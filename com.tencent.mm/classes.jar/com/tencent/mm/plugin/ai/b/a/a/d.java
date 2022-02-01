package com.tencent.mm.plugin.ai.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.e;
import com.tencent.mm.plugin.ai.c.a;
import com.tencent.mm.plugin.ai.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class d
{
  private static final int[] nnU = { 10, 30, 90 };
  public float noA;
  public float noB;
  public float noC;
  public float noD;
  public float noE;
  public float noF;
  public String noG;
  public float noh;
  public float noi;
  public float noj;
  public float nok;
  public float nol;
  public float nom;
  public float non;
  public float noo;
  public long nop;
  public long noq;
  public long nor;
  public long nos;
  public long not;
  public long nou;
  public long nov;
  public float now;
  public long nox;
  public long noy;
  public float noz;
  
  public d()
  {
    this.noo = 0.0F;
  }
  
  public d(e parame, f paramf, g paramg)
  {
    AppMethodBeat.i(239251);
    this.noo = 0.0F;
    int i = (int)parame.gdx;
    label54:
    long l2;
    int j;
    long l1;
    label89:
    label105:
    label234:
    boolean bool;
    if (!paramf.msB)
    {
      f1 = 0.0F;
      this.noh = f1;
      i = (int)parame.gde;
      if (paramf.msB) {
        break label946;
      }
      f1 = 0.0F;
      this.noj = f1;
      l2 = Util.nowMilliSecond();
      j = a.He(l2);
      i = a.Hf(l2);
      if (paramg.msB) {
        break label969;
      }
      l1 = 0L;
      this.nop = l1;
      if (paramg.msB) {
        break label1024;
      }
      l1 = 0L;
      this.noq = l1;
      i = (int)parame.gdt;
      if (paramf.msB) {
        break label1079;
      }
      f1 = 0.0F;
      label128:
      this.non = f1;
      if (parame.gdw != 1L) {
        break label1102;
      }
      i = 1;
      label146:
      if (paramg.msB) {
        break label1108;
      }
      l1 = 0L;
      label156:
      this.nor = l1;
      if (parame.gdy != 1L) {
        break label1177;
      }
      i = 1;
      label174:
      if (paramg.msB) {
        break label1183;
      }
      l1 = 0L;
      label184:
      this.nos = l1;
      if (parame.gds != 1L) {
        break label1252;
      }
      i = 1;
      label202:
      if (paramg.msB) {
        break label1258;
      }
      l1 = 0L;
      label212:
      this.not = l1;
      i = parame.gdq;
      if (paramg.msB) {
        break label1327;
      }
      l1 = 0L;
      this.nou = l1;
      i = parame.gdp;
      if (paramg.msB) {
        break label1382;
      }
      l1 = 0L;
      label256:
      this.nov = l1;
      i = Util.getInt(parame.gdr, -1);
      if (i <= 0) {
        break label1492;
      }
      if (paramg.msB) {
        break label1437;
      }
      l1 = 0L;
      label287:
      this.nox = l1;
      label293:
      bool = parame.gdc;
      if (paramg.msB) {
        break label1500;
      }
      l1 = 0L;
      label309:
      this.noy = l1;
      l1 = l2 - parame.gdd;
      if (l1 >= 0L)
      {
        i = (int)l1 / 1000 / 60 / 60;
        if (paramf.msB) {
          break label1566;
        }
        f1 = 0.0F;
        label356:
        this.noi = f1;
      }
      i = b.bBr().nqG.yE(j);
      j = b.bBr().nqG.yF(j);
      if (i <= 0) {
        break label1877;
      }
    }
    label414:
    label430:
    label446:
    label468:
    label1877:
    for (float f1 = j * 1.0F / i;; f1 = 0.0F)
    {
      if (!paramf.msB)
      {
        f2 = 0.0F;
        this.nok = f2;
        if (paramf.msB) {
          break label1612;
        }
        f2 = 0.0F;
        this.nol = f2;
        if (paramf.msB) {
          break label1635;
        }
        f2 = 0.0F;
        this.nom = f2;
        l1 = parame.gdB;
        if (paramf.msB) {
          break label1658;
        }
        f2 = 0.0F;
        this.now = f2;
        l1 = parame.gdD;
        if (paramf.msB) {
          break label1682;
        }
        f2 = 0.0F;
        label490:
        this.noz = f2;
        paramg = abs(parame.gdE);
        l1 = paramg[0];
        if (paramf.msB) {
          break label1706;
        }
        f2 = 0.0F;
        this.noA = f2;
        l1 = paramg[1];
        if (paramf.msB) {
          break label1730;
        }
        f2 = 0.0F;
        this.noB = f2;
        l1 = paramg[2];
        if (paramf.msB) {
          break label1754;
        }
        f2 = 0.0F;
        this.noC = f2;
        paramg = abs(parame.gdC);
        l1 = paramg[0];
        if (paramf.msB) {
          break label1778;
        }
        f2 = 0.0F;
        this.noD = f2;
        l1 = paramg[1];
        if (paramf.msB) {
          break label1802;
        }
        f2 = 0.0F;
        label611:
        this.noE = f2;
        l1 = paramg[2];
        if (paramf.msB) {
          break label1826;
        }
      }
      for (float f2 = 0.0F;; f2 = a.f((int)l1, (float[])paramf.noN.get("findfrienduiexposure_90")))
      {
        this.noF = f2;
        paramf = new JSONObject();
        try
        {
          paramf.put("now", l2);
          paramf.put("currHour", a.He(l2));
          paramf.put("currWeekday", a.Hf(l2));
          paramf.put("_7Exposure", i);
          paramf.put("_7Click", j);
          paramf.put("_7Rate", f1);
          paramf.put("snsunread", parame.gdx);
          paramf.put("lastStaySecs", parame.gde);
          paramf.put("friendsTabUnread", parame.gdt);
          paramf.put("isSnsRedDot", parame.gdw);
          paramf.put("isTopStoryRedDot", parame.gdy);
          paramf.put("isFriendsTabRedDot", parame.gds);
          paramf.put("lastFinderRedDotShowType", parame.gdq);
          paramf.put("lastFinderRedDotCtrlType", parame.gdp);
          paramf.put("sessionId", parame.gdr);
          paramf.put("isNewMsgOpenWechat", parame.gdc);
          l1 = l2 - parame.gdd;
          if (l1 >= 0L) {
            paramf.put("fromLastHours", (int)l1 / 1000 / 60 / 60);
          }
          paramf.put("lastsessionduration", parame.gdB);
          paramf.put("wechatduration7dayhour", parame.gdD);
          paramf.put("wechatdurationnminute", parame.gdE);
          paramf.put("findfrienduiexposure", parame.gdC);
          this.noG = paramf.toString().replace(",", ";");
          AppMethodBeat.o(239251);
          return;
        }
        catch (Exception parame)
        {
          HashMap localHashMap;
          Log.d("MicroMsg.AiFinderFeatureStruct", "note input error:[%s]", new Object[] { parame.toString() });
          AppMethodBeat.o(239251);
          return;
        }
        f1 = a.f(i, (float[])paramf.noN.get("snsunread"));
        break;
        f1 = a.f(i, (float[])paramf.noN.get("last_stay_secs"));
        break label54;
        localHashMap = (HashMap)paramg.noN.get("starttime_to_weekday");
        if (!localHashMap.containsKey(Integer.valueOf(i)))
        {
          l1 = 0L;
          break label89;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label89;
        localHashMap = (HashMap)paramg.noN.get("starttime_to_24h");
        if (!localHashMap.containsKey(Integer.valueOf(j)))
        {
          l1 = 0L;
          break label105;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(j))).longValue();
        break label105;
        f1 = a.f(i, (float[])paramf.noN.get("friendstabredunread"));
        break label128;
        i = 0;
        break label146;
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          localHashMap = (HashMap)paramg.noN.get("is_snsreddot");
          if (localHashMap.containsKey(Integer.valueOf(i))) {
            break label1156;
          }
          l1 = 0L;
          break;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label156;
        i = 0;
        break label174;
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          localHashMap = (HashMap)paramg.noN.get("is_topstoryreddot");
          if (localHashMap.containsKey(Integer.valueOf(i))) {
            break label1231;
          }
          l1 = 0L;
          break;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label184;
        label1252:
        i = 0;
        break label202;
        label1258:
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          localHashMap = (HashMap)paramg.noN.get("is_friendstabreddot");
          if (localHashMap.containsKey(Integer.valueOf(i))) {
            break label1306;
          }
          l1 = 0L;
          break;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label212;
        localHashMap = (HashMap)paramg.noN.get("lastfinderreddotshowtype");
        if (!localHashMap.containsKey(Integer.valueOf(i)))
        {
          l1 = 0L;
          break label234;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label234;
        label1382:
        localHashMap = (HashMap)paramg.noN.get("lastfinderreddotctrltype");
        if (!localHashMap.containsKey(Integer.valueOf(i)))
        {
          l1 = 0L;
          break label256;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label256;
        localHashMap = (HashMap)paramg.noN.get("lastsessionid");
        if (!localHashMap.containsKey(Integer.valueOf(i)))
        {
          l1 = 0L;
          break label287;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label287;
        this.nox = 0L;
        break label293;
        label1500:
        if (bool) {}
        for (i = 1;; i = 0)
        {
          paramg = (HashMap)paramg.noN.get("is_newmsgopenwechat");
          if (paramg.containsKey(Integer.valueOf(i))) {
            break label1546;
          }
          l1 = 0L;
          break;
        }
        l1 = ((Long)paramg.get(Integer.valueOf(i))).longValue();
        break label309;
        f1 = a.f(i, (float[])paramf.noN.get("from_last_hours"));
        break label356;
        f2 = a.f(i, (float[])paramf.noN.get("7day_impr_h"));
        break label414;
        f2 = a.f(j, (float[])paramf.noN.get("7day_clk_h"));
        break label430;
        label1635:
        f2 = a.a(f1, (float[])paramf.noN.get("7day_clk_rate_h"));
        break label446;
        label1658:
        f2 = a.f((int)l1, (float[])paramf.noN.get("lastsessionduration"));
        break label468;
        f2 = a.f((int)l1, (float[])paramf.noN.get("wechatduration7dayhour"));
        break label490;
        f2 = a.f((int)l1, (float[])paramf.noN.get("wechatdurationnminute_10"));
        break label519;
        f2 = a.f((int)l1, (float[])paramf.noN.get("wechatdurationnminute_30"));
        break label540;
        label1754:
        f2 = a.f((int)l1, (float[])paramf.noN.get("wechatdurationnminute_90"));
        break label561;
        label1778:
        f2 = a.f((int)l1, (float[])paramf.noN.get("findfrienduiexposure_10"));
        break label590;
        f2 = a.f((int)l1, (float[])paramf.noN.get("findfrienduiexposure_30"));
        break label611;
      }
    }
  }
  
  private static long[] abs(String paramString)
  {
    AppMethodBeat.i(239257);
    arrayOfLong = new long[nnU.length];
    try
    {
      paramString = new JSONObject(paramString.replaceAll(";", ","));
      int i = 0;
      while (i < nnU.length)
      {
        arrayOfLong[i] = paramString.optLong(nnU[i], -1L);
        i += 1;
      }
      return arrayOfLong;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(239257);
    }
  }
  
  public final Object[] bAY()
  {
    AppMethodBeat.i(239254);
    Object[] arrayOfObject = new Object[25];
    try
    {
      arrayOfObject[0] = { { this.nol } };
      arrayOfObject[1] = { { this.nom } };
      arrayOfObject[2] = { { this.nok } };
      arrayOfObject[3] = { { this.noD } };
      arrayOfObject[4] = { { this.noE } };
      arrayOfObject[5] = { { this.noF } };
      arrayOfObject[6] = { { this.non } };
      arrayOfObject[7] = { { this.noi } };
      arrayOfObject[8] = { { this.not } };
      arrayOfObject[9] = { { this.noy } };
      arrayOfObject[10] = { { this.nor } };
      arrayOfObject[11] = { { this.nos } };
      arrayOfObject[12] = { { this.noo } };
      arrayOfObject[13] = { { this.noj } };
      arrayOfObject[14] = { { this.nov } };
      arrayOfObject[15] = { { this.nou } };
      arrayOfObject[16] = { { this.now } };
      arrayOfObject[17] = { { this.nox } };
      arrayOfObject[18] = { { this.noh } };
      arrayOfObject[19] = { { this.noq } };
      arrayOfObject[20] = { { this.nop } };
      arrayOfObject[21] = { { this.noz } };
      arrayOfObject[22] = { { this.noA } };
      arrayOfObject[23] = { { this.noB } };
      arrayOfObject[24] = { { this.noC } };
      AppMethodBeat.o(239254);
      return arrayOfObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AiFinderFeatureStruct", "put data error [%s]", new Object[] { localException.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */