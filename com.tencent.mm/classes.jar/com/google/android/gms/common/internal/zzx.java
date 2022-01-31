package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract interface zzx
  extends IInterface
{
  public abstract void zza(zzaf paramzzaf);
  
  private static class zza$zza
    implements zzx
  {
    private IBinder zzrk;
    
    zza$zza(IBinder paramIBinder)
    {
      this.zzrk = paramIBinder;
    }
    
    public IBinder asBinder()
    {
      return this.zzrk;
    }
    
    /* Error */
    public void zza(zzaf paramzzaf)
    {
      // Byte code:
      //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 30
      //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_1
      //   15: ifnull +41 -> 56
      //   18: aload_2
      //   19: iconst_1
      //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
      //   23: aload_1
      //   24: aload_2
      //   25: iconst_0
      //   26: invokevirtual 44	com/google/android/gms/common/internal/zzaf:writeToParcel	(Landroid/os/Parcel;I)V
      //   29: aload_0
      //   30: getfield 18	com/google/android/gms/common/internal/zzx$zza$zza:zzrk	Landroid/os/IBinder;
      //   33: iconst_2
      //   34: aload_2
      //   35: aload_3
      //   36: iconst_0
      //   37: invokeinterface 50 5 0
      //   42: pop
      //   43: aload_3
      //   44: invokevirtual 53	android/os/Parcel:readException	()V
      //   47: aload_3
      //   48: invokevirtual 56	android/os/Parcel:recycle	()V
      //   51: aload_2
      //   52: invokevirtual 56	android/os/Parcel:recycle	()V
      //   55: return
      //   56: aload_2
      //   57: iconst_0
      //   58: invokevirtual 38	android/os/Parcel:writeInt	(I)V
      //   61: goto -32 -> 29
      //   64: astore_1
      //   65: aload_3
      //   66: invokevirtual 56	android/os/Parcel:recycle	()V
      //   69: aload_2
      //   70: invokevirtual 56	android/os/Parcel:recycle	()V
      //   73: aload_1
      //   74: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	75	0	this	zza
      //   0	75	1	paramzzaf	zzaf
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzx
 * JD-Core Version:    0.7.0.1
 */