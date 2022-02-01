package com.tencent.mm.plugin.ai.data.business.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ai.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class d
{
  private static final int[] qlb = { 10, 30, 90 };
  public long qlA;
  public long qlB;
  public long qlC;
  public float qlD;
  public long qlE;
  public long qlF;
  public float qlG;
  public float qlH;
  public float qlI;
  public float qlJ;
  public float qlK;
  public float qlL;
  public float qlM;
  public String qlN;
  public float qlo;
  public float qlp;
  public float qlq;
  public float qlr;
  public float qls;
  public float qlt;
  public float qlu;
  public float qlv;
  public long qlw;
  public long qlx;
  public long qly;
  public long qlz;
  
  public d()
  {
    this.qlv = 0.0F;
  }
  
  public d(com.tencent.mm.autogen.mmdata.rpt.e parame, f paramf, g paramg)
  {
    AppMethodBeat.i(267502);
    this.qlv = 0.0F;
    int i = (int)parame.ijN;
    label54:
    long l2;
    int j;
    long l1;
    label89:
    label105:
    label234:
    boolean bool;
    if (!paramf.plZ)
    {
      f1 = 0.0F;
      this.qlo = f1;
      i = (int)parame.iju;
      if (paramf.plZ) {
        break label946;
      }
      f1 = 0.0F;
      this.qlq = f1;
      l2 = Util.nowMilliSecond();
      j = a.jv(l2);
      i = a.jw(l2);
      if (paramg.plZ) {
        break label969;
      }
      l1 = 0L;
      this.qlw = l1;
      if (paramg.plZ) {
        break label1024;
      }
      l1 = 0L;
      this.qlx = l1;
      i = (int)parame.ijJ;
      if (paramf.plZ) {
        break label1079;
      }
      f1 = 0.0F;
      label128:
      this.qlu = f1;
      if (parame.ijM != 1L) {
        break label1102;
      }
      i = 1;
      label146:
      if (paramg.plZ) {
        break label1108;
      }
      l1 = 0L;
      label156:
      this.qly = l1;
      if (parame.ijO != 1L) {
        break label1177;
      }
      i = 1;
      label174:
      if (paramg.plZ) {
        break label1183;
      }
      l1 = 0L;
      label184:
      this.qlz = l1;
      if (parame.ijI != 1L) {
        break label1252;
      }
      i = 1;
      label202:
      if (paramg.plZ) {
        break label1258;
      }
      l1 = 0L;
      label212:
      this.qlA = l1;
      i = parame.ijG;
      if (paramg.plZ) {
        break label1327;
      }
      l1 = 0L;
      this.qlB = l1;
      i = parame.ijF;
      if (paramg.plZ) {
        break label1382;
      }
      l1 = 0L;
      label256:
      this.qlC = l1;
      i = Util.getInt(parame.ijH, -1);
      if (i <= 0) {
        break label1492;
      }
      if (paramg.plZ) {
        break label1437;
      }
      l1 = 0L;
      label287:
      this.qlE = l1;
      label293:
      bool = parame.ijs;
      if (paramg.plZ) {
        break label1500;
      }
      l1 = 0L;
      label309:
      this.qlF = l1;
      l1 = l2 - parame.ijt;
      if (l1 >= 0L)
      {
        i = (int)l1 / 1000 / 60 / 60;
        if (paramf.plZ) {
          break label1566;
        }
        f1 = 0.0F;
        label356:
        this.qlp = f1;
      }
      i = com.tencent.mm.plugin.ai.d.e.caH().qpp.yM(j);
      j = com.tencent.mm.plugin.ai.d.e.caH().qpp.yN(j);
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
      if (!paramf.plZ)
      {
        f2 = 0.0F;
        this.qlr = f2;
        if (paramf.plZ) {
          break label1612;
        }
        f2 = 0.0F;
        this.qls = f2;
        if (paramf.plZ) {
          break label1635;
        }
        f2 = 0.0F;
        this.qlt = f2;
        l1 = parame.ijR;
        if (paramf.plZ) {
          break label1658;
        }
        f2 = 0.0F;
        this.qlD = f2;
        l1 = parame.ijT;
        if (paramf.plZ) {
          break label1682;
        }
        f2 = 0.0F;
        label490:
        this.qlG = f2;
        paramg = TJ(parame.ijU);
        l1 = paramg[0];
        if (paramf.plZ) {
          break label1706;
        }
        f2 = 0.0F;
        this.qlH = f2;
        l1 = paramg[1];
        if (paramf.plZ) {
          break label1730;
        }
        f2 = 0.0F;
        this.qlI = f2;
        l1 = paramg[2];
        if (paramf.plZ) {
          break label1754;
        }
        f2 = 0.0F;
        this.qlJ = f2;
        paramg = TJ(parame.ijS);
        l1 = paramg[0];
        if (paramf.plZ) {
          break label1778;
        }
        f2 = 0.0F;
        this.qlK = f2;
        l1 = paramg[1];
        if (paramf.plZ) {
          break label1802;
        }
        f2 = 0.0F;
        label611:
        this.qlL = f2;
        l1 = paramg[2];
        if (paramf.plZ) {
          break label1826;
        }
      }
      for (float f2 = 0.0F;; f2 = a.f((int)l1, (float[])paramf.qmf.get("findfrienduiexposure_90")))
      {
        this.qlM = f2;
        paramf = new JSONObject();
        try
        {
          paramf.put("now", l2);
          paramf.put("currHour", a.jv(l2));
          paramf.put("currWeekday", a.jw(l2));
          paramf.put("_7Exposure", i);
          paramf.put("_7Click", j);
          paramf.put("_7Rate", f1);
          paramf.put("snsunread", parame.ijN);
          paramf.put("lastStaySecs", parame.iju);
          paramf.put("friendsTabUnread", parame.ijJ);
          paramf.put("isSnsRedDot", parame.ijM);
          paramf.put("isTopStoryRedDot", parame.ijO);
          paramf.put("isFriendsTabRedDot", parame.ijI);
          paramf.put("lastFinderRedDotShowType", parame.ijG);
          paramf.put("lastFinderRedDotCtrlType", parame.ijF);
          paramf.put("sessionId", parame.ijH);
          paramf.put("isNewMsgOpenWechat", parame.ijs);
          l1 = l2 - parame.ijt;
          if (l1 >= 0L) {
            paramf.put("fromLastHours", (int)l1 / 1000 / 60 / 60);
          }
          paramf.put("lastsessionduration", parame.ijR);
          paramf.put("wechatduration7dayhour", parame.ijT);
          paramf.put("wechatdurationnminute", parame.ijU);
          paramf.put("findfrienduiexposure", parame.ijS);
          this.qlN = paramf.toString().replace(",", ";");
          AppMethodBeat.o(267502);
          return;
        }
        catch (Exception parame)
        {
          HashMap localHashMap;
          Log.d("MicroMsg.AiFinderFeatureStruct", "note input error:[%s]", new Object[] { parame.toString() });
          AppMethodBeat.o(267502);
          return;
        }
        f1 = a.f(i, (float[])paramf.qmf.get("snsunread"));
        break;
        f1 = a.f(i, (float[])paramf.qmf.get("last_stay_secs"));
        break label54;
        localHashMap = (HashMap)paramg.qmf.get("starttime_to_weekday");
        if (!localHashMap.containsKey(Integer.valueOf(i)))
        {
          l1 = 0L;
          break label89;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label89;
        localHashMap = (HashMap)paramg.qmf.get("starttime_to_24h");
        if (!localHashMap.containsKey(Integer.valueOf(j)))
        {
          l1 = 0L;
          break label105;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(j))).longValue();
        break label105;
        f1 = a.f(i, (float[])paramf.qmf.get("friendstabredunread"));
        break label128;
        i = 0;
        break label146;
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          localHashMap = (HashMap)paramg.qmf.get("is_snsreddot");
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
          localHashMap = (HashMap)paramg.qmf.get("is_topstoryreddot");
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
          localHashMap = (HashMap)paramg.qmf.get("is_friendstabreddot");
          if (localHashMap.containsKey(Integer.valueOf(i))) {
            break label1306;
          }
          l1 = 0L;
          break;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label212;
        localHashMap = (HashMap)paramg.qmf.get("lastfinderreddotshowtype");
        if (!localHashMap.containsKey(Integer.valueOf(i)))
        {
          l1 = 0L;
          break label234;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label234;
        label1382:
        localHashMap = (HashMap)paramg.qmf.get("lastfinderreddotctrltype");
        if (!localHashMap.containsKey(Integer.valueOf(i)))
        {
          l1 = 0L;
          break label256;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label256;
        localHashMap = (HashMap)paramg.qmf.get("lastsessionid");
        if (!localHashMap.containsKey(Integer.valueOf(i)))
        {
          l1 = 0L;
          break label287;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label287;
        this.qlE = 0L;
        break label293;
        label1500:
        if (bool) {}
        for (i = 1;; i = 0)
        {
          paramg = (HashMap)paramg.qmf.get("is_newmsgopenwechat");
          if (paramg.containsKey(Integer.valueOf(i))) {
            break label1546;
          }
          l1 = 0L;
          break;
        }
        l1 = ((Long)paramg.get(Integer.valueOf(i))).longValue();
        break label309;
        f1 = a.f(i, (float[])paramf.qmf.get("from_last_hours"));
        break label356;
        f2 = a.f(i, (float[])paramf.qmf.get("7day_impr_h"));
        break label414;
        f2 = a.f(j, (float[])paramf.qmf.get("7day_clk_h"));
        break label430;
        label1635:
        f2 = a.a(f1, (float[])paramf.qmf.get("7day_clk_rate_h"));
        break label446;
        label1658:
        f2 = a.f((int)l1, (float[])paramf.qmf.get("lastsessionduration"));
        break label468;
        f2 = a.f((int)l1, (float[])paramf.qmf.get("wechatduration7dayhour"));
        break label490;
        f2 = a.f((int)l1, (float[])paramf.qmf.get("wechatdurationnminute_10"));
        break label519;
        f2 = a.f((int)l1, (float[])paramf.qmf.get("wechatdurationnminute_30"));
        break label540;
        label1754:
        f2 = a.f((int)l1, (float[])paramf.qmf.get("wechatdurationnminute_90"));
        break label561;
        label1778:
        f2 = a.f((int)l1, (float[])paramf.qmf.get("findfrienduiexposure_10"));
        break label590;
        f2 = a.f((int)l1, (float[])paramf.qmf.get("findfrienduiexposure_30"));
        break label611;
      }
    }
  }
  
  private static long[] TJ(String paramString)
  {
    AppMethodBeat.i(267510);
    arrayOfLong = new long[qlb.length];
    try
    {
      paramString = new JSONObject(paramString.replaceAll(";", ","));
      int i = 0;
      while (i < qlb.length)
      {
        arrayOfLong[i] = paramString.optLong(qlb[i], -1L);
        i += 1;
      }
      return arrayOfLong;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(267510);
    }
  }
  
  public final Object[] bZL()
  {
    AppMethodBeat.i(267533);
    Object[] arrayOfObject = new Object[25];
    try
    {
      arrayOfObject[0] = { { this.qls } };
      arrayOfObject[1] = { { this.qlt } };
      arrayOfObject[2] = { { this.qlr } };
      arrayOfObject[3] = { { this.qlK } };
      arrayOfObject[4] = { { this.qlL } };
      arrayOfObject[5] = { { this.qlM } };
      arrayOfObject[6] = { { this.qlu } };
      arrayOfObject[7] = { { this.qlp } };
      arrayOfObject[8] = { { this.qlA } };
      arrayOfObject[9] = { { this.qlF } };
      arrayOfObject[10] = { { this.qly } };
      arrayOfObject[11] = { { this.qlz } };
      arrayOfObject[12] = { { this.qlv } };
      arrayOfObject[13] = { { this.qlq } };
      arrayOfObject[14] = { { this.qlC } };
      arrayOfObject[15] = { { this.qlB } };
      arrayOfObject[16] = { { this.qlD } };
      arrayOfObject[17] = { { this.qlE } };
      arrayOfObject[18] = { { this.qlo } };
      arrayOfObject[19] = { { this.qlx } };
      arrayOfObject[20] = { { this.qlw } };
      arrayOfObject[21] = { { this.qlG } };
      arrayOfObject[22] = { { this.qlH } };
      arrayOfObject[23] = { { this.qlI } };
      arrayOfObject[24] = { { this.qlJ } };
      AppMethodBeat.o(267533);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.finder.d
 * JD-Core Version:    0.7.0.1
 */