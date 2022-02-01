package com.tencent.mm.plugin.finder.upload;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Message;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.b.a.kk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.r.c;
import com.tencent.mm.plugin.finder.report.r.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.t;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.protocal.protobuf.ekn;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.videocomposition.n.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.a;
import kotlin.g.b.z.c;
import kotlin.g.b.z.d;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "checkProgressException", "", "localId", "", "isLongVideo", "", "isCancel", "checkVideoInfoMatch", "path", "", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "chooseMixType", "", "originAudio", "addAudio", "compositionToCropInfo", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "exportMedia", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "remuxComposition", "Lkotlin/Pair;", "", "startRemuxerTick", "index", "outputPath", "mediaReportObject", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;", "size", "remuxLongVideoComposition", "localMedia", "vcPerformanceStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "remuxNormalVideo", "videoWidth", "videoHeight", "width", "height", "bitrate", "localFinderMedia", "musicPath", "mixType", "isLongVideoAttachShort", "onUpdateProgress", "Lkotlin/Function1;", "rotateRect", "rotate", "saveFinderObject", "start", "uniqueId", "updateMedia", "reportObject", "audioQuality", "videoQuality", "updateProgress", "avgProgress", "Companion", "plugin-finder_release"})
public final class c
  extends j
{
  private static final String TAG = "Finder.LogPost.FinderMediaProcessTask";
  private static final MMHandler vRP;
  public static final a vRQ;
  FinderItem vRO;
  
  static
  {
    AppMethodBeat.i(167735);
    vRQ = new a((byte)0);
    TAG = "Finder.LogPost.FinderMediaProcessTask";
    MMHandler localMMHandler = new MMHandler(TAG + "#checkProgressExceptionHandler", (MMHandler.Callback)b.vRS);
    localMMHandler.setLogging(false);
    vRP = localMMHandler;
    AppMethodBeat.o(167735);
  }
  
  public c(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167734);
    this.vRO = paramFinderItem;
    AppMethodBeat.o(167734);
  }
  
  private final int a(final long paramLong, final int paramInt1, String paramString1, int paramInt2, int paramInt3, final int paramInt4, final int paramInt5, int paramInt6, final VideoTransPara paramVideoTransPara, final cjl paramcjl, final FinderMediaReportObject paramFinderMediaReportObject, String paramString2, int paramInt7, boolean paramBoolean1, final boolean paramBoolean2, final kk paramkk, kotlin.g.a.b<? super Float, kotlin.x> paramb)
  {
    AppMethodBeat.i(253058);
    final z.d locald = new z.d();
    locald.SYE = -1;
    final Object localObject4 = new Object();
    final z.a locala = new z.a();
    locala.SYB = false;
    for (;;)
    {
      try
      {
        Object localObject2 = paramcjl.url;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = paramcjl.uOR;
        if (localObject2 != null)
        {
          localObject3 = ((cjx)localObject2).Mpq;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = new erf();
        }
        localObject2 = a.a((erf)localObject2);
        int j = paramVideoTransPara.audioBitrate;
        int k = paramVideoTransPara.audioSampleRate;
        int m = paramVideoTransPara.audioChannelCount;
        int n = paramVideoTransPara.fps;
        Object localObject3 = paramcjl.uOR;
        if (localObject3 != null)
        {
          l1 = ((cjx)localObject3).dvv;
          localObject3 = paramcjl.uOR;
          if (localObject3 == null) {
            continue;
          }
          l2 = ((cjx)localObject3).iqg;
          if (w.fBu()) {
            break label533;
          }
          if (!w.fBw()) {
            continue;
          }
          localObject3 = paramcjl.uOR;
          if (localObject3 == null) {
            continue;
          }
          i = ((cjx)localObject3).retryCount;
          break label527;
          if (w.fBu()) {
            break label539;
          }
          if (!w.fBv()) {
            continue;
          }
          break label539;
          paramString1 = new com.tencent.mm.plugin.finder.video.n(paramString2, (String)localObject1, paramInt7, paramString1, (Rect)localObject2, paramInt4, paramInt5, paramInt6, j, k, m, n, l1, l2, bool1, bool2, paramVideoTransPara.iiH, (kotlin.g.a.b)new g(paramb), (kotlin.g.a.b)new h(this, paramcjl, paramkk, paramLong, paramBoolean1, locald, paramInt1, paramBoolean2, paramFinderMediaReportObject, paramInt4, paramInt5, paramVideoTransPara, localObject4, locala), paramInt2, paramInt3);
          paramString1.aMG();
        }
      }
      catch (Throwable paramString1)
      {
        long l1;
        long l2;
        Log.printErrStackTrace(TAG, paramString1, "create remuxer failed", new Object[0]);
        paramString1 = r.c.vhb;
        if ((paramBoolean1) || (paramBoolean2))
        {
          paramBoolean1 = true;
          r.c.nU(paramBoolean1);
          a(com.tencent.mm.loader.g.j.ibx);
          paramInt1 = locald.SYE;
          AppMethodBeat.o(253058);
          return paramInt1;
        }
        paramBoolean1 = false;
        continue;
      }
      try
      {
        if (!locala.SYB)
        {
          Log.i(TAG, "wait ".concat(String.valueOf(paramInt1)));
          localObject4.wait();
          Log.i(TAG, "notify " + paramInt1 + ", " + locald.SYE);
        }
        paramString1 = kotlin.x.SXb;
        paramInt1 = locald.SYE;
        AppMethodBeat.o(253058);
        return paramInt1;
      }
      finally
      {
        AppMethodBeat.o(253058);
      }
      l1 = 0L;
      continue;
      l2 = 0L;
      continue;
      int i = 0;
      break label527;
      boolean bool1 = false;
      continue;
      boolean bool2 = false;
      continue;
      label527:
      if (i >= 2)
      {
        label533:
        bool1 = true;
        continue;
        label539:
        bool2 = true;
      }
    }
  }
  
  private final kotlin.o<Integer, Float> a(final long paramLong, final int paramInt1, String paramString, final VideoTransPara paramVideoTransPara, final cjl paramcjl, final FinderMediaReportObject paramFinderMediaReportObject, final int paramInt2)
  {
    AppMethodBeat.i(253059);
    Log.i(TAG, "remuxComposition outputPath:".concat(String.valueOf(paramString)));
    Object localObject2 = paramcjl.MfU;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new acn();
    }
    p.g(localObject1, "media.videoCompositionInfo ?: CompositionInfo()");
    final z.d locald = new z.d();
    locald.SYE = -1;
    if (localObject1 != null)
    {
      localObject3 = ((acn)localObject1).Gxw;
      localObject2 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject2 = new aco();
    }
    ((aco)localObject2).rpE = paramString;
    boolean bool;
    final z.a locala;
    com.tencent.mm.plugin.vlog.model.f localf;
    if ((w.fBu()) || (w.fBv()))
    {
      bool = true;
      ((aco)localObject2).Lnr = bool;
      localObject3 = new Object();
      locala = new z.a();
      locala.SYB = false;
      localf = new com.tencent.mm.plugin.vlog.model.f();
      paramcjl = paramcjl.uOR;
      if (paramcjl == null) {
        break label401;
      }
    }
    label401:
    for (int i = paramcjl.retryCount;; i = 0)
    {
      localf.retryCount = i;
      localf.Gxj = true;
      paramcjl = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (com.tencent.mm.plugin.finder.storage.c.dqB()) {
        localf.r(paramVideoTransPara);
      }
      paramcjl = new z.c();
      paramcjl.SYD = 0.0F;
      localf.N((kotlin.g.a.b)new c(this, paramcjl, paramInt1, paramInt2));
      float f = localf.a((acn)localObject1, (kotlin.g.a.b)new d(this, locald, paramInt1, paramFinderMediaReportObject, paramLong, paramString, (aco)localObject2, paramVideoTransPara, (acn)localObject1, localObject3, locala));
      try
      {
        if (!locala.SYB)
        {
          Log.i(TAG, "wait ".concat(String.valueOf(paramInt1)));
          localObject3.wait();
          Log.i(TAG, "notify " + paramInt1 + ", " + locald.SYE);
        }
        paramString = kotlin.x.SXb;
        paramString = new kotlin.o(Integer.valueOf(locald.SYE), Float.valueOf(f));
        AppMethodBeat.o(253059);
        return paramString;
      }
      finally
      {
        AppMethodBeat.o(253059);
      }
      bool = false;
      break;
    }
  }
  
  private kotlin.o<Integer, Float> a(final long paramLong, VideoTransPara paramVideoTransPara, final cjl paramcjl, final String paramString, final FinderMediaReportObject paramFinderMediaReportObject, boolean paramBoolean, final int paramInt1, final int paramInt2, final kk paramkk)
  {
    AppMethodBeat.i(253060);
    p.h(paramVideoTransPara, "videoParams");
    p.h(paramcjl, "localMedia");
    p.h(paramString, "outputPath");
    p.h(paramFinderMediaReportObject, "mediaReportObject");
    p.h(paramkk, "vcPerformanceStruct");
    final Object localObject1 = r.c.vhb;
    r.c.nT(true);
    localObject1 = new Object();
    final z.a locala = new z.a();
    locala.SYB = false;
    Object localObject3 = paramcjl.url;
    if (localObject3 == null)
    {
      paramVideoTransPara = new kotlin.o(Integer.valueOf(-1000), Float.valueOf(0.0F));
      AppMethodBeat.o(253060);
      return paramVideoTransPara;
    }
    p.g(localObject3, "localMedia.url ?: return Pair(-1000, 0f)");
    Object localObject5 = paramcjl.uOR;
    if (localObject5 == null)
    {
      paramVideoTransPara = new kotlin.o(Integer.valueOf(-1001), Float.valueOf(0.0F));
      AppMethodBeat.o(253060);
      return paramVideoTransPara;
    }
    p.g(localObject5, "localMedia.cropInfo ?: return Pair(-1001, 0f)");
    Rect localRect = new Rect();
    paramcjl = new z.d();
    paramcjl.SYE = 0;
    final z.d locald = new z.d();
    locald.SYE = 0;
    int k = paramVideoTransPara.videoBitrate;
    Object localObject4 = MultiMediaVideoChecker.GyY.cA((String)localObject3, true);
    Object localObject6 = new ad((String)localObject3, 2);
    Object localObject2 = new ac(kotlin.a.j.listOf(localObject6));
    int j;
    int i;
    if (localObject4 != null)
    {
      j = ((MultiMediaVideoChecker.a)localObject4).width;
      i = ((MultiMediaVideoChecker.a)localObject4).height;
      if ((((MultiMediaVideoChecker.a)localObject4).dYT == 90) || (((MultiMediaVideoChecker.a)localObject4).dYT == 270))
      {
        j = ((MultiMediaVideoChecker.a)localObject4).height;
        i = ((MultiMediaVideoChecker.a)localObject4).width;
      }
      ((ad)localObject6).Gzx.rwL.set(0, 0, j, i);
      ((ac)localObject2).jt(j, i);
      localRect.set(0, 0, j, i);
      localObject6 = paramFinderMediaReportObject.origin;
      if (localObject6 != null) {
        ((FinderMediaReportInfo)localObject6).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject4).duration);
      }
      localObject6 = paramFinderMediaReportObject.origin;
      if (localObject6 != null) {
        ((FinderMediaReportInfo)localObject6).width = ((MultiMediaVideoChecker.a)localObject4).width;
      }
      localObject6 = paramFinderMediaReportObject.origin;
      if (localObject6 != null) {
        ((FinderMediaReportInfo)localObject6).height = ((MultiMediaVideoChecker.a)localObject4).height;
      }
      localObject6 = paramFinderMediaReportObject.origin;
      if (localObject6 != null) {
        ((FinderMediaReportInfo)localObject6).videoBitrate = ((MultiMediaVideoChecker.a)localObject4).bitrate;
      }
      localObject6 = paramFinderMediaReportObject.origin;
      if (localObject6 != null) {
        ((FinderMediaReportInfo)localObject6).audioBitrate = ((MultiMediaVideoChecker.a)localObject4).audioBitrate;
      }
      localObject6 = paramFinderMediaReportObject.origin;
      if (localObject6 != null) {
        ((FinderMediaReportInfo)localObject6).fps = ((int)((MultiMediaVideoChecker.a)localObject4).cKu);
      }
      localObject6 = kotlin.x.SXb;
    }
    localObject6 = ((cjx)localObject5).Mpq;
    if (localObject6 != null)
    {
      if (paramBoolean)
      {
        localRect.set(((erf)localObject6).left, ((erf)localObject6).bottom, ((erf)localObject6).right, ((erf)localObject6).top);
        localObject6 = kotlin.x.SXb;
      }
    }
    else
    {
      if (!paramBoolean) {
        break label1201;
      }
      i = ((cjx)localObject5).width;
      label541:
      paramcjl.SYE = i;
      if (!paramBoolean) {
        break label1219;
      }
      i = ((cjx)localObject5).height;
      label560:
      locald.SYE = i;
      ((ac)localObject2).at(((cjx)localObject5).dvv, ((cjx)localObject5).iqg);
      ((ac)localObject2).q(localRect);
      localObject3 = a.a((String)localObject3, paramcjl.SYE, locald.SYE, ((cjx)localObject5).iqg / 1000.0F, 0.0F, paramVideoTransPara, paramBoolean);
      if ((((c.a.a)localObject3).errCode != 0) || (((c.a.a)localObject3).width <= 0) || (((c.a.a)localObject3).height <= 0) || (((c.a.a)localObject3).bitrate <= 0)) {
        break label1263;
      }
      paramcjl.SYE = ((c.a.a)localObject3).width;
      locald.SYE = ((c.a.a)localObject3).height;
      i = ((c.a.a)localObject3).bitrate;
      Log.i(TAG, "video abaResult, width:" + paramcjl.SYE + ", height:" + locald.SYE + ", " + i);
    }
    for (;;)
    {
      float f;
      if (localObject4 != null)
      {
        f = ((MultiMediaVideoChecker.a)localObject4).cKu;
        label745:
        if ((f >= 0.0F) && (f <= paramVideoTransPara.fps)) {
          break label1243;
        }
      }
      label1201:
      label1219:
      label1243:
      for (j = paramVideoTransPara.fps;; j = (int)f)
      {
        localObject4 = new n.b(new Size(paramcjl.SYE, locald.SYE), i, j, paramVideoTransPara.iiH, paramVideoTransPara.audioBitrate, paramVideoTransPara.audioSampleRate, paramVideoTransPara.audioChannelCount);
        localObject5 = new z.c();
        ((z.c)localObject5).SYD = 0.0F;
        localObject3 = new z.d();
        ((z.d)localObject3).SYE = -1;
        final long l = Util.currentTicks();
        localObject2 = ((ac)localObject2).getComposition();
        ((com.tencent.mm.videocomposition.n)localObject2).a(paramString, (n.b)localObject4, (kotlin.g.a.m)new e(this, paramkk, (n.b)localObject4, l, paramBoolean, Util.ticksToNow(l), paramString, (com.tencent.mm.videocomposition.n)localObject2, (z.d)localObject3, paramFinderMediaReportObject, paramLong, paramcjl, locald, paramVideoTransPara, localObject1, locala), (kotlin.g.a.b)new f(this, (z.c)localObject5, paramInt1, paramInt2));
        try
        {
          if (!locala.SYB)
          {
            Log.i(TAG, "wait longvideo");
            localObject1.wait();
            Log.i(TAG, "notify longvideo, " + ((z.d)localObject3).SYE);
          }
          paramVideoTransPara = kotlin.x.SXb;
          paramVideoTransPara = new kotlin.o(Integer.valueOf(((z.d)localObject3).SYE), Float.valueOf(0.0F));
          AppMethodBeat.o(253060);
          return paramVideoTransPara;
        }
        finally
        {
          Object localObject7;
          Object localObject8;
          double d2;
          double d1;
          int m;
          int n;
          AppMethodBeat.o(253060);
        }
        localObject7 = ((cjx)localObject5).Mpr;
        if (localObject7 == null) {
          break;
        }
        localObject8 = ((bej)localObject7).LOe;
        if (localObject8 == null) {
          break;
        }
        localObject7 = new Matrix();
        ((Matrix)localObject7).setValues(kotlin.a.j.t((Collection)localObject8));
        localObject8 = kotlin.x.SXb;
        d2 = t.e((Matrix)localObject7);
        d1 = d2;
        if (d2 <= 0.0D) {
          d1 = 1.0D;
        }
        localObject7 = y.vXH;
        i = y.Lt((int)Math.floor((((erf)localObject6).top - ((erf)localObject6).bottom) / d1));
        localObject7 = y.vXH;
        j = y.Lt((int)Math.floor((((erf)localObject6).right - ((erf)localObject6).left) / d1));
        m = (int)Math.floor(((erf)localObject6).left / d1);
        n = (int)Math.floor(((erf)localObject6).bottom / d1);
        localRect.set(m, n, m + j, i + n);
        localObject6 = kotlin.x.SXb;
        break;
        localObject6 = y.vXH;
        i = y.Lt(((cjx)localObject5).width);
        break label541;
        localObject6 = y.vXH;
        i = y.Lt(((cjx)localObject5).height);
        break label560;
        f = 0.0F;
        break label745;
      }
      label1263:
      i = k;
    }
  }
  
  private static void a(VideoTransPara paramVideoTransPara, cjl paramcjl1, String paramString, cjl paramcjl2, int paramInt, FinderMediaReportObject paramFinderMediaReportObject, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(253061);
    p.h(paramVideoTransPara, "videoParams");
    p.h(paramcjl1, "localMedia");
    p.h(paramString, "outputPath");
    p.h(paramcjl2, "media");
    p.h(paramFinderMediaReportObject, "reportObject");
    localObject1 = y.vXH;
    localObject1 = y.awl(paramString);
    if (localObject1 != null)
    {
      paramcjl1.width = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
      paramcjl1.height = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
      paramcjl2.width = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
      paramcjl2.height = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
    }
    i = paramVideoTransPara.iTf;
    j = (int)(paramcjl1.height / paramcjl1.width * i);
    localObject1 = f.vSz.ag(paramString, i, j);
    Object localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (com.tencent.mm.plugin.finder.storage.c.dtU()) {
      localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    }
    for (i = AdaptiveAdjustBitrate.getVideoImageQuality(com.tencent.mm.plugin.finder.storage.c.dqC(), 0, i, j, 0.8F);; i = 0)
    {
      paramcjl2.MoZ = paramFinderMediaReportObject;
      paramcjl2.url = paramString;
      paramcjl2.thumbUrl = ((String)localObject1);
      if ((!paramBoolean) && (!paramcjl1.MoY))
      {
        paramFinderMediaReportObject = paramcjl2.MoU;
        if (paramFinderMediaReportObject == null) {}
      }
      try
      {
        localObject2 = paramcjl1.MfU;
        if (localObject2 != null)
        {
          localObject2 = ((acn)localObject2).Gxw;
          if (localObject2 != null)
          {
            float f1 = paramcjl2.width / ((aco)localObject2).xlg;
            float f2 = paramcjl2.height / ((aco)localObject2).xlh;
            paramFinderMediaReportObject = new Rect((int)(paramFinderMediaReportObject.left * f1), (int)(paramFinderMediaReportObject.top * f2), (int)(f1 * paramFinderMediaReportObject.right), (int)(paramFinderMediaReportObject.bottom * f2));
            j = paramVideoTransPara.iTf;
            int k = (int)(paramFinderMediaReportObject.height() / paramFinderMediaReportObject.width() * j);
            paramVideoTransPara = al.waC;
            paramVideoTransPara = al.awE(paramString);
            localObject2 = f.vSz;
            paramcjl2.thumbUrl = f.a(paramString, paramVideoTransPara, j, k, new Rect(paramFinderMediaReportObject.left, paramFinderMediaReportObject.bottom, paramFinderMediaReportObject.right, paramFinderMediaReportObject.top));
            paramcjl2.MoR = ((String)localObject1);
            paramVideoTransPara = kotlin.x.SXb;
          }
        }
      }
      catch (Exception paramVideoTransPara)
      {
        for (;;)
        {
          Log.e(TAG, "crop halfThumb from " + (String)localObject1 + " fail:" + paramVideoTransPara.getLocalizedMessage());
          paramVideoTransPara = kotlin.x.SXb;
          continue;
          j = 0;
          continue;
          i = 0;
          continue;
          paramBoolean = false;
          continue;
          paramVideoTransPara = null;
        }
      }
      paramcjl2.MoO = false;
      paramcjl2.mediaId = MD5Util.getMD5String(paramcjl1.url);
      paramcjl2.fileSize = ((int)com.tencent.mm.vfs.s.boW(paramString));
      paramVideoTransPara = paramcjl2.MoZ;
      if (paramVideoTransPara != null) {
        paramVideoTransPara.target = new FinderMediaReportInfo();
      }
      paramVideoTransPara = paramcjl2.MoZ;
      if (paramVideoTransPara != null)
      {
        paramVideoTransPara = paramVideoTransPara.target;
        if (paramVideoTransPara != null) {
          paramVideoTransPara.fileSize = paramcjl2.fileSize;
        }
      }
      paramVideoTransPara = paramcjl2.MoZ;
      if (paramVideoTransPara != null)
      {
        paramFinderMediaReportObject = paramcjl2.MoZ;
        if (paramFinderMediaReportObject == null) {
          break;
        }
        paramFinderMediaReportObject = paramFinderMediaReportObject.target;
        if (paramFinderMediaReportObject == null) {
          break;
        }
        j = paramFinderMediaReportObject.fileSize;
        paramVideoTransPara.videoFinalSize = j;
      }
      paramVideoTransPara = paramcjl2.MfU;
      if (paramVideoTransPara != null) {
        paramVideoTransPara.Lng = false;
      }
      if (paramcjl2.codec_info == null) {
        paramcjl2.codec_info = new ayg();
      }
      paramVideoTransPara = paramcjl2.codec_info;
      if (paramVideoTransPara != null)
      {
        paramVideoTransPara.LIt = paramFloat2;
        paramVideoTransPara.LIv = paramFloat1;
        paramVideoTransPara.LIw = i;
        paramFinderMediaReportObject = paramcjl2.MfU;
        if (paramFinderMediaReportObject == null) {
          break label1129;
        }
        paramFinderMediaReportObject = paramFinderMediaReportObject.Gxx;
        if (paramFinderMediaReportObject == null) {
          break label1129;
        }
        paramFinderMediaReportObject = paramFinderMediaReportObject.Lna;
        if (paramFinderMediaReportObject == null) {
          break label1129;
        }
        i = paramFinderMediaReportObject.size();
        if (i <= 0) {
          break label1135;
        }
        paramBoolean = true;
        paramVideoTransPara.LIy = paramBoolean;
        Log.i(TAG, "codec_info video_score:" + paramVideoTransPara.LIt + ",video_cover_score:" + paramVideoTransPara.LIu + ",video_audio_score:" + paramVideoTransPara.LIv + ",thumb_score:" + paramVideoTransPara.LIw + ",hdimg_score:" + paramVideoTransPara.LIx + ",has_stickers:" + paramVideoTransPara.LIy);
      }
      paramVideoTransPara = paramcjl2.MoZ;
      if (paramVideoTransPara == null) {
        break label1141;
      }
      paramVideoTransPara = paramVideoTransPara.codecInfo;
      if (paramVideoTransPara == null)
      {
        paramVideoTransPara = paramcjl2.MoZ;
        if (paramVideoTransPara != null) {
          paramVideoTransPara.codecInfo = paramcjl2.codec_info;
        }
      }
      paramVideoTransPara = MultiMediaVideoChecker.GyY.aTV(paramString);
      if (paramVideoTransPara != null)
      {
        paramcjl2.videoDuration = kotlin.h.a.cR((float)paramVideoTransPara.duration / 1000.0F);
        paramFinderMediaReportObject = paramcjl2.MoZ;
        if (paramFinderMediaReportObject != null)
        {
          paramFinderMediaReportObject = paramFinderMediaReportObject.target;
          if (paramFinderMediaReportObject != null) {
            paramFinderMediaReportObject.videoDuration = ((int)paramVideoTransPara.duration);
          }
        }
        paramFinderMediaReportObject = paramcjl2.MoZ;
        if (paramFinderMediaReportObject != null)
        {
          paramFinderMediaReportObject = paramFinderMediaReportObject.target;
          if (paramFinderMediaReportObject != null) {
            paramFinderMediaReportObject.width = paramVideoTransPara.width;
          }
        }
        paramFinderMediaReportObject = paramcjl2.MoZ;
        if (paramFinderMediaReportObject != null)
        {
          paramFinderMediaReportObject = paramFinderMediaReportObject.target;
          if (paramFinderMediaReportObject != null) {
            paramFinderMediaReportObject.height = paramVideoTransPara.height;
          }
        }
        paramFinderMediaReportObject = paramcjl2.MoZ;
        if (paramFinderMediaReportObject != null)
        {
          paramFinderMediaReportObject = paramFinderMediaReportObject.target;
          if (paramFinderMediaReportObject != null) {
            paramFinderMediaReportObject.videoBitrate = paramVideoTransPara.bitrate;
          }
        }
        paramFinderMediaReportObject = paramcjl2.MoZ;
        if (paramFinderMediaReportObject != null)
        {
          paramFinderMediaReportObject = paramFinderMediaReportObject.target;
          if (paramFinderMediaReportObject != null) {
            paramFinderMediaReportObject.audioBitrate = paramVideoTransPara.audioBitrate;
          }
        }
        paramcjl2 = paramcjl2.MoZ;
        if (paramcjl2 != null)
        {
          paramcjl2 = paramcjl2.target;
          if (paramcjl2 != null) {
            paramcjl2.fps = ((int)paramVideoTransPara.cKu);
          }
        }
      }
      Log.i(TAG, "processList index " + paramInt + " url " + paramcjl1.url + " thumbUrl: " + paramcjl1.thumbUrl + " newMd5: " + MD5Util.getMD5String(paramcjl1.url) + " size:" + Util.getSizeKB(com.tencent.mm.vfs.s.boW(paramcjl1.url)));
      paramVideoTransPara = com.tencent.mm.plugin.vlog.model.m.Gyi;
      com.tencent.mm.plugin.vlog.model.m.l(paramString, paramFloat2);
      paramVideoTransPara = com.tencent.mm.plugin.vlog.model.m.Gyi;
      com.tencent.mm.plugin.vlog.model.m.fBf();
      AppMethodBeat.o(253061);
      return;
    }
  }
  
  private final void dAR()
  {
    AppMethodBeat.i(253057);
    com.tencent.mm.plugin.finder.storage.logic.c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
    com.tencent.mm.plugin.finder.storage.logic.c.a.r(this.vRO);
    AppMethodBeat.o(253057);
  }
  
  public final String auK()
  {
    AppMethodBeat.i(167732);
    long l = this.vRO.getLocalId();
    AppMethodBeat.o(167732);
    return String.valueOf(l);
  }
  
  public final void bi(float paramFloat)
  {
    AppMethodBeat.i(167733);
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    int i = (int)(com.tencent.mm.plugin.finder.storage.c.drd() * f);
    Log.i(TAG, "feed " + this.vRO.getLocalId() + " updateProgress  " + f + ", " + i);
    if (this.vRO.getPostInfo().Mpc < i)
    {
      this.vRO.getPostInfo().Mpc = i;
      localObject = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
      com.tencent.mm.plugin.finder.storage.logic.c.a.r(this.vRO);
    }
    localObject = EventCenter.instance;
    hk localhk = new hk();
    localhk.dLT.localId = this.vRO.getLocalId();
    localhk.dLT.progress = this.vRO.getPostInfo().Mpc;
    ((EventCenter)localObject).publish((IEvent)localhk);
    AppMethodBeat.o(167733);
  }
  
  public final void start()
  {
    AppMethodBeat.i(253056);
    this.vRO.trackPost("mediaProcess");
    Object localObject1 = this.vRO.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 2;
    }
    final List localList1 = (List)new ArrayList();
    final List localList2 = (List)new ArrayList();
    localObject1 = ((Iterable)this.vRO.getHalfVideoMediaExtList()).iterator();
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (cjl)((Iterator)localObject1).next();
      localObject5 = ((cjl)localObject4).MfU;
      if ((localObject5 != null) && (((acn)localObject5).Lng == true)) {
        localList1.add(localObject4);
      }
    }
    localObject1 = (Iterable)this.vRO.getMediaList();
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    int j;
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = ((Iterator)localObject1).next();
      j = i + 1;
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject4 = (cjl)localObject4;
      if (this.vRO.isNeedCrop(i))
      {
        if (this.vRO.getCropInfo(i) != null) {
          localList1.add(localObject4);
        }
        i = j;
      }
      else
      {
        if ((this.vRO.isNeedVideoCompositionPlay(i)) && (this.vRO.getCropInfo(i) != null)) {
          localList1.add(localObject4);
        }
        i = j;
      }
    }
    localObject1 = (Iterable)this.vRO.getLongVideoMediaExtList();
    i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject4 = (cjl)localObject4;
      if ((((cjl)localObject4).MoO) && (((cjl)localObject4).uOR != null))
      {
        localList1.add(localObject4);
        localList2.add(localObject4);
      }
      i += 1;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    if ((com.tencent.mm.plugin.finder.storage.c.drf()) && (Log.getLogLevel() >= 0))
    {
      Log.i(TAG, "debug blocking, sleep.....");
      Thread.sleep(30000L);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dra().value()).intValue() == 1)
    {
      a(com.tencent.mm.loader.g.j.ibx);
      AppMethodBeat.o(253056);
      return;
    }
    if (localList1.size() <= 0)
    {
      Log.i(TAG, "nothing need to be processed");
      bi(1.0F);
      a(com.tencent.mm.loader.g.j.ibw);
      AppMethodBeat.o(253056);
      return;
    }
    Log.i(TAG, "process media count " + localList1.size());
    localObject1 = r.d.vhx;
    r.d.oe(this.vRO.isLongVideo());
    localObject1 = (Iterable)localList1;
    final int k = 0;
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int m;
    cjl localcjl;
    label688:
    boolean bool2;
    label696:
    label717:
    boolean bool3;
    label725:
    label740:
    boolean bool7;
    FinderMediaReportObject localFinderMediaReportObject;
    Object localObject7;
    Object localObject6;
    label1148:
    String str1;
    label1154:
    label1160:
    label1166:
    label1179:
    label1190:
    kk localkk;
    long l;
    label1278:
    String str2;
    int n;
    int i1;
    label1325:
    int i2;
    label1382:
    boolean bool6;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      m = k + 1;
      if (k < 0) {
        kotlin.a.j.hxH();
      }
      localcjl = (cjl)localObject1;
      localObject1 = localcjl.uOR;
      if (localObject1 != null) {}
      for (i = ((cjx)localObject1).retryCount;; i = 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (i <= com.tencent.mm.plugin.finder.storage.c.drb()) {
          break;
        }
        a(com.tencent.mm.loader.g.j.ibx);
        AppMethodBeat.o(253056);
        return;
      }
      localObject1 = localList2.iterator();
      i = 0;
      if (((Iterator)localObject1).hasNext()) {
        if (p.j(((cjl)((Iterator)localObject1).next()).mediaId, localcjl.mediaId))
        {
          if (i < 0) {
            break label1148;
          }
          bool2 = true;
          if (bool2) {
            break label1160;
          }
          if (((Collection)localList2).isEmpty()) {
            break label1154;
          }
          i = 1;
          if (i == 0) {
            break label1160;
          }
          bool3 = true;
          if (!bool2) {
            break label1166;
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
          localObject4 = com.tencent.mm.plugin.finder.storage.c.dqy();
          Log.i(TAG, "FinderMediaProcessTask index " + k + " isLongVideo:" + bool2 + " videoParams " + localObject4);
          localObject1 = localcjl.uOR;
          if (localObject1 != null)
          {
            localObject5 = localcjl.uOR;
            if (localObject5 == null) {
              break label1179;
            }
          }
        }
      }
      for (i = ((cjx)localObject5).retryCount;; i = 0)
      {
        ((cjx)localObject1).retryCount = (i + 1);
        if (bool2)
        {
          localObject1 = this.vRO.field_reportObject;
          if (localObject1 != null) {
            ((FinderFeedReportObject)localObject1).postStage = 6;
          }
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        com.tencent.mm.plugin.finder.storage.logic.c.a.r(this.vRO);
        localObject1 = y.vXH;
        bool7 = y.h(localcjl);
        localFinderMediaReportObject = new FinderMediaReportObject();
        localFinderMediaReportObject.mediaType = localcjl.mediaType;
        localFinderMediaReportObject.origin = new FinderMediaReportInfo();
        localFinderMediaReportObject.multiMediaInfo = new LinkedList();
        localObject1 = localcjl.MfU;
        if (localObject1 == null) {
          break label1190;
        }
        localObject1 = ((acn)localObject1).Lnd;
        if (localObject1 == null) {
          break label1190;
        }
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject7 = (ejf)((Iterator)localObject1).next();
          localObject5 = new FinderMediaReportInfo();
          ((FinderMediaReportInfo)localObject5).fileSize = ((int)com.tencent.mm.vfs.s.boW(((ejf)localObject7).path));
          localObject6 = MultiMediaVideoChecker.GyY;
          localObject7 = ((ejf)localObject7).path;
          p.g(localObject7, "track.path");
          localObject6 = ((MultiMediaVideoChecker)localObject6).aTV((String)localObject7);
          if (localObject6 != null)
          {
            ((FinderMediaReportInfo)localObject5).width = ((MultiMediaVideoChecker.a)localObject6).width;
            ((FinderMediaReportInfo)localObject5).height = ((MultiMediaVideoChecker.a)localObject6).height;
            ((FinderMediaReportInfo)localObject5).videoBitrate = ((MultiMediaVideoChecker.a)localObject6).bitrate;
            ((FinderMediaReportInfo)localObject5).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject6).duration);
            ((FinderMediaReportInfo)localObject5).audioBitrate = ((MultiMediaVideoChecker.a)localObject6).audioBitrate;
            ((FinderMediaReportInfo)localObject5).fps = ((int)((MultiMediaVideoChecker.a)localObject6).cKu);
            Log.i(TAG, "put multiMediaInfo:".concat(String.valueOf(localObject6)));
            localObject6 = kotlin.x.SXb;
          }
          localFinderMediaReportObject.multiMediaInfo.add(localObject5);
        }
        i += 1;
        break;
        i = -1;
        break label688;
        bool2 = false;
        break label696;
        i = 0;
        break label717;
        bool3 = false;
        break label725;
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        localObject4 = com.tencent.mm.plugin.finder.storage.c.dqx();
        break label740;
      }
      localObject1 = kotlin.x.SXb;
      str1 = UUID.randomUUID().toString();
      p.g(str1, "UUID.randomUUID().toString()");
      localObject1 = com.tencent.mm.plugin.vlog.report.b.GDm;
      localkk = com.tencent.mm.plugin.vlog.report.b.aUh(str1);
      l = Util.currentTicks();
      localObject5 = new com.tencent.mm.plugin.finder.loader.s(localcjl, com.tencent.mm.plugin.finder.storage.x.vEA, 0, null, 12);
      localObject1 = al.waC;
      localObject6 = new StringBuilder().append(this.vRO.getCreateTime());
      if (localcjl.MoY)
      {
        localObject1 = "_half";
        str2 = al.a((com.tencent.mm.plugin.finder.loader.s)localObject5, (String)localObject1);
        localObject6 = null;
        n = 1;
        i1 = 2;
        localObject1 = com.tencent.mm.plugin.vlog.model.m.Gyi;
        if (!com.tencent.mm.plugin.vlog.model.m.fAU()) {
          break label2898;
        }
        localObject1 = com.tencent.mm.plugin.vlog.model.m.Gyi;
        i = com.tencent.mm.plugin.vlog.model.m.fAW();
        i2 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smw, 1);
        localObject1 = localcjl.MfU;
        if (localObject1 == null) {
          break label2921;
        }
        localObject1 = ((acn)localObject1).Lnd;
        if (localObject1 == null) {
          break label2921;
        }
        localObject1 = (ejf)kotlin.a.j.kt((List)localObject1);
        localObject5 = localcjl.MfU;
        if (localObject5 == null) {
          break label2951;
        }
        localObject5 = ((acn)localObject5).Lnd;
        if ((localObject5 == null) || (((LinkedList)localObject5).size() != 1)) {
          break label2951;
        }
        localObject5 = localcjl.MfU;
        if (localObject5 == null) {
          break label2927;
        }
        localObject5 = ((acn)localObject5).Gxx;
        if (localObject5 == null) {
          break label2927;
        }
        localObject5 = ((acm)localObject5).Lna;
        if (localObject5 == null) {
          break label2927;
        }
        j = ((LinkedList)localObject5).size();
        label1458:
        if (j != 0) {
          break label2951;
        }
        localObject5 = localcjl.MfU;
        if ((localObject5 == null) || (((acn)localObject5).Gzp)) {
          break label2951;
        }
        localObject5 = localcjl.MfU;
        if (localObject5 == null) {
          break label2933;
        }
        localObject5 = ((acn)localObject5).Lni;
        label1502:
        if ((localObject5 != null) || (localObject1 == null)) {
          break label2951;
        }
        if (((ejf)localObject1).NiQ != null)
        {
          localObject5 = ((ejf)localObject1).NiQ;
          if (localObject5 == null) {
            break label2939;
          }
          localObject5 = ((ekn)localObject5).path;
          label1539:
          localObject5 = (CharSequence)localObject5;
          if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
            break label2945;
          }
          j = 1;
          label1564:
          if (j == 0) {
            break label2951;
          }
        }
        if (((ejf)localObject1).endTimeMs - ((ejf)localObject1).startTimeMs != ((ejf)localObject1).GGA - ((ejf)localObject1).GGz) {
          break label2951;
        }
        bool6 = true;
        label1598:
        localObject5 = TAG;
        localObject7 = new StringBuilder("process: config: ").append(i).append(", checkNoNeedRemux:").append(i2).append(", trackSize: ");
        localObject1 = localcjl.MfU;
        if (localObject1 == null) {
          break label2957;
        }
        localObject1 = ((acn)localObject1).Lnd;
        if (localObject1 == null) {
          break label2957;
        }
        localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
        label1671:
        localObject7 = ((StringBuilder)localObject7).append(localObject1).append(", editSize: ");
        localObject1 = localcjl.MfU;
        if (localObject1 == null) {
          break label2963;
        }
        localObject1 = ((acn)localObject1).Gxx;
        if (localObject1 == null) {
          break label2963;
        }
        localObject1 = ((acm)localObject1).Lna;
        if (localObject1 == null) {
          break label2963;
        }
        localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
        label1732:
        Log.i((String)localObject5, localObject1 + ", videoIsNoEffect:" + bool6);
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgM, 0) != 1) {
          break label7315;
        }
      }
    }
    label2190:
    label7312:
    label7315:
    for (boolean bool4 = true;; bool4 = false)
    {
      float f3 = ((VideoTransPara)localObject4).audioBitrate / 1000.0F;
      float f4 = ((VideoTransPara)localObject4).audioSampleRate;
      int i8 = ((VideoTransPara)localObject4).audioChannelCount;
      localObject1 = localcjl.MfU;
      boolean bool5;
      label1829:
      float f2;
      float f1;
      if (localObject1 != null)
      {
        bool5 = ((acn)localObject1).Gzo;
        f2 = 0.0F;
        f1 = f2;
        j = i1;
        if (i2 == 1)
        {
          f1 = f2;
          j = i1;
          if (bool6)
          {
            localObject1 = localcjl.MfU;
            if (localObject1 != null)
            {
              localObject1 = ((acn)localObject1).Lnd;
              if (localObject1 != null)
              {
                localObject1 = (ejf)((LinkedList)localObject1).get(0);
                if (localObject1 != null) {
                  break label7312;
                }
              }
            }
            localObject1 = new ejf();
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          p.g(localObject1, "it.videoCompositionInfo?…et(0) ?: TrackInfoProto()");
          localObject5 = ((ejf)localObject1).path;
          p.g(localObject5, "track.path");
          localObject5 = MultiMediaVideoChecker.GyY.aTV((String)localObject5);
          label1972:
          label2004:
          Object localObject8;
          Object localObject9;
          boolean bool1;
          if (localObject5 != null) {
            if ((((MultiMediaVideoChecker.a)localObject5).dYT == 90) || (((MultiMediaVideoChecker.a)localObject5).dYT == 270))
            {
              j = ((MultiMediaVideoChecker.a)localObject5).height;
              double d = j;
              if ((((MultiMediaVideoChecker.a)localObject5).dYT != 90) && (((MultiMediaVideoChecker.a)localObject5).dYT != 270)) {
                break label2985;
              }
              j = ((MultiMediaVideoChecker.a)localObject5).width;
              d = 1.0D * d / j;
              Log.i(TAG, "origin videoInfo:" + localObject5 + ", videoParams:" + localObject4 + ", videoRatio:" + d);
              localObject7 = TAG;
              localObject8 = new StringBuilder("videoRatio in range:");
              localObject9 = com.tencent.mm.plugin.finder.storage.c.vCb;
              localObject8 = ((StringBuilder)localObject8).append(com.tencent.mm.plugin.finder.storage.c.dsn().contains((Comparable)Double.valueOf(d))).append(", finderVideoRatioRange:");
              localObject9 = com.tencent.mm.plugin.finder.storage.c.vCb;
              Log.i((String)localObject7, com.tencent.mm.plugin.finder.storage.c.dsn());
              if ((((MultiMediaVideoChecker.a)localObject5).zzJ) || (((MultiMediaVideoChecker.a)localObject5).bitrate > ((VideoTransPara)localObject4).videoBitrate) || (((MultiMediaVideoChecker.a)localObject5).cKu > ((VideoTransPara)localObject4).fps)) {
                break label2995;
              }
              localObject5 = com.tencent.mm.plugin.finder.storage.c.vCb;
              if (!com.tencent.mm.plugin.finder.storage.c.dsn().contains((Comparable)Double.valueOf(d))) {
                break label2995;
              }
              bool1 = true;
              localObject5 = localcjl.MfU;
              if (localObject5 == null) {
                break label3007;
              }
              localObject5 = ((acn)localObject5).iiv;
              label2209:
              boolean bool8 = Util.isNullOrNil((String)localObject5);
              Log.i(TAG, "isVideoSizeMatch:" + bool1 + "， noMusic:" + bool8);
              f1 = f2;
              j = i1;
              if (bool1)
              {
                f1 = f2;
                j = i1;
                if (bool8)
                {
                  localObject5 = new Rect();
                  localObject7 = new Rect();
                  localObject8 = ((ejf)localObject1).NiP.LpR;
                  p.g(localObject8, "track.cropInfo.cropRect");
                  com.tencent.mm.plugin.vlog.model.i.a((dlh)localObject8, (Rect)localObject5);
                  localObject8 = ((ejf)localObject1).NiP.LpT;
                  p.g(localObject8, "track.cropInfo.contentRect");
                  com.tencent.mm.plugin.vlog.model.i.a((dlh)localObject8, (Rect)localObject7);
                  Log.i(TAG, "cropRect:" + localObject5 + ", contentRect:" + localObject7 + ", track:[" + ((ejf)localObject1).GGz + ", " + ((ejf)localObject1).GGA + ", " + ((ejf)localObject1).GJB + ']');
                  f1 = f2;
                  j = i1;
                  if (((ejf)localObject1).GGz == 0L)
                  {
                    f1 = f2;
                    j = i1;
                    if (((ejf)localObject1).GJB - ((ejf)localObject1).GGA <= 10L)
                    {
                      f1 = f2;
                      j = i1;
                      if (((ejf)localObject1).GJB <= ((VideoTransPara)localObject4).duration * 1000)
                      {
                        f1 = f2;
                        j = i1;
                        if (p.j(localObject5, localObject7))
                        {
                          Log.i(TAG, "no need remux!!!");
                          j = 3;
                          com.tencent.mm.vfs.s.nw(((ejf)localObject1).path, str2);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          try
          {
            localObject1 = AdaptiveAdjustBitrate.a(str2, ((ejf)localObject1).Gzu, ((ejf)localObject1).Gzv, ((VideoTransPara)localObject4).fps, ((VideoTransPara)localObject4).videoBitrate, (float)((ejf)localObject1).GJB / 1000.0F, ((VideoTransPara)localObject4).iTi, ((VideoTransPara)localObject4).iTj, ((VideoTransPara)localObject4).iTm, ((VideoTransPara)localObject4).iTn);
            if ((localObject1 != null) && (localObject1.length >= 28))
            {
              i1 = localObject1[27];
              f1 = i1;
            }
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              try
              {
                SightVideoJNI.addReportMetadata(str2, null, ((VideoTransPara)localObject4).iTg, 0);
                localObject1 = r.c.vhb;
                if ((bool2) || (bool3))
                {
                  bool1 = true;
                  r.c.nW(bool1);
                  if (j == 3) {
                    continue;
                  }
                  localObject1 = localcjl.MfU;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((acn)localObject1).Lnd;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject5 = (ejf)((LinkedList)localObject1).get(0);
                  if ((!bool6) || (localObject5 == null)) {
                    continue;
                  }
                  localObject1 = new Rect();
                  localObject7 = new Rect();
                  localObject8 = ((ejf)localObject5).NiP.LpR;
                  p.g(localObject8, "track.cropInfo.cropRect");
                  com.tencent.mm.plugin.vlog.model.i.a((dlh)localObject8, (Rect)localObject1);
                  localObject8 = ((ejf)localObject5).NiP.LpT;
                  p.g(localObject8, "track.cropInfo.contentRect");
                  com.tencent.mm.plugin.vlog.model.i.a((dlh)localObject8, (Rect)localObject7);
                  bool1 = ((Rect)localObject7).contains((Rect)localObject1);
                  Log.i(TAG, "process: crop: " + localObject1 + ", content: " + localObject7);
                  if ((!bool2) && (!bool3)) {
                    continue;
                  }
                  if (i == 1) {
                    continue;
                  }
                  if (((Number)a(l, (VideoTransPara)localObject4, localcjl, str2, localFinderMediaReportObject, bool2, k, localList1.size(), localkk).first).intValue() >= 0) {
                    continue;
                  }
                  localObject1 = com.tencent.mm.plugin.vlog.report.b.GDm;
                  com.tencent.mm.plugin.vlog.report.b.aUi(str1);
                  a(com.tencent.mm.loader.g.j.ibx);
                  AppMethodBeat.o(253056);
                  return;
                  localObject1 = "";
                  break label1278;
                  label2898:
                  i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sco, 0);
                  break label1325;
                  label2921:
                  localObject1 = null;
                  break label1382;
                  label2927:
                  j = 0;
                  break label1458;
                  label2933:
                  localObject5 = null;
                  break label1502;
                  label2939:
                  localObject5 = null;
                  break label1539;
                  j = 0;
                  break label1564;
                  bool6 = false;
                  break label1598;
                  localObject1 = null;
                  break label1671;
                  label2963:
                  localObject1 = null;
                  break label1732;
                  bool5 = true;
                  break label1829;
                  j = ((MultiMediaVideoChecker.a)localObject5).width;
                  break label1972;
                  label2985:
                  j = ((MultiMediaVideoChecker.a)localObject5).height;
                  break label2004;
                  label2995:
                  bool1 = false;
                  break label2190;
                  bool1 = false;
                  break label2190;
                  label3007:
                  localObject5 = null;
                  break label2209;
                }
                bool1 = false;
                continue;
                localObject5 = null;
                continue;
                localObject7 = MultiMediaVideoChecker.GyY.aTV(str2);
                if ((localObject7 == null) || (((MultiMediaVideoChecker.a)localObject7).width <= 0) || (((MultiMediaVideoChecker.a)localObject7).height <= 0) || (((MultiMediaVideoChecker.a)localObject7).cKu <= 0.0F))
                {
                  localObject4 = TAG;
                  localObject5 = new StringBuilder("remuxVideo file error: ");
                  if (localObject7 != null)
                  {
                    localObject1 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject7).width);
                    localObject5 = ((StringBuilder)localObject5).append(localObject1).append(' ');
                    if (localObject7 != null)
                    {
                      localObject1 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject7).height);
                      Log.i((String)localObject4, localObject1);
                      localObject1 = com.tencent.mm.plugin.vlog.report.b.GDm;
                      com.tencent.mm.plugin.vlog.report.b.aUi(str1);
                      a(com.tencent.mm.loader.g.j.ibx);
                      AppMethodBeat.o(253056);
                    }
                  }
                  else
                  {
                    localObject1 = null;
                    continue;
                  }
                  localObject1 = null;
                  continue;
                  i = 0;
                  bool1 = true;
                  localObject1 = localObject6;
                  if (bool1)
                  {
                    i6 = 1;
                    localObject6 = localFinderMediaReportObject.origin;
                    if (localObject6 != null) {
                      ((FinderMediaReportInfo)localObject6).fileSize = ((int)com.tencent.mm.vfs.s.boW(localcjl.url));
                    }
                    localObject8 = MultiMediaVideoChecker.GyY;
                    localObject7 = localcjl.url;
                    localObject6 = localObject7;
                    if (localObject7 == null) {
                      localObject6 = "";
                    }
                    localObject6 = ((MultiMediaVideoChecker)localObject8).aTV((String)localObject6);
                    i1 = 0;
                    i2 = 0;
                    if (localObject6 != null)
                    {
                      localObject7 = localFinderMediaReportObject.origin;
                      if (localObject7 != null) {
                        ((FinderMediaReportInfo)localObject7).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject6).duration);
                      }
                      localObject7 = localFinderMediaReportObject.origin;
                      if (localObject7 != null) {
                        ((FinderMediaReportInfo)localObject7).width = ((MultiMediaVideoChecker.a)localObject6).width;
                      }
                      localObject7 = localFinderMediaReportObject.origin;
                      if (localObject7 != null) {
                        ((FinderMediaReportInfo)localObject7).height = ((MultiMediaVideoChecker.a)localObject6).height;
                      }
                      localObject7 = localFinderMediaReportObject.origin;
                      if (localObject7 != null) {
                        ((FinderMediaReportInfo)localObject7).videoBitrate = ((MultiMediaVideoChecker.a)localObject6).bitrate;
                      }
                      localObject7 = localFinderMediaReportObject.origin;
                      if (localObject7 != null) {
                        ((FinderMediaReportInfo)localObject7).audioBitrate = ((MultiMediaVideoChecker.a)localObject6).audioBitrate;
                      }
                      localObject7 = localFinderMediaReportObject.origin;
                      if (localObject7 != null) {
                        ((FinderMediaReportInfo)localObject7).fps = ((int)((MultiMediaVideoChecker.a)localObject6).cKu);
                      }
                      i1 = ((MultiMediaVideoChecker.a)localObject6).width;
                      i2 = ((MultiMediaVideoChecker.a)localObject6).height;
                      localObject7 = kotlin.x.SXb;
                    }
                    if (localObject6 == null)
                    {
                      a(com.tencent.mm.loader.g.j.ibx);
                      AppMethodBeat.o(253056);
                      return;
                      if ((i != 1) || (!bool6) || (!bool1) || (localObject5 == null)) {
                        continue;
                      }
                      Log.i(TAG, "process, force use normal video");
                      bool6 = true;
                      localObject7 = localcjl.MfU;
                      localObject1 = localcjl.uOR;
                      if (localObject7 != null)
                      {
                        localObject6 = ((acn)localObject7).Lnd;
                        if (localObject6 != null)
                        {
                          localObject8 = (ejf)((LinkedList)localObject6).get(0);
                          if (localObject8 != null) {
                            continue;
                          }
                        }
                      }
                      localcjl.url = ((ejf)localObject5).path;
                      localObject1 = localcjl.MfU;
                      if (localObject1 != null)
                      {
                        localObject6 = ((acn)localObject1).iiv;
                        localObject1 = localObject6;
                        if (localObject6 != null) {}
                      }
                      else
                      {
                        localObject1 = "";
                      }
                      localObject6 = localcjl.MfU;
                      if (localObject6 != null)
                      {
                        bool1 = ((acn)localObject6).Gzo;
                        if (!Util.isNullOrNil((String)localObject1))
                        {
                          i = 1;
                          if (!bool1) {
                            continue;
                          }
                          if (i == 0) {
                            continue;
                          }
                          i = 3;
                          localObject7 = TAG;
                          localObject8 = new StringBuilder("process, time: [");
                          localObject6 = localcjl.uOR;
                          if (localObject6 == null) {
                            continue;
                          }
                          localObject6 = Integer.valueOf(((cjx)localObject6).dvv);
                          localObject8 = ((StringBuilder)localObject8).append(localObject6).append(", ");
                          localObject6 = localcjl.uOR;
                          if (localObject6 == null) {
                            continue;
                          }
                          localObject6 = Integer.valueOf(((cjx)localObject6).iqg);
                          localObject8 = ((StringBuilder)localObject8).append(localObject6).append("], size: [");
                          localObject6 = localcjl.uOR;
                          if (localObject6 == null) {
                            continue;
                          }
                          localObject6 = Integer.valueOf(((cjx)localObject6).width);
                          localObject8 = ((StringBuilder)localObject8).append(localObject6).append(", ");
                          localObject6 = localcjl.uOR;
                          if (localObject6 == null) {
                            continue;
                          }
                          localObject6 = Integer.valueOf(((cjx)localObject6).height);
                          localObject8 = ((StringBuilder)localObject8).append(localObject6).append("], crop: [");
                          localObject6 = localcjl.uOR;
                          if (localObject6 == null) {
                            continue;
                          }
                          localObject6 = ((cjx)localObject6).Mpq;
                          if (localObject6 == null) {
                            continue;
                          }
                          localObject6 = Integer.valueOf(((erf)localObject6).left);
                          localObject8 = ((StringBuilder)localObject8).append(localObject6).append(", ");
                          localObject6 = localcjl.uOR;
                          if (localObject6 == null) {
                            continue;
                          }
                          localObject6 = ((cjx)localObject6).Mpq;
                          if (localObject6 == null) {
                            continue;
                          }
                          localObject6 = Integer.valueOf(((erf)localObject6).top);
                          localObject8 = ((StringBuilder)localObject8).append(localObject6).append(", ");
                          localObject6 = localcjl.uOR;
                          if (localObject6 == null) {
                            continue;
                          }
                          localObject6 = ((cjx)localObject6).Mpq;
                          if (localObject6 == null) {
                            continue;
                          }
                          localObject6 = Integer.valueOf(((erf)localObject6).right);
                          localObject8 = ((StringBuilder)localObject8).append(localObject6).append(", ");
                          localObject6 = localcjl.uOR;
                          if (localObject6 == null) {
                            continue;
                          }
                          localObject6 = ((cjx)localObject6).Mpq;
                          if (localObject6 == null) {
                            continue;
                          }
                          localObject6 = Integer.valueOf(((erf)localObject6).bottom);
                          Log.i((String)localObject7, localObject6 + "], mixType: " + i);
                          n = i;
                          i = 0;
                          bool1 = bool6;
                          continue;
                          p.g(localObject8, "compositionInfo?.tracks?.get(0) ?: return");
                          i1 = SightVideoJNI.getMp4RotateVFS(((ejf)localObject8).path);
                          if (localObject1 != null) {
                            ((cjx)localObject1).dvv = ((int)(((acn)localObject7).Lne + ((ejf)localObject8).GGz));
                          }
                          if (localObject1 != null) {
                            ((cjx)localObject1).iqg = ((int)(((acn)localObject7).Lnf + ((ejf)localObject8).GGz));
                          }
                          f2 = ((ejf)localObject8).Gzu;
                          float f5 = ((ejf)localObject8).Gzw;
                          i = ((Number)((ejf)localObject8).NiP.LpT.Msu.get(2)).intValue();
                          localObject6 = ((ejf)localObject8).NiP.LpT.Msu.get(0);
                          p.g(localObject6, "track.cropInfo.contentRect.values[0]");
                          f2 = 1.0F * (f2 * f5) / (i - ((Number)localObject6).intValue());
                          localObject6 = new erf();
                          i = ((Number)((ejf)localObject8).NiP.LpR.Msu.get(0)).intValue();
                          localObject9 = ((ejf)localObject8).NiP.LpT.Msu.get(0);
                          p.g(localObject9, "track.cropInfo.contentRect.values[0]");
                          ((erf)localObject6).left = ((int)((i - ((Number)localObject9).intValue()) * f2));
                          i = ((Number)((ejf)localObject8).NiP.LpR.Msu.get(1)).intValue();
                          localObject9 = ((ejf)localObject8).NiP.LpT.Msu.get(1);
                          p.g(localObject9, "track.cropInfo.contentRect.values[1]");
                          ((erf)localObject6).bottom = ((int)((i - ((Number)localObject9).intValue()) * f2));
                          i = ((Number)((ejf)localObject8).NiP.LpR.Msu.get(2)).intValue();
                          localObject9 = ((ejf)localObject8).NiP.LpT.Msu.get(0);
                          p.g(localObject9, "track.cropInfo.contentRect.values[0]");
                          ((erf)localObject6).right = ((int)((i - ((Number)localObject9).intValue()) * f2));
                          i = ((Number)((ejf)localObject8).NiP.LpR.Msu.get(3)).intValue();
                          localObject9 = ((ejf)localObject8).NiP.LpT.Msu.get(1);
                          p.g(localObject9, "track.cropInfo.contentRect.values[1]");
                          ((erf)localObject6).top = ((int)((i - ((Number)localObject9).intValue()) * f2));
                          if (localObject1 != null) {
                            ((cjx)localObject1).Mpq = ((erf)localObject6);
                          }
                          i = ((Number)((ejf)localObject8).NiP.LpT.Msu.get(2)).intValue();
                          localObject9 = ((ejf)localObject8).NiP.LpT.Msu.get(0);
                          p.g(localObject9, "track.cropInfo.contentRect.values[0]");
                          i2 = (int)((i - ((Number)localObject9).intValue()) * f2);
                          i = ((Number)((ejf)localObject8).NiP.LpT.Msu.get(3)).intValue();
                          localObject8 = ((ejf)localObject8).NiP.LpT.Msu.get(1);
                          p.g(localObject8, "track.cropInfo.contentRect.values[1]");
                          i3 = (int)((i - ((Number)localObject8).intValue()) * f2);
                          if (localObject1 != null)
                          {
                            localObject8 = ((cjx)localObject1).Mpq;
                            if (localObject8 != null)
                            {
                              i = ((erf)localObject8).right;
                              if (localObject1 == null) {
                                continue;
                              }
                              localObject8 = ((cjx)localObject1).Mpq;
                              if (localObject8 == null) {
                                continue;
                              }
                              n = ((erf)localObject8).left;
                              f2 = i - n;
                              localObject8 = ((acn)localObject7).Gxw;
                              if (localObject8 == null) {
                                continue;
                              }
                              i = ((aco)localObject8).targetWidth;
                              f2 = 1.0F * f2 / i;
                              if (f2 <= 1.0F) {
                                continue;
                              }
                              f2 = 1.0F;
                              if (localObject1 != null)
                              {
                                localObject8 = ((acn)localObject7).Gxw;
                                if (localObject8 == null) {
                                  continue;
                                }
                                i = ((aco)localObject8).targetWidth;
                                ((cjx)localObject1).width = ((int)(i * f2));
                              }
                              if (localObject1 != null)
                              {
                                localObject7 = ((acn)localObject7).Gxw;
                                if (localObject7 == null) {
                                  continue;
                                }
                                i = ((aco)localObject7).targetHeight;
                                ((cjx)localObject1).height = ((int)(i * f2));
                              }
                              if (i1 != 90) {
                                continue;
                              }
                              localObject7 = new erf();
                              ((erf)localObject7).left = ((erf)localObject6).bottom;
                              ((erf)localObject7).top = ((erf)localObject6).right;
                              ((erf)localObject7).right = ((erf)localObject6).top;
                              ((erf)localObject7).bottom = ((erf)localObject6).left;
                              if (localObject1 == null) {
                                continue;
                              }
                              ((cjx)localObject1).Mpq = ((erf)localObject7);
                              continue;
                            }
                          }
                          i = 0;
                          continue;
                          n = 0;
                          continue;
                          i = 1;
                          continue;
                          i = 0;
                          continue;
                          i = 0;
                          continue;
                          if (i1 == 180)
                          {
                            localObject7 = new erf();
                            ((erf)localObject7).left = (i2 - ((erf)localObject6).right);
                            ((erf)localObject7).top = (i3 - ((erf)localObject6).bottom);
                            ((erf)localObject7).right = (i2 - ((erf)localObject6).left);
                            ((erf)localObject7).bottom = (i3 - ((erf)localObject6).top);
                            if (localObject1 == null) {
                              continue;
                            }
                            ((cjx)localObject1).Mpq = ((erf)localObject7);
                            continue;
                          }
                          if (i1 != 270) {
                            continue;
                          }
                          localObject7 = new erf();
                          ((erf)localObject7).left = (i3 - ((erf)localObject6).top);
                          ((erf)localObject7).top = (i2 - ((erf)localObject6).left);
                          ((erf)localObject7).right = (i3 - ((erf)localObject6).bottom);
                          ((erf)localObject7).bottom = (i2 - ((erf)localObject6).right);
                          if (localObject1 == null) {
                            continue;
                          }
                          ((cjx)localObject1).Mpq = ((erf)localObject7);
                          continue;
                        }
                      }
                      else
                      {
                        bool1 = false;
                        continue;
                      }
                      i = 0;
                      continue;
                      i = 1;
                      continue;
                      if (i != 0)
                      {
                        i = 2;
                        continue;
                      }
                      i = 0;
                      continue;
                      localObject6 = null;
                      continue;
                      localObject6 = null;
                      continue;
                      localObject6 = null;
                      continue;
                      localObject6 = null;
                      continue;
                      localObject6 = null;
                      continue;
                      localObject6 = null;
                      continue;
                      localObject6 = null;
                      continue;
                      localObject6 = null;
                      continue;
                    }
                    localObject7 = new z.c();
                    ((z.c)localObject7).SYD = 0.0F;
                    int i3 = SightVideoJNI.getMp4RotateVFS(localcjl.url);
                    localObject6 = localcjl.uOR;
                    if (localObject6 != null)
                    {
                      i = ((cjx)localObject6).width;
                      localObject6 = localcjl.uOR;
                      if (localObject6 != null)
                      {
                        j = ((cjx)localObject6).height;
                        if ((i3 != 90) && (i3 != 270)) {
                          continue;
                        }
                        localObject6 = localcjl.uOR;
                        if (localObject6 == null) {
                          continue;
                        }
                        i = ((cjx)localObject6).height;
                        localObject6 = localcjl.uOR;
                        if (localObject6 == null) {
                          continue;
                        }
                        j = ((cjx)localObject6).width;
                        if ((localObject5 == null) && (localcjl.uOR != null))
                        {
                          localObject5 = localcjl.uOR;
                          if (localObject5 == null) {
                            p.hyc();
                          }
                          p.g(localObject5, "it.cropInfo!!");
                          localObject6 = ((cjx)localObject5).Mpq;
                          if (localObject6 != null) {
                            continue;
                          }
                        }
                        int i7 = ((VideoTransPara)localObject4).videoBitrate;
                        localObject5 = r.c.vhb;
                        if ((!bool2) && (!bool3)) {
                          continue;
                        }
                        bool1 = true;
                        r.c.nT(bool1);
                        Log.i(TAG, "video rotate:" + i3 + ", width:" + i + ", height:" + j + " url " + localcjl.url + " thumbUrl: " + localcjl.thumbUrl + " size:" + Util.getSizeKB(com.tencent.mm.vfs.s.boW(localcjl.url)));
                        localObject6 = localcjl.url;
                        localObject5 = localObject6;
                        if (localObject6 == null) {
                          localObject5 = "";
                        }
                        localObject6 = localcjl.uOR;
                        if (localObject6 == null) {
                          continue;
                        }
                        i3 = ((cjx)localObject6).iqg;
                        f2 = i3 / 1000.0F;
                        localObject6 = localcjl.uOR;
                        if (localObject6 == null) {
                          continue;
                        }
                        i3 = ((cjx)localObject6).dvv;
                        localObject6 = a.a((String)localObject5, i, j, f2, i3 / 1000.0F, (VideoTransPara)localObject4, bool2);
                        i5 = i;
                        i4 = j;
                        i3 = i7;
                        if (((c.a.a)localObject6).errCode == 0)
                        {
                          i5 = i;
                          i4 = j;
                          i3 = i7;
                          if (((c.a.a)localObject6).width > 0)
                          {
                            i5 = i;
                            i4 = j;
                            i3 = i7;
                            if (((c.a.a)localObject6).height > 0)
                            {
                              i5 = i;
                              i4 = j;
                              i3 = i7;
                              if (((c.a.a)localObject6).bitrate > 0)
                              {
                                i5 = ((c.a.a)localObject6).width;
                                i4 = ((c.a.a)localObject6).height;
                                i3 = ((c.a.a)localObject6).bitrate;
                                Log.i(TAG, "video abaResult, width:" + i5 + ", height:" + i4 + ", " + i3);
                              }
                            }
                          }
                        }
                        if ((((c.a.a)localObject6).vRR == null) || (((c.a.a)localObject6).vRR.length < 28)) {
                          continue;
                        }
                        f1 = localObject6.vRR[27];
                        i = a(l, k, str2, i1, i2, d.QH(i5), d.QH(i4), i3, (VideoTransPara)localObject4, localcjl, localFinderMediaReportObject, (String)localObject1, n, bool2, bool3, localkk, (kotlin.g.a.b)new i((z.c)localObject7, k, this, localList2, localList1));
                        Util.ticksToNow(l);
                        if (i >= 0) {
                          continue;
                        }
                        localObject1 = com.tencent.mm.plugin.vlog.report.b.GDm;
                        com.tencent.mm.plugin.vlog.report.b.aUi(str1);
                        a(com.tencent.mm.loader.g.j.ibx);
                        AppMethodBeat.o(253056);
                      }
                    }
                    else
                    {
                      i = 0;
                      continue;
                    }
                    j = 0;
                    continue;
                    i = 0;
                    continue;
                    j = 0;
                    continue;
                    p.g(localObject6, "cropInfo.rect ?: return");
                    int i4 = ((erf)localObject6).right - ((erf)localObject6).left;
                    int i5 = ((erf)localObject6).top - ((erf)localObject6).bottom;
                    switch (i3)
                    {
                    default: 
                      break;
                    case 90: 
                      localObject8 = new erf();
                      ((erf)localObject8).left = ((erf)localObject6).bottom;
                      ((erf)localObject8).top = ((erf)localObject6).right;
                      ((erf)localObject8).right = ((erf)localObject6).top;
                      ((erf)localObject8).bottom = ((erf)localObject6).left;
                      ((cjx)localObject5).Mpq = ((erf)localObject8);
                      break;
                    case 180: 
                      localObject8 = new erf();
                      ((erf)localObject8).left = (i4 - ((erf)localObject6).right);
                      ((erf)localObject8).top = (i5 - ((erf)localObject6).bottom);
                      ((erf)localObject8).right = (i4 - ((erf)localObject6).left);
                      ((erf)localObject8).bottom = (i5 - ((erf)localObject6).top);
                      ((cjx)localObject5).Mpq = ((erf)localObject8);
                      break;
                    case 270: 
                      localObject8 = new erf();
                      ((erf)localObject8).left = (i5 - ((erf)localObject6).top);
                      ((erf)localObject8).top = (i4 - ((erf)localObject6).left);
                      ((erf)localObject8).right = (i5 - ((erf)localObject6).bottom);
                      ((erf)localObject8).bottom = (i4 - ((erf)localObject6).right);
                      ((cjx)localObject5).Mpq = ((erf)localObject8);
                      continue;
                      bool1 = false;
                      break;
                    }
                    i3 = 0;
                    continue;
                    i3 = 0;
                    continue;
                    localObject5 = MultiMediaVideoChecker.GyY.aTV(str2);
                    if ((localObject5 == null) || (((MultiMediaVideoChecker.a)localObject5).width <= 0) || (((MultiMediaVideoChecker.a)localObject5).height <= 0) || (((MultiMediaVideoChecker.a)localObject5).cKu <= 0.0F))
                    {
                      localObject4 = TAG;
                      localObject6 = new StringBuilder("normal video remuxVideo file error: ");
                      if (localObject5 != null)
                      {
                        localObject1 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject5).width);
                        localObject6 = ((StringBuilder)localObject6).append(localObject1).append(' ');
                        if (localObject5 != null)
                        {
                          localObject1 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject5).height);
                          Log.i((String)localObject4, localObject1);
                          localObject1 = r.c.vhb;
                          if ((!bool2) && (!bool3)) {
                            continue;
                          }
                          bool1 = true;
                          r.c.nU(bool1);
                          localObject1 = r.c.vhb;
                          if ((!bool2) && (!bool3)) {
                            continue;
                          }
                          bool1 = true;
                          r.c.nV(bool1);
                          localObject1 = com.tencent.mm.plugin.vlog.report.b.GDm;
                          com.tencent.mm.plugin.vlog.report.b.aUi(str1);
                          a(com.tencent.mm.loader.g.j.ibx);
                          AppMethodBeat.o(253056);
                        }
                      }
                      else
                      {
                        localObject1 = null;
                        continue;
                      }
                      localObject1 = null;
                      continue;
                      bool1 = false;
                      continue;
                      bool1 = false;
                      continue;
                    }
                    if (((c.a.a)localObject6).vRR == null) {
                      continue;
                    }
                    try
                    {
                      SightVideoJNI.addReportMetadata(str2, ((c.a.a)localObject6).vRR, ((VideoTransPara)localObject4).iTg, 0);
                      i = 1;
                      j = i6;
                    }
                    catch (Throwable localThrowable1)
                    {
                      i = 1;
                      j = i6;
                      continue;
                    }
                    Log.i(TAG, "hseasunhan, video quality level: ".concat(String.valueOf(f1)));
                    p.h(str2, "input");
                    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (!com.tencent.mm.plugin.finder.storage.c.dtU()) {
                      continue;
                    }
                    f2 = AdaptiveAdjustBitrate.a(str2, f3, f4, i8, bool4, bool5);
                    Log.i(TAG, "qipengfeng, audio quality level: " + f2 + ", bitrate:" + f3 + ", samplerate:" + f4 + ", channels:" + i8 + ", enableAuQA:" + bool4 + ", useOriAu:" + bool5);
                    if (i != 0)
                    {
                      localkk.tz((100.0F * f1));
                      localkk.ty((100.0F * f2));
                      localObject1 = com.tencent.mm.plugin.vlog.report.b.GDm;
                      com.tencent.mm.plugin.vlog.report.b.aUi(str1);
                    }
                    bi((k + 1.0F) / localList1.size());
                    if (!localcjl.MoY) {
                      continue;
                    }
                    localObject5 = ((Iterable)this.vRO.getHalfVideoMediaExtList()).iterator();
                    if (!((Iterator)localObject5).hasNext()) {
                      continue;
                    }
                    localObject1 = ((Iterator)localObject5).next();
                    localObject6 = (cjl)localObject1;
                    if (!p.j(localcjl.mediaId, ((cjl)localObject6).mediaId)) {
                      continue;
                    }
                    localObject1 = (cjl)localObject1;
                    if (localObject1 != null)
                    {
                      a((VideoTransPara)localObject4, localcjl, str2, (cjl)localObject1, k, localFinderMediaReportObject, f2, f1, false);
                      dAR();
                      localObject1 = kotlin.x.SXb;
                    }
                    localObject5 = this.vRO.getLongVideoMediaExtList();
                    localObject6 = ((Iterable)localObject5).iterator();
                    if (!((Iterator)localObject6).hasNext()) {
                      continue;
                    }
                    localObject1 = ((Iterator)localObject6).next();
                    localObject7 = (cjl)localObject1;
                    if (!p.j(localcjl.mediaId, ((cjl)localObject7).mediaId)) {
                      continue;
                    }
                    localObject1 = (cjl)localObject1;
                    if (localObject1 == null) {
                      continue;
                    }
                    a((VideoTransPara)localObject4, localcjl, str2, (cjl)localObject1, k, localFinderMediaReportObject, f2, f1, true);
                    localObject1 = this.vRO.getFeedObject().attachmentList;
                    if (localObject1 != null)
                    {
                      localObject1 = ((aoq)localObject1).LAM;
                      if (localObject1 != null)
                      {
                        localObject1 = (aop)kotlin.a.j.kt((List)localObject1);
                        if (localObject1 != null)
                        {
                          localObject1 = ((aop)localObject1).LAL;
                          if (localObject1 != null)
                          {
                            localObject1 = ((bei)localObject1).LIA;
                            if (localObject1 != null)
                            {
                              localObject1 = ((cng)localObject1).MtG;
                              if (localObject1 != null) {
                                ((cnl)localObject1).media = com.tencent.mm.plugin.finder.storage.data.o.aC((LinkedList)localObject5);
                              }
                            }
                          }
                        }
                      }
                    }
                    dAR();
                    localObject1 = kotlin.x.SXb;
                    k = m;
                    break;
                  }
                  if ((!bool2) && (!bool3))
                  {
                    Object localObject2 = a(l, k, str2, (VideoTransPara)localObject4, localcjl, localFinderMediaReportObject, localList1.size());
                    n = ((Number)((kotlin.o)localObject2).first).intValue();
                    f1 = ((Number)((kotlin.o)localObject2).second).floatValue();
                    if (n < 0)
                    {
                      a(com.tencent.mm.loader.g.j.ibx);
                      AppMethodBeat.o(253056);
                      return;
                    }
                    localObject5 = MultiMediaVideoChecker.GyY.aTV(str2);
                    if ((localObject5 == null) || (((MultiMediaVideoChecker.a)localObject5).width <= 0) || (((MultiMediaVideoChecker.a)localObject5).height <= 0) || (((MultiMediaVideoChecker.a)localObject5).cKu <= 0.0F))
                    {
                      localObject4 = TAG;
                      localObject6 = new StringBuilder("remuxVideo file error: ");
                      if (localObject5 != null)
                      {
                        localObject2 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject5).width);
                        localObject6 = ((StringBuilder)localObject6).append(localObject2).append(' ');
                        if (localObject5 != null)
                        {
                          localObject2 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject5).height);
                          Log.i((String)localObject4, localObject2);
                          a(com.tencent.mm.loader.g.j.ibx);
                          AppMethodBeat.o(253056);
                        }
                      }
                      else
                      {
                        localObject2 = null;
                        continue;
                      }
                      localObject2 = null;
                      continue;
                      f2 = 0.0F;
                      continue;
                      localObject2 = null;
                      continue;
                      localObject5 = this.vRO.getMediaList();
                      localObject6 = ((Iterable)localObject5).iterator();
                      if (((Iterator)localObject6).hasNext())
                      {
                        localObject2 = ((Iterator)localObject6).next();
                        localObject7 = (cjl)localObject2;
                        if (!p.j(localcjl.mediaId, ((cjl)localObject7).mediaId)) {
                          continue;
                        }
                        localObject2 = (cjl)localObject2;
                        if (localObject2 == null) {
                          continue;
                        }
                        a((VideoTransPara)localObject4, localcjl, str2, (cjl)localObject2, k, localFinderMediaReportObject, f2, f1, false);
                        this.vRO.setMediaList((LinkedList)localObject5);
                        localObject2 = this.vRO.field_reportObject;
                        if (localObject2 != null)
                        {
                          ((FinderFeedReportObject)localObject2).remuxEndTime = cl.aWA();
                          ((FinderFeedReportObject)localObject2).remuxType = j;
                          localObject2 = kotlin.x.SXb;
                        }
                        dAR();
                        localObject2 = kotlin.x.SXb;
                        continue;
                      }
                      localObject2 = null;
                      continue;
                      localObject2 = null;
                      continue;
                      k = m;
                      break;
                      localObject2 = com.tencent.mm.plugin.vlog.model.m.Gyi;
                      com.tencent.mm.plugin.vlog.model.m.reset();
                      a(com.tencent.mm.loader.g.j.ibw);
                      AppMethodBeat.o(253056);
                      return;
                      localThrowable2 = localThrowable2;
                      f1 = 0.0F;
                      continue;
                    }
                  }
                }
              }
              catch (Throwable localThrowable3)
              {
                int i6;
                continue;
                continue;
                continue;
                i = 1;
                j = i6;
                continue;
                continue;
                continue;
                continue;
                i = 0;
                bool1 = bool7;
                Object localObject3 = localObject6;
                continue;
                i = 1;
                bool1 = false;
                localObject3 = localObject6;
                continue;
                bool1 = false;
                continue;
                i = 0;
                continue;
              }
              f1 = 0.0F;
            }
          }
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion;", "", "()V", "RemuxTypeNoNeedRemux", "", "RemuxTypeNormalVideo", "RemuxTypeTavkit", "TAG", "", "getTAG", "()Ljava/lang/String;", "_5_min", "", "checkProgressExceptionHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkRemuxVideo", "path", "width", "height", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "localId", "isLongVideoAttachShort", "", "convertViewRect", "Landroid/graphics/Rect;", "viewRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "getABAResult", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "input", "durationSec", "", "startTimeSec", "videoTransPara", "isLongVideo", "getAudioQualityLevel", "bitrate", "samplerate", "channels", "enableAuQA", "useOriAu", "ABAResult", "plugin-finder_release"})
  public static final class a
  {
    public static int a(String paramString, int paramInt1, int paramInt2, VideoTransPara paramVideoTransPara, long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(253047);
      p.h(paramVideoTransPara, "videoParams");
      long l2 = com.tencent.mm.vfs.s.boW(paramString);
      Object localObject = r.c.vhb;
      r.c.v(l2, paramBoolean);
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      long l1 = com.tencent.mm.plugin.finder.storage.c.dqI();
      if (l2 > l1)
      {
        localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dtH() != 1) {}
      }
      else
      {
        localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (((Number)com.tencent.mm.plugin.finder.storage.c.dwn().value()).intValue() != 1) {
          break label286;
        }
      }
      Log.i(c.access$getTAG$cp(), "checkRemuxVideo need remux zip");
      localObject = r.c.vhb;
      r.c.nY(paramBoolean);
      l2 = Util.currentTicks();
      localObject = paramString + ".remux";
      paramInt1 = SightVideoJNI.remuxingVFS(paramString, (String)localObject, paramInt1, paramInt2, paramVideoTransPara.videoBitrate, com.tencent.mm.plugin.sight.base.c.Dmc, 8, 2, 25.0F, paramVideoTransPara.fps, null, 0, com.tencent.mm.plugin.sight.base.c.Dmb, 0, 51);
      Log.i(c.access$getTAG$cp(), "checkRemuxVideo remux cost:" + Util.ticksToNow(l2) + "ms, ret:" + paramInt1 + " localId:" + paramLong);
      paramVideoTransPara = r.c.vhb;
      r.c.w(Util.ticksToNow(l2), paramBoolean);
      if (paramInt1 >= 0)
      {
        com.tencent.mm.vfs.s.nx((String)localObject, paramString);
        paramLong = com.tencent.mm.vfs.s.boW((String)localObject);
        paramString = r.c.vhb;
        r.c.x(paramLong, paramBoolean);
        if (paramLong > l1)
        {
          AppMethodBeat.o(253047);
          return -3;
        }
        AppMethodBeat.o(253047);
        return 0;
      }
      paramString = r.c.vhb;
      r.c.nZ(paramBoolean);
      AppMethodBeat.o(253047);
      return -2;
      label286:
      Log.i(c.access$getTAG$cp(), "checkRemuxVideo, no need remux");
      AppMethodBeat.o(253047);
      return 0;
    }
    
    public static Rect a(erf paramerf)
    {
      AppMethodBeat.i(167726);
      p.h(paramerf, "viewRect");
      paramerf = new Rect(paramerf.left, paramerf.top, paramerf.right, paramerf.bottom);
      AppMethodBeat.o(167726);
      return paramerf;
    }
    
    public static a a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, VideoTransPara paramVideoTransPara, boolean paramBoolean)
    {
      AppMethodBeat.i(253048);
      p.h(paramString, "input");
      p.h(paramVideoTransPara, "videoTransPara");
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
          float f = (float)com.tencent.mm.plugin.finder.storage.c.dqJ();
          localc = com.tencent.mm.plugin.finder.storage.c.vCb;
          f /= 1.0F * com.tencent.mm.plugin.finder.storage.c.dqs();
          localc = com.tencent.mm.plugin.finder.storage.c.vCb;
          paramVideoTransPara.iTo = ((int)(f * com.tencent.mm.plugin.finder.storage.c.dqt()));
          Log.i(c.access$getTAG$cp(), "ABA:  finder video maxVideoSize:" + paramVideoTransPara + ".maxVideoSize");
          Log.i(c.access$getTAG$cp(), "ABA:  finder video video endtime:" + paramFloat1 + " starttime:" + paramFloat2);
          localc = com.tencent.mm.plugin.finder.storage.c.vCb;
          if (!com.tencent.mm.plugin.finder.storage.c.dqB()) {
            continue;
          }
          paramString = AdaptiveAdjustBitrate.a(paramString, paramInt2, paramInt1, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, paramFloat1, paramFloat2, 4, paramVideoTransPara.iTi, paramVideoTransPara.iTj, paramVideoTransPara.iTk, paramVideoTransPara.iTl, paramVideoTransPara.iTm, paramVideoTransPara.iTn, paramVideoTransPara.iTo, false);
          j = paramVideoTransPara.videoBitrate;
          i = -1;
          if (paramString == null) {
            break label352;
          }
          j = paramString[0] * 1000;
          i = 0;
          Log.i(c.access$getTAG$cp(), "getABAResult use videoBitrate:".concat(String.valueOf(j)));
        }
        catch (Throwable paramString)
        {
          int j;
          paramString = new a(-1, 0, 0, 0, null);
          AppMethodBeat.o(253048);
          return paramString;
        }
        Log.i(c.access$getTAG$cp(), "ABA:  finder video bitrate:" + j + " width: " + k + " height:" + paramInt1);
        if (com.tencent.mm.modelvideo.o.bhk() != null) {
          e.s(paramString);
        }
        paramString = new a(i, k, paramInt1, j, paramString);
        AppMethodBeat.o(253048);
        return paramString;
        label352:
        while ((paramString == null) || (paramString[5] <= 0))
        {
          k = paramInt1;
          paramInt1 = paramInt2;
          break;
        }
        int k = paramString[1];
        paramInt1 = paramString[2];
        int i = 0;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "", "errCode", "", "width", "height", "bitrate", "abaParams", "", "(IIII[I)V", "getAbaParams", "()[I", "getBitrate", "()I", "getErrCode", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      public final int bitrate;
      public final int errCode;
      public final int height;
      public final int[] vRR;
      public final int width;
      
      public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
      {
        this.errCode = paramInt1;
        this.width = paramInt2;
        this.height = paramInt3;
        this.bitrate = paramInt4;
        this.vRR = paramArrayOfInt;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(167725);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((this.errCode != paramObject.errCode) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.bitrate != paramObject.bitrate) || (!p.j(this.vRR, paramObject.vRR))) {}
          }
        }
        else
        {
          AppMethodBeat.o(167725);
          return true;
        }
        AppMethodBeat.o(167725);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(167724);
        int j = this.errCode;
        int k = this.width;
        int m = this.height;
        int n = this.bitrate;
        int[] arrayOfInt = this.vRR;
        if (arrayOfInt != null) {}
        for (int i = Arrays.hashCode(arrayOfInt);; i = 0)
        {
          AppMethodBeat.o(167724);
          return i + (((j * 31 + k) * 31 + m) * 31 + n) * 31;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(167723);
        String str = "ABAResult(errCode=" + this.errCode + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", abaParams=" + Arrays.toString(this.vRR) + ")";
        AppMethodBeat.o(167723);
        return str;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "msg", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements MMHandler.Callback
  {
    public static final b vRS;
    
    static
    {
      AppMethodBeat.i(253046);
      vRS = new b();
      AppMethodBeat.o(253046);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      boolean bool2 = false;
      AppMethodBeat.i(253045);
      boolean bool1;
      Object localObject;
      StringBuilder localStringBuilder;
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        long l = paramMessage.what;
        paramMessage = r.c.vhb;
        r.c.nX(bool1);
        paramMessage = ((PluginFinder)g.ah(PluginFinder.class)).getFeedStorage().Fz(l);
        if (paramMessage != null)
        {
          localObject = paramMessage.field_reportObject;
          if (localObject != null) {
            ((FinderFeedReportObject)localObject).uploadLogicError = 3;
          }
          localObject = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
          com.tencent.mm.plugin.finder.storage.logic.c.a.r(paramMessage);
          localObject = com.tencent.mm.plugin.finder.report.i.vfo;
          com.tencent.mm.plugin.finder.report.i.Fb(paramMessage.getLocalId());
        }
        localObject = c.vRQ;
        localObject = c.access$getTAG$cp();
        localStringBuilder = new StringBuilder("[checkProgressException] timeout update progress, item is null=");
        bool1 = bool2;
        if (paramMessage == null) {
          bool1 = true;
        }
        localStringBuilder = localStringBuilder.append(bool1).append(" localId=");
        if (paramMessage == null) {
          break label172;
        }
      }
      label172:
      for (paramMessage = Long.valueOf(paramMessage.getLocalId());; paramMessage = null)
      {
        Log.e((String)localObject, paramMessage);
        AppMethodBeat.o(253045);
        return true;
        bool1 = false;
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Float, kotlin.x>
  {
    c(c paramc, z.c paramc1, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    d(c paramc, z.d paramd, int paramInt, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, String paramString, aco paramaco, VideoTransPara paramVideoTransPara, acn paramacn, Object paramObject, z.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "errCode", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.m<Boolean, Integer, kotlin.x>
  {
    e(c paramc, kk paramkk, n.b paramb, long paramLong1, boolean paramBoolean, long paramLong2, String paramString, com.tencent.mm.videocomposition.n paramn, z.d paramd1, FinderMediaReportObject paramFinderMediaReportObject, long paramLong3, z.d paramd2, z.d paramd3, VideoTransPara paramVideoTransPara, Object paramObject, z.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "progress", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Float, kotlin.x>
  {
    f(c paramc, z.c paramc1, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<Float, kotlin.x>
  {
    g(kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<String, kotlin.x>
  {
    h(c paramc, cjl paramcjl, kk paramkk, long paramLong, boolean paramBoolean1, z.d paramd, int paramInt1, boolean paramBoolean2, FinderMediaReportObject paramFinderMediaReportObject, int paramInt2, int paramInt3, VideoTransPara paramVideoTransPara, Object paramObject, z.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$start$4$3"})
  static final class i
    extends q
    implements kotlin.g.a.b<Float, kotlin.x>
  {
    i(z.c paramc, int paramInt, c paramc1, List paramList1, List paramList2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.c
 * JD-Core Version:    0.7.0.1
 */