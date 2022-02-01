package com.tencent.mm.plugin.finder.upload.postlogic.finderstage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ic;
import com.tencent.mm.autogen.mmdata.rpt.qn;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.upload.c;
import com.tencent.mm.plugin.finder.upload.c.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.h;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.plugin.vlog.model.k;
import com.tencent.mm.plugin.vlog.model.m;
import com.tencent.mm.plugin.vlog.model.t;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.fyb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.j;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.h.a;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/FinderMediaProcessStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "TAG", "", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "checkProgressException", "", "localId", "", "isLongVideo", "", "isCancel", "checkVideoInfoMatch", "path", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "chooseMixType", "", "originAudio", "addAudio", "compositionToCropInfo", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "getStageType", "onFailed", "nextStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "onSuccess", "onWait", "remuxComposition", "Lkotlin/Pair;", "", "startRemuxerTick", "index", "outputPath", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaReportObject", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;", "size", "remuxLongVideoComposition", "localMedia", "remuxNormalVideo", "videoWidth", "videoHeight", "width", "height", "bitrate", "localFinderMedia", "musicPath", "mixType", "isLongVideoAttachShort", "vcPerformanceStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "onUpdateProgress", "Lkotlin/Function1;", "rotateRect", "rotate", "saveFinderObject", "start", "updateMedia", "reportObject", "audioQuality", "videoQuality", "updateProgress", "avgProgress", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.finder.upload.postlogic.f
{
  public final FinderItem Ged;
  final String TAG;
  
  public b(FinderItem paramFinderItem)
  {
    super(String.valueOf(paramFinderItem.getLocalId()));
    AppMethodBeat.i(343187);
    this.Ged = paramFinderItem;
    this.TAG = "LogPost.FinderMediaProcessStage";
    AppMethodBeat.o(343187);
  }
  
  private final int a(final long paramLong, final int paramInt1, String paramString1, int paramInt2, int paramInt3, final int paramInt4, final int paramInt5, int paramInt6, final VideoTransPara paramVideoTransPara, dji paramdji, final FinderMediaReportObject paramFinderMediaReportObject, String paramString2, int paramInt7, boolean paramBoolean1, final boolean paramBoolean2, final qn paramqn, kotlin.g.a.b<? super Float, ah> paramb)
  {
    AppMethodBeat.i(343238);
    locald = new kotlin.g.b.ah.d();
    locald.aixb = -1;
    localObject4 = new Object();
    final ah.a locala = new ah.a();
    for (;;)
    {
      try
      {
        localObject1 = paramdji.url;
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localObject1 = c.Gbx;
        localObject1 = paramdji.EDC;
        if (localObject1 == null)
        {
          localObject1 = null;
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new fyb();
          }
          localObject1 = c.a.a((fyb)localObject3);
          int i = paramVideoTransPara.audioBitrate;
          int j = paramVideoTransPara.audioSampleRate;
          int k = paramVideoTransPara.audioChannelCount;
          int m = paramVideoTransPara.fps;
          localObject3 = paramdji.EDC;
          if (localObject3 != null) {
            continue;
          }
          l1 = 0L;
          localObject3 = paramdji.EDC;
          if (localObject3 != null) {
            continue;
          }
          l2 = 0L;
          paramString1 = new o(paramString2, (String)localObject2, paramInt7, paramString1, (Rect)localObject1, paramInt4, paramInt5, paramInt6, i, j, k, m, l1, l2, paramVideoTransPara.nCd, (kotlin.g.a.b)new b.e(paramb), (kotlin.g.a.b)new f(paramdji, paramqn, paramLong, paramBoolean1, locald, this, paramInt1, paramBoolean2, paramFinderMediaReportObject, paramInt4, paramInt5, paramVideoTransPara, localObject4, locala), paramInt2, paramInt3);
          paramString1.bpE();
        }
      }
      finally
      {
        Object localObject1;
        Object localObject3;
        long l1;
        long l2;
        int n;
        Log.printErrStackTrace(this.TAG, paramString1, "create remuxer failed", new Object[0]);
        paramString1 = com.tencent.mm.plugin.finder.report.ah.c.Ftv;
        if ((paramBoolean1) || (paramBoolean2))
        {
          paramBoolean1 = true;
          com.tencent.mm.plugin.finder.report.ah.c.ty(paramBoolean1);
          paramInt1 = locald.aixb;
          AppMethodBeat.o(343238);
          return paramInt1;
        }
        paramBoolean1 = false;
        continue;
      }
      try
      {
        if (!locala.aiwY)
        {
          Log.i(this.TAG, s.X("wait ", Integer.valueOf(paramInt1)));
          localObject4.wait();
          Log.i(this.TAG, "notify " + paramInt1 + ", " + locald.aixb);
        }
        paramString1 = ah.aiuX;
        paramString1 = this.Ged.field_reportObject;
        if (paramString1 != null) {
          paramString1.mpError = locald.aixb;
        }
        fey();
        paramInt1 = locald.aixb;
        AppMethodBeat.o(343238);
        return paramInt1;
      }
      finally
      {
        AppMethodBeat.o(343238);
      }
      localObject1 = ((dju)localObject1).aaPJ;
      continue;
      l1 = ((dju)localObject3).startTime;
      continue;
      n = ((dju)localObject3).endTime;
      l2 = n;
    }
  }
  
  private final r<Integer, Float> a(final long paramLong, final int paramInt1, String paramString, final VideoTransPara paramVideoTransPara, dji paramdji, final FinderMediaReportObject paramFinderMediaReportObject, final int paramInt2)
  {
    AppMethodBeat.i(343250);
    Log.i(this.TAG, s.X("remuxComposition outputPath:", paramString));
    Object localObject2 = paramdji.aaDI;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new afb();
    }
    final kotlin.g.b.ah.d locald = new kotlin.g.b.ah.d();
    locald.aixb = -1;
    localObject3 = ((afb)localObject1).TYB;
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new afc();
    }
    ((afc)localObject2).outputPath = paramString;
    ((afc)localObject2).oYa = w.s(false, 0L);
    localObject3 = new Object();
    final ah.a locala = new ah.a();
    com.tencent.mm.plugin.vlog.model.e locale = new com.tencent.mm.plugin.vlog.model.e();
    locale.ybL = 1;
    paramdji = paramdji.EDC;
    if (paramdji == null) {}
    for (int i = 0;; i = paramdji.retryCount)
    {
      locale.retryCount = i;
      locale.TYa = true;
      paramdji = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (com.tencent.mm.plugin.finder.storage.d.ePX())
      {
        paramdji = com.tencent.mm.plugin.finder.storage.d.FAy;
        long l = com.tencent.mm.plugin.finder.storage.d.eQi();
        if (l > 0L)
        {
          f = (float)l;
          paramdji = com.tencent.mm.plugin.finder.storage.d.FAy;
          f /= 1.0F * com.tencent.mm.plugin.finder.storage.d.ePO();
          paramdji = com.tencent.mm.plugin.finder.storage.d.FAy;
          paramVideoTransPara.oCj = ((int)(f * com.tencent.mm.plugin.finder.storage.d.ePP()));
          Log.i(this.TAG, s.X("ABA finder video maxVideoSize:", Integer.valueOf(paramVideoTransPara.oCj)));
        }
        locale.a(true, paramVideoTransPara);
      }
      locale.aJ((kotlin.g.a.b)new a(new kotlin.g.b.ah.c(), this, paramInt1, paramInt2));
      float f = com.tencent.mm.plugin.vlog.model.e.a(locale, (afb)localObject1, (kotlin.g.a.b)new b(this, locald, paramInt1, paramFinderMediaReportObject, paramLong, paramString, (afc)localObject2, paramVideoTransPara, (afb)localObject1, localObject3, locala));
      try
      {
        if (!locala.aiwY)
        {
          Log.i(this.TAG, s.X("wait ", Integer.valueOf(paramInt1)));
          localObject3.wait();
          Log.i(this.TAG, "notify " + paramInt1 + ", " + locald.aixb);
        }
        paramString = ah.aiuX;
        paramString = this.Ged.field_reportObject;
        if (paramString != null) {
          paramString.mpError = locald.aixb;
        }
        fey();
        paramString = new r(Integer.valueOf(locald.aixb), Float.valueOf(f));
        AppMethodBeat.o(343250);
        return paramString;
      }
      finally
      {
        AppMethodBeat.o(343250);
      }
    }
  }
  
  private void a(VideoTransPara paramVideoTransPara, dji paramdji1, String paramString, dji paramdji2, int paramInt, FinderMediaReportObject paramFinderMediaReportObject, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(343224);
    s.u(paramVideoTransPara, "videoParams");
    s.u(paramdji1, "localMedia");
    s.u(paramString, "outputPath");
    s.u(paramdji2, "media");
    s.u(paramFinderMediaReportObject, "reportObject");
    Object localObject = av.GiL;
    localObject = av.aBH(paramString);
    if (localObject != null)
    {
      paramdji1.width = ((com.tencent.mm.plugin.sight.base.b)localObject).width;
      paramdji1.height = ((com.tencent.mm.plugin.sight.base.b)localObject).height;
      paramdji2.width = ((com.tencent.mm.plugin.sight.base.b)localObject).width;
      paramdji2.height = ((com.tencent.mm.plugin.sight.base.b)localObject).height;
    }
    i = paramVideoTransPara.oCa;
    int j = (int)(paramdji1.height / paramdji1.width * i);
    str = com.tencent.mm.plugin.finder.upload.f.GbE.ao(paramString, i, j);
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (com.tencent.mm.plugin.finder.storage.d.eTA())
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      j = AdaptiveAdjustBitrate.getVideoImageQuality(com.tencent.mm.plugin.finder.storage.d.ePY(), 0, i, j, 0.8F);
      paramdji2.aaPt = paramFinderMediaReportObject;
      paramdji2.url = paramString;
      paramdji2.thumbUrl = str;
      if ((!paramBoolean) && (!paramdji1.aaPp))
      {
        paramFinderMediaReportObject = paramdji2.aaPl;
        if (paramFinderMediaReportObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject = paramdji1.aaDI;
        if (localObject != null)
        {
          localObject = ((afb)localObject).TYB;
          if (localObject != null)
          {
            new Rect();
            if (((afc)localObject).Znv == null) {
              continue;
            }
            Rect localRect = new Rect();
            h.a(((afc)localObject).Znv.Zqq, localRect);
            f1 = paramdji2.width / localRect.width();
            localObject = new Rect((int)paramFinderMediaReportObject.left, (int)(paramFinderMediaReportObject.top * f1), (int)(paramFinderMediaReportObject.right * f1), (int)(paramFinderMediaReportObject.bottom * f1));
            paramFinderMediaReportObject = (FinderMediaReportObject)localObject;
            if (((Rect)localObject).bottom > paramdji2.height)
            {
              ((Rect)localObject).bottom = ((int)paramdji2.height);
              paramFinderMediaReportObject = (FinderMediaReportObject)localObject;
            }
            i = paramVideoTransPara.oCa;
            int k = (int)(paramFinderMediaReportObject.height() / paramFinderMediaReportObject.width() * i);
            paramVideoTransPara = bm.GlZ;
            paramVideoTransPara = bm.aCj(paramString);
            localObject = com.tencent.mm.plugin.finder.upload.f.GbE;
            paramdji2.thumbUrl = com.tencent.mm.plugin.finder.upload.f.a(paramString, paramVideoTransPara, i, k, new Rect(paramFinderMediaReportObject.left, paramFinderMediaReportObject.bottom, paramFinderMediaReportObject.right, paramFinderMediaReportObject.top));
            paramdji2.aaPi = str;
            paramVideoTransPara = ah.aiuX;
          }
        }
      }
      catch (Exception paramVideoTransPara)
      {
        float f1;
        float f2;
        Log.e(this.TAG, "crop halfThumb from " + str + " fail:" + paramVideoTransPara.getLocalizedMessage());
        paramVideoTransPara = ah.aiuX;
        continue;
        paramVideoTransPara = paramVideoTransPara.target;
        continue;
        paramFinderMediaReportObject = paramFinderMediaReportObject.target;
        if (paramFinderMediaReportObject != null) {
          continue;
        }
        i = 0;
        continue;
        i = paramFinderMediaReportObject.fileSize;
        continue;
        paramFinderMediaReportObject = paramFinderMediaReportObject.TYC;
        if (paramFinderMediaReportObject != null) {
          continue;
        }
        i = 0;
        continue;
        paramFinderMediaReportObject = paramFinderMediaReportObject.Znd;
        if (paramFinderMediaReportObject != null) {
          continue;
        }
        i = 0;
        continue;
        i = paramFinderMediaReportObject.size();
        continue;
        boolean bool = false;
        continue;
        paramVideoTransPara = paramVideoTransPara.codecInfo;
        continue;
        paramVideoTransPara = paramVideoTransPara.target;
        continue;
        paramVideoTransPara = paramVideoTransPara.target;
        continue;
        paramVideoTransPara = paramVideoTransPara.target;
        continue;
        paramVideoTransPara = paramVideoTransPara.target;
        continue;
        paramVideoTransPara = paramVideoTransPara.target;
        continue;
        paramVideoTransPara = paramVideoTransPara.target;
        continue;
      }
      paramdji2.aaPf = false;
      paramdji2.mediaId = MD5Util.getMD5String(paramdji1.url);
      paramdji2.fileSize = ((int)y.bEl(paramString));
      paramVideoTransPara = paramdji2.aaPt;
      if (paramVideoTransPara != null) {
        paramVideoTransPara.target = new FinderMediaReportInfo();
      }
      paramVideoTransPara = paramdji2.aaPt;
      if (paramVideoTransPara != null) {
        continue;
      }
      paramVideoTransPara = null;
      if (paramVideoTransPara != null) {
        paramVideoTransPara.fileSize = paramdji2.fileSize;
      }
      paramVideoTransPara = paramdji2.aaPt;
      if (paramVideoTransPara != null)
      {
        paramFinderMediaReportObject = paramdji2.aaPt;
        if (paramFinderMediaReportObject != null) {
          continue;
        }
        i = 0;
        paramVideoTransPara.videoFinalSize = i;
      }
      paramVideoTransPara = paramdji2.aaDI;
      if (paramVideoTransPara != null) {
        paramVideoTransPara.Znj = false;
      }
      if (paramdji2.codec_info == null) {
        paramdji2.codec_info = new boy();
      }
      paramVideoTransPara = paramdji2.codec_info;
      if (paramVideoTransPara != null)
      {
        paramVideoTransPara.ZXq = paramFloat2;
        paramVideoTransPara.ZXs = paramFloat1;
        paramVideoTransPara.ZXt = j;
        paramFinderMediaReportObject = paramdji2.aaDI;
        if (paramFinderMediaReportObject != null) {
          continue;
        }
        i = 0;
        if (i <= 0) {
          continue;
        }
        bool = true;
        paramVideoTransPara.ZXv = bool;
        Log.i(this.TAG, "codec_info video_score:" + paramVideoTransPara.ZXq + ",video_cover_score:" + paramVideoTransPara.ZXr + ",video_audio_score:" + paramVideoTransPara.ZXs + ",thumb_score:" + paramVideoTransPara.ZXt + ",hdimg_score:" + paramVideoTransPara.ZXu + ",has_stickers:" + paramVideoTransPara.ZXv);
      }
      paramVideoTransPara = paramdji2.aaPt;
      if (paramVideoTransPara != null) {
        continue;
      }
      paramVideoTransPara = null;
      if (paramVideoTransPara == null)
      {
        paramVideoTransPara = paramdji2.aaPt;
        if (paramVideoTransPara != null) {
          paramVideoTransPara.codecInfo = paramdji2.codec_info;
        }
      }
      paramFinderMediaReportObject = MultiMediaVideoChecker.ObB.aTG(paramString);
      if (paramFinderMediaReportObject != null)
      {
        paramdji2.videoDuration = a.eH((float)paramFinderMediaReportObject.duration / 1000.0F);
        paramVideoTransPara = paramdji2.aaPt;
        if (paramVideoTransPara != null) {
          continue;
        }
        paramVideoTransPara = null;
        if (paramVideoTransPara != null) {
          paramVideoTransPara.videoDuration = ((int)paramFinderMediaReportObject.duration);
        }
        paramVideoTransPara = paramdji2.aaPt;
        if (paramVideoTransPara != null) {
          continue;
        }
        paramVideoTransPara = null;
        if (paramVideoTransPara != null) {
          paramVideoTransPara.width = paramFinderMediaReportObject.width;
        }
        paramVideoTransPara = paramdji2.aaPt;
        if (paramVideoTransPara != null) {
          continue;
        }
        paramVideoTransPara = null;
        if (paramVideoTransPara != null) {
          paramVideoTransPara.height = paramFinderMediaReportObject.height;
        }
        paramVideoTransPara = paramdji2.aaPt;
        if (paramVideoTransPara != null) {
          continue;
        }
        paramVideoTransPara = null;
        if (paramVideoTransPara != null) {
          paramVideoTransPara.videoBitrate = paramFinderMediaReportObject.bitrate;
        }
        paramVideoTransPara = paramdji2.aaPt;
        if (paramVideoTransPara != null) {
          continue;
        }
        paramVideoTransPara = null;
        if (paramVideoTransPara != null) {
          paramVideoTransPara.audioBitrate = paramFinderMediaReportObject.audioBitrate;
        }
        paramVideoTransPara = paramdji2.aaPt;
        if (paramVideoTransPara != null) {
          continue;
        }
        paramVideoTransPara = null;
        if (paramVideoTransPara != null) {
          paramVideoTransPara.fps = ((int)paramFinderMediaReportObject.eGw);
        }
      }
      Log.i(this.TAG, "processList index " + paramInt + " url " + paramdji1.url + " thumbUrl: " + paramdji1.thumbUrl + " newMd5: " + MD5Util.getMD5String(paramdji1.url) + " size:" + Util.getSizeKB(y.bEl(paramdji1.url)));
      paramVideoTransPara = m.TYW;
      m.c(paramString, paramFloat2, paramBoolean);
      paramVideoTransPara = m.TYW;
      m.hQB();
      AppMethodBeat.o(343224);
      return;
      j = 0;
      break;
      f1 = paramdji2.width / ((afc)localObject).HJN;
      f2 = paramdji2.height / ((afc)localObject).HJO;
      paramFinderMediaReportObject = new Rect((int)(paramFinderMediaReportObject.left * f1), (int)(paramFinderMediaReportObject.top * f2), (int)(f1 * paramFinderMediaReportObject.right), (int)(paramFinderMediaReportObject.bottom * f2));
    }
  }
  
  private final r<Integer, Float> b(final long paramLong, final VideoTransPara paramVideoTransPara, final dji paramdji, String paramString, final FinderMediaReportObject paramFinderMediaReportObject, final boolean paramBoolean, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(343211);
    localObject1 = com.tencent.mm.plugin.finder.report.ah.c.Ftv;
    com.tencent.mm.plugin.finder.report.ah.c.tP(true);
    localObject1 = m.TYW;
    m.FN(paramBoolean);
    localObject1 = new Object();
    final ah.a locala = new ah.a();
    Object localObject3 = paramdji.url;
    if (localObject3 == null)
    {
      paramVideoTransPara = new r(Integer.valueOf(-1000), Float.valueOf(0.0F));
      AppMethodBeat.o(343211);
      return paramVideoTransPara;
    }
    dju localdju = paramdji.EDC;
    if (localdju == null)
    {
      paramVideoTransPara = new r(Integer.valueOf(-1001), Float.valueOf(0.0F));
      AppMethodBeat.o(343211);
      return paramVideoTransPara;
    }
    Object localObject2 = new Rect();
    final kotlin.g.b.ah.d locald1 = new kotlin.g.b.ah.d();
    final kotlin.g.b.ah.d locald2 = new kotlin.g.b.ah.d();
    Object localObject4 = MultiMediaVideoChecker.ObB.cI((String)localObject3, true);
    Object localObject5 = new ad((String)localObject3, 2);
    ((ad)localObject5).wC(localdju.endTime);
    ((ad)localObject5).wA(localdju.endTime);
    localObject3 = new ac(p.listOf(localObject5));
    int j = 0;
    int i = 0;
    if (localObject4 != null)
    {
      j = ((MultiMediaVideoChecker.a)localObject4).width;
      i = ((MultiMediaVideoChecker.a)localObject4).height;
      if ((((MultiMediaVideoChecker.a)localObject4).hYK == 90) || (((MultiMediaVideoChecker.a)localObject4).hYK == 270))
      {
        j = ((MultiMediaVideoChecker.a)localObject4).height;
        i = ((MultiMediaVideoChecker.a)localObject4).width;
      }
      ((ad)localObject5).UaF.yok.set(0, 0, j, i);
      ((ac)localObject3).mu(j, i);
      ((Rect)localObject2).set(0, 0, j, i);
      localObject5 = paramFinderMediaReportObject.origin;
      if (localObject5 != null) {
        ((FinderMediaReportInfo)localObject5).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject4).duration);
      }
      localObject5 = paramFinderMediaReportObject.origin;
      if (localObject5 != null) {
        ((FinderMediaReportInfo)localObject5).width = ((MultiMediaVideoChecker.a)localObject4).width;
      }
      localObject5 = paramFinderMediaReportObject.origin;
      if (localObject5 != null) {
        ((FinderMediaReportInfo)localObject5).height = ((MultiMediaVideoChecker.a)localObject4).height;
      }
      localObject5 = paramFinderMediaReportObject.origin;
      if (localObject5 != null) {
        ((FinderMediaReportInfo)localObject5).videoBitrate = ((MultiMediaVideoChecker.a)localObject4).bitrate;
      }
      localObject5 = paramFinderMediaReportObject.origin;
      if (localObject5 != null) {
        ((FinderMediaReportInfo)localObject5).audioBitrate = ((MultiMediaVideoChecker.a)localObject4).audioBitrate;
      }
      localObject5 = paramFinderMediaReportObject.origin;
      if (localObject5 != null) {
        ((FinderMediaReportInfo)localObject5).fps = ((int)((MultiMediaVideoChecker.a)localObject4).eGw);
      }
      localObject4 = ah.aiuX;
    }
    localObject4 = localdju.aaPJ;
    int k;
    if (localObject4 != null)
    {
      if (paramBoolean)
      {
        ((Rect)localObject2).set(((fyb)localObject4).left, ((fyb)localObject4).bottom, ((fyb)localObject4).right, ((fyb)localObject4).top);
        localObject4 = ah.aiuX;
      }
    }
    else
    {
      if (!paramBoolean) {
        break label1107;
      }
      k = localdju.width;
      label500:
      locald1.aixb = k;
      if (!paramBoolean) {
        break label1125;
      }
      k = localdju.height;
      label519:
      locald2.aixb = k;
      ((ac)localObject3).F((Rect)localObject2);
      if (paramBoolean)
      {
        localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
        float f = (float)com.tencent.mm.plugin.finder.storage.d.eQj();
        localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
        f /= 1.0F * com.tencent.mm.plugin.finder.storage.d.ePO();
        localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
        paramVideoTransPara.oCj = ((int)(f * com.tencent.mm.plugin.finder.storage.d.ePP()));
        Log.i(this.TAG, s.X("ABA:  finder video maxVideoSize:", Integer.valueOf(paramVideoTransPara.oCj)));
      }
      localObject4 = new com.tencent.mm.plugin.vlog.model.f((ac)localObject3);
      ((com.tencent.mm.plugin.vlog.model.f)localObject4).a(paramString, paramVideoTransPara, new Size(j, i), (Rect)localObject2, false, true);
      localObject2 = ((com.tencent.mm.plugin.vlog.model.f)localObject4).hQn();
      ((afb)localObject2).TYB.outputPath = paramString;
      ((afb)localObject2).TYB.oYa = w.s(paramBoolean, ((ac)localObject3).Uaw.getDurationMs());
      localObject3 = new com.tencent.mm.plugin.vlog.model.e();
      ((com.tencent.mm.plugin.vlog.model.e)localObject3).ybL = 2;
      paramdji = paramdji.EDC;
      if (paramdji != null) {
        break label1143;
      }
    }
    label1107:
    label1125:
    label1143:
    for (i = 0;; i = paramdji.retryCount)
    {
      ((com.tencent.mm.plugin.vlog.model.e)localObject3).retryCount = i;
      ((com.tencent.mm.plugin.vlog.model.e)localObject3).a(true, paramVideoTransPara);
      ((com.tencent.mm.plugin.vlog.model.e)localObject3).aJ((kotlin.g.a.b)new c(new kotlin.g.b.ah.c(), this, paramInt1, paramInt2));
      ((afb)localObject2).editId = localdju.editId;
      paramdji = new kotlin.g.b.ah.d();
      paramdji.aixb = -1;
      com.tencent.mm.plugin.vlog.model.e.a((com.tencent.mm.plugin.vlog.model.e)localObject3, (afb)localObject2, (kotlin.g.a.b)new d(this, paramdji, paramFinderMediaReportObject, paramLong, paramString, paramBoolean, locald1, locald2, paramVideoTransPara, localObject1, locala));
      try
      {
        if (!locala.aiwY)
        {
          Log.i(this.TAG, "wait longvideo");
          localObject1.wait();
          Log.i(this.TAG, s.X("notify longvideo, ", Integer.valueOf(paramdji.aixb)));
        }
        paramVideoTransPara = ah.aiuX;
        paramVideoTransPara = this.Ged.field_reportObject;
        if (paramVideoTransPara != null) {
          paramVideoTransPara.mpError = paramdji.aixb;
        }
        fey();
        paramVideoTransPara = new r(Integer.valueOf(paramdji.aixb), Float.valueOf(0.0F));
        AppMethodBeat.o(343211);
        return paramVideoTransPara;
      }
      finally
      {
        Object localObject6;
        double d2;
        double d1;
        int m;
        int n;
        int i1;
        AppMethodBeat.o(343211);
      }
      localObject5 = localdju.aaPK;
      if (localObject5 == null) {
        break;
      }
      localObject6 = ((byz)localObject5).aaib;
      if (localObject6 == null) {
        break;
      }
      localObject5 = new Matrix();
      ((Matrix)localObject5).setValues(p.H((Collection)localObject6));
      localObject6 = ah.aiuX;
      d2 = t.g((Matrix)localObject5);
      d1 = d2;
      if (d2 <= 0.0D) {
        d1 = 1.0D;
      }
      localObject5 = av.GiL;
      k = av.TM((int)Math.floor((((fyb)localObject4).top - ((fyb)localObject4).bottom) / d1));
      localObject5 = av.GiL;
      m = av.TM((int)Math.floor((((fyb)localObject4).right - ((fyb)localObject4).left) / d1));
      n = (int)Math.floor(((fyb)localObject4).left / d1);
      i1 = (int)Math.floor(((fyb)localObject4).bottom / d1);
      ((Rect)localObject2).set(n, i1, m + n, k + i1);
      localObject4 = ah.aiuX;
      localObject4 = ah.aiuX;
      break;
      localObject4 = av.GiL;
      k = av.TM(localdju.width);
      break label500;
      localObject4 = av.GiL;
      k = av.TM(localdju.height);
      break label519;
    }
  }
  
  public final void cn(float paramFloat)
  {
    AppMethodBeat.i(343331);
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i = (int)(com.tencent.mm.plugin.finder.storage.d.eQF() * f);
    Log.i(this.TAG, "feed " + this.Ged.getLocalId() + " updateProgress  " + f + ", " + i);
    if (this.Ged.getPostInfo().aaPw < i)
    {
      this.Ged.getPostInfo().aaPw = i;
      localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      d.a.v(this.Ged);
    }
    localObject = new ic();
    ((ic)localObject).hJy.localId = this.Ged.getLocalId();
    ((ic)localObject).hJy.progress = this.Ged.getPostInfo().aaPw;
    ((ic)localObject).publish();
    AppMethodBeat.o(343331);
  }
  
  public final void d(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343345);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343345);
  }
  
  public final void e(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343355);
    s.u(parame, "nextStage");
    parame = com.tencent.mm.plugin.finder.report.ah.d.Ftw;
    com.tencent.mm.plugin.finder.report.ah.d.tF(this.Ged.isLongVideo());
    AppMethodBeat.o(343355);
  }
  
  public final void f(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343362);
    s.u(parame, "nextStage");
    parame = com.tencent.mm.plugin.finder.report.ah.d.Ftw;
    com.tencent.mm.plugin.finder.report.ah.d.tF(this.Ged.isLongVideo());
    AppMethodBeat.o(343362);
  }
  
  /* Error */
  public final com.tencent.mm.plugin.finder.upload.postlogic.base.e feo()
  {
    // Byte code:
    //   0: ldc_w 937
    //   3: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   10: ldc_w 939
    //   13: invokevirtual 942	com/tencent/mm/plugin/finder/storage/FinderItem:trackPost	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   20: getfield 265	com/tencent/mm/plugin/finder/storage/FinderItem:field_reportObject	Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;
    //   23: astore 31
    //   25: aload 31
    //   27: ifnull +9 -> 36
    //   30: aload 31
    //   32: iconst_2
    //   33: putfield 945	com/tencent/mm/protocal/protobuf/FinderFeedReportObject:postStage	I
    //   36: new 947	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 948	java/util/ArrayList:<init>	()V
    //   43: checkcast 950	java/util/List
    //   46: astore 37
    //   48: new 947	java/util/ArrayList
    //   51: dup
    //   52: invokespecial 948	java/util/ArrayList:<init>	()V
    //   55: checkcast 950	java/util/List
    //   58: astore 38
    //   60: aload_0
    //   61: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   64: invokevirtual 954	com/tencent/mm/plugin/finder/storage/FinderItem:getHalfVideoMediaExtList	()Ljava/util/LinkedList;
    //   67: checkcast 956	java/lang/Iterable
    //   70: invokeinterface 960 1 0
    //   75: astore 31
    //   77: aload 31
    //   79: invokeinterface 965 1 0
    //   84: ifeq +63 -> 147
    //   87: aload 31
    //   89: invokeinterface 969 1 0
    //   94: checkcast 156	com/tencent/mm/protocal/protobuf/dji
    //   97: astore 32
    //   99: aload 32
    //   101: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   104: astore 33
    //   106: aload 33
    //   108: ifnull +33 -> 141
    //   111: aload 33
    //   113: getfield 567	com/tencent/mm/protocal/protobuf/afb:Znj	Z
    //   116: iconst_1
    //   117: if_icmpne +24 -> 141
    //   120: iconst_1
    //   121: istore 8
    //   123: iload 8
    //   125: ifeq -48 -> 77
    //   128: aload 37
    //   130: aload 32
    //   132: invokeinterface 973 2 0
    //   137: pop
    //   138: goto -61 -> 77
    //   141: iconst_0
    //   142: istore 8
    //   144: goto -21 -> 123
    //   147: aload_0
    //   148: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   151: invokevirtual 976	com/tencent/mm/plugin/finder/storage/FinderItem:getMediaList	()Ljava/util/LinkedList;
    //   154: checkcast 956	java/lang/Iterable
    //   157: astore 31
    //   159: iconst_0
    //   160: istore 8
    //   162: aload 31
    //   164: invokeinterface 960 1 0
    //   169: astore 31
    //   171: aload 31
    //   173: invokeinterface 965 1 0
    //   178: ifeq +115 -> 293
    //   181: aload 31
    //   183: invokeinterface 969 1 0
    //   188: astore 32
    //   190: iload 8
    //   192: iconst_1
    //   193: iadd
    //   194: istore 9
    //   196: iload 8
    //   198: ifge +6 -> 204
    //   201: invokestatic 979	kotlin/a/p:kkW	()V
    //   204: aload 32
    //   206: checkcast 156	com/tencent/mm/protocal/protobuf/dji
    //   209: astore 32
    //   211: aload_0
    //   212: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   215: iload 8
    //   217: invokevirtual 983	com/tencent/mm/plugin/finder/storage/FinderItem:isNeedCrop	(I)Z
    //   220: ifeq +32 -> 252
    //   223: aload_0
    //   224: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   227: iload 8
    //   229: invokevirtual 987	com/tencent/mm/plugin/finder/storage/FinderItem:getCropInfo	(I)Lcom/tencent/mm/protocal/protobuf/dji;
    //   232: ifnull +13 -> 245
    //   235: aload 37
    //   237: aload 32
    //   239: invokeinterface 973 2 0
    //   244: pop
    //   245: iload 9
    //   247: istore 8
    //   249: goto -78 -> 171
    //   252: aload_0
    //   253: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   256: iload 8
    //   258: invokevirtual 990	com/tencent/mm/plugin/finder/storage/FinderItem:isNeedVideoCompositionPlay	(I)Z
    //   261: ifeq +25 -> 286
    //   264: aload_0
    //   265: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   268: iload 8
    //   270: invokevirtual 987	com/tencent/mm/plugin/finder/storage/FinderItem:getCropInfo	(I)Lcom/tencent/mm/protocal/protobuf/dji;
    //   273: ifnull +13 -> 286
    //   276: aload 37
    //   278: aload 32
    //   280: invokeinterface 973 2 0
    //   285: pop
    //   286: iload 9
    //   288: istore 8
    //   290: goto -119 -> 171
    //   293: aload_0
    //   294: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   297: invokevirtual 993	com/tencent/mm/plugin/finder/storage/FinderItem:getLongVideoMediaExtList	()Ljava/util/LinkedList;
    //   300: invokevirtual 716	java/util/LinkedList:size	()I
    //   303: ifle +10 -> 313
    //   306: aload 37
    //   308: invokeinterface 996 1 0
    //   313: aload_0
    //   314: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   317: invokevirtual 993	com/tencent/mm/plugin/finder/storage/FinderItem:getLongVideoMediaExtList	()Ljava/util/LinkedList;
    //   320: checkcast 956	java/lang/Iterable
    //   323: astore 31
    //   325: iconst_0
    //   326: istore 8
    //   328: aload 31
    //   330: invokeinterface 960 1 0
    //   335: astore 31
    //   337: aload 31
    //   339: invokeinterface 965 1 0
    //   344: ifeq +72 -> 416
    //   347: aload 31
    //   349: invokeinterface 969 1 0
    //   354: astore 32
    //   356: iload 8
    //   358: ifge +6 -> 364
    //   361: invokestatic 979	kotlin/a/p:kkW	()V
    //   364: aload 32
    //   366: checkcast 156	com/tencent/mm/protocal/protobuf/dji
    //   369: astore 32
    //   371: aload 32
    //   373: getfield 534	com/tencent/mm/protocal/protobuf/dji:aaPf	Z
    //   376: ifeq +31 -> 407
    //   379: aload 32
    //   381: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   384: ifnull +23 -> 407
    //   387: aload 37
    //   389: aload 32
    //   391: invokeinterface 973 2 0
    //   396: pop
    //   397: aload 38
    //   399: aload 32
    //   401: invokeinterface 973 2 0
    //   406: pop
    //   407: iload 8
    //   409: iconst_1
    //   410: iadd
    //   411: istore 8
    //   413: goto -76 -> 337
    //   416: getstatic 350	com/tencent/mm/plugin/finder/storage/d:FAy	Lcom/tencent/mm/plugin/finder/storage/d;
    //   419: astore 31
    //   421: invokestatic 999	com/tencent/mm/plugin/finder/storage/d:eQH	()Z
    //   424: ifeq +25 -> 449
    //   427: invokestatic 1002	com/tencent/mm/sdk/platformtools/Log:getLogLevel	()I
    //   430: iflt +19 -> 449
    //   433: aload_0
    //   434: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   437: ldc_w 1004
    //   440: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: ldc2_w 1005
    //   446: invokestatic 1011	java/lang/Thread:sleep	(J)V
    //   449: getstatic 350	com/tencent/mm/plugin/finder/storage/d:FAy	Lcom/tencent/mm/plugin/finder/storage/d;
    //   452: astore 31
    //   454: invokestatic 1015	com/tencent/mm/plugin/finder/storage/d:eQB	()Lcom/tencent/mm/plugin/findersdk/storage/config/base/b;
    //   457: invokevirtual 1020	com/tencent/mm/plugin/findersdk/storage/config/base/b:bmg	()Ljava/lang/Object;
    //   460: checkcast 1022	java/lang/Number
    //   463: invokevirtual 1025	java/lang/Number:intValue	()I
    //   466: iconst_1
    //   467: if_icmpne +40 -> 507
    //   470: aload_0
    //   471: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   474: astore 31
    //   476: getstatic 1031	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:Gfb	Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/g$a;
    //   479: astore 32
    //   481: new 1027	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g
    //   484: dup
    //   485: aload 31
    //   487: invokestatic 1034	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:fev	()I
    //   490: invokespecial 1037	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:<init>	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;I)V
    //   493: checkcast 1039	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   496: astore 31
    //   498: ldc_w 937
    //   501: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   504: aload 31
    //   506: areturn
    //   507: aload 37
    //   509: invokeinterface 1040 1 0
    //   514: ifgt +43 -> 557
    //   517: aload_0
    //   518: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   521: ldc_w 1042
    //   524: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: aload_0
    //   528: fconst_1
    //   529: invokevirtual 1044	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:cn	(F)V
    //   532: new 1046	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/f
    //   535: dup
    //   536: aload_0
    //   537: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   540: invokespecial 1048	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/f:<init>	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V
    //   543: checkcast 1039	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   546: astore 31
    //   548: ldc_w 937
    //   551: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   554: aload 31
    //   556: areturn
    //   557: aload_0
    //   558: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   561: ldc_w 1050
    //   564: aload 37
    //   566: invokeinterface 1040 1 0
    //   571: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   574: invokestatic 229	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   577: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   580: getstatic 927	com/tencent/mm/plugin/finder/report/ah$d:Ftw	Lcom/tencent/mm/plugin/finder/report/ah$d;
    //   583: astore 31
    //   585: aload_0
    //   586: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   589: invokevirtual 929	com/tencent/mm/plugin/finder/storage/FinderItem:isLongVideo	()Z
    //   592: invokestatic 1053	com/tencent/mm/plugin/finder/report/ah$d:tE	(Z)V
    //   595: aload 37
    //   597: checkcast 956	java/lang/Iterable
    //   600: astore 31
    //   602: iconst_0
    //   603: istore 11
    //   605: aload 31
    //   607: invokeinterface 960 1 0
    //   612: astore 39
    //   614: aload 39
    //   616: invokeinterface 965 1 0
    //   621: ifeq +7165 -> 7786
    //   624: aload 39
    //   626: invokeinterface 969 1 0
    //   631: astore 31
    //   633: iload 11
    //   635: ifge +6 -> 641
    //   638: invokestatic 979	kotlin/a/p:kkW	()V
    //   641: aload 31
    //   643: checkcast 156	com/tencent/mm/protocal/protobuf/dji
    //   646: astore 40
    //   648: aload 40
    //   650: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   653: astore 31
    //   655: aload 31
    //   657: ifnonnull +56 -> 713
    //   660: iconst_0
    //   661: istore 8
    //   663: getstatic 350	com/tencent/mm/plugin/finder/storage/d:FAy	Lcom/tencent/mm/plugin/finder/storage/d;
    //   666: astore 31
    //   668: iload 8
    //   670: invokestatic 1056	com/tencent/mm/plugin/finder/storage/d:eQD	()I
    //   673: if_icmple +50 -> 723
    //   676: aload_0
    //   677: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   680: astore 31
    //   682: getstatic 1031	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:Gfb	Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/g$a;
    //   685: astore 32
    //   687: new 1027	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g
    //   690: dup
    //   691: aload 31
    //   693: invokestatic 1034	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:fev	()I
    //   696: invokespecial 1037	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:<init>	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;I)V
    //   699: checkcast 1039	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   702: astore 31
    //   704: ldc_w 937
    //   707: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   710: aload 31
    //   712: areturn
    //   713: aload 31
    //   715: getfield 398	com/tencent/mm/protocal/protobuf/dju:retryCount	I
    //   718: istore 8
    //   720: goto -57 -> 663
    //   723: aload 38
    //   725: invokeinterface 1057 1 0
    //   730: astore 31
    //   732: iconst_0
    //   733: istore 8
    //   735: aload 31
    //   737: invokeinterface 965 1 0
    //   742: ifeq +464 -> 1206
    //   745: aload 31
    //   747: invokeinterface 969 1 0
    //   752: checkcast 156	com/tencent/mm/protocal/protobuf/dji
    //   755: getfield 542	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   758: aload 40
    //   760: getfield 542	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   763: invokestatic 1061	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   766: ifeq +431 -> 1197
    //   769: iload 8
    //   771: iflt +441 -> 1212
    //   774: iconst_1
    //   775: istore 20
    //   777: iload 20
    //   779: ifne +445 -> 1224
    //   782: aload 38
    //   784: checkcast 840	java/util/Collection
    //   787: invokeinterface 1064 1 0
    //   792: ifne +426 -> 1218
    //   795: iconst_1
    //   796: istore 8
    //   798: iload 8
    //   800: ifeq +424 -> 1224
    //   803: iconst_1
    //   804: istore 21
    //   806: iload 20
    //   808: ifeq +422 -> 1230
    //   811: getstatic 1070	com/tencent/mm/plugin/finder/ui/config/a:FWH	Lcom/tencent/mm/plugin/finder/ui/config/a;
    //   814: astore 31
    //   816: invokestatic 1074	com/tencent/mm/plugin/finder/ui/config/a:fcM	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   819: astore 34
    //   821: aload_0
    //   822: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   825: new 239	java/lang/StringBuilder
    //   828: dup
    //   829: ldc_w 1076
    //   832: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   835: iload 11
    //   837: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   840: ldc_w 1078
    //   843: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: iload 20
    //   848: invokevirtual 610	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   851: ldc_w 1080
    //   854: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload 34
    //   859: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   862: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   868: aload 40
    //   870: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   873: astore 31
    //   875: aload 31
    //   877: ifnull +27 -> 904
    //   880: aload 40
    //   882: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   885: astore 32
    //   887: aload 32
    //   889: ifnonnull +354 -> 1243
    //   892: iconst_0
    //   893: istore 8
    //   895: aload 31
    //   897: iload 8
    //   899: iconst_1
    //   900: iadd
    //   901: putfield 398	com/tencent/mm/protocal/protobuf/dju:retryCount	I
    //   904: iload 20
    //   906: ifeq +24 -> 930
    //   909: aload_0
    //   910: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   913: getfield 265	com/tencent/mm/plugin/finder/storage/FinderItem:field_reportObject	Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;
    //   916: astore 31
    //   918: aload 31
    //   920: ifnull +10 -> 930
    //   923: aload 31
    //   925: bipush 6
    //   927: putfield 945	com/tencent/mm/protocal/protobuf/FinderFeedReportObject:postStage	I
    //   930: getstatic 893	com/tencent/mm/plugin/finder/storage/logic/d:FND	Lcom/tencent/mm/plugin/finder/storage/logic/d$a;
    //   933: astore 31
    //   935: aload_0
    //   936: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   939: invokestatic 899	com/tencent/mm/plugin/finder/storage/logic/d$a:v	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)Z
    //   942: pop
    //   943: getstatic 414	com/tencent/mm/plugin/finder/utils/av:GiL	Lcom/tencent/mm/plugin/finder/utils/av;
    //   946: astore 31
    //   948: aload 40
    //   950: invokestatic 1083	com/tencent/mm/plugin/finder/utils/av:i	(Lcom/tencent/mm/protocal/protobuf/dji;)Z
    //   953: istore 25
    //   955: new 556	com/tencent/mm/protocal/protobuf/FinderMediaReportObject
    //   958: dup
    //   959: invokespecial 1084	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:<init>	()V
    //   962: astore 41
    //   964: aload 41
    //   966: aload 40
    //   968: getfield 1087	com/tencent/mm/protocal/protobuf/dji:mediaType	I
    //   971: putfield 1088	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:mediaType	I
    //   974: aload 41
    //   976: new 714	java/util/LinkedList
    //   979: dup
    //   980: invokespecial 1089	java/util/LinkedList:<init>	()V
    //   983: putfield 1092	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:multiMediaInfo	Ljava/util/LinkedList;
    //   986: aload 40
    //   988: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   991: astore 31
    //   993: aload 31
    //   995: ifnull +263 -> 1258
    //   998: aload 31
    //   1000: getfield 1095	com/tencent/mm/protocal/protobuf/afb:Zng	Ljava/util/LinkedList;
    //   1003: astore 31
    //   1005: aload 31
    //   1007: ifnull +251 -> 1258
    //   1010: aload 31
    //   1012: checkcast 956	java/lang/Iterable
    //   1015: invokeinterface 960 1 0
    //   1020: astore 31
    //   1022: aload 31
    //   1024: invokeinterface 965 1 0
    //   1029: ifeq +224 -> 1253
    //   1032: aload 31
    //   1034: invokeinterface 969 1 0
    //   1039: checkcast 1097	com/tencent/mm/protocal/protobuf/fos
    //   1042: astore 35
    //   1044: new 553	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo
    //   1047: dup
    //   1048: invokespecial 554	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:<init>	()V
    //   1051: astore 32
    //   1053: aload 32
    //   1055: aload 35
    //   1057: getfield 1099	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   1060: invokestatic 548	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   1063: l2i
    //   1064: putfield 561	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:fileSize	I
    //   1067: getstatic 619	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:ObB	Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker;
    //   1070: astore 33
    //   1072: aload 35
    //   1074: getfield 1099	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   1077: astore 35
    //   1079: aload 35
    //   1081: ldc_w 1101
    //   1084: invokestatic 1103	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1087: aload 33
    //   1089: aload 35
    //   1091: invokevirtual 623	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:aTG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a;
    //   1094: astore 33
    //   1096: aload 33
    //   1098: ifnull +85 -> 1183
    //   1101: aload 32
    //   1103: aload 33
    //   1105: getfield 641	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   1108: putfield 642	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:width	I
    //   1111: aload 32
    //   1113: aload 33
    //   1115: getfield 643	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   1118: putfield 644	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:height	I
    //   1121: aload 32
    //   1123: aload 33
    //   1125: getfield 646	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:bitrate	I
    //   1128: putfield 649	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:videoBitrate	I
    //   1131: aload 32
    //   1133: aload 33
    //   1135: getfield 629	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:duration	J
    //   1138: l2i
    //   1139: putfield 640	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:videoDuration	I
    //   1142: aload 32
    //   1144: aload 33
    //   1146: getfield 650	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:audioBitrate	I
    //   1149: putfield 651	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:audioBitrate	I
    //   1152: aload 32
    //   1154: aload 33
    //   1156: getfield 654	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:eGw	F
    //   1159: f2i
    //   1160: putfield 655	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:fps	I
    //   1163: aload_0
    //   1164: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   1167: ldc_w 1105
    //   1170: aload 33
    //   1172: invokestatic 229	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1175: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1178: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   1181: astore 33
    //   1183: aload 41
    //   1185: getfield 1092	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:multiMediaInfo	Ljava/util/LinkedList;
    //   1188: aload 32
    //   1190: invokevirtual 1106	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   1193: pop
    //   1194: goto -172 -> 1022
    //   1197: iload 8
    //   1199: iconst_1
    //   1200: iadd
    //   1201: istore 8
    //   1203: goto -468 -> 735
    //   1206: iconst_m1
    //   1207: istore 8
    //   1209: goto -440 -> 769
    //   1212: iconst_0
    //   1213: istore 20
    //   1215: goto -438 -> 777
    //   1218: iconst_0
    //   1219: istore 8
    //   1221: goto -423 -> 798
    //   1224: iconst_0
    //   1225: istore 21
    //   1227: goto -421 -> 806
    //   1230: getstatic 350	com/tencent/mm/plugin/finder/storage/d:FAy	Lcom/tencent/mm/plugin/finder/storage/d;
    //   1233: astore 31
    //   1235: invokestatic 1109	com/tencent/mm/plugin/finder/storage/d:ePV	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   1238: astore 34
    //   1240: goto -419 -> 821
    //   1243: aload 32
    //   1245: getfield 398	com/tencent/mm/protocal/protobuf/dju:retryCount	I
    //   1248: istore 8
    //   1250: goto -355 -> 895
    //   1253: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   1256: astore 31
    //   1258: aload 41
    //   1260: getfield 1092	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:multiMediaInfo	Ljava/util/LinkedList;
    //   1263: astore 31
    //   1265: aload 31
    //   1267: ifnonnull +1561 -> 2828
    //   1270: aconst_null
    //   1271: astore 31
    //   1273: aload 31
    //   1275: astore 32
    //   1277: aload 31
    //   1279: ifnonnull +12 -> 1291
    //   1282: new 553	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo
    //   1285: dup
    //   1286: invokespecial 554	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:<init>	()V
    //   1289: astore 32
    //   1291: aload 41
    //   1293: aload 32
    //   1295: putfield 775	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:origin	Lcom/tencent/mm/protocal/protobuf/FinderMediaReportInfo;
    //   1298: aload 40
    //   1300: getfield 542	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   1303: astore 35
    //   1305: aload 35
    //   1307: ifnonnull +1537 -> 2844
    //   1310: invokestatic 1115	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   1313: invokevirtual 1116	java/util/UUID:toString	()Ljava/lang/String;
    //   1316: astore 35
    //   1318: aload 35
    //   1320: ldc_w 1118
    //   1323: invokestatic 1103	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1326: invokestatic 1121	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   1329: lstore 29
    //   1331: new 1123	com/tencent/mm/plugin/finder/loader/v
    //   1334: dup
    //   1335: aload 40
    //   1337: getstatic 1129	com/tencent/mm/plugin/finder/storage/v:FLB	Lcom/tencent/mm/plugin/finder/storage/v;
    //   1340: iconst_0
    //   1341: aconst_null
    //   1342: bipush 12
    //   1344: invokespecial 1132	com/tencent/mm/plugin/finder/loader/v:<init>	(Lcom/tencent/mm/protocal/protobuf/dji;Lcom/tencent/mm/plugin/finder/storage/v;ILjava/lang/String;I)V
    //   1347: astore 32
    //   1349: getstatic 515	com/tencent/mm/plugin/finder/utils/bm:GlZ	Lcom/tencent/mm/plugin/finder/utils/bm;
    //   1352: astore 31
    //   1354: new 239	java/lang/StringBuilder
    //   1357: dup
    //   1358: invokespecial 1133	java/lang/StringBuilder:<init>	()V
    //   1361: aload_0
    //   1362: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   1365: invokevirtual 1136	com/tencent/mm/plugin/finder/storage/FinderItem:getCreateTime	()J
    //   1368: invokevirtual 876	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1371: astore 33
    //   1373: aload 40
    //   1375: getfield 464	com/tencent/mm/protocal/protobuf/dji:aaPp	Z
    //   1378: ifeq +1469 -> 2847
    //   1381: ldc_w 1138
    //   1384: astore 31
    //   1386: aload 32
    //   1388: aload 33
    //   1390: aload 31
    //   1392: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1398: invokestatic 1141	com/tencent/mm/plugin/finder/utils/bm:a	(Lcom/tencent/mm/plugin/finder/loader/v;Ljava/lang/String;)Ljava/lang/String;
    //   1401: astore 42
    //   1403: aconst_null
    //   1404: astore 33
    //   1406: iconst_1
    //   1407: istore 12
    //   1409: iconst_2
    //   1410: istore 9
    //   1412: getstatic 679	com/tencent/mm/plugin/vlog/model/m:TYW	Lcom/tencent/mm/plugin/vlog/model/m;
    //   1415: astore 31
    //   1417: invokestatic 1144	com/tencent/mm/plugin/vlog/model/m:hQq	()Z
    //   1420: ifeq +1434 -> 2854
    //   1423: getstatic 679	com/tencent/mm/plugin/vlog/model/m:TYW	Lcom/tencent/mm/plugin/vlog/model/m;
    //   1426: astore 31
    //   1428: invokestatic 1147	com/tencent/mm/plugin/vlog/model/m:hQs	()I
    //   1431: istore 10
    //   1433: ldc_w 1149
    //   1436: invokestatic 1155	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1439: checkcast 1149	com/tencent/mm/plugin/expt/b/c
    //   1442: getstatic 1161	com/tencent/mm/plugin/expt/b/c$a:zpY	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   1445: iconst_1
    //   1446: invokeinterface 1164 3 0
    //   1451: istore 13
    //   1453: aload 40
    //   1455: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1458: astore 31
    //   1460: aload 31
    //   1462: ifnonnull +1415 -> 2877
    //   1465: aconst_null
    //   1466: astore 31
    //   1468: aload 40
    //   1470: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1473: astore 32
    //   1475: aload 32
    //   1477: ifnull +1434 -> 2911
    //   1480: aload 32
    //   1482: getfield 1095	com/tencent/mm/protocal/protobuf/afb:Zng	Ljava/util/LinkedList;
    //   1485: astore 32
    //   1487: aload 32
    //   1489: ifnull +1422 -> 2911
    //   1492: aload 32
    //   1494: invokevirtual 716	java/util/LinkedList:size	()I
    //   1497: iconst_1
    //   1498: if_icmpne +1413 -> 2911
    //   1501: iconst_1
    //   1502: istore 8
    //   1504: iload 8
    //   1506: ifeq +1489 -> 2995
    //   1509: aload 40
    //   1511: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1514: astore 32
    //   1516: aload 32
    //   1518: ifnonnull +1399 -> 2917
    //   1521: iconst_0
    //   1522: istore 8
    //   1524: iload 8
    //   1526: ifne +1469 -> 2995
    //   1529: aload 40
    //   1531: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1534: astore 32
    //   1536: aload 32
    //   1538: ifnull +1425 -> 2963
    //   1541: aload 32
    //   1543: getfield 1167	com/tencent/mm/protocal/protobuf/afb:Uay	Z
    //   1546: ifne +1417 -> 2963
    //   1549: iconst_1
    //   1550: istore 8
    //   1552: iload 8
    //   1554: ifeq +1441 -> 2995
    //   1557: aload 40
    //   1559: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1562: astore 32
    //   1564: aload 32
    //   1566: ifnonnull +1403 -> 2969
    //   1569: aconst_null
    //   1570: astore 32
    //   1572: aload 32
    //   1574: ifnonnull +1421 -> 2995
    //   1577: aload 31
    //   1579: ifnull +1416 -> 2995
    //   1582: aload 31
    //   1584: getfield 1171	com/tencent/mm/protocal/protobuf/fos:abPa	Lcom/tencent/mm/protocal/protobuf/fqf;
    //   1587: ifnull +48 -> 1635
    //   1590: aload 31
    //   1592: getfield 1171	com/tencent/mm/protocal/protobuf/fos:abPa	Lcom/tencent/mm/protocal/protobuf/fqf;
    //   1595: astore 32
    //   1597: aload 32
    //   1599: ifnonnull +1380 -> 2979
    //   1602: aconst_null
    //   1603: astore 32
    //   1605: aload 32
    //   1607: checkcast 1173	java/lang/CharSequence
    //   1610: astore 32
    //   1612: aload 32
    //   1614: ifnull +13 -> 1627
    //   1617: aload 32
    //   1619: invokeinterface 1176 1 0
    //   1624: ifne +1365 -> 2989
    //   1627: iconst_1
    //   1628: istore 8
    //   1630: iload 8
    //   1632: ifeq +1363 -> 2995
    //   1635: aload 31
    //   1637: getfield 1179	com/tencent/mm/protocal/protobuf/fos:endTimeMs	J
    //   1640: aload 31
    //   1642: getfield 1182	com/tencent/mm/protocal/protobuf/fos:startTimeMs	J
    //   1645: lsub
    //   1646: aload 31
    //   1648: getfield 1185	com/tencent/mm/protocal/protobuf/fos:TDx	J
    //   1651: aload 31
    //   1653: getfield 1188	com/tencent/mm/protocal/protobuf/fos:TDw	J
    //   1656: lsub
    //   1657: lcmp
    //   1658: ifne +1337 -> 2995
    //   1661: iconst_1
    //   1662: istore 19
    //   1664: aload_0
    //   1665: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   1668: astore 32
    //   1670: new 239	java/lang/StringBuilder
    //   1673: dup
    //   1674: ldc_w 1190
    //   1677: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1680: iload 10
    //   1682: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1685: ldc_w 1192
    //   1688: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1691: iload 13
    //   1693: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1696: ldc_w 1194
    //   1699: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1702: astore 36
    //   1704: aload 40
    //   1706: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1709: astore 31
    //   1711: aload 31
    //   1713: ifnonnull +1288 -> 3001
    //   1716: aconst_null
    //   1717: astore 31
    //   1719: aload 36
    //   1721: aload 31
    //   1723: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1726: ldc_w 1196
    //   1729: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: astore 36
    //   1734: aload 40
    //   1736: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1739: astore 31
    //   1741: aload 31
    //   1743: ifnonnull +1289 -> 3032
    //   1746: aconst_null
    //   1747: astore 31
    //   1749: aload 32
    //   1751: aload 36
    //   1753: aload 31
    //   1755: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1758: ldc_w 1198
    //   1761: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: iload 19
    //   1766: invokevirtual 610	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1769: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1772: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1775: ldc_w 1149
    //   1778: invokestatic 1155	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1781: checkcast 1149	com/tencent/mm/plugin/expt/b/c
    //   1784: getstatic 1201	com/tencent/mm/plugin/expt/b/c$a:zjq	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   1787: iconst_0
    //   1788: invokeinterface 1164 3 0
    //   1793: iconst_1
    //   1794: if_icmpne +6105 -> 7899
    //   1797: iconst_1
    //   1798: istore 22
    //   1800: aload 34
    //   1802: getfield 183	com/tencent/mm/modelcontrol/VideoTransPara:audioBitrate	I
    //   1805: i2f
    //   1806: ldc_w 630
    //   1809: fdiv
    //   1810: fstore 5
    //   1812: aload 34
    //   1814: getfield 186	com/tencent/mm/modelcontrol/VideoTransPara:audioSampleRate	I
    //   1817: i2f
    //   1818: fstore 6
    //   1820: aload 34
    //   1822: getfield 189	com/tencent/mm/modelcontrol/VideoTransPara:audioChannelCount	I
    //   1825: istore 18
    //   1827: aload 40
    //   1829: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1832: astore 31
    //   1834: aload 31
    //   1836: ifnonnull +1245 -> 3081
    //   1839: iconst_1
    //   1840: istore 23
    //   1842: iload 13
    //   1844: iconst_1
    //   1845: if_icmpne +1346 -> 3191
    //   1848: iload 19
    //   1850: ifeq +1341 -> 3191
    //   1853: aload 40
    //   1855: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1858: astore 31
    //   1860: aload 31
    //   1862: ifnonnull +1229 -> 3091
    //   1865: aconst_null
    //   1866: astore 31
    //   1868: aload 31
    //   1870: ifnonnull +1253 -> 3123
    //   1873: new 1097	com/tencent/mm/protocal/protobuf/fos
    //   1876: dup
    //   1877: invokespecial 1202	com/tencent/mm/protocal/protobuf/fos:<init>	()V
    //   1880: astore 31
    //   1882: aload 31
    //   1884: getfield 1099	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   1887: astore 32
    //   1889: aload 32
    //   1891: ldc_w 1101
    //   1894: invokestatic 1103	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1897: getstatic 619	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:ObB	Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker;
    //   1900: aload 32
    //   1902: invokevirtual 623	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:aTG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a;
    //   1905: astore 32
    //   1907: aload 32
    //   1909: ifnull +1237 -> 3146
    //   1912: aload 32
    //   1914: getfield 755	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:hYK	I
    //   1917: bipush 90
    //   1919: if_icmpeq +14 -> 1933
    //   1922: aload 32
    //   1924: getfield 755	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:hYK	I
    //   1927: sipush 270
    //   1930: if_icmpne +1196 -> 3126
    //   1933: aload 32
    //   1935: getfield 643	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   1938: istore 8
    //   1940: iload 8
    //   1942: i2d
    //   1943: dstore_1
    //   1944: aload 32
    //   1946: getfield 755	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:hYK	I
    //   1949: bipush 90
    //   1951: if_icmpeq +14 -> 1965
    //   1954: aload 32
    //   1956: getfield 755	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:hYK	I
    //   1959: sipush 270
    //   1962: if_icmpne +1174 -> 3136
    //   1965: aload 32
    //   1967: getfield 641	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   1970: istore 8
    //   1972: dconst_1
    //   1973: dload_1
    //   1974: dmul
    //   1975: iload 8
    //   1977: i2d
    //   1978: ddiv
    //   1979: dstore_1
    //   1980: aload_0
    //   1981: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   1984: new 239	java/lang/StringBuilder
    //   1987: dup
    //   1988: ldc_w 1204
    //   1991: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1994: aload 32
    //   1996: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1999: ldc_w 1206
    //   2002: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2005: aload 34
    //   2007: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2010: ldc_w 1208
    //   2013: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2016: dload_1
    //   2017: invokevirtual 1211	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2020: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2023: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2026: aload_0
    //   2027: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   2030: astore 36
    //   2032: new 239	java/lang/StringBuilder
    //   2035: dup
    //   2036: ldc_w 1213
    //   2039: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2042: astore 43
    //   2044: getstatic 350	com/tencent/mm/plugin/finder/storage/d:FAy	Lcom/tencent/mm/plugin/finder/storage/d;
    //   2047: astore 44
    //   2049: aload 43
    //   2051: invokestatic 1217	com/tencent/mm/plugin/finder/storage/d:eRR	()Lkotlin/k/c;
    //   2054: dload_1
    //   2055: invokestatic 1222	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   2058: checkcast 1224	java/lang/Comparable
    //   2061: invokeinterface 1229 2 0
    //   2066: invokevirtual 610	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2069: ldc_w 1231
    //   2072: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2075: astore 43
    //   2077: getstatic 350	com/tencent/mm/plugin/finder/storage/d:FAy	Lcom/tencent/mm/plugin/finder/storage/d;
    //   2080: astore 44
    //   2082: aload 36
    //   2084: aload 43
    //   2086: invokestatic 1217	com/tencent/mm/plugin/finder/storage/d:eRR	()Lkotlin/k/c;
    //   2089: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2092: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2095: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2098: aload 32
    //   2100: getfield 1234	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:Lam	Z
    //   2103: ifne +1043 -> 3146
    //   2106: aload 32
    //   2108: getfield 646	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:bitrate	I
    //   2111: aload 34
    //   2113: getfield 1235	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   2116: if_icmpgt +1030 -> 3146
    //   2119: aload 32
    //   2121: getfield 654	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:eGw	F
    //   2124: aload 34
    //   2126: getfield 192	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   2129: i2f
    //   2130: fcmpg
    //   2131: ifgt +1015 -> 3146
    //   2134: iconst_1
    //   2135: istore 24
    //   2137: aload 40
    //   2139: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   2142: astore 32
    //   2144: aload 32
    //   2146: ifnonnull +1006 -> 3152
    //   2149: aconst_null
    //   2150: astore 32
    //   2152: aload 32
    //   2154: invokestatic 1239	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   2157: istore 26
    //   2159: aload_0
    //   2160: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   2163: new 239	java/lang/StringBuilder
    //   2166: dup
    //   2167: ldc_w 1241
    //   2170: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2173: iload 24
    //   2175: invokevirtual 610	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2178: ldc_w 1243
    //   2181: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2184: iload 26
    //   2186: invokevirtual 610	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2189: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2192: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2195: iload 24
    //   2197: ifeq +994 -> 3191
    //   2200: iload 26
    //   2202: ifeq +989 -> 3191
    //   2205: new 470	android/graphics/Rect
    //   2208: dup
    //   2209: invokespecial 471	android/graphics/Rect:<init>	()V
    //   2212: astore 32
    //   2214: new 470	android/graphics/Rect
    //   2217: dup
    //   2218: invokespecial 471	android/graphics/Rect:<init>	()V
    //   2221: astore 36
    //   2223: aload 31
    //   2225: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   2228: getfield 1250	com/tencent/mm/protocal/protobuf/ahj:Zqq	Lcom/tencent/mm/protocal/protobuf/enx;
    //   2231: aload 32
    //   2233: invokestatic 486	com/tencent/mm/plugin/vlog/model/h:a	(Lcom/tencent/mm/protocal/protobuf/enx;Landroid/graphics/Rect;)V
    //   2236: aload 31
    //   2238: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   2241: getfield 1253	com/tencent/mm/protocal/protobuf/ahj:Zqs	Lcom/tencent/mm/protocal/protobuf/enx;
    //   2244: aload 36
    //   2246: invokestatic 486	com/tencent/mm/plugin/vlog/model/h:a	(Lcom/tencent/mm/protocal/protobuf/enx;Landroid/graphics/Rect;)V
    //   2249: aload_0
    //   2250: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   2253: new 239	java/lang/StringBuilder
    //   2256: dup
    //   2257: ldc_w 1255
    //   2260: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2263: aload 32
    //   2265: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2268: ldc_w 1257
    //   2271: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2274: aload 36
    //   2276: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2279: ldc_w 1259
    //   2282: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2285: aload 31
    //   2287: getfield 1188	com/tencent/mm/protocal/protobuf/fos:TDw	J
    //   2290: invokevirtual 876	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2293: ldc 248
    //   2295: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2298: aload 31
    //   2300: getfield 1185	com/tencent/mm/protocal/protobuf/fos:TDx	J
    //   2303: invokevirtual 876	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2306: ldc 248
    //   2308: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2311: aload 31
    //   2313: getfield 1262	com/tencent/mm/protocal/protobuf/fos:UjZ	J
    //   2316: invokevirtual 876	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2319: bipush 93
    //   2321: invokevirtual 1265	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2324: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2327: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2330: aload 31
    //   2332: getfield 1188	com/tencent/mm/protocal/protobuf/fos:TDw	J
    //   2335: lconst_0
    //   2336: lcmp
    //   2337: ifne +854 -> 3191
    //   2340: aload 31
    //   2342: getfield 1262	com/tencent/mm/protocal/protobuf/fos:UjZ	J
    //   2345: aload 31
    //   2347: getfield 1185	com/tencent/mm/protocal/protobuf/fos:TDx	J
    //   2350: lsub
    //   2351: ldc2_w 1266
    //   2354: lcmp
    //   2355: ifgt +836 -> 3191
    //   2358: aload 31
    //   2360: getfield 1262	com/tencent/mm/protocal/protobuf/fos:UjZ	J
    //   2363: aload 34
    //   2365: getfield 1269	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   2368: sipush 1000
    //   2371: imul
    //   2372: i2l
    //   2373: lcmp
    //   2374: ifgt +817 -> 3191
    //   2377: aload 32
    //   2379: aload 36
    //   2381: invokestatic 1061	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2384: ifeq +807 -> 3191
    //   2387: aload 31
    //   2389: getfield 1099	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   2392: invokestatic 1274	com/tencent/mm/plugin/sight/base/SightVideoJNI:optimizeMP4VFS	(Ljava/lang/String;)Z
    //   2395: istore 24
    //   2397: getstatic 414	com/tencent/mm/plugin/finder/utils/av:GiL	Lcom/tencent/mm/plugin/finder/utils/av;
    //   2400: astore 32
    //   2402: aload 31
    //   2404: getfield 1099	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   2407: astore 32
    //   2409: aload 32
    //   2411: ldc_w 1101
    //   2414: invokestatic 1103	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2417: aload 32
    //   2419: invokestatic 1277	com/tencent/mm/plugin/finder/utils/av:aBO	(Ljava/lang/String;)Z
    //   2422: istore 26
    //   2424: aload_0
    //   2425: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   2428: new 239	java/lang/StringBuilder
    //   2431: dup
    //   2432: ldc_w 1279
    //   2435: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2438: iload 24
    //   2440: invokevirtual 610	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2443: ldc_w 1281
    //   2446: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2449: iload 26
    //   2451: invokevirtual 610	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2454: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2457: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2460: iload 26
    //   2462: ifeq +706 -> 3168
    //   2465: aload_0
    //   2466: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   2469: ldc_w 1283
    //   2472: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2475: iconst_3
    //   2476: istore 9
    //   2478: aload 31
    //   2480: getfield 1099	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   2483: aload 42
    //   2485: iconst_0
    //   2486: invokestatic 1287	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   2489: pop2
    //   2490: aload 42
    //   2492: aload 31
    //   2494: getfield 1290	com/tencent/mm/protocal/protobuf/fos:UaC	I
    //   2497: aload 31
    //   2499: getfield 1293	com/tencent/mm/protocal/protobuf/fos:UaD	I
    //   2502: aload 34
    //   2504: getfield 192	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   2507: aload 34
    //   2509: getfield 1235	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   2512: aload 31
    //   2514: getfield 1262	com/tencent/mm/protocal/protobuf/fos:UjZ	J
    //   2517: l2f
    //   2518: ldc_w 630
    //   2521: fdiv
    //   2522: aload 34
    //   2524: getfield 1296	com/tencent/mm/modelcontrol/VideoTransPara:oCd	F
    //   2527: aload 34
    //   2529: getfield 1299	com/tencent/mm/modelcontrol/VideoTransPara:oCh	I
    //   2532: aload 34
    //   2534: getfield 1302	com/tencent/mm/modelcontrol/VideoTransPara:oCi	I
    //   2537: invokestatic 1305	com/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate:a	(Ljava/lang/String;IIIIFFII)Lcom/tencent/mm/plugin/sight/base/ABAPrams;
    //   2540: astore 31
    //   2542: aload 31
    //   2544: ifnull +5350 -> 7894
    //   2547: aload 31
    //   2549: getfield 1310	com/tencent/mm/plugin/sight/base/ABAPrams:qualityLevel	I
    //   2552: istore 8
    //   2554: iload 8
    //   2556: i2f
    //   2557: fstore_3
    //   2558: fload_3
    //   2559: fstore 4
    //   2561: iload 24
    //   2563: ifeq +19 -> 2582
    //   2566: aload 42
    //   2568: aload 31
    //   2570: aload 34
    //   2572: getfield 1313	com/tencent/mm/modelcontrol/VideoTransPara:oCb	I
    //   2575: iconst_0
    //   2576: invokestatic 1317	com/tencent/mm/plugin/sight/base/SightVideoJNI:addReportMetadata	(Ljava/lang/String;Lcom/tencent/mm/plugin/sight/base/ABAPrams;II)V
    //   2579: fload_3
    //   2580: fstore 4
    //   2582: getstatic 297	com/tencent/mm/plugin/finder/report/ah$c:Ftv	Lcom/tencent/mm/plugin/finder/report/ah$c;
    //   2585: astore 31
    //   2587: iload 20
    //   2589: ifne +8 -> 2597
    //   2592: iload 21
    //   2594: ifeq +568 -> 3162
    //   2597: iconst_1
    //   2598: istore 24
    //   2600: iload 24
    //   2602: invokestatic 1320	com/tencent/mm/plugin/finder/report/ah$c:tz	(Z)V
    //   2605: fload 4
    //   2607: fstore_3
    //   2608: iload 9
    //   2610: iconst_3
    //   2611: if_icmpeq +5234 -> 7845
    //   2614: aload 40
    //   2616: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   2619: astore 31
    //   2621: aload 31
    //   2623: ifnonnull +579 -> 3202
    //   2626: aconst_null
    //   2627: astore 32
    //   2629: iload 19
    //   2631: ifeq +5257 -> 7888
    //   2634: aload 32
    //   2636: ifnull +5252 -> 7888
    //   2639: new 470	android/graphics/Rect
    //   2642: dup
    //   2643: invokespecial 471	android/graphics/Rect:<init>	()V
    //   2646: astore 31
    //   2648: new 470	android/graphics/Rect
    //   2651: dup
    //   2652: invokespecial 471	android/graphics/Rect:<init>	()V
    //   2655: astore 36
    //   2657: aload 32
    //   2659: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   2662: getfield 1250	com/tencent/mm/protocal/protobuf/ahj:Zqq	Lcom/tencent/mm/protocal/protobuf/enx;
    //   2665: aload 31
    //   2667: invokestatic 486	com/tencent/mm/plugin/vlog/model/h:a	(Lcom/tencent/mm/protocal/protobuf/enx;Landroid/graphics/Rect;)V
    //   2670: aload 32
    //   2672: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   2675: getfield 1323	com/tencent/mm/protocal/protobuf/ahj:Zqt	Lcom/tencent/mm/protocal/protobuf/enx;
    //   2678: aload 36
    //   2680: invokestatic 486	com/tencent/mm/plugin/vlog/model/h:a	(Lcom/tencent/mm/protocal/protobuf/enx;Landroid/graphics/Rect;)V
    //   2683: aload 36
    //   2685: aload 31
    //   2687: invokevirtual 1327	android/graphics/Rect:contains	(Landroid/graphics/Rect;)Z
    //   2690: istore 24
    //   2692: aload_0
    //   2693: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   2696: new 239	java/lang/StringBuilder
    //   2699: dup
    //   2700: ldc_w 1329
    //   2703: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2706: aload 31
    //   2708: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2711: ldc_w 1331
    //   2714: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2717: aload 36
    //   2719: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2722: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2725: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2728: iload 20
    //   2730: ifne +8 -> 2738
    //   2733: iload 21
    //   2735: ifeq +959 -> 3694
    //   2738: iload 10
    //   2740: iconst_1
    //   2741: if_icmpeq +670 -> 3411
    //   2744: aload_0
    //   2745: lload 29
    //   2747: aload 34
    //   2749: aload 40
    //   2751: aload 42
    //   2753: aload 41
    //   2755: iload 20
    //   2757: iload 11
    //   2759: aload 37
    //   2761: invokeinterface 1040 1 0
    //   2766: invokespecial 1333	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:b	(JLcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/protocal/protobuf/dji;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;ZII)Lkotlin/r;
    //   2769: getfield 1337	kotlin/r:bsC	Ljava/lang/Object;
    //   2772: checkcast 1022	java/lang/Number
    //   2775: invokevirtual 1025	java/lang/Number:intValue	()I
    //   2778: ifge +456 -> 3234
    //   2781: getstatic 1343	com/tencent/mm/plugin/vlog/report/c:UeI	Lcom/tencent/mm/plugin/vlog/report/c;
    //   2784: astore 31
    //   2786: aload 35
    //   2788: invokestatic 1346	com/tencent/mm/plugin/vlog/report/c:aZm	(Ljava/lang/String;)V
    //   2791: aload_0
    //   2792: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   2795: astore 31
    //   2797: getstatic 1031	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:Gfb	Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/g$a;
    //   2800: astore 32
    //   2802: new 1027	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g
    //   2805: dup
    //   2806: aload 31
    //   2808: invokestatic 1034	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:fev	()I
    //   2811: invokespecial 1037	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:<init>	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;I)V
    //   2814: checkcast 1039	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   2817: astore 31
    //   2819: ldc_w 937
    //   2822: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2825: aload 31
    //   2827: areturn
    //   2828: aload 31
    //   2830: checkcast 950	java/util/List
    //   2833: invokestatic 1350	kotlin/a/p:oL	(Ljava/util/List;)Ljava/lang/Object;
    //   2836: checkcast 553	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo
    //   2839: astore 31
    //   2841: goto -1568 -> 1273
    //   2844: goto -1526 -> 1318
    //   2847: ldc 160
    //   2849: astore 31
    //   2851: goto -1465 -> 1386
    //   2854: ldc_w 1149
    //   2857: invokestatic 1155	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   2860: checkcast 1149	com/tencent/mm/plugin/expt/b/c
    //   2863: getstatic 1353	com/tencent/mm/plugin/expt/b/c$a:zaT	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   2866: iconst_0
    //   2867: invokeinterface 1164 3 0
    //   2872: istore 10
    //   2874: goto -1441 -> 1433
    //   2877: aload 31
    //   2879: getfield 1095	com/tencent/mm/protocal/protobuf/afb:Zng	Ljava/util/LinkedList;
    //   2882: astore 31
    //   2884: aload 31
    //   2886: ifnonnull +9 -> 2895
    //   2889: aconst_null
    //   2890: astore 31
    //   2892: goto -1424 -> 1468
    //   2895: aload 31
    //   2897: checkcast 950	java/util/List
    //   2900: invokestatic 1350	kotlin/a/p:oL	(Ljava/util/List;)Ljava/lang/Object;
    //   2903: checkcast 1097	com/tencent/mm/protocal/protobuf/fos
    //   2906: astore 31
    //   2908: goto -1440 -> 1468
    //   2911: iconst_0
    //   2912: istore 8
    //   2914: goto -1410 -> 1504
    //   2917: aload 32
    //   2919: getfield 706	com/tencent/mm/protocal/protobuf/afb:TYC	Lcom/tencent/mm/protocal/protobuf/afa;
    //   2922: astore 32
    //   2924: aload 32
    //   2926: ifnonnull +9 -> 2935
    //   2929: iconst_0
    //   2930: istore 8
    //   2932: goto -1408 -> 1524
    //   2935: aload 32
    //   2937: getfield 712	com/tencent/mm/protocal/protobuf/afa:Znd	Ljava/util/LinkedList;
    //   2940: astore 32
    //   2942: aload 32
    //   2944: ifnonnull +9 -> 2953
    //   2947: iconst_0
    //   2948: istore 8
    //   2950: goto -1426 -> 1524
    //   2953: aload 32
    //   2955: invokevirtual 716	java/util/LinkedList:size	()I
    //   2958: istore 8
    //   2960: goto -1436 -> 1524
    //   2963: iconst_0
    //   2964: istore 8
    //   2966: goto -1414 -> 1552
    //   2969: aload 32
    //   2971: getfield 1357	com/tencent/mm/protocal/protobuf/afb:Znl	Lcom/tencent/mm/protocal/protobuf/fxt;
    //   2974: astore 32
    //   2976: goto -1404 -> 1572
    //   2979: aload 32
    //   2981: getfield 1360	com/tencent/mm/protocal/protobuf/fqf:path	Ljava/lang/String;
    //   2984: astore 32
    //   2986: goto -1381 -> 1605
    //   2989: iconst_0
    //   2990: istore 8
    //   2992: goto -1362 -> 1630
    //   2995: iconst_0
    //   2996: istore 19
    //   2998: goto -1334 -> 1664
    //   3001: aload 31
    //   3003: getfield 1095	com/tencent/mm/protocal/protobuf/afb:Zng	Ljava/util/LinkedList;
    //   3006: astore 31
    //   3008: aload 31
    //   3010: ifnonnull +9 -> 3019
    //   3013: aconst_null
    //   3014: astore 31
    //   3016: goto -1297 -> 1719
    //   3019: aload 31
    //   3021: invokevirtual 716	java/util/LinkedList:size	()I
    //   3024: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3027: astore 31
    //   3029: goto -1310 -> 1719
    //   3032: aload 31
    //   3034: getfield 706	com/tencent/mm/protocal/protobuf/afb:TYC	Lcom/tencent/mm/protocal/protobuf/afa;
    //   3037: astore 31
    //   3039: aload 31
    //   3041: ifnonnull +9 -> 3050
    //   3044: aconst_null
    //   3045: astore 31
    //   3047: goto -1298 -> 1749
    //   3050: aload 31
    //   3052: getfield 712	com/tencent/mm/protocal/protobuf/afa:Znd	Ljava/util/LinkedList;
    //   3055: astore 31
    //   3057: aload 31
    //   3059: ifnonnull +9 -> 3068
    //   3062: aconst_null
    //   3063: astore 31
    //   3065: goto -1316 -> 1749
    //   3068: aload 31
    //   3070: invokevirtual 716	java/util/LinkedList:size	()I
    //   3073: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3076: astore 31
    //   3078: goto -1329 -> 1749
    //   3081: aload 31
    //   3083: getfield 1363	com/tencent/mm/protocal/protobuf/afb:Uax	Z
    //   3086: istore 23
    //   3088: goto -1246 -> 1842
    //   3091: aload 31
    //   3093: getfield 1095	com/tencent/mm/protocal/protobuf/afb:Zng	Ljava/util/LinkedList;
    //   3096: astore 31
    //   3098: aload 31
    //   3100: ifnonnull +9 -> 3109
    //   3103: aconst_null
    //   3104: astore 31
    //   3106: goto -1238 -> 1868
    //   3109: aload 31
    //   3111: iconst_0
    //   3112: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   3115: checkcast 1097	com/tencent/mm/protocal/protobuf/fos
    //   3118: astore 31
    //   3120: goto -1252 -> 1868
    //   3123: goto -1241 -> 1882
    //   3126: aload 32
    //   3128: getfield 641	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   3131: istore 8
    //   3133: goto -1193 -> 1940
    //   3136: aload 32
    //   3138: getfield 643	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   3141: istore 8
    //   3143: goto -1171 -> 1972
    //   3146: iconst_0
    //   3147: istore 24
    //   3149: goto -1012 -> 2137
    //   3152: aload 32
    //   3154: getfield 1370	com/tencent/mm/protocal/protobuf/afb:nBT	Ljava/lang/String;
    //   3157: astore 32
    //   3159: goto -1007 -> 2152
    //   3162: iconst_0
    //   3163: istore 24
    //   3165: goto -565 -> 2600
    //   3168: getstatic 297	com/tencent/mm/plugin/finder/report/ah$c:Ftv	Lcom/tencent/mm/plugin/finder/report/ah$c;
    //   3171: astore 31
    //   3173: iload 20
    //   3175: ifne +8 -> 3183
    //   3178: iload 21
    //   3180: ifeq +16 -> 3196
    //   3183: iconst_1
    //   3184: istore 24
    //   3186: iload 24
    //   3188: invokestatic 1373	com/tencent/mm/plugin/finder/report/ah$c:tA	(Z)V
    //   3191: fconst_0
    //   3192: fstore_3
    //   3193: goto -585 -> 2608
    //   3196: iconst_0
    //   3197: istore 24
    //   3199: goto -13 -> 3186
    //   3202: aload 31
    //   3204: getfield 1095	com/tencent/mm/protocal/protobuf/afb:Zng	Ljava/util/LinkedList;
    //   3207: astore 31
    //   3209: aload 31
    //   3211: ifnonnull +9 -> 3220
    //   3214: aconst_null
    //   3215: astore 32
    //   3217: goto -588 -> 2629
    //   3220: aload 31
    //   3222: iconst_0
    //   3223: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   3226: checkcast 1097	com/tencent/mm/protocal/protobuf/fos
    //   3229: astore 32
    //   3231: goto -602 -> 2629
    //   3234: getstatic 619	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:ObB	Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker;
    //   3237: aload 42
    //   3239: invokevirtual 623	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:aTG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a;
    //   3242: astore 36
    //   3244: aload 36
    //   3246: ifnull +29 -> 3275
    //   3249: aload 36
    //   3251: getfield 641	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   3254: ifle +21 -> 3275
    //   3257: aload 36
    //   3259: getfield 643	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   3262: ifle +13 -> 3275
    //   3265: aload 36
    //   3267: getfield 629	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:duration	J
    //   3270: lconst_0
    //   3271: lcmp
    //   3272: ifgt +4606 -> 7878
    //   3275: aload_0
    //   3276: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   3279: astore 32
    //   3281: new 239	java/lang/StringBuilder
    //   3284: dup
    //   3285: ldc_w 1375
    //   3288: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3291: astore 33
    //   3293: aload 36
    //   3295: ifnonnull +90 -> 3385
    //   3298: aconst_null
    //   3299: astore 31
    //   3301: aload 33
    //   3303: aload 31
    //   3305: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3308: bipush 32
    //   3310: invokevirtual 1265	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3313: astore 33
    //   3315: aload 36
    //   3317: ifnonnull +81 -> 3398
    //   3320: aconst_null
    //   3321: astore 31
    //   3323: aload 32
    //   3325: aload 33
    //   3327: aload 31
    //   3329: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3332: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3335: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3338: getstatic 1343	com/tencent/mm/plugin/vlog/report/c:UeI	Lcom/tencent/mm/plugin/vlog/report/c;
    //   3341: astore 31
    //   3343: aload 35
    //   3345: invokestatic 1346	com/tencent/mm/plugin/vlog/report/c:aZm	(Ljava/lang/String;)V
    //   3348: aload_0
    //   3349: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   3352: astore 31
    //   3354: getstatic 1031	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:Gfb	Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/g$a;
    //   3357: astore 32
    //   3359: new 1027	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g
    //   3362: dup
    //   3363: aload 31
    //   3365: invokestatic 1034	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:fev	()I
    //   3368: invokespecial 1037	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:<init>	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;I)V
    //   3371: checkcast 1039	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   3374: astore 31
    //   3376: ldc_w 937
    //   3379: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3382: aload 31
    //   3384: areturn
    //   3385: aload 36
    //   3387: getfield 641	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   3390: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3393: astore 31
    //   3395: goto -94 -> 3301
    //   3398: aload 36
    //   3400: getfield 643	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   3403: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3406: astore 31
    //   3408: goto -85 -> 3323
    //   3411: iconst_1
    //   3412: istore 19
    //   3414: iload 12
    //   3416: istore 10
    //   3418: iload 19
    //   3420: ifeq +3772 -> 7192
    //   3423: aload 41
    //   3425: getfield 775	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:origin	Lcom/tencent/mm/protocal/protobuf/FinderMediaReportInfo;
    //   3428: astore 31
    //   3430: aload 31
    //   3432: ifnull +17 -> 3449
    //   3435: aload 31
    //   3437: aload 40
    //   3439: getfield 159	com/tencent/mm/protocal/protobuf/dji:url	Ljava/lang/String;
    //   3442: invokestatic 548	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   3445: l2i
    //   3446: putfield 561	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:fileSize	I
    //   3449: getstatic 619	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:ObB	Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker;
    //   3452: astore 43
    //   3454: aload 40
    //   3456: getfield 159	com/tencent/mm/protocal/protobuf/dji:url	Ljava/lang/String;
    //   3459: astore 36
    //   3461: aload 36
    //   3463: astore 31
    //   3465: aload 36
    //   3467: ifnonnull +7 -> 3474
    //   3470: ldc 160
    //   3472: astore 31
    //   3474: aload 43
    //   3476: aload 31
    //   3478: invokevirtual 623	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:aTG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a;
    //   3481: astore 31
    //   3483: iconst_0
    //   3484: istore 12
    //   3486: iconst_0
    //   3487: istore 13
    //   3489: aload 31
    //   3491: ifnull +161 -> 3652
    //   3494: aload 41
    //   3496: getfield 775	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:origin	Lcom/tencent/mm/protocal/protobuf/FinderMediaReportInfo;
    //   3499: astore 36
    //   3501: aload 36
    //   3503: ifnull +14 -> 3517
    //   3506: aload 36
    //   3508: aload 31
    //   3510: getfield 629	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:duration	J
    //   3513: l2i
    //   3514: putfield 640	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:videoDuration	I
    //   3517: aload 41
    //   3519: getfield 775	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:origin	Lcom/tencent/mm/protocal/protobuf/FinderMediaReportInfo;
    //   3522: astore 36
    //   3524: aload 36
    //   3526: ifnull +13 -> 3539
    //   3529: aload 36
    //   3531: aload 31
    //   3533: getfield 641	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   3536: putfield 642	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:width	I
    //   3539: aload 41
    //   3541: getfield 775	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:origin	Lcom/tencent/mm/protocal/protobuf/FinderMediaReportInfo;
    //   3544: astore 36
    //   3546: aload 36
    //   3548: ifnull +13 -> 3561
    //   3551: aload 36
    //   3553: aload 31
    //   3555: getfield 643	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   3558: putfield 644	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:height	I
    //   3561: aload 41
    //   3563: getfield 775	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:origin	Lcom/tencent/mm/protocal/protobuf/FinderMediaReportInfo;
    //   3566: astore 36
    //   3568: aload 36
    //   3570: ifnull +13 -> 3583
    //   3573: aload 36
    //   3575: aload 31
    //   3577: getfield 646	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:bitrate	I
    //   3580: putfield 649	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:videoBitrate	I
    //   3583: aload 41
    //   3585: getfield 775	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:origin	Lcom/tencent/mm/protocal/protobuf/FinderMediaReportInfo;
    //   3588: astore 36
    //   3590: aload 36
    //   3592: ifnull +13 -> 3605
    //   3595: aload 36
    //   3597: aload 31
    //   3599: getfield 650	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:audioBitrate	I
    //   3602: putfield 651	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:audioBitrate	I
    //   3605: aload 41
    //   3607: getfield 775	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:origin	Lcom/tencent/mm/protocal/protobuf/FinderMediaReportInfo;
    //   3610: astore 36
    //   3612: aload 36
    //   3614: ifnull +14 -> 3628
    //   3617: aload 36
    //   3619: aload 31
    //   3621: getfield 654	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:eGw	F
    //   3624: f2i
    //   3625: putfield 655	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:fps	I
    //   3628: aload 31
    //   3630: getfield 641	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   3633: istore 12
    //   3635: aload 31
    //   3637: getfield 643	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   3640: istore 13
    //   3642: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   3645: astore 36
    //   3647: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   3650: astore 36
    //   3652: aload 31
    //   3654: ifnonnull +1803 -> 5457
    //   3657: aload_0
    //   3658: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   3661: astore 31
    //   3663: getstatic 1031	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:Gfb	Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/g$a;
    //   3666: astore 32
    //   3668: new 1027	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g
    //   3671: dup
    //   3672: aload 31
    //   3674: invokestatic 1034	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:fev	()I
    //   3677: invokespecial 1037	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:<init>	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;I)V
    //   3680: checkcast 1039	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   3683: astore 31
    //   3685: ldc_w 937
    //   3688: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3691: aload 31
    //   3693: areturn
    //   3694: iload 10
    //   3696: iconst_1
    //   3697: if_icmpne +4170 -> 7867
    //   3700: iload 19
    //   3702: ifeq +4165 -> 7867
    //   3705: iload 24
    //   3707: ifeq +4160 -> 7867
    //   3710: aload 32
    //   3712: ifnull +4155 -> 7867
    //   3715: aload_0
    //   3716: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   3719: ldc_w 1377
    //   3722: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3725: aload 40
    //   3727: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   3730: astore 36
    //   3732: aload 40
    //   3734: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   3737: astore 33
    //   3739: aload 36
    //   3741: ifnonnull +1070 -> 4811
    //   3744: aconst_null
    //   3745: astore 31
    //   3747: aload 31
    //   3749: ifnull +719 -> 4468
    //   3752: aload 31
    //   3754: getfield 1099	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   3757: invokestatic 1381	com/tencent/mm/plugin/sight/base/SightVideoJNI:getMp4RotateVFS	(Ljava/lang/String;)I
    //   3760: istore 12
    //   3762: aload 33
    //   3764: ifnull +25 -> 3789
    //   3767: aload 36
    //   3769: ifnonnull +1074 -> 4843
    //   3772: lconst_0
    //   3773: lstore 27
    //   3775: aload 33
    //   3777: lload 27
    //   3779: aload 31
    //   3781: getfield 1188	com/tencent/mm/protocal/protobuf/fos:TDw	J
    //   3784: ladd
    //   3785: l2i
    //   3786: putfield 282	com/tencent/mm/protocal/protobuf/dju:startTime	I
    //   3789: aload 33
    //   3791: ifnull +25 -> 3816
    //   3794: aload 36
    //   3796: ifnonnull +1057 -> 4853
    //   3799: lconst_0
    //   3800: lstore 27
    //   3802: aload 33
    //   3804: lload 27
    //   3806: aload 31
    //   3808: getfield 1188	com/tencent/mm/protocal/protobuf/fos:TDw	J
    //   3811: ladd
    //   3812: l2i
    //   3813: putfield 285	com/tencent/mm/protocal/protobuf/dju:endTime	I
    //   3816: aload 31
    //   3818: getfield 1290	com/tencent/mm/protocal/protobuf/fos:UaC	I
    //   3821: i2f
    //   3822: fstore 4
    //   3824: aload 31
    //   3826: getfield 1384	com/tencent/mm/protocal/protobuf/fos:UaE	F
    //   3829: fstore 7
    //   3831: aload 31
    //   3833: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   3836: getfield 1253	com/tencent/mm/protocal/protobuf/ahj:Zqs	Lcom/tencent/mm/protocal/protobuf/enx;
    //   3839: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   3842: iconst_2
    //   3843: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   3846: checkcast 1022	java/lang/Number
    //   3849: invokevirtual 1025	java/lang/Number:intValue	()I
    //   3852: istore 8
    //   3854: aload 31
    //   3856: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   3859: getfield 1253	com/tencent/mm/protocal/protobuf/ahj:Zqs	Lcom/tencent/mm/protocal/protobuf/enx;
    //   3862: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   3865: iconst_0
    //   3866: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   3869: astore 43
    //   3871: aload 43
    //   3873: ldc_w 1391
    //   3876: invokestatic 1103	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   3879: fconst_1
    //   3880: fload 4
    //   3882: fload 7
    //   3884: fmul
    //   3885: fmul
    //   3886: iload 8
    //   3888: aload 43
    //   3890: checkcast 1022	java/lang/Number
    //   3893: invokevirtual 1025	java/lang/Number:intValue	()I
    //   3896: isub
    //   3897: i2f
    //   3898: fdiv
    //   3899: fstore 4
    //   3901: new 172	com/tencent/mm/protocal/protobuf/fyb
    //   3904: dup
    //   3905: invokespecial 173	com/tencent/mm/protocal/protobuf/fyb:<init>	()V
    //   3908: astore 43
    //   3910: aload 31
    //   3912: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   3915: getfield 1250	com/tencent/mm/protocal/protobuf/ahj:Zqq	Lcom/tencent/mm/protocal/protobuf/enx;
    //   3918: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   3921: iconst_0
    //   3922: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   3925: checkcast 1022	java/lang/Number
    //   3928: invokevirtual 1025	java/lang/Number:intValue	()I
    //   3931: istore 8
    //   3933: aload 31
    //   3935: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   3938: getfield 1253	com/tencent/mm/protocal/protobuf/ahj:Zqs	Lcom/tencent/mm/protocal/protobuf/enx;
    //   3941: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   3944: iconst_0
    //   3945: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   3948: astore 44
    //   3950: aload 44
    //   3952: ldc_w 1391
    //   3955: invokestatic 1103	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   3958: aload 43
    //   3960: iload 8
    //   3962: aload 44
    //   3964: checkcast 1022	java/lang/Number
    //   3967: invokevirtual 1025	java/lang/Number:intValue	()I
    //   3970: isub
    //   3971: i2f
    //   3972: fload 4
    //   3974: fmul
    //   3975: f2i
    //   3976: putfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   3979: aload 31
    //   3981: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   3984: getfield 1250	com/tencent/mm/protocal/protobuf/ahj:Zqq	Lcom/tencent/mm/protocal/protobuf/enx;
    //   3987: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   3990: iconst_1
    //   3991: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   3994: checkcast 1022	java/lang/Number
    //   3997: invokevirtual 1025	java/lang/Number:intValue	()I
    //   4000: istore 8
    //   4002: aload 31
    //   4004: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   4007: getfield 1253	com/tencent/mm/protocal/protobuf/ahj:Zqs	Lcom/tencent/mm/protocal/protobuf/enx;
    //   4010: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   4013: iconst_1
    //   4014: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   4017: astore 44
    //   4019: aload 44
    //   4021: ldc_w 1393
    //   4024: invokestatic 1103	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   4027: aload 43
    //   4029: iload 8
    //   4031: aload 44
    //   4033: checkcast 1022	java/lang/Number
    //   4036: invokevirtual 1025	java/lang/Number:intValue	()I
    //   4039: isub
    //   4040: i2f
    //   4041: fload 4
    //   4043: fmul
    //   4044: f2i
    //   4045: putfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   4048: aload 31
    //   4050: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   4053: getfield 1250	com/tencent/mm/protocal/protobuf/ahj:Zqq	Lcom/tencent/mm/protocal/protobuf/enx;
    //   4056: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   4059: iconst_2
    //   4060: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   4063: checkcast 1022	java/lang/Number
    //   4066: invokevirtual 1025	java/lang/Number:intValue	()I
    //   4069: istore 8
    //   4071: aload 31
    //   4073: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   4076: getfield 1253	com/tencent/mm/protocal/protobuf/ahj:Zqs	Lcom/tencent/mm/protocal/protobuf/enx;
    //   4079: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   4082: iconst_0
    //   4083: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   4086: astore 44
    //   4088: aload 44
    //   4090: ldc_w 1391
    //   4093: invokestatic 1103	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   4096: aload 43
    //   4098: iload 8
    //   4100: aload 44
    //   4102: checkcast 1022	java/lang/Number
    //   4105: invokevirtual 1025	java/lang/Number:intValue	()I
    //   4108: isub
    //   4109: i2f
    //   4110: fload 4
    //   4112: fmul
    //   4113: f2i
    //   4114: putfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   4117: aload 31
    //   4119: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   4122: getfield 1250	com/tencent/mm/protocal/protobuf/ahj:Zqq	Lcom/tencent/mm/protocal/protobuf/enx;
    //   4125: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   4128: iconst_3
    //   4129: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   4132: checkcast 1022	java/lang/Number
    //   4135: invokevirtual 1025	java/lang/Number:intValue	()I
    //   4138: istore 8
    //   4140: aload 31
    //   4142: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   4145: getfield 1253	com/tencent/mm/protocal/protobuf/ahj:Zqs	Lcom/tencent/mm/protocal/protobuf/enx;
    //   4148: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   4151: iconst_1
    //   4152: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   4155: astore 44
    //   4157: aload 44
    //   4159: ldc_w 1393
    //   4162: invokestatic 1103	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   4165: aload 43
    //   4167: iload 8
    //   4169: aload 44
    //   4171: checkcast 1022	java/lang/Number
    //   4174: invokevirtual 1025	java/lang/Number:intValue	()I
    //   4177: isub
    //   4178: i2f
    //   4179: fload 4
    //   4181: fmul
    //   4182: f2i
    //   4183: putfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   4186: aload 33
    //   4188: ifnull +10 -> 4198
    //   4191: aload 33
    //   4193: aload 43
    //   4195: putfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   4198: aload 31
    //   4200: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   4203: getfield 1253	com/tencent/mm/protocal/protobuf/ahj:Zqs	Lcom/tencent/mm/protocal/protobuf/enx;
    //   4206: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   4209: iconst_2
    //   4210: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   4213: checkcast 1022	java/lang/Number
    //   4216: invokevirtual 1025	java/lang/Number:intValue	()I
    //   4219: istore 8
    //   4221: aload 31
    //   4223: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   4226: getfield 1253	com/tencent/mm/protocal/protobuf/ahj:Zqs	Lcom/tencent/mm/protocal/protobuf/enx;
    //   4229: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   4232: iconst_0
    //   4233: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   4236: astore 44
    //   4238: aload 44
    //   4240: ldc_w 1391
    //   4243: invokestatic 1103	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   4246: iload 8
    //   4248: aload 44
    //   4250: checkcast 1022	java/lang/Number
    //   4253: invokevirtual 1025	java/lang/Number:intValue	()I
    //   4256: isub
    //   4257: i2f
    //   4258: fload 4
    //   4260: fmul
    //   4261: f2i
    //   4262: istore 13
    //   4264: aload 31
    //   4266: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   4269: getfield 1253	com/tencent/mm/protocal/protobuf/ahj:Zqs	Lcom/tencent/mm/protocal/protobuf/enx;
    //   4272: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   4275: iconst_3
    //   4276: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   4279: checkcast 1022	java/lang/Number
    //   4282: invokevirtual 1025	java/lang/Number:intValue	()I
    //   4285: istore 8
    //   4287: aload 31
    //   4289: getfield 1247	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   4292: getfield 1253	com/tencent/mm/protocal/protobuf/ahj:Zqs	Lcom/tencent/mm/protocal/protobuf/enx;
    //   4295: getfield 1389	com/tencent/mm/protocal/protobuf/enx:aaTg	Ljava/util/LinkedList;
    //   4298: iconst_1
    //   4299: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   4302: astore 31
    //   4304: aload 31
    //   4306: ldc_w 1393
    //   4309: invokestatic 1103	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   4312: iload 8
    //   4314: aload 31
    //   4316: checkcast 1022	java/lang/Number
    //   4319: invokevirtual 1025	java/lang/Number:intValue	()I
    //   4322: isub
    //   4323: i2f
    //   4324: fload 4
    //   4326: fmul
    //   4327: f2i
    //   4328: istore 14
    //   4330: aload 33
    //   4332: ifnonnull +531 -> 4863
    //   4335: iconst_0
    //   4336: istore 8
    //   4338: aload 33
    //   4340: ifnonnull +551 -> 4891
    //   4343: iconst_0
    //   4344: istore 10
    //   4346: iload 8
    //   4348: iload 10
    //   4350: isub
    //   4351: i2f
    //   4352: fstore 4
    //   4354: aload 36
    //   4356: ifnonnull +563 -> 4919
    //   4359: iconst_1
    //   4360: istore 8
    //   4362: fconst_1
    //   4363: fload 4
    //   4365: fmul
    //   4366: iload 8
    //   4368: i2f
    //   4369: fdiv
    //   4370: fstore 4
    //   4372: fload 4
    //   4374: fconst_1
    //   4375: fcmpl
    //   4376: ifle +3488 -> 7864
    //   4379: fconst_1
    //   4380: fstore 4
    //   4382: aload 33
    //   4384: ifnull +23 -> 4407
    //   4387: aload 36
    //   4389: ifnonnull +558 -> 4947
    //   4392: iconst_0
    //   4393: istore 8
    //   4395: aload 33
    //   4397: iload 8
    //   4399: i2f
    //   4400: fload 4
    //   4402: fmul
    //   4403: f2i
    //   4404: putfield 780	com/tencent/mm/protocal/protobuf/dju:width	I
    //   4407: aload 33
    //   4409: ifnull +23 -> 4432
    //   4412: aload 36
    //   4414: ifnonnull +561 -> 4975
    //   4417: iconst_0
    //   4418: istore 8
    //   4420: aload 33
    //   4422: iload 8
    //   4424: i2f
    //   4425: fload 4
    //   4427: fmul
    //   4428: f2i
    //   4429: putfield 781	com/tencent/mm/protocal/protobuf/dju:height	I
    //   4432: iload 12
    //   4434: lookupswitch	default:+34->4468, 90:+569->5003, 180:+633->5067, 270:+709->5143
    //   4469: dload_2
    //   4470: aload 32
    //   4472: getfield 1099	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   4475: putfield 159	com/tencent/mm/protocal/protobuf/dji:url	Ljava/lang/String;
    //   4478: aload 40
    //   4480: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   4483: astore 31
    //   4485: aload 31
    //   4487: ifnonnull +732 -> 5219
    //   4490: ldc 160
    //   4492: astore 31
    //   4494: aload 40
    //   4496: getfield 311	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   4499: astore 33
    //   4501: aload 33
    //   4503: ifnonnull +739 -> 5242
    //   4506: iconst_0
    //   4507: istore 19
    //   4509: aload 31
    //   4511: invokestatic 1239	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   4514: ifne +738 -> 5252
    //   4517: iconst_1
    //   4518: istore 8
    //   4520: iload 19
    //   4522: ifeq +742 -> 5264
    //   4525: iload 8
    //   4527: ifeq +731 -> 5258
    //   4530: iconst_3
    //   4531: istore 8
    //   4533: aload_0
    //   4534: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   4537: astore 36
    //   4539: new 239	java/lang/StringBuilder
    //   4542: dup
    //   4543: ldc_w 1395
    //   4546: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4549: astore 43
    //   4551: aload 40
    //   4553: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   4556: astore 33
    //   4558: aload 33
    //   4560: ifnonnull +721 -> 5281
    //   4563: aconst_null
    //   4564: astore 33
    //   4566: aload 43
    //   4568: aload 33
    //   4570: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4573: ldc 248
    //   4575: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4578: astore 43
    //   4580: aload 40
    //   4582: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   4585: astore 33
    //   4587: aload 33
    //   4589: ifnonnull +705 -> 5294
    //   4592: aconst_null
    //   4593: astore 33
    //   4595: aload 43
    //   4597: aload 33
    //   4599: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4602: ldc_w 1397
    //   4605: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4608: astore 43
    //   4610: aload 40
    //   4612: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   4615: astore 33
    //   4617: aload 33
    //   4619: ifnonnull +688 -> 5307
    //   4622: aconst_null
    //   4623: astore 33
    //   4625: aload 43
    //   4627: aload 33
    //   4629: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4632: ldc 248
    //   4634: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4637: astore 43
    //   4639: aload 40
    //   4641: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   4644: astore 33
    //   4646: aload 33
    //   4648: ifnonnull +672 -> 5320
    //   4651: aconst_null
    //   4652: astore 33
    //   4654: aload 43
    //   4656: aload 33
    //   4658: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4661: ldc_w 1399
    //   4664: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4667: astore 43
    //   4669: aload 40
    //   4671: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   4674: astore 33
    //   4676: aload 33
    //   4678: ifnonnull +655 -> 5333
    //   4681: aconst_null
    //   4682: astore 33
    //   4684: aload 43
    //   4686: aload 33
    //   4688: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4691: ldc 248
    //   4693: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4696: astore 43
    //   4698: aload 40
    //   4700: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   4703: astore 33
    //   4705: aload 33
    //   4707: ifnonnull +657 -> 5364
    //   4710: aconst_null
    //   4711: astore 33
    //   4713: aload 43
    //   4715: aload 33
    //   4717: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4720: ldc 248
    //   4722: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4725: astore 43
    //   4727: aload 40
    //   4729: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   4732: astore 33
    //   4734: aload 33
    //   4736: ifnonnull +659 -> 5395
    //   4739: aconst_null
    //   4740: astore 33
    //   4742: aload 43
    //   4744: aload 33
    //   4746: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4749: ldc 248
    //   4751: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4754: astore 43
    //   4756: aload 40
    //   4758: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   4761: astore 33
    //   4763: aload 33
    //   4765: ifnonnull +661 -> 5426
    //   4768: aconst_null
    //   4769: astore 33
    //   4771: aload 36
    //   4773: aload 43
    //   4775: aload 33
    //   4777: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4780: ldc_w 1401
    //   4783: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4786: iload 8
    //   4788: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4791: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4794: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4797: iconst_1
    //   4798: istore 19
    //   4800: aload 31
    //   4802: astore 33
    //   4804: iload 8
    //   4806: istore 10
    //   4808: goto -1390 -> 3418
    //   4811: aload 36
    //   4813: getfield 1095	com/tencent/mm/protocal/protobuf/afb:Zng	Ljava/util/LinkedList;
    //   4816: astore 31
    //   4818: aload 31
    //   4820: ifnonnull +9 -> 4829
    //   4823: aconst_null
    //   4824: astore 31
    //   4826: goto -1079 -> 3747
    //   4829: aload 31
    //   4831: iconst_0
    //   4832: invokevirtual 1367	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   4835: checkcast 1097	com/tencent/mm/protocal/protobuf/fos
    //   4838: astore 31
    //   4840: goto -1093 -> 3747
    //   4843: aload 36
    //   4845: getfield 1404	com/tencent/mm/protocal/protobuf/afb:Znh	J
    //   4848: lstore 27
    //   4850: goto -1075 -> 3775
    //   4853: aload 36
    //   4855: getfield 1407	com/tencent/mm/protocal/protobuf/afb:Zni	J
    //   4858: lstore 27
    //   4860: goto -1058 -> 3802
    //   4863: aload 33
    //   4865: getfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   4868: astore 31
    //   4870: aload 31
    //   4872: ifnonnull +9 -> 4881
    //   4875: iconst_0
    //   4876: istore 8
    //   4878: goto -540 -> 4338
    //   4881: aload 31
    //   4883: getfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   4886: istore 8
    //   4888: goto -550 -> 4338
    //   4891: aload 33
    //   4893: getfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   4896: astore 31
    //   4898: aload 31
    //   4900: ifnonnull +9 -> 4909
    //   4903: iconst_0
    //   4904: istore 10
    //   4906: goto -560 -> 4346
    //   4909: aload 31
    //   4911: getfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   4914: istore 10
    //   4916: goto -570 -> 4346
    //   4919: aload 36
    //   4921: getfield 318	com/tencent/mm/protocal/protobuf/afb:TYB	Lcom/tencent/mm/protocal/protobuf/afc;
    //   4924: astore 31
    //   4926: aload 31
    //   4928: ifnonnull +9 -> 4937
    //   4931: iconst_1
    //   4932: istore 8
    //   4934: goto -572 -> 4362
    //   4937: aload 31
    //   4939: getfield 1410	com/tencent/mm/protocal/protobuf/afc:nxO	I
    //   4942: istore 8
    //   4944: goto -582 -> 4362
    //   4947: aload 36
    //   4949: getfield 318	com/tencent/mm/protocal/protobuf/afb:TYB	Lcom/tencent/mm/protocal/protobuf/afc;
    //   4952: astore 31
    //   4954: aload 31
    //   4956: ifnonnull +9 -> 4965
    //   4959: iconst_0
    //   4960: istore 8
    //   4962: goto -567 -> 4395
    //   4965: aload 31
    //   4967: getfield 1410	com/tencent/mm/protocal/protobuf/afc:nxO	I
    //   4970: istore 8
    //   4972: goto -577 -> 4395
    //   4975: aload 36
    //   4977: getfield 318	com/tencent/mm/protocal/protobuf/afb:TYB	Lcom/tencent/mm/protocal/protobuf/afc;
    //   4980: astore 31
    //   4982: aload 31
    //   4984: ifnonnull +9 -> 4993
    //   4987: iconst_0
    //   4988: istore 8
    //   4990: goto -570 -> 4420
    //   4993: aload 31
    //   4995: getfield 1413	com/tencent/mm/protocal/protobuf/afc:nxP	I
    //   4998: istore 8
    //   5000: goto -580 -> 4420
    //   5003: new 172	com/tencent/mm/protocal/protobuf/fyb
    //   5006: dup
    //   5007: invokespecial 173	com/tencent/mm/protocal/protobuf/fyb:<init>	()V
    //   5010: astore 31
    //   5012: aload 31
    //   5014: aload 43
    //   5016: getfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   5019: putfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   5022: aload 31
    //   5024: aload 43
    //   5026: getfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   5029: putfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   5032: aload 31
    //   5034: aload 43
    //   5036: getfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   5039: putfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   5042: aload 31
    //   5044: aload 43
    //   5046: getfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   5049: putfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   5052: aload 33
    //   5054: ifnull -586 -> 4468
    //   5057: aload 33
    //   5059: aload 31
    //   5061: putfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   5064: goto -596 -> 4468
    //   5067: new 172	com/tencent/mm/protocal/protobuf/fyb
    //   5070: dup
    //   5071: invokespecial 173	com/tencent/mm/protocal/protobuf/fyb:<init>	()V
    //   5074: astore 31
    //   5076: aload 31
    //   5078: iload 13
    //   5080: aload 43
    //   5082: getfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   5085: isub
    //   5086: putfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   5089: aload 31
    //   5091: iload 14
    //   5093: aload 43
    //   5095: getfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   5098: isub
    //   5099: putfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   5102: aload 31
    //   5104: iload 13
    //   5106: aload 43
    //   5108: getfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   5111: isub
    //   5112: putfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   5115: aload 31
    //   5117: iload 14
    //   5119: aload 43
    //   5121: getfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   5124: isub
    //   5125: putfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   5128: aload 33
    //   5130: ifnull -662 -> 4468
    //   5133: aload 33
    //   5135: aload 31
    //   5137: putfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   5140: goto -672 -> 4468
    //   5143: new 172	com/tencent/mm/protocal/protobuf/fyb
    //   5146: dup
    //   5147: invokespecial 173	com/tencent/mm/protocal/protobuf/fyb:<init>	()V
    //   5150: astore 31
    //   5152: aload 31
    //   5154: iload 14
    //   5156: aload 43
    //   5158: getfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   5161: isub
    //   5162: putfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   5165: aload 31
    //   5167: iload 13
    //   5169: aload 43
    //   5171: getfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   5174: isub
    //   5175: putfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   5178: aload 31
    //   5180: iload 14
    //   5182: aload 43
    //   5184: getfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   5187: isub
    //   5188: putfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   5191: aload 31
    //   5193: iload 13
    //   5195: aload 43
    //   5197: getfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   5200: isub
    //   5201: putfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   5204: aload 33
    //   5206: ifnull -738 -> 4468
    //   5209: aload 33
    //   5211: aload 31
    //   5213: putfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   5216: goto -748 -> 4468
    //   5219: aload 31
    //   5221: getfield 1370	com/tencent/mm/protocal/protobuf/afb:nBT	Ljava/lang/String;
    //   5224: astore 33
    //   5226: aload 33
    //   5228: astore 31
    //   5230: aload 33
    //   5232: ifnonnull -738 -> 4494
    //   5235: ldc 160
    //   5237: astore 31
    //   5239: goto -745 -> 4494
    //   5242: aload 33
    //   5244: getfield 1363	com/tencent/mm/protocal/protobuf/afb:Uax	Z
    //   5247: istore 19
    //   5249: goto -740 -> 4509
    //   5252: iconst_0
    //   5253: istore 8
    //   5255: goto -735 -> 4520
    //   5258: iconst_1
    //   5259: istore 8
    //   5261: goto -728 -> 4533
    //   5264: iload 8
    //   5266: ifeq +9 -> 5275
    //   5269: iconst_2
    //   5270: istore 8
    //   5272: goto -739 -> 4533
    //   5275: iconst_0
    //   5276: istore 8
    //   5278: goto -745 -> 4533
    //   5281: aload 33
    //   5283: getfield 282	com/tencent/mm/protocal/protobuf/dju:startTime	I
    //   5286: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5289: astore 33
    //   5291: goto -725 -> 4566
    //   5294: aload 33
    //   5296: getfield 285	com/tencent/mm/protocal/protobuf/dju:endTime	I
    //   5299: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5302: astore 33
    //   5304: goto -709 -> 4595
    //   5307: aload 33
    //   5309: getfield 780	com/tencent/mm/protocal/protobuf/dju:width	I
    //   5312: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5315: astore 33
    //   5317: goto -692 -> 4625
    //   5320: aload 33
    //   5322: getfield 781	com/tencent/mm/protocal/protobuf/dju:height	I
    //   5325: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5328: astore 33
    //   5330: goto -676 -> 4654
    //   5333: aload 33
    //   5335: getfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   5338: astore 33
    //   5340: aload 33
    //   5342: ifnonnull +9 -> 5351
    //   5345: aconst_null
    //   5346: astore 33
    //   5348: goto -664 -> 4684
    //   5351: aload 33
    //   5353: getfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   5356: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5359: astore 33
    //   5361: goto -677 -> 4684
    //   5364: aload 33
    //   5366: getfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   5369: astore 33
    //   5371: aload 33
    //   5373: ifnonnull +9 -> 5382
    //   5376: aconst_null
    //   5377: astore 33
    //   5379: goto -666 -> 4713
    //   5382: aload 33
    //   5384: getfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   5387: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5390: astore 33
    //   5392: goto -679 -> 4713
    //   5395: aload 33
    //   5397: getfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   5400: astore 33
    //   5402: aload 33
    //   5404: ifnonnull +9 -> 5413
    //   5407: aconst_null
    //   5408: astore 33
    //   5410: goto -668 -> 4742
    //   5413: aload 33
    //   5415: getfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   5418: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5421: astore 33
    //   5423: goto -681 -> 4742
    //   5426: aload 33
    //   5428: getfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   5431: astore 33
    //   5433: aload 33
    //   5435: ifnonnull +9 -> 5444
    //   5438: aconst_null
    //   5439: astore 33
    //   5441: goto -670 -> 4771
    //   5444: aload 33
    //   5446: getfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   5449: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5452: astore 33
    //   5454: goto -683 -> 4771
    //   5457: new 374	kotlin/g/b/ah$c
    //   5460: dup
    //   5461: invokespecial 375	kotlin/g/b/ah$c:<init>	()V
    //   5464: astore 36
    //   5466: aload 40
    //   5468: getfield 159	com/tencent/mm/protocal/protobuf/dji:url	Ljava/lang/String;
    //   5471: invokestatic 1381	com/tencent/mm/plugin/sight/base/SightVideoJNI:getMp4RotateVFS	(Ljava/lang/String;)I
    //   5474: istore 14
    //   5476: aload 40
    //   5478: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   5481: astore 31
    //   5483: aload 31
    //   5485: ifnonnull +676 -> 6161
    //   5488: iconst_0
    //   5489: istore 8
    //   5491: aload 40
    //   5493: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   5496: astore 31
    //   5498: aload 31
    //   5500: ifnonnull +671 -> 6171
    //   5503: iconst_0
    //   5504: istore 9
    //   5506: iload 14
    //   5508: lookupswitch	default:+28->5536, 90:+673->6181, 270:+673->6181
    //   5537: lload_2
    //   5538: ifnonnull +106 -> 5644
    //   5541: aload 40
    //   5543: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   5546: ifnull +98 -> 5644
    //   5549: aload 40
    //   5551: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   5554: astore 31
    //   5556: aload 31
    //   5558: invokestatic 1417	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   5561: aload 31
    //   5563: ldc_w 1419
    //   5566: invokestatic 1103	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   5569: aload 31
    //   5571: getfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   5574: astore 32
    //   5576: aload 32
    //   5578: ifnull +66 -> 5644
    //   5581: aload 32
    //   5583: getfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   5586: aload 32
    //   5588: getfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   5591: isub
    //   5592: istore 15
    //   5594: aload 32
    //   5596: getfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   5599: aload 32
    //   5601: getfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   5604: isub
    //   5605: istore 16
    //   5607: iload 14
    //   5609: lookupswitch	default:+35->5644, 90:+625->6234, 180:+684->6293, 270:+755->6364
    //   5645: fload_0
    //   5646: getfield 1235	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   5649: istore 17
    //   5651: getstatic 297	com/tencent/mm/plugin/finder/report/ah$c:Ftv	Lcom/tencent/mm/plugin/finder/report/ah$c;
    //   5654: astore 31
    //   5656: iload 20
    //   5658: ifne +8 -> 5666
    //   5661: iload 21
    //   5663: ifeq +772 -> 6435
    //   5666: iconst_1
    //   5667: istore 19
    //   5669: iload 19
    //   5671: invokestatic 722	com/tencent/mm/plugin/finder/report/ah$c:tP	(Z)V
    //   5674: aload_0
    //   5675: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   5678: new 239	java/lang/StringBuilder
    //   5681: dup
    //   5682: ldc_w 1421
    //   5685: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5688: iload 14
    //   5690: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5693: ldc_w 1423
    //   5696: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5699: iload 8
    //   5701: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5704: ldc_w 1425
    //   5707: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5710: iload 9
    //   5712: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5715: ldc_w 659
    //   5718: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5721: aload 40
    //   5723: getfield 159	com/tencent/mm/protocal/protobuf/dji:url	Ljava/lang/String;
    //   5726: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5729: ldc_w 664
    //   5732: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5735: aload 40
    //   5737: getfield 461	com/tencent/mm/protocal/protobuf/dji:thumbUrl	Ljava/lang/String;
    //   5740: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5743: ldc_w 668
    //   5746: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5749: aload 40
    //   5751: getfield 159	com/tencent/mm/protocal/protobuf/dji:url	Ljava/lang/String;
    //   5754: invokestatic 548	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   5757: invokestatic 673	com/tencent/mm/sdk/platformtools/Util:getSizeKB	(J)Ljava/lang/String;
    //   5760: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5763: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5766: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5769: getstatic 166	com/tencent/mm/plugin/finder/upload/c:Gbx	Lcom/tencent/mm/plugin/finder/upload/c$a;
    //   5772: astore 31
    //   5774: aload 40
    //   5776: getfield 159	com/tencent/mm/protocal/protobuf/dji:url	Ljava/lang/String;
    //   5779: astore 32
    //   5781: aload 32
    //   5783: astore 31
    //   5785: aload 32
    //   5787: ifnonnull +7 -> 5794
    //   5790: ldc 160
    //   5792: astore 31
    //   5794: aload 40
    //   5796: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   5799: astore 32
    //   5801: aload 32
    //   5803: ifnonnull +638 -> 6441
    //   5806: iconst_0
    //   5807: istore 14
    //   5809: iload 14
    //   5811: i2f
    //   5812: ldc_w 630
    //   5815: fdiv
    //   5816: fstore 4
    //   5818: aload 40
    //   5820: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   5823: astore 32
    //   5825: aload 32
    //   5827: ifnonnull +624 -> 6451
    //   5830: iconst_0
    //   5831: istore 14
    //   5833: aload 31
    //   5835: iload 8
    //   5837: iload 9
    //   5839: fload 4
    //   5841: iload 14
    //   5843: i2f
    //   5844: ldc_w 630
    //   5847: fdiv
    //   5848: aload 34
    //   5850: iload 20
    //   5852: invokestatic 1428	com/tencent/mm/plugin/finder/upload/c$a:a	(Ljava/lang/String;IIFFLcom/tencent/mm/modelcontrol/VideoTransPara;Z)Lcom/tencent/mm/plugin/finder/upload/c$a$a;
    //   5855: astore 43
    //   5857: iload 8
    //   5859: istore 16
    //   5861: iload 9
    //   5863: istore 15
    //   5865: iload 17
    //   5867: istore 14
    //   5869: aload 43
    //   5871: getfield 1433	com/tencent/mm/plugin/finder/upload/c$a$a:errCode	I
    //   5874: ifne +130 -> 6004
    //   5877: iload 8
    //   5879: istore 16
    //   5881: iload 9
    //   5883: istore 15
    //   5885: iload 17
    //   5887: istore 14
    //   5889: aload 43
    //   5891: getfield 1434	com/tencent/mm/plugin/finder/upload/c$a$a:width	I
    //   5894: ifle +110 -> 6004
    //   5897: iload 8
    //   5899: istore 16
    //   5901: iload 9
    //   5903: istore 15
    //   5905: iload 17
    //   5907: istore 14
    //   5909: aload 43
    //   5911: getfield 1435	com/tencent/mm/plugin/finder/upload/c$a$a:height	I
    //   5914: ifle +90 -> 6004
    //   5917: iload 8
    //   5919: istore 16
    //   5921: iload 9
    //   5923: istore 15
    //   5925: iload 17
    //   5927: istore 14
    //   5929: aload 43
    //   5931: getfield 1436	com/tencent/mm/plugin/finder/upload/c$a$a:bitrate	I
    //   5934: ifle +70 -> 6004
    //   5937: aload 43
    //   5939: getfield 1434	com/tencent/mm/plugin/finder/upload/c$a$a:width	I
    //   5942: istore 16
    //   5944: aload 43
    //   5946: getfield 1435	com/tencent/mm/plugin/finder/upload/c$a$a:height	I
    //   5949: istore 15
    //   5951: aload 43
    //   5953: getfield 1436	com/tencent/mm/plugin/finder/upload/c$a$a:bitrate	I
    //   5956: istore 14
    //   5958: aload_0
    //   5959: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   5962: new 239	java/lang/StringBuilder
    //   5965: dup
    //   5966: ldc_w 1438
    //   5969: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5972: iload 16
    //   5974: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5977: ldc_w 1425
    //   5980: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5983: iload 15
    //   5985: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5988: ldc 248
    //   5990: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5993: iload 14
    //   5995: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5998: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6001: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6004: aload 43
    //   6006: getfield 1442	com/tencent/mm/plugin/finder/upload/c$a$a:Gbz	Lcom/tencent/mm/plugin/sight/base/ABAPrams;
    //   6009: ifnull +1852 -> 7861
    //   6012: aload 43
    //   6014: getfield 1442	com/tencent/mm/plugin/finder/upload/c$a$a:Gbz	Lcom/tencent/mm/plugin/sight/base/ABAPrams;
    //   6017: getfield 1310	com/tencent/mm/plugin/sight/base/ABAPrams:qualityLevel	I
    //   6020: i2f
    //   6021: fstore_3
    //   6022: iload 16
    //   6024: invokestatic 1447	com/tencent/mm/plugin/mmsight/d:aaX	(I)I
    //   6027: istore 8
    //   6029: iload 15
    //   6031: invokestatic 1447	com/tencent/mm/plugin/mmsight/d:aaX	(I)I
    //   6034: istore 9
    //   6036: getstatic 1343	com/tencent/mm/plugin/vlog/report/c:UeI	Lcom/tencent/mm/plugin/vlog/report/c;
    //   6039: astore 31
    //   6041: aload 35
    //   6043: invokestatic 1451	com/tencent/mm/plugin/vlog/report/c:bfn	(Ljava/lang/String;)Lcom/tencent/mm/autogen/mmdata/rpt/qn;
    //   6046: astore 31
    //   6048: aload_0
    //   6049: lload 29
    //   6051: iload 11
    //   6053: aload 42
    //   6055: iload 12
    //   6057: iload 13
    //   6059: iload 8
    //   6061: iload 9
    //   6063: iload 14
    //   6065: aload 34
    //   6067: aload 40
    //   6069: aload 41
    //   6071: aload 33
    //   6073: iload 10
    //   6075: iload 20
    //   6077: iload 21
    //   6079: aload 31
    //   6081: new 16	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b$g
    //   6084: dup
    //   6085: aload 36
    //   6087: aload_0
    //   6088: iload 11
    //   6090: aload 37
    //   6092: invokespecial 1454	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b$g:<init>	(Lkotlin/g/b/ah$c;Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/b;ILjava/util/List;)V
    //   6095: checkcast 204	kotlin/g/a/b
    //   6098: invokespecial 1456	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:a	(JILjava/lang/String;IIIIILcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/protocal/protobuf/dji;Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;Ljava/lang/String;IZZLcom/tencent/mm/autogen/mmdata/rpt/qn;Lkotlin/g/a/b;)I
    //   6101: istore 8
    //   6103: lload 29
    //   6105: invokestatic 1460	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   6108: pop2
    //   6109: iload 8
    //   6111: ifge +350 -> 6461
    //   6114: getstatic 1343	com/tencent/mm/plugin/vlog/report/c:UeI	Lcom/tencent/mm/plugin/vlog/report/c;
    //   6117: astore 31
    //   6119: aload 35
    //   6121: invokestatic 1346	com/tencent/mm/plugin/vlog/report/c:aZm	(Ljava/lang/String;)V
    //   6124: aload_0
    //   6125: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   6128: astore 31
    //   6130: getstatic 1031	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:Gfb	Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/g$a;
    //   6133: astore 32
    //   6135: new 1027	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g
    //   6138: dup
    //   6139: aload 31
    //   6141: invokestatic 1034	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:fev	()I
    //   6144: invokespecial 1037	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:<init>	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;I)V
    //   6147: checkcast 1039	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   6150: astore 31
    //   6152: ldc_w 937
    //   6155: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6158: aload 31
    //   6160: areturn
    //   6161: aload 31
    //   6163: getfield 780	com/tencent/mm/protocal/protobuf/dju:width	I
    //   6166: istore 8
    //   6168: goto -677 -> 5491
    //   6171: aload 31
    //   6173: getfield 781	com/tencent/mm/protocal/protobuf/dju:height	I
    //   6176: istore 9
    //   6178: goto -672 -> 5506
    //   6181: aload 40
    //   6183: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   6186: astore 31
    //   6188: aload 31
    //   6190: ifnonnull +24 -> 6214
    //   6193: iconst_0
    //   6194: istore 8
    //   6196: aload 40
    //   6198: getfield 170	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   6201: astore 31
    //   6203: aload 31
    //   6205: ifnonnull +19 -> 6224
    //   6208: iconst_0
    //   6209: istore 9
    //   6211: goto -675 -> 5536
    //   6214: aload 31
    //   6216: getfield 781	com/tencent/mm/protocal/protobuf/dju:height	I
    //   6219: istore 8
    //   6221: goto -25 -> 6196
    //   6224: aload 31
    //   6226: getfield 780	com/tencent/mm/protocal/protobuf/dju:width	I
    //   6229: istore 9
    //   6231: goto -20 -> 6211
    //   6234: new 172	com/tencent/mm/protocal/protobuf/fyb
    //   6237: dup
    //   6238: invokespecial 173	com/tencent/mm/protocal/protobuf/fyb:<init>	()V
    //   6241: astore 43
    //   6243: aload 43
    //   6245: aload 32
    //   6247: getfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   6250: putfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   6253: aload 43
    //   6255: aload 32
    //   6257: getfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   6260: putfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   6263: aload 43
    //   6265: aload 32
    //   6267: getfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   6270: putfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   6273: aload 43
    //   6275: aload 32
    //   6277: getfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   6280: putfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   6283: aload 31
    //   6285: aload 43
    //   6287: putfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   6290: goto -646 -> 5644
    //   6293: new 172	com/tencent/mm/protocal/protobuf/fyb
    //   6296: dup
    //   6297: invokespecial 173	com/tencent/mm/protocal/protobuf/fyb:<init>	()V
    //   6300: astore 43
    //   6302: aload 43
    //   6304: iload 15
    //   6306: aload 32
    //   6308: getfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   6311: isub
    //   6312: putfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   6315: aload 43
    //   6317: iload 16
    //   6319: aload 32
    //   6321: getfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   6324: isub
    //   6325: putfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   6328: aload 43
    //   6330: iload 15
    //   6332: aload 32
    //   6334: getfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   6337: isub
    //   6338: putfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   6341: aload 43
    //   6343: iload 16
    //   6345: aload 32
    //   6347: getfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   6350: isub
    //   6351: putfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   6354: aload 31
    //   6356: aload 43
    //   6358: putfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   6361: goto -717 -> 5644
    //   6364: new 172	com/tencent/mm/protocal/protobuf/fyb
    //   6367: dup
    //   6368: invokespecial 173	com/tencent/mm/protocal/protobuf/fyb:<init>	()V
    //   6371: astore 43
    //   6373: aload 43
    //   6375: iload 16
    //   6377: aload 32
    //   6379: getfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   6382: isub
    //   6383: putfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   6386: aload 43
    //   6388: iload 15
    //   6390: aload 32
    //   6392: getfield 776	com/tencent/mm/protocal/protobuf/fyb:left	I
    //   6395: isub
    //   6396: putfield 779	com/tencent/mm/protocal/protobuf/fyb:top	I
    //   6399: aload 43
    //   6401: iload 16
    //   6403: aload 32
    //   6405: getfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   6408: isub
    //   6409: putfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   6412: aload 43
    //   6414: iload 15
    //   6416: aload 32
    //   6418: getfield 778	com/tencent/mm/protocal/protobuf/fyb:right	I
    //   6421: isub
    //   6422: putfield 777	com/tencent/mm/protocal/protobuf/fyb:bottom	I
    //   6425: aload 31
    //   6427: aload 43
    //   6429: putfield 279	com/tencent/mm/protocal/protobuf/dju:aaPJ	Lcom/tencent/mm/protocal/protobuf/fyb;
    //   6432: goto -788 -> 5644
    //   6435: iconst_0
    //   6436: istore 19
    //   6438: goto -769 -> 5669
    //   6441: aload 32
    //   6443: getfield 285	com/tencent/mm/protocal/protobuf/dju:endTime	I
    //   6446: istore 14
    //   6448: goto -639 -> 5809
    //   6451: aload 32
    //   6453: getfield 282	com/tencent/mm/protocal/protobuf/dju:startTime	I
    //   6456: istore 14
    //   6458: goto -625 -> 5833
    //   6461: getstatic 619	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:ObB	Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker;
    //   6464: aload 42
    //   6466: invokevirtual 623	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:aTG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a;
    //   6469: astore 32
    //   6471: aload 32
    //   6473: ifnull +29 -> 6502
    //   6476: aload 32
    //   6478: getfield 641	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   6481: ifle +21 -> 6502
    //   6484: aload 32
    //   6486: getfield 643	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   6489: ifle +13 -> 6502
    //   6492: aload 32
    //   6494: getfield 629	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:duration	J
    //   6497: lconst_0
    //   6498: lcmp
    //   6499: ifgt +197 -> 6696
    //   6502: aload_0
    //   6503: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   6506: astore 33
    //   6508: new 239	java/lang/StringBuilder
    //   6511: dup
    //   6512: ldc_w 1462
    //   6515: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   6518: astore 34
    //   6520: aload 32
    //   6522: ifnonnull +136 -> 6658
    //   6525: aconst_null
    //   6526: astore 31
    //   6528: aload 34
    //   6530: aload 31
    //   6532: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6535: bipush 32
    //   6537: invokevirtual 1265	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   6540: astore 34
    //   6542: aload 32
    //   6544: ifnonnull +127 -> 6671
    //   6547: aconst_null
    //   6548: astore 31
    //   6550: aload 33
    //   6552: aload 34
    //   6554: aload 31
    //   6556: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6559: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6562: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6565: getstatic 297	com/tencent/mm/plugin/finder/report/ah$c:Ftv	Lcom/tencent/mm/plugin/finder/report/ah$c;
    //   6568: astore 31
    //   6570: iload 20
    //   6572: ifne +8 -> 6580
    //   6575: iload 21
    //   6577: ifeq +107 -> 6684
    //   6580: iconst_1
    //   6581: istore 19
    //   6583: iload 19
    //   6585: invokestatic 301	com/tencent/mm/plugin/finder/report/ah$c:ty	(Z)V
    //   6588: getstatic 297	com/tencent/mm/plugin/finder/report/ah$c:Ftv	Lcom/tencent/mm/plugin/finder/report/ah$c;
    //   6591: astore 31
    //   6593: iload 20
    //   6595: ifne +8 -> 6603
    //   6598: iload 21
    //   6600: ifeq +90 -> 6690
    //   6603: iconst_1
    //   6604: istore 19
    //   6606: iload 19
    //   6608: invokestatic 1465	com/tencent/mm/plugin/finder/report/ah$c:tQ	(Z)V
    //   6611: getstatic 1343	com/tencent/mm/plugin/vlog/report/c:UeI	Lcom/tencent/mm/plugin/vlog/report/c;
    //   6614: astore 31
    //   6616: aload 35
    //   6618: invokestatic 1346	com/tencent/mm/plugin/vlog/report/c:aZm	(Ljava/lang/String;)V
    //   6621: aload_0
    //   6622: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   6625: astore 31
    //   6627: getstatic 1031	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:Gfb	Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/g$a;
    //   6630: astore 32
    //   6632: new 1027	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g
    //   6635: dup
    //   6636: aload 31
    //   6638: invokestatic 1034	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:fev	()I
    //   6641: invokespecial 1037	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:<init>	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;I)V
    //   6644: checkcast 1039	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   6647: astore 31
    //   6649: ldc_w 937
    //   6652: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6655: aload 31
    //   6657: areturn
    //   6658: aload 32
    //   6660: getfield 641	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   6663: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6666: astore 31
    //   6668: goto -140 -> 6528
    //   6671: aload 32
    //   6673: getfield 643	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   6676: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6679: astore 31
    //   6681: goto -131 -> 6550
    //   6684: iconst_0
    //   6685: istore 19
    //   6687: goto -104 -> 6583
    //   6690: iconst_0
    //   6691: istore 19
    //   6693: goto -87 -> 6606
    //   6696: aload 43
    //   6698: getfield 1442	com/tencent/mm/plugin/finder/upload/c$a$a:Gbz	Lcom/tencent/mm/plugin/sight/base/ABAPrams;
    //   6701: ifnull +1154 -> 7855
    //   6704: aload 42
    //   6706: aload 43
    //   6708: getfield 1442	com/tencent/mm/plugin/finder/upload/c$a$a:Gbz	Lcom/tencent/mm/plugin/sight/base/ABAPrams;
    //   6711: aload 34
    //   6713: getfield 1313	com/tencent/mm/modelcontrol/VideoTransPara:oCb	I
    //   6716: iconst_0
    //   6717: invokestatic 1317	com/tencent/mm/plugin/sight/base/SightVideoJNI:addReportMetadata	(Ljava/lang/String;Lcom/tencent/mm/plugin/sight/base/ABAPrams;II)V
    //   6720: iconst_1
    //   6721: istore 8
    //   6723: aload_0
    //   6724: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   6727: ldc_w 1467
    //   6730: fload_3
    //   6731: invokestatic 394	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   6734: invokestatic 229	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   6737: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6740: getstatic 166	com/tencent/mm/plugin/finder/upload/c:Gbx	Lcom/tencent/mm/plugin/finder/upload/c$a;
    //   6743: astore 32
    //   6745: aload 42
    //   6747: fload 5
    //   6749: fload 6
    //   6751: iload 18
    //   6753: iload 22
    //   6755: iload 23
    //   6757: invokestatic 1470	com/tencent/mm/plugin/finder/upload/c$a:a	(Ljava/lang/String;FFIZZ)F
    //   6760: fstore 4
    //   6762: aload_0
    //   6763: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   6766: new 239	java/lang/StringBuilder
    //   6769: dup
    //   6770: ldc_w 1472
    //   6773: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   6776: fload 4
    //   6778: invokevirtual 591	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   6781: ldc_w 1474
    //   6784: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6787: fload 5
    //   6789: invokevirtual 591	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   6792: ldc_w 1476
    //   6795: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6798: fload 6
    //   6800: invokevirtual 591	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   6803: ldc_w 1478
    //   6806: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6809: iload 18
    //   6811: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6814: ldc_w 1480
    //   6817: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6820: iload 22
    //   6822: invokevirtual 610	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6825: ldc_w 1482
    //   6828: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6831: iload 23
    //   6833: invokevirtual 610	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6836: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6839: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   6842: aload 31
    //   6844: ifnull +56 -> 6900
    //   6847: aload 31
    //   6849: ifnull +14 -> 6863
    //   6852: aload 31
    //   6854: ldc_w 1483
    //   6857: fload_3
    //   6858: fmul
    //   6859: f2l
    //   6860: putfield 1488	com/tencent/mm/autogen/mmdata/rpt/qn:jsE	J
    //   6863: aload 31
    //   6865: ifnull +15 -> 6880
    //   6868: aload 31
    //   6870: ldc_w 1483
    //   6873: fload 4
    //   6875: fmul
    //   6876: f2l
    //   6877: putfield 1491	com/tencent/mm/autogen/mmdata/rpt/qn:jsD	J
    //   6880: getstatic 1343	com/tencent/mm/plugin/vlog/report/c:UeI	Lcom/tencent/mm/plugin/vlog/report/c;
    //   6883: astore 31
    //   6885: aload 35
    //   6887: invokestatic 1346	com/tencent/mm/plugin/vlog/report/c:aZm	(Ljava/lang/String;)V
    //   6890: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   6893: astore 31
    //   6895: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   6898: astore 31
    //   6900: aload_0
    //   6901: iload 11
    //   6903: i2f
    //   6904: fconst_1
    //   6905: fadd
    //   6906: aload 37
    //   6908: invokeinterface 1040 1 0
    //   6913: i2f
    //   6914: fdiv
    //   6915: invokevirtual 1044	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:cn	(F)V
    //   6918: aload 40
    //   6920: getfield 464	com/tencent/mm/protocal/protobuf/dji:aaPp	Z
    //   6923: ifeq +544 -> 7467
    //   6926: aload_0
    //   6927: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   6930: invokevirtual 954	com/tencent/mm/plugin/finder/storage/FinderItem:getHalfVideoMediaExtList	()Ljava/util/LinkedList;
    //   6933: checkcast 956	java/lang/Iterable
    //   6936: invokeinterface 960 1 0
    //   6941: astore 32
    //   6943: aload 32
    //   6945: invokeinterface 965 1 0
    //   6950: ifeq +511 -> 7461
    //   6953: aload 32
    //   6955: invokeinterface 969 1 0
    //   6960: astore 31
    //   6962: aload 31
    //   6964: checkcast 156	com/tencent/mm/protocal/protobuf/dji
    //   6967: astore 33
    //   6969: aload 40
    //   6971: getfield 542	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   6974: aload 33
    //   6976: getfield 542	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   6979: invokestatic 1061	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   6982: ifeq -39 -> 6943
    //   6985: aload 31
    //   6987: checkcast 156	com/tencent/mm/protocal/protobuf/dji
    //   6990: astore 31
    //   6992: aload 31
    //   6994: ifnull +37 -> 7031
    //   6997: aload_0
    //   6998: aload 34
    //   7000: aload 40
    //   7002: aload 42
    //   7004: aload 31
    //   7006: iload 11
    //   7008: aload 41
    //   7010: fload 4
    //   7012: fload_3
    //   7013: iconst_0
    //   7014: invokespecial 1493	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:a	(Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/protocal/protobuf/dji;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/dji;ILcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;FFZ)V
    //   7017: aload_0
    //   7018: invokevirtual 273	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:fey	()V
    //   7021: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   7024: astore 31
    //   7026: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   7029: astore 31
    //   7031: aload_0
    //   7032: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   7035: invokevirtual 993	com/tencent/mm/plugin/finder/storage/FinderItem:getLongVideoMediaExtList	()Ljava/util/LinkedList;
    //   7038: astore 32
    //   7040: aload 32
    //   7042: checkcast 956	java/lang/Iterable
    //   7045: invokeinterface 960 1 0
    //   7050: astore 33
    //   7052: aload 33
    //   7054: invokeinterface 965 1 0
    //   7059: ifeq +574 -> 7633
    //   7062: aload 33
    //   7064: invokeinterface 969 1 0
    //   7069: astore 31
    //   7071: aload 31
    //   7073: checkcast 156	com/tencent/mm/protocal/protobuf/dji
    //   7076: astore 35
    //   7078: aload 40
    //   7080: getfield 542	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   7083: aload 35
    //   7085: getfield 542	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   7088: invokestatic 1061	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   7091: ifeq -39 -> 7052
    //   7094: aload 31
    //   7096: checkcast 156	com/tencent/mm/protocal/protobuf/dji
    //   7099: astore 31
    //   7101: aload 31
    //   7103: ifnull +72 -> 7175
    //   7106: aload_0
    //   7107: aload 34
    //   7109: aload 40
    //   7111: aload 42
    //   7113: aload 31
    //   7115: iload 11
    //   7117: aload 41
    //   7119: fload 4
    //   7121: fload_3
    //   7122: iconst_1
    //   7123: invokespecial 1493	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:a	(Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/protocal/protobuf/dji;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/dji;ILcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;FFZ)V
    //   7126: aload_0
    //   7127: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   7130: invokevirtual 1497	com/tencent/mm/plugin/finder/storage/FinderItem:getFeedObject	()Lcom/tencent/mm/protocal/protobuf/FinderObject;
    //   7133: getfield 1503	com/tencent/mm/protocal/protobuf/FinderObject:attachmentList	Lcom/tencent/mm/protocal/protobuf/atr;
    //   7136: astore 31
    //   7138: aload 31
    //   7140: ifnonnull +499 -> 7639
    //   7143: aconst_null
    //   7144: astore 31
    //   7146: aload 31
    //   7148: ifnull +13 -> 7161
    //   7151: aload 31
    //   7153: aload 32
    //   7155: invokestatic 1509	com/tencent/mm/plugin/finder/storage/data/n:ba	(Ljava/util/LinkedList;)Ljava/util/LinkedList;
    //   7158: putfield 1513	com/tencent/mm/protocal/protobuf/dnh:media	Ljava/util/LinkedList;
    //   7161: aload_0
    //   7162: invokevirtual 273	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:fey	()V
    //   7165: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   7168: astore 31
    //   7170: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   7173: astore 31
    //   7175: iload 11
    //   7177: iconst_1
    //   7178: iadd
    //   7179: istore 11
    //   7181: goto -6567 -> 614
    //   7184: astore 32
    //   7186: iconst_1
    //   7187: istore 8
    //   7189: goto -466 -> 6723
    //   7192: iload 20
    //   7194: ifne +651 -> 7845
    //   7197: iload 21
    //   7199: ifne +646 -> 7845
    //   7202: aload_0
    //   7203: lload 29
    //   7205: iload 11
    //   7207: aload 42
    //   7209: aload 34
    //   7211: aload 40
    //   7213: aload 41
    //   7215: aload 37
    //   7217: invokeinterface 1040 1 0
    //   7222: invokespecial 1515	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:a	(JILjava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/protocal/protobuf/dji;Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;I)Lkotlin/r;
    //   7225: astore 31
    //   7227: aload 31
    //   7229: getfield 1337	kotlin/r:bsC	Ljava/lang/Object;
    //   7232: checkcast 1022	java/lang/Number
    //   7235: invokevirtual 1025	java/lang/Number:intValue	()I
    //   7238: istore 8
    //   7240: aload 31
    //   7242: getfield 1518	kotlin/r:bsD	Ljava/lang/Object;
    //   7245: checkcast 1022	java/lang/Number
    //   7248: invokevirtual 1521	java/lang/Number:floatValue	()F
    //   7251: fstore_3
    //   7252: iload 8
    //   7254: ifge +40 -> 7294
    //   7257: aload_0
    //   7258: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   7261: astore 31
    //   7263: getstatic 1031	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:Gfb	Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/g$a;
    //   7266: astore 32
    //   7268: new 1027	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g
    //   7271: dup
    //   7272: aload 31
    //   7274: invokestatic 1034	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:fev	()I
    //   7277: invokespecial 1037	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:<init>	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;I)V
    //   7280: checkcast 1039	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   7283: astore 31
    //   7285: ldc_w 937
    //   7288: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7291: aload 31
    //   7293: areturn
    //   7294: getstatic 619	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:ObB	Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker;
    //   7297: aload 42
    //   7299: invokevirtual 623	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:aTG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a;
    //   7302: astore 32
    //   7304: aload 32
    //   7306: ifnull +29 -> 7335
    //   7309: aload 32
    //   7311: getfield 641	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   7314: ifle +21 -> 7335
    //   7317: aload 32
    //   7319: getfield 643	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   7322: ifle +13 -> 7335
    //   7325: aload 32
    //   7327: getfield 629	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:duration	J
    //   7330: lconst_0
    //   7331: lcmp
    //   7332: ifgt +503 -> 7835
    //   7335: aload_0
    //   7336: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:TAG	Ljava/lang/String;
    //   7339: astore 33
    //   7341: new 239	java/lang/StringBuilder
    //   7344: dup
    //   7345: ldc_w 1375
    //   7348: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   7351: astore 34
    //   7353: aload 32
    //   7355: ifnonnull +80 -> 7435
    //   7358: aconst_null
    //   7359: astore 31
    //   7361: aload 34
    //   7363: aload 31
    //   7365: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7368: bipush 32
    //   7370: invokevirtual 1265	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   7373: astore 34
    //   7375: aload 32
    //   7377: ifnonnull +71 -> 7448
    //   7380: aconst_null
    //   7381: astore 31
    //   7383: aload 33
    //   7385: aload 34
    //   7387: aload 31
    //   7389: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7392: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7395: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7398: aload_0
    //   7399: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   7402: astore 31
    //   7404: getstatic 1031	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:Gfb	Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/g$a;
    //   7407: astore 32
    //   7409: new 1027	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g
    //   7412: dup
    //   7413: aload 31
    //   7415: invokestatic 1034	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:fev	()I
    //   7418: invokespecial 1037	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/g:<init>	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;I)V
    //   7421: checkcast 1039	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   7424: astore 31
    //   7426: ldc_w 937
    //   7429: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7432: aload 31
    //   7434: areturn
    //   7435: aload 32
    //   7437: getfield 641	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   7440: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7443: astore 31
    //   7445: goto -84 -> 7361
    //   7448: aload 32
    //   7450: getfield 643	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   7453: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7456: astore 31
    //   7458: goto -75 -> 7383
    //   7461: aconst_null
    //   7462: astore 31
    //   7464: goto -479 -> 6985
    //   7467: aload_0
    //   7468: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   7471: invokevirtual 976	com/tencent/mm/plugin/finder/storage/FinderItem:getMediaList	()Ljava/util/LinkedList;
    //   7474: astore 32
    //   7476: aload 32
    //   7478: checkcast 956	java/lang/Iterable
    //   7481: invokeinterface 960 1 0
    //   7486: astore 33
    //   7488: aload 33
    //   7490: invokeinterface 965 1 0
    //   7495: ifeq +132 -> 7627
    //   7498: aload 33
    //   7500: invokeinterface 969 1 0
    //   7505: astore 31
    //   7507: aload 31
    //   7509: checkcast 156	com/tencent/mm/protocal/protobuf/dji
    //   7512: astore 35
    //   7514: aload 40
    //   7516: getfield 542	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   7519: aload 35
    //   7521: getfield 542	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   7524: invokestatic 1061	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   7527: ifeq -39 -> 7488
    //   7530: aload 31
    //   7532: checkcast 156	com/tencent/mm/protocal/protobuf/dji
    //   7535: astore 31
    //   7537: aload 31
    //   7539: ifnull -508 -> 7031
    //   7542: aload_0
    //   7543: aload 34
    //   7545: aload 40
    //   7547: aload 42
    //   7549: aload 31
    //   7551: iload 11
    //   7553: aload 41
    //   7555: fload 4
    //   7557: fload_3
    //   7558: iconst_0
    //   7559: invokespecial 1493	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:a	(Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/protocal/protobuf/dji;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/dji;ILcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;FFZ)V
    //   7562: aload_0
    //   7563: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   7566: aload 32
    //   7568: invokevirtual 1525	com/tencent/mm/plugin/finder/storage/FinderItem:setMediaList	(Ljava/util/LinkedList;)V
    //   7571: aload_0
    //   7572: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   7575: getfield 265	com/tencent/mm/plugin/finder/storage/FinderItem:field_reportObject	Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;
    //   7578: astore 31
    //   7580: aload 31
    //   7582: ifnull +28 -> 7610
    //   7585: aload 31
    //   7587: invokestatic 1530	com/tencent/mm/model/cn:bDw	()J
    //   7590: putfield 1533	com/tencent/mm/protocal/protobuf/FinderFeedReportObject:remuxEndTime	J
    //   7593: aload 31
    //   7595: iload 8
    //   7597: putfield 1536	com/tencent/mm/protocal/protobuf/FinderFeedReportObject:remuxType	I
    //   7600: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   7603: astore 31
    //   7605: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   7608: astore 31
    //   7610: aload_0
    //   7611: invokevirtual 273	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:fey	()V
    //   7614: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   7617: astore 31
    //   7619: getstatic 261	kotlin/ah:aiuX	Lkotlin/ah;
    //   7622: astore 31
    //   7624: goto -593 -> 7031
    //   7627: aconst_null
    //   7628: astore 31
    //   7630: goto -100 -> 7530
    //   7633: aconst_null
    //   7634: astore 31
    //   7636: goto -542 -> 7094
    //   7639: aload 31
    //   7641: getfield 1541	com/tencent/mm/protocal/protobuf/atr:ZEi	Ljava/util/LinkedList;
    //   7644: astore 31
    //   7646: aload 31
    //   7648: ifnonnull +9 -> 7657
    //   7651: aconst_null
    //   7652: astore 31
    //   7654: goto -508 -> 7146
    //   7657: aload 31
    //   7659: checkcast 956	java/lang/Iterable
    //   7662: invokeinterface 960 1 0
    //   7667: astore 33
    //   7669: aload 33
    //   7671: invokeinterface 965 1 0
    //   7676: ifeq +58 -> 7734
    //   7679: aload 33
    //   7681: invokeinterface 969 1 0
    //   7686: astore 31
    //   7688: aload 31
    //   7690: checkcast 1543	com/tencent/mm/protocal/protobuf/atq
    //   7693: astore 34
    //   7695: getstatic 414	com/tencent/mm/plugin/finder/utils/av:GiL	Lcom/tencent/mm/plugin/finder/utils/av;
    //   7698: astore 35
    //   7700: aload 34
    //   7702: ldc_w 1545
    //   7705: invokestatic 1103	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7708: aload 34
    //   7710: invokestatic 1548	com/tencent/mm/plugin/finder/utils/av:a	(Lcom/tencent/mm/protocal/protobuf/atq;)Z
    //   7713: ifeq -44 -> 7669
    //   7716: aload 31
    //   7718: checkcast 1543	com/tencent/mm/protocal/protobuf/atq
    //   7721: astore 31
    //   7723: aload 31
    //   7725: ifnonnull +15 -> 7740
    //   7728: aconst_null
    //   7729: astore 31
    //   7731: goto -585 -> 7146
    //   7734: aconst_null
    //   7735: astore 31
    //   7737: goto -21 -> 7716
    //   7740: aload 31
    //   7742: getfield 1552	com/tencent/mm/protocal/protobuf/atq:ZEf	Lcom/tencent/mm/protocal/protobuf/byx;
    //   7745: astore 31
    //   7747: aload 31
    //   7749: ifnonnull +9 -> 7758
    //   7752: aconst_null
    //   7753: astore 31
    //   7755: goto -609 -> 7146
    //   7758: aload 31
    //   7760: getfield 1558	com/tencent/mm/protocal/protobuf/byx:ZXx	Lcom/tencent/mm/protocal/protobuf/dne;
    //   7763: astore 31
    //   7765: aload 31
    //   7767: ifnonnull +9 -> 7776
    //   7770: aconst_null
    //   7771: astore 31
    //   7773: goto -627 -> 7146
    //   7776: aload 31
    //   7778: getfield 1564	com/tencent/mm/protocal/protobuf/dne:aaUt	Lcom/tencent/mm/protocal/protobuf/dnh;
    //   7781: astore 31
    //   7783: goto -637 -> 7146
    //   7786: getstatic 679	com/tencent/mm/plugin/vlog/model/m:TYW	Lcom/tencent/mm/plugin/vlog/model/m;
    //   7789: astore 31
    //   7791: invokestatic 1567	com/tencent/mm/plugin/vlog/model/m:reset	()V
    //   7794: new 1046	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/f
    //   7797: dup
    //   7798: aload_0
    //   7799: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/b:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   7802: invokespecial 1048	com/tencent/mm/plugin/finder/upload/postlogic/finderstage/f:<init>	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V
    //   7805: checkcast 1039	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   7808: astore 31
    //   7810: ldc_w 937
    //   7813: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7816: aload 31
    //   7818: areturn
    //   7819: astore 31
    //   7821: fconst_0
    //   7822: fstore 4
    //   7824: goto -5242 -> 2582
    //   7827: astore 31
    //   7829: fload_3
    //   7830: fstore 4
    //   7832: goto -5250 -> 2582
    //   7835: iload 9
    //   7837: istore 8
    //   7839: aconst_null
    //   7840: astore 31
    //   7842: goto -1119 -> 6723
    //   7845: iload 9
    //   7847: istore 8
    //   7849: aconst_null
    //   7850: astore 31
    //   7852: goto -1129 -> 6723
    //   7855: iconst_1
    //   7856: istore 8
    //   7858: goto -1135 -> 6723
    //   7861: goto -1839 -> 6022
    //   7864: goto -3482 -> 4382
    //   7867: iload 25
    //   7869: istore 19
    //   7871: iload 12
    //   7873: istore 10
    //   7875: goto -4457 -> 3418
    //   7878: iconst_0
    //   7879: istore 19
    //   7881: iload 12
    //   7883: istore 10
    //   7885: goto -4467 -> 3418
    //   7888: iconst_0
    //   7889: istore 24
    //   7891: goto -5163 -> 2728
    //   7894: fconst_0
    //   7895: fstore_3
    //   7896: goto -5338 -> 2558
    //   7899: iconst_0
    //   7900: istore 22
    //   7902: goto -6102 -> 1800
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7905	0	this	b
    //   1943	112	1	d	double
    //   2557	5339	3	f1	float
    //   2559	5272	4	f2	float
    //   1810	4978	5	f3	float
    //   1818	4981	6	f4	float
    //   3829	54	7	f5	float
    //   121	7736	8	i	int
    //   194	7652	9	j	int
    //   1431	6453	10	k	int
    //   603	6949	11	m	int
    //   1407	6475	12	n	int
    //   1451	4607	13	i1	int
    //   4328	2129	14	i2	int
    //   5592	830	15	i3	int
    //   5605	804	16	i4	int
    //   5649	277	17	i5	int
    //   1825	4985	18	i6	int
    //   1662	6218	19	bool1	boolean
    //   775	6418	20	bool2	boolean
    //   804	6394	21	bool3	boolean
    //   1798	6103	22	bool4	boolean
    //   1840	4992	23	bool5	boolean
    //   2135	5755	24	bool6	boolean
    //   953	6915	25	bool7	boolean
    //   2157	304	26	bool8	boolean
    //   3773	1086	27	l1	long
    //   1329	5875	29	l2	long
    //   23	7794	31	localObject1	Object
    //   7819	1	31	localObject2	Object
    //   7827	1	31	localObject3	Object
    //   7840	11	31	localObject4	Object
    //   97	7057	32	localObject5	Object
    //   7184	1	32	localObject6	Object
    //   7266	301	32	localObject7	Object
    //   104	7576	33	localObject8	Object
    //   819	6890	34	localObject9	Object
    //   1042	6657	35	localObject10	Object
    //   1702	4384	36	localObject11	Object
    //   46	7170	37	localList1	List
    //   58	725	38	localList2	List
    //   612	13	39	localIterator	java.util.Iterator
    //   646	6900	40	localdji	dji
    //   962	6592	41	localFinderMediaReportObject	FinderMediaReportObject
    //   1401	6147	42	str	String
    //   2042	4665	43	localObject12	Object
    //   2047	2202	44	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   6704	6720	7184	finally
    //   2490	2542	7819	finally
    //   2547	2554	7819	finally
    //   2566	2579	7827	finally
  }
  
  public final int fer()
  {
    return 2;
  }
  
  final void fey()
  {
    AppMethodBeat.i(343337);
    d.a locala = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    d.a.v(this.Ged);
    AppMethodBeat.o(343337);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Float, ah>
  {
    a(kotlin.g.b.ah.c paramc, b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<k, ah>
  {
    b(b paramb, kotlin.g.b.ah.d paramd, int paramInt, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, String paramString, afc paramafc, VideoTransPara paramVideoTransPara, afb paramafb, Object paramObject, ah.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Float, ah>
  {
    c(kotlin.g.b.ah.c paramc, b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<k, ah>
  {
    d(b paramb, kotlin.g.b.ah.d paramd1, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, String paramString, boolean paramBoolean, kotlin.g.b.ah.d paramd2, kotlin.g.b.ah.d paramd3, VideoTransPara paramVideoTransPara, Object paramObject, ah.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    f(dji paramdji, qn paramqn, long paramLong, boolean paramBoolean1, kotlin.g.b.ah.d paramd, b paramb, int paramInt1, boolean paramBoolean2, FinderMediaReportObject paramFinderMediaReportObject, int paramInt2, int paramInt3, VideoTransPara paramVideoTransPara, Object paramObject, ah.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Float, ah>
  {
    g(kotlin.g.b.ah.c paramc, b paramb, int paramInt, List<dji> paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.finderstage.b
 * JD-Core Version:    0.7.0.1
 */