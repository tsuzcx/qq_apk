package com.tencent.mm.cb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qq;
import com.tencent.mm.autogen.mmdata.rpt.qr;
import com.tencent.mm.media.util.a.a;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/report/VideoSendReporter;", "", "()V", "FAIL_REASON_COMPLETE_MSG", "", "FAIL_REASON_COMPRESS", "FAIL_REASON_COMPRESS_VIDEO_UPLOAD", "FAIL_REASON_DATA_DOWNLOAD", "FAIL_REASON_IMPORT_VIDEO", "FAIL_REASON_LOST_RESOURCE", "FAIL_REASON_NO_LOCAL_DATA", "FAIL_REASON_RAW_DATA_DOWNLOAD", "FAIL_REASON_RAW_VIDEO_UPLOAD", "FAIL_REASON_SEND_PLACE_HOLDER_MSG", "FAIL_REASON_THUMB_UPLOAD", "FAIL_REASON_UNKNOWN", "SEND_FROM_CAPTURE", "", "SEND_FROM_EXTERNAL", "SEND_FROM_FAV", "SEND_FROM_GALLERY", "SEND_FROM_TRANSMIT", "TAG", "", "sessionMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoSendReporterStruct;", "Lkotlin/collections/HashMap;", "endSession", "", "filename", "generateNewReporter", "basicReportData", "generateSessionId", "getBasicReportData", "getRemuxType", "isH265", "", "forceMediaCode", "enableVC", "reportC2CAlbumLog", "result", "type", "encodeInfo", "originPath", "outputPath", "remuxInfo", "remuxDuration", "parallelSize", "reportPauseSend", "reportResend", "reportSendSuccess", "reportSendVideo", "talker", "duration", "originSize", "compressSize", "sendType", "isSendRaw", "reportSendVideoFail", "failReason", "cdnErrorCode", "plugin-videologic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d acls;
  private static final HashMap<String, qr> tRl;
  
  static
  {
    AppMethodBeat.i(231941);
    acls = new d();
    tRl = new HashMap();
    AppMethodBeat.o(231941);
  }
  
  private static qr a(qr paramqr)
  {
    AppMethodBeat.i(231908);
    qr localqr = new qr();
    localqr.xR(paramqr.iWh);
    localqr.iCW = paramqr.iCW;
    localqr.xQ(paramqr.ijk);
    localqr.jtk = paramqr.jtk;
    localqr.iSD = paramqr.iSD;
    localqr.iHM = paramqr.iHM;
    localqr.iOd = paramqr.iOd;
    localqr.xS(paramqr.iwJ);
    AppMethodBeat.o(231908);
    return localqr;
  }
  
  private static final void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, long paramLong4, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231926);
    qr localqr = btP(paramString1);
    if (paramLong1 != 0L) {
      localqr.iCW = paramLong1;
    }
    if (paramLong2 != 0L) {
      localqr.iSD = paramLong2;
    }
    if (paramLong3 != 0L) {
      localqr.jtk = paramLong3;
    }
    if (localqr.iHM == 0L)
    {
      if (paramBoolean)
      {
        paramLong1 = 1L;
        localqr.iHM = paramLong1;
      }
    }
    else
    {
      if (paramLong4 != 0L) {
        localqr.iOd = paramLong4;
      }
      if (paramString2 != null) {
        localqr.xR(paramString2);
      }
      localqr = a(localqr);
      if (!Util.isNullOrNil(localqr.iwJ)) {
        break label203;
      }
    }
    label203:
    for (paramString2 = new JSONObject();; paramString2 = new JSONObject(localqr.iwJ))
    {
      paramString2.put("cdnErrorCode", paramInt1);
      paramString2 = paramString2.toString();
      s.s(paramString2, "jsonObject.toString()");
      localqr.xS(n.a(paramString2, ',', ';'));
      localqr.jtu = paramInt2;
      localqr.ikE = 3L;
      localqr.bMH();
      btQ(paramString1);
      AppMethodBeat.o(231926);
      return;
      paramLong1 = 2L;
      break;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(231907);
    if (paramString2 == null)
    {
      AppMethodBeat.o(231907);
      return;
    }
    com.tencent.threadpool.h.ahAA.bn(new d..ExternalSyntheticLambda3(paramString2, paramLong1, paramLong2, paramLong3, paramBoolean, paramLong4, paramString1, paramInt2, paramInt1));
    AppMethodBeat.o(231907);
  }
  
  public static void a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean)
  {
    AppMethodBeat.i(231906);
    if (paramString2 == null)
    {
      AppMethodBeat.o(231906);
      return;
    }
    com.tencent.threadpool.h.ahAA.bn(new d..ExternalSyntheticLambda4(paramString2, paramString1, paramLong1, paramLong3, paramLong2, paramBoolean, paramLong4));
    AppMethodBeat.o(231906);
  }
  
  private static final void a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, long paramLong4)
  {
    AppMethodBeat.i(231920);
    paramString1 = btP(paramString1);
    paramString1.xR(paramString2);
    paramString1.iCW = paramLong1;
    paramString1.jtk = paramLong2;
    paramString1.iSD = paramLong3;
    if (paramBoolean) {}
    for (paramLong1 = 1L;; paramLong1 = 2L)
    {
      paramString1.iHM = paramLong1;
      paramString1.iOd = paramLong4;
      paramString1 = a(paramString1);
      paramString1.ikE = 1L;
      paramString1.bMH();
      AppMethodBeat.o(231920);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    Object localObject = null;
    AppMethodBeat.i(231904);
    if (!((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yMd, true))
    {
      AppMethodBeat.o(231904);
      return;
    }
    qq localqq = new qq();
    localqq.imW = 1;
    int i;
    if (paramBoolean)
    {
      i = 0;
      localqq.jtr = i;
      localqq.jts = paramInt2;
      localqq.iYK = paramInt1;
      localqq.jtp = -1;
      if (com.tencent.mm.vfs.y.ZC(paramString1))
      {
        paramString1 = f.aMu(paramString1);
        if (paramString1 != null) {
          break label200;
        }
        paramString1 = null;
        label100:
        localqq.jsI = localqq.F("OriginMediaInfo", paramString1, true);
      }
      if ((paramBoolean) && (com.tencent.mm.vfs.y.ZC(paramString2)))
      {
        paramString1 = f.aMu(paramString2);
        if (paramString1 != null) {
          break label212;
        }
        paramString1 = null;
        label137:
        localqq.jsq = localqq.F("OutputMediaInfo", paramString1, true);
      }
      if (paramString3 != null) {
        break label224;
      }
    }
    label200:
    label212:
    label224:
    for (paramString1 = localObject;; paramString1 = n.a(paramString3, ',', ';'))
    {
      localqq.jtq = localqq.F("RemuxInfo", paramString1, true);
      localqq.jtt = -1;
      localqq.bMH();
      AppMethodBeat.o(231904);
      return;
      i = -2;
      break;
      paramString1 = n.a(paramString1, ',', ';');
      break label100;
      paramString1 = n.a(paramString1, ',', ';');
      break label137;
    }
  }
  
  public static void btM(String paramString)
  {
    AppMethodBeat.i(231909);
    if (paramString == null)
    {
      AppMethodBeat.o(231909);
      return;
    }
    com.tencent.threadpool.h.ahAA.bn(new d..ExternalSyntheticLambda2(paramString));
    AppMethodBeat.o(231909);
  }
  
  public static void btN(String paramString)
  {
    AppMethodBeat.i(231910);
    if (paramString == null)
    {
      AppMethodBeat.o(231910);
      return;
    }
    com.tencent.threadpool.h.ahAA.bn(new d..ExternalSyntheticLambda1(paramString));
    AppMethodBeat.o(231910);
  }
  
  public static void btO(String paramString)
  {
    AppMethodBeat.i(231911);
    if (paramString == null)
    {
      AppMethodBeat.o(231911);
      return;
    }
    com.tencent.threadpool.h.ahAA.bn(new d..ExternalSyntheticLambda0(paramString));
    AppMethodBeat.o(231911);
  }
  
  private static qr btP(String paramString)
  {
    AppMethodBeat.i(231916);
    Object localObject3 = tRl.get(paramString);
    Object localObject1 = localObject3;
    qr localqr;
    if (localObject3 == null)
    {
      localqr = new qr();
      if (paramString != null) {
        break label286;
      }
      localObject1 = "";
      localqr.xQ((String)localObject1);
      localObject1 = ab.Qo(paramString);
      localObject3 = null;
      if (localObject1 == null) {
        break label386;
      }
      if (!Util.isNullOrNil(((z)localObject1).bOt())) {
        break label337;
      }
      if (!Util.isNullOrNil(((z)localObject1).oYk)) {
        break label300;
      }
      v.bOh();
      localObject1 = aa.PX(paramString);
    }
    try
    {
      label82:
      localObject4 = SightVideoJNI.getSimpleMp4InfoVFS((String)localObject1);
      localObject3 = localObject4;
      Log.i("MicroMsg.VideoSendReporter", "getSimpleMp4Info: %s", new Object[] { localObject4 });
      localObject3 = localObject4;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject4;
        label286:
        label300:
        label337:
        Log.e("MicroMsg.VideoSendReporter", "getBasicReportData, get video meta fail", new Object[] { localException2 });
      }
    }
    if (localObject3 != null) {}
    for (;;)
    {
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        localObject4 = com.tencent.mm.kernel.h.az(a.class);
        s.s(localObject4, "plugin(IPluginVideoColorSpaceDetector::class.java)");
        localObject4 = ((a)localObject4).getVideoColorSpaceJson((String)localObject1);
        if (localObject4 != null)
        {
          localObject4 = new JSONObject((String)localObject4);
          ((JSONObject)localObject3).put("colorRange", ((JSONObject)localObject4).getInt("colorRange"));
          ((JSONObject)localObject3).put("colorStandard", ((JSONObject)localObject4).getInt("colorStandard"));
          ((JSONObject)localObject3).put("colorTransfer", ((JSONObject)localObject4).getInt("colorTransfer"));
        }
        ((JSONObject)localObject3).put("isH265", com.tencent.mm.modelvideo.y.isH265Video((String)localObject1));
        localObject1 = ((JSONObject)localObject3).toString();
        s.s(localObject1, "jsonObj.toString()");
        localqr.xS(n.bV((String)localObject1, ",", ";"));
        localObject1 = localqr;
        ((Map)tRl).put(paramString, localObject1);
        paramString = (qr)localObject1;
        AppMethodBeat.o(231916);
        return paramString;
      }
      catch (Exception localException1)
      {
        Log.e("MicroMsg.VideoSendReporter", "parse video meta json error", new Object[] { localException1 });
      }
      localObject1 = s.X(paramString, Long.valueOf(System.currentTimeMillis()));
      break;
      if (ab.Qo(((z)localObject1).oYk) != null)
      {
        v.bOh();
        localObject1 = aa.PX(((z)localObject1).oYk);
        break label82;
      }
      v.bOh();
      localObject1 = aa.PX(paramString);
      break label82;
      localObject1 = ((z)localObject1).bOt();
      break label82;
      label386:
      Object localObject2 = localqr;
    }
  }
  
  private static void btQ(String paramString)
  {
    AppMethodBeat.i(231917);
    if (paramString == null)
    {
      AppMethodBeat.o(231917);
      return;
    }
    tRl.remove(paramString);
    AppMethodBeat.o(231917);
  }
  
  private static final void btR(String paramString)
  {
    AppMethodBeat.i(231930);
    paramString = a(btP(paramString));
    paramString.ikE = 5L;
    paramString.bMH();
    AppMethodBeat.o(231930);
  }
  
  private static final void btS(String paramString)
  {
    AppMethodBeat.i(231935);
    qr localqr1 = btP(paramString);
    qr localqr2 = a(localqr1);
    localqr2.ikE = 4L;
    if (!Util.isNullOrNil(localqr2.iWh))
    {
      localqr2.bMH();
      AppMethodBeat.o(231935);
      return;
    }
    z localz = ab.Qo(paramString);
    if (localz == null)
    {
      AppMethodBeat.o(231935);
      return;
    }
    localqr1.xR(localz.bOs());
    localqr1.iCW = (localz.omT * 1000L);
    v.bOh();
    localqr1.jtk = com.tencent.mm.vfs.y.bEl(aa.PX(paramString));
    localqr1.iSD = com.tencent.mm.vfs.y.bEl(localz.bOt());
    if (localz.oYk != null) {}
    for (long l = 1L;; l = 2L)
    {
      localqr1.iHM = l;
      localqr2.xR(localqr1.iWh);
      localqr2.iCW = localqr1.iCW;
      localqr2.jtk = localqr1.jtk;
      localqr2.iSD = localqr1.iSD;
      localqr2.iHM = localqr1.iHM;
      localqr2.bMH();
      AppMethodBeat.o(231935);
      return;
    }
  }
  
  private static final void btT(String paramString)
  {
    AppMethodBeat.i(231937);
    qr localqr = a(btP(paramString));
    localqr.ikE = 2L;
    localqr.bMH();
    btQ(paramString);
    AppMethodBeat.o(231937);
  }
  
  public static int q(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {
      return 3;
    }
    if ((paramBoolean1) || (paramBoolean2)) {
      return 4;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cb.d
 * JD-Core Version:    0.7.0.1
 */