package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class FavaDiagnosticsEntity
  extends com.google.android.gms.common.internal.safeparcel.zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new zza();
  public final String zzaGP;
  public final int zzaGQ;
  final int zzaiI;
  
  public FavaDiagnosticsEntity(int paramInt1, String paramString, int paramInt2)
  {
    this.zzaiI = paramInt1;
    this.zzaGP = paramString;
    this.zzaGQ = paramInt2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.server.FavaDiagnosticsEntity
 * JD-Core Version:    0.7.0.1
 */