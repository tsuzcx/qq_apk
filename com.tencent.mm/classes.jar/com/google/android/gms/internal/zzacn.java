package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzacn
  extends zza
{
  public static final Parcelable.Creator<zzacn> CREATOR = new zzaco();
  private final zzacp zzaGR;
  final int zzaiI;
  
  zzacn(int paramInt, zzacp paramzzacp)
  {
    this.zzaiI = paramInt;
    this.zzaGR = paramzzacp;
  }
  
  private zzacn(zzacp paramzzacp)
  {
    this.zzaiI = 1;
    this.zzaGR = paramzzacp;
  }
  
  public static zzacn zza(zzacs.zzb<?, ?> paramzzb)
  {
    if ((paramzzb instanceof zzacp)) {
      return new zzacn((zzacp)paramzzb);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaco.zza(this, paramParcel, paramInt);
  }
  
  zzacp zzyo()
  {
    return this.zzaGR;
  }
  
  public zzacs.zzb<?, ?> zzyp()
  {
    if (this.zzaGR != null) {
      return this.zzaGR;
    }
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzacn
 * JD-Core Version:    0.7.0.1
 */