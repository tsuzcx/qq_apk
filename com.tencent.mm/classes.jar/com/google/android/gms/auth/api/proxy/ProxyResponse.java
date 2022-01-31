package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ProxyResponse
  extends zza
{
  public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzd();
  public static final int STATUS_CODE_NO_CONNECTION = -1;
  public final byte[] body;
  public final int googlePlayServicesStatusCode;
  public final PendingIntent recoveryAction;
  public final int statusCode;
  final int versionCode;
  final Bundle zzajR;
  
  ProxyResponse(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, int paramInt3, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this.versionCode = paramInt1;
    this.googlePlayServicesStatusCode = paramInt2;
    this.statusCode = paramInt3;
    this.zzajR = paramBundle;
    this.body = paramArrayOfByte;
    this.recoveryAction = paramPendingIntent;
  }
  
  public ProxyResponse(int paramInt1, PendingIntent paramPendingIntent, int paramInt2, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this(1, paramInt1, paramPendingIntent, paramInt2, paramBundle, paramArrayOfByte);
  }
  
  private ProxyResponse(int paramInt, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this(1, 0, null, paramInt, paramBundle, paramArrayOfByte);
  }
  
  public ProxyResponse(int paramInt, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    this(paramInt, zzW(paramMap), paramArrayOfByte);
  }
  
  public static ProxyResponse createErrorProxyResponse(int paramInt1, PendingIntent paramPendingIntent, int paramInt2, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    return new ProxyResponse(1, paramInt1, paramPendingIntent, paramInt2, zzW(paramMap), paramArrayOfByte);
  }
  
  private static Bundle zzW(Map<String, String> paramMap)
  {
    Bundle localBundle = new Bundle();
    if (paramMap == null) {
      return localBundle;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localBundle.putString((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return localBundle;
  }
  
  public Map<String, String> getHeaders()
  {
    if (this.zzajR == null) {
      return Collections.emptyMap();
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zzajR.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, this.zzajR.getString(str));
    }
    return localHashMap;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyResponse
 * JD-Core Version:    0.7.0.1
 */