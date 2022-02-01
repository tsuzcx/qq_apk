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
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.a;
import com.tencent.mm.model.u;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
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
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.cle;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.protocal.protobuf.dub;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  private b.a fFl;
  private com.tencent.mm.sdk.b.c pgq;
  private View vcT;
  private k.a veo;
  private com.tencent.mm.plugin.location.ui.g vhA;
  private com.tencent.mm.modelgeo.d vhB;
  private ShareHeader vhC;
  private String vhD;
  private long vhE;
  private long vhF;
  private q.b vhG;
  private q.a vhH;
  private HashMap<String, dub> vhI;
  private Button vht;
  MyLocationButton vhu;
  private TipSayingWidget vhv;
  com.tencent.mm.plugin.location.ui.k vhw;
  com.tencent.mm.plugin.location.model.q vhx;
  j vhy;
  i vhz;
  private PowerManager.WakeLock wakeLock;
  
  public h(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56125);
    this.vhE = 0L;
    this.vhF = 0L;
    this.veo = new k.a() {};
    this.vhG = new q.b()
    {
      public final void a(csr paramAnonymouscsr)
      {
        AppMethodBeat.i(56114);
        h.a(h.this, paramAnonymouscsr);
        AppMethodBeat.o(56114);
      }
      
      public final void dgs()
      {
        AppMethodBeat.i(56113);
        ad.i("MicroMsg.ShareMapUI", "onJoinSucess");
        com.tencent.mm.plugin.location.model.q localq = h.this.vhx;
        localq.vaI = true;
        localq.dgp();
        localq.dgq();
        h.this.vhw.nW(true);
        if (h.this.vhz != null) {
          h.this.vhz.dgJ();
        }
        AppMethodBeat.o(56113);
      }
      
      public final void dgt()
      {
        AppMethodBeat.i(56116);
        h.this.vhw.nW(false);
        h.this.vhx.stop();
        h.this.vhx.IW(3);
        i.dgL();
        h.this.activity.finish();
        h.this.activity.overridePendingTransition(2130772107, 2130772109);
        AppMethodBeat.o(56116);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(56115);
        ad.v("MicroMsg.ShareMapUI", "onError type %d msg %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.g.yhR.f(10997, new Object[] { "7", "", Integer.valueOf(0), Integer.valueOf(0) });
        j localj = h.this.vhy;
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
    this.vhH = new q.a()
    {
      public final void bwP()
      {
        AppMethodBeat.i(56117);
        h localh = h.this;
        d.a locala = new d.a(localh.activity);
        locala.afi(2131764536);
        locala.afl(2131755835).c(new h.2(localh));
        locala.fMb().show();
        AppMethodBeat.o(56117);
      }
    };
    this.fFl = new b.a()
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
        if ((com.tencent.mm.plugin.location.model.f.v(paramAnonymousDouble1)) && (!h.this.vhw.vee))
        {
          ad.d("MicroMsg.ShareMapUI", "set driving mode");
          h.this.vhw.veh = false;
          h.this.vhw.nV(true);
          h.this.vhu.dgw();
        }
        AppMethodBeat.o(56118);
        return true;
      }
    };
    this.pgq = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(yb paramAnonymousyb)
      {
        AppMethodBeat.i(56119);
        if (!com.tencent.mm.kernel.g.ajx())
        {
          AppMethodBeat.o(56119);
          return false;
        }
        if (paramAnonymousyb.dMo.dsi == 3)
        {
          h.this.vhw.nW(false);
          h.this.vhx.stop();
          h.this.vhx.IW(2);
          i.dgL();
          h.this.activity.finish();
        }
        AppMethodBeat.o(56119);
        return true;
      }
    };
    this.vhI = new HashMap();
    this.vhx = com.tencent.mm.plugin.location.model.n.dgh();
    this.vhB = com.tencent.mm.modelgeo.d.aHQ();
    AppMethodBeat.o(56125);
  }
  
  private void dhn()
  {
    AppMethodBeat.i(56133);
    hideVKB();
    this.vhw.nW(false);
    this.vhx.stop();
    this.vhx.IW(3);
    i.dgL();
    this.vhx.vaO = this.veY.vbP.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56133);
  }
  
  public final void IX(int paramInt)
  {
    AppMethodBeat.i(56135);
    if (paramInt == 0)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      dhn();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      dhn();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 2) {
      dhn();
    }
    AppMethodBeat.o(56135);
  }
  
  public final void dgN()
  {
    AppMethodBeat.i(56132);
    this.vhx.vaO = this.veY.vbP.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56132);
  }
  
  public final void dgO()
  {
    AppMethodBeat.i(56134);
    this.vhw.nW(false);
    this.vhx.stop();
    this.vhx.IW(0);
    i.dgL();
    this.activity.finish();
    AppMethodBeat.o(56134);
  }
  
  protected final void dgV()
  {
    AppMethodBeat.i(56131);
    super.dgV();
    AppMethodBeat.o(56131);
  }
  
  final void dgW()
  {
    AppMethodBeat.i(56127);
    super.dgW();
    this.wakeLock = ((PowerManager)this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
    if (this.vir != null)
    {
      localObject1 = this.vir;
      ((l)localObject1).veN.setVisibility(4);
      ((l)localObject1).isVisible = false;
    }
    findViewById(2131300707).setVisibility(8);
    this.vhu = ((MyLocationButton)findViewById(2131301520));
    this.vhu.setProgressBar(this.veY.vbP);
    this.vhu.dgv();
    this.vhu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56121);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/ShareMapUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        h.this.vhu.dgv();
        h.this.vhw.veh = true;
        h.this.vhw.a(h.this.veY.vbP);
        h.this.vhw.nV(false);
        com.tencent.mm.plugin.report.service.g.yhR.f(10997, new Object[] { "6", "", Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56121);
      }
    });
    this.vcT = findViewById(2131300706);
    this.vhC = ((ShareHeader)findViewById(2131304743));
    this.vhC.setVisibility(0);
    this.vhA = new com.tencent.mm.plugin.location.ui.g(this.activity, this.vhC.getHeaderBar(), this.vcT, this.vaL, this.veY.vbP);
    this.vhA.vda = new g.a()
    {
      public final void aoI(String paramAnonymousString)
      {
        AppMethodBeat.i(56122);
        Object localObject = (TrackPoint)h.this.veY.vbP.getViewByItag(paramAnonymousString);
        if (localObject != null)
        {
          ((TrackPoint)localObject).set2Top();
          h.this.veY.vbP.invalidate();
          localObject = h.this.vhw;
          if (bt.isNullOrNil(paramAnonymousString)) {
            break label234;
          }
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).vaG == null) || (!paramAnonymousString.equals(((com.tencent.mm.plugin.location.ui.k)localObject).vaG.Username))) {
            break label150;
          }
          paramAnonymousString = new com.tencent.mm.plugin.location.model.d(((com.tencent.mm.plugin.location.ui.k)localObject).vaG.HGW.FIb, ((com.tencent.mm.plugin.location.ui.k)localObject).vaG.HGW.FIc);
        }
        for (;;)
        {
          if (paramAnonymousString != null) {
            h.this.veY.vbP.getIController().animateTo(paramAnonymousString.uZr, paramAnonymousString.uZs);
          }
          AppMethodBeat.o(56122);
          return;
          label150:
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).vdW != null) && (((com.tencent.mm.plugin.location.ui.k)localObject).vdW.size() > 0))
          {
            localObject = ((com.tencent.mm.plugin.location.ui.k)localObject).vdW.iterator();
            for (;;)
            {
              if (((Iterator)localObject).hasNext())
              {
                dub localdub = (dub)((Iterator)localObject).next();
                if (localdub.Username.equals(paramAnonymousString))
                {
                  paramAnonymousString = new com.tencent.mm.plugin.location.model.d(localdub.HGW.FIb, localdub.HGW.FIc);
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
    this.vhx.vaN = this.vhH;
    if (this.vhw == null) {
      this.vhw = new com.tencent.mm.plugin.location.ui.k(this.activity, this.veY.vbP, true);
    }
    this.vhw.veo = this.veo;
    this.vhw.vec = false;
    this.vhy = new j(this.activity, this);
    this.vhv = ((TipSayingWidget)findViewById(2131304298));
    this.vht = ((Button)findViewById(2131304751));
    this.vht.setVisibility(0);
    this.vhz = new i(this.activity, this.vht);
    this.vhz.vdL = this.vhA;
    this.vhC.setOnLeftClickListener(new h.9(this));
    this.vhC.setOnRightClickListener(new h.10(this));
    ((LocationManager)this.activity.getSystemService("location")).isProviderEnabled("gps");
    Object localObject1 = this.vhx;
    Object localObject2 = this.veW;
    ((com.tencent.mm.plugin.location.model.q)localObject1).vaQ = System.currentTimeMillis();
    ((com.tencent.mm.plugin.location.model.q)localObject1).hQo = com.tencent.mm.modelgeo.d.aHQ();
    ((com.tencent.mm.plugin.location.model.q)localObject1).hQo.b(((com.tencent.mm.plugin.location.model.q)localObject1).fFl, true);
    if (((com.tencent.mm.plugin.location.model.q)localObject1).vaD == null) {
      ((com.tencent.mm.plugin.location.model.q)localObject1).vaD = com.tencent.mm.plugin.location.model.n.dgj();
    }
    ((com.tencent.mm.plugin.location.model.q)localObject1).vaD.a(((com.tencent.mm.plugin.location.model.q)localObject1).vaS);
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.location.model.q)localObject1).vaH = ((LocationInfo)localObject2);
    }
    if (((com.tencent.mm.plugin.location.model.q)localObject1).isStart)
    {
      ad.i("MicorMsg.TrackRefreshManager", "start location " + ((com.tencent.mm.plugin.location.model.q)localObject1).vaH.uZr + " " + ((com.tencent.mm.plugin.location.model.q)localObject1).vaH.uZs);
      localObject1 = this.vhx;
      localObject2 = this.vhG;
      Iterator localIterator = ((com.tencent.mm.plugin.location.model.q)localObject1).vaE.iterator();
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
      this.vhD = this.activity.getIntent().getStringExtra("fromWhereShare");
      ad.d("MicroMsg.ShareMapUI", "fromWhere=%s", new Object[] { this.vhD });
      if (!this.vhx.dgl()) {
        break label829;
      }
      ad.i("MicroMsg.ShareMapUI", "has join");
      this.vhw.nW(true);
      this.vhz.dgJ();
      AppMethodBeat.o(56127);
      return;
      ((com.tencent.mm.plugin.location.model.q)localObject1).vaF = 1;
      ((com.tencent.mm.plugin.location.model.q)localObject1).vaG = new dub();
      ((com.tencent.mm.plugin.location.model.q)localObject1).vaG.HGW = new cle();
      ((com.tencent.mm.plugin.location.model.q)localObject1).vaG.HGW.FIc = -1000.0D;
      ((com.tencent.mm.plugin.location.model.q)localObject1).vaG.HGW.FIb = -1000.0D;
      ad.i("MicorMsg.TrackRefreshManager", "start location imp " + ((com.tencent.mm.plugin.location.model.q)localObject1).vaH.uZr + " " + ((com.tencent.mm.plugin.location.model.q)localObject1).vaH.uZs);
      com.tencent.mm.kernel.g.aiU().a(492, (com.tencent.mm.al.f)localObject1);
      com.tencent.mm.kernel.g.aiU().a(490, (com.tencent.mm.al.f)localObject1);
      com.tencent.mm.kernel.g.aiU().a(491, (com.tencent.mm.al.f)localObject1);
      ((com.tencent.mm.plugin.location.model.q)localObject1).cXj = false;
      ((com.tencent.mm.plugin.location.model.q)localObject1).isStart = true;
      break;
      ((com.tencent.mm.plugin.location.model.q)localObject1).vaE.add(new WeakReference(localObject2));
    }
    label829:
    localObject2 = this.vhx;
    localObject1 = this.vaL;
    int i;
    if (!bt.isNullOrNil(this.vhD)) {
      if (this.vhD.equals("fromBanner"))
      {
        i = 0;
        ad.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[] { localObject1 });
        ((com.tencent.mm.plugin.location.model.q)localObject2).vaL = ((String)localObject1);
        localObject2 = u.aAm();
        if (!((String)localObject1).contains("@chatroom")) {
          break label1014;
        }
      }
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.location.model.a.b((String)localObject1);
      ((brq)((com.tencent.mm.plugin.location.model.a.b)localObject1).rr.hNK.hNQ).Scene = i;
      com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject1, 0);
      AppMethodBeat.o(56127);
      return;
      if (!this.vhD.equals("fromPluginLocation"))
      {
        if (this.vhD.equals("fromPluginTalk"))
        {
          i = 2;
          break;
        }
        if (this.vhD.equals("fromTrackButton"))
        {
          i = 3;
          break;
        }
        if (this.vhD.equals("fromMessage"))
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
  
  public final boolean dgX()
  {
    return true;
  }
  
  public final void dho()
  {
    AppMethodBeat.i(56138);
    super.dho();
    if (this.vhw != null)
    {
      this.vhw.veh = false;
      this.vhw.nV(false);
      this.vhu.dgw();
    }
    AppMethodBeat.o(56138);
  }
  
  protected final void dhp()
  {
    AppMethodBeat.i(56139);
    super.dhp();
    com.tencent.mm.plugin.report.service.g.yhR.f(10997, new Object[] { "1", "", Integer.valueOf(0), Integer.valueOf(0) });
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
    com.tencent.mm.plugin.report.service.g.yhR.f(10997, new Object[] { "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.vhy.dgM();
    AppMethodBeat.o(56136);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56126);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.ShareMapUI", "onCreate");
    this.vhE = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.IbL.c(this.pgq);
    AppMethodBeat.o(56126);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56130);
    super.onDestroy();
    Object localObject = this.vhx;
    q.b localb = this.vhG;
    Iterator localIterator = ((com.tencent.mm.plugin.location.model.q)localObject).vaE.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((q.b)localWeakReference.get()).equals(localb))) {
        ((com.tencent.mm.plugin.location.model.q)localObject).vaE.remove(localWeakReference);
      }
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.pgq);
    this.vhx.vaN = null;
    if (this.vhz != null)
    {
      localObject = this.vhz;
      ((i)localObject).vdK.b((com.tencent.mm.bi.d)localObject);
      localObject = ((i)localObject).vdx;
      ((VolumeMeter)localObject).vev.removeCallbacks((Runnable)localObject);
      ((VolumeMeter)localObject).vev.post(((VolumeMeter)localObject).veJ);
    }
    if (this.vhw != null) {
      this.vhw.destroy();
    }
    if (this.vhu != null)
    {
      localObject = this.vhu;
      com.tencent.mm.modelgeo.d.aHQ().c(((MyLocationButton)localObject).fFl);
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
    com.tencent.mm.plugin.location.model.q localq = this.vhx;
    ad.d("MicorMsg.TrackRefreshManager", "pause isShared:" + localq.vaI);
    if (!localq.vaI)
    {
      localq.hQo.c(localq.fFl);
      localq.vaD.b(localq.vaS);
      localq.vaJ = true;
      localq.vaP = true;
    }
    localq = this.vhx;
    com.tencent.mm.plugin.k.d locald = this.veY.vbP;
    localq.vaK = localq.vaF;
    localq.vaF = 0;
    ad.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + localq.vaK);
    if (localq.dgr())
    {
      localq.uZr = (locald.getMapCenterX() * 1.0D / 1000000.0D);
      localq.uZs = (locald.getMapCenterY() * 1.0D / 1000000.0D);
      localq.uZt = locald.getZoom();
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(10997, new Object[] { "17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.vhE) });
    this.vhE = System.currentTimeMillis();
    if (this.vhB != null) {
      this.vhB.c(this.fFl);
    }
    if (this.vhw != null) {
      this.vhw.onPause();
    }
    AppMethodBeat.o(56129);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56128);
    ad.i("MicroMsg.ShareMapUI", "resume");
    super.onResume();
    this.wakeLock.acquire();
    com.tencent.mm.plugin.location.model.q localq = this.vhx;
    ad.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + localq.vaJ);
    if (localq.vaJ)
    {
      localq.vaQ = System.currentTimeMillis();
      localq.hQo.a(localq.fFl);
      localq.vaD.a(localq.vaS);
    }
    localq.vaJ = false;
    localq.dgn();
    localq = this.vhx;
    com.tencent.mm.plugin.k.d locald = this.veY.vbP;
    localq.vaF = localq.vaK;
    ad.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + localq.vaF + " %f %f %d ", new Object[] { Double.valueOf(localq.uZr), Double.valueOf(localq.uZs), Integer.valueOf(localq.uZt) });
    if ((localq.uZr != -1000.0D) && (localq.uZs != -1000.0D) && (localq.uZt != -1))
    {
      locald.getIController().setCenter(localq.uZr, localq.uZs);
      locald.getIController().setZoom(localq.uZt);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.vhu.setAnimToSelf(false);
        this.vhu.dgw();
        this.vhw.veh = false;
        this.vhw.veb = true;
      }
      localq = this.vhx;
      locald = this.veY.vbP;
      if (localq.vaO != -1) {
        locald.getIController().setZoom(localq.vaO);
      }
      if (this.vhB != null) {
        this.vhB.a(this.fFl);
      }
      if (this.vhw != null) {
        this.vhw.onResume();
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