package com.tencent.mm.plugin.ai.d.b;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ai.b.a.a.e;
import com.tencent.mm.plugin.ai.b.a.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.s;
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

public final class a
{
  private String kwQ;
  String kwR;
  String kwS;
  private org.tensorflow.lite.c kwT;
  e kwU;
  f kwV;
  private float[][] kwW;
  private Map<Integer, Object> kwX;
  private boolean kwY;
  public long kwZ;
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(238912);
    this.kwY = false;
    this.kwZ = 0L;
    this.kwQ = paramString1;
    this.kwR = paramString2;
    this.kwS = paramString3;
    com.tencent.f.h.RTc.b(new a.1(this), "Ai_thread");
    AppMethodBeat.o(238912);
  }
  
  private MappedByteBuffer bqw()
  {
    AppMethodBeat.i(238913);
    if (Util.isNullOrNil(this.kwQ))
    {
      AppMethodBeat.o(238913);
      return null;
    }
    if (!s.YS(this.kwQ))
    {
      Log.w("MicroMsg.FinderRedDotDetector", "loadModel error, model file not exists. [%s]", new Object[] { this.kwQ });
      AppMethodBeat.o(238913);
      return null;
    }
    try
    {
      Object localObject = s.dB(this.kwQ, false);
      localObject = ((RandomAccessFile)localObject).getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, ((RandomAccessFile)localObject).length());
      AppMethodBeat.o(238913);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FinderRedDotDetector", localException, "load model error [%s]", new Object[] { this.kwQ });
      com.tencent.mm.plugin.report.service.h.CyF.dN(1559, 21);
      Log.w("MicroMsg.FinderRedDotDetector", "loadModel error, can not open model file. [%s]", new Object[] { this.kwQ });
      AppMethodBeat.o(238913);
    }
    return null;
  }
  
  public final float ci(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238914);
    if ((this.kwV == null) || (this.kwU == null))
    {
      AppMethodBeat.o(238914);
      return -1.0F;
    }
    this.kwZ = Util.nowMilliSecond();
    final long l1 = Util.currentTicks();
    final com.tencent.mm.plugin.ai.b.a.a.d locald;
    if (!"debug".equals(paramString1))
    {
      locald = new com.tencent.mm.plugin.ai.b.a.a.d(new com.tencent.mm.g.b.a.d(paramString1), this.kwU, this.kwV);
      f = -1.0F;
    }
    for (;;)
    {
      try
      {
        if (!this.kwY)
        {
          l2 = Util.currentTicks();
          localObject = bqw();
          if (localObject != null) {
            continue;
          }
          Log.w("MicroMsg.FinderRedDotDetector", "init interpreter error, model is null modelPath[%s]", new Object[] { this.kwQ });
          if (this.kwT != null) {
            this.kwT.close();
          }
          this.kwT = null;
        }
        if (this.kwT == null) {
          continue;
        }
        this.kwW[0][0] = 0;
        localObject = this.kwT;
        Object[] arrayOfObject = locald.bqu();
        Map localMap = this.kwX;
        ((org.tensorflow.lite.c)localObject).oa();
        ((org.tensorflow.lite.c)localObject).UiX.a(arrayOfObject, localMap);
        f = this.kwW[0][0];
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
        com.tencent.mm.plugin.report.service.h.CyF.dN(1559, 22);
        continue;
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.FinderRedDotDetector", localThrowable, "tf run model error.[%s]", new Object[] { paramString1 });
        f = -1.0F;
        continue;
        int i = 0;
        continue;
      }
      l1 = Util.ticksToNow(l1);
      Log.i("MicroMsg.FinderRedDotDetector", "run finish [%f] cost[%d] info [%s]", new Object[] { Float.valueOf(f), Long.valueOf(l1), paramString1 });
      com.tencent.f.h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(238911);
          com.tencent.mm.plugin.ai.b.a.a.d locald = locald;
          float f = f;
          long l = l1;
          String str = this.kxe;
          Object localObject2 = new JSONObject();
          Object localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("_7dayClkH", locald.kwd);
            ((JSONObject)localObject2).put("_7dayClkRateH", locald.kwe);
            ((JSONObject)localObject2).put("_7dayImprH", locald.kwc);
            ((JSONObject)localObject2).put("friendsTabUnread", locald.kwf);
            ((JSONObject)localObject2).put("fromLastHours", locald.kwa);
            ((JSONObject)localObject2).put("isFriendsTabRedDot", locald.kwl);
            ((JSONObject)localObject2).put("isNewMsgOpenWechat", locald.kwq);
            ((JSONObject)localObject2).put("isSnsRedDot", locald.kwj);
            ((JSONObject)localObject2).put("isTopStoryRedDot", locald.kwk);
            ((JSONObject)localObject2).put("label", locald.kwg);
            ((JSONObject)localObject2).put("lastStaySecs", locald.kwb);
            ((JSONObject)localObject2).put("lastFinderRedDotCtrlType", locald.kwn);
            ((JSONObject)localObject2).put("lastFinderRedDotShowType", locald.kwm);
            ((JSONObject)localObject2).put("lastSessionId", locald.kwp);
            ((JSONObject)localObject2).put("snsunread", locald.kvZ);
            ((JSONObject)localObject2).put("startTimeTo24H", locald.kwi);
            ((JSONObject)localObject2).put("startTimeToWeekDay", locald.kwh);
            ((JSONObject)localObject2).put("wechatduration7dayhour", locald.kwr);
            ((JSONObject)localObject2).put("wechatdurationnminute_10", locald.kws);
            ((JSONObject)localObject2).put("wechatdurationnminute_30", locald.kwt);
            ((JSONObject)localObject2).put("wechatdurationnminute_90", locald.kwu);
            ((JSONObject)localObject2).put("findfrienduiexposure_10", locald.kwv);
            ((JSONObject)localObject2).put("findfrienduiexposure_30", locald.kww);
            ((JSONObject)localObject2).put("findfrienduiexposure_90", locald.kwx);
            ((JSONObject)localObject2).put("lastsessionduration", locald.kwo);
            ((JSONObject)localObject1).put("result", f);
            localObject2 = ((JSONObject)localObject2).toString().replace(",", ";");
            localObject1 = ((JSONObject)localObject1).toString().replace(",", ";");
            com.tencent.mm.g.b.a.c localc = new com.tencent.mm.g.b.a.c();
            localc.eiP = localc.x("InputJson", (String)localObject2, true);
            localc.eiQ = localc.x("OutputJson", (String)localObject1, true);
            localc.eiR = l;
            localc.eiS = localc.x("ModelMd5", str, true);
            localc.eiT = localc.x("OriInputJson", locald.kwy, true);
            localc.bfK();
            if (f > 0.0F)
            {
              com.tencent.mm.plugin.report.service.h.CyF.dN(1559, 5);
              if (l >= 1000L) {
                com.tencent.mm.plugin.report.service.h.CyF.dN(1559, 7);
              }
              int i = (int)(100.0F * f);
              int j = ((Integer)com.tencent.mm.plugin.report.service.h.a(i, new int[] { 20, 40, 60, 80, 100 }, 10, 15)).intValue();
              com.tencent.mm.plugin.report.service.h.CyF.dN(1559, j);
              Log.i("MicroMsg.AiFinderFeatureStruct", "report idkey score[%d] res[%d] struct[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localc.abW() });
              AppMethodBeat.o(238911);
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.AiFinderFeatureStruct", localJSONException, "report result error", new Object[0]);
              continue;
              com.tencent.mm.plugin.report.service.h.CyF.dN(1559, 6);
            }
          }
        }
      }, "Ai_thread");
      AppMethodBeat.o(238914);
      return f;
      locald = new com.tencent.mm.plugin.ai.b.a.a.d();
      locald.kwd = 0.95F;
      locald.kwe = 0.8F;
      locald.kwc = 0.95F;
      locald.kwf = 0.9F;
      locald.kwa = 0.4F;
      locald.kwl = 1L;
      locald.kwq = 1L;
      locald.kwj = 2L;
      locald.kwk = 1L;
      locald.kwg = 0.0F;
      locald.kwb = 0.75F;
      locald.kwn = 3L;
      locald.kwm = 2L;
      locald.kwp = 1L;
      locald.kvZ = 0.9F;
      locald.kwi = 14L;
      locald.kwh = 2L;
      locald.kwo = 0.4F;
      locald.kwr = 0.4F;
      locald.kws = 0.4F;
      locald.kwt = 0.4F;
      locald.kwu = 0.4F;
      locald.kwv = 0.4F;
      locald.kww = 0.4F;
      locald.kwx = 0.4F;
      break;
      this.kwT = new org.tensorflow.lite.c(((MappedByteBuffer)localObject).asReadOnlyBuffer());
      this.kwW = ((float[][])Array.newInstance(Float.TYPE, new int[] { 1, 1 }));
      this.kwX = new HashMap();
      this.kwX.put(Integer.valueOf(0), this.kwW);
      this.kwY = true;
      localObject = this.kwT;
      ((org.tensorflow.lite.c)localObject).oa();
      j = ((org.tensorflow.lite.c)localObject).UiX.Ujm.length;
      localObject = this.kwT;
      ((org.tensorflow.lite.c)localObject).oa();
      k = ((org.tensorflow.lite.c)localObject).UiX.Ujn.length;
      if (WeChatEnvironment.hasDebugger())
      {
        i = 0;
        if (i >= j) {
          continue;
        }
        localObject = this.kwT;
        ((org.tensorflow.lite.c)localObject).oa();
        localObject = ((org.tensorflow.lite.c)localObject).UiX.awn(i);
        Log.i("MicroMsg.FinderRedDotDetector", "model info index[%d] inputType[%s, %d, %s] dataType[%s]", new Object[] { Integer.valueOf(i), Tensor.name(((Tensor)localObject).nativeHandle), Integer.valueOf(Tensor.numBytes(((Tensor)localObject).nativeHandle)), localObject, ((Tensor)localObject).Ujq });
        i += 1;
        continue;
        if (i < k)
        {
          localObject = this.kwT;
          ((org.tensorflow.lite.c)localObject).oa();
          localObject = ((org.tensorflow.lite.c)localObject).UiX.awo(i);
          Log.i("MicroMsg.FinderRedDotDetector", "model info index[%d] outputType[%s, %d, %s] dataType[%s]", new Object[] { Integer.valueOf(i), Tensor.name(((Tensor)localObject).nativeHandle), Integer.valueOf(Tensor.numBytes(((Tensor)localObject).nativeHandle)), localObject, ((Tensor)localObject).Ujq });
          i += 1;
          continue;
        }
      }
      localObject = s.bhK(this.kwQ);
      Log.i("MicroMsg.FinderRedDotDetector", "initInterpreter cost[%d] model[%s] md5[%s] inputCount[%d] outputCount[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l2)), this.kwQ, localObject, Integer.valueOf(j), Integer.valueOf(k) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.b.a
 * JD-Core Version:    0.7.0.1
 */