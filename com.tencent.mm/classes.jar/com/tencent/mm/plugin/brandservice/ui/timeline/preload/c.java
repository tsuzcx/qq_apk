package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Looper;
import android.os.MessageQueue;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static HashSet<Long> jZJ;
  private static HashSet<String> jZK;
  private static Boolean jZP;
  private static Boolean jZQ;
  public BizTimeLineUI jVs;
  private int jZG;
  private int jZH;
  public int jZI;
  public List<com.tencent.mm.storage.q> jZL;
  private List<com.tencent.mm.storage.q> jZM;
  private boolean jZN;
  public boolean jZO;
  
  static
  {
    AppMethodBeat.i(14388);
    jZJ = new HashSet();
    jZK = new HashSet();
    jZP = null;
    jZQ = null;
    AppMethodBeat.o(14388);
  }
  
  public c(BizTimeLineUI paramBizTimeLineUI, int paramInt1, int paramInt2, List<com.tencent.mm.storage.q> paramList)
  {
    AppMethodBeat.i(14368);
    this.jZI = 0;
    this.jZL = new LinkedList();
    this.jZN = false;
    this.jZO = false;
    this.jVs = paramBizTimeLineUI;
    this.jZG = paramInt1;
    this.jZH = paramInt2;
    this.jZM = paramList;
    if (this.jZM.size() <= 10) {
      Looper.myQueue().addIdleHandler(new c.1(this));
    }
    AppMethodBeat.o(14368);
  }
  
  public static boolean a(com.tencent.mm.storage.q paramq, com.tencent.mm.af.q paramq1)
  {
    AppMethodBeat.i(152655);
    if ((paramq == null) || (paramq1 == null))
    {
      AppMethodBeat.o(152655);
      return false;
    }
    if ((paramq1.type == 5) || (paramq1.type == 10) || (com.tencent.mm.plugin.brandservice.ui.b.a.a(paramq, paramq1)))
    {
      AppMethodBeat.o(152655);
      return true;
    }
    AppMethodBeat.o(152655);
    return false;
  }
  
  private boolean a(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(152653);
    if (b(paramString, paramLong, paramInt))
    {
      AppMethodBeat.o(152653);
      return false;
    }
    ab.v("MicroMsg.BizTimeLineImgLoader", "doPreLoadNext pos %d", new Object[] { Integer.valueOf(paramInt) });
    ImageView localImageView = new ImageView(this.jVs);
    this.jZI += 1;
    if ((paramInt == 0) && (paramBoolean)) {
      a(paramString, localImageView, getContentWidth(), this.jZG, new c.3(this, paramLong, paramInt), false);
    }
    for (;;)
    {
      AppMethodBeat.o(152653);
      return true;
      a(paramString, localImageView, this.jZH, this.jZH, new c.4(this, paramLong, paramInt));
    }
  }
  
  private com.tencent.mm.storage.q aXh()
  {
    AppMethodBeat.i(14375);
    int i = 0;
    try
    {
      while (i < this.jZM.size() + this.jZL.size())
      {
        com.tencent.mm.storage.q localq = se(i);
        if ((localq != null) && (localq.dvV()) && (localq.field_isRead != 1) && (!jZJ.contains(Long.valueOf(localq.field_msgId))))
        {
          ab.v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo pos=%d,msg id=%d", new Object[] { Integer.valueOf(i), Long.valueOf(localq.field_msgId) });
          AppMethodBeat.o(14375);
          return localq;
        }
        i += 1;
        hX(localq.field_msgId);
      }
      return null;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(14375);
    }
  }
  
  private static boolean aXj()
  {
    AppMethodBeat.i(14382);
    if (jZP == null) {
      aXl();
    }
    boolean bool = jZP.booleanValue();
    AppMethodBeat.o(14382);
    return bool;
  }
  
  public static boolean aXk()
  {
    AppMethodBeat.i(14383);
    if (jZQ == null) {
      aXl();
    }
    boolean bool = jZQ.booleanValue();
    AppMethodBeat.o(14383);
    return bool;
  }
  
  private static void aXl()
  {
    AppMethodBeat.i(14384);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100461");
    if ((localc.isValid()) && ("1".equals(localc.dvN().get("isOpenBizMsgPreDownloadCover"))))
    {
      bool = true;
      jZP = Boolean.valueOf(bool);
      if ((!localc.isValid()) || (!"1".equals(localc.dvN().get("isOnlyPreloadInWifi")))) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      jZQ = Boolean.valueOf(bool);
      ab.i("MicroMsg.BizTimeLineImgLoader", "BizTimeLineImg initABTest %b/%b", new Object[] { jZP, jZQ });
      AppMethodBeat.o(14384);
      return;
      bool = false;
      break;
    }
  }
  
  private static boolean b(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(152654);
    if (jZK.contains(paramLong + "_" + paramInt))
    {
      AppMethodBeat.o(152654);
      return true;
    }
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(152654);
      return false;
    }
    if (!com.tencent.mm.vfs.e.cN(p.aln(com.tencent.mm.at.q.ts(paramString))))
    {
      AppMethodBeat.o(152654);
      return false;
    }
    jZK.add(paramLong + "_" + paramInt);
    AppMethodBeat.o(152654);
    return true;
  }
  
  private static void hX(long paramLong)
  {
    AppMethodBeat.i(14374);
    jZJ.add(Long.valueOf(paramLong));
    AppMethodBeat.o(14374);
  }
  
  private com.tencent.mm.storage.q se(int paramInt)
  {
    AppMethodBeat.i(14380);
    try
    {
      com.tencent.mm.storage.q localq;
      if (paramInt < this.jZM.size())
      {
        localq = (com.tencent.mm.storage.q)this.jZM.get(paramInt);
        AppMethodBeat.o(14380);
        return localq;
      }
      if (paramInt < this.jZM.size() + this.jZL.size())
      {
        localq = (com.tencent.mm.storage.q)this.jZL.get(paramInt - this.jZM.size());
        AppMethodBeat.o(14380);
        return localq;
      }
    }
    catch (Throwable localThrowable)
    {
      ab.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(14380);
    }
    return null;
  }
  
  public final void Kt()
  {
    AppMethodBeat.i(14378);
    if (!aXj())
    {
      AppMethodBeat.o(14378);
      return;
    }
    b.a("BizTimeLineImgLoaderThread", new c.5(this), 0L);
    AppMethodBeat.o(14378);
  }
  
  public final void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, e.a parama)
  {
    AppMethodBeat.i(152652);
    paramImageView.setContentDescription(this.jVs.getString(2131298197));
    paramString = com.tencent.mm.at.q.ts(paramString);
    com.tencent.mm.at.a.a locala = o.ahG();
    c.a locala1 = new c.a();
    locala1.eOa = 2131689878;
    locala1.eNM = true;
    locala1 = locala1.cx(paramInt1, paramInt2);
    locala1.eOc = "2130841441";
    locala1.fHk = new f();
    locala1.eNO = p.aln(paramString);
    locala.a(paramString, paramImageView, locala1.ahY(), null, new com.tencent.mm.pluginsdk.ui.applet.e(paramInt1, paramInt2, true, true, 2.0F, parama));
    AppMethodBeat.o(152652);
  }
  
  public final void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(152651);
    paramImageView.setContentDescription(this.jVs.getString(2131298197));
    paramString = com.tencent.mm.at.q.ts(paramString);
    int i;
    if (paramBoolean)
    {
      i = 2130837954;
      if (!paramBoolean) {
        break label168;
      }
    }
    label168:
    for (int j = 2130837951;; j = 2130837956)
    {
      float f = com.tencent.mm.cb.a.fromDPToPix(this.jVs, 8);
      com.tencent.mm.at.a.a locala = o.ahG();
      c.a locala1 = new c.a();
      locala1.eOa = j;
      locala1.eNM = true;
      locala1 = locala1.cx(paramInt1, paramInt2);
      locala1.eOc = String.valueOf(i);
      locala1.fHk = new f();
      locala1.eNO = p.aln(paramString);
      locala.a(paramString, paramImageView, locala1.ahY(), null, new com.tencent.mm.pluginsdk.ui.applet.e(paramInt1, paramInt2, false, paramBoolean, f, parama));
      AppMethodBeat.o(152651);
      return;
      i = 0;
      break;
    }
  }
  
  public final void aXg()
  {
    AppMethodBeat.i(14372);
    if (!aXj())
    {
      AppMethodBeat.o(14372);
      return;
    }
    if ((this.jZN) || (this.jZO))
    {
      ab.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext loading %b, onPause %b", new Object[] { Boolean.valueOf(this.jZN), Boolean.valueOf(this.jZO) });
      AppMethodBeat.o(14372);
      return;
    }
    this.jZN = true;
    ab.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext");
    b.a("BizTimeLineImgLoaderThread", new c.2(this), 500L);
    AppMethodBeat.o(14372);
  }
  
  public final com.tencent.mm.storage.q aXi()
  {
    AppMethodBeat.i(14379);
    try
    {
      if (this.jZM.size() > 0)
      {
        com.tencent.mm.storage.q localq = (com.tencent.mm.storage.q)this.jZM.get(this.jZM.size() - 1);
        AppMethodBeat.o(14379);
        return localq;
      }
    }
    catch (Throwable localThrowable)
    {
      ab.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(14379);
    }
    return null;
  }
  
  public final int getContentWidth()
  {
    AppMethodBeat.i(14371);
    int i = com.tencent.mm.cb.a.gw(this.jVs);
    int j = com.tencent.mm.plugin.brandservice.ui.timeline.a.jVE;
    AppMethodBeat.o(14371);
    return i - j;
  }
  
  public final void m(long paramLong, int paramInt)
  {
    AppMethodBeat.i(14376);
    ab.v("MicroMsg.BizTimeLineImgLoader", "onLoadFinish mLoadingCount %d", new Object[] { Integer.valueOf(this.jZI) });
    jZK.add(paramLong + "_" + paramInt);
    if (this.jZI <= 0) {
      aXg();
    }
    AppMethodBeat.o(14376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c
 * JD-Core Version:    0.7.0.1
 */