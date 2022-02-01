package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="SignInRequestCreator")
public class SignInRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<SignInRequest> CREATOR;
  @SafeParcelable.Field(getter="getResolveAccountRequest", id=2)
  private final ResolveAccountRequest zzadt;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  
  static
  {
    AppMethodBeat.i(12190);
    CREATOR = new SignInRequestCreator();
    AppMethodBeat.o(12190);
  }
  
  @SafeParcelable.Constructor
  SignInRequest(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) ResolveAccountRequest paramResolveAccountRequest)
  {
    this.zzal = paramInt;
    this.zzadt = paramResolveAccountRequest;
  }
  
  public SignInRequest(ResolveAccountRequest paramResolveAccountRequest)
  {
    this(1, paramResolveAccountRequest);
  }
  
  public ResolveAccountRequest getResolveAccountRequest()
  {
    return this.zzadt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(12189);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getResolveAccountRequest(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(12189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.signin.internal.SignInRequest
 * JD-Core Version:    0.7.0.1
 */