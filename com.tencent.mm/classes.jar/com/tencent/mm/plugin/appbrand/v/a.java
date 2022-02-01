package com.tencent.mm.plugin.appbrand.v;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
  extends IInterface
{
  public abstract void a(b paramb);
  
  public abstract int yo(int paramInt);
  
  public static abstract class a
    extends Binder
    implements a
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
    }
    
    public static a bUa()
    {
      return a.nFB;
    }
    
    public static a s(IBinder paramIBinder)
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
        paramInt1 = yo(paramParcel1.readInt());
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
      public static a nFB;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void a(b paramb)
      {
        AppMethodBeat.i(48000);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
          if (paramb != null) {}
          for (IBinder localIBinder = paramb.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(2, localParcel1, localParcel2, 0)) || (a.a.bUa() == null)) {
              break;
            }
            a.a.bUa().a(paramb);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(48000);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final int yo(int paramInt)
      {
        AppMethodBeat.i(47999);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (a.a.bUa() != null))
          {
            paramInt = a.a.bUa().yo(paramInt);
            return paramInt;
          }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.a
 * JD-Core Version:    0.7.0.1
 */