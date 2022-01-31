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

public final class q
  extends j
{
  public boolean dYj = false;
  public String gfH;
  public boolean iHI = false;
  public int iHJ;
  public int iHK;
  public int iHL;
  public int iHM;
  public List<h> iHN = new ArrayList();
  public long iHh;
  private int limit;
  
  public q(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    this.limit = paramInt2;
    this.iHK = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    localHashMap.put("from_timestamp", String.valueOf(paramLong));
    localHashMap.put("direction_flag", "0");
    localHashMap.put("num", String.valueOf(paramInt2));
    localHashMap.put("choose_flag", String.valueOf(paramInt3));
    D(localHashMap);
  }
  
  public q(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.iHI = true;
    this.limit = paramInt3;
    this.iHK = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    localHashMap.put("from_timestamp", String.valueOf(paramLong));
    localHashMap.put("direction_flag", String.valueOf(paramInt2));
    localHashMap.put("num", String.valueOf(paramInt3));
    localHashMap.put("choose_flag", String.valueOf(paramInt4));
    localHashMap.put("try_num", String.valueOf(paramInt5));
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1993;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "json: %s", new Object[] { paramJSONObject.toString() });
    this.iHJ = paramJSONObject.optInt("choose_flag", 0);
    this.iHh = paramJSONObject.optLong("from_timestamp", -1L);
    this.iHL = paramJSONObject.optInt("finish_flag", 0);
    this.iHM = paramJSONObject.optInt("try_num", 0);
    this.gfH = paramJSONObject.optString("retmsg", "");
    paramString = paramJSONObject.optJSONArray("records");
    if ((paramString == null) || (paramString.length() <= 0))
    {
      y.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "empty records");
      if (this.iHL == 1)
      {
        y.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "finish query");
        this.dYj = true;
      }
      return;
    }
    paramInt = 0;
    while (paramInt < paramString.length()) {
      try
      {
        paramJSONObject = paramString.getJSONObject(paramInt);
        h localh = new h();
        localh.type = paramJSONObject.optInt("type", 0);
        localh.iHh = paramJSONObject.optLong("from_timestamp", 0L);
        localh.iHi = paramJSONObject.optInt("total_num", 0);
        localh.iHj = paramJSONObject.optInt("total_amt", 0);
        this.iHN.add(localh);
        paramInt += 1;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.NetSceneTenpayF2fHistoryRecordList", paramJSONObject, "", new Object[0]);
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
    return "/cgi-bin/mmpay-bin/f2frcvrcdhissta";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.q
 * JD-Core Version:    0.7.0.1
 */