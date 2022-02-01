package com.tencent.mm.plugin.ai.e;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.b.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.plugin.ai.a.a
{
  private static int kxf = 100;
  private static a kxg;
  private com.tencent.mm.plugin.ai.d.a.a kxh;
  private com.tencent.mm.plugin.ai.d.b.a kxi;
  private b kxj;
  private LinkedList<Byte> kxk;
  private long kxl;
  public IListener<sz> kxm;
  public IListener<ie> kxn;
  
  private a()
  {
    AppMethodBeat.i(238921);
    this.kxj = null;
    this.kxl = 0L;
    this.kxm = new a.1(this);
    this.kxn = new IListener() {};
    this.kxh = new com.tencent.mm.plugin.ai.d.a.a();
    AppMethodBeat.o(238921);
  }
  
  private boolean aC(float paramFloat)
  {
    AppMethodBeat.i(238924);
    long l = Util.currentTicks();
    byte b = (byte)(int)(100.0F * paramFloat);
    if (b < 0)
    {
      AppMethodBeat.o(238924);
      return false;
    }
    if (this.kxk == null)
    {
      this.kxk = new LinkedList();
      localObject = com.tencent.mm.plugin.ai.f.b.bqC().kxK.aTI().decodeBytes("finder_history");
      if (!Util.isNullOrNil((byte[])localObject))
      {
        i = 0;
        while (i < localObject.length)
        {
          this.kxk.add(Byte.valueOf(localObject[i]));
          if (this.kxk.size() > kxf) {
            break;
          }
          i += 1;
        }
      }
    }
    if (this.kxk.size() < kxf)
    {
      this.kxk.push(Byte.valueOf(b));
      bqy();
      com.tencent.mm.plugin.report.service.h.CyF.dN(1559, 16);
      AppMethodBeat.o(238924);
      return false;
    }
    Object localObject = this.kxk.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (((Byte)((Iterator)localObject).next()).byteValue() <= b) {
        break label353;
      }
      i += 1;
    }
    label339:
    label353:
    for (;;)
    {
      break;
      this.kxk.removeLast();
      this.kxk.push(Byte.valueOf(b));
      bqy();
      if (this.kxj.getPos() < 0)
      {
        AppMethodBeat.o(238924);
        return false;
      }
      boolean bool;
      if (i < this.kxj.getPos())
      {
        bool = true;
        if (!bool) {
          break label339;
        }
        com.tencent.mm.plugin.report.service.h.CyF.dN(1559, 17);
      }
      for (;;)
      {
        Log.i("MicroMsg.AiService", "checkAndSaveResult needSync[%b] [%d %d] cost[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(this.kxj.getPos()), Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(238924);
        return bool;
        bool = false;
        break;
        com.tencent.mm.plugin.report.service.h.CyF.dN(1559, 18);
      }
    }
  }
  
  public static a bqx()
  {
    AppMethodBeat.i(238922);
    if (kxg == null) {
      kxg = new a();
    }
    a locala = kxg;
    AppMethodBeat.o(238922);
    return locala;
  }
  
  private void bqy()
  {
    AppMethodBeat.i(238925);
    if ((this.kxk == null) || (this.kxk.size() <= 0))
    {
      AppMethodBeat.o(238925);
      return;
    }
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238918);
        byte[] arrayOfByte = new byte[Math.min(a.b(a.this).size(), a.Tp())];
        Iterator localIterator = a.b(a.this).iterator();
        int k;
        for (int j = 0;; j = k) {
          if (localIterator.hasNext())
          {
            int i = ((Byte)localIterator.next()).byteValue();
            k = j + 1;
            arrayOfByte[j] = i;
            if (k < a.Tp()) {}
          }
          else
          {
            com.tencent.mm.plugin.ai.f.b.bqC().kxK.aTI().encode("finder_history", arrayOfByte);
            AppMethodBeat.o(238918);
            return;
          }
        }
      }
    }, "Ai_thread");
    AppMethodBeat.o(238925);
  }
  
  private void bqz()
  {
    AppMethodBeat.i(238926);
    if (this.kxj != null) {}
    for (int i = this.kxj.bqB();; i = -1)
    {
      if (i > 0)
      {
        id localid = new id();
        localid.dMJ.dMK = true;
        localid.dMJ.dML = 47613;
        localid.dMJ.scene = i;
        EventCenter.instance.publish(localid);
        this.kxl = Util.nowMilliSecond();
      }
      Log.i("MicroMsg.AiService", "start to finder sync [%d]", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(238926);
      return;
    }
  }
  
  public final void TK(String paramString)
  {
    AppMethodBeat.i(238923);
    long l1 = Util.currentTicks();
    if (this.kxi == null) {
      if (this.kxj == null)
      {
        if (BuildInfo.IS_ARM64) {}
        for (localObject1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.snl, ""); Util.isNullOrNil((String)localObject1); localObject1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.snk, ""))
        {
          AppMethodBeat.o(238923);
          return;
        }
        this.kxj = new b((String)localObject1);
        localObject1 = this.kxj;
        if (Util.isNullOrNil(((b)localObject1).dNA)) {}
      }
    }
    try
    {
      Object localObject2 = new JSONObject(((b)localObject1).dNA);
      ((b)localObject1).kxt = ((JSONObject)localObject2).optString("zipUrl", "");
      ((b)localObject1).kxu = ((JSONObject)localObject2).optString("zipMd5", "");
      ((b)localObject1).kxv = ((JSONObject)localObject2).optString("tensorflowlite_jni", "");
      ((b)localObject1).kxw = ((JSONObject)localObject2).optString("tensorflowlite_flex_jni", "");
      ((b)localObject1).kxx = ((JSONObject)localObject2).optString("model", "");
      ((b)localObject1).kxy = ((JSONObject)localObject2).optString("modelMd5", "");
      ((b)localObject1).pos = ((JSONObject)localObject2).optInt("pos", -1);
      ((b)localObject1).kxz = ((JSONObject)localObject2).optString("quantiles", "");
      ((b)localObject1).kxA = ((JSONObject)localObject2).optString("quantilesMd5", "");
      ((b)localObject1).kxB = ((JSONObject)localObject2).optString("tffeat2idx", "");
      ((b)localObject1).kxC = ((JSONObject)localObject2).optString("tffeat2idxMd5", "");
      ((b)localObject1).kxD = ((JSONObject)localObject2).optInt("randomScene", -1);
      ((b)localObject1).kxE = ((JSONObject)localObject2).optInt("modelScene", -1);
      ((b)localObject1).kxF = ((JSONObject)localObject2).optInt("historySize", 100);
      ((b)localObject1).kxG = ((JSONObject)localObject2).optInt("predictGap", -1);
      ((b)localObject1).TL(((JSONObject)localObject2).optString("noPredictSessionId", ""));
      ((b)localObject1).kxr = true;
      localObject1 = this.kxj;
      if (!((b)localObject1).kxr)
      {
        i = 100;
        kxf = i;
        localObject1 = new PString();
        localObject2 = new PString();
        PString localPString = new PString();
        bool = this.kxj.a(this.kxh, (PString)localObject1, (PString)localObject2, localPString);
        if ((!Util.isNullOrNil(((PString)localObject1).value)) && (!Util.isNullOrNil(((PString)localObject2).value)) && (!Util.isNullOrNil(localPString.value))) {
          this.kxi = new com.tencent.mm.plugin.ai.d.b.a(((PString)localObject1).value, ((PString)localObject2).value, localPString.value);
        }
        Log.i("MicroMsg.AiService", "check config cost [%d] flag[%b] [%s %s %s]", new Object[] { Long.valueOf(Util.ticksToNow(l1)), Boolean.valueOf(bool), ((PString)localObject1).value, ((PString)localObject2).value, localPString.value });
        f2 = -1.0F;
        if (this.kxi == null) {
          break label997;
        }
        localObject1 = this.kxj;
        l2 = this.kxi.kwZ;
        if (((b)localObject1).kxr) {
          break label679;
        }
        bool = false;
        if (bool) {
          break label775;
        }
        Log.i("MicroMsg.AiService", "n min can not predict");
        com.tencent.mm.plugin.report.service.h.CyF.n(1559L, 25L, 1L);
        AppMethodBeat.o(238923);
      }
    }
    catch (JSONException localJSONException)
    {
      boolean bool;
      for (;;)
      {
        long l2;
        Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", localJSONException, "parse error", new Object[0]);
        ((b)localObject1).kxr = false;
        continue;
        int i = ((b)localObject1).kxF;
        continue;
        label679:
        if (((b)localObject1).kxG <= 0)
        {
          bool = true;
        }
        else
        {
          long l3 = Util.nowMilliSecond();
          long l4 = l3 - l2;
          bool = false;
          if (l4 > ((b)localObject1).kxG * 60000L) {
            bool = true;
          }
          Log.v("MicroMsg.FinderRedDotConfig", "need predict result[%b] now[%d] before[%d] diff[%d]", new Object[] { Boolean.valueOf(bool), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) });
        }
      }
      label775:
      localObject3 = this.kxj;
      if (Util.isNullOrNil(paramString))
      {
        localObject1 = "";
        if (((b)localObject3).kxr) {
          break label871;
        }
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          break label950;
        }
        Log.i("MicroMsg.AiService", "this session id can not predict");
        com.tencent.mm.plugin.report.service.h.CyF.n(1559L, 26L, 1L);
        AppMethodBeat.o(238923);
        return;
        if ("debug".equals(paramString))
        {
          localObject1 = "";
          break;
        }
        localObject1 = new d(paramString).eiY;
        break;
        label871:
        if (((b)localObject3).kxH.size() <= 0)
        {
          bool = true;
        }
        else if (Util.isNullOrNil((String)localObject1))
        {
          bool = true;
        }
        else
        {
          bool = true;
          if (((b)localObject3).kxH.contains(localObject1)) {
            bool = false;
          }
          Log.v("MicroMsg.FinderRedDotConfig", "need predict result[%b] sessionId[%s]", new Object[] { Boolean.valueOf(bool), localObject1 });
        }
      }
      label950:
      if (!this.kxj.bqA()) {
        break label1034;
      }
    }
    this.kxi.kwZ = Util.nowMilliSecond();
    float f1 = Util.getIntRandom(100, 1) / 100.0F;
    float f2 = f1;
    if (aC(f1))
    {
      bqz();
      f2 = f1;
    }
    label997:
    Log.i("MicroMsg.AiService", "predictFinderRedDot [%f] cost end [%d]", new Object[] { Float.valueOf(f2), Long.valueOf(Util.ticksToNow(l1)) });
    AppMethodBeat.o(238923);
    return;
    label1034:
    Object localObject3 = this.kxi;
    if (this.kxj != null)
    {
      localObject1 = this.kxj;
      if (!((b)localObject1).kxr) {}
    }
    for (Object localObject1 = ((b)localObject1).kxy;; localObject1 = "")
    {
      f1 = ((com.tencent.mm.plugin.ai.d.b.a)localObject3).ci(paramString, (String)localObject1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.e.a
 * JD-Core Version:    0.7.0.1
 */