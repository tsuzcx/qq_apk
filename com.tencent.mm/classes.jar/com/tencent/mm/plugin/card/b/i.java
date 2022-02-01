package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.location.LocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.card.model.ai;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class i
  implements com.tencent.mm.al.g
{
  public volatile boolean csX;
  public Object dah;
  public volatile float fjD;
  public volatile float fjE;
  public MMActivity nqA;
  private volatile boolean nqB;
  private boolean nqC;
  boolean nqD;
  private boolean nqE;
  oc nqF;
  private i.b nqG;
  public i.a nqH;
  private int nqI;
  private long nqJ;
  private long nqK;
  private long nqL;
  public av nqM;
  String nqb;
  private com.tencent.mm.plugin.card.base.b nqp;
  
  public i()
  {
    AppMethodBeat.i(112657);
    this.csX = false;
    this.nqB = false;
    this.dah = new Object();
    this.nqC = false;
    this.nqD = false;
    this.fjD = -85.0F;
    this.fjE = -1000.0F;
    this.nqE = false;
    this.nqI = 60;
    this.nqJ = 0L;
    this.nqK = 0L;
    this.nqL = 10000L;
    this.nqM = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112645);
        i.this.report();
        i.this.bIB();
        AppMethodBeat.o(112645);
        return true;
      }
    }, false);
    AppMethodBeat.o(112657);
  }
  
  private void a(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112665);
    boolean bool = this.nqD;
    a(paramString, new byte[0], paramFloat1, paramFloat2, 0, false, bool);
    AppMethodBeat.o(112665);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112667);
    a(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean, this.nqD);
    AppMethodBeat.o(112667);
  }
  
  static void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112668);
    paramString = new ai(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    AppMethodBeat.o(112668);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112666);
    a(paramString, paramArrayOfByte, -1000.0F, -85.0F, paramInt, paramBoolean, this.nqD);
    AppMethodBeat.o(112666);
  }
  
  private static void aSo()
  {
    AppMethodBeat.i(112670);
    LocationManager localLocationManager = (LocationManager)aj.getContext().getSystemService("location");
    if (localLocationManager != null) {
      ad.i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", new Object[] { Boolean.valueOf(localLocationManager.isProviderEnabled("gps")), Boolean.valueOf(localLocationManager.isProviderEnabled("network")) });
    }
    AppMethodBeat.o(112670);
  }
  
  private boolean bID()
  {
    boolean bool = true;
    AppMethodBeat.i(112663);
    synchronized (this.dah)
    {
      int i;
      if (System.currentTimeMillis() - this.nqK >= this.nqL)
      {
        i = 1;
        if ((Float.compare(this.fjD, -85.0F) == 0) || (Float.compare(this.fjE, -1000.0F) == 0)) {
          break label97;
        }
      }
      label97:
      for (int j = 1;; j = 0)
      {
        if ((!this.nqD) || (!this.nqC) || (j == 0) || (i == 0)) {
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
  
  private boolean bIE()
  {
    AppMethodBeat.i(112664);
    if (!this.nqE)
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.nqH == null)
    {
      ad.e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.nqH.bIG().cLR.equals(""))
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (System.currentTimeMillis() - this.nqJ >= this.nqL)
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
    this.csX = true;
    this.nqA = paramMMActivity;
    this.nqb = paramString;
    this.nqp = paramb;
    this.fjD = paramFloat1;
    this.fjE = paramFloat2;
    this.nqC = paramb.bHV().CSn;
    this.nqD = paramb.bHW().CPK;
    this.nqF = paramb.bHV().CSo;
    int i;
    if (paramb.bHV().CSo == null)
    {
      i = 60;
      this.nqI = i;
      if ((paramb.bHV().CSo == null) || (bt.isNullOrNil(paramb.bHV().CSo.name))) {
        break label328;
      }
    }
    label328:
    for (boolean bool = true;; bool = false)
    {
      this.nqE = bool;
      ad.i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", new Object[] { paramString, Boolean.valueOf(this.nqC), Boolean.valueOf(this.nqD), Boolean.valueOf(this.nqE), Integer.valueOf(this.nqI) });
      if ((this.nqC) && (!this.nqD)) {
        break label334;
      }
      if (this.nqE)
      {
        ad.i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", new Object[] { this.nqF.name });
        this.nqH = new i.a(this, (byte)0);
        paramMMActivity = this.nqH;
        ad.i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
        paramMMActivity.jHB = new i.a.2(paramMMActivity);
        paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        aj.getContext().registerReceiver(paramMMActivity.jHB, paramString);
      }
      start();
      report();
      AppMethodBeat.o(112658);
      return;
      i = paramb.bHV().CSo.CLF;
      break;
    }
    label334:
    if (bt.isNullOrNil(this.nqp.bHV().CSp)) {}
    for (paramMMActivity = this.nqp.bHV().title;; paramMMActivity = this.nqp.bHV().CSp)
    {
      h.a(this.nqA, this.nqA.getString(2131756956, new Object[] { paramMMActivity }), this.nqA.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(112646);
          i.this.nqD = true;
          i.a(i.this.nqb, new byte[0], -85.0F, -1000.0F, 0, false, true);
          AppMethodBeat.o(112646);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          i.this.nqD = false;
        }
      });
      break;
    }
  }
  
  public final void bIB()
  {
    AppMethodBeat.i(112660);
    bIC();
    if (this.nqI > 0)
    {
      av localav = this.nqM;
      long l = this.nqI * 1000;
      localav.av(l, l);
      ad.i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
      AppMethodBeat.o(112660);
      return;
    }
    ad.e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
    AppMethodBeat.o(112660);
  }
  
  public final void bIC()
  {
    AppMethodBeat.i(112661);
    ad.i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
    if (!this.nqM.eFX()) {
      this.nqM.stopTimer();
    }
    AppMethodBeat.o(112661);
  }
  
  public final boolean bIF()
  {
    return (this.nqC) || (this.nqE);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112669);
    ad.i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nqB = false;
    AppMethodBeat.o(112669);
  }
  
  public final void report()
  {
    AppMethodBeat.i(112662);
    if (!bIF())
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
      AppMethodBeat.o(112662);
      return;
    }
    if (this.nqB)
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
      AppMethodBeat.o(112662);
      return;
    }
    this.nqB = true;
    boolean bool2 = bIE();
    boolean bool3 = bID();
    boolean bool4 = this.nqC;
    boolean bool5 = this.nqD;
    if (this.nqH == null) {}
    i.b localb;
    for (boolean bool1 = false;; bool1 = this.nqH.nqP)
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!bool2) || (!bool3)) {
        break;
      }
      localb = this.nqH.bIG();
      ad.i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", new Object[] { localb });
      ad.d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.fjE), Float.valueOf(this.fjD) });
      a(this.nqb, localb.nqV, this.fjE, this.fjD, localb.dhP, this.nqH.nqP);
      this.nqK = System.currentTimeMillis();
      this.nqJ = System.currentTimeMillis();
      this.nqH.reset();
      this.nqG = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool2)
    {
      localb = this.nqH.bIG();
      ad.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", new Object[] { localb });
      a(this.nqb, localb.nqV, localb.dhP, this.nqH.nqP);
      this.nqJ = System.currentTimeMillis();
      this.nqH.reset();
      this.nqG = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool3)
    {
      ad.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
      ad.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.fjE), Float.valueOf(this.fjD) });
      a(this.nqb, this.fjE, this.fjD);
      this.nqK = System.currentTimeMillis();
      AppMethodBeat.o(112662);
      return;
    }
    ad.e("MicroMsg.CardLbsOrBluetooth", "not report");
    this.nqB = false;
    AppMethodBeat.o(112662);
  }
  
  public final void start()
  {
    AppMethodBeat.i(112659);
    if (!bIF())
    {
      AppMethodBeat.o(112659);
      return;
    }
    ad.i("MicroMsg.CardLbsOrBluetooth", "start");
    if (!this.csX)
    {
      ad.e("MicroMsg.CardLbsOrBluetooth", "isInit:%b", new Object[] { Boolean.valueOf(this.csX) });
      AppMethodBeat.o(112659);
      return;
    }
    if (this.nqC) {
      aSo();
    }
    if ((this.nqH != null) && (this.nqE)) {
      this.nqH.bIH();
    }
    bIB();
    com.tencent.mm.kernel.g.afA().gcy.a(2574, this);
    AppMethodBeat.o(112659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.i
 * JD-Core Version:    0.7.0.1
 */