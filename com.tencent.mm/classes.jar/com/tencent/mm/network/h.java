package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.network.a.b.a.a;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.protocal.ab.a.a;
import java.util.ArrayList;
import java.util.List;

public abstract interface h
  extends IInterface
{
  public abstract void MH(String paramString);
  
  public abstract void MI(String paramString);
  
  public abstract void MJ(String paramString);
  
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
  
  public abstract boolean aYT();
  
  public abstract void aZj();
  
  public abstract void aZk();
  
  public abstract String[] aZl();
  
  public abstract void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public abstract void bK(String paramString1, String paramString2);
  
  public abstract f bjw();
  
  public abstract void bjx();
  
  public abstract k bjy();
  
  public abstract void cancel(int paramInt);
  
  public abstract void d(String paramString1, long paramLong, String paramString2);
  
  public abstract void d(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void fA(boolean paramBoolean);
  
  public abstract void fB(boolean paramBoolean);
  
  public abstract void forceUseV6(boolean paramBoolean);
  
  public abstract void fy(boolean paramBoolean);
  
  public abstract void fz(boolean paramBoolean);
  
  public abstract int getHostByName(String paramString, List<String> paramList);
  
  public abstract String[] getIPsString(boolean paramBoolean);
  
  public abstract String getIspId();
  
  public abstract String getNetworkServerIp();
  
  public abstract int i(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void keepSignalling();
  
  public abstract void reportFailIp(String paramString);
  
  public abstract void reportV6Status(boolean paramBoolean);
  
  public abstract void reset();
  
  public abstract void setDebugHost(String paramString);
  
  public abstract void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt);
  
  public abstract void setNewDnsDebugHost(String paramString1, String paramString2);
  
  public abstract void setSignallingStrategy(long paramLong1, long paramLong2);
  
  public abstract void stopSignalling();
  
  public abstract void switchProcessActiveState(boolean paramBoolean);
  
  public static abstract class a
    extends Binder
    implements h
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.IDispatcher_AIDL");
    }
    
    public static h bjz()
    {
      return a.jDR;
    }
    
    public static h n(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.IDispatcher_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof h))) {
        return (h)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      t localt = null;
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject7 = null;
      Object localObject8 = null;
      Object localObject1 = null;
      boolean bool2 = false;
      boolean bool3 = false;
      int i = 0;
      boolean bool4 = false;
      boolean bool5 = false;
      boolean bool6 = false;
      boolean bool7 = false;
      boolean bool8 = false;
      boolean bool9 = false;
      boolean bool10 = false;
      boolean bool11 = false;
      boolean bool12 = false;
      boolean bool1 = false;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.network.IDispatcher_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        localt = t.a.q(paramParcel1.readStrongBinder());
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 == null) {
          paramParcel1 = (Parcel)localObject1;
        }
        for (;;)
        {
          paramInt1 = a(localt, paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
          localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.IOnGYNetEnd_AIDL");
          if ((localObject1 != null) && ((localObject1 instanceof n))) {
            paramParcel1 = (n)localObject1;
          } else {
            paramParcel1 = new n.a.a(paramParcel1);
          }
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        cancel(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        localObject1 = bjw();
        paramParcel2.writeNoException();
        paramParcel1 = localt;
        if (localObject1 != null) {
          paramParcel1 = ((f)localObject1).asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        reset();
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 == null) {
          paramParcel1 = localObject2;
        }
        for (;;)
        {
          a(paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
          if ((localObject1 != null) && ((localObject1 instanceof ab))) {
            paramParcel1 = (ab)localObject1;
          } else {
            paramParcel1 = new ab.a.a(paramParcel1);
          }
        }
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        a(bool1, paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createIntArray(), paramParcel1.createIntArray(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        bool1 = bool2;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        paramParcel1 = getIPsString(bool1);
        paramParcel2.writeNoException();
        paramParcel2.writeStringArray(paramParcel1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        paramParcel1 = getNetworkServerIp();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        bool1 = bool3;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        fy(bool1);
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        d(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        setNewDnsDebugHost(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        bjx();
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        bool1 = aYT();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 == null) {
          paramParcel1 = localObject3;
        }
        for (;;)
        {
          a(paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
          if ((localObject1 != null) && ((localObject1 instanceof b))) {
            paramParcel1 = (b)localObject1;
          } else {
            paramParcel1 = new b.a.a(paramParcel1);
          }
        }
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        MH(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        localObject1 = bjy();
        paramParcel2.writeNoException();
        paramParcel1 = localObject4;
        if (localObject1 != null) {
          paramParcel1 = ((k)localObject1).asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        paramParcel1 = paramParcel1.readString();
        localObject1 = new ArrayList();
        paramInt1 = getHostByName(paramParcel1, (List)localObject1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        paramParcel2.writeStringList((List)localObject1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        bool1 = bool4;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        paramParcel1 = new ArrayList();
        paramInt1 = a(bool1, paramParcel1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        paramParcel2.writeStringList(paramParcel1);
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        localObject1 = paramParcel1.readString();
        bool1 = bool5;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        paramParcel1 = new ArrayList();
        paramInt1 = a((String)localObject1, bool1, paramParcel1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        paramParcel2.writeStringList(paramParcel1);
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        reportFailIp(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        setHostInfo(paramParcel1.createStringArray(), paramParcel1.createStringArray(), paramParcel1.createIntArray());
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        addHostInfo(paramParcel1.createStringArray(), paramParcel1.createStringArray(), paramParcel1.createIntArray());
        paramParcel2.writeNoException();
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        paramInt1 = paramParcel1.readInt();
        localObject1 = paramParcel1.readString();
        paramInt2 = paramParcel1.readInt();
        bool1 = bool6;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        a(paramInt1, (String)localObject1, paramInt2, bool1);
        paramParcel2.writeNoException();
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        d(paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        aZj();
        paramParcel2.writeNoException();
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        paramParcel1 = getIspId();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        paramInt1 = i(paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        setSignallingStrategy(paramParcel1.readLong(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        keepSignalling();
        paramParcel2.writeNoException();
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        stopSignalling();
        paramParcel2.writeNoException();
        return true;
      case 31: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 == null) {
          paramParcel1 = localObject5;
        }
        for (;;)
        {
          a(paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.IOnReportKV_AIDL");
          if ((localObject1 != null) && ((localObject1 instanceof q))) {
            paramParcel1 = (q)localObject1;
          } else {
            paramParcel1 = new q.a.a(paramParcel1);
          }
        }
      case 32: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 == null) {
          paramParcel1 = localObject6;
        }
        for (;;)
        {
          a(paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.IWorkerCallback_AIDL");
          if ((localObject1 != null) && ((localObject1 instanceof u))) {
            paramParcel1 = (u)localObject1;
          } else {
            paramParcel1 = new u.a.a(paramParcel1);
          }
        }
      case 33: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 == null) {
          paramParcel1 = localObject7;
        }
        for (;;)
        {
          a(paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.IIpxxCallback_AIDL");
          if ((localObject1 != null) && ((localObject1 instanceof i))) {
            paramParcel1 = (i)localObject1;
          } else {
            paramParcel1 = new i.a.a(paramParcel1);
          }
        }
      case 34: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        MI(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 35: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        bool1 = bool7;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        fz(bool1);
        paramParcel2.writeNoException();
        return true;
      case 36: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        bool1 = bool8;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        fA(bool1);
        paramParcel2.writeNoException();
        return true;
      case 37: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        bool1 = bool9;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        fB(bool1);
        paramParcel2.writeNoException();
        return true;
      case 38: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        aZk();
        paramParcel2.writeNoException();
        return true;
      case 39: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 == null) {
          paramParcel1 = localObject8;
        }
        for (;;)
        {
          a(paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
          if ((localObject1 != null) && ((localObject1 instanceof j))) {
            paramParcel1 = (j)localObject1;
          } else {
            paramParcel1 = new j.a.a(paramParcel1);
          }
        }
      case 40: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        MJ(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 41: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        bool1 = bool10;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        reportV6Status(bool1);
        paramParcel2.writeNoException();
        return true;
      case 42: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        bool1 = bool11;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        forceUseV6(bool1);
        paramParcel2.writeNoException();
        return true;
      case 43: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        bool1 = bool12;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        switchProcessActiveState(bool1);
        paramParcel2.writeNoException();
        return true;
      case 44: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        setDebugHost(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 45: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
        bK(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = aZl();
      paramParcel2.writeNoException();
      paramParcel2.writeStringArray(paramParcel1);
      return true;
    }
    
    static final class a
      implements h
    {
      public static h jDR;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void MH(String paramString)
      {
        AppMethodBeat.i(132712);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(15, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().MH(paramString);
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
      
      public final void MI(String paramString)
      {
        AppMethodBeat.i(132731);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(34, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().MI(paramString);
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
      
      public final void MJ(String paramString)
      {
        AppMethodBeat.i(132737);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(40, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().MJ(paramString);
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
            if ((this.mRemote.transact(1, localParcel1, localParcel2, 0)) || (h.a.bjz() == null)) {
              break;
            }
            i = h.a.bjz().a(paramt, paramn);
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
          if ((!this.mRemote.transact(19, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            i = h.a.bjz().a(paramString, paramBoolean, paramList);
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
          if ((!this.mRemote.transact(18, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            i = h.a.bjz().a(paramBoolean, paramList);
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
          if ((!this.mRemote.transact(23, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().a(paramInt1, paramString, paramInt2, paramBoolean);
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
            if ((this.mRemote.transact(14, localParcel1, localParcel2, 0)) || (h.a.bjz() == null)) {
              break;
            }
            h.a.bjz().a(paramb);
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
            if ((this.mRemote.transact(33, localParcel1, localParcel2, 0)) || (h.a.bjz() == null)) {
              break;
            }
            h.a.bjz().a(parami);
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
            if ((this.mRemote.transact(39, localParcel1, localParcel2, 0)) || (h.a.bjz() == null)) {
              break;
            }
            h.a.bjz().a(paramj);
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
            if ((this.mRemote.transact(31, localParcel1, localParcel2, 0)) || (h.a.bjz() == null)) {
              break;
            }
            h.a.bjz().a(paramq);
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
            if ((this.mRemote.transact(32, localParcel1, localParcel2, 0)) || (h.a.bjz() == null)) {
              break;
            }
            h.a.bjz().a(paramu);
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
            if ((this.mRemote.transact(5, localParcel1, localParcel2, 0)) || (h.a.bjz() == null)) {
              break;
            }
            h.a.bjz().a(paramab);
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
            if ((this.mRemote.transact(6, localParcel1, localParcel2, 0)) || (h.a.bjz() == null)) {
              break;
            }
            h.a.bjz().a(paramBoolean, paramString1, paramString2, paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramInt2, paramString3, paramString4);
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
      
      public final boolean aYT()
      {
        boolean bool = false;
        AppMethodBeat.i(132710);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          if ((!this.mRemote.transact(13, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            bool = h.a.bjz().aYT();
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
      
      public final void aZj()
      {
        AppMethodBeat.i(132722);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          if ((!this.mRemote.transact(25, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().aZj();
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
      
      public final void aZk()
      {
        AppMethodBeat.i(132735);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          if ((!this.mRemote.transact(38, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().aZk();
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
      
      public final String[] aZl()
      {
        AppMethodBeat.i(197096);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          if ((!this.mRemote.transact(46, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            arrayOfString = h.a.bjz().aZl();
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
          AppMethodBeat.o(197096);
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
          if ((!this.mRemote.transact(22, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().addHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
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
      
      public final void bK(String paramString1, String paramString2)
      {
        AppMethodBeat.i(197095);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if ((!this.mRemote.transact(45, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().bK(paramString1, paramString2);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(197095);
        }
      }
      
      public final f bjw()
      {
        AppMethodBeat.i(132700);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            localf = h.a.bjz().bjw();
            return localf;
          }
          localParcel2.readException();
          f localf = f.a.m(localParcel2.readStrongBinder());
          return localf;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132700);
        }
      }
      
      public final void bjx()
      {
        AppMethodBeat.i(132709);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          if ((!this.mRemote.transact(12, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().bjx();
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
      
      public final k bjy()
      {
        AppMethodBeat.i(132713);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          if ((!this.mRemote.transact(16, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            localk = h.a.bjz().bjy();
            return localk;
          }
          localParcel2.readException();
          k localk = k.a.o(localParcel2.readStrongBinder());
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
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().cancel(paramInt);
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
      
      public final void d(String paramString1, long paramLong, String paramString2)
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
          if ((!this.mRemote.transact(24, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().d(paramString1, paramLong, paramString2);
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
      
      public final void d(String paramString1, String paramString2, String paramString3, String paramString4)
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
          if ((!this.mRemote.transact(10, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().d(paramString1, paramString2, paramString3, paramString4);
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
      
      public final void fA(boolean paramBoolean)
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
          if ((!this.mRemote.transact(36, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().fA(paramBoolean);
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
      
      public final void fB(boolean paramBoolean)
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
          if ((!this.mRemote.transact(37, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().fB(paramBoolean);
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
          if ((!this.mRemote.transact(42, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().forceUseV6(paramBoolean);
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
      
      public final void fy(boolean paramBoolean)
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
          if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().fy(paramBoolean);
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
      
      public final void fz(boolean paramBoolean)
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
          if ((!this.mRemote.transact(35, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().fz(paramBoolean);
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
      
      public final int getHostByName(String paramString, List<String> paramList)
      {
        AppMethodBeat.i(132714);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(17, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            i = h.a.bjz().getHostByName(paramString, paramList);
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
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            arrayOfString = h.a.bjz().getIPsString(paramBoolean);
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
          if ((!this.mRemote.transact(26, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            str = h.a.bjz().getIspId();
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
      
      public final String getNetworkServerIp()
      {
        AppMethodBeat.i(132705);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            str = h.a.bjz().getNetworkServerIp();
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
      
      public final int i(int paramInt, byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(132724);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          localParcel1.writeInt(paramInt);
          localParcel1.writeByteArray(paramArrayOfByte);
          if ((!this.mRemote.transact(27, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            paramInt = h.a.bjz().i(paramInt, paramArrayOfByte);
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
          if ((!this.mRemote.transact(29, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().keepSignalling();
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
          if ((!this.mRemote.transact(20, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().reportFailIp(paramString);
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
          if ((!this.mRemote.transact(41, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().reportV6Status(paramBoolean);
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
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().reset();
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
        AppMethodBeat.i(197094);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(44, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().setDebugHost(paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(197094);
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
          if ((!this.mRemote.transact(21, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().setHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
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
          if ((!this.mRemote.transact(11, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().setNewDnsDebugHost(paramString1, paramString2);
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
          if ((!this.mRemote.transact(28, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().setSignallingStrategy(paramLong1, paramLong2);
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
      
      public final void stopSignalling()
      {
        AppMethodBeat.i(132727);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          if ((!this.mRemote.transact(30, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().stopSignalling();
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
        AppMethodBeat.i(197093);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          if ((!this.mRemote.transact(43, localParcel1, localParcel2, 0)) && (h.a.bjz() != null))
          {
            h.a.bjz().switchProcessActiveState(paramBoolean);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(197093);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.h
 * JD-Core Version:    0.7.0.1
 */