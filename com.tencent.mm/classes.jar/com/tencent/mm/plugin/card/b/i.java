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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.ai;
import com.tencent.mm.protocal.protobuf.po;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class i
  implements f
{
  public volatile boolean cAX;
  public Object diV;
  public volatile float fFf;
  public volatile float fFg;
  private com.tencent.mm.plugin.card.base.b owK;
  public MMActivity owV;
  private volatile boolean owW;
  private boolean owX;
  boolean owY;
  private boolean owZ;
  String oww;
  po oxa;
  private b oxb;
  public a oxc;
  private int oxd;
  private long oxe;
  private long oxf;
  private long oxg;
  public av oxh;
  
  public i()
  {
    AppMethodBeat.i(112657);
    this.cAX = false;
    this.owW = false;
    this.diV = new Object();
    this.owX = false;
    this.owY = false;
    this.fFf = -85.0F;
    this.fFg = -1000.0F;
    this.owZ = false;
    this.oxd = 60;
    this.oxe = 0L;
    this.oxf = 0L;
    this.oxg = 10000L;
    this.oxh = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112645);
        i.this.report();
        i.this.bUt();
        AppMethodBeat.o(112645);
        return true;
      }
    }, false);
    AppMethodBeat.o(112657);
  }
  
  private void a(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112665);
    boolean bool = this.owY;
    a(paramString, new byte[0], paramFloat1, paramFloat2, 0, false, bool);
    AppMethodBeat.o(112665);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112667);
    a(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean, this.owY);
    AppMethodBeat.o(112667);
  }
  
  static void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112668);
    paramString = new ai(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    g.ajB().gAO.a(paramString, 0);
    AppMethodBeat.o(112668);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112666);
    a(paramString, paramArrayOfByte, -1000.0F, -85.0F, paramInt, paramBoolean, this.owY);
    AppMethodBeat.o(112666);
  }
  
  private boolean bUv()
  {
    boolean bool = true;
    AppMethodBeat.i(112663);
    synchronized (this.diV)
    {
      int i;
      if (System.currentTimeMillis() - this.oxf >= this.oxg)
      {
        i = 1;
        if ((Float.compare(this.fFf, -85.0F) == 0) || (Float.compare(this.fFg, -1000.0F) == 0)) {
          break label97;
        }
      }
      label97:
      for (int j = 1;; j = 0)
      {
        if ((!this.owY) || (!this.owX) || (j == 0) || (i == 0)) {
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
  
  private boolean bUw()
  {
    AppMethodBeat.i(112664);
    if (!this.owZ)
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.oxc == null)
    {
      ad.e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.oxc.bUy().cUi.equals(""))
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (System.currentTimeMillis() - this.oxe >= this.oxg)
    {
      AppMethodBeat.o(112664);
      return true;
    }
    AppMethodBeat.o(112664);
    return false;
  }
  
  private static void bcJ()
  {
    AppMethodBeat.i(112670);
    LocationManager localLocationManager = (LocationManager)aj.getContext().getSystemService("location");
    if (localLocationManager != null) {
      ad.i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", new Object[] { Boolean.valueOf(localLocationManager.isProviderEnabled("gps")), Boolean.valueOf(localLocationManager.isProviderEnabled("network")) });
    }
    AppMethodBeat.o(112670);
  }
  
  public final void a(MMActivity paramMMActivity, String paramString, com.tencent.mm.plugin.card.base.b paramb, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112658);
    this.cAX = true;
    this.owV = paramMMActivity;
    this.oww = paramString;
    this.owK = paramb;
    this.fFf = paramFloat1;
    this.fFg = paramFloat2;
    this.owX = paramb.bTN().FSh;
    this.owY = paramb.bTO().FPF;
    this.oxa = paramb.bTN().FSi;
    int i;
    if (paramb.bTN().FSi == null)
    {
      i = 60;
      this.oxd = i;
      if ((paramb.bTN().FSi == null) || (bt.isNullOrNil(paramb.bTN().FSi.name))) {
        break label328;
      }
    }
    label328:
    for (boolean bool = true;; bool = false)
    {
      this.owZ = bool;
      ad.i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", new Object[] { paramString, Boolean.valueOf(this.owX), Boolean.valueOf(this.owY), Boolean.valueOf(this.owZ), Integer.valueOf(this.oxd) });
      if ((this.owX) && (!this.owY)) {
        break label334;
      }
      if (this.owZ)
      {
        ad.i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", new Object[] { this.oxa.name });
        this.oxc = new a((byte)0);
        paramMMActivity = this.oxc;
        ad.i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
        paramMMActivity.kCT = new i.a.2(paramMMActivity);
        paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        aj.getContext().registerReceiver(paramMMActivity.kCT, paramString);
      }
      start();
      report();
      AppMethodBeat.o(112658);
      return;
      i = paramb.bTN().FSi.FKH;
      break;
    }
    label334:
    if (bt.isNullOrNil(this.owK.bTN().FSj)) {}
    for (paramMMActivity = this.owK.bTN().title;; paramMMActivity = this.owK.bTN().FSj)
    {
      h.a(this.owV, this.owV.getString(2131756956, new Object[] { paramMMActivity }), this.owV.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(112646);
          i.this.owY = true;
          i.a(i.this.oww, new byte[0], -85.0F, -1000.0F, 0, false, true);
          AppMethodBeat.o(112646);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          i.this.owY = false;
        }
      });
      break;
    }
  }
  
  public final void bUt()
  {
    AppMethodBeat.i(112660);
    bUu();
    if (this.oxd > 0)
    {
      av localav = this.oxh;
      long l = this.oxd * 1000;
      localav.az(l, l);
      ad.i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
      AppMethodBeat.o(112660);
      return;
    }
    ad.e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
    AppMethodBeat.o(112660);
  }
  
  public final void bUu()
  {
    AppMethodBeat.i(112661);
    ad.i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
    if (!this.oxh.fkZ()) {
      this.oxh.stopTimer();
    }
    AppMethodBeat.o(112661);
  }
  
  public final boolean bUx()
  {
    return (this.owX) || (this.owZ);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112669);
    ad.i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.owW = false;
    AppMethodBeat.o(112669);
  }
  
  public final void report()
  {
    AppMethodBeat.i(112662);
    if (!bUx())
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
      AppMethodBeat.o(112662);
      return;
    }
    if (this.owW)
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
      AppMethodBeat.o(112662);
      return;
    }
    this.owW = true;
    boolean bool2 = bUw();
    boolean bool3 = bUv();
    boolean bool4 = this.owX;
    boolean bool5 = this.owY;
    if (this.oxc == null) {}
    b localb;
    for (boolean bool1 = false;; bool1 = this.oxc.oxk)
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!bool2) || (!bool3)) {
        break;
      }
      localb = this.oxc.bUy();
      ad.i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", new Object[] { localb });
      ad.d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.fFg), Float.valueOf(this.fFf) });
      a(this.oww, localb.oxq, this.fFg, this.fFf, localb.dqG, this.oxc.oxk);
      this.oxf = System.currentTimeMillis();
      this.oxe = System.currentTimeMillis();
      this.oxc.reset();
      this.oxb = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool2)
    {
      localb = this.oxc.bUy();
      ad.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", new Object[] { localb });
      a(this.oww, localb.oxq, localb.dqG, this.oxc.oxk);
      this.oxe = System.currentTimeMillis();
      this.oxc.reset();
      this.oxb = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool3)
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
      ad.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.fFg), Float.valueOf(this.fFf) });
      a(this.oww, this.fFg, this.fFf);
      this.oxf = System.currentTimeMillis();
      AppMethodBeat.o(112662);
      return;
    }
    ad.e("MicroMsg.CardLbsOrBluetooth", "not report");
    this.owW = false;
    AppMethodBeat.o(112662);
  }
  
  public final void start()
  {
    AppMethodBeat.i(112659);
    if (!bUx())
    {
      AppMethodBeat.o(112659);
      return;
    }
    ad.i("MicroMsg.CardLbsOrBluetooth", "start");
    if (!this.cAX)
    {
      ad.e("MicroMsg.CardLbsOrBluetooth", "isInit:%b", new Object[] { Boolean.valueOf(this.cAX) });
      AppMethodBeat.o(112659);
      return;
    }
    if (this.owX) {
      bcJ();
    }
    if ((this.oxc != null) && (this.owZ)) {
      this.oxc.bUz();
    }
    bUt();
    g.ajB().gAO.a(2574, this);
    AppMethodBeat.o(112659);
  }
  
  public final class a
  {
    public BroadcastReceiver kCT;
    private BluetoothAdapter kNF;
    private volatile boolean oxj;
    boolean oxk;
    Map<String, i.b> oxl;
    long oxm;
    Runnable oxn;
    private BluetoothAdapter.LeScanCallback oxo;
    
    private a()
    {
      AppMethodBeat.i(112650);
      this.oxj = false;
      this.oxk = false;
      this.oxl = new ConcurrentHashMap();
      this.oxm = 3000L;
      this.oxn = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(112647);
          i.a.this.bUA();
          i.a.this.bUz();
          AppMethodBeat.o(112647);
        }
      };
      this.oxo = new BluetoothAdapter.LeScanCallback()
      {
        public final void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(112649);
          if (paramAnonymousBluetoothDevice == null)
          {
            ad.e("MicroMsg.CardLbsOrBluetooth", "device is null, return");
            AppMethodBeat.o(112649);
            return;
          }
          if ((i.this.oxa == null) || (bt.isNullOrNil(i.this.oxa.name)))
          {
            AppMethodBeat.o(112649);
            return;
          }
          String str = bt.nullAsNil(paramAnonymousBluetoothDevice.getName());
          paramAnonymousBluetoothDevice = paramAnonymousBluetoothDevice.getAddress();
          if (str.equals(i.this.oxa.name))
          {
            ad.i("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
            paramAnonymousArrayOfByte = new i.b(paramAnonymousBluetoothDevice, paramAnonymousInt, str, i.a.aM(paramAnonymousArrayOfByte));
            i.a.this.oxl.put(paramAnonymousBluetoothDevice, paramAnonymousArrayOfByte);
            AppMethodBeat.o(112649);
            return;
          }
          ad.d("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(112649);
        }
      };
      AppMethodBeat.o(112650);
    }
    
    public static byte[] aM(byte[] paramArrayOfByte)
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
    
    @TargetApi(18)
    public final void bUA()
    {
      AppMethodBeat.i(112654);
      if (Build.VERSION.SDK_INT < 18)
      {
        ad.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        AppMethodBeat.o(112654);
        return;
      }
      if (!this.oxj)
      {
        ad.i("MicroMsg.CardLbsOrBluetooth", "not start");
        AppMethodBeat.o(112654);
        return;
      }
      if ((this.kNF == null) || (!this.kNF.isEnabled()))
      {
        this.oxk = false;
        ad.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
        AppMethodBeat.o(112654);
        return;
      }
      this.oxk = true;
      this.kNF.stopLeScan(this.oxo);
      ad.i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
      this.oxj = false;
      AppMethodBeat.o(112654);
    }
    
    public final i.b bUy()
    {
      AppMethodBeat.i(112652);
      Object localObject = new i.b("", -100, "", null);
      if (this.oxl.size() <= 0)
      {
        AppMethodBeat.o(112652);
        return localObject;
      }
      Iterator localIterator = this.oxl.values().iterator();
      if (localIterator.hasNext())
      {
        i.b localb = (i.b)localIterator.next();
        if (((i.b)localObject).dqG >= localb.dqG) {
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
    public final void bUz()
    {
      AppMethodBeat.i(112653);
      if (Build.VERSION.SDK_INT < 18)
      {
        ad.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        AppMethodBeat.o(112653);
        return;
      }
      if (this.oxj)
      {
        ad.i("MicroMsg.CardLbsOrBluetooth", "already start");
        AppMethodBeat.o(112653);
        return;
      }
      this.oxl.clear();
      BluetoothManager localBluetoothManager = (BluetoothManager)aj.getContext().getSystemService("bluetooth");
      if (localBluetoothManager == null)
      {
        this.oxk = false;
        ad.e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
        AppMethodBeat.o(112653);
        return;
      }
      this.oxk = true;
      this.kNF = localBluetoothManager.getAdapter();
      if ((this.kNF == null) || (!this.kNF.isEnabled()))
      {
        this.oxk = false;
        ad.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
        AppMethodBeat.o(112653);
        return;
      }
      ad.i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", new Object[] { Boolean.valueOf(this.kNF.startLeScan(this.oxo)) });
      this.oxj = true;
      AppMethodBeat.o(112653);
    }
    
    public final void reset()
    {
      AppMethodBeat.i(112651);
      this.oxl.clear();
      AppMethodBeat.o(112651);
    }
  }
  
  static final class b
  {
    String cUi;
    int dqG;
    String name;
    byte[] oxq;
    
    public b(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
    {
      this.cUi = paramString1;
      this.dqG = paramInt;
      this.name = paramString2;
      this.oxq = paramArrayOfByte;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(112656);
      String str = "SrvDeviceInfo{deviceId='" + this.cUi + '\'' + ", rssi=" + this.dqG + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.oxq) + '}';
      AppMethodBeat.o(112656);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i
 * JD-Core Version:    0.7.0.1
 */