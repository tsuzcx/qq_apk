package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RecordConsentRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<RecordConsentRequest> CREATOR;
  private final Scope[] zzadr;
  private final int zzal;
  private final Account zzs;
  private final String zzw;
  
  static
  {
    AppMethodBeat.i(12175);
    CREATOR = new RecordConsentRequestCreator();
    AppMethodBeat.o(12175);
  }
  
  RecordConsentRequest(int paramInt, Account paramAccount, Scope[] paramArrayOfScope, String paramString)
  {
    this.zzal = paramInt;
    this.zzs = paramAccount;
    this.zzadr = paramArrayOfScope;
    this.zzw = paramString;
  }
  
  public RecordConsentRequest(Account paramAccount, Scope[] paramArrayOfScope, String paramString)
  {
    this(1, paramAccount, paramArrayOfScope, paramString);
  }
  
  public Account getAccount()
  {
    return this.zzs;
  }
  
  public Scope[] getScopesToConsent()
  {
    return this.zzadr;
  }
  
  public String getServerClientId()
  {
    return this.zzw;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(12174);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getAccount(), paramInt, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 3, getScopesToConsent(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, getServerClientId(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(12174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.signin.internal.RecordConsentRequest
 * JD-Core Version:    0.7.0.1
 */