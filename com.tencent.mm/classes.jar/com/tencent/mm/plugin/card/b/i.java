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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.ai;
import com.tencent.mm.protocal.protobuf.qk;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class i
  implements com.tencent.mm.an.i
{
  public volatile float iQD;
  public volatile float iQE;
  public volatile boolean isInit;
  private String tmG;
  private b tmU;
  public MMActivity tnf;
  private volatile boolean tng;
  public Object tnh;
  private boolean tni;
  private boolean tnj;
  private boolean tnk;
  private qk tnl;
  private b tnm;
  public a tnn;
  private int tno;
  private long tnp;
  private long tnq;
  private long tnr;
  public MTimerHandler tns;
  
  public i()
  {
    AppMethodBeat.i(112657);
    this.isInit = false;
    this.tng = false;
    this.tnh = new Object();
    this.tni = false;
    this.tnj = false;
    this.iQD = -85.0F;
    this.iQE = -1000.0F;
    this.tnk = false;
    this.tno = 60;
    this.tnp = 0L;
    this.tnq = 0L;
    this.tnr = 10000L;
    this.tns = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112645);
        i.this.report();
        i.this.cGY();
        AppMethodBeat.o(112645);
        return true;
      }
    }, false);
    AppMethodBeat.o(112657);
  }
  
  private void a(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112665);
    boolean bool = this.tnj;
    a(paramString, new byte[0], paramFloat1, paramFloat2, 0, false, bool);
    AppMethodBeat.o(112665);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112667);
    a(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean, this.tnj);
    AppMethodBeat.o(112667);
  }
  
  private static void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112668);
    paramString = new ai(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    AppMethodBeat.o(112668);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112666);
    a(paramString, paramArrayOfByte, -1000.0F, -85.0F, paramInt, paramBoolean, this.tnj);
    AppMethodBeat.o(112666);
  }
  
  private static void bJU()
  {
    AppMethodBeat.i(112670);
    LocationManager localLocationManager = (LocationManager)MMApplicationContext.getContext().getSystemService("location");
    if (localLocationManager != null) {
      Log.i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", new Object[] { Boolean.valueOf(localLocationManager.isProviderEnabled("gps")), Boolean.valueOf(localLocationManager.isProviderEnabled("network")) });
    }
    AppMethodBeat.o(112670);
  }
  
  private boolean cHa()
  {
    boolean bool = true;
    AppMethodBeat.i(112663);
    synchronized (this.tnh)
    {
      int i;
      if (System.currentTimeMillis() - this.tnq >= this.tnr)
      {
        i = 1;
        if ((Float.compare(this.iQD, -85.0F) == 0) || (Float.compare(this.iQE, -1000.0F) == 0)) {
          break label97;
        }
      }
      label97:
      for (int j = 1;; j = 0)
      {
        if ((!this.tnj) || (!this.tni) || (j == 0) || (i == 0)) {
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
  
  private boolean cHb()
  {
    AppMethodBeat.i(112664);
    if (!this.tnk)
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.tnn == null)
    {
      Log.e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.tnn.cHd().fzB.equals(""))
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (System.currentTimeMillis() - this.tnp >= this.tnr)
    {
      AppMethodBeat.o(112664);
      return true;
    }
    AppMethodBeat.o(112664);
    return false;
  }
  
  public final void a(MMActivity paramMMActivity, String paramString, b paramb, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112658);
    this.isInit = true;
    this.tnf = paramMMActivity;
    this.tmG = paramString;
    this.tmU = paramb;
    this.iQD = paramFloat1;
    this.iQE = paramFloat2;
    this.tni = paramb.cGs().Sgx;
    this.tnj = paramb.cGt().SdU;
    this.tnl = paramb.cGs().Sgy;
    int i;
    if (paramb.cGs().Sgy == null)
    {
      i = 60;
      this.tno = i;
      if ((paramb.cGs().Sgy == null) || (Util.isNullOrNil(paramb.cGs().Sgy.name))) {
        break label328;
      }
    }
    label328:
    for (boolean bool = true;; bool = false)
    {
      this.tnk = bool;
      Log.i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", new Object[] { paramString, Boolean.valueOf(this.tni), Boolean.valueOf(this.tnj), Boolean.valueOf(this.tnk), Integer.valueOf(this.tno) });
      if ((this.tni) && (!this.tnj)) {
        break label334;
      }
      if (this.tnk)
      {
        Log.i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", new Object[] { this.tnl.name });
        this.tnn = new a((byte)0);
        paramMMActivity = this.tnn;
        Log.i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
        paramMMActivity.oGW = new i.a.2(paramMMActivity);
        paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        MMApplicationContext.getContext().registerReceiver(paramMMActivity.oGW, paramString);
      }
      start();
      report();
      AppMethodBeat.o(112658);
      return;
      i = paramb.cGs().Sgy.RYG;
      break;
    }
    label334:
    if (Util.isNullOrNil(this.tmU.cGs().RVI)) {}
    for (paramMMActivity = this.tmU.cGs().title;; paramMMActivity = this.tmU.cGs().RVI)
    {
      com.tencent.mm.ui.base.h.a(this.tnf, this.tnf.getString(a.g.tlm, new Object[] { paramMMActivity }), this.tnf.getString(a.g.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(112646);
          i.a(i.this, true);
          i.o(i.a(i.this), new byte[0]);
          AppMethodBeat.o(112646);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(244977);
          i.a(i.this, false);
          AppMethodBeat.o(244977);
        }
      });
      break;
    }
  }
  
  public final void cGY()
  {
    AppMethodBeat.i(112660);
    cGZ();
    if (this.tno > 0)
    {
      this.tns.startTimer(this.tno * 1000);
      Log.i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
      AppMethodBeat.o(112660);
      return;
    }
    Log.e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
    AppMethodBeat.o(112660);
  }
  
  public final void cGZ()
  {
    AppMethodBeat.i(112661);
    Log.i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
    if (!this.tns.stopped()) {
      this.tns.stopTimer();
    }
    AppMethodBeat.o(112661);
  }
  
  public final boolean cHc()
  {
    return (this.tni) || (this.tnk);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112669);
    Log.i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tng = false;
    AppMethodBeat.o(112669);
  }
  
  public final void report()
  {
    AppMethodBeat.i(112662);
    if (!cHc())
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
      AppMethodBeat.o(112662);
      return;
    }
    if (this.tng)
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
      AppMethodBeat.o(112662);
      return;
    }
    this.tng = true;
    boolean bool2 = cHb();
    boolean bool3 = cHa();
    boolean bool4 = this.tni;
    boolean bool5 = this.tnj;
    if (this.tnn == null) {}
    b localb;
    for (boolean bool1 = false;; bool1 = this.tnn.tnv)
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!bool2) || (!bool3)) {
        break;
      }
      localb = this.tnn.cHd();
      Log.i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", new Object[] { localb });
      Log.d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.iQE), Float.valueOf(this.iQD) });
      a(this.tmG, localb.tnB, this.iQE, this.iQD, localb.rssi, this.tnn.tnv);
      this.tnq = System.currentTimeMillis();
      this.tnp = System.currentTimeMillis();
      this.tnn.reset();
      this.tnm = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool2)
    {
      localb = this.tnn.cHd();
      Log.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", new Object[] { localb });
      a(this.tmG, localb.tnB, localb.rssi, this.tnn.tnv);
      this.tnp = System.currentTimeMillis();
      this.tnn.reset();
      this.tnm = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool3)
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
      Log.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.iQE), Float.valueOf(this.iQD) });
      a(this.tmG, this.iQE, this.iQD);
      this.tnq = System.currentTimeMillis();
      AppMethodBeat.o(112662);
      return;
    }
    Log.e("MicroMsg.CardLbsOrBluetooth", "not report");
    this.tng = false;
    AppMethodBeat.o(112662);
  }
  
  public final void start()
  {
    AppMethodBeat.i(112659);
    if (!cHc())
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
    if (this.tni) {
      bJU();
    }
    if ((this.tnn != null) && (this.tnk)) {
      this.tnn.cHe();
    }
    cGY();
    com.tencent.mm.kernel.h.aHF().kcd.a(2574, this);
    AppMethodBeat.o(112659);
  }
  
  public final class a
  {
    public BroadcastReceiver oGW;
    private BluetoothAdapter oTU;
    private volatile boolean tnu;
    boolean tnv;
    Map<String, i.b> tnw;
    long tnx;
    Runnable tny;
    private BluetoothAdapter.LeScanCallback tnz;
    
    private a()
    {
      AppMethodBeat.i(112650);
      this.tnu = false;
      this.tnv = false;
      this.tnw = new ConcurrentHashMap();
      this.tnx = 3000L;
      this.tny = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(112647);
          i.a.this.cHf();
          i.a.this.cHe();
          AppMethodBeat.o(112647);
        }
      };
      this.tnz = new BluetoothAdapter.LeScanCallback()
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
          if ((i.b(i.this) == null) || (Util.isNullOrNil(i.b(i.this).name)))
          {
            AppMethodBeat.o(112649);
            return;
          }
          String str = Util.nullAsNil(paramAnonymousBluetoothDevice.getName());
          paramAnonymousBluetoothDevice = paramAnonymousBluetoothDevice.getAddress();
          if (str.equals(i.b(i.this).name))
          {
            Log.i("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
            paramAnonymousArrayOfByte = new i.b(paramAnonymousBluetoothDevice, paramAnonymousInt, str, i.a.bp(paramAnonymousArrayOfByte));
            i.a.this.tnw.put(paramAnonymousBluetoothDevice, paramAnonymousArrayOfByte);
            AppMethodBeat.o(112649);
            return;
          }
          Log.d("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(112649);
        }
      };
      AppMethodBeat.o(112650);
    }
    
    public static byte[] bp(byte[] paramArrayOfByte)
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
    
    public final i.b cHd()
    {
      AppMethodBeat.i(112652);
      Object localObject = new i.b("", -100, "", null);
      if (this.tnw.size() <= 0)
      {
        AppMethodBeat.o(112652);
        return localObject;
      }
      Iterator localIterator = this.tnw.values().iterator();
      if (localIterator.hasNext())
      {
        i.b localb = (i.b)localIterator.next();
        if (((i.b)localObject).rssi >= localb.rssi) {
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
    public final void cHe()
    {
      AppMethodBeat.i(112653);
      if (Build.VERSION.SDK_INT < 18)
      {
        Log.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        AppMethodBeat.o(112653);
        return;
      }
      if (this.tnu)
      {
        Log.i("MicroMsg.CardLbsOrBluetooth", "already start");
        AppMethodBeat.o(112653);
        return;
      }
      this.tnw.clear();
      Object localObject = (BluetoothManager)MMApplicationContext.getContext().getSystemService("bluetooth");
      if (localObject == null)
      {
        this.tnv = false;
        Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
        AppMethodBeat.o(112653);
        return;
      }
      this.tnv = true;
      this.oTU = ((BluetoothManager)localObject).getAdapter();
      if ((this.oTU == null) || (!this.oTU.isEnabled()))
      {
        this.tnv = false;
        Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
        AppMethodBeat.o(112653);
        return;
      }
      Log.i("MicroMsg.CardLbsOrBluetooth", "[BluetoothTrace] start scan");
      Log.printErrStackTrace("MicroMsg.CardLbsOrBluetooth", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
      localObject = this.oTU;
      BluetoothAdapter.LeScanCallback localLeScanCallback = this.tnz;
      Log.i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", new Object[] { Boolean.valueOf(((Boolean)com.tencent.mm.hellhoundlib.a.a.a(localObject, new com.tencent.mm.hellhoundlib.b.a().bm(localLeScanCallback).aFh(), "com/tencent/mm/plugin/card/mgr/CardLbsOrBluetoothInfoManager$BluetoothHelper", "startScanBluetooth", "()V", "android/bluetooth/BluetoothAdapter", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z")).booleanValue()) });
      this.tnu = true;
      AppMethodBeat.o(112653);
    }
    
    @TargetApi(18)
    public final void cHf()
    {
      AppMethodBeat.i(112654);
      if (Build.VERSION.SDK_INT < 18)
      {
        Log.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        AppMethodBeat.o(112654);
        return;
      }
      if (!this.tnu)
      {
        Log.i("MicroMsg.CardLbsOrBluetooth", "not start");
        AppMethodBeat.o(112654);
        return;
      }
      if ((this.oTU == null) || (!this.oTU.isEnabled()))
      {
        this.tnv = false;
        Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
        AppMethodBeat.o(112654);
        return;
      }
      this.tnv = true;
      this.oTU.stopLeScan(this.tnz);
      Log.i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
      this.tnu = false;
      AppMethodBeat.o(112654);
    }
    
    public final void reset()
    {
      AppMethodBeat.i(112651);
      this.tnw.clear();
      AppMethodBeat.o(112651);
    }
  }
  
  static final class b
  {
    String fzB;
    String name;
    int rssi;
    byte[] tnB;
    
    public b(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
    {
      this.fzB = paramString1;
      this.rssi = paramInt;
      this.name = paramString2;
      this.tnB = paramArrayOfByte;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(112656);
      String str = "SrvDeviceInfo{deviceId='" + this.fzB + '\'' + ", rssi=" + this.rssi + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.tnB) + '}';
      AppMethodBeat.o(112656);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i
 * JD-Core Version:    0.7.0.1
 */