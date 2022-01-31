package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.r;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.model.o.a;
import com.tencent.mm.plugin.location.model.o.b;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.ShareHeader;
import com.tencent.mm.plugin.location.ui.TipSayingWidget;
import com.tencent.mm.plugin.location.ui.VolumeMeter;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.l.5;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location.ui.m.a;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class g
  extends i
  implements l.a
{
  private b.a dZA;
  private com.tencent.mm.sdk.b.c kSY;
  private View odl;
  private m.a oeG;
  private Button ohg;
  MyLocationButton ohh;
  private TipSayingWidget ohi;
  com.tencent.mm.plugin.location.ui.m ohj;
  o ohk;
  com.tencent.mm.plugin.location.ui.l ohl;
  k ohm;
  private com.tencent.mm.plugin.location.ui.i ohn;
  private com.tencent.mm.modelgeo.d oho;
  private ShareHeader ohp;
  private String ohq;
  private long ohr;
  private long ohs;
  private o.b oht;
  private o.a ohu;
  private HashMap<String, cpm> ohv;
  private PowerManager.WakeLock wakeLock;
  
  public g(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(113679);
    this.ohr = 0L;
    this.ohs = 0L;
    this.oeG = new g.1(this);
    this.oht = new o.b()
    {
      public final void a(bsz paramAnonymousbsz)
      {
        AppMethodBeat.i(113669);
        g.a(g.this, paramAnonymousbsz);
        AppMethodBeat.o(113669);
      }
      
      public final void bLC()
      {
        AppMethodBeat.i(113668);
        ab.i("MicroMsg.ShareMapUI", "onJoinSucess");
        o localo = g.this.ohk;
        localo.obm = true;
        localo.bLz();
        localo.bLA();
        g.this.ohj.iU(true);
        if (g.this.ohm != null) {
          g.this.ohm.bLR();
        }
        AppMethodBeat.o(113668);
      }
      
      public final void bLD()
      {
        AppMethodBeat.i(113671);
        g.this.ohj.iU(false);
        g.this.ohk.stop();
        g.this.ohk.yb(3);
        k.bLT();
        g.this.activity.finish();
        g.this.activity.overridePendingTransition(2131034229, 2131034231);
        AppMethodBeat.o(113671);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(113670);
        ab.v("MicroMsg.ShareMapUI", "onError type %d msg %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.qsU.e(10997, new Object[] { "7", "", Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.plugin.location.ui.l locall = g.this.ohl;
        ab.d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", new Object[] { paramAnonymousString });
        Context localContext = ah.getContext();
        Object localObject = null;
        if (bo.isNullOrNil(paramAnonymousString)) {
          if (paramAnonymousInt == 0) {
            paramAnonymousString = localContext.getString(2131301095);
          }
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.a(locall.mContext, paramAnonymousString, "", locall.mResources.getString(2131297018), false, new l.5(locall, paramAnonymousInt));
          AppMethodBeat.o(113670);
          return;
          if (paramAnonymousInt == 1)
          {
            paramAnonymousString = localContext.getString(2131301100);
          }
          else
          {
            paramAnonymousString = localObject;
            if (paramAnonymousInt == 2) {
              paramAnonymousString = localContext.getString(2131301101);
            }
          }
        }
      }
    };
    this.ohu = new g.4(this);
    this.dZA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(113673);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(113673);
          return false;
        }
        ab.d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble1) });
        if ((com.tencent.mm.plugin.location.model.f.w(paramAnonymousDouble1)) && (!g.this.ohj.oew))
        {
          ab.d("MicroMsg.ShareMapUI", "set driving mode");
          g.this.ohj.oez = false;
          g.this.ohj.iT(true);
          g.this.ohh.bLH();
        }
        AppMethodBeat.o(113673);
        return true;
      }
    };
    this.kSY = new g.6(this);
    this.ohv = new HashMap();
    this.ohk = com.tencent.mm.plugin.location.model.l.bLr();
    this.oho = com.tencent.mm.modelgeo.d.agQ();
    AppMethodBeat.o(113679);
  }
  
  private void bMr()
  {
    AppMethodBeat.i(113687);
    hideVKB();
    this.ohj.iU(false);
    this.ohk.stop();
    this.ohk.yb(3);
    k.bLT();
    this.ohk.obs = this.ofo.ocA.getZoom();
    this.activity.finish();
    AppMethodBeat.o(113687);
  }
  
  public final void bLV()
  {
    AppMethodBeat.i(113686);
    this.ohk.obs = this.ofo.ocA.getZoom();
    this.activity.finish();
    AppMethodBeat.o(113686);
  }
  
  public final void bLW()
  {
    AppMethodBeat.i(113688);
    this.ohj.iU(false);
    this.ohk.stop();
    this.ohk.yb(0);
    k.bLT();
    this.activity.finish();
    AppMethodBeat.o(113688);
  }
  
  protected final void bMd()
  {
    AppMethodBeat.i(113685);
    super.bMd();
    AppMethodBeat.o(113685);
  }
  
  final void bMe()
  {
    AppMethodBeat.i(113681);
    super.bMe();
    this.wakeLock = ((PowerManager)this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
    if (this.ohS != null)
    {
      localObject1 = this.ohS;
      ((n)localObject1).ofc.setVisibility(4);
      ((n)localObject1).isVisible = false;
    }
    findViewById(2131826116).setVisibility(8);
    this.ohh = ((MyLocationButton)findViewById(2131824806));
    this.ohh.setProgressBar(this.ofo.ocA);
    this.ohh.bLG();
    this.ohh.setOnClickListener(new g.7(this));
    this.odl = findViewById(2131827760);
    this.ohp = ((ShareHeader)findViewById(2131824816));
    this.ohp.setVisibility(0);
    this.ohn = new com.tencent.mm.plugin.location.ui.i(this.activity, this.ohp.getHeaderBar(), this.odl, this.obp, this.ofo.ocA);
    this.ohn.odr = new g.8(this);
    this.ohk.obr = this.ohu;
    if (this.ohj == null) {
      this.ohj = new com.tencent.mm.plugin.location.ui.m(this.activity, this.ofo.ocA, true);
    }
    this.ohj.oeG = this.oeG;
    this.ohj.oeu = false;
    this.ohl = new com.tencent.mm.plugin.location.ui.l(this.activity, this);
    this.ohi = ((TipSayingWidget)findViewById(2131824812));
    this.ohg = ((Button)findViewById(2131828629));
    this.ohg.setVisibility(0);
    this.ohm = new k(this.activity, this.ohg);
    this.ohm.oed = this.ohn;
    this.ohp.setOnLeftClickListener(new g.9(this));
    this.ohp.setOnRightClickListener(new g.10(this));
    ((LocationManager)this.activity.getSystemService("location")).isProviderEnabled("gps");
    Object localObject1 = this.ohk;
    Object localObject2 = this.ofm;
    ((o)localObject1).obu = System.currentTimeMillis();
    ((o)localObject1).fwu = com.tencent.mm.modelgeo.d.agQ();
    ((o)localObject1).fwu.b(((o)localObject1).dZA, true);
    if (((o)localObject1).obg == null) {
      ((o)localObject1).obg = com.tencent.mm.plugin.location.model.l.bLt();
    }
    ((o)localObject1).obg.a(((o)localObject1).obw);
    if (localObject2 != null) {
      ((o)localObject1).obl = ((LocationInfo)localObject2);
    }
    if (((o)localObject1).isStart)
    {
      ab.i("MicorMsg.TrackRefreshManager", "start location " + ((o)localObject1).obl.nZV + " " + ((o)localObject1).obl.nZW);
      localObject1 = this.ohk;
      localObject2 = this.oht;
      Iterator localIterator = ((o)localObject1).obh.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((localWeakReference == null) || (localWeakReference.get() == null) || (!((o.b)localWeakReference.get()).equals(localObject2)));
    }
    for (;;)
    {
      this.ohq = this.activity.getIntent().getStringExtra("fromWhereShare");
      ab.d("MicroMsg.ShareMapUI", "fromWhere=%s", new Object[] { this.ohq });
      if (!this.ohk.bLv()) {
        break label829;
      }
      ab.i("MicroMsg.ShareMapUI", "has join");
      this.ohj.iU(true);
      this.ohm.bLR();
      AppMethodBeat.o(113681);
      return;
      ((o)localObject1).obi = 1;
      ((o)localObject1).obk = new cpm();
      ((o)localObject1).obk.xYw = new bmx();
      ((o)localObject1).obk.xYw.wyP = -1000.0D;
      ((o)localObject1).obk.xYw.wyO = -1000.0D;
      ab.i("MicorMsg.TrackRefreshManager", "start location imp " + ((o)localObject1).obl.nZV + " " + ((o)localObject1).obl.nZW);
      com.tencent.mm.kernel.g.Rc().a(492, (com.tencent.mm.ai.f)localObject1);
      com.tencent.mm.kernel.g.Rc().a(490, (com.tencent.mm.ai.f)localObject1);
      com.tencent.mm.kernel.g.Rc().a(491, (com.tencent.mm.ai.f)localObject1);
      ((o)localObject1).caV = false;
      ((o)localObject1).isStart = true;
      break;
      ((o)localObject1).obh.add(new WeakReference(localObject2));
    }
    label829:
    localObject2 = this.ohk;
    localObject1 = this.obp;
    int i;
    if (!bo.isNullOrNil(this.ohq)) {
      if (this.ohq.equals("fromBanner"))
      {
        i = 0;
        ab.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[] { localObject1 });
        ((o)localObject2).obp = ((String)localObject1);
        localObject2 = r.Zn();
        if (!((String)localObject1).contains("@chatroom")) {
          break label1014;
        }
      }
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.location.model.a.b((String)localObject1);
      ((ayg)((com.tencent.mm.plugin.location.model.a.b)localObject1).rr.fsV.fta).Scene = i;
      com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject1, 0);
      AppMethodBeat.o(113681);
      return;
      if (!this.ohq.equals("fromPluginLocation"))
      {
        if (this.ohq.equals("fromPluginTalk"))
        {
          i = 2;
          break;
        }
        if (this.ohq.equals("fromTrackButton"))
        {
          i = 3;
          break;
        }
        if (this.ohq.equals("fromMessage"))
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
  
  public final boolean bMf()
  {
    return true;
  }
  
  public final void bMs()
  {
    AppMethodBeat.i(113692);
    super.bMs();
    if (this.ohj != null)
    {
      this.ohj.oez = false;
      this.ohj.iT(false);
      this.ohh.bLH();
    }
    AppMethodBeat.o(113692);
  }
  
  protected final void bMt()
  {
    AppMethodBeat.i(113693);
    super.bMt();
    com.tencent.mm.plugin.report.service.h.qsU.e(10997, new Object[] { "1", "", Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(113693);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113691);
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113691);
    return bool;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(113690);
    com.tencent.mm.plugin.report.service.h.qsU.e(10997, new Object[] { "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.ohl.bLU();
    AppMethodBeat.o(113690);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113680);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.ShareMapUI", "onCreate");
    this.ohr = System.currentTimeMillis();
    a.ymk.c(this.kSY);
    AppMethodBeat.o(113680);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113684);
    super.onDestroy();
    Object localObject = this.ohk;
    o.b localb = this.oht;
    Iterator localIterator = ((o)localObject).obh.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((o.b)localWeakReference.get()).equals(localb))) {
        ((o)localObject).obh.remove(localWeakReference);
      }
    }
    a.ymk.d(this.kSY);
    this.ohk.obr = null;
    if (this.ohm != null)
    {
      localObject = this.ohm;
      ((k)localObject).oec.b((com.tencent.mm.bg.d)localObject);
      localObject = ((k)localObject).odP;
      ((VolumeMeter)localObject).oeI = true;
      ((VolumeMeter)localObject).fAK = false;
      if (((VolumeMeter)localObject).oeM != null)
      {
        ((VolumeMeter)localObject).oeM.getLooper().quit();
        ((VolumeMeter)localObject).oeM = null;
      }
    }
    if (this.ohj != null) {
      this.ohj.destroy();
    }
    if (this.ohh != null)
    {
      localObject = this.ohh;
      com.tencent.mm.modelgeo.d.agQ().c(((MyLocationButton)localObject).dZA);
    }
    ab.i("MicroMsg.ShareMapUI", "onDestory");
    AppMethodBeat.o(113684);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(113683);
    ab.i("MicroMsg.ShareMapUI", "pause");
    super.onPause();
    this.wakeLock.release();
    o localo = this.ohk;
    ab.d("MicorMsg.TrackRefreshManager", "pause isShared:" + localo.obm);
    if (!localo.obm)
    {
      localo.fwu.c(localo.dZA);
      localo.obg.b(localo.obw);
      localo.obn = true;
      localo.obt = true;
    }
    localo = this.ohk;
    com.tencent.mm.plugin.k.d locald = this.ofo.ocA;
    localo.obo = localo.obi;
    localo.obi = 0;
    ab.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + localo.obo);
    if (localo.bLB())
    {
      localo.nZV = (locald.getMapCenterX() * 1.0D / 1000000.0D);
      localo.nZW = (locald.getMapCenterY() * 1.0D / 1000000.0D);
      localo.nZX = locald.getZoom();
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(10997, new Object[] { "17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.ohr) });
    this.ohr = System.currentTimeMillis();
    if (this.oho != null) {
      this.oho.c(this.dZA);
    }
    if (this.ohj != null) {
      this.ohj.onPause();
    }
    AppMethodBeat.o(113683);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(113682);
    ab.i("MicroMsg.ShareMapUI", "resume");
    super.onResume();
    this.wakeLock.acquire();
    o localo = this.ohk;
    ab.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + localo.obn);
    if (localo.obn)
    {
      localo.obu = System.currentTimeMillis();
      localo.fwu.a(localo.dZA);
      localo.obg.a(localo.obw);
    }
    localo.obn = false;
    localo.bLx();
    localo = this.ohk;
    com.tencent.mm.plugin.k.d locald = this.ofo.ocA;
    localo.obi = localo.obo;
    ab.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + localo.obi + " %f %f %d ", new Object[] { Double.valueOf(localo.nZV), Double.valueOf(localo.nZW), Integer.valueOf(localo.nZX) });
    if ((localo.nZV != -1000.0D) && (localo.nZW != -1000.0D) && (localo.nZX != -1))
    {
      locald.getIController().setCenter(localo.nZV, localo.nZW);
      locald.getIController().setZoom(localo.nZX);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.ohh.setAnimToSelf(false);
        this.ohh.bLH();
        this.ohj.oez = false;
        this.ohj.oet = true;
      }
      localo = this.ohk;
      locald = this.ofo.ocA;
      if (localo.obs != -1) {
        locald.getIController().setZoom(localo.obs);
      }
      if (this.oho != null) {
        this.oho.a(this.dZA);
      }
      if (this.ohj != null) {
        this.ohj.onResume();
      }
      AppMethodBeat.o(113682);
      return;
    }
  }
  
  public final void yc(int paramInt)
  {
    AppMethodBeat.i(113689);
    if (paramInt == 0)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      bMr();
      AppMethodBeat.o(113689);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      bMr();
      AppMethodBeat.o(113689);
      return;
    }
    if (paramInt == 2) {
      bMr();
    }
    AppMethodBeat.o(113689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g
 * JD-Core Version:    0.7.0.1
 */