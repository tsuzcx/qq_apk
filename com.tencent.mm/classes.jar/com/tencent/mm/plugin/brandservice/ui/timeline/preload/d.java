package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private static Boolean pAC;
  private static Boolean pAD;
  private static HashSet<Long> pAw;
  private static HashSet<String> pAx;
  private boolean pAA;
  public boolean pAB;
  private int pAt;
  private int pAu;
  public int pAv;
  public List<z> pAy;
  private List<z> pAz;
  public BizTimeLineUI pro;
  
  static
  {
    AppMethodBeat.i(6181);
    pAw = new HashSet();
    pAx = new HashSet();
    pAC = null;
    pAD = null;
    AppMethodBeat.o(6181);
  }
  
  public d(BizTimeLineUI paramBizTimeLineUI, int paramInt1, int paramInt2, List<z> paramList)
  {
    AppMethodBeat.i(6160);
    this.pAv = 0;
    this.pAy = new LinkedList();
    this.pAA = false;
    this.pAB = false;
    this.pro = paramBizTimeLineUI;
    this.pAt = paramInt1;
    this.pAu = paramInt2;
    this.pAz = paramList;
    if (this.pAz.size() <= 10) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(6154);
          d.this.onLoadMore();
          AppMethodBeat.o(6154);
          return false;
        }
      });
    }
    AppMethodBeat.o(6160);
  }
  
  private static void BG(long paramLong)
  {
    AppMethodBeat.i(6166);
    pAw.add(Long.valueOf(paramLong));
    AppMethodBeat.o(6166);
  }
  
  private z De(int paramInt)
  {
    AppMethodBeat.i(6173);
    try
    {
      z localz;
      if (paramInt < this.pAz.size())
      {
        localz = (z)this.pAz.get(paramInt);
        AppMethodBeat.o(6173);
        return localz;
      }
      if (paramInt < this.pAz.size() + this.pAy.size())
      {
        localz = (z)this.pAy.get(paramInt - this.pAz.size());
        AppMethodBeat.o(6173);
        return localz;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(6173);
    }
    return null;
  }
  
  public static String OO(String paramString)
  {
    AppMethodBeat.i(258319);
    paramString = com.tencent.mm.api.b.u(paramString, 1);
    AppMethodBeat.o(258319);
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
    Log.v("MicroMsg.BizTimeLineImgLoader", "doPreLoadNext pos %d", new Object[] { Integer.valueOf(paramInt) });
    ImageView localImageView = new ImageView(this.pro);
    this.pAv += 1;
    if ((paramInt == 0) && (paramBoolean)) {
      a(paramLong, paramInt, paramv, paramString, localImageView, getContentWidth(), this.pAt, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6156);
          d.e(d.this);
          d.this.m(paramLong, this.keB);
          AppMethodBeat.o(6156);
        }
        
        public final void onStart() {}
      }, false, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(6165);
      return true;
      a(paramLong, paramInt, paramv, paramString, localImageView, this.pAu, this.pAu, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6157);
          d.e(d.this);
          d.this.m(paramLong, this.keB);
          AppMethodBeat.o(6157);
        }
        
        public final void onStart() {}
      }, -1, 2.0F);
    }
  }
  
  public static boolean a(z paramz, v paramv)
  {
    AppMethodBeat.i(6174);
    if ((paramz == null) || (paramv == null))
    {
      AppMethodBeat.o(6174);
      return false;
    }
    boolean bool = com.tencent.mm.plugin.brandservice.ui.b.a.a(paramz, paramv);
    AppMethodBeat.o(6174);
    return bool;
  }
  
  private static boolean a(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(6169);
    if (pAx.contains(paramLong + "_" + paramInt))
    {
      AppMethodBeat.o(6169);
      return true;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6169);
      return false;
    }
    if (!com.tencent.mm.vfs.s.YS(com.tencent.mm.pluginsdk.model.s.bdu(com.tencent.mm.api.b.u(paramString, 1))))
    {
      AppMethodBeat.o(6169);
      return false;
    }
    pAx.add(paramLong + "_" + paramInt);
    AppMethodBeat.o(6169);
    return true;
  }
  
  private z cnA()
  {
    AppMethodBeat.i(6167);
    int i = 0;
    try
    {
      while (i < this.pAz.size() + this.pAy.size())
      {
        z localz = De(i);
        if ((localz != null) && (localz.gAt()) && (localz.field_isRead != 1) && (!pAw.contains(Long.valueOf(localz.field_msgId))))
        {
          Log.v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo pos=%d,msg id=%d", new Object[] { Integer.valueOf(i), Long.valueOf(localz.field_msgId) });
          AppMethodBeat.o(6167);
          return localz;
        }
        i += 1;
        BG(localz.field_msgId);
      }
      return null;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(6167);
    }
  }
  
  private static boolean cnC()
  {
    AppMethodBeat.i(6175);
    if (pAC == null) {
      cnE();
    }
    boolean bool = pAC.booleanValue();
    AppMethodBeat.o(6175);
    return bool;
  }
  
  public static boolean cnD()
  {
    AppMethodBeat.i(6176);
    if (pAD == null) {
      cnE();
    }
    boolean bool = pAD.booleanValue();
    AppMethodBeat.o(6176);
    return bool;
  }
  
  private static void cnE()
  {
    AppMethodBeat.i(6177);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTq, 1) == 1)
    {
      bool = true;
      pAC = Boolean.valueOf(bool);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTr, 0) != 1) {
        break label104;
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      pAD = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizTimeLineImgLoader", "BizTimeLineImg initABTest %b/%b", new Object[] { pAC, pAD });
      AppMethodBeat.o(6177);
      return;
      bool = false;
      break;
    }
  }
  
  public final void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, int paramInt3, boolean paramBoolean, m.a parama, int paramInt4, float paramFloat)
  {
    AppMethodBeat.i(195022);
    paramImageView.setContentDescription(this.pro.getString(2131757392));
    paramString = com.tencent.mm.api.b.u(paramString, 1);
    Object localObject = com.tencent.mm.pluginsdk.ui.applet.g.Kev;
    if (com.tencent.mm.pluginsdk.ui.applet.g.aig(1))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.JUl;
      com.tencent.mm.pluginsdk.model.a.n(paramLong, paramInt1, paramv.url);
    }
    localObject = com.tencent.mm.pluginsdk.model.b.JUJ;
    localObject = new c.a();
    ((c.a)localObject).jbt = 2131100173;
    ((c.a)localObject).jbf = true;
    localObject = ((c.a)localObject).dr(paramInt2, paramInt3);
    ((c.a)localObject).jbv = "2131231315";
    ((c.a)localObject).jaU = new n(1);
    ((c.a)localObject).jbC = new e(1);
    ((c.a)localObject).jbD = new l();
    ((c.a)localObject).fullPath = com.tencent.mm.pluginsdk.model.s.bdu(paramString);
    com.tencent.mm.pluginsdk.model.b.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean, ((c.a)localObject).bdv(), new m(1, paramInt2, paramInt3, true, true, paramFloat, parama));
    AppMethodBeat.o(195022);
  }
  
  public final void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, int paramInt3, boolean paramBoolean1, m.a parama, boolean paramBoolean2, int paramInt4)
  {
    AppMethodBeat.i(6161);
    paramImageView.setContentDescription(this.pro.getString(2131757392));
    paramString = com.tencent.mm.api.b.u(paramString, 1);
    Object localObject = com.tencent.mm.pluginsdk.ui.applet.g.Kev;
    if (com.tencent.mm.pluginsdk.ui.applet.g.aig(1))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.JUl;
      com.tencent.mm.pluginsdk.model.a.n(paramLong, paramInt1, paramv.url);
    }
    int i;
    if (paramBoolean2)
    {
      i = 2131231310;
      if (!paramBoolean2) {
        break label236;
      }
    }
    label236:
    for (int j = 2131231307;; j = 2131231312)
    {
      float f = com.tencent.mm.cb.a.fromDPToPix(this.pro, 8);
      localObject = com.tencent.mm.pluginsdk.model.b.JUJ;
      localObject = new c.a();
      ((c.a)localObject).jbt = j;
      ((c.a)localObject).jbf = true;
      localObject = ((c.a)localObject).dr(paramInt2, paramInt3);
      ((c.a)localObject).jbv = String.valueOf(i);
      ((c.a)localObject).jaU = new n(1);
      ((c.a)localObject).jbC = new e(1);
      ((c.a)localObject).jbD = new l();
      ((c.a)localObject).fullPath = com.tencent.mm.pluginsdk.model.s.bdu(paramString);
      com.tencent.mm.pluginsdk.model.b.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean1, ((c.a)localObject).bdv(), new m(1, paramInt2, paramInt3, false, paramBoolean2, f, parama));
      AppMethodBeat.o(6161);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(195023);
    paramImageView.setContentDescription(this.pro.getString(2131757392));
    Object localObject = com.tencent.mm.pluginsdk.model.b.JUJ;
    localObject = new c.a();
    ((c.a)localObject).jbd = true;
    ((c.a)localObject).jbq = 2131100173;
    localObject = ((c.a)localObject).dr(paramInt1, paramInt2);
    ((c.a)localObject).jbi = 4;
    com.tencent.mm.pluginsdk.model.b.a(-1L, -1, null, paramString, paramImageView, paramInt3, false, ((c.a)localObject).bdv(), new m());
    AppMethodBeat.o(195023);
  }
  
  public final z cnB()
  {
    AppMethodBeat.i(6172);
    try
    {
      if (this.pAz.size() > 0)
      {
        z localz = (z)this.pAz.get(this.pAz.size() - 1);
        AppMethodBeat.o(6172);
        return localz;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(6172);
    }
    return null;
  }
  
  public final void cnz()
  {
    AppMethodBeat.i(6164);
    if (!cnC())
    {
      AppMethodBeat.o(6164);
      return;
    }
    if ((this.pAA) || (this.pAB))
    {
      Log.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext loading %b, onPause %b", new Object[] { Boolean.valueOf(this.pAA), Boolean.valueOf(this.pAB) });
      AppMethodBeat.o(6164);
      return;
    }
    this.pAA = true;
    Log.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext");
    com.tencent.mm.plugin.brandservice.b.a("BizTimeLineImgLoaderThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6155);
        d.a(d.this);
        if ((d.b(d.this) == null) || (d.b(d.this).isFinishing()))
        {
          AppMethodBeat.o(6155);
          return;
        }
        if ((d.cnD()) && (!NetStatusUtil.isWifi(d.b(d.this))))
        {
          AppMethodBeat.o(6155);
          return;
        }
        if (!d.c(d.this))
        {
          Log.v("MicroMsg.BizTimeLineImgLoader", "not all visibleItem loaded");
          AppMethodBeat.o(6155);
          return;
        }
        z localz = d.d(d.this);
        if (localz == null)
        {
          Log.v("MicroMsg.BizTimeLineImgLoader", "not loading");
          AppMethodBeat.o(6155);
          return;
        }
        d.a(d.this, localz);
        AppMethodBeat.o(6155);
      }
    }, 500L);
    AppMethodBeat.o(6164);
  }
  
  public final int getContentWidth()
  {
    AppMethodBeat.i(6163);
    int i = com.tencent.mm.cb.a.jn(this.pro);
    int j = com.tencent.mm.plugin.brandservice.ui.timeline.b.prD;
    AppMethodBeat.o(6163);
    return i - j;
  }
  
  public final void m(long paramLong, int paramInt)
  {
    AppMethodBeat.i(6168);
    Log.v("MicroMsg.BizTimeLineImgLoader", "onLoadFinish mLoadingCount %d", new Object[] { Integer.valueOf(this.pAv) });
    pAx.add(paramLong + "_" + paramInt);
    if (this.pAv <= 0) {
      cnz();
    }
    AppMethodBeat.o(6168);
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(6171);
    if (!cnC())
    {
      AppMethodBeat.o(6171);
      return;
    }
    com.tencent.mm.plugin.brandservice.b.a("BizTimeLineImgLoaderThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6159);
        if ((d.b(d.this) == null) || (d.b(d.this).isFinishing()))
        {
          AppMethodBeat.o(6159);
          return;
        }
        z localz = d.this.cnB();
        if (localz == null)
        {
          AppMethodBeat.o(6159);
          return;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(6158);
            d.f(d.this).clear();
            d.f(d.this).addAll(this.hjk);
            AppMethodBeat.o(6158);
          }
        });
        AppMethodBeat.o(6159);
      }
    }, 0L);
    AppMethodBeat.o(6171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.d
 * JD-Core Version:    0.7.0.1
 */