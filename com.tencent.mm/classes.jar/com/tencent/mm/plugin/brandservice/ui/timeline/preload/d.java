package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.v;
import com.tencent.mm.ao.af;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
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
import com.tencent.mm.vfs.u;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private static HashSet<String> sKC;
  private static HashSet<String> sKD;
  private static Boolean sKK;
  private static Boolean sKL;
  public BizTimeLineUI sAm;
  public int sKB;
  public List<z> sKE;
  private List<z> sKF;
  private List<z> sKG;
  private boolean sKH;
  public boolean sKI;
  private boolean sKJ;
  
  static
  {
    AppMethodBeat.i(6181);
    sKC = new HashSet();
    sKD = new HashSet();
    sKK = null;
    sKL = null;
    AppMethodBeat.o(6181);
  }
  
  public d(BizTimeLineUI paramBizTimeLineUI, List<z> paramList1, List<z> paramList2)
  {
    AppMethodBeat.i(266409);
    this.sKB = 0;
    this.sKE = new LinkedList();
    this.sKH = false;
    this.sKI = false;
    this.sKJ = false;
    this.sAm = paramBizTimeLineUI;
    this.sKF = paramList1;
    this.sKG = paramList2;
    if (this.sKF.size() <= 10) {
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
    AppMethodBeat.o(266409);
  }
  
  private z GK(int paramInt)
  {
    AppMethodBeat.i(6173);
    try
    {
      z localz;
      if (paramInt < this.sKF.size())
      {
        localz = (z)this.sKF.get(paramInt);
        AppMethodBeat.o(6173);
        return localz;
      }
      if (paramInt < this.sKF.size() + this.sKE.size())
      {
        localz = (z)this.sKE.get(paramInt - this.sKF.size());
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
  
  private z GV(int paramInt)
  {
    AppMethodBeat.i(266421);
    try
    {
      if (paramInt < this.sKG.size())
      {
        z localz = (z)this.sKG.get(paramInt);
        AppMethodBeat.o(266421);
        return localz;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.w("MicroMsg.BizTimeLineImgLoader", "getRecItem error %s", new Object[] { localThrowable.getMessage() });
      AppMethodBeat.o(266421);
    }
    return null;
  }
  
  public static String Wm(String paramString)
  {
    AppMethodBeat.i(293126);
    paramString = com.tencent.mm.api.b.M(paramString, 1);
    AppMethodBeat.o(293126);
    return paramString;
  }
  
  private boolean a(v paramv, String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(266414);
    if (paramv == null)
    {
      AppMethodBeat.o(266414);
      return false;
    }
    if (paramv.type == 0) {}
    for (int i = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAo;; i = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAq)
    {
      paramBoolean = a(paramv, paramString, paramLong, paramInt, paramBoolean, getContentWidth(), i);
      AppMethodBeat.o(266414);
      return paramBoolean;
    }
  }
  
  private boolean a(v paramv, String paramString, final long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(266415);
    if ((Util.isNullOrNil(paramString)) || (a(paramString, paramLong, paramInt1)))
    {
      AppMethodBeat.o(266415);
      return false;
    }
    ImageView localImageView = new ImageView(this.sAm);
    this.sKB += 1;
    Log.d("MicroMsg.BizTimeLineImgLoader", "doLoadImage loadingCount=%d, msgId=%d, pos=%d, showBigImg=%b", new Object[] { Integer.valueOf(this.sKB), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
    if ((paramInt1 == 0) && (paramBoolean)) {
      a(paramLong, paramInt1, paramv, paramString, localImageView, paramInt2, paramInt3, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6156);
          d.f(d.this);
          Log.d("MicroMsg.BizTimeLineImgLoader", "doLoadImage onFinish loadingCount=%d", new Object[] { Integer.valueOf(d.g(d.this)) });
          d.this.p(paramLong, this.mWa);
          AppMethodBeat.o(6156);
        }
        
        public final void onStart() {}
      }, false, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(266415);
      return true;
      paramInt2 = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAs;
      a(paramLong, paramInt1, paramv, paramString, localImageView, paramInt2, paramInt2, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6157);
          d.f(d.this);
          Log.d("MicroMsg.BizTimeLineImgLoader", "doLoadImage onFinish loadingCount=%d", new Object[] { Integer.valueOf(d.g(d.this)) });
          d.this.p(paramLong, this.mWa);
          AppMethodBeat.o(6157);
        }
        
        public final void onStart() {}
      }, -1, 0.0F);
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
    AppMethodBeat.i(266418);
    if (sKD.contains(paramLong + "_" + paramInt))
    {
      AppMethodBeat.o(266418);
      return true;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(266418);
      return false;
    }
    if (!u.agG(w.bpO(com.tencent.mm.api.b.M(paramString, 1))))
    {
      AppMethodBeat.o(266418);
      return false;
    }
    sKD.add(paramLong + "_" + paramInt);
    AppMethodBeat.o(266418);
    return true;
  }
  
  public static void apR(String paramString)
  {
    AppMethodBeat.i(266416);
    sKC.add(paramString);
    AppMethodBeat.o(266416);
  }
  
  private z cBC()
  {
    AppMethodBeat.i(6167);
    int i = 0;
    try
    {
      while (i < this.sKF.size() + this.sKE.size())
      {
        z localz = GK(i);
        if ((localz != null) && (localz.hwA()) && (localz.field_isRead != 1) && (!sKC.contains(localz.getId())))
        {
          Log.v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo pos=%d,msg id=%d", new Object[] { Integer.valueOf(i), Long.valueOf(localz.field_msgId) });
          AppMethodBeat.o(6167);
          return localz;
        }
        i += 1;
        apR(localz.getId());
      }
      return null;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(6167);
    }
  }
  
  private z cBF()
  {
    AppMethodBeat.i(266422);
    int i = 0;
    try
    {
      while (i < this.sKG.size())
      {
        z localz = GV(i);
        if ((localz != null) && (localz.hwz()) && (!sKC.contains(localz.getId())))
        {
          Log.v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadRecFeed pos=%d", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(266422);
          return localz;
        }
        i += 1;
        apR(localz.getId());
      }
      return null;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadRecFeed %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(266422);
    }
  }
  
  private void cBG()
  {
    AppMethodBeat.i(266423);
    if (!cBH())
    {
      AppMethodBeat.o(266423);
      return;
    }
    if ((this.sKH) || (this.sKI))
    {
      Log.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext loading %b, onPause %b", new Object[] { Boolean.valueOf(this.sKH), Boolean.valueOf(this.sKI) });
      AppMethodBeat.o(266423);
      return;
    }
    this.sKH = true;
    Log.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext");
    com.tencent.mm.plugin.brandservice.b.a("BizTimeLineImgLoaderThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(260676);
        d.a(d.this);
        if ((d.b(d.this) == null) || (d.b(d.this).isFinishing()))
        {
          AppMethodBeat.o(260676);
          return;
        }
        if ((d.cBI()) && (!NetStatusUtil.isWifi(d.b(d.this))))
        {
          AppMethodBeat.o(260676);
          return;
        }
        if (!d.c(d.this))
        {
          Log.v("MicroMsg.BizTimeLineImgLoader", "not all visibleItem loaded");
          AppMethodBeat.o(260676);
          return;
        }
        z localz = d.i(d.this);
        if (localz == null)
        {
          Log.v("MicroMsg.BizTimeLineImgLoader", "not loading recFeed");
          AppMethodBeat.o(260676);
          return;
        }
        d.b(d.this, localz);
        AppMethodBeat.o(260676);
      }
    }, 500L);
    AppMethodBeat.o(266423);
  }
  
  private static boolean cBH()
  {
    AppMethodBeat.i(6175);
    if (sKK == null) {
      cBJ();
    }
    boolean bool = sKK.booleanValue();
    AppMethodBeat.o(6175);
    return bool;
  }
  
  public static boolean cBI()
  {
    AppMethodBeat.i(6176);
    if (sKL == null) {
      cBJ();
    }
    boolean bool = sKL.booleanValue();
    AppMethodBeat.o(6176);
    return bool;
  }
  
  private static void cBJ()
  {
    AppMethodBeat.i(6177);
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzR, 1) == 1)
    {
      bool = true;
      sKK = Boolean.valueOf(bool);
      if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzS, 0) != 1) {
        break label104;
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      sKL = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizTimeLineImgLoader", "BizTimeLineImg initABTest %b/%b", new Object[] { sKK, sKL });
      AppMethodBeat.o(6177);
      return;
      bool = false;
      break;
    }
  }
  
  public final void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, int paramInt3, boolean paramBoolean, m.a parama, int paramInt4, float paramFloat)
  {
    AppMethodBeat.i(266411);
    paramImageView.setContentDescription(this.sAm.getString(d.i.chatting_img_item_desc));
    paramString = com.tencent.mm.api.b.M(paramString, 1);
    Object localObject = g.Rfj;
    if (g.aqi(1))
    {
      localObject = c.QUt;
      c.m(paramLong, paramInt1, paramv.url);
    }
    int i = d.d.spD;
    localObject = com.tencent.mm.pluginsdk.model.d.QUR;
    localObject = new c.a();
    ((c.a)localObject).lRS = d.b.chatting_item_biz_default_bg;
    ((c.a)localObject).lRD = true;
    localObject = ((c.a)localObject).dO(paramInt2, paramInt3);
    ((c.a)localObject).lRU = String.valueOf(i);
    ((c.a)localObject).lRs = new n(1);
    ((c.a)localObject).lSb = new e(1);
    ((c.a)localObject).lSc = new l();
    ((c.a)localObject).fullPath = w.bpO(paramString);
    com.tencent.mm.pluginsdk.model.d.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean, ((c.a)localObject).bmL(), new m(1, paramInt2, paramInt3, true, true, paramFloat, parama));
    AppMethodBeat.o(266411);
  }
  
  public final void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, int paramInt3, boolean paramBoolean1, m.a parama, boolean paramBoolean2, int paramInt4)
  {
    AppMethodBeat.i(266410);
    paramImageView.setContentDescription(this.sAm.getString(d.i.chatting_img_item_desc));
    paramString = com.tencent.mm.api.b.M(paramString, 1);
    Object localObject = g.Rfj;
    if (g.aqi(1))
    {
      localObject = c.QUt;
      c.m(paramLong, paramInt1, paramv.url);
    }
    int i;
    if (paramBoolean2)
    {
      i = d.d.spz;
      if (!paramBoolean2) {
        break label236;
      }
    }
    label236:
    for (int j = d.d.spy;; j = d.d.spB)
    {
      float f = com.tencent.mm.ci.a.fromDPToPix(this.sAm, 8);
      localObject = com.tencent.mm.pluginsdk.model.d.QUR;
      localObject = new c.a();
      ((c.a)localObject).lRS = j;
      ((c.a)localObject).lRD = true;
      localObject = ((c.a)localObject).dO(paramInt2, paramInt3);
      ((c.a)localObject).lRU = String.valueOf(i);
      ((c.a)localObject).lRs = new n(1);
      ((c.a)localObject).lSb = new e(1);
      ((c.a)localObject).lSc = new l();
      ((c.a)localObject).fullPath = w.bpO(paramString);
      com.tencent.mm.pluginsdk.model.d.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean1, ((c.a)localObject).bmL(), new m(1, paramInt2, paramInt3, false, paramBoolean2, f, parama));
      AppMethodBeat.o(266410);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(266412);
    paramImageView.setContentDescription(this.sAm.getString(d.i.chatting_img_item_desc));
    Object localObject = com.tencent.mm.pluginsdk.model.d.QUR;
    localObject = new c.a();
    ((c.a)localObject).lRB = true;
    ((c.a)localObject).lRP = d.b.chatting_item_biz_default_bg;
    localObject = ((c.a)localObject).dO(paramInt1, paramInt2);
    ((c.a)localObject).lRG = 4;
    com.tencent.mm.pluginsdk.model.d.a(-1L, -1, null, paramString, paramImageView, paramInt3, false, ((c.a)localObject).bmL(), new m());
    AppMethodBeat.o(266412);
  }
  
  public final int cBA()
  {
    AppMethodBeat.i(266413);
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.shG;
    int i = com.tencent.mm.plugin.bizui.a.a.eO(this.sAm);
    int j = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAu;
    AppMethodBeat.o(266413);
    return i - j * 2;
  }
  
  public final void cBB()
  {
    AppMethodBeat.i(6164);
    if (!cBH())
    {
      AppMethodBeat.o(6164);
      return;
    }
    if ((this.sKH) || (this.sKI))
    {
      Log.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext loading %b, onPause %b", new Object[] { Boolean.valueOf(this.sKH), Boolean.valueOf(this.sKI) });
      AppMethodBeat.o(6164);
      return;
    }
    this.sKH = true;
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
        if ((d.cBI()) && (!NetStatusUtil.isWifi(d.b(d.this))))
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
          d.e(d.this);
          d.this.cBE();
          AppMethodBeat.o(6155);
          return;
        }
        d.a(d.this, localz);
        AppMethodBeat.o(6155);
      }
    }, 500L);
    AppMethodBeat.o(6164);
  }
  
  public final z cBD()
  {
    AppMethodBeat.i(6172);
    try
    {
      if (this.sKF.size() > 0)
      {
        z localz = (z)this.sKF.get(this.sKF.size() - 1);
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
  
  public final void cBE()
  {
    AppMethodBeat.i(266420);
    if ((Util.isNullOrNil(this.sKG)) || (!this.sKJ))
    {
      AppMethodBeat.o(266420);
      return;
    }
    cBG();
    AppMethodBeat.o(266420);
  }
  
  public final int getContentWidth()
  {
    AppMethodBeat.i(6163);
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.shG;
    int i = com.tencent.mm.plugin.bizui.a.a.eO(this.sAm);
    int j = com.tencent.mm.plugin.brandservice.ui.timeline.b.sAu;
    AppMethodBeat.o(6163);
    return i - j;
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(6171);
    if (!cBH())
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
        z localz = d.this.cBD();
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
            d.h(d.this).clear();
            d.h(d.this).addAll(this.pzd);
            AppMethodBeat.o(6158);
          }
        });
        AppMethodBeat.o(6159);
      }
    }, 0L);
    AppMethodBeat.o(6171);
  }
  
  public final void p(long paramLong, int paramInt)
  {
    AppMethodBeat.i(6168);
    sKD.add(paramLong + "_" + paramInt);
    if (this.sKB <= 0) {
      cBB();
    }
    AppMethodBeat.o(6168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.d
 * JD-Core Version:    0.7.0.1
 */