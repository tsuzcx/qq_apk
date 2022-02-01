package com.tencent.mm.network.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
  extends IInterface
{
  public abstract void C(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, boolean paramBoolean);
  
  public static abstract class a
    extends Binder
    implements b
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
    }
    
    public static b bRF()
    {
      return a.pqx;
    }
    
    public static b w(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof b))) {
        return (b)localIInterface;
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
        paramParcel2.writeString("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        String str1 = paramParcel1.readString();
        int i = paramParcel1.readInt();
        String str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          a(paramInt1, paramInt2, str1, i, str2, bool);
          paramParcel2.writeNoException();
          return true;
        }
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
      C(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements b
    {
      public static b pqx;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void C(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
      {
        AppMethodBeat.i(132964);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          localParcel1.writeInt(paramInt4);
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (b.a.bRF() != null))
          {
            b.a.bRF().C(paramInt1, paramInt2, paramInt3, paramInt4);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132964);
        }
      }
      
      public final void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, boolean paramBoolean)
      {
        AppMethodBeat.i(132963);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeString(paramString1);
          localParcel1.writeInt(paramInt3);
          localParcel1.writeString(paramString2);
          if (paramBoolean) {}
          for (int i = 1;; i = 0)
          {
            localParcel1.writeInt(i);
            if ((this.mRemote.transact(1, localParcel1, localParcel2, 0)) || (b.a.bRF() == null)) {
              break;
            }
            b.a.bRF().a(paramInt1, paramInt2, paramString1, paramInt3, paramString2, paramBoolean);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132963);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.a.b
 * JD-Core Version:    0.7.0.1
 */