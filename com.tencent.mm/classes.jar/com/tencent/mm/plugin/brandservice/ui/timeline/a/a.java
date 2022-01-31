package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.os.Looper;
import android.os.MessageQueue;
import android.widget.ImageView;
import com.tencent.mm.ae.m;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.brandservice.b.a;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
{
  private static HashSet<Long> ihS = new HashSet();
  private static Boolean ihV = null;
  private static Boolean ihW = null;
  public BizTimeLineUI ieF;
  private int ihP;
  private int ihQ;
  private int ihR = 0;
  public List<com.tencent.mm.storage.q> ihT = new LinkedList();
  private List<com.tencent.mm.storage.q> ihU;
  
  public a(BizTimeLineUI paramBizTimeLineUI, int paramInt1, int paramInt2, List<com.tencent.mm.storage.q> paramList)
  {
    this.ieF = paramBizTimeLineUI;
    this.ihP = paramInt1;
    this.ihQ = paramInt2;
    this.ihU = paramList;
    if (this.ihU.size() <= 10) {
      Looper.myQueue().addIdleHandler(new a.1(this));
    }
  }
  
  public static boolean a(com.tencent.mm.storage.q paramq, m paramm)
  {
    if ((paramq == null) || (paramm == null)) {}
    while ((paramm.type != 5) && (paramm.type != 10) && (!com.tencent.mm.plugin.brandservice.ui.b.a.e(paramq))) {
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    if (r(paramString1, paramInt1, paramString2)) {
      return false;
    }
    y.v("MicroMsg.BizTimeLineImgLoader", "doPreLoadNext pos %d", new Object[] { Integer.valueOf(paramInt2) });
    ImageView localImageView = new ImageView(this.ieF);
    this.ihR += 1;
    if ((paramInt2 == 0) && (paramBoolean)) {
      a(paramString1, localImageView, paramInt1, this.ihP, new a.3(this), false);
    }
    for (;;)
    {
      return true;
      a(paramString1, localImageView, paramInt1, this.ihQ, this.ihQ, paramString2, new a.4(this));
    }
  }
  
  private void ayh()
  {
    if (!ayk()) {
      return;
    }
    y.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext");
    g.DS().k(new Runnable()
    {
      public final void run()
      {
        if ((a.a(a.this) == null) || (a.a(a.this).isFinishing())) {}
        while ((a.ayl()) && (!aq.isWifi(a.a(a.this)))) {
          return;
        }
        if (!a.b(a.this))
        {
          y.v("MicroMsg.BizTimeLineImgLoader", "not all visibleItem loaded");
          return;
        }
        com.tencent.mm.storage.q localq = a.c(a.this);
        if (localq == null)
        {
          y.v("MicroMsg.BizTimeLineImgLoader", "not loading");
          return;
        }
        a.a(a.this, localq);
      }
    }, 50L);
  }
  
  private com.tencent.mm.storage.q ayi()
  {
    int i = 0;
    try
    {
      while (i < this.ihU.size() + this.ihT.size())
      {
        com.tencent.mm.storage.q localq = oy(i);
        if ((localq != null) && (localq.ctz()) && (!ihS.contains(Long.valueOf(localq.field_msgId))))
        {
          y.v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo pos=%d,msg id=%d", new Object[] { Integer.valueOf(i), Long.valueOf(localq.field_msgId) });
          return localq;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo %s", new Object[] { localException.getMessage() });
    }
  }
  
  private static boolean ayk()
  {
    if (ihV == null) {
      aym();
    }
    return ihV.booleanValue();
  }
  
  public static boolean ayl()
  {
    if (ihW == null) {
      aym();
    }
    return ihW.booleanValue();
  }
  
  private static void aym()
  {
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100461");
    if ((localc.isValid()) && ("1".equals(localc.ctr().get("isOpenBizMsgPreDownloadCover"))))
    {
      bool = true;
      ihV = Boolean.valueOf(bool);
      if ((!localc.isValid()) || (!"1".equals(localc.ctr().get("isOnlyPreloadInWifi")))) {
        break label114;
      }
    }
    label114:
    for (boolean bool = true;; bool = false)
    {
      ihW = Boolean.valueOf(bool);
      y.i("MicroMsg.BizTimeLineImgLoader", "BizTimeLineImg initABTest %b/%b", new Object[] { ihV, ihW });
      return;
      bool = false;
      break;
    }
  }
  
  private com.tencent.mm.storage.q oy(int paramInt)
  {
    try
    {
      if (paramInt < this.ihU.size()) {
        return (com.tencent.mm.storage.q)this.ihU.get(paramInt);
      }
      if (paramInt < this.ihU.size() + this.ihT.size())
      {
        com.tencent.mm.storage.q localq = (com.tencent.mm.storage.q)this.ihT.get(paramInt - this.ihU.size());
        return localq;
      }
    }
    catch (Throwable localThrowable)
    {
      y.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
    }
    return null;
  }
  
  private static boolean r(String paramString1, int paramInt, String paramString2)
  {
    String str = paramString1;
    if (com.tencent.mm.as.q.OQ()) {
      str = com.tencent.mm.as.q.mo(paramString1);
    }
    return FileOp.bK(com.tencent.mm.pluginsdk.model.q.y(str, paramInt, paramString2));
  }
  
  public final void a(String paramString1, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, String paramString2, e.a parama)
  {
    paramImageView.setContentDescription(this.ieF.getString(b.h.chatting_img_item_desc));
    if (com.tencent.mm.as.q.OQ()) {
      paramString1 = com.tencent.mm.as.q.mo(paramString1);
    }
    for (;;)
    {
      com.tencent.mm.as.a.a locala = o.ON();
      c.a locala1 = new c.a();
      locala1.ery = b.a.chatting_item_biz_default_bg;
      locala1.erf = true;
      locala1 = locala1.bn(paramInt2, paramInt3);
      locala1.eqU = new f();
      locala1.erh = com.tencent.mm.pluginsdk.model.q.y(paramString1, paramInt1, paramString2);
      locala.a(paramString1, paramImageView, locala1.OV(), null, new e(0, 0, 0, parama));
      return;
    }
  }
  
  public final void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, e.a parama, boolean paramBoolean)
  {
    paramImageView.setContentDescription(this.ieF.getString(b.h.chatting_img_item_desc));
    if (com.tencent.mm.as.q.OQ()) {
      paramString = com.tencent.mm.as.q.mo(paramString);
    }
    for (;;)
    {
      int i;
      if (paramBoolean)
      {
        i = b.c.biz_time_line_bottom_round_mask_bg;
        if (!paramBoolean) {
          break label158;
        }
      }
      label158:
      for (int j = b.c.biz_time_line_cover_bottom_round_default_bg;; j = b.c.biz_time_line_cover_default_bg)
      {
        int k = getContentWidth();
        com.tencent.mm.as.a.a locala = o.ON();
        c.a locala1 = new c.a();
        locala1.ery = j;
        locala1.erf = true;
        locala1 = locala1.bn(k, paramInt2);
        locala1.erA = String.valueOf(i);
        locala1.eqU = new f();
        locala1.erh = com.tencent.mm.pluginsdk.model.q.y(paramString, paramInt1, "@T");
        locala.a(paramString, paramImageView, locala1.OV(), null, new e(i, k, paramInt2, parama));
        return;
        i = 0;
        break;
      }
    }
  }
  
  public final void aog()
  {
    y.v("MicroMsg.BizTimeLineImgLoader", "onLoadFinish mLoadingCount %d", new Object[] { Integer.valueOf(this.ihR) });
    if (this.ihR <= 0) {
      ayh();
    }
  }
  
  public final com.tencent.mm.storage.q ayj()
  {
    try
    {
      if (this.ihU.size() > 0)
      {
        com.tencent.mm.storage.q localq = (com.tencent.mm.storage.q)this.ihU.get(this.ihU.size() - 1);
        return localq;
      }
    }
    catch (Throwable localThrowable)
    {
      y.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
    }
    return null;
  }
  
  public final int getContentWidth()
  {
    return com.tencent.mm.cb.a.fj(this.ieF) - (int)(com.tencent.mm.cb.a.getDensity(this.ieF) * 16.0F);
  }
  
  public final void yb()
  {
    if (!ayk()) {
      return;
    }
    g.DS().O(new a.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a
 * JD-Core Version:    0.7.0.1
 */