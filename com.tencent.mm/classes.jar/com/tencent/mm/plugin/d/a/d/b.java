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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import junit.framework.Assert;

public final class b
{
  private aq mHandler;
  public com.tencent.mm.plugin.d.a.b.b nYY;
  public a nYZ;
  c nZa;
  final HashSet<String> nZb;
  
  public b(Context paramContext, c paramc, aq paramaq)
  {
    AppMethodBeat.i(179586);
    this.mHandler = null;
    this.nYY = null;
    this.nYZ = null;
    this.nZa = null;
    this.nZb = new HashSet();
    this.nYZ = new a(paramaq);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.nYY = new com.tencent.mm.plugin.d.a.b.b(paramaq.getSerialTag());
      paramaq = this.nYY;
      localObject = new b();
      ae.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramaq.mIsInit)
      {
        paramaq.mIsInit = true;
        paramaq.IR = paramContext;
        paramaq.nVE = ((com.tencent.mm.plugin.d.a.b.b.a)localObject);
        paramaq.nVH = com.tencent.mm.plugin.d.a.b.c.bNG();
        if (d.lA(21)) {
          paramaq.nVI = g.bNL();
        }
        if (paramaq.bNE()) {
          break label303;
        }
        ae.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
      }
    }
    for (;;)
    {
      paramaq = this.nYZ;
      localObject = new a();
      ae.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramaq.mIsInit)
      {
        paramaq.mIsInit = true;
        paramaq.nYC = ((a.a)localObject);
        paramaq.nYD = paramContext;
        paramContext = new IntentFilter();
        paramContext.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        paramContext.addAction("android.bluetooth.device.action.FOUND");
        paramContext.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
        paramContext.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        paramaq.nYD.registerReceiver(paramaq.mReceiver, paramContext);
        paramaq.nUZ = BluetoothAdapter.getDefaultAdapter();
      }
      this.mHandler = new c(v.cnm().ipo.getSerialTag(), this);
      this.nZa = paramc;
      AppMethodBeat.o(179586);
      return;
      label303:
      paramaq.nUZ = ((BluetoothManager)paramaq.IR.getSystemService("bluetooth")).getAdapter();
    }
  }
  
  public final boolean d(int paramInt, int... paramVarArgs)
  {
    AppMethodBeat.i(22625);
    ae.i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      Assert.assertTrue(false);
      AppMethodBeat.o(22625);
      return false;
    case 1: 
      if (this.nYZ == null)
      {
        ae.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        AppMethodBeat.o(22625);
        return false;
      }
      bool = this.nYZ.jh(true);
      AppMethodBeat.o(22625);
      return bool;
    }
    if (this.nYY == null)
    {
      ae.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      AppMethodBeat.o(22625);
      return false;
    }
    if (paramVarArgs == null)
    {
      bool = this.nYY.a(true, new int[0]);
      AppMethodBeat.o(22625);
      return bool;
    }
    boolean bool = this.nYY.a(true, paramVarArgs);
    AppMethodBeat.o(22625);
    return bool;
  }
  
  public final void e(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(22626);
    ae.i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + paramLong1 + "aBluetoothVersion = " + paramInt);
    switch (paramInt)
    {
    default: 
      Assert.assertTrue(false);
      AppMethodBeat.o(22626);
      return;
    case 1: 
      if (this.nYZ == null)
      {
        ae.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        AppMethodBeat.o(22626);
        return;
      }
      localObject = this.nYZ;
      ae.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
      Assert.assertTrue(((a)localObject).mIsInit);
      if (!((a)localObject).bNN())
      {
        ae.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
        AppMethodBeat.o(22626);
        return;
      }
      Assert.assertTrue(((a)localObject).mHandler.post(new a.b((a)localObject, paramLong1, paramLong2)));
      AppMethodBeat.o(22626);
      return;
    }
    if (this.nYY == null)
    {
      ae.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      AppMethodBeat.o(22626);
      return;
    }
    Object localObject = this.nYY;
    ae.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    Assert.assertTrue(((com.tencent.mm.plugin.d.a.b.b)localObject).mIsInit);
    if (!((com.tencent.mm.plugin.d.a.b.b)localObject).bNE())
    {
      ae.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
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
      ae.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = ".concat(String.valueOf(paramLong)));
      paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 1, 1, paramArrayOfByte));
      AppMethodBeat.o(22613);
    }
    
    public final void bNF()
    {
      AppMethodBeat.i(22610);
      ae.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
      b.this.nZb.clear();
      Assert.assertTrue(b.a(b.this, 2, 1, null));
      AppMethodBeat.o(22610);
    }
    
    public final void c(long paramLong, int paramInt, String paramString)
    {
      AppMethodBeat.i(22615);
      ae.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + paramLong + " errorCode = " + paramInt + " errorInfo = " + paramString);
      paramString = new b.g(paramLong, paramInt, paramString);
      Assert.assertTrue(b.a(b.this, 5, 1, paramString));
      AppMethodBeat.o(22615);
    }
    
    public final void eJ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(22611);
      b localb = b.this;
      int i;
      if (paramString1 == null)
      {
        ae.e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
        i = 0;
      }
      while (i == 0)
      {
        AppMethodBeat.o(22611);
        return;
        if (localb.nZb.contains(paramString1))
        {
          i = 0;
        }
        else
        {
          localb.nZb.add(paramString1);
          i = 1;
        }
      }
      ae.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + paramString1 + "deviceName = " + paramString2);
      paramString1 = new b.i(paramString1, paramString2, 0, null);
      Assert.assertTrue(b.a(b.this, 3, 1, paramString1));
      AppMethodBeat.o(22611);
    }
    
    public final void i(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(22609);
      ae.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
      b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
      Assert.assertTrue(b.a(b.this, 6, 1, locald));
      AppMethodBeat.o(22609);
    }
    
    public final void l(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22612);
      ae.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
      b.f localf = new b.f(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 4, 1, localf));
      AppMethodBeat.o(22612);
    }
    
    public final void m(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22614);
      ae.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + paramLong + " success = " + paramBoolean);
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
      ae.d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", new Object[] { paramString1, paramString2 });
      paramString1 = new b.i(paramString1, paramString2, paramInt, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 3, 0, paramString1));
      AppMethodBeat.o(22618);
    }
    
    public final void b(long paramLong, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(22620);
      ae.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = ".concat(String.valueOf(paramLong)));
      paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 1, 0, paramArrayOfByte));
      AppMethodBeat.o(22620);
    }
    
    public final void bNF()
    {
      AppMethodBeat.i(22617);
      ae.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
      b.this.nZb.clear();
      Assert.assertTrue(b.a(b.this, 2, 0, null));
      AppMethodBeat.o(22617);
    }
    
    public final void i(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(22616);
      ae.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
      b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
      Assert.assertTrue(b.a(b.this, 6, 0, locald));
      AppMethodBeat.o(22616);
    }
    
    public final void l(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22619);
      ae.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
      b.f localf = new b.f(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 4, 0, localf));
      AppMethodBeat.o(22619);
    }
    
    public final void m(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22621);
      ae.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + paramLong + " success = " + paramBoolean);
      b.j localj = new b.j(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 0, 0, localj));
      AppMethodBeat.o(22621);
    }
  }
  
  static final class c
    extends aq
  {
    private WeakReference<b> nWm;
    
    public c(String paramString, b paramb)
    {
      super();
      AppMethodBeat.i(179585);
      this.nWm = null;
      this.nWm = new WeakReference(paramb);
      AppMethodBeat.o(179585);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(22623);
      b localb = (b)this.nWm.get();
      if (localb == null)
      {
        ae.w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
        AppMethodBeat.o(22623);
        return;
      }
      ae.i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + paramMessage.what);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.f)paramMessage.obj;
        localb.nZa.l(paramMessage.nZe, paramMessage.nZf);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.g)paramMessage.obj;
        localb.nZa.tv(paramMessage.mSessionId);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.h)paramMessage.obj;
        localb.nZa.b(paramMessage.mSessionId, paramMessage.mData);
        AppMethodBeat.o(22623);
        return;
        localb.nZa.ze(paramMessage.arg1);
        AppMethodBeat.o(22623);
        return;
        b.i locali = (b.i)paramMessage.obj;
        localb.nZa.a(locali.nZh, locali.mDeviceName, paramMessage.arg1, locali.kKi, locali.nZi);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.j)paramMessage.obj;
        localb.nZa.m(paramMessage.nZe, paramMessage.nZf);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.d)paramMessage.obj;
        localb.nZa.i(paramMessage.mSessionId, paramMessage.nZd, paramMessage.nVR);
      }
    }
  }
  
  static final class d
  {
    long mSessionId;
    long nVR;
    long nZd;
    
    public d(long paramLong1, long paramLong2, long paramLong3)
    {
      this.mSessionId = paramLong1;
      this.nZd = paramLong2;
      this.nVR = paramLong3;
    }
  }
  
  static class e
  {
    long nZe;
    boolean nZf;
    
    public e(long paramLong, boolean paramBoolean)
    {
      this.nZe = paramLong;
      this.nZf = paramBoolean;
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
    private String nZg;
    
    public g(long paramLong, int paramInt, String paramString)
    {
      this.mSessionId = paramLong;
      this.mErrorCode = paramInt;
      this.nZg = paramString;
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
    int kKi;
    String mDeviceName;
    String nZh;
    byte[] nZi;
    
    public i(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
    {
      this.nZh = paramString1;
      this.mDeviceName = paramString2;
      this.kKi = paramInt;
      this.nZi = paramArrayOfByte;
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