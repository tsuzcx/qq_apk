package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class zza
  extends com.google.android.gms.common.internal.safeparcel.zza
{
  public static final Parcelable.Creator<zza> CREATOR = new zzb();
  public final byte[] body;
  public final String hostname;
  public final String method;
  public final int port;
  public final long timeoutMillis;
  final int versionCode;
  
  zza(int paramInt1, String paramString1, int paramInt2, long paramLong, byte[] paramArrayOfByte, String paramString2)
  {
    this.versionCode = paramInt1;
    this.hostname = paramString1;
    this.port = paramInt2;
    this.timeoutMillis = paramLong;
    this.body = paramArrayOfByte;
    this.method = paramString2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.proxy.zza
 * JD-Core Version:    0.7.0.1
 */