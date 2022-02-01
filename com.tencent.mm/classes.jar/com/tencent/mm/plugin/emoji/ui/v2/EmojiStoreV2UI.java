package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.p;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v3.EmojiStoreV3HomeUI;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.util.HashMap;

@k
public class EmojiStoreV2UI
  extends MMActivity
{
  private int xYG;
  private HashMap<Integer, EmojiStoreV2BaseFragment> xYR;
  EmojiStoreV2TabView xYS;
  private EmojiStoreV2ViewPager xYT;
  private a xYU;
  private boolean xYV;
  private boolean xYW;
  private int xYX;
  
  public EmojiStoreV2UI()
  {
    AppMethodBeat.i(109400);
    this.xYR = new HashMap();
    this.xYG = 0;
    this.xYV = true;
    this.xYW = false;
    this.xYX = -1;
    AppMethodBeat.o(109400);
  }
  
  public final EmojiStoreV2BaseFragment Kw(int paramInt)
  {
    EmojiStoreV2BaseFragment localEmojiStoreV2BaseFragment = null;
    AppMethodBeat.i(109405);
    if (paramInt < 0)
    {
      AppMethodBeat.o(109405);
      return null;
    }
    if (this.xYR.containsKey(Integer.valueOf(paramInt)))
    {
      localEmojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment)this.xYR.get(Integer.valueOf(paramInt));
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
      this.xYR.put(Integer.valueOf(paramInt), localEmojiStoreV2BaseFragment);
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
    return h.f.emoji_store_v2_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109403);
    addIconOptionMenu(0, h.h.app_search, h.g.actionbar_icon_dark_search, new EmojiStoreV2UI.1(this));
    addIconOptionMenu(1, h.h.app_manage, h.g.actionbar_setting_icon, new EmojiStoreV2UI.2(this));
    this.xYS = ((EmojiStoreV2TabView)findViewById(h.e.emoji_store_v2_tab));
    this.xYT = ((EmojiStoreV2ViewPager)findViewById(h.e.emoji_store_v2_pager));
    this.xYT.setOffscreenPageLimit(0);
    this.xYU = new a(this, this.xYT, this.xYV);
    if (!this.xYV)
    {
      this.xYS.setVisibility(8);
      AppMethodBeat.o(109403);
      return;
    }
    this.xYS.setVisibility(0);
    this.xYS.xYO.alive();
    AppMethodBeat.o(109403);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109406);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d("MicroMsg.emoji.EmojiStoreV2UI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    if ((this.xYU != null) && (this.xYU.Kx(this.xYG) != null)) {
      this.xYU.Kx(this.xYG).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(109406);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109401);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2UI", "exit in teen mode");
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(this);
      finish();
      AppMethodBeat.o(109401);
      return;
    }
    this.xYX = getIntent().getIntExtra("download_entrance_scene", -1);
    paramBundle = com.tencent.mm.k.i.aRC().getValue("ShowPersonalEmotion");
    Log.i("MicroMsg.emoji.EmojiStoreV2UI", "get dynamic config value:%s", new Object[] { paramBundle });
    if ((!Util.isNullOrNil(paramBundle)) && (Util.safeParseInt(paramBundle) == 1)) {}
    for (this.xYV = true;; this.xYV = false)
    {
      if (this.xYV) {
        this.xYG = getIntent().getIntExtra("emoji_tab", 0);
      }
      if ((!EmojiLogic.bBX()) && (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRM, 0) == 1))
      {
        paramBundle = new Intent(this, EmojiStoreV3HomeUI.class);
        paramBundle.putExtra("emoji_tab", this.xYG);
        paramBundle.putExtra("download_entrance_scene", this.xYX);
        startActivity(EmojiStoreV3HomeUI.class);
        com.tencent.threadpool.h.ahAA.bk(new EmojiStoreV2UI..ExternalSyntheticLambda0(this));
      }
      initView();
      com.tencent.mm.kernel.h.baH().postToWorker(new EmojiStoreV2UI.b((byte)0));
      boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIc, Boolean.FALSE)).booleanValue();
      if (this.xYS != null) {
        this.xYS.ok(bool);
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(406L, 0L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(406L, 2L, System.currentTimeMillis() - l, false);
      AppMethodBeat.o(109401);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109404);
    super.onDestroy();
    if (this.xYR != null) {
      this.xYR.clear();
    }
    if (this.xYS != null) {
      this.xYS.xYO.dead();
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
        com.tencent.mm.xwebutil.c.jQE();
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
    extends p
    implements ViewPager.OnPageChangeListener, EmojiStoreV2TabView.a
  {
    private boolean xYV;
    private WxViewPager xYZ;
    
    public a(FragmentActivity paramFragmentActivity, WxViewPager paramWxViewPager, boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(270785);
      this.xYV = false;
      this.xYV = paramBoolean;
      this.xYZ = paramWxViewPager;
      this.xYZ.setAdapter(this);
      this.xYZ.setOnPageChangeListener(this);
      this.xYZ.setCurrentItem(EmojiStoreV2UI.b(EmojiStoreV2UI.this));
      com.tencent.mm.compatible.util.d.rc(11);
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).setOnTabClickListener(this);
      }
      AppMethodBeat.o(270785);
    }
    
    public final EmojiStoreV2BaseFragment Kx(int paramInt)
    {
      AppMethodBeat.i(109393);
      EmojiStoreV2BaseFragment localEmojiStoreV2BaseFragment = EmojiStoreV2UI.this.Kw(paramInt);
      AppMethodBeat.o(109393);
      return localEmojiStoreV2BaseFragment;
    }
    
    public final int getCount()
    {
      if (this.xYV) {
        return 2;
      }
      return 1;
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(109396);
      Log.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageScrollStateChanged state:%d", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 0) && (EmojiStoreV2UI.this.Kw(EmojiStoreV2UI.b(EmojiStoreV2UI.this)) != null)) {
        EmojiStoreV2UI.this.Kw(EmojiStoreV2UI.b(EmojiStoreV2UI.this)).dCm();
      }
      AppMethodBeat.o(109396);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(109394);
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).t(paramInt1, paramFloat);
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
        com.tencent.mm.plugin.report.service.h.OAn.b(12090, new Object[0]);
        EmojiStoreV2UI localEmojiStoreV2UI = EmojiStoreV2UI.this;
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acIc, Boolean.FALSE);
        if (localEmojiStoreV2UI.xYS != null) {
          localEmojiStoreV2UI.xYS.ok(false);
        }
        EmojiStoreV2UI.e(EmojiStoreV2UI.this);
      }
      AppMethodBeat.o(109395);
    }
    
    public final void onTabClick(int paramInt)
    {
      AppMethodBeat.i(109397);
      if (paramInt != EmojiStoreV2UI.b(EmojiStoreV2UI.this)) {
        this.xYZ.setCurrentItem(paramInt, false);
      }
      EmojiStoreV2UI.a(EmojiStoreV2UI.this, paramInt);
      AppMethodBeat.o(109397);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI
 * JD-Core Version:    0.7.0.1
 */