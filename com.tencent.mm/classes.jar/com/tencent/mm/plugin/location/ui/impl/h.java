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
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.t;
import com.tencent.mm.bj.c;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.aaq.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.q.a;
import com.tencent.mm.plugin.location.model.q.b;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.ShareHeader;
import com.tencent.mm.plugin.location.ui.TipSayingWidget;
import com.tencent.mm.plugin.location.ui.VolumeMeter;
import com.tencent.mm.plugin.location.ui.g;
import com.tencent.mm.plugin.location.ui.g.a;
import com.tencent.mm.plugin.location.ui.j;
import com.tencent.mm.plugin.location.ui.j.3;
import com.tencent.mm.plugin.location.ui.j.4;
import com.tencent.mm.plugin.location.ui.j.a;
import com.tencent.mm.plugin.location.ui.k.a;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dvt;
import com.tencent.mm.protocal.protobuf.ezh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class h
  extends k
  implements j.a
{
  private View EmN;
  private k.a Eoi;
  private HashMap<String, ezh> ErA;
  private Button Erl;
  private MyLocationButton Erm;
  private TipSayingWidget Ern;
  private com.tencent.mm.plugin.location.ui.k Ero;
  private com.tencent.mm.plugin.location.model.q Erp;
  private j Erq;
  private com.tencent.mm.plugin.location.ui.i Err;
  private g Ers;
  private com.tencent.mm.modelgeo.d Ert;
  private ShareHeader Eru;
  private String Erv;
  private long Erw;
  private long Erx;
  private q.b Ery;
  private q.a Erz;
  private b.a iQJ;
  private IListener ubt;
  private PowerManager.WakeLock wakeLock;
  
  public h(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56125);
    this.Erw = 0L;
    this.Erx = 0L;
    this.Eoi = new k.a() {};
    this.Ery = new q.b()
    {
      public final void a(dvt paramAnonymousdvt)
      {
        AppMethodBeat.i(56114);
        h.a(h.this, paramAnonymousdvt);
        AppMethodBeat.o(56114);
      }
      
      public final void eMv()
      {
        AppMethodBeat.i(56113);
        Log.i("MicroMsg.ShareMapUI", "onJoinSucess");
        com.tencent.mm.plugin.location.model.q localq = h.b(h.this);
        localq.EkF = true;
        localq.eMs();
        localq.eMt();
        h.a(h.this).tL(true);
        if (h.c(h.this) != null) {
          h.c(h.this).eMM();
        }
        AppMethodBeat.o(56113);
      }
      
      public final void eMw()
      {
        AppMethodBeat.i(56116);
        h.a(h.this).tL(false);
        h.b(h.this).stop();
        h.b(h.this).VG(3);
        h.c(h.this);
        com.tencent.mm.plugin.location.ui.i.eMP();
        h.this.activity.finish();
        h.this.activity.overridePendingTransition(com.tencent.mm.plugin.map.a.a.push_empty_out, com.tencent.mm.plugin.map.a.a.push_up_out);
        AppMethodBeat.o(56116);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(56115);
        Log.v("MicroMsg.ShareMapUI", "onError type %d msg %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.IzE.a(10997, new Object[] { "7", "", Integer.valueOf(0), Integer.valueOf(0) });
        h.a(h.this, paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(56115);
      }
    };
    this.Erz = new q.a()
    {
      public final void onTimeout()
      {
        AppMethodBeat.i(56117);
        h.d(h.this);
        AppMethodBeat.o(56117);
      }
    };
    this.iQJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(56118);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(56118);
          return false;
        }
        Log.d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble1) });
        if ((f.w(paramAnonymousDouble1)) && (!h.a(h.this).EnY))
        {
          Log.d("MicroMsg.ShareMapUI", "set driving mode");
          h.a(h.this).Eob = false;
          h.a(h.this).tK(true);
          h.e(h.this).eMz();
        }
        AppMethodBeat.o(56118);
        return true;
      }
    };
    this.ubt = new IListener()
    {
      private boolean a(aaq paramAnonymousaaq)
      {
        AppMethodBeat.i(56119);
        if (!com.tencent.mm.kernel.h.aHB())
        {
          AppMethodBeat.o(56119);
          return false;
        }
        if (paramAnonymousaaq.fZM.fDn == 3)
        {
          h.a(h.this).tL(false);
          h.b(h.this).stop();
          h.b(h.this).VG(2);
          h.c(h.this);
          com.tencent.mm.plugin.location.ui.i.eMP();
          h.this.activity.finish();
        }
        AppMethodBeat.o(56119);
        return true;
      }
    };
    this.ErA = new HashMap();
    this.Erp = n.eMj();
    this.Ert = com.tencent.mm.modelgeo.d.blq();
    AppMethodBeat.o(56125);
  }
  
  private void eNs()
  {
    AppMethodBeat.i(56133);
    hideVKB();
    this.Ero.tL(false);
    this.Erp.stop();
    this.Erp.VG(3);
    com.tencent.mm.plugin.location.ui.i.eMP();
    this.Erp.EkK = this.EoO.ElK.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56133);
  }
  
  public final void VH(int paramInt)
  {
    AppMethodBeat.i(56135);
    if (paramInt == 0)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      eNs();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      eNs();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 2) {
      eNs();
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
  
  public final void eMR()
  {
    AppMethodBeat.i(56132);
    this.Erp.EkK = this.EoO.ElK.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56132);
  }
  
  public final void eMS()
  {
    AppMethodBeat.i(56134);
    this.Ero.tL(false);
    this.Erp.stop();
    this.Erp.VG(0);
    com.tencent.mm.plugin.location.ui.i.eMP();
    this.activity.finish();
    AppMethodBeat.o(56134);
  }
  
  protected final void eNa()
  {
    AppMethodBeat.i(56131);
    super.eNa();
    AppMethodBeat.o(56131);
  }
  
  final void eNb()
  {
    AppMethodBeat.i(56127);
    super.eNb();
    this.wakeLock = ((PowerManager)this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
    if (this.Esj != null)
    {
      localObject1 = this.Esj;
      ((l)localObject1).EoG.setVisibility(4);
      ((l)localObject1).isVisible = false;
    }
    findViewById(a.e.header_bar).setVisibility(8);
    this.Erm = ((MyLocationButton)findViewById(a.e.locate_to_my_position));
    this.Erm.setProgressBar(this.EoO.ElK);
    this.Erm.eMy();
    this.Erm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56121);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/location/ui/impl/ShareMapUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        h.e(h.this).eMy();
        h.a(h.this).Eob = true;
        h.a(h.this).a(h.this.EoO.ElK);
        h.a(h.this).tK(false);
        com.tencent.mm.plugin.report.service.h.IzE.a(10997, new Object[] { "6", "", Integer.valueOf(0), Integer.valueOf(0) });
        a.a(this, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56121);
      }
    });
    this.EmN = findViewById(a.e.header_avatar_area);
    this.Eru = ((ShareHeader)findViewById(a.e.share_header));
    this.Eru.setVisibility(0);
    this.Ers = new g(this.activity, this.Eru.getHeaderBar(), this.EmN, this.uJM, this.EoO.ElK);
    this.Ers.EmU = new g.a()
    {
      public final void aNq(String paramAnonymousString)
      {
        AppMethodBeat.i(56122);
        Object localObject = (TrackPoint)h.this.EoO.ElK.getViewByItag(paramAnonymousString);
        if (localObject != null)
        {
          ((TrackPoint)localObject).set2Top();
          h.this.EoO.ElK.invalidate();
          localObject = h.a(h.this);
          if (Util.isNullOrNil(paramAnonymousString)) {
            break label234;
          }
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).EkD == null) || (!paramAnonymousString.equals(((com.tencent.mm.plugin.location.ui.k)localObject).EkD.Username))) {
            break label150;
          }
          paramAnonymousString = new com.tencent.mm.plugin.location.model.d(((com.tencent.mm.plugin.location.ui.k)localObject).EkD.UzK.RVy, ((com.tencent.mm.plugin.location.ui.k)localObject).EkD.UzK.RVz);
        }
        for (;;)
        {
          if (paramAnonymousString != null) {
            h.this.EoO.ElK.getIController().animateTo(paramAnonymousString.Ejn, paramAnonymousString.Ejo);
          }
          AppMethodBeat.o(56122);
          return;
          label150:
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).EnQ != null) && (((com.tencent.mm.plugin.location.ui.k)localObject).EnQ.size() > 0))
          {
            localObject = ((com.tencent.mm.plugin.location.ui.k)localObject).EnQ.iterator();
            for (;;)
            {
              if (((Iterator)localObject).hasNext())
              {
                ezh localezh = (ezh)((Iterator)localObject).next();
                if (localezh.Username.equals(paramAnonymousString))
                {
                  paramAnonymousString = new com.tencent.mm.plugin.location.model.d(localezh.UzK.RVy, localezh.UzK.RVz);
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
    this.Erp.EkJ = this.Erz;
    if (this.Ero == null) {
      this.Ero = new com.tencent.mm.plugin.location.ui.k(this.activity, this.EoO.ElK, true);
    }
    this.Ero.Eoi = this.Eoi;
    this.Ero.EnW = false;
    this.Erq = new j(this.activity, this);
    this.Ern = ((TipSayingWidget)findViewById(a.e.saying_tips));
    this.Erl = ((Button)findViewById(a.e.share_speak));
    this.Erl.setVisibility(0);
    this.Err = new com.tencent.mm.plugin.location.ui.i(this.activity, this.Erl);
    this.Err.EnF = this.Ers;
    this.Eru.setOnLeftClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56123);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/location/ui/impl/ShareMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = h.f(h.this);
        com.tencent.mm.ui.base.h.c(paramAnonymousView.mContext, paramAnonymousView.mResources.getString(a.i.location_sharing_end_tips), "", paramAnonymousView.mResources.getString(a.i.app_endshare), paramAnonymousView.mResources.getString(a.i.app_cancel), new j.3(paramAnonymousView), new j.4(paramAnonymousView));
        a.a(this, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56123);
      }
    });
    this.Eru.setOnRightClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56124);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/location/ui/impl/ShareMapUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.report.service.h.IzE.a(10997, new Object[] { "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        h.f(h.this).ehJ();
        a.a(this, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56124);
      }
    });
    ((LocationManager)this.activity.getSystemService("location")).isProviderEnabled("gps");
    Object localObject1 = this.Erp;
    Object localObject2 = this.oUV;
    ((com.tencent.mm.plugin.location.model.q)localObject1).EkM = System.currentTimeMillis();
    ((com.tencent.mm.plugin.location.model.q)localObject1).lEL = com.tencent.mm.modelgeo.d.blq();
    ((com.tencent.mm.plugin.location.model.q)localObject1).lEL.b(((com.tencent.mm.plugin.location.model.q)localObject1).iQJ, true);
    if (((com.tencent.mm.plugin.location.model.q)localObject1).EkA == null) {
      ((com.tencent.mm.plugin.location.model.q)localObject1).EkA = n.eMl();
    }
    ((com.tencent.mm.plugin.location.model.q)localObject1).EkA.a(((com.tencent.mm.plugin.location.model.q)localObject1).EkO);
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.location.model.q)localObject1).EkE = ((LocationInfo)localObject2);
    }
    if (((com.tencent.mm.plugin.location.model.q)localObject1).isStart)
    {
      Log.i("MicorMsg.TrackRefreshManager", "start location " + ((com.tencent.mm.plugin.location.model.q)localObject1).EkE.Ejn + " " + ((com.tencent.mm.plugin.location.model.q)localObject1).EkE.Ejo);
      localObject1 = this.Erp;
      localObject2 = this.Ery;
      Iterator localIterator = ((com.tencent.mm.plugin.location.model.q)localObject1).EkB.iterator();
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
      this.Erv = this.activity.getIntent().getStringExtra("fromWhereShare");
      Log.d("MicroMsg.ShareMapUI", "fromWhere=%s", new Object[] { this.Erv });
      if (!this.Erp.eMo()) {
        break label829;
      }
      Log.i("MicroMsg.ShareMapUI", "has join");
      this.Ero.tL(true);
      this.Err.eMM();
      AppMethodBeat.o(56127);
      return;
      ((com.tencent.mm.plugin.location.model.q)localObject1).EkC = 1;
      ((com.tencent.mm.plugin.location.model.q)localObject1).EkD = new ezh();
      ((com.tencent.mm.plugin.location.model.q)localObject1).EkD.UzK = new dmz();
      ((com.tencent.mm.plugin.location.model.q)localObject1).EkD.UzK.RVz = -1000.0D;
      ((com.tencent.mm.plugin.location.model.q)localObject1).EkD.UzK.RVy = -1000.0D;
      Log.i("MicorMsg.TrackRefreshManager", "start location imp " + ((com.tencent.mm.plugin.location.model.q)localObject1).EkE.Ejn + " " + ((com.tencent.mm.plugin.location.model.q)localObject1).EkE.Ejo);
      com.tencent.mm.kernel.h.aGY().a(492, (com.tencent.mm.an.i)localObject1);
      com.tencent.mm.kernel.h.aGY().a(490, (com.tencent.mm.an.i)localObject1);
      com.tencent.mm.kernel.h.aGY().a(491, (com.tencent.mm.an.i)localObject1);
      ((com.tencent.mm.plugin.location.model.q)localObject1).isTimeout = false;
      ((com.tencent.mm.plugin.location.model.q)localObject1).isStart = true;
      break;
      ((com.tencent.mm.plugin.location.model.q)localObject1).EkB.add(new WeakReference(localObject2));
    }
    label829:
    localObject2 = this.Erp;
    localObject1 = this.uJM;
    int i;
    if (!Util.isNullOrNil(this.Erv)) {
      if (this.Erv.equals("fromBanner"))
      {
        i = 0;
        Log.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[] { localObject1 });
        ((com.tencent.mm.plugin.location.model.q)localObject2).uJM = ((String)localObject1);
        localObject2 = z.bcZ();
        if (!((String)localObject1).contains("@chatroom")) {
          break label1014;
        }
      }
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.location.model.a.b((String)localObject1);
      ((cnz)d.b.b(((com.tencent.mm.plugin.location.model.a.b)localObject1).rr.lBR)).CPw = i;
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
      AppMethodBeat.o(56127);
      return;
      if (!this.Erv.equals("fromPluginLocation"))
      {
        if (this.Erv.equals("fromPluginTalk"))
        {
          i = 2;
          break;
        }
        if (this.Erv.equals("fromTrackButton"))
        {
          i = 3;
          break;
        }
        if (this.Erv.equals("fromMessage"))
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
  
  public final boolean eNc()
  {
    return true;
  }
  
  public final void eNt()
  {
    AppMethodBeat.i(56138);
    super.eNt();
    if (this.Ero != null)
    {
      this.Ero.Eob = false;
      this.Ero.tK(false);
      this.Erm.eMz();
    }
    AppMethodBeat.o(56138);
  }
  
  protected final void eNu()
  {
    AppMethodBeat.i(56139);
    super.eNu();
    com.tencent.mm.plugin.report.service.h.IzE.a(10997, new Object[] { "1", "", Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(56139);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(56136);
    com.tencent.mm.plugin.report.service.h.IzE.a(10997, new Object[] { "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.Erq.ehJ();
    AppMethodBeat.o(56136);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56126);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.ShareMapUI", "onCreate");
    this.Erw = System.currentTimeMillis();
    EventCenter.instance.addListener(this.ubt);
    AppMethodBeat.o(56126);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56130);
    super.onDestroy();
    Object localObject = this.Erp;
    q.b localb = this.Ery;
    Iterator localIterator = ((com.tencent.mm.plugin.location.model.q)localObject).EkB.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((q.b)localWeakReference.get()).equals(localb))) {
        ((com.tencent.mm.plugin.location.model.q)localObject).EkB.remove(localWeakReference);
      }
    }
    EventCenter.instance.removeListener(this.ubt);
    this.Erp.EkJ = null;
    if (this.Err != null)
    {
      localObject = this.Err;
      ((com.tencent.mm.plugin.location.ui.i)localObject).EnE.b((com.tencent.mm.bj.d)localObject);
      localObject = ((com.tencent.mm.plugin.location.ui.i)localObject).Enr;
      ((VolumeMeter)localObject).Eoo.removeCallbacks((Runnable)localObject);
      ((VolumeMeter)localObject).Eoo.post(((VolumeMeter)localObject).EoC);
    }
    if (this.Ero != null) {
      this.Ero.destroy();
    }
    if (this.Erm != null)
    {
      localObject = this.Erm;
      com.tencent.mm.modelgeo.d.blq().b(((MyLocationButton)localObject).iQJ);
    }
    Log.i("MicroMsg.ShareMapUI", "onDestory");
    AppMethodBeat.o(56130);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56129);
    Log.i("MicroMsg.ShareMapUI", "pause");
    super.onPause();
    Object localObject = this.wakeLock;
    a.b(localObject, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI", "onPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    ((PowerManager.WakeLock)localObject).release();
    a.c(localObject, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI", "onPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    localObject = this.Erp;
    Log.d("MicorMsg.TrackRefreshManager", "pause isShared:" + ((com.tencent.mm.plugin.location.model.q)localObject).EkF);
    if (!((com.tencent.mm.plugin.location.model.q)localObject).EkF)
    {
      ((com.tencent.mm.plugin.location.model.q)localObject).lEL.b(((com.tencent.mm.plugin.location.model.q)localObject).iQJ);
      ((com.tencent.mm.plugin.location.model.q)localObject).EkA.b(((com.tencent.mm.plugin.location.model.q)localObject).EkO);
      ((com.tencent.mm.plugin.location.model.q)localObject).EkG = true;
      ((com.tencent.mm.plugin.location.model.q)localObject).EkL = true;
    }
    localObject = this.Erp;
    com.tencent.mm.plugin.q.d locald = this.EoO.ElK;
    ((com.tencent.mm.plugin.location.model.q)localObject).EkH = ((com.tencent.mm.plugin.location.model.q)localObject).EkC;
    ((com.tencent.mm.plugin.location.model.q)localObject).EkC = 0;
    Log.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + ((com.tencent.mm.plugin.location.model.q)localObject).EkH);
    if (((com.tencent.mm.plugin.location.model.q)localObject).eMu())
    {
      ((com.tencent.mm.plugin.location.model.q)localObject).Ejn = (locald.getMapCenterX() * 1.0D / 1000000.0D);
      ((com.tencent.mm.plugin.location.model.q)localObject).Ejo = (locald.getMapCenterY() * 1.0D / 1000000.0D);
      ((com.tencent.mm.plugin.location.model.q)localObject).Ejp = locald.getZoom();
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(10997, new Object[] { "17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.Erw) });
    this.Erw = System.currentTimeMillis();
    if (this.Ert != null) {
      this.Ert.b(this.iQJ);
    }
    if (this.Ero != null) {
      this.Ero.onPause();
    }
    AppMethodBeat.o(56129);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56128);
    Log.i("MicroMsg.ShareMapUI", "resume");
    super.onResume();
    Object localObject = this.wakeLock;
    a.b(localObject, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI", "onResume", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    ((PowerManager.WakeLock)localObject).acquire();
    a.c(localObject, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI", "onResume", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    localObject = this.Erp;
    Log.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + ((com.tencent.mm.plugin.location.model.q)localObject).EkG);
    if (((com.tencent.mm.plugin.location.model.q)localObject).EkG)
    {
      ((com.tencent.mm.plugin.location.model.q)localObject).EkM = System.currentTimeMillis();
      ((com.tencent.mm.plugin.location.model.q)localObject).lEL.c(((com.tencent.mm.plugin.location.model.q)localObject).iQJ);
      ((com.tencent.mm.plugin.location.model.q)localObject).EkA.a(((com.tencent.mm.plugin.location.model.q)localObject).EkO);
    }
    ((com.tencent.mm.plugin.location.model.q)localObject).EkG = false;
    ((com.tencent.mm.plugin.location.model.q)localObject).eMq();
    localObject = this.Erp;
    com.tencent.mm.plugin.q.d locald = this.EoO.ElK;
    ((com.tencent.mm.plugin.location.model.q)localObject).EkC = ((com.tencent.mm.plugin.location.model.q)localObject).EkH;
    Log.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + ((com.tencent.mm.plugin.location.model.q)localObject).EkC + " %f %f %d ", new Object[] { Double.valueOf(((com.tencent.mm.plugin.location.model.q)localObject).Ejn), Double.valueOf(((com.tencent.mm.plugin.location.model.q)localObject).Ejo), Integer.valueOf(((com.tencent.mm.plugin.location.model.q)localObject).Ejp) });
    if ((((com.tencent.mm.plugin.location.model.q)localObject).Ejn != -1000.0D) && (((com.tencent.mm.plugin.location.model.q)localObject).Ejo != -1000.0D) && (((com.tencent.mm.plugin.location.model.q)localObject).Ejp != -1))
    {
      locald.getIController().setCenter(((com.tencent.mm.plugin.location.model.q)localObject).Ejn, ((com.tencent.mm.plugin.location.model.q)localObject).Ejo);
      locald.getIController().setZoom(((com.tencent.mm.plugin.location.model.q)localObject).Ejp);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.Erm.setAnimToSelf(false);
        this.Erm.eMz();
        this.Ero.Eob = false;
        this.Ero.EnV = true;
      }
      localObject = this.Erp;
      locald = this.EoO.ElK;
      if (((com.tencent.mm.plugin.location.model.q)localObject).EkK != -1) {
        locald.getIController().setZoom(((com.tencent.mm.plugin.location.model.q)localObject).EkK);
      }
      if (this.Ert != null) {
        this.Ert.c(this.iQJ);
      }
      if (this.Ero != null) {
        this.Ero.onResume();
      }
      AppMethodBeat.o(56128);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h
 * JD-Core Version:    0.7.0.1
 */