package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface f
  extends IInterface
{
  public abstract byte[] MC(String paramString);
  
  public abstract byte[] MD(String paramString);
  
  public abstract byte[] ME(String paramString);
  
  public abstract byte[] MF(String paramString);
  
  public abstract boolean MG(String paramString);
  
  public abstract void RL(String paramString);
  
  public abstract boolean RN(String paramString);
  
  public abstract void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt);
  
  public abstract byte[] aZa();
  
  public abstract boolean aZb();
  
  public abstract byte[] aZc();
  
  public abstract String aZd();
  
  public abstract byte[] aZe();
  
  public abstract void aZf();
  
  public abstract void aZg();
  
  public abstract int al(byte[] paramArrayOfByte);
  
  public abstract int am(byte[] paramArrayOfByte);
  
  public abstract void av(byte[] paramArrayOfByte);
  
  public abstract void aw(byte[] paramArrayOfByte);
  
  public abstract void ax(byte[] paramArrayOfByte);
  
  public abstract boolean ay(byte[] paramArrayOfByte);
  
  public abstract void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract int getUin();
  
  public abstract String getUsername();
  
  public abstract void h(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void i(String paramString, byte[] paramArrayOfByte);
  
  public abstract boolean isForeground();
  
  public abstract byte[] qe(int paramInt);
  
  public abstract void reset();
  
  public abstract void setForeground(boolean paramBoolean);
  
  public abstract void setUin(int paramInt);
  
  public abstract void setUsername(String paramString);
  
  public static abstract class a
    extends Binder
    implements f
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.IAccInfo_AIDL");
    }
    
    public static f bjv()
    {
      return a.jDQ;
    }
    
    public static f m(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.IAccInfo_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof f))) {
        return (f)localIInterface;
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
        av(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        aw(paramParcel1.createByteArray());
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
        paramParcel1 = qe(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = aZa();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = aZc();
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
        bool = aZb();
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
        paramParcel1 = MC(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        if (paramParcel1.readInt() != 0) {
          bool = true;
        }
        setForeground(bool);
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
        paramParcel1 = aZd();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        RL(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramInt1 = al(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = aZe();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramInt1 = am(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        h(paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        b(paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        ax(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        bool = ay(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = MD(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = MF(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        paramParcel1 = ME(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        bool = MG(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        aZf();
        paramParcel2.writeNoException();
        return true;
      case 31: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
        aZg();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
      bool = RN(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = n;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    static final class a
      implements f
    {
      public static f jDQ;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final byte[] MC(String paramString)
      {
        AppMethodBeat.i(132680);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(14, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            paramString = f.a.bjv().MC(paramString);
            return paramString;
          }
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
      
      public final byte[] MD(String paramString)
      {
        AppMethodBeat.i(132691);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(26, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            paramString = f.a.bjv().MD(paramString);
            return paramString;
          }
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
      
      public final byte[] ME(String paramString)
      {
        AppMethodBeat.i(132693);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(28, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            paramString = f.a.bjv().ME(paramString);
            return paramString;
          }
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
      
      public final byte[] MF(String paramString)
      {
        AppMethodBeat.i(132692);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(27, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            paramString = f.a.bjv().MF(paramString);
            return paramString;
          }
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
      
      public final boolean MG(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(132694);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(29, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            bool = f.a.bjv().MG(paramString);
            return bool;
          }
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
      
      public final void RL(String paramString)
      {
        AppMethodBeat.i(132684);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(18, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().RL(paramString);
            return;
          }
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
      
      public final boolean RN(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(132697);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(32, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            bool = f.a.bjv().RN(paramString);
            return bool;
          }
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
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt);
            return;
          }
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
      
      public final byte[] aZa()
      {
        AppMethodBeat.i(132675);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            arrayOfByte = f.a.bjv().aZa();
            return arrayOfByte;
          }
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
      
      public final boolean aZb()
      {
        boolean bool = false;
        AppMethodBeat.i(132678);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          if ((!this.mRemote.transact(12, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            bool = f.a.bjv().aZb();
            return bool;
          }
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
      
      public final byte[] aZc()
      {
        AppMethodBeat.i(132676);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          if ((!this.mRemote.transact(10, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            arrayOfByte = f.a.bjv().aZc();
            return arrayOfByte;
          }
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
      
      public final String aZd()
      {
        AppMethodBeat.i(132683);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          if ((!this.mRemote.transact(17, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            str = f.a.bjv().aZd();
            return str;
          }
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
      
      public final byte[] aZe()
      {
        AppMethodBeat.i(132686);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          if ((!this.mRemote.transact(20, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            arrayOfByte = f.a.bjv().aZe();
            return arrayOfByte;
          }
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
      
      public final void aZf()
      {
        AppMethodBeat.i(132695);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          if ((!this.mRemote.transact(30, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().aZf();
            return;
          }
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
      
      public final void aZg()
      {
        AppMethodBeat.i(132696);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          if ((!this.mRemote.transact(31, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().aZg();
            return;
          }
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
      
      public final int al(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(132685);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          if ((!this.mRemote.transact(19, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            i = f.a.bjv().al(paramArrayOfByte);
            return i;
          }
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
      
      public final int am(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(197092);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          if ((!this.mRemote.transact(21, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            i = f.a.bjv().am(paramArrayOfByte);
            return i;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(197092);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void av(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(132671);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().av(paramArrayOfByte);
            return;
          }
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
      
      public final void aw(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(132672);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().aw(paramArrayOfByte);
            return;
          }
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
      
      public final void ax(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(132689);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          if ((!this.mRemote.transact(24, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().ax(paramArrayOfByte);
            return;
          }
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
      
      public final boolean ay(byte[] paramArrayOfByte)
      {
        boolean bool = false;
        AppMethodBeat.i(132690);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeByteArray(paramArrayOfByte);
          if ((!this.mRemote.transact(25, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            bool = f.a.bjv().ay(paramArrayOfByte);
            return bool;
          }
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
          if ((!this.mRemote.transact(23, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().b(paramInt, paramArrayOfByte1, paramArrayOfByte2);
            return;
          }
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
      
      public final int getUin()
      {
        AppMethodBeat.i(132677);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          if ((!this.mRemote.transact(11, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            i = f.a.bjv().getUin();
            return i;
          }
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
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            str = f.a.bjv().getUsername();
            return str;
          }
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
          if ((!this.mRemote.transact(22, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().h(paramInt, paramArrayOfByte);
            return;
          }
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
          if ((!this.mRemote.transact(13, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().i(paramString, paramArrayOfByte);
            return;
          }
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
          if ((!this.mRemote.transact(16, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            bool = f.a.bjv().isForeground();
            return bool;
          }
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
      
      public final byte[] qe(int paramInt)
      {
        AppMethodBeat.i(132674);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            arrayOfByte = f.a.bjv().qe(paramInt);
            return arrayOfByte;
          }
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
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().reset();
            return;
          }
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
      
      public final void setForeground(boolean paramBoolean)
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
          if ((!this.mRemote.transact(15, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().setForeground(paramBoolean);
            return;
          }
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
      
      public final void setUin(int paramInt)
      {
        AppMethodBeat.i(132669);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().setUin(paramInt);
            return;
          }
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
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (f.a.bjv() != null))
          {
            f.a.bjv().setUsername(paramString);
            return;
          }
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
 * Qualified Name:     com.tencent.mm.network.f
 * JD-Core Version:    0.7.0.1
 */