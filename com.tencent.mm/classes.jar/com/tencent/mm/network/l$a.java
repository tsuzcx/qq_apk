package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class l$a
  extends Binder
  implements l
{
  public l$a()
  {
    attachInterface(this, "com.tencent.mm.network.IOnAutoAuth_AIDL");
  }
  
  public static l btk()
  {
    return a.muy;
  }
  
  public static l r(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.IOnAutoAuth_AIDL");
    if ((localIInterface != null) && ((localIInterface instanceof l))) {
      return (l)localIInterface;
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
    a(t.a.s(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
  
  static final class a
    implements l
  {
    public static l muy;
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final void a(t paramt, int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(132745);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IOnAutoAuth_AIDL");
        if (paramt != null) {}
        for (IBinder localIBinder = paramt.asBinder();; localIBinder = null)
        {
          localParcel1.writeStrongBinder(localIBinder);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeString(paramString);
          if ((this.mRemote.transact(1, localParcel1, localParcel2, 0)) || (l.a.btk() == null)) {
            break;
          }
          l.a.btk().a(paramt, paramInt1, paramInt2, paramString);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132745);
      }
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.l.a
 * JD-Core Version:    0.7.0.1
 */