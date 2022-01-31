package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;

class zzbaq$zza$zza
  implements zzbaq
{
  private IBinder zzrk;
  
  zzbaq$zza$zza(IBinder paramIBinder)
  {
    this.zzrk = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.zzrk;
  }
  
  public void zza(int paramInt, Account paramAccount, zzbap paramzzbap)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
        localParcel1.writeInt(paramInt);
        if (paramAccount != null)
        {
          localParcel1.writeInt(1);
          paramAccount.writeToParcel(localParcel1, 0);
          if (paramzzbap != null)
          {
            paramAccount = paramzzbap.asBinder();
            localParcel1.writeStrongBinder(paramAccount);
            this.zzrk.transact(8, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAccount = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void zza(zzad paramzzad, zzx paramzzx)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
        if (paramzzad != null)
        {
          localParcel1.writeInt(1);
          paramzzad.writeToParcel(localParcel1, 0);
          if (paramzzx != null)
          {
            paramzzad = paramzzx.asBinder();
            localParcel1.writeStrongBinder(paramzzad);
            this.zzrk.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramzzad = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void zza(zzd paramzzd, zzbap paramzzbap)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
        if (paramzzd != null)
        {
          localParcel1.writeInt(1);
          paramzzd.writeToParcel(localParcel1, 0);
          if (paramzzbap != null)
          {
            paramzzd = paramzzbap.asBinder();
            localParcel1.writeStrongBinder(paramzzd);
            this.zzrk.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramzzd = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public void zza(com.google.android.gms.common.internal.zzr paramzzr, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 5
    //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 6
    //   13: aload 5
    //   15: ldc 30
    //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: ifnull +70 -> 91
    //   24: aload_1
    //   25: invokeinterface 78 1 0
    //   30: astore_1
    //   31: aload 5
    //   33: aload_1
    //   34: invokevirtual 51	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   37: aload 5
    //   39: iload_2
    //   40: invokevirtual 38	android/os/Parcel:writeInt	(I)V
    //   43: iload 4
    //   45: istore_2
    //   46: iload_3
    //   47: ifeq +5 -> 52
    //   50: iconst_1
    //   51: istore_2
    //   52: aload 5
    //   54: iload_2
    //   55: invokevirtual 38	android/os/Parcel:writeInt	(I)V
    //   58: aload_0
    //   59: getfield 18	com/google/android/gms/internal/zzbaq$zza$zza:zzrk	Landroid/os/IBinder;
    //   62: bipush 9
    //   64: aload 5
    //   66: aload 6
    //   68: iconst_0
    //   69: invokeinterface 57 5 0
    //   74: pop
    //   75: aload 6
    //   77: invokevirtual 60	android/os/Parcel:readException	()V
    //   80: aload 6
    //   82: invokevirtual 63	android/os/Parcel:recycle	()V
    //   85: aload 5
    //   87: invokevirtual 63	android/os/Parcel:recycle	()V
    //   90: return
    //   91: aconst_null
    //   92: astore_1
    //   93: goto -62 -> 31
    //   96: astore_1
    //   97: aload 6
    //   99: invokevirtual 63	android/os/Parcel:recycle	()V
    //   102: aload 5
    //   104: invokevirtual 63	android/os/Parcel:recycle	()V
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	zza
    //   0	109	1	paramzzr	com.google.android.gms.common.internal.zzr
    //   0	109	2	paramInt	int
    //   0	109	3	paramBoolean	boolean
    //   1	43	4	i	int
    //   6	97	5	localParcel1	Parcel
    //   11	87	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	20	96	finally
    //   24	31	96	finally
    //   31	43	96	finally
    //   52	80	96	finally
  }
  
  /* Error */
  public void zza(zzban paramzzban)
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
    //   26: invokevirtual 82	com/google/android/gms/internal/zzban:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/internal/zzbaq$zza$zza:zzrk	Landroid/os/IBinder;
    //   33: iconst_3
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 57 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 60	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 63	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 63	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 38	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 63	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 63	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	zza
    //   0	75	1	paramzzban	zzban
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
  
  public void zza(zzbar paramzzbar, zzbap paramzzbap)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
        if (paramzzbar != null)
        {
          localParcel1.writeInt(1);
          paramzzbar.writeToParcel(localParcel1, 0);
          if (paramzzbap != null)
          {
            paramzzbar = paramzzbap.asBinder();
            localParcel1.writeStrongBinder(paramzzbar);
            this.zzrk.transact(10, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramzzbar = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void zza(zzbau paramzzbau, zzbap paramzzbap)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
        if (paramzzbau != null)
        {
          localParcel1.writeInt(1);
          paramzzbau.writeToParcel(localParcel1, 0);
          if (paramzzbap != null)
          {
            paramzzbau = paramzzbap.asBinder();
            localParcel1.writeStrongBinder(paramzzbau);
            this.zzrk.transact(12, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramzzbau = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void zzaP(boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.zzrk.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void zzaQ(boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.zzrk.transact(13, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void zzb(zzbap paramzzbap)
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
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 48 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 51	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/google/android/gms/internal/zzbaq$zza$zza:zzrk	Landroid/os/IBinder;
    //   34: bipush 11
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 57 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 60	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 63	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 63	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 63	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 63	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	zza
    //   0	74	1	paramzzbap	zzbap
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  public void zznv(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
      localParcel1.writeInt(paramInt);
      this.zzrk.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzbaq.zza.zza
 * JD-Core Version:    0.7.0.1
 */