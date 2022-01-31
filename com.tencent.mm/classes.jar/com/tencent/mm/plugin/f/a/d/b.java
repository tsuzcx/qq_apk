package com.tencent.mm.plugin.f.a.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.plugin.f.a.b.g;
import com.tencent.mm.plugin.f.a.c.a;
import com.tencent.mm.plugin.f.a.c.a.a;
import com.tencent.mm.plugin.f.a.c.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import junit.framework.Assert;

public final class b
{
  public com.tencent.mm.plugin.f.a.b.b hXp = null;
  public a hXq = null;
  c hXr = null;
  final HashSet<String> hXs = new HashSet();
  private ah mHandler = null;
  
  public b(Context paramContext, c paramc, ai paramai)
  {
    this.hXq = new a(paramai);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.hXp = new com.tencent.mm.plugin.f.a.b.b(paramai);
      paramai = this.hXp;
      localObject = new b.b(this);
      y.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramai.mIsInit)
      {
        paramai.mIsInit = true;
        paramai.ze = paramContext;
        paramai.hTT = ((com.tencent.mm.plugin.f.a.b.b.a)localObject);
        paramai.hTW = com.tencent.mm.plugin.f.a.b.c.aws();
        if (d.gF(21)) {
          paramai.hTX = g.awx();
        }
        if (paramai.awq()) {
          break label293;
        }
        y.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
      }
    }
    for (;;)
    {
      paramai = this.hXq;
      localObject = new b.a(this);
      y.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramai.mIsInit)
      {
        paramai.mIsInit = true;
        paramai.hWS = ((a.a)localObject);
        paramai.hWT = paramContext;
        paramContext = new IntentFilter();
        paramContext.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        paramContext.addAction("android.bluetooth.device.action.FOUND");
        paramContext.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
        paramContext.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        paramai.hWT.registerReceiver(paramai.hWU, paramContext);
        paramai.hTo = BluetoothAdapter.getDefaultAdapter();
      }
      this.mHandler = new b.c(v.aMo().eAg.mnU.getLooper(), this);
      this.hXr = paramc;
      return;
      label293:
      paramai.hTo = ((BluetoothManager)paramai.ze.getSystemService("bluetooth")).getAdapter();
    }
  }
  
  public final boolean b(int paramInt, int... paramVarArgs)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = " + paramInt);
    switch (paramInt)
    {
    default: 
      Assert.assertTrue(false);
      return false;
    case 1: 
      if (this.hXq == null)
      {
        y.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        return false;
      }
      return this.hXq.ep(true);
    }
    if (this.hXp == null)
    {
      y.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      return false;
    }
    if (paramVarArgs == null) {
      return this.hXp.a(true, new int[0]);
    }
    return this.hXp.a(true, paramVarArgs);
  }
  
  public final void c(long paramLong1, long paramLong2, int paramInt)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + paramLong1 + "aBluetoothVersion = " + paramInt);
    switch (paramInt)
    {
    default: 
      Assert.assertTrue(false);
      return;
    case 1: 
      if (this.hXq == null)
      {
        y.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        return;
      }
      localObject = this.hXq;
      y.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
      Assert.assertTrue(((a)localObject).mIsInit);
      if (!((a)localObject).awz())
      {
        y.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
        return;
      }
      Assert.assertTrue(((a)localObject).mHandler.post(new a.b((a)localObject, paramLong1, paramLong2)));
      return;
    }
    if (this.hXp == null)
    {
      y.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      return;
    }
    Object localObject = this.hXp;
    y.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    Assert.assertTrue(((com.tencent.mm.plugin.f.a.b.b)localObject).mIsInit);
    if (!((com.tencent.mm.plugin.f.a.b.b)localObject).awq())
    {
      y.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
      return;
    }
    Assert.assertTrue(((com.tencent.mm.plugin.f.a.b.b)localObject).mHandler.post(new com.tencent.mm.plugin.f.a.b.b.b((com.tencent.mm.plugin.f.a.b.b)localObject, paramLong1, paramLong2)));
  }
  
  private static class e
  {
    long hXv;
    boolean hXw;
    
    public e(long paramLong, boolean paramBoolean)
    {
      this.hXv = paramLong;
      this.hXw = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.d.b
 * JD-Core Version:    0.7.0.1
 */