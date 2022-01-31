package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator="AuthAccountRequestCreator")
public class AuthAccountRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AuthAccountRequest> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  @Deprecated
  @SafeParcelable.Field(id=2)
  private final IBinder zzqv;
  @SafeParcelable.Field(id=3)
  private final Scope[] zzqw;
  @SafeParcelable.Field(id=4)
  private Integer zzqx;
  @SafeParcelable.Field(id=5)
  private Integer zzqy;
  @SafeParcelable.Field(id=6, type="android.accounts.Account")
  private Account zzs;
  
  static
  {
    AppMethodBeat.i(61305);
    CREATOR = new AuthAccountRequestCreator();
    AppMethodBeat.o(61305);
  }
  
  @SafeParcelable.Constructor
  AuthAccountRequest(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) IBinder paramIBinder, @SafeParcelable.Param(id=3) Scope[] paramArrayOfScope, @SafeParcelable.Param(id=4) Integer paramInteger1, @SafeParcelable.Param(id=5) Integer paramInteger2, @SafeParcelable.Param(id=6) Account paramAccount)
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
    AppMethodBeat.i(61301);
    AppMethodBeat.o(61301);
  }
  
  @Deprecated
  public AuthAccountRequest(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet)
  {
    this(3, paramIAccountAccessor.asBinder(), (Scope[])paramSet.toArray(new Scope[paramSet.size()]), null, null, null);
    AppMethodBeat.i(61300);
    AppMethodBeat.o(61300);
  }
  
  public Account getAccount()
  {
    AppMethodBeat.i(61302);
    Account localAccount = null;
    if (this.zzs != null) {
      localAccount = this.zzs;
    }
    for (;;)
    {
      AppMethodBeat.o(61302);
      return localAccount;
      if (this.zzqv != null) {
        localAccount = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(this.zzqv));
      }
    }
  }
  
  @Nullable
  public Integer getOauthPolicy()
  {
    return this.zzqx;
  }
  
  @Nullable
  public Integer getPolicyAction()
  {
    return this.zzqy;
  }
  
  public Set<Scope> getScopes()
  {
    AppMethodBeat.i(61303);
    HashSet localHashSet = new HashSet(Arrays.asList(this.zzqw));
    AppMethodBeat.o(61303);
    return localHashSet;
  }
  
  public AuthAccountRequest setOauthPolicy(@Nullable Integer paramInteger)
  {
    this.zzqx = paramInteger;
    return this;
  }
  
  public AuthAccountRequest setPolicyAction(@Nullable Integer paramInteger)
  {
    this.zzqy = paramInteger;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(61304);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zzqv, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 3, this.zzqw, paramInt, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 4, this.zzqx, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 5, this.zzqy, false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, this.zzs, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(61304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.AuthAccountRequest
 * JD-Core Version:    0.7.0.1
 */