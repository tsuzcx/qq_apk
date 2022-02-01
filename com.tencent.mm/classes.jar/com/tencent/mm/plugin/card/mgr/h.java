package com.tencent.mm.plugin.card.mgr;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.ai;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

public final class h
  implements com.tencent.mm.am.h
{
  public volatile boolean isInit;
  private volatile float lsA;
  private volatile float lsz;
  public MMActivity wrG;
  private volatile boolean wrH;
  private Object wrI;
  private boolean wrJ;
  private boolean wrK;
  private boolean wrL;
  private ru wrM;
  private h.b wrN;
  public h.a wrO;
  private int wrP;
  private long wrQ;
  private long wrR;
  private long wrS;
  public MTimerHandler wrT;
  private String wrg;
  private b wru;
  
  public h()
  {
    AppMethodBeat.i(112657);
    this.isInit = false;
    this.wrH = false;
    this.wrI = new Object();
    this.wrJ = false;
    this.wrK = false;
    this.lsz = -85.0F;
    this.lsA = -1000.0F;
    this.wrL = false;
    this.wrP = 60;
    this.wrQ = 0L;
    this.wrR = 0L;
    this.wrS = 10000L;
    this.wrT = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112645);
        h.this.report();
        h.this.dkp();
        AppMethodBeat.o(112645);
        return true;
      }
    }, false);
    AppMethodBeat.o(112657);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112667);
    a(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean, this.wrK);
    AppMethodBeat.o(112667);
  }
  
  private static void a(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112668);
    paramString = new ai(paramString, paramArrayOfByte, paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    AppMethodBeat.o(112668);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112666);
    a(paramString, paramArrayOfByte, -1000.0F, -85.0F, paramInt, paramBoolean, this.wrK);
    AppMethodBeat.o(112666);
  }
  
  private void b(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(112665);
    boolean bool = this.wrK;
    a(paramString, new byte[0], paramFloat1, paramFloat2, 0, false, bool);
    AppMethodBeat.o(112665);
  }
  
  private static void cjw()
  {
    AppMethodBeat.i(112670);
    Log.i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", new Object[] { Boolean.valueOf(d.bJm()), Boolean.valueOf(d.bJn()) });
    AppMethodBeat.o(112670);
  }
  
  private boolean dkr()
  {
    boolean bool = true;
    AppMethodBeat.i(112663);
    synchronized (this.wrI)
    {
      int i;
      if (System.currentTimeMillis() - this.wrR >= this.wrS)
      {
        i = 1;
        if ((Float.compare(this.lsz, -85.0F) == 0) || (Float.compare(this.lsA, -1000.0F) == 0)) {
          break label97;
        }
      }
      label97:
      for (int j = 1;; j = 0)
      {
        if ((!this.wrK) || (!this.wrJ) || (j == 0) || (i == 0)) {
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
  
  private boolean dks()
  {
    AppMethodBeat.i(112664);
    if (!this.wrL)
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.wrO == null)
    {
      Log.e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
      AppMethodBeat.o(112664);
      return false;
    }
    if (this.wrO.dku().hEl.equals(""))
    {
      AppMethodBeat.o(112664);
      return false;
    }
    if (System.currentTimeMillis() - this.wrQ >= this.wrS)
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
    this.wrG = paramMMActivity;
    this.wrg = paramString;
    this.wru = paramb;
    this.lsz = paramFloat1;
    this.lsA = paramFloat2;
    this.wrJ = paramb.djK().Zes;
    this.wrK = paramb.djL().ZbO;
    this.wrM = paramb.djK().Zet;
    int i;
    if (paramb.djK().Zet == null)
    {
      i = 60;
      this.wrP = i;
      if ((paramb.djK().Zet == null) || (Util.isNullOrNil(paramb.djK().Zet.name))) {
        break label327;
      }
    }
    label327:
    for (boolean bool = true;; bool = false)
    {
      this.wrL = bool;
      Log.i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", new Object[] { paramString, Boolean.valueOf(this.wrJ), Boolean.valueOf(this.wrK), Boolean.valueOf(this.wrL), Integer.valueOf(this.wrP) });
      if ((this.wrJ) && (!this.wrK)) {
        break label333;
      }
      if (this.wrL)
      {
        Log.i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", new Object[] { this.wrM.name });
        this.wrO = new h.a(this, (byte)0);
        paramMMActivity = this.wrO;
        Log.i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
        paramMMActivity.rJV = new h.a.2(paramMMActivity);
        paramString = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        MMApplicationContext.getContext().registerReceiver(paramMMActivity.rJV, paramString);
      }
      start();
      report();
      AppMethodBeat.o(112658);
      return;
      i = paramb.djK().Zet.YWF;
      break;
    }
    label333:
    if (Util.isNullOrNil(this.wru.djK().YTl)) {}
    for (paramMMActivity = this.wru.djK().title;; paramMMActivity = this.wru.djK().YTl)
    {
      k.a(this.wrG, this.wrG.getString(a.g.wpL, new Object[] { paramMMActivity }), this.wrG.getString(a.g.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(112646);
          h.a(h.this, true);
          h.r(h.a(h.this), new byte[0]);
          AppMethodBeat.o(112646);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(293761);
          h.a(h.this, false);
          AppMethodBeat.o(293761);
        }
      });
      break;
    }
  }
  
  public final void aA(float paramFloat1, float paramFloat2)
  {
    synchronized (this.wrI)
    {
      this.lsz = paramFloat2;
      this.lsA = paramFloat1;
      return;
    }
  }
  
  public final void dkp()
  {
    AppMethodBeat.i(112660);
    dkq();
    if (this.wrP > 0)
    {
      this.wrT.startTimer(this.wrP * 1000);
      Log.i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
      AppMethodBeat.o(112660);
      return;
    }
    Log.e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
    AppMethodBeat.o(112660);
  }
  
  public final void dkq()
  {
    AppMethodBeat.i(112661);
    Log.i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
    if (!this.wrT.stopped()) {
      this.wrT.stopTimer();
    }
    AppMethodBeat.o(112661);
  }
  
  public final boolean dkt()
  {
    return (this.wrJ) || (this.wrL);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(112669);
    Log.i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wrH = false;
    AppMethodBeat.o(112669);
  }
  
  public final void report()
  {
    AppMethodBeat.i(112662);
    if (!dkt())
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
      AppMethodBeat.o(112662);
      return;
    }
    if (this.wrH)
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
      AppMethodBeat.o(112662);
      return;
    }
    this.wrH = true;
    boolean bool2 = dks();
    boolean bool3 = dkr();
    boolean bool4 = this.wrJ;
    boolean bool5 = this.wrK;
    if (this.wrO == null) {}
    h.b localb;
    for (boolean bool1 = false;; bool1 = this.wrO.wrW)
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!bool2) || (!bool3)) {
        break;
      }
      localb = this.wrO.dku();
      Log.i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", new Object[] { localb });
      Log.d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.lsA), Float.valueOf(this.lsz) });
      a(this.wrg, localb.wsc, this.lsA, this.lsz, localb.rssi, this.wrO.wrW);
      this.wrR = System.currentTimeMillis();
      this.wrQ = System.currentTimeMillis();
      this.wrO.reset();
      this.wrN = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool2)
    {
      localb = this.wrO.dku();
      Log.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", new Object[] { localb });
      a(this.wrg, localb.wsc, localb.rssi, this.wrO.wrW);
      this.wrQ = System.currentTimeMillis();
      this.wrO.reset();
      this.wrN = localb;
      AppMethodBeat.o(112662);
      return;
    }
    if (bool3)
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
      Log.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", new Object[] { Float.valueOf(this.lsA), Float.valueOf(this.lsz) });
      b(this.wrg, this.lsA, this.lsz);
      this.wrR = System.currentTimeMillis();
      AppMethodBeat.o(112662);
      return;
    }
    Log.e("MicroMsg.CardLbsOrBluetooth", "not report");
    this.wrH = false;
    AppMethodBeat.o(112662);
  }
  
  public final void start()
  {
    AppMethodBeat.i(112659);
    if (!dkt())
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
    if (this.wrJ) {
      cjw();
    }
    if ((this.wrO != null) && (this.wrL)) {
      this.wrO.dkv();
    }
    dkp();
    com.tencent.mm.kernel.h.baD().mCm.a(2574, this);
    AppMethodBeat.o(112659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.h
 * JD-Core Version:    0.7.0.1
 */