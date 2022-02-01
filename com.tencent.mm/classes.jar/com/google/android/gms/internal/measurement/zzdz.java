package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzdz
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdz> CREATOR;
  public final String packageName;
  public final String zzadm;
  public final String zzado;
  public final long zzads;
  public final String zzadt;
  public final long zzadu;
  public final long zzadv;
  public final boolean zzadw;
  public final long zzadx;
  public final boolean zzady;
  public final boolean zzadz;
  public final String zzaek;
  public final boolean zzael;
  public final long zzaem;
  public final int zzaen;
  public final boolean zzaeo;
  public final String zzth;
  
  static
  {
    AppMethodBeat.i(1105);
    CREATOR = new zzea();
    AppMethodBeat.o(1105);
  }
  
  zzdz(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, long paramLong3, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, long paramLong4, long paramLong5, int paramInt, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(1103);
    Preconditions.checkNotEmpty(paramString1);
    this.packageName = paramString1;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = null;
    }
    this.zzadm = paramString1;
    this.zzth = paramString3;
    this.zzads = paramLong1;
    this.zzadt = paramString4;
    this.zzadu = paramLong2;
    this.zzadv = paramLong3;
    this.zzaek = paramString5;
    this.zzadw = paramBoolean1;
    this.zzael = paramBoolean2;
    this.zzado = paramString6;
    this.zzadx = paramLong4;
    this.zzaem = paramLong5;
    this.zzaen = paramInt;
    this.zzady = paramBoolean3;
    this.zzadz = paramBoolean4;
    this.zzaeo = paramBoolean5;
    AppMethodBeat.o(1103);
  }
  
  zzdz(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, boolean paramBoolean1, boolean paramBoolean2, long paramLong3, String paramString6, long paramLong4, long paramLong5, int paramInt, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.packageName = paramString1;
    this.zzadm = paramString2;
    this.zzth = paramString3;
    this.zzads = paramLong3;
    this.zzadt = paramString4;
    this.zzadu = paramLong1;
    this.zzadv = paramLong2;
    this.zzaek = paramString5;
    this.zzadw = paramBoolean1;
    this.zzael = paramBoolean2;
    this.zzado = paramString6;
    this.zzadx = paramLong4;
    this.zzaem = paramLong5;
    this.zzaen = paramInt;
    this.zzady = paramBoolean3;
    this.zzadz = paramBoolean4;
    this.zzaeo = paramBoolean5;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(1104);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzadm, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzth, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzadt, false);
    SafeParcelWriter.writeLong(paramParcel, 6, this.zzadu);
    SafeParcelWriter.writeLong(paramParcel, 7, this.zzadv);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzaek, false);
    SafeParcelWriter.writeBoolean(paramParcel, 9, this.zzadw);
    SafeParcelWriter.writeBoolean(paramParcel, 10, this.zzael);
    SafeParcelWriter.writeLong(paramParcel, 11, this.zzads);
    SafeParcelWriter.writeString(paramParcel, 12, this.zzado, false);
    SafeParcelWriter.writeLong(paramParcel, 13, this.zzadx);
    SafeParcelWriter.writeLong(paramParcel, 14, this.zzaem);
    SafeParcelWriter.writeInt(paramParcel, 15, this.zzaen);
    SafeParcelWriter.writeBoolean(paramParcel, 16, this.zzady);
    SafeParcelWriter.writeBoolean(paramParcel, 17, this.zzadz);
    SafeParcelWriter.writeBoolean(paramParcel, 18, this.zzaeo);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(1104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzdz
 * JD-Core Version:    0.7.0.1
 */