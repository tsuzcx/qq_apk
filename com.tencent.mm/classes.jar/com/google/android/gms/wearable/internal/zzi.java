package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="AmsEntityUpdateParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzi
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzi> CREATOR;
  @SafeParcelable.Field(getter="getValue", id=4)
  private final String value;
  @SafeParcelable.Field(getter="getEntityId", id=2)
  private byte zzbd;
  @SafeParcelable.Field(getter="getAttributeId", id=3)
  private final byte zzbe;
  
  static
  {
    AppMethodBeat.i(101430);
    CREATOR = new zzj();
    AppMethodBeat.o(101430);
  }
  
  @SafeParcelable.Constructor
  public zzi(@SafeParcelable.Param(id=2) byte paramByte1, @SafeParcelable.Param(id=3) byte paramByte2, @SafeParcelable.Param(id=4) String paramString)
  {
    this.zzbd = paramByte1;
    this.zzbe = paramByte2;
    this.value = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(101428);
    if (this == paramObject)
    {
      AppMethodBeat.o(101428);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(101428);
      return false;
    }
    paramObject = (zzi)paramObject;
    if (this.zzbd != paramObject.zzbd)
    {
      AppMethodBeat.o(101428);
      return false;
    }
    if (this.zzbe != paramObject.zzbe)
    {
      AppMethodBeat.o(101428);
      return false;
    }
    if (!this.value.equals(paramObject.value))
    {
      AppMethodBeat.o(101428);
      return false;
    }
    AppMethodBeat.o(101428);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(101429);
    int i = this.zzbd;
    int j = this.zzbe;
    int k = this.value.hashCode();
    AppMethodBeat.o(101429);
    return ((i + 31) * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101427);
    int i = this.zzbd;
    int j = this.zzbe;
    String str = this.value;
    str = String.valueOf(str).length() + 73 + "AmsEntityUpdateParcelable{, mEntityId=" + i + ", mAttributeId=" + j + ", mValue='" + str + '\'' + '}';
    AppMethodBeat.o(101427);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101426);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeByte(paramParcel, 2, this.zzbd);
    SafeParcelWriter.writeByte(paramParcel, 3, this.zzbe);
    SafeParcelWriter.writeString(paramParcel, 4, this.value, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(101426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzi
 * JD-Core Version:    0.7.0.1
 */