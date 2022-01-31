package com.google.android.gms.dynamite;

import android.os.IBinder;

class zzb$zza$zza
  implements zzb
{
  private IBinder zzrk;
  
  zzb$zza$zza(IBinder paramIBinder)
  {
    this.zzrk = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.zzrk;
  }
  
  /* Error */
  public com.google.android.gms.dynamic.IObjectWrapper zza(com.google.android.gms.dynamic.IObjectWrapper paramIObjectWrapper, java.lang.String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 30
    //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +70 -> 88
    //   21: aload_1
    //   22: invokeinterface 38 1 0
    //   27: astore_1
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 4
    //   36: aload_2
    //   37: invokevirtual 44	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   40: aload 4
    //   42: aload_3
    //   43: invokevirtual 48	android/os/Parcel:writeByteArray	([B)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/dynamite/zzb$zza$zza:zzrk	Landroid/os/IBinder;
    //   50: iconst_1
    //   51: aload 4
    //   53: aload 5
    //   55: iconst_0
    //   56: invokeinterface 54 5 0
    //   61: pop
    //   62: aload 5
    //   64: invokevirtual 57	android/os/Parcel:readException	()V
    //   67: aload 5
    //   69: invokevirtual 60	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   72: invokestatic 66	com/google/android/gms/dynamic/IObjectWrapper$zza:zzcd	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   75: astore_1
    //   76: aload 5
    //   78: invokevirtual 69	android/os/Parcel:recycle	()V
    //   81: aload 4
    //   83: invokevirtual 69	android/os/Parcel:recycle	()V
    //   86: aload_1
    //   87: areturn
    //   88: aconst_null
    //   89: astore_1
    //   90: goto -62 -> 28
    //   93: astore_1
    //   94: aload 5
    //   96: invokevirtual 69	android/os/Parcel:recycle	()V
    //   99: aload 4
    //   101: invokevirtual 69	android/os/Parcel:recycle	()V
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	zza
    //   0	106	1	paramIObjectWrapper	com.google.android.gms.dynamic.IObjectWrapper
    //   0	106	2	paramString	java.lang.String
    //   0	106	3	paramArrayOfByte	byte[]
    //   3	97	4	localParcel1	android.os.Parcel
    //   8	87	5	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	93	finally
    //   21	28	93	finally
    //   28	76	93	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.dynamite.zzb.zza.zza
 * JD-Core Version:    0.7.0.1
 */