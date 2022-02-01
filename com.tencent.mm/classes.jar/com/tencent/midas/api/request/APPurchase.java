package com.tencent.midas.api.request;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class APPurchase
{
  public String mOriginalJson;
  public String mSignature;
  public String mSku;
  
  public APPurchase()
  {
    this.mSignature = "";
    this.mOriginalJson = "";
    this.mSku = "";
  }
  
  public APPurchase(String paramString)
  {
    AppMethodBeat.i(253297);
    paramString = new JSONObject(paramString);
    this.mSignature = ((String)paramString.get("sign"));
    this.mOriginalJson = ((String)paramString.get("data"));
    this.mSku = "";
    AppMethodBeat.o(253297);
  }
  
  public APPurchase(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253296);
    this.mOriginalJson = paramString1;
    this.mSku = new JSONObject(new String(Base64.decode(paramString1.getBytes(), 0))).optString("product-id");
    this.mSignature = paramString2;
    AppMethodBeat.o(253296);
  }
  
  public String getOriginalJson()
  {
    return this.mOriginalJson;
  }
  
  public String getSignature()
  {
    return this.mSignature;
  }
  
  public String getSku()
  {
    return this.mSku;
  }
  
  public String toString()
  {
    AppMethodBeat.i(253302);
    String str = "PurchaseInfo():" + this.mOriginalJson;
    AppMethodBeat.o(253302);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.midas.api.request.APPurchase
 * JD-Core Version:    0.7.0.1
 */