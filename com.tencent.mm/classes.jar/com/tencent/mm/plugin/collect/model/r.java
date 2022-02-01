package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r
  extends m
{
  public boolean hLB;
  public boolean isRetry;
  public String kuP;
  private int limit;
  public long pgU;
  public int pht;
  public int phu;
  public int phv;
  public int phw;
  public List<h> phx;
  
  public r(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(63843);
    this.hLB = false;
    this.isRetry = false;
    this.phx = new ArrayList();
    this.limit = paramInt2;
    this.phu = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    localHashMap.put("from_timestamp", String.valueOf(paramLong));
    localHashMap.put("direction_flag", "0");
    localHashMap.put("num", String.valueOf(paramInt2));
    localHashMap.put("choose_flag", String.valueOf(paramInt3));
    setRequestData(localHashMap);
    AppMethodBeat.o(63843);
  }
  
  public r(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(63844);
    this.hLB = false;
    this.isRetry = false;
    this.phx = new ArrayList();
    this.isRetry = true;
    this.limit = paramInt3;
    this.phu = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    localHashMap.put("from_timestamp", String.valueOf(paramLong));
    localHashMap.put("direction_flag", String.valueOf(paramInt2));
    localHashMap.put("num", String.valueOf(paramInt3));
    localHashMap.put("choose_flag", String.valueOf(paramInt4));
    localHashMap.put("try_num", String.valueOf(paramInt5));
    setRequestData(localHashMap);
    AppMethodBeat.o(63844);
  }
  
  public final int getFuncId()
  {
    return 1993;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/f2frcvrcdhissta";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(63845);
    ae.d("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "json: %s", new Object[] { paramJSONObject.toString() });
    this.pht = paramJSONObject.optInt("choose_flag", 0);
    this.pgU = paramJSONObject.optLong("from_timestamp", -1L);
    this.phv = paramJSONObject.optInt("finish_flag", 0);
    this.phw = paramJSONObject.optInt("try_num", 0);
    this.kuP = paramJSONObject.optString("retmsg", "");
    paramString = paramJSONObject.optJSONArray("records");
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ae.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "empty records");
      if (this.phv == 1)
      {
        ae.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "finish query");
        this.hLB = true;
      }
      AppMethodBeat.o(63845);
      return;
    }
    paramInt = 0;
    while (paramInt < paramString.length()) {
      try
      {
        paramJSONObject = paramString.getJSONObject(paramInt);
        h localh = new h();
        localh.type = paramJSONObject.optInt("type", 0);
        localh.pgU = paramJSONObject.optLong("from_timestamp", 0L);
        localh.pgV = paramJSONObject.optInt("total_num", 0);
        localh.dtj = paramJSONObject.optInt("total_amt", 0);
        this.phx.add(localh);
        paramInt += 1;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.NetSceneTenpayF2fHistoryRecordList", paramJSONObject, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.r
 * JD-Core Version:    0.7.0.1
 */