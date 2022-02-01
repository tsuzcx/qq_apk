package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.TenpayCgiCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.tenpay.model.p;
import java.util.HashMap;
import org.json.JSONObject;

public class NetSceneTenpay
  extends p
{
  private static final String TAG = "WXP";
  TenpayCgiCallback mCallback;
  int mCgiId;
  
  public NetSceneTenpay(int paramInt, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, TenpayCgiCallback paramTenpayCgiCallback)
  {
    AppMethodBeat.i(18669);
    this.mCgiId = paramInt;
    this.mCallback = paramTenpayCgiCallback;
    setWXRequestData(paramHashMap2);
    setRequestData(paramHashMap1);
    AppMethodBeat.o(18669);
  }
  
  public int getFuncId()
  {
    return this.mCgiId;
  }
  
  public int getTenpayCgicmd()
  {
    return this.mCgiId;
  }
  
  public String getUri()
  {
    AppMethodBeat.i(18670);
    switch (getFuncId())
    {
    default: 
      String str = super.getUri();
      AppMethodBeat.o(18670);
      return str;
    case 1992: 
      AppMethodBeat.o(18670);
      return "/cgi-bin/mmpay-bin/gettransferwording";
    case 1679: 
      AppMethodBeat.o(18670);
      return "/cgi-bin/mmpay-bin/tenpay/getbannerinfo";
    }
    AppMethodBeat.o(18670);
    return "/cgi-bin/mmpay-bin/transferplaceorder";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(18671);
    super.onGYNetEnd(paramInt, paramString, paramJSONObject);
    ae.i("WXP", "errCode:%d,errMsg:%s,json:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    String.format("errCode:%d,errMsg:%s,json:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    if (paramInt == 0)
    {
      this.mCallback.onSuccess(paramJSONObject.toString());
      AppMethodBeat.o(18671);
      return;
    }
    this.mCallback.onError(paramInt, paramString);
    AppMethodBeat.o(18671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.NetSceneTenpay
 * JD-Core Version:    0.7.0.1
 */