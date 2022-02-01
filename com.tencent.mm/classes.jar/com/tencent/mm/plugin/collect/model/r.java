package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
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
  public boolean hqq;
  public boolean isRetry;
  public String jXd;
  private int limit;
  public long owV;
  public int oxu;
  public int oxv;
  public int oxw;
  public int oxx;
  public List<h> oxy;
  
  public r(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(63843);
    this.hqq = false;
    this.isRetry = false;
    this.oxy = new ArrayList();
    this.limit = paramInt2;
    this.oxv = 0;
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
    this.hqq = false;
    this.isRetry = false;
    this.oxy = new ArrayList();
    this.isRetry = true;
    this.limit = paramInt3;
    this.oxv = paramInt2;
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
    ac.d("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "json: %s", new Object[] { paramJSONObject.toString() });
    this.oxu = paramJSONObject.optInt("choose_flag", 0);
    this.owV = paramJSONObject.optLong("from_timestamp", -1L);
    this.oxw = paramJSONObject.optInt("finish_flag", 0);
    this.oxx = paramJSONObject.optInt("try_num", 0);
    this.jXd = paramJSONObject.optString("retmsg", "");
    paramString = paramJSONObject.optJSONArray("records");
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ac.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "empty records");
      if (this.oxw == 1)
      {
        ac.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "finish query");
        this.hqq = true;
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
        localh.owV = paramJSONObject.optLong("from_timestamp", 0L);
        localh.owW = paramJSONObject.optInt("total_num", 0);
        localh.dgH = paramJSONObject.optInt("total_amt", 0);
        this.oxy.add(localh);
        paramInt += 1;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.NetSceneTenpayF2fHistoryRecordList", paramJSONObject, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.r
 * JD-Core Version:    0.7.0.1
 */