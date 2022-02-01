package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ProxyResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ProxyResponse> CREATOR;
  public static final int STATUS_CODE_NO_CONNECTION = -1;
  public final byte[] body;
  public final int googlePlayServicesStatusCode;
  public final PendingIntent recoveryAction;
  public final int statusCode;
  private final int versionCode;
  private final Bundle zzdw;
  
  static
  {
    AppMethodBeat.i(10708);
    CREATOR = new zze();
    AppMethodBeat.o(10708);
  }
  
  ProxyResponse(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, int paramInt3, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this.versionCode = paramInt1;
    this.googlePlayServicesStatusCode = paramInt2;
    this.statusCode = paramInt3;
    this.zzdw = paramBundle;
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
    this(paramInt, zzd(paramMap), paramArrayOfByte);
    AppMethodBeat.i(10705);
    AppMethodBeat.o(10705);
  }
  
  public static ProxyResponse createErrorProxyResponse(int paramInt1, PendingIntent paramPendingIntent, int paramInt2, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(10703);
    paramPendingIntent = new ProxyResponse(1, paramInt1, paramPendingIntent, paramInt2, zzd(paramMap), paramArrayOfByte);
    AppMethodBeat.o(10703);
    return paramPendingIntent;
  }
  
  private static Bundle zzd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(10704);
    Bundle localBundle = new Bundle();
    if (paramMap == null)
    {
      AppMethodBeat.o(10704);
      return localBundle;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localBundle.putString((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    AppMethodBeat.o(10704);
    return localBundle;
  }
  
  public Map<String, String> getHeaders()
  {
    AppMethodBeat.i(10706);
    if (this.zzdw == null)
    {
      localObject = Collections.emptyMap();
      AppMethodBeat.o(10706);
      return localObject;
    }
    Object localObject = new HashMap();
    Iterator localIterator = this.zzdw.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((Map)localObject).put(str, this.zzdw.getString(str));
    }
    AppMethodBeat.o(10706);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10707);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.googlePlayServicesStatusCode);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.recoveryAction, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.statusCode);
    SafeParcelWriter.writeBundle(paramParcel, 4, this.zzdw, false);
    SafeParcelWriter.writeByteArray(paramParcel, 5, this.body, false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.versionCode);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(10707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyResponse
 * JD-Core Version:    0.7.0.1
 */