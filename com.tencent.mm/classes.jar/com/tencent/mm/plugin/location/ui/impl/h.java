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
import com.tencent.mm.ak.b.b;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xh.a;
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
import com.tencent.mm.plugin.location.ui.j.3;
import com.tencent.mm.plugin.location.ui.j.4;
import com.tencent.mm.plugin.location.ui.j.5;
import com.tencent.mm.plugin.location.ui.j.a;
import com.tencent.mm.plugin.location.ui.k.a;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.protocal.protobuf.bng;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cno;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a.d.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class h
  extends k
  implements j.a
{
  private b.a fnd;
  private com.tencent.mm.sdk.b.c oCV;
  private View uak;
  private k.a ubF;
  private Button ueK;
  MyLocationButton ueL;
  private TipSayingWidget ueM;
  com.tencent.mm.plugin.location.ui.k ueN;
  com.tencent.mm.plugin.location.model.q ueO;
  j ueP;
  i ueQ;
  private com.tencent.mm.plugin.location.ui.g ueR;
  private com.tencent.mm.modelgeo.d ueS;
  private ShareHeader ueT;
  private String ueU;
  private long ueV;
  private long ueW;
  private q.b ueX;
  private q.a ueY;
  private HashMap<String, dok> ueZ;
  private PowerManager.WakeLock wakeLock;
  
  public h(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56125);
    this.ueV = 0L;
    this.ueW = 0L;
    this.ubF = new k.a() {};
    this.ueX = new q.b()
    {
      public final void a(cno paramAnonymouscno)
      {
        AppMethodBeat.i(56114);
        h.a(h.this, paramAnonymouscno);
        AppMethodBeat.o(56114);
      }
      
      public final void cXg()
      {
        AppMethodBeat.i(56113);
        ac.i("MicroMsg.ShareMapUI", "onJoinSucess");
        com.tencent.mm.plugin.location.model.q localq = h.this.ueO;
        localq.tXZ = true;
        localq.cXd();
        localq.cXe();
        h.this.ueN.nC(true);
        if (h.this.ueQ != null) {
          h.this.ueQ.cXx();
        }
        AppMethodBeat.o(56113);
      }
      
      public final void cXh()
      {
        AppMethodBeat.i(56116);
        h.this.ueN.nC(false);
        h.this.ueO.stop();
        h.this.ueO.HA(3);
        i.cXz();
        h.this.activity.finish();
        h.this.activity.overridePendingTransition(2130772107, 2130772109);
        AppMethodBeat.o(56116);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(56115);
        ac.v("MicroMsg.ShareMapUI", "onError type %d msg %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.wUl.f(10997, new Object[] { "7", "", Integer.valueOf(0), Integer.valueOf(0) });
        j localj = h.this.ueP;
        ac.d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", new Object[] { paramAnonymousString });
        Context localContext = ai.getContext();
        Object localObject = null;
        if (bs.isNullOrNil(paramAnonymousString)) {
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
    this.ueY = new q.a()
    {
      public final void bsL()
      {
        AppMethodBeat.i(56117);
        h localh = h.this;
        d.a locala = new d.a(localh.activity);
        locala.acJ(2131764536);
        locala.acM(2131755835).b(new h.2(localh));
        locala.fvp().show();
        AppMethodBeat.o(56117);
      }
    };
    this.fnd = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(56118);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(56118);
          return false;
        }
        ac.d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble1) });
        if ((f.v(paramAnonymousDouble1)) && (!h.this.ueN.ubv))
        {
          ac.d("MicroMsg.ShareMapUI", "set driving mode");
          h.this.ueN.uby = false;
          h.this.ueN.nB(true);
          h.this.ueL.cXk();
        }
        AppMethodBeat.o(56118);
        return true;
      }
    };
    this.oCV = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(xh paramAnonymousxh)
      {
        AppMethodBeat.i(56119);
        if (!com.tencent.mm.kernel.g.agM())
        {
          AppMethodBeat.o(56119);
          return false;
        }
        if (paramAnonymousxh.dAb.dgL == 3)
        {
          h.this.ueN.nC(false);
          h.this.ueO.stop();
          h.this.ueO.HA(2);
          i.cXz();
          h.this.activity.finish();
        }
        AppMethodBeat.o(56119);
        return true;
      }
    };
    this.ueZ = new HashMap();
    this.ueO = com.tencent.mm.plugin.location.model.n.cWV();
    this.ueS = com.tencent.mm.modelgeo.d.aEL();
    AppMethodBeat.o(56125);
  }
  
  private void cYb()
  {
    AppMethodBeat.i(56133);
    hideVKB();
    this.ueN.nC(false);
    this.ueO.stop();
    this.ueO.HA(3);
    i.cXz();
    this.ueO.tYf = this.uco.tZg.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56133);
  }
  
  public final void HB(int paramInt)
  {
    AppMethodBeat.i(56135);
    if (paramInt == 0)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      cYb();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      cYb();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 2) {
      cYb();
    }
    AppMethodBeat.o(56135);
  }
  
  public final void cXB()
  {
    AppMethodBeat.i(56132);
    this.ueO.tYf = this.uco.tZg.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56132);
  }
  
  public final void cXC()
  {
    AppMethodBeat.i(56134);
    this.ueN.nC(false);
    this.ueO.stop();
    this.ueO.HA(0);
    i.cXz();
    this.activity.finish();
    AppMethodBeat.o(56134);
  }
  
  protected final void cXJ()
  {
    AppMethodBeat.i(56131);
    super.cXJ();
    AppMethodBeat.o(56131);
  }
  
  final void cXK()
  {
    AppMethodBeat.i(56127);
    super.cXK();
    this.wakeLock = ((PowerManager)this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
    if (this.ufH != null)
    {
      localObject1 = this.ufH;
      ((l)localObject1).ucd.setVisibility(4);
      ((l)localObject1).isVisible = false;
    }
    findViewById(2131300707).setVisibility(8);
    this.ueL = ((MyLocationButton)findViewById(2131301520));
    this.ueL.setProgressBar(this.uco.tZg);
    this.ueL.cXj();
    this.ueL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56121);
        h.this.ueL.cXj();
        h.this.ueN.uby = true;
        h.this.ueN.a(h.this.uco.tZg);
        h.this.ueN.nB(false);
        com.tencent.mm.plugin.report.service.h.wUl.f(10997, new Object[] { "6", "", Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(56121);
      }
    });
    this.uak = findViewById(2131300706);
    this.ueT = ((ShareHeader)findViewById(2131304743));
    this.ueT.setVisibility(0);
    this.ueR = new com.tencent.mm.plugin.location.ui.g(this.activity, this.ueT.getHeaderBar(), this.uak, this.tYc, this.uco.tZg);
    this.ueR.uar = new g.a()
    {
      public final void ajV(String paramAnonymousString)
      {
        AppMethodBeat.i(56122);
        Object localObject = (TrackPoint)h.this.uco.tZg.getViewByItag(paramAnonymousString);
        if (localObject != null)
        {
          ((TrackPoint)localObject).set2Top();
          h.this.uco.tZg.invalidate();
          localObject = h.this.ueN;
          if (bs.isNullOrNil(paramAnonymousString)) {
            break label234;
          }
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).tXX == null) || (!paramAnonymousString.equals(((com.tencent.mm.plugin.location.ui.k)localObject).tXX.Username))) {
            break label150;
          }
          paramAnonymousString = new com.tencent.mm.plugin.location.model.d(((com.tencent.mm.plugin.location.ui.k)localObject).tXX.FWg.Ecf, ((com.tencent.mm.plugin.location.ui.k)localObject).tXX.FWg.Ecg);
        }
        for (;;)
        {
          if (paramAnonymousString != null) {
            h.this.uco.tZg.getIController().animateTo(paramAnonymousString.tWI, paramAnonymousString.tWJ);
          }
          AppMethodBeat.o(56122);
          return;
          label150:
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).ubn != null) && (((com.tencent.mm.plugin.location.ui.k)localObject).ubn.size() > 0))
          {
            localObject = ((com.tencent.mm.plugin.location.ui.k)localObject).ubn.iterator();
            for (;;)
            {
              if (((Iterator)localObject).hasNext())
              {
                dok localdok = (dok)((Iterator)localObject).next();
                if (localdok.Username.equals(paramAnonymousString))
                {
                  paramAnonymousString = new com.tencent.mm.plugin.location.model.d(localdok.FWg.Ecf, localdok.FWg.Ecg);
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
    this.ueO.tYe = this.ueY;
    if (this.ueN == null) {
      this.ueN = new com.tencent.mm.plugin.location.ui.k(this.activity, this.uco.tZg, true);
    }
    this.ueN.ubF = this.ubF;
    this.ueN.ubt = false;
    this.ueP = new j(this.activity, this);
    this.ueM = ((TipSayingWidget)findViewById(2131304298));
    this.ueK = ((Button)findViewById(2131304751));
    this.ueK.setVisibility(0);
    this.ueQ = new i(this.activity, this.ueK);
    this.ueQ.ubc = this.ueR;
    this.ueT.setOnLeftClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56123);
        paramAnonymousView = h.this.ueP;
        com.tencent.mm.ui.base.h.d(paramAnonymousView.mContext, paramAnonymousView.mResources.getString(2131760734), "", paramAnonymousView.mResources.getString(2131755728), paramAnonymousView.mResources.getString(2131755691), new j.3(paramAnonymousView), new j.4(paramAnonymousView));
        AppMethodBeat.o(56123);
      }
    });
    this.ueT.setOnRightClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56124);
        com.tencent.mm.plugin.report.service.h.wUl.f(10997, new Object[] { "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        h.this.ueP.cXA();
        AppMethodBeat.o(56124);
      }
    });
    ((LocationManager)this.activity.getSystemService("location")).isProviderEnabled("gps");
    Object localObject1 = this.ueO;
    Object localObject2 = this.ucm;
    ((com.tencent.mm.plugin.location.model.q)localObject1).tYh = System.currentTimeMillis();
    ((com.tencent.mm.plugin.location.model.q)localObject1).hxT = com.tencent.mm.modelgeo.d.aEL();
    ((com.tencent.mm.plugin.location.model.q)localObject1).hxT.b(((com.tencent.mm.plugin.location.model.q)localObject1).fnd, true);
    if (((com.tencent.mm.plugin.location.model.q)localObject1).tXU == null) {
      ((com.tencent.mm.plugin.location.model.q)localObject1).tXU = com.tencent.mm.plugin.location.model.n.cWX();
    }
    ((com.tencent.mm.plugin.location.model.q)localObject1).tXU.a(((com.tencent.mm.plugin.location.model.q)localObject1).tYj);
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.location.model.q)localObject1).tXY = ((LocationInfo)localObject2);
    }
    if (((com.tencent.mm.plugin.location.model.q)localObject1).isStart)
    {
      ac.i("MicorMsg.TrackRefreshManager", "start location " + ((com.tencent.mm.plugin.location.model.q)localObject1).tXY.tWI + " " + ((com.tencent.mm.plugin.location.model.q)localObject1).tXY.tWJ);
      localObject1 = this.ueO;
      localObject2 = this.ueX;
      Iterator localIterator = ((com.tencent.mm.plugin.location.model.q)localObject1).tXV.iterator();
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
      this.ueU = this.activity.getIntent().getStringExtra("fromWhereShare");
      ac.d("MicroMsg.ShareMapUI", "fromWhere=%s", new Object[] { this.ueU });
      if (!this.ueO.cWZ()) {
        break label829;
      }
      ac.i("MicroMsg.ShareMapUI", "has join");
      this.ueN.nC(true);
      this.ueQ.cXx();
      AppMethodBeat.o(56127);
      return;
      ((com.tencent.mm.plugin.location.model.q)localObject1).tXW = 1;
      ((com.tencent.mm.plugin.location.model.q)localObject1).tXX = new dok();
      ((com.tencent.mm.plugin.location.model.q)localObject1).tXX.FWg = new cgf();
      ((com.tencent.mm.plugin.location.model.q)localObject1).tXX.FWg.Ecg = -1000.0D;
      ((com.tencent.mm.plugin.location.model.q)localObject1).tXX.FWg.Ecf = -1000.0D;
      ac.i("MicorMsg.TrackRefreshManager", "start location imp " + ((com.tencent.mm.plugin.location.model.q)localObject1).tXY.tWI + " " + ((com.tencent.mm.plugin.location.model.q)localObject1).tXY.tWJ);
      com.tencent.mm.kernel.g.agi().a(492, (com.tencent.mm.ak.g)localObject1);
      com.tencent.mm.kernel.g.agi().a(490, (com.tencent.mm.ak.g)localObject1);
      com.tencent.mm.kernel.g.agi().a(491, (com.tencent.mm.ak.g)localObject1);
      ((com.tencent.mm.plugin.location.model.q)localObject1).cLV = false;
      ((com.tencent.mm.plugin.location.model.q)localObject1).isStart = true;
      break;
      ((com.tencent.mm.plugin.location.model.q)localObject1).tXV.add(new WeakReference(localObject2));
    }
    label829:
    localObject2 = this.ueO;
    localObject1 = this.tYc;
    int i;
    if (!bs.isNullOrNil(this.ueU)) {
      if (this.ueU.equals("fromBanner"))
      {
        i = 0;
        ac.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[] { localObject1 });
        ((com.tencent.mm.plugin.location.model.q)localObject2).tYc = ((String)localObject1);
        localObject2 = u.axw();
        if (!((String)localObject1).contains("@chatroom")) {
          break label1014;
        }
      }
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.location.model.a.b((String)localObject1);
      ((bng)((com.tencent.mm.plugin.location.model.a.b)localObject1).rr.hvr.hvw).Scene = i;
      com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject1, 0);
      AppMethodBeat.o(56127);
      return;
      if (!this.ueU.equals("fromPluginLocation"))
      {
        if (this.ueU.equals("fromPluginTalk"))
        {
          i = 2;
          break;
        }
        if (this.ueU.equals("fromTrackButton"))
        {
          i = 3;
          break;
        }
        if (this.ueU.equals("fromMessage"))
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
  
  public final boolean cXL()
  {
    return true;
  }
  
  public final void cYc()
  {
    AppMethodBeat.i(56138);
    super.cYc();
    if (this.ueN != null)
    {
      this.ueN.uby = false;
      this.ueN.nB(false);
      this.ueL.cXk();
    }
    AppMethodBeat.o(56138);
  }
  
  protected final void cYd()
  {
    AppMethodBeat.i(56139);
    super.cYd();
    com.tencent.mm.plugin.report.service.h.wUl.f(10997, new Object[] { "1", "", Integer.valueOf(0), Integer.valueOf(0) });
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
    com.tencent.mm.plugin.report.service.h.wUl.f(10997, new Object[] { "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.ueP.cXA();
    AppMethodBeat.o(56136);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56126);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.ShareMapUI", "onCreate");
    this.ueV = System.currentTimeMillis();
    a.GpY.c(this.oCV);
    AppMethodBeat.o(56126);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56130);
    super.onDestroy();
    Object localObject = this.ueO;
    q.b localb = this.ueX;
    Iterator localIterator = ((com.tencent.mm.plugin.location.model.q)localObject).tXV.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((q.b)localWeakReference.get()).equals(localb))) {
        ((com.tencent.mm.plugin.location.model.q)localObject).tXV.remove(localWeakReference);
      }
    }
    a.GpY.d(this.oCV);
    this.ueO.tYe = null;
    if (this.ueQ != null)
    {
      localObject = this.ueQ;
      ((i)localObject).ubb.b((com.tencent.mm.bh.d)localObject);
      localObject = ((i)localObject).uaO;
      ((VolumeMeter)localObject).ubL.removeCallbacks((Runnable)localObject);
      ((VolumeMeter)localObject).ubL.post(((VolumeMeter)localObject).ubZ);
    }
    if (this.ueN != null) {
      this.ueN.destroy();
    }
    if (this.ueL != null)
    {
      localObject = this.ueL;
      com.tencent.mm.modelgeo.d.aEL().c(((MyLocationButton)localObject).fnd);
    }
    ac.i("MicroMsg.ShareMapUI", "onDestory");
    AppMethodBeat.o(56130);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56129);
    ac.i("MicroMsg.ShareMapUI", "pause");
    super.onPause();
    this.wakeLock.release();
    com.tencent.mm.plugin.location.model.q localq = this.ueO;
    ac.d("MicorMsg.TrackRefreshManager", "pause isShared:" + localq.tXZ);
    if (!localq.tXZ)
    {
      localq.hxT.c(localq.fnd);
      localq.tXU.b(localq.tYj);
      localq.tYa = true;
      localq.tYg = true;
    }
    localq = this.ueO;
    com.tencent.mm.plugin.k.d locald = this.uco.tZg;
    localq.tYb = localq.tXW;
    localq.tXW = 0;
    ac.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + localq.tYb);
    if (localq.cXf())
    {
      localq.tWI = (locald.getMapCenterX() * 1.0D / 1000000.0D);
      localq.tWJ = (locald.getMapCenterY() * 1.0D / 1000000.0D);
      localq.tWK = locald.getZoom();
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(10997, new Object[] { "17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.ueV) });
    this.ueV = System.currentTimeMillis();
    if (this.ueS != null) {
      this.ueS.c(this.fnd);
    }
    if (this.ueN != null) {
      this.ueN.onPause();
    }
    AppMethodBeat.o(56129);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56128);
    ac.i("MicroMsg.ShareMapUI", "resume");
    super.onResume();
    this.wakeLock.acquire();
    com.tencent.mm.plugin.location.model.q localq = this.ueO;
    ac.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + localq.tYa);
    if (localq.tYa)
    {
      localq.tYh = System.currentTimeMillis();
      localq.hxT.a(localq.fnd);
      localq.tXU.a(localq.tYj);
    }
    localq.tYa = false;
    localq.cXb();
    localq = this.ueO;
    com.tencent.mm.plugin.k.d locald = this.uco.tZg;
    localq.tXW = localq.tYb;
    ac.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + localq.tXW + " %f %f %d ", new Object[] { Double.valueOf(localq.tWI), Double.valueOf(localq.tWJ), Integer.valueOf(localq.tWK) });
    if ((localq.tWI != -1000.0D) && (localq.tWJ != -1000.0D) && (localq.tWK != -1))
    {
      locald.getIController().setCenter(localq.tWI, localq.tWJ);
      locald.getIController().setZoom(localq.tWK);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.ueL.setAnimToSelf(false);
        this.ueL.cXk();
        this.ueN.uby = false;
        this.ueN.ubs = true;
      }
      localq = this.ueO;
      locald = this.uco.tZg;
      if (localq.tYf != -1) {
        locald.getIController().setZoom(localq.tYf);
      }
      if (this.ueS != null) {
        this.ueS.a(this.fnd);
      }
      if (this.ueN != null) {
        this.ueN.onResume();
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