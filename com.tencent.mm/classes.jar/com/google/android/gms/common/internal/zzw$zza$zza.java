package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

class zzw$zza$zza
  implements zzw
{
  private IBinder zzrk;
  
  zzw$zza$zza(IBinder paramIBinder)
  {
    this.zzrk = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.zzrk;
  }
  
  /* Error */
  public boolean zze(java.lang.String paramString, IObjectWrapper paramIObjectWrapper)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 5
    //   8: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 6
    //   13: aload 5
    //   15: ldc 31
    //   17: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 5
    //   22: aload_1
    //   23: invokevirtual 38	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: aload_2
    //   27: ifnull +63 -> 90
    //   30: aload_2
    //   31: invokeinterface 42 1 0
    //   36: astore_1
    //   37: aload 5
    //   39: aload_1
    //   40: invokevirtual 45	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   43: aload_0
    //   44: getfield 18	com/google/android/gms/common/internal/zzw$zza$zza:zzrk	Landroid/os/IBinder;
    //   47: iconst_3
    //   48: aload 5
    //   50: aload 6
    //   52: iconst_0
    //   53: invokeinterface 51 5 0
    //   58: pop
    //   59: aload 6
    //   61: invokevirtual 54	android/os/Parcel:readException	()V
    //   64: aload 6
    //   66: invokevirtual 58	android/os/Parcel:readInt	()I
    //   69: istore_3
    //   70: iload_3
    //   71: ifeq +6 -> 77
    //   74: iconst_1
    //   75: istore 4
    //   77: aload 6
    //   79: invokevirtual 61	android/os/Parcel:recycle	()V
    //   82: aload 5
    //   84: invokevirtual 61	android/os/Parcel:recycle	()V
    //   87: iload 4
    //   89: ireturn
    //   90: aconst_null
    //   91: astore_1
    //   92: goto -55 -> 37
    //   95: astore_1
    //   96: aload 6
    //   98: invokevirtual 61	android/os/Parcel:recycle	()V
    //   101: aload 5
    //   103: invokevirtual 61	android/os/Parcel:recycle	()V
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	zza
    //   0	108	1	paramString	java.lang.String
    //   0	108	2	paramIObjectWrapper	IObjectWrapper
    //   69	2	3	i	int
    //   1	87	4	bool	boolean
    //   6	96	5	localParcel1	Parcel
    //   11	86	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	26	95	finally
    //   30	37	95	finally
    //   37	70	95	finally
  }
  
  /* Error */
  public boolean zzf(java.lang.String paramString, IObjectWrapper paramIObjectWrapper)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 5
    //   8: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 6
    //   13: aload 5
    //   15: ldc 31
    //   17: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 5
    //   22: aload_1
    //   23: invokevirtual 38	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: aload_2
    //   27: ifnull +63 -> 90
    //   30: aload_2
    //   31: invokeinterface 42 1 0
    //   36: astore_1
    //   37: aload 5
    //   39: aload_1
    //   40: invokevirtual 45	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   43: aload_0
    //   44: getfield 18	com/google/android/gms/common/internal/zzw$zza$zza:zzrk	Landroid/os/IBinder;
    //   47: iconst_4
    //   48: aload 5
    //   50: aload 6
    //   52: iconst_0
    //   53: invokeinterface 51 5 0
    //   58: pop
    //   59: aload 6
    //   61: invokevirtual 54	android/os/Parcel:readException	()V
    //   64: aload 6
    //   66: invokevirtual 58	android/os/Parcel:readInt	()I
    //   69: istore_3
    //   70: iload_3
    //   71: ifeq +6 -> 77
    //   74: iconst_1
    //   75: istore 4
    //   77: aload 6
    //   79: invokevirtual 61	android/os/Parcel:recycle	()V
    //   82: aload 5
    //   84: invokevirtual 61	android/os/Parcel:recycle	()V
    //   87: iload 4
    //   89: ireturn
    //   90: aconst_null
    //   91: astore_1
    //   92: goto -55 -> 37
    //   95: astore_1
    //   96: aload 6
    //   98: invokevirtual 61	android/os/Parcel:recycle	()V
    //   101: aload 5
    //   103: invokevirtual 61	android/os/Parcel:recycle	()V
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	zza
    //   0	108	1	paramString	java.lang.String
    //   0	108	2	paramIObjectWrapper	IObjectWrapper
    //   69	2	3	i	int
    //   1	87	4	bool	boolean
    //   6	96	5	localParcel1	Parcel
    //   11	86	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	26	95	finally
    //   30	37	95	finally
    //   37	70	95	finally
  }
  
  public IObjectWrapper zzyc()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
      this.zzrk.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      IObjectWrapper localIObjectWrapper = IObjectWrapper.zza.zzcd(localParcel2.readStrongBinder());
      return localIObjectWrapper;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IObjectWrapper zzyd()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
      this.zzrk.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      IObjectWrapper localIObjectWrapper = IObjectWrapper.zza.zzcd(localParcel2.readStrongBinder());
      return localIObjectWrapper;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzw.zza.zza
 * JD-Core Version:    0.7.0.1
 */