package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface d
  extends IInterface
{
  public abstract byte[] Dm(String paramString);
  
  public abstract byte[] Dn(String paramString);
  
  public abstract byte[] Do(String paramString);
  
  public abstract byte[] Dp(String paramString);
  
  public abstract boolean Dq(String paramString);
  
  public abstract void In(String paramString);
  
  public abstract boolean Ip(String paramString);
  
  public abstract int X(byte[] paramArrayOfByte);
  
  public abstract void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt);
  
  public abstract byte[] aEV();
  
  public abstract boolean aEW();
  
  public abstract byte[] aEX();
  
  public abstract String aEY();
  
  public abstract byte[] aEZ();
  
  public abstract void aFa();
  
  public abstract void aFb();
  
  public abstract void ag(byte[] paramArrayOfByte);
  
  public abstract void ah(byte[] paramArrayOfByte);
  
  public abstract void ai(byte[] paramArrayOfByte);
  
  public abstract boolean aj(byte[] paramArrayOfByte);
  
  public abstract void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract void eE(boolean paramBoolean);
  
  public abstract int getUin();
  
  public abstract String getUsername();
  
  public abstract void h(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void i(String paramString, byte[] paramArrayOfByte);
  
  public abstract boolean isForeground();
  
  public abstract byte[] mO(int paramInt);
  
  public abstract void reset();
  
  public abstract void setUin(int paramInt);
  
  public abstract void setUsername(String paramString);
  
  public static abstract class a
    extends Binder
    implements d
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.IAccInfo_AIDL");
    }
    
    public static d l(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.IAccInfo_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof d))) {
        return (d)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      boolean bool = false;
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i = 0;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.network.IAccInfo_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        reset();
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        a(paramParcel1.createByteArray(), paramParcel1.createByteArray(), paramParcel1.createByteArray(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        setUin(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        setUsername(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        ag(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        ah(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = getUsername();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = mO(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = aEV();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = aEX();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramInt1 = getUin();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        bool = aEW();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        i(paramParcel1.readString(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = Dm(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        if (paramParcel1.readInt() != 0) {
          bool = true;
        }
        eE(bool);
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        bool = isForeground();
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = aEY();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        In(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramInt1 = X(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = aEZ();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        h(paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        b(paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        ai(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        bool = aj(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = Dn(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = Dp(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = Do(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        bool = Dq(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        aFa();
        paramParcel2.writeNoException();
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        aFb();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      bool = Ip(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = n;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    static final class a
      implements d
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final byte[] Dm(String paramString)
      {
        AppMethodBeat.i(132680);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.createByteArray();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132680);
        }
      }
      
      public final byte[] Dn(String paramString)
      {
        AppMethodBeat.i(132691);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(25, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.createByteArray();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132691);
        }
      }
      
      public final byte[] Do(String paramString)
      {
        AppMethodBeat.i(132693);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(27, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.createByteArray();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132693);
        }
      }
      
      public final byte[] Dp(String paramString)
      {
        AppMethodBeat.i(132692);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(26, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.createByteArray();
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132692);
        }
      }
      
      public final boolean Dq(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(132694);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(28, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132694);
        }
      }
      
      public final void In(String paramString)
      {
        AppMethodBeat.i(132684);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132684);
        }
      }
      
      public final boolean Ip(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(132697);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(31, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132697);
        }
      }
      
      public final int X(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(132685);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132685);
        }
      }
      
      public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
      {
        AppMethodBeat.i(132668);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte1);
          localParcel1.writeByteArray(paramArrayOfByte2);
          localParcel1.writeByteArray(paramArrayOfByte3);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132668);
        }
      }
      
      public final byte[] aEV()
      {
        AppMethodBeat.i(132675);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          byte[] arrayOfByte = localParcel2.createByteArray();
          return arrayOfByte;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132675);
        }
      }
      
      public final boolean aEW()
      {
        boolean bool = false;
        AppMethodBeat.i(132678);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132678);
        }
      }
      
      public final byte[] aEX()
      {
        AppMethodBeat.i(132676);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          byte[] arrayOfByte = localParcel2.createByteArray();
          return arrayOfByte;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132676);
        }
      }
      
      public final String aEY()
      {
        AppMethodBeat.i(132683);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          this.mRemote.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132683);
        }
      }
      
      public final byte[] aEZ()
      {
        AppMethodBeat.i(132686);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          this.mRemote.transact(20, localParcel1, localParcel2, 0);
          localParcel2.readException();
          byte[] arrayOfByte = localParcel2.createByteArray();
          return arrayOfByte;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132686);
        }
      }
      
      public final void aFa()
      {
        AppMethodBeat.i(132695);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          this.mRemote.transact(29, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132695);
        }
      }
      
      public final void aFb()
      {
        AppMethodBeat.i(132696);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          this.mRemote.transact(30, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132696);
        }
      }
      
      public final void ag(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(132671);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132671);
        }
      }
      
      public final void ah(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(132672);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132672);
        }
      }
      
      public final void ai(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(132689);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(23, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132689);
        }
      }
      
      public final boolean aj(byte[] paramArrayOfByte)
      {
        boolean bool = false;
        AppMethodBeat.i(132690);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(24, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132690);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
      {
        AppMethodBeat.i(132688);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeInt(paramInt);
          localParcel1.writeByteArray(paramArrayOfByte1);
          localParcel1.writeByteArray(paramArrayOfByte2);
          this.mRemote.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132688);
        }
      }
      
      public final void eE(boolean paramBoolean)
      {
        int i = 0;
        AppMethodBeat.i(132681);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132681);
        }
      }
      
      public final int getUin()
      {
        AppMethodBeat.i(132677);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132677);
        }
      }
      
      public final String getUsername()
      {
        AppMethodBeat.i(132673);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132673);
        }
      }
      
      public final void h(int paramInt, byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(132687);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeInt(paramInt);
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132687);
        }
      }
      
      public final void i(String paramString, byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(132679);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132679);
        }
      }
      
      public final boolean isForeground()
      {
        boolean bool = false;
        AppMethodBeat.i(132682);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132682);
        }
      }
      
      public final byte[] mO(int paramInt)
      {
        AppMethodBeat.i(132674);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          byte[] arrayOfByte = localParcel2.createByteArray();
          return arrayOfByte;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132674);
        }
      }
      
      public final void reset()
      {
        AppMethodBeat.i(132667);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132667);
        }
      }
      
      public final void setUin(int paramInt)
      {
        AppMethodBeat.i(132669);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132669);
        }
      }
      
      public final void setUsername(String paramString)
      {
        AppMethodBeat.i(132670);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132670);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.d
 * JD-Core Version:    0.7.0.1
 */