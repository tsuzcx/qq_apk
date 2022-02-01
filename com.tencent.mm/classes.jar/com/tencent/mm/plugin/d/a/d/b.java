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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import junit.framework.Assert;

public final class b
{
  private ao mHandler;
  public com.tencent.mm.plugin.d.a.b.b nsw;
  public a nsx;
  c nsy;
  final HashSet<String> nsz;
  
  public b(Context paramContext, c paramc, ao paramao)
  {
    AppMethodBeat.i(179586);
    this.mHandler = null;
    this.nsw = null;
    this.nsx = null;
    this.nsy = null;
    this.nsz = new HashSet();
    this.nsx = new a(paramao);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.nsw = new com.tencent.mm.plugin.d.a.b.b(paramao.getSerialTag());
      paramao = this.nsw;
      localObject = new b();
      ac.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramao.mIsInit)
      {
        paramao.mIsInit = true;
        paramao.GX = paramContext;
        paramao.npc = ((com.tencent.mm.plugin.d.a.b.b.a)localObject);
        paramao.npf = com.tencent.mm.plugin.d.a.b.c.bIv();
        if (d.kZ(21)) {
          paramao.npg = g.bIA();
        }
        if (paramao.bIt()) {
          break label303;
        }
        ac.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
      }
    }
    for (;;)
    {
      paramao = this.nsx;
      localObject = new a();
      ac.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramao.mIsInit)
      {
        paramao.mIsInit = true;
        paramao.nsa = ((a.a)localObject);
        paramao.nsb = paramContext;
        paramContext = new IntentFilter();
        paramContext.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        paramContext.addAction("android.bluetooth.device.action.FOUND");
        paramContext.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
        paramContext.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        paramao.nsb.registerReceiver(paramao.mReceiver, paramContext);
        paramao.nox = BluetoothAdapter.getDefaultAdapter();
      }
      this.mHandler = new c(v.chs().hTd.getSerialTag(), this);
      this.nsy = paramc;
      AppMethodBeat.o(179586);
      return;
      label303:
      paramao.nox = ((BluetoothManager)paramao.GX.getSystemService("bluetooth")).getAdapter();
    }
  }
  
  public final boolean d(int paramInt, int... paramVarArgs)
  {
    AppMethodBeat.i(22625);
    ac.i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      Assert.assertTrue(false);
      AppMethodBeat.o(22625);
      return false;
    case 1: 
      if (this.nsx == null)
      {
        ac.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        AppMethodBeat.o(22625);
        return false;
      }
      bool = this.nsx.iZ(true);
      AppMethodBeat.o(22625);
      return bool;
    }
    if (this.nsw == null)
    {
      ac.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      AppMethodBeat.o(22625);
      return false;
    }
    if (paramVarArgs == null)
    {
      bool = this.nsw.a(true, new int[0]);
      AppMethodBeat.o(22625);
      return bool;
    }
    boolean bool = this.nsw.a(true, paramVarArgs);
    AppMethodBeat.o(22625);
    return bool;
  }
  
  public final void e(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(22626);
    ac.i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + paramLong1 + "aBluetoothVersion = " + paramInt);
    switch (paramInt)
    {
    default: 
      Assert.assertTrue(false);
      AppMethodBeat.o(22626);
      return;
    case 1: 
      if (this.nsx == null)
      {
        ac.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        AppMethodBeat.o(22626);
        return;
      }
      localObject = this.nsx;
      ac.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
      Assert.assertTrue(((a)localObject).mIsInit);
      if (!((a)localObject).bIC())
      {
        ac.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
        AppMethodBeat.o(22626);
        return;
      }
      Assert.assertTrue(((a)localObject).mHandler.post(new a.b((a)localObject, paramLong1, paramLong2)));
      AppMethodBeat.o(22626);
      return;
    }
    if (this.nsw == null)
    {
      ac.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      AppMethodBeat.o(22626);
      return;
    }
    Object localObject = this.nsw;
    ac.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    Assert.assertTrue(((com.tencent.mm.plugin.d.a.b.b)localObject).mIsInit);
    if (!((com.tencent.mm.plugin.d.a.b.b)localObject).bIt())
    {
      ac.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
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
      ac.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = ".concat(String.valueOf(paramLong)));
      paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 1, 1, paramArrayOfByte));
      AppMethodBeat.o(22613);
    }
    
    public final void bIu()
    {
      AppMethodBeat.i(22610);
      ac.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
      b.this.nsz.clear();
      Assert.assertTrue(b.a(b.this, 2, 1, null));
      AppMethodBeat.o(22610);
    }
    
    public final void c(long paramLong, int paramInt, String paramString)
    {
      AppMethodBeat.i(22615);
      ac.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + paramLong + " errorCode = " + paramInt + " errorInfo = " + paramString);
      paramString = new b.g(paramLong, paramInt, paramString);
      Assert.assertTrue(b.a(b.this, 5, 1, paramString));
      AppMethodBeat.o(22615);
    }
    
    public final void ex(String paramString1, String paramString2)
    {
      AppMethodBeat.i(22611);
      b localb = b.this;
      int i;
      if (paramString1 == null)
      {
        ac.e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
        i = 0;
      }
      while (i == 0)
      {
        AppMethodBeat.o(22611);
        return;
        if (localb.nsz.contains(paramString1))
        {
          i = 0;
        }
        else
        {
          localb.nsz.add(paramString1);
          i = 1;
        }
      }
      ac.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + paramString1 + "deviceName = " + paramString2);
      paramString1 = new b.i(paramString1, paramString2, 0, null);
      Assert.assertTrue(b.a(b.this, 3, 1, paramString1));
      AppMethodBeat.o(22611);
    }
    
    public final void i(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(22609);
      ac.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
      b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
      Assert.assertTrue(b.a(b.this, 6, 1, locald));
      AppMethodBeat.o(22609);
    }
    
    public final void l(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22612);
      ac.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
      b.f localf = new b.f(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 4, 1, localf));
      AppMethodBeat.o(22612);
    }
    
    public final void m(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22614);
      ac.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + paramLong + " success = " + paramBoolean);
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
      ac.d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", new Object[] { paramString1, paramString2 });
      paramString1 = new b.i(paramString1, paramString2, paramInt, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 3, 0, paramString1));
      AppMethodBeat.o(22618);
    }
    
    public final void b(long paramLong, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(22620);
      ac.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = ".concat(String.valueOf(paramLong)));
      paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 1, 0, paramArrayOfByte));
      AppMethodBeat.o(22620);
    }
    
    public final void bIu()
    {
      AppMethodBeat.i(22617);
      ac.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
      b.this.nsz.clear();
      Assert.assertTrue(b.a(b.this, 2, 0, null));
      AppMethodBeat.o(22617);
    }
    
    public final void i(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(22616);
      ac.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
      b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
      Assert.assertTrue(b.a(b.this, 6, 0, locald));
      AppMethodBeat.o(22616);
    }
    
    public final void l(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22619);
      ac.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
      b.f localf = new b.f(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 4, 0, localf));
      AppMethodBeat.o(22619);
    }
    
    public final void m(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22621);
      ac.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + paramLong + " success = " + paramBoolean);
      b.j localj = new b.j(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 0, 0, localj));
      AppMethodBeat.o(22621);
    }
  }
  
  static final class c
    extends ao
  {
    private WeakReference<b> npK;
    
    public c(String paramString, b paramb)
    {
      super();
      AppMethodBeat.i(179585);
      this.npK = null;
      this.npK = new WeakReference(paramb);
      AppMethodBeat.o(179585);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(22623);
      b localb = (b)this.npK.get();
      if (localb == null)
      {
        ac.w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
        AppMethodBeat.o(22623);
        return;
      }
      ac.i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + paramMessage.what);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.f)paramMessage.obj;
        localb.nsy.l(paramMessage.nsC, paramMessage.nsD);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.g)paramMessage.obj;
        localb.nsy.rj(paramMessage.mSessionId);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.h)paramMessage.obj;
        localb.nsy.b(paramMessage.mSessionId, paramMessage.mData);
        AppMethodBeat.o(22623);
        return;
        localb.nsy.yl(paramMessage.arg1);
        AppMethodBeat.o(22623);
        return;
        b.i locali = (b.i)paramMessage.obj;
        localb.nsy.a(locali.nsF, locali.mDeviceName, paramMessage.arg1, locali.klT, locali.nsG);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.j)paramMessage.obj;
        localb.nsy.m(paramMessage.nsC, paramMessage.nsD);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.d)paramMessage.obj;
        localb.nsy.i(paramMessage.mSessionId, paramMessage.nsB, paramMessage.npp);
      }
    }
  }
  
  static final class d
  {
    long mSessionId;
    long npp;
    long nsB;
    
    public d(long paramLong1, long paramLong2, long paramLong3)
    {
      this.mSessionId = paramLong1;
      this.nsB = paramLong2;
      this.npp = paramLong3;
    }
  }
  
  static class e
  {
    long nsC;
    boolean nsD;
    
    public e(long paramLong, boolean paramBoolean)
    {
      this.nsC = paramLong;
      this.nsD = paramBoolean;
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
    private String nsE;
    
    public g(long paramLong, int paramInt, String paramString)
    {
      this.mSessionId = paramLong;
      this.mErrorCode = paramInt;
      this.nsE = paramString;
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
    int klT;
    String mDeviceName;
    String nsF;
    byte[] nsG;
    
    public i(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
    {
      this.nsF = paramString1;
      this.mDeviceName = paramString2;
      this.klT = paramInt;
      this.nsG = paramArrayOfByte;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.d.b
 * JD-Core Version:    0.7.0.1
 */