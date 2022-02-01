package com.tencent.mm.plugin.g.a.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.plugin.g.a.b.g;
import com.tencent.mm.plugin.g.a.c.a;
import com.tencent.mm.plugin.g.a.c.a.a;
import com.tencent.mm.plugin.g.a.c.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import junit.framework.Assert;

public final class b
{
  private MMHandler mHandler;
  public com.tencent.mm.plugin.g.a.b.b vye;
  public a vyf;
  c vyg;
  final HashSet<String> vyh;
  
  public b(Context paramContext, c paramc, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(179586);
    this.mHandler = null;
    this.vye = null;
    this.vyf = null;
    this.vyg = null;
    this.vyh = new HashSet();
    this.vyf = new a(paramMMHandler);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.vye = new com.tencent.mm.plugin.g.a.b.b(paramMMHandler.getSerialTag());
      paramMMHandler = this.vye;
      localObject = new b();
      Log.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramMMHandler.mIsInit)
      {
        paramMMHandler.mIsInit = true;
        paramMMHandler.mAppContext = paramContext;
        paramMMHandler.vuL = ((com.tencent.mm.plugin.g.a.b.b.a)localObject);
        paramMMHandler.vuO = com.tencent.mm.plugin.g.a.b.c.daS();
        if (d.rb(21)) {
          paramMMHandler.vuP = g.daX();
        }
        if (paramMMHandler.daQ()) {
          break label303;
        }
        Log.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
      }
    }
    for (;;)
    {
      paramMMHandler = this.vyf;
      localObject = new a();
      Log.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
      Assert.assertNotNull(paramContext);
      Assert.assertNotNull(localObject);
      if (!paramMMHandler.mIsInit)
      {
        paramMMHandler.mIsInit = true;
        paramMMHandler.vxI = ((a.a)localObject);
        paramMMHandler.vxJ = paramContext;
        paramContext = new IntentFilter();
        paramContext.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        paramContext.addAction("android.bluetooth.device.action.FOUND");
        paramContext.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
        paramContext.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        paramMMHandler.vxJ.registerReceiver(paramMMHandler.mReceiver, paramContext);
        paramMMHandler.vug = BluetoothAdapter.getDefaultAdapter();
      }
      this.mHandler = new c(v.dGF().oTi.getSerialTag(), this);
      this.vyg = paramc;
      AppMethodBeat.o(179586);
      return;
      label303:
      paramMMHandler.vug = ((BluetoothManager)paramMMHandler.mAppContext.getSystemService("bluetooth")).getAdapter();
    }
  }
  
  public final boolean c(int paramInt, int... paramVarArgs)
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
      if (this.vyf == null)
      {
        Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        AppMethodBeat.o(22625);
        return false;
      }
      bool = this.vyf.mJ(true);
      AppMethodBeat.o(22625);
      return bool;
    }
    if (this.vye == null)
    {
      Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      AppMethodBeat.o(22625);
      return false;
    }
    if (paramVarArgs == null)
    {
      bool = this.vye.a(true, new int[0]);
      AppMethodBeat.o(22625);
      return bool;
    }
    boolean bool = this.vye.a(true, paramVarArgs);
    AppMethodBeat.o(22625);
    return bool;
  }
  
  public final void h(long paramLong1, long paramLong2, int paramInt)
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
      if (this.vyf == null)
      {
        Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
        AppMethodBeat.o(22626);
        return;
      }
      localObject = this.vyf;
      Log.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
      Assert.assertTrue(((a)localObject).mIsInit);
      if (!((a)localObject).daZ())
      {
        Log.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
        AppMethodBeat.o(22626);
        return;
      }
      Assert.assertTrue(((a)localObject).mHandler.post(new a.b((a)localObject, paramLong1, paramLong2)));
      AppMethodBeat.o(22626);
      return;
    }
    if (this.vye == null)
    {
      Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
      AppMethodBeat.o(22626);
      return;
    }
    Object localObject = this.vye;
    Log.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    Assert.assertTrue(((com.tencent.mm.plugin.g.a.b.b)localObject).mIsInit);
    if (!((com.tencent.mm.plugin.g.a.b.b)localObject).daQ())
    {
      Log.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
      AppMethodBeat.o(22626);
      return;
    }
    Assert.assertTrue(((com.tencent.mm.plugin.g.a.b.b)localObject).mHandler.post(new com.tencent.mm.plugin.g.a.b.b.b((com.tencent.mm.plugin.g.a.b.b)localObject, paramLong1, paramLong2)));
    AppMethodBeat.o(22626);
  }
  
  final class a
    extends a.a
  {
    a() {}
    
    public final void c(long paramLong, int paramInt, String paramString)
    {
      AppMethodBeat.i(22615);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + paramLong + " errorCode = " + paramInt + " errorInfo = " + paramString);
      paramString = new b.g(paramLong, paramInt, paramString);
      Assert.assertTrue(b.a(b.this, 5, 1, paramString));
      AppMethodBeat.o(22615);
    }
    
    public final void c(long paramLong, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(22613);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = ".concat(String.valueOf(paramLong)));
      paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 1, 1, paramArrayOfByte));
      AppMethodBeat.o(22613);
    }
    
    public final void daR()
    {
      AppMethodBeat.i(22610);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
      b.this.vyh.clear();
      Assert.assertTrue(b.a(b.this, 2, 1, null));
      AppMethodBeat.o(22610);
    }
    
    public final void fG(String paramString1, String paramString2)
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
        if (localb.vyh.contains(paramString1))
        {
          i = 0;
        }
        else
        {
          localb.vyh.add(paramString1);
          i = 1;
        }
      }
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + paramString1 + "deviceName = " + paramString2);
      paramString1 = new b.i(paramString1, paramString2, 0, null);
      Assert.assertTrue(b.a(b.this, 3, 1, paramString1));
      AppMethodBeat.o(22611);
    }
    
    public final void k(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(22609);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
      b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
      Assert.assertTrue(b.a(b.this, 6, 1, locald));
      AppMethodBeat.o(22609);
    }
    
    public final void r(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22612);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
      b.f localf = new b.f(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 4, 1, localf));
      AppMethodBeat.o(22612);
    }
    
    public final void s(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22614);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + paramLong + " success = " + paramBoolean);
      b.j localj = new b.j(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 0, 1, localj));
      AppMethodBeat.o(22614);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.g.a.b.b.a
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
    
    public final void c(long paramLong, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(22620);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = ".concat(String.valueOf(paramLong)));
      paramArrayOfByte = new b.h(paramLong, paramArrayOfByte);
      Assert.assertTrue(b.a(b.this, 1, 0, paramArrayOfByte));
      AppMethodBeat.o(22620);
    }
    
    public final void daR()
    {
      AppMethodBeat.i(22617);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
      b.this.vyh.clear();
      Assert.assertTrue(b.a(b.this, 2, 0, null));
      AppMethodBeat.o(22617);
    }
    
    public final void k(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(22616);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + paramLong1 + " deviceID = " + paramLong2);
      b.d locald = new b.d(paramLong1, paramLong2, paramLong3);
      Assert.assertTrue(b.a(b.this, 6, 0, locald));
      AppMethodBeat.o(22616);
    }
    
    public final void r(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(22619);
      Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + paramLong + " Connected = " + paramBoolean);
      b.f localf = new b.f(paramLong, paramBoolean);
      Assert.assertTrue(b.a(b.this, 4, 0, localf));
      AppMethodBeat.o(22619);
    }
    
    public final void s(long paramLong, boolean paramBoolean)
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
    private WeakReference<b> vvs;
    
    public c(String paramString, b paramb)
    {
      super();
      AppMethodBeat.i(179585);
      this.vvs = null;
      this.vvs = new WeakReference(paramb);
      AppMethodBeat.o(179585);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(22623);
      b localb = (b)this.vvs.get();
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
        localb.vyg.r(paramMessage.vyk, paramMessage.vyl);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.g)paramMessage.obj;
        localb.vyg.kf(paramMessage.mSessionId);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.h)paramMessage.obj;
        localb.vyg.c(paramMessage.mSessionId, paramMessage.mData);
        AppMethodBeat.o(22623);
        return;
        localb.vyg.GO(paramMessage.arg1);
        AppMethodBeat.o(22623);
        return;
        b.i locali = (b.i)paramMessage.obj;
        localb.vyg.a(locali.vyn, locali.mDeviceName, paramMessage.arg1, locali.rPb, locali.vyo);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.j)paramMessage.obj;
        localb.vyg.s(paramMessage.vyk, paramMessage.vyl);
        AppMethodBeat.o(22623);
        return;
        paramMessage = (b.d)paramMessage.obj;
        localb.vyg.k(paramMessage.mSessionId, paramMessage.vyj, paramMessage.vuY);
      }
    }
  }
  
  static final class d
  {
    long mSessionId;
    long vuY;
    long vyj;
    
    public d(long paramLong1, long paramLong2, long paramLong3)
    {
      this.mSessionId = paramLong1;
      this.vyj = paramLong2;
      this.vuY = paramLong3;
    }
  }
  
  static class e
  {
    long vyk;
    boolean vyl;
    
    public e(long paramLong, boolean paramBoolean)
    {
      this.vyk = paramLong;
      this.vyl = paramBoolean;
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
    int mErrorCode;
    long mSessionId;
    String vym;
    
    public g(long paramLong, int paramInt, String paramString)
    {
      this.mSessionId = paramLong;
      this.mErrorCode = paramInt;
      this.vym = paramString;
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
    String mDeviceName;
    int rPb;
    String vyn;
    byte[] vyo;
    
    public i(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
    {
      this.vyn = paramString1;
      this.mDeviceName = paramString2;
      this.rPb = paramInt;
      this.vyo = paramArrayOfByte;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.d.b
 * JD-Core Version:    0.7.0.1
 */