package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends j
{
  public String iGJ;
  public long iHh;
  public int iHi;
  public int iHj;
  public int type;
  
  public p(String paramString, int paramInt, long paramLong)
  {
    this.iGJ = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("bill_id", paramString);
    localHashMap.put("type", String.valueOf(paramInt));
    localHashMap.put("from_timestamp", String.valueOf(paramLong));
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1964;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.iHi = paramJSONObject.optInt("total_num", 0);
    this.iHj = paramJSONObject.optInt("total_amt", 0);
    this.type = paramJSONObject.optInt("type", 0);
    this.iHh = paramJSONObject.optLong("from_timestamp", 0L);
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/f2frmrcvdrcd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.p
 * JD-Core Version:    0.7.0.1
 */