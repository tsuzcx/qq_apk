package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AuthAccountRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AuthAccountRequest> CREATOR;
  private final int zzal;
  @Deprecated
  private final IBinder zzqv;
  private final Scope[] zzqw;
  private Integer zzqx;
  private Integer zzqy;
  private Account zzs;
  
  static
  {
    AppMethodBeat.i(11797);
    CREATOR = new AuthAccountRequestCreator();
    AppMethodBeat.o(11797);
  }
  
  AuthAccountRequest(int paramInt, IBinder paramIBinder, Scope[] paramArrayOfScope, Integer paramInteger1, Integer paramInteger2, Account paramAccount)
  {
    this.zzal = paramInt;
    this.zzqv = paramIBinder;
    this.zzqw = paramArrayOfScope;
    this.zzqx = paramInteger1;
    this.zzqy = paramInteger2;
    this.zzs = paramAccount;
  }
  
  public AuthAccountRequest(Account paramAccount, Set<Scope> paramSet)
  {
    this(3, null, (Scope[])paramSet.toArray(new Scope[paramSet.size()]), null, null, (Account)Preconditions.checkNotNull(paramAccount));
    AppMethodBeat.i(11793);
    AppMethodBeat.o(11793);
  }
  
  @Deprecated
  public AuthAccountRequest(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet)
  {
    this(3, paramIAccountAccessor.asBinder(), (Scope[])paramSet.toArray(new Scope[paramSet.size()]), null, null, null);
    AppMethodBeat.i(11792);
    AppMethodBeat.o(11792);
  }
  
  public Account getAccount()
  {
    AppMethodBeat.i(11794);
    Account localAccount = null;
    if (this.zzs != null) {
      localAccount = this.zzs;
    }
    for (;;)
    {
      AppMethodBeat.o(11794);
      return localAccount;
      if (this.zzqv != null) {
        localAccount = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(this.zzqv));
      }
    }
  }
  
  public Integer getOauthPolicy()
  {
    return this.zzqx;
  }
  
  public Integer getPolicyAction()
  {
    return this.zzqy;
  }
  
  public Set<Scope> getScopes()
  {
    AppMethodBeat.i(11795);
    HashSet localHashSet = new HashSet(Arrays.asList(this.zzqw));
    AppMethodBeat.o(11795);
    return localHashSet;
  }
  
  public AuthAccountRequest setOauthPolicy(Integer paramInteger)
  {
    this.zzqx = paramInteger;
    return this;
  }
  
  public AuthAccountRequest setPolicyAction(Integer paramInteger)
  {
    this.zzqy = paramInteger;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(11796);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zzqv, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 3, this.zzqw, paramInt, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 4, this.zzqx, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 5, this.zzqy, false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, this.zzs, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(11796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.AuthAccountRequest
 * JD-Core Version:    0.7.0.1
 */