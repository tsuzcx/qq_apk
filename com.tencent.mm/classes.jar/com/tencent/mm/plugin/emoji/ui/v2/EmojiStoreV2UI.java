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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.y.c;
import java.util.HashMap;

@i
public class EmojiStoreV2UI
  extends MMActivity
{
  private int plF;
  private HashMap<Integer, EmojiStoreV2BaseFragment> plQ;
  EmojiStoreV2TabView plR;
  private EmojiStoreV2ViewPager plS;
  private a plT;
  private boolean plU;
  private boolean plV;
  private int plW;
  
  public EmojiStoreV2UI()
  {
    AppMethodBeat.i(109400);
    this.plQ = new HashMap();
    this.plF = 0;
    this.plU = true;
    this.plV = false;
    this.plW = -1;
    AppMethodBeat.o(109400);
  }
  
  public final EmojiStoreV2BaseFragment Bz(int paramInt)
  {
    EmojiStoreV2BaseFragment localEmojiStoreV2BaseFragment = null;
    AppMethodBeat.i(109405);
    if (paramInt < 0)
    {
      AppMethodBeat.o(109405);
      return null;
    }
    if (this.plQ.containsKey(Integer.valueOf(paramInt)))
    {
      localEmojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment)this.plQ.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(109405);
      return localEmojiStoreV2BaseFragment;
    }
    switch (paramInt)
    {
    default: 
      ac.w("MicroMsg.emoji.EmojiStoreV2UI", "create fragment failed.");
    }
    for (;;)
    {
      ac.d("MicroMsg.emoji.EmojiStoreV2UI", "create fragment index:%d", new Object[] { Integer.valueOf(paramInt) });
      if (localEmojiStoreV2BaseFragment != null) {
        localEmojiStoreV2BaseFragment.setParent(this);
      }
      this.plQ.put(Integer.valueOf(paramInt), localEmojiStoreV2BaseFragment);
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
    return 2131493830;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109403);
    addIconOptionMenu(0, 2131689494, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109388);
        EmojiStoreV2UI.a(EmojiStoreV2UI.this);
        AppMethodBeat.o(109388);
        return false;
      }
    });
    addIconOptionMenu(1, 2131689511, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109389);
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("10931", 1);
        ((Intent)localObject).setClass(EmojiStoreV2UI.this, EmojiMineUI.class);
        paramAnonymousMenuItem = EmojiStoreV2UI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2UI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2UI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109389);
        return false;
      }
    });
    this.plR = ((EmojiStoreV2TabView)findViewById(2131299449));
    this.plS = ((EmojiStoreV2ViewPager)findViewById(2131299448));
    this.plS.setOffscreenPageLimit(0);
    this.plT = new a(this, this.plS, this.plU);
    if (!this.plU)
    {
      this.plR.setVisibility(8);
      AppMethodBeat.o(109403);
      return;
    }
    this.plR.setVisibility(0);
    EmojiStoreV2TabView localEmojiStoreV2TabView = this.plR;
    com.tencent.mm.sdk.b.a.GpY.c(localEmojiStoreV2TabView.plN);
    AppMethodBeat.o(109403);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109406);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.d("MicroMsg.emoji.EmojiStoreV2UI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    if ((this.plT != null) && (this.plT.BA(this.plF) != null)) {
      this.plT.BA(this.plF).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(109406);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109401);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    this.plW = getIntent().getIntExtra("download_entrance_scene", -1);
    paramBundle = com.tencent.mm.m.g.ZY().getValue("ShowPersonalEmotion");
    ac.i("MicroMsg.emoji.EmojiStoreV2UI", "get dynamic config value:%s", new Object[] { paramBundle });
    if ((!bs.isNullOrNil(paramBundle)) && (bs.aLy(paramBundle) == 1)) {}
    for (this.plU = true;; this.plU = false)
    {
      if (this.plU) {
        this.plF = getIntent().getIntExtra("emoji_tab", 0);
      }
      initView();
      com.tencent.mm.kernel.g.agU().az(new b((byte)0));
      boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GEb, Boolean.FALSE)).booleanValue();
      if (this.plR != null) {
        this.plR.kq(bool);
      }
      h.wUl.idkeyStat(406L, 0L, 1L, false);
      h.wUl.idkeyStat(406L, 2L, System.currentTimeMillis() - l, false);
      AppMethodBeat.o(109401);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109404);
    super.onDestroy();
    if (this.plQ != null) {
      this.plQ.clear();
    }
    if (this.plR != null)
    {
      EmojiStoreV2TabView localEmojiStoreV2TabView = this.plR;
      com.tencent.mm.sdk.b.a.GpY.d(localEmojiStoreV2TabView.plN);
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
        ac.i("MicroMsg.emoji.EmojiStoreV2UI", "now try to activity the tools process");
        com.tencent.mm.cq.d.fBf();
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
    private boolean plU;
    private WxViewPager plY;
    
    public a(FragmentActivity paramFragmentActivity, WxViewPager paramWxViewPager, boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(109392);
      this.plU = false;
      this.plU = paramBoolean;
      this.plY = paramWxViewPager;
      this.plY.setAdapter(this);
      this.plY.setOnPageChangeListener(this);
      this.plY.setCurrentItem(EmojiStoreV2UI.b(EmojiStoreV2UI.this));
      com.tencent.mm.compatible.util.d.la(11);
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).setOnTabClickListener(this);
      }
      AppMethodBeat.o(109392);
    }
    
    public final EmojiStoreV2BaseFragment BA(int paramInt)
    {
      AppMethodBeat.i(109393);
      EmojiStoreV2BaseFragment localEmojiStoreV2BaseFragment = EmojiStoreV2UI.this.Bz(paramInt);
      AppMethodBeat.o(109393);
      return localEmojiStoreV2BaseFragment;
    }
    
    public final int getCount()
    {
      if (this.plU) {
        return 2;
      }
      return 1;
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(109396);
      ac.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageScrollStateChanged state:%d", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 0) && (EmojiStoreV2UI.this.Bz(EmojiStoreV2UI.b(EmojiStoreV2UI.this)) != null)) {
        EmojiStoreV2UI.this.Bz(EmojiStoreV2UI.b(EmojiStoreV2UI.this)).ceg();
      }
      AppMethodBeat.o(109396);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(109394);
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).n(paramInt1, paramFloat);
      }
      AppMethodBeat.o(109394);
    }
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(109395);
      ac.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageSelected :%d", new Object[] { Integer.valueOf(paramInt) });
      EmojiStoreV2UI.a(EmojiStoreV2UI.this, paramInt);
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).setTo(paramInt);
      }
      if ((EmojiStoreV2UI.b(EmojiStoreV2UI.this) == 1) && (!EmojiStoreV2UI.d(EmojiStoreV2UI.this)))
      {
        h.wUl.f(12090, new Object[0]);
        EmojiStoreV2UI localEmojiStoreV2UI = EmojiStoreV2UI.this;
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEb, Boolean.FALSE);
        if (localEmojiStoreV2UI.plR != null) {
          localEmojiStoreV2UI.plR.kq(false);
        }
        EmojiStoreV2UI.e(EmojiStoreV2UI.this);
      }
      AppMethodBeat.o(109395);
    }
    
    public final void onTabClick(int paramInt)
    {
      AppMethodBeat.i(109397);
      if (paramInt != EmojiStoreV2UI.b(EmojiStoreV2UI.this)) {
        this.plY.setCurrentItem(paramInt, false);
      }
      EmojiStoreV2UI.a(EmojiStoreV2UI.this, paramInt);
      AppMethodBeat.o(109397);
    }
  }
  
  static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(109399);
      c.aeH().w(262147, false);
      c.aeH().w(262149, false);
      c.aeH().cI(262147, 266244);
      c.aeH().cI(262149, 266244);
      com.tencent.mm.kernel.g.agR().agA().set(208899, Boolean.FALSE);
      com.tencent.mm.kernel.g.agR().agA().set(208913, Boolean.FALSE);
      AppMethodBeat.o(109399);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI
 * JD-Core Version:    0.7.0.1
 */