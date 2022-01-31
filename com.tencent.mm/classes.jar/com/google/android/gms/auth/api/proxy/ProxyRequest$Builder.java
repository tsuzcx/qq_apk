package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.util.Patterns;
import com.google.android.gms.common.internal.zzac;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProxyRequest$Builder
{
  private long zzVv = 3000L;
  private String zzajS;
  private int zzajT = ProxyRequest.HTTP_METHOD_GET;
  private byte[] zzajU = null;
  private Bundle zzajV = new Bundle();
  
  public ProxyRequest$Builder(String paramString)
  {
    zzac.zzdr(paramString);
    if (Patterns.WEB_URL.matcher(paramString).matches())
    {
      this.zzajS = paramString;
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramString).length() + 51 + "The supplied url [ " + paramString + "] is not match Patterns.WEB_URL!");
  }
  
  public ProxyRequest build()
  {
    if (this.zzajU == null) {
      this.zzajU = new byte[0];
    }
    return new ProxyRequest(2, this.zzajS, this.zzajT, this.zzVv, this.zzajU, this.zzajV);
  }
  
  public Builder putHeader(String paramString1, String paramString2)
  {
    zzac.zzh(paramString1, "Header name cannot be null or empty!");
    Bundle localBundle = this.zzajV;
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    localBundle.putString(paramString1, str);
    return this;
  }
  
  public Builder setBody(byte[] paramArrayOfByte)
  {
    this.zzajU = paramArrayOfByte;
    return this;
  }
  
  public Builder setHttpMethod(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= ProxyRequest.LAST_CODE)) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "Unrecognized http method code.");
      this.zzajT = paramInt;
      return this;
    }
  }
  
  public Builder setTimeoutMillis(long paramLong)
  {
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "The specified timeout must be non-negative.");
      this.zzVv = paramLong;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyRequest.Builder
 * JD-Core Version:    0.7.0.1
 */