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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import junit.framework.Assert;

public final class b
{
  private MMHandler mHandler;
  public com.tencent.mm.plugin.d.a.b.b pjW;
  public a pjX;
  c pjY;
  final HashSet<String> pjZ;
  
  public b(Context paramContext, c paramc, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(179586);
    this.mHandler = null;
    this.pjW = null;
    this.pjX = null;
    this.pjY = null;
    this.pjZ = new HashSet();
    this.pjX = new a(paramMMHandler);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.pjW = new com.tencent.mm.plugin.d.a.b.b(paramMMHandler.getSerialTag());
      paramMMHandler = this.pjW;
      localObject = new b();
      Log.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramMMHandler.mIsInit)
      {
        paramMMHandler.mIsInit = true;
        paramMMHandler.mAppContext = paramContext;
        paramMMHandler.pgB = ((com.tencent.mm.plugin.d.a.b.b.a)localObject);
        paramMMHandler.pgE = com.tencent.mm.plugin.d.a.b.c.ckG();
        if (d.oD(21)) {
          paramMMHandler.pgF = g.ckL();
        }
        if (paramMMHandler.ckE()) {
          break label303;
        }
        Log.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
      }
    }
    for (;;)
    {
      paramMMHandler = this.pjX;
      localObject = new a();
      Log.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramMMHandler.mIsInit)
      {
        paramMMHandler.mIsInit = true;
        paramMMHandler.pjA = ((a.a)localObject);
        paramMMHandler.pjB = paramContext;
        paramContext = new IntentFilter();
        paramContext.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        paramContext.addAction("android.bluetooth.device.action.FOUND");
        paramContext.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
        paramContext.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        paramMMHandler.pjB.registerReceiver(paramMMHandler.mReceiver, paramContext);
        paramMMHandler.pfW = BluetoothAdapter.getDefaultAdapter();
      }
      this.mHandler = new c(v.cLz().jkv.getSerialTag(), this);
      this.pjY = paramc;
      AppMethodBeat.o(179586);
      return;
      label303:
      paramMMHandler.pfW = ((BluetoothManager)paramMMHandler.mAppContext.getSystemService("bluetooth")).getAdapter();
    }
  }
  
  public final boolean d(int paramInt, int... paramVarArgs)
  {
    AppMethodBeat.i(22625);
    Log.i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      Assert.assertTrue(false);
      AppMethodBeat.o(22625);
      return false;
    case 1: 
      if (this.pjX == null)
      {
        Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        AppMethodBeat.o(22625);
        return false;
      }
      bool = this.pjX.kg(true);
      AppMethodBeat.o(22625);
      return bool;
    }
    if (this.pjW == null)
    {
      Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      AppMethodBeat.o(22625);
      return false;
    }
    if (paramVarArgs == null)
    {
      bool = this.pjW.a(true, new int[0]);
      AppMethodBeat.o(22625);
      return bool;
    }
    boolean bool = this.pjW.a(true, paramVarArgs);
    AppMethodBeat.o(22625);
    return bool;
  }
  
  public final void e(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(22626);
    Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + paramLong1 + "aBluetoothVersion = " + paramInt);
    switch (paramInt)
    {
    default: 
      Assert.assertTrue(false);
      AppMethodBeat.o(22626);
      return;
    case 1: 
      if (this.pjX == null)
      {
        Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        AppMethodBeat.o(22626);
        return;
      }
      localObject = this.pjX;
      Log.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
      Assert.assertTrue(((a)localObject).mIsInit);
      if (!((a)localObject).ckN())
      {
        Log.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
        AppMethodBeat.o(22626);
        return;
      }
      Assert.assertTrue(((a)localObject).mHandler.post(new a.b((a)localObject, paramLong1, paramLong2)));
      AppMethodBeat.o(22626);
      return;
    }
    if (this.pjW == null)
    {
      Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      AppMethodBeat.o(22626);
      return;
    }
    Object localObject = this.pjW;
    Log.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    Assert.assertTrue(((com.tencent.mm.plugin.d.a.b.b)localObject).mIsInit);
    if (!((com.tencent.mm.plugin.d.a.b.b)localObject).ckE())
    {
      Log.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
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
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = ".concat(String.valueOf(paramLong)));
      paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 1, 1, paramArrayOfByte));
      AppMethodBeat.o(22613);
    }
    
    public final void c(long paramLong, int paramInt, String paramString)
    {
      AppMethodBeat.i(22615);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + paramLong + " errorCode = " + paramInt + " errorInfo = " + paramString);
      paramString = new b.g(paramLong, paramInt, paramString);
      Assert.assertTrue(b.a(b.this, 5, 1, paramString));
      AppMethodBeat.o(22615);
    }
    
    public final void ckF()
    {
      AppMethodBeat.i(22610);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
      b.this.pjZ.clear();
      Assert.assertTrue(b.a(b.this, 2, 1, null));
      AppMethodBeat.o(22610);
    }
    
    public final void fb(String paramString1, String paramString2)
    {
      AppMethodBeat.i(22611);
      b localb = b.this;
      int i;
      if (paramString1 == null)
      {
        Log.e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
        i = 0;
      }
      while (i == 0)
      {
        AppMethodBeat.o(22611);
        return;
        if (localb.pjZ.contains(paramString1))
        {
          i = 0;
        }
        else
        {
          localb.pjZ.add(paramString1);
          i = 1;
        }
      }
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + paramString1 + "deviceName = " + paramString2);
      paramString1 = new b.i(paramString1, paramString2, 0, null);
      Assert.assertTrue(b.a(b.this, 3, 1, paramString1));
      AppMethodBeat.o(22611);
    }
    
    public final void i(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(22609);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
      b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
      Assert.assertTrue(b.a(b.this, 6, 1, locald));
      AppMethodBeat.o(22609);
    }
    
    public final void l(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22612);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
      b.f localf = new b.f(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 4, 1, localf));
      AppMethodBeat.o(22612);
    }
    
    public final void m(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22614);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + paramLong + " success = " + paramBoolean);
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
      Log.d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", new Object[] { paramString1, paramString2 });
      paramString1 = new b.i(paramString1, paramString2, paramInt, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 3, 0, paramString1));
      AppMethodBeat.o(22618);
    }
    
    public final void b(long paramLong, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(22620);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = ".concat(String.valueOf(paramLong)));
      paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 1, 0, paramArrayOfByte));
      AppMethodBeat.o(22620);
    }
    
    public final void ckF()
    {
      AppMethodBeat.i(22617);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
      b.this.pjZ.clear();
      Assert.assertTrue(b.a(b.this, 2, 0, null));
      AppMethodBeat.o(22617);
    }
    
    public final void i(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(22616);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
      b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
      Assert.assertTrue(b.a(b.this, 6, 0, locald));
      AppMethodBeat.o(22616);
    }
    
    public final void l(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22619);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
      b.f localf = new b.f(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 4, 0, localf));
      AppMethodBeat.o(22619);
    }
    
    public final void m(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22621);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + paramLong + " success = " + paramBoolean);
      b.j localj = new b.j(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 0, 0, localj));
      AppMethodBeat.o(22621);
    }
  }
  
  static final class c
    extends MMHandler
  {
    private WeakReference<b> phi;
    
    public c(String paramString, b paramb)
    {
      super();
      AppMethodBeat.i(179585);
      this.phi = null;
      this.phi = new WeakReference(paramb);
      AppMethodBeat.o(179585);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(22623);
      b localb = (b)this.phi.get();
      if (localb == null)
      {
        Log.w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
        AppMethodBeat.o(22623);
        return;
      }
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + paramMessage.what);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.f)paramMessage.obj;
        localb.pjY.l(paramMessage.pkc, paramMessage.pkd);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.g)paramMessage.obj;
        localb.pjY.BB(paramMessage.mSessionId);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.h)paramMessage.obj;
        localb.pjY.b(paramMessage.mSessionId, paramMessage.mData);
        AppMethodBeat.o(22623);
        return;
        localb.pjY.CK(paramMessage.arg1);
        AppMethodBeat.o(22623);
        return;
        b.i locali = (b.i)paramMessage.obj;
        localb.pjY.a(locali.pkf, locali.mDeviceName, paramMessage.arg1, locali.lOO, locali.pkg);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.j)paramMessage.obj;
        localb.pjY.m(paramMessage.pkc, paramMessage.pkd);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.d)paramMessage.obj;
        localb.pjY.i(paramMessage.mSessionId, paramMessage.pkb, paramMessage.pgO);
      }
    }
  }
  
  static final class d
  {
    long mSessionId;
    long pgO;
    long pkb;
    
    public d(long paramLong1, long paramLong2, long paramLong3)
    {
      this.mSessionId = paramLong1;
      this.pkb = paramLong2;
      this.pgO = paramLong3;
    }
  }
  
  static class e
  {
    long pkc;
    boolean pkd;
    
    public e(long paramLong, boolean paramBoolean)
    {
      this.pkc = paramLong;
      this.pkd = paramBoolean;
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
    private String pke;
    
    public g(long paramLong, int paramInt, String paramString)
    {
      this.mSessionId = paramLong;
      this.mErrorCode = paramInt;
      this.pke = paramString;
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
    int lOO;
    String mDeviceName;
    String pkf;
    byte[] pkg;
    
    public i(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
    {
      this.pkf = paramString1;
      this.mDeviceName = paramString2;
      this.lOO = paramInt;
      this.pkg = paramArrayOfByte;
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