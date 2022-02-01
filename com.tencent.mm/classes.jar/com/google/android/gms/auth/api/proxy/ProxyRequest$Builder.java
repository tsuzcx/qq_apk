package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.util.Patterns;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@KeepForSdkWithMembers
public class ProxyRequest$Builder
{
  private String zzdx;
  private int zzdy;
  private long zzdz;
  private byte[] zzea;
  private Bundle zzeb;
  
  public ProxyRequest$Builder(String paramString)
  {
    AppMethodBeat.i(10694);
    this.zzdy = ProxyRequest.HTTP_METHOD_GET;
    this.zzdz = 3000L;
    this.zzea = null;
    this.zzeb = new Bundle();
    Preconditions.checkNotEmpty(paramString);
    if (Patterns.WEB_URL.matcher(paramString).matches())
    {
      this.zzdx = paramString;
      AppMethodBeat.o(10694);
      return;
    }
    paramString = new IllegalArgumentException(String.valueOf(paramString).length() + 51 + "The supplied url [ " + paramString + "] is not match Patterns.WEB_URL!");
    AppMethodBeat.o(10694);
    throw paramString;
  }
  
  public ProxyRequest build()
  {
    AppMethodBeat.i(10698);
    if (this.zzea == null) {
      this.zzea = new byte[0];
    }
    ProxyRequest localProxyRequest = new ProxyRequest(2, this.zzdx, this.zzdy, this.zzdz, this.zzea, this.zzeb);
    AppMethodBeat.o(10698);
    return localProxyRequest;
  }
  
  public Builder putHeader(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10697);
    Preconditions.checkNotEmpty(paramString1, "Header name cannot be null or empty!");
    Bundle localBundle = this.zzeb;
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    localBundle.putString(paramString1, str);
    AppMethodBeat.o(10697);
    return this;
  }
  
  public Builder setBody(byte[] paramArrayOfByte)
  {
    this.zzea = paramArrayOfByte;
    return this;
  }
  
  public Builder setHttpMethod(int paramInt)
  {
    AppMethodBeat.i(10695);
    if ((paramInt >= 0) && (paramInt <= ProxyRequest.LAST_CODE)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Unrecognized http method code.");
      this.zzdy = paramInt;
      AppMethodBeat.o(10695);
      return this;
    }
  }
  
  public Builder setTimeoutMillis(long paramLong)
  {
    AppMethodBeat.i(10696);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "The specified timeout must be non-negative.");
      this.zzdz = paramLong;
      AppMethodBeat.o(10696);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyRequest.Builder
 * JD-Core Version:    0.7.0.1
 */