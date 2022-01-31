package com.google.android.gms.auth.account;

import android.os.IBinder;

class zza$zza$zza
  implements zza
{
  private IBinder zzrk;
  
  zza$zza$zza(IBinder paramIBinder)
  {
    this.zzrk = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.zzrk;
  }
  
  /* Error */
  public void zzac(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: aload_3
    //   7: ldc 31
    //   9: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: iload_1
    //   13: ifeq +27 -> 40
    //   16: aload_3
    //   17: iload_2
    //   18: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   21: aload_0
    //   22: getfield 18	com/google/android/gms/auth/account/zza$zza$zza:zzrk	Landroid/os/IBinder;
    //   25: iconst_2
    //   26: aload_3
    //   27: aconst_null
    //   28: iconst_1
    //   29: invokeinterface 45 5 0
    //   34: pop
    //   35: aload_3
    //   36: invokevirtual 48	android/os/Parcel:recycle	()V
    //   39: return
    //   40: iconst_0
    //   41: istore_2
    //   42: goto -26 -> 16
    //   45: astore 4
    //   47: aload_3
    //   48: invokevirtual 48	android/os/Parcel:recycle	()V
    //   51: aload 4
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	zza
    //   0	54	1	paramBoolean	boolean
    //   1	41	2	i	int
    //   5	43	3	localParcel	android.os.Parcel
    //   45	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	12	45	finally
    //   16	35	45	finally
  }
  
  /* Error */
  public void zzd(android.accounts.Account paramAccount)
  {
    // Byte code:
    //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 31
    //   7: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +33 -> 44
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 56	android/accounts/Account:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 18	com/google/android/gms/auth/account/zza$zza$zza:zzrk	Landroid/os/IBinder;
    //   29: iconst_1
    //   30: aload_2
    //   31: aconst_null
    //   32: iconst_1
    //   33: invokeinterface 45 5 0
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 48	android/os/Parcel:recycle	()V
    //   43: return
    //   44: aload_2
    //   45: iconst_0
    //   46: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   49: goto -24 -> 25
    //   52: astore_1
    //   53: aload_2
    //   54: invokevirtual 48	android/os/Parcel:recycle	()V
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	zza
    //   0	59	1	paramAccount	android.accounts.Account
    //   3	51	2	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	52	finally
    //   14	25	52	finally
    //   25	39	52	finally
    //   44	49	52	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.auth.account.zza.zza.zza
 * JD-Core Version:    0.7.0.1
 */