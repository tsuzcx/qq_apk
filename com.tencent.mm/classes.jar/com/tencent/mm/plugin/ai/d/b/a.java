package com.tencent.mm.plugin.ai.d.b;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.e;
import com.tencent.mm.plugin.ai.b.a.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
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
  private String npK;
  String npL;
  String npM;
  private c npN;
  com.tencent.mm.plugin.ai.b.a.a.f npO;
  g npP;
  private float[][] npQ;
  private Map<Integer, Object> npR;
  private boolean npS;
  public long npT;
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(240481);
    this.npS = false;
    this.npT = 0L;
    this.npK = paramString1;
    this.npL = paramString2;
    this.npM = paramString3;
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        int j = 0;
        AppMethodBeat.i(240017);
        a locala = a.this;
        long l = Util.currentTicks();
        Object localObject;
        if (locala.npO == null)
        {
          localObject = new com.tencent.mm.plugin.ai.b.a.a.f(locala.npL);
          if (((com.tencent.mm.plugin.ai.b.a.a.f)localObject).uY()) {
            locala.npO = ((com.tencent.mm.plugin.ai.b.a.a.f)localObject);
          }
        }
        else
        {
          if (locala.npP == null)
          {
            localObject = new g(locala.npM);
            ((g)localObject).uY();
            locala.npP = ((g)localObject);
          }
          if (locala.npO == null) {
            break label178;
          }
        }
        label178:
        for (int i = locala.npO.hashCode();; i = 0)
        {
          if (locala.npP != null) {
            j = locala.npP.hashCode();
          }
          Log.i("MicroMsg.FinderRedDotDetector", "init config finish aiFinderQuantiles [%d] aiFinderTffeat2idx[%d] cost[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Util.ticksToNow(l)) });
          AppMethodBeat.o(240017);
          return;
          com.tencent.mm.plugin.report.service.h.IzE.el(1559, 43);
          break;
        }
      }
    }, "Ai_thread");
    AppMethodBeat.o(240481);
  }
  
  private MappedByteBuffer bBh()
  {
    AppMethodBeat.i(240485);
    if (Util.isNullOrNil(this.npK))
    {
      AppMethodBeat.o(240485);
      return null;
    }
    if (!u.agG(this.npK))
    {
      Log.w("MicroMsg.FinderRedDotDetector", "loadModel error, model file not exists. [%s]", new Object[] { this.npK });
      AppMethodBeat.o(240485);
      return null;
    }
    try
    {
      Object localObject = u.dO(this.npK, false);
      localObject = ((RandomAccessFile)localObject).getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, ((RandomAccessFile)localObject).length());
      AppMethodBeat.o(240485);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FinderRedDotDetector", localException, "load model error [%s]", new Object[] { this.npK });
      com.tencent.mm.plugin.report.service.h.IzE.el(1559, 21);
      Log.w("MicroMsg.FinderRedDotDetector", "loadModel error, can not open model file. [%s]", new Object[] { this.npK });
      AppMethodBeat.o(240485);
    }
    return null;
  }
  
  public final float cn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(240493);
    if ((this.npP == null) || (this.npO == null))
    {
      AppMethodBeat.o(240493);
      return -1.0F;
    }
    this.npT = Util.nowMilliSecond();
    final long l1 = Util.currentTicks();
    final com.tencent.mm.plugin.ai.b.a.a.d locald;
    if (!"debug".equals(paramString1))
    {
      locald = new com.tencent.mm.plugin.ai.b.a.a.d(new e(paramString1), this.npO, this.npP);
      f = -1.0F;
    }
    for (;;)
    {
      try
      {
        if (!this.npS)
        {
          l2 = Util.currentTicks();
          localObject = bBh();
          if (localObject != null) {
            continue;
          }
          Log.w("MicroMsg.FinderRedDotDetector", "init interpreter error, model is null modelPath[%s]", new Object[] { this.npK });
          if (this.npN != null) {
            this.npN.close();
          }
          this.npN = null;
        }
        if (this.npN == null) {
          continue;
        }
        this.npQ[0][0] = 0;
        localObject = this.npN;
        Object[] arrayOfObject = locald.bAY();
        Map localMap = this.npR;
        ((c)localObject).isP();
        ((c)localObject).abMs.a(arrayOfObject, localMap);
        f = this.npQ[0][0];
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
        com.tencent.mm.plugin.report.service.h.IzE.el(1559, 22);
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
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(240193);
          com.tencent.mm.plugin.ai.b.a.a.d locald = locald;
          float f = f;
          long l = l1;
          String str = this.npY;
          Object localObject2 = new JSONObject();
          Object localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("_7dayClkH", locald.nol);
            ((JSONObject)localObject2).put("_7dayClkRateH", locald.nom);
            ((JSONObject)localObject2).put("_7dayImprH", locald.nok);
            ((JSONObject)localObject2).put("friendsTabUnread", locald.non);
            ((JSONObject)localObject2).put("fromLastHours", locald.noi);
            ((JSONObject)localObject2).put("isFriendsTabRedDot", locald.not);
            ((JSONObject)localObject2).put("isNewMsgOpenWechat", locald.noy);
            ((JSONObject)localObject2).put("isSnsRedDot", locald.nor);
            ((JSONObject)localObject2).put("isTopStoryRedDot", locald.nos);
            ((JSONObject)localObject2).put("label", locald.noo);
            ((JSONObject)localObject2).put("lastStaySecs", locald.noj);
            ((JSONObject)localObject2).put("lastFinderRedDotCtrlType", locald.nov);
            ((JSONObject)localObject2).put("lastFinderRedDotShowType", locald.nou);
            ((JSONObject)localObject2).put("lastSessionId", locald.nox);
            ((JSONObject)localObject2).put("snsunread", locald.noh);
            ((JSONObject)localObject2).put("startTimeTo24H", locald.noq);
            ((JSONObject)localObject2).put("startTimeToWeekDay", locald.nop);
            ((JSONObject)localObject2).put("wechatduration7dayhour", locald.noz);
            ((JSONObject)localObject2).put("wechatdurationnminute_10", locald.noA);
            ((JSONObject)localObject2).put("wechatdurationnminute_30", locald.noB);
            ((JSONObject)localObject2).put("wechatdurationnminute_90", locald.noC);
            ((JSONObject)localObject2).put("findfrienduiexposure_10", locald.noD);
            ((JSONObject)localObject2).put("findfrienduiexposure_30", locald.noE);
            ((JSONObject)localObject2).put("findfrienduiexposure_90", locald.noF);
            ((JSONObject)localObject2).put("lastsessionduration", locald.now);
            ((JSONObject)localObject1).put("result", f);
            localObject2 = ((JSONObject)localObject2).toString().replace(",", ";");
            localObject1 = ((JSONObject)localObject1).toString().replace(",", ";");
            com.tencent.mm.f.b.a.d locald1 = new com.tencent.mm.f.b.a.d();
            locald1.gdi = locald1.z("InputJson", (String)localObject2, true);
            locald1.gdj = locald1.z("OutputJson", (String)localObject1, true);
            locald1.gdk = l;
            locald1.gdl = locald1.z("ModelMd5", str, true);
            locald1.gdm = locald1.z("OriInputJson", locald.noG, true);
            locald1.bpa();
            if (f > 0.0F)
            {
              com.tencent.mm.plugin.report.service.h.IzE.el(1559, 5);
              if (l >= 1000L) {
                com.tencent.mm.plugin.report.service.h.IzE.el(1559, 7);
              }
              int i = (int)(100.0F * f);
              int j = ((Integer)com.tencent.mm.plugin.report.service.h.a(i, new int[] { 20, 40, 60, 80, 100 }, 10, 15)).intValue();
              com.tencent.mm.plugin.report.service.h.IzE.el(1559, j);
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCm, locald1.agH());
              Log.i("MicroMsg.AiFinderFeatureStruct", "report idkey score[%d] res[%d] struct[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), locald1.agI() });
              AppMethodBeat.o(240193);
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.AiFinderFeatureStruct", localJSONException, "report result error", new Object[0]);
              continue;
              com.tencent.mm.plugin.report.service.h.IzE.el(1559, 6);
            }
          }
        }
      }, "Ai_thread");
      AppMethodBeat.o(240493);
      return f;
      locald = new com.tencent.mm.plugin.ai.b.a.a.d();
      locald.nol = 0.95F;
      locald.nom = 0.8F;
      locald.nok = 0.95F;
      locald.non = 0.9F;
      locald.noi = 0.4F;
      locald.not = 1L;
      locald.noy = 1L;
      locald.nor = 2L;
      locald.nos = 1L;
      locald.noo = 0.0F;
      locald.noj = 0.75F;
      locald.nov = 3L;
      locald.nou = 2L;
      locald.nox = 1L;
      locald.noh = 0.9F;
      locald.noq = 14L;
      locald.nop = 2L;
      locald.now = 0.4F;
      locald.noz = 0.4F;
      locald.noA = 0.4F;
      locald.noB = 0.4F;
      locald.noC = 0.4F;
      locald.noD = 0.4F;
      locald.noE = 0.4F;
      locald.noF = 0.4F;
      break;
      this.npN = new c(((MappedByteBuffer)localObject).asReadOnlyBuffer());
      this.npQ = ((float[][])Array.newInstance(Float.TYPE, new int[] { 1, 1 }));
      this.npR = new HashMap();
      this.npR.put(Integer.valueOf(0), this.npQ);
      this.npS = true;
      localObject = this.npN;
      ((c)localObject).isP();
      j = ((c)localObject).abMs.abMH.length;
      localObject = this.npN;
      ((c)localObject).isP();
      k = ((c)localObject).abMs.abMI.length;
      if (WeChatEnvironment.hasDebugger())
      {
        i = 0;
        if (i >= j) {
          continue;
        }
        localObject = this.npN;
        ((c)localObject).isP();
        localObject = ((c)localObject).abMs.aGi(i);
        Log.i("MicroMsg.FinderRedDotDetector", "model info index[%d] inputType[%s, %d, %s] dataType[%s]", new Object[] { Integer.valueOf(i), Tensor.name(((Tensor)localObject).nativeHandle), Integer.valueOf(Tensor.numBytes(((Tensor)localObject).nativeHandle)), localObject, ((Tensor)localObject).abML });
        i += 1;
        continue;
        if (i < k)
        {
          localObject = this.npN;
          ((c)localObject).isP();
          localObject = ((c)localObject).abMs.aGj(i);
          Log.i("MicroMsg.FinderRedDotDetector", "model info index[%d] outputType[%s, %d, %s] dataType[%s]", new Object[] { Integer.valueOf(i), Tensor.name(((Tensor)localObject).nativeHandle), Integer.valueOf(Tensor.numBytes(((Tensor)localObject).nativeHandle)), localObject, ((Tensor)localObject).abML });
          i += 1;
          continue;
        }
      }
      localObject = u.buc(this.npK);
      Log.i("MicroMsg.FinderRedDotDetector", "initInterpreter cost[%d] model[%s] md5[%s] inputCount[%d] outputCount[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l2)), this.npK, localObject, Integer.valueOf(j), Integer.valueOf(k) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.b.a
 * JD-Core Version:    0.7.0.1
 */