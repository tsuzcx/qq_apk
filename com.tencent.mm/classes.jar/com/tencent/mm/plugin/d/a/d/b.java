package com.tencent.mm.plugin.d.a.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.d.a.b.g;
import com.tencent.mm.plugin.d.a.c.a;
import com.tencent.mm.plugin.d.a.c.a.a;
import com.tencent.mm.plugin.d.a.c.a.b;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import junit.framework.Assert;

public final class b
{
  private ap mHandler;
  public com.tencent.mm.plugin.d.a.b.b nTs;
  public a nTt;
  c nTu;
  final HashSet<String> nTv;
  
  public b(Context paramContext, c paramc, ap paramap)
  {
    AppMethodBeat.i(179586);
    this.mHandler = null;
    this.nTs = null;
    this.nTt = null;
    this.nTu = null;
    this.nTv = new HashSet();
    this.nTt = new a(paramap);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.nTs = new com.tencent.mm.plugin.d.a.b.b(paramap.getSerialTag());
      paramap = this.nTs;
      localObject = new b();
      ad.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramap.mIsInit)
      {
        paramap.mIsInit = true;
        paramap.IR = paramContext;
        paramap.nPY = ((com.tencent.mm.plugin.d.a.b.b.a)localObject);
        paramap.nQb = com.tencent.mm.plugin.d.a.b.c.bMI();
        if (d.ly(21)) {
          paramap.nQc = g.bMN();
        }
        if (paramap.bMG()) {
          break label303;
        }
        ad.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
      }
    }
    for (;;)
    {
      paramap = this.nTt;
      localObject = new a();
      ad.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramap.mIsInit)
      {
        paramap.mIsInit = true;
        paramap.nSW = ((a.a)localObject);
        paramap.nSX = paramContext;
        paramContext = new IntentFilter();
        paramContext.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        paramContext.addAction("android.bluetooth.device.action.FOUND");
        paramContext.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
        paramContext.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        paramap.nSX.registerReceiver(paramap.mReceiver, paramContext);
        paramap.nPt = BluetoothAdapter.getDefaultAdapter();
      }
      this.mHandler = new c(v.clW().imu.getSerialTag(), this);
      this.nTu = paramc;
      AppMethodBeat.o(179586);
      return;
      label303:
      paramap.nPt = ((BluetoothManager)paramap.IR.getSystemService("bluetooth")).getAdapter();
    }
  }
  
  public final boolean d(int paramInt, int... paramVarArgs)
  {
    AppMethodBeat.i(22625);
    ad.i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      Assert.assertTrue(false);
      AppMethodBeat.o(22625);
      return false;
    case 1: 
      if (this.nTt == null)
      {
        ad.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        AppMethodBeat.o(22625);
        return false;
      }
      bool = this.nTt.jj(true);
      AppMethodBeat.o(22625);
      return bool;
    }
    if (this.nTs == null)
    {
      ad.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      AppMethodBeat.o(22625);
      return false;
    }
    if (paramVarArgs == null)
    {
      bool = this.nTs.a(true, new int[0]);
      AppMethodBeat.o(22625);
      return bool;
    }
    boolean bool = this.nTs.a(true, paramVarArgs);
    AppMethodBeat.o(22625);
    return bool;
  }
  
  public final void e(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(22626);
    ad.i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + paramLong1 + "aBluetoothVersion = " + paramInt);
    switch (paramInt)
    {
    default: 
      Assert.assertTrue(false);
      AppMethodBeat.o(22626);
      return;
    case 1: 
      if (this.nTt == null)
      {
        ad.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        AppMethodBeat.o(22626);
        return;
      }
      localObject = this.nTt;
      ad.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
      Assert.assertTrue(((a)localObject).mIsInit);
      if (!((a)localObject).bMP())
      {
        ad.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
        AppMethodBeat.o(22626);
        return;
      }
      Assert.assertTrue(((a)localObject).mHandler.post(new a.b((a)localObject, paramLong1, paramLong2)));
      AppMethodBeat.o(22626);
      return;
    }
    if (this.nTs == null)
    {
      ad.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      AppMethodBeat.o(22626);
      return;
    }
    Object localObject = this.nTs;
    ad.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    Assert.assertTrue(((com.tencent.mm.plugin.d.a.b.b)localObject).mIsInit);
    if (!((com.tencent.mm.plugin.d.a.b.b)localObject).bMG())
    {
      ad.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
      AppMethodBeat.o(22626);
      return;
    }
    Assert.assertTrue(((com.tencent.mm.plugin.d.a.b.b)localObject).mHandler.post(new com.tencent.mm.plugin.d.a.b.b.b((com.tencent.mm.plugin.d.a.b.b)localObject, paramLong1, paramLong2)));
    AppMethodBeat.o(22626);
  }
  
  final class a
    extends a.a
  {
    a() {}
    
    public final void b(long paramLong, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(22613);
      ad.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = ".concat(String.valueOf(paramLong)));
      paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 1, 1, paramArrayOfByte));
      AppMethodBeat.o(22613);
    }
    
    public final void bMH()
    {
      AppMethodBeat.i(22610);
      ad.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
      b.this.nTv.clear();
      Assert.assertTrue(b.a(b.this, 2, 1, null));
      AppMethodBeat.o(22610);
    }
    
    public final void c(long paramLong, int paramInt, String paramString)
    {
      AppMethodBeat.i(22615);
      ad.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + paramLong + " errorCode = " + paramInt + " errorInfo = " + paramString);
      paramString = new b.g(paramLong, paramInt, paramString);
      Assert.assertTrue(b.a(b.this, 5, 1, paramString));
      AppMethodBeat.o(22615);
    }
    
    public final void eG(String paramString1, String paramString2)
    {
      AppMethodBeat.i(22611);
      b localb = b.this;
      int i;
      if (paramString1 == null)
      {
        ad.e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
        i = 0;
      }
      while (i == 0)
      {
        AppMethodBeat.o(22611);
        return;
        if (localb.nTv.contains(paramString1))
        {
          i = 0;
        }
        else
        {
          localb.nTv.add(paramString1);
          i = 1;
        }
      }
      ad.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + paramString1 + "deviceName = " + paramString2);
      paramString1 = new b.i(paramString1, paramString2, 0, null);
      Assert.assertTrue(b.a(b.this, 3, 1, paramString1));
      AppMethodBeat.o(22611);
    }
    
    public final void i(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(22609);
      ad.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
      b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
      Assert.assertTrue(b.a(b.this, 6, 1, locald));
      AppMethodBeat.o(22609);
    }
    
    public final void l(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22612);
      ad.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
      b.f localf = new b.f(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 4, 1, localf));
      AppMethodBeat.o(22612);
    }
    
    public final void m(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22614);
      ad.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + paramLong + " success = " + paramBoolean);
      b.j localj = new b.j(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 0, 1, localj));
      AppMethodBeat.o(22614);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.d.a.b.b.a
  {
    b() {}
    
    public final void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(22618);
      ad.d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", new Object[] { paramString1, paramString2 });
      paramString1 = new b.i(paramString1, paramString2, paramInt, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 3, 0, paramString1));
      AppMethodBeat.o(22618);
    }
    
    public final void b(long paramLong, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(22620);
      ad.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = ".concat(String.valueOf(paramLong)));
      paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 1, 0, paramArrayOfByte));
      AppMethodBeat.o(22620);
    }
    
    public final void bMH()
    {
      AppMethodBeat.i(22617);
      ad.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
      b.this.nTv.clear();
      Assert.assertTrue(b.a(b.this, 2, 0, null));
      AppMethodBeat.o(22617);
    }
    
    public final void i(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(22616);
      ad.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
      b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
      Assert.assertTrue(b.a(b.this, 6, 0, locald));
      AppMethodBeat.o(22616);
    }
    
    public final void l(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22619);
      ad.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
      b.f localf = new b.f(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 4, 0, localf));
      AppMethodBeat.o(22619);
    }
    
    public final void m(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22621);
      ad.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + paramLong + " success = " + paramBoolean);
      b.j localj = new b.j(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 0, 0, localj));
      AppMethodBeat.o(22621);
    }
  }
  
  static final class c
    extends ap
  {
    private WeakReference<b> nQG;
    
    public c(String paramString, b paramb)
    {
      super();
      AppMethodBeat.i(179585);
      this.nQG = null;
      this.nQG = new WeakReference(paramb);
      AppMethodBeat.o(179585);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(22623);
      b localb = (b)this.nQG.get();
      if (localb == null)
      {
        ad.w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
        AppMethodBeat.o(22623);
        return;
      }
      ad.i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + paramMessage.what);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.f)paramMessage.obj;
        localb.nTu.l(paramMessage.nTy, paramMessage.nTz);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.g)paramMessage.obj;
        localb.nTu.th(paramMessage.mSessionId);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.h)paramMessage.obj;
        localb.nTu.b(paramMessage.mSessionId, paramMessage.mData);
        AppMethodBeat.o(22623);
        return;
        localb.nTu.yV(paramMessage.arg1);
        AppMethodBeat.o(22623);
        return;
        b.i locali = (b.i)paramMessage.obj;
        localb.nTu.a(locali.nTB, locali.mDeviceName, paramMessage.arg1, locali.kGT, locali.nTC);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.j)paramMessage.obj;
        localb.nTu.m(paramMessage.nTy, paramMessage.nTz);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.d)paramMessage.obj;
        localb.nTu.i(paramMessage.mSessionId, paramMessage.nTx, paramMessage.nQl);
      }
    }
  }
  
  static final class d
  {
    long mSessionId;
    long nQl;
    long nTx;
    
    public d(long paramLong1, long paramLong2, long paramLong3)
    {
      this.mSessionId = paramLong1;
      this.nTx = paramLong2;
      this.nQl = paramLong3;
    }
  }
  
  static class e
  {
    long nTy;
    boolean nTz;
    
    public e(long paramLong, boolean paramBoolean)
    {
      this.nTy = paramLong;
      this.nTz = paramBoolean;
    }
  }
  
  static final class f
    extends b.e
  {
    public f(long paramLong, boolean paramBoolean)
    {
      super(paramBoolean);
    }
  }
  
  static final class g
  {
    private int mErrorCode;
    long mSessionId;
    private String nTA;
    
    public g(long paramLong, int paramInt, String paramString)
    {
      this.mSessionId = paramLong;
      this.mErrorCode = paramInt;
      this.nTA = paramString;
    }
  }
  
  static final class h
  {
    byte[] mData;
    long mSessionId;
    
    public h(long paramLong, byte[] paramArrayOfByte)
    {
      this.mSessionId = paramLong;
      this.mData = paramArrayOfByte;
    }
  }
  
  static final class i
  {
    int kGT;
    String mDeviceName;
    String nTB;
    byte[] nTC;
    
    public i(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
    {
      this.nTB = paramString1;
      this.mDeviceName = paramString2;
      this.kGT = paramInt;
      this.nTC = paramArrayOfByte;
    }
  }
  
  static final class j
    extends b.e
  {
    public j(long paramLong, boolean paramBoolean)
    {
      super(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.d.b
 * JD-Core Version:    0.7.0.1
 */