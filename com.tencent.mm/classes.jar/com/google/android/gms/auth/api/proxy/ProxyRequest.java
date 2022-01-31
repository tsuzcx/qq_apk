package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ProxyRequest
  extends zza
{
  public static final Parcelable.Creator<ProxyRequest> CREATOR = new zzc();
  public static final int HTTP_METHOD_DELETE;
  public static final int HTTP_METHOD_GET = 0;
  public static final int HTTP_METHOD_HEAD;
  public static final int HTTP_METHOD_OPTIONS;
  public static final int HTTP_METHOD_PATCH = 7;
  public static final int HTTP_METHOD_POST = 1;
  public static final int HTTP_METHOD_PUT = 2;
  public static final int HTTP_METHOD_TRACE;
  public static final int LAST_CODE = 7;
  public static final int VERSION_CODE = 2;
  public final byte[] body;
  public final int httpMethod;
  public final long timeoutMillis;
  public final String url;
  final int versionCode;
  Bundle zzajR;
  
  static
  {
    HTTP_METHOD_DELETE = 3;
    HTTP_METHOD_HEAD = 4;
    HTTP_METHOD_OPTIONS = 5;
    HTTP_METHOD_TRACE = 6;
  }
  
  ProxyRequest(int paramInt1, String paramString, int paramInt2, long paramLong, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.versionCode = paramInt1;
    this.url = paramString;
    this.httpMethod = paramInt2;
    this.timeoutMillis = paramLong;
    this.body = paramArrayOfByte;
    this.zzajR = paramBundle;
  }
  
  public Map<String, String> getHeaderMap()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.zzajR.size());
    Iterator localIterator = this.zzajR.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedHashMap.put(str, this.zzajR.getString(str));
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  public String toString()
  {
    String str = this.url;
    int i = this.httpMethod;
    return String.valueOf(str).length() + 42 + "ProxyRequest[ url: " + str + ", method: " + i + " ]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyRequest
 * JD-Core Version:    0.7.0.1
 */