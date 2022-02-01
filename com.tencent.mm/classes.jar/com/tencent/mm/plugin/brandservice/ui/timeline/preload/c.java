package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.v;
import com.tencent.mm.al.af;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.vfs.i;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static HashSet<Long> nET;
  private static HashSet<String> nEU;
  private static Boolean nEZ;
  private static Boolean nFa;
  private int nEQ;
  private int nER;
  public int nES;
  public List<t> nEV;
  private List<t> nEW;
  private boolean nEX;
  public boolean nEY;
  public BizTimeLineUI nyX;
  
  static
  {
    AppMethodBeat.i(6181);
    nET = new HashSet();
    nEU = new HashSet();
    nEZ = null;
    nFa = null;
    AppMethodBeat.o(6181);
  }
  
  public c(BizTimeLineUI paramBizTimeLineUI, int paramInt1, int paramInt2, List<t> paramList)
  {
    AppMethodBeat.i(6160);
    this.nES = 0;
    this.nEV = new LinkedList();
    this.nEX = false;
    this.nEY = false;
    this.nyX = paramBizTimeLineUI;
    this.nEQ = paramInt1;
    this.nER = paramInt2;
    this.nEW = paramList;
    if (this.nEW.size() <= 10) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(6154);
          c.this.Xa();
          AppMethodBeat.o(6154);
          return false;
        }
      });
    }
    AppMethodBeat.o(6160);
  }
  
  public static String Cx(String paramString)
  {
    AppMethodBeat.i(210006);
    paramString = com.tencent.mm.api.b.q(paramString, 1);
    AppMethodBeat.o(210006);
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
    ac.v("MicroMsg.BizTimeLineImgLoader", "doPreLoadNext pos %d", new Object[] { Integer.valueOf(paramInt) });
    ImageView localImageView = new ImageView(this.nyX);
    this.nES += 1;
    if ((paramInt == 0) && (paramBoolean)) {
      a(paramLong, paramInt, paramv, paramString, localImageView, getContentWidth(), this.nEQ, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6156);
          c.e(c.this);
          c.this.p(paramLong, this.iKv);
          AppMethodBeat.o(6156);
        }
        
        public final void onStart() {}
      }, false, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(6165);
      return true;
      a(paramLong, paramInt, paramv, paramString, localImageView, this.nER, this.nER, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6157);
          c.e(c.this);
          c.this.p(paramLong, this.iKv);
          AppMethodBeat.o(6157);
        }
        
        public final void onStart() {}
      }, -1, 2.0F);
    }
  }
  
  public static boolean a(t paramt, v paramv)
  {
    AppMethodBeat.i(6174);
    if ((paramt == null) || (paramv == null))
    {
      AppMethodBeat.o(6174);
      return false;
    }
    boolean bool = com.tencent.mm.plugin.brandservice.ui.b.a.a(paramt, paramv);
    AppMethodBeat.o(6174);
    return bool;
  }
  
  private static boolean a(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(6169);
    if (nEU.contains(paramLong + "_" + paramInt))
    {
      AppMethodBeat.o(6169);
      return true;
    }
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6169);
      return false;
    }
    if (!i.eA(r.aGc(com.tencent.mm.api.b.q(paramString, 1))))
    {
      AppMethodBeat.o(6169);
      return false;
    }
    nEU.add(paramLong + "_" + paramInt);
    AppMethodBeat.o(6169);
    return true;
  }
  
  public static boolean bKA()
  {
    AppMethodBeat.i(6176);
    if (nFa == null) {
      bKB();
    }
    boolean bool = nFa.booleanValue();
    AppMethodBeat.o(6176);
    return bool;
  }
  
  private static void bKB()
  {
    AppMethodBeat.i(6177);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aAp().tJ("100461");
    if ((localc.isValid()) && ("1".equals(localc.eYV().get("isOpenBizMsgPreDownloadCover"))))
    {
      bool = true;
      nEZ = Boolean.valueOf(bool);
      if ((!localc.isValid()) || (!"1".equals(localc.eYV().get("isOnlyPreloadInWifi")))) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      nFa = Boolean.valueOf(bool);
      ac.i("MicroMsg.BizTimeLineImgLoader", "BizTimeLineImg initABTest %b/%b", new Object[] { nEZ, nFa });
      AppMethodBeat.o(6177);
      return;
      bool = false;
      break;
    }
  }
  
  private t bKx()
  {
    AppMethodBeat.i(6167);
    int i = 0;
    try
    {
      while (i < this.nEW.size() + this.nEV.size())
      {
        t localt = yG(i);
        if ((localt != null) && (localt.eZj()) && (localt.field_isRead != 1) && (!nET.contains(Long.valueOf(localt.field_msgId))))
        {
          ac.v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo pos=%d,msg id=%d", new Object[] { Integer.valueOf(i), Long.valueOf(localt.field_msgId) });
          AppMethodBeat.o(6167);
          return localt;
        }
        i += 1;
        rp(localt.field_msgId);
      }
      return null;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(6167);
    }
  }
  
  private static boolean bKz()
  {
    AppMethodBeat.i(6175);
    if (nEZ == null) {
      bKB();
    }
    boolean bool = nEZ.booleanValue();
    AppMethodBeat.o(6175);
    return bool;
  }
  
  private static void rp(long paramLong)
  {
    AppMethodBeat.i(6166);
    nET.add(Long.valueOf(paramLong));
    AppMethodBeat.o(6166);
  }
  
  private t yG(int paramInt)
  {
    AppMethodBeat.i(6173);
    try
    {
      t localt;
      if (paramInt < this.nEW.size())
      {
        localt = (t)this.nEW.get(paramInt);
        AppMethodBeat.o(6173);
        return localt;
      }
      if (paramInt < this.nEW.size() + this.nEV.size())
      {
        localt = (t)this.nEV.get(paramInt - this.nEW.size());
        AppMethodBeat.o(6173);
        return localt;
      }
    }
    catch (Throwable localThrowable)
    {
      ac.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(6173);
    }
    return null;
  }
  
  public final void Xa()
  {
    AppMethodBeat.i(6171);
    if (!bKz())
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
        t localt = c.this.bKy();
        if (localt == null)
        {
          AppMethodBeat.o(6159);
          return;
        }
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(6158);
            c.f(c.this).clear();
            c.f(c.this).addAll(this.gan);
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
    AppMethodBeat.i(198741);
    paramImageView.setContentDescription(this.nyX.getString(2131757186));
    paramString = com.tencent.mm.api.b.q(paramString, 1);
    Object localObject = g.Dqh;
    if (g.WT(1))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.Dgo;
      com.tencent.mm.pluginsdk.model.a.l(paramLong, paramInt1, paramv.url);
    }
    localObject = com.tencent.mm.pluginsdk.model.b.DgN;
    localObject = new c.a();
    ((c.a)localObject).hKL = 2131100141;
    ((c.a)localObject).hKx = true;
    localObject = ((c.a)localObject).de(paramInt2, paramInt3);
    ((c.a)localObject).hKN = "2131231255";
    ((c.a)localObject).hKm = new n(1);
    ((c.a)localObject).hKU = new e(1);
    ((c.a)localObject).hKV = new l();
    ((c.a)localObject).gKe = r.aGc(paramString);
    com.tencent.mm.pluginsdk.model.b.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean, ((c.a)localObject).aFT(), new m(1, paramInt2, paramInt3, true, true, paramFloat, parama));
    AppMethodBeat.o(198741);
  }
  
  public final void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, int paramInt3, boolean paramBoolean1, m.a parama, boolean paramBoolean2, int paramInt4)
  {
    AppMethodBeat.i(6161);
    paramImageView.setContentDescription(this.nyX.getString(2131757186));
    paramString = com.tencent.mm.api.b.q(paramString, 1);
    Object localObject = g.Dqh;
    if (g.WT(1))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.Dgo;
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
      float f = com.tencent.mm.cc.a.fromDPToPix(this.nyX, 8);
      localObject = com.tencent.mm.pluginsdk.model.b.DgN;
      localObject = new c.a();
      ((c.a)localObject).hKL = j;
      ((c.a)localObject).hKx = true;
      localObject = ((c.a)localObject).de(paramInt2, paramInt3);
      ((c.a)localObject).hKN = String.valueOf(i);
      ((c.a)localObject).hKm = new n(1);
      ((c.a)localObject).hKU = new e(1);
      ((c.a)localObject).hKV = new l();
      ((c.a)localObject).gKe = r.aGc(paramString);
      com.tencent.mm.pluginsdk.model.b.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean1, ((c.a)localObject).aFT(), new m(1, paramInt2, paramInt3, false, paramBoolean2, f, parama));
      AppMethodBeat.o(6161);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(198742);
    paramImageView.setContentDescription(this.nyX.getString(2131757186));
    Object localObject = com.tencent.mm.pluginsdk.model.b.DgN;
    localObject = new c.a();
    ((c.a)localObject).hKv = true;
    ((c.a)localObject).hKI = 2131100141;
    localObject = ((c.a)localObject).de(paramInt1, paramInt2);
    ((c.a)localObject).hKA = 4;
    com.tencent.mm.pluginsdk.model.b.a(-1L, -1, null, paramString, paramImageView, paramInt3, false, ((c.a)localObject).aFT(), new m());
    AppMethodBeat.o(198742);
  }
  
  public final void bKw()
  {
    AppMethodBeat.i(6164);
    if (!bKz())
    {
      AppMethodBeat.o(6164);
      return;
    }
    if ((this.nEX) || (this.nEY))
    {
      ac.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext loading %b, onPause %b", new Object[] { Boolean.valueOf(this.nEX), Boolean.valueOf(this.nEY) });
      AppMethodBeat.o(6164);
      return;
    }
    this.nEX = true;
    ac.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext");
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
        if ((c.bKA()) && (!ax.isWifi(c.b(c.this))))
        {
          AppMethodBeat.o(6155);
          return;
        }
        if (!c.c(c.this))
        {
          ac.v("MicroMsg.BizTimeLineImgLoader", "not all visibleItem loaded");
          AppMethodBeat.o(6155);
          return;
        }
        t localt = c.d(c.this);
        if (localt == null)
        {
          ac.v("MicroMsg.BizTimeLineImgLoader", "not loading");
          AppMethodBeat.o(6155);
          return;
        }
        c.a(c.this, localt);
        AppMethodBeat.o(6155);
      }
    }, 500L);
    AppMethodBeat.o(6164);
  }
  
  public final t bKy()
  {
    AppMethodBeat.i(6172);
    try
    {
      if (this.nEW.size() > 0)
      {
        t localt = (t)this.nEW.get(this.nEW.size() - 1);
        AppMethodBeat.o(6172);
        return localt;
      }
    }
    catch (Throwable localThrowable)
    {
      ac.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(6172);
    }
    return null;
  }
  
  public final int getContentWidth()
  {
    AppMethodBeat.i(6163);
    int i = com.tencent.mm.cc.a.ig(this.nyX);
    int j = com.tencent.mm.plugin.brandservice.ui.timeline.c.nzj;
    AppMethodBeat.o(6163);
    return i - j;
  }
  
  public final void p(long paramLong, int paramInt)
  {
    AppMethodBeat.i(6168);
    ac.v("MicroMsg.BizTimeLineImgLoader", "onLoadFinish mLoadingCount %d", new Object[] { Integer.valueOf(this.nES) });
    nEU.add(paramLong + "_" + paramInt);
    if (this.nES <= 0) {
      bKw();
    }
    AppMethodBeat.o(6168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c
 * JD-Core Version:    0.7.0.1
 */