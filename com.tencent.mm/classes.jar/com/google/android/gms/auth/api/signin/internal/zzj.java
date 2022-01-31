package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract interface zzj
  extends IInterface
{
  public abstract void zza(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus);
  
  public abstract void zzl(Status paramStatus);
  
  public abstract void zzm(Status paramStatus);
  
  public static abstract class zza
    extends Binder
    implements zzj
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }
    
    public static zzj zzaL(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzj))) {
        return (zzj)localIInterface;
      }
      return new zzj.zza.zza(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
        return true;
      case 101: 
        paramParcel1.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
        GoogleSignInAccount localGoogleSignInAccount;
        if (paramParcel1.readInt() != 0)
        {
          localGoogleSignInAccount = (GoogleSignInAccount)GoogleSignInAccount.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label128;
          }
        }
        for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          zza(localGoogleSignInAccount, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localGoogleSignInAccount = null;
          break;
        }
      case 102: 
        label128:
        paramParcel1.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          zzl(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zzm(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzj
 * JD-Core Version:    0.7.0.1
 */