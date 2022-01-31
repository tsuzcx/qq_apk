package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class q
  extends m
{
  public boolean fon;
  public String hxt;
  public boolean isRetry;
  public int kNM;
  public int kNN;
  public int kNO;
  public int kNP;
  public List<h> kNQ;
  public long kNm;
  private int limit;
  
  public q(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(40991);
    this.fon = false;
    this.isRetry = false;
    this.kNQ = new ArrayList();
    this.limit = paramInt2;
    this.kNN = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    localHashMap.put("from_timestamp", String.valueOf(paramLong));
    localHashMap.put("direction_flag", "0");
    localHashMap.put("num", String.valueOf(paramInt2));
    localHashMap.put("choose_flag", String.valueOf(paramInt3));
    setRequestData(localHashMap);
    AppMethodBeat.o(40991);
  }
  
  public q(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(40992);
    this.fon = false;
    this.isRetry = false;
    this.kNQ = new ArrayList();
    this.isRetry = true;
    this.limit = paramInt3;
    this.kNN = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    localHashMap.put("from_timestamp", String.valueOf(paramLong));
    localHashMap.put("direction_flag", String.valueOf(paramInt2));
    localHashMap.put("num", String.valueOf(paramInt3));
    localHashMap.put("choose_flag", String.valueOf(paramInt4));
    localHashMap.put("try_num", String.valueOf(paramInt5));
    setRequestData(localHashMap);
    AppMethodBeat.o(40992);
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
    AppMethodBeat.i(40993);
    ab.d("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "json: %s", new Object[] { paramJSONObject.toString() });
    this.kNM = paramJSONObject.optInt("choose_flag", 0);
    this.kNm = paramJSONObject.optLong("from_timestamp", -1L);
    this.kNO = paramJSONObject.optInt("finish_flag", 0);
    this.kNP = paramJSONObject.optInt("try_num", 0);
    this.hxt = paramJSONObject.optString("retmsg", "");
    paramString = paramJSONObject.optJSONArray("records");
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ab.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "empty records");
      if (this.kNO == 1)
      {
        ab.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "finish query");
        this.fon = true;
      }
      AppMethodBeat.o(40993);
      return;
    }
    paramInt = 0;
    while (paramInt < paramString.length()) {
      try
      {
        paramJSONObject = paramString.getJSONObject(paramInt);
        h localh = new h();
        localh.type = paramJSONObject.optInt("type", 0);
        localh.kNm = paramJSONObject.optLong("from_timestamp", 0L);
        localh.kNn = paramJSONObject.optInt("total_num", 0);
        localh.kNo = paramJSONObject.optInt("total_amt", 0);
        this.kNQ.add(localh);
        paramInt += 1;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneTenpayF2fHistoryRecordList", paramJSONObject, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.q
 * JD-Core Version:    0.7.0.1
 */