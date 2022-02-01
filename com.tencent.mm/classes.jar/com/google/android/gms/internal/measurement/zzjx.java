package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="UserAttributeParcelCreator")
public final class zzjx
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzjx> CREATOR;
  @SafeParcelable.Field(id=2)
  public final String name;
  @SafeParcelable.Field(id=7)
  public final String origin;
  @SafeParcelable.Field(id=1)
  private final int versionCode;
  @SafeParcelable.Field(id=6)
  private final String zzajf;
  @SafeParcelable.Field(id=3)
  public final long zzaqz;
  @SafeParcelable.Field(id=4)
  private final Long zzara;
  @SafeParcelable.Field(id=5)
  private final Float zzarb;
  @SafeParcelable.Field(id=8)
  private final Double zzarc;
  
  static
  {
    AppMethodBeat.i(2018);
    CREATOR = new zzjy();
    AppMethodBeat.o(2018);
  }
  
  @SafeParcelable.Constructor
  zzjx(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) long paramLong, @SafeParcelable.Param(id=4) Long paramLong1, @SafeParcelable.Param(id=5) Float paramFloat, @SafeParcelable.Param(id=6) String paramString2, @SafeParcelable.Param(id=7) String paramString3, @SafeParcelable.Param(id=8) Double paramDouble)
  {
    AppMethodBeat.i(2016);
    this.versionCode = paramInt;
    this.name = paramString1;
    this.zzaqz = paramLong;
    this.zzara = paramLong1;
    this.zzarb = null;
    if (paramInt == 1)
    {
      paramString1 = localObject;
      if (paramFloat != null) {
        paramString1 = Double.valueOf(paramFloat.doubleValue());
      }
    }
    for (this.zzarc = paramString1;; this.zzarc = paramDouble)
    {
      this.zzajf = paramString2;
      this.origin = paramString3;
      AppMethodBeat.o(2016);
      return;
    }
  }
  
  zzjx(zzjz paramzzjz)
  {
    this(paramzzjz.name, paramzzjz.zzaqz, paramzzjz.value, paramzzjz.origin);
  }
  
  zzjx(String paramString1, long paramLong, Object paramObject, String paramString2)
  {
    AppMethodBeat.i(2015);
    Preconditions.checkNotEmpty(paramString1);
    this.versionCode = 2;
    this.name = paramString1;
    this.zzaqz = paramLong;
    this.origin = paramString2;
    if (paramObject == null)
    {
      this.zzara = null;
      this.zzarb = null;
      this.zzarc = null;
      this.zzajf = null;
      AppMethodBeat.o(2015);
      return;
    }
    if ((paramObject instanceof Long))
    {
      this.zzara = ((Long)paramObject);
      this.zzarb = null;
      this.zzarc = null;
      this.zzajf = null;
      AppMethodBeat.o(2015);
      return;
    }
    if ((paramObject instanceof String))
    {
      this.zzara = null;
      this.zzarb = null;
      this.zzarc = null;
      this.zzajf = ((String)paramObject);
      AppMethodBeat.o(2015);
      return;
    }
    if ((paramObject instanceof Double))
    {
      this.zzara = null;
      this.zzarb = null;
      this.zzarc = ((Double)paramObject);
      this.zzajf = null;
      AppMethodBeat.o(2015);
      return;
    }
    paramString1 = new IllegalArgumentException("User attribute given of un-supported type");
    AppMethodBeat.o(2015);
    throw paramString1;
  }
  
  public final Object getValue()
  {
    if (this.zzara != null) {
      return this.zzara;
    }
    if (this.zzarc != null) {
      return this.zzarc;
    }
    if (this.zzajf != null) {
      return this.zzajf;
    }
    return null;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(2017);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.name, false);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzaqz);
    SafeParcelWriter.writeLongObject(paramParcel, 4, this.zzara, false);
    SafeParcelWriter.writeFloatObject(paramParcel, 5, null, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzajf, false);
    SafeParcelWriter.writeString(paramParcel, 7, this.origin, false);
    SafeParcelWriter.writeDoubleObject(paramParcel, 8, this.zzarc, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(2017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzjx
 * JD-Core Version:    0.7.0.1
 */