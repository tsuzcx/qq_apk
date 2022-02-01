package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface d
  extends IInterface
{
  public abstract byte[] DO(String paramString);
  
  public abstract byte[] DP(String paramString);
  
  public abstract byte[] DQ(String paramString);
  
  public abstract byte[] DR(String paramString);
  
  public abstract boolean DS(String paramString);
  
  public abstract void IP(String paramString);
  
  public abstract boolean IR(String paramString);
  
  public abstract int X(byte[] paramArrayOfByte);
  
  public abstract void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt);
  
  public abstract byte[] aFl();
  
  public abstract boolean aFm();
  
  public abstract byte[] aFn();
  
  public abstract String aFo();
  
  public abstract byte[] aFp();
  
  public abstract void aFq();
  
  public abstract void aFr();
  
  public abstract void ag(byte[] paramArrayOfByte);
  
  public abstract void ah(byte[] paramArrayOfByte);
  
  public abstract void ai(byte[] paramArrayOfByte);
  
  public abstract boolean aj(byte[] paramArrayOfByte);
  
  public abstract void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract void eG(boolean paramBoolean);
  
  public abstract int getUin();
  
  public abstract String getUsername();
  
  public abstract void h(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void i(String paramString, byte[] paramArrayOfByte);
  
  public abstract boolean isForeground();
  
  public abstract byte[] mR(int paramInt);
  
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
    
    public static d m(IBinder paramIBinder)
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
        paramParcel1 = mR(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = aFl();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = aFn();
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
        bool = aFm();
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
        paramParcel1 = DO(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        if (paramParcel1.readInt() != 0) {
          bool = true;
        }
        eG(bool);
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
        paramParcel1 = aFo();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        IP(paramParcel1.readString());
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
        paramParcel1 = aFp();
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
        paramParcel1 = DP(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = DR(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = DQ(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        bool = DS(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        aFq();
        paramParcel2.writeNoException();
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        aFr();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      bool = IR(paramParcel1.readString());
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
      
      public final byte[] DO(String paramString)
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
      
      public final byte[] DP(String paramString)
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
      
      public final byte[] DQ(String paramString)
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
      
      public final byte[] DR(String paramString)
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
      
      public final boolean DS(String paramString)
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
      
      public final void IP(String paramString)
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
      
      public final boolean IR(String paramString)
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
      
      public final byte[] aFl()
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
      
      public final boolean aFm()
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
      
      public final byte[] aFn()
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
      
      public final String aFo()
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
      
      public final byte[] aFp()
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
      
      public final void aFq()
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
      
      public final void aFr()
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
      
      public final void eG(boolean paramBoolean)
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
      
      public final byte[] mR(int paramInt)
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