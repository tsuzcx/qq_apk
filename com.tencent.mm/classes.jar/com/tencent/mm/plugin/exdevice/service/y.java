package com.tencent.mm.plugin.exdevice.service;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.a.f.6;
import com.tencent.mm.plugin.d.a.a.f.7;
import com.tencent.mm.plugin.d.a.a.h;
import com.tencent.mm.plugin.d.a.b.e.4;
import com.tencent.mm.plugin.d.a.b.e.5;
import com.tencent.mm.plugin.d.a.b.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import junit.framework.Assert;

public final class y
  extends h.a
  implements com.tencent.mm.plugin.d.a.a.b, com.tencent.mm.plugin.d.a.d.a.a, g
{
  private final aq mHandler;
  private a qmR;
  private RemoteCallbackList<k> qmS;
  private RemoteCallbackList<p> qmT;
  private RemoteCallbackList<j> qmU;
  private RemoteCallbackList<i> qmV;
  private RemoteCallbackList<q> qmW;
  private RemoteCallbackList<n> qmX;
  private final l qmY;
  private int qmZ;
  private final com.tencent.mm.plugin.d.a.a.f qna;
  private final com.tencent.mm.plugin.d.a.d.a qnb;
  private RemoteCallbackList<j> qnc;
  private RemoteCallbackList<k> qnd;
  private RemoteCallbackList<s> qne;
  private RemoteCallbackList<t> qnf;
  com.tencent.mm.plugin.d.a.b.e qng;
  private e.a qnh;
  
  public y()
  {
    AppMethodBeat.i(23726);
    this.qmR = null;
    this.qmS = new RemoteCallbackList();
    this.qmT = new RemoteCallbackList();
    this.qmU = new RemoteCallbackList();
    this.qmV = new RemoteCallbackList();
    this.qmW = new RemoteCallbackList();
    this.qmX = new RemoteCallbackList();
    this.qmY = new l((byte)0);
    this.qmZ = 0;
    this.qnc = new RemoteCallbackList();
    this.qnd = new RemoteCallbackList();
    this.qne = new RemoteCallbackList();
    this.qnf = new RemoteCallbackList();
    this.qmR = new a(this);
    this.mHandler = new a(v.cnm().ipo.getSerialTag());
    if (Build.VERSION.SDK_INT >= 18) {}
    for (this.qna = new com.tencent.mm.plugin.d.a.a.f(this);; this.qna = null)
    {
      this.qnb = new com.tencent.mm.plugin.d.a.d.a(this);
      this.qnh = new e.a()
      {
        public final void a(long paramAnonymousLong1, boolean paramAnonymousBoolean, long paramAnonymousLong2)
        {
          AppMethodBeat.i(23717);
          Object localObject;
          if (paramAnonymousBoolean)
          {
            localObject = "true";
            ae.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onConnected. seesionId=%d, connected=%s, profileType=%d", new Object[] { Long.valueOf(paramAnonymousLong1), localObject, Long.valueOf(paramAnonymousLong2) });
            localObject = new y.c((byte)0);
            ((y.c)localObject).nZd = paramAnonymousLong1;
            if (!paramAnonymousBoolean) {
              break label154;
            }
          }
          label154:
          for (int i = 2;; i = 4)
          {
            ((y.c)localObject).qmj = i;
            ((y.c)localObject).qmi = 1;
            ((y.c)localObject).qgz = 0;
            ((y.c)localObject).nWB = paramAnonymousLong2;
            if (!y.a(y.this).sendMessage(y.a(y.this).obtainMessage(9, localObject))) {
              ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(9) });
            }
            AppMethodBeat.o(23717);
            return;
            localObject = "false";
            break;
          }
        }
        
        public final void a(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(23720);
          ae.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscover. deviceMac=%s, deviceName=%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          y.g localg = new y.g((byte)0);
          localg.qnm = false;
          localg.nZh = paramAnonymousString1;
          localg.mDeviceName = paramAnonymousString2;
          localg.kKi = paramAnonymousInt;
          localg.qnn = paramAnonymousArrayOfByte;
          if (!y.a(y.this).sendMessage(y.a(y.this).obtainMessage(13, localg))) {
            ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(13) });
          }
          AppMethodBeat.o(23720);
        }
        
        public final void b(long paramAnonymousLong, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(23718);
          y.f localf = new y.f((byte)0);
          localf.qjy = paramAnonymousLong;
          localf.mData = paramAnonymousArrayOfByte;
          if (!y.a(y.this).sendMessage(y.a(y.this).obtainMessage(12, localf))) {
            ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(12) });
          }
          AppMethodBeat.o(23718);
        }
        
        public final void bNF()
        {
          AppMethodBeat.i(23721);
          ae.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscoverFinished");
          y.g localg = new y.g((byte)0);
          localg.qnm = true;
          localg.nZh = null;
          localg.mDeviceName = null;
          localg.kKi = 0;
          localg.qnn = null;
          if (!y.a(y.this).sendMessage(y.a(y.this).obtainMessage(13, localg))) {
            ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(13) });
          }
          AppMethodBeat.o(23721);
        }
        
        public final void m(long paramAnonymousLong, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(23719);
          Object localObject;
          if (paramAnonymousBoolean)
          {
            localObject = "true";
            ae.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onSend. sessionId=%d, success=%s", new Object[] { Long.valueOf(paramAnonymousLong), localObject });
            localObject = new y.h((byte)0);
            ((y.h)localObject).qjy = paramAnonymousLong;
            if (!paramAnonymousBoolean) {
              break label136;
            }
            ((y.h)localObject).qgL = 0;
          }
          for (((y.h)localObject).qgz = 0;; ((y.h)localObject).qgz = -1)
          {
            ((y.h)localObject).kwn = "";
            if (!y.a(y.this).sendMessage(y.a(y.this).obtainMessage(11, localObject))) {
              ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(11) });
            }
            AppMethodBeat.o(23719);
            return;
            localObject = "false";
            break;
            label136:
            ((y.h)localObject).qgL = -1;
          }
        }
      };
      com.tencent.mm.compatible.a.a.a(18, new com.tencent.mm.compatible.a.a.a()
      {
        public final void run()
        {
          AppMethodBeat.i(23722);
          y.a(y.this, new com.tencent.mm.plugin.d.a.b.e(y.b(y.this)));
          AppMethodBeat.o(23722);
        }
      });
      AppMethodBeat.o(23726);
      return;
    }
  }
  
  private static IInterface a(long paramLong, RemoteCallbackList paramRemoteCallbackList, int paramInt)
  {
    AppMethodBeat.i(23727);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "findCallbackbyId, Id = %d, count = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    int i = 0;
    while (i < paramInt)
    {
      HashMap localHashMap = (HashMap)paramRemoteCallbackList.getBroadcastCookie(i);
      if (localHashMap.containsKey(Long.valueOf(paramLong)))
      {
        paramRemoteCallbackList = (IInterface)localHashMap.get(Long.valueOf(paramLong));
        AppMethodBeat.o(23727);
        return paramRemoteCallbackList;
      }
      i += 1;
    }
    ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find id in the callback list");
    AppMethodBeat.o(23727);
    return null;
  }
  
  private static boolean a(RemoteCallbackList paramRemoteCallbackList, long paramLong, IInterface paramIInterface)
  {
    AppMethodBeat.i(23734);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB, ID = %d", new Object[] { Long.valueOf(paramLong) });
    if ((paramRemoteCallbackList == null) || (paramIInterface == null))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
      AppMethodBeat.o(23734);
      return false;
    }
    int i = paramRemoteCallbackList.beginBroadcast();
    int j;
    do
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      i = j;
    } while (!paramRemoteCallbackList.getBroadcastItem(j).asBinder().equals(paramIInterface.asBinder()));
    if (j < 0)
    {
      ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Register a new process in callback list.");
      localHashMap = new HashMap();
      localHashMap.put(Long.valueOf(paramLong), paramIInterface);
      paramRemoteCallbackList.register(paramIInterface, localHashMap);
      paramRemoteCallbackList.finishBroadcast();
      AppMethodBeat.o(23734);
      return true;
    }
    HashMap localHashMap = (HashMap)paramRemoteCallbackList.getBroadcastCookie(j);
    if (localHashMap == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
      paramRemoteCallbackList.finishBroadcast();
      AppMethodBeat.o(23734);
      return false;
    }
    localHashMap.put(Long.valueOf(paramLong), paramIInterface);
    paramRemoteCallbackList.finishBroadcast();
    AppMethodBeat.o(23734);
    return true;
  }
  
  private static boolean a(RemoteCallbackList paramRemoteCallbackList, long paramLong, IInterface paramIInterface, int paramInt)
  {
    AppMethodBeat.i(23735);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB, device id = %d, aCount = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if ((paramRemoteCallbackList == null) || (paramIInterface == null))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
      AppMethodBeat.o(23735);
      return false;
    }
    int i;
    do
    {
      i = paramInt - 1;
      if (i < 0) {
        break;
      }
      paramInt = i;
    } while (!paramRemoteCallbackList.getBroadcastItem(i).asBinder().equals(paramIInterface.asBinder()));
    if (i < 0)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find callback in callback list");
      AppMethodBeat.o(23735);
      return false;
    }
    HashMap localHashMap = (HashMap)paramRemoteCallbackList.getBroadcastCookie(i);
    if (localHashMap == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
      AppMethodBeat.o(23735);
      return false;
    }
    if ((IInterface)localHashMap.remove(Long.valueOf(paramLong)) == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find id in the map");
      AppMethodBeat.o(23735);
      return false;
    }
    if (!localHashMap.isEmpty())
    {
      AppMethodBeat.o(23735);
      return true;
    }
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "No id is in the map, unregister this process");
    boolean bool = paramRemoteCallbackList.unregister(paramIInterface);
    if (!bool) {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallbackList.unregister failed!!!");
    }
    AppMethodBeat.o(23735);
    return bool;
  }
  
  private boolean b(long paramLong, p paramp)
  {
    AppMethodBeat.i(23738);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp, task Id = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramp == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
      d(paramLong, -1, -1, "null == aTask");
      AppMethodBeat.o(23738);
      return false;
    }
    a locala = this.qmR;
    ae.i("MicroMsg.exdevice.BTDeviceManager", "startTask, taskId = %d", new Object[] { Long.valueOf(paramLong) });
    Assert.assertNotNull(paramp);
    a.g localg = new a.g(paramLong, paramp);
    if (locala.mHandler.sendMessage(locala.mHandler.obtainMessage(8, localg))) {}
    for (int i = 0; i != 0; i = -1)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.startTask Failed ret = -1");
      d(paramLong, -1, -1, "mBTDeviceMrg.startTask Failed!!!");
      AppMethodBeat.o(23738);
      return false;
    }
    if (!a(this.qmT, paramLong, paramp))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB Fail!!!");
      d(paramLong, -1, -1, "registerRemoteCB Fail!!!");
      AppMethodBeat.o(23738);
      return false;
    }
    AppMethodBeat.o(23738);
    return true;
  }
  
  private boolean c(j paramj)
  {
    AppMethodBeat.i(23728);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnscanCallback");
    boolean bool = this.qmU.unregister(paramj);
    if (!bool) {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
    }
    for (;;)
    {
      AppMethodBeat.o(23728);
      return bool;
      this.qmZ -= 1;
    }
  }
  
  private void d(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(23744);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEndImp taskId = %d, errType = %d, errCode =%d, errMsg = %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    int i = this.qmT.beginBroadcast();
    p localp = (p)a(paramLong, this.qmT, i);
    if (localp == null)
    {
      ae.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By taskId = ".concat(String.valueOf(paramLong)));
      this.qmT.finishBroadcast();
      AppMethodBeat.o(23744);
      return;
    }
    try
    {
      localp.cni().a(paramLong, paramInt1, paramInt2, paramString, localp);
      if (!a(this.qmT, paramLong, localp, i)) {
        ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB failed!!!");
      }
      this.qmT.finishBroadcast();
      AppMethodBeat.o(23744);
      return;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onTaskEnd Error!!!");
        ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramString, "", new Object[0]);
      }
    }
  }
  
  private boolean f(int paramInt, j paramj)
  {
    AppMethodBeat.i(23730);
    if (paramj == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
      paramj = new IllegalArgumentException("scanImp: null == aCallback");
      AppMethodBeat.o(23730);
      throw paramj;
    }
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnscanCallback");
    boolean bool = this.qmU.register(paramj);
    if (!bool) {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.register Failed!!!");
    }
    for (;;)
    {
      if (!bool) {
        try
        {
          paramj.a(0, -1, "scanImp: registScanCallback failed!!!", "", "", 0, null);
          AppMethodBeat.o(23730);
          return false;
          this.qmZ += 1;
        }
        catch (RemoteException paramj)
        {
          for (;;)
          {
            ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", new Object[] { paramj.getMessage() });
            ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramj, "", new Object[0]);
          }
        }
      }
    }
    a locala = this.qmR;
    ae.i("MicroMsg.exdevice.BTDeviceManager", "------scan------ bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (!b.a(paramInt, locala, new int[0]))
    {
      ae.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.scan Failed!!!");
      bool = false;
    }
    for (;;)
    {
      if (!bool) {
        ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.scan Failed!!!");
      }
      try
      {
        paramj.a(0, -1, "scanImp: mBTDeviceMrg.scan failed!!!", "", "", 0, null);
        if (!c(paramj)) {
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
        }
        AppMethodBeat.o(23730);
        return bool;
        bool = true;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", new Object[] { localRemoteException.getMessage() });
          ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
        }
      }
    }
  }
  
  private boolean g(int paramInt, j paramj)
  {
    AppMethodBeat.i(23732);
    if (paramj == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
      AppMethodBeat.o(23732);
      return false;
    }
    boolean bool = a.CO(paramInt);
    if (!bool) {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
    }
    try
    {
      paramj.a(0, -1, "stopScanImp: mBTDeviceMrg.stopScan failed!!!", "", "", 0, null);
      if (!c(paramj)) {
        ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
      }
      AppMethodBeat.o(23732);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp: aCallback.onScanCallback failed!!!, %s", new Object[] { localRemoteException.getMessage() });
        ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  public final long a(p paramp)
  {
    AppMethodBeat.i(23739);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTask");
    if (paramp == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
      AppMethodBeat.o(23739);
      return -1L;
    }
    l locall = this.qmY;
    if (9223372036854775807L == locall.qmk)
    {
      ae.w("MicroMsg.TaskId", "TaskId Data-overrun!!!");
      locall.qmk = 0L;
    }
    long l = locall.qmk;
    locall.qmk = (1L + l);
    paramp = new k(l, paramp);
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(0, paramp)))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! messsage what  = %d", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(23739);
      return -1L;
    }
    AppMethodBeat.o(23739);
    return l;
  }
  
  public final void a(double paramDouble, com.tencent.mm.plugin.d.a.a.c paramc)
  {
    AppMethodBeat.i(23750);
    if (paramc == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aContext is null");
      AppMethodBeat.o(23750);
      return;
    }
    h localh = paramc.nUP.nUT;
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onRangingCallback, distance = %f, uuid = %s, major = %d, minor = %d ,minor&0xFFFF = %d", new Object[] { Double.valueOf(paramDouble), com.tencent.mm.plugin.exdevice.k.b.bf(localh.nVu), Short.valueOf(localh.nVv), Short.valueOf(localh.nVw), Integer.valueOf(localh.nVw & 0xFFFF) });
    try
    {
      int j = this.qmW.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((q)this.qmW.getBroadcastItem(i)).a(paramDouble, localh.nVv, localh.nVw, localh.nVu, paramc.nUQ, paramc.nUP.nUT.nVx, paramc.cPk);
            i += 1;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.getBroadcastItem failed!!!, i = %d, (%s)", new Object[] { Integer.valueOf(i), localRemoteException.toString() });
              ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramc)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "[shakezb] beginBroadcast fail!", new Object[] { paramc.toString() });
      ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramc, "", new Object[0]);
      return;
    }
    finally
    {
      this.qmW.finishBroadcast();
      AppMethodBeat.o(23750);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23743);
    int j = this.qmU.beginBroadcast();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label129;
      }
      try
      {
        ((j)this.qmU.getBroadcastItem(i)).a(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3, paramArrayOfByte);
        if ((2 == paramInt1) && (!this.qmU.unregister(this.qmU.getBroadcastItem(i)))) {
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mCBListOnScanCallback.unregister failed!!!");
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception i = ".concat(String.valueOf(i)));
          ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
        }
      }
      i += 1;
    }
    label129:
    this.qmU.finishBroadcast();
    AppMethodBeat.o(23743);
  }
  
  public final void a(int paramInt, long paramLong, short paramShort1, short paramShort2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23746);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDeviceRequest errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Short.valueOf(paramShort1), Short.valueOf(paramShort2), Integer.valueOf(i) });
      b localb = new b((byte)0);
      localb.qmh = paramShort2;
      localb.qgA = paramArrayOfByte;
      localb.nZd = paramLong;
      localb.qgG = paramShort1;
      localb.mErrorCode = paramInt;
      if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(6, localb))) {
        ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(6) });
      }
      AppMethodBeat.o(23746);
      return;
    }
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(23747);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChange deviceId = " + paramLong + " oldState" + paramInt1 + " newState = " + paramInt2 + " errCode = " + paramInt3);
    c localc = new c((byte)0);
    localc.nZd = paramLong;
    localc.qmi = paramInt1;
    localc.qmj = paramInt2;
    localc.qgz = paramInt3;
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(5, localc))) {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, messagewhat = %d", new Object[] { Integer.valueOf(5) });
    }
    AppMethodBeat.o(23747);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(23752);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registExDeviceInvokerHandler");
    if (!this.qmX.register(paramn)) {
      ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.register failed!!!");
    }
    AppMethodBeat.o(23752);
  }
  
  public final boolean a(long paramLong, int paramInt, k paramk)
  {
    AppMethodBeat.i(23736);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannel deviceId = %d, bluetoothVersion = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramk == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == callback");
      AppMethodBeat.o(23736);
      return false;
    }
    if (paramLong < 0L)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23736);
      return false;
    }
    if ((1 != paramInt) && (paramInt != 0))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(23736);
      return false;
    }
    paramk = new j(paramLong, paramInt, paramk);
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(3, paramk)))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(23736);
      return false;
    }
    AppMethodBeat.o(23736);
    return true;
  }
  
  public final boolean a(i parami)
  {
    AppMethodBeat.i(23741);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnDeviceRequest");
    boolean bool = this.qmV.register(parami);
    if (!bool) {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.register Failed!!!");
    }
    AppMethodBeat.o(23741);
    return bool;
  }
  
  public final boolean a(s params)
  {
    AppMethodBeat.i(23757);
    if (params == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
      AppMethodBeat.o(23757);
      return false;
    }
    boolean bool = this.qne.register(params);
    if (!bool) {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBluetoothRegistOnRecv error");
    }
    AppMethodBeat.o(23757);
    return bool;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, q paramq)
  {
    AppMethodBeat.i(23749);
    if ((Build.VERSION.SDK_INT < 18) || (this.qna == null))
    {
      AppMethodBeat.o(23749);
      return false;
    }
    boolean bool = ak.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if ((!bool) || (localObject == null))
    {
      AppMethodBeat.o(23749);
      return false;
    }
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
    if (!this.qmW.register(paramq))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.register failed!!!");
      AppMethodBeat.o(23749);
      return false;
    }
    for (;;)
    {
      com.tencent.mm.plugin.d.a.a.f localf;
      try
      {
        localObject = UUID.fromString(paramString);
        localf = this.qna;
        com.tencent.mm.plugin.d.a.a.f.nUY = ak.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
        if (localObject == null)
        {
          paramString = "";
          ae.d("MicroMsg.exdevice.IBeaconServer", "Ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
          if (localObject != null) {
            break label248;
          }
          ae.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
          paramBoolean = false;
          if (!paramBoolean) {
            break;
          }
          AppMethodBeat.o(23749);
          return true;
        }
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "UUID.fromString failed!!!, (%s)", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(23749);
        return false;
      }
      paramString = ((UUID)localObject).toString();
      continue;
      label248:
      if (paramBoolean) {
        paramBoolean = localf.mHandler.post(new f.6(localf, (UUID)localObject));
      } else {
        paramBoolean = localf.mHandler.post(new f.7(localf, (UUID)localObject));
      }
    }
    ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mIBeaconServer.ranging failed!!!");
    if (!this.qmW.unregister(paramq)) {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.unregister failed!!!");
    }
    AppMethodBeat.o(23749);
    return false;
  }
  
  public final boolean b(final int paramInt, final j paramj)
  {
    AppMethodBeat.i(23729);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---scan--- aBluetoothVersion = ".concat(String.valueOf(paramInt)));
    if (paramj == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
      AppMethodBeat.o(23729);
      return false;
    }
    boolean bool = this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23723);
        if (!y.a(y.this, paramInt, paramj)) {
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scanImp failed!!!");
        }
        AppMethodBeat.o(23723);
      }
    });
    if (!bool) {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan: mHandler.post failed!!!");
    }
    AppMethodBeat.o(23729);
    return bool;
  }
  
  public final boolean b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    AppMethodBeat.i(23761);
    ae.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl. mac=%d, oldstate = %d, newsate=%d, errcode=%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    int i = this.qnd.beginBroadcast();
    k localk = (k)a(paramLong1, this.qnd, i);
    if (localk == null)
    {
      ae.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = ".concat(String.valueOf(paramLong1)));
      this.qnd.finishBroadcast();
      AppMethodBeat.o(23761);
      return false;
    }
    try
    {
      localk.a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
      ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
      return false;
    }
    finally
    {
      this.qnd.finishBroadcast();
      AppMethodBeat.o(23761);
    }
  }
  
  public final boolean b(long paramLong, int paramInt, k paramk)
  {
    AppMethodBeat.i(23755);
    if (paramk == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
      AppMethodBeat.o(23755);
      return false;
    }
    if (paramLong < 0L)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23755);
      return false;
    }
    if (paramInt != 0)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(23755);
      return false;
    }
    e locale = new e((byte)0);
    locale.qjy = paramLong;
    locale.qnk = paramInt;
    locale.qnl = paramk;
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(7, locale)))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(7) });
      AppMethodBeat.o(23755);
      return false;
    }
    AppMethodBeat.o(23755);
    return true;
  }
  
  public final boolean b(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    AppMethodBeat.i(23758);
    if (0L > paramLong)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mac < 0");
      AppMethodBeat.o(23758);
      return false;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "data is empty");
      AppMethodBeat.o(23758);
      return false;
    }
    if (paramt == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
      AppMethodBeat.o(23758);
      return false;
    }
    i locali = new i((byte)0);
    locali.qjy = paramLong;
    locali.mData = paramArrayOfByte;
    locali.qno = paramt;
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(10, locali)))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(10) });
      AppMethodBeat.o(23758);
      return false;
    }
    AppMethodBeat.o(23758);
    return true;
  }
  
  public final boolean b(i parami)
  {
    AppMethodBeat.i(23742);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnDeviceRequest");
    boolean bool = this.qmV.unregister(parami);
    if (!bool) {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.unregister Failed!!!");
    }
    AppMethodBeat.o(23742);
    return bool;
  }
  
  public final void c(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(23745);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEnd taskId = %d, errTpye = %d, errCode = %d, errMsg = %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    d locald = new d();
    locald.qmk = paramLong;
    locald.qgL = paramInt1;
    locald.qgz = paramInt2;
    locald.kwn = paramString;
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2, locald))) {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, MessageWhat = %d", new Object[] { Integer.valueOf(2) });
    }
    AppMethodBeat.o(23745);
  }
  
  public final boolean c(final int paramInt, final j paramj)
  {
    AppMethodBeat.i(23731);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---stopScan--- aBluetoothVersion = ".concat(String.valueOf(paramInt)));
    if (paramj == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback");
      AppMethodBeat.o(23731);
      return false;
    }
    boolean bool = this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23724);
        if (!y.b(y.this, paramInt, paramj)) {
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp failed!!!");
        }
        AppMethodBeat.o(23724);
      }
    });
    if (!bool) {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScan: mHandler.post failed!!!");
    }
    AppMethodBeat.o(23731);
    return bool;
  }
  
  public final boolean c(long paramLong, int paramInt, k paramk)
  {
    AppMethodBeat.i(23759);
    ae.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl. mac=%d, bTVersion=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (!a(this.qnd, paramLong, paramk))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register connect callback error");
      try
      {
        paramk.a(paramLong, -1, 4, -1, 0L);
        AppMethodBeat.o(23759);
        return false;
      }
      catch (RemoteException paramk)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramk, "", new Object[0]);
        }
      }
    }
    try
    {
      paramk.a(paramLong, -1, 1, -1, 0L);
      if (this.qng != null)
      {
        com.tencent.mm.plugin.d.a.b.e locale = this.qng;
        ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "connect. mac = %d", new Object[] { Long.valueOf(paramLong) });
        if (!locale.bNE())
        {
          ae.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
          bool = false;
          if (bool) {
            break label351;
          }
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "connect device(mac=%d) error", new Object[] { Long.valueOf(paramLong) });
          if (paramk == null) {}
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      try
      {
        for (;;)
        {
          paramk.a(paramLong, 1, 4, -1, 0L);
          AppMethodBeat.o(23759);
          return false;
          localRemoteException = localRemoteException;
          ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
          continue;
          com.tencent.mm.plugin.d.a.b.f localf = (com.tencent.mm.plugin.d.a.b.f)localRemoteException.nVF.get(Long.valueOf(paramLong));
          if (localf != null)
          {
            ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session(mac=%s) has been in map");
            bool = localf.connect();
          }
          else
          {
            localf = new com.tencent.mm.plugin.d.a.b.f(paramLong, localRemoteException.IR, localRemoteException.nWq);
            if (!localf.connect()) {
              break;
            }
            localRemoteException.ab(new e.4(localRemoteException, paramLong, localf));
            bool = true;
          }
        }
        ae.e("MicroMsg.exdevice.BluetoothLESimpleManager", "tmpConnectForScan error");
        boolean bool = false;
      }
      catch (RemoteException paramk)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramk, "", new Object[0]);
        }
      }
      label351:
      AppMethodBeat.o(23759);
    }
    return true;
  }
  
  public final boolean c(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    AppMethodBeat.i(23760);
    ae.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl. mac=%d, data=%s", new Object[] { Long.valueOf(paramLong), com.tencent.mm.plugin.exdevice.k.b.bf(paramArrayOfByte) });
    if (this.qng != null)
    {
      Object localObject = this.qng;
      ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "writeData. mac = %d", new Object[] { Long.valueOf(paramLong) });
      boolean bool;
      if (!((com.tencent.mm.plugin.d.a.b.e)localObject).bNE())
      {
        ae.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
        bool = false;
      }
      for (;;)
      {
        if (!bool)
        {
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "writeData error");
          if (paramt != null) {}
          try
          {
            paramt.b(paramLong, -1, -1, "start write data error");
            AppMethodBeat.o(23760);
            return false;
            localObject = (com.tencent.mm.plugin.d.a.b.f)((com.tencent.mm.plugin.d.a.b.e)localObject).nVF.get(Long.valueOf(paramLong));
            if (localObject == null)
            {
              ae.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session is null, may be this session is closed");
              bool = false;
            }
            else
            {
              ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeData------parserobj, length = %d, mac=%s, name=%s", new Object[] { Integer.valueOf(paramArrayOfByte.length), com.tencent.mm.plugin.exdevice.k.b.vf(((com.tencent.mm.plugin.d.a.b.f)localObject).mSessionId), ((com.tencent.mm.plugin.d.a.b.f)localObject).kKg.getName() });
              bool = ((com.tencent.mm.plugin.d.a.b.f)localObject).mHandler.sendMessage(((com.tencent.mm.plugin.d.a.b.f)localObject).mHandler.obtainMessage(3, paramArrayOfByte));
            }
          }
          catch (RemoteException paramArrayOfByte)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramArrayOfByte, "", new Object[0]);
            }
          }
        }
      }
    }
    if (!a(this.qnf, paramLong, paramt))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register on send end callback error");
      AppMethodBeat.o(23760);
      return false;
    }
    AppMethodBeat.o(23760);
    return true;
  }
  
  public final long[] cmY()
  {
    AppMethodBeat.i(23733);
    long[] arrayOfLong = a.cmY();
    AppMethodBeat.o(23733);
    return arrayOfLong;
  }
  
  public final boolean d(int paramInt, j paramj)
  {
    AppMethodBeat.i(23753);
    ae.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothScan. bluetoothVersion=%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramj == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan callback is null. just return");
      AppMethodBeat.o(23753);
      return false;
    }
    if (paramInt != 0)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "this is not ble scan cmd");
      AppMethodBeat.o(23753);
      return false;
    }
    boolean bool3 = this.qnc.register(paramj);
    if (bool3) {
      ae.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback ok");
    }
    for (;;)
    {
      if (this.qng != null)
      {
        com.tencent.mm.plugin.d.a.b.e locale = this.qng;
        ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble scan");
        boolean bool1;
        if (locale.nVH != null)
        {
          bool1 = true;
          label120:
          Assert.assertTrue(bool1);
          if (locale.bNE()) {
            break label212;
          }
          ae.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
          bool1 = false;
          label143:
          if (bool1) {
            break label289;
          }
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simple ble scan fail");
        }
        try
        {
          paramj.a(0, -1, "simpleBLE.scan failed!!!", "", "", 0, null);
          if (bool3) {
            this.qnc.unregister(paramj);
          }
          AppMethodBeat.o(23753);
          return false;
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback fail");
          continue;
          bool1 = false;
          break label120;
          label212:
          boolean bool2 = locale.nVH.a(true, locale.nVK);
          bool1 = bool2;
          if (!bool2) {
            break label143;
          }
          locale.nWo.clear();
          bool1 = bool2;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.scan callback failed!!!, %s", new Object[] { localRemoteException.getMessage() });
            ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
          }
        }
      }
    }
    label289:
    AppMethodBeat.o(23753);
    return true;
  }
  
  /* Error */
  public final boolean d(long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: sipush 23763
    //   6: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_3
    //   10: ifnonnull +105 -> 115
    //   13: ldc_w 1016
    //   16: astore 6
    //   18: ldc 192
    //   20: ldc_w 1018
    //   23: iconst_2
    //   24: anewarray 196	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: lload_1
    //   30: invokestatic 202	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: aload 6
    //   38: aastore
    //   39: invokestatic 341	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: getfield 128	com/tencent/mm/plugin/exdevice/service/y:qne	Landroid/os/RemoteCallbackList;
    //   46: invokevirtual 251	android/os/RemoteCallbackList:beginBroadcast	()I
    //   49: istore 5
    //   51: ldc 192
    //   53: ldc_w 1020
    //   56: iconst_1
    //   57: anewarray 196	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: iload 5
    //   64: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: invokestatic 341	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: iload 4
    //   73: iload 5
    //   75: if_icmpge +97 -> 172
    //   78: aload_0
    //   79: getfield 128	com/tencent/mm/plugin/exdevice/service/y:qne	Landroid/os/RemoteCallbackList;
    //   82: iload 4
    //   84: invokevirtual 255	android/os/RemoteCallbackList:getBroadcastItem	(I)Landroid/os/IInterface;
    //   87: checkcast 1022	com/tencent/mm/plugin/exdevice/service/s
    //   90: astore 6
    //   92: aload 6
    //   94: ifnull +30 -> 124
    //   97: aload 6
    //   99: lload_1
    //   100: aload_3
    //   101: invokeinterface 1025 4 0
    //   106: iload 4
    //   108: iconst_1
    //   109: iadd
    //   110: istore 4
    //   112: goto -41 -> 71
    //   115: aload_3
    //   116: invokestatic 638	com/tencent/mm/plugin/exdevice/k/b:bf	([B)Ljava/lang/String;
    //   119: astore 6
    //   121: goto -103 -> 18
    //   124: ldc 192
    //   126: ldc_w 1027
    //   129: invokestatic 233	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -26 -> 106
    //   135: astore_3
    //   136: ldc 192
    //   138: ldc_w 1029
    //   141: invokestatic 233	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: ldc 192
    //   146: aload_3
    //   147: ldc_w 277
    //   150: iconst_0
    //   151: anewarray 196	java/lang/Object
    //   154: invokestatic 281	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_0
    //   158: getfield 128	com/tencent/mm/plugin/exdevice/service/y:qne	Landroid/os/RemoteCallbackList;
    //   161: invokevirtual 284	android/os/RemoteCallbackList:finishBroadcast	()V
    //   164: sipush 23763
    //   167: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: iconst_1
    //   171: ireturn
    //   172: aload_0
    //   173: getfield 128	com/tencent/mm/plugin/exdevice/service/y:qne	Landroid/os/RemoteCallbackList;
    //   176: invokevirtual 284	android/os/RemoteCallbackList:finishBroadcast	()V
    //   179: goto -15 -> 164
    //   182: astore_3
    //   183: aload_0
    //   184: getfield 128	com/tencent/mm/plugin/exdevice/service/y:qne	Landroid/os/RemoteCallbackList;
    //   187: invokevirtual 284	android/os/RemoteCallbackList:finishBroadcast	()V
    //   190: sipush 23763
    //   193: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_3
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	y
    //   0	198	1	paramLong	long
    //   0	198	3	paramArrayOfByte	byte[]
    //   1	110	4	i	int
    //   49	27	5	j	int
    //   16	104	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   78	92	135	android/os/RemoteException
    //   97	106	135	android/os/RemoteException
    //   124	132	135	android/os/RemoteException
    //   78	92	182	finally
    //   97	106	182	finally
    //   124	132	182	finally
    //   136	157	182	finally
  }
  
  public final boolean e(int paramInt, j paramj)
  {
    AppMethodBeat.i(23754);
    ae.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothStopScan. bluetoothVersion=%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramj == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan callback is null. just return");
      AppMethodBeat.o(23754);
      return false;
    }
    if (this.qng == null)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan mBLESimpleMgr is null. just return");
      AppMethodBeat.o(23754);
      return false;
    }
    com.tencent.mm.plugin.d.a.b.e locale = this.qng;
    ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble stop scan");
    boolean bool;
    if (locale.nVH != null) {
      bool = true;
    }
    for (;;)
    {
      Assert.assertTrue(bool);
      if (!locale.bNE())
      {
        ae.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
        bool = false;
        if (!bool) {
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
        }
      }
      try
      {
        paramj.a(0, -1, "simpleBLE.stopScan failed!!!", "", "", 0, null);
        AppMethodBeat.o(23754);
        return bool;
        bool = false;
        continue;
        locale.mHandler.removeCallbacks(locale.mRunnable);
        bool = locale.nVH.a(false, locale.nVK);
      }
      catch (RemoteException paramj)
      {
        for (;;)
        {
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.onScanCallback failed!!!, %s", new Object[] { paramj.getMessage() });
          ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramj, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean e(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(23762);
    ae.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl. mac=%d, errType = %d, errCode=%d, errMsg=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    int i = this.qnf.beginBroadcast();
    t localt = (t)a(paramLong, this.qnf, i);
    if (localt == null)
    {
      ae.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = ".concat(String.valueOf(paramLong)));
      this.qnf.finishBroadcast();
      AppMethodBeat.o(23762);
      return false;
    }
    try
    {
      localt.b(paramLong, paramInt1, paramInt2, paramString);
      return true;
    }
    catch (RemoteException paramString)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onSendEnd Failed!!!");
      ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramString, "", new Object[0]);
      return false;
    }
    finally
    {
      this.qnf.finishBroadcast();
      AppMethodBeat.o(23762);
    }
  }
  
  public final void setChannelSessionKey(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23748);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---setChannelSessionKey--- deviceId = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = this.qmR;
    ae.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKey------ deviceId = %d", new Object[] { Long.valueOf(paramLong) });
    paramArrayOfByte = new a.f(paramLong, paramArrayOfByte);
    if (!locala.mHandler.sendMessage(locala.mHandler.obtainMessage(10, paramArrayOfByte))) {
      ae.e("MicroMsg.exdevice.BTDeviceManager", "mHandler.sendMessage failed!!! messageWhat = %d", new Object[] { Integer.valueOf(10) });
    }
    AppMethodBeat.o(23748);
  }
  
  public final boolean va(long paramLong)
  {
    AppMethodBeat.i(23737);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannel deviceId = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramLong < 0L)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23737);
      return false;
    }
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Long.valueOf(paramLong))))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", new Object[] { Integer.valueOf(4) });
      AppMethodBeat.o(23737);
      return false;
    }
    AppMethodBeat.o(23737);
    return true;
  }
  
  public final boolean vb(long paramLong)
  {
    return false;
  }
  
  public final boolean vc(long paramLong)
  {
    AppMethodBeat.i(23740);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask, task Id = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramLong < 0L)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
      AppMethodBeat.o(23740);
      return false;
    }
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1, Long.valueOf(paramLong))))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage, message what = %d", new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(23740);
      return false;
    }
    AppMethodBeat.o(23740);
    return true;
  }
  
  public final boolean vd(long paramLong)
  {
    AppMethodBeat.i(23756);
    if (paramLong < 0L)
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23756);
      return false;
    }
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(8, Long.valueOf(paramLong))))
    {
      ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(8) });
      AppMethodBeat.o(23756);
      return false;
    }
    AppMethodBeat.o(23756);
    return true;
  }
  
  public final void zg(int paramInt)
  {
    AppMethodBeat.i(23751);
    ae.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "OnBluetoothStateChange, state = %d", new Object[] { Integer.valueOf(paramInt) });
    int i = this.qmX.beginBroadcast() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_state", paramInt);
        try
        {
          ((n)this.qmX.getBroadcastItem(i)).o(0, localBundle);
          i -= 1;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.getBroadcastItem(%d).onExdeviceInvoke failed!!!", new Object[] { Integer.valueOf(i) });
            ae.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
          }
        }
      }
    }
    this.qmX.finishBroadcast();
    AppMethodBeat.o(23751);
  }
  
  final class a
    extends aq
  {
    public a(String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(23725);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(23725);
        return;
        paramMessage = (y.d)paramMessage.obj;
        y.a(y.this, paramMessage.qmk, paramMessage.qgL, paramMessage.qgz, paramMessage.kwn);
        AppMethodBeat.o(23725);
        return;
        paramMessage = (y.k)paramMessage.obj;
        if (!y.a(y.this, paramMessage.qmk, paramMessage.qnq)) {
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp failed!!!");
        }
        AppMethodBeat.o(23725);
        return;
        long l = ((Long)paramMessage.obj).longValue();
        if (!y.a(y.this, l)) {
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp failed!!!");
        }
        AppMethodBeat.o(23725);
        return;
        paramMessage = (y.c)paramMessage.obj;
        y.a(y.this, paramMessage.nZd, paramMessage.qmi, paramMessage.qmj, paramMessage.qgz);
        AppMethodBeat.o(23725);
        return;
        paramMessage = (y.j)paramMessage.obj;
        if (!y.a(y.this, paramMessage.nZd, paramMessage.qnp, paramMessage.qnl)) {
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp failed!!!");
        }
        AppMethodBeat.o(23725);
        return;
        if (!y.b(y.this, ((Long)paramMessage.obj).longValue()))
        {
          ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp failed!!!");
          AppMethodBeat.o(23725);
          return;
          paramMessage = (y.b)paramMessage.obj;
          y.a(y.this, paramMessage.mErrorCode, paramMessage.nZd, paramMessage.qgG, paramMessage.qmh, paramMessage.qgA);
          AppMethodBeat.o(23725);
          return;
          paramMessage = (y.e)paramMessage.obj;
          if (!y.this.c(paramMessage.qjy, paramMessage.qnk, paramMessage.qnl)) {
            ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl error");
          }
          AppMethodBeat.o(23725);
          return;
          l = ((Long)paramMessage.obj).longValue();
          paramMessage = y.this;
          ae.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTDisonnectImpl. mac=%d", new Object[] { Long.valueOf(l) });
          if (paramMessage.qng != null)
          {
            paramMessage = paramMessage.qng;
            ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnect. mac = %d", new Object[] { Long.valueOf(l) });
            if (!paramMessage.bNE())
            {
              ae.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
              AppMethodBeat.o(23725);
              return;
            }
            paramMessage.ab(new e.5(paramMessage, l));
          }
          AppMethodBeat.o(23725);
          return;
          paramMessage = (y.c)paramMessage.obj;
          if (!y.this.b(paramMessage.nZd, paramMessage.qmi, paramMessage.qmj, paramMessage.qgz, paramMessage.nWB)) {
            ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl error");
          }
          AppMethodBeat.o(23725);
          return;
          paramMessage = (y.i)paramMessage.obj;
          if (!y.this.c(paramMessage.qjy, paramMessage.mData, paramMessage.qno)) {
            ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl error");
          }
          AppMethodBeat.o(23725);
          return;
          paramMessage = (y.h)paramMessage.obj;
          if (!y.this.e(paramMessage.qjy, paramMessage.qgL, paramMessage.qgz, paramMessage.kwn)) {
            ae.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl error");
          }
          AppMethodBeat.o(23725);
          return;
          paramMessage = (y.f)paramMessage.obj;
          y.this.d(paramMessage.qjy, paramMessage.mData);
          AppMethodBeat.o(23725);
          return;
          paramMessage = (y.g)paramMessage.obj;
          y.a(y.this, paramMessage);
        }
      }
    }
  }
  
  static final class b
  {
    int mErrorCode = 0;
    long nZd = 0L;
    byte[] qgA = null;
    short qgG = 0;
    short qmh = 0;
  }
  
  static final class c
  {
    long nWB = 0L;
    long nZd = 0L;
    int qgz = 0;
    int qmi = 0;
    int qmj = 0;
  }
  
  static final class d
  {
    String kwn = null;
    int qgL = 0;
    int qgz = 0;
    long qmk = 0L;
  }
  
  static final class e
  {
    public long qjy;
    public int qnk;
    public k qnl;
  }
  
  static final class f
  {
    public byte[] mData;
    public long qjy;
  }
  
  static final class g
  {
    int kKi;
    String mDeviceName;
    String nZh;
    boolean qnm;
    byte[] qnn;
  }
  
  static final class h
  {
    public String kwn;
    public int qgL;
    public int qgz;
    public long qjy;
  }
  
  static final class i
  {
    public byte[] mData;
    public long qjy;
    public t qno;
  }
  
  static final class j
  {
    long nZd;
    k qnl;
    int qnp;
    
    public j(long paramLong, int paramInt, k paramk)
    {
      this.nZd = paramLong;
      this.qnp = paramInt;
      this.qnl = paramk;
    }
  }
  
  static final class k
  {
    long qmk;
    p qnq;
    
    public k(long paramLong, p paramp)
    {
      this.qmk = paramLong;
      this.qnq = paramp;
    }
  }
  
  static final class l
  {
    long qmk = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.y
 * JD-Core Version:    0.7.0.1
 */