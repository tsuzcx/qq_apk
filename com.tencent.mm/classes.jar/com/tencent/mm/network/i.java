package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface i
  extends IInterface
{
  public abstract int anj();
  
  public abstract void ank();
  
  public abstract long anl();
  
  public abstract boolean c(n paramn);
  
  public abstract boolean d(n paramn);
  
  public static abstract class a
    extends Binder
    implements i
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.INetworkEvent_AIDL");
    }
    
    public static i n(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.INetworkEvent_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof i))) {
        return (i)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      int j = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.network.INetworkEvent_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
        paramInt1 = anj();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
        bool = c(n.a.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
        bool = d(n.a.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
        ank();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
      long l = anl();
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    }
    
    static final class a
      implements i
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final int anj()
      {
        AppMethodBeat.i(58519);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58519);
        }
      }
      
      public final void ank()
      {
        AppMethodBeat.i(58522);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58522);
        }
      }
      
      public final long anl()
      {
        AppMethodBeat.i(58523);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(58523);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public final boolean c(n paramn)
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_3
        //   2: ldc 71
        //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 4
        //   12: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   15: astore 5
        //   17: aload 4
        //   19: ldc 36
        //   21: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   24: aload_1
        //   25: ifnull +66 -> 91
        //   28: aload_1
        //   29: invokeinterface 75 1 0
        //   34: astore_1
        //   35: aload 4
        //   37: aload_1
        //   38: invokevirtual 78	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   41: aload_0
        //   42: getfield 18	com/tencent/mm/network/i$a$a:mRemote	Landroid/os/IBinder;
        //   45: iconst_2
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 46 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 49	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 52	android/os/Parcel:readInt	()I
        //   67: istore_2
        //   68: iload_2
        //   69: ifeq +5 -> 74
        //   72: iconst_1
        //   73: istore_3
        //   74: aload 5
        //   76: invokevirtual 55	android/os/Parcel:recycle	()V
        //   79: aload 4
        //   81: invokevirtual 55	android/os/Parcel:recycle	()V
        //   84: ldc 71
        //   86: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   89: iload_3
        //   90: ireturn
        //   91: aconst_null
        //   92: astore_1
        //   93: goto -58 -> 35
        //   96: astore_1
        //   97: aload 5
        //   99: invokevirtual 55	android/os/Parcel:recycle	()V
        //   102: aload 4
        //   104: invokevirtual 55	android/os/Parcel:recycle	()V
        //   107: ldc 71
        //   109: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   112: aload_1
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	a
        //   0	114	1	paramn	n
        //   67	2	2	i	int
        //   1	89	3	bool	boolean
        //   10	93	4	localParcel1	Parcel
        //   15	83	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   17	24	96	finally
        //   28	35	96	finally
        //   35	68	96	finally
      }
      
      /* Error */
      public final boolean d(n paramn)
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_3
        //   2: ldc 80
        //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 4
        //   12: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   15: astore 5
        //   17: aload 4
        //   19: ldc 36
        //   21: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   24: aload_1
        //   25: ifnull +66 -> 91
        //   28: aload_1
        //   29: invokeinterface 75 1 0
        //   34: astore_1
        //   35: aload 4
        //   37: aload_1
        //   38: invokevirtual 78	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   41: aload_0
        //   42: getfield 18	com/tencent/mm/network/i$a$a:mRemote	Landroid/os/IBinder;
        //   45: iconst_3
        //   46: aload 4
        //   48: aload 5
        //   50: iconst_0
        //   51: invokeinterface 46 5 0
        //   56: pop
        //   57: aload 5
        //   59: invokevirtual 49	android/os/Parcel:readException	()V
        //   62: aload 5
        //   64: invokevirtual 52	android/os/Parcel:readInt	()I
        //   67: istore_2
        //   68: iload_2
        //   69: ifeq +5 -> 74
        //   72: iconst_1
        //   73: istore_3
        //   74: aload 5
        //   76: invokevirtual 55	android/os/Parcel:recycle	()V
        //   79: aload 4
        //   81: invokevirtual 55	android/os/Parcel:recycle	()V
        //   84: ldc 80
        //   86: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   89: iload_3
        //   90: ireturn
        //   91: aconst_null
        //   92: astore_1
        //   93: goto -58 -> 35
        //   96: astore_1
        //   97: aload 5
        //   99: invokevirtual 55	android/os/Parcel:recycle	()V
        //   102: aload 4
        //   104: invokevirtual 55	android/os/Parcel:recycle	()V
        //   107: ldc 80
        //   109: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   112: aload_1
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	a
        //   0	114	1	paramn	n
        //   67	2	2	i	int
        //   1	89	3	bool	boolean
        //   10	93	4	localParcel1	Parcel
        //   15	83	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   17	24	96	finally
        //   28	35	96	finally
        //   35	68	96	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.i
 * JD-Core Version:    0.7.0.1
 */