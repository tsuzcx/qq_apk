package com.tencent.mm.plugin.finder.upload;

import android.graphics.Rect;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.ah.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.storage.n;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.fyb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "checkNotRetryAndSave", "", "result", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;", "checkProgressException", "localId", "", "isLongVideo", "", "isCancel", "checkVideoInfoMatch", "path", "", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "chooseMixType", "", "originAudio", "addAudio", "compositionToCropInfo", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "exportMedia", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "remuxComposition", "Lkotlin/Pair;", "", "startRemuxerTick", "index", "outputPath", "mediaReportObject", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;", "size", "remuxLongVideoComposition", "localMedia", "remuxNormalVideo", "videoWidth", "videoHeight", "width", "height", "bitrate", "localFinderMedia", "musicPath", "mixType", "isLongVideoAttachShort", "vcPerformanceStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "onUpdateProgress", "Lkotlin/Function1;", "rotateRect", "rotate", "saveFinderObject", "start", "uniqueId", "updateMedia", "reportObject", "audioQuality", "videoQuality", "updateProgress", "avgProgress", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends j
{
  public static final a Gbx;
  private static final MMHandler Gby;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(167735);
    Gbx = new a((byte)0);
    TAG = "Finder.LogPost.FinderMediaProcessTask";
    MMHandler localMMHandler = new MMHandler(s.X(TAG, "#checkProgressExceptionHandler"), c..ExternalSyntheticLambda0.INSTANCE);
    localMMHandler.setLogging(false);
    Gby = localMMHandler;
    AppMethodBeat.o(167735);
  }
  
  private static final boolean r(Message paramMessage)
  {
    boolean bool2 = false;
    AppMethodBeat.i(342945);
    s.u(paramMessage, "msg");
    boolean bool1;
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramMessage.arg1 == 1)
    {
      bool1 = true;
      long l = paramMessage.what;
      paramMessage = ah.c.Ftv;
      ah.c.tR(bool1);
      paramMessage = ((PluginFinder)h.az(PluginFinder.class)).getFeedStorage().qc(l);
      if (paramMessage != null)
      {
        localObject = paramMessage.field_reportObject;
        if (localObject != null) {
          ((FinderFeedReportObject)localObject).uploadLogicError = 3;
        }
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        d.a.v(paramMessage);
        localObject = com.tencent.mm.plugin.finder.report.v.FrN;
        com.tencent.mm.plugin.finder.report.v.pG(paramMessage.getLocalId());
      }
      localObject = TAG;
      localStringBuilder = new StringBuilder("[checkProgressException] timeout update progress, item is null=");
      bool1 = bool2;
      if (paramMessage == null) {
        bool1 = true;
      }
      localStringBuilder = localStringBuilder.append(bool1).append(" localId=");
      if (paramMessage != null) {
        break label165;
      }
    }
    label165:
    for (paramMessage = null;; paramMessage = Long.valueOf(paramMessage.getLocalId()))
    {
      Log.e((String)localObject, paramMessage);
      AppMethodBeat.o(342945);
      return true;
      bool1 = false;
      break;
    }
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(167732);
    AppMethodBeat.o(167732);
    throw null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion;", "", "()V", "RemuxTypeNoNeedRemux", "", "RemuxTypeNormalVideo", "RemuxTypeTavkit", "TAG", "", "getTAG", "()Ljava/lang/String;", "_5_min", "", "checkProgressExceptionHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkRemuxVideo", "path", "width", "height", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "localId", "isLongVideoAttachShort", "", "convertViewRect", "Landroid/graphics/Rect;", "viewRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "getABAResult", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "input", "durationSec", "", "startTimeSec", "videoTransPara", "isLongVideo", "getAudioQualityLevel", "bitrate", "samplerate", "channels", "enableAuQA", "useOriAu", "ABAResult", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static float a(String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(342921);
      s.u(paramString, "input");
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (com.tencent.mm.plugin.finder.storage.d.eTA())
      {
        paramFloat1 = AdaptiveAdjustBitrate.b(paramString, paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
        AppMethodBeat.o(342921);
        return paramFloat1;
      }
      AppMethodBeat.o(342921);
      return 0.0F;
    }
    
    public static int a(String paramString, int paramInt1, int paramInt2, VideoTransPara paramVideoTransPara, long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(342894);
      s.u(paramVideoTransPara, "videoParams");
      long l2 = y.bEl(paramString);
      Object localObject = ah.c.Ftv;
      ah.c.F(l2, paramBoolean);
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      long l1 = com.tencent.mm.plugin.finder.storage.d.eQi();
      if (l2 > l1)
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (com.tencent.mm.plugin.finder.storage.d.eTp() != 1) {}
      }
      else
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eVm().bmg()).intValue() != 1) {
          break label273;
        }
      }
      Log.i(c.access$getTAG$cp(), "checkRemuxVideo need remux zip");
      localObject = ah.c.Ftv;
      ah.c.tS(paramBoolean);
      l2 = Util.currentTicks();
      localObject = s.X(paramString, ".remux");
      paramInt1 = SightVideoJNI.remuxingVFS(paramString, (String)localObject, paramInt1, paramInt2, paramVideoTransPara.videoBitrate, com.tencent.mm.plugin.sight.base.d.PFj, 8, 2, 25.0F, paramVideoTransPara.fps, null, 0, com.tencent.mm.plugin.sight.base.d.PFi, 0, 51);
      Log.i(c.access$getTAG$cp(), "checkRemuxVideo remux cost:" + Util.ticksToNow(l2) + "ms, ret:" + paramInt1 + " localId:" + paramLong);
      paramVideoTransPara = ah.c.Ftv;
      ah.c.G(Util.ticksToNow(l2), paramBoolean);
      if (paramInt1 >= 0)
      {
        y.qn((String)localObject, paramString);
        paramLong = y.bEl((String)localObject);
        paramString = ah.c.Ftv;
        ah.c.H(paramLong, paramBoolean);
        if (paramLong > l1)
        {
          AppMethodBeat.o(342894);
          return -3;
        }
        AppMethodBeat.o(342894);
        return 0;
      }
      paramString = ah.c.Ftv;
      ah.c.tT(paramBoolean);
      AppMethodBeat.o(342894);
      return -2;
      label273:
      Log.i(c.access$getTAG$cp(), "checkRemuxVideo, no need remux");
      AppMethodBeat.o(342894);
      return 0;
    }
    
    public static Rect a(fyb paramfyb)
    {
      AppMethodBeat.i(167726);
      s.u(paramfyb, "viewRect");
      paramfyb = new Rect(paramfyb.left, paramfyb.top, paramfyb.right, paramfyb.bottom);
      AppMethodBeat.o(167726);
      return paramfyb;
    }
    
    public static c.a.a a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, VideoTransPara paramVideoTransPara, boolean paramBoolean)
    {
      AppMethodBeat.i(342912);
      s.u(paramString, "input");
      s.u(paramVideoTransPara, "videoTransPara");
      if (paramBoolean) {}
      label363:
      for (;;)
      {
        try
        {
          com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          float f = (float)com.tencent.mm.plugin.finder.storage.d.eQj();
          locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          f /= 1.0F * com.tencent.mm.plugin.finder.storage.d.ePO();
          locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          paramVideoTransPara.oCj = ((int)(f * com.tencent.mm.plugin.finder.storage.d.ePP()));
          Log.i(c.access$getTAG$cp(), "ABA:  finder video maxVideoSize:" + paramVideoTransPara + ".maxVideoSize");
          Log.i(c.access$getTAG$cp(), "ABA:  finder video video endtime:" + paramFloat1 + " starttime:" + paramFloat2);
          locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (com.tencent.mm.plugin.finder.storage.d.ePX())
          {
            paramString = AdaptiveAdjustBitrate.a(paramString, paramInt2, paramInt1, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, paramFloat1, paramFloat2, 4, paramVideoTransPara.oCd, paramVideoTransPara.oCf, paramVideoTransPara.oCg, paramVideoTransPara.oCh, paramVideoTransPara.oCi, paramVideoTransPara.oCj, false);
            int j = paramVideoTransPara.videoBitrate;
            int i = -1;
            if (paramString != null)
            {
              j = paramString.outputKbps * 1000;
              i = 0;
              Log.i(c.access$getTAG$cp(), s.X("getABAResult use videoBitrate:", Integer.valueOf(j)));
            }
            if ((paramString == null) || (paramString.resolutionAdjust <= 0)) {
              break label363;
            }
            paramInt1 = paramString.outputWidth;
            paramInt2 = paramString.outputHeight;
            i = 0;
            Log.i(c.access$getTAG$cp(), "ABA:  finder video bitrate:" + j + " width: " + paramInt1 + " height:" + paramInt2);
            if (com.tencent.mm.modelvideo.v.bOi() != null) {
              com.tencent.mm.modelcdntran.j.a(paramString);
            }
            paramString = new c.a.a(i, paramInt1, paramInt2, j, paramString);
            AppMethodBeat.o(342912);
            return paramString;
          }
        }
        finally
        {
          paramString = new c.a.a(-1, 0, 0, 0, null);
          AppMethodBeat.o(342912);
          return paramString;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.c
 * JD-Core Version:    0.7.0.1
 */