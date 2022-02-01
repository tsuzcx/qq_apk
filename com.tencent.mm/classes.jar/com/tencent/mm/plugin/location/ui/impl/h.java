package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.SubCoreLocation;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.model.o.a;
import com.tencent.mm.plugin.location.model.o.b;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.ShareHeader;
import com.tencent.mm.plugin.location.ui.TipSayingWidget;
import com.tencent.mm.plugin.location.ui.VolumeMeter;
import com.tencent.mm.plugin.location.ui.g;
import com.tencent.mm.plugin.location.ui.g.a;
import com.tencent.mm.plugin.location.ui.i;
import com.tencent.mm.plugin.location.ui.j;
import com.tencent.mm.plugin.location.ui.j.3;
import com.tencent.mm.plugin.location.ui.j.4;
import com.tencent.mm.plugin.location.ui.j.a;
import com.tencent.mm.plugin.location.ui.k.a;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.protocal.protobuf.fvj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.sensitive.d.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class h
  extends k
  implements j.a
{
  private View Kfw;
  private k.a KgO;
  private Button KjR;
  private MyLocationButton KjS;
  private TipSayingWidget KjT;
  private com.tencent.mm.plugin.location.ui.k KjU;
  private o KjV;
  private j KjW;
  private i KjX;
  private g KjY;
  private com.tencent.mm.modelgeo.d KjZ;
  private ShareHeader Kka;
  private String Kkb;
  private long Kkc;
  private long Kkd;
  private o.b Kke;
  private o.a Kkf;
  private HashMap<String, fvj> Kkg;
  private b.a lsF;
  private PowerManager.WakeLock wakeLock;
  private IListener xeK;
  
  public h(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56125);
    this.Kkc = 0L;
    this.Kkd = 0L;
    this.KgO = new k.a() {};
    this.Kke = new o.b()
    {
      public final void a(eor paramAnonymouseor)
      {
        AppMethodBeat.i(56114);
        h.a(h.this, paramAnonymouseor);
        AppMethodBeat.o(56114);
      }
      
      public final void fUN()
      {
        AppMethodBeat.i(56113);
        Log.i("MicroMsg.ShareMapUI", "onJoinSucess");
        o localo = h.b(h.this);
        localo.Kdo = true;
        localo.fUK();
        localo.fUL();
        h.a(h.this).xX(true);
        if (h.c(h.this) != null) {
          h.c(h.this).fVf();
        }
        AppMethodBeat.o(56113);
      }
      
      public final void fUO()
      {
        AppMethodBeat.i(56116);
        h.a(h.this).xX(false);
        h.b(h.this).stop();
        h.b(h.this).ZC(3);
        h.c(h.this);
        i.fVi();
        h.this.activity.finish();
        h.this.activity.overridePendingTransition(com.tencent.mm.plugin.map.a.a.push_empty_out, com.tencent.mm.plugin.map.a.a.push_up_out);
        AppMethodBeat.o(56116);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(56115);
        Log.v("MicroMsg.ShareMapUI", "onError type %d msg %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.OAn.b(10997, new Object[] { "7", "", Integer.valueOf(0), Integer.valueOf(0) });
        h.a(h.this, paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(56115);
      }
    };
    this.Kkf = new o.a()
    {
      public final void onTimeout()
      {
        AppMethodBeat.i(56117);
        h.d(h.this);
        AppMethodBeat.o(56117);
      }
    };
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(264991);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(264991);
          return false;
        }
        Log.d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", new Object[] { Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1), Double.valueOf(paramAnonymousDouble1) });
        if ((com.tencent.mm.plugin.location.model.f.P(paramAnonymousDouble1)) && (!h.a(h.this).KgE))
        {
          Log.d("MicroMsg.ShareMapUI", "set driving mode");
          h.a(h.this).KgH = false;
          h.a(h.this).xW(true);
          h.e(h.this).fUS();
        }
        AppMethodBeat.o(264991);
        return true;
      }
    };
    this.xeK = new ShareMapUI.5(this, com.tencent.mm.app.f.hfK);
    this.Kkg = new HashMap();
    this.KjV = SubCoreLocation.fUB();
    this.KjZ = com.tencent.mm.modelgeo.d.bJl();
    AppMethodBeat.o(56125);
  }
  
  private void fVL()
  {
    AppMethodBeat.i(56133);
    hideVKB();
    this.KjU.xX(false);
    this.KjV.stop();
    this.KjV.ZC(3);
    i.fVi();
    this.KjV.Kdt = this.Khu.Ket.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56133);
  }
  
  public final void ZD(int paramInt)
  {
    AppMethodBeat.i(56135);
    if (paramInt == 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      fVL();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(10997, new Object[] { "8", "", Integer.valueOf(0), Integer.valueOf(0) });
      fVL();
      AppMethodBeat.o(56135);
      return;
    }
    if (paramInt == 2) {
      fVL();
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
  
  public final void fVM()
  {
    AppMethodBeat.i(56138);
    super.fVM();
    if (this.KjU != null)
    {
      this.KjU.KgH = false;
      this.KjU.xW(false);
      this.KjS.fUS();
    }
    AppMethodBeat.o(56138);
  }
  
  protected final void fVN()
  {
    AppMethodBeat.i(56139);
    super.fVN();
    com.tencent.mm.plugin.report.service.h.OAn.b(10997, new Object[] { "1", "", Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(56139);
  }
  
  public final void fVk()
  {
    AppMethodBeat.i(56132);
    this.KjV.Kdt = this.Khu.Ket.getZoom();
    this.activity.finish();
    AppMethodBeat.o(56132);
  }
  
  public final void fVl()
  {
    AppMethodBeat.i(56134);
    this.KjU.xX(false);
    this.KjV.stop();
    this.KjV.ZC(0);
    i.fVi();
    this.activity.finish();
    AppMethodBeat.o(56134);
  }
  
  protected final void fVt()
  {
    AppMethodBeat.i(56131);
    super.fVt();
    AppMethodBeat.o(56131);
  }
  
  final void fVu()
  {
    AppMethodBeat.i(56127);
    super.fVu();
    this.wakeLock = ((PowerManager)this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
    if (this.KkP != null)
    {
      localObject1 = this.KkP;
      ((l)localObject1).Khm.setVisibility(4);
      ((l)localObject1).isVisible = false;
    }
    findViewById(a.e.header_bar).setVisibility(8);
    this.KjS = ((MyLocationButton)findViewById(a.e.locate_to_my_position));
    this.KjS.setProgressBar(this.Khu.Ket);
    this.KjS.fUR();
    this.KjS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56121);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/location/ui/impl/ShareMapUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        h.e(h.this).fUR();
        h.a(h.this).KgH = true;
        h.a(h.this).a(h.this.Khu.Ket);
        h.a(h.this).xW(false);
        com.tencent.mm.plugin.report.service.h.OAn.b(10997, new Object[] { "6", "", Integer.valueOf(0), Integer.valueOf(0) });
        a.a(this, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56121);
      }
    });
    this.Kfw = findViewById(a.e.header_avatar_area);
    this.Kka = ((ShareHeader)findViewById(a.e.share_header));
    this.Kka.setVisibility(0);
    this.KjY = new g(this.activity, this.Kka.getHeaderBar(), this.Kfw, this.mpr, this.Khu.Ket);
    this.KjY.KfC = new g.a()
    {
      public final void aKl(String paramAnonymousString)
      {
        AppMethodBeat.i(56122);
        Object localObject = (TrackPoint)h.this.Khu.Ket.getViewByItag(paramAnonymousString);
        if (localObject != null)
        {
          ((TrackPoint)localObject).set2Top();
          h.this.Khu.Ket.invalidate();
          localObject = h.a(h.this);
          if (Util.isNullOrNil(paramAnonymousString)) {
            break label234;
          }
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).Kdm == null) || (!paramAnonymousString.equals(((com.tencent.mm.plugin.location.ui.k)localObject).Kdm.Username))) {
            break label150;
          }
          paramAnonymousString = new com.tencent.mm.plugin.location.model.d(((com.tencent.mm.plugin.location.ui.k)localObject).Kdm.abTG.YTc, ((com.tencent.mm.plugin.location.ui.k)localObject).Kdm.abTG.YTd);
        }
        for (;;)
        {
          if (paramAnonymousString != null) {
            h.this.Khu.Ket.getIController().animateTo(paramAnonymousString.KbW, paramAnonymousString.KbX);
          }
          AppMethodBeat.o(56122);
          return;
          label150:
          if ((((com.tencent.mm.plugin.location.ui.k)localObject).Kgy != null) && (((com.tencent.mm.plugin.location.ui.k)localObject).Kgy.size() > 0))
          {
            localObject = ((com.tencent.mm.plugin.location.ui.k)localObject).Kgy.iterator();
            for (;;)
            {
              if (((Iterator)localObject).hasNext())
              {
                fvj localfvj = (fvj)((Iterator)localObject).next();
                if (localfvj.Username.equals(paramAnonymousString))
                {
                  paramAnonymousString = new com.tencent.mm.plugin.location.model.d(localfvj.abTG.YTc, localfvj.abTG.YTd);
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
    this.KjV.Kds = this.Kkf;
    if (this.KjU == null) {
      this.KjU = new com.tencent.mm.plugin.location.ui.k(this.activity, this.Khu.Ket, true);
    }
    this.KjU.KgO = this.KgO;
    this.KjU.KgD = false;
    this.KjW = new j(this.activity, this);
    this.KjT = ((TipSayingWidget)findViewById(a.e.saying_tips));
    this.KjR = ((Button)findViewById(a.e.share_speak));
    this.KjR.setVisibility(0);
    this.KjX = new i(this.activity, this.KjR);
    this.KjX.Kgn = this.KjY;
    this.Kka.setOnLeftClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56123);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/location/ui/impl/ShareMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = h.f(h.this);
        com.tencent.mm.ui.base.k.b(paramAnonymousView.mContext, paramAnonymousView.mResources.getString(a.i.location_sharing_end_tips), "", paramAnonymousView.mResources.getString(a.i.app_endshare), paramAnonymousView.mResources.getString(a.i.app_cancel), new j.3(paramAnonymousView), new j.4(paramAnonymousView));
        a.a(this, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56123);
      }
    });
    this.Kka.setOnRightClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(56124);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/location/ui/impl/ShareMapUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.plugin.report.service.h.OAn.b(10997, new Object[] { "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        h.f(h.this).fjO();
        a.a(this, "com/tencent/mm/plugin/location/ui/impl/ShareMapUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(56124);
      }
    });
    Object localObject1 = this.KjV;
    Object localObject2 = this.sai;
    ((o)localObject1).Kdv = System.currentTimeMillis();
    ((o)localObject1).owr = com.tencent.mm.modelgeo.d.bJl();
    ((o)localObject1).owr.a(((o)localObject1).lsF, true);
    if (((o)localObject1).Kdj == null) {
      ((o)localObject1).Kdj = SubCoreLocation.fUD();
    }
    ((o)localObject1).Kdj.a(((o)localObject1).Kdx);
    if (localObject2 != null) {
      ((o)localObject1).Kdn = ((LocationInfo)localObject2);
    }
    if (((o)localObject1).isStart)
    {
      Log.i("MicorMsg.TrackRefreshManager", "start location " + ((o)localObject1).Kdn.KbW + " " + ((o)localObject1).Kdn.KbX);
      localObject1 = this.KjV;
      localObject2 = this.Kke;
      Iterator localIterator = ((o)localObject1).Kdk.iterator();
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
      this.Kkb = this.activity.getIntent().getStringExtra("fromWhereShare");
      Log.d("MicroMsg.ShareMapUI", "fromWhere=%s", new Object[] { this.Kkb });
      if (!this.KjV.fUG()) {
        break label809;
      }
      Log.i("MicroMsg.ShareMapUI", "has join");
      this.KjU.xX(true);
      this.KjX.fVf();
      AppMethodBeat.o(56127);
      return;
      ((o)localObject1).Kdl = 1;
      ((o)localObject1).Kdm = new fvj();
      ((o)localObject1).Kdm.abTG = new efn();
      ((o)localObject1).Kdm.abTG.YTd = -1000.0D;
      ((o)localObject1).Kdm.abTG.YTc = -1000.0D;
      Log.i("MicorMsg.TrackRefreshManager", "start location imp " + ((o)localObject1).Kdn.KbW + " " + ((o)localObject1).Kdn.KbX);
      com.tencent.mm.kernel.h.aZW().a(492, (com.tencent.mm.am.h)localObject1);
      com.tencent.mm.kernel.h.aZW().a(490, (com.tencent.mm.am.h)localObject1);
      com.tencent.mm.kernel.h.aZW().a(491, (com.tencent.mm.am.h)localObject1);
      ((o)localObject1).isTimeout = false;
      ((o)localObject1).isStart = true;
      break;
      ((o)localObject1).Kdk.add(new WeakReference(localObject2));
    }
    label809:
    int i;
    if (!((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).checkAndShowPermissionDialog(d.c.actu, new d.f()
    {
      public final void onOp(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(264989);
        if (paramAnonymousBoolean.booleanValue())
        {
          h.this.onBusinessPermissionGranted(d.c.actu.value);
          AppMethodBeat.o(264989);
          return;
        }
        h.this.onBusinessPermissionDenied(d.c.actu.value);
        AppMethodBeat.o(264989);
      }
    }))
    {
      localObject2 = this.KjV;
      localObject1 = this.mpr;
      if (Util.isNullOrNil(this.Kkb)) {
        break label1017;
      }
      if (!this.Kkb.equals("fromBanner")) {
        break label950;
      }
      i = 0;
      Log.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[] { localObject1 });
      ((o)localObject2).mpr = ((String)localObject1);
      localObject2 = z.bAM();
      if (!((String)localObject1).contains("@chatroom")) {
        break label1022;
      }
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.plugin.location.model.a.b((String)localObject1);
      ((det)c.b.b(((com.tencent.mm.plugin.location.model.a.b)localObject1).rr.otB)).IJG = i;
      com.tencent.mm.kernel.h.aZW().a((p)localObject1, 0);
      AppMethodBeat.o(56127);
      return;
      label950:
      if (!this.Kkb.equals("fromPluginLocation"))
      {
        if (this.Kkb.equals("fromPluginTalk"))
        {
          i = 2;
          break;
        }
        if (this.Kkb.equals("fromTrackButton"))
        {
          i = 3;
          break;
        }
        if (this.Kkb.equals("fromMessage"))
        {
          i = 4;
          break;
        }
      }
      label1017:
      i = 1;
      break;
      label1022:
      if (((String)localObject2).compareTo((String)localObject1) > 0) {
        localObject1 = (String)localObject1 + (String)localObject2;
      } else {
        localObject1 = (String)localObject2 + (String)localObject1;
      }
    }
  }
  
  public final boolean fVv()
  {
    return true;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(56136);
    com.tencent.mm.plugin.report.service.h.OAn.b(10997, new Object[] { "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.KjW.fjO();
    AppMethodBeat.o(56136);
  }
  
  public final void onBusinessPermissionDenied(String paramString)
  {
    AppMethodBeat.i(264988);
    fVl();
    AppMethodBeat.o(264988);
  }
  
  public final void onBusinessPermissionGranted(String paramString)
  {
    AppMethodBeat.i(264987);
    this.activity.recreate();
    AppMethodBeat.o(264987);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56126);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.ShareMapUI", "onCreate");
    this.Kkc = System.currentTimeMillis();
    this.xeK.alive();
    AppMethodBeat.o(56126);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56130);
    super.onDestroy();
    Object localObject = this.KjV;
    o.b localb = this.Kke;
    Iterator localIterator = ((o)localObject).Kdk.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((o.b)localWeakReference.get()).equals(localb))) {
        ((o)localObject).Kdk.remove(localWeakReference);
      }
    }
    this.xeK.dead();
    this.KjV.Kds = null;
    if (this.KjX != null)
    {
      localObject = this.KjX;
      ((i)localObject).activity = null;
      ((i)localObject).Kgm.b((com.tencent.mm.bc.d)localObject);
      localObject = ((i)localObject).KfZ;
      ((VolumeMeter)localObject).KgU.removeCallbacks((Runnable)localObject);
      ((VolumeMeter)localObject).KgU.post(((VolumeMeter)localObject).Khi);
    }
    if (this.KjU != null) {
      this.KjU.destroy();
    }
    if (this.KjS != null)
    {
      localObject = this.KjS;
      com.tencent.mm.modelgeo.d.bJl().a(((MyLocationButton)localObject).lsF);
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
    localObject = this.KjV;
    Log.d("MicorMsg.TrackRefreshManager", "pause isShared:" + ((o)localObject).Kdo);
    if (!((o)localObject).Kdo)
    {
      ((o)localObject).owr.a(((o)localObject).lsF);
      ((o)localObject).Kdj.b(((o)localObject).Kdx);
      ((o)localObject).Kdp = true;
      ((o)localObject).Kdu = true;
    }
    localObject = this.KjV;
    com.tencent.mm.plugin.p.d locald = this.Khu.Ket;
    ((o)localObject).Kdq = ((o)localObject).Kdl;
    ((o)localObject).Kdl = 0;
    Log.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + ((o)localObject).Kdq);
    if (((o)localObject).fUM())
    {
      ((o)localObject).KbW = (locald.getMapCenterX() * 1.0D / 1000000.0D);
      ((o)localObject).KbX = (locald.getMapCenterY() * 1.0D / 1000000.0D);
      ((o)localObject).KbY = locald.getZoom();
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(10997, new Object[] { "17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.Kkc) });
    this.Kkc = System.currentTimeMillis();
    if (this.KjZ != null) {
      this.KjZ.a(this.lsF);
    }
    if (this.KjU != null) {
      this.KjU.onPause();
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
    localObject = this.KjV;
    Log.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + ((o)localObject).Kdp);
    if (((o)localObject).Kdp)
    {
      ((o)localObject).Kdv = System.currentTimeMillis();
      ((o)localObject).owr.a(((o)localObject).lsF, true);
      ((o)localObject).Kdj.a(((o)localObject).Kdx);
    }
    ((o)localObject).Kdp = false;
    ((o)localObject).fUI();
    localObject = this.KjV;
    com.tencent.mm.plugin.p.d locald = this.Khu.Ket;
    ((o)localObject).Kdl = ((o)localObject).Kdq;
    Log.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + ((o)localObject).Kdl + " %f %f %d ", new Object[] { Double.valueOf(((o)localObject).KbW), Double.valueOf(((o)localObject).KbX), Integer.valueOf(((o)localObject).KbY) });
    if ((((o)localObject).KbW != -1000.0D) && (((o)localObject).KbX != -1000.0D) && (((o)localObject).KbY != -1))
    {
      locald.getIController().setCenter(((o)localObject).KbW, ((o)localObject).KbX);
      locald.getIController().setZoom(((o)localObject).KbY);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.KjS.setAnimToSelf(false);
        this.KjS.fUS();
        this.KjU.KgH = false;
        this.KjU.KgC = true;
      }
      localObject = this.KjV;
      locald = this.Khu.Ket;
      if (((o)localObject).Kdt != -1) {
        locald.getIController().setZoom(((o)localObject).Kdt);
      }
      if (this.KjZ != null) {
        this.KjZ.a(this.lsF, true);
      }
      if (this.KjU != null) {
        this.KjU.onResume();
      }
      AppMethodBeat.o(56128);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h
 * JD-Core Version:    0.7.0.1
 */