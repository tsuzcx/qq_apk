package com.tencent.mm.network.a;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a$a
  implements b
{
  private IBinder mRemote;
  
  public b$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  /* Error */
  public final void a(int paramInt1, int paramInt2, java.lang.String paramString1, int paramInt3, java.lang.String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: ldc 21
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 8
    //   13: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   16: astore 9
    //   18: aload 8
    //   20: ldc 35
    //   22: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   25: aload 8
    //   27: iload_1
    //   28: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   31: aload 8
    //   33: iload_2
    //   34: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   37: aload 8
    //   39: aload_3
    //   40: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   43: aload 8
    //   45: iload 4
    //   47: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   50: aload 8
    //   52: aload 5
    //   54: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   57: iload 6
    //   59: ifeq +49 -> 108
    //   62: iload 7
    //   64: istore_1
    //   65: aload 8
    //   67: iload_1
    //   68: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   71: aload_0
    //   72: getfield 18	com/tencent/mm/network/a/b$a$a:mRemote	Landroid/os/IBinder;
    //   75: iconst_1
    //   76: aload 8
    //   78: aload 9
    //   80: iconst_0
    //   81: invokeinterface 51 5 0
    //   86: pop
    //   87: aload 9
    //   89: invokevirtual 54	android/os/Parcel:readException	()V
    //   92: aload 9
    //   94: invokevirtual 57	android/os/Parcel:recycle	()V
    //   97: aload 8
    //   99: invokevirtual 57	android/os/Parcel:recycle	()V
    //   102: ldc 21
    //   104: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: iconst_0
    //   109: istore_1
    //   110: goto -45 -> 65
    //   113: astore_3
    //   114: aload 9
    //   116: invokevirtual 57	android/os/Parcel:recycle	()V
    //   119: aload 8
    //   121: invokevirtual 57	android/os/Parcel:recycle	()V
    //   124: ldc 21
    //   126: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_3
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	a
    //   0	131	1	paramInt1	int
    //   0	131	2	paramInt2	int
    //   0	131	3	paramString1	java.lang.String
    //   0	131	4	paramInt3	int
    //   0	131	5	paramString2	java.lang.String
    //   0	131	6	paramBoolean	boolean
    //   1	62	7	i	int
    //   11	109	8	localParcel1	Parcel
    //   16	99	9	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   18	57	113	finally
    //   65	92	113	finally
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(132964);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeInt(paramInt3);
      localParcel1.writeInt(paramInt4);
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(132964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */