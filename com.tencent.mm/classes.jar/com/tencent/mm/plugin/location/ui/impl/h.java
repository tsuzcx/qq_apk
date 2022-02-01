package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.a.ww.a;
import com.tencent.mm.model.u;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.q.a;
import com.tencent.mm.plugin.location.model.q.b;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.ShareHeader;
import com.tencent.mm.plugin.location.ui.TipSayingWidget;
import com.tencent.mm.plugin.location.ui.VolumeMeter;
import com.tencent.mm.plugin.location.ui.g.a;
import com.tencent.mm.plugin.location.ui.i;
import com.tencent.mm.plugin.location.ui.j;
import com.tencent.mm.plugin.location.ui.j.5;
import com.tencent.mm.plugin.location.ui.j.a;
import com.tencent.mm.plugin.location.ui.k.a;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.div;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class h
  extends k
  implements j.a
{
  private b.a fjJ;
  private com.tencent.mm.sdk.b.c nZA;
  private View sRX;
  private k.a sTt;
  com.tencent.mm.plugin.location.ui.k sWA;
  com.tencent.mm.plugin.location.model.q sWB;
  j sWC;
  i sWD;
  private com.tencent.mm.plugin.location.ui.g sWE;
  private com.tencent.mm.modelgeo.d sWF;
  private ShareHeader sWG;
  private String sWH;
  private long sWI;
  private long sWJ;
  private q.b sWK;
  private q.a sWL;
  private HashMap<String, div> sWM;
  private Button sWx;
  MyLocationButton sWy;
  private TipSayingWidget sWz;
  private PowerManager.WakeLock wakeLock;
  
  public h(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56125);
    this.sWI = 0L;
    this.sWJ = 0L;
    this.sTt = new k.a() {};
    this.sWK = new q.b()
    {
      public final void a(cii paramAnonymouscii)
      {
        AppMethodBeat.i(56114);
        h.a(h.this, paramAnonymouscii);
        AppMethodBeat.o(56114);
      }
      
      public final void cJB()
      {
        AppMethodBeat.i(56113);
        ad.i("MicroMsg.ShareMapUI", "onJoinSucess");
        com.tencent.mm.plugin.location.model.q localq = h.this.sWB;
        localq.sPM = true;
        localq.cJy();
        localq.cJz();
        h.this.sWA.mK(true);
        if (h.this.sWD != null) {
          h.this.sWD.cJS();
        }
        AppMethodBeat.o(56113);
      }
      
      public final void cJC()
      {
        AppMethodBeat.i(56116);
        h.this.sWA.mK(false);
        h.this.sWB.stop();
        h.this.sWB.FF(3);
        i.cJU();
        h.this.activity.finish();
        h.this.activity.overridePendingTransition(2130772107, 2130772109);
        AppMethodBeat.o(56116);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(56115);
        ad.v("MicroMsg.ShareMapUI", "onError type %d msg %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.vKh.f(10997, new Object[] { "7", "", Integer.valueOf(0), Integer.valueOf(0) });
        j localj = h.this.sWC;
        ad.d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", new Object[] { paramAnonymousString });
        Context localContext = aj.getContext();
        Object localObject = null;
        if (bt.isNullOrNil(paramAnonymousString)) {
          if (paramAnonymousInt == 0) {
            paramAnonymousString = localContext.getString(2131760719);
          }
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.a(localj.mContext, paramAnonymousString, "", localj.mResources.getString(2131755835), false, new j.5(localj, paramAnonymousInt));
          AppMethodBeat.o(56115);
          return;
          if (paramAnonymousInt == 1)
          {
            paramAnonymousString = localContext.getString(2131760724);
          }
          else
          {
            paramAnonymousString = localObject;
            if (paramAnonymousInt == 2) {
              paramAnonymousString = localContext.getString(2131760725);
            }
          }
        }
      }
    };
    this.sWL = new h.4(this);
    this.fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(56118);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(56118);
          return false;
        }
        ad.d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble1) });
        if ((f.w(paramAnonymousDouble1)) && (!h.this.sWA.sTj))
        {
          ad.d("MicroMsg.ShareMapUI", "set driving mode");
          h.this.sWA.sTm = false;
          h.this.sWA.mJ(true);
          h.this.sWy.cJF();
        }
        AppMethodBeat.o(56118);
        return true;
      }
    };
    this.nZA = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(ww paramAnonymousww)
      {
        AppMethodBeat.i(56119);
        if (!com.tencent.mm.kernel.g.afw())
        {
          AppMethodBeat.o(56119);
          return false;
        }
        if (paramAnonymousww.dCp.djq == 3)
        {
          h.this.sWA.mK(false);
          h.this.sWB.stop();
          h.this.sWB.FF(2);
          i.cJU();
          h.this.activity.finish();
        }
        AppMethodBeat.o(56119);
        return true;
      }
    };
    this.sWM = new HashMap();
    this.sWB = com.tencent.mm.plugin.location.model.n.cJq();
    this.sWF = com.tencent.mm.modelgeo.d.axT();
    AppMethodBeat.o(56125);
  }
  
  private void cKw()
  {
    AppMethodBeat.i(56133);
    hideVKB();
    this.sWA.mK(false);
    this.sWB.stop();
    this.sWB.FF(3);
    i.cJU();
    this.sWB.sPS = this.sUc.sQT.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56133);
  }
  
  public final void FG(int paramInt)
  {
    AppMethodBeat.i(56135);
    if (paramInt == 0)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      cKw();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      cKw();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 2) {
      cKw();
    }
    AppMethodBeat.o(56135);
  }
  
  public final void cJW()
  {
    AppMethodBeat.i(56132);
    this.sWB.sPS = this.sUc.sQT.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56132);
  }
  
  public final void cJX()
  {
    AppMethodBeat.i(56134);
    this.sWA.mK(false);
    this.sWB.stop();
    this.sWB.FF(0);
    i.cJU();
    this.activity.finish();
    AppMethodBeat.o(56134);
  }
  
  protected final void cKe()
  {
    AppMethodBeat.i(56131);
    super.cKe();
    AppMethodBeat.o(56131);
  }
  
  final void cKf()
  {
    AppMethodBeat.i(56127);
    super.cKf();
    this.wakeLock = ((PowerManager)this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
    if (this.sXu != null)
    {
      localObject1 = this.sXu;
      ((l)localObject1).sTR.setVisibility(4);
      ((l)localObject1).isVisible = false;
    }
    findViewById(2131300707).setVisibility(8);
    this.sWy = ((MyLocationButton)findViewById(2131301520));
    this.sWy.setProgressBar(this.sUc.sQT);
    this.sWy.cJE();
    this.sWy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56121);
        h.this.sWy.cJE();
        h.this.sWA.sTm = true;
        h.this.sWA.a(h.this.sUc.sQT);
        h.this.sWA.mJ(false);
        com.tencent.mm.plugin.report.service.h.vKh.f(10997, new Object[] { "6", "", Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(56121);
      }
    });
    this.sRX = findViewById(2131300706);
    this.sWG = ((ShareHeader)findViewById(2131304743));
    this.sWG.setVisibility(0);
    this.sWE = new com.tencent.mm.plugin.location.ui.g(this.activity, this.sWG.getHeaderBar(), this.sRX, this.sPP, this.sUc.sQT);
    this.sWE.sSe = new g.a()
    {
      public final void afb(String paramAnonymousString)
      {
        AppMethodBeat.i(56122);
        Object localObject = (TrackPoint)h.this.sUc.sQT.getViewByItag(paramAnonymousString);
        if (localObject != null)
        {
          ((TrackPoint)localObject).set2Top();
          h.this.sUc.sQT.invalidate();
          localObject = h.this.sWA;
          if (bt.isNullOrNil(paramAnonymousString)) {
            break label234;
          }
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).sPK == null) || (!paramAnonymousString.equals(((com.tencent.mm.plugin.location.ui.k)localObject).sPK.Username))) {
            break label150;
          }
          paramAnonymousString = new com.tencent.mm.plugin.location.model.d(((com.tencent.mm.plugin.location.ui.k)localObject).sPK.Eze.CJD, ((com.tencent.mm.plugin.location.ui.k)localObject).sPK.Eze.CJE);
        }
        for (;;)
        {
          if (paramAnonymousString != null) {
            h.this.sUc.sQT.getIController().animateTo(paramAnonymousString.sOv, paramAnonymousString.sOw);
          }
          AppMethodBeat.o(56122);
          return;
          label150:
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).sTb != null) && (((com.tencent.mm.plugin.location.ui.k)localObject).sTb.size() > 0))
          {
            localObject = ((com.tencent.mm.plugin.location.ui.k)localObject).sTb.iterator();
            for (;;)
            {
              if (((Iterator)localObject).hasNext())
              {
                div localdiv = (div)((Iterator)localObject).next();
                if (localdiv.Username.equals(paramAnonymousString))
                {
                  paramAnonymousString = new com.tencent.mm.plugin.location.model.d(localdiv.Eze.CJD, localdiv.Eze.CJE);
                  break;
                }
              }
            }
          }
          label234:
          paramAnonymousString = null;
        }
      }
    };
    this.sWB.sPR = this.sWL;
    if (this.sWA == null) {
      this.sWA = new com.tencent.mm.plugin.location.ui.k(this.activity, this.sUc.sQT, true);
    }
    this.sWA.sTt = this.sTt;
    this.sWA.sTh = false;
    this.sWC = new j(this.activity, this);
    this.sWz = ((TipSayingWidget)findViewById(2131304298));
    this.sWx = ((Button)findViewById(2131304751));
    this.sWx.setVisibility(0);
    this.sWD = new i(this.activity, this.sWx);
    this.sWD.sSQ = this.sWE;
    this.sWG.setOnLeftClickListener(new h.9(this));
    this.sWG.setOnRightClickListener(new h.10(this));
    ((LocationManager)this.activity.getSystemService("location")).isProviderEnabled("gps");
    Object localObject1 = this.sWB;
    Object localObject2 = this.sUa;
    ((com.tencent.mm.plugin.location.model.q)localObject1).sPU = System.currentTimeMillis();
    ((com.tencent.mm.plugin.location.model.q)localObject1).gXu = com.tencent.mm.modelgeo.d.axT();
    ((com.tencent.mm.plugin.location.model.q)localObject1).gXu.b(((com.tencent.mm.plugin.location.model.q)localObject1).fjJ, true);
    if (((com.tencent.mm.plugin.location.model.q)localObject1).sPH == null) {
      ((com.tencent.mm.plugin.location.model.q)localObject1).sPH = com.tencent.mm.plugin.location.model.n.cJs();
    }
    ((com.tencent.mm.plugin.location.model.q)localObject1).sPH.a(((com.tencent.mm.plugin.location.model.q)localObject1).sPW);
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.location.model.q)localObject1).sPL = ((LocationInfo)localObject2);
    }
    if (((com.tencent.mm.plugin.location.model.q)localObject1).isStart)
    {
      ad.i("MicorMsg.TrackRefreshManager", "start location " + ((com.tencent.mm.plugin.location.model.q)localObject1).sPL.sOv + " " + ((com.tencent.mm.plugin.location.model.q)localObject1).sPL.sOw);
      localObject1 = this.sWB;
      localObject2 = this.sWK;
      Iterator localIterator = ((com.tencent.mm.plugin.location.model.q)localObject1).sPI.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((localWeakReference == null) || (localWeakReference.get() == null) || (!((q.b)localWeakReference.get()).equals(localObject2)));
    }
    for (;;)
    {
      this.sWH = this.activity.getIntent().getStringExtra("fromWhereShare");
      ad.d("MicroMsg.ShareMapUI", "fromWhere=%s", new Object[] { this.sWH });
      if (!this.sWB.cJu()) {
        break label829;
      }
      ad.i("MicroMsg.ShareMapUI", "has join");
      this.sWA.mK(true);
      this.sWD.cJS();
      AppMethodBeat.o(56127);
      return;
      ((com.tencent.mm.plugin.location.model.q)localObject1).sPJ = 1;
      ((com.tencent.mm.plugin.location.model.q)localObject1).sPK = new div();
      ((com.tencent.mm.plugin.location.model.q)localObject1).sPK.Eze = new cbf();
      ((com.tencent.mm.plugin.location.model.q)localObject1).sPK.Eze.CJE = -1000.0D;
      ((com.tencent.mm.plugin.location.model.q)localObject1).sPK.Eze.CJD = -1000.0D;
      ad.i("MicorMsg.TrackRefreshManager", "start location imp " + ((com.tencent.mm.plugin.location.model.q)localObject1).sPL.sOv + " " + ((com.tencent.mm.plugin.location.model.q)localObject1).sPL.sOw);
      com.tencent.mm.kernel.g.aeS().a(492, (com.tencent.mm.al.g)localObject1);
      com.tencent.mm.kernel.g.aeS().a(490, (com.tencent.mm.al.g)localObject1);
      com.tencent.mm.kernel.g.aeS().a(491, (com.tencent.mm.al.g)localObject1);
      ((com.tencent.mm.plugin.location.model.q)localObject1).cOA = false;
      ((com.tencent.mm.plugin.location.model.q)localObject1).isStart = true;
      break;
      ((com.tencent.mm.plugin.location.model.q)localObject1).sPI.add(new WeakReference(localObject2));
    }
    label829:
    localObject2 = this.sWB;
    localObject1 = this.sPP;
    int i;
    if (!bt.isNullOrNil(this.sWH)) {
      if (this.sWH.equals("fromBanner"))
      {
        i = 0;
        ad.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[] { localObject1 });
        ((com.tencent.mm.plugin.location.model.q)localObject2).sPP = ((String)localObject1);
        localObject2 = u.aqG();
        if (!((String)localObject1).contains("@chatroom")) {
          break label1014;
        }
      }
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.location.model.a.b((String)localObject1);
      ((bjm)((com.tencent.mm.plugin.location.model.a.b)localObject1).rr.gUS.gUX).Scene = i;
      com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject1, 0);
      AppMethodBeat.o(56127);
      return;
      if (!this.sWH.equals("fromPluginLocation"))
      {
        if (this.sWH.equals("fromPluginTalk"))
        {
          i = 2;
          break;
        }
        if (this.sWH.equals("fromTrackButton"))
        {
          i = 3;
          break;
        }
        if (this.sWH.equals("fromMessage"))
        {
          i = 4;
          break;
        }
      }
      i = 1;
      break;
      label1014:
      if (((String)localObject2).compareTo((String)localObject1) > 0) {
        localObject1 = (String)localObject1 + (String)localObject2;
      } else {
        localObject1 = (String)localObject2 + (String)localObject1;
      }
    }
  }
  
  public final boolean cKg()
  {
    return true;
  }
  
  public final void cKx()
  {
    AppMethodBeat.i(56138);
    super.cKx();
    if (this.sWA != null)
    {
      this.sWA.sTm = false;
      this.sWA.mJ(false);
      this.sWy.cJF();
    }
    AppMethodBeat.o(56138);
  }
  
  protected final void cKy()
  {
    AppMethodBeat.i(56139);
    super.cKy();
    com.tencent.mm.plugin.report.service.h.vKh.f(10997, new Object[] { "1", "", Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(56139);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(56137);
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(56137);
    return bool;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(56136);
    com.tencent.mm.plugin.report.service.h.vKh.f(10997, new Object[] { "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.sWC.cJV();
    AppMethodBeat.o(56136);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56126);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.ShareMapUI", "onCreate");
    this.sWI = System.currentTimeMillis();
    a.ESL.c(this.nZA);
    AppMethodBeat.o(56126);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56130);
    super.onDestroy();
    Object localObject = this.sWB;
    q.b localb = this.sWK;
    Iterator localIterator = ((com.tencent.mm.plugin.location.model.q)localObject).sPI.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((q.b)localWeakReference.get()).equals(localb))) {
        ((com.tencent.mm.plugin.location.model.q)localObject).sPI.remove(localWeakReference);
      }
    }
    a.ESL.d(this.nZA);
    this.sWB.sPR = null;
    if (this.sWD != null)
    {
      localObject = this.sWD;
      ((i)localObject).sSP.b((com.tencent.mm.bi.d)localObject);
      localObject = ((i)localObject).sSC;
      ((VolumeMeter)localObject).sTz.removeCallbacks((Runnable)localObject);
      ((VolumeMeter)localObject).sTz.post(((VolumeMeter)localObject).sTN);
    }
    if (this.sWA != null) {
      this.sWA.destroy();
    }
    if (this.sWy != null)
    {
      localObject = this.sWy;
      com.tencent.mm.modelgeo.d.axT().c(((MyLocationButton)localObject).fjJ);
    }
    ad.i("MicroMsg.ShareMapUI", "onDestory");
    AppMethodBeat.o(56130);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56129);
    ad.i("MicroMsg.ShareMapUI", "pause");
    super.onPause();
    this.wakeLock.release();
    com.tencent.mm.plugin.location.model.q localq = this.sWB;
    ad.d("MicorMsg.TrackRefreshManager", "pause isShared:" + localq.sPM);
    if (!localq.sPM)
    {
      localq.gXu.c(localq.fjJ);
      localq.sPH.b(localq.sPW);
      localq.sPN = true;
      localq.sPT = true;
    }
    localq = this.sWB;
    com.tencent.mm.plugin.k.d locald = this.sUc.sQT;
    localq.sPO = localq.sPJ;
    localq.sPJ = 0;
    ad.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + localq.sPO);
    if (localq.cJA())
    {
      localq.sOv = (locald.getMapCenterX() * 1.0D / 1000000.0D);
      localq.sOw = (locald.getMapCenterY() * 1.0D / 1000000.0D);
      localq.sOx = locald.getZoom();
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(10997, new Object[] { "17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.sWI) });
    this.sWI = System.currentTimeMillis();
    if (this.sWF != null) {
      this.sWF.c(this.fjJ);
    }
    if (this.sWA != null) {
      this.sWA.onPause();
    }
    AppMethodBeat.o(56129);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56128);
    ad.i("MicroMsg.ShareMapUI", "resume");
    super.onResume();
    this.wakeLock.acquire();
    com.tencent.mm.plugin.location.model.q localq = this.sWB;
    ad.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + localq.sPN);
    if (localq.sPN)
    {
      localq.sPU = System.currentTimeMillis();
      localq.gXu.a(localq.fjJ);
      localq.sPH.a(localq.sPW);
    }
    localq.sPN = false;
    localq.cJw();
    localq = this.sWB;
    com.tencent.mm.plugin.k.d locald = this.sUc.sQT;
    localq.sPJ = localq.sPO;
    ad.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + localq.sPJ + " %f %f %d ", new Object[] { Double.valueOf(localq.sOv), Double.valueOf(localq.sOw), Integer.valueOf(localq.sOx) });
    if ((localq.sOv != -1000.0D) && (localq.sOw != -1000.0D) && (localq.sOx != -1))
    {
      locald.getIController().setCenter(localq.sOv, localq.sOw);
      locald.getIController().setZoom(localq.sOx);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.sWy.setAnimToSelf(false);
        this.sWy.cJF();
        this.sWA.sTm = false;
        this.sWA.sTg = true;
      }
      localq = this.sWB;
      locald = this.sUc.sQT;
      if (localq.sPS != -1) {
        locald.getIController().setZoom(localq.sPS);
      }
      if (this.sWF != null) {
        this.sWF.a(this.fjJ);
      }
      if (this.sWA != null) {
        this.sWA.onResume();
      }
      AppMethodBeat.o(56128);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h
 * JD-Core Version:    0.7.0.1
 */