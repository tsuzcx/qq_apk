package com.tencent.mm.plugin.ai.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.vq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pointers.PFloat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.plugin.ai.a.a
{
  private static int qoE = 100;
  private static a qoF;
  private com.tencent.mm.plugin.ai.c.a.a qoG;
  private com.tencent.mm.plugin.ai.c.b.a qoH;
  private b qoI;
  private LinkedList<Float> qoJ;
  private IListener<vq> qoK;
  
  private a()
  {
    AppMethodBeat.i(267440);
    this.qoI = null;
    this.qoK = new AiService.1(this, f.hfK);
    this.qoG = new com.tencent.mm.plugin.ai.c.a.a();
    AppMethodBeat.o(267440);
  }
  
  private static void a(boolean paramBoolean, float paramFloat, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(267479);
    com.tencent.mm.autogen.mmdata.rpt.g localg1 = new com.tencent.mm.autogen.mmdata.rpt.g();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localg1.ika = i;
      com.tencent.mm.autogen.mmdata.rpt.g localg2 = localg1.jY(String.valueOf(paramFloat));
      localg2.ikc = paramInt1;
      localg2.ikd = paramInt2;
      localg2.jZ(paramString).bMH();
      Log.v("MicroMsg.AiService", "reportHistoryScores [%s]", new Object[] { localg1.aIF() });
      AppMethodBeat.o(267479);
      return;
    }
  }
  
  private boolean bA(float paramFloat)
  {
    AppMethodBeat.i(267464);
    long l = Util.currentTicks();
    if (paramFloat < 0.0F)
    {
      AppMethodBeat.o(267464);
      return false;
    }
    if (this.qoJ == null)
    {
      this.qoJ = new LinkedList();
      localObject1 = com.tencent.mm.plugin.ai.d.e.caH().qpt.atj();
      if (localObject1 == null) {}
      for (localObject1 = null; !Util.isNullOrNil((byte[])localObject1); localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes("finder_float_history"))
      {
        localObject1 = com.tencent.mm.plugin.ai.b.a.aS((byte[])localObject1);
        i = 0;
        while (i < localObject1.length)
        {
          this.qoJ.add(Float.valueOf(localObject1[i]));
          if (this.qoJ.size() > qoE) {
            break;
          }
          i += 1;
        }
      }
    }
    if (this.qoJ.size() < qoE)
    {
      this.qoJ.push(Float.valueOf(paramFloat));
      caA();
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, 16);
      AppMethodBeat.o(267464);
      return false;
    }
    int i = 0;
    Object localObject1 = new StringBuffer();
    Object localObject2 = this.qoJ.iterator();
    float f;
    if (((Iterator)localObject2).hasNext())
    {
      f = ((Float)((Iterator)localObject2).next()).floatValue();
      if (f <= paramFloat) {
        break label933;
      }
      i += 1;
    }
    label919:
    label933:
    for (;;)
    {
      ((StringBuffer)localObject1).append(f).append(";");
      break;
      this.qoJ.removeLast();
      this.qoJ.push(Float.valueOf(paramFloat));
      caA();
      int j = this.qoI.caC();
      if (j < 0)
      {
        a(false, paramFloat, ((StringBuffer)localObject1).toString(), i, j);
        AppMethodBeat.o(267464);
        return false;
      }
      int k;
      label348:
      boolean bool;
      if (j == 2)
      {
        localObject2 = this.qoI;
        k = com.tencent.mm.plugin.ai.b.a.jx(Util.nowMilliSecond());
        if (k <= 0)
        {
          f = -1.0F;
          k = com.tencent.mm.plugin.ai.b.a.jx(Util.nowMilliSecond() - 86400000L);
          if (k > 0) {
            break label858;
          }
          if (paramFloat <= f) {
            break label890;
          }
          bool = true;
          label357:
          if (!bool) {
            break label919;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, 17);
        }
      }
      for (;;)
      {
        a(bool, paramFloat, ((StringBuffer)localObject1).toString(), i, this.qoI.caD());
        Log.i("MicroMsg.AiService", "checkAndSaveResult needSync[%b] algorithm[%d] [%d %d] cost[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.qoI.caD()), Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(267464);
        return bool;
        HashSet localHashSet;
        int m;
        int n;
        if ((((b)localObject2).qpj == null) || (((b)localObject2).qpj.value != k) || (((b)localObject2).qpi == null))
        {
          ((b)localObject2).qpj = new PInt(k);
          ((b)localObject2).qpi = new PFloat();
          ((b)localObject2).qpi.value = -1.0F;
          localHashSet = com.tencent.mm.plugin.ai.d.e.caH().qpp.caI();
          k = com.tencent.mm.plugin.ai.b.a.jx(Util.nowMilliSecond() - 86400000L);
          m = com.tencent.mm.plugin.ai.b.a.jx(Util.nowMilliSecond() - 172800000L);
          n = com.tencent.mm.plugin.ai.b.a.jx(Util.nowMilliSecond() - 259200000L);
          if ((localHashSet != null) && (!localHashSet.isEmpty())) {
            break label604;
          }
          ((b)localObject2).qpi.value = 0.0F;
        }
        for (;;)
        {
          f = ((b)localObject2).qpi.value;
          break;
          label604:
          if ((localHashSet.contains(Integer.valueOf(k))) && (localHashSet.contains(Integer.valueOf(m))) && (localHashSet.contains(Integer.valueOf(n)))) {
            ((b)localObject2).qpi.value = 0.5F;
          } else if ((localHashSet.contains(Integer.valueOf(k))) && (localHashSet.contains(Integer.valueOf(m)))) {
            ((b)localObject2).qpi.value = 0.4F;
          } else if ((localHashSet.contains(Integer.valueOf(k))) && (localHashSet.contains(Integer.valueOf(n)))) {
            ((b)localObject2).qpi.value = 0.4F;
          } else if ((localHashSet.contains(Integer.valueOf(m))) && (localHashSet.contains(Integer.valueOf(n)))) {
            ((b)localObject2).qpi.value = 0.4F;
          } else if (localHashSet.contains(Integer.valueOf(k))) {
            ((b)localObject2).qpi.value = 0.3F;
          } else if (localHashSet.contains(Integer.valueOf(m))) {
            ((b)localObject2).qpi.value = 0.2F;
          } else if (localHashSet.contains(Integer.valueOf(n))) {
            ((b)localObject2).qpi.value = 0.1F;
          }
        }
        label858:
        if (!com.tencent.mm.plugin.ai.d.e.caH().qpp.yP(k))
        {
          f -= 0.1F;
          break label348;
        }
        f += 0.1F;
        break label348;
        label890:
        bool = false;
        break label357;
        if (i < this.qoI.caD())
        {
          bool = true;
          break label357;
        }
        bool = false;
        break label357;
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1559, 18);
      }
    }
  }
  
  public static boolean bZX()
  {
    AppMethodBeat.i(267488);
    boolean bool3 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).showFinderEntry();
    boolean bool1;
    if (!ju(34359738368L))
    {
      bool1 = true;
      if ((!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) || (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD() != 2)) {
        break label127;
      }
    }
    label127:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.AiService", "[isShowFinderEntrance] show:%s open:%s, isTeenModeAndNothing:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool3) || (!bool1) || (bool2)) {
        break label132;
      }
      AppMethodBeat.o(267488);
      return true;
      bool1 = false;
      break;
    }
    label132:
    AppMethodBeat.o(267488);
    return false;
  }
  
  private void caA()
  {
    AppMethodBeat.i(267471);
    if ((this.qoJ == null) || (this.qoJ.size() <= 0))
    {
      AppMethodBeat.o(267471);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(267434);
        int k = Math.min(a.b(a.this).size(), a.qoE);
        Object localObject1 = new float[k];
        Object localObject2 = a.b(a.this).iterator();
        int j;
        for (int i = 0;; i = j) {
          if (((Iterator)localObject2).hasNext())
          {
            float f = ((Float)((Iterator)localObject2).next()).floatValue();
            j = i + 1;
            localObject1[i] = f;
            if (j < k) {}
          }
          else
          {
            localObject1 = com.tencent.mm.plugin.ai.b.a.t((float[])localObject1);
            localObject2 = com.tencent.mm.plugin.ai.d.e.caH().qpt.atj();
            if (localObject2 != null) {
              ((MultiProcessMMKV)localObject2).encode("finder_float_history", (byte[])localObject1);
            }
            AppMethodBeat.o(267434);
            return;
          }
        }
      }
    }, "Ai_thread");
    AppMethodBeat.o(267471);
  }
  
  public static a caz()
  {
    AppMethodBeat.i(267448);
    if (qoF == null) {
      qoF = new a();
    }
    a locala = qoF;
    AppMethodBeat.o(267448);
    return locala;
  }
  
  public static boolean ju(long paramLong)
  {
    AppMethodBeat.i(267495);
    if ((z.bAR() & paramLong) != 0L)
    {
      AppMethodBeat.o(267495);
      return true;
    }
    AppMethodBeat.o(267495);
    return false;
  }
  
  public final void TQ(String paramString)
  {
    AppMethodBeat.i(267558);
    long l1 = Util.currentTicks();
    Object localObject1;
    if (this.qoH == null) {
      if (this.qoI == null)
      {
        if (BuildInfo.IS_ARM64) {}
        for (localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrd, ""); Util.isNullOrNil((String)localObject1); localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrc, ""))
        {
          AppMethodBeat.o(267558);
          return;
        }
        this.qoI = new b((String)localObject1);
        localObject1 = this.qoI;
        if (Util.isNullOrNil(((b)localObject1).hMi)) {}
      }
    }
    float f2;
    label706:
    Object localObject3;
    try
    {
      Object localObject2 = new JSONObject(((b)localObject1).hMi);
      ((b)localObject1).qoQ = ((JSONObject)localObject2).optString("zipUrl", "");
      ((b)localObject1).qoR = ((JSONObject)localObject2).optString("zipMd5", "");
      ((b)localObject1).qoS = ((JSONObject)localObject2).optString("tensorflowlite_jni", "");
      ((b)localObject1).qoT = ((JSONObject)localObject2).optString("tensorflowlite_flex_jni", "");
      ((b)localObject1).modelName = ((JSONObject)localObject2).optString("model", "");
      ((b)localObject1).qoU = ((JSONObject)localObject2).optString("modelMd5", "");
      ((b)localObject1).pos = ((JSONObject)localObject2).optInt("pos", -1);
      ((b)localObject1).qoV = ((JSONObject)localObject2).optString("quantiles", "");
      ((b)localObject1).qoW = ((JSONObject)localObject2).optString("quantilesMd5", "");
      ((b)localObject1).qoX = ((JSONObject)localObject2).optString("tffeat2idx", "");
      ((b)localObject1).qoY = ((JSONObject)localObject2).optString("tffeat2idxMd5", "");
      ((b)localObject1).qoZ = ((JSONObject)localObject2).optInt("randomScene", -1);
      ((b)localObject1).qpa = ((JSONObject)localObject2).optInt("modelScene", -1);
      ((b)localObject1).qpb = ((JSONObject)localObject2).optInt("historySize", 100);
      ((b)localObject1).qpc = ((JSONObject)localObject2).optInt("predictGap", -1);
      ((b)localObject1).TR(((JSONObject)localObject2).optString("noPredictSessionId", ""));
      ((b)localObject1).qpe = ((JSONObject)localObject2).optInt("topKAlgorithm", -1);
      ((b)localObject1).qpf = ((JSONObject)localObject2).optInt("finderSyncInfo", -1);
      ((b)localObject1).qoO = true;
      localObject1 = this.qoI;
      if (!((b)localObject1).qoO)
      {
        i = 100;
        qoE = i;
        localObject1 = new PString();
        localObject2 = new PString();
        PString localPString = new PString();
        bool = this.qoI.a(this.qoG, (PString)localObject1, (PString)localObject2, localPString);
        if ((!Util.isNullOrNil(((PString)localObject1).value)) && (!Util.isNullOrNil(((PString)localObject2).value)) && (!Util.isNullOrNil(localPString.value))) {
          this.qoH = new com.tencent.mm.plugin.ai.c.b.a(((PString)localObject1).value, ((PString)localObject2).value, localPString.value);
        }
        Log.i("MicroMsg.AiService", "check config cost [%d] flag[%b] [%s %s %s]", new Object[] { Long.valueOf(Util.ticksToNow(l1)), Boolean.valueOf(bool), ((PString)localObject1).value, ((PString)localObject2).value, localPString.value });
        f2 = -1.0F;
        if (this.qoH == null) {
          break label1078;
        }
        localObject1 = this.qoI;
        l2 = this.qoH.qoy;
        if (((b)localObject1).qoO) {
          break label706;
        }
        bool = false;
        if (bool) {
          break label802;
        }
        Log.i("MicroMsg.AiService", "n min can not predict");
        com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 25L, 1L);
        AppMethodBeat.o(267558);
      }
    }
    catch (JSONException localJSONException)
    {
      boolean bool;
      for (;;)
      {
        long l2;
        Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", localJSONException, "parse error", new Object[0]);
        ((b)localObject1).qoO = false;
        continue;
        i = ((b)localObject1).qpb;
        continue;
        if (((b)localObject1).qpc <= 0)
        {
          bool = true;
        }
        else
        {
          long l3 = Util.nowMilliSecond();
          long l4 = l3 - l2;
          bool = false;
          if (l4 > ((b)localObject1).qpc * 60000L) {
            bool = true;
          }
          Log.v("MicroMsg.FinderRedDotConfig", "need predict result[%b] now[%d] before[%d] diff[%d]", new Object[] { Boolean.valueOf(bool), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) });
        }
      }
      label802:
      localObject3 = this.qoI;
      if (Util.isNullOrNil(paramString))
      {
        localObject1 = "";
        if (((b)localObject3).qoO) {
          break label898;
        }
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          break label977;
        }
        Log.i("MicroMsg.AiService", "this session id can not predict");
        com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 26L, 1L);
        AppMethodBeat.o(267558);
        return;
        if ("debug".equals(paramString))
        {
          localObject1 = "";
          break;
        }
        localObject1 = new com.tencent.mm.autogen.mmdata.rpt.e(paramString).ijH;
        break;
        label898:
        if (((b)localObject3).qpd.size() <= 0)
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
          if (((b)localObject3).qpd.contains(localObject1)) {
            bool = false;
          }
          Log.v("MicroMsg.FinderRedDotConfig", "need predict result[%b] sessionId[%s]", new Object[] { Boolean.valueOf(bool), localObject1 });
        }
      }
      label977:
      localObject1 = this.qoI;
      if (!((b)localObject1).qoO) {
        break label1115;
      }
    }
    float f1;
    if (((b)localObject1).qoZ > 0)
    {
      i = 1;
      if (i == 0) {
        break label1121;
      }
      this.qoH.qoy = Util.nowMilliSecond();
      f1 = Util.getIntRandom(100, 1) / 100.0F;
      paramString = this.qoI;
      if ((!paramString.qoO) || (paramString.qpf <= 0)) {
        break label1175;
      }
      i = 1;
      label1051:
      if (i == 0) {
        break label1181;
      }
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(267429);
          com.tencent.mm.plugin.ai.data.business.finder.e locale = com.tencent.mm.plugin.ai.data.business.finder.e.bZM();
          if (a.a(a.this) != null) {}
          for (int i = a.a(a.this).caE();; i = 0)
          {
            locale.yJ(i);
            AppMethodBeat.o(267429);
            return;
          }
        }
      }, "Ai_thread");
      f2 = f1;
    }
    label1078:
    label1115:
    label1121:
    do
    {
      Log.i("MicroMsg.AiService", "predictFinderRedDot [%f] cost end [%d]", new Object[] { Float.valueOf(f2), Long.valueOf(Util.ticksToNow(l1)) });
      AppMethodBeat.o(267558);
      return;
      i = 0;
      break;
      localObject3 = this.qoH;
      if (this.qoI != null)
      {
        localObject1 = this.qoI;
        if (!((b)localObject1).qoO) {}
      }
      for (localObject1 = ((b)localObject1).qoU;; localObject1 = "")
      {
        f1 = ((com.tencent.mm.plugin.ai.c.b.a)localObject3).cD(paramString, (String)localObject1);
        break;
      }
      i = 0;
      break label1051;
      f2 = f1;
    } while (!bA(f1));
    label1175:
    label1181:
    paramString = com.tencent.mm.plugin.ai.data.business.finder.e.bZM();
    if (this.qoI != null) {}
    for (int i = this.qoI.caE();; i = 0)
    {
      paramString.yJ(i);
      f2 = f1;
      break;
    }
  }
  
  public final boolean bZI()
  {
    AppMethodBeat.i(369742);
    boolean bool = com.tencent.mm.plugin.ai.data.business.global.c.caj().bZI();
    AppMethodBeat.o(369742);
    return bool;
  }
  
  public final String bZJ()
  {
    AppMethodBeat.i(267532);
    long l = Util.currentTicks();
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrO, false);
    String str = "";
    if (bool)
    {
      com.tencent.mm.plugin.ai.data.business.global.b.bZW();
      str = com.tencent.mm.plugin.ai.data.business.global.b.bZJ();
    }
    Log.i("MicroMsg.AiService", "checkToReturnAiFinderInfo flag[%b] cost[%d] json[%d]", new Object[] { Boolean.valueOf(bool), Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(str.length()) });
    AppMethodBeat.o(267532);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.service.a
 * JD-Core Version:    0.7.0.1
 */