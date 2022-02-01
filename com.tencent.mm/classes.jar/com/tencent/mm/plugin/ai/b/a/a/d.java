package com.tencent.mm.plugin.ai.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ai.c.a;
import com.tencent.mm.plugin.ai.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class d
{
  private static final int[] kvJ = { 10, 30, 90 };
  public float kvZ;
  public float kwa;
  public float kwb;
  public float kwc;
  public float kwd;
  public float kwe;
  public float kwf;
  public float kwg;
  public long kwh;
  public long kwi;
  public long kwj;
  public long kwk;
  public long kwl;
  public long kwm;
  public long kwn;
  public float kwo;
  public long kwp;
  public long kwq;
  public float kwr;
  public float kws;
  public float kwt;
  public float kwu;
  public float kwv;
  public float kww;
  public float kwx;
  public String kwy;
  
  public d()
  {
    this.kwg = 0.0F;
  }
  
  public d(com.tencent.mm.g.b.a.d paramd, e parame, f paramf)
  {
    AppMethodBeat.i(238880);
    this.kwg = 0.0F;
    int i = (int)paramd.eje;
    label54:
    long l2;
    int j;
    long l1;
    label89:
    label105:
    label234:
    boolean bool;
    if (!parame.jCx)
    {
      f1 = 0.0F;
      this.kvZ = f1;
      i = (int)paramd.eiL;
      if (parame.jCx) {
        break label946;
      }
      f1 = 0.0F;
      this.kwb = f1;
      l2 = Util.nowMilliSecond();
      j = a.AU(l2);
      i = a.AV(l2);
      if (paramf.jCx) {
        break label969;
      }
      l1 = 0L;
      this.kwh = l1;
      if (paramf.jCx) {
        break label1024;
      }
      l1 = 0L;
      this.kwi = l1;
      i = (int)paramd.eja;
      if (parame.jCx) {
        break label1079;
      }
      f1 = 0.0F;
      label128:
      this.kwf = f1;
      if (paramd.ejd != 1L) {
        break label1102;
      }
      i = 1;
      label146:
      if (paramf.jCx) {
        break label1108;
      }
      l1 = 0L;
      label156:
      this.kwj = l1;
      if (paramd.ejf != 1L) {
        break label1177;
      }
      i = 1;
      label174:
      if (paramf.jCx) {
        break label1183;
      }
      l1 = 0L;
      label184:
      this.kwk = l1;
      if (paramd.eiZ != 1L) {
        break label1252;
      }
      i = 1;
      label202:
      if (paramf.jCx) {
        break label1258;
      }
      l1 = 0L;
      label212:
      this.kwl = l1;
      i = paramd.eiX;
      if (paramf.jCx) {
        break label1327;
      }
      l1 = 0L;
      this.kwm = l1;
      i = paramd.eiW;
      if (paramf.jCx) {
        break label1382;
      }
      l1 = 0L;
      label256:
      this.kwn = l1;
      i = Util.getInt(paramd.eiY, -1);
      if (i <= 0) {
        break label1492;
      }
      if (paramf.jCx) {
        break label1437;
      }
      l1 = 0L;
      label287:
      this.kwp = l1;
      label293:
      bool = paramd.eiJ;
      if (paramf.jCx) {
        break label1500;
      }
      l1 = 0L;
      label309:
      this.kwq = l1;
      l1 = l2 - paramd.eiK;
      if (l1 >= 0L)
      {
        i = (int)l1 / 1000 / 60 / 60;
        if (parame.jCx) {
          break label1566;
        }
        f1 = 0.0F;
        label356:
        this.kwa = f1;
      }
      i = b.bqC().kxI.vu(j);
      j = b.bqC().kxI.vv(j);
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
      if (!parame.jCx)
      {
        f2 = 0.0F;
        this.kwc = f2;
        if (parame.jCx) {
          break label1612;
        }
        f2 = 0.0F;
        this.kwd = f2;
        if (parame.jCx) {
          break label1635;
        }
        f2 = 0.0F;
        this.kwe = f2;
        l1 = paramd.eji;
        if (parame.jCx) {
          break label1658;
        }
        f2 = 0.0F;
        this.kwo = f2;
        l1 = paramd.ejk;
        if (parame.jCx) {
          break label1682;
        }
        f2 = 0.0F;
        label490:
        this.kwr = f2;
        paramf = TJ(paramd.ejl);
        l1 = paramf[0];
        if (parame.jCx) {
          break label1706;
        }
        f2 = 0.0F;
        this.kws = f2;
        l1 = paramf[1];
        if (parame.jCx) {
          break label1730;
        }
        f2 = 0.0F;
        this.kwt = f2;
        l1 = paramf[2];
        if (parame.jCx) {
          break label1754;
        }
        f2 = 0.0F;
        this.kwu = f2;
        paramf = TJ(paramd.ejj);
        l1 = paramf[0];
        if (parame.jCx) {
          break label1778;
        }
        f2 = 0.0F;
        this.kwv = f2;
        l1 = paramf[1];
        if (parame.jCx) {
          break label1802;
        }
        f2 = 0.0F;
        label611:
        this.kww = f2;
        l1 = paramf[2];
        if (parame.jCx) {
          break label1826;
        }
      }
      for (float f2 = 0.0F;; f2 = a.f((int)l1, (float[])parame.kwA.get("findfrienduiexposure_90")))
      {
        this.kwx = f2;
        parame = new JSONObject();
        try
        {
          parame.put("now", l2);
          parame.put("currHour", a.AU(l2));
          parame.put("currWeekday", a.AV(l2));
          parame.put("_7Exposure", i);
          parame.put("_7Click", j);
          parame.put("_7Rate", f1);
          parame.put("snsunread", paramd.eje);
          parame.put("lastStaySecs", paramd.eiL);
          parame.put("friendsTabUnread", paramd.eja);
          parame.put("isSnsRedDot", paramd.ejd);
          parame.put("isTopStoryRedDot", paramd.ejf);
          parame.put("isFriendsTabRedDot", paramd.eiZ);
          parame.put("lastFinderRedDotShowType", paramd.eiX);
          parame.put("lastFinderRedDotCtrlType", paramd.eiW);
          parame.put("sessionId", paramd.eiY);
          parame.put("isNewMsgOpenWechat", paramd.eiJ);
          l1 = l2 - paramd.eiK;
          if (l1 >= 0L) {
            parame.put("fromLastHours", (int)l1 / 1000 / 60 / 60);
          }
          parame.put("lastsessionduration", paramd.eji);
          parame.put("wechatduration7dayhour", paramd.ejk);
          parame.put("wechatdurationnminute", paramd.ejl);
          parame.put("findfrienduiexposure", paramd.ejj);
          this.kwy = parame.toString().replace(",", ";");
          AppMethodBeat.o(238880);
          return;
        }
        catch (Exception paramd)
        {
          HashMap localHashMap;
          Log.d("MicroMsg.AiFinderFeatureStruct", "note input error:[%s]", new Object[] { paramd.toString() });
          AppMethodBeat.o(238880);
          return;
        }
        f1 = a.f(i, (float[])parame.kwA.get("snsunread"));
        break;
        f1 = a.f(i, (float[])parame.kwA.get("last_stay_secs"));
        break label54;
        localHashMap = (HashMap)paramf.kwA.get("starttime_to_weekday");
        if (!localHashMap.containsKey(Integer.valueOf(i)))
        {
          l1 = 0L;
          break label89;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label89;
        localHashMap = (HashMap)paramf.kwA.get("starttime_to_24h");
        if (!localHashMap.containsKey(Integer.valueOf(j)))
        {
          l1 = 0L;
          break label105;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(j))).longValue();
        break label105;
        f1 = a.f(i, (float[])parame.kwA.get("friendstabredunread"));
        break label128;
        i = 0;
        break label146;
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          localHashMap = (HashMap)paramf.kwA.get("is_snsreddot");
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
          localHashMap = (HashMap)paramf.kwA.get("is_topstoryreddot");
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
          localHashMap = (HashMap)paramf.kwA.get("is_friendstabreddot");
          if (localHashMap.containsKey(Integer.valueOf(i))) {
            break label1306;
          }
          l1 = 0L;
          break;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label212;
        localHashMap = (HashMap)paramf.kwA.get("lastfinderreddotshowtype");
        if (!localHashMap.containsKey(Integer.valueOf(i)))
        {
          l1 = 0L;
          break label234;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label234;
        label1382:
        localHashMap = (HashMap)paramf.kwA.get("lastfinderreddotctrltype");
        if (!localHashMap.containsKey(Integer.valueOf(i)))
        {
          l1 = 0L;
          break label256;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label256;
        localHashMap = (HashMap)paramf.kwA.get("lastsessionid");
        if (!localHashMap.containsKey(Integer.valueOf(i)))
        {
          l1 = 0L;
          break label287;
        }
        l1 = ((Long)localHashMap.get(Integer.valueOf(i))).longValue();
        break label287;
        this.kwp = 0L;
        break label293;
        label1500:
        if (bool) {}
        for (i = 1;; i = 0)
        {
          paramf = (HashMap)paramf.kwA.get("is_newmsgopenwechat");
          if (paramf.containsKey(Integer.valueOf(i))) {
            break label1546;
          }
          l1 = 0L;
          break;
        }
        l1 = ((Long)paramf.get(Integer.valueOf(i))).longValue();
        break label309;
        f1 = a.f(i, (float[])parame.kwA.get("from_last_hours"));
        break label356;
        f2 = a.f(i, (float[])parame.kwA.get("7day_impr_h"));
        break label414;
        f2 = a.f(j, (float[])parame.kwA.get("7day_clk_h"));
        break label430;
        label1635:
        f2 = a.a(f1, (float[])parame.kwA.get("7day_clk_rate_h"));
        break label446;
        label1658:
        f2 = a.f((int)l1, (float[])parame.kwA.get("lastsessionduration"));
        break label468;
        f2 = a.f((int)l1, (float[])parame.kwA.get("wechatduration7dayhour"));
        break label490;
        f2 = a.f((int)l1, (float[])parame.kwA.get("wechatdurationnminute_10"));
        break label519;
        f2 = a.f((int)l1, (float[])parame.kwA.get("wechatdurationnminute_30"));
        break label540;
        label1754:
        f2 = a.f((int)l1, (float[])parame.kwA.get("wechatdurationnminute_90"));
        break label561;
        label1778:
        f2 = a.f((int)l1, (float[])parame.kwA.get("findfrienduiexposure_10"));
        break label590;
        f2 = a.f((int)l1, (float[])parame.kwA.get("findfrienduiexposure_30"));
        break label611;
      }
    }
  }
  
  private static long[] TJ(String paramString)
  {
    AppMethodBeat.i(238882);
    arrayOfLong = new long[kvJ.length];
    try
    {
      paramString = new JSONObject(paramString.replaceAll(";", ","));
      int i = 0;
      while (i < kvJ.length)
      {
        arrayOfLong[i] = paramString.optLong(kvJ[i], -1L);
        i += 1;
      }
      return arrayOfLong;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(238882);
    }
  }
  
  public final Object[] bqu()
  {
    AppMethodBeat.i(238881);
    Object[] arrayOfObject = new Object[25];
    try
    {
      arrayOfObject[0] = { { this.kwd } };
      arrayOfObject[1] = { { this.kwe } };
      arrayOfObject[2] = { { this.kwc } };
      arrayOfObject[3] = { { this.kwv } };
      arrayOfObject[4] = { { this.kww } };
      arrayOfObject[5] = { { this.kwx } };
      arrayOfObject[6] = { { this.kwf } };
      arrayOfObject[7] = { { this.kwa } };
      arrayOfObject[8] = { { this.kwl } };
      arrayOfObject[9] = { { this.kwq } };
      arrayOfObject[10] = { { this.kwj } };
      arrayOfObject[11] = { { this.kwk } };
      arrayOfObject[12] = { { this.kwg } };
      arrayOfObject[13] = { { this.kwb } };
      arrayOfObject[14] = { { this.kwn } };
      arrayOfObject[15] = { { this.kwm } };
      arrayOfObject[16] = { { this.kwo } };
      arrayOfObject[17] = { { this.kwp } };
      arrayOfObject[18] = { { this.kvZ } };
      arrayOfObject[19] = { { this.kwi } };
      arrayOfObject[20] = { { this.kwh } };
      arrayOfObject[21] = { { this.kwr } };
      arrayOfObject[22] = { { this.kws } };
      arrayOfObject[23] = { { this.kwt } };
      arrayOfObject[24] = { { this.kwu } };
      AppMethodBeat.o(238881);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */