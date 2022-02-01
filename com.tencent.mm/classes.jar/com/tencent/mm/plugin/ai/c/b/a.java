package com.tencent.mm.plugin.ai.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.e;
import com.tencent.mm.plugin.ai.data.business.finder.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.tensorflow.lite.NativeInterpreterWrapper;
import org.tensorflow.lite.Tensor;
import org.tensorflow.lite.c;

public final class a
{
  private String qop;
  String qoq;
  String qor;
  private c qos;
  com.tencent.mm.plugin.ai.data.business.finder.f qot;
  g qou;
  private float[][] qov;
  private Map<Integer, Object> qow;
  private boolean qox;
  public long qoy;
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(267441);
    this.qox = false;
    this.qoy = 0L;
    this.qop = paramString1;
    this.qoq = paramString2;
    this.qor = paramString3;
    com.tencent.threadpool.h.ahAA.g(new a.1(this), "Ai_thread");
    AppMethodBeat.o(267441);
  }
  
  private MappedByteBuffer cay()
  {
    AppMethodBeat.i(267454);
    if (Util.isNullOrNil(this.qop))
    {
      AppMethodBeat.o(267454);
      return null;
    }
    if (!y.ZC(this.qop))
    {
      Log.w("MicroMsg.FinderRedDotDetector", "loadModel error, model file not exists. [%s]", new Object[] { this.qop });
      AppMethodBeat.o(267454);
      return null;
    }
    try
    {
      Object localObject = y.eA(this.qop, false);
      localObject = ((RandomAccessFile)localObject).getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, ((RandomAccessFile)localObject).length());
      AppMethodBeat.o(267454);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FinderRedDotDetector", localException, "load model error [%s]", new Object[] { this.qop });
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, 21);
      Log.w("MicroMsg.FinderRedDotDetector", "loadModel error, can not open model file. [%s]", new Object[] { this.qop });
      AppMethodBeat.o(267454);
    }
    return null;
  }
  
  public final float cD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267475);
    if ((this.qou == null) || (this.qot == null))
    {
      AppMethodBeat.o(267475);
      return -1.0F;
    }
    this.qoy = Util.nowMilliSecond();
    final long l1 = Util.currentTicks();
    final com.tencent.mm.plugin.ai.data.business.finder.d locald;
    if (!"debug".equals(paramString1))
    {
      locald = new com.tencent.mm.plugin.ai.data.business.finder.d(new e(paramString1), this.qot, this.qou);
      f = -1.0F;
    }
    for (;;)
    {
      try
      {
        if (!this.qox)
        {
          l2 = Util.currentTicks();
          localObject = cay();
          if (localObject != null) {
            continue;
          }
          Log.w("MicroMsg.FinderRedDotDetector", "init interpreter error, model is null modelPath[%s]", new Object[] { this.qop });
          if (this.qos != null) {
            this.qos.close();
          }
          this.qos = null;
        }
        if (this.qos == null) {
          continue;
        }
        this.qov[0][0] = 0;
        localObject = this.qos;
        Object[] arrayOfObject = locald.bZL();
        Map localMap = this.qow;
        ((c)localObject).kcl();
        ((c)localObject).ajZm.a(arrayOfObject, localMap);
        f = this.qov[0][0];
      }
      catch (Exception localException)
      {
        long l2;
        Object localObject;
        int j;
        int k;
        Log.printErrStackTrace("MicroMsg.FinderRedDotDetector", localException, "tf run model error.[%s]", new Object[] { paramString1 });
        f = -1.0F;
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, 22);
        continue;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.FinderRedDotDetector", localThrowable, "tf run model error.[%s]", new Object[] { paramString1 });
        f = -1.0F;
        continue;
        int i = 0;
        continue;
      }
      l1 = Util.ticksToNow(l1);
      Log.i("MicroMsg.FinderRedDotDetector", "run finish [%f] cost[%d] info [%s]", new Object[] { Float.valueOf(f), Long.valueOf(l1), paramString1 });
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(267463);
          com.tencent.mm.plugin.ai.data.business.finder.d locald = locald;
          float f = f;
          long l = l1;
          String str = this.qoD;
          Object localObject2 = new JSONObject();
          Object localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("_7dayClkH", locald.qls);
            ((JSONObject)localObject2).put("_7dayClkRateH", locald.qlt);
            ((JSONObject)localObject2).put("_7dayImprH", locald.qlr);
            ((JSONObject)localObject2).put("friendsTabUnread", locald.qlu);
            ((JSONObject)localObject2).put("fromLastHours", locald.qlp);
            ((JSONObject)localObject2).put("isFriendsTabRedDot", locald.qlA);
            ((JSONObject)localObject2).put("isNewMsgOpenWechat", locald.qlF);
            ((JSONObject)localObject2).put("isSnsRedDot", locald.qly);
            ((JSONObject)localObject2).put("isTopStoryRedDot", locald.qlz);
            ((JSONObject)localObject2).put("label", locald.qlv);
            ((JSONObject)localObject2).put("lastStaySecs", locald.qlq);
            ((JSONObject)localObject2).put("lastFinderRedDotCtrlType", locald.qlC);
            ((JSONObject)localObject2).put("lastFinderRedDotShowType", locald.qlB);
            ((JSONObject)localObject2).put("lastSessionId", locald.qlE);
            ((JSONObject)localObject2).put("snsunread", locald.qlo);
            ((JSONObject)localObject2).put("startTimeTo24H", locald.qlx);
            ((JSONObject)localObject2).put("startTimeToWeekDay", locald.qlw);
            ((JSONObject)localObject2).put("wechatduration7dayhour", locald.qlG);
            ((JSONObject)localObject2).put("wechatdurationnminute_10", locald.qlH);
            ((JSONObject)localObject2).put("wechatdurationnminute_30", locald.qlI);
            ((JSONObject)localObject2).put("wechatdurationnminute_90", locald.qlJ);
            ((JSONObject)localObject2).put("findfrienduiexposure_10", locald.qlK);
            ((JSONObject)localObject2).put("findfrienduiexposure_30", locald.qlL);
            ((JSONObject)localObject2).put("findfrienduiexposure_90", locald.qlM);
            ((JSONObject)localObject2).put("lastsessionduration", locald.qlD);
            ((JSONObject)localObject1).put("result", f);
            localObject2 = ((JSONObject)localObject2).toString().replace(",", ";");
            localObject1 = ((JSONObject)localObject1).toString().replace(",", ";");
            com.tencent.mm.autogen.mmdata.rpt.d locald1 = new com.tencent.mm.autogen.mmdata.rpt.d();
            locald1.ijy = locald1.F("InputJson", (String)localObject2, true);
            locald1.ijz = locald1.F("OutputJson", (String)localObject1, true);
            locald1.ijA = l;
            locald1.ijB = locald1.F("ModelMd5", str, true);
            locald1.ijC = locald1.F("OriInputJson", locald.qlN, true);
            locald1.bMH();
            if (f > 0.0F)
            {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, 5);
              if (l >= 1000L) {
                com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, 7);
              }
              int i = (int)(100.0F * f);
              int j = ((Integer)com.tencent.mm.plugin.report.service.h.a(i, new int[] { 20, 40, 60, 80, 100 }, 10, 15)).intValue();
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, j);
              com.tencent.mm.kernel.h.baE().ban().set(at.a.adfb, locald1.aIE());
              Log.i("MicroMsg.AiFinderFeatureStruct", "report idkey score[%d] res[%d] struct[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), locald1.aIF() });
              AppMethodBeat.o(267463);
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.AiFinderFeatureStruct", localJSONException, "report result error", new Object[0]);
              continue;
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, 6);
            }
          }
        }
      }, "Ai_thread");
      AppMethodBeat.o(267475);
      return f;
      locald = new com.tencent.mm.plugin.ai.data.business.finder.d();
      locald.qls = 0.95F;
      locald.qlt = 0.8F;
      locald.qlr = 0.95F;
      locald.qlu = 0.9F;
      locald.qlp = 0.4F;
      locald.qlA = 1L;
      locald.qlF = 1L;
      locald.qly = 2L;
      locald.qlz = 1L;
      locald.qlv = 0.0F;
      locald.qlq = 0.75F;
      locald.qlC = 3L;
      locald.qlB = 2L;
      locald.qlE = 1L;
      locald.qlo = 0.9F;
      locald.qlx = 14L;
      locald.qlw = 2L;
      locald.qlD = 0.4F;
      locald.qlG = 0.4F;
      locald.qlH = 0.4F;
      locald.qlI = 0.4F;
      locald.qlJ = 0.4F;
      locald.qlK = 0.4F;
      locald.qlL = 0.4F;
      locald.qlM = 0.4F;
      break;
      this.qos = new c(((MappedByteBuffer)localObject).asReadOnlyBuffer());
      this.qov = ((float[][])Array.newInstance(Float.TYPE, new int[] { 1, 1 }));
      this.qow = new HashMap();
      this.qow.put(Integer.valueOf(0), this.qov);
      this.qox = true;
      localObject = this.qos;
      ((c)localObject).kcl();
      j = ((c)localObject).ajZm.ajZA.length;
      localObject = this.qos;
      ((c)localObject).kcl();
      k = ((c)localObject).ajZm.ajZB.length;
      if (WeChatEnvironment.hasDebugger())
      {
        i = 0;
        if (i >= j) {
          continue;
        }
        localObject = this.qos;
        ((c)localObject).kcl();
        localObject = ((c)localObject).ajZm.aNx(i);
        Log.i("MicroMsg.FinderRedDotDetector", "model info index[%d] inputType[%s, %d, %s] dataType[%s]", new Object[] { Integer.valueOf(i), Tensor.name(((Tensor)localObject).nativeHandle), Integer.valueOf(Tensor.numBytes(((Tensor)localObject).nativeHandle)), localObject, ((Tensor)localObject).ajZE });
        i += 1;
        continue;
        if (i < k)
        {
          localObject = this.qos;
          ((c)localObject).kcl();
          localObject = ((c)localObject).ajZm.aNy(i);
          Log.i("MicroMsg.FinderRedDotDetector", "model info index[%d] outputType[%s, %d, %s] dataType[%s]", new Object[] { Integer.valueOf(i), Tensor.name(((Tensor)localObject).nativeHandle), Integer.valueOf(Tensor.numBytes(((Tensor)localObject).nativeHandle)), localObject, ((Tensor)localObject).ajZE });
          i += 1;
          continue;
        }
      }
      localObject = y.bub(this.qop);
      Log.i("MicroMsg.FinderRedDotDetector", "initInterpreter cost[%d] model[%s] md5[%s] inputCount[%d] outputCount[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l2)), this.qop, localObject, Integer.valueOf(j), Integer.valueOf(k) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.c.b.a
 * JD-Core Version:    0.7.0.1
 */