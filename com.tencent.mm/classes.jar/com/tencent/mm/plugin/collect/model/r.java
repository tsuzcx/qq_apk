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

public final class r
  extends m
{
  public boolean fon;
  public List<a> kNQ;
  public long kNm;
  public int kNn;
  public int kNo;
  private int limit;
  public int type;
  
  public r(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    AppMethodBeat.i(40994);
    this.kNQ = new ArrayList();
    this.fon = false;
    this.limit = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    localHashMap.put("from_timestamp", String.valueOf(paramLong));
    localHashMap.put("last_bill_id", paramString);
    localHashMap.put("num", String.valueOf(paramInt2));
    setRequestData(localHashMap);
    AppMethodBeat.o(40994);
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
    AppMethodBeat.i(40995);
    this.kNn = paramJSONObject.optInt("total_num");
    this.kNo = paramJSONObject.optInt("total_amt");
    this.kNm = paramJSONObject.optLong("from_timestamp", 0L);
    this.type = paramJSONObject.optInt("type", 0);
    paramString = paramJSONObject.optJSONArray("records");
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ab.i("MicroMsg.NetSceneTenpayF2fRecordList", "empty records");
      if (this.kNQ.size() < this.limit)
      {
        ab.i("MicroMsg.NetSceneTenpayF2fRecordList", "finish query");
        this.fon = true;
      }
      AppMethodBeat.o(40995);
      return;
    }
    paramInt = 0;
    while (paramInt < paramString.length()) {
      try
      {
        paramJSONObject = paramString.getJSONObject(paramInt);
        a locala = new a();
        locala.kMM = paramJSONObject.optString("bill_id");
        locala.kMN = paramJSONObject.optString("trans_id");
        locala.timestamp = paramJSONObject.optLong("timestamp", 0L);
        locala.desc = paramJSONObject.optString("desc");
        locala.cpo = paramJSONObject.optInt("fee", 0);
        this.kNQ.add(locala);
        paramInt += 1;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneTenpayF2fRecordList", paramJSONObject, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.r
 * JD-Core Version:    0.7.0.1
 */