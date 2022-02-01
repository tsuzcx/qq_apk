package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="AppMetadataCreator")
@SafeParcelable.Reserved({1})
public final class zzdz
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdz> CREATOR;
  @SafeParcelable.Field(id=2)
  public final String packageName;
  @SafeParcelable.Field(id=3)
  public final String zzadm;
  @SafeParcelable.Field(id=12)
  public final String zzado;
  @SafeParcelable.Field(defaultValueUnchecked="Integer.MIN_VALUE", id=11)
  public final long zzads;
  @SafeParcelable.Field(id=5)
  public final String zzadt;
  @SafeParcelable.Field(id=6)
  public final long zzadu;
  @SafeParcelable.Field(id=7)
  public final long zzadv;
  @SafeParcelable.Field(defaultValue="true", id=9)
  public final boolean zzadw;
  @SafeParcelable.Field(id=13)
  public final long zzadx;
  @SafeParcelable.Field(defaultValue="true", id=16)
  public final boolean zzady;
  @SafeParcelable.Field(defaultValue="true", id=17)
  public final boolean zzadz;
  @SafeParcelable.Field(id=8)
  public final String zzaek;
  @SafeParcelable.Field(id=10)
  public final boolean zzael;
  @SafeParcelable.Field(id=14)
  public final long zzaem;
  @SafeParcelable.Field(id=15)
  public final int zzaen;
  @SafeParcelable.Field(id=18)
  public final boolean zzaeo;
  @SafeParcelable.Field(id=4)
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
  
  @SafeParcelable.Constructor
  zzdz(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) String paramString3, @SafeParcelable.Param(id=5) String paramString4, @SafeParcelable.Param(id=6) long paramLong1, @SafeParcelable.Param(id=7) long paramLong2, @SafeParcelable.Param(id=8) String paramString5, @SafeParcelable.Param(id=9) boolean paramBoolean1, @SafeParcelable.Param(id=10) boolean paramBoolean2, @SafeParcelable.Param(id=11) long paramLong3, @SafeParcelable.Param(id=12) String paramString6, @SafeParcelable.Param(id=13) long paramLong4, @SafeParcelable.Param(id=14) long paramLong5, @SafeParcelable.Param(id=15) int paramInt, @SafeParcelable.Param(id=16) boolean paramBoolean3, @SafeParcelable.Param(id=17) boolean paramBoolean4, @SafeParcelable.Param(id=18) boolean paramBoolean5)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzdz
 * JD-Core Version:    0.7.0.1
 */