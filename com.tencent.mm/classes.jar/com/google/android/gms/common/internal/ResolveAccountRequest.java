package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="ResolveAccountRequestCreator")
public class ResolveAccountRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountRequest> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  @SafeParcelable.Field(getter="getAccount", id=2)
  private final Account zzs;
  @SafeParcelable.Field(getter="getSessionId", id=3)
  private final int zzut;
  @SafeParcelable.Field(getter="getSignInAccountHint", id=4)
  private final GoogleSignInAccount zzuu;
  
  static
  {
    AppMethodBeat.i(11852);
    CREATOR = new ResolveAccountRequestCreator();
    AppMethodBeat.o(11852);
  }
  
  @SafeParcelable.Constructor
  ResolveAccountRequest(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) Account paramAccount, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) GoogleSignInAccount paramGoogleSignInAccount)
  {
    this.zzal = paramInt1;
    this.zzs = paramAccount;
    this.zzut = paramInt2;
    this.zzuu = paramGoogleSignInAccount;
  }
  
  public ResolveAccountRequest(Account paramAccount, int paramInt, GoogleSignInAccount paramGoogleSignInAccount)
  {
    this(2, paramAccount, paramInt, paramGoogleSignInAccount);
  }
  
  public Account getAccount()
  {
    return this.zzs;
  }
  
  public int getSessionId()
  {
    return this.zzut;
  }
  
  public GoogleSignInAccount getSignInAccountHint()
  {
    return this.zzuu;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(11851);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getAccount(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getSessionId());
    SafeParcelWriter.writeParcelable(paramParcel, 4, getSignInAccountHint(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(11851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountRequest
 * JD-Core Version:    0.7.0.1
 */