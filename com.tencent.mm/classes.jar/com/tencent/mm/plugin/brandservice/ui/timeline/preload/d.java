package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private static Boolean vQD;
  private static Boolean vQE;
  private static HashSet<String> vQv;
  private static HashSet<String> vQw;
  public BizTimeLineUI vFF;
  private boolean vQA;
  public boolean vQB;
  private boolean vQC;
  public int vQu;
  public List<ab> vQx;
  private List<ab> vQy;
  private List<ab> vQz;
  
  static
  {
    AppMethodBeat.i(6181);
    vQv = new HashSet();
    vQw = new HashSet();
    vQD = null;
    vQE = null;
    AppMethodBeat.o(6181);
  }
  
  public d(BizTimeLineUI paramBizTimeLineUI, List<ab> paramList1, List<ab> paramList2)
  {
    AppMethodBeat.i(303197);
    this.vQu = 0;
    this.vQx = new LinkedList();
    this.vQA = false;
    this.vQB = false;
    this.vQC = false;
    this.vFF = paramBizTimeLineUI;
    this.vQy = paramList1;
    this.vQz = paramList2;
    if (this.vQy.size() <= 10) {
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
    AppMethodBeat.o(303197);
  }
  
  private ab Hk(int paramInt)
  {
    AppMethodBeat.i(6173);
    try
    {
      ab localab;
      if (paramInt < this.vQy.size())
      {
        localab = (ab)this.vQy.get(paramInt);
        AppMethodBeat.o(6173);
        return localab;
      }
      if (paramInt < this.vQy.size() + this.vQx.size())
      {
        localab = (ab)this.vQx.get(paramInt - this.vQy.size());
        AppMethodBeat.o(6173);
        return localab;
      }
    }
    finally
    {
      Log.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localObject.getMessage() });
      AppMethodBeat.o(6173);
    }
    return null;
  }
  
  private ab Hu(int paramInt)
  {
    AppMethodBeat.i(303273);
    try
    {
      if (paramInt < this.vQz.size())
      {
        ab localab = (ab)this.vQz.get(paramInt);
        AppMethodBeat.o(303273);
        return localab;
      }
    }
    finally
    {
      Log.w("MicroMsg.BizTimeLineImgLoader", "getRecItem error %s", new Object[] { localObject.getMessage() });
      AppMethodBeat.o(303273);
    }
    return null;
  }
  
  public static String Om(String paramString)
  {
    AppMethodBeat.i(369886);
    paramString = com.tencent.mm.api.b.U(paramString, 1);
    AppMethodBeat.o(369886);
    return paramString;
  }
  
  public static void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, int paramInt3, boolean paramBoolean, m.a parama, int paramInt4, float paramFloat)
  {
    AppMethodBeat.i(303203);
    paramString = com.tencent.mm.api.b.U(paramString, 1);
    Object localObject = g.Ybp;
    if (g.awm(1))
    {
      localObject = com.tencent.mm.pluginsdk.model.e.XQp;
      com.tencent.mm.pluginsdk.model.e.o(paramLong, paramInt1, paramv.url);
    }
    int i = d.d.biz_time_line_cover_round_mask_bg;
    localObject = f.XQM;
    localObject = new com.tencent.mm.modelimage.loader.a.c.a();
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKE = d.b.chatting_item_biz_default_bg;
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKp = true;
    localObject = ((com.tencent.mm.modelimage.loader.a.c.a)localObject).eG(paramInt2, paramInt3);
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKG = String.valueOf(i);
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKe = new n(1);
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKN = new com.tencent.mm.pluginsdk.ui.applet.e(1);
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKO = new l();
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).fullPath = com.tencent.mm.pluginsdk.model.y.bpF(paramString);
    f.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean, ((com.tencent.mm.modelimage.loader.a.c.a)localObject).bKx(), new m(1, paramInt2, paramInt3, true, true, paramFloat, parama));
    AppMethodBeat.o(303203);
  }
  
  public static void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(303212);
    Object localObject = f.XQM;
    localObject = new com.tencent.mm.modelimage.loader.a.c.a();
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKn = true;
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKB = d.b.chatting_item_biz_default_bg;
    localObject = ((com.tencent.mm.modelimage.loader.a.c.a)localObject).eG(paramInt1, paramInt2);
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKs = 4;
    f.a(-1L, -1, null, paramString, paramImageView, paramInt3, false, ((com.tencent.mm.modelimage.loader.a.c.a)localObject).bKx(), new m());
    AppMethodBeat.o(303212);
  }
  
  private boolean a(v paramv, String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(303217);
    if (paramv == null)
    {
      AppMethodBeat.o(303217);
      return false;
    }
    if (paramv.type == 0) {}
    for (int i = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGa;; i = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGc)
    {
      paramBoolean = a(paramv, paramString, paramLong, paramInt, paramBoolean, getContentWidth(), i);
      AppMethodBeat.o(303217);
      return paramBoolean;
    }
  }
  
  private boolean a(v paramv, String paramString, final long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(303226);
    if ((Util.isNullOrNil(paramString)) || (a(paramString, paramLong, paramInt1)))
    {
      AppMethodBeat.o(303226);
      return false;
    }
    ImageView localImageView = new ImageView(this.vFF);
    this.vQu += 1;
    Log.d("MicroMsg.BizTimeLineImgLoader", "doLoadImage loadingCount=%d, msgId=%d, pos=%d, showBigImg=%b", new Object[] { Integer.valueOf(this.vQu), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean) });
    if ((paramInt1 == 0) && (paramBoolean)) {
      a(paramLong, paramInt1, paramv, paramString, localImageView, paramInt2, paramInt3, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6156);
          d.f(d.this);
          Log.d("MicroMsg.BizTimeLineImgLoader", "doLoadImage onFinish loadingCount=%d", new Object[] { Integer.valueOf(d.g(d.this)) });
          d.this.y(paramLong, this.pSH);
          AppMethodBeat.o(6156);
        }
        
        public final void onStart() {}
      }, false, -1);
    }
    for (;;)
    {
      AppMethodBeat.o(303226);
      return true;
      paramInt2 = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGe;
      a(paramLong, paramInt1, paramv, paramString, localImageView, paramInt2, paramInt2, true, new m.a()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(6157);
          d.f(d.this);
          Log.d("MicroMsg.BizTimeLineImgLoader", "doLoadImage onFinish loadingCount=%d", new Object[] { Integer.valueOf(d.g(d.this)) });
          d.this.y(paramLong, this.pSH);
          AppMethodBeat.o(6157);
        }
        
        public final void onStart() {}
      }, -1, 0.0F);
    }
  }
  
  public static boolean a(ab paramab, v paramv)
  {
    AppMethodBeat.i(6174);
    if ((paramab == null) || (paramv == null))
    {
      AppMethodBeat.o(6174);
      return false;
    }
    boolean bool = com.tencent.mm.plugin.brandservice.ui.b.b.a(paramab, paramv);
    AppMethodBeat.o(6174);
    return bool;
  }
  
  private static boolean a(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(303244);
    if (vQw.contains(paramLong + "_" + paramInt))
    {
      AppMethodBeat.o(303244);
      return true;
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(303244);
      return false;
    }
    if (!com.tencent.mm.vfs.y.ZC(com.tencent.mm.pluginsdk.model.y.bpF(com.tencent.mm.api.b.U(paramString, 1))))
    {
      AppMethodBeat.o(303244);
      return false;
    }
    vQw.add(paramLong + "_" + paramInt);
    AppMethodBeat.o(303244);
    return true;
  }
  
  public static void ajs(String paramString)
  {
    AppMethodBeat.i(303232);
    vQv.add(paramString);
    AppMethodBeat.o(303232);
  }
  
  private ab deN()
  {
    AppMethodBeat.i(6167);
    int i = 0;
    try
    {
      while (i < this.vQy.size() + this.vQx.size())
      {
        ab localab = Hk(i);
        if ((localab != null) && (localab.iYe()) && (localab.field_isRead != 1) && (!vQv.contains(localab.getId())))
        {
          Log.v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo pos=%d,msg id=%d", new Object[] { Integer.valueOf(i), Long.valueOf(localab.field_msgId) });
          AppMethodBeat.o(6167);
          return localab;
        }
        i += 1;
        ajs(localab.getId());
      }
      return null;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(6167);
    }
  }
  
  private ab deQ()
  {
    AppMethodBeat.i(303282);
    int i = 0;
    try
    {
      while (i < this.vQz.size())
      {
        ab localab = Hu(i);
        if ((localab != null) && (localab.iYd()) && (!vQv.contains(localab.getId())))
        {
          Log.v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadRecFeed pos=%d", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(303282);
          return localab;
        }
        i += 1;
        ajs(localab.getId());
      }
      return null;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadRecFeed %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(303282);
    }
  }
  
  private void deR()
  {
    AppMethodBeat.i(303292);
    if (!deS())
    {
      AppMethodBeat.o(303292);
      return;
    }
    if ((this.vQA) || (this.vQB))
    {
      Log.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext loading %b, onPause %b", new Object[] { Boolean.valueOf(this.vQA), Boolean.valueOf(this.vQB) });
      AppMethodBeat.o(303292);
      return;
    }
    this.vQA = true;
    Log.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext");
    com.tencent.mm.plugin.brandservice.b.a("BizTimeLineImgLoaderThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(303007);
        d.a(d.this);
        if ((d.b(d.this) == null) || (d.b(d.this).isFinishing()))
        {
          AppMethodBeat.o(303007);
          return;
        }
        if ((d.deT()) && (!NetStatusUtil.isWifi(d.b(d.this))))
        {
          AppMethodBeat.o(303007);
          return;
        }
        if (!d.c(d.this))
        {
          Log.v("MicroMsg.BizTimeLineImgLoader", "not all visibleItem loaded");
          AppMethodBeat.o(303007);
          return;
        }
        ab localab = d.i(d.this);
        if (localab == null)
        {
          Log.v("MicroMsg.BizTimeLineImgLoader", "not loading recFeed");
          AppMethodBeat.o(303007);
          return;
        }
        d.b(d.this, localab);
        AppMethodBeat.o(303007);
      }
    }, 500L);
    AppMethodBeat.o(303292);
  }
  
  private static boolean deS()
  {
    AppMethodBeat.i(6175);
    if (vQD == null) {
      deU();
    }
    boolean bool = vQD.booleanValue();
    AppMethodBeat.o(6175);
    return bool;
  }
  
  public static boolean deT()
  {
    AppMethodBeat.i(6176);
    if (vQE == null) {
      deU();
    }
    boolean bool = vQE.booleanValue();
    AppMethodBeat.o(6176);
    return bool;
  }
  
  private static void deU()
  {
    AppMethodBeat.i(6177);
    if (((c)h.ax(c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yNy, 1) == 1)
    {
      bool = true;
      vQD = Boolean.valueOf(bool);
      if (((c)h.ax(c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yNA, 0) != 1) {
        break label104;
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      vQE = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizTimeLineImgLoader", "BizTimeLineImg initABTest %b/%b", new Object[] { vQD, vQE });
      AppMethodBeat.o(6177);
      return;
      bool = false;
      break;
    }
  }
  
  public final void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, int paramInt3, boolean paramBoolean1, m.a parama, boolean paramBoolean2, int paramInt4)
  {
    AppMethodBeat.i(303391);
    paramString = com.tencent.mm.api.b.U(paramString, 1);
    Object localObject = g.Ybp;
    if (g.awm(1))
    {
      localObject = com.tencent.mm.pluginsdk.model.e.XQp;
      com.tencent.mm.pluginsdk.model.e.o(paramLong, paramInt1, paramv.url);
    }
    int i;
    if (paramBoolean2)
    {
      i = d.d.biz_time_line_cover_bottom_round_mask_bg;
      if (!paramBoolean2) {
        break label221;
      }
    }
    label221:
    for (int j = d.d.biz_time_line_cover_bottom_round_default_bg;; j = d.d.biz_time_line_cover_default_bg)
    {
      float f = com.tencent.mm.cd.a.fromDPToPix(this.vFF, 8);
      localObject = f.XQM;
      localObject = new com.tencent.mm.modelimage.loader.a.c.a();
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKE = j;
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKp = true;
      localObject = ((com.tencent.mm.modelimage.loader.a.c.a)localObject).eG(paramInt2, paramInt3);
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKG = String.valueOf(i);
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKe = new n(1);
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKN = new com.tencent.mm.pluginsdk.ui.applet.e(1);
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKO = new l();
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).fullPath = com.tencent.mm.pluginsdk.model.y.bpF(paramString);
      f.a(paramLong, paramInt1, paramv, paramString, paramImageView, paramInt4, paramBoolean1, ((com.tencent.mm.modelimage.loader.a.c.a)localObject).bKx(), new m(1, paramInt2, paramInt3, false, paramBoolean2, f, parama));
      AppMethodBeat.o(303391);
      return;
      i = 0;
      break;
    }
  }
  
  public final int deL()
  {
    AppMethodBeat.i(303398);
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.vtB;
    int i = com.tencent.mm.plugin.bizui.a.a.fK(this.vFF);
    int j = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGg;
    AppMethodBeat.o(303398);
    return i - j * 2;
  }
  
  public final void deM()
  {
    AppMethodBeat.i(6164);
    if (!deS())
    {
      AppMethodBeat.o(6164);
      return;
    }
    if ((this.vQA) || (this.vQB))
    {
      Log.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext loading %b, onPause %b", new Object[] { Boolean.valueOf(this.vQA), Boolean.valueOf(this.vQB) });
      AppMethodBeat.o(6164);
      return;
    }
    this.vQA = true;
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
        if ((d.deT()) && (!NetStatusUtil.isWifi(d.b(d.this))))
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
        ab localab = d.d(d.this);
        if (localab == null)
        {
          Log.v("MicroMsg.BizTimeLineImgLoader", "not loading");
          d.e(d.this);
          d.this.deP();
          AppMethodBeat.o(6155);
          return;
        }
        d.a(d.this, localab);
        AppMethodBeat.o(6155);
      }
    }, 500L);
    AppMethodBeat.o(6164);
  }
  
  public final ab deO()
  {
    AppMethodBeat.i(6172);
    try
    {
      if (this.vQy.size() > 0)
      {
        ab localab = (ab)this.vQy.get(this.vQy.size() - 1);
        AppMethodBeat.o(6172);
        return localab;
      }
    }
    finally
    {
      Log.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", new Object[] { localObject.getMessage() });
      AppMethodBeat.o(6172);
    }
    return null;
  }
  
  public final void deP()
  {
    AppMethodBeat.i(303421);
    if ((Util.isNullOrNil(this.vQz)) || (!this.vQC))
    {
      AppMethodBeat.o(303421);
      return;
    }
    deR();
    AppMethodBeat.o(303421);
  }
  
  public final int getContentWidth()
  {
    AppMethodBeat.i(6163);
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.vtB;
    int i = com.tencent.mm.plugin.bizui.a.a.fK(this.vFF);
    int j = com.tencent.mm.plugin.brandservice.ui.timeline.b.vGg;
    AppMethodBeat.o(6163);
    return i - j;
  }
  
  public final void onLoadMore()
  {
    AppMethodBeat.i(6171);
    if (!deS())
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
        ab localab = d.this.deO();
        if (localab == null)
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
            d.h(d.this).addAll(this.sEi);
            AppMethodBeat.o(6158);
          }
        });
        AppMethodBeat.o(6159);
      }
    }, 0L);
    AppMethodBeat.o(6171);
  }
  
  public final void y(long paramLong, int paramInt)
  {
    AppMethodBeat.i(6168);
    vQw.add(paramLong + "_" + paramInt);
    if (this.vQu <= 0) {
      deM();
    }
    AppMethodBeat.o(6168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.d
 * JD-Core Version:    0.7.0.1
 */