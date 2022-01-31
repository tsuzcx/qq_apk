package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="SendDataRequestCreator")
public final class zzai
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzai> CREATOR;
  @SafeParcelable.Field(id=2)
  private final String accountType;
  @SafeParcelable.Field(id=3)
  private final byte[] zzbz;
  @SafeParcelable.VersionField(id=1)
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(77095);
    CREATOR = new zzaj();
    AppMethodBeat.o(77095);
  }
  
  @SafeParcelable.Constructor
  zzai(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77093);
    this.zzy = 1;
    this.accountType = ((String)Preconditions.checkNotNull(paramString));
    this.zzbz = ((byte[])Preconditions.checkNotNull(paramArrayOfByte));
    AppMethodBeat.o(77093);
  }
  
  public zzai(String paramString, byte[] paramArrayOfByte)
  {
    this(1, paramString, paramArrayOfByte);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(77094);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzy);
    SafeParcelWriter.writeString(paramParcel, 2, this.accountType, false);
    SafeParcelWriter.writeByteArray(paramParcel, 3, this.zzbz, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(77094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzai
 * JD-Core Version:    0.7.0.1
 */