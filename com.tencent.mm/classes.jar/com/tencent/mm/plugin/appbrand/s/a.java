package com.tencent.mm.plugin.appbrand.s;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
  extends IInterface
{
  public abstract void a(b paramb);
  
  public abstract int tN(int paramInt);
  
  public static abstract class a
    extends Binder
    implements a
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
    }
    
    public static a r(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        return (a)localIInterface;
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
        paramParcel2.writeString("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
        paramInt1 = tN(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = null;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        IInterface localIInterface = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCallback");
        if ((localIInterface != null) && ((localIInterface instanceof b))) {
          paramParcel1 = (b)localIInterface;
        } else {
          paramParcel1 = new b.a.a(paramParcel1);
        }
      }
    }
    
    static final class a
      implements a
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public final void a(b paramb)
      {
        // Byte code:
        //   0: ldc 21
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 35
        //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +47 -> 67
        //   23: aload_1
        //   24: invokeinterface 45 1 0
        //   29: astore_1
        //   30: aload_2
        //   31: aload_1
        //   32: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/tencent/mm/plugin/appbrand/s/a$a$a:mRemote	Landroid/os/IBinder;
        //   39: iconst_2
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 54 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 57	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 60	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 60	android/os/Parcel:recycle	()V
        //   61: ldc 21
        //   63: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   66: return
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -39 -> 30
        //   72: astore_1
        //   73: aload_3
        //   74: invokevirtual 60	android/os/Parcel:recycle	()V
        //   77: aload_2
        //   78: invokevirtual 60	android/os/Parcel:recycle	()V
        //   81: ldc 21
        //   83: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   86: aload_1
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	a
        //   0	88	1	paramb	b
        //   8	70	2	localParcel1	Parcel
        //   12	62	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	72	finally
        //   23	30	72	finally
        //   30	53	72	finally
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final int tN(int paramInt)
      {
        AppMethodBeat.i(47999);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(47999);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a
 * JD-Core Version:    0.7.0.1
 */