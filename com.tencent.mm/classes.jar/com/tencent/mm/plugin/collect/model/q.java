package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
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
  private int limit;
  public boolean ooe;
  public boolean vBn;
  public int wYX;
  public int wYY;
  public int wYZ;
  public long wYy;
  public int wZa;
  public String wZb;
  public List<g> wZc;
  
  public q(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(63843);
    this.ooe = false;
    this.vBn = false;
    this.wZc = new ArrayList();
    this.limit = paramInt2;
    this.wYY = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    localHashMap.put("from_timestamp", String.valueOf(paramLong));
    localHashMap.put("direction_flag", "0");
    localHashMap.put("num", String.valueOf(paramInt2));
    localHashMap.put("choose_flag", String.valueOf(paramInt3));
    setRequestData(localHashMap);
    AppMethodBeat.o(63843);
  }
  
  public q(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(63844);
    this.ooe = false;
    this.vBn = false;
    this.wZc = new ArrayList();
    this.vBn = true;
    this.limit = paramInt3;
    this.wYY = paramInt2;
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
    Log.d("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "json: %s", new Object[] { paramJSONObject.toString() });
    this.wYX = paramJSONObject.optInt("choose_flag", 0);
    this.wYy = paramJSONObject.optLong("from_timestamp", -1L);
    this.wYZ = paramJSONObject.optInt("finish_flag", 0);
    this.wZa = paramJSONObject.optInt("try_num", 0);
    this.wZb = paramJSONObject.optString("retmsg", "");
    paramString = paramJSONObject.optJSONArray("records");
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "empty records");
      if (this.wYZ == 1)
      {
        Log.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "finish query");
        this.ooe = true;
      }
      AppMethodBeat.o(63845);
      return;
    }
    paramInt = 0;
    while (paramInt < paramString.length()) {
      try
      {
        paramJSONObject = paramString.getJSONObject(paramInt);
        g localg = new g();
        localg.type = paramJSONObject.optInt("type", 0);
        localg.wYy = paramJSONObject.optLong("from_timestamp", 0L);
        localg.wYz = paramJSONObject.optInt("total_num", 0);
        localg.hHX = paramJSONObject.optInt("total_amt", 0);
        this.wZc.add(localg);
        paramInt += 1;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneTenpayF2fHistoryRecordList", paramJSONObject, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.q
 * JD-Core Version:    0.7.0.1
 */