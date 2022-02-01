package com.tencent.mm.plugin.finder.upload.postlogic.draftstage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ic;
import com.tencent.mm.autogen.a.iq;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.report.i.b;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.h;
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
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.c;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.h.a;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/FinderDraftMediaProcessStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;)V", "TAG", "", "cancel", "", "getCancel", "()Z", "setCancel", "(Z)V", "curExporter", "Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;", "getCurExporter", "()Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;", "setCurExporter", "(Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;)V", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "draftModifyListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderDraftModifyEvent;", "getDraftModifyListener", "()Lcom/tencent/mm/sdk/event/IListener;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "checkVideoInfoMatch", "path", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getStageType", "", "onFailed", "", "nextStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "onSuccess", "onWait", "remuxComposition", "Lkotlin/Pair;", "", "startRemuxerTick", "", "index", "outputPath", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaReportObject", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;", "size", "remuxLongVideoComposition", "localMedia", "isLongVideo", "vcPerformanceStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "run", "saveFinderObject", "start", "updateMedia", "reportObject", "audioQuality", "videoQuality", "updateProgress", "avgProgress", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.finder.upload.postlogic.f
{
  final com.tencent.mm.plugin.finder.storage.i ABX;
  final FinderItem Ged;
  com.tencent.mm.plugin.vlog.model.e Gee;
  private final IListener<iq> Gef;
  final String TAG;
  boolean cancel;
  
  public d(com.tencent.mm.plugin.finder.storage.i parami)
  {
    super(com.tencent.mm.plugin.finder.storage.j.e(parami));
    AppMethodBeat.i(343095);
    this.ABX = parami;
    this.TAG = "LogPost.FinderDraftMediaProcessStage";
    this.Ged = this.ABX.eYK();
    this.Gef = ((IListener)new FinderDraftMediaProcessStage.draftModifyListener.1(this, com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(343095);
  }
  
  private final r<Integer, Float> a(final long paramLong, final int paramInt1, String paramString, final VideoTransPara paramVideoTransPara, dji paramdji, final FinderMediaReportObject paramFinderMediaReportObject, final int paramInt2)
  {
    AppMethodBeat.i(343215);
    Log.i(this.TAG, s.X("remuxComposition outputPath:", paramString));
    Object localObject2 = paramdji.aaDI;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new afb();
    }
    final ah.d locald = new ah.d();
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
    paramdji = paramdji.EDC;
    if (paramdji == null) {}
    for (int i = 0;; i = paramdji.retryCount)
    {
      locale.retryCount = i;
      locale.TYa = true;
      paramdji = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (com.tencent.mm.plugin.finder.storage.d.ePX()) {
        locale.a(true, paramVideoTransPara);
      }
      locale.aJ((kotlin.g.a.b)new a(new ah.c(), this, paramInt1, paramInt2));
      this.Gee = locale;
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
        paramString = new r(Integer.valueOf(locald.aixb), Float.valueOf(f));
        AppMethodBeat.o(343215);
        return paramString;
      }
      finally
      {
        AppMethodBeat.o(343215);
      }
    }
  }
  
  private final r<Integer, Float> a(final long paramLong, final VideoTransPara paramVideoTransPara, final dji paramdji, String paramString, final FinderMediaReportObject paramFinderMediaReportObject, final boolean paramBoolean, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(343180);
    localObject1 = i.b.Fox;
    i.b.eMr();
    localObject1 = m.TYW;
    m.FN(paramBoolean);
    localObject1 = new Object();
    final ah.a locala = new ah.a();
    Object localObject3 = paramdji.url;
    if (localObject3 == null)
    {
      paramVideoTransPara = new r(Integer.valueOf(-1000), Float.valueOf(0.0F));
      AppMethodBeat.o(343180);
      return paramVideoTransPara;
    }
    Object localObject4 = paramdji.EDC;
    if (localObject4 == null)
    {
      paramVideoTransPara = new r(Integer.valueOf(-1001), Float.valueOf(0.0F));
      AppMethodBeat.o(343180);
      return paramVideoTransPara;
    }
    Object localObject2 = new Rect();
    final ah.d locald1 = new ah.d();
    final ah.d locald2 = new ah.d();
    Object localObject5 = MultiMediaVideoChecker.ObB.cI((String)localObject3, true);
    Object localObject6 = new ad((String)localObject3, 2);
    ((ad)localObject6).wC(((dju)localObject4).endTime);
    ((ad)localObject6).wA(((dju)localObject4).endTime);
    localObject3 = new ac(p.listOf(localObject6));
    int j = 0;
    int i = 0;
    if (localObject5 != null)
    {
      j = ((MultiMediaVideoChecker.a)localObject5).width;
      i = ((MultiMediaVideoChecker.a)localObject5).height;
      if ((((MultiMediaVideoChecker.a)localObject5).hYK == 90) || (((MultiMediaVideoChecker.a)localObject5).hYK == 270))
      {
        j = ((MultiMediaVideoChecker.a)localObject5).height;
        i = ((MultiMediaVideoChecker.a)localObject5).width;
      }
      ((ad)localObject6).UaF.yok.set(0, 0, j, i);
      ((ac)localObject3).mu(j, i);
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
        ((FinderMediaReportInfo)localObject6).fps = ((int)((MultiMediaVideoChecker.a)localObject5).eGw);
      }
      localObject5 = ah.aiuX;
    }
    localObject5 = ((dju)localObject4).aaPJ;
    int k;
    if (localObject5 != null)
    {
      if (paramBoolean)
      {
        ((Rect)localObject2).set(((fyb)localObject5).left, ((fyb)localObject5).bottom, ((fyb)localObject5).right, ((fyb)localObject5).top);
        localObject5 = ah.aiuX;
      }
    }
    else
    {
      if (!paramBoolean) {
        break label1077;
      }
      k = ((dju)localObject4).width;
      label499:
      locald1.aixb = k;
      if (!paramBoolean) {
        break label1095;
      }
      k = ((dju)localObject4).height;
      label518:
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
        break label1113;
      }
    }
    label1077:
    label1095:
    label1113:
    for (i = 0;; i = paramdji.retryCount)
    {
      ((com.tencent.mm.plugin.vlog.model.e)localObject3).retryCount = i;
      ((com.tencent.mm.plugin.vlog.model.e)localObject3).a(true, paramVideoTransPara);
      ((com.tencent.mm.plugin.vlog.model.e)localObject3).aJ((kotlin.g.a.b)new c(new ah.c(), this, paramInt1, paramInt2));
      paramdji = new ah.d();
      paramdji.aixb = -1;
      this.Gee = ((com.tencent.mm.plugin.vlog.model.e)localObject3);
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
        paramVideoTransPara = new r(Integer.valueOf(paramdji.aixb), Float.valueOf(0.0F));
        AppMethodBeat.o(343180);
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
        AppMethodBeat.o(343180);
      }
      localObject6 = ((dju)localObject4).aaPK;
      if (localObject6 == null) {
        break;
      }
      localObject7 = ((byz)localObject6).aaib;
      if (localObject7 == null) {
        break;
      }
      localObject6 = new Matrix();
      ((Matrix)localObject6).setValues(p.H((Collection)localObject7));
      localObject7 = ah.aiuX;
      d2 = t.g((Matrix)localObject6);
      d1 = d2;
      if (d2 <= 0.0D) {
        d1 = 1.0D;
      }
      localObject6 = av.GiL;
      k = av.TM((int)Math.floor((((fyb)localObject5).top - ((fyb)localObject5).bottom) / d1));
      localObject6 = av.GiL;
      m = av.TM((int)Math.floor((((fyb)localObject5).right - ((fyb)localObject5).left) / d1));
      n = (int)Math.floor(((fyb)localObject5).left / d1);
      i1 = (int)Math.floor(((fyb)localObject5).bottom / d1);
      ((Rect)localObject2).set(n, i1, n + m, k + i1);
      localObject5 = ah.aiuX;
      localObject5 = ah.aiuX;
      break;
      localObject5 = av.GiL;
      k = av.TM(((dju)localObject4).width);
      break label499;
      localObject5 = av.GiL;
      k = av.TM(((dju)localObject4).height);
      break label518;
    }
  }
  
  private void a(VideoTransPara paramVideoTransPara, dji paramdji1, String paramString, dji paramdji2, int paramInt, FinderMediaReportObject paramFinderMediaReportObject, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(343208);
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
      AppMethodBeat.o(343208);
      return;
      j = 0;
      break;
      f1 = paramdji2.width / ((afc)localObject).HJN;
      f2 = paramdji2.height / ((afc)localObject).HJO;
      paramFinderMediaReportObject = new Rect((int)(paramFinderMediaReportObject.left * f1), (int)(paramFinderMediaReportObject.top * f2), (int)(f1 * paramFinderMediaReportObject.right), (int)(paramFinderMediaReportObject.bottom * f2));
    }
  }
  
  /* Error */
  private final com.tencent.mm.plugin.finder.upload.postlogic.base.e fex()
  {
    // Byte code:
    //   0: ldc_w 816
    //   3: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   10: ldc_w 818
    //   13: invokevirtual 823	com/tencent/mm/plugin/finder/storage/FinderItem:trackDraftPost	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   20: getfield 827	com/tencent/mm/plugin/finder/storage/FinderItem:field_reportObject	Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;
    //   23: astore 20
    //   25: aload 20
    //   27: ifnull +9 -> 36
    //   30: aload 20
    //   32: iconst_2
    //   33: putfield 832	com/tencent/mm/protocal/protobuf/FinderFeedReportObject:postStage	I
    //   36: new 834	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 835	java/util/ArrayList:<init>	()V
    //   43: checkcast 837	java/util/List
    //   46: astore 23
    //   48: new 834	java/util/ArrayList
    //   51: dup
    //   52: invokespecial 835	java/util/ArrayList:<init>	()V
    //   55: checkcast 837	java/util/List
    //   58: astore 24
    //   60: aload_0
    //   61: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   64: invokevirtual 841	com/tencent/mm/plugin/finder/storage/FinderItem:getHalfVideoMediaExtList	()Ljava/util/LinkedList;
    //   67: checkcast 843	java/lang/Iterable
    //   70: invokeinterface 847 1 0
    //   75: astore 20
    //   77: aload 20
    //   79: invokeinterface 852 1 0
    //   84: ifeq +63 -> 147
    //   87: aload 20
    //   89: invokeinterface 856 1 0
    //   94: checkcast 172	com/tencent/mm/protocal/protobuf/dji
    //   97: astore 21
    //   99: aload 21
    //   101: getfield 176	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   104: astore 22
    //   106: aload 22
    //   108: ifnull +33 -> 141
    //   111: aload 22
    //   113: getfield 701	com/tencent/mm/protocal/protobuf/afb:Znj	Z
    //   116: iconst_1
    //   117: if_icmpne +24 -> 141
    //   120: iconst_1
    //   121: istore 7
    //   123: iload 7
    //   125: ifeq -48 -> 77
    //   128: aload 23
    //   130: aload 21
    //   132: invokeinterface 860 2 0
    //   137: pop
    //   138: goto -61 -> 77
    //   141: iconst_0
    //   142: istore 7
    //   144: goto -21 -> 123
    //   147: aload_0
    //   148: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   151: invokevirtual 863	com/tencent/mm/plugin/finder/storage/FinderItem:getMediaList	()Ljava/util/LinkedList;
    //   154: checkcast 843	java/lang/Iterable
    //   157: astore 20
    //   159: iconst_0
    //   160: istore 7
    //   162: aload 20
    //   164: invokeinterface 847 1 0
    //   169: astore 20
    //   171: aload 20
    //   173: invokeinterface 852 1 0
    //   178: ifeq +115 -> 293
    //   181: aload 20
    //   183: invokeinterface 856 1 0
    //   188: astore 21
    //   190: iload 7
    //   192: iconst_1
    //   193: iadd
    //   194: istore 8
    //   196: iload 7
    //   198: ifge +6 -> 204
    //   201: invokestatic 866	kotlin/a/p:kkW	()V
    //   204: aload 21
    //   206: checkcast 172	com/tencent/mm/protocal/protobuf/dji
    //   209: astore 21
    //   211: aload_0
    //   212: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   215: iload 7
    //   217: invokevirtual 870	com/tencent/mm/plugin/finder/storage/FinderItem:isNeedCrop	(I)Z
    //   220: ifeq +32 -> 252
    //   223: aload_0
    //   224: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   227: iload 7
    //   229: invokevirtual 874	com/tencent/mm/plugin/finder/storage/FinderItem:getCropInfo	(I)Lcom/tencent/mm/protocal/protobuf/dji;
    //   232: ifnull +13 -> 245
    //   235: aload 23
    //   237: aload 21
    //   239: invokeinterface 860 2 0
    //   244: pop
    //   245: iload 8
    //   247: istore 7
    //   249: goto -78 -> 171
    //   252: aload_0
    //   253: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   256: iload 7
    //   258: invokevirtual 877	com/tencent/mm/plugin/finder/storage/FinderItem:isNeedVideoCompositionPlay	(I)Z
    //   261: ifeq +25 -> 286
    //   264: aload_0
    //   265: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   268: iload 7
    //   270: invokevirtual 874	com/tencent/mm/plugin/finder/storage/FinderItem:getCropInfo	(I)Lcom/tencent/mm/protocal/protobuf/dji;
    //   273: ifnull +13 -> 286
    //   276: aload 23
    //   278: aload 21
    //   280: invokeinterface 860 2 0
    //   285: pop
    //   286: iload 8
    //   288: istore 7
    //   290: goto -119 -> 171
    //   293: aload_0
    //   294: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   297: invokevirtual 880	com/tencent/mm/plugin/finder/storage/FinderItem:getLongVideoMediaExtList	()Ljava/util/LinkedList;
    //   300: invokevirtual 813	java/util/LinkedList:size	()I
    //   303: ifle +10 -> 313
    //   306: aload 23
    //   308: invokeinterface 883 1 0
    //   313: aload_0
    //   314: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   317: invokevirtual 880	com/tencent/mm/plugin/finder/storage/FinderItem:getLongVideoMediaExtList	()Ljava/util/LinkedList;
    //   320: checkcast 843	java/lang/Iterable
    //   323: astore 20
    //   325: iconst_0
    //   326: istore 7
    //   328: aload 20
    //   330: invokeinterface 847 1 0
    //   335: astore 20
    //   337: aload 20
    //   339: invokeinterface 852 1 0
    //   344: ifeq +72 -> 416
    //   347: aload 20
    //   349: invokeinterface 856 1 0
    //   354: astore 21
    //   356: iload 7
    //   358: ifge +6 -> 364
    //   361: invokestatic 866	kotlin/a/p:kkW	()V
    //   364: aload 21
    //   366: checkcast 172	com/tencent/mm/protocal/protobuf/dji
    //   369: astore 21
    //   371: aload 21
    //   373: getfield 673	com/tencent/mm/protocal/protobuf/dji:aaPf	Z
    //   376: ifeq +31 -> 407
    //   379: aload 21
    //   381: getfield 219	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   384: ifnull +23 -> 407
    //   387: aload 23
    //   389: aload 21
    //   391: invokeinterface 860 2 0
    //   396: pop
    //   397: aload 24
    //   399: aload 21
    //   401: invokeinterface 860 2 0
    //   406: pop
    //   407: iload 7
    //   409: iconst_1
    //   410: iadd
    //   411: istore 7
    //   413: goto -76 -> 337
    //   416: getstatic 231	com/tencent/mm/plugin/finder/storage/d:FAy	Lcom/tencent/mm/plugin/finder/storage/d;
    //   419: astore 20
    //   421: invokestatic 886	com/tencent/mm/plugin/finder/storage/d:eQH	()Z
    //   424: ifeq +25 -> 449
    //   427: invokestatic 889	com/tencent/mm/sdk/platformtools/Log:getLogLevel	()I
    //   430: iflt +19 -> 449
    //   433: aload_0
    //   434: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   437: ldc_w 891
    //   440: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: ldc2_w 892
    //   446: invokestatic 898	java/lang/Thread:sleep	(J)V
    //   449: getstatic 231	com/tencent/mm/plugin/finder/storage/d:FAy	Lcom/tencent/mm/plugin/finder/storage/d;
    //   452: astore 20
    //   454: invokestatic 902	com/tencent/mm/plugin/finder/storage/d:eQB	()Lcom/tencent/mm/plugin/findersdk/storage/config/base/b;
    //   457: invokevirtual 907	com/tencent/mm/plugin/findersdk/storage/config/base/b:bmg	()Ljava/lang/Object;
    //   460: checkcast 909	java/lang/Number
    //   463: invokevirtual 912	java/lang/Number:intValue	()I
    //   466: iconst_1
    //   467: if_icmpne +40 -> 507
    //   470: aload_0
    //   471: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   474: astore 20
    //   476: getstatic 918	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:GdZ	Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/c$a;
    //   479: astore 21
    //   481: new 914	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c
    //   484: dup
    //   485: aload 20
    //   487: invokestatic 921	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:fev	()I
    //   490: invokespecial 924	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:<init>	(Lcom/tencent/mm/plugin/finder/storage/i;I)V
    //   493: checkcast 926	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   496: astore 20
    //   498: ldc_w 816
    //   501: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   504: aload 20
    //   506: areturn
    //   507: aload 23
    //   509: invokeinterface 927 1 0
    //   514: ifgt +43 -> 557
    //   517: aload_0
    //   518: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   521: ldc_w 929
    //   524: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: aload_0
    //   528: fconst_1
    //   529: invokevirtual 933	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:cn	(F)V
    //   532: new 935	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/g
    //   535: dup
    //   536: aload_0
    //   537: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   540: invokespecial 937	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/g:<init>	(Lcom/tencent/mm/plugin/finder/storage/i;)V
    //   543: checkcast 926	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   546: astore 20
    //   548: ldc_w 816
    //   551: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   554: aload 20
    //   556: areturn
    //   557: aload_0
    //   558: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   561: ldc_w 939
    //   564: aload 23
    //   566: invokeinterface 927 1 0
    //   571: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   574: invokestatic 165	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   577: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   580: getstatic 945	com/tencent/mm/plugin/finder/report/i$c:FoQ	Lcom/tencent/mm/plugin/finder/report/i$c;
    //   583: astore 20
    //   585: aload_0
    //   586: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   589: invokevirtual 947	com/tencent/mm/plugin/finder/storage/FinderItem:isLongVideo	()Z
    //   592: invokestatic 950	com/tencent/mm/plugin/finder/report/i$c:tE	(Z)V
    //   595: aload 23
    //   597: checkcast 843	java/lang/Iterable
    //   600: astore 20
    //   602: iconst_0
    //   603: istore 8
    //   605: aload 20
    //   607: invokeinterface 847 1 0
    //   612: astore 25
    //   614: aload 25
    //   616: invokeinterface 852 1 0
    //   621: ifeq +3860 -> 4481
    //   624: aload 25
    //   626: invokeinterface 856 1 0
    //   631: astore 20
    //   633: iload 8
    //   635: ifge +6 -> 641
    //   638: invokestatic 866	kotlin/a/p:kkW	()V
    //   641: aload 20
    //   643: checkcast 172	com/tencent/mm/protocal/protobuf/dji
    //   646: astore 26
    //   648: aload 26
    //   650: getfield 219	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   653: astore 20
    //   655: aload 20
    //   657: ifnonnull +56 -> 713
    //   660: iconst_0
    //   661: istore 7
    //   663: getstatic 231	com/tencent/mm/plugin/finder/storage/d:FAy	Lcom/tencent/mm/plugin/finder/storage/d;
    //   666: astore 20
    //   668: iload 7
    //   670: invokestatic 953	com/tencent/mm/plugin/finder/storage/d:eQD	()I
    //   673: if_icmple +50 -> 723
    //   676: aload_0
    //   677: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   680: astore 20
    //   682: getstatic 918	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:GdZ	Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/c$a;
    //   685: astore 21
    //   687: new 914	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c
    //   690: dup
    //   691: aload 20
    //   693: invokestatic 921	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:fev	()I
    //   696: invokespecial 924	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:<init>	(Lcom/tencent/mm/plugin/finder/storage/i;I)V
    //   699: checkcast 926	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   702: astore 20
    //   704: ldc_w 816
    //   707: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   710: aload 20
    //   712: areturn
    //   713: aload 20
    //   715: getfield 308	com/tencent/mm/protocal/protobuf/dju:retryCount	I
    //   718: istore 7
    //   720: goto -57 -> 663
    //   723: aload 24
    //   725: invokeinterface 954 1 0
    //   730: astore 20
    //   732: iconst_0
    //   733: istore 7
    //   735: aload 20
    //   737: invokeinterface 852 1 0
    //   742: ifeq +464 -> 1206
    //   745: aload 20
    //   747: invokeinterface 856 1 0
    //   752: checkcast 172	com/tencent/mm/protocal/protobuf/dji
    //   755: getfield 681	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   758: aload 26
    //   760: getfield 681	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   763: invokestatic 958	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   766: ifeq +431 -> 1197
    //   769: iload 7
    //   771: iflt +441 -> 1212
    //   774: iconst_1
    //   775: istore 12
    //   777: iload 12
    //   779: ifne +445 -> 1224
    //   782: aload 24
    //   784: checkcast 528	java/util/Collection
    //   787: invokeinterface 961 1 0
    //   792: ifne +426 -> 1218
    //   795: iconst_1
    //   796: istore 7
    //   798: iload 7
    //   800: ifeq +424 -> 1224
    //   803: iconst_1
    //   804: istore 9
    //   806: iload 12
    //   808: ifeq +422 -> 1230
    //   811: getstatic 967	com/tencent/mm/plugin/finder/ui/config/a:FWH	Lcom/tencent/mm/plugin/finder/ui/config/a;
    //   814: astore 20
    //   816: invokestatic 971	com/tencent/mm/plugin/finder/ui/config/a:fcM	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   819: astore 21
    //   821: aload_0
    //   822: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   825: new 273	java/lang/StringBuilder
    //   828: dup
    //   829: ldc_w 973
    //   832: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   835: iload 8
    //   837: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   840: ldc_w 975
    //   843: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: iload 12
    //   848: invokevirtual 744	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   851: ldc_w 977
    //   854: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload 21
    //   859: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   862: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   868: aload 26
    //   870: getfield 219	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   873: astore 20
    //   875: aload 20
    //   877: ifnull +27 -> 904
    //   880: aload 26
    //   882: getfield 219	com/tencent/mm/protocal/protobuf/dji:EDC	Lcom/tencent/mm/protocal/protobuf/dju;
    //   885: astore 22
    //   887: aload 22
    //   889: ifnonnull +354 -> 1243
    //   892: iconst_0
    //   893: istore 7
    //   895: aload 20
    //   897: iload 7
    //   899: iconst_1
    //   900: iadd
    //   901: putfield 308	com/tencent/mm/protocal/protobuf/dju:retryCount	I
    //   904: iload 12
    //   906: ifeq +24 -> 930
    //   909: aload_0
    //   910: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   913: getfield 827	com/tencent/mm/plugin/finder/storage/FinderItem:field_reportObject	Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;
    //   916: astore 20
    //   918: aload 20
    //   920: ifnull +10 -> 930
    //   923: aload 20
    //   925: bipush 6
    //   927: putfield 832	com/tencent/mm/protocal/protobuf/FinderFeedReportObject:postStage	I
    //   930: getstatic 983	com/tencent/mm/plugin/finder/storage/logic/c:FNC	Lcom/tencent/mm/plugin/finder/storage/logic/c;
    //   933: astore 20
    //   935: aload_0
    //   936: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   939: invokestatic 986	com/tencent/mm/plugin/finder/storage/logic/c:g	(Lcom/tencent/mm/plugin/finder/storage/i;)Z
    //   942: pop
    //   943: new 403	com/tencent/mm/protocal/protobuf/FinderMediaReportObject
    //   946: dup
    //   947: invokespecial 987	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:<init>	()V
    //   950: astore 27
    //   952: aload 27
    //   954: aload 26
    //   956: getfield 990	com/tencent/mm/protocal/protobuf/dji:mediaType	I
    //   959: putfield 991	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:mediaType	I
    //   962: aload 27
    //   964: new 413	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo
    //   967: dup
    //   968: invokespecial 691	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:<init>	()V
    //   971: putfield 407	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:origin	Lcom/tencent/mm/protocal/protobuf/FinderMediaReportInfo;
    //   974: aload 27
    //   976: new 811	java/util/LinkedList
    //   979: dup
    //   980: invokespecial 992	java/util/LinkedList:<init>	()V
    //   983: putfield 995	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:multiMediaInfo	Ljava/util/LinkedList;
    //   986: aload 26
    //   988: getfield 176	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   991: astore 20
    //   993: aload 20
    //   995: ifnull +263 -> 1258
    //   998: aload 20
    //   1000: getfield 998	com/tencent/mm/protocal/protobuf/afb:Zng	Ljava/util/LinkedList;
    //   1003: astore 20
    //   1005: aload 20
    //   1007: ifnull +251 -> 1258
    //   1010: aload 20
    //   1012: checkcast 843	java/lang/Iterable
    //   1015: invokeinterface 847 1 0
    //   1020: astore 20
    //   1022: aload 20
    //   1024: invokeinterface 852 1 0
    //   1029: ifeq +224 -> 1253
    //   1032: aload 20
    //   1034: invokeinterface 856 1 0
    //   1039: checkcast 1000	com/tencent/mm/protocal/protobuf/fos
    //   1042: astore 29
    //   1044: new 413	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo
    //   1047: dup
    //   1048: invokespecial 691	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:<init>	()V
    //   1051: astore 22
    //   1053: aload 22
    //   1055: aload 29
    //   1057: getfield 1002	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   1060: invokestatic 687	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   1063: l2i
    //   1064: putfield 695	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:fileSize	I
    //   1067: getstatic 342	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:ObB	Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker;
    //   1070: astore 28
    //   1072: aload 29
    //   1074: getfield 1002	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   1077: astore 29
    //   1079: aload 29
    //   1081: ldc_w 1004
    //   1084: invokestatic 1006	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1087: aload 28
    //   1089: aload 29
    //   1091: invokevirtual 751	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:aTG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a;
    //   1094: astore 28
    //   1096: aload 28
    //   1098: ifnull +85 -> 1183
    //   1101: aload 22
    //   1103: aload 28
    //   1105: getfield 377	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   1108: putfield 417	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:width	I
    //   1111: aload 22
    //   1113: aload 28
    //   1115: getfield 380	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   1118: putfield 418	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:height	I
    //   1121: aload 22
    //   1123: aload 28
    //   1125: getfield 421	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:bitrate	I
    //   1128: putfield 424	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:videoBitrate	I
    //   1131: aload 22
    //   1133: aload 28
    //   1135: getfield 411	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:duration	J
    //   1138: l2i
    //   1139: putfield 416	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:videoDuration	I
    //   1142: aload 22
    //   1144: aload 28
    //   1146: getfield 427	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:audioBitrate	I
    //   1149: putfield 428	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:audioBitrate	I
    //   1152: aload 22
    //   1154: aload 28
    //   1156: getfield 432	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:eGw	F
    //   1159: f2i
    //   1160: putfield 435	com/tencent/mm/protocal/protobuf/FinderMediaReportInfo:fps	I
    //   1163: aload_0
    //   1164: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   1167: ldc_w 1008
    //   1170: aload 28
    //   1172: invokestatic 165	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1175: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1178: getstatic 295	kotlin/ah:aiuX	Lkotlin/ah;
    //   1181: astore 28
    //   1183: aload 27
    //   1185: getfield 995	com/tencent/mm/protocal/protobuf/FinderMediaReportObject:multiMediaInfo	Ljava/util/LinkedList;
    //   1188: aload 22
    //   1190: invokevirtual 1009	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   1193: pop
    //   1194: goto -172 -> 1022
    //   1197: iload 7
    //   1199: iconst_1
    //   1200: iadd
    //   1201: istore 7
    //   1203: goto -468 -> 735
    //   1206: iconst_m1
    //   1207: istore 7
    //   1209: goto -440 -> 769
    //   1212: iconst_0
    //   1213: istore 12
    //   1215: goto -438 -> 777
    //   1218: iconst_0
    //   1219: istore 7
    //   1221: goto -423 -> 798
    //   1224: iconst_0
    //   1225: istore 9
    //   1227: goto -421 -> 806
    //   1230: getstatic 231	com/tencent/mm/plugin/finder/storage/d:FAy	Lcom/tencent/mm/plugin/finder/storage/d;
    //   1233: astore 20
    //   1235: invokestatic 1012	com/tencent/mm/plugin/finder/storage/d:ePV	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   1238: astore 21
    //   1240: goto -419 -> 821
    //   1243: aload 22
    //   1245: getfield 308	com/tencent/mm/protocal/protobuf/dju:retryCount	I
    //   1248: istore 7
    //   1250: goto -355 -> 895
    //   1253: getstatic 295	kotlin/ah:aiuX	Lkotlin/ah;
    //   1256: astore 20
    //   1258: invokestatic 1018	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   1261: invokevirtual 1019	java/util/UUID:toString	()Ljava/lang/String;
    //   1264: astore 29
    //   1266: aload 29
    //   1268: ldc_w 1021
    //   1271: invokestatic 1006	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1274: getstatic 1027	com/tencent/mm/plugin/vlog/report/c:UeI	Lcom/tencent/mm/plugin/vlog/report/c;
    //   1277: astore 20
    //   1279: aload 29
    //   1281: invokestatic 1031	com/tencent/mm/plugin/vlog/report/c:bfn	(Ljava/lang/String;)Lcom/tencent/mm/autogen/mmdata/rpt/qn;
    //   1284: pop
    //   1285: invokestatic 1034	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   1288: lstore 18
    //   1290: new 1036	com/tencent/mm/plugin/finder/loader/v
    //   1293: dup
    //   1294: aload 26
    //   1296: getstatic 1042	com/tencent/mm/plugin/finder/storage/v:FLB	Lcom/tencent/mm/plugin/finder/storage/v;
    //   1299: iconst_0
    //   1300: aconst_null
    //   1301: bipush 12
    //   1303: invokespecial 1045	com/tencent/mm/plugin/finder/loader/v:<init>	(Lcom/tencent/mm/protocal/protobuf/dji;Lcom/tencent/mm/plugin/finder/storage/v;ILjava/lang/String;I)V
    //   1306: astore 22
    //   1308: getstatic 657	com/tencent/mm/plugin/finder/utils/bm:GlZ	Lcom/tencent/mm/plugin/finder/utils/bm;
    //   1311: astore 20
    //   1313: new 273	java/lang/StringBuilder
    //   1316: dup
    //   1317: invokespecial 1046	java/lang/StringBuilder:<init>	()V
    //   1320: aload_0
    //   1321: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   1324: invokevirtual 1049	com/tencent/mm/plugin/finder/storage/FinderItem:getCreateTime	()J
    //   1327: invokevirtual 1052	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1330: astore 28
    //   1332: aload 26
    //   1334: getfield 615	com/tencent/mm/protocal/protobuf/dji:aaPp	Z
    //   1337: ifeq +1425 -> 2762
    //   1340: ldc_w 1054
    //   1343: astore 20
    //   1345: aload 22
    //   1347: aload 28
    //   1349: aload 20
    //   1351: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1357: invokestatic 1057	com/tencent/mm/plugin/finder/utils/bm:a	(Lcom/tencent/mm/plugin/finder/loader/v;Ljava/lang/String;)Ljava/lang/String;
    //   1360: astore 28
    //   1362: ldc_w 1059
    //   1365: invokestatic 1065	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1368: checkcast 1059	com/tencent/mm/plugin/expt/b/c
    //   1371: getstatic 1071	com/tencent/mm/plugin/expt/b/c$a:zpY	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   1374: iconst_1
    //   1375: invokeinterface 1074 3 0
    //   1380: istore 10
    //   1382: aload 26
    //   1384: getfield 176	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1387: astore 20
    //   1389: aload 20
    //   1391: ifnonnull +1379 -> 2770
    //   1394: aconst_null
    //   1395: astore 20
    //   1397: aload 26
    //   1399: getfield 176	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1402: astore 22
    //   1404: aload 22
    //   1406: ifnull +1398 -> 2804
    //   1409: aload 22
    //   1411: getfield 998	com/tencent/mm/protocal/protobuf/afb:Zng	Ljava/util/LinkedList;
    //   1414: astore 22
    //   1416: aload 22
    //   1418: ifnull +1386 -> 2804
    //   1421: aload 22
    //   1423: invokevirtual 813	java/util/LinkedList:size	()I
    //   1426: iconst_1
    //   1427: if_icmpne +1377 -> 2804
    //   1430: iconst_1
    //   1431: istore 7
    //   1433: iload 7
    //   1435: ifeq +1453 -> 2888
    //   1438: aload 26
    //   1440: getfield 176	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1443: astore 22
    //   1445: aload 22
    //   1447: ifnonnull +1363 -> 2810
    //   1450: iconst_0
    //   1451: istore 7
    //   1453: iload 7
    //   1455: ifne +1433 -> 2888
    //   1458: aload 26
    //   1460: getfield 176	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1463: astore 22
    //   1465: aload 22
    //   1467: ifnull +1389 -> 2856
    //   1470: aload 22
    //   1472: getfield 1077	com/tencent/mm/protocal/protobuf/afb:Uay	Z
    //   1475: ifne +1381 -> 2856
    //   1478: iconst_1
    //   1479: istore 7
    //   1481: iload 7
    //   1483: ifeq +1405 -> 2888
    //   1486: aload 26
    //   1488: getfield 176	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1491: astore 22
    //   1493: aload 22
    //   1495: ifnonnull +1367 -> 2862
    //   1498: aconst_null
    //   1499: astore 22
    //   1501: aload 22
    //   1503: ifnonnull +1385 -> 2888
    //   1506: aload 20
    //   1508: ifnull +1380 -> 2888
    //   1511: aload 20
    //   1513: getfield 1081	com/tencent/mm/protocal/protobuf/fos:abPa	Lcom/tencent/mm/protocal/protobuf/fqf;
    //   1516: ifnull +48 -> 1564
    //   1519: aload 20
    //   1521: getfield 1081	com/tencent/mm/protocal/protobuf/fos:abPa	Lcom/tencent/mm/protocal/protobuf/fqf;
    //   1524: astore 22
    //   1526: aload 22
    //   1528: ifnonnull +1344 -> 2872
    //   1531: aconst_null
    //   1532: astore 22
    //   1534: aload 22
    //   1536: checkcast 1083	java/lang/CharSequence
    //   1539: astore 22
    //   1541: aload 22
    //   1543: ifnull +13 -> 1556
    //   1546: aload 22
    //   1548: invokeinterface 1086 1 0
    //   1553: ifne +1329 -> 2882
    //   1556: iconst_1
    //   1557: istore 7
    //   1559: iload 7
    //   1561: ifeq +1327 -> 2888
    //   1564: aload 20
    //   1566: getfield 1089	com/tencent/mm/protocal/protobuf/fos:endTimeMs	J
    //   1569: aload 20
    //   1571: getfield 1092	com/tencent/mm/protocal/protobuf/fos:startTimeMs	J
    //   1574: lsub
    //   1575: aload 20
    //   1577: getfield 1095	com/tencent/mm/protocal/protobuf/fos:TDx	J
    //   1580: aload 20
    //   1582: getfield 1098	com/tencent/mm/protocal/protobuf/fos:TDw	J
    //   1585: lsub
    //   1586: lcmp
    //   1587: ifne +1301 -> 2888
    //   1590: iconst_1
    //   1591: istore 13
    //   1593: aload_0
    //   1594: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   1597: astore 22
    //   1599: new 273	java/lang/StringBuilder
    //   1602: dup
    //   1603: ldc_w 1100
    //   1606: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1609: iload 10
    //   1611: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1614: ldc_w 1102
    //   1617: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: astore 30
    //   1622: aload 26
    //   1624: getfield 176	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1627: astore 20
    //   1629: aload 20
    //   1631: ifnonnull +1263 -> 2894
    //   1634: aconst_null
    //   1635: astore 20
    //   1637: aload 30
    //   1639: aload 20
    //   1641: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1644: ldc_w 1104
    //   1647: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1650: astore 30
    //   1652: aload 26
    //   1654: getfield 176	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1657: astore 20
    //   1659: aload 20
    //   1661: ifnonnull +1264 -> 2925
    //   1664: aconst_null
    //   1665: astore 20
    //   1667: aload 22
    //   1669: aload 30
    //   1671: aload 20
    //   1673: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1676: ldc_w 1106
    //   1679: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: iload 13
    //   1684: invokevirtual 744	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1687: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1690: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1693: ldc_w 1059
    //   1696: invokestatic 1065	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1699: checkcast 1059	com/tencent/mm/plugin/expt/b/c
    //   1702: getstatic 1109	com/tencent/mm/plugin/expt/b/c$a:zjq	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   1705: iconst_0
    //   1706: invokeinterface 1074 3 0
    //   1711: iconst_1
    //   1712: if_icmpne +2913 -> 4625
    //   1715: iconst_1
    //   1716: istore 14
    //   1718: aload 21
    //   1720: getfield 1110	com/tencent/mm/modelcontrol/VideoTransPara:audioBitrate	I
    //   1723: i2f
    //   1724: ldc_w 752
    //   1727: fdiv
    //   1728: fstore 5
    //   1730: aload 21
    //   1732: getfield 1113	com/tencent/mm/modelcontrol/VideoTransPara:audioSampleRate	I
    //   1735: i2f
    //   1736: fstore 6
    //   1738: aload 21
    //   1740: getfield 1116	com/tencent/mm/modelcontrol/VideoTransPara:audioChannelCount	I
    //   1743: istore 11
    //   1745: aload 26
    //   1747: getfield 176	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1750: astore 20
    //   1752: aload 20
    //   1754: ifnonnull +1220 -> 2974
    //   1757: iconst_1
    //   1758: istore 15
    //   1760: iload 10
    //   1762: iconst_1
    //   1763: if_icmpne +1321 -> 3084
    //   1766: iload 13
    //   1768: ifeq +1316 -> 3084
    //   1771: aload 26
    //   1773: getfield 176	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   1776: astore 20
    //   1778: aload 20
    //   1780: ifnonnull +1204 -> 2984
    //   1783: aconst_null
    //   1784: astore 20
    //   1786: aload 20
    //   1788: ifnonnull +1228 -> 3016
    //   1791: new 1000	com/tencent/mm/protocal/protobuf/fos
    //   1794: dup
    //   1795: invokespecial 1117	com/tencent/mm/protocal/protobuf/fos:<init>	()V
    //   1798: astore 20
    //   1800: aload 20
    //   1802: getfield 1002	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   1805: astore 22
    //   1807: aload 22
    //   1809: ldc_w 1004
    //   1812: invokestatic 1006	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1815: getstatic 342	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:ObB	Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker;
    //   1818: aload 22
    //   1820: invokevirtual 751	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:aTG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a;
    //   1823: astore 22
    //   1825: aload 22
    //   1827: ifnull +1212 -> 3039
    //   1830: aload 22
    //   1832: getfield 383	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:hYK	I
    //   1835: bipush 90
    //   1837: if_icmpeq +14 -> 1851
    //   1840: aload 22
    //   1842: getfield 383	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:hYK	I
    //   1845: sipush 270
    //   1848: if_icmpne +1171 -> 3019
    //   1851: aload 22
    //   1853: getfield 380	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   1856: istore 7
    //   1858: iload 7
    //   1860: i2d
    //   1861: dstore_1
    //   1862: aload 22
    //   1864: getfield 383	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:hYK	I
    //   1867: bipush 90
    //   1869: if_icmpeq +14 -> 1883
    //   1872: aload 22
    //   1874: getfield 383	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:hYK	I
    //   1877: sipush 270
    //   1880: if_icmpne +1149 -> 3029
    //   1883: aload 22
    //   1885: getfield 377	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   1888: istore 7
    //   1890: dconst_1
    //   1891: dload_1
    //   1892: dmul
    //   1893: iload 7
    //   1895: i2d
    //   1896: ddiv
    //   1897: dstore_1
    //   1898: aload_0
    //   1899: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   1902: new 273	java/lang/StringBuilder
    //   1905: dup
    //   1906: ldc_w 1119
    //   1909: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1912: aload 22
    //   1914: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1917: ldc_w 1121
    //   1920: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: aload 21
    //   1925: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1928: ldc_w 1123
    //   1931: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1934: dload_1
    //   1935: invokevirtual 1126	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1938: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1941: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1944: aload_0
    //   1945: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   1948: astore 30
    //   1950: new 273	java/lang/StringBuilder
    //   1953: dup
    //   1954: ldc_w 1128
    //   1957: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1960: astore 31
    //   1962: getstatic 231	com/tencent/mm/plugin/finder/storage/d:FAy	Lcom/tencent/mm/plugin/finder/storage/d;
    //   1965: astore 32
    //   1967: aload 31
    //   1969: invokestatic 1132	com/tencent/mm/plugin/finder/storage/d:eRR	()Lkotlin/k/c;
    //   1972: dload_1
    //   1973: invokestatic 1137	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1976: checkcast 1139	java/lang/Comparable
    //   1979: invokeinterface 1144 2 0
    //   1984: invokevirtual 744	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1987: ldc_w 1146
    //   1990: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1993: astore 31
    //   1995: getstatic 231	com/tencent/mm/plugin/finder/storage/d:FAy	Lcom/tencent/mm/plugin/finder/storage/d;
    //   1998: astore 32
    //   2000: aload 30
    //   2002: aload 31
    //   2004: invokestatic 1132	com/tencent/mm/plugin/finder/storage/d:eRR	()Lkotlin/k/c;
    //   2007: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2010: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2013: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2016: aload 22
    //   2018: getfield 1149	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:Lam	Z
    //   2021: ifne +1018 -> 3039
    //   2024: aload 22
    //   2026: getfield 421	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:bitrate	I
    //   2029: aload 21
    //   2031: getfield 1150	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   2034: if_icmpgt +1005 -> 3039
    //   2037: aload 22
    //   2039: getfield 432	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:eGw	F
    //   2042: aload 21
    //   2044: getfield 1151	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   2047: i2f
    //   2048: fcmpg
    //   2049: ifgt +990 -> 3039
    //   2052: getstatic 231	com/tencent/mm/plugin/finder/storage/d:FAy	Lcom/tencent/mm/plugin/finder/storage/d;
    //   2055: astore 22
    //   2057: invokestatic 1132	com/tencent/mm/plugin/finder/storage/d:eRR	()Lkotlin/k/c;
    //   2060: dload_1
    //   2061: invokestatic 1137	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   2064: checkcast 1139	java/lang/Comparable
    //   2067: invokeinterface 1144 2 0
    //   2072: ifeq +967 -> 3039
    //   2075: iconst_1
    //   2076: istore 16
    //   2078: aload 26
    //   2080: getfield 176	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   2083: astore 22
    //   2085: aload 22
    //   2087: ifnonnull +958 -> 3045
    //   2090: aconst_null
    //   2091: astore 22
    //   2093: aload 22
    //   2095: invokestatic 1155	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   2098: istore 17
    //   2100: aload_0
    //   2101: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   2104: new 273	java/lang/StringBuilder
    //   2107: dup
    //   2108: ldc_w 1157
    //   2111: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2114: iload 16
    //   2116: invokevirtual 744	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2119: ldc_w 1159
    //   2122: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2125: iload 17
    //   2127: invokevirtual 744	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2130: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2133: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2136: iload 16
    //   2138: ifeq +946 -> 3084
    //   2141: iload 17
    //   2143: ifeq +941 -> 3084
    //   2146: new 335	android/graphics/Rect
    //   2149: dup
    //   2150: invokespecial 336	android/graphics/Rect:<init>	()V
    //   2153: astore 22
    //   2155: new 335	android/graphics/Rect
    //   2158: dup
    //   2159: invokespecial 336	android/graphics/Rect:<init>	()V
    //   2162: astore 30
    //   2164: aload 20
    //   2166: getfield 1163	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   2169: getfield 1166	com/tencent/mm/protocal/protobuf/ahj:Zqq	Lcom/tencent/mm/protocal/protobuf/enx;
    //   2172: aload 22
    //   2174: invokestatic 634	com/tencent/mm/plugin/vlog/model/h:a	(Lcom/tencent/mm/protocal/protobuf/enx;Landroid/graphics/Rect;)V
    //   2177: aload 20
    //   2179: getfield 1163	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   2182: getfield 1169	com/tencent/mm/protocal/protobuf/ahj:Zqs	Lcom/tencent/mm/protocal/protobuf/enx;
    //   2185: aload 30
    //   2187: invokestatic 634	com/tencent/mm/plugin/vlog/model/h:a	(Lcom/tencent/mm/protocal/protobuf/enx;Landroid/graphics/Rect;)V
    //   2190: aload_0
    //   2191: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   2194: new 273	java/lang/StringBuilder
    //   2197: dup
    //   2198: ldc_w 1171
    //   2201: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2204: aload 22
    //   2206: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2209: ldc_w 1173
    //   2212: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2215: aload 30
    //   2217: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2220: ldc_w 1175
    //   2223: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2226: aload 20
    //   2228: getfield 1098	com/tencent/mm/protocal/protobuf/fos:TDw	J
    //   2231: invokevirtual 1052	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2234: ldc_w 282
    //   2237: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2240: aload 20
    //   2242: getfield 1095	com/tencent/mm/protocal/protobuf/fos:TDx	J
    //   2245: invokevirtual 1052	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2248: ldc_w 282
    //   2251: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2254: aload 20
    //   2256: getfield 1178	com/tencent/mm/protocal/protobuf/fos:UjZ	J
    //   2259: invokevirtual 1052	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2262: bipush 93
    //   2264: invokevirtual 1181	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2267: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2270: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2273: aload 20
    //   2275: getfield 1098	com/tencent/mm/protocal/protobuf/fos:TDw	J
    //   2278: lconst_0
    //   2279: lcmp
    //   2280: ifne +804 -> 3084
    //   2283: aload 20
    //   2285: getfield 1178	com/tencent/mm/protocal/protobuf/fos:UjZ	J
    //   2288: aload 20
    //   2290: getfield 1095	com/tencent/mm/protocal/protobuf/fos:TDx	J
    //   2293: lsub
    //   2294: ldc2_w 1182
    //   2297: lcmp
    //   2298: ifgt +786 -> 3084
    //   2301: aload 20
    //   2303: getfield 1178	com/tencent/mm/protocal/protobuf/fos:UjZ	J
    //   2306: aload 21
    //   2308: getfield 1185	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   2311: sipush 1000
    //   2314: imul
    //   2315: i2l
    //   2316: lcmp
    //   2317: ifgt +767 -> 3084
    //   2320: aload 22
    //   2322: aload 30
    //   2324: invokestatic 958	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2327: ifeq +757 -> 3084
    //   2330: aload 20
    //   2332: getfield 1002	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   2335: invokestatic 1190	com/tencent/mm/plugin/sight/base/SightVideoJNI:optimizeMP4VFS	(Ljava/lang/String;)Z
    //   2338: istore 16
    //   2340: getstatic 548	com/tencent/mm/plugin/finder/utils/av:GiL	Lcom/tencent/mm/plugin/finder/utils/av;
    //   2343: astore 22
    //   2345: aload 20
    //   2347: getfield 1002	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   2350: astore 22
    //   2352: aload 22
    //   2354: ldc_w 1004
    //   2357: invokestatic 1006	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2360: aload 22
    //   2362: invokestatic 1193	com/tencent/mm/plugin/finder/utils/av:aBO	(Ljava/lang/String;)Z
    //   2365: istore 17
    //   2367: aload_0
    //   2368: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   2371: new 273	java/lang/StringBuilder
    //   2374: dup
    //   2375: ldc_w 1195
    //   2378: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2381: iload 16
    //   2383: invokevirtual 744	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2386: ldc_w 1197
    //   2389: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2392: iload 17
    //   2394: invokevirtual 744	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2397: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2400: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2403: iload 17
    //   2405: ifeq +656 -> 3061
    //   2408: aload_0
    //   2409: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   2412: ldc_w 1199
    //   2415: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2418: aload 20
    //   2420: getfield 1002	com/tencent/mm/protocal/protobuf/fos:path	Ljava/lang/String;
    //   2423: aload 28
    //   2425: iconst_0
    //   2426: invokestatic 1203	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   2429: pop2
    //   2430: aload 28
    //   2432: aload 20
    //   2434: getfield 1206	com/tencent/mm/protocal/protobuf/fos:UaC	I
    //   2437: aload 20
    //   2439: getfield 1209	com/tencent/mm/protocal/protobuf/fos:UaD	I
    //   2442: aload 21
    //   2444: getfield 1151	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   2447: aload 21
    //   2449: getfield 1150	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   2452: aload 20
    //   2454: getfield 1178	com/tencent/mm/protocal/protobuf/fos:UjZ	J
    //   2457: l2f
    //   2458: ldc_w 752
    //   2461: fdiv
    //   2462: aload 21
    //   2464: getfield 1212	com/tencent/mm/modelcontrol/VideoTransPara:oCd	F
    //   2467: aload 21
    //   2469: getfield 1215	com/tencent/mm/modelcontrol/VideoTransPara:oCh	I
    //   2472: aload 21
    //   2474: getfield 1218	com/tencent/mm/modelcontrol/VideoTransPara:oCi	I
    //   2477: invokestatic 1221	com/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate:a	(Ljava/lang/String;IIIIFFII)Lcom/tencent/mm/plugin/sight/base/ABAPrams;
    //   2480: astore 20
    //   2482: aload 20
    //   2484: ifnull +2136 -> 4620
    //   2487: aload 20
    //   2489: getfield 1226	com/tencent/mm/plugin/sight/base/ABAPrams:qualityLevel	I
    //   2492: istore 7
    //   2494: iload 7
    //   2496: i2f
    //   2497: fstore_3
    //   2498: fload_3
    //   2499: fstore 4
    //   2501: iload 16
    //   2503: ifeq +18 -> 2521
    //   2506: aload 28
    //   2508: aconst_null
    //   2509: aload 21
    //   2511: getfield 1229	com/tencent/mm/modelcontrol/VideoTransPara:oCb	I
    //   2514: iconst_0
    //   2515: invokestatic 1233	com/tencent/mm/plugin/sight/base/SightVideoJNI:addReportMetadata	(Ljava/lang/String;Lcom/tencent/mm/plugin/sight/base/ABAPrams;II)V
    //   2518: fload_3
    //   2519: fstore 4
    //   2521: getstatic 318	com/tencent/mm/plugin/finder/report/i$b:Fox	Lcom/tencent/mm/plugin/finder/report/i$b;
    //   2524: astore 20
    //   2526: iload 12
    //   2528: ifne +8 -> 2536
    //   2531: iload 9
    //   2533: ifeq +522 -> 3055
    //   2536: iconst_1
    //   2537: istore 16
    //   2539: iload 16
    //   2541: invokestatic 1236	com/tencent/mm/plugin/finder/report/i$b:tz	(Z)V
    //   2544: fload 4
    //   2546: fstore_3
    //   2547: iconst_3
    //   2548: istore 7
    //   2550: fload_3
    //   2551: fstore 4
    //   2553: iload 7
    //   2555: iconst_3
    //   2556: if_icmpeq +1108 -> 3664
    //   2559: aload 26
    //   2561: getfield 176	com/tencent/mm/protocal/protobuf/dji:aaDI	Lcom/tencent/mm/protocal/protobuf/afb;
    //   2564: astore 20
    //   2566: aload 20
    //   2568: ifnonnull +530 -> 3098
    //   2571: aconst_null
    //   2572: astore 20
    //   2574: iload 13
    //   2576: ifeq +96 -> 2672
    //   2579: aload 20
    //   2581: ifnull +91 -> 2672
    //   2584: new 335	android/graphics/Rect
    //   2587: dup
    //   2588: invokespecial 336	android/graphics/Rect:<init>	()V
    //   2591: astore 22
    //   2593: new 335	android/graphics/Rect
    //   2596: dup
    //   2597: invokespecial 336	android/graphics/Rect:<init>	()V
    //   2600: astore 30
    //   2602: aload 20
    //   2604: getfield 1163	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   2607: getfield 1166	com/tencent/mm/protocal/protobuf/ahj:Zqq	Lcom/tencent/mm/protocal/protobuf/enx;
    //   2610: aload 22
    //   2612: invokestatic 634	com/tencent/mm/plugin/vlog/model/h:a	(Lcom/tencent/mm/protocal/protobuf/enx;Landroid/graphics/Rect;)V
    //   2615: aload 20
    //   2617: getfield 1163	com/tencent/mm/protocal/protobuf/fos:abOZ	Lcom/tencent/mm/protocal/protobuf/ahj;
    //   2620: getfield 1239	com/tencent/mm/protocal/protobuf/ahj:Zqt	Lcom/tencent/mm/protocal/protobuf/enx;
    //   2623: aload 30
    //   2625: invokestatic 634	com/tencent/mm/plugin/vlog/model/h:a	(Lcom/tencent/mm/protocal/protobuf/enx;Landroid/graphics/Rect;)V
    //   2628: aload 30
    //   2630: aload 22
    //   2632: invokevirtual 1243	android/graphics/Rect:contains	(Landroid/graphics/Rect;)Z
    //   2635: pop
    //   2636: aload_0
    //   2637: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   2640: new 273	java/lang/StringBuilder
    //   2643: dup
    //   2644: ldc_w 1245
    //   2647: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2650: aload 22
    //   2652: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2655: ldc_w 1247
    //   2658: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2661: aload 30
    //   2663: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2666: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2669: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2672: aload_0
    //   2673: getfield 1249	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:cancel	Z
    //   2676: ifeq +454 -> 3130
    //   2679: aload_0
    //   2680: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   2683: new 273	java/lang/StringBuilder
    //   2686: dup
    //   2687: ldc_w 1251
    //   2690: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2693: aload_0
    //   2694: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   2697: getfield 1254	com/tencent/mm/plugin/finder/storage/i:field_localId	J
    //   2700: invokevirtual 1052	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2703: ldc_w 282
    //   2706: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2709: aload_0
    //   2710: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   2713: getfield 1257	com/tencent/mm/plugin/finder/storage/i:field_objectId	J
    //   2716: invokevirtual 1052	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2719: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2722: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2725: aload_0
    //   2726: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   2729: astore 20
    //   2731: getstatic 918	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:GdZ	Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/c$a;
    //   2734: astore 21
    //   2736: new 914	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c
    //   2739: dup
    //   2740: aload 20
    //   2742: invokestatic 1260	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:few	()I
    //   2745: invokespecial 924	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:<init>	(Lcom/tencent/mm/plugin/finder/storage/i;I)V
    //   2748: checkcast 926	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   2751: astore 20
    //   2753: ldc_w 816
    //   2756: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2759: aload 20
    //   2761: areturn
    //   2762: ldc_w 1261
    //   2765: astore 20
    //   2767: goto -1422 -> 1345
    //   2770: aload 20
    //   2772: getfield 998	com/tencent/mm/protocal/protobuf/afb:Zng	Ljava/util/LinkedList;
    //   2775: astore 20
    //   2777: aload 20
    //   2779: ifnonnull +9 -> 2788
    //   2782: aconst_null
    //   2783: astore 20
    //   2785: goto -1388 -> 1397
    //   2788: aload 20
    //   2790: checkcast 837	java/util/List
    //   2793: invokestatic 1265	kotlin/a/p:oL	(Ljava/util/List;)Ljava/lang/Object;
    //   2796: checkcast 1000	com/tencent/mm/protocal/protobuf/fos
    //   2799: astore 20
    //   2801: goto -1404 -> 1397
    //   2804: iconst_0
    //   2805: istore 7
    //   2807: goto -1374 -> 1433
    //   2810: aload 22
    //   2812: getfield 804	com/tencent/mm/protocal/protobuf/afb:TYC	Lcom/tencent/mm/protocal/protobuf/afa;
    //   2815: astore 22
    //   2817: aload 22
    //   2819: ifnonnull +9 -> 2828
    //   2822: iconst_0
    //   2823: istore 7
    //   2825: goto -1372 -> 1453
    //   2828: aload 22
    //   2830: getfield 809	com/tencent/mm/protocal/protobuf/afa:Znd	Ljava/util/LinkedList;
    //   2833: astore 22
    //   2835: aload 22
    //   2837: ifnonnull +9 -> 2846
    //   2840: iconst_0
    //   2841: istore 7
    //   2843: goto -1390 -> 1453
    //   2846: aload 22
    //   2848: invokevirtual 813	java/util/LinkedList:size	()I
    //   2851: istore 7
    //   2853: goto -1400 -> 1453
    //   2856: iconst_0
    //   2857: istore 7
    //   2859: goto -1378 -> 1481
    //   2862: aload 22
    //   2864: getfield 1269	com/tencent/mm/protocal/protobuf/afb:Znl	Lcom/tencent/mm/protocal/protobuf/fxt;
    //   2867: astore 22
    //   2869: goto -1368 -> 1501
    //   2872: aload 22
    //   2874: getfield 1272	com/tencent/mm/protocal/protobuf/fqf:path	Ljava/lang/String;
    //   2877: astore 22
    //   2879: goto -1345 -> 1534
    //   2882: iconst_0
    //   2883: istore 7
    //   2885: goto -1326 -> 1559
    //   2888: iconst_0
    //   2889: istore 13
    //   2891: goto -1298 -> 1593
    //   2894: aload 20
    //   2896: getfield 998	com/tencent/mm/protocal/protobuf/afb:Zng	Ljava/util/LinkedList;
    //   2899: astore 20
    //   2901: aload 20
    //   2903: ifnonnull +9 -> 2912
    //   2906: aconst_null
    //   2907: astore 20
    //   2909: goto -1272 -> 1637
    //   2912: aload 20
    //   2914: invokevirtual 813	java/util/LinkedList:size	()I
    //   2917: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2920: astore 20
    //   2922: goto -1285 -> 1637
    //   2925: aload 20
    //   2927: getfield 804	com/tencent/mm/protocal/protobuf/afb:TYC	Lcom/tencent/mm/protocal/protobuf/afa;
    //   2930: astore 20
    //   2932: aload 20
    //   2934: ifnonnull +9 -> 2943
    //   2937: aconst_null
    //   2938: astore 20
    //   2940: goto -1273 -> 1667
    //   2943: aload 20
    //   2945: getfield 809	com/tencent/mm/protocal/protobuf/afa:Znd	Ljava/util/LinkedList;
    //   2948: astore 20
    //   2950: aload 20
    //   2952: ifnonnull +9 -> 2961
    //   2955: aconst_null
    //   2956: astore 20
    //   2958: goto -1291 -> 1667
    //   2961: aload 20
    //   2963: invokevirtual 813	java/util/LinkedList:size	()I
    //   2966: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2969: astore 20
    //   2971: goto -1304 -> 1667
    //   2974: aload 20
    //   2976: getfield 1275	com/tencent/mm/protocal/protobuf/afb:Uax	Z
    //   2979: istore 15
    //   2981: goto -1221 -> 1760
    //   2984: aload 20
    //   2986: getfield 998	com/tencent/mm/protocal/protobuf/afb:Zng	Ljava/util/LinkedList;
    //   2989: astore 20
    //   2991: aload 20
    //   2993: ifnonnull +9 -> 3002
    //   2996: aconst_null
    //   2997: astore 20
    //   2999: goto -1213 -> 1786
    //   3002: aload 20
    //   3004: iconst_0
    //   3005: invokevirtual 1279	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   3008: checkcast 1000	com/tencent/mm/protocal/protobuf/fos
    //   3011: astore 20
    //   3013: goto -1227 -> 1786
    //   3016: goto -1216 -> 1800
    //   3019: aload 22
    //   3021: getfield 377	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   3024: istore 7
    //   3026: goto -1168 -> 1858
    //   3029: aload 22
    //   3031: getfield 380	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   3034: istore 7
    //   3036: goto -1146 -> 1890
    //   3039: iconst_0
    //   3040: istore 16
    //   3042: goto -964 -> 2078
    //   3045: aload 22
    //   3047: getfield 1282	com/tencent/mm/protocal/protobuf/afb:nBT	Ljava/lang/String;
    //   3050: astore 22
    //   3052: goto -959 -> 2093
    //   3055: iconst_0
    //   3056: istore 16
    //   3058: goto -519 -> 2539
    //   3061: getstatic 318	com/tencent/mm/plugin/finder/report/i$b:Fox	Lcom/tencent/mm/plugin/finder/report/i$b;
    //   3064: astore 20
    //   3066: iload 12
    //   3068: ifne +8 -> 3076
    //   3071: iload 9
    //   3073: ifeq +19 -> 3092
    //   3076: iconst_1
    //   3077: istore 16
    //   3079: iload 16
    //   3081: invokestatic 1285	com/tencent/mm/plugin/finder/report/i$b:tA	(Z)V
    //   3084: fconst_0
    //   3085: fstore_3
    //   3086: iconst_2
    //   3087: istore 7
    //   3089: goto -539 -> 2550
    //   3092: iconst_0
    //   3093: istore 16
    //   3095: goto -16 -> 3079
    //   3098: aload 20
    //   3100: getfield 998	com/tencent/mm/protocal/protobuf/afb:Zng	Ljava/util/LinkedList;
    //   3103: astore 20
    //   3105: aload 20
    //   3107: ifnonnull +9 -> 3116
    //   3110: aconst_null
    //   3111: astore 20
    //   3113: goto -539 -> 2574
    //   3116: aload 20
    //   3118: iconst_0
    //   3119: invokevirtual 1279	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   3122: checkcast 1000	com/tencent/mm/protocal/protobuf/fos
    //   3125: astore 20
    //   3127: goto -553 -> 2574
    //   3130: iload 12
    //   3132: ifne +8 -> 3140
    //   3135: iload 9
    //   3137: ifeq +267 -> 3404
    //   3140: aload_0
    //   3141: lload 18
    //   3143: aload 21
    //   3145: aload 26
    //   3147: aload 28
    //   3149: aload 27
    //   3151: iload 12
    //   3153: iload 8
    //   3155: aload 23
    //   3157: invokeinterface 927 1 0
    //   3162: invokespecial 1287	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:a	(JLcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/protocal/protobuf/dji;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;ZII)Lkotlin/r;
    //   3165: getfield 1291	kotlin/r:bsC	Ljava/lang/Object;
    //   3168: checkcast 909	java/lang/Number
    //   3171: invokevirtual 912	java/lang/Number:intValue	()I
    //   3174: ifge +50 -> 3224
    //   3177: getstatic 1027	com/tencent/mm/plugin/vlog/report/c:UeI	Lcom/tencent/mm/plugin/vlog/report/c;
    //   3180: astore 20
    //   3182: aload 29
    //   3184: invokestatic 1294	com/tencent/mm/plugin/vlog/report/c:aZm	(Ljava/lang/String;)V
    //   3187: aload_0
    //   3188: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   3191: astore 20
    //   3193: getstatic 918	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:GdZ	Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/c$a;
    //   3196: astore 21
    //   3198: new 914	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c
    //   3201: dup
    //   3202: aload 20
    //   3204: invokestatic 921	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:fev	()I
    //   3207: invokespecial 924	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:<init>	(Lcom/tencent/mm/plugin/finder/storage/i;I)V
    //   3210: checkcast 926	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   3213: astore 20
    //   3215: ldc_w 816
    //   3218: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3221: aload 20
    //   3223: areturn
    //   3224: getstatic 342	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:ObB	Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker;
    //   3227: aload 28
    //   3229: invokevirtual 751	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:aTG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a;
    //   3232: astore 22
    //   3234: aload 22
    //   3236: ifnull +32 -> 3268
    //   3239: aload 22
    //   3241: getfield 377	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   3244: ifle +24 -> 3268
    //   3247: aload 22
    //   3249: getfield 380	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   3252: ifle +16 -> 3268
    //   3255: fload_3
    //   3256: fstore 4
    //   3258: aload 22
    //   3260: getfield 432	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:eGw	F
    //   3263: fconst_0
    //   3264: fcmpg
    //   3265: ifgt +399 -> 3664
    //   3268: aload_0
    //   3269: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   3272: astore 21
    //   3274: new 273	java/lang/StringBuilder
    //   3277: dup
    //   3278: ldc_w 1296
    //   3281: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3284: astore 23
    //   3286: aload 22
    //   3288: ifnonnull +90 -> 3378
    //   3291: aconst_null
    //   3292: astore 20
    //   3294: aload 23
    //   3296: aload 20
    //   3298: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3301: bipush 32
    //   3303: invokevirtual 1181	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3306: astore 23
    //   3308: aload 22
    //   3310: ifnonnull +81 -> 3391
    //   3313: aconst_null
    //   3314: astore 20
    //   3316: aload 21
    //   3318: aload 23
    //   3320: aload 20
    //   3322: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3325: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3328: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3331: getstatic 1027	com/tencent/mm/plugin/vlog/report/c:UeI	Lcom/tencent/mm/plugin/vlog/report/c;
    //   3334: astore 20
    //   3336: aload 29
    //   3338: invokestatic 1294	com/tencent/mm/plugin/vlog/report/c:aZm	(Ljava/lang/String;)V
    //   3341: aload_0
    //   3342: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   3345: astore 20
    //   3347: getstatic 918	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:GdZ	Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/c$a;
    //   3350: astore 21
    //   3352: new 914	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c
    //   3355: dup
    //   3356: aload 20
    //   3358: invokestatic 921	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:fev	()I
    //   3361: invokespecial 924	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:<init>	(Lcom/tencent/mm/plugin/finder/storage/i;I)V
    //   3364: checkcast 926	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   3367: astore 20
    //   3369: ldc_w 816
    //   3372: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3375: aload 20
    //   3377: areturn
    //   3378: aload 22
    //   3380: getfield 377	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   3383: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3386: astore 20
    //   3388: goto -94 -> 3294
    //   3391: aload 22
    //   3393: getfield 380	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   3396: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3399: astore 20
    //   3401: goto -85 -> 3316
    //   3404: aload_0
    //   3405: lload 18
    //   3407: iload 8
    //   3409: aload 28
    //   3411: aload 21
    //   3413: aload 26
    //   3415: aload 27
    //   3417: aload 23
    //   3419: invokeinterface 927 1 0
    //   3424: invokespecial 1298	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:a	(JILjava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/protocal/protobuf/dji;Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;I)Lkotlin/r;
    //   3427: astore 20
    //   3429: aload 20
    //   3431: getfield 1291	kotlin/r:bsC	Ljava/lang/Object;
    //   3434: checkcast 909	java/lang/Number
    //   3437: invokevirtual 912	java/lang/Number:intValue	()I
    //   3440: istore 9
    //   3442: aload 20
    //   3444: getfield 1301	kotlin/r:bsD	Ljava/lang/Object;
    //   3447: checkcast 909	java/lang/Number
    //   3450: invokevirtual 1304	java/lang/Number:floatValue	()F
    //   3453: fstore 4
    //   3455: iload 9
    //   3457: ifge +40 -> 3497
    //   3460: aload_0
    //   3461: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   3464: astore 20
    //   3466: getstatic 918	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:GdZ	Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/c$a;
    //   3469: astore 21
    //   3471: new 914	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c
    //   3474: dup
    //   3475: aload 20
    //   3477: invokestatic 921	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:fev	()I
    //   3480: invokespecial 924	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:<init>	(Lcom/tencent/mm/plugin/finder/storage/i;I)V
    //   3483: checkcast 926	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   3486: astore 20
    //   3488: ldc_w 816
    //   3491: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3494: aload 20
    //   3496: areturn
    //   3497: getstatic 342	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:ObB	Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker;
    //   3500: aload 28
    //   3502: invokevirtual 751	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker:aTG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a;
    //   3505: astore 22
    //   3507: aload 22
    //   3509: ifnull +29 -> 3538
    //   3512: aload 22
    //   3514: getfield 377	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   3517: ifle +21 -> 3538
    //   3520: aload 22
    //   3522: getfield 380	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   3525: ifle +13 -> 3538
    //   3528: aload 22
    //   3530: getfield 432	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:eGw	F
    //   3533: fconst_0
    //   3534: fcmpg
    //   3535: ifgt +129 -> 3664
    //   3538: aload_0
    //   3539: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   3542: astore 21
    //   3544: new 273	java/lang/StringBuilder
    //   3547: dup
    //   3548: ldc_w 1296
    //   3551: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3554: astore 23
    //   3556: aload 22
    //   3558: ifnonnull +80 -> 3638
    //   3561: aconst_null
    //   3562: astore 20
    //   3564: aload 23
    //   3566: aload 20
    //   3568: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3571: bipush 32
    //   3573: invokevirtual 1181	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3576: astore 23
    //   3578: aload 22
    //   3580: ifnonnull +71 -> 3651
    //   3583: aconst_null
    //   3584: astore 20
    //   3586: aload 21
    //   3588: aload 23
    //   3590: aload 20
    //   3592: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3595: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3598: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3601: aload_0
    //   3602: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   3605: astore 20
    //   3607: getstatic 918	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:GdZ	Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/c$a;
    //   3610: astore 21
    //   3612: new 914	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c
    //   3615: dup
    //   3616: aload 20
    //   3618: invokestatic 921	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:fev	()I
    //   3621: invokespecial 924	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:<init>	(Lcom/tencent/mm/plugin/finder/storage/i;I)V
    //   3624: checkcast 926	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   3627: astore 20
    //   3629: ldc_w 816
    //   3632: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3635: aload 20
    //   3637: areturn
    //   3638: aload 22
    //   3640: getfield 377	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:width	I
    //   3643: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3646: astore 20
    //   3648: goto -84 -> 3564
    //   3651: aload 22
    //   3653: getfield 380	com/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$a:height	I
    //   3656: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3659: astore 20
    //   3661: goto -75 -> 3586
    //   3664: aload_0
    //   3665: getfield 1249	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:cancel	Z
    //   3668: ifeq +86 -> 3754
    //   3671: aload_0
    //   3672: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   3675: new 273	java/lang/StringBuilder
    //   3678: dup
    //   3679: ldc_w 1306
    //   3682: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3685: aload_0
    //   3686: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   3689: getfield 1254	com/tencent/mm/plugin/finder/storage/i:field_localId	J
    //   3692: invokevirtual 1052	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3695: ldc_w 282
    //   3698: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3701: aload_0
    //   3702: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   3705: getfield 1257	com/tencent/mm/plugin/finder/storage/i:field_objectId	J
    //   3708: invokevirtual 1052	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3711: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3714: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3717: aload_0
    //   3718: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   3721: astore 20
    //   3723: getstatic 918	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:GdZ	Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/c$a;
    //   3726: astore 21
    //   3728: new 914	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c
    //   3731: dup
    //   3732: aload 20
    //   3734: invokestatic 1260	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:few	()I
    //   3737: invokespecial 924	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:<init>	(Lcom/tencent/mm/plugin/finder/storage/i;I)V
    //   3740: checkcast 926	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   3743: astore 20
    //   3745: ldc_w 816
    //   3748: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3751: aload 20
    //   3753: areturn
    //   3754: aload_0
    //   3755: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   3758: ldc_w 1308
    //   3761: fload 4
    //   3763: invokestatic 302	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   3766: invokestatic 165	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   3769: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3772: getstatic 1314	com/tencent/mm/plugin/finder/upload/c:Gbx	Lcom/tencent/mm/plugin/finder/upload/c$a;
    //   3775: astore 20
    //   3777: aload 28
    //   3779: fload 5
    //   3781: fload 6
    //   3783: iload 11
    //   3785: iload 14
    //   3787: iload 15
    //   3789: invokestatic 1319	com/tencent/mm/plugin/finder/upload/c$a:a	(Ljava/lang/String;FFIZZ)F
    //   3792: fstore_3
    //   3793: aload_0
    //   3794: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   3797: new 273	java/lang/StringBuilder
    //   3800: dup
    //   3801: ldc_w 1321
    //   3804: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3807: fload_3
    //   3808: invokevirtual 725	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   3811: ldc_w 1323
    //   3814: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3817: fload 5
    //   3819: invokevirtual 725	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   3822: ldc_w 1325
    //   3825: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3828: fload 6
    //   3830: invokevirtual 725	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   3833: ldc_w 1327
    //   3836: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3839: iload 11
    //   3841: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3844: ldc_w 1329
    //   3847: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3850: iload 14
    //   3852: invokevirtual 744	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3855: ldc_w 1331
    //   3858: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3861: iload 15
    //   3863: invokevirtual 744	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3866: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3869: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3872: aload_0
    //   3873: iload 8
    //   3875: i2f
    //   3876: fconst_1
    //   3877: fadd
    //   3878: aload 23
    //   3880: invokeinterface 927 1 0
    //   3885: i2f
    //   3886: fdiv
    //   3887: invokevirtual 933	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:cn	(F)V
    //   3890: aload 26
    //   3892: getfield 615	com/tencent/mm/protocal/protobuf/dji:aaPp	Z
    //   3895: ifeq +267 -> 4162
    //   3898: aload_0
    //   3899: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   3902: invokevirtual 841	com/tencent/mm/plugin/finder/storage/FinderItem:getHalfVideoMediaExtList	()Ljava/util/LinkedList;
    //   3905: checkcast 843	java/lang/Iterable
    //   3908: invokeinterface 847 1 0
    //   3913: astore 22
    //   3915: aload 22
    //   3917: invokeinterface 852 1 0
    //   3922: ifeq +234 -> 4156
    //   3925: aload 22
    //   3927: invokeinterface 856 1 0
    //   3932: astore 20
    //   3934: aload 20
    //   3936: checkcast 172	com/tencent/mm/protocal/protobuf/dji
    //   3939: astore 29
    //   3941: aload 26
    //   3943: getfield 681	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   3946: aload 29
    //   3948: getfield 681	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   3951: invokestatic 958	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3954: ifeq -39 -> 3915
    //   3957: aload 20
    //   3959: checkcast 172	com/tencent/mm/protocal/protobuf/dji
    //   3962: astore 20
    //   3964: aload 20
    //   3966: ifnull +37 -> 4003
    //   3969: aload_0
    //   3970: aload 21
    //   3972: aload 26
    //   3974: aload 28
    //   3976: aload 20
    //   3978: iload 8
    //   3980: aload 27
    //   3982: fload_3
    //   3983: fload 4
    //   3985: iconst_0
    //   3986: invokespecial 1333	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:a	(Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/protocal/protobuf/dji;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/dji;ILcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;FFZ)V
    //   3989: aload_0
    //   3990: invokevirtual 1336	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:fey	()V
    //   3993: getstatic 295	kotlin/ah:aiuX	Lkotlin/ah;
    //   3996: astore 20
    //   3998: getstatic 295	kotlin/ah:aiuX	Lkotlin/ah;
    //   4001: astore 20
    //   4003: aload_0
    //   4004: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   4007: invokevirtual 880	com/tencent/mm/plugin/finder/storage/FinderItem:getLongVideoMediaExtList	()Ljava/util/LinkedList;
    //   4010: astore 22
    //   4012: aload 22
    //   4014: checkcast 843	java/lang/Iterable
    //   4017: invokeinterface 847 1 0
    //   4022: astore 29
    //   4024: aload 29
    //   4026: invokeinterface 852 1 0
    //   4031: ifeq +297 -> 4328
    //   4034: aload 29
    //   4036: invokeinterface 856 1 0
    //   4041: astore 20
    //   4043: aload 20
    //   4045: checkcast 172	com/tencent/mm/protocal/protobuf/dji
    //   4048: astore 30
    //   4050: aload 26
    //   4052: getfield 681	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   4055: aload 30
    //   4057: getfield 681	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   4060: invokestatic 958	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4063: ifeq -39 -> 4024
    //   4066: aload 20
    //   4068: checkcast 172	com/tencent/mm/protocal/protobuf/dji
    //   4071: astore 20
    //   4073: aload 20
    //   4075: ifnull +72 -> 4147
    //   4078: aload_0
    //   4079: aload 21
    //   4081: aload 26
    //   4083: aload 28
    //   4085: aload 20
    //   4087: iload 8
    //   4089: aload 27
    //   4091: fload_3
    //   4092: fload 4
    //   4094: iconst_1
    //   4095: invokespecial 1333	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:a	(Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/protocal/protobuf/dji;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/dji;ILcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;FFZ)V
    //   4098: aload_0
    //   4099: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   4102: invokevirtual 1340	com/tencent/mm/plugin/finder/storage/FinderItem:getFeedObject	()Lcom/tencent/mm/protocal/protobuf/FinderObject;
    //   4105: getfield 1346	com/tencent/mm/protocal/protobuf/FinderObject:attachmentList	Lcom/tencent/mm/protocal/protobuf/atr;
    //   4108: astore 20
    //   4110: aload 20
    //   4112: ifnonnull +222 -> 4334
    //   4115: aconst_null
    //   4116: astore 20
    //   4118: aload 20
    //   4120: ifnull +13 -> 4133
    //   4123: aload 20
    //   4125: aload 22
    //   4127: invokestatic 1352	com/tencent/mm/plugin/finder/storage/data/n:ba	(Ljava/util/LinkedList;)Ljava/util/LinkedList;
    //   4130: putfield 1356	com/tencent/mm/protocal/protobuf/dnh:media	Ljava/util/LinkedList;
    //   4133: aload_0
    //   4134: invokevirtual 1336	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:fey	()V
    //   4137: getstatic 295	kotlin/ah:aiuX	Lkotlin/ah;
    //   4140: astore 20
    //   4142: getstatic 295	kotlin/ah:aiuX	Lkotlin/ah;
    //   4145: astore 20
    //   4147: iload 8
    //   4149: iconst_1
    //   4150: iadd
    //   4151: istore 8
    //   4153: goto -3539 -> 614
    //   4156: aconst_null
    //   4157: astore 20
    //   4159: goto -202 -> 3957
    //   4162: aload_0
    //   4163: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   4166: invokevirtual 863	com/tencent/mm/plugin/finder/storage/FinderItem:getMediaList	()Ljava/util/LinkedList;
    //   4169: astore 22
    //   4171: aload 22
    //   4173: checkcast 843	java/lang/Iterable
    //   4176: invokeinterface 847 1 0
    //   4181: astore 29
    //   4183: aload 29
    //   4185: invokeinterface 852 1 0
    //   4190: ifeq +132 -> 4322
    //   4193: aload 29
    //   4195: invokeinterface 856 1 0
    //   4200: astore 20
    //   4202: aload 20
    //   4204: checkcast 172	com/tencent/mm/protocal/protobuf/dji
    //   4207: astore 30
    //   4209: aload 26
    //   4211: getfield 681	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   4214: aload 30
    //   4216: getfield 681	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   4219: invokestatic 958	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   4222: ifeq -39 -> 4183
    //   4225: aload 20
    //   4227: checkcast 172	com/tencent/mm/protocal/protobuf/dji
    //   4230: astore 20
    //   4232: aload 20
    //   4234: ifnull -231 -> 4003
    //   4237: aload_0
    //   4238: aload 21
    //   4240: aload 26
    //   4242: aload 28
    //   4244: aload 20
    //   4246: iload 8
    //   4248: aload 27
    //   4250: fload_3
    //   4251: fload 4
    //   4253: iconst_0
    //   4254: invokespecial 1333	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:a	(Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/protocal/protobuf/dji;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/dji;ILcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;FFZ)V
    //   4257: aload_0
    //   4258: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   4261: aload 22
    //   4263: invokevirtual 1360	com/tencent/mm/plugin/finder/storage/FinderItem:setMediaList	(Ljava/util/LinkedList;)V
    //   4266: aload_0
    //   4267: getfield 139	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:Ged	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   4270: getfield 827	com/tencent/mm/plugin/finder/storage/FinderItem:field_reportObject	Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;
    //   4273: astore 20
    //   4275: aload 20
    //   4277: ifnull +28 -> 4305
    //   4280: aload 20
    //   4282: invokestatic 1365	com/tencent/mm/model/cn:bDw	()J
    //   4285: putfield 1368	com/tencent/mm/protocal/protobuf/FinderFeedReportObject:remuxEndTime	J
    //   4288: aload 20
    //   4290: iload 7
    //   4292: putfield 1371	com/tencent/mm/protocal/protobuf/FinderFeedReportObject:remuxType	I
    //   4295: getstatic 295	kotlin/ah:aiuX	Lkotlin/ah;
    //   4298: astore 20
    //   4300: getstatic 295	kotlin/ah:aiuX	Lkotlin/ah;
    //   4303: astore 20
    //   4305: aload_0
    //   4306: invokevirtual 1336	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:fey	()V
    //   4309: getstatic 295	kotlin/ah:aiuX	Lkotlin/ah;
    //   4312: astore 20
    //   4314: getstatic 295	kotlin/ah:aiuX	Lkotlin/ah;
    //   4317: astore 20
    //   4319: goto -316 -> 4003
    //   4322: aconst_null
    //   4323: astore 20
    //   4325: goto -100 -> 4225
    //   4328: aconst_null
    //   4329: astore 20
    //   4331: goto -265 -> 4066
    //   4334: aload 20
    //   4336: getfield 1376	com/tencent/mm/protocal/protobuf/atr:ZEi	Ljava/util/LinkedList;
    //   4339: astore 20
    //   4341: aload 20
    //   4343: ifnonnull +9 -> 4352
    //   4346: aconst_null
    //   4347: astore 20
    //   4349: goto -231 -> 4118
    //   4352: aload 20
    //   4354: checkcast 843	java/lang/Iterable
    //   4357: invokeinterface 847 1 0
    //   4362: astore 21
    //   4364: aload 21
    //   4366: invokeinterface 852 1 0
    //   4371: ifeq +58 -> 4429
    //   4374: aload 21
    //   4376: invokeinterface 856 1 0
    //   4381: astore 20
    //   4383: aload 20
    //   4385: checkcast 1378	com/tencent/mm/protocal/protobuf/atq
    //   4388: astore 26
    //   4390: getstatic 548	com/tencent/mm/plugin/finder/utils/av:GiL	Lcom/tencent/mm/plugin/finder/utils/av;
    //   4393: astore 27
    //   4395: aload 26
    //   4397: ldc_w 1380
    //   4400: invokestatic 1006	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   4403: aload 26
    //   4405: invokestatic 1383	com/tencent/mm/plugin/finder/utils/av:a	(Lcom/tencent/mm/protocal/protobuf/atq;)Z
    //   4408: ifeq -44 -> 4364
    //   4411: aload 20
    //   4413: checkcast 1378	com/tencent/mm/protocal/protobuf/atq
    //   4416: astore 20
    //   4418: aload 20
    //   4420: ifnonnull +15 -> 4435
    //   4423: aconst_null
    //   4424: astore 20
    //   4426: goto -308 -> 4118
    //   4429: aconst_null
    //   4430: astore 20
    //   4432: goto -21 -> 4411
    //   4435: aload 20
    //   4437: getfield 1387	com/tencent/mm/protocal/protobuf/atq:ZEf	Lcom/tencent/mm/protocal/protobuf/byx;
    //   4440: astore 20
    //   4442: aload 20
    //   4444: ifnonnull +9 -> 4453
    //   4447: aconst_null
    //   4448: astore 20
    //   4450: goto -332 -> 4118
    //   4453: aload 20
    //   4455: getfield 1393	com/tencent/mm/protocal/protobuf/byx:ZXx	Lcom/tencent/mm/protocal/protobuf/dne;
    //   4458: astore 20
    //   4460: aload 20
    //   4462: ifnonnull +9 -> 4471
    //   4465: aconst_null
    //   4466: astore 20
    //   4468: goto -350 -> 4118
    //   4471: aload 20
    //   4473: getfield 1399	com/tencent/mm/protocal/protobuf/dne:aaUt	Lcom/tencent/mm/protocal/protobuf/dnh;
    //   4476: astore 20
    //   4478: goto -360 -> 4118
    //   4481: getstatic 327	com/tencent/mm/plugin/vlog/model/m:TYW	Lcom/tencent/mm/plugin/vlog/model/m;
    //   4484: astore 20
    //   4486: invokestatic 1402	com/tencent/mm/plugin/vlog/model/m:reset	()V
    //   4489: aload_0
    //   4490: getfield 1249	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:cancel	Z
    //   4493: ifeq +86 -> 4579
    //   4496: aload_0
    //   4497: getfield 132	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:TAG	Ljava/lang/String;
    //   4500: new 273	java/lang/StringBuilder
    //   4503: dup
    //   4504: ldc_w 1404
    //   4507: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4510: aload_0
    //   4511: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   4514: getfield 1254	com/tencent/mm/plugin/finder/storage/i:field_localId	J
    //   4517: invokevirtual 1052	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4520: ldc_w 282
    //   4523: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4526: aload_0
    //   4527: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   4530: getfield 1257	com/tencent/mm/plugin/finder/storage/i:field_objectId	J
    //   4533: invokevirtual 1052	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4536: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4539: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4542: aload_0
    //   4543: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   4546: astore 20
    //   4548: getstatic 918	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:GdZ	Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/c$a;
    //   4551: astore 21
    //   4553: new 914	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c
    //   4556: dup
    //   4557: aload 20
    //   4559: invokestatic 1260	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:few	()I
    //   4562: invokespecial 924	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/c:<init>	(Lcom/tencent/mm/plugin/finder/storage/i;I)V
    //   4565: checkcast 926	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   4568: astore 20
    //   4570: ldc_w 816
    //   4573: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4576: aload 20
    //   4578: areturn
    //   4579: new 935	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/g
    //   4582: dup
    //   4583: aload_0
    //   4584: getfield 128	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/d:ABX	Lcom/tencent/mm/plugin/finder/storage/i;
    //   4587: invokespecial 937	com/tencent/mm/plugin/finder/upload/postlogic/draftstage/g:<init>	(Lcom/tencent/mm/plugin/finder/storage/i;)V
    //   4590: checkcast 926	com/tencent/mm/plugin/finder/upload/postlogic/base/e
    //   4593: astore 20
    //   4595: ldc_w 816
    //   4598: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4601: aload 20
    //   4603: areturn
    //   4604: astore 20
    //   4606: fconst_0
    //   4607: fstore 4
    //   4609: goto -2088 -> 2521
    //   4612: astore 20
    //   4614: fload_3
    //   4615: fstore 4
    //   4617: goto -2096 -> 2521
    //   4620: fconst_0
    //   4621: fstore_3
    //   4622: goto -2124 -> 2498
    //   4625: iconst_0
    //   4626: istore 14
    //   4628: goto -2910 -> 1718
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4631	0	this	d
    //   1861	200	1	d	double
    //   2497	2125	3	f1	float
    //   2499	2117	4	f2	float
    //   1728	2090	5	f3	float
    //   1736	2093	6	f4	float
    //   121	4170	7	i	int
    //   194	4053	8	j	int
    //   804	2652	9	k	int
    //   1380	384	10	m	int
    //   1743	2097	11	n	int
    //   775	2377	12	bool1	boolean
    //   1591	1299	13	bool2	boolean
    //   1716	2911	14	bool3	boolean
    //   1758	2104	15	bool4	boolean
    //   2076	1018	16	bool5	boolean
    //   2098	306	17	bool6	boolean
    //   1288	2118	18	l	long
    //   23	4579	20	localObject1	Object
    //   4604	1	20	localObject2	Object
    //   4612	1	20	localObject3	Object
    //   97	4455	21	localObject4	Object
    //   104	4158	22	localObject5	Object
    //   46	3833	23	localObject6	Object
    //   58	725	24	localList	java.util.List
    //   612	13	25	localIterator	java.util.Iterator
    //   646	3758	26	localObject7	Object
    //   950	3444	27	localObject8	Object
    //   1070	3173	28	localObject9	Object
    //   1042	3152	29	localObject10	Object
    //   1620	2595	30	localObject11	Object
    //   1960	43	31	localStringBuilder	java.lang.StringBuilder
    //   1965	34	32	locald	com.tencent.mm.plugin.finder.storage.d
    // Exception table:
    //   from	to	target	type
    //   2430	2482	4604	finally
    //   2487	2494	4604	finally
    //   2506	2518	4612	finally
  }
  
  public final void cn(float paramFloat)
  {
    AppMethodBeat.i(343226);
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i = (int)(com.tencent.mm.plugin.finder.storage.d.eQF() * f);
    Log.i(this.TAG, "feed " + this.ABX.field_localId + " updateProgress  " + f + ", " + i);
    if (this.Ged.getPostInfo().aaPw < i)
    {
      this.Ged.getPostInfo().aaPw = i;
      localObject = c.FNC;
      c.g(this.ABX);
    }
    localObject = new ic();
    ((ic)localObject).hJy.localId = this.ABX.field_localId;
    ((ic)localObject).hJy.progress = this.Ged.getPostInfo().aaPw;
    ((ic)localObject).publish();
    AppMethodBeat.o(343226);
  }
  
  public final void d(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343237);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343237);
  }
  
  public final void e(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343241);
    s.u(parame, "nextStage");
    parame = i.c.FoQ;
    i.c.tF(this.Ged.isLongVideo());
    AppMethodBeat.o(343241);
  }
  
  public final void f(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343248);
    s.u(parame, "nextStage");
    parame = i.c.FoQ;
    i.c.tF(this.Ged.isLongVideo());
    AppMethodBeat.o(343248);
  }
  
  public final com.tencent.mm.plugin.finder.upload.postlogic.base.e feo()
  {
    AppMethodBeat.i(343220);
    this.Gef.alive();
    com.tencent.mm.plugin.finder.upload.postlogic.base.e locale = fex();
    this.Gef.dead();
    AppMethodBeat.o(343220);
    return locale;
  }
  
  public final int fer()
  {
    return 2;
  }
  
  final void fey()
  {
    AppMethodBeat.i(343230);
    c localc = c.FNC;
    c.g(this.ABX);
    AppMethodBeat.o(343230);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Float, ah>
  {
    a(ah.c paramc, d paramd, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<k, ah>
  {
    b(d paramd, ah.d paramd1, int paramInt, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, String paramString, afc paramafc, VideoTransPara paramVideoTransPara, afb paramafb, Object paramObject, ah.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Float, ah>
  {
    c(ah.c paramc, d paramd, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<k, ah>
  {
    d(d paramd, ah.d paramd1, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, String paramString, boolean paramBoolean, ah.d paramd2, ah.d paramd3, VideoTransPara paramVideoTransPara, Object paramObject, ah.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.draftstage.d
 * JD-Core Version:    0.7.0.1
 */