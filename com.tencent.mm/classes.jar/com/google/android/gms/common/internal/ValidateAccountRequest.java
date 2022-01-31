package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
@SafeParcelable.Class(creator="ValidateAccountRequestCreator")
public class ValidateAccountRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ValidateAccountRequest> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  
  static
  {
    AppMethodBeat.i(89724);
    CREATOR = new ValidateAccountRequestCreator();
    AppMethodBeat.o(89724);
  }
  
  @SafeParcelable.Constructor
  ValidateAccountRequest(@SafeParcelable.Param(id=1) int paramInt)
  {
    this.zzal = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89723);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(89723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ValidateAccountRequest
 * JD-Core Version:    0.7.0.1
 */