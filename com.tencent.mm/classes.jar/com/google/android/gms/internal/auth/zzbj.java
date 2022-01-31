package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

public abstract class zzbj
  extends zze
  implements zzbi
{
  public zzbj()
  {
    super("com.google.android.gms.auth.api.internal.IAuthCallbacks");
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 1: 
      zzd((ProxyResponse)zzf.zzd(paramParcel1, ProxyResponse.CREATOR));
    }
    for (;;)
    {
      paramParcel2.writeNoException();
      return true;
      zzf(paramParcel1.readString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzbj
 * JD-Core Version:    0.7.0.1
 */