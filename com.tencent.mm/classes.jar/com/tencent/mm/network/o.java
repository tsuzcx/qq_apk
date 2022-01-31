package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface o
  extends IInterface
{
  public abstract void reportKV(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public static abstract class a
    extends Binder
    implements o
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.IOnReportKV_AIDL");
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
        paramParcel2.writeString("com.tencent.mm.network.IOnReportKV_AIDL");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.IOnReportKV_AIDL");
      long l = paramParcel1.readLong();
      String str = paramParcel1.readString();
      boolean bool1;
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label108;
        }
      }
      label108:
      for (boolean bool2 = true;; bool2 = false)
      {
        reportKV(l, str, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    }
    
    static final class a
      implements o
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
      public final void reportKV(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 7
        //   3: ldc 24
        //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 8
        //   13: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   16: astore 9
        //   18: aload 8
        //   20: ldc 38
        //   22: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   25: aload 8
        //   27: lload_1
        //   28: invokevirtual 46	android/os/Parcel:writeLong	(J)V
        //   31: aload 8
        //   33: aload_3
        //   34: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   37: iload 4
        //   39: ifeq +66 -> 105
        //   42: iconst_1
        //   43: istore 6
        //   45: aload 8
        //   47: iload 6
        //   49: invokevirtual 52	android/os/Parcel:writeInt	(I)V
        //   52: iload 5
        //   54: ifeq +57 -> 111
        //   57: iload 7
        //   59: istore 6
        //   61: aload 8
        //   63: iload 6
        //   65: invokevirtual 52	android/os/Parcel:writeInt	(I)V
        //   68: aload_0
        //   69: getfield 18	com/tencent/mm/network/o$a$a:mRemote	Landroid/os/IBinder;
        //   72: iconst_1
        //   73: aload 8
        //   75: aload 9
        //   77: iconst_0
        //   78: invokeinterface 58 5 0
        //   83: pop
        //   84: aload 9
        //   86: invokevirtual 61	android/os/Parcel:readException	()V
        //   89: aload 9
        //   91: invokevirtual 64	android/os/Parcel:recycle	()V
        //   94: aload 8
        //   96: invokevirtual 64	android/os/Parcel:recycle	()V
        //   99: ldc 24
        //   101: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   104: return
        //   105: iconst_0
        //   106: istore 6
        //   108: goto -63 -> 45
        //   111: iconst_0
        //   112: istore 6
        //   114: goto -53 -> 61
        //   117: astore_3
        //   118: aload 9
        //   120: invokevirtual 64	android/os/Parcel:recycle	()V
        //   123: aload 8
        //   125: invokevirtual 64	android/os/Parcel:recycle	()V
        //   128: ldc 24
        //   130: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   133: aload_3
        //   134: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	135	0	this	a
        //   0	135	1	paramLong	long
        //   0	135	3	paramString	String
        //   0	135	4	paramBoolean1	boolean
        //   0	135	5	paramBoolean2	boolean
        //   43	70	6	i	int
        //   1	57	7	j	int
        //   11	113	8	localParcel1	Parcel
        //   16	103	9	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   18	37	117	finally
        //   45	52	117	finally
        //   61	89	117	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.o
 * JD-Core Version:    0.7.0.1
 */