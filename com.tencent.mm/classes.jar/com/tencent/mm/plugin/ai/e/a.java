package com.tencent.mm.plugin.ai.e;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ua;
import com.tencent.mm.f.a.ua.a;
import com.tencent.mm.f.b.a.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.pointers.PFloat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
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
  private static int npZ = 100;
  private static a nqa;
  private com.tencent.mm.plugin.ai.d.a.a nqb;
  private com.tencent.mm.plugin.ai.d.b.a nqc;
  private b nqd;
  private LinkedList<Float> nqe;
  public IListener<ua> nqf;
  
  private a()
  {
    AppMethodBeat.i(239490);
    this.nqd = null;
    this.nqf = new IListener() {};
    this.nqb = new com.tencent.mm.plugin.ai.d.a.a();
    AppMethodBeat.o(239490);
  }
  
  public static boolean Hh(long paramLong)
  {
    AppMethodBeat.i(239527);
    if ((z.bde() & paramLong) != 0L)
    {
      AppMethodBeat.o(239527);
      return true;
    }
    AppMethodBeat.o(239527);
    return false;
  }
  
  private static void a(boolean paramBoolean, float paramFloat, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239519);
    f localf1 = new f();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localf1.gdH = i;
      f localf2 = localf1.iC(String.valueOf(paramFloat));
      localf2.gdJ = paramInt1;
      localf2.gdK = paramInt2;
      localf2.iD(paramString).bpa();
      Log.v("MicroMsg.AiService", "reportHistoryScores [%s]", new Object[] { localf1.agI() });
      AppMethodBeat.o(239519);
      return;
    }
  }
  
  private boolean aC(float paramFloat)
  {
    AppMethodBeat.i(239513);
    long l = Util.currentTicks();
    if (paramFloat < 0.0F)
    {
      AppMethodBeat.o(239513);
      return false;
    }
    if (this.nqe == null)
    {
      this.nqe = new LinkedList();
      localObject1 = com.tencent.mm.plugin.ai.f.b.bBr().nqJ.bcJ().decodeBytes("finder_float_history");
      if (!Util.isNullOrNil((byte[])localObject1))
      {
        localObject1 = com.tencent.mm.plugin.ai.c.a.aS((byte[])localObject1);
        i = 0;
        while (i < localObject1.length)
        {
          this.nqe.add(Float.valueOf(localObject1[i]));
          if (this.nqe.size() > npZ) {
            break;
          }
          i += 1;
        }
      }
    }
    if (this.nqe.size() < npZ)
    {
      this.nqe.push(Float.valueOf(paramFloat));
      bBj();
      com.tencent.mm.plugin.report.service.h.IzE.el(1559, 16);
      AppMethodBeat.o(239513);
      return false;
    }
    int i = 0;
    Object localObject1 = new StringBuffer();
    Object localObject2 = this.nqe.iterator();
    float f;
    if (((Iterator)localObject2).hasNext())
    {
      f = ((Float)((Iterator)localObject2).next()).floatValue();
      if (f <= paramFloat) {
        break label918;
      }
      i += 1;
    }
    label904:
    label918:
    for (;;)
    {
      ((StringBuffer)localObject1).append(f).append(";");
      break;
      this.nqe.removeLast();
      this.nqe.push(Float.valueOf(paramFloat));
      bBj();
      int j = this.nqd.bBo();
      if (j < 0)
      {
        a(false, paramFloat, ((StringBuffer)localObject1).toString(), i, j);
        AppMethodBeat.o(239513);
        return false;
      }
      int k;
      label333:
      boolean bool;
      if (j == 2)
      {
        localObject2 = this.nqd;
        k = com.tencent.mm.plugin.ai.c.a.Hg(Util.nowMilliSecond());
        if (k <= 0)
        {
          f = -1.0F;
          k = com.tencent.mm.plugin.ai.c.a.Hg(Util.nowMilliSecond() - 86400000L);
          if (k > 0) {
            break label843;
          }
          if (paramFloat <= f) {
            break label875;
          }
          bool = true;
          label342:
          if (!bool) {
            break label904;
          }
          com.tencent.mm.plugin.report.service.h.IzE.el(1559, 17);
        }
      }
      for (;;)
      {
        a(bool, paramFloat, ((StringBuffer)localObject1).toString(), i, this.nqd.bBp());
        Log.i("MicroMsg.AiService", "checkAndSaveResult needSync[%b] algorithm[%d] [%d %d] cost[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.nqd.bBp()), Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(239513);
        return bool;
        HashSet localHashSet;
        int m;
        int n;
        if ((((b)localObject2).nqF == null) || (((b)localObject2).nqF.value != k) || (((b)localObject2).nqE == null))
        {
          ((b)localObject2).nqF = new PInt(k);
          ((b)localObject2).nqE = new PFloat();
          ((b)localObject2).nqE.value = -1.0F;
          localHashSet = com.tencent.mm.plugin.ai.f.b.bBr().nqG.bBs();
          k = com.tencent.mm.plugin.ai.c.a.Hg(Util.nowMilliSecond() - 86400000L);
          m = com.tencent.mm.plugin.ai.c.a.Hg(Util.nowMilliSecond() - 172800000L);
          n = com.tencent.mm.plugin.ai.c.a.Hg(Util.nowMilliSecond() - 259200000L);
          if ((localHashSet != null) && (!localHashSet.isEmpty())) {
            break label589;
          }
          ((b)localObject2).nqE.value = 0.0F;
        }
        for (;;)
        {
          f = ((b)localObject2).nqE.value;
          break;
          label589:
          if ((localHashSet.contains(Integer.valueOf(k))) && (localHashSet.contains(Integer.valueOf(m))) && (localHashSet.contains(Integer.valueOf(n)))) {
            ((b)localObject2).nqE.value = 0.5F;
          } else if ((localHashSet.contains(Integer.valueOf(k))) && (localHashSet.contains(Integer.valueOf(m)))) {
            ((b)localObject2).nqE.value = 0.4F;
          } else if ((localHashSet.contains(Integer.valueOf(k))) && (localHashSet.contains(Integer.valueOf(n)))) {
            ((b)localObject2).nqE.value = 0.4F;
          } else if ((localHashSet.contains(Integer.valueOf(m))) && (localHashSet.contains(Integer.valueOf(n)))) {
            ((b)localObject2).nqE.value = 0.4F;
          } else if (localHashSet.contains(Integer.valueOf(k))) {
            ((b)localObject2).nqE.value = 0.3F;
          } else if (localHashSet.contains(Integer.valueOf(m))) {
            ((b)localObject2).nqE.value = 0.2F;
          } else if (localHashSet.contains(Integer.valueOf(n))) {
            ((b)localObject2).nqE.value = 0.1F;
          }
        }
        label843:
        if (!com.tencent.mm.plugin.ai.f.b.bBr().nqG.yH(k))
        {
          f -= 0.1F;
          break label333;
        }
        f += 0.1F;
        break label333;
        label875:
        bool = false;
        break label342;
        if (i < this.nqd.bBp())
        {
          bool = true;
          break label342;
        }
        bool = false;
        break label342;
        com.tencent.mm.plugin.report.service.h.IzE.el(1559, 18);
      }
    }
  }
  
  public static a bBi()
  {
    AppMethodBeat.i(239494);
    if (nqa == null) {
      nqa = new a();
    }
    a locala = nqa;
    AppMethodBeat.o(239494);
    return locala;
  }
  
  private void bBj()
  {
    AppMethodBeat.i(239516);
    if ((this.nqe == null) || (this.nqe.size() <= 0))
    {
      AppMethodBeat.o(239516);
      return;
    }
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239593);
        int k = Math.min(a.b(a.this).size(), a.npZ);
        Object localObject = new float[k];
        Iterator localIterator = a.b(a.this).iterator();
        int j;
        for (int i = 0;; i = j) {
          if (localIterator.hasNext())
          {
            float f = ((Float)localIterator.next()).floatValue();
            j = i + 1;
            localObject[i] = f;
            if (j < k) {}
          }
          else
          {
            localObject = com.tencent.mm.plugin.ai.c.a.l((float[])localObject);
            com.tencent.mm.plugin.ai.f.b.bBr().nqJ.bcJ().encode("finder_float_history", (byte[])localObject);
            AppMethodBeat.o(239593);
            return;
          }
        }
      }
    }, "Ai_thread");
    AppMethodBeat.o(239516);
  }
  
  private static boolean bBk()
  {
    AppMethodBeat.i(239520);
    String str = com.tencent.mm.plugin.expt.h.d.dgX().a("reddot_expt_conf", "", false, false);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(239520);
      return false;
    }
    try
    {
      int i = new JSONObject(str).optInt("use_reddot_recommend", -1);
      if (i == 0)
      {
        AppMethodBeat.o(239520);
        return true;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(239520);
    }
    return false;
  }
  
  public static boolean bBl()
  {
    AppMethodBeat.i(239523);
    boolean bool3 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).showFinderEntry();
    boolean bool1;
    if (!Hh(34359738368L))
    {
      bool1 = true;
      if ((!((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM()) || (((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).dYS() != 2)) {
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
      AppMethodBeat.o(239523);
      return true;
      bool1 = false;
      break;
    }
    label132:
    AppMethodBeat.o(239523);
    return false;
  }
  
  public final void abu(String paramString)
  {
    AppMethodBeat.i(239505);
    long l1 = Util.currentTicks();
    Object localObject1;
    if (this.nqc == null) {
      if (this.nqd == null)
      {
        if (BuildInfo.IS_ARM64) {}
        for (localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYn, ""); Util.isNullOrNil((String)localObject1); localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYm, ""))
        {
          AppMethodBeat.o(239505);
          return;
        }
        this.nqd = new b((String)localObject1);
        localObject1 = this.nqd;
        if (Util.isNullOrNil(((b)localObject1).fGM)) {}
      }
    }
    float f2;
    label706:
    Object localObject3;
    try
    {
      Object localObject2 = new JSONObject(((b)localObject1).fGM);
      ((b)localObject1).nql = ((JSONObject)localObject2).optString("zipUrl", "");
      ((b)localObject1).nqm = ((JSONObject)localObject2).optString("zipMd5", "");
      ((b)localObject1).nqn = ((JSONObject)localObject2).optString("tensorflowlite_jni", "");
      ((b)localObject1).nqo = ((JSONObject)localObject2).optString("tensorflowlite_flex_jni", "");
      ((b)localObject1).nqp = ((JSONObject)localObject2).optString("model", "");
      ((b)localObject1).nqq = ((JSONObject)localObject2).optString("modelMd5", "");
      ((b)localObject1).pos = ((JSONObject)localObject2).optInt("pos", -1);
      ((b)localObject1).nqr = ((JSONObject)localObject2).optString("quantiles", "");
      ((b)localObject1).nqs = ((JSONObject)localObject2).optString("quantilesMd5", "");
      ((b)localObject1).nqt = ((JSONObject)localObject2).optString("tffeat2idx", "");
      ((b)localObject1).nqu = ((JSONObject)localObject2).optString("tffeat2idxMd5", "");
      ((b)localObject1).nqv = ((JSONObject)localObject2).optInt("randomScene", -1);
      ((b)localObject1).nqw = ((JSONObject)localObject2).optInt("modelScene", -1);
      ((b)localObject1).nqx = ((JSONObject)localObject2).optInt("historySize", 100);
      ((b)localObject1).nqy = ((JSONObject)localObject2).optInt("predictGap", -1);
      ((b)localObject1).abv(((JSONObject)localObject2).optString("noPredictSessionId", ""));
      ((b)localObject1).nqA = ((JSONObject)localObject2).optInt("topKAlgorithm", -1);
      ((b)localObject1).nqB = ((JSONObject)localObject2).optInt("finderSyncInfo", -1);
      ((b)localObject1).nqj = true;
      localObject1 = this.nqd;
      if (!((b)localObject1).nqj)
      {
        i = 100;
        npZ = i;
        localObject1 = new PString();
        localObject2 = new PString();
        PString localPString = new PString();
        bool = this.nqd.a(this.nqb, (PString)localObject1, (PString)localObject2, localPString);
        if ((!Util.isNullOrNil(((PString)localObject1).value)) && (!Util.isNullOrNil(((PString)localObject2).value)) && (!Util.isNullOrNil(localPString.value))) {
          this.nqc = new com.tencent.mm.plugin.ai.d.b.a(((PString)localObject1).value, ((PString)localObject2).value, localPString.value);
        }
        Log.i("MicroMsg.AiService", "check config cost [%d] flag[%b] [%s %s %s]", new Object[] { Long.valueOf(Util.ticksToNow(l1)), Boolean.valueOf(bool), ((PString)localObject1).value, ((PString)localObject2).value, localPString.value });
        f2 = -1.0F;
        if (this.nqc == null) {
          break label1078;
        }
        localObject1 = this.nqd;
        l2 = this.nqc.npT;
        if (((b)localObject1).nqj) {
          break label706;
        }
        bool = false;
        if (bool) {
          break label802;
        }
        Log.i("MicroMsg.AiService", "n min can not predict");
        com.tencent.mm.plugin.report.service.h.IzE.p(1559L, 25L, 1L);
        AppMethodBeat.o(239505);
      }
    }
    catch (JSONException localJSONException)
    {
      boolean bool;
      for (;;)
      {
        long l2;
        Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", localJSONException, "parse error", new Object[0]);
        ((b)localObject1).nqj = false;
        continue;
        i = ((b)localObject1).nqx;
        continue;
        if (((b)localObject1).nqy <= 0)
        {
          bool = true;
        }
        else
        {
          long l3 = Util.nowMilliSecond();
          long l4 = l3 - l2;
          bool = false;
          if (l4 > ((b)localObject1).nqy * 60000L) {
            bool = true;
          }
          Log.v("MicroMsg.FinderRedDotConfig", "need predict result[%b] now[%d] before[%d] diff[%d]", new Object[] { Boolean.valueOf(bool), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l4) });
        }
      }
      label802:
      localObject3 = this.nqd;
      if (Util.isNullOrNil(paramString))
      {
        localObject1 = "";
        if (((b)localObject3).nqj) {
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
        com.tencent.mm.plugin.report.service.h.IzE.p(1559L, 26L, 1L);
        AppMethodBeat.o(239505);
        return;
        if ("debug".equals(paramString))
        {
          localObject1 = "";
          break;
        }
        localObject1 = new com.tencent.mm.f.b.a.e(paramString).gdr;
        break;
        label898:
        if (((b)localObject3).nqz.size() <= 0)
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
          if (((b)localObject3).nqz.contains(localObject1)) {
            bool = false;
          }
          Log.v("MicroMsg.FinderRedDotConfig", "need predict result[%b] sessionId[%s]", new Object[] { Boolean.valueOf(bool), localObject1 });
        }
      }
      label977:
      localObject1 = this.nqd;
      if (!((b)localObject1).nqj) {
        break label1115;
      }
    }
    float f1;
    if (((b)localObject1).nqv > 0)
    {
      i = 1;
      if (i == 0) {
        break label1121;
      }
      this.nqc.npT = Util.nowMilliSecond();
      f1 = Util.getIntRandom(100, 1) / 100.0F;
      paramString = this.nqd;
      if ((!paramString.nqj) || (paramString.nqB <= 0)) {
        break label1175;
      }
      i = 1;
      label1051:
      if (i == 0) {
        break label1181;
      }
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(239738);
          com.tencent.mm.plugin.ai.b.a.a.e locale = com.tencent.mm.plugin.ai.b.a.a.e.bAZ();
          if (a.a(a.this) != null) {}
          for (int i = a.a(a.this).bBq();; i = 0)
          {
            locale.yB(i);
            AppMethodBeat.o(239738);
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
      AppMethodBeat.o(239505);
      return;
      i = 0;
      break;
      localObject3 = this.nqc;
      if (this.nqd != null)
      {
        localObject1 = this.nqd;
        if (!((b)localObject1).nqj) {}
      }
      for (localObject1 = ((b)localObject1).nqq;; localObject1 = "")
      {
        f1 = ((com.tencent.mm.plugin.ai.d.b.a)localObject3).cn(paramString, (String)localObject1);
        break;
      }
      i = 0;
      break label1051;
      f2 = f1;
    } while (!aC(f1));
    label1175:
    label1181:
    paramString = com.tencent.mm.plugin.ai.b.a.a.e.bAZ();
    if (this.nqd != null) {}
    for (int i = this.nqd.bBq();; i = 0)
    {
      paramString.yB(i);
      f2 = f1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.e.a
 * JD-Core Version:    0.7.0.1
 */