package com.tencent.mm.plugin.exdevice.service;

import android.os.IBinder;

final class l$a$a
  implements l
{
  private IBinder mRemote;
  
  l$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  /* Error */
  public final void a(long paramLong, int paramInt1, int paramInt2, java.lang.String paramString, p paramp)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 7
    //   5: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 8
    //   10: aload 7
    //   12: ldc 28
    //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 7
    //   19: lload_1
    //   20: invokevirtual 36	android/os/Parcel:writeLong	(J)V
    //   23: aload 7
    //   25: iload_3
    //   26: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   29: aload 7
    //   31: iload 4
    //   33: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   36: aload 7
    //   38: aload 5
    //   40: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   43: aload 6
    //   45: ifnull +51 -> 96
    //   48: aload 6
    //   50: invokeinterface 49 1 0
    //   55: astore 5
    //   57: aload 7
    //   59: aload 5
    //   61: invokevirtual 52	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   64: aload_0
    //   65: getfield 18	com/tencent/mm/plugin/exdevice/service/l$a$a:mRemote	Landroid/os/IBinder;
    //   68: iconst_1
    //   69: aload 7
    //   71: aload 8
    //   73: iconst_0
    //   74: invokeinterface 58 5 0
    //   79: pop
    //   80: aload 8
    //   82: invokevirtual 61	android/os/Parcel:readException	()V
    //   85: aload 8
    //   87: invokevirtual 64	android/os/Parcel:recycle	()V
    //   90: aload 7
    //   92: invokevirtual 64	android/os/Parcel:recycle	()V
    //   95: return
    //   96: aconst_null
    //   97: astore 5
    //   99: goto -42 -> 57
    //   102: astore 5
    //   104: aload 8
    //   106: invokevirtual 64	android/os/Parcel:recycle	()V
    //   109: aload 7
    //   111: invokevirtual 64	android/os/Parcel:recycle	()V
    //   114: aload 5
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	a
    //   0	117	1	paramLong	long
    //   0	117	3	paramInt1	int
    //   0	117	4	paramInt2	int
    //   0	117	5	paramString	java.lang.String
    //   0	117	6	paramp	p
    //   3	107	7	localParcel1	android.os.Parcel
    //   8	97	8	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	43	102	finally
    //   48	57	102	finally
    //   57	85	102	finally
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.l.a.a
 * JD-Core Version:    0.7.0.1
 */