package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.n;
import android.support.v4.view.ViewPager.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.j;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.util.HashMap;

@j
public class EmojiStoreV2UI
  extends MMActivity
{
  private int jiU = 0;
  private HashMap<Integer, a> jjf = new HashMap();
  EmojiStoreV2TabView jjg;
  private EmojiStoreV2ViewPager jjh;
  private a jji;
  private boolean jjj = true;
  private boolean jjk = false;
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return f.f.emoji_store_v2_ui;
  }
  
  protected final void initView()
  {
    addIconOptionMenu(0, f.g.actionbar_icon_dark_search, new EmojiStoreV2UI.1(this));
    addIconOptionMenu(1, f.g.actionbar_setting_icon, new EmojiStoreV2UI.2(this));
    this.jjg = ((EmojiStoreV2TabView)findViewById(f.e.emoji_store_v2_tab));
    this.jjh = ((EmojiStoreV2ViewPager)findViewById(f.e.emoji_store_v2_pager));
    this.jjh.setOffscreenPageLimit(0);
    this.jji = new a(this, this.jjh, this.jjj);
    if (!this.jjj)
    {
      this.jjg.setVisibility(8);
      return;
    }
    this.jjg.setVisibility(0);
    EmojiStoreV2TabView localEmojiStoreV2TabView = this.jjg;
    com.tencent.mm.sdk.b.a.udP.c(localEmojiStoreV2TabView.jjc);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.d("MicroMsg.emoji.EmojiStoreV2UI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    if ((this.jji != null) && (this.jji.qe(this.jiU) != null)) {
      this.jji.qe(this.jiU).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.m.g.AA().getValue("ShowPersonalEmotion");
    y.i("MicroMsg.emoji.EmojiStoreV2UI", "get dynamic config value:%s", new Object[] { paramBundle });
    if ((!bk.bl(paramBundle)) && (bk.ZR(paramBundle) == 1)) {}
    for (this.jjj = true;; this.jjj = false)
    {
      if (this.jjj) {
        this.jiU = getIntent().getIntExtra("emoji_tab", 0);
      }
      initView();
      com.tencent.mm.kernel.g.DS().O(new EmojiStoreV2UI.3(this));
      boolean bool = ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uoc, Boolean.valueOf(false))).booleanValue();
      if (this.jjg != null) {
        this.jjg.fo(bool);
      }
      h.nFQ.a(406L, 0L, 1L, false);
      h.nFQ.a(406L, 2L, System.currentTimeMillis() - l, false);
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jjf != null) {
      this.jjf.clear();
    }
    if (this.jjg != null)
    {
      EmojiStoreV2TabView localEmojiStoreV2TabView = this.jjg;
      com.tencent.mm.sdk.b.a.udP.d(localEmojiStoreV2TabView.jjc);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    Looper.myQueue().addIdleHandler(new EmojiStoreV2UI.5(this));
  }
  
  public final a qd(int paramInt)
  {
    Object localObject = null;
    if (paramInt < 0) {
      return null;
    }
    if (this.jjf.containsKey(Integer.valueOf(paramInt))) {
      return (a)this.jjf.get(Integer.valueOf(paramInt));
    }
    switch (paramInt)
    {
    default: 
      y.w("MicroMsg.emoji.EmojiStoreV2UI", "create fragment failed.");
    }
    for (;;)
    {
      y.d("MicroMsg.emoji.EmojiStoreV2UI", "create fragment index:%d", new Object[] { Integer.valueOf(paramInt) });
      if (localObject != null) {
        ((a)localObject).setParent(this);
      }
      this.jjf.put(Integer.valueOf(paramInt), localObject);
      return localObject;
      localObject = (a)Fragment.instantiate(this, b.class.getName(), null);
      continue;
      localObject = (a)Fragment.instantiate(this, c.class.getName(), null);
    }
  }
  
  final class a
    extends n
    implements ViewPager.e, EmojiStoreV2TabView.a
  {
    private boolean jjj = false;
    private WxViewPager jjm;
    
    public a(FragmentActivity paramFragmentActivity, WxViewPager paramWxViewPager, boolean paramBoolean)
    {
      super();
      this.jjj = paramBoolean;
      this.jjm = paramWxViewPager;
      this.jjm.setAdapter(this);
      this.jjm.setOnPageChangeListener(this);
      this.jjm.setCurrentItem(EmojiStoreV2UI.b(EmojiStoreV2UI.this));
      d.gG(11);
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).setOnTabClickListener(this);
      }
    }
    
    public final void Q(int paramInt)
    {
      y.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageScrollStateChanged state:%d", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 0) && (EmojiStoreV2UI.this.qd(EmojiStoreV2UI.b(EmojiStoreV2UI.this)) != null))
      {
        a locala = EmojiStoreV2UI.this.qd(EmojiStoreV2UI.b(EmojiStoreV2UI.this));
        if ((locala.Nn != null) && (locala.iYq != null) && (locala.aJy())) {
          locala.iYq.aqU();
        }
      }
    }
    
    public final void R(int paramInt)
    {
      y.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageSelected :%d", new Object[] { Integer.valueOf(paramInt) });
      EmojiStoreV2UI.a(EmojiStoreV2UI.this, paramInt);
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).setTo(paramInt);
      }
      if ((EmojiStoreV2UI.b(EmojiStoreV2UI.this) == 1) && (!EmojiStoreV2UI.d(EmojiStoreV2UI.this)))
      {
        h.nFQ.f(12090, new Object[0]);
        EmojiStoreV2UI localEmojiStoreV2UI = EmojiStoreV2UI.this;
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uoc, Boolean.valueOf(false));
        if (localEmojiStoreV2UI.jjg != null) {
          localEmojiStoreV2UI.jjg.fo(false);
        }
        EmojiStoreV2UI.e(EmojiStoreV2UI.this);
      }
    }
    
    public final void a(int paramInt1, float paramFloat, int paramInt2)
    {
      if (EmojiStoreV2UI.c(EmojiStoreV2UI.this) != null) {
        EmojiStoreV2UI.c(EmojiStoreV2UI.this).i(paramInt1, paramFloat);
      }
    }
    
    public final int getCount()
    {
      if (this.jjj) {
        return 2;
      }
      return 1;
    }
    
    public final void qc(int paramInt)
    {
      if (paramInt != EmojiStoreV2UI.b(EmojiStoreV2UI.this)) {
        this.jjm.m(paramInt, false);
      }
      EmojiStoreV2UI.a(EmojiStoreV2UI.this, paramInt);
    }
    
    public final a qe(int paramInt)
    {
      return EmojiStoreV2UI.this.qd(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI
 * JD-Core Version:    0.7.0.1
 */