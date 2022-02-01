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

public final class t
  extends m
{
  public int fDi;
  private int limit;
  public boolean lwF;
  public List<a> tVI;
  public long tVc;
  public int tVd;
  public int type;
  
  public t(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    AppMethodBeat.i(63846);
    this.tVI = new ArrayList();
    this.lwF = false;
    this.limit = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    localHashMap.put("from_timestamp", String.valueOf(paramLong));
    localHashMap.put("last_bill_id", paramString);
    localHashMap.put("num", String.valueOf(paramInt2));
    setRequestData(localHashMap);
    AppMethodBeat.o(63846);
  }
  
  public final int getFuncId()
  {
    return 1963;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/f2frcvdlist";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(63847);
    this.tVd = paramJSONObject.optInt("total_num");
    this.fDi = paramJSONObject.optInt("total_amt");
    this.tVc = paramJSONObject.optLong("from_timestamp", 0L);
    this.type = paramJSONObject.optInt("type", 0);
    paramString = paramJSONObject.optJSONArray("records");
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.i("MicroMsg.NetSceneTenpayF2fRecordList", "empty records");
      if (this.tVI.size() < this.limit)
      {
        Log.i("MicroMsg.NetSceneTenpayF2fRecordList", "finish query");
        this.lwF = true;
      }
      AppMethodBeat.o(63847);
      return;
    }
    paramInt = 0;
    while (paramInt < paramString.length()) {
      try
      {
        paramJSONObject = paramString.getJSONObject(paramInt);
        a locala = new a();
        locala.tUB = paramJSONObject.optString("bill_id");
        locala.tUC = paramJSONObject.optString("trans_id");
        locala.timestamp = paramJSONObject.optLong("timestamp", 0L);
        locala.desc = paramJSONObject.optString("desc");
        locala.fee = paramJSONObject.optInt("fee", 0);
        this.tVI.add(locala);
        paramInt += 1;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneTenpayF2fRecordList", paramJSONObject, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.t
 * JD-Core Version:    0.7.0.1
 */