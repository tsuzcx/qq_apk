package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public class GetServiceRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetServiceRequest> CREATOR;
  private final int version;
  private final int zzst;
  private int zzsu;
  private String zzsv;
  private IBinder zzsw;
  private Scope[] zzsx;
  private Bundle zzsy;
  private Account zzsz;
  private Feature[] zzta;
  private Feature[] zztb;
  private boolean zztc;
  
  static
  {
    AppMethodBeat.i(4632);
    CREATOR = new GetServiceRequestCreator();
    AppMethodBeat.o(4632);
  }
  
  public GetServiceRequest(int paramInt)
  {
    this.version = 4;
    this.zzsu = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    this.zzst = paramInt;
    this.zztc = true;
  }
  
  GetServiceRequest(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount, Feature[] paramArrayOfFeature1, Feature[] paramArrayOfFeature2, boolean paramBoolean)
  {
    AppMethodBeat.i(4626);
    this.version = paramInt1;
    this.zzst = paramInt2;
    this.zzsu = paramInt3;
    if ("com.google.android.gms".equals(paramString))
    {
      this.zzsv = "com.google.android.gms";
      if (paramInt1 >= 2) {
        break label101;
      }
    }
    for (this.zzsz = zzb(paramIBinder);; this.zzsz = paramAccount)
    {
      this.zzsx = paramArrayOfScope;
      this.zzsy = paramBundle;
      this.zzta = paramArrayOfFeature1;
      this.zztb = paramArrayOfFeature2;
      this.zztc = paramBoolean;
      AppMethodBeat.o(4626);
      return;
      this.zzsv = paramString;
      break;
      label101:
      this.zzsw = paramIBinder;
    }
  }
  
  public static Parcelable.Creator<GetServiceRequest> getCreator()
  {
    return CREATOR;
  }
  
  private static Account zzb(IBinder paramIBinder)
  {
    AppMethodBeat.i(4631);
    Account localAccount = null;
    if (paramIBinder != null) {
      localAccount = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(paramIBinder));
    }
    AppMethodBeat.o(4631);
    return localAccount;
  }
  
  public Account getAuthenticatedAccount()
  {
    AppMethodBeat.i(4627);
    Account localAccount = zzb(this.zzsw);
    AppMethodBeat.o(4627);
    return localAccount;
  }
  
  public String getCallingPackage()
  {
    return this.zzsv;
  }
  
  public Feature[] getClientApiFeatures()
  {
    return this.zztb;
  }
  
  public int getClientLibraryVersion()
  {
    return this.zzsu;
  }
  
  public Account getClientRequestedAccount()
  {
    return this.zzsz;
  }
  
  public Feature[] getClientRequiredFeatures()
  {
    return this.zzta;
  }
  
  public Bundle getExtraArgs()
  {
    return this.zzsy;
  }
  
  public Scope[] getScopes()
  {
    return this.zzsx;
  }
  
  public int getServiceId()
  {
    return this.zzst;
  }
  
  public boolean isRequestingConnectionInfo()
  {
    return this.zztc;
  }
  
  public GetServiceRequest setAuthenticatedAccount(IAccountAccessor paramIAccountAccessor)
  {
    AppMethodBeat.i(4628);
    if (paramIAccountAccessor != null) {
      this.zzsw = paramIAccountAccessor.asBinder();
    }
    AppMethodBeat.o(4628);
    return this;
  }
  
  public GetServiceRequest setCallingPackage(String paramString)
  {
    this.zzsv = paramString;
    return this;
  }
  
  public GetServiceRequest setClientApiFeatures(Feature[] paramArrayOfFeature)
  {
    this.zztb = paramArrayOfFeature;
    return this;
  }
  
  public GetServiceRequest setClientLibraryVersion(int paramInt)
  {
    this.zzsu = paramInt;
    return this;
  }
  
  public GetServiceRequest setClientRequestedAccount(Account paramAccount)
  {
    this.zzsz = paramAccount;
    return this;
  }
  
  public GetServiceRequest setClientRequiredFeatures(Feature[] paramArrayOfFeature)
  {
    this.zzta = paramArrayOfFeature;
    return this;
  }
  
  public GetServiceRequest setExtraArgs(Bundle paramBundle)
  {
    this.zzsy = paramBundle;
    return this;
  }
  
  public GetServiceRequest setRequestingConnectionInfo(boolean paramBoolean)
  {
    this.zztc = paramBoolean;
    return this;
  }
  
  public GetServiceRequest setScopes(Collection<Scope> paramCollection)
  {
    AppMethodBeat.i(4629);
    this.zzsx = ((Scope[])paramCollection.toArray(new Scope[paramCollection.size()]));
    AppMethodBeat.o(4629);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4630);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.version);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzst);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzsu);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzsv, false);
    SafeParcelWriter.writeIBinder(paramParcel, 5, this.zzsw, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 6, this.zzsx, paramInt, false);
    SafeParcelWriter.writeBundle(paramParcel, 7, this.zzsy, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, this.zzsz, paramInt, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 10, this.zzta, paramInt, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 11, this.zztb, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 12, this.zztc);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(4630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.GetServiceRequest
 * JD-Core Version:    0.7.0.1
 */