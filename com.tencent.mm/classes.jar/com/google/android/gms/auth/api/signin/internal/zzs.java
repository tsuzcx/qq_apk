package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.internal.auth.zze;

public abstract class zzs
  extends zze
  implements zzr
{
  public zzs()
  {
    super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 1: 
      zzq();
    }
    for (;;)
    {
      return true;
      zzr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzs
 * JD-Core Version:    0.7.0.1
 */