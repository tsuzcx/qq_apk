package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.h.a;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.a;

public abstract interface t
  extends IInterface
{
  public abstract void a(f paramf, l paraml, int paramInt1, int paramInt2);
  
  public abstract void a(l paraml, int paramInt1, int paramInt2);
  
  public abstract void a(l paraml, int paramInt1, int paramInt2, String paramString);
  
  public abstract h bGo();
  
  public abstract i bGp();
  
  public abstract int bGq();
  
  public abstract boolean bGr();
  
  public abstract String getCgiVerifyPrivateKey();
  
  public abstract String getCgiVerifyPublicKey();
  
  public abstract boolean getIsLongPolling();
  
  public abstract boolean getIsUserCmd();
  
  public abstract int getLongPollingTimeout();
  
  public abstract int getMMReqRespHash();
  
  public abstract int getNewExtFlags();
  
  public abstract int getOptions();
  
  public abstract int getTimeOut();
  
  public abstract byte[] getTransHeader();
  
  public abstract int getType();
  
  public abstract String getUri();
  
  public abstract boolean isSingleSession();
  
  public abstract void setConnectionInfo(String paramString);
  
  public static abstract class a
    extends Binder
    implements t
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.IReqResp_AIDL");
    }
    
    public static t bQW()
    {
      return a.pnY;
    }
    
    public static t u(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.IReqResp_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof t))) {
        return (t)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      i locali = null;
      h localh = null;
      int j = 0;
      int k = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.network.IReqResp_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = getType();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramParcel1 = getUri();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        locali = bGp();
        paramParcel2.writeNoException();
        paramParcel1 = localh;
        if (locali != null) {
          paramParcel1 = locali.asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        localh = bGo();
        paramParcel2.writeNoException();
        paramParcel1 = locali;
        if (localh != null) {
          paramParcel1 = localh.asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        a(l.a.t(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = getMMReqRespHash();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        bool = getIsUserCmd();
        paramParcel2.writeNoException();
        if (bool) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = getOptions();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        setConnectionInfo(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        a(l.a.t(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        a(f.a.q(paramParcel1.readStrongBinder()), l.a.t(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = bGq();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = getTimeOut();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        bool = isSingleSession();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        bool = getIsLongPolling();
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        bool = bGr();
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = getLongPollingTimeout();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = getNewExtFlags();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramParcel1 = getTransHeader();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramParcel1 = getCgiVerifyPublicKey();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
      paramParcel1 = getCgiVerifyPrivateKey();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }
    
    static final class a
      implements t
    {
      public static t pnY;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void a(f paramf, l paraml, int paramInt1, int paramInt2)
      {
        Object localObject2 = null;
        AppMethodBeat.i(132767);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if (paramf != null) {}
          for (Object localObject1 = paramf.asBinder();; localObject1 = null)
          {
            localParcel1.writeStrongBinder((IBinder)localObject1);
            localObject1 = localObject2;
            if (paraml != null) {
              localObject1 = paraml.asBinder();
            }
            localParcel1.writeStrongBinder((IBinder)localObject1);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            if ((this.mRemote.transact(11, localParcel1, localParcel2, 0)) || (t.a.bQW() == null)) {
              break;
            }
            t.a.bQW().a(paramf, paraml, paramInt1, paramInt2);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132767);
        }
      }
      
      public final void a(l paraml, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(132761);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if (paraml != null) {}
          for (IBinder localIBinder = paraml.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            if ((this.mRemote.transact(5, localParcel1, localParcel2, 0)) || (t.a.bQW() == null)) {
              break;
            }
            t.a.bQW().a(paraml, paramInt1, paramInt2);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132761);
        }
      }
      
      public final void a(l paraml, int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(132766);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if (paraml != null) {}
          for (IBinder localIBinder = paraml.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeString(paramString);
            if ((this.mRemote.transact(10, localParcel1, localParcel2, 0)) || (t.a.bQW() == null)) {
              break;
            }
            t.a.bQW().a(paraml, paramInt1, paramInt2, paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132766);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final h bGo()
      {
        AppMethodBeat.i(132760);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            localh = t.a.bQW().bGo();
            return localh;
          }
          localParcel2.readException();
          h localh = h.a.S(localParcel2.readStrongBinder());
          return localh;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132760);
        }
      }
      
      public final i bGp()
      {
        AppMethodBeat.i(132759);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            locali = t.a.bQW().bGp();
            return locali;
          }
          localParcel2.readException();
          i locali = i.a.T(localParcel2.readStrongBinder());
          return locali;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132759);
        }
      }
      
      public final int bGq()
      {
        AppMethodBeat.i(132768);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(12, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            i = t.a.bQW().bGq();
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
          AppMethodBeat.o(132768);
        }
      }
      
      public final boolean bGr()
      {
        boolean bool = false;
        AppMethodBeat.i(241221);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(16, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            bool = t.a.bQW().bGr();
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
          AppMethodBeat.o(241221);
        }
      }
      
      public final String getCgiVerifyPrivateKey()
      {
        AppMethodBeat.i(241238);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(21, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            str = t.a.bQW().getCgiVerifyPrivateKey();
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
          AppMethodBeat.o(241238);
        }
      }
      
      public final String getCgiVerifyPublicKey()
      {
        AppMethodBeat.i(241235);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(20, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            str = t.a.bQW().getCgiVerifyPublicKey();
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
          AppMethodBeat.o(241235);
        }
      }
      
      public final boolean getIsLongPolling()
      {
        boolean bool = false;
        AppMethodBeat.i(241219);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(15, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            bool = t.a.bQW().getIsLongPolling();
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
          AppMethodBeat.o(241219);
        }
      }
      
      public final boolean getIsUserCmd()
      {
        boolean bool = false;
        AppMethodBeat.i(132763);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            bool = t.a.bQW().getIsUserCmd();
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
          AppMethodBeat.o(132763);
        }
      }
      
      public final int getLongPollingTimeout()
      {
        AppMethodBeat.i(241226);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(17, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            i = t.a.bQW().getLongPollingTimeout();
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
          AppMethodBeat.o(241226);
        }
      }
      
      public final int getMMReqRespHash()
      {
        AppMethodBeat.i(132762);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            i = t.a.bQW().getMMReqRespHash();
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
          AppMethodBeat.o(132762);
        }
      }
      
      public final int getNewExtFlags()
      {
        AppMethodBeat.i(241228);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(18, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            i = t.a.bQW().getNewExtFlags();
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
          AppMethodBeat.o(241228);
        }
      }
      
      public final int getOptions()
      {
        AppMethodBeat.i(132764);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            i = t.a.bQW().getOptions();
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
          AppMethodBeat.o(132764);
        }
      }
      
      public final int getTimeOut()
      {
        AppMethodBeat.i(132769);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(13, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            i = t.a.bQW().getTimeOut();
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
          AppMethodBeat.o(132769);
        }
      }
      
      public final byte[] getTransHeader()
      {
        AppMethodBeat.i(241231);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(19, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            arrayOfByte = t.a.bQW().getTransHeader();
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
          AppMethodBeat.o(241231);
        }
      }
      
      public final int getType()
      {
        AppMethodBeat.i(132757);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            i = t.a.bQW().getType();
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
          AppMethodBeat.o(132757);
        }
      }
      
      public final String getUri()
      {
        AppMethodBeat.i(132758);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            str = t.a.bQW().getUri();
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
          AppMethodBeat.o(132758);
        }
      }
      
      public final boolean isSingleSession()
      {
        boolean bool = false;
        AppMethodBeat.i(132770);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          if ((!this.mRemote.transact(14, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            bool = t.a.bQW().isSingleSession();
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
          AppMethodBeat.o(132770);
        }
      }
      
      public final void setConnectionInfo(String paramString)
      {
        AppMethodBeat.i(132765);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (t.a.bQW() != null))
          {
            t.a.bQW().setConnectionInfo(paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132765);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.t
 * JD-Core Version:    0.7.0.1
 */