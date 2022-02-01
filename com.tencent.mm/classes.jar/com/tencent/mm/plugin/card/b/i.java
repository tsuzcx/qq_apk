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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class i
  implements com.tencent.mm.ak.g
{
  public Object cXD;
  public volatile boolean cqf;
  public volatile float fmX;
  public volatile float fmY;
  public MMActivity nTA;
  private volatile boolean nTB;
  private boolean nTC;
  boolean nTD;
  private boolean nTE;
  oj nTF;
  private b nTG;
  public a nTH;
  private int nTI;
  private long nTJ;
  private long nTK;
  private long nTL;
  public au nTM;
  String nTb;
  private com.tencent.mm.plugin.card.base.b nTp;
  
  public i()
  {
    AppMethodBeat.i(112657);
    this.cqf = false;
    this.nTB = false;
    this.cXD = new Object();
    this.nTC = false;
    this.nTD = false;
    this.fmX = -85.0F;
    this.fmY = -1000.0F;
    this.nTE = false;
    this.nTI = 60;
    this.nTJ = 0L;
    this.nTK = 0L;
    this.nTL = 10000L;
    this.nTM = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112645);
        i.this.report();
        i.this.bPO();
        AppMethodBeat.o(112645);
        return true;
      }
    }, false);
    AppMethodBeat.o(112657);
  }
  
  private void a(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112665);
    boolean bool = this.nTD;
    a(paramString, new byte[0], paramFloat1, paramFloat2, 0, false, bool);
    AppMethodBeat.o(112665);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112667);
    a(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean, this.nTD);
    AppMethodBeat.o(112667);
  }
  
  static void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112668);
    paramString = new com.tencent.mm.plugin.card.model.ai(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
    AppMethodBeat.o(112668);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112666);
    a(paramString, paramArrayOfByte, -1000.0F, -85.0F, paramInt, paramBoolean, this.nTD);
    AppMethodBeat.o(112666);
  }
  
  private static void aZl()
  {
    AppMethodBeat.i(112670);
    LocationManager localLocationManager = (LocationManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("location");
    if (localLocationManager != null) {
      ac.i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", new Object[] { Boolean.valueOf(localLocationManager.isProviderEnabled("gps")), Boolean.valueOf(localLocationManager.isProviderEnabled("network")) });
    }
    AppMethodBeat.o(112670);
  }
  
  private boolean bPQ()
  {
    boolean bool = true;
    AppMethodBeat.i(112663);
    synchronized (this.cXD)
    {
      int i;
      if (System.currentTimeMillis() - this.nTK >= this.nTL)
      {
        i = 1;
        if ((Float.compare(this.fmX, -85.0F) == 0) || (Float.compare(this.fmY, -1000.0F) == 0)) {
          break label97;
        }
      }
      label97:
      for (int j = 1;; j = 0)
      {
        if ((!this.nTD) || (!this.nTC) || (j == 0) || (i == 0)) {
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
  
  private boolean bPR()
  {
    AppMethodBeat.i(112664);
    if (!this.nTE)
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.nTH == null)
    {
      ac.e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.nTH.bPT().cIZ.equals(""))
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (System.currentTimeMillis() - this.nTJ >= this.nTL)
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
    this.cqf = true;
    this.nTA = paramMMActivity;
    this.nTb = paramString;
    this.nTp = paramb;
    this.fmX = paramFloat1;
    this.fmY = paramFloat2;
    this.nTC = paramb.bPi().EkY;
    this.nTD = paramb.bPj().Eiv;
    this.nTF = paramb.bPi().EkZ;
    int i;
    if (paramb.bPi().EkZ == null)
    {
      i = 60;
      this.nTI = i;
      if ((paramb.bPi().EkZ == null) || (bs.isNullOrNil(paramb.bPi().EkZ.name))) {
        break label328;
      }
    }
    label328:
    for (boolean bool = true;; bool = false)
    {
      this.nTE = bool;
      ac.i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", new Object[] { paramString, Boolean.valueOf(this.nTC), Boolean.valueOf(this.nTD), Boolean.valueOf(this.nTE), Integer.valueOf(this.nTI) });
      if ((this.nTC) && (!this.nTD)) {
        break label334;
      }
      if (this.nTE)
      {
        ac.i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", new Object[] { this.nTF.name });
        this.nTH = new a((byte)0);
        paramMMActivity = this.nTH;
        ac.i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
        paramMMActivity.kia = new i.a.2(paramMMActivity);
        paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        com.tencent.mm.sdk.platformtools.ai.getContext().registerReceiver(paramMMActivity.kia, paramString);
      }
      start();
      report();
      AppMethodBeat.o(112658);
      return;
      i = paramb.bPi().EkZ.Eei;
      break;
    }
    label334:
    if (bs.isNullOrNil(this.nTp.bPi().Ela)) {}
    for (paramMMActivity = this.nTp.bPi().title;; paramMMActivity = this.nTp.bPi().Ela)
    {
      h.a(this.nTA, this.nTA.getString(2131756956, new Object[] { paramMMActivity }), this.nTA.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(112646);
          i.this.nTD = true;
          i.a(i.this.nTb, new byte[0], -85.0F, -1000.0F, 0, false, true);
          AppMethodBeat.o(112646);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          i.this.nTD = false;
        }
      });
      break;
    }
  }
  
  public final void bPO()
  {
    AppMethodBeat.i(112660);
    bPP();
    if (this.nTI > 0)
    {
      au localau = this.nTM;
      long l = this.nTI * 1000;
      localau.au(l, l);
      ac.i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
      AppMethodBeat.o(112660);
      return;
    }
    ac.e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
    AppMethodBeat.o(112660);
  }
  
  public final void bPP()
  {
    AppMethodBeat.i(112661);
    ac.i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
    if (!this.nTM.eVs()) {
      this.nTM.stopTimer();
    }
    AppMethodBeat.o(112661);
  }
  
  public final boolean bPS()
  {
    return (this.nTC) || (this.nTE);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112669);
    ac.i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nTB = false;
    AppMethodBeat.o(112669);
  }
  
  public final void report()
  {
    AppMethodBeat.i(112662);
    if (!bPS())
    {
      ac.i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
      AppMethodBeat.o(112662);
      return;
    }
    if (this.nTB)
    {
      ac.i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
      AppMethodBeat.o(112662);
      return;
    }
    this.nTB = true;
    boolean bool2 = bPR();
    boolean bool3 = bPQ();
    boolean bool4 = this.nTC;
    boolean bool5 = this.nTD;
    if (this.nTH == null) {}
    b localb;
    for (boolean bool1 = false;; bool1 = this.nTH.nTP)
    {
      ac.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!bool2) || (!bool3)) {
        break;
      }
      localb = this.nTH.bPT();
      ac.i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", new Object[] { localb });
      ac.d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.fmY), Float.valueOf(this.fmX) });
      a(this.nTb, localb.nTV, this.fmY, this.fmX, localb.dfk, this.nTH.nTP);
      this.nTK = System.currentTimeMillis();
      this.nTJ = System.currentTimeMillis();
      this.nTH.reset();
      this.nTG = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool2)
    {
      localb = this.nTH.bPT();
      ac.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", new Object[] { localb });
      a(this.nTb, localb.nTV, localb.dfk, this.nTH.nTP);
      this.nTJ = System.currentTimeMillis();
      this.nTH.reset();
      this.nTG = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool3)
    {
      ac.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
      ac.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.fmY), Float.valueOf(this.fmX) });
      a(this.nTb, this.fmY, this.fmX);
      this.nTK = System.currentTimeMillis();
      AppMethodBeat.o(112662);
      return;
    }
    ac.e("MicroMsg.CardLbsOrBluetooth", "not report");
    this.nTB = false;
    AppMethodBeat.o(112662);
  }
  
  public final void start()
  {
    AppMethodBeat.i(112659);
    if (!bPS())
    {
      AppMethodBeat.o(112659);
      return;
    }
    ac.i("MicroMsg.CardLbsOrBluetooth", "start");
    if (!this.cqf)
    {
      ac.e("MicroMsg.CardLbsOrBluetooth", "isInit:%b", new Object[] { Boolean.valueOf(this.cqf) });
      AppMethodBeat.o(112659);
      return;
    }
    if (this.nTC) {
      aZl();
    }
    if ((this.nTH != null) && (this.nTE)) {
      this.nTH.bPU();
    }
    bPO();
    com.tencent.mm.kernel.g.agQ().ghe.a(2574, this);
    AppMethodBeat.o(112659);
  }
  
  public final class a
  {
    public BroadcastReceiver kia;
    private BluetoothAdapter ksj;
    private volatile boolean nTO;
    boolean nTP;
    Map<String, i.b> nTQ;
    long nTR;
    Runnable nTS;
    private BluetoothAdapter.LeScanCallback nTT;
    
    private a()
    {
      AppMethodBeat.i(112650);
      this.nTO = false;
      this.nTP = false;
      this.nTQ = new ConcurrentHashMap();
      this.nTR = 3000L;
      this.nTS = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(112647);
          i.a.this.bPV();
          i.a.this.bPU();
          AppMethodBeat.o(112647);
        }
      };
      this.nTT = new BluetoothAdapter.LeScanCallback()
      {
        public final void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(112649);
          if (paramAnonymousBluetoothDevice == null)
          {
            ac.e("MicroMsg.CardLbsOrBluetooth", "device is null, return");
            AppMethodBeat.o(112649);
            return;
          }
          if ((i.this.nTF == null) || (bs.isNullOrNil(i.this.nTF.name)))
          {
            AppMethodBeat.o(112649);
            return;
          }
          String str = bs.nullAsNil(paramAnonymousBluetoothDevice.getName());
          paramAnonymousBluetoothDevice = paramAnonymousBluetoothDevice.getAddress();
          if (str.equals(i.this.nTF.name))
          {
            ac.i("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
            paramAnonymousArrayOfByte = new i.b(paramAnonymousBluetoothDevice, paramAnonymousInt, str, i.a.aJ(paramAnonymousArrayOfByte));
            i.a.this.nTQ.put(paramAnonymousBluetoothDevice, paramAnonymousArrayOfByte);
            AppMethodBeat.o(112649);
            return;
          }
          ac.d("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[] { paramAnonymousBluetoothDevice, str, Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(112649);
        }
      };
      AppMethodBeat.o(112650);
    }
    
    public static byte[] aJ(byte[] paramArrayOfByte)
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
    
    public final i.b bPT()
    {
      AppMethodBeat.i(112652);
      Object localObject = new i.b("", -100, "", null);
      if (this.nTQ.size() <= 0)
      {
        AppMethodBeat.o(112652);
        return localObject;
      }
      Iterator localIterator = this.nTQ.values().iterator();
      if (localIterator.hasNext())
      {
        i.b localb = (i.b)localIterator.next();
        if (((i.b)localObject).dfk >= localb.dfk) {
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
    public final void bPU()
    {
      AppMethodBeat.i(112653);
      if (Build.VERSION.SDK_INT < 18)
      {
        ac.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        AppMethodBeat.o(112653);
        return;
      }
      if (this.nTO)
      {
        ac.i("MicroMsg.CardLbsOrBluetooth", "already start");
        AppMethodBeat.o(112653);
        return;
      }
      this.nTQ.clear();
      BluetoothManager localBluetoothManager = (BluetoothManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("bluetooth");
      if (localBluetoothManager == null)
      {
        this.nTP = false;
        ac.e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
        AppMethodBeat.o(112653);
        return;
      }
      this.nTP = true;
      this.ksj = localBluetoothManager.getAdapter();
      if ((this.ksj == null) || (!this.ksj.isEnabled()))
      {
        this.nTP = false;
        ac.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
        AppMethodBeat.o(112653);
        return;
      }
      ac.i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", new Object[] { Boolean.valueOf(this.ksj.startLeScan(this.nTT)) });
      this.nTO = true;
      AppMethodBeat.o(112653);
    }
    
    @TargetApi(18)
    public final void bPV()
    {
      AppMethodBeat.i(112654);
      if (Build.VERSION.SDK_INT < 18)
      {
        ac.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        AppMethodBeat.o(112654);
        return;
      }
      if (!this.nTO)
      {
        ac.i("MicroMsg.CardLbsOrBluetooth", "not start");
        AppMethodBeat.o(112654);
        return;
      }
      if ((this.ksj == null) || (!this.ksj.isEnabled()))
      {
        this.nTP = false;
        ac.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
        AppMethodBeat.o(112654);
        return;
      }
      this.nTP = true;
      this.ksj.stopLeScan(this.nTT);
      ac.i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
      this.nTO = false;
      AppMethodBeat.o(112654);
    }
    
    public final void reset()
    {
      AppMethodBeat.i(112651);
      this.nTQ.clear();
      AppMethodBeat.o(112651);
    }
  }
  
  static final class b
  {
    String cIZ;
    int dfk;
    byte[] nTV;
    String name;
    
    public b(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
    {
      this.cIZ = paramString1;
      this.dfk = paramInt;
      this.name = paramString2;
      this.nTV = paramArrayOfByte;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(112656);
      String str = "SrvDeviceInfo{deviceId='" + this.cIZ + '\'' + ", rssi=" + this.dfk + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.nTV) + '}';
      AppMethodBeat.o(112656);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i
 * JD-Core Version:    0.7.0.1
 */