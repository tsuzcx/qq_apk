package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.IntentFilter;
import android.location.LocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.ai;
import com.tencent.mm.protocal.protobuf.mb;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Arrays;

public final class i
  implements f
{
  public volatile boolean bRB;
  public Object clk;
  public volatile float dZu;
  public volatile float dZv;
  String kkW;
  private b klA;
  public i.a klB;
  private int klC;
  private long klD;
  private long klE;
  private long klF;
  public ap klG;
  private com.tencent.mm.plugin.card.base.b klk;
  public MMActivity klu;
  private volatile boolean klv;
  private boolean klw;
  boolean klx;
  private boolean kly;
  mb klz;
  
  public i()
  {
    AppMethodBeat.i(87713);
    this.bRB = false;
    this.klv = false;
    this.clk = new Object();
    this.klw = false;
    this.klx = false;
    this.dZu = -85.0F;
    this.dZv = -1000.0F;
    this.kly = false;
    this.klC = 60;
    this.klD = 0L;
    this.klE = 0L;
    this.klF = 10000L;
    this.klG = new ap(new i.1(this), false);
    AppMethodBeat.o(87713);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(87723);
    a(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean, this.klx);
    AppMethodBeat.o(87723);
  }
  
  static void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(87724);
    paramString = new ai(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    g.RK().eHt.a(paramString, 0);
    AppMethodBeat.o(87724);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(87722);
    a(paramString, paramArrayOfByte, -1000.0F, -85.0F, paramInt, paramBoolean, this.klx);
    AppMethodBeat.o(87722);
  }
  
  private static void axL()
  {
    AppMethodBeat.i(87726);
    LocationManager localLocationManager = (LocationManager)ah.getContext().getSystemService("location");
    if (localLocationManager != null) {
      ab.i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", new Object[] { Boolean.valueOf(localLocationManager.isProviderEnabled("gps")), Boolean.valueOf(localLocationManager.isProviderEnabled("network")) });
    }
    AppMethodBeat.o(87726);
  }
  
  private void b(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(87721);
    boolean bool = this.klx;
    a(paramString, new byte[0], paramFloat1, paramFloat2, 0, false, bool);
    AppMethodBeat.o(87721);
  }
  
  private boolean bbL()
  {
    boolean bool = true;
    AppMethodBeat.i(87719);
    synchronized (this.clk)
    {
      int i;
      if (System.currentTimeMillis() - this.klE >= this.klF)
      {
        i = 1;
        if ((Float.compare(this.dZu, -85.0F) == 0) || (Float.compare(this.dZv, -1000.0F) == 0)) {
          break label97;
        }
      }
      label97:
      for (int j = 1;; j = 0)
      {
        if ((!this.klx) || (!this.klw) || (j == 0) || (i == 0)) {
          break label102;
        }
        AppMethodBeat.o(87719);
        return bool;
        i = 0;
        break;
      }
      label102:
      bool = false;
    }
  }
  
  private boolean bbM()
  {
    AppMethodBeat.i(87720);
    if (!this.kly)
    {
      AppMethodBeat.o(87720);
      return false;
    }
    if (this.klB == null)
    {
      ab.e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
      AppMethodBeat.o(87720);
      return false;
    }
    if (this.klB.bbO().bYu.equals(""))
    {
      AppMethodBeat.o(87720);
      return false;
    }
    if (System.currentTimeMillis() - this.klD >= this.klF)
    {
      AppMethodBeat.o(87720);
      return true;
    }
    AppMethodBeat.o(87720);
    return false;
  }
  
  public final void IE()
  {
    AppMethodBeat.i(87718);
    if (!bbN())
    {
      ab.i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
      AppMethodBeat.o(87718);
      return;
    }
    if (this.klv)
    {
      ab.i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
      AppMethodBeat.o(87718);
      return;
    }
    this.klv = true;
    boolean bool2 = bbM();
    boolean bool3 = bbL();
    boolean bool4 = this.klw;
    boolean bool5 = this.klx;
    if (this.klB == null) {}
    b localb;
    for (boolean bool1 = false;; bool1 = this.klB.klJ)
    {
      ab.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!bool2) || (!bool3)) {
        break;
      }
      localb = this.klB.bbO();
      ab.i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", new Object[] { localb });
      ab.d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.dZv), Float.valueOf(this.dZu) });
      a(this.kkW, localb.klP, this.dZv, this.dZu, localb.csT, this.klB.klJ);
      this.klE = System.currentTimeMillis();
      this.klD = System.currentTimeMillis();
      this.klB.reset();
      this.klA = localb;
      AppMethodBeat.o(87718);
      return;
    }
    if (bool2)
    {
      localb = this.klB.bbO();
      ab.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", new Object[] { localb });
      a(this.kkW, localb.klP, localb.csT, this.klB.klJ);
      this.klD = System.currentTimeMillis();
      this.klB.reset();
      this.klA = localb;
      AppMethodBeat.o(87718);
      return;
    }
    if (bool3)
    {
      ab.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
      ab.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.dZv), Float.valueOf(this.dZu) });
      b(this.kkW, this.dZv, this.dZu);
      this.klE = System.currentTimeMillis();
      AppMethodBeat.o(87718);
      return;
    }
    ab.e("MicroMsg.CardLbsOrBluetooth", "not report");
    this.klv = false;
    AppMethodBeat.o(87718);
  }
  
  public final void a(MMActivity paramMMActivity, String paramString, com.tencent.mm.plugin.card.base.b paramb, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(87714);
    this.bRB = true;
    this.klu = paramMMActivity;
    this.kkW = paramString;
    this.klk = paramb;
    this.dZu = paramFloat1;
    this.dZv = paramFloat2;
    this.klw = paramb.bbd().wGI;
    this.klx = paramb.bbe().wEj;
    this.klz = paramb.bbd().wGJ;
    int i;
    if (paramb.bbd().wGJ == null)
    {
      i = 60;
      this.klC = i;
      if ((paramb.bbd().wGJ == null) || (bo.isNullOrNil(paramb.bbd().wGJ.name))) {
        break label330;
      }
    }
    label330:
    for (boolean bool = true;; bool = false)
    {
      this.kly = bool;
      ab.i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", new Object[] { paramString, Boolean.valueOf(this.klw), Boolean.valueOf(this.klx), Boolean.valueOf(this.kly), Integer.valueOf(this.klC) });
      if ((this.klw) && (!this.klx)) {
        break label336;
      }
      if (this.kly)
      {
        ab.i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", new Object[] { this.klz.name });
        this.klB = new i.a(this, (byte)0);
        paramMMActivity = this.klB;
        ab.i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
        paramMMActivity.hFt = new i.a.2(paramMMActivity);
        paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        ah.getContext().registerReceiver(paramMMActivity.hFt, paramString);
      }
      start();
      IE();
      AppMethodBeat.o(87714);
      return;
      i = paramb.bbd().wGJ.wAw;
      break;
    }
    label336:
    if (bo.isNullOrNil(this.klk.bbd().wGK)) {}
    for (paramMMActivity = this.klk.bbd().title;; paramMMActivity = this.klk.bbd().wGK)
    {
      h.a(this.klu, this.klu.getString(2131298014, new Object[] { paramMMActivity }), this.klu.getString(2131297087), new i.2(this), new i.3(this));
      break;
    }
  }
  
  public final void bbJ()
  {
    AppMethodBeat.i(87716);
    bbK();
    if (this.klC > 0)
    {
      ap localap = this.klG;
      long l = this.klC * 1000;
      localap.ag(l, l);
      ab.i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
      AppMethodBeat.o(87716);
      return;
    }
    ab.e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
    AppMethodBeat.o(87716);
  }
  
  public final void bbK()
  {
    AppMethodBeat.i(87717);
    ab.i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
    if (!this.klG.dtj()) {
      this.klG.stopTimer();
    }
    AppMethodBeat.o(87717);
  }
  
  public final boolean bbN()
  {
    return (this.klw) || (this.kly);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(87725);
    ab.i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.klv = false;
    AppMethodBeat.o(87725);
  }
  
  public final void start()
  {
    AppMethodBeat.i(87715);
    if (!bbN())
    {
      AppMethodBeat.o(87715);
      return;
    }
    ab.i("MicroMsg.CardLbsOrBluetooth", "start");
    if (!this.bRB)
    {
      ab.e("MicroMsg.CardLbsOrBluetooth", "isInit:%b", new Object[] { Boolean.valueOf(this.bRB) });
      AppMethodBeat.o(87715);
      return;
    }
    if (this.klw) {
      axL();
    }
    if ((this.klB != null) && (this.kly)) {
      this.klB.bbP();
    }
    bbJ();
    g.RK().eHt.a(2574, this);
    AppMethodBeat.o(87715);
  }
  
  static final class b
  {
    String bYu;
    int csT;
    byte[] klP;
    String name;
    
    public b(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
    {
      this.bYu = paramString1;
      this.csT = paramInt;
      this.name = paramString2;
      this.klP = paramArrayOfByte;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(87712);
      String str = "SrvDeviceInfo{deviceId='" + this.bYu + '\'' + ", rssi=" + this.csT + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.klP) + '}';
      AppMethodBeat.o(87712);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i
 * JD-Core Version:    0.7.0.1
 */