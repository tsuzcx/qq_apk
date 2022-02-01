package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface l
  extends IInterface
{
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, String paramString, r paramr, byte[] paramArrayOfByte);
  
  public static abstract class a
    extends Binder
    implements l
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.IOnGYNetEnd_AIDL");
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
        paramParcel2.writeString("com.tencent.mm.network.IOnGYNetEnd_AIDL");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.IOnGYNetEnd_AIDL");
      a(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString(), r.a.q(paramParcel1.readStrongBinder()), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements l
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, r paramr, byte[] paramArrayOfByte)
      {
        // Byte code:
        //   0: ldc 21
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 8
        //   15: aload 7
        //   17: ldc 35
        //   19: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload 7
        //   24: iload_1
        //   25: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   28: aload 7
        //   30: iload_2
        //   31: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   34: aload 7
        //   36: iload_3
        //   37: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   40: aload 7
        //   42: aload 4
        //   44: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   47: aload 5
        //   49: ifnull +63 -> 112
        //   52: aload 5
        //   54: invokeinterface 51 1 0
        //   59: astore 4
        //   61: aload 7
        //   63: aload 4
        //   65: invokevirtual 54	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   68: aload 7
        //   70: aload 6
        //   72: invokevirtual 58	android/os/Parcel:writeByteArray	([B)V
        //   75: aload_0
        //   76: getfield 18	com/tencent/mm/network/l$a$a:mRemote	Landroid/os/IBinder;
        //   79: iconst_1
        //   80: aload 7
        //   82: aload 8
        //   84: iconst_0
        //   85: invokeinterface 64 5 0
        //   90: pop
        //   91: aload 8
        //   93: invokevirtual 67	android/os/Parcel:readException	()V
        //   96: aload 8
        //   98: invokevirtual 70	android/os/Parcel:recycle	()V
        //   101: aload 7
        //   103: invokevirtual 70	android/os/Parcel:recycle	()V
        //   106: ldc 21
        //   108: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   111: return
        //   112: aconst_null
        //   113: astore 4
        //   115: goto -54 -> 61
        //   118: astore 4
        //   120: aload 8
        //   122: invokevirtual 70	android/os/Parcel:recycle	()V
        //   125: aload 7
        //   127: invokevirtual 70	android/os/Parcel:recycle	()V
        //   130: ldc 21
        //   132: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   135: aload 4
        //   137: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	138	0	this	a
        //   0	138	1	paramInt1	int
        //   0	138	2	paramInt2	int
        //   0	138	3	paramInt3	int
        //   0	138	4	paramString	String
        //   0	138	5	paramr	r
        //   0	138	6	paramArrayOfByte	byte[]
        //   8	118	7	localParcel1	Parcel
        //   13	108	8	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	47	118	finally
        //   52	61	118	finally
        //   61	96	118	finally
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.l
 * JD-Core Version:    0.7.0.1
 */