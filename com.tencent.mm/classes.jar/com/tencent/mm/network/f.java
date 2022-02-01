package com.tencent.mm.network;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface f
  extends IInterface
{
  public abstract byte[] LW(String paramString);
  
  public abstract byte[] LX(String paramString);
  
  public abstract byte[] LY(String paramString);
  
  public abstract byte[] LZ(String paramString);
  
  public abstract boolean Ma(String paramString);
  
  public abstract void Rp(String paramString);
  
  public abstract boolean Rr(String paramString);
  
  public abstract void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt);
  
  public abstract void aG(byte[] paramArrayOfByte);
  
  public abstract void aH(byte[] paramArrayOfByte);
  
  public abstract void aI(byte[] paramArrayOfByte);
  
  public abstract boolean aJ(byte[] paramArrayOfByte);
  
  public abstract int av(byte[] paramArrayOfByte);
  
  public abstract int aw(byte[] paramArrayOfByte);
  
  public abstract void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract byte[] bFZ();
  
  public abstract boolean bGa();
  
  public abstract byte[] bGb();
  
  public abstract String bGc();
  
  public abstract byte[] bGd();
  
  public abstract void bGe();
  
  public abstract void bGf();
  
  public abstract int getUin();
  
  public abstract String getUsername();
  
  public abstract void i(int paramInt, byte[] paramArrayOfByte);
  
  public abstract boolean isForeground();
  
  public abstract void k(String paramString, byte[] paramArrayOfByte);
  
  public abstract void reset();
  
  public abstract byte[] sA(int paramInt);
  
  public abstract void setForeground(boolean paramBoolean);
  
  public abstract void setUin(int paramInt);
  
  public abstract void setUsername(String paramString);
  
  static final class a$a
    implements f
  {
    public static f pnN;
    private IBinder mRemote;
    
    a$a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final byte[] LW(String paramString)
    {
      AppMethodBeat.i(132680);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(14, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          paramString = f.a.bQI().LW(paramString);
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
    
    public final byte[] LX(String paramString)
    {
      AppMethodBeat.i(132691);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(26, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          paramString = f.a.bQI().LX(paramString);
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
    
    public final byte[] LY(String paramString)
    {
      AppMethodBeat.i(132693);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(28, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          paramString = f.a.bQI().LY(paramString);
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
    
    public final byte[] LZ(String paramString)
    {
      AppMethodBeat.i(132692);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(27, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          paramString = f.a.bQI().LZ(paramString);
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
    
    public final boolean Ma(String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(132694);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(29, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          bool = f.a.bQI().Ma(paramString);
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
    
    public final void Rp(String paramString)
    {
      AppMethodBeat.i(132684);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(18, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().Rp(paramString);
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
    
    public final boolean Rr(String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(132697);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(32, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          bool = f.a.bQI().Rr(paramString);
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
        if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt);
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
    
    public final void aG(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132671);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeByteArray(paramArrayOfByte);
        if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().aG(paramArrayOfByte);
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
    
    public final void aH(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132672);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeByteArray(paramArrayOfByte);
        if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().aH(paramArrayOfByte);
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
    
    public final void aI(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132689);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeByteArray(paramArrayOfByte);
        if ((!this.mRemote.transact(24, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().aI(paramArrayOfByte);
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
    
    public final boolean aJ(byte[] paramArrayOfByte)
    {
      boolean bool = false;
      AppMethodBeat.i(132690);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeByteArray(paramArrayOfByte);
        if ((!this.mRemote.transact(25, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          bool = f.a.bQI().aJ(paramArrayOfByte);
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
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    public final int av(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132685);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeByteArray(paramArrayOfByte);
        if ((!this.mRemote.transact(19, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          i = f.a.bQI().av(paramArrayOfByte);
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
    
    public final int aw(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(241195);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeByteArray(paramArrayOfByte);
        if ((!this.mRemote.transact(21, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          i = f.a.bQI().aw(paramArrayOfByte);
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
        AppMethodBeat.o(241195);
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
        if ((!this.mRemote.transact(23, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().b(paramInt, paramArrayOfByte1, paramArrayOfByte2);
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
    
    public final byte[] bFZ()
    {
      AppMethodBeat.i(132675);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          arrayOfByte = f.a.bQI().bFZ();
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
    
    public final boolean bGa()
    {
      boolean bool = false;
      AppMethodBeat.i(132678);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        if ((!this.mRemote.transact(12, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          bool = f.a.bQI().bGa();
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
    
    public final byte[] bGb()
    {
      AppMethodBeat.i(132676);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        if ((!this.mRemote.transact(10, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          arrayOfByte = f.a.bQI().bGb();
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
    
    public final String bGc()
    {
      AppMethodBeat.i(132683);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        if ((!this.mRemote.transact(17, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          str = f.a.bQI().bGc();
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
    
    public final byte[] bGd()
    {
      AppMethodBeat.i(132686);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        if ((!this.mRemote.transact(20, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          arrayOfByte = f.a.bQI().bGd();
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
    
    public final void bGe()
    {
      AppMethodBeat.i(132695);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        if ((!this.mRemote.transact(30, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().bGe();
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
    
    public final void bGf()
    {
      AppMethodBeat.i(132696);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        if ((!this.mRemote.transact(31, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().bGf();
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
    
    public final int getUin()
    {
      AppMethodBeat.i(132677);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        if ((!this.mRemote.transact(11, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          i = f.a.bQI().getUin();
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
        if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          str = f.a.bQI().getUsername();
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
    
    public final void i(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132687);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeInt(paramInt);
        localParcel1.writeByteArray(paramArrayOfByte);
        if ((!this.mRemote.transact(22, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().i(paramInt, paramArrayOfByte);
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
    
    public final boolean isForeground()
    {
      boolean bool = false;
      AppMethodBeat.i(132682);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        if ((!this.mRemote.transact(16, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          bool = f.a.bQI().isForeground();
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
    
    public final void k(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132679);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeString(paramString);
        localParcel1.writeByteArray(paramArrayOfByte);
        if ((!this.mRemote.transact(13, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().k(paramString, paramArrayOfByte);
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
    
    public final void reset()
    {
      AppMethodBeat.i(132667);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().reset();
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
    
    public final byte[] sA(int paramInt)
    {
      AppMethodBeat.i(132674);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
        localParcel1.writeInt(paramInt);
        if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          arrayOfByte = f.a.bQI().sA(paramInt);
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
        if ((!this.mRemote.transact(15, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().setForeground(paramBoolean);
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
        if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().setUin(paramInt);
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
        if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (f.a.bQI() != null))
        {
          f.a.bQI().setUsername(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.network.f
 * JD-Core Version:    0.7.0.1
 */