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
    //   0: sipush 19614
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 7
    //   11: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   14: astore 8
    //   16: aload 7
    //   18: ldc 34
    //   20: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   23: aload 7
    //   25: lload_1
    //   26: invokevirtual 42	android/os/Parcel:writeLong	(J)V
    //   29: aload 7
    //   31: iload_3
    //   32: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   35: aload 7
    //   37: iload 4
    //   39: invokevirtual 45	android/os/Parcel:writeInt	(I)V
    //   42: aload 7
    //   44: aload 5
    //   46: invokevirtual 48	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   49: aload 6
    //   51: ifnull +57 -> 108
    //   54: aload 6
    //   56: invokeinterface 54 1 0
    //   61: astore 5
    //   63: aload 7
    //   65: aload 5
    //   67: invokevirtual 57	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   70: aload_0
    //   71: getfield 18	com/tencent/mm/plugin/exdevice/service/l$a$a:mRemote	Landroid/os/IBinder;
    //   74: iconst_1
    //   75: aload 7
    //   77: aload 8
    //   79: iconst_0
    //   80: invokeinterface 63 5 0
    //   85: pop
    //   86: aload 8
    //   88: invokevirtual 66	android/os/Parcel:readException	()V
    //   91: aload 8
    //   93: invokevirtual 69	android/os/Parcel:recycle	()V
    //   96: aload 7
    //   98: invokevirtual 69	android/os/Parcel:recycle	()V
    //   101: sipush 19614
    //   104: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: aconst_null
    //   109: astore 5
    //   111: goto -48 -> 63
    //   114: astore 5
    //   116: aload 8
    //   118: invokevirtual 69	android/os/Parcel:recycle	()V
    //   121: aload 7
    //   123: invokevirtual 69	android/os/Parcel:recycle	()V
    //   126: sipush 19614
    //   129: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload 5
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	a
    //   0	135	1	paramLong	long
    //   0	135	3	paramInt1	int
    //   0	135	4	paramInt2	int
    //   0	135	5	paramString	java.lang.String
    //   0	135	6	paramp	p
    //   9	113	7	localParcel1	android.os.Parcel
    //   14	103	8	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   16	49	114	finally
    //   54	63	114	finally
    //   63	91	114	finally
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.l.a.a
 * JD-Core Version:    0.7.0.1
 */