package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.model.o.a;
import com.tencent.mm.plugin.location.model.o.b;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.ShareHeader;
import com.tencent.mm.plugin.location.ui.TipSayingWidget;
import com.tencent.mm.plugin.location.ui.VolumeMeter;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location.ui.m.a;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.protocal.c.bfb;
import com.tencent.mm.protocal.c.ccg;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.c.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class g
  extends i
  implements l.a
{
  private com.tencent.mm.modelgeo.a.a dig = new g.4(this);
  private View lFY;
  private m.a lHt = new g.1(this);
  private Button lJS;
  MyLocationButton lJT;
  private TipSayingWidget lJU;
  com.tencent.mm.plugin.location.ui.m lJV;
  o lJW = com.tencent.mm.plugin.location.model.l.bdX();
  com.tencent.mm.plugin.location.ui.l lJX;
  k lJY;
  private com.tencent.mm.plugin.location.ui.i lJZ;
  private com.tencent.mm.modelgeo.c lKa = com.tencent.mm.modelgeo.c.Ob();
  private ShareHeader lKb;
  private String lKc;
  private long lKd = 0L;
  private long lKe = 0L;
  private o.b lKf = new g.2(this);
  private o.a lKg = new o.a()
  {
    public final void bei()
    {
      g localg = g.this;
      c.a locala = new c.a(localg.activity);
      locala.Iq(a.h.track_timeout);
      locala.Is(a.h.app_ok).a(new g.9(localg));
      locala.aoP().show();
    }
  };
  private HashMap<String, ccg> lKh = new HashMap();
  private PowerManager.WakeLock wakeLock;
  
  public g(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void beV()
  {
    XM();
    this.lJV.hk(false);
    this.lJW.stop();
    this.lJW.sY(3);
    k.beA();
    this.lJW.lEf = this.lIb.lFm.getZoom();
    this.activity.finish();
  }
  
  public final void beC()
  {
    this.lJW.lEf = this.lIb.lFm.getZoom();
    this.activity.finish();
  }
  
  public final void beD()
  {
    this.lJV.hk(false);
    this.lJW.stop();
    this.lJW.sY(0);
    k.beA();
    this.activity.finish();
  }
  
  protected final void beJ()
  {
    super.beJ();
  }
  
  final void beK()
  {
    super.beK();
    this.wakeLock = ((PowerManager)this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
    if (this.lKA != null)
    {
      localObject1 = this.lKA;
      ((n)localObject1).lHQ.setVisibility(4);
      ((n)localObject1).isVisible = false;
    }
    findViewById(a.e.header_bar).setVisibility(8);
    this.lJT = ((MyLocationButton)findViewById(a.e.locate_to_my_position));
    this.lJT.setProgressBar(this.lIb.lFm);
    this.lJT.ben();
    this.lJT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        g.this.lJT.ben();
        g.this.lJV.lHm = true;
        g.this.lJV.a(g.this.lIb.lFm);
        g.this.lJV.hj(false);
        h.nFQ.f(10997, new Object[] { "6", "", Integer.valueOf(0), Integer.valueOf(0) });
      }
    });
    this.lFY = findViewById(a.e.header_avatar_area);
    this.lKb = ((ShareHeader)findViewById(a.e.share_header));
    this.lKb.setVisibility(0);
    this.lJZ = new com.tencent.mm.plugin.location.ui.i(this.activity, this.lKb.getHeaderBar(), this.lFY, this.lEc, this.lIb.lFm);
    this.lJZ.lGe = new g.6(this);
    this.lJW.lEe = this.lKg;
    if (this.lJV == null) {
      this.lJV = new com.tencent.mm.plugin.location.ui.m(this.activity, this.lIb.lFm, true);
    }
    this.lJV.lHt = this.lHt;
    this.lJV.lHh = false;
    this.lJX = new com.tencent.mm.plugin.location.ui.l(this.activity, this);
    this.lJU = ((TipSayingWidget)findViewById(a.e.saying_tips));
    this.lJS = ((Button)findViewById(a.e.share_speak));
    this.lJS.setVisibility(0);
    this.lJY = new k(this.activity, this.lJS);
    this.lJY.lGQ = this.lJZ;
    this.lKb.setOnLeftClickListener(new g.7(this));
    this.lKb.setOnRightClickListener(new g.8(this));
    ((LocationManager)this.activity.getSystemService("location")).isProviderEnabled("gps");
    Object localObject1 = this.lJW;
    Object localObject2 = this.lHZ;
    ((o)localObject1).lEh = System.currentTimeMillis();
    ((o)localObject1).egs = com.tencent.mm.modelgeo.c.Ob();
    ((o)localObject1).egs.b(((o)localObject1).dig, true);
    if (((o)localObject1).lDU == null) {
      ((o)localObject1).lDU = com.tencent.mm.plugin.location.model.l.bdZ();
    }
    ((o)localObject1).lDU.a(((o)localObject1).lEj);
    if (localObject2 != null) {
      ((o)localObject1).lDY = ((LocationInfo)localObject2);
    }
    if (((o)localObject1).bSr)
    {
      y.i("MicorMsg.TrackRefreshManager", "start location " + ((o)localObject1).lDY.lCJ + " " + ((o)localObject1).lDY.lCK);
      localObject1 = this.lJW;
      localObject2 = this.lKf;
      Iterator localIterator = ((o)localObject1).lDV.iterator();
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
      this.lKc = this.activity.getIntent().getStringExtra("fromWhereShare");
      y.d("MicroMsg.ShareMapUI", "fromWhere=%s", new Object[] { this.lKc });
      if (!this.lJW.bec()) {
        break label817;
      }
      y.i("MicroMsg.ShareMapUI", "has join");
      this.lJV.hk(true);
      this.lJY.bex();
      return;
      ((o)localObject1).lDW = 1;
      ((o)localObject1).lDX = new ccg();
      ((o)localObject1).lDX.tRA = new bfb();
      ((o)localObject1).lDX.tRA.sDn = -1000.0D;
      ((o)localObject1).lDX.tRA.sDm = -1000.0D;
      y.i("MicorMsg.TrackRefreshManager", "start location imp " + ((o)localObject1).lDY.lCJ + " " + ((o)localObject1).lDY.lCK);
      com.tencent.mm.kernel.g.Dk().a(492, (f)localObject1);
      com.tencent.mm.kernel.g.Dk().a(490, (f)localObject1);
      com.tencent.mm.kernel.g.Dk().a(491, (f)localObject1);
      ((o)localObject1).byT = false;
      ((o)localObject1).bSr = true;
      break;
      ((o)localObject1).lDV.add(new WeakReference(localObject2));
    }
    label817:
    localObject2 = this.lJW;
    localObject1 = this.lEc;
    int i;
    if (!bk.bl(this.lKc)) {
      if (this.lKc.equals("fromBanner"))
      {
        i = 0;
        y.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[] { localObject1 });
        ((o)localObject2).lEc = ((String)localObject1);
        localObject2 = q.Gj();
        if (!((String)localObject1).contains("@chatroom")) {
          break label996;
        }
      }
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.location.model.a.b((String)localObject1);
      ((asf)((com.tencent.mm.plugin.location.model.a.b)localObject1).dmK.ecE.ecN).pyo = i;
      com.tencent.mm.kernel.g.Dk().a((com.tencent.mm.ah.m)localObject1, 0);
      return;
      if (!this.lKc.equals("fromPluginLocation"))
      {
        if (this.lKc.equals("fromPluginTalk"))
        {
          i = 2;
          break;
        }
        if (this.lKc.equals("fromTrackButton"))
        {
          i = 3;
          break;
        }
        if (this.lKc.equals("fromMessage"))
        {
          i = 4;
          break;
        }
      }
      i = 1;
      break;
      label996:
      if (((String)localObject2).compareTo((String)localObject1) > 0) {
        localObject1 = (String)localObject1 + (String)localObject2;
      } else {
        localObject1 = (String)localObject2 + (String)localObject1;
      }
    }
  }
  
  public final boolean beL()
  {
    return true;
  }
  
  public final void beW()
  {
    super.beW();
    if (this.lJV != null)
    {
      this.lJV.lHm = false;
      this.lJV.hj(false);
      this.lJT.beo();
    }
  }
  
  protected final void beX()
  {
    super.beX();
    h.nFQ.f(10997, new Object[] { "1", "", Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public final void onBackPressed()
  {
    h.nFQ.f(10997, new Object[] { "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.lJX.beB();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.ShareMapUI", "onCreate");
    this.lKd = System.currentTimeMillis();
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.lJW;
    o.b localb = this.lKf;
    Iterator localIterator = ((o)localObject).lDV.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((o.b)localWeakReference.get()).equals(localb))) {
        ((o)localObject).lDV.remove(localWeakReference);
      }
    }
    this.lJW.lEe = null;
    if (this.lJY != null)
    {
      localObject = this.lJY;
      ((k)localObject).lGP.b((com.tencent.mm.bf.d)localObject);
      localObject = ((k)localObject).lGC;
      ((VolumeMeter)localObject).lHv = true;
      ((VolumeMeter)localObject).eku = false;
      if (((VolumeMeter)localObject).lHz != null)
      {
        ((VolumeMeter)localObject).lHz.getLooper().quit();
        ((VolumeMeter)localObject).lHz = null;
      }
    }
    if (this.lJV != null) {
      this.lJV.destroy();
    }
    if (this.lJT != null)
    {
      localObject = this.lJT;
      com.tencent.mm.modelgeo.c.Ob().c(((MyLocationButton)localObject).dig);
    }
    y.i("MicroMsg.ShareMapUI", "onDestory");
  }
  
  public final void onPause()
  {
    y.i("MicroMsg.ShareMapUI", "pause");
    super.onPause();
    this.wakeLock.release();
    o localo = this.lJW;
    y.d("MicorMsg.TrackRefreshManager", "pause isShared:" + localo.lDZ);
    if (!localo.lDZ)
    {
      localo.egs.c(localo.dig);
      localo.lDU.b(localo.lEj);
      localo.lEa = true;
      localo.lEg = true;
    }
    localo = this.lJW;
    com.tencent.mm.plugin.p.d locald = this.lIb.lFm;
    localo.lEb = localo.lDW;
    localo.lDW = 0;
    y.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + localo.lEb);
    if (localo.beh())
    {
      localo.lCJ = (locald.getMapCenterX() * 1.0D / 1000000.0D);
      localo.lCK = (locald.getMapCenterY() * 1.0D / 1000000.0D);
      localo.lCL = locald.getZoom();
    }
    h.nFQ.f(10997, new Object[] { "17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.lKd) });
    this.lKd = System.currentTimeMillis();
    if (this.lKa != null) {
      this.lKa.c(this.dig);
    }
    if (this.lJV != null) {
      this.lJV.onPause();
    }
  }
  
  public final void onResume()
  {
    y.i("MicroMsg.ShareMapUI", "resume");
    super.onResume();
    this.wakeLock.acquire();
    o localo = this.lJW;
    y.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + localo.lEa);
    if (localo.lEa)
    {
      localo.lEh = System.currentTimeMillis();
      localo.egs.a(localo.dig);
      localo.lDU.a(localo.lEj);
    }
    localo.lEa = false;
    localo.bed();
    localo = this.lJW;
    com.tencent.mm.plugin.p.d locald = this.lIb.lFm;
    localo.lDW = localo.lEb;
    y.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + localo.lDW + " %f %f %d ", new Object[] { Double.valueOf(localo.lCJ), Double.valueOf(localo.lCK), Integer.valueOf(localo.lCL) });
    if ((localo.lCJ != -1000.0D) && (localo.lCK != -1000.0D) && (localo.lCL != -1))
    {
      locald.getIController().setCenter(localo.lCJ, localo.lCK);
      locald.getIController().setZoom(localo.lCL);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.lJT.setAnimToSelf(false);
        this.lJT.beo();
        this.lJV.lHm = false;
        this.lJV.lHg = true;
      }
      localo = this.lJW;
      locald = this.lIb.lFm;
      if (localo.lEf != -1) {
        locald.getIController().setZoom(localo.lEf);
      }
      if (this.lKa != null) {
        this.lKa.a(this.dig);
      }
      if (this.lJV != null) {
        this.lJV.onResume();
      }
      return;
    }
  }
  
  public final void sZ(int paramInt)
  {
    if (paramInt == 0)
    {
      h.nFQ.f(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      beV();
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        h.nFQ.f(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
        beV();
        return;
      }
    } while (paramInt != 2);
    beV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g
 * JD-Core Version:    0.7.0.1
 */