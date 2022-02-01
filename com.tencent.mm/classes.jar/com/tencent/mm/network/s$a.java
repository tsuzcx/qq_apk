package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class s$a
  extends Binder
  implements s
{
  public s$a()
  {
    attachInterface(this, "com.tencent.mm.network.IWorkerCallback_AIDL");
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.network.IWorkerCallback_AIDL");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.network.IWorkerCallback_AIDL");
    boolean bool = check();
    paramParcel2.writeNoException();
    if (bool) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramParcel2.writeInt(paramInt1);
      return true;
    }
  }
  
  static final class a
    implements s
  {
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    /* Error */
    public final boolean check()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: ldc 24
      //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   10: astore_3
      //   11: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   14: astore 4
      //   16: aload_3
      //   17: ldc 38
      //   19: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   22: aload_0
      //   23: getfield 18	com/tencent/mm/network/s$a$a:mRemote	Landroid/os/IBinder;
      //   26: iconst_1
      //   27: aload_3
      //   28: aload 4
      //   30: iconst_0
      //   31: invokeinterface 48 5 0
      //   36: pop
      //   37: aload 4
      //   39: invokevirtual 51	android/os/Parcel:readException	()V
      //   42: aload 4
      //   44: invokevirtual 55	android/os/Parcel:readInt	()I
      //   47: istore_1
      //   48: iload_1
      //   49: ifeq +19 -> 68
      //   52: aload 4
      //   54: invokevirtual 58	android/os/Parcel:recycle	()V
      //   57: aload_3
      //   58: invokevirtual 58	android/os/Parcel:recycle	()V
      //   61: ldc 24
      //   63: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: iload_2
      //   67: ireturn
      //   68: iconst_0
      //   69: istore_2
      //   70: goto -18 -> 52
      //   73: astore 5
      //   75: aload 4
      //   77: invokevirtual 58	android/os/Parcel:recycle	()V
      //   80: aload_3
      //   81: invokevirtual 58	android/os/Parcel:recycle	()V
      //   84: ldc 24
      //   86: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   89: aload 5
      //   91: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	92	0	this	a
      //   47	2	1	i	int
      //   1	69	2	bool	boolean
      //   10	71	3	localParcel1	Parcel
      //   14	62	4	localParcel2	Parcel
      //   73	17	5	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   16	48	73	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.s.a
 * JD-Core Version:    0.7.0.1
 */