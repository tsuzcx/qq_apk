package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public abstract interface zzk
  extends IInterface
{
  public abstract void zza(zzj paramzzj, GoogleSignInOptions paramGoogleSignInOptions);
  
  public abstract void zzb(zzj paramzzj, GoogleSignInOptions paramGoogleSignInOptions);
  
  public abstract void zzc(zzj paramzzj, GoogleSignInOptions paramGoogleSignInOptions);
  
  public static abstract class zza
    extends Binder
    implements zzk
  {
    public static zzk zzaM(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
      if ((localIInterface != null) && ((localIInterface instanceof zzk))) {
        return (zzk)localIInterface;
      }
      return new zzk.zza.zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      zzj localzzj1 = null;
      zzj localzzj2 = null;
      Object localObject = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return true;
      case 101: 
        paramParcel1.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        localzzj1 = zzj.zza.zzaL(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          localObject = (GoogleSignInOptions)GoogleSignInOptions.CREATOR.createFromParcel(paramParcel1);
        }
        zza(localzzj1, (GoogleSignInOptions)localObject);
        paramParcel2.writeNoException();
        return true;
      case 102: 
        paramParcel1.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        localzzj2 = zzj.zza.zzaL(paramParcel1.readStrongBinder());
        localObject = localzzj1;
        if (paramParcel1.readInt() != 0) {
          localObject = (GoogleSignInOptions)GoogleSignInOptions.CREATOR.createFromParcel(paramParcel1);
        }
        zzb(localzzj2, (GoogleSignInOptions)localObject);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
      localzzj1 = zzj.zza.zzaL(paramParcel1.readStrongBinder());
      localObject = localzzj2;
      if (paramParcel1.readInt() != 0) {
        localObject = (GoogleSignInOptions)GoogleSignInOptions.CREATOR.createFromParcel(paramParcel1);
      }
      zzc(localzzj1, (GoogleSignInOptions)localObject);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzk
 * JD-Core Version:    0.7.0.1
 */