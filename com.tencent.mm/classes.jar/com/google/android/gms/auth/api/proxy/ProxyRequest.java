package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProxyRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ProxyRequest> CREATOR;
  public static final int HTTP_METHOD_DELETE;
  public static final int HTTP_METHOD_GET;
  public static final int HTTP_METHOD_HEAD;
  public static final int HTTP_METHOD_OPTIONS;
  public static final int HTTP_METHOD_PATCH;
  public static final int HTTP_METHOD_POST;
  public static final int HTTP_METHOD_PUT;
  public static final int HTTP_METHOD_TRACE;
  public static final int LAST_CODE;
  public static final int VERSION_CODE = 2;
  public final byte[] body;
  public final int httpMethod;
  public final long timeoutMillis;
  public final String url;
  private final int versionCode;
  private Bundle zzdw;
  
  static
  {
    AppMethodBeat.i(10702);
    CREATOR = new zzd();
    HTTP_METHOD_GET = 0;
    HTTP_METHOD_POST = 1;
    HTTP_METHOD_PUT = 2;
    HTTP_METHOD_DELETE = 3;
    HTTP_METHOD_HEAD = 4;
    HTTP_METHOD_OPTIONS = 5;
    HTTP_METHOD_TRACE = 6;
    HTTP_METHOD_PATCH = 7;
    LAST_CODE = 7;
    AppMethodBeat.o(10702);
  }
  
  ProxyRequest(int paramInt1, String paramString, int paramInt2, long paramLong, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.versionCode = paramInt1;
    this.url = paramString;
    this.httpMethod = paramInt2;
    this.timeoutMillis = paramLong;
    this.body = paramArrayOfByte;
    this.zzdw = paramBundle;
  }
  
  public Map<String, String> getHeaderMap()
  {
    AppMethodBeat.i(10699);
    Object localObject = new LinkedHashMap(this.zzdw.size());
    Iterator localIterator = this.zzdw.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((Map)localObject).put(str, this.zzdw.getString(str));
    }
    localObject = Collections.unmodifiableMap((Map)localObject);
    AppMethodBeat.o(10699);
    return localObject;
  }
  
  public String toString()
  {
    AppMethodBeat.i(10700);
    String str = this.url;
    int i = this.httpMethod;
    str = String.valueOf(str).length() + 42 + "ProxyRequest[ url: " + str + ", method: " + i + " ]";
    AppMethodBeat.o(10700);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10701);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.url, false);
    SafeParcelWriter.writeInt(paramParcel, 2, this.httpMethod);
    SafeParcelWriter.writeLong(paramParcel, 3, this.timeoutMillis);
    SafeParcelWriter.writeByteArray(paramParcel, 4, this.body, false);
    SafeParcelWriter.writeBundle(paramParcel, 5, this.zzdw, false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.versionCode);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(10701);
  }
  
  public static class Builder
  {
    private String zzdx;
    private int zzdy;
    private long zzdz;
    private byte[] zzea;
    private Bundle zzeb;
    
    public Builder(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyRequest
 * JD-Core Version:    0.7.0.1
 */