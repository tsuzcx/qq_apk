package com.tencent.mm.mj_template.maas.b;

import com.tencent.maas.instamovie.MJExportSettings;
import com.tencent.maas.instamovie.MJMovieOptions;
import com.tencent.maas.instamovie.base.MJError;
import com.tencent.maas.instamovie.base.MJError.MaasEC;
import com.tencent.maas.instamovie.mediafoundation.FrameRate;
import com.tencent.maas.instamovie.mediafoundation.FrameRate.FrameRateType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.jm;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.j;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/report/MaasReport24946;", "", "()V", "CREATION_RESULT_BACK", "", "CREATION_RESULT_EXPORT_FAIL", "CREATION_RESULT_EXPORT_SUCCESSFUL", "CREATION_RESULT_SKIP", "CREATION_RESULT_UNKNOWN_EXIT", "TAG", "", "getInfoJob", "Lkotlinx/coroutines/Job;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "reportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/MaaSCreationReportStruct;", "getVideoReportInfo", "videoPath", "markCaptureExportSetting", "", "exportSettings", "Lcom/tencent/maas/instamovie/MJRecordingSettings;", "width", "markEntrance", "entrance", "markExportError", "error", "Lcom/tencent/maas/instamovie/base/MJError;", "markExportParams", "templateId", "musicId", "movieOption", "Lcom/tencent/maas/instamovie/MJMovieOptions;", "Lcom/tencent/maas/instamovie/MJExportSettings;", "markExportTime", "spend", "", "markExportVideoInfo", "markInputMediaInfo", "mediaInfo", "", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "markTemplateId", "report", "creationResult", "getFrameRate", "Lcom/tencent/maas/instamovie/mediafoundation/FrameRate;", "getReportInfo", "Lorg/json/JSONObject;", "toReportInfo", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$ImageMediaItem;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final int Ue;
  public static final c obu;
  private static final aq obv;
  public static jm obw;
  private static cb obx;
  
  static
  {
    AppMethodBeat.i(240074);
    obu = new c();
    obv = ar.d(bg.kCi().plus((f)cx.g(null)));
    obw = new jm();
    Ue = 8;
    AppMethodBeat.o(240074);
  }
  
  public static void HI(String paramString)
  {
    AppMethodBeat.i(239984);
    obw.si(paramString);
    AppMethodBeat.o(239984);
  }
  
  public static void HJ(final String paramString)
  {
    AppMethodBeat.i(239993);
    s.u(paramString, "videoPath");
    cb localcb = obx;
    obx = j.a(obv, null, null, (m)new a(localcb, paramString, null), 3);
    AppMethodBeat.o(239993);
  }
  
  public static int a(MJMovieOptions paramMJMovieOptions)
  {
    int j = 0;
    AppMethodBeat.i(240025);
    int i;
    if (paramMJMovieOptions.isOSTMuted())
    {
      i = 0;
      if (!paramMJMovieOptions.isBGMMuted()) {
        break label41;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(240025);
      return i | 0x1 | j;
      i = 2;
      break;
      label41:
      j = 4;
    }
  }
  
  private static int a(FrameRate paramFrameRate)
  {
    AppMethodBeat.i(240036);
    switch (paramFrameRate.getType().getTypeId())
    {
    case 6: 
    case 7: 
    default: 
      AppMethodBeat.o(240036);
      return 1;
    case 5: 
      AppMethodBeat.o(240036);
      return 30;
    }
    AppMethodBeat.o(240036);
    return 60;
  }
  
  public static String a(MJExportSettings paramMJExportSettings)
  {
    AppMethodBeat.i(240030);
    JSONObject localJSONObject = new JSONObject();
    FrameRate localFrameRate = paramMJExportSettings.getFrameRate();
    s.s(localFrameRate, "frameRate");
    localJSONObject.put("f", a(localFrameRate));
    int i = paramMJExportSettings.getVideoBitsPerFrame();
    localFrameRate = paramMJExportSettings.getFrameRate();
    s.s(localFrameRate, "frameRate");
    localJSONObject.put("vb", i * a(localFrameRate));
    localJSONObject.put("ab", paramMJExportSettings.getAverageAudioBitRate());
    localJSONObject.put("maxgop", paramMJExportSettings.getMaxKeyframeInterval());
    paramMJExportSettings = localJSONObject.toString();
    s.s(paramMJExportSettings, "JSONObject().apply {\n   …val)\n        }.toString()");
    paramMJExportSettings = n.bV(paramMJExportSettings, ",", ";");
    AppMethodBeat.o(240030);
    return paramMJExportSettings;
  }
  
  public static void a(MJError paramMJError)
  {
    AppMethodBeat.i(240003);
    s.u(paramMJError, "error");
    obw.iTJ = paramMJError.ec.getErrorCode();
    jm localjm = obw;
    paramMJError = paramMJError.message;
    s.s(paramMJError, "error.message");
    localjm.iTK = localjm.F("exportResultErrorMessage", n.m(paramMJError, ",", ";", false), true);
    AppMethodBeat.o(240003);
  }
  
  public static void bN(final List<? extends GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(239971);
    s.u(paramList, "mediaInfo");
    cb localcb = obx;
    obx = j.a(obv, null, null, (m)new b(localcb, paramList, null), 3);
    AppMethodBeat.o(239971);
  }
  
  public static void iq(long paramLong)
  {
    obw.iTQ = paramLong;
  }
  
  public static void rG(final int paramInt)
  {
    AppMethodBeat.i(240014);
    cb localcb = obx;
    obx = j.a(obv, null, null, (m)new c(localcb, paramInt, null), 3);
    AppMethodBeat.o(240014);
  }
  
  public static void uL(int paramInt)
  {
    obw.iTP = paramInt;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(cb paramcb, String paramString, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(239961);
      paramObject = (d)new a(this.oby, paramString, paramd);
      AppMethodBeat.o(239961);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239950);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239950);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.oby;
        if (paramObject != null)
        {
          d locald = (d)this;
          this.label = 1;
          if (paramObject.ay(locald) == localObject)
          {
            AppMethodBeat.o(239950);
            return localObject;
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = c.bxI();
      localObject = c.obu;
      paramObject.iTH = paramObject.F("exportMediaInfo", c.HK(paramString), true);
      paramObject = ah.aiuX;
      AppMethodBeat.o(239950);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(cb paramcb, List<? extends GalleryItem.MediaItem> paramList, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(239960);
      paramObject = (d)new b(this.oby, paramList, paramd);
      AppMethodBeat.o(239960);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239949);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239949);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.oby;
        if (paramObject != null)
        {
          localObject2 = (d)this;
          this.label = 1;
          if (paramObject.ay((d)localObject2) == localObject1)
          {
            AppMethodBeat.o(239949);
            return localObject1;
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = c.bxI();
      localObject1 = c.obu;
      paramObject.iTE = paramObject.F("importMediaInfo", c.bO(paramList), true);
      paramObject = c.bxI();
      Object localObject2 = (Iterable)paramList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if ((localObject3 instanceof GalleryItem.ImageMediaItem)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      paramObject.iTG = ((List)localObject1).size();
      paramObject = c.bxI();
      localObject2 = (Iterable)paramList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if ((localObject3 instanceof GalleryItem.VideoMediaItem)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      paramObject.iTF = ((List)localObject1).size();
      Log.i("MaasReport24946", s.X("markInputMediaInfo: ", c.bxI().iTE));
      paramObject = ah.aiuX;
      AppMethodBeat.o(239949);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    c(cb paramcb, int paramInt, d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(239963);
      paramObject = (d)new c(this.oby, paramInt, paramd);
      AppMethodBeat.o(239963);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239956);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239956);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.oby;
        if (paramObject != null)
        {
          d locald = (d)this;
          this.label = 1;
          if (paramObject.ay(locald) == localObject)
          {
            AppMethodBeat.o(239956);
            return localObject;
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = c.bxI();
      int i = paramInt;
      localObject = a.obp;
      paramObject.iTC = paramObject.F("sessionKey", a.bxG(), true);
      localObject = a.obp;
      paramObject.iTD = a.bxH();
      paramObject.iTL = i;
      Log.i("MaasReport24946", s.X("report creationResult: ", Integer.valueOf(i)));
      paramObject.bMH();
      paramObject = c.obu;
      c.a(new jm());
      paramObject = ah.aiuX;
      AppMethodBeat.o(239956);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.b.c
 * JD-Core Version:    0.7.0.1
 */