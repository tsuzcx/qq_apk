package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;

class zzk$zza$zza
  implements zzk
{
  private IBinder zzrk;
  
  zzk$zza$zza(IBinder paramIBinder)
  {
    this.zzrk = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.zzrk;
  }
  
  /* Error */
  public void zza(zzj paramzzj, com.google.android.gms.auth.api.signin.GoogleSignInOptions paramGoogleSignInOptions)
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
    //   16: ifnull +61 -> 77
    //   19: aload_1
    //   20: invokeinterface 38 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +50 -> 82
    //   35: aload_3
    //   36: iconst_1
    //   37: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 51	com/google/android/gms/auth/api/signin/GoogleSignInOptions:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/auth/api/signin/internal/zzk$zza$zza:zzrk	Landroid/os/IBinder;
    //   50: bipush 101
    //   52: aload_3
    //   53: aload 4
    //   55: iconst_0
    //   56: invokeinterface 57 5 0
    //   61: pop
    //   62: aload 4
    //   64: invokevirtual 60	android/os/Parcel:readException	()V
    //   67: aload 4
    //   69: invokevirtual 63	android/os/Parcel:recycle	()V
    //   72: aload_3
    //   73: invokevirtual 63	android/os/Parcel:recycle	()V
    //   76: return
    //   77: aconst_null
    //   78: astore_1
    //   79: goto -53 -> 26
    //   82: aload_3
    //   83: iconst_0
    //   84: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   87: goto -41 -> 46
    //   90: astore_1
    //   91: aload 4
    //   93: invokevirtual 63	android/os/Parcel:recycle	()V
    //   96: aload_3
    //   97: invokevirtual 63	android/os/Parcel:recycle	()V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	zza
    //   0	102	1	paramzzj	zzj
    //   0	102	2	paramGoogleSignInOptions	com.google.android.gms.auth.api.signin.GoogleSignInOptions
    //   3	94	3	localParcel1	android.os.Parcel
    //   7	85	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	90	finally
    //   19	26	90	finally
    //   26	31	90	finally
    //   35	46	90	finally
    //   46	67	90	finally
    //   82	87	90	finally
  }
  
  /* Error */
  public void zzb(zzj paramzzj, com.google.android.gms.auth.api.signin.GoogleSignInOptions paramGoogleSignInOptions)
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
    //   16: ifnull +61 -> 77
    //   19: aload_1
    //   20: invokeinterface 38 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +50 -> 82
    //   35: aload_3
    //   36: iconst_1
    //   37: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 51	com/google/android/gms/auth/api/signin/GoogleSignInOptions:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/auth/api/signin/internal/zzk$zza$zza:zzrk	Landroid/os/IBinder;
    //   50: bipush 102
    //   52: aload_3
    //   53: aload 4
    //   55: iconst_0
    //   56: invokeinterface 57 5 0
    //   61: pop
    //   62: aload 4
    //   64: invokevirtual 60	android/os/Parcel:readException	()V
    //   67: aload 4
    //   69: invokevirtual 63	android/os/Parcel:recycle	()V
    //   72: aload_3
    //   73: invokevirtual 63	android/os/Parcel:recycle	()V
    //   76: return
    //   77: aconst_null
    //   78: astore_1
    //   79: goto -53 -> 26
    //   82: aload_3
    //   83: iconst_0
    //   84: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   87: goto -41 -> 46
    //   90: astore_1
    //   91: aload 4
    //   93: invokevirtual 63	android/os/Parcel:recycle	()V
    //   96: aload_3
    //   97: invokevirtual 63	android/os/Parcel:recycle	()V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	zza
    //   0	102	1	paramzzj	zzj
    //   0	102	2	paramGoogleSignInOptions	com.google.android.gms.auth.api.signin.GoogleSignInOptions
    //   3	94	3	localParcel1	android.os.Parcel
    //   7	85	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	90	finally
    //   19	26	90	finally
    //   26	31	90	finally
    //   35	46	90	finally
    //   46	67	90	finally
    //   82	87	90	finally
  }
  
  /* Error */
  public void zzc(zzj paramzzj, com.google.android.gms.auth.api.signin.GoogleSignInOptions paramGoogleSignInOptions)
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
    //   16: ifnull +61 -> 77
    //   19: aload_1
    //   20: invokeinterface 38 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +50 -> 82
    //   35: aload_3
    //   36: iconst_1
    //   37: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 51	com/google/android/gms/auth/api/signin/GoogleSignInOptions:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/auth/api/signin/internal/zzk$zza$zza:zzrk	Landroid/os/IBinder;
    //   50: bipush 103
    //   52: aload_3
    //   53: aload 4
    //   55: iconst_0
    //   56: invokeinterface 57 5 0
    //   61: pop
    //   62: aload 4
    //   64: invokevirtual 60	android/os/Parcel:readException	()V
    //   67: aload 4
    //   69: invokevirtual 63	android/os/Parcel:recycle	()V
    //   72: aload_3
    //   73: invokevirtual 63	android/os/Parcel:recycle	()V
    //   76: return
    //   77: aconst_null
    //   78: astore_1
    //   79: goto -53 -> 26
    //   82: aload_3
    //   83: iconst_0
    //   84: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   87: goto -41 -> 46
    //   90: astore_1
    //   91: aload 4
    //   93: invokevirtual 63	android/os/Parcel:recycle	()V
    //   96: aload_3
    //   97: invokevirtual 63	android/os/Parcel:recycle	()V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	zza
    //   0	102	1	paramzzj	zzj
    //   0	102	2	paramGoogleSignInOptions	com.google.android.gms.auth.api.signin.GoogleSignInOptions
    //   3	94	3	localParcel1	android.os.Parcel
    //   7	85	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	90	finally
    //   19	26	90	finally
    //   26	31	90	finally
    //   35	46	90	finally
    //   46	67	90	finally
    //   82	87	90	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzk.zza.zza
 * JD-Core Version:    0.7.0.1
 */