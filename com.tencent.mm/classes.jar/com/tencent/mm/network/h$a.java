package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.protocal.ab.a.a;
import java.util.ArrayList;
import java.util.List;

public abstract class h$a
  extends Binder
  implements h
{
  public h$a()
  {
    attachInterface(this, "com.tencent.mm.network.IDispatcher_AIDL");
  }
  
  public static h bQM()
  {
    return h.a.a.pnO;
  }
  
  public static h r(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.IDispatcher_AIDL");
    if ((localIInterface != null) && ((localIInterface instanceof h))) {
      return (h)localIInterface;
    }
    return new h.a.a(paramIBinder);
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
      localt = t.a.u(paramParcel1.readStrongBinder());
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
      localObject1 = bQJ();
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
      ha(bool1);
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      e(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      setNewDnsDebugHost(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bQK();
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bFR();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      a(b.a.w(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      Mb(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      localObject1 = bQL();
      paramParcel2.writeNoException();
      paramParcel1 = localObject3;
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
      paramInt1 = c(bool1, paramParcel1);
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
      paramInt1 = a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      localObject1 = paramParcel1.createIntArray();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        paramInt1 = a((int[])localObject1, bool1, paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 25: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bFP();
      paramParcel2.writeNoException();
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bGi();
      paramParcel2.writeNoException();
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = getIspId();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 28: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramInt1 = j(paramParcel1.readInt(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      setSignallingStrategy(paramParcel1.readLong(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      keepSignalling();
      paramParcel2.writeNoException();
      return true;
    case 31: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      stopSignalling();
      paramParcel2.writeNoException();
      return true;
    case 32: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = localObject4;
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
    case 33: 
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
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.IWorkerCallback_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof v))) {
          paramParcel1 = (v)localObject1;
        } else {
          paramParcel1 = new v.a.a(paramParcel1);
        }
      }
    case 34: 
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
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.IIpxxCallback_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof i))) {
          paramParcel1 = (i)localObject1;
        } else {
          paramParcel1 = new i.a.a(paramParcel1);
        }
      }
    case 35: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      Mc(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 36: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool6;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      hb(bool1);
      paramParcel2.writeNoException();
      return true;
    case 37: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool7;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      hc(bool1);
      paramParcel2.writeNoException();
      return true;
    case 38: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool8;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      hd(bool1);
      paramParcel2.writeNoException();
      return true;
    case 39: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bGj();
      paramParcel2.writeNoException();
      return true;
    case 40: 
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
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof j))) {
          paramParcel1 = (j)localObject1;
        } else {
          paramParcel1 = new j.a.a(paramParcel1);
        }
      }
    case 41: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      Md(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 42: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool9;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      reportV6Status(bool1);
      paramParcel2.writeNoException();
      return true;
    case 43: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool10;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      forceUseV6(bool1);
      paramParcel2.writeNoException();
      return true;
    case 44: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool11;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      switchProcessActiveState(bool1);
      paramParcel2.writeNoException();
      return true;
    case 45: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      setDebugHost(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 46: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bY(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 47: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = bGk();
      paramParcel2.writeNoException();
      paramParcel2.writeStringArray(paramParcel1);
      return true;
    case 48: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      clearMMtlsForbidenHostAndPsk();
      paramParcel2.writeNoException();
      return true;
    case 49: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramInt1 = getMMtlsRegion();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 50: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = Me(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeStringArray(paramParcel1);
      return true;
    case 51: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      setMMtlsRegion(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 52: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      setNetIdAndIsp(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 53: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      simpleTestCommand(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 54: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramInt1 = ackActionNotify(paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 55: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramInt1 = doLiveSpeedTest(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.createByteArray(), u.a.v(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
    long l = getMarsTimestamp();
    paramParcel2.writeNoException();
    paramParcel2.writeLong(l);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.h.a
 * JD-Core Version:    0.7.0.1
 */