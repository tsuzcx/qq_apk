package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzr.zza;
import com.google.android.gms.common.internal.zzx.zza;

public abstract class zzbaq$zza
  extends Binder
  implements zzbaq
{
  public static zzbaq zzff(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
    if ((localIInterface != null) && ((localIInterface instanceof zzbaq))) {
      return (zzbaq)localIInterface;
    }
    return new zzbaq.zza.zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzd)zzd.CREATOR.createFromParcel(paramParcel1);
      }
      zza((zzd)localObject1, zzbap.zza.zzfe(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzban)zzban.CREATOR.createFromParcel(paramParcel1);
      }
      zza((zzban)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        zzaP(bool1);
        paramParcel2.writeNoException();
        return true;
      }
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzad)zzad.CREATOR.createFromParcel(paramParcel1);
      }
      zza((zzad)localObject1, zzx.zza.zzbw(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      zznv(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      paramInt1 = paramParcel1.readInt();
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Account)Account.CREATOR.createFromParcel(paramParcel1);
      }
      zza(paramInt1, (Account)localObject1, zzbap.zza.zzfe(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      localObject1 = zzr.zza.zzbr(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      zza((zzr)localObject1, paramInt1, bool1);
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      localObject1 = localObject5;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzbar)zzbar.CREATOR.createFromParcel(paramParcel1);
      }
      zza((zzbar)localObject1, zzbap.zza.zzfe(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      zzb(zzbap.zza.zzfe(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzbau)zzbau.CREATOR.createFromParcel(paramParcel1);
      }
      zza((zzbau)localObject1, zzbap.zza.zzfe(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
    bool1 = bool2;
    if (paramParcel1.readInt() != 0) {
      bool1 = true;
    }
    zzaQ(bool1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzbaq.zza
 * JD-Core Version:    0.7.0.1
 */