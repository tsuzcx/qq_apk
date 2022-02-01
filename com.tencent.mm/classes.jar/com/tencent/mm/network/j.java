package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface j
  extends IInterface
{
  public abstract void a(r paramr, int paramInt1, int paramInt2, String paramString);
  
  public static abstract class a
    extends Binder
    implements j
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.IOnAutoAuth_AIDL");
    }
    
    public static j p(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.IOnAutoAuth_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof j))) {
        return (j)localIInterface;
      }
      return new a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.mm.network.IOnAutoAuth_AIDL");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.IOnAutoAuth_AIDL");
      a(r.a.q(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements j
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public final void a(r paramr, int paramInt1, int paramInt2, String paramString)
      {
        // Byte code:
        //   0: ldc 21
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 6
        //   15: aload 5
        //   17: ldc 35
        //   19: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload_1
        //   23: ifnull +72 -> 95
        //   26: aload_1
        //   27: invokeinterface 45 1 0
        //   32: astore_1
        //   33: aload 5
        //   35: aload_1
        //   36: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: iload_2
        //   42: invokevirtual 51	android/os/Parcel:writeInt	(I)V
        //   45: aload 5
        //   47: iload_3
        //   48: invokevirtual 51	android/os/Parcel:writeInt	(I)V
        //   51: aload 5
        //   53: aload 4
        //   55: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/tencent/mm/network/j$a$a:mRemote	Landroid/os/IBinder;
        //   62: iconst_1
        //   63: aload 5
        //   65: aload 6
        //   67: iconst_0
        //   68: invokeinterface 60 5 0
        //   73: pop
        //   74: aload 6
        //   76: invokevirtual 63	android/os/Parcel:readException	()V
        //   79: aload 6
        //   81: invokevirtual 66	android/os/Parcel:recycle	()V
        //   84: aload 5
        //   86: invokevirtual 66	android/os/Parcel:recycle	()V
        //   89: ldc 21
        //   91: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   94: return
        //   95: aconst_null
        //   96: astore_1
        //   97: goto -64 -> 33
        //   100: astore_1
        //   101: aload 6
        //   103: invokevirtual 66	android/os/Parcel:recycle	()V
        //   106: aload 5
        //   108: invokevirtual 66	android/os/Parcel:recycle	()V
        //   111: ldc 21
        //   113: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   116: aload_1
        //   117: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	118	0	this	a
        //   0	118	1	paramr	r
        //   0	118	2	paramInt1	int
        //   0	118	3	paramInt2	int
        //   0	118	4	paramString	String
        //   8	99	5	localParcel1	Parcel
        //   13	89	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	22	100	finally
        //   26	33	100	finally
        //   33	79	100	finally
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.j
 * JD-Core Version:    0.7.0.1
 */