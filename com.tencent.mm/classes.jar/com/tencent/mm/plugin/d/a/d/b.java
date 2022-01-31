package com.tencent.mm.plugin.d.a.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.d.a.b.g;
import com.tencent.mm.plugin.d.a.c.a;
import com.tencent.mm.plugin.d.a.c.a.a;
import com.tencent.mm.plugin.d.a.c.a.b;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashSet;
import junit.framework.Assert;

public final class b
{
  public com.tencent.mm.plugin.d.a.b.b jRi;
  public a jRj;
  c jRk;
  final HashSet<String> jRl;
  private ak mHandler;
  
  public b(Context paramContext, c paramc, al paramal)
  {
    AppMethodBeat.i(18513);
    this.mHandler = null;
    this.jRi = null;
    this.jRj = null;
    this.jRk = null;
    this.jRl = new HashSet();
    this.jRj = new a(paramal);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.jRi = new com.tencent.mm.plugin.d.a.b.b(paramal);
      paramal = this.jRi;
      localObject = new b.b(this);
      ab.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramal.mIsInit)
      {
        paramal.mIsInit = true;
        paramal.zF = paramContext;
        paramal.jNN = ((com.tencent.mm.plugin.d.a.b.b.a)localObject);
        paramal.jNQ = com.tencent.mm.plugin.d.a.b.c.aVV();
        if (d.fv(21)) {
          paramal.jNR = g.aWa();
        }
        if (paramal.aVT()) {
          break label305;
        }
        ab.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
      }
    }
    for (;;)
    {
      paramal = this.jRj;
      localObject = new b.a(this);
      ab.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramal.mIsInit)
      {
        paramal.mIsInit = true;
        paramal.jQL = ((a.a)localObject);
        paramal.jQM = paramContext;
        paramContext = new IntentFilter();
        paramContext.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        paramContext.addAction("android.bluetooth.device.action.FOUND");
        paramContext.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
        paramContext.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        paramal.jQM.registerReceiver(paramal.jQN, paramContext);
        paramal.jNi = BluetoothAdapter.getDefaultAdapter();
      }
      this.mHandler = new b.c(v.bqB().fPW.oNc.getLooper(), this);
      this.jRk = paramc;
      AppMethodBeat.o(18513);
      return;
      label305:
      paramal.jNi = ((BluetoothManager)paramal.zF.getSystemService("bluetooth")).getAdapter();
    }
  }
  
  public final void c(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(18515);
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + paramLong1 + "aBluetoothVersion = " + paramInt);
    switch (paramInt)
    {
    default: 
      Assert.assertTrue(false);
      AppMethodBeat.o(18515);
      return;
    case 1: 
      if (this.jRj == null)
      {
        ab.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        AppMethodBeat.o(18515);
        return;
      }
      localObject = this.jRj;
      ab.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
      Assert.assertTrue(((a)localObject).mIsInit);
      if (!((a)localObject).aWc())
      {
        ab.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
        AppMethodBeat.o(18515);
        return;
      }
      Assert.assertTrue(((a)localObject).mHandler.post(new a.b((a)localObject, paramLong1, paramLong2)));
      AppMethodBeat.o(18515);
      return;
    }
    if (this.jRi == null)
    {
      ab.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      AppMethodBeat.o(18515);
      return;
    }
    Object localObject = this.jRi;
    ab.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    Assert.assertTrue(((com.tencent.mm.plugin.d.a.b.b)localObject).mIsInit);
    if (!((com.tencent.mm.plugin.d.a.b.b)localObject).aVT())
    {
      ab.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
      AppMethodBeat.o(18515);
      return;
    }
    Assert.assertTrue(((com.tencent.mm.plugin.d.a.b.b)localObject).mHandler.post(new com.tencent.mm.plugin.d.a.b.b.b((com.tencent.mm.plugin.d.a.b.b)localObject, paramLong1, paramLong2)));
    AppMethodBeat.o(18515);
  }
  
  public final boolean d(int paramInt, int... paramVarArgs)
  {
    AppMethodBeat.i(18514);
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      Assert.assertTrue(false);
      AppMethodBeat.o(18514);
      return false;
    case 1: 
      if (this.jRj == null)
      {
        ab.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        AppMethodBeat.o(18514);
        return false;
      }
      bool = this.jRj.fK(true);
      AppMethodBeat.o(18514);
      return bool;
    }
    if (this.jRi == null)
    {
      ab.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      AppMethodBeat.o(18514);
      return false;
    }
    if (paramVarArgs == null)
    {
      bool = this.jRi.a(true, new int[0]);
      AppMethodBeat.o(18514);
      return bool;
    }
    boolean bool = this.jRi.a(true, paramVarArgs);
    AppMethodBeat.o(18514);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.d.b
 * JD-Core Version:    0.7.0.1
 */