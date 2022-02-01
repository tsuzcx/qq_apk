package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="AuthAccountResultCreator")
public class AuthAccountResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<AuthAccountResult> CREATOR;
  @SafeParcelable.Field(getter="getConnectionResultCode", id=2)
  private int zzadn;
  @SafeParcelable.Field(getter="getRawAuthResolutionIntent", id=3)
  private Intent zzado;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  
  static
  {
    AppMethodBeat.i(12145);
    CREATOR = new AuthAccountResultCreator();
    AppMethodBeat.o(12145);
  }
  
  public AuthAccountResult()
  {
    this(0, null);
  }
  
  @SafeParcelable.Constructor
  AuthAccountResult(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) Intent paramIntent)
  {
    this.zzal = paramInt1;
    this.zzadn = paramInt2;
    this.zzado = paramIntent;
  }
  
  public AuthAccountResult(int paramInt, Intent paramIntent)
  {
    this(2, paramInt, paramIntent);
  }
  
  public int getConnectionResultCode()
  {
    return this.zzadn;
  }
  
  public Intent getRawAuthResolutionIntent()
  {
    return this.zzado;
  }
  
  public Status getStatus()
  {
    if (this.zzadn == 0) {
      return Status.RESULT_SUCCESS;
    }
    return Status.RESULT_CANCELED;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(12144);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeInt(paramParcel, 2, getConnectionResultCode());
    SafeParcelWriter.writeParcelable(paramParcel, 3, getRawAuthResolutionIntent(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(12144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.signin.internal.AuthAccountResult
 * JD-Core Version:    0.7.0.1
 */