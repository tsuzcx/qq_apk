package com.google.android.gms.auth.api.proxy;

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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@KeepForSdkWithMembers
@SafeParcelable.Class(creator="ProxyRequestCreator")
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
  @SafeParcelable.Field(id=4)
  public final byte[] body;
  @SafeParcelable.Field(id=2)
  public final int httpMethod;
  @SafeParcelable.Field(id=3)
  public final long timeoutMillis;
  @SafeParcelable.Field(id=1)
  public final String url;
  @SafeParcelable.VersionField(id=1000)
  private final int versionCode;
  @SafeParcelable.Field(id=5)
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
  
  @SafeParcelable.Constructor
  ProxyRequest(@SafeParcelable.Param(id=1000) int paramInt1, @SafeParcelable.Param(id=1) String paramString, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) long paramLong, @SafeParcelable.Param(id=4) byte[] paramArrayOfByte, @SafeParcelable.Param(id=5) Bundle paramBundle)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyRequest
 * JD-Core Version:    0.7.0.1
 */