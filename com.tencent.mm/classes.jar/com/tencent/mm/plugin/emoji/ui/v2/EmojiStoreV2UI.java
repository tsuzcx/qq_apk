package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.j;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.util.HashMap;

@i
public class EmojiStoreV2UI
  extends MMActivity
{
  private int rmJ;
  private HashMap<Integer, EmojiStoreV2BaseFragment> rmU;
  EmojiStoreV2TabView rmV;
  private EmojiStoreV2ViewPager rmW;
  private a rmX;
  private boolean rmY;
  private boolean rmZ;
  private int rna;
  
  public EmojiStoreV2UI()
  {
    AppMethodBeat.i(109400);
    this.rmU = new HashMap();
    this.rmJ = 0;
    this.rmY = true;
    this.rmZ = false;
    this.rna = -1;
    AppMethodBeat.o(109400);
  }
  
  public final EmojiStoreV2BaseFragment Ge(int paramInt)
  {
    EmojiStoreV2BaseFragment localEmojiStoreV2BaseFragment = null;
    AppMethodBeat.i(109405);
    if (paramInt < 0)
    {
      AppMethodBeat.o(109405);
      return null;
    }
    if (this.rmU.containsKey(Integer.valueOf(paramInt)))
    {
      localEmojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment)this.rmU.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(109405);
      return localEmojiStoreV2BaseFragment;
    }
    switch (paramInt)
    {
    default: 
      Log.w("MicroMsg.emoji.EmojiStoreV2UI", "create fragment failed.");
    }
    for (;;)
    {
      Log.d("MicroMsg.emoji.EmojiStoreV2UI", "create fragment index:%d", new Object[] { Integer.valueOf(paramInt) });
      if (localEmojiStoreV2BaseFragment != null) {
        localEmojiStoreV2BaseFragment.setParent(this);
      }
      this.rmU.put(Integer.valueOf(paramInt), localEmojiStoreV2BaseFragment);
      AppMethodBeat.o(109405);
      return localEmojiStoreV2BaseFragment;
      localEmojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment)Fragment.instantiate(this, EmojiStoreV2MainFragment.class.getName(), null);
      continue;
      localEmojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment)Fragment.instantiate(this, EmojiStoreV2PersonFragment.class.getName(), null);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493984;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109403);
    addIconOptionMenu(0, 2131755972, 2131689496, new EmojiStoreV2UI.1(this));
    addIconOptionMenu(1, 2131755890, 2131689513, new EmojiStoreV2UI.2(this));
    this.rmV = ((EmojiStoreV2TabView)findViewById(2131300063));
    this.rmW = ((EmojiStoreV2ViewPager)findViewById(2131300062));
    this.rmW.setOffscreenPageLimit(0);
    this.rmX = new a(this, this.rmW, this.rmY);
    if (!this.rmY)
    {
      this.rmV.setVisibility(8);
      AppMethodBeat.o(109403);
      return;
    }
    this.rmV.setVisibility(0);
    EmojiStoreV2TabView localEmojiStoreV2TabView = this.rmV;
    EventCenter.instance.addListener(localEmojiStoreV2TabView.rmR);
    AppMethodBeat.o(109403);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109406);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d("MicroMsg.emoji.EmojiStoreV2UI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    if ((this.rmX != null) && (this.rmX.Gf(this.rmJ) != null)) {
      this.rmX.Gf(this.rmJ).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(109406);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109401);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    this.rna = getIntent().getIntExtra("download_entrance_scene", -1);
    paramBundle = com.tencent.mm.n.h.aqJ().getValue("ShowPersonalEmotion");
    Log.i("MicroMsg.emoji.EmojiStoreV2UI", "get dynamic config value:%s", new Object[] { paramBundle });
    if ((!Util.isNullOrNil(paramBundle)) && (Util.safeParseInt(paramBundle) == 1)) {}
    for (this.rmY = true;; this.rmY = false)
    {
      if (this.rmY) {
        this.rmJ = getIntent().getIntExtra("emoji_tab", 0);
      }
      initView();
      g.aAk().postToWorker(new EmojiStoreV2UI.b((byte)0));
      boolean bool = ((Boolean)g.aAh().azQ().get(ar.a.NSO, Boolean.FALSE)).booleanValue();
      if (this.rmV != null) {
        this.rmV.lC(bool);
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(406L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(406L, 2L, System.currentTimeMillis() - l, false);
      AppMethodBeat.o(109401);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109404);
    super.onDestroy();
    if (this.rmU != null) {
      this.rmU.clear();
    }
    if (this.rmV != null)
    {
      EmojiStoreV2TabView localEmojiStoreV2TabView = this.rmV;
      EventCenter.instance.removeListener(localEmojiStoreV2TabView.rmR);
    }
    AppMethodBeat.o(109404);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109402);
    super.onResume();
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(109391);
        Log.i("MicroMsg.emoji.EmojiStoreV2UI", "now try to activity the tools process");
        com.tencent.mm.cr.d.hiy();
        AppMethodBeat.o(109391);
        return false;
      }
    });
    AppMethodBeat.o(109402);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends j
    implements ViewPager.OnPageChangeListener, EmojiStoreV2TabView.a
  {
    private boolean rmY;
    private WxViewPager rnc;
    
    public a(FragmentActivity paramFragmentActivity, WxViewPager paramWxViewPager, boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(109392);
      this.rmY = false;
      this.rmY = paramBoolean;
      this.rnc = paramWxViewPager;
      this.rnc.setAdapter(this);
      this.rnc.setOnPageChangeListener(this);
      this.rnc.setCurrentItem(EmojiStoreV2UI.b(EmojiStoreV2UI.this));
      com.tencent.mm.compatible.util.d.oE(11);
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).setOnTabClickListener(this);
      }
      AppMethodBeat.o(109392);
    }
    
    public final EmojiStoreV2BaseFragment Gf(int paramInt)
    {
      AppMethodBeat.i(109393);
      EmojiStoreV2BaseFragment localEmojiStoreV2BaseFragment = EmojiStoreV2UI.this.Ge(paramInt);
      AppMethodBeat.o(109393);
      return localEmojiStoreV2BaseFragment;
    }
    
    public final int getCount()
    {
      if (this.rmY) {
        return 2;
      }
      return 1;
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(109396);
      Log.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageScrollStateChanged state:%d", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 0) && (EmojiStoreV2UI.this.Ge(EmojiStoreV2UI.b(EmojiStoreV2UI.this)) != null)) {
        EmojiStoreV2UI.this.Ge(EmojiStoreV2UI.b(EmojiStoreV2UI.this)).cIa();
      }
      AppMethodBeat.o(109396);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(109394);
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).p(paramInt1, paramFloat);
      }
      AppMethodBeat.o(109394);
    }
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(109395);
      Log.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageSelected :%d", new Object[] { Integer.valueOf(paramInt) });
      EmojiStoreV2UI.a(EmojiStoreV2UI.this, paramInt);
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).setTo(paramInt);
      }
      if ((EmojiStoreV2UI.b(EmojiStoreV2UI.this) == 1) && (!EmojiStoreV2UI.d(EmojiStoreV2UI.this)))
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(12090, new Object[0]);
        EmojiStoreV2UI localEmojiStoreV2UI = EmojiStoreV2UI.this;
        g.aAh().azQ().set(ar.a.NSO, Boolean.FALSE);
        if (localEmojiStoreV2UI.rmV != null) {
          localEmojiStoreV2UI.rmV.lC(false);
        }
        EmojiStoreV2UI.e(EmojiStoreV2UI.this);
      }
      AppMethodBeat.o(109395);
    }
    
    public final void onTabClick(int paramInt)
    {
      AppMethodBeat.i(109397);
      if (paramInt != EmojiStoreV2UI.b(EmojiStoreV2UI.this)) {
        this.rnc.setCurrentItem(paramInt, false);
      }
      EmojiStoreV2UI.a(EmojiStoreV2UI.this, paramInt);
      AppMethodBeat.o(109397);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI
 * JD-Core Version:    0.7.0.1
 */