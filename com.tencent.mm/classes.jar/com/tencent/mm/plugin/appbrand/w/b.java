package com.tencent.mm.plugin.appbrand.w;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
  extends IInterface
{
  public abstract void CX(int paramInt);
  
  public abstract void y(IBinder paramIBinder);
  
  public static abstract class a
    extends Binder
    implements b
  {
    public static b cIe()
    {
      return a.tMx;
    }
    
    public static b z(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCallback");
      if ((localIInterface != null) && ((localIInterface instanceof b))) {
        return (b)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCallback");
        CX(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCallback");
      y(paramParcel1.readStrongBinder());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements b
    {
      public static b tMx;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void CX(int paramInt)
      {
        AppMethodBeat.i(48001);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCallback");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (b.a.cIe() != null))
          {
            b.a.cIe().CX(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(48001);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void y(IBinder paramIBinder)
      {
        AppMethodBeat.i(317297);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCallback");
          localParcel1.writeStrongBinder(paramIBinder);
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (b.a.cIe() != null))
          {
            b.a.cIe().y(paramIBinder);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(317297);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.b
 * JD-Core Version:    0.7.0.1
 */