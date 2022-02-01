package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class p$a
  extends Binder
  implements p
{
  private static final String DESCRIPTOR = "com.tencent.mm.network.IOnNetworkChange_AIDL";
  static final int TRANSACTION_onNetworkChange = 1;
  
  public p$a()
  {
    attachInterface(this, "com.tencent.mm.network.IOnNetworkChange_AIDL");
  }
  
  public static p asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.IOnNetworkChange_AIDL");
    if ((localIInterface != null) && ((localIInterface instanceof p))) {
      return (p)localIInterface;
    }
    return new a(paramIBinder);
  }
  
  public static p getDefaultImpl()
  {
    return a.pnU;
  }
  
  public static boolean setDefaultImpl(p paramp)
  {
    if (a.pnU != null) {
      throw new IllegalStateException("setDefaultImpl() called twice");
    }
    if (paramp != null)
    {
      a.pnU = paramp;
      return true;
    }
    return false;
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
      paramParcel2.writeString("com.tencent.mm.network.IOnNetworkChange_AIDL");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.network.IOnNetworkChange_AIDL");
    onNetworkChange(paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
  
  static final class a
    implements p
  {
    public static p pnU;
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    public final void onNetworkChange(int paramInt)
    {
      AppMethodBeat.i(132747);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IOnNetworkChange_AIDL");
        localParcel1.writeInt(paramInt);
        if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (p.a.getDefaultImpl() != null))
        {
          p.a.getDefaultImpl().onNetworkChange(paramInt);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132747);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.p.a
 * JD-Core Version:    0.7.0.1
 */