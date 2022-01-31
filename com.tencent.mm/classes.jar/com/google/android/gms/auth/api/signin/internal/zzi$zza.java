package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class zzi$zza
  extends Binder
  implements zzi
{
  public zzi$zza()
  {
    attachInterface(this, "com.google.android.gms.auth.api.signin.internal.IRevocationService");
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
      paramParcel2.writeString("com.google.android.gms.auth.api.signin.internal.IRevocationService");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    zzrv();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzi.zza
 * JD-Core Version:    0.7.0.1
 */