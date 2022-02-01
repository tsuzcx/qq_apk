package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends m
{
  public int dtj;
  public long pgU;
  public int pgV;
  public String pgr;
  public int type;
  
  public q(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(63841);
    this.pgr = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("bill_id", paramString);
    localHashMap.put("type", String.valueOf(paramInt));
    localHashMap.put("from_timestamp", String.valueOf(paramLong));
    setRequestData(localHashMap);
    AppMethodBeat.o(63841);
  }
  
  public final int getFuncId()
  {
    return 1964;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/f2frmrcvdrcd";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(63842);
    this.pgV = paramJSONObject.optInt("total_num", 0);
    this.dtj = paramJSONObject.optInt("total_amt", 0);
    this.type = paramJSONObject.optInt("type", 0);
    this.pgU = paramJSONObject.optLong("from_timestamp", 0L);
    AppMethodBeat.o(63842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.q
 * JD-Core Version:    0.7.0.1
 */