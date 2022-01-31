package com.google.android.gms.auth.account;

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
  public void zza(zza paramzza, android.accounts.Account paramAccount)
  {
    // Byte code:
    //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 30
    //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +60 -> 76
    //   19: aload_1
    //   20: invokeinterface 38 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +49 -> 81
    //   35: aload_3
    //   36: iconst_1
    //   37: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 51	android/accounts/Account:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/auth/account/zzb$zza$zza:zzrk	Landroid/os/IBinder;
    //   50: iconst_3
    //   51: aload_3
    //   52: aload 4
    //   54: iconst_0
    //   55: invokeinterface 57 5 0
    //   60: pop
    //   61: aload 4
    //   63: invokevirtual 60	android/os/Parcel:readException	()V
    //   66: aload 4
    //   68: invokevirtual 63	android/os/Parcel:recycle	()V
    //   71: aload_3
    //   72: invokevirtual 63	android/os/Parcel:recycle	()V
    //   75: return
    //   76: aconst_null
    //   77: astore_1
    //   78: goto -52 -> 26
    //   81: aload_3
    //   82: iconst_0
    //   83: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   86: goto -40 -> 46
    //   89: astore_1
    //   90: aload 4
    //   92: invokevirtual 63	android/os/Parcel:recycle	()V
    //   95: aload_3
    //   96: invokevirtual 63	android/os/Parcel:recycle	()V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	zza
    //   0	101	1	paramzza	zza
    //   0	101	2	paramAccount	android.accounts.Account
    //   3	93	3	localParcel1	android.os.Parcel
    //   7	84	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	89	finally
    //   19	26	89	finally
    //   26	31	89	finally
    //   35	46	89	finally
    //   46	66	89	finally
    //   81	86	89	finally
  }
  
  /* Error */
  public void zza(zza paramzza, java.lang.String paramString)
  {
    // Byte code:
    //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 30
    //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +50 -> 66
    //   19: aload_1
    //   20: invokeinterface 38 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: aload_2
    //   33: invokevirtual 67	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 18	com/google/android/gms/auth/account/zzb$zza$zza:zzrk	Landroid/os/IBinder;
    //   40: iconst_2
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 57 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 60	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 63	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 63	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aconst_null
    //   67: astore_1
    //   68: goto -42 -> 26
    //   71: astore_1
    //   72: aload 4
    //   74: invokevirtual 63	android/os/Parcel:recycle	()V
    //   77: aload_3
    //   78: invokevirtual 63	android/os/Parcel:recycle	()V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	zza
    //   0	83	1	paramzza	zza
    //   0	83	2	paramString	java.lang.String
    //   3	75	3	localParcel1	android.os.Parcel
    //   7	66	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	71	finally
    //   19	26	71	finally
    //   26	56	71	finally
  }
  
  /* Error */
  public void zzad(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: aload_3
    //   12: ldc 30
    //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: iload_1
    //   18: ifeq +38 -> 56
    //   21: aload_3
    //   22: iload_2
    //   23: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   26: aload_0
    //   27: getfield 18	com/google/android/gms/auth/account/zzb$zza$zza:zzrk	Landroid/os/IBinder;
    //   30: iconst_1
    //   31: aload_3
    //   32: aload 4
    //   34: iconst_0
    //   35: invokeinterface 57 5 0
    //   40: pop
    //   41: aload 4
    //   43: invokevirtual 60	android/os/Parcel:readException	()V
    //   46: aload 4
    //   48: invokevirtual 63	android/os/Parcel:recycle	()V
    //   51: aload_3
    //   52: invokevirtual 63	android/os/Parcel:recycle	()V
    //   55: return
    //   56: iconst_0
    //   57: istore_2
    //   58: goto -37 -> 21
    //   61: astore 5
    //   63: aload 4
    //   65: invokevirtual 63	android/os/Parcel:recycle	()V
    //   68: aload_3
    //   69: invokevirtual 63	android/os/Parcel:recycle	()V
    //   72: aload 5
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	zza
    //   0	75	1	paramBoolean	boolean
    //   1	57	2	i	int
    //   5	64	3	localParcel1	android.os.Parcel
    //   9	55	4	localParcel2	android.os.Parcel
    //   61	12	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	17	61	finally
    //   21	46	61	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.account.zzb.zza.zza
 * JD-Core Version:    0.7.0.1
 */