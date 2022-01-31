package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.j;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.x.c;
import java.util.HashMap;

@i
public class EmojiStoreV2UI
  extends MMActivity
{
  private int lrL;
  private HashMap<Integer, EmojiStoreV2BaseFragment> lrW;
  EmojiStoreV2TabView lrX;
  private EmojiStoreV2ViewPager lrY;
  private a lrZ;
  private boolean lsa;
  private boolean lsb;
  private int lsc;
  
  public EmojiStoreV2UI()
  {
    AppMethodBeat.i(53828);
    this.lrW = new HashMap();
    this.lrL = 0;
    this.lsa = true;
    this.lsb = false;
    this.lsc = -1;
    AppMethodBeat.o(53828);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969418;
  }
  
  public void initView()
  {
    AppMethodBeat.i(53831);
    addIconOptionMenu(0, 2131230741, new EmojiStoreV2UI.1(this));
    addIconOptionMenu(1, 2131230758, new EmojiStoreV2UI.2(this));
    this.lrX = ((EmojiStoreV2TabView)findViewById(2131823711));
    this.lrY = ((EmojiStoreV2ViewPager)findViewById(2131823712));
    this.lrY.setOffscreenPageLimit(0);
    this.lrZ = new a(this, this.lrY, this.lsa);
    if (!this.lsa)
    {
      this.lrX.setVisibility(8);
      AppMethodBeat.o(53831);
      return;
    }
    this.lrX.setVisibility(0);
    EmojiStoreV2TabView localEmojiStoreV2TabView = this.lrX;
    com.tencent.mm.sdk.b.a.ymk.c(localEmojiStoreV2TabView.lrT);
    AppMethodBeat.o(53831);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(53834);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.d("MicroMsg.emoji.EmojiStoreV2UI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    if ((this.lrZ != null) && (this.lrZ.uz(this.lrL) != null)) {
      this.lrZ.uz(this.lrL).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(53834);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53829);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    this.lsc = getIntent().getIntExtra("download_entrance_scene", -1);
    paramBundle = com.tencent.mm.m.g.Nq().getValue("ShowPersonalEmotion");
    ab.i("MicroMsg.emoji.EmojiStoreV2UI", "get dynamic config value:%s", new Object[] { paramBundle });
    if ((!bo.isNullOrNil(paramBundle)) && (bo.apV(paramBundle) == 1)) {}
    for (this.lsa = true;; this.lsa = false)
    {
      if (this.lsa) {
        this.lrL = getIntent().getIntExtra("emoji_tab", 0);
      }
      initView();
      com.tencent.mm.kernel.g.RO().ac(new b((byte)0));
      boolean bool = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yxT, Boolean.FALSE)).booleanValue();
      if (this.lrX != null) {
        this.lrX.gQ(bool);
      }
      h.qsU.idkeyStat(406L, 0L, 1L, false);
      h.qsU.idkeyStat(406L, 2L, System.currentTimeMillis() - l, false);
      AppMethodBeat.o(53829);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53832);
    super.onDestroy();
    if (this.lrW != null) {
      this.lrW.clear();
    }
    if (this.lrX != null)
    {
      EmojiStoreV2TabView localEmojiStoreV2TabView = this.lrX;
      com.tencent.mm.sdk.b.a.ymk.d(localEmojiStoreV2TabView.lrT);
    }
    AppMethodBeat.o(53832);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(53830);
    super.onResume();
    Looper.myQueue().addIdleHandler(new EmojiStoreV2UI.4(this));
    AppMethodBeat.o(53830);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final EmojiStoreV2BaseFragment uy(int paramInt)
  {
    EmojiStoreV2BaseFragment localEmojiStoreV2BaseFragment = null;
    AppMethodBeat.i(53833);
    if (paramInt < 0)
    {
      AppMethodBeat.o(53833);
      return null;
    }
    if (this.lrW.containsKey(Integer.valueOf(paramInt)))
    {
      localEmojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment)this.lrW.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(53833);
      return localEmojiStoreV2BaseFragment;
    }
    switch (paramInt)
    {
    default: 
      ab.w("MicroMsg.emoji.EmojiStoreV2UI", "create fragment failed.");
    }
    for (;;)
    {
      ab.d("MicroMsg.emoji.EmojiStoreV2UI", "create fragment index:%d", new Object[] { Integer.valueOf(paramInt) });
      if (localEmojiStoreV2BaseFragment != null) {
        localEmojiStoreV2BaseFragment.setParent(this);
      }
      this.lrW.put(Integer.valueOf(paramInt), localEmojiStoreV2BaseFragment);
      AppMethodBeat.o(53833);
      return localEmojiStoreV2BaseFragment;
      localEmojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment)Fragment.instantiate(this, EmojiStoreV2MainFragment.class.getName(), null);
      continue;
      localEmojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment)Fragment.instantiate(this, EmojiStoreV2PersonFragment.class.getName(), null);
    }
  }
  
  final class a
    extends j
    implements ViewPager.OnPageChangeListener, EmojiStoreV2TabView.a
  {
    private boolean lsa;
    private WxViewPager lse;
    
    public a(FragmentActivity paramFragmentActivity, WxViewPager paramWxViewPager, boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(53820);
      this.lsa = false;
      this.lsa = paramBoolean;
      this.lse = paramWxViewPager;
      this.lse.setAdapter(this);
      this.lse.setOnPageChangeListener(this);
      this.lse.setCurrentItem(EmojiStoreV2UI.b(EmojiStoreV2UI.this));
      d.fw(11);
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).setOnTabClickListener(this);
      }
      AppMethodBeat.o(53820);
    }
    
    public final int getCount()
    {
      if (this.lsa) {
        return 2;
      }
      return 1;
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(53824);
      ab.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageScrollStateChanged state:%d", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 0) && (EmojiStoreV2UI.this.uy(EmojiStoreV2UI.b(EmojiStoreV2UI.this)) != null))
      {
        EmojiStoreV2BaseFragment localEmojiStoreV2BaseFragment = EmojiStoreV2UI.this.uy(EmojiStoreV2UI.b(EmojiStoreV2UI.this));
        if ((localEmojiStoreV2BaseFragment.mListView != null) && (localEmojiStoreV2BaseFragment.lhv != null) && (localEmojiStoreV2BaseFragment.bnh())) {
          localEmojiStoreV2BaseFragment.lhv.refreshView();
        }
      }
      AppMethodBeat.o(53824);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(53822);
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).k(paramInt1, paramFloat);
      }
      AppMethodBeat.o(53822);
    }
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(53823);
      ab.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageSelected :%d", new Object[] { Integer.valueOf(paramInt) });
      EmojiStoreV2UI.a(EmojiStoreV2UI.this, paramInt);
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).setTo(paramInt);
      }
      if ((EmojiStoreV2UI.b(EmojiStoreV2UI.this) == 1) && (!EmojiStoreV2UI.d(EmojiStoreV2UI.this)))
      {
        h.qsU.e(12090, new Object[0]);
        EmojiStoreV2UI localEmojiStoreV2UI = EmojiStoreV2UI.this;
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yxT, Boolean.FALSE);
        if (localEmojiStoreV2UI.lrX != null) {
          localEmojiStoreV2UI.lrX.gQ(false);
        }
        EmojiStoreV2UI.e(EmojiStoreV2UI.this);
      }
      AppMethodBeat.o(53823);
    }
    
    public final void onTabClick(int paramInt)
    {
      AppMethodBeat.i(53825);
      if (paramInt != EmojiStoreV2UI.b(EmojiStoreV2UI.this)) {
        this.lse.setCurrentItem(paramInt, false);
      }
      EmojiStoreV2UI.a(EmojiStoreV2UI.this, paramInt);
      AppMethodBeat.o(53825);
    }
    
    public final EmojiStoreV2BaseFragment uz(int paramInt)
    {
      AppMethodBeat.i(53821);
      EmojiStoreV2BaseFragment localEmojiStoreV2BaseFragment = EmojiStoreV2UI.this.uy(paramInt);
      AppMethodBeat.o(53821);
      return localEmojiStoreV2BaseFragment;
    }
  }
  
  static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(53827);
      c.PJ().x(262147, false);
      c.PJ().x(262149, false);
      c.PJ().ce(262147, 266244);
      c.PJ().ce(262149, 266244);
      com.tencent.mm.kernel.g.RL().Ru().set(208899, Boolean.FALSE);
      com.tencent.mm.kernel.g.RL().Ru().set(208913, Boolean.FALSE);
      AppMethodBeat.o(53827);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI
 * JD-Core Version:    0.7.0.1
 */