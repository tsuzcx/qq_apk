package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r
  extends j
{
  public boolean dYj = false;
  public List<a> iHN = new ArrayList();
  public long iHh;
  public int iHi;
  public int iHj;
  private int limit;
  public int type;
  
  public r(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.limit = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    localHashMap.put("from_timestamp", String.valueOf(paramLong));
    localHashMap.put("last_bill_id", paramString);
    localHashMap.put("num", String.valueOf(paramInt2));
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1963;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.iHi = paramJSONObject.optInt("total_num");
    this.iHj = paramJSONObject.optInt("total_amt");
    this.iHh = paramJSONObject.optLong("from_timestamp", 0L);
    this.type = paramJSONObject.optInt("type", 0);
    paramString = paramJSONObject.optJSONArray("records");
    if ((paramString == null) || (paramString.length() <= 0))
    {
      y.i("MicroMsg.NetSceneTenpayF2fRecordList", "empty records");
      if (this.iHN.size() < this.limit)
      {
        y.i("MicroMsg.NetSceneTenpayF2fRecordList", "finish query");
        this.dYj = true;
      }
      return;
    }
    paramInt = 0;
    while (paramInt < paramString.length()) {
      try
      {
        paramJSONObject = paramString.getJSONObject(paramInt);
        a locala = new a();
        locala.iGJ = paramJSONObject.optString("bill_id");
        locala.iGK = paramJSONObject.optString("trans_id");
        locala.timestamp = paramJSONObject.optLong("timestamp", 0L);
        locala.desc = paramJSONObject.optString("desc");
        locala.fee = paramJSONObject.optInt("fee", 0);
        this.iHN.add(locala);
        paramInt += 1;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.NetSceneTenpayF2fRecordList", paramJSONObject, "", new Object[0]);
        }
      }
    }
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/f2frcvdlist";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.r
 * JD-Core Version:    0.7.0.1
 */