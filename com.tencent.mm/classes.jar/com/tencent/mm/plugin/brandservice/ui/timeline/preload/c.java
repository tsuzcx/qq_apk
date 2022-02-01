package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.v;
import com.tencent.mm.am.ag;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.vfs.i;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static Boolean ohC;
  private static Boolean ohD;
  private static HashSet<Long> ohw;
  private static HashSet<String> ohx;
  public BizTimeLineUI oac;
  private boolean ohA;
  public boolean ohB;
  private int oht;
  private int ohu;
  public int ohv;
  public List<w> ohy;
  private List<w> ohz;
  
  static
  {
    AppMethodBeat.i(6181);
    ohw = new HashSet();
    ohx = new HashSet();
    ohC = null;
    ohD = null;
    AppMethodBeat.o(6181);
  }
  
  public c(BizTimeLineUI paramBizTimeLineUI, int paramInt1, int paramInt2, List<w> paramList)
  {
    AppMethodBeat.i(6160);
    this.ohv = 0;
    this.ohy = new LinkedList();
    this.ohA = false;
    this.ohB = false;
    this.oac = paramBizTimeLineUI;
    this.oht = paramInt1;
    this.ohu = paramInt2;
    this.ohz = paramList;
    if (this.ohz.size() <= 10) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(6154);
          c.this.Zt();
          AppMethodBeat.o(6154);
          return false;
        }
      });
    }
    AppMethodBeat.o(6160);
  }
  
  public static String FB(String paramString)
  {
    AppMethodBeat.i(221699);
    paramString = com.tencent.mm.api.b.s(paramString, 1);
    AppMethodBeat.o(221699);
    return paramString;
  }
  
  private boolean a(v paramv, String paramString, final long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6165);
    if (a(paramString, paramLong, paramInt))
    {
      AppMethodBeat.o(6165);
      return false;
    }
    ad.v("MicroMsg.BizTimeLineImgLoader", "doPreLoadNext pos %d", new Object[] { Integer.valueOf(paramInt) });
    ImageView localImageView = new ImageView(this.oac);
    this.ohv += 1;
    if ((paramInt == 0) && (paramBoolean)) {
      a(paramLong, paramInt, paramv, paramString, localImageView, getContentWidth(), this.oht, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6156);
          c.e(c.this);
          c.this.p(paramLong, this.jdE);
          AppMethodBeat.o(6156);
        }
        
        public final void onStart() {}
      }, false, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(6165);
      return true;
      a(paramLong, paramInt, paramv, paramString, localImageView, this.ohu, this.ohu, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6157);
          c.e(c.this);
          c.this.p(paramLong, this.jdE);
          AppMethodBeat.o(6157);
        }
        
        public final void onStart() {}
      }, -1, 2.0F);
    }
  }
  
  public static boolean a(w paramw, v paramv)
  {
    AppMethodBeat.i(6174);
    if ((paramw == null) || (paramv == null))
    {
      AppMethodBeat.o(6174);
      return false;
    }
    boolean bool = com.tencent.mm.plugin.brandservice.ui.b.a.a(paramw, paramv);
    AppMethodBeat.o(6174);
    return bool;
  }
  
  private static boolean a(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(6169);
    if (ohx.contains(paramLong + "_" + paramInt))
    {
      AppMethodBeat.o(6169);
      return true;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6169);
      return false;
    }
    if (!i.fv(r.aLC(com.tencent.mm.api.b.s(paramString, 1))))
    {
      AppMethodBeat.o(6169);
      return false;
    }
    ohx.add(paramLong + "_" + paramInt);
    AppMethodBeat.o(6169);
    return true;
  }
  
  private w bOY()
  {
    AppMethodBeat.i(6167);
    int i = 0;
    try
    {
      while (i < this.ohz.size() + this.ohy.size())
      {
        w localw = zq(i);
        if ((localw != null) && (localw.fpd()) && (localw.field_isRead != 1) && (!ohw.contains(Long.valueOf(localw.field_msgId))))
        {
          ad.v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo pos=%d,msg id=%d", new Object[] { Integer.valueOf(i), Long.valueOf(localw.field_msgId) });
          AppMethodBeat.o(6167);
          return localw;
        }
        i += 1;
        to(localw.field_msgId);
      }
      return null;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(6167);
    }
  }
  
  private static boolean bPa()
  {
    AppMethodBeat.i(6175);
    if (ohC == null) {
      bPc();
    }
    boolean bool = ohC.booleanValue();
    AppMethodBeat.o(6175);
    return bool;
  }
  
  public static boolean bPb()
  {
    AppMethodBeat.i(6176);
    if (ohD == null) {
      bPc();
    }
    boolean bool = ohD.booleanValue();
    AppMethodBeat.o(6176);
    return bool;
  }
  
  private static void bPc()
  {
    AppMethodBeat.i(6177);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDs().wz("100461");
    if ((localc.isValid()) && ("1".equals(localc.foF().get("isOpenBizMsgPreDownloadCover"))))
    {
      bool = true;
      ohC = Boolean.valueOf(bool);
      if ((!localc.isValid()) || (!"1".equals(localc.foF().get("isOnlyPreloadInWifi")))) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      ohD = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizTimeLineImgLoader", "BizTimeLineImg initABTest %b/%b", new Object[] { ohC, ohD });
      AppMethodBeat.o(6177);
      return;
      bool = false;
      break;
    }
  }
  
  private static void to(long paramLong)
  {
    AppMethodBeat.i(6166);
    ohw.add(Long.valueOf(paramLong));
    AppMethodBeat.o(6166);
  }
  
  private w zq(int paramInt)
  {
    AppMethodBeat.i(6173);
    try
    {
      w localw;
      if (paramInt < this.ohz.size())
      {
        localw = (w)this.ohz.get(paramInt);
        AppMethodBeat.o(6173);
        return localw;
      }
      if (paramInt < this.ohz.size() + this.ohy.size())
      {
        localw = (w)this.ohy.get(paramInt - this.ohz.size());
        AppMethodBeat.o(6173);
        return localw;
      }
    }
    catch (Throwable localThrowable)
    {
      ad.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(6173);
    }
    return null;
  }
  
  public final void Zt()
  {
    AppMethodBeat.i(6171);
    if (!bPa())
    {
      AppMethodBeat.o(6171);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BizTimeLineImgLoaderThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6159);
        if ((c.b(c.this) == null) || (c.b(c.this).isFinishing()))
        {
          AppMethodBeat.o(6159);
          return;
        }
        w localw = c.this.bOZ();
        if (localw == null)
        {
          AppMethodBeat.o(6159);
          return;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(6158);
            c.f(c.this).clear();
            c.f(c.this).addAll(this.gtP);
            AppMethodBeat.o(6158);
          }
        });
        AppMethodBeat.o(6159);
      }
    }, 0L);
    AppMethodBeat.o(6171);
  }
  
  public final void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, int paramInt3, boolean paramBoolean, m.a parama, int paramInt4, float paramFloat)
  {
    AppMethodBeat.i(209555);
    paramImageView.setContentDescription(this.oac.getString(2131757186));
    paramString = com.tencent.mm.api.b.s(paramString, 1);
    Object localObject = g.EVk;
    if (g.YP(1))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.EKY;
      com.tencent.mm.pluginsdk.model.a.m(paramLong, paramInt1, paramv.url);
    }
    localObject = com.tencent.mm.pluginsdk.model.b.ELx;
    localObject = new c.a();
    ((c.a)localObject).idG = 2131100141;
    ((c.a)localObject).idr = true;
    localObject = ((c.a)localObject).dh(paramInt2, paramInt3);
    ((c.a)localObject).idI = "2131231255";
    ((c.a)localObject).idg = new n(1);
    ((c.a)localObject).idP = new e(1);
    ((c.a)localObject).idQ = new l();
    ((c.a)localObject).hdP = r.aLC(paramString);
    com.tencent.mm.pluginsdk.model.b.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean, ((c.a)localObject).aJc(), new m(1, paramInt2, paramInt3, true, true, paramFloat, parama));
    AppMethodBeat.o(209555);
  }
  
  public final void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, int paramInt3, boolean paramBoolean1, m.a parama, boolean paramBoolean2, int paramInt4)
  {
    AppMethodBeat.i(6161);
    paramImageView.setContentDescription(this.oac.getString(2131757186));
    paramString = com.tencent.mm.api.b.s(paramString, 1);
    Object localObject = g.EVk;
    if (g.YP(1))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.EKY;
      com.tencent.mm.pluginsdk.model.a.m(paramLong, paramInt1, paramv.url);
    }
    int i;
    if (paramBoolean2)
    {
      i = 2131231250;
      if (!paramBoolean2) {
        break label236;
      }
    }
    label236:
    for (int j = 2131231247;; j = 2131231252)
    {
      float f = com.tencent.mm.cc.a.fromDPToPix(this.oac, 8);
      localObject = com.tencent.mm.pluginsdk.model.b.ELx;
      localObject = new c.a();
      ((c.a)localObject).idG = j;
      ((c.a)localObject).idr = true;
      localObject = ((c.a)localObject).dh(paramInt2, paramInt3);
      ((c.a)localObject).idI = String.valueOf(i);
      ((c.a)localObject).idg = new n(1);
      ((c.a)localObject).idP = new e(1);
      ((c.a)localObject).idQ = new l();
      ((c.a)localObject).hdP = r.aLC(paramString);
      com.tencent.mm.pluginsdk.model.b.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean1, ((c.a)localObject).aJc(), new m(1, paramInt2, paramInt3, false, paramBoolean2, f, parama));
      AppMethodBeat.o(6161);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(209556);
    paramImageView.setContentDescription(this.oac.getString(2131757186));
    Object localObject = com.tencent.mm.pluginsdk.model.b.ELx;
    localObject = new c.a();
    ((c.a)localObject).idp = true;
    ((c.a)localObject).idD = 2131100141;
    localObject = ((c.a)localObject).dh(paramInt1, paramInt2);
    ((c.a)localObject).idu = 4;
    com.tencent.mm.pluginsdk.model.b.a(-1L, -1, null, paramString, paramImageView, paramInt3, false, ((c.a)localObject).aJc(), new m());
    AppMethodBeat.o(209556);
  }
  
  public final void bOX()
  {
    AppMethodBeat.i(6164);
    if (!bPa())
    {
      AppMethodBeat.o(6164);
      return;
    }
    if ((this.ohA) || (this.ohB))
    {
      ad.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext loading %b, onPause %b", new Object[] { Boolean.valueOf(this.ohA), Boolean.valueOf(this.ohB) });
      AppMethodBeat.o(6164);
      return;
    }
    this.ohA = true;
    ad.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext");
    com.tencent.mm.plugin.brandservice.b.a("BizTimeLineImgLoaderThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6155);
        c.a(c.this);
        if ((c.b(c.this) == null) || (c.b(c.this).isFinishing()))
        {
          AppMethodBeat.o(6155);
          return;
        }
        if ((c.bPb()) && (!ay.isWifi(c.b(c.this))))
        {
          AppMethodBeat.o(6155);
          return;
        }
        if (!c.c(c.this))
        {
          ad.v("MicroMsg.BizTimeLineImgLoader", "not all visibleItem loaded");
          AppMethodBeat.o(6155);
          return;
        }
        w localw = c.d(c.this);
        if (localw == null)
        {
          ad.v("MicroMsg.BizTimeLineImgLoader", "not loading");
          AppMethodBeat.o(6155);
          return;
        }
        c.a(c.this, localw);
        AppMethodBeat.o(6155);
      }
    }, 500L);
    AppMethodBeat.o(6164);
  }
  
  public final w bOZ()
  {
    AppMethodBeat.i(6172);
    try
    {
      if (this.ohz.size() > 0)
      {
        w localw = (w)this.ohz.get(this.ohz.size() - 1);
        AppMethodBeat.o(6172);
        return localw;
      }
    }
    catch (Throwable localThrowable)
    {
      ad.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(6172);
    }
    return null;
  }
  
  public final int getContentWidth()
  {
    AppMethodBeat.i(6163);
    int i = com.tencent.mm.cc.a.ip(this.oac);
    int j = com.tencent.mm.plugin.brandservice.ui.timeline.b.oao;
    AppMethodBeat.o(6163);
    return i - j;
  }
  
  public final void p(long paramLong, int paramInt)
  {
    AppMethodBeat.i(6168);
    ad.v("MicroMsg.BizTimeLineImgLoader", "onLoadFinish mLoadingCount %d", new Object[] { Integer.valueOf(this.ohv) });
    ohx.add(paramLong + "_" + paramInt);
    if (this.ohv <= 0) {
      bOX();
    }
    AppMethodBeat.o(6168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c
 * JD-Core Version:    0.7.0.1
 */