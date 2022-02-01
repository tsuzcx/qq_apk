package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.vfs.o;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static Boolean onC;
  private static Boolean onD;
  private static HashSet<Long> onw;
  private static HashSet<String> onx;
  public BizTimeLineUI ofS;
  private boolean onA;
  public boolean onB;
  private int ont;
  private int onu;
  public int onv;
  public List<w> ony;
  private List<w> onz;
  
  static
  {
    AppMethodBeat.i(6181);
    onw = new HashSet();
    onx = new HashSet();
    onC = null;
    onD = null;
    AppMethodBeat.o(6181);
  }
  
  public c(BizTimeLineUI paramBizTimeLineUI, int paramInt1, int paramInt2, List<w> paramList)
  {
    AppMethodBeat.i(6160);
    this.onv = 0;
    this.ony = new LinkedList();
    this.onA = false;
    this.onB = false;
    this.ofS = paramBizTimeLineUI;
    this.ont = paramInt1;
    this.onu = paramInt2;
    this.onz = paramList;
    if (this.onz.size() <= 10) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(6154);
          c.this.ZC();
          AppMethodBeat.o(6154);
          return false;
        }
      });
    }
    AppMethodBeat.o(6160);
  }
  
  public static String Gd(String paramString)
  {
    AppMethodBeat.i(224136);
    paramString = com.tencent.mm.api.b.t(paramString, 1);
    AppMethodBeat.o(224136);
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
    ae.v("MicroMsg.BizTimeLineImgLoader", "doPreLoadNext pos %d", new Object[] { Integer.valueOf(paramInt) });
    ImageView localImageView = new ImageView(this.ofS);
    this.onv += 1;
    if ((paramInt == 0) && (paramBoolean)) {
      a(paramLong, paramInt, paramv, paramString, localImageView, getContentWidth(), this.ont, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6156);
          c.e(c.this);
          c.this.p(paramLong, this.jgx);
          AppMethodBeat.o(6156);
        }
        
        public final void onStart() {}
      }, false, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(6165);
      return true;
      a(paramLong, paramInt, paramv, paramString, localImageView, this.onu, this.onu, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6157);
          c.e(c.this);
          c.this.p(paramLong, this.jgx);
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
    if (onx.contains(paramLong + "_" + paramInt))
    {
      AppMethodBeat.o(6169);
      return true;
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6169);
      return false;
    }
    if (!o.fB(r.aMY(com.tencent.mm.api.b.t(paramString, 1))))
    {
      AppMethodBeat.o(6169);
      return false;
    }
    onx.add(paramLong + "_" + paramInt);
    AppMethodBeat.o(6169);
    return true;
  }
  
  private w bPW()
  {
    AppMethodBeat.i(6167);
    int i = 0;
    try
    {
      while (i < this.onz.size() + this.ony.size())
      {
        w localw = zz(i);
        if ((localw != null) && (localw.fta()) && (localw.field_isRead != 1) && (!onw.contains(Long.valueOf(localw.field_msgId))))
        {
          ae.v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo pos=%d,msg id=%d", new Object[] { Integer.valueOf(i), Long.valueOf(localw.field_msgId) });
          AppMethodBeat.o(6167);
          return localw;
        }
        i += 1;
        tC(localw.field_msgId);
      }
      return null;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(6167);
    }
  }
  
  private static boolean bPY()
  {
    AppMethodBeat.i(6175);
    if (onC == null) {
      bQa();
    }
    boolean bool = onC.booleanValue();
    AppMethodBeat.o(6175);
    return bool;
  }
  
  public static boolean bPZ()
  {
    AppMethodBeat.i(6176);
    if (onD == null) {
      bQa();
    }
    boolean bool = onD.booleanValue();
    AppMethodBeat.o(6176);
    return bool;
  }
  
  private static void bQa()
  {
    AppMethodBeat.i(6177);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDI().xi("100461");
    if ((localc.isValid()) && ("1".equals(localc.fsy().get("isOpenBizMsgPreDownloadCover"))))
    {
      bool = true;
      onC = Boolean.valueOf(bool);
      if ((!localc.isValid()) || (!"1".equals(localc.fsy().get("isOnlyPreloadInWifi")))) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      onD = Boolean.valueOf(bool);
      ae.i("MicroMsg.BizTimeLineImgLoader", "BizTimeLineImg initABTest %b/%b", new Object[] { onC, onD });
      AppMethodBeat.o(6177);
      return;
      bool = false;
      break;
    }
  }
  
  private static void tC(long paramLong)
  {
    AppMethodBeat.i(6166);
    onw.add(Long.valueOf(paramLong));
    AppMethodBeat.o(6166);
  }
  
  private w zz(int paramInt)
  {
    AppMethodBeat.i(6173);
    try
    {
      w localw;
      if (paramInt < this.onz.size())
      {
        localw = (w)this.onz.get(paramInt);
        AppMethodBeat.o(6173);
        return localw;
      }
      if (paramInt < this.onz.size() + this.ony.size())
      {
        localw = (w)this.ony.get(paramInt - this.onz.size());
        AppMethodBeat.o(6173);
        return localw;
      }
    }
    catch (Throwable localThrowable)
    {
      ae.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(6173);
    }
    return null;
  }
  
  public final void ZC()
  {
    AppMethodBeat.i(6171);
    if (!bPY())
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
        w localw = c.this.bPX();
        if (localw == null)
        {
          AppMethodBeat.o(6159);
          return;
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(6158);
            c.f(c.this).clear();
            c.f(c.this).addAll(this.gww);
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
    AppMethodBeat.i(208511);
    paramImageView.setContentDescription(this.ofS.getString(2131757186));
    paramString = com.tencent.mm.api.b.t(paramString, 1);
    Object localObject = g.FnF;
    if (g.Zv(1))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.Fdw;
      com.tencent.mm.pluginsdk.model.a.l(paramLong, paramInt1, paramv.url);
    }
    localObject = com.tencent.mm.pluginsdk.model.b.FdV;
    localObject = new c.a();
    ((c.a)localObject).igy = 2131100141;
    ((c.a)localObject).igk = true;
    localObject = ((c.a)localObject).dh(paramInt2, paramInt3);
    ((c.a)localObject).igA = "2131231255";
    ((c.a)localObject).ifZ = new n(1);
    ((c.a)localObject).igH = new e(1);
    ((c.a)localObject).igI = new l();
    ((c.a)localObject).hgD = r.aMY(paramString);
    com.tencent.mm.pluginsdk.model.b.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean, ((c.a)localObject).aJu(), new m(1, paramInt2, paramInt3, true, true, paramFloat, parama));
    AppMethodBeat.o(208511);
  }
  
  public final void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, int paramInt3, boolean paramBoolean1, m.a parama, boolean paramBoolean2, int paramInt4)
  {
    AppMethodBeat.i(6161);
    paramImageView.setContentDescription(this.ofS.getString(2131757186));
    paramString = com.tencent.mm.api.b.t(paramString, 1);
    Object localObject = g.FnF;
    if (g.Zv(1))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.Fdw;
      com.tencent.mm.pluginsdk.model.a.l(paramLong, paramInt1, paramv.url);
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
      float f = com.tencent.mm.cb.a.fromDPToPix(this.ofS, 8);
      localObject = com.tencent.mm.pluginsdk.model.b.FdV;
      localObject = new c.a();
      ((c.a)localObject).igy = j;
      ((c.a)localObject).igk = true;
      localObject = ((c.a)localObject).dh(paramInt2, paramInt3);
      ((c.a)localObject).igA = String.valueOf(i);
      ((c.a)localObject).ifZ = new n(1);
      ((c.a)localObject).igH = new e(1);
      ((c.a)localObject).igI = new l();
      ((c.a)localObject).hgD = r.aMY(paramString);
      com.tencent.mm.pluginsdk.model.b.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean1, ((c.a)localObject).aJu(), new m(1, paramInt2, paramInt3, false, paramBoolean2, f, parama));
      AppMethodBeat.o(6161);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(208512);
    paramImageView.setContentDescription(this.ofS.getString(2131757186));
    Object localObject = com.tencent.mm.pluginsdk.model.b.FdV;
    localObject = new c.a();
    ((c.a)localObject).igi = true;
    ((c.a)localObject).igv = 2131100141;
    localObject = ((c.a)localObject).dh(paramInt1, paramInt2);
    ((c.a)localObject).ign = 4;
    com.tencent.mm.pluginsdk.model.b.a(-1L, -1, null, paramString, paramImageView, paramInt3, false, ((c.a)localObject).aJu(), new m());
    AppMethodBeat.o(208512);
  }
  
  public final void bPV()
  {
    AppMethodBeat.i(6164);
    if (!bPY())
    {
      AppMethodBeat.o(6164);
      return;
    }
    if ((this.onA) || (this.onB))
    {
      ae.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext loading %b, onPause %b", new Object[] { Boolean.valueOf(this.onA), Boolean.valueOf(this.onB) });
      AppMethodBeat.o(6164);
      return;
    }
    this.onA = true;
    ae.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext");
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
        if ((c.bPZ()) && (!az.isWifi(c.b(c.this))))
        {
          AppMethodBeat.o(6155);
          return;
        }
        if (!c.c(c.this))
        {
          ae.v("MicroMsg.BizTimeLineImgLoader", "not all visibleItem loaded");
          AppMethodBeat.o(6155);
          return;
        }
        w localw = c.d(c.this);
        if (localw == null)
        {
          ae.v("MicroMsg.BizTimeLineImgLoader", "not loading");
          AppMethodBeat.o(6155);
          return;
        }
        c.a(c.this, localw);
        AppMethodBeat.o(6155);
      }
    }, 500L);
    AppMethodBeat.o(6164);
  }
  
  public final w bPX()
  {
    AppMethodBeat.i(6172);
    try
    {
      if (this.onz.size() > 0)
      {
        w localw = (w)this.onz.get(this.onz.size() - 1);
        AppMethodBeat.o(6172);
        return localw;
      }
    }
    catch (Throwable localThrowable)
    {
      ae.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(6172);
    }
    return null;
  }
  
  public final int getContentWidth()
  {
    AppMethodBeat.i(6163);
    int i = com.tencent.mm.cb.a.iu(this.ofS);
    int j = com.tencent.mm.plugin.brandservice.ui.timeline.b.oge;
    AppMethodBeat.o(6163);
    return i - j;
  }
  
  public final void p(long paramLong, int paramInt)
  {
    AppMethodBeat.i(6168);
    ae.v("MicroMsg.BizTimeLineImgLoader", "onLoadFinish mLoadingCount %d", new Object[] { Integer.valueOf(this.onv) });
    onx.add(paramLong + "_" + paramInt);
    if (this.onv <= 0) {
      bPV();
    }
    AppMethodBeat.o(6168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c
 * JD-Core Version:    0.7.0.1
 */