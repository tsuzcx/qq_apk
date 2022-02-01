package com.tencent.mm.network;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.protocal.ab;
import java.util.List;

public abstract interface h
  extends IInterface
{
  public abstract void Uc(String paramString);
  
  public abstract void Ud(String paramString);
  
  public abstract void Ue(String paramString);
  
  public abstract String[] Uf(String paramString);
  
  public abstract int a(t paramt, n paramn);
  
  public abstract int a(String paramString, boolean paramBoolean, List<String> paramList);
  
  public abstract int a(boolean paramBoolean, List<String> paramList);
  
  public abstract void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean);
  
  public abstract void a(b paramb);
  
  public abstract void a(i parami);
  
  public abstract void a(j paramj);
  
  public abstract void a(q paramq);
  
  public abstract void a(u paramu);
  
  public abstract void a(ab paramab);
  
  public abstract void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4);
  
  public abstract void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public abstract void b(String paramString1, long paramLong, String paramString2);
  
  public abstract void bN(String paramString1, String paramString2);
  
  public abstract String[] biA();
  
  public abstract boolean bii();
  
  public abstract void biy();
  
  public abstract void biz();
  
  public abstract f bta();
  
  public abstract void btb();
  
  public abstract k btc();
  
  public abstract void cancel(int paramInt);
  
  public abstract void clearMMtlsForbidenHostAndPsk();
  
  public abstract void e(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void forceUseV6(boolean paramBoolean);
  
  public abstract int getHostByName(String paramString, List<String> paramList);
  
  public abstract String[] getIPsString(boolean paramBoolean);
  
  public abstract String getIspId();
  
  public abstract int getMMtlsRegion();
  
  public abstract String getNetworkServerIp();
  
  public abstract void gj(boolean paramBoolean);
  
  public abstract void gk(boolean paramBoolean);
  
  public abstract void gl(boolean paramBoolean);
  
  public abstract void gm(boolean paramBoolean);
  
  public abstract int j(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void keepSignalling();
  
  public abstract void reportFailIp(String paramString);
  
  public abstract void reportV6Status(boolean paramBoolean);
  
  public abstract void reset();
  
  public abstract void setDebugHost(String paramString);
  
  public abstract void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public abstract void setMMtlsRegion(int paramInt);
  
  public abstract void setNetIdAndIsp(String paramString1, String paramString2, String paramString3);
  
  public abstract void setNewDnsDebugHost(String paramString1, String paramString2);
  
  public abstract void setSignallingStrategy(long paramLong1, long paramLong2);
  
  public abstract void simpleTestCommand(String paramString);
  
  public abstract void stopSignalling();
  
  public abstract void switchProcessActiveState(boolean paramBoolean);
  
  static final class a$a
    implements h
  {
    public static h muu;
    private IBinder mRemote;
    
    a$a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final void Uc(String paramString)
    {
      AppMethodBeat.i(132712);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(15, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().Uc(paramString);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132712);
      }
    }
    
    public final void Ud(String paramString)
    {
      AppMethodBeat.i(132731);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(34, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().Ud(paramString);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132731);
      }
    }
    
    public final void Ue(String paramString)
    {
      AppMethodBeat.i(132737);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(40, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().Ue(paramString);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132737);
      }
    }
    
    public final String[] Uf(String paramString)
    {
      AppMethodBeat.i(206639);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(49, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          paramString = h.a.btd().Uf(paramString);
          return paramString;
        }
        localParcel2.readException();
        paramString = localParcel2.createStringArray();
        return paramString;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(206639);
      }
    }
    
    public final int a(t paramt, n paramn)
    {
      Object localObject2 = null;
      AppMethodBeat.i(132698);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramt != null) {}
        for (Object localObject1 = paramt.asBinder();; localObject1 = null)
        {
          localParcel1.writeStrongBinder((IBinder)localObject1);
          localObject1 = localObject2;
          if (paramn != null) {
            localObject1 = paramn.asBinder();
          }
          localParcel1.writeStrongBinder((IBinder)localObject1);
          if ((this.mRemote.transact(1, localParcel1, localParcel2, 0)) || (h.a.btd() == null)) {
            break;
          }
          i = h.a.btd().a(paramt, paramn);
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
        AppMethodBeat.o(132698);
      }
    }
    
    public final int a(String paramString, boolean paramBoolean, List<String> paramList)
    {
      int i = 0;
      AppMethodBeat.i(132716);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        if ((!this.mRemote.transact(19, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          i = h.a.btd().a(paramString, paramBoolean, paramList);
          return i;
        }
        localParcel2.readException();
        i = localParcel2.readInt();
        localParcel2.readStringList(paramList);
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132716);
      }
    }
    
    public final int a(boolean paramBoolean, List<String> paramList)
    {
      int i = 0;
      AppMethodBeat.i(132715);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        if ((!this.mRemote.transact(18, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          i = h.a.btd().a(paramBoolean, paramList);
          return i;
        }
        localParcel2.readException();
        i = localParcel2.readInt();
        localParcel2.readStringList(paramList);
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132715);
      }
    }
    
    public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(132720);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeInt(paramInt1);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt2);
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        if ((!this.mRemote.transact(23, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().a(paramInt1, paramString, paramInt2, paramBoolean);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132720);
      }
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(132711);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramb != null) {}
        for (IBinder localIBinder = paramb.asBinder();; localIBinder = null)
        {
          localParcel1.writeStrongBinder(localIBinder);
          if ((this.mRemote.transact(14, localParcel1, localParcel2, 0)) || (h.a.btd() == null)) {
            break;
          }
          h.a.btd().a(paramb);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132711);
      }
    }
    
    public final void a(i parami)
    {
      AppMethodBeat.i(132730);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (parami != null) {}
        for (IBinder localIBinder = parami.asBinder();; localIBinder = null)
        {
          localParcel1.writeStrongBinder(localIBinder);
          if ((this.mRemote.transact(33, localParcel1, localParcel2, 0)) || (h.a.btd() == null)) {
            break;
          }
          h.a.btd().a(parami);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132730);
      }
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(132736);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramj != null) {}
        for (IBinder localIBinder = paramj.asBinder();; localIBinder = null)
        {
          localParcel1.writeStrongBinder(localIBinder);
          if ((this.mRemote.transact(39, localParcel1, localParcel2, 0)) || (h.a.btd() == null)) {
            break;
          }
          h.a.btd().a(paramj);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132736);
      }
    }
    
    public final void a(q paramq)
    {
      AppMethodBeat.i(132728);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramq != null) {}
        for (IBinder localIBinder = paramq.asBinder();; localIBinder = null)
        {
          localParcel1.writeStrongBinder(localIBinder);
          if ((this.mRemote.transact(31, localParcel1, localParcel2, 0)) || (h.a.btd() == null)) {
            break;
          }
          h.a.btd().a(paramq);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132728);
      }
    }
    
    public final void a(u paramu)
    {
      AppMethodBeat.i(132729);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramu != null) {}
        for (IBinder localIBinder = paramu.asBinder();; localIBinder = null)
        {
          localParcel1.writeStrongBinder(localIBinder);
          if ((this.mRemote.transact(32, localParcel1, localParcel2, 0)) || (h.a.btd() == null)) {
            break;
          }
          h.a.btd().a(paramu);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132729);
      }
    }
    
    public final void a(ab paramab)
    {
      AppMethodBeat.i(132702);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramab != null) {}
        for (IBinder localIBinder = paramab.asBinder();; localIBinder = null)
        {
          localParcel1.writeStrongBinder(localIBinder);
          if ((this.mRemote.transact(5, localParcel1, localParcel2, 0)) || (h.a.btd() == null)) {
            break;
          }
          h.a.btd().a(paramab);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132702);
      }
    }
    
    public final void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(132703);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {}
        for (int i = 1;; i = 0)
        {
          localParcel1.writeInt(i);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeIntArray(paramArrayOfInt1);
          localParcel1.writeIntArray(paramArrayOfInt2);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeString(paramString3);
          localParcel1.writeString(paramString4);
          if ((this.mRemote.transact(6, localParcel1, localParcel2, 0)) || (h.a.btd() == null)) {
            break;
          }
          h.a.btd().a(paramBoolean, paramString1, paramString2, paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramInt2, paramString3, paramString4);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132703);
      }
    }
    
    public final void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(132719);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeStringArray(paramArrayOfString1);
        localParcel1.writeStringArray(paramArrayOfString2);
        localParcel1.writeIntArray(paramArrayOfInt);
        if ((!this.mRemote.transact(22, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().addHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132719);
      }
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    public final void b(String paramString1, long paramLong, String paramString2)
    {
      AppMethodBeat.i(132721);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString1);
        localParcel1.writeLong(paramLong);
        localParcel1.writeString(paramString2);
        if ((!this.mRemote.transact(24, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().b(paramString1, paramLong, paramString2);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132721);
      }
    }
    
    public final void bN(String paramString1, String paramString2)
    {
      AppMethodBeat.i(206631);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if ((!this.mRemote.transact(45, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().bN(paramString1, paramString2);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(206631);
      }
    }
    
    public final String[] biA()
    {
      AppMethodBeat.i(206633);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(46, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          arrayOfString = h.a.btd().biA();
          return arrayOfString;
        }
        localParcel2.readException();
        String[] arrayOfString = localParcel2.createStringArray();
        return arrayOfString;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(206633);
      }
    }
    
    public final boolean bii()
    {
      boolean bool = false;
      AppMethodBeat.i(132710);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(13, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          bool = h.a.btd().bii();
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
        AppMethodBeat.o(132710);
      }
    }
    
    public final void biy()
    {
      AppMethodBeat.i(132722);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(25, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().biy();
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132722);
      }
    }
    
    public final void biz()
    {
      AppMethodBeat.i(132735);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(38, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().biz();
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132735);
      }
    }
    
    public final f bta()
    {
      AppMethodBeat.i(132700);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          localf = h.a.btd().bta();
          return localf;
        }
        localParcel2.readException();
        f localf = f.a.o(localParcel2.readStrongBinder());
        return localf;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132700);
      }
    }
    
    public final void btb()
    {
      AppMethodBeat.i(132709);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(12, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().btb();
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132709);
      }
    }
    
    public final k btc()
    {
      AppMethodBeat.i(132713);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(16, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          localk = h.a.btd().btc();
          return localk;
        }
        localParcel2.readException();
        k localk = k.a.q(localParcel2.readStrongBinder());
        return localk;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132713);
      }
    }
    
    public final void cancel(int paramInt)
    {
      AppMethodBeat.i(132699);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeInt(paramInt);
        if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().cancel(paramInt);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132699);
      }
    }
    
    public final void clearMMtlsForbidenHostAndPsk()
    {
      AppMethodBeat.i(206636);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(47, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().clearMMtlsForbidenHostAndPsk();
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(206636);
      }
    }
    
    public final void e(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(132707);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeString(paramString3);
        localParcel1.writeString(paramString4);
        if ((!this.mRemote.transact(10, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().e(paramString1, paramString2, paramString3, paramString4);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132707);
      }
    }
    
    public final void forceUseV6(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(176846);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        if ((!this.mRemote.transact(42, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().forceUseV6(paramBoolean);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(176846);
      }
    }
    
    public final int getHostByName(String paramString, List<String> paramList)
    {
      AppMethodBeat.i(132714);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(17, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          i = h.a.btd().getHostByName(paramString, paramList);
          return i;
        }
        localParcel2.readException();
        int i = localParcel2.readInt();
        localParcel2.readStringList(paramList);
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132714);
      }
    }
    
    public final String[] getIPsString(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(132704);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          arrayOfString = h.a.btd().getIPsString(paramBoolean);
          return arrayOfString;
        }
        localParcel2.readException();
        String[] arrayOfString = localParcel2.createStringArray();
        return arrayOfString;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132704);
      }
    }
    
    public final String getIspId()
    {
      AppMethodBeat.i(132723);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(26, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          str = h.a.btd().getIspId();
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
        AppMethodBeat.o(132723);
      }
    }
    
    public final int getMMtlsRegion()
    {
      AppMethodBeat.i(206637);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(48, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          i = h.a.btd().getMMtlsRegion();
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
        AppMethodBeat.o(206637);
      }
    }
    
    public final String getNetworkServerIp()
    {
      AppMethodBeat.i(132705);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          str = h.a.btd().getNetworkServerIp();
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
        AppMethodBeat.o(132705);
      }
    }
    
    public final void gj(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(132706);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().gj(paramBoolean);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132706);
      }
    }
    
    public final void gk(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(132732);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        if ((!this.mRemote.transact(35, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().gk(paramBoolean);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132732);
      }
    }
    
    public final void gl(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(132733);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        if ((!this.mRemote.transact(36, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().gl(paramBoolean);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132733);
      }
    }
    
    public final void gm(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(132734);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        if ((!this.mRemote.transact(37, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().gm(paramBoolean);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132734);
      }
    }
    
    public final int j(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132724);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeInt(paramInt);
        localParcel1.writeByteArray(paramArrayOfByte);
        if ((!this.mRemote.transact(27, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          paramInt = h.a.btd().j(paramInt, paramArrayOfByte);
          return paramInt;
        }
        localParcel2.readException();
        paramInt = localParcel2.readInt();
        return paramInt;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132724);
      }
    }
    
    public final void keepSignalling()
    {
      AppMethodBeat.i(132726);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(29, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().keepSignalling();
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132726);
      }
    }
    
    public final void reportFailIp(String paramString)
    {
      AppMethodBeat.i(132717);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(20, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().reportFailIp(paramString);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132717);
      }
    }
    
    public final void reportV6Status(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(176845);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        if ((!this.mRemote.transact(41, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().reportV6Status(paramBoolean);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(176845);
      }
    }
    
    public final void reset()
    {
      AppMethodBeat.i(132701);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().reset();
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132701);
      }
    }
    
    public final void setDebugHost(String paramString)
    {
      AppMethodBeat.i(206629);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(44, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().setDebugHost(paramString);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(206629);
      }
    }
    
    public final void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(132718);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeStringArray(paramArrayOfString1);
        localParcel1.writeStringArray(paramArrayOfString2);
        localParcel1.writeIntArray(paramArrayOfInt);
        if ((!this.mRemote.transact(21, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().setHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132718);
      }
    }
    
    public final void setMMtlsRegion(int paramInt)
    {
      AppMethodBeat.i(206640);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeInt(paramInt);
        if ((!this.mRemote.transact(50, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().setMMtlsRegion(paramInt);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(206640);
      }
    }
    
    public final void setNetIdAndIsp(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(206642);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeString(paramString3);
        if ((!this.mRemote.transact(51, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().setNetIdAndIsp(paramString1, paramString2, paramString3);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(206642);
      }
    }
    
    public final void setNewDnsDebugHost(String paramString1, String paramString2)
    {
      AppMethodBeat.i(132708);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if ((!this.mRemote.transact(11, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().setNewDnsDebugHost(paramString1, paramString2);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132708);
      }
    }
    
    public final void setSignallingStrategy(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(132725);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeLong(paramLong1);
        localParcel1.writeLong(paramLong2);
        if ((!this.mRemote.transact(28, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().setSignallingStrategy(paramLong1, paramLong2);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132725);
      }
    }
    
    public final void simpleTestCommand(String paramString)
    {
      AppMethodBeat.i(206644);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        if ((!this.mRemote.transact(52, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().simpleTestCommand(paramString);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(206644);
      }
    }
    
    public final void stopSignalling()
    {
      AppMethodBeat.i(132727);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if ((!this.mRemote.transact(30, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().stopSignalling();
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132727);
      }
    }
    
    public final void switchProcessActiveState(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(206628);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        if ((!this.mRemote.transact(43, localParcel1, localParcel2, 0)) && (h.a.btd() != null))
        {
          h.a.btd().switchProcessActiveState(paramBoolean);
          return;
        }
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(206628);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.network.h
 * JD-Core Version:    0.7.0.1
 */