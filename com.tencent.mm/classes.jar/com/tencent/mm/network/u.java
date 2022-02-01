package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface u
  extends IInterface
{
  public abstract void a(boolean paramBoolean1, float paramFloat1, float paramFloat2, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(boolean paramBoolean1, float paramFloat1, float paramFloat2, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean3, int paramInt4, int paramInt5, int paramInt6);
  
  public static abstract class a
    extends Binder
    implements u
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.ISpeedTestCallback_AIDL");
    }
    
    public static u bQX()
    {
      return a.pnZ;
    }
    
    public static u v(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.ISpeedTestCallback_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof u))) {
        return (u)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      boolean bool1;
      float f1;
      float f2;
      boolean bool2;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.network.ISpeedTestCallback_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.network.ISpeedTestCallback_AIDL");
        if (paramParcel1.readInt() != 0)
        {
          bool1 = true;
          f1 = paramParcel1.readFloat();
          f2 = paramParcel1.readFloat();
          if (paramParcel1.readInt() == 0) {
            break label128;
          }
        }
        label128:
        for (bool2 = true;; bool2 = false)
        {
          a(bool1, f1, f2, bool2, paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
          bool1 = false;
          break;
        }
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.ISpeedTestCallback_AIDL");
      label172:
      int i;
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        f1 = paramParcel1.readFloat();
        f2 = paramParcel1.readFloat();
        if (paramParcel1.readInt() == 0) {
          break label242;
        }
        bool2 = true;
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        i = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          break label248;
        }
      }
      label242:
      label248:
      for (boolean bool3 = true;; bool3 = false)
      {
        a(bool1, f1, f2, bool2, paramInt1, paramInt2, i, bool3, paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
        bool2 = false;
        break label172;
      }
    }
    
    static final class a
      implements u
    {
      public static u pnZ;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void a(boolean paramBoolean1, float paramFloat1, float paramFloat2, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
      {
        AppMethodBeat.i(241150);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.ISpeedTestCallback_AIDL");
          if (paramBoolean1)
          {
            i = 1;
            localParcel1.writeInt(i);
            localParcel1.writeFloat(paramFloat1);
            localParcel1.writeFloat(paramFloat2);
            if (!paramBoolean2) {
              break label149;
            }
          }
          label149:
          for (int i = 1;; i = 0)
          {
            localParcel1.writeInt(i);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeInt(paramInt3);
            if ((this.mRemote.transact(1, localParcel1, localParcel2, 0)) || (u.a.bQX() == null)) {
              break label155;
            }
            u.a.bQX().a(paramBoolean1, paramFloat1, paramFloat2, paramBoolean2, paramInt1, paramInt2, paramInt3);
            return;
            i = 0;
            break;
          }
          label155:
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(241150);
        }
      }
      
      public final void a(boolean paramBoolean1, float paramFloat1, float paramFloat2, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean3, int paramInt4, int paramInt5, int paramInt6)
      {
        AppMethodBeat.i(241155);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.ISpeedTestCallback_AIDL");
          if (paramBoolean1)
          {
            i = 1;
            localParcel1.writeInt(i);
            localParcel1.writeFloat(paramFloat1);
            localParcel1.writeFloat(paramFloat2);
            if (!paramBoolean2) {
              break label193;
            }
            i = 1;
            label56:
            localParcel1.writeInt(i);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeInt(paramInt3);
            if (!paramBoolean3) {
              break label199;
            }
          }
          label193:
          label199:
          for (int i = 1;; i = 0)
          {
            localParcel1.writeInt(i);
            localParcel1.writeInt(paramInt4);
            localParcel1.writeInt(paramInt5);
            localParcel1.writeInt(paramInt6);
            if ((this.mRemote.transact(2, localParcel1, localParcel2, 0)) || (u.a.bQX() == null)) {
              break label205;
            }
            u.a.bQX().a(paramBoolean1, paramFloat1, paramFloat2, paramBoolean2, paramInt1, paramInt2, paramInt3, paramBoolean3, paramInt4, paramInt5, paramInt6);
            return;
            i = 0;
            break;
            i = 0;
            break label56;
          }
          label205:
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(241155);
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
 * Qualified Name:     com.tencent.mm.network.u
 * JD-Core Version:    0.7.0.1
 */