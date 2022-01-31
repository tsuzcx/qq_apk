package com.google.android.gms.internal;

import android.os.IBinder;

class zzvr$zza$zza
  implements zzvr
{
  private IBinder zzrk;
  
  zzvr$zza$zza(IBinder paramIBinder)
  {
    this.zzrk = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.zzrk;
  }
  
  /* Error */
  public void zza(zzvq paramzzvq)
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
    //   15: ifnull +42 -> 57
    //   18: aload_1
    //   19: invokeinterface 38 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/google/android/gms/internal/zzvr$zza$zza:zzrk	Landroid/os/IBinder;
    //   34: iconst_3
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 47 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 50	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 53	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 53	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -34 -> 25
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 53	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 53	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	zza
    //   0	73	1	paramzzvq	zzvq
    //   3	65	2	localParcel1	android.os.Parcel
    //   7	57	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	62	finally
    //   18	25	62	finally
    //   25	48	62	finally
  }
  
  /* Error */
  public void zza(zzvq paramzzvq, com.google.android.gms.auth.api.proxy.ProxyRequest paramProxyRequest)
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
    //   37: invokevirtual 58	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 64	com/google/android/gms/auth/api/proxy/ProxyRequest:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/internal/zzvr$zza$zza:zzrk	Landroid/os/IBinder;
    //   50: iconst_1
    //   51: aload_3
    //   52: aload 4
    //   54: iconst_0
    //   55: invokeinterface 47 5 0
    //   60: pop
    //   61: aload 4
    //   63: invokevirtual 50	android/os/Parcel:readException	()V
    //   66: aload 4
    //   68: invokevirtual 53	android/os/Parcel:recycle	()V
    //   71: aload_3
    //   72: invokevirtual 53	android/os/Parcel:recycle	()V
    //   75: return
    //   76: aconst_null
    //   77: astore_1
    //   78: goto -52 -> 26
    //   81: aload_3
    //   82: iconst_0
    //   83: invokevirtual 58	android/os/Parcel:writeInt	(I)V
    //   86: goto -40 -> 46
    //   89: astore_1
    //   90: aload 4
    //   92: invokevirtual 53	android/os/Parcel:recycle	()V
    //   95: aload_3
    //   96: invokevirtual 53	android/os/Parcel:recycle	()V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	zza
    //   0	101	1	paramzzvq	zzvq
    //   0	101	2	paramProxyRequest	com.google.android.gms.auth.api.proxy.ProxyRequest
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
  public void zza(zzvq paramzzvq, com.google.android.gms.auth.api.proxy.zza paramzza)
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
    //   37: invokevirtual 58	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 68	com/google/android/gms/auth/api/proxy/zza:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/internal/zzvr$zza$zza:zzrk	Landroid/os/IBinder;
    //   50: iconst_2
    //   51: aload_3
    //   52: aload 4
    //   54: iconst_0
    //   55: invokeinterface 47 5 0
    //   60: pop
    //   61: aload 4
    //   63: invokevirtual 50	android/os/Parcel:readException	()V
    //   66: aload 4
    //   68: invokevirtual 53	android/os/Parcel:recycle	()V
    //   71: aload_3
    //   72: invokevirtual 53	android/os/Parcel:recycle	()V
    //   75: return
    //   76: aconst_null
    //   77: astore_1
    //   78: goto -52 -> 26
    //   81: aload_3
    //   82: iconst_0
    //   83: invokevirtual 58	android/os/Parcel:writeInt	(I)V
    //   86: goto -40 -> 46
    //   89: astore_1
    //   90: aload 4
    //   92: invokevirtual 53	android/os/Parcel:recycle	()V
    //   95: aload_3
    //   96: invokevirtual 53	android/os/Parcel:recycle	()V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	zza
    //   0	101	1	paramzzvq	zzvq
    //   0	101	2	paramzza	com.google.android.gms.auth.api.proxy.zza
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzvr.zza.zza
 * JD-Core Version:    0.7.0.1
 */