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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.ai;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
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
  public volatile boolean cBE;
  public Object djX;
  public volatile float fHj;
  public volatile float fHk;
  String oCY;
  boolean oDA;
  private boolean oDB;
  pq oDC;
  private b oDD;
  public a oDE;
  private int oDF;
  private long oDG;
  private long oDH;
  private long oDI;
  public aw oDJ;
  private com.tencent.mm.plugin.card.base.b oDm;
  public MMActivity oDx;
  private volatile boolean oDy;
  private boolean oDz;
  
  public i()
  {
    AppMethodBeat.i(112657);
    this.cBE = false;
    this.oDy = false;
    this.djX = new Object();
    this.oDz = false;
    this.oDA = false;
    this.fHj = -85.0F;
    this.fHk = -1000.0F;
    this.oDB = false;
    this.oDF = 60;
    this.oDG = 0L;
    this.oDH = 0L;
    this.oDI = 10000L;
    this.oDJ = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112645);
        i.this.report();
        i.this.bVI();
        AppMethodBeat.o(112645);
        return true;
      }
    }, false);
    AppMethodBeat.o(112657);
  }
  
  private void a(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112665);
    boolean bool = this.oDA;
    a(paramString, new byte[0], paramFloat1, paramFloat2, 0, false, bool);
    AppMethodBeat.o(112665);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112667);
    a(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean, this.oDA);
    AppMethodBeat.o(112667);
  }
  
  static void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112668);
    paramString = new ai(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    g.ajQ().gDv.a(paramString, 0);
    AppMethodBeat.o(112668);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112666);
    a(paramString, paramArrayOfByte, -1000.0F, -85.0F, paramInt, paramBoolean, this.oDA);
    AppMethodBeat.o(112666);
  }
  
  private boolean bVK()
  {
    boolean bool = true;
    AppMethodBeat.i(112663);
    synchronized (this.djX)
    {
      int i;
      if (System.currentTimeMillis() - this.oDH >= this.oDI)
      {
        i = 1;
        if ((Float.compare(this.fHj, -85.0F) == 0) || (Float.compare(this.fHk, -1000.0F) == 0)) {
          break label97;
        }
      }
      label97:
      for (int j = 1;; j = 0)
      {
        if ((!this.oDA) || (!this.oDz) || (j == 0) || (i == 0)) {
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
  
  private boolean bVL()
  {
    AppMethodBeat.i(112664);
    if (!this.oDB)
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.oDE == null)
    {
      ae.e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.oDE.bVN().cVh.equals(""))
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (System.currentTimeMillis() - this.oDG >= this.oDI)
    {
      AppMethodBeat.o(112664);
      return true;
    }
    AppMethodBeat.o(112664);
    return false;
  }
  
  private static void bdo()
  {
    AppMethodBeat.i(112670);
    LocationManager localLocationManager = (LocationManager)ak.getContext().getSystemService("location");
    if (localLocationManager != null) {
      ae.i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", new Object[] { Boolean.valueOf(localLocationManager.isProviderEnabled("gps")), Boolean.valueOf(localLocationManager.isProviderEnabled("network")) });
    }
    AppMethodBeat.o(112670);
  }
  
  public final void a(MMActivity paramMMActivity, String paramString, com.tencent.mm.plugin.card.base.b paramb, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112658);
    this.cBE = true;
    this.oDx = paramMMActivity;
    this.oCY = paramString;
    this.oDm = paramb;
    this.fHj = paramFloat1;
    this.fHk = paramFloat2;
    this.oDz = paramb.bVc().GkG;
    this.oDA = paramb.bVd().Gie;
    this.oDC = paramb.bVc().GkH;
    int i;
    if (paramb.bVc().GkH == null)
    {
      i = 60;
      this.oDF = i;
      if ((paramb.bVc().GkH == null) || (bu.isNullOrNil(paramb.bVc().GkH.name))) {
        break label328;
      }
    }
    label328:
    for (boolean bool = true;; bool = false)
    {
      this.oDB = bool;
      ae.i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", new Object[] { paramString, Boolean.valueOf(this.oDz), Boolean.valueOf(this.oDA), Boolean.valueOf(this.oDB), Integer.valueOf(this.oDF) });
      if ((this.oDz) && (!this.oDA)) {
        break label334;
      }
      if (this.oDB)
      {
        ae.i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", new Object[] { this.oDC.name });
        this.oDE = new a((byte)0);
        paramMMActivity = this.oDE;
        ae.i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
        paramMMActivity.kGi = new i.a.2(paramMMActivity);
        paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        ak.getContext().registerReceiver(paramMMActivity.kGi, paramString);
      }
      start();
      report();
      AppMethodBeat.o(112658);
      return;
      i = paramb.bVc().GkH.Gdg;
      break;
    }
    label334:
    if (bu.isNullOrNil(this.oDm.bVc().GkI)) {}
    for (paramMMActivity = this.oDm.bVc().title;; paramMMActivity = this.oDm.bVc().GkI)
    {
      h.a(this.oDx, this.oDx.getString(2131756956, new Object[] { paramMMActivity }), this.oDx.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(112646);
          i.this.oDA = true;
          i.a(i.this.oCY, new byte[0], -85.0F, -1000.0F, 0, false, true);
          AppMethodBeat.o(112646);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          i.this.oDA = false;
        }
      });
      break;
    }
  }
  
  public final void bVI()
  {
    AppMethodBeat.i(112660);
    bVJ();
    if (this.oDF > 0)
    {
      aw localaw = this.oDJ;
      long l = this.oDF * 1000;
      localaw.ay(l, l);
      ae.i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
      AppMethodBeat.o(112660);
      return;
    }
    ae.e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
    AppMethodBeat.o(112660);
  }
  
  public final void bVJ()
  {
    AppMethodBeat.i(112661);
    ae.i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
    if (!this.oDJ.foU()) {
      this.oDJ.stopTimer();
    }
    AppMethodBeat.o(112661);
  }
  
  public final boolean bVM()
  {
    return (this.oDz) || (this.oDB);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112669);
    ae.i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.oDy = false;
    AppMethodBeat.o(112669);
  }
  
  public final void report()
  {
    AppMethodBeat.i(112662);
    if (!bVM())
    {
      ae.i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
      AppMethodBeat.o(112662);
      return;
    }
    if (this.oDy)
    {
      ae.i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
      AppMethodBeat.o(112662);
      return;
    }
    this.oDy = true;
    boolean bool2 = bVL();
    boolean bool3 = bVK();
    boolean bool4 = this.oDz;
    boolean bool5 = this.oDA;
    if (this.oDE == null) {}
    b localb;
    for (boolean bool1 = false;; bool1 = this.oDE.oDM)
    {
      ae.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!bool2) || (!bool3)) {
        break;
      }
      localb = this.oDE.bVN();
      ae.i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", new Object[] { localb });
      ae.d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.fHk), Float.valueOf(this.fHj) });
      a(this.oCY, localb.oDS, this.fHk, this.fHj, localb.drL, this.oDE.oDM);
      this.oDH = System.currentTimeMillis();
      this.oDG = System.currentTimeMillis();
      this.oDE.reset();
      this.oDD = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool2)
    {
      localb = this.oDE.bVN();
      ae.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", new Object[] { localb });
      a(this.oCY, localb.oDS, localb.drL, this.oDE.oDM);
      this.oDG = System.currentTimeMillis();
      this.oDE.reset();
      this.oDD = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool3)
    {
      ae.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
      ae.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.fHk), Float.valueOf(this.fHj) });
      a(this.oCY, this.fHk, this.fHj);
      this.oDH = System.currentTimeMillis();
      AppMethodBeat.o(112662);
      return;
    }
    ae.e("MicroMsg.CardLbsOrBluetooth", "not report");
    this.oDy = false;
    AppMethodBeat.o(112662);
  }
  
  public final void start()
  {
    AppMethodBeat.i(112659);
    if (!bVM())
    {
      AppMethodBeat.o(112659);
      return;
    }
    ae.i("MicroMsg.CardLbsOrBluetooth", "start");
    if (!this.cBE)
    {
      ae.e("MicroMsg.CardLbsOrBluetooth", "isInit:%b", new Object[] { Boolean.valueOf(this.cBE) });
      AppMethodBeat.o(112659);
      return;
    }
    if (this.oDz) {
      bdo();
    }
    if ((this.oDE != null) && (this.oDB)) {
      this.oDE.bVO();
    }
    bVI();
    g.ajQ().gDv.a(2574, this);
    AppMethodBeat.o(112659);
  }
  
  public final class a
  {
    public BroadcastReceiver kGi;
    private BluetoothAdapter kRh;
    private volatile boolean oDL;
    boolean oDM;
    Map<String, i.b> oDN;
    long oDO;
    Runnable oDP;
    private BluetoothAdapter.LeScanCallback oDQ;
    
    private a()
    {
      AppMethodBeat.i(112650);
      this.oDL = false;
      this.oDM = false;
      this.oDN = new ConcurrentHashMap();
      this.oDO = 3000L;
      this.oDP = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(112647);
          i.a.this.bVP();
          i.a.this.bVO();
          AppMethodBeat.o(112647);
        }
      };
      this.oDQ = new BluetoothAdapter.LeScanCallback()
      {
        public final void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(112649);
          if (paramAnonymousBluetoothDevice == null)
          {
            ae.e("MicroMsg.CardLbsOrBluetooth", "device is null, return");
            AppMethodBeat.o(112649);
            return;
          }
          if ((i.this.oDC == null) || (bu.isNullOrNil(i.this.oDC.name)))
          {
            AppMethodBeat.o(112649);
            return;
          }
          String str = bu.nullAsNil(paramAnonymousBluetoothDevice.getName());
          paramAnonymousBluetoothDevice = paramAnonymousBluetoothDevice.getAddress();
          if (str.equals(i.this.oDC.name))
          {
            ae.i("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
            paramAnonymousArrayOfByte = new i.b(paramAnonymousBluetoothDevice, paramAnonymousInt, str, i.a.aL(paramAnonymousArrayOfByte));
            i.a.this.oDN.put(paramAnonymousBluetoothDevice, paramAnonymousArrayOfByte);
            AppMethodBeat.o(112649);
            return;
          }
          ae.d("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(112649);
        }
      };
      AppMethodBeat.o(112650);
    }
    
    public static byte[] aL(byte[] paramArrayOfByte)
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
    
    public final i.b bVN()
    {
      AppMethodBeat.i(112652);
      Object localObject = new i.b("", -100, "", null);
      if (this.oDN.size() <= 0)
      {
        AppMethodBeat.o(112652);
        return localObject;
      }
      Iterator localIterator = this.oDN.values().iterator();
      if (localIterator.hasNext())
      {
        i.b localb = (i.b)localIterator.next();
        if (((i.b)localObject).drL >= localb.drL) {
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
    public final void bVO()
    {
      AppMethodBeat.i(112653);
      if (Build.VERSION.SDK_INT < 18)
      {
        ae.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        AppMethodBeat.o(112653);
        return;
      }
      if (this.oDL)
      {
        ae.i("MicroMsg.CardLbsOrBluetooth", "already start");
        AppMethodBeat.o(112653);
        return;
      }
      this.oDN.clear();
      BluetoothManager localBluetoothManager = (BluetoothManager)ak.getContext().getSystemService("bluetooth");
      if (localBluetoothManager == null)
      {
        this.oDM = false;
        ae.e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
        AppMethodBeat.o(112653);
        return;
      }
      this.oDM = true;
      this.kRh = localBluetoothManager.getAdapter();
      if ((this.kRh == null) || (!this.kRh.isEnabled()))
      {
        this.oDM = false;
        ae.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
        AppMethodBeat.o(112653);
        return;
      }
      ae.i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", new Object[] { Boolean.valueOf(this.kRh.startLeScan(this.oDQ)) });
      this.oDL = true;
      AppMethodBeat.o(112653);
    }
    
    @TargetApi(18)
    public final void bVP()
    {
      AppMethodBeat.i(112654);
      if (Build.VERSION.SDK_INT < 18)
      {
        ae.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        AppMethodBeat.o(112654);
        return;
      }
      if (!this.oDL)
      {
        ae.i("MicroMsg.CardLbsOrBluetooth", "not start");
        AppMethodBeat.o(112654);
        return;
      }
      if ((this.kRh == null) || (!this.kRh.isEnabled()))
      {
        this.oDM = false;
        ae.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
        AppMethodBeat.o(112654);
        return;
      }
      this.oDM = true;
      this.kRh.stopLeScan(this.oDQ);
      ae.i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
      this.oDL = false;
      AppMethodBeat.o(112654);
    }
    
    public final void reset()
    {
      AppMethodBeat.i(112651);
      this.oDN.clear();
      AppMethodBeat.o(112651);
    }
  }
  
  static final class b
  {
    String cVh;
    int drL;
    String name;
    byte[] oDS;
    
    public b(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
    {
      this.cVh = paramString1;
      this.drL = paramInt;
      this.name = paramString2;
      this.oDS = paramArrayOfByte;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(112656);
      String str = "SrvDeviceInfo{deviceId='" + this.cVh + '\'' + ", rssi=" + this.drL + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.oDS) + '}';
      AppMethodBeat.o(112656);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i
 * JD-Core Version:    0.7.0.1
 */