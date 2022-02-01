package com.tencent.mm.plugin.card.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.ai;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class i
  implements com.tencent.mm.ak.i
{
  public Object dBh;
  public volatile float gmu;
  public volatile float gmv;
  public volatile boolean isInit;
  String pQH;
  private com.tencent.mm.plugin.card.base.b pQV;
  public MMActivity pRg;
  private volatile boolean pRh;
  private boolean pRi;
  boolean pRj;
  private boolean pRk;
  qr pRl;
  private b pRm;
  public a pRn;
  private int pRo;
  private long pRp;
  private long pRq;
  private long pRr;
  public MTimerHandler pRs;
  
  public i()
  {
    AppMethodBeat.i(112657);
    this.isInit = false;
    this.pRh = false;
    this.dBh = new Object();
    this.pRi = false;
    this.pRj = false;
    this.gmu = -85.0F;
    this.gmv = -1000.0F;
    this.pRk = false;
    this.pRo = 60;
    this.pRp = 0L;
    this.pRq = 0L;
    this.pRr = 10000L;
    this.pRs = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112645);
        i.this.report();
        i.this.ctw();
        AppMethodBeat.o(112645);
        return true;
      }
    }, false);
    AppMethodBeat.o(112657);
  }
  
  private void a(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112665);
    boolean bool = this.pRj;
    a(paramString, new byte[0], paramFloat1, paramFloat2, 0, false, bool);
    AppMethodBeat.o(112665);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112667);
    a(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean, this.pRj);
    AppMethodBeat.o(112667);
  }
  
  static void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112668);
    paramString = new ai(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    g.aAg().hqi.a(paramString, 0);
    AppMethodBeat.o(112668);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112666);
    a(paramString, paramArrayOfByte, -1000.0F, -85.0F, paramInt, paramBoolean, this.pRj);
    AppMethodBeat.o(112666);
  }
  
  private static void byG()
  {
    AppMethodBeat.i(112670);
    LocationManager localLocationManager = (LocationManager)MMApplicationContext.getContext().getSystemService("location");
    if (localLocationManager != null) {
      Log.i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", new Object[] { Boolean.valueOf(localLocationManager.isProviderEnabled("gps")), Boolean.valueOf(localLocationManager.isProviderEnabled("network")) });
    }
    AppMethodBeat.o(112670);
  }
  
  private boolean cty()
  {
    boolean bool = true;
    AppMethodBeat.i(112663);
    synchronized (this.dBh)
    {
      int i;
      if (System.currentTimeMillis() - this.pRq >= this.pRr)
      {
        i = 1;
        if ((Float.compare(this.gmu, -85.0F) == 0) || (Float.compare(this.gmv, -1000.0F) == 0)) {
          break label97;
        }
      }
      label97:
      for (int j = 1;; j = 0)
      {
        if ((!this.pRj) || (!this.pRi) || (j == 0) || (i == 0)) {
          break label102;
        }
        AppMethodBeat.o(112663);
        return bool;
        i = 0;
        break;
      }
      label102:
      bool = false;
    }
  }
  
  private boolean ctz()
  {
    AppMethodBeat.i(112664);
    if (!this.pRk)
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.pRn == null)
    {
      Log.e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.pRn.ctB().dGL.equals(""))
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (System.currentTimeMillis() - this.pRp >= this.pRr)
    {
      AppMethodBeat.o(112664);
      return true;
    }
    AppMethodBeat.o(112664);
    return false;
  }
  
  public final void a(MMActivity paramMMActivity, String paramString, com.tencent.mm.plugin.card.base.b paramb, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112658);
    this.isInit = true;
    this.pRg = paramMMActivity;
    this.pQH = paramString;
    this.pQV = paramb;
    this.gmu = paramFloat1;
    this.gmv = paramFloat2;
    this.pRi = paramb.csQ().Lfj;
    this.pRj = paramb.csR().LcH;
    this.pRl = paramb.csQ().Lfk;
    int i;
    if (paramb.csQ().Lfk == null)
    {
      i = 60;
      this.pRo = i;
      if ((paramb.csQ().Lfk == null) || (Util.isNullOrNil(paramb.csQ().Lfk.name))) {
        break label328;
      }
    }
    label328:
    for (boolean bool = true;; bool = false)
    {
      this.pRk = bool;
      Log.i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", new Object[] { paramString, Boolean.valueOf(this.pRi), Boolean.valueOf(this.pRj), Boolean.valueOf(this.pRk), Integer.valueOf(this.pRo) });
      if ((this.pRi) && (!this.pRj)) {
        break label334;
      }
      if (this.pRk)
      {
        Log.i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", new Object[] { this.pRl.name });
        this.pRn = new a((byte)0);
        paramMMActivity = this.pRn;
        Log.i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
        paramMMActivity.lKJ = new i.a.2(paramMMActivity);
        paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        MMApplicationContext.getContext().registerReceiver(paramMMActivity.lKJ, paramString);
      }
      start();
      report();
      AppMethodBeat.o(112658);
      return;
      i = paramb.csQ().Lfk.KXx;
      break;
    }
    label334:
    if (Util.isNullOrNil(this.pQV.csQ().KUD)) {}
    for (paramMMActivity = this.pQV.csQ().title;; paramMMActivity = this.pQV.csQ().KUD)
    {
      h.a(this.pRg, this.pRg.getString(2131757126, new Object[] { paramMMActivity }), this.pRg.getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(112646);
          i.this.pRj = true;
          i.a(i.this.pQH, new byte[0], -85.0F, -1000.0F, 0, false, true);
          AppMethodBeat.o(112646);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          i.this.pRj = false;
        }
      });
      break;
    }
  }
  
  public final boolean ctA()
  {
    return (this.pRi) || (this.pRk);
  }
  
  public final void ctw()
  {
    AppMethodBeat.i(112660);
    ctx();
    if (this.pRo > 0)
    {
      this.pRs.startTimer(this.pRo * 1000);
      Log.i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
      AppMethodBeat.o(112660);
      return;
    }
    Log.e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
    AppMethodBeat.o(112660);
  }
  
  public final void ctx()
  {
    AppMethodBeat.i(112661);
    Log.i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
    if (!this.pRs.stopped()) {
      this.pRs.stopTimer();
    }
    AppMethodBeat.o(112661);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112669);
    Log.i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.pRh = false;
    AppMethodBeat.o(112669);
  }
  
  public final void report()
  {
    AppMethodBeat.i(112662);
    if (!ctA())
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
      AppMethodBeat.o(112662);
      return;
    }
    if (this.pRh)
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
      AppMethodBeat.o(112662);
      return;
    }
    this.pRh = true;
    boolean bool2 = ctz();
    boolean bool3 = cty();
    boolean bool4 = this.pRi;
    boolean bool5 = this.pRj;
    if (this.pRn == null) {}
    b localb;
    for (boolean bool1 = false;; bool1 = this.pRn.pRv)
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!bool2) || (!bool3)) {
        break;
      }
      localb = this.pRn.ctB();
      Log.i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", new Object[] { localb });
      Log.d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.gmv), Float.valueOf(this.gmu) });
      a(this.pQH, localb.pRB, this.gmv, this.gmu, localb.dIX, this.pRn.pRv);
      this.pRq = System.currentTimeMillis();
      this.pRp = System.currentTimeMillis();
      this.pRn.reset();
      this.pRm = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool2)
    {
      localb = this.pRn.ctB();
      Log.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", new Object[] { localb });
      a(this.pQH, localb.pRB, localb.dIX, this.pRn.pRv);
      this.pRp = System.currentTimeMillis();
      this.pRn.reset();
      this.pRm = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool3)
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
      Log.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.gmv), Float.valueOf(this.gmu) });
      a(this.pQH, this.gmv, this.gmu);
      this.pRq = System.currentTimeMillis();
      AppMethodBeat.o(112662);
      return;
    }
    Log.e("MicroMsg.CardLbsOrBluetooth", "not report");
    this.pRh = false;
    AppMethodBeat.o(112662);
  }
  
  public final void start()
  {
    AppMethodBeat.i(112659);
    if (!ctA())
    {
      AppMethodBeat.o(112659);
      return;
    }
    Log.i("MicroMsg.CardLbsOrBluetooth", "start");
    if (!this.isInit)
    {
      Log.e("MicroMsg.CardLbsOrBluetooth", "isInit:%b", new Object[] { Boolean.valueOf(this.isInit) });
      AppMethodBeat.o(112659);
      return;
    }
    if (this.pRi) {
      byG();
    }
    if ((this.pRn != null) && (this.pRk)) {
      this.pRn.ctC();
    }
    ctw();
    g.aAg().hqi.a(2574, this);
    AppMethodBeat.o(112659);
  }
  
  public final class a
  {
    public BroadcastReceiver lKJ;
    private BluetoothAdapter lWj;
    private volatile boolean pRu;
    boolean pRv;
    Map<String, i.b> pRw;
    long pRx;
    Runnable pRy;
    private BluetoothAdapter.LeScanCallback pRz;
    
    private a()
    {
      AppMethodBeat.i(112650);
      this.pRu = false;
      this.pRv = false;
      this.pRw = new ConcurrentHashMap();
      this.pRx = 3000L;
      this.pRy = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(112647);
          i.a.this.ctD();
          i.a.this.ctC();
          AppMethodBeat.o(112647);
        }
      };
      this.pRz = new BluetoothAdapter.LeScanCallback()
      {
        public final void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(112649);
          if (paramAnonymousBluetoothDevice == null)
          {
            Log.e("MicroMsg.CardLbsOrBluetooth", "device is null, return");
            AppMethodBeat.o(112649);
            return;
          }
          if ((i.this.pRl == null) || (Util.isNullOrNil(i.this.pRl.name)))
          {
            AppMethodBeat.o(112649);
            return;
          }
          String str = Util.nullAsNil(paramAnonymousBluetoothDevice.getName());
          paramAnonymousBluetoothDevice = paramAnonymousBluetoothDevice.getAddress();
          if (str.equals(i.this.pRl.name))
          {
            Log.i("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
            paramAnonymousArrayOfByte = new i.b(paramAnonymousBluetoothDevice, paramAnonymousInt, str, i.a.bc(paramAnonymousArrayOfByte));
            i.a.this.pRw.put(paramAnonymousBluetoothDevice, paramAnonymousArrayOfByte);
            AppMethodBeat.o(112649);
            return;
          }
          Log.d("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(112649);
        }
      };
      AppMethodBeat.o(112650);
    }
    
    public static byte[] bc(byte[] paramArrayOfByte)
    {
      byte[] arrayOfByte = null;
      AppMethodBeat.i(112655);
      if (paramArrayOfByte == null)
      {
        AppMethodBeat.o(112655);
        return null;
      }
      int i = 0;
      if (i < paramArrayOfByte.length)
      {
        int j = i + 1;
        i = paramArrayOfByte[i] & 0xFF;
        if (i != 0)
        {
          i -= 1;
          int k = j + 1;
          switch (paramArrayOfByte[j] & 0xFF)
          {
          }
          for (;;)
          {
            i += k;
            break;
            arrayOfByte = new byte[i];
            System.arraycopy(paramArrayOfByte, k, arrayOfByte, 0, i);
          }
        }
      }
      AppMethodBeat.o(112655);
      return arrayOfByte;
    }
    
    public final i.b ctB()
    {
      AppMethodBeat.i(112652);
      Object localObject = new i.b("", -100, "", null);
      if (this.pRw.size() <= 0)
      {
        AppMethodBeat.o(112652);
        return localObject;
      }
      Iterator localIterator = this.pRw.values().iterator();
      if (localIterator.hasNext())
      {
        i.b localb = (i.b)localIterator.next();
        if (((i.b)localObject).dIX >= localb.dIX) {
          break label96;
        }
        localObject = localb;
      }
      label96:
      for (;;)
      {
        break;
        AppMethodBeat.o(112652);
        return localObject;
      }
    }
    
    @TargetApi(18)
    public final void ctC()
    {
      AppMethodBeat.i(112653);
      if (Build.VERSION.SDK_INT < 18)
      {
        Log.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        AppMethodBeat.o(112653);
        return;
      }
      if (this.pRu)
      {
        Log.i("MicroMsg.CardLbsOrBluetooth", "already start");
        AppMethodBeat.o(112653);
        return;
      }
      this.pRw.clear();
      BluetoothManager localBluetoothManager = (BluetoothManager)MMApplicationContext.getContext().getSystemService("bluetooth");
      if (localBluetoothManager == null)
      {
        this.pRv = false;
        Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
        AppMethodBeat.o(112653);
        return;
      }
      this.pRv = true;
      this.lWj = localBluetoothManager.getAdapter();
      if ((this.lWj == null) || (!this.lWj.isEnabled()))
      {
        this.pRv = false;
        Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
        AppMethodBeat.o(112653);
        return;
      }
      Log.i("MicroMsg.CardLbsOrBluetooth", "[BluetoothTrace] start scan");
      Log.printErrStackTrace("MicroMsg.CardLbsOrBluetooth", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
      Log.i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", new Object[] { Boolean.valueOf(this.lWj.startLeScan(this.pRz)) });
      this.pRu = true;
      AppMethodBeat.o(112653);
    }
    
    @TargetApi(18)
    public final void ctD()
    {
      AppMethodBeat.i(112654);
      if (Build.VERSION.SDK_INT < 18)
      {
        Log.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        AppMethodBeat.o(112654);
        return;
      }
      if (!this.pRu)
      {
        Log.i("MicroMsg.CardLbsOrBluetooth", "not start");
        AppMethodBeat.o(112654);
        return;
      }
      if ((this.lWj == null) || (!this.lWj.isEnabled()))
      {
        this.pRv = false;
        Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
        AppMethodBeat.o(112654);
        return;
      }
      this.pRv = true;
      this.lWj.stopLeScan(this.pRz);
      Log.i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
      this.pRu = false;
      AppMethodBeat.o(112654);
    }
    
    public final void reset()
    {
      AppMethodBeat.i(112651);
      this.pRw.clear();
      AppMethodBeat.o(112651);
    }
  }
  
  static final class b
  {
    String dGL;
    int dIX;
    String name;
    byte[] pRB;
    
    public b(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
    {
      this.dGL = paramString1;
      this.dIX = paramInt;
      this.name = paramString2;
      this.pRB = paramArrayOfByte;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(112656);
      String str = "SrvDeviceInfo{deviceId='" + this.dGL + '\'' + ", rssi=" + this.dIX + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.pRB) + '}';
      AppMethodBeat.o(112656);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i
 * JD-Core Version:    0.7.0.1
 */