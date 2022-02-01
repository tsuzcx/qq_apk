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
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.yh.a;
import com.tencent.mm.model.v;
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
import com.tencent.mm.protocal.protobuf.bsk;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
  private b.a fHp;
  private com.tencent.mm.sdk.b.c pmW;
  private View vpe;
  private k.a vqz;
  private Button vtA;
  MyLocationButton vtB;
  private TipSayingWidget vtC;
  com.tencent.mm.plugin.location.ui.k vtD;
  com.tencent.mm.plugin.location.model.q vtE;
  j vtF;
  i vtG;
  private com.tencent.mm.plugin.location.ui.g vtH;
  private com.tencent.mm.modelgeo.d vtI;
  private ShareHeader vtJ;
  private String vtK;
  private long vtL;
  private long vtM;
  private q.b vtN;
  private q.a vtO;
  private HashMap<String, duy> vtP;
  private PowerManager.WakeLock wakeLock;
  
  public h(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56125);
    this.vtL = 0L;
    this.vtM = 0L;
    this.vqz = new k.a() {};
    this.vtN = new q.b()
    {
      public final void a(ctl paramAnonymousctl)
      {
        AppMethodBeat.i(56114);
        h.a(h.this, paramAnonymousctl);
        AppMethodBeat.o(56114);
      }
      
      public final void djr()
      {
        AppMethodBeat.i(56113);
        ae.i("MicroMsg.ShareMapUI", "onJoinSucess");
        com.tencent.mm.plugin.location.model.q localq = h.this.vtE;
        localq.vmT = true;
        localq.djo();
        localq.djp();
        h.this.vtD.ob(true);
        if (h.this.vtG != null) {
          h.this.vtG.djI();
        }
        AppMethodBeat.o(56113);
      }
      
      public final void djs()
      {
        AppMethodBeat.i(56116);
        h.this.vtD.ob(false);
        h.this.vtE.stop();
        h.this.vtE.Jv(3);
        i.djK();
        h.this.activity.finish();
        h.this.activity.overridePendingTransition(2130772107, 2130772109);
        AppMethodBeat.o(56116);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(56115);
        ae.v("MicroMsg.ShareMapUI", "onError type %d msg %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.g.yxI.f(10997, new Object[] { "7", "", Integer.valueOf(0), Integer.valueOf(0) });
        j localj = h.this.vtF;
        ae.d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", new Object[] { paramAnonymousString });
        Context localContext = ak.getContext();
        Object localObject = null;
        if (bu.isNullOrNil(paramAnonymousString)) {
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
    this.vtO = new q.a()
    {
      public final void bxH()
      {
        AppMethodBeat.i(56117);
        h localh = h.this;
        d.a locala = new d.a(localh.activity);
        locala.afR(2131764536);
        locala.afU(2131755835).c(new h.2(localh));
        locala.fQv().show();
        AppMethodBeat.o(56117);
      }
    };
    this.fHp = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(56118);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(56118);
          return false;
        }
        ae.d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble1) });
        if ((com.tencent.mm.plugin.location.model.f.v(paramAnonymousDouble1)) && (!h.this.vtD.vqp))
        {
          ae.d("MicroMsg.ShareMapUI", "set driving mode");
          h.this.vtD.vqs = false;
          h.this.vtD.oa(true);
          h.this.vtB.djv();
        }
        AppMethodBeat.o(56118);
        return true;
      }
    };
    this.pmW = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(yh paramAnonymousyh)
      {
        AppMethodBeat.i(56119);
        if (!com.tencent.mm.kernel.g.ajM())
        {
          AppMethodBeat.o(56119);
          return false;
        }
        if (paramAnonymousyh.dNE.dto == 3)
        {
          h.this.vtD.ob(false);
          h.this.vtE.stop();
          h.this.vtE.Jv(2);
          i.djK();
          h.this.activity.finish();
        }
        AppMethodBeat.o(56119);
        return true;
      }
    };
    this.vtP = new HashMap();
    this.vtE = com.tencent.mm.plugin.location.model.n.djg();
    this.vtI = com.tencent.mm.modelgeo.d.aIh();
    AppMethodBeat.o(56125);
  }
  
  private void dkm()
  {
    AppMethodBeat.i(56133);
    hideVKB();
    this.vtD.ob(false);
    this.vtE.stop();
    this.vtE.Jv(3);
    i.djK();
    this.vtE.vmZ = this.vrf.voa.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56133);
  }
  
  public final void Jw(int paramInt)
  {
    AppMethodBeat.i(56135);
    if (paramInt == 0)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      dkm();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      dkm();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 2) {
      dkm();
    }
    AppMethodBeat.o(56135);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(56137);
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(56137);
    return bool;
  }
  
  public final void djM()
  {
    AppMethodBeat.i(56132);
    this.vtE.vmZ = this.vrf.voa.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56132);
  }
  
  public final void djN()
  {
    AppMethodBeat.i(56134);
    this.vtD.ob(false);
    this.vtE.stop();
    this.vtE.Jv(0);
    i.djK();
    this.activity.finish();
    AppMethodBeat.o(56134);
  }
  
  protected final void djU()
  {
    AppMethodBeat.i(56131);
    super.djU();
    AppMethodBeat.o(56131);
  }
  
  final void djV()
  {
    AppMethodBeat.i(56127);
    super.djV();
    this.wakeLock = ((PowerManager)this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
    if (this.vuw != null)
    {
      localObject1 = this.vuw;
      ((l)localObject1).vqX.setVisibility(4);
      ((l)localObject1).isVisible = false;
    }
    findViewById(2131300707).setVisibility(8);
    this.vtB = ((MyLocationButton)findViewById(2131301520));
    this.vtB.setProgressBar(this.vrf.voa);
    this.vtB.dju();
    this.vtB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56121);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/impl/ShareMapUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        h.this.vtB.dju();
        h.this.vtD.vqs = true;
        h.this.vtD.a(h.this.vrf.voa);
        h.this.vtD.oa(false);
        com.tencent.mm.plugin.report.service.g.yxI.f(10997, new Object[] { "6", "", Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56121);
      }
    });
    this.vpe = findViewById(2131300706);
    this.vtJ = ((ShareHeader)findViewById(2131304743));
    this.vtJ.setVisibility(0);
    this.vtH = new com.tencent.mm.plugin.location.ui.g(this.activity, this.vtJ.getHeaderBar(), this.vpe, this.vmW, this.vrf.voa);
    this.vtH.vpl = new g.a()
    {
      public final void apN(String paramAnonymousString)
      {
        AppMethodBeat.i(56122);
        Object localObject = (TrackPoint)h.this.vrf.voa.getViewByItag(paramAnonymousString);
        if (localObject != null)
        {
          ((TrackPoint)localObject).set2Top();
          h.this.vrf.voa.invalidate();
          localObject = h.this.vtD;
          if (bu.isNullOrNil(paramAnonymousString)) {
            break label234;
          }
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).vmR == null) || (!paramAnonymousString.equals(((com.tencent.mm.plugin.location.ui.k)localObject).vmR.Username))) {
            break label150;
          }
          paramAnonymousString = new com.tencent.mm.plugin.location.model.d(((com.tencent.mm.plugin.location.ui.k)localObject).vmR.IaJ.Gax, ((com.tencent.mm.plugin.location.ui.k)localObject).vmR.IaJ.Gay);
        }
        for (;;)
        {
          if (paramAnonymousString != null) {
            h.this.vrf.voa.getIController().animateTo(paramAnonymousString.vlC, paramAnonymousString.vlD);
          }
          AppMethodBeat.o(56122);
          return;
          label150:
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).vqh != null) && (((com.tencent.mm.plugin.location.ui.k)localObject).vqh.size() > 0))
          {
            localObject = ((com.tencent.mm.plugin.location.ui.k)localObject).vqh.iterator();
            for (;;)
            {
              if (((Iterator)localObject).hasNext())
              {
                duy localduy = (duy)((Iterator)localObject).next();
                if (localduy.Username.equals(paramAnonymousString))
                {
                  paramAnonymousString = new com.tencent.mm.plugin.location.model.d(localduy.IaJ.Gax, localduy.IaJ.Gay);
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
    this.vtE.vmY = this.vtO;
    if (this.vtD == null) {
      this.vtD = new com.tencent.mm.plugin.location.ui.k(this.activity, this.vrf.voa, true);
    }
    this.vtD.vqz = this.vqz;
    this.vtD.vqn = false;
    this.vtF = new j(this.activity, this);
    this.vtC = ((TipSayingWidget)findViewById(2131304298));
    this.vtA = ((Button)findViewById(2131304751));
    this.vtA.setVisibility(0);
    this.vtG = new i(this.activity, this.vtA);
    this.vtG.vpW = this.vtH;
    this.vtJ.setOnLeftClickListener(new h.9(this));
    this.vtJ.setOnRightClickListener(new h.10(this));
    ((LocationManager)this.activity.getSystemService("location")).isProviderEnabled("gps");
    Object localObject1 = this.vtE;
    Object localObject2 = this.kSe;
    ((com.tencent.mm.plugin.location.model.q)localObject1).vnb = System.currentTimeMillis();
    ((com.tencent.mm.plugin.location.model.q)localObject1).hTg = com.tencent.mm.modelgeo.d.aIh();
    ((com.tencent.mm.plugin.location.model.q)localObject1).hTg.b(((com.tencent.mm.plugin.location.model.q)localObject1).fHp, true);
    if (((com.tencent.mm.plugin.location.model.q)localObject1).vmO == null) {
      ((com.tencent.mm.plugin.location.model.q)localObject1).vmO = com.tencent.mm.plugin.location.model.n.dji();
    }
    ((com.tencent.mm.plugin.location.model.q)localObject1).vmO.a(((com.tencent.mm.plugin.location.model.q)localObject1).vnd);
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.location.model.q)localObject1).vmS = ((LocationInfo)localObject2);
    }
    if (((com.tencent.mm.plugin.location.model.q)localObject1).isStart)
    {
      ae.i("MicorMsg.TrackRefreshManager", "start location " + ((com.tencent.mm.plugin.location.model.q)localObject1).vmS.vlC + " " + ((com.tencent.mm.plugin.location.model.q)localObject1).vmS.vlD);
      localObject1 = this.vtE;
      localObject2 = this.vtN;
      Iterator localIterator = ((com.tencent.mm.plugin.location.model.q)localObject1).vmP.iterator();
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
      this.vtK = this.activity.getIntent().getStringExtra("fromWhereShare");
      ae.d("MicroMsg.ShareMapUI", "fromWhere=%s", new Object[] { this.vtK });
      if (!this.vtE.djk()) {
        break label829;
      }
      ae.i("MicroMsg.ShareMapUI", "has join");
      this.vtD.ob(true);
      this.vtG.djI();
      AppMethodBeat.o(56127);
      return;
      ((com.tencent.mm.plugin.location.model.q)localObject1).vmQ = 1;
      ((com.tencent.mm.plugin.location.model.q)localObject1).vmR = new duy();
      ((com.tencent.mm.plugin.location.model.q)localObject1).vmR.IaJ = new cly();
      ((com.tencent.mm.plugin.location.model.q)localObject1).vmR.IaJ.Gay = -1000.0D;
      ((com.tencent.mm.plugin.location.model.q)localObject1).vmR.IaJ.Gax = -1000.0D;
      ae.i("MicorMsg.TrackRefreshManager", "start location imp " + ((com.tencent.mm.plugin.location.model.q)localObject1).vmS.vlC + " " + ((com.tencent.mm.plugin.location.model.q)localObject1).vmS.vlD);
      com.tencent.mm.kernel.g.ajj().a(492, (com.tencent.mm.ak.f)localObject1);
      com.tencent.mm.kernel.g.ajj().a(490, (com.tencent.mm.ak.f)localObject1);
      com.tencent.mm.kernel.g.ajj().a(491, (com.tencent.mm.ak.f)localObject1);
      ((com.tencent.mm.plugin.location.model.q)localObject1).cYg = false;
      ((com.tencent.mm.plugin.location.model.q)localObject1).isStart = true;
      break;
      ((com.tencent.mm.plugin.location.model.q)localObject1).vmP.add(new WeakReference(localObject2));
    }
    label829:
    localObject2 = this.vtE;
    localObject1 = this.vmW;
    int i;
    if (!bu.isNullOrNil(this.vtK)) {
      if (this.vtK.equals("fromBanner"))
      {
        i = 0;
        ae.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[] { localObject1 });
        ((com.tencent.mm.plugin.location.model.q)localObject2).vmW = ((String)localObject1);
        localObject2 = v.aAC();
        if (!((String)localObject1).contains("@chatroom")) {
          break label1014;
        }
      }
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.location.model.a.b((String)localObject1);
      ((bsk)((com.tencent.mm.plugin.location.model.a.b)localObject1).rr.hQD.hQJ).Scene = i;
      com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)localObject1, 0);
      AppMethodBeat.o(56127);
      return;
      if (!this.vtK.equals("fromPluginLocation"))
      {
        if (this.vtK.equals("fromPluginTalk"))
        {
          i = 2;
          break;
        }
        if (this.vtK.equals("fromTrackButton"))
        {
          i = 3;
          break;
        }
        if (this.vtK.equals("fromMessage"))
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
  
  public final boolean djW()
  {
    return true;
  }
  
  public final void dkn()
  {
    AppMethodBeat.i(56138);
    super.dkn();
    if (this.vtD != null)
    {
      this.vtD.vqs = false;
      this.vtD.oa(false);
      this.vtB.djv();
    }
    AppMethodBeat.o(56138);
  }
  
  protected final void dko()
  {
    AppMethodBeat.i(56139);
    super.dko();
    com.tencent.mm.plugin.report.service.g.yxI.f(10997, new Object[] { "1", "", Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(56139);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(56136);
    com.tencent.mm.plugin.report.service.g.yxI.f(10997, new Object[] { "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.vtF.djL();
    AppMethodBeat.o(56136);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56126);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.ShareMapUI", "onCreate");
    this.vtL = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.IvT.c(this.pmW);
    AppMethodBeat.o(56126);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56130);
    super.onDestroy();
    Object localObject = this.vtE;
    q.b localb = this.vtN;
    Iterator localIterator = ((com.tencent.mm.plugin.location.model.q)localObject).vmP.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((q.b)localWeakReference.get()).equals(localb))) {
        ((com.tencent.mm.plugin.location.model.q)localObject).vmP.remove(localWeakReference);
      }
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.pmW);
    this.vtE.vmY = null;
    if (this.vtG != null)
    {
      localObject = this.vtG;
      ((i)localObject).vpV.b((com.tencent.mm.bh.d)localObject);
      localObject = ((i)localObject).vpI;
      ((VolumeMeter)localObject).vqF.removeCallbacks((Runnable)localObject);
      ((VolumeMeter)localObject).vqF.post(((VolumeMeter)localObject).vqT);
    }
    if (this.vtD != null) {
      this.vtD.destroy();
    }
    if (this.vtB != null)
    {
      localObject = this.vtB;
      com.tencent.mm.modelgeo.d.aIh().c(((MyLocationButton)localObject).fHp);
    }
    ae.i("MicroMsg.ShareMapUI", "onDestory");
    AppMethodBeat.o(56130);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56129);
    ae.i("MicroMsg.ShareMapUI", "pause");
    super.onPause();
    this.wakeLock.release();
    com.tencent.mm.plugin.location.model.q localq = this.vtE;
    ae.d("MicorMsg.TrackRefreshManager", "pause isShared:" + localq.vmT);
    if (!localq.vmT)
    {
      localq.hTg.c(localq.fHp);
      localq.vmO.b(localq.vnd);
      localq.vmU = true;
      localq.vna = true;
    }
    localq = this.vtE;
    com.tencent.mm.plugin.k.d locald = this.vrf.voa;
    localq.vmV = localq.vmQ;
    localq.vmQ = 0;
    ae.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + localq.vmV);
    if (localq.djq())
    {
      localq.vlC = (locald.getMapCenterX() * 1.0D / 1000000.0D);
      localq.vlD = (locald.getMapCenterY() * 1.0D / 1000000.0D);
      localq.vlE = locald.getZoom();
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(10997, new Object[] { "17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.vtL) });
    this.vtL = System.currentTimeMillis();
    if (this.vtI != null) {
      this.vtI.c(this.fHp);
    }
    if (this.vtD != null) {
      this.vtD.onPause();
    }
    AppMethodBeat.o(56129);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56128);
    ae.i("MicroMsg.ShareMapUI", "resume");
    super.onResume();
    this.wakeLock.acquire();
    com.tencent.mm.plugin.location.model.q localq = this.vtE;
    ae.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + localq.vmU);
    if (localq.vmU)
    {
      localq.vnb = System.currentTimeMillis();
      localq.hTg.a(localq.fHp);
      localq.vmO.a(localq.vnd);
    }
    localq.vmU = false;
    localq.djm();
    localq = this.vtE;
    com.tencent.mm.plugin.k.d locald = this.vrf.voa;
    localq.vmQ = localq.vmV;
    ae.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + localq.vmQ + " %f %f %d ", new Object[] { Double.valueOf(localq.vlC), Double.valueOf(localq.vlD), Integer.valueOf(localq.vlE) });
    if ((localq.vlC != -1000.0D) && (localq.vlD != -1000.0D) && (localq.vlE != -1))
    {
      locald.getIController().setCenter(localq.vlC, localq.vlD);
      locald.getIController().setZoom(localq.vlE);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.vtB.setAnimToSelf(false);
        this.vtB.djv();
        this.vtD.vqs = false;
        this.vtD.vqm = true;
      }
      localq = this.vtE;
      locald = this.vrf.voa;
      if (localq.vmZ != -1) {
        locald.getIController().setZoom(localq.vmZ);
      }
      if (this.vtI != null) {
        this.vtI.a(this.fHp);
      }
      if (this.vtD != null) {
        this.vtD.onResume();
      }
      AppMethodBeat.o(56128);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h
 * JD-Core Version:    0.7.0.1
 */