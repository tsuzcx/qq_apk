package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepForSdkWithMembers
@SafeParcelable.Class(creator="ProxyResponseCreator")
public class ProxyResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ProxyResponse> CREATOR;
  public static final int STATUS_CODE_NO_CONNECTION = -1;
  @SafeParcelable.Field(id=5)
  public final byte[] body;
  @SafeParcelable.Field(id=1)
  public final int googlePlayServicesStatusCode;
  @SafeParcelable.Field(id=2)
  public final PendingIntent recoveryAction;
  @SafeParcelable.Field(id=3)
  public final int statusCode;
  @SafeParcelable.VersionField(id=1000)
  private final int versionCode;
  @SafeParcelable.Field(id=4)
  private final Bundle zzdw;
  
  static
  {
    AppMethodBeat.i(77049);
    CREATOR = new zze();
    AppMethodBeat.o(77049);
  }
  
  @SafeParcelable.Constructor
  ProxyResponse(@SafeParcelable.Param(id=1000) int paramInt1, @SafeParcelable.Param(id=1) int paramInt2, @SafeParcelable.Param(id=2) PendingIntent paramPendingIntent, @SafeParcelable.Param(id=3) int paramInt3, @SafeParcelable.Param(id=4) Bundle paramBundle, @SafeParcelable.Param(id=5) byte[] paramArrayOfByte)
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
    AppMethodBeat.i(77046);
    AppMethodBeat.o(77046);
  }
  
  public static ProxyResponse createErrorProxyResponse(int paramInt1, PendingIntent paramPendingIntent, int paramInt2, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77044);
    paramPendingIntent = new ProxyResponse(1, paramInt1, paramPendingIntent, paramInt2, zzd(paramMap), paramArrayOfByte);
    AppMethodBeat.o(77044);
    return paramPendingIntent;
  }
  
  private static Bundle zzd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(77045);
    Bundle localBundle = new Bundle();
    if (paramMap == null)
    {
      AppMethodBeat.o(77045);
      return localBundle;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localBundle.putString((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    AppMethodBeat.o(77045);
    return localBundle;
  }
  
  public Map<String, String> getHeaders()
  {
    AppMethodBeat.i(77047);
    if (this.zzdw == null)
    {
      localObject = Collections.emptyMap();
      AppMethodBeat.o(77047);
      return localObject;
    }
    Object localObject = new HashMap();
    Iterator localIterator = this.zzdw.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((Map)localObject).put(str, this.zzdw.getString(str));
    }
    AppMethodBeat.o(77047);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(77048);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.googlePlayServicesStatusCode);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.recoveryAction, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.statusCode);
    SafeParcelWriter.writeBundle(paramParcel, 4, this.zzdw, false);
    SafeParcelWriter.writeByteArray(paramParcel, 5, this.body, false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.versionCode);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(77048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyResponse
 * JD-Core Version:    0.7.0.1
 */