package com.tencent.mm.plugin.finder.upload;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Message;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.e;
import com.tencent.mm.f.a.hr;
import com.tencent.mm.f.b.a.nd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.v.c;
import com.tencent.mm.plugin.finder.report.v.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.g;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.plugin.vlog.model.t;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.eth;
import com.tencent.mm.protocal.protobuf.eus;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.c;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "checkNotRetryAndSave", "", "result", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;", "checkProgressException", "localId", "", "isLongVideo", "", "isCancel", "checkVideoInfoMatch", "path", "", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "chooseMixType", "", "originAudio", "addAudio", "compositionToCropInfo", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "exportMedia", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "remuxComposition", "Lkotlin/Pair;", "", "startRemuxerTick", "index", "outputPath", "mediaReportObject", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;", "size", "remuxLongVideoComposition", "localMedia", "vcPerformanceStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "remuxNormalVideo", "videoWidth", "videoHeight", "width", "height", "bitrate", "localFinderMedia", "musicPath", "mixType", "isLongVideoAttachShort", "onUpdateProgress", "Lkotlin/Function1;", "rotateRect", "rotate", "saveFinderObject", "start", "uniqueId", "updateMedia", "reportObject", "audioQuality", "videoQuality", "updateProgress", "avgProgress", "Companion", "plugin-finder_release"})
public final class c
  extends j
{
  private static final MMHandler Azs;
  public static final a Azt;
  private static final String TAG = "Finder.LogPost.FinderMediaProcessTask";
  FinderItem Azr;
  
  static
  {
    AppMethodBeat.i(167735);
    Azt = new a((byte)0);
    TAG = "Finder.LogPost.FinderMediaProcessTask";
    MMHandler localMMHandler = new MMHandler(TAG + "#checkProgressExceptionHandler", (MMHandler.Callback)b.Azv);
    localMMHandler.setLogging(false);
    Azs = localMMHandler;
    AppMethodBeat.o(167735);
  }
  
  public c(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167734);
    this.Azr = paramFinderItem;
    AppMethodBeat.o(167734);
  }
  
  private final int a(final long paramLong, final int paramInt1, String paramString1, int paramInt2, int paramInt3, final int paramInt4, final int paramInt5, int paramInt6, final VideoTransPara paramVideoTransPara, final csg paramcsg, final FinderMediaReportObject paramFinderMediaReportObject, String paramString2, int paramInt7, boolean paramBoolean1, final boolean paramBoolean2, final nd paramnd, kotlin.g.a.b<? super Float, x> paramb)
  {
    AppMethodBeat.i(287561);
    locald = new aa.d();
    locald.aaBA = -1;
    localObject4 = new Object();
    final aa.a locala = new aa.a();
    locala.aaBx = false;
    for (;;)
    {
      try
      {
        Object localObject2 = paramcsg.url;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = paramcsg.zBo;
        if (localObject2 != null)
        {
          localObject3 = ((css)localObject2).TAv;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = new fbq();
        }
        localObject2 = a.a((fbq)localObject2);
        int i = paramVideoTransPara.audioBitrate;
        int j = paramVideoTransPara.audioSampleRate;
        int k = paramVideoTransPara.audioChannelCount;
        int m = paramVideoTransPara.fps;
        Object localObject3 = paramcsg.zBo;
        if (localObject3 != null)
        {
          l1 = ((css)localObject3).fod;
          localObject3 = paramcsg.zBo;
          if (localObject3 == null) {
            continue;
          }
          l2 = ((css)localObject3).endTime;
          paramString1 = new com.tencent.mm.plugin.finder.video.o(paramString2, (String)localObject1, paramInt7, paramString1, (Rect)localObject2, paramInt4, paramInt5, paramInt6, i, j, k, m, l1, l2, paramVideoTransPara.kXt, (kotlin.g.a.b)new g(paramb), (kotlin.g.a.b)new h(this, paramcsg, paramnd, paramLong, paramBoolean1, locald, paramInt1, paramBoolean2, paramFinderMediaReportObject, paramInt4, paramInt5, paramVideoTransPara, localObject4, locala), paramInt2, paramInt3);
          paramString1.aUW();
        }
      }
      catch (Throwable paramString1)
      {
        long l1;
        long l2;
        Log.printErrStackTrace(TAG, paramString1, "create remuxer failed", new Object[0]);
        paramString1 = v.c.zYk;
        if ((paramBoolean1) || (paramBoolean2))
        {
          paramBoolean1 = true;
          v.c.qe(paramBoolean1);
          a(com.tencent.mm.loader.g.j.kQe);
          paramInt1 = locald.aaBA;
          AppMethodBeat.o(287561);
          return paramInt1;
        }
        paramBoolean1 = false;
        continue;
      }
      try
      {
        if (!locala.aaBx)
        {
          Log.i(TAG, "wait ".concat(String.valueOf(paramInt1)));
          localObject4.wait();
          Log.i(TAG, "notify " + paramInt1 + ", " + locald.aaBA);
        }
        paramString1 = x.aazN;
        paramInt1 = locald.aaBA;
        AppMethodBeat.o(287561);
        return paramInt1;
      }
      finally
      {
        AppMethodBeat.o(287561);
      }
      l1 = 0L;
      continue;
      l2 = 0L;
    }
  }
  
  private final kotlin.o<Integer, Float> a(final long paramLong, final int paramInt1, String paramString, final VideoTransPara paramVideoTransPara, final csg paramcsg, final FinderMediaReportObject paramFinderMediaReportObject, final int paramInt2)
  {
    AppMethodBeat.i(287562);
    Log.i(TAG, "remuxComposition outputPath:".concat(String.valueOf(paramString)));
    Object localObject1 = com.tencent.mm.plugin.vlog.model.n.NlN;
    com.tencent.mm.plugin.vlog.model.n.Ao(false);
    Object localObject2 = paramcsg.TpG;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new acu();
    }
    p.j(localObject1, "media.videoCompositionInfo ?: CompositionInfo()");
    final aa.d locald = new aa.d();
    locald.aaBA = -1;
    if (localObject1 != null)
    {
      localObject3 = ((acu)localObject1).NkX;
      localObject2 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject2 = new acv();
    }
    ((acv)localObject2).uVk = paramString;
    ((acv)localObject2).mfh = w.o(false, 0L);
    localObject3 = new Object();
    final aa.a locala = new aa.a();
    locala.aaBx = false;
    com.tencent.mm.plugin.vlog.model.f localf = new com.tencent.mm.plugin.vlog.model.f();
    localf.wwk = 1;
    Object localObject4 = paramcsg.zBo;
    if (localObject4 != null) {}
    for (int i = ((css)localObject4).retryCount;; i = 0)
    {
      localf.retryCount = i;
      localf.NkL = true;
      localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (com.tencent.mm.plugin.finder.storage.d.dRL()) {
        localf.a(true, paramVideoTransPara);
      }
      localObject4 = new aa.c();
      ((aa.c)localObject4).aaBz = 0.0F;
      localf.Z((kotlin.g.a.b)new c(this, (aa.c)localObject4, paramInt1, paramInt2));
      float f = localf.a((acu)localObject1, (kotlin.g.a.b)new d(this, locald, paramInt1, paramFinderMediaReportObject, paramLong, paramString, (acv)localObject2, paramVideoTransPara, (acu)localObject1, paramcsg, localObject3, locala));
      try
      {
        if (!locala.aaBx)
        {
          Log.i(TAG, "wait ".concat(String.valueOf(paramInt1)));
          localObject3.wait();
          Log.i(TAG, "notify " + paramInt1 + ", " + locald.aaBA);
        }
        paramString = x.aazN;
        paramString = new kotlin.o(Integer.valueOf(locald.aaBA), Float.valueOf(f));
        AppMethodBeat.o(287562);
        return paramString;
      }
      finally
      {
        AppMethodBeat.o(287562);
      }
    }
  }
  
  private final kotlin.o<Integer, Float> a(final long paramLong, final VideoTransPara paramVideoTransPara, final csg paramcsg, String paramString, final FinderMediaReportObject paramFinderMediaReportObject, final boolean paramBoolean, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(287563);
    localObject1 = v.c.zYk;
    v.c.qd(true);
    localObject1 = com.tencent.mm.plugin.vlog.model.n.NlN;
    com.tencent.mm.plugin.vlog.model.n.Ao(paramBoolean);
    localObject1 = new Object();
    final aa.a locala = new aa.a();
    locala.aaBx = false;
    Object localObject3 = paramcsg.url;
    if (localObject3 == null)
    {
      paramVideoTransPara = new kotlin.o(Integer.valueOf(-1000), Float.valueOf(0.0F));
      AppMethodBeat.o(287563);
      return paramVideoTransPara;
    }
    p.j(localObject3, "localMedia.url ?: return Pair(-1000, 0f)");
    Object localObject4 = paramcsg.zBo;
    if (localObject4 == null)
    {
      paramVideoTransPara = new kotlin.o(Integer.valueOf(-1001), Float.valueOf(0.0F));
      AppMethodBeat.o(287563);
      return paramVideoTransPara;
    }
    p.j(localObject4, "localMedia.cropInfo ?: return Pair(-1001, 0f)");
    Object localObject2 = new Rect();
    final aa.d locald1 = new aa.d();
    locald1.aaBA = 0;
    final aa.d locald2 = new aa.d();
    locald2.aaBA = 0;
    Object localObject5 = MultiMediaVideoChecker.NmA.cO((String)localObject3, true);
    Object localObject6 = new ad((String)localObject3, 2);
    ((ad)localObject6).So(((css)localObject4).endTime);
    ((ad)localObject6).Sm(((css)localObject4).endTime);
    localObject3 = new ac(kotlin.a.j.listOf(localObject6));
    int j = 0;
    int i = 0;
    if (localObject5 != null)
    {
      j = ((MultiMediaVideoChecker.a)localObject5).width;
      i = ((MultiMediaVideoChecker.a)localObject5).height;
      if ((((MultiMediaVideoChecker.a)localObject5).fSM == 90) || (((MultiMediaVideoChecker.a)localObject5).fSM == 270))
      {
        j = ((MultiMediaVideoChecker.a)localObject5).height;
        i = ((MultiMediaVideoChecker.a)localObject5).width;
      }
      ((ad)localObject6).Nnd.vcr.set(0, 0, j, i);
      ((ac)localObject3).kH(j, i);
      ((Rect)localObject2).set(0, 0, j, i);
      localObject6 = paramFinderMediaReportObject.origin;
      if (localObject6 != null) {
        ((FinderMediaReportInfo)localObject6).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject5).duration);
      }
      localObject6 = paramFinderMediaReportObject.origin;
      if (localObject6 != null) {
        ((FinderMediaReportInfo)localObject6).width = ((MultiMediaVideoChecker.a)localObject5).width;
      }
      localObject6 = paramFinderMediaReportObject.origin;
      if (localObject6 != null) {
        ((FinderMediaReportInfo)localObject6).height = ((MultiMediaVideoChecker.a)localObject5).height;
      }
      localObject6 = paramFinderMediaReportObject.origin;
      if (localObject6 != null) {
        ((FinderMediaReportInfo)localObject6).videoBitrate = ((MultiMediaVideoChecker.a)localObject5).bitrate;
      }
      localObject6 = paramFinderMediaReportObject.origin;
      if (localObject6 != null) {
        ((FinderMediaReportInfo)localObject6).audioBitrate = ((MultiMediaVideoChecker.a)localObject5).audioBitrate;
      }
      localObject6 = paramFinderMediaReportObject.origin;
      if (localObject6 != null) {
        ((FinderMediaReportInfo)localObject6).fps = ((int)((MultiMediaVideoChecker.a)localObject5).cLa);
      }
      localObject5 = x.aazN;
    }
    localObject5 = ((css)localObject4).TAv;
    int k;
    if (localObject5 != null)
    {
      if (paramBoolean)
      {
        ((Rect)localObject2).set(((fbq)localObject5).left, ((fbq)localObject5).bottom, ((fbq)localObject5).right, ((fbq)localObject5).top);
        localObject5 = x.aazN;
      }
    }
    else
    {
      if (!paramBoolean) {
        break label1126;
      }
      k = ((css)localObject4).width;
      label534:
      locald1.aaBA = k;
      if (!paramBoolean) {
        break label1144;
      }
      k = ((css)localObject4).height;
      label553:
      locald2.aaBA = k;
      ((ac)localObject3).x((Rect)localObject2);
      if (paramBoolean)
      {
        localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
        float f = (float)com.tencent.mm.plugin.finder.storage.d.dRW();
        localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
        f /= 1.0F * com.tencent.mm.plugin.finder.storage.d.dRE();
        localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
        paramVideoTransPara.lJH = ((int)(f * com.tencent.mm.plugin.finder.storage.d.dRF()));
        Log.i(TAG, "ABA:  finder video maxVideoSize:" + paramVideoTransPara.lJH);
      }
      localObject4 = new g((ac)localObject3);
      ((g)localObject4).a(paramString, paramVideoTransPara, new Size(j, i), (Rect)localObject2, true, true);
      localObject2 = ((g)localObject4).gsR();
      ((acu)localObject2).NkX.uVk = paramString;
      ((acu)localObject2).NkX.mfh = w.o(paramBoolean, ((ac)localObject3).NmT.getDurationMs());
      localObject3 = new com.tencent.mm.plugin.vlog.model.f();
      ((com.tencent.mm.plugin.vlog.model.f)localObject3).wwk = 2;
      paramcsg = paramcsg.zBo;
      if (paramcsg == null) {
        break label1162;
      }
    }
    label1162:
    for (i = paramcsg.retryCount;; i = 0)
    {
      ((com.tencent.mm.plugin.vlog.model.f)localObject3).retryCount = i;
      ((com.tencent.mm.plugin.vlog.model.f)localObject3).a(true, paramVideoTransPara);
      paramcsg = new aa.c();
      paramcsg.aaBz = 0.0F;
      ((com.tencent.mm.plugin.vlog.model.f)localObject3).Z((kotlin.g.a.b)new e(this, paramcsg, paramInt1, paramInt2));
      paramcsg = new aa.d();
      paramcsg.aaBA = -1;
      ((com.tencent.mm.plugin.vlog.model.f)localObject3).a((acu)localObject2, (kotlin.g.a.b)new f(this, paramcsg, paramFinderMediaReportObject, paramLong, paramString, paramBoolean, locald1, locald2, paramVideoTransPara, localObject1, locala));
      try
      {
        if (!locala.aaBx)
        {
          Log.i(TAG, "wait longvideo");
          localObject1.wait();
          Log.i(TAG, "notify longvideo, " + paramcsg.aaBA);
        }
        paramVideoTransPara = x.aazN;
        paramVideoTransPara = new kotlin.o(Integer.valueOf(paramcsg.aaBA), Float.valueOf(0.0F));
        AppMethodBeat.o(287563);
        return paramVideoTransPara;
      }
      finally
      {
        Object localObject7;
        double d2;
        double d1;
        int m;
        int n;
        int i1;
        AppMethodBeat.o(287563);
      }
      localObject6 = ((css)localObject4).TAw;
      if (localObject6 == null) {
        break;
      }
      localObject7 = ((blk)localObject6).SWx;
      if (localObject7 == null) {
        break;
      }
      localObject6 = new Matrix();
      ((Matrix)localObject6).setValues(kotlin.a.j.r((Collection)localObject7));
      localObject7 = x.aazN;
      d2 = t.e((Matrix)localObject6);
      d1 = d2;
      if (d2 <= 0.0D) {
        d1 = 1.0D;
      }
      localObject6 = aj.AGc;
      k = aj.QC((int)Math.floor((((fbq)localObject5).top - ((fbq)localObject5).bottom) / d1));
      localObject6 = aj.AGc;
      m = aj.QC((int)Math.floor((((fbq)localObject5).right - ((fbq)localObject5).left) / d1));
      n = (int)Math.floor(((fbq)localObject5).left / d1);
      i1 = (int)Math.floor(((fbq)localObject5).bottom / d1);
      ((Rect)localObject2).set(n, i1, n + m, k + i1);
      localObject5 = x.aazN;
      break;
      label1126:
      localObject5 = aj.AGc;
      k = aj.QC(((css)localObject4).width);
      break label534;
      label1144:
      localObject5 = aj.AGc;
      k = aj.QC(((css)localObject4).height);
      break label553;
    }
  }
  
  private static void a(VideoTransPara paramVideoTransPara, csg paramcsg1, String paramString, csg paramcsg2, int paramInt, FinderMediaReportObject paramFinderMediaReportObject, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(287565);
    p.k(paramVideoTransPara, "videoParams");
    p.k(paramcsg1, "localMedia");
    p.k(paramString, "outputPath");
    p.k(paramcsg2, "media");
    p.k(paramFinderMediaReportObject, "reportObject");
    Object localObject1 = aj.AGc;
    localObject1 = aj.aFG(paramString);
    if (localObject1 != null)
    {
      paramcsg1.width = ((com.tencent.mm.plugin.sight.base.b)localObject1).width;
      paramcsg1.height = ((com.tencent.mm.plugin.sight.base.b)localObject1).height;
      paramcsg2.width = ((com.tencent.mm.plugin.sight.base.b)localObject1).width;
      paramcsg2.height = ((com.tencent.mm.plugin.sight.base.b)localObject1).height;
    }
    i = paramVideoTransPara.lJy;
    j = (int)(paramcsg1.height / paramcsg1.width * i);
    str = f.AzZ.aj(paramString, i, j);
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (com.tencent.mm.plugin.finder.storage.d.dVd())
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      i = AdaptiveAdjustBitrate.getVideoImageQuality(com.tencent.mm.plugin.finder.storage.d.dRM(), 0, i, j, 0.8F);
      paramcsg2.TAf = paramFinderMediaReportObject;
      paramcsg2.url = paramString;
      paramcsg2.thumbUrl = str;
      if ((!paramBoolean) && (!paramcsg1.TAe))
      {
        paramFinderMediaReportObject = paramcsg2.TAa;
        if (paramFinderMediaReportObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = paramcsg1.TpG;
        if (localObject1 != null)
        {
          localObject2 = ((acu)localObject1).NkX;
          if (localObject2 != null)
          {
            new Rect();
            if (((acv)localObject2).SoJ == null) {
              continue;
            }
            localObject1 = new Rect();
            localObject2 = ((acv)localObject2).SoJ.Sro;
            p.j(localObject2, "outputConfig.fullScreenConfig.cropRect");
            i.a((duz)localObject2, (Rect)localObject1);
            f1 = paramcsg2.width / ((Rect)localObject1).width();
            localObject1 = new Rect((int)paramFinderMediaReportObject.left, (int)(paramFinderMediaReportObject.top * f1), (int)(paramFinderMediaReportObject.right * f1), (int)(paramFinderMediaReportObject.bottom * f1));
            paramFinderMediaReportObject = (FinderMediaReportObject)localObject1;
            if (((Rect)localObject1).bottom > paramcsg2.height)
            {
              ((Rect)localObject1).bottom = ((int)paramcsg2.height);
              paramFinderMediaReportObject = (FinderMediaReportObject)localObject1;
            }
            j = paramVideoTransPara.lJy;
            int k = (int)(paramFinderMediaReportObject.height() / paramFinderMediaReportObject.width() * j);
            paramVideoTransPara = av.AJz;
            paramVideoTransPara = av.aGg(paramString);
            localObject1 = f.AzZ;
            paramcsg2.thumbUrl = f.a(paramString, paramVideoTransPara, j, k, new Rect(paramFinderMediaReportObject.left, paramFinderMediaReportObject.bottom, paramFinderMediaReportObject.right, paramFinderMediaReportObject.top));
            paramcsg2.TzX = str;
            paramVideoTransPara = x.aazN;
          }
        }
      }
      catch (Exception paramVideoTransPara)
      {
        Object localObject2;
        float f1;
        float f2;
        Log.e(TAG, "crop halfThumb from " + str + " fail:" + paramVideoTransPara.getLocalizedMessage());
        paramVideoTransPara = x.aazN;
        continue;
        j = 0;
        continue;
        i = 0;
        continue;
        boolean bool = false;
        continue;
        paramVideoTransPara = null;
        continue;
      }
      paramcsg2.TzU = false;
      paramcsg2.mediaId = MD5Util.getMD5String(paramcsg1.url);
      paramcsg2.fileSize = ((int)com.tencent.mm.vfs.u.bBQ(paramString));
      paramVideoTransPara = paramcsg2.TAf;
      if (paramVideoTransPara != null) {
        paramVideoTransPara.target = new FinderMediaReportInfo();
      }
      paramVideoTransPara = paramcsg2.TAf;
      if (paramVideoTransPara != null)
      {
        paramVideoTransPara = paramVideoTransPara.target;
        if (paramVideoTransPara != null) {
          paramVideoTransPara.fileSize = paramcsg2.fileSize;
        }
      }
      paramVideoTransPara = paramcsg2.TAf;
      if (paramVideoTransPara != null)
      {
        paramFinderMediaReportObject = paramcsg2.TAf;
        if (paramFinderMediaReportObject == null) {
          continue;
        }
        paramFinderMediaReportObject = paramFinderMediaReportObject.target;
        if (paramFinderMediaReportObject == null) {
          continue;
        }
        j = paramFinderMediaReportObject.fileSize;
        paramVideoTransPara.videoFinalSize = j;
      }
      paramVideoTransPara = paramcsg2.TpG;
      if (paramVideoTransPara != null) {
        paramVideoTransPara.Sox = false;
      }
      if (paramcsg2.codec_info == null) {
        paramcsg2.codec_info = new bea();
      }
      paramVideoTransPara = paramcsg2.codec_info;
      if (paramVideoTransPara != null)
      {
        paramVideoTransPara.SPf = paramFloat2;
        paramVideoTransPara.SPh = paramFloat1;
        paramVideoTransPara.SPi = i;
        paramFinderMediaReportObject = paramcsg2.TpG;
        if (paramFinderMediaReportObject == null) {
          continue;
        }
        paramFinderMediaReportObject = paramFinderMediaReportObject.NkY;
        if (paramFinderMediaReportObject == null) {
          continue;
        }
        paramFinderMediaReportObject = paramFinderMediaReportObject.Sor;
        if (paramFinderMediaReportObject == null) {
          continue;
        }
        i = paramFinderMediaReportObject.size();
        if (i <= 0) {
          continue;
        }
        bool = true;
        paramVideoTransPara.SPk = bool;
        Log.i(TAG, "codec_info video_score:" + paramVideoTransPara.SPf + ",video_cover_score:" + paramVideoTransPara.SPg + ",video_audio_score:" + paramVideoTransPara.SPh + ",thumb_score:" + paramVideoTransPara.SPi + ",hdimg_score:" + paramVideoTransPara.SPj + ",has_stickers:" + paramVideoTransPara.SPk);
      }
      paramVideoTransPara = paramcsg2.TAf;
      if (paramVideoTransPara == null) {
        continue;
      }
      paramVideoTransPara = paramVideoTransPara.codecInfo;
      if (paramVideoTransPara == null)
      {
        paramVideoTransPara = paramcsg2.TAf;
        if (paramVideoTransPara != null) {
          paramVideoTransPara.codecInfo = paramcsg2.codec_info;
        }
      }
      paramVideoTransPara = MultiMediaVideoChecker.NmA.bfs(paramString);
      if (paramVideoTransPara != null)
      {
        paramcsg2.videoDuration = kotlin.h.a.dm((float)paramVideoTransPara.duration / 1000.0F);
        paramFinderMediaReportObject = paramcsg2.TAf;
        if (paramFinderMediaReportObject != null)
        {
          paramFinderMediaReportObject = paramFinderMediaReportObject.target;
          if (paramFinderMediaReportObject != null) {
            paramFinderMediaReportObject.videoDuration = ((int)paramVideoTransPara.duration);
          }
        }
        paramFinderMediaReportObject = paramcsg2.TAf;
        if (paramFinderMediaReportObject != null)
        {
          paramFinderMediaReportObject = paramFinderMediaReportObject.target;
          if (paramFinderMediaReportObject != null) {
            paramFinderMediaReportObject.width = paramVideoTransPara.width;
          }
        }
        paramFinderMediaReportObject = paramcsg2.TAf;
        if (paramFinderMediaReportObject != null)
        {
          paramFinderMediaReportObject = paramFinderMediaReportObject.target;
          if (paramFinderMediaReportObject != null) {
            paramFinderMediaReportObject.height = paramVideoTransPara.height;
          }
        }
        paramFinderMediaReportObject = paramcsg2.TAf;
        if (paramFinderMediaReportObject != null)
        {
          paramFinderMediaReportObject = paramFinderMediaReportObject.target;
          if (paramFinderMediaReportObject != null) {
            paramFinderMediaReportObject.videoBitrate = paramVideoTransPara.bitrate;
          }
        }
        paramFinderMediaReportObject = paramcsg2.TAf;
        if (paramFinderMediaReportObject != null)
        {
          paramFinderMediaReportObject = paramFinderMediaReportObject.target;
          if (paramFinderMediaReportObject != null) {
            paramFinderMediaReportObject.audioBitrate = paramVideoTransPara.audioBitrate;
          }
        }
        paramcsg2 = paramcsg2.TAf;
        if (paramcsg2 != null)
        {
          paramcsg2 = paramcsg2.target;
          if (paramcsg2 != null) {
            paramcsg2.fps = ((int)paramVideoTransPara.cLa);
          }
        }
      }
      Log.i(TAG, "processList index " + paramInt + " url " + paramcsg1.url + " thumbUrl: " + paramcsg1.thumbUrl + " newMd5: " + MD5Util.getMD5String(paramcsg1.url) + " size:" + Util.getSizeKB(com.tencent.mm.vfs.u.bBQ(paramcsg1.url)));
      paramVideoTransPara = com.tencent.mm.plugin.vlog.model.n.NlN;
      com.tencent.mm.plugin.vlog.model.n.c(paramString, paramFloat2, paramBoolean);
      paramVideoTransPara = com.tencent.mm.plugin.vlog.model.n.NlN;
      com.tencent.mm.plugin.vlog.model.n.gtf();
      AppMethodBeat.o(287565);
      return;
      i = 0;
      break;
      f1 = paramcsg2.width / ((acv)localObject2).BXA;
      f2 = paramcsg2.height / ((acv)localObject2).BXB;
      paramFinderMediaReportObject = new Rect((int)(paramFinderMediaReportObject.left * f1), (int)(paramFinderMediaReportObject.top * f2), (int)(f1 * paramFinderMediaReportObject.right), (int)(paramFinderMediaReportObject.bottom * f2));
    }
  }
  
  private final void eca()
  {
    AppMethodBeat.i(287560);
    com.tencent.mm.plugin.finder.storage.logic.c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
    com.tencent.mm.plugin.finder.storage.logic.c.a.s(this.Azr);
    AppMethodBeat.o(287560);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(167732);
    long l = this.Azr.getLocalId();
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
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    int i = (int)(com.tencent.mm.plugin.finder.storage.d.dSr() * f);
    Log.i(TAG, "feed " + this.Azr.getLocalId() + " updateProgress  " + f + ", " + i);
    if (this.Azr.getPostInfo().TAi < i)
    {
      this.Azr.getPostInfo().TAi = i;
      localObject = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
      com.tencent.mm.plugin.finder.storage.logic.c.a.s(this.Azr);
    }
    localObject = EventCenter.instance;
    hr localhr = new hr();
    localhr.fEI.localId = this.Azr.getLocalId();
    localhr.fEI.progress = this.Azr.getPostInfo().TAi;
    ((EventCenter)localObject).publish((IEvent)localhr);
    AppMethodBeat.o(167733);
  }
  
  public final void start()
  {
    AppMethodBeat.i(287559);
    this.Azr.trackPost("mediaProcess");
    Object localObject1 = this.Azr.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 2;
    }
    final List localList1 = (List)new ArrayList();
    final List localList2 = (List)new ArrayList();
    localObject1 = ((Iterable)this.Azr.getHalfVideoMediaExtList()).iterator();
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (csg)((Iterator)localObject1).next();
      localObject5 = ((csg)localObject4).TpG;
      if ((localObject5 != null) && (((acu)localObject5).Sox == true)) {
        localList1.add(localObject4);
      }
    }
    localObject1 = (Iterable)this.Azr.getMediaList();
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    int j;
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = ((Iterator)localObject1).next();
      j = i + 1;
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject4 = (csg)localObject4;
      if (this.Azr.isNeedCrop(i))
      {
        if (this.Azr.getCropInfo(i) != null) {
          localList1.add(localObject4);
        }
        i = j;
      }
      else
      {
        if ((this.Azr.isNeedVideoCompositionPlay(i)) && (this.Azr.getCropInfo(i) != null)) {
          localList1.add(localObject4);
        }
        i = j;
      }
    }
    localObject1 = (Iterable)this.Azr.getLongVideoMediaExtList();
    i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject4 = (csg)localObject4;
      if ((((csg)localObject4).TzU) && (((csg)localObject4).zBo != null))
      {
        localList1.add(localObject4);
        localList2.add(localObject4);
      }
      i += 1;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if ((com.tencent.mm.plugin.finder.storage.d.dSt()) && (Log.getLogLevel() >= 0))
    {
      Log.i(TAG, "debug blocking, sleep.....");
      Thread.sleep(30000L);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dSo().aSr()).intValue() == 1)
    {
      a(com.tencent.mm.loader.g.j.kQe);
      AppMethodBeat.o(287559);
      return;
    }
    if (localList1.size() <= 0)
    {
      Log.i(TAG, "nothing need to be processed");
      bi(1.0F);
      a(com.tencent.mm.loader.g.j.kQd);
      AppMethodBeat.o(287559);
      return;
    }
    Log.i(TAG, "process media count " + localList1.size());
    localObject1 = v.d.zYG;
    v.d.qp(this.Azr.isLongVideo());
    Iterator localIterator = ((Iterable)localList1).iterator();
    final int k = 0;
    int m;
    csg localcsg;
    label684:
    boolean bool2;
    label692:
    label713:
    boolean bool3;
    label721:
    label736:
    boolean bool7;
    FinderMediaReportObject localFinderMediaReportObject;
    Object localObject7;
    Object localObject6;
    label1144:
    label1150:
    String str2;
    label1156:
    label1162:
    label1175:
    label1186:
    nd localnd;
    long l;
    label1274:
    String str1;
    int n;
    int i1;
    label1318:
    int i2;
    label1375:
    label1532:
    boolean bool6;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      m = k + 1;
      if (k < 0) {
        kotlin.a.j.iBO();
      }
      localcsg = (csg)localObject1;
      localObject1 = localcsg.zBo;
      if (localObject1 != null) {}
      for (i = ((css)localObject1).retryCount;; i = 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (i <= com.tencent.mm.plugin.finder.storage.d.dSp()) {
          break;
        }
        a(com.tencent.mm.loader.g.j.kQe);
        AppMethodBeat.o(287559);
        return;
      }
      localObject1 = localList2.iterator();
      i = 0;
      if (((Iterator)localObject1).hasNext()) {
        if (p.h(((csg)((Iterator)localObject1).next()).mediaId, localcsg.mediaId))
        {
          if (i < 0) {
            break label1144;
          }
          bool2 = true;
          if (bool2) {
            break label1156;
          }
          if (((Collection)localList2).isEmpty()) {
            break label1150;
          }
          i = 1;
          if (i == 0) {
            break label1156;
          }
          bool3 = true;
          if (!bool2) {
            break label1162;
          }
          localObject1 = com.tencent.mm.plugin.finder.ui.config.a.AxF;
          localObject4 = com.tencent.mm.plugin.finder.ui.config.a.ebF();
          Log.i(TAG, "FinderMediaProcessTask index " + k + " isLongVideo:" + bool2 + " videoParams " + localObject4);
          localObject1 = localcsg.zBo;
          if (localObject1 != null)
          {
            localObject5 = localcsg.zBo;
            if (localObject5 == null) {
              break label1175;
            }
          }
        }
      }
      for (i = ((css)localObject5).retryCount;; i = 0)
      {
        ((css)localObject1).retryCount = (i + 1);
        if (bool2)
        {
          localObject1 = this.Azr.field_reportObject;
          if (localObject1 != null) {
            ((FinderFeedReportObject)localObject1).postStage = 6;
          }
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        com.tencent.mm.plugin.finder.storage.logic.c.a.s(this.Azr);
        localObject1 = aj.AGc;
        bool7 = aj.g(localcsg);
        localFinderMediaReportObject = new FinderMediaReportObject();
        localFinderMediaReportObject.mediaType = localcsg.mediaType;
        localFinderMediaReportObject.origin = new FinderMediaReportInfo();
        localFinderMediaReportObject.multiMediaInfo = new LinkedList();
        localObject1 = localcsg.TpG;
        if (localObject1 == null) {
          break label1186;
        }
        localObject1 = ((acu)localObject1).Sou;
        if (localObject1 == null) {
          break label1186;
        }
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject7 = (eth)((Iterator)localObject1).next();
          localObject5 = new FinderMediaReportInfo();
          ((FinderMediaReportInfo)localObject5).fileSize = ((int)com.tencent.mm.vfs.u.bBQ(((eth)localObject7).path));
          localObject6 = MultiMediaVideoChecker.NmA;
          localObject7 = ((eth)localObject7).path;
          p.j(localObject7, "track.path");
          localObject6 = ((MultiMediaVideoChecker)localObject6).bfs((String)localObject7);
          if (localObject6 != null)
          {
            ((FinderMediaReportInfo)localObject5).width = ((MultiMediaVideoChecker.a)localObject6).width;
            ((FinderMediaReportInfo)localObject5).height = ((MultiMediaVideoChecker.a)localObject6).height;
            ((FinderMediaReportInfo)localObject5).videoBitrate = ((MultiMediaVideoChecker.a)localObject6).bitrate;
            ((FinderMediaReportInfo)localObject5).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject6).duration);
            ((FinderMediaReportInfo)localObject5).audioBitrate = ((MultiMediaVideoChecker.a)localObject6).audioBitrate;
            ((FinderMediaReportInfo)localObject5).fps = ((int)((MultiMediaVideoChecker.a)localObject6).cLa);
            Log.i(TAG, "put multiMediaInfo:".concat(String.valueOf(localObject6)));
            localObject6 = x.aazN;
          }
          localFinderMediaReportObject.multiMediaInfo.add(localObject5);
        }
        i += 1;
        break;
        i = -1;
        break label684;
        bool2 = false;
        break label692;
        i = 0;
        break label713;
        bool3 = false;
        break label721;
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        localObject4 = com.tencent.mm.plugin.finder.storage.d.dRJ();
        break label736;
      }
      localObject1 = x.aazN;
      str2 = UUID.randomUUID().toString();
      p.j(str2, "UUID.randomUUID().toString()");
      localObject1 = com.tencent.mm.plugin.vlog.report.c.NqY;
      localnd = com.tencent.mm.plugin.vlog.report.c.bfG(str2);
      l = Util.currentTicks();
      localObject5 = new aa(localcsg, com.tencent.mm.plugin.finder.storage.u.AlL, 0, null, 12);
      localObject1 = av.AJz;
      localObject6 = new StringBuilder().append(this.Azr.getCreateTime());
      if (localcsg.TAe)
      {
        localObject1 = "_half";
        str1 = av.a((aa)localObject5, (String)localObject1);
        n = 1;
        i1 = 2;
        localObject1 = com.tencent.mm.plugin.vlog.model.n.NlN;
        if (!com.tencent.mm.plugin.vlog.model.n.gsU()) {
          break label2911;
        }
        localObject1 = com.tencent.mm.plugin.vlog.model.n.NlN;
        j = com.tencent.mm.plugin.vlog.model.n.gsW();
        i2 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXr, 1);
        localObject1 = localcsg.TpG;
        if (localObject1 == null) {
          break label2934;
        }
        localObject1 = ((acu)localObject1).Sou;
        if (localObject1 == null) {
          break label2934;
        }
        localObject1 = (eth)kotlin.a.j.lp((List)localObject1);
        localObject5 = localcsg.TpG;
        if (localObject5 == null) {
          break label2964;
        }
        localObject5 = ((acu)localObject5).Sou;
        if ((localObject5 == null) || (((LinkedList)localObject5).size() != 1)) {
          break label2964;
        }
        localObject5 = localcsg.TpG;
        if (localObject5 == null) {
          break label2940;
        }
        localObject5 = ((acu)localObject5).NkY;
        if (localObject5 == null) {
          break label2940;
        }
        localObject5 = ((act)localObject5).Sor;
        if (localObject5 == null) {
          break label2940;
        }
        i = ((LinkedList)localObject5).size();
        label1451:
        if (i != 0) {
          break label2964;
        }
        localObject5 = localcsg.TpG;
        if ((localObject5 == null) || (((acu)localObject5).NmV)) {
          break label2964;
        }
        localObject5 = localcsg.TpG;
        if (localObject5 == null) {
          break label2946;
        }
        localObject5 = ((acu)localObject5).Soz;
        label1495:
        if ((localObject5 != null) || (localObject1 == null)) {
          break label2964;
        }
        if (((eth)localObject1).Uvv != null)
        {
          localObject5 = ((eth)localObject1).Uvv;
          if (localObject5 == null) {
            break label2952;
          }
          localObject5 = ((eus)localObject5).path;
          localObject5 = (CharSequence)localObject5;
          if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
            break label2958;
          }
          i = 1;
          label1557:
          if (i == 0) {
            break label2964;
          }
        }
        if (((eth)localObject1).endTimeMs - ((eth)localObject1).startTimeMs != ((eth)localObject1).MQW - ((eth)localObject1).MQV) {
          break label2964;
        }
        bool6 = true;
        label1591:
        localObject5 = TAG;
        localObject6 = new StringBuilder("process: config: ").append(j).append(", checkNoNeedRemux:").append(i2).append(", trackSize: ");
        localObject1 = localcsg.TpG;
        if (localObject1 == null) {
          break label2970;
        }
        localObject1 = ((acu)localObject1).Sou;
        if (localObject1 == null) {
          break label2970;
        }
        localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
        label1664:
        localObject6 = ((StringBuilder)localObject6).append(localObject1).append(", editSize: ");
        localObject1 = localcsg.TpG;
        if (localObject1 == null) {
          break label2976;
        }
        localObject1 = ((acu)localObject1).NkY;
        if (localObject1 == null) {
          break label2976;
        }
        localObject1 = ((act)localObject1).Sor;
        if (localObject1 == null) {
          break label2976;
        }
        localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
        label1725:
        Log.i((String)localObject5, localObject1 + ", videoIsNoEffect:" + bool6);
        if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQH, 0) != 1) {
          break label7376;
        }
      }
    }
    label1822:
    label1980:
    label3008:
    label3020:
    label5071:
    label7376:
    for (boolean bool4 = true;; bool4 = false)
    {
      float f3 = ((VideoTransPara)localObject4).audioBitrate / 1000.0F;
      float f4 = ((VideoTransPara)localObject4).audioSampleRate;
      int i8 = ((VideoTransPara)localObject4).audioChannelCount;
      localObject1 = localcsg.TpG;
      boolean bool5;
      if (localObject1 != null)
      {
        bool5 = ((acu)localObject1).NmU;
        if ((i2 != 1) || (!bool6)) {
          break label3055;
        }
        localObject1 = localcsg.TpG;
        if (localObject1 != null)
        {
          localObject1 = ((acu)localObject1).Sou;
          if (localObject1 != null)
          {
            localObject1 = (eth)((LinkedList)localObject1).get(0);
            if (localObject1 != null) {
              break label7373;
            }
          }
        }
        localObject1 = new eth();
      }
      boolean bool1;
      for (;;)
      {
        p.j(localObject1, "it.videoCompositionInfo?…et(0) ?: TrackInfoProto()");
        localObject5 = ((eth)localObject1).path;
        p.j(localObject5, "track.path");
        localObject5 = MultiMediaVideoChecker.NmA.bfs((String)localObject5);
        Object localObject8;
        if (localObject5 != null) {
          if ((((MultiMediaVideoChecker.a)localObject5).fSM == 90) || (((MultiMediaVideoChecker.a)localObject5).fSM == 270))
          {
            i = ((MultiMediaVideoChecker.a)localObject5).height;
            double d = i;
            if ((((MultiMediaVideoChecker.a)localObject5).fSM != 90) && (((MultiMediaVideoChecker.a)localObject5).fSM != 270)) {
              break label2998;
            }
            i = ((MultiMediaVideoChecker.a)localObject5).width;
            d = 1.0D * d / i;
            Log.i(TAG, "origin videoInfo:" + localObject5 + ", videoParams:" + localObject4 + ", videoRatio:" + d);
            localObject6 = TAG;
            localObject7 = new StringBuilder("videoRatio in range:");
            localObject8 = com.tencent.mm.plugin.finder.storage.d.AjH;
            localObject7 = ((StringBuilder)localObject7).append(com.tencent.mm.plugin.finder.storage.d.dTC().g((Comparable)Double.valueOf(d))).append(", finderVideoRatioRange:");
            localObject8 = com.tencent.mm.plugin.finder.storage.d.AjH;
            Log.i((String)localObject6, com.tencent.mm.plugin.finder.storage.d.dTC());
            if ((((MultiMediaVideoChecker.a)localObject5).FeD) || (((MultiMediaVideoChecker.a)localObject5).bitrate > ((VideoTransPara)localObject4).videoBitrate) || (((MultiMediaVideoChecker.a)localObject5).cLa > ((VideoTransPara)localObject4).fps)) {
              break label3008;
            }
            localObject5 = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (!com.tencent.mm.plugin.finder.storage.d.dTC().g((Comparable)Double.valueOf(d))) {
              break label3008;
            }
            bool1 = true;
            label2166:
            localObject5 = localcsg.TpG;
            if (localObject5 == null) {
              break label3020;
            }
            localObject5 = ((acu)localObject5).kXi;
            boolean bool8 = Util.isNullOrNil((String)localObject5);
            Log.i(TAG, "isVideoSizeMatch:" + bool1 + "， noMusic:" + bool8);
            if ((!bool1) || (!bool8)) {
              break label3055;
            }
            localObject5 = new Rect();
            localObject6 = new Rect();
            localObject7 = ((eth)localObject1).Uvu.Sro;
            p.j(localObject7, "track.cropInfo.cropRect");
            i.a((duz)localObject7, (Rect)localObject5);
            localObject7 = ((eth)localObject1).Uvu.Srq;
            p.j(localObject7, "track.cropInfo.contentRect");
            i.a((duz)localObject7, (Rect)localObject6);
            Log.i(TAG, "cropRect:" + localObject5 + ", contentRect:" + localObject6 + ", track:[" + ((eth)localObject1).MQV + ", " + ((eth)localObject1).MQW + ", " + ((eth)localObject1).NwS + ']');
            if ((((eth)localObject1).MQV != 0L) || (((eth)localObject1).NwS - ((eth)localObject1).MQW > 10L) || (((eth)localObject1).NwS > ((VideoTransPara)localObject4).duration * 1000) || (!p.h(localObject5, localObject6))) {
              break label3055;
            }
            bool1 = SightVideoJNI.optimizeMP4VFS(((eth)localObject1).path);
            localObject5 = aj.AGc;
            localObject5 = ((eth)localObject1).path;
            p.j(localObject5, "track.path");
            bool8 = aj.aFO((String)localObject5);
            Log.i(TAG, "moovSucc:" + bool1 + ", isOptimize:" + bool8);
            if (!bool8) {
              break label3032;
            }
            Log.i(TAG, "no need remux!!!");
            i = 3;
            com.tencent.mm.vfs.u.on(((eth)localObject1).path, str1);
          }
        }
        label2666:
        label3055:
        label4850:
        label5107:
        try
        {
          localObject1 = AdaptiveAdjustBitrate.a(str1, ((eth)localObject1).Nna, ((eth)localObject1).Nnb, ((VideoTransPara)localObject4).fps, ((VideoTransPara)localObject4).videoBitrate, (float)((eth)localObject1).NwS / 1000.0F, ((VideoTransPara)localObject4).lJB, ((VideoTransPara)localObject4).lJC, ((VideoTransPara)localObject4).lJF, ((VideoTransPara)localObject4).lJG);
          if ((localObject1 == null) || (localObject1.length < 28)) {
            break label7368;
          }
          i1 = localObject1[27];
          f1 = i1;
        }
        catch (Throwable localThrowable2)
        {
          label2934:
          label5238:
          for (;;)
          {
            label2940:
            label3070:
            label3711:
            float f2 = 0.0F;
            label3834:
            label4862:
            continue;
            label4856:
            label5113:
            label6394:
            float f1 = 0.0F;
          }
        }
        f2 = f1;
        if (bool1) {}
        try
        {
          SightVideoJNI.addReportMetadata(str1, null, ((VideoTransPara)localObject4).lJz, 0);
          f2 = f1;
        }
        catch (Throwable localThrowable3)
        {
          for (;;)
          {
            label2911:
            label4713:
            label4844:
            label5101:
            f2 = f1;
            label3032:
            label3550:
            label4838:
            label5095:
            continue;
            label3674:
            label3932:
            label5089:
            label5219:
            f1 = f2;
            label5077:
            label5083:
            n = i;
            label6229:
            i = j;
            label7251:
            j = n;
            continue;
            j = i;
            i = 0;
            continue;
            continue;
            continue;
            continue;
            Object localObject3 = null;
            bool1 = bool7;
            continue;
            localObject3 = null;
            bool1 = false;
            continue;
            bool1 = false;
            continue;
            j = i;
            i = 0;
          }
        }
        localObject1 = v.c.zYk;
        if ((bool2) || (bool3))
        {
          bool1 = true;
          v.c.qg(bool1);
          f1 = f2;
          if (i == 3) {
            break label7358;
          }
          localObject1 = localcsg.TpG;
          if (localObject1 == null) {
            break label3070;
          }
          localObject1 = ((acu)localObject1).Sou;
          if (localObject1 == null) {
            break label3070;
          }
          localObject5 = (eth)((LinkedList)localObject1).get(0);
        }
        for (;;)
        {
          if ((bool6) && (localObject5 != null))
          {
            localObject1 = new Rect();
            localObject6 = new Rect();
            localObject7 = ((eth)localObject5).Uvu.Sro;
            p.j(localObject7, "track.cropInfo.cropRect");
            i.a((duz)localObject7, (Rect)localObject1);
            localObject7 = ((eth)localObject5).Uvu.Srr;
            p.j(localObject7, "track.cropInfo.trackCropRect");
            i.a((duz)localObject7, (Rect)localObject6);
            bool1 = ((Rect)localObject6).contains((Rect)localObject1);
            Log.i(TAG, "process: crop: " + localObject1 + ", content: " + localObject6);
            int i6;
            if ((bool2) || (bool3))
            {
              if (j != 1)
              {
                if (((Number)a(l, (VideoTransPara)localObject4, localcsg, str1, localFinderMediaReportObject, bool2, k, localList1.size()).Mx).intValue() < 0)
                {
                  a(com.tencent.mm.loader.g.j.kQe);
                  AppMethodBeat.o(287559);
                  return;
                  localObject1 = "";
                  break label1274;
                  j = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKz, 0);
                  break label1318;
                  localObject1 = null;
                  break label1375;
                  i = 0;
                  break label1451;
                  localObject5 = null;
                  break label1495;
                  localObject5 = null;
                  break label1532;
                  i = 0;
                  break label1557;
                  bool6 = false;
                  break label1591;
                  localObject1 = null;
                  break label1664;
                  localObject1 = null;
                  break label1725;
                  bool5 = true;
                  break label1822;
                  i = ((MultiMediaVideoChecker.a)localObject5).width;
                  break label1948;
                  i = ((MultiMediaVideoChecker.a)localObject5).height;
                  break label1980;
                  bool1 = false;
                  break label2166;
                  bool1 = false;
                  break label2166;
                  localObject5 = null;
                  break label2185;
                  bool1 = false;
                  break label2666;
                  localObject1 = v.c.zYk;
                  if ((bool2) || (bool3)) {}
                  for (bool1 = true;; bool1 = false)
                  {
                    v.c.qi(bool1);
                    f1 = 0.0F;
                    i = i1;
                    break;
                  }
                  localObject5 = null;
                  continue;
                }
                localObject6 = MultiMediaVideoChecker.NmA.bfs(str1);
                if ((localObject6 != null) && (((MultiMediaVideoChecker.a)localObject6).width > 0) && (((MultiMediaVideoChecker.a)localObject6).height > 0) && (((MultiMediaVideoChecker.a)localObject6).cLa > 0.0F)) {
                  break label7343;
                }
                localObject4 = TAG;
                localObject5 = new StringBuilder("remuxVideo file error: ");
                if (localObject6 != null)
                {
                  localObject1 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject6).width);
                  localObject5 = ((StringBuilder)localObject5).append(localObject1).append(' ');
                  if (localObject6 == null) {
                    break label3213;
                  }
                }
                for (localObject1 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject6).height);; localObject1 = null)
                {
                  Log.i((String)localObject4, localObject1);
                  a(com.tencent.mm.loader.g.j.kQe);
                  AppMethodBeat.o(287559);
                  return;
                  localObject1 = null;
                  break;
                }
              }
              localObject1 = null;
              bool1 = true;
              if (!bool1) {
                break label6852;
              }
              i6 = 1;
              localObject6 = localFinderMediaReportObject.origin;
              if (localObject6 != null) {
                ((FinderMediaReportInfo)localObject6).fileSize = ((int)com.tencent.mm.vfs.u.bBQ(localcsg.url));
              }
              localObject8 = MultiMediaVideoChecker.NmA;
              localObject7 = localcsg.url;
              localObject6 = localObject7;
              if (localObject7 == null) {
                localObject6 = "";
              }
              localObject6 = ((MultiMediaVideoChecker)localObject8).bfs((String)localObject6);
              if (localObject6 == null) {
                break label5113;
              }
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
                ((FinderMediaReportInfo)localObject7).fps = ((int)((MultiMediaVideoChecker.a)localObject6).cLa);
              }
              i2 = ((MultiMediaVideoChecker.a)localObject6).width;
              i1 = ((MultiMediaVideoChecker.a)localObject6).height;
              localObject7 = x.aazN;
            }
            for (;;)
            {
              if (localObject6 != null) {
                break label5122;
              }
              a(com.tencent.mm.loader.g.j.kQe);
              AppMethodBeat.o(287559);
              return;
              if ((j != 1) || (!bool6) || (!bool1) || (localObject5 == null)) {
                break label7333;
              }
              Log.i(TAG, "process, force use normal video");
              bool6 = true;
              localObject7 = localcsg.TpG;
              localObject1 = localcsg.zBo;
              if (localObject7 != null)
              {
                localObject6 = ((acu)localObject7).Sou;
                if (localObject6 != null)
                {
                  localObject8 = (eth)((LinkedList)localObject6).get(0);
                  if (localObject8 != null) {
                    break label4018;
                  }
                }
              }
              localcsg.url = ((eth)localObject5).path;
              localObject1 = localcsg.TpG;
              if (localObject1 != null)
              {
                localObject6 = ((acu)localObject1).kXi;
                localObject1 = localObject6;
                if (localObject6 != null) {}
              }
              else
              {
                localObject1 = "";
              }
              localObject6 = localcsg.TpG;
              if (localObject6 != null)
              {
                bool1 = ((acu)localObject6).NmU;
                if (Util.isNullOrNil((String)localObject1)) {
                  break label5036;
                }
                j = 1;
                if (!bool1) {
                  break label5048;
                }
                if (j == 0) {
                  break label5042;
                }
                j = 3;
                localObject7 = TAG;
                localObject8 = new StringBuilder("process, time: [");
                localObject6 = localcsg.zBo;
                if (localObject6 == null) {
                  break label5065;
                }
                localObject6 = Integer.valueOf(((css)localObject6).fod);
                localObject8 = ((StringBuilder)localObject8).append(localObject6).append(", ");
                localObject6 = localcsg.zBo;
                if (localObject6 == null) {
                  break label5071;
                }
                localObject6 = Integer.valueOf(((css)localObject6).endTime);
                localObject8 = ((StringBuilder)localObject8).append(localObject6).append("], size: [");
                localObject6 = localcsg.zBo;
                if (localObject6 == null) {
                  break label5077;
                }
                localObject6 = Integer.valueOf(((css)localObject6).width);
                localObject8 = ((StringBuilder)localObject8).append(localObject6).append(", ");
                localObject6 = localcsg.zBo;
                if (localObject6 == null) {
                  break label5083;
                }
                localObject6 = Integer.valueOf(((css)localObject6).height);
                localObject8 = ((StringBuilder)localObject8).append(localObject6).append("], crop: [");
                localObject6 = localcsg.zBo;
                if (localObject6 == null) {
                  break label5089;
                }
                localObject6 = ((css)localObject6).TAv;
                if (localObject6 == null) {
                  break label5089;
                }
                localObject6 = Integer.valueOf(((fbq)localObject6).left);
                localObject8 = ((StringBuilder)localObject8).append(localObject6).append(", ");
                localObject6 = localcsg.zBo;
                if (localObject6 == null) {
                  break label5095;
                }
                localObject6 = ((css)localObject6).TAv;
                if (localObject6 == null) {
                  break label5095;
                }
                localObject6 = Integer.valueOf(((fbq)localObject6).top);
                localObject8 = ((StringBuilder)localObject8).append(localObject6).append(", ");
                localObject6 = localcsg.zBo;
                if (localObject6 == null) {
                  break label5101;
                }
                localObject6 = ((css)localObject6).TAv;
                if (localObject6 == null) {
                  break label5101;
                }
                localObject6 = Integer.valueOf(((fbq)localObject6).right);
                localObject8 = ((StringBuilder)localObject8).append(localObject6).append(", ");
                localObject6 = localcsg.zBo;
                if (localObject6 == null) {
                  break label5107;
                }
                localObject6 = ((css)localObject6).TAv;
                if (localObject6 == null) {
                  break label5107;
                }
              }
              for (localObject6 = Integer.valueOf(((fbq)localObject6).bottom);; localObject6 = null)
              {
                Log.i((String)localObject7, localObject6 + "], mixType: " + j);
                bool1 = bool6;
                n = j;
                break;
                p.j(localObject8, "compositionInfo?.tracks?.get(0) ?: return");
                i1 = SightVideoJNI.getMp4RotateVFS(((eth)localObject8).path);
                if (localObject1 != null) {
                  ((css)localObject1).fod = ((int)(((acu)localObject7).Sov + ((eth)localObject8).MQV));
                }
                if (localObject1 != null) {
                  ((css)localObject1).endTime = ((int)(((acu)localObject7).Sow + ((eth)localObject8).MQV));
                }
                f2 = ((eth)localObject8).Nna;
                float f5 = ((eth)localObject8).Nnc;
                j = ((Number)((eth)localObject8).Uvu.Srq.TDA.get(2)).intValue();
                localObject6 = ((eth)localObject8).Uvu.Srq.TDA.get(0);
                p.j(localObject6, "track.cropInfo.contentRect.values[0]");
                f2 = 1.0F * (f2 * f5) / (j - ((Number)localObject6).intValue());
                localObject6 = new fbq();
                j = ((Number)((eth)localObject8).Uvu.Sro.TDA.get(0)).intValue();
                Object localObject9 = ((eth)localObject8).Uvu.Srq.TDA.get(0);
                p.j(localObject9, "track.cropInfo.contentRect.values[0]");
                ((fbq)localObject6).left = ((int)((j - ((Number)localObject9).intValue()) * f2));
                j = ((Number)((eth)localObject8).Uvu.Sro.TDA.get(1)).intValue();
                localObject9 = ((eth)localObject8).Uvu.Srq.TDA.get(1);
                p.j(localObject9, "track.cropInfo.contentRect.values[1]");
                ((fbq)localObject6).bottom = ((int)((j - ((Number)localObject9).intValue()) * f2));
                j = ((Number)((eth)localObject8).Uvu.Sro.TDA.get(2)).intValue();
                localObject9 = ((eth)localObject8).Uvu.Srq.TDA.get(0);
                p.j(localObject9, "track.cropInfo.contentRect.values[0]");
                ((fbq)localObject6).right = ((int)((j - ((Number)localObject9).intValue()) * f2));
                j = ((Number)((eth)localObject8).Uvu.Sro.TDA.get(3)).intValue();
                localObject9 = ((eth)localObject8).Uvu.Srq.TDA.get(1);
                p.j(localObject9, "track.cropInfo.contentRect.values[1]");
                ((fbq)localObject6).top = ((int)((j - ((Number)localObject9).intValue()) * f2));
                if (localObject1 != null) {
                  ((css)localObject1).TAv = ((fbq)localObject6);
                }
                j = ((Number)((eth)localObject8).Uvu.Srq.TDA.get(2)).intValue();
                localObject9 = ((eth)localObject8).Uvu.Srq.TDA.get(0);
                p.j(localObject9, "track.cropInfo.contentRect.values[0]");
                i2 = (int)((j - ((Number)localObject9).intValue()) * f2);
                j = ((Number)((eth)localObject8).Uvu.Srq.TDA.get(3)).intValue();
                localObject8 = ((eth)localObject8).Uvu.Srq.TDA.get(1);
                p.j(localObject8, "track.cropInfo.contentRect.values[1]");
                i3 = (int)((j - ((Number)localObject8).intValue()) * f2);
                if (localObject1 != null)
                {
                  localObject8 = ((css)localObject1).TAv;
                  if (localObject8 != null)
                  {
                    j = ((fbq)localObject8).right;
                    if (localObject1 == null) {
                      break label4838;
                    }
                    localObject8 = ((css)localObject1).TAv;
                    if (localObject8 == null) {
                      break label4838;
                    }
                    n = ((fbq)localObject8).left;
                    f2 = j - n;
                    localObject8 = ((acu)localObject7).NkX;
                    if (localObject8 == null) {
                      break label4844;
                    }
                    j = ((acv)localObject8).targetWidth;
                    f2 = 1.0F * f2 / j;
                    if (f2 <= 1.0F) {
                      break label7330;
                    }
                    f2 = 1.0F;
                    if (localObject1 != null)
                    {
                      localObject8 = ((acu)localObject7).NkX;
                      if (localObject8 == null) {
                        break label4850;
                      }
                      j = ((acv)localObject8).targetWidth;
                      ((css)localObject1).width = ((int)(j * f2));
                    }
                    if (localObject1 != null)
                    {
                      localObject7 = ((acu)localObject7).NkX;
                      if (localObject7 == null) {
                        break label4856;
                      }
                    }
                  }
                }
                for (j = ((acv)localObject7).targetHeight;; j = 0)
                {
                  ((css)localObject1).height = ((int)(j * f2));
                  if (i1 != 90) {
                    break label4862;
                  }
                  localObject7 = new fbq();
                  ((fbq)localObject7).left = ((fbq)localObject6).bottom;
                  ((fbq)localObject7).top = ((fbq)localObject6).right;
                  ((fbq)localObject7).right = ((fbq)localObject6).top;
                  ((fbq)localObject7).bottom = ((fbq)localObject6).left;
                  if (localObject1 == null) {
                    break;
                  }
                  ((css)localObject1).TAv = ((fbq)localObject7);
                  break;
                  j = 0;
                  break label4618;
                  n = 0;
                  break label4642;
                  j = 1;
                  break label4669;
                  j = 0;
                  break label4713;
                }
                if (i1 == 180)
                {
                  localObject7 = new fbq();
                  ((fbq)localObject7).left = (i2 - ((fbq)localObject6).right);
                  ((fbq)localObject7).top = (i3 - ((fbq)localObject6).bottom);
                  ((fbq)localObject7).right = (i2 - ((fbq)localObject6).left);
                  ((fbq)localObject7).bottom = (i3 - ((fbq)localObject6).top);
                  if (localObject1 == null) {
                    break label3550;
                  }
                  ((css)localObject1).TAv = ((fbq)localObject7);
                  break label3550;
                }
                if (i1 != 270) {
                  break label3550;
                }
                localObject7 = new fbq();
                ((fbq)localObject7).left = (i3 - ((fbq)localObject6).top);
                ((fbq)localObject7).top = (i2 - ((fbq)localObject6).left);
                ((fbq)localObject7).right = (i3 - ((fbq)localObject6).bottom);
                ((fbq)localObject7).bottom = (i2 - ((fbq)localObject6).right);
                if (localObject1 == null) {
                  break label3550;
                }
                ((css)localObject1).TAv = ((fbq)localObject7);
                break label3550;
                bool1 = false;
                break label3611;
                j = 0;
                break label3622;
                j = 1;
                break label3635;
                if (j != 0)
                {
                  j = 2;
                  break label3635;
                }
                j = 0;
                break label3635;
                localObject6 = null;
                break label3674;
                localObject6 = null;
                break label3711;
                localObject6 = null;
                break label3748;
                localObject6 = null;
                break label3785;
                localObject6 = null;
                break label3834;
                localObject6 = null;
                break label3883;
                localObject6 = null;
                break label3932;
              }
              i1 = 0;
              i2 = 0;
            }
            localObject7 = new aa.c();
            ((aa.c)localObject7).aaBz = 0.0F;
            int i3 = SightVideoJNI.getMp4RotateVFS(localcsg.url);
            localObject6 = localcsg.zBo;
            int i7;
            if (localObject6 != null)
            {
              i = ((css)localObject6).width;
              localObject6 = localcsg.zBo;
              if (localObject6 == null) {
                break label5784;
              }
              j = ((css)localObject6).height;
              if ((i3 != 90) && (i3 != 270)) {
                break label7327;
              }
              localObject6 = localcsg.zBo;
              if (localObject6 == null) {
                break label5790;
              }
              i = ((css)localObject6).height;
              localObject6 = localcsg.zBo;
              if (localObject6 == null) {
                break label5796;
              }
              j = ((css)localObject6).width;
              if ((localObject5 == null) && (localcsg.zBo != null))
              {
                localObject5 = localcsg.zBo;
                if (localObject5 == null) {
                  p.iCn();
                }
                p.j(localObject5, "it.cropInfo!!");
                localObject6 = ((css)localObject5).TAv;
                if (localObject6 != null) {
                  break label5802;
                }
              }
              i7 = ((VideoTransPara)localObject4).videoBitrate;
              localObject5 = v.c.zYk;
              if ((!bool2) && (!bool3)) {
                break label6076;
              }
              bool1 = true;
              v.c.qd(bool1);
              Log.i(TAG, "video rotate:" + i3 + ", width:" + i + ", height:" + j + " url " + localcsg.url + " thumbUrl: " + localcsg.thumbUrl + " size:" + Util.getSizeKB(com.tencent.mm.vfs.u.bBQ(localcsg.url)));
              localObject6 = localcsg.url;
              localObject5 = localObject6;
              if (localObject6 == null) {
                localObject5 = "";
              }
              localObject6 = localcsg.zBo;
              if (localObject6 == null) {
                break label6082;
              }
              i3 = ((css)localObject6).endTime;
              f2 = i3 / 1000.0F;
              localObject6 = localcsg.zBo;
              if (localObject6 == null) {
                break label6088;
              }
            }
            for (i3 = ((css)localObject6).fod;; i3 = 0)
            {
              localObject6 = a.a((String)localObject5, i, j, f2, i3 / 1000.0F, (VideoTransPara)localObject4, bool2);
              int i5 = i;
              int i4 = j;
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
              if ((((c.a.a)localObject6).Azu == null) || (((c.a.a)localObject6).Azu.length < 28)) {
                break label7324;
              }
              f1 = localObject6.Azu[27];
              i = a(l, k, str1, i2, i1, com.tencent.mm.plugin.mmsight.d.WV(i5), com.tencent.mm.plugin.mmsight.d.WV(i4), i3, (VideoTransPara)localObject4, localcsg, localFinderMediaReportObject, (String)localObject1, n, bool2, bool3, localnd, (kotlin.g.a.b)new i((aa.c)localObject7, k, this, localList2, localList1));
              j = 1;
              Util.ticksToNow(l);
              if (i >= 0) {
                break label6094;
              }
              localObject1 = com.tencent.mm.plugin.vlog.report.c.NqY;
              com.tencent.mm.plugin.vlog.report.c.bfH(str2);
              a(com.tencent.mm.loader.g.j.kQe);
              AppMethodBeat.o(287559);
              return;
              i = 0;
              break;
              j = 0;
              break label5185;
              i = 0;
              break label5219;
              j = 0;
              break label5238;
              p.j(localObject6, "cropInfo.rect ?: return");
              i4 = ((fbq)localObject6).right - ((fbq)localObject6).left;
              i5 = ((fbq)localObject6).top - ((fbq)localObject6).bottom;
              switch (i3)
              {
              default: 
                break;
              case 90: 
                localObject8 = new fbq();
                ((fbq)localObject8).left = ((fbq)localObject6).bottom;
                ((fbq)localObject8).top = ((fbq)localObject6).right;
                ((fbq)localObject8).right = ((fbq)localObject6).top;
                ((fbq)localObject8).bottom = ((fbq)localObject6).left;
                ((css)localObject5).TAv = ((fbq)localObject8);
                break;
              case 180: 
                localObject8 = new fbq();
                ((fbq)localObject8).left = (i4 - ((fbq)localObject6).right);
                ((fbq)localObject8).top = (i5 - ((fbq)localObject6).bottom);
                ((fbq)localObject8).right = (i4 - ((fbq)localObject6).left);
                ((fbq)localObject8).bottom = (i5 - ((fbq)localObject6).top);
                ((css)localObject5).TAv = ((fbq)localObject8);
                break;
              case 270: 
                localObject8 = new fbq();
                ((fbq)localObject8).left = (i5 - ((fbq)localObject6).top);
                ((fbq)localObject8).top = (i4 - ((fbq)localObject6).left);
                ((fbq)localObject8).right = (i5 - ((fbq)localObject6).bottom);
                ((fbq)localObject8).bottom = (i4 - ((fbq)localObject6).right);
                ((css)localObject5).TAv = ((fbq)localObject8);
                break;
                bool1 = false;
                break label5311;
                i3 = 0;
                break label5449;
              }
            }
            localObject5 = MultiMediaVideoChecker.NmA.bfs(str1);
            if ((localObject5 == null) || (((MultiMediaVideoChecker.a)localObject5).width <= 0) || (((MultiMediaVideoChecker.a)localObject5).height <= 0) || (((MultiMediaVideoChecker.a)localObject5).cLa <= 0.0F))
            {
              localObject4 = TAG;
              localObject6 = new StringBuilder("normal video remuxVideo file error: ");
              if (localObject5 != null)
              {
                localObject1 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject5).width);
                localObject6 = ((StringBuilder)localObject6).append(localObject1).append(' ');
                if (localObject5 == null) {
                  break label6287;
                }
                localObject1 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject5).height);
                Log.i((String)localObject4, localObject1);
                localObject1 = v.c.zYk;
                if ((!bool2) && (!bool3)) {
                  break label6293;
                }
                bool1 = true;
                v.c.qe(bool1);
                localObject1 = v.c.zYk;
                if ((!bool2) && (!bool3)) {
                  break label6299;
                }
              }
              for (bool1 = true;; bool1 = false)
              {
                v.c.qf(bool1);
                localObject1 = com.tencent.mm.plugin.vlog.report.c.NqY;
                com.tencent.mm.plugin.vlog.report.c.bfH(str2);
                a(com.tencent.mm.loader.g.j.kQe);
                AppMethodBeat.o(287559);
                return;
                localObject1 = null;
                break;
                localObject1 = null;
                break label6196;
                bool1 = false;
                break label6229;
              }
            }
            f2 = f1;
            i = i6;
            if (((c.a.a)localObject6).Azu != null)
            {
              try
              {
                SightVideoJNI.addReportMetadata(str1, ((c.a.a)localObject6).Azu, ((VideoTransPara)localObject4).lJz, 0);
                j = 1;
                i = 1;
              }
              catch (Throwable localThrowable1)
              {
                for (;;)
                {
                  j = 1;
                  i = 1;
                }
              }
              Log.i(TAG, "hseasunhan, video quality level: ".concat(String.valueOf(f1)));
              p.k(str1, "input");
              localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
              if (com.tencent.mm.plugin.finder.storage.d.dVd())
              {
                f2 = AdaptiveAdjustBitrate.a(str1, f3, f4, i8, bool4, bool5);
                Log.i(TAG, "qipengfeng, audio quality level: " + f2 + ", bitrate:" + f3 + ", samplerate:" + f4 + ", channels:" + i8 + ", enableAuQA:" + bool4 + ", useOriAu:" + bool5);
                if (i != 0)
                {
                  localnd.zh((100.0F * f1));
                  localnd.zg((100.0F * f2));
                  localObject1 = com.tencent.mm.plugin.vlog.report.c.NqY;
                  com.tencent.mm.plugin.vlog.report.c.bfH(str2);
                }
                bi((k + 1.0F) / localList1.size());
                if (!localcsg.TAe) {
                  break label7090;
                }
                localObject5 = ((Iterable)this.Azr.getHalfVideoMediaExtList()).iterator();
                while (((Iterator)localObject5).hasNext())
                {
                  localObject1 = ((Iterator)localObject5).next();
                  localObject6 = (csg)localObject1;
                  if (p.h(localcsg.mediaId, ((csg)localObject6).mediaId))
                  {
                    localObject1 = (csg)localObject1;
                    if (localObject1 != null)
                    {
                      a((VideoTransPara)localObject4, localcsg, str1, (csg)localObject1, k, localFinderMediaReportObject, f2, f1, false);
                      eca();
                      localObject1 = x.aazN;
                    }
                    localObject5 = this.Azr.getLongVideoMediaExtList();
                    localObject6 = ((Iterable)localObject5).iterator();
                    do
                    {
                      if (!((Iterator)localObject6).hasNext()) {
                        break;
                      }
                      localObject1 = ((Iterator)localObject6).next();
                      localObject7 = (csg)localObject1;
                    } while (!p.h(localcsg.mediaId, ((csg)localObject7).mediaId));
                  }
                }
              }
              for (;;)
              {
                localObject1 = (csg)localObject1;
                if (localObject1 == null) {
                  break label7251;
                }
                a((VideoTransPara)localObject4, localcsg, str1, (csg)localObject1, k, localFinderMediaReportObject, f2, f1, true);
                localObject1 = this.Azr.getFeedObject().attachmentList;
                if (localObject1 != null)
                {
                  localObject1 = ((apx)localObject1).SDm;
                  if (localObject1 != null)
                  {
                    localObject1 = (apw)kotlin.a.j.lp((List)localObject1);
                    if (localObject1 != null)
                    {
                      localObject1 = ((apw)localObject1).SDl;
                      if (localObject1 != null)
                      {
                        localObject1 = ((blj)localObject1).SPm;
                        if (localObject1 != null)
                        {
                          localObject1 = ((cvy)localObject1).TEM;
                          if (localObject1 != null) {
                            ((cwc)localObject1).media = com.tencent.mm.plugin.finder.storage.data.n.aT((LinkedList)localObject5);
                          }
                        }
                      }
                    }
                  }
                }
                eca();
                localObject1 = x.aazN;
                k = m;
                break;
                if ((bool2) || (bool3)) {
                  break label7314;
                }
                localObject2 = a(l, k, str1, (VideoTransPara)localObject4, localcsg, localFinderMediaReportObject, localList1.size());
                j = 0;
                n = ((Number)((kotlin.o)localObject2).Mx).intValue();
                f2 = ((Number)((kotlin.o)localObject2).My).floatValue();
                if (n < 0)
                {
                  a(com.tencent.mm.loader.g.j.kQe);
                  AppMethodBeat.o(287559);
                  return;
                }
                localObject5 = MultiMediaVideoChecker.NmA.bfs(str1);
                if ((localObject5 != null) && (((MultiMediaVideoChecker.a)localObject5).width > 0) && (((MultiMediaVideoChecker.a)localObject5).height > 0) && (((MultiMediaVideoChecker.a)localObject5).cLa > 0.0F)) {
                  break label7296;
                }
                localObject4 = TAG;
                localObject6 = new StringBuilder("remuxVideo file error: ");
                if (localObject5 != null)
                {
                  localObject2 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject5).width);
                  localObject6 = ((StringBuilder)localObject6).append(localObject2).append(' ');
                  if (localObject5 == null) {
                    break label7072;
                  }
                }
                for (localObject2 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject5).height);; localObject2 = null)
                {
                  Log.i((String)localObject4, localObject2);
                  a(com.tencent.mm.loader.g.j.kQe);
                  AppMethodBeat.o(287559);
                  return;
                  localObject2 = null;
                  break;
                }
                f2 = 0.0F;
                break label6394;
                localObject2 = null;
                break label6598;
                localObject5 = this.Azr.getMediaList();
                localObject6 = ((Iterable)localObject5).iterator();
                do
                {
                  if (!((Iterator)localObject6).hasNext()) {
                    break;
                  }
                  localObject2 = ((Iterator)localObject6).next();
                  localObject7 = (csg)localObject2;
                } while (!p.h(localcsg.mediaId, ((csg)localObject7).mediaId));
                for (;;)
                {
                  localObject2 = (csg)localObject2;
                  if (localObject2 == null) {
                    break;
                  }
                  a((VideoTransPara)localObject4, localcsg, str1, (csg)localObject2, k, localFinderMediaReportObject, f2, f1, false);
                  this.Azr.setMediaList((LinkedList)localObject5);
                  localObject2 = this.Azr.field_reportObject;
                  if (localObject2 != null)
                  {
                    ((FinderFeedReportObject)localObject2).remuxEndTime = cm.bfE();
                    ((FinderFeedReportObject)localObject2).remuxType = j;
                    localObject2 = x.aazN;
                  }
                  eca();
                  localObject2 = x.aazN;
                  break;
                  localObject2 = null;
                }
                localObject2 = null;
              }
              k = m;
              break;
              Object localObject2 = com.tencent.mm.plugin.vlog.model.n.NlN;
              com.tencent.mm.plugin.vlog.model.n.reset();
              a(com.tencent.mm.loader.g.j.kQd);
              AppMethodBeat.o(287559);
              return;
            }
          }
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion;", "", "()V", "RemuxTypeNoNeedRemux", "", "RemuxTypeNormalVideo", "RemuxTypeTavkit", "TAG", "", "getTAG", "()Ljava/lang/String;", "_5_min", "", "checkProgressExceptionHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkRemuxVideo", "path", "width", "height", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "localId", "isLongVideoAttachShort", "", "convertViewRect", "Landroid/graphics/Rect;", "viewRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "getABAResult", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "input", "durationSec", "", "startTimeSec", "videoTransPara", "isLongVideo", "getAudioQualityLevel", "bitrate", "samplerate", "channels", "enableAuQA", "useOriAu", "ABAResult", "plugin-finder_release"})
  public static final class a
  {
    public static int a(String paramString, int paramInt1, int paramInt2, VideoTransPara paramVideoTransPara, long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(227574);
      p.k(paramVideoTransPara, "videoParams");
      long l2 = com.tencent.mm.vfs.u.bBQ(paramString);
      Object localObject = v.c.zYk;
      v.c.v(l2, paramBoolean);
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      long l1 = com.tencent.mm.plugin.finder.storage.d.dRV();
      if (l2 > l1)
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (com.tencent.mm.plugin.finder.storage.d.dUQ() != 1) {}
      }
      else
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dWy().aSr()).intValue() != 1) {
          break label286;
        }
      }
      Log.i(c.access$getTAG$cp(), "checkRemuxVideo need remux zip");
      localObject = v.c.zYk;
      v.c.qj(paramBoolean);
      l2 = Util.currentTicks();
      localObject = paramString + ".remux";
      paramInt1 = SightVideoJNI.remuxingVFS(paramString, (String)localObject, paramInt1, paramInt2, paramVideoTransPara.videoBitrate, com.tencent.mm.plugin.sight.base.d.JrH, 8, 2, 25.0F, paramVideoTransPara.fps, null, 0, com.tencent.mm.plugin.sight.base.d.JrG, 0, 51);
      Log.i(c.access$getTAG$cp(), "checkRemuxVideo remux cost:" + Util.ticksToNow(l2) + "ms, ret:" + paramInt1 + " localId:" + paramLong);
      paramVideoTransPara = v.c.zYk;
      v.c.w(Util.ticksToNow(l2), paramBoolean);
      if (paramInt1 >= 0)
      {
        com.tencent.mm.vfs.u.oo((String)localObject, paramString);
        paramLong = com.tencent.mm.vfs.u.bBQ((String)localObject);
        paramString = v.c.zYk;
        v.c.x(paramLong, paramBoolean);
        if (paramLong > l1)
        {
          AppMethodBeat.o(227574);
          return -3;
        }
        AppMethodBeat.o(227574);
        return 0;
      }
      paramString = v.c.zYk;
      v.c.qk(paramBoolean);
      AppMethodBeat.o(227574);
      return -2;
      label286:
      Log.i(c.access$getTAG$cp(), "checkRemuxVideo, no need remux");
      AppMethodBeat.o(227574);
      return 0;
    }
    
    public static Rect a(fbq paramfbq)
    {
      AppMethodBeat.i(167726);
      p.k(paramfbq, "viewRect");
      paramfbq = new Rect(paramfbq.left, paramfbq.top, paramfbq.right, paramfbq.bottom);
      AppMethodBeat.o(167726);
      return paramfbq;
    }
    
    public static a a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, VideoTransPara paramVideoTransPara, boolean paramBoolean)
    {
      AppMethodBeat.i(227587);
      p.k(paramString, "input");
      p.k(paramVideoTransPara, "videoTransPara");
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
          float f = (float)com.tencent.mm.plugin.finder.storage.d.dRW();
          locald = com.tencent.mm.plugin.finder.storage.d.AjH;
          f /= 1.0F * com.tencent.mm.plugin.finder.storage.d.dRE();
          locald = com.tencent.mm.plugin.finder.storage.d.AjH;
          paramVideoTransPara.lJH = ((int)(f * com.tencent.mm.plugin.finder.storage.d.dRF()));
          Log.i(c.access$getTAG$cp(), "ABA:  finder video maxVideoSize:" + paramVideoTransPara + ".maxVideoSize");
          Log.i(c.access$getTAG$cp(), "ABA:  finder video video endtime:" + paramFloat1 + " starttime:" + paramFloat2);
          locald = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (!com.tencent.mm.plugin.finder.storage.d.dRL()) {
            continue;
          }
          paramString = AdaptiveAdjustBitrate.a(paramString, paramInt2, paramInt1, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, paramFloat1, paramFloat2, 4, paramVideoTransPara.lJB, paramVideoTransPara.lJC, paramVideoTransPara.lJD, paramVideoTransPara.lJE, paramVideoTransPara.lJF, paramVideoTransPara.lJG, paramVideoTransPara.lJH, false);
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
          AppMethodBeat.o(227587);
          return paramString;
        }
        Log.i(c.access$getTAG$cp(), "ABA:  finder video bitrate:" + j + " width: " + k + " height:" + paramInt1);
        if (s.bqC() != null) {
          e.s(paramString);
        }
        paramString = new a(i, k, paramInt1, j, paramString);
        AppMethodBeat.o(227587);
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
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "", "errCode", "", "width", "height", "bitrate", "abaParams", "", "(IIII[I)V", "getAbaParams", "()[I", "getBitrate", "()I", "getErrCode", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      public final int[] Azu;
      public final int bitrate;
      public final int errCode;
      public final int height;
      public final int width;
      
      public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
      {
        this.errCode = paramInt1;
        this.width = paramInt2;
        this.height = paramInt3;
        this.bitrate = paramInt4;
        this.Azu = paramArrayOfInt;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(167725);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((this.errCode != paramObject.errCode) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.bitrate != paramObject.bitrate) || (!p.h(this.Azu, paramObject.Azu))) {}
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
        int[] arrayOfInt = this.Azu;
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
        String str = "ABAResult(errCode=" + this.errCode + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", abaParams=" + Arrays.toString(this.Azu) + ")";
        AppMethodBeat.o(167723);
        return str;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "msg", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class b
    implements MMHandler.Callback
  {
    public static final b Azv;
    
    static
    {
      AppMethodBeat.i(266549);
      Azv = new b();
      AppMethodBeat.o(266549);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      boolean bool2 = false;
      AppMethodBeat.i(266548);
      boolean bool1;
      Object localObject;
      StringBuilder localStringBuilder;
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        long l = paramMessage.what;
        paramMessage = v.c.zYk;
        v.c.qh(bool1);
        paramMessage = ((PluginFinder)h.ag(PluginFinder.class)).getFeedStorage().MI(l);
        if (paramMessage != null)
        {
          localObject = paramMessage.field_reportObject;
          if (localObject != null) {
            ((FinderFeedReportObject)localObject).uploadLogicError = 3;
          }
          localObject = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          com.tencent.mm.plugin.finder.storage.logic.c.a.s(paramMessage);
          localObject = k.zWs;
          k.Ml(paramMessage.getLocalId());
        }
        localObject = c.Azt;
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
        AppMethodBeat.o(266548);
        return true;
        bool1 = false;
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Float, x>
  {
    c(c paramc, aa.c paramc1, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.vlog.model.l, x>
  {
    d(c paramc, aa.d paramd, int paramInt, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, String paramString, acv paramacv, VideoTransPara paramVideoTransPara, acu paramacu, csg paramcsg, Object paramObject, aa.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<Float, x>
  {
    e(c paramc, aa.c paramc1, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.vlog.model.l, x>
  {
    f(c paramc, aa.d paramd1, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, String paramString, boolean paramBoolean, aa.d paramd2, aa.d paramd3, VideoTransPara paramVideoTransPara, Object paramObject, aa.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<Float, x>
  {
    g(kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<String, x>
  {
    h(c paramc, csg paramcsg, nd paramnd, long paramLong, boolean paramBoolean1, aa.d paramd, int paramInt1, boolean paramBoolean2, FinderMediaReportObject paramFinderMediaReportObject, int paramInt2, int paramInt3, VideoTransPara paramVideoTransPara, Object paramObject, aa.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$start$4$3"})
  static final class i
    extends q
    implements kotlin.g.a.b<Float, x>
  {
    i(aa.c paramc, int paramInt, c paramc1, List paramList1, List paramList2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.c
 * JD-Core Version:    0.7.0.1
 */