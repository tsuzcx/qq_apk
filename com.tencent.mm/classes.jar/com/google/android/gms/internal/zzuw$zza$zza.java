package com.google.android.gms.internal;

import android.os.IBinder;

class zzuw$zza$zza
  implements zzuw
{
  private IBinder zzrk;
  
  zzuw$zza$zza(IBinder paramIBinder)
  {
    this.zzrk = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.zzrk;
  }
  
  /* Error */
  public void zzg(com.google.android.gms.common.api.Status paramStatus)
  {
    // Byte code:
    //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 31
    //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 45	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/internal/zzuw$zza$zza:zzrk	Landroid/os/IBinder;
    //   33: iconst_2
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 51 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 54	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 57	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 57	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 57	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 57	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	zza
    //   0	75	1	paramStatus	com.google.android.gms.common.api.Status
    //   3	67	2	localParcel1	android.os.Parcel
    //   7	59	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzuw.zza.zza
 * JD-Core Version:    0.7.0.1
 */