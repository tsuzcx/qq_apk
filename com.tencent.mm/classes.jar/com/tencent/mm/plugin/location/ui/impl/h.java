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
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.bh.c;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.a.zj.a;
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
import com.tencent.mm.plugin.location.ui.g.a;
import com.tencent.mm.plugin.location.ui.j;
import com.tencent.mm.plugin.location.ui.j.5;
import com.tencent.mm.plugin.location.ui.j.a;
import com.tencent.mm.plugin.location.ui.k.a;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.eox;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
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
  private b.a gmA;
  private IListener qCu;
  private PowerManager.WakeLock wakeLock;
  private View yIU;
  private k.a yKp;
  private q.b yNA;
  private q.a yNB;
  private HashMap<String, eox> yNC;
  private Button yNn;
  MyLocationButton yNo;
  private TipSayingWidget yNp;
  com.tencent.mm.plugin.location.ui.k yNq;
  com.tencent.mm.plugin.location.model.q yNr;
  j yNs;
  com.tencent.mm.plugin.location.ui.i yNt;
  private com.tencent.mm.plugin.location.ui.g yNu;
  private com.tencent.mm.modelgeo.d yNv;
  private ShareHeader yNw;
  private String yNx;
  private long yNy;
  private long yNz;
  
  public h(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56125);
    this.yNy = 0L;
    this.yNz = 0L;
    this.yKp = new k.a() {};
    this.yNA = new q.b()
    {
      public final void a(dmb paramAnonymousdmb)
      {
        AppMethodBeat.i(56114);
        h.a(h.this, paramAnonymousdmb);
        AppMethodBeat.o(56114);
      }
      
      public final void edc()
      {
        AppMethodBeat.i(56113);
        Log.i("MicroMsg.ShareMapUI", "onJoinSucess");
        com.tencent.mm.plugin.location.model.q localq = h.this.yNr;
        localq.yGL = true;
        localq.ecZ();
        localq.eda();
        h.this.yNq.qJ(true);
        if (h.this.yNt != null) {
          h.this.yNt.edt();
        }
        AppMethodBeat.o(56113);
      }
      
      public final void edd()
      {
        AppMethodBeat.i(56116);
        h.this.yNq.qJ(false);
        h.this.yNr.stop();
        h.this.yNr.Px(3);
        com.tencent.mm.plugin.location.ui.i.edv();
        h.this.activity.finish();
        h.this.activity.overridePendingTransition(2130772131, 2130772133);
        AppMethodBeat.o(56116);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(56115);
        Log.v("MicroMsg.ShareMapUI", "onError type %d msg %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.CyF.a(10997, new Object[] { "7", "", Integer.valueOf(0), Integer.valueOf(0) });
        j localj = h.this.yNs;
        Log.d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", new Object[] { paramAnonymousString });
        Context localContext = MMApplicationContext.getContext();
        Object localObject = null;
        if (Util.isNullOrNil(paramAnonymousString)) {
          if (paramAnonymousInt == 0) {
            paramAnonymousString = localContext.getString(2131762459);
          }
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.a(localj.mContext, paramAnonymousString, "", localj.mResources.getString(2131755921), false, new j.5(localj, paramAnonymousInt));
          AppMethodBeat.o(56115);
          return;
          if (paramAnonymousInt == 1)
          {
            paramAnonymousString = localContext.getString(2131762465);
          }
          else
          {
            paramAnonymousString = localObject;
            if (paramAnonymousInt == 2) {
              paramAnonymousString = localContext.getString(2131762466);
            }
          }
        }
      }
    };
    this.yNB = new q.a()
    {
      public final void bTS()
      {
        AppMethodBeat.i(56117);
        h localh = h.this;
        d.a locala = new d.a(localh.activity);
        locala.aoS(2131766880);
        locala.aoV(2131755921).c(new h.2(localh));
        locala.hbn().show();
        AppMethodBeat.o(56117);
      }
    };
    this.gmA = new b.a()
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
        if ((f.v(paramAnonymousDouble1)) && (!h.this.yNq.yKf))
        {
          Log.d("MicroMsg.ShareMapUI", "set driving mode");
          h.this.yNq.yKi = false;
          h.this.yNq.qI(true);
          h.this.yNo.edg();
        }
        AppMethodBeat.o(56118);
        return true;
      }
    };
    this.qCu = new IListener()
    {
      private boolean a(zj paramAnonymouszj)
      {
        AppMethodBeat.i(56119);
        if (!com.tencent.mm.kernel.g.aAc())
        {
          AppMethodBeat.o(56119);
          return false;
        }
        if (paramAnonymouszj.efx.dKy == 3)
        {
          h.this.yNq.qJ(false);
          h.this.yNr.stop();
          h.this.yNr.Px(2);
          com.tencent.mm.plugin.location.ui.i.edv();
          h.this.activity.finish();
        }
        AppMethodBeat.o(56119);
        return true;
      }
    };
    this.yNC = new HashMap();
    this.yNr = n.ecR();
    this.yNv = com.tencent.mm.modelgeo.d.bca();
    AppMethodBeat.o(56125);
  }
  
  private void edX()
  {
    AppMethodBeat.i(56133);
    hideVKB();
    this.yNq.qJ(false);
    this.yNr.stop();
    this.yNr.Px(3);
    com.tencent.mm.plugin.location.ui.i.edv();
    this.yNr.yGQ = this.yKV.yHR.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56133);
  }
  
  public final void Py(int paramInt)
  {
    AppMethodBeat.i(56135);
    if (paramInt == 0)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      edX();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      edX();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 2) {
      edX();
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
  
  protected final void edF()
  {
    AppMethodBeat.i(56131);
    super.edF();
    AppMethodBeat.o(56131);
  }
  
  final void edG()
  {
    AppMethodBeat.i(56127);
    super.edG();
    this.wakeLock = ((PowerManager)this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
    if (this.yOl != null)
    {
      localObject1 = this.yOl;
      ((l)localObject1).yKN.setVisibility(4);
      ((l)localObject1).isVisible = false;
    }
    findViewById(2131302279).setVisibility(8);
    this.yNo = ((MyLocationButton)findViewById(2131303726));
    this.yNo.setProgressBar(this.yKV.yHR);
    this.yNo.edf();
    this.yNo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56121);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/location/ui/impl/ShareMapUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        h.this.yNo.edf();
        h.this.yNq.yKi = true;
        h.this.yNq.a(h.this.yKV.yHR);
        h.this.yNq.qI(false);
        com.tencent.mm.plugin.report.service.h.CyF.a(10997, new Object[] { "6", "", Integer.valueOf(0), Integer.valueOf(0) });
        a.a(this, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56121);
      }
    });
    this.yIU = findViewById(2131302278);
    this.yNw = ((ShareHeader)findViewById(2131307808));
    this.yNw.setVisibility(0);
    this.yNu = new com.tencent.mm.plugin.location.ui.g(this.activity, this.yNw.getHeaderBar(), this.yIU, this.rgD, this.yKV.yHR);
    this.yNu.yJb = new g.a()
    {
      public final void aDg(String paramAnonymousString)
      {
        AppMethodBeat.i(56122);
        Object localObject = (TrackPoint)h.this.yKV.yHR.getViewByItag(paramAnonymousString);
        if (localObject != null)
        {
          ((TrackPoint)localObject).set2Top();
          h.this.yKV.yHR.invalidate();
          localObject = h.this.yNq;
          if (Util.isNullOrNil(paramAnonymousString)) {
            break label234;
          }
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).yGJ == null) || (!paramAnonymousString.equals(((com.tencent.mm.plugin.location.ui.k)localObject).yGJ.Username))) {
            break label150;
          }
          paramAnonymousString = new com.tencent.mm.plugin.location.model.d(((com.tencent.mm.plugin.location.ui.k)localObject).yGJ.NmV.KUt, ((com.tencent.mm.plugin.location.ui.k)localObject).yGJ.NmV.KUu);
        }
        for (;;)
        {
          if (paramAnonymousString != null) {
            h.this.yKV.yHR.getIController().animateTo(paramAnonymousString.yFu, paramAnonymousString.yFv);
          }
          AppMethodBeat.o(56122);
          return;
          label150:
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).yJX != null) && (((com.tencent.mm.plugin.location.ui.k)localObject).yJX.size() > 0))
          {
            localObject = ((com.tencent.mm.plugin.location.ui.k)localObject).yJX.iterator();
            for (;;)
            {
              if (((Iterator)localObject).hasNext())
              {
                eox localeox = (eox)((Iterator)localObject).next();
                if (localeox.Username.equals(paramAnonymousString))
                {
                  paramAnonymousString = new com.tencent.mm.plugin.location.model.d(localeox.NmV.KUt, localeox.NmV.KUu);
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
    this.yNr.yGP = this.yNB;
    if (this.yNq == null) {
      this.yNq = new com.tencent.mm.plugin.location.ui.k(this.activity, this.yKV.yHR, true);
    }
    this.yNq.yKp = this.yKp;
    this.yNq.yKd = false;
    this.yNs = new j(this.activity, this);
    this.yNp = ((TipSayingWidget)findViewById(2131307226));
    this.yNn = ((Button)findViewById(2131307821));
    this.yNn.setVisibility(0);
    this.yNt = new com.tencent.mm.plugin.location.ui.i(this.activity, this.yNn);
    this.yNt.yJM = this.yNu;
    this.yNw.setOnLeftClickListener(new h.9(this));
    this.yNw.setOnRightClickListener(new h.10(this));
    ((LocationManager)this.activity.getSystemService("location")).isProviderEnabled("gps");
    Object localObject1 = this.yNr;
    Object localObject2 = this.lXk;
    ((com.tencent.mm.plugin.location.model.q)localObject1).yGS = System.currentTimeMillis();
    ((com.tencent.mm.plugin.location.model.q)localObject1).iOv = com.tencent.mm.modelgeo.d.bca();
    ((com.tencent.mm.plugin.location.model.q)localObject1).iOv.b(((com.tencent.mm.plugin.location.model.q)localObject1).gmA, true);
    if (((com.tencent.mm.plugin.location.model.q)localObject1).yGG == null) {
      ((com.tencent.mm.plugin.location.model.q)localObject1).yGG = n.ecT();
    }
    ((com.tencent.mm.plugin.location.model.q)localObject1).yGG.a(((com.tencent.mm.plugin.location.model.q)localObject1).yGU);
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.location.model.q)localObject1).yGK = ((LocationInfo)localObject2);
    }
    if (((com.tencent.mm.plugin.location.model.q)localObject1).isStart)
    {
      Log.i("MicorMsg.TrackRefreshManager", "start location " + ((com.tencent.mm.plugin.location.model.q)localObject1).yGK.yFu + " " + ((com.tencent.mm.plugin.location.model.q)localObject1).yGK.yFv);
      localObject1 = this.yNr;
      localObject2 = this.yNA;
      Iterator localIterator = ((com.tencent.mm.plugin.location.model.q)localObject1).yGH.iterator();
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
      this.yNx = this.activity.getIntent().getStringExtra("fromWhereShare");
      Log.d("MicroMsg.ShareMapUI", "fromWhere=%s", new Object[] { this.yNx });
      if (!this.yNr.ecV()) {
        break label829;
      }
      Log.i("MicroMsg.ShareMapUI", "has join");
      this.yNq.qJ(true);
      this.yNt.edt();
      AppMethodBeat.o(56127);
      return;
      ((com.tencent.mm.plugin.location.model.q)localObject1).yGI = 1;
      ((com.tencent.mm.plugin.location.model.q)localObject1).yGJ = new eox();
      ((com.tencent.mm.plugin.location.model.q)localObject1).yGJ.NmV = new ddj();
      ((com.tencent.mm.plugin.location.model.q)localObject1).yGJ.NmV.KUu = -1000.0D;
      ((com.tencent.mm.plugin.location.model.q)localObject1).yGJ.NmV.KUt = -1000.0D;
      Log.i("MicorMsg.TrackRefreshManager", "start location imp " + ((com.tencent.mm.plugin.location.model.q)localObject1).yGK.yFu + " " + ((com.tencent.mm.plugin.location.model.q)localObject1).yGK.yFv);
      com.tencent.mm.kernel.g.azz().a(492, (com.tencent.mm.ak.i)localObject1);
      com.tencent.mm.kernel.g.azz().a(490, (com.tencent.mm.ak.i)localObject1);
      com.tencent.mm.kernel.g.azz().a(491, (com.tencent.mm.ak.i)localObject1);
      ((com.tencent.mm.plugin.location.model.q)localObject1).isTimeout = false;
      ((com.tencent.mm.plugin.location.model.q)localObject1).isStart = true;
      break;
      ((com.tencent.mm.plugin.location.model.q)localObject1).yGH.add(new WeakReference(localObject2));
    }
    label829:
    localObject2 = this.yNr;
    localObject1 = this.rgD;
    int i;
    if (!Util.isNullOrNil(this.yNx)) {
      if (this.yNx.equals("fromBanner"))
      {
        i = 0;
        Log.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[] { localObject1 });
        ((com.tencent.mm.plugin.location.model.q)localObject2).rgD = ((String)localObject1);
        localObject2 = z.aTY();
        if (!((String)localObject1).contains("@chatroom")) {
          break label1014;
        }
      }
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.location.model.a.b((String)localObject1);
      ((cfe)((com.tencent.mm.plugin.location.model.a.b)localObject1).rr.iLK.iLR).Scene = i;
      com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject1, 0);
      AppMethodBeat.o(56127);
      return;
      if (!this.yNx.equals("fromPluginLocation"))
      {
        if (this.yNx.equals("fromPluginTalk"))
        {
          i = 2;
          break;
        }
        if (this.yNx.equals("fromTrackButton"))
        {
          i = 3;
          break;
        }
        if (this.yNx.equals("fromMessage"))
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
  
  public final boolean edH()
  {
    return true;
  }
  
  public final void edY()
  {
    AppMethodBeat.i(56138);
    super.edY();
    if (this.yNq != null)
    {
      this.yNq.yKi = false;
      this.yNq.qI(false);
      this.yNo.edg();
    }
    AppMethodBeat.o(56138);
  }
  
  protected final void edZ()
  {
    AppMethodBeat.i(56139);
    super.edZ();
    com.tencent.mm.plugin.report.service.h.CyF.a(10997, new Object[] { "1", "", Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(56139);
  }
  
  public final void edx()
  {
    AppMethodBeat.i(56132);
    this.yNr.yGQ = this.yKV.yHR.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56132);
  }
  
  public final void edy()
  {
    AppMethodBeat.i(56134);
    this.yNq.qJ(false);
    this.yNr.stop();
    this.yNr.Px(0);
    com.tencent.mm.plugin.location.ui.i.edv();
    this.activity.finish();
    AppMethodBeat.o(56134);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(56136);
    com.tencent.mm.plugin.report.service.h.CyF.a(10997, new Object[] { "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.yNs.edw();
    AppMethodBeat.o(56136);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56126);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.ShareMapUI", "onCreate");
    this.yNy = System.currentTimeMillis();
    EventCenter.instance.addListener(this.qCu);
    AppMethodBeat.o(56126);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56130);
    super.onDestroy();
    Object localObject = this.yNr;
    q.b localb = this.yNA;
    Iterator localIterator = ((com.tencent.mm.plugin.location.model.q)localObject).yGH.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((q.b)localWeakReference.get()).equals(localb))) {
        ((com.tencent.mm.plugin.location.model.q)localObject).yGH.remove(localWeakReference);
      }
    }
    EventCenter.instance.removeListener(this.qCu);
    this.yNr.yGP = null;
    if (this.yNt != null)
    {
      localObject = this.yNt;
      ((com.tencent.mm.plugin.location.ui.i)localObject).yJL.b((com.tencent.mm.bh.d)localObject);
      localObject = ((com.tencent.mm.plugin.location.ui.i)localObject).yJy;
      ((VolumeMeter)localObject).yKv.removeCallbacks((Runnable)localObject);
      ((VolumeMeter)localObject).yKv.post(((VolumeMeter)localObject).yKJ);
    }
    if (this.yNq != null) {
      this.yNq.destroy();
    }
    if (this.yNo != null)
    {
      localObject = this.yNo;
      com.tencent.mm.modelgeo.d.bca().c(((MyLocationButton)localObject).gmA);
    }
    Log.i("MicroMsg.ShareMapUI", "onDestory");
    AppMethodBeat.o(56130);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56129);
    Log.i("MicroMsg.ShareMapUI", "pause");
    super.onPause();
    this.wakeLock.release();
    com.tencent.mm.plugin.location.model.q localq = this.yNr;
    Log.d("MicorMsg.TrackRefreshManager", "pause isShared:" + localq.yGL);
    if (!localq.yGL)
    {
      localq.iOv.c(localq.gmA);
      localq.yGG.b(localq.yGU);
      localq.yGM = true;
      localq.yGR = true;
    }
    localq = this.yNr;
    com.tencent.mm.plugin.k.d locald = this.yKV.yHR;
    localq.yGN = localq.yGI;
    localq.yGI = 0;
    Log.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + localq.yGN);
    if (localq.edb())
    {
      localq.yFu = (locald.getMapCenterX() * 1.0D / 1000000.0D);
      localq.yFv = (locald.getMapCenterY() * 1.0D / 1000000.0D);
      localq.yFw = locald.getZoom();
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(10997, new Object[] { "17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.yNy) });
    this.yNy = System.currentTimeMillis();
    if (this.yNv != null) {
      this.yNv.c(this.gmA);
    }
    if (this.yNq != null) {
      this.yNq.onPause();
    }
    AppMethodBeat.o(56129);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56128);
    Log.i("MicroMsg.ShareMapUI", "resume");
    super.onResume();
    this.wakeLock.acquire();
    com.tencent.mm.plugin.location.model.q localq = this.yNr;
    Log.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + localq.yGM);
    if (localq.yGM)
    {
      localq.yGS = System.currentTimeMillis();
      localq.iOv.a(localq.gmA);
      localq.yGG.a(localq.yGU);
    }
    localq.yGM = false;
    localq.ecX();
    localq = this.yNr;
    com.tencent.mm.plugin.k.d locald = this.yKV.yHR;
    localq.yGI = localq.yGN;
    Log.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + localq.yGI + " %f %f %d ", new Object[] { Double.valueOf(localq.yFu), Double.valueOf(localq.yFv), Integer.valueOf(localq.yFw) });
    if ((localq.yFu != -1000.0D) && (localq.yFv != -1000.0D) && (localq.yFw != -1))
    {
      locald.getIController().setCenter(localq.yFu, localq.yFv);
      locald.getIController().setZoom(localq.yFw);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.yNo.setAnimToSelf(false);
        this.yNo.edg();
        this.yNq.yKi = false;
        this.yNq.yKc = true;
      }
      localq = this.yNr;
      locald = this.yKV.yHR;
      if (localq.yGQ != -1) {
        locald.getIController().setZoom(localq.yGQ);
      }
      if (this.yNv != null) {
        this.yNv.a(this.gmA);
      }
      if (this.yNq != null) {
        this.yNq.onResume();
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