package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

public abstract class zzvl$zza
  extends Binder
  implements zzvl
{
  public static zzvl zzaG(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    if ((localIInterface != null) && ((localIInterface instanceof zzvl))) {
      return (zzvl)localIInterface;
    }
    return new zzvl.zza.zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    zzvk localzzvk1 = null;
    zzvk localzzvk2 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
      localzzvk1 = zzvk.zza.zzaF(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CredentialRequest)CredentialRequest.CREATOR.createFromParcel(paramParcel1);
      }
      zza(localzzvk1, (CredentialRequest)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
      localzzvk2 = zzvk.zza.zzaF(paramParcel1.readStrongBinder());
      localObject1 = localzzvk1;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzvm)zzvm.CREATOR.createFromParcel(paramParcel1);
      }
      zza(localzzvk2, (zzvm)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
      localzzvk1 = zzvk.zza.zzaF(paramParcel1.readStrongBinder());
      localObject1 = localzzvk2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzvg)zzvg.CREATOR.createFromParcel(paramParcel1);
      }
      zza(localzzvk1, (zzvg)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
      zza(zzvk.zza.zzaF(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    localzzvk1 = zzvk.zza.zzaF(paramParcel1.readStrongBinder());
    localObject1 = localObject2;
    if (paramParcel1.readInt() != 0) {
      localObject1 = (zzvi)zzvi.CREATOR.createFromParcel(paramParcel1);
    }
    zza(localzzvk1, (zzvi)localObject1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzvl.zza
 * JD-Core Version:    0.7.0.1
 */