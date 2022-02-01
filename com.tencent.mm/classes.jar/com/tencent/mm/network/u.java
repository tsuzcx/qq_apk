package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface u
  extends IInterface
{
  public abstract boolean check();
  
  public static abstract class a
    extends Binder
    implements u
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.IWorkerCallback_AIDL");
    }
    
    public static u bto()
    {
      return a.muF;
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
      implements u
    {
      public static u muF;
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
        //   2: ldc 26
        //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: invokestatic 38	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_3
        //   11: invokestatic 38	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   14: astore 4
        //   16: aload_3
        //   17: ldc 40
        //   19: invokevirtual 44	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload_0
        //   23: getfield 20	com/tencent/mm/network/u$a$a:mRemote	Landroid/os/IBinder;
        //   26: iconst_1
        //   27: aload_3
        //   28: aload 4
        //   30: iconst_0
        //   31: invokeinterface 50 5 0
        //   36: ifne +34 -> 70
        //   39: invokestatic 54	com/tencent/mm/network/u$a:bto	()Lcom/tencent/mm/network/u;
        //   42: ifnull +28 -> 70
        //   45: invokestatic 54	com/tencent/mm/network/u$a:bto	()Lcom/tencent/mm/network/u;
        //   48: invokeinterface 56 1 0
        //   53: istore_2
        //   54: aload 4
        //   56: invokevirtual 59	android/os/Parcel:recycle	()V
        //   59: aload_3
        //   60: invokevirtual 59	android/os/Parcel:recycle	()V
        //   63: ldc 26
        //   65: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   68: iload_2
        //   69: ireturn
        //   70: aload 4
        //   72: invokevirtual 65	android/os/Parcel:readException	()V
        //   75: aload 4
        //   77: invokevirtual 69	android/os/Parcel:readInt	()I
        //   80: istore_1
        //   81: iload_1
        //   82: ifeq +19 -> 101
        //   85: aload 4
        //   87: invokevirtual 59	android/os/Parcel:recycle	()V
        //   90: aload_3
        //   91: invokevirtual 59	android/os/Parcel:recycle	()V
        //   94: ldc 26
        //   96: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   99: iload_2
        //   100: ireturn
        //   101: iconst_0
        //   102: istore_2
        //   103: goto -18 -> 85
        //   106: astore 5
        //   108: aload 4
        //   110: invokevirtual 59	android/os/Parcel:recycle	()V
        //   113: aload_3
        //   114: invokevirtual 59	android/os/Parcel:recycle	()V
        //   117: ldc 26
        //   119: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   122: aload 5
        //   124: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	125	0	this	a
        //   80	2	1	i	int
        //   1	102	2	bool	boolean
        //   10	104	3	localParcel1	Parcel
        //   14	95	4	localParcel2	Parcel
        //   106	17	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   16	54	106	finally
        //   70	81	106	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.u
 * JD-Core Version:    0.7.0.1
 */