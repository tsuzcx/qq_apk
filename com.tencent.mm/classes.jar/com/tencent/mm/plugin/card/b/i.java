package com.tencent.mm.plugin.card.b;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.IntentFilter;
import android.location.LocationManager;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.ai;
import com.tencent.mm.protocal.c.jq;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Arrays;
import java.util.Map;

public final class i
  implements f
{
  public volatile boolean dBn = false;
  public volatile float dia = -85.0F;
  public volatile float dib = -1000.0F;
  String ijW;
  private boolean ikA = false;
  jq ikB;
  private b ikC;
  public i.a ikD;
  private int ikE = 60;
  private long ikF = 0L;
  private long ikG = 0L;
  private long ikH = 10000L;
  public am ikI = new am(new i.1(this), false);
  private com.tencent.mm.plugin.card.base.b ikk;
  public MMActivity ikv;
  private volatile boolean ikw = false;
  public Object ikx = new Object();
  private boolean iky = false;
  boolean ikz = false;
  
  static void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = new ai(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    g.DO().dJT.a(paramString, 0);
  }
  
  private boolean aAa()
  {
    boolean bool = true;
    for (;;)
    {
      synchronized (this.ikx)
      {
        if (System.currentTimeMillis() - this.ikG >= this.ikH)
        {
          i = 1;
          if ((Float.compare(this.dia, -85.0F) == 0) || (Float.compare(this.dib, -1000.0F) == 0)) {
            break label95;
          }
          j = 1;
          if ((!this.ikz) || (!this.iky) || (j == 0) || (i == 0)) {
            break label100;
          }
          return bool;
        }
      }
      int i = 0;
      continue;
      label95:
      int j = 0;
      continue;
      label100:
      bool = false;
    }
  }
  
  public final void a(MMActivity paramMMActivity, String paramString, com.tencent.mm.plugin.card.base.b paramb, float paramFloat1, float paramFloat2)
  {
    this.dBn = true;
    this.ikv = paramMMActivity;
    this.ijW = paramString;
    this.ikk = paramb;
    this.dia = paramFloat1;
    this.dib = paramFloat2;
    this.iky = paramb.azx().sIZ;
    this.ikz = paramb.azy().sHN;
    this.ikB = paramb.azx().sJa;
    int i;
    if (paramb.azx().sJa == null)
    {
      i = 60;
      this.ikE = i;
      if ((paramb.azx().sJa == null) || (bk.bl(paramb.azx().sJa.name))) {
        break label314;
      }
    }
    label314:
    for (boolean bool = true;; bool = false)
    {
      this.ikA = bool;
      y.i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", new Object[] { paramString, Boolean.valueOf(this.iky), Boolean.valueOf(this.ikz), Boolean.valueOf(this.ikA), Integer.valueOf(this.ikE) });
      if ((this.iky) && (!this.ikz)) {
        break label320;
      }
      if (this.ikA)
      {
        y.i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", new Object[] { this.ikB.name });
        this.ikD = new i.a(this, (byte)0);
        paramMMActivity = this.ikD;
        y.i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
        paramMMActivity.glu = new i.a.2(paramMMActivity);
        paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        ae.getContext().registerReceiver(paramMMActivity.glu, paramString);
      }
      start();
      wn();
      return;
      i = paramb.azx().sJa.sEq;
      break;
    }
    label320:
    if (bk.bl(this.ikk.azx().sJb)) {}
    for (paramMMActivity = this.ikk.azx().title;; paramMMActivity = this.ikk.azx().sJb)
    {
      h.a(this.ikv, this.ikv.getString(a.g.card_report_location_confirm, new Object[] { paramMMActivity }), this.ikv.getString(a.g.app_tip), new i.2(this), new i.3(this));
      break;
    }
  }
  
  public final boolean aAb()
  {
    return (this.iky) || (this.ikA);
  }
  
  public final void azY()
  {
    azZ();
    if (this.ikE > 0)
    {
      am localam = this.ikI;
      long l = this.ikE * 1000;
      localam.S(l, l);
      y.i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
      return;
    }
    y.e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
  }
  
  public final void azZ()
  {
    y.i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
    if (!this.ikI.crl()) {
      this.ikI.stopTimer();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.ikw = false;
  }
  
  public final void start()
  {
    if (!aAb()) {
      return;
    }
    y.i("MicroMsg.CardLbsOrBluetooth", "start");
    if (!this.dBn)
    {
      y.e("MicroMsg.CardLbsOrBluetooth", "isInit:%b", new Object[] { Boolean.valueOf(this.dBn) });
      return;
    }
    if (this.iky)
    {
      LocationManager localLocationManager = (LocationManager)ae.getContext().getSystemService("location");
      if (localLocationManager != null) {
        y.i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", new Object[] { Boolean.valueOf(localLocationManager.isProviderEnabled("gps")), Boolean.valueOf(localLocationManager.isProviderEnabled("network")) });
      }
    }
    if ((this.ikD != null) && (this.ikA)) {
      this.ikD.aAd();
    }
    azY();
    g.DO().dJT.a(2574, this);
  }
  
  public final void wn()
  {
    if (!aAb())
    {
      y.i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
      return;
    }
    if (this.ikw)
    {
      y.i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
      return;
    }
    this.ikw = true;
    if (this.ikA)
    {
      if (this.ikD != null) {
        break label258;
      }
      y.e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
    }
    boolean bool2;
    Object localObject;
    for (boolean bool1 = false;; bool1 = true)
    {
      bool2 = aAa();
      y.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", new Object[] { Boolean.valueOf(this.iky), Boolean.valueOf(this.ikz), Boolean.valueOf(this.ikD.ikL), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label298;
      }
      localObject = this.ikD.aAc();
      y.i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", new Object[] { localObject });
      y.d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.dib), Float.valueOf(this.dia) });
      a(this.ijW, ((b)localObject).ikR, this.dib, this.dia, ((b)localObject).bLz, this.ikD.ikL, this.ikz);
      this.ikG = System.currentTimeMillis();
      this.ikF = System.currentTimeMillis();
      this.ikD.reset();
      this.ikC = ((b)localObject);
      return;
      label258:
      if ((this.ikD.aAc().bwK.equals("")) || (System.currentTimeMillis() - this.ikF < this.ikH)) {
        break;
      }
    }
    label298:
    if (bool1)
    {
      localObject = this.ikD.aAc();
      y.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", new Object[] { localObject });
      a(this.ijW, ((b)localObject).ikR, -1000.0F, -85.0F, ((b)localObject).bLz, this.ikD.ikL, this.ikz);
      this.ikF = System.currentTimeMillis();
      this.ikD.reset();
      this.ikC = ((b)localObject);
      return;
    }
    if (bool2)
    {
      y.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
      y.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.dib), Float.valueOf(this.dia) });
      localObject = this.ijW;
      float f1 = this.dib;
      float f2 = this.dia;
      bool1 = this.ikz;
      a((String)localObject, new byte[0], f1, f2, 0, false, bool1);
      this.ikG = System.currentTimeMillis();
      return;
    }
    y.e("MicroMsg.CardLbsOrBluetooth", "not report");
    this.ikw = false;
  }
  
  private static final class b
  {
    int bLz;
    String bwK;
    byte[] ikR;
    String name;
    
    public b(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
    {
      this.bwK = paramString1;
      this.bLz = paramInt;
      this.name = paramString2;
      this.ikR = paramArrayOfByte;
    }
    
    public final String toString()
    {
      return "DeviceInfo{deviceId='" + this.bwK + '\'' + ", rssi=" + this.bLz + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.ikR) + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i
 * JD-Core Version:    0.7.0.1
 */