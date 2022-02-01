package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.d.b.c;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.model.h.a;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.a;
import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView.4;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect.a;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectUI
  extends MMActivity
  implements com.tencent.mm.plugin.facedetect.c.f, com.tencent.mm.plugin.facedetect.views.a
{
  private String fGM = null;
  private ServiceConnection mConnection = null;
  boolean qcs = false;
  private int rfF = -1;
  h rkV = null;
  private b rkW = null;
  private boolean rkX = false;
  private boolean rkY = false;
  private View rkZ = null;
  private com.tencent.mm.plugin.facedetect.c.a rkp = null;
  private a rkq = null;
  private FaceTutorial rkr = null;
  private String rkz;
  private RelativeLayout rla;
  FaceDetectView rlb = null;
  FaceScanRect rlc = null;
  private TextView rld = null;
  private Button rle = null;
  private FaceDetectProcessService rlf = null;
  private boolean rlg = false;
  private boolean rlh = false;
  private com.tencent.mm.plugin.facedetect.views.c rli = null;
  private PowerManager.WakeLock wakeLock = null;
  
  private void clc()
  {
    AppMethodBeat.i(103993);
    ad.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", new Object[] { Boolean.valueOf(this.rlg) });
    if (this.rlg)
    {
      ad.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
      d.a(this.mConnection, "tools");
      this.rlg = false;
    }
    AppMethodBeat.o(103993);
  }
  
  private void ctF()
  {
    AppMethodBeat.i(104007);
    ad.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
    b.b localb = this.rlb.getCurrentMotionCancelInfo();
    a(1, localb.errCode, localb.errMsg, null);
    AppMethodBeat.o(104007);
  }
  
  private void ctQ()
  {
    AppMethodBeat.i(104001);
    this.qcs = false;
    this.rlb.lt(false);
    ad.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
    AppMethodBeat.o(104001);
  }
  
  private void ctR()
  {
    AppMethodBeat.i(104002);
    ctQ();
    stopPreview();
    AppMethodBeat.o(104002);
  }
  
  private void f(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(104008);
    setResult(-1, g(paramInt1, paramInt2, paramString, paramBundle));
    AppMethodBeat.o(104008);
  }
  
  private static Intent g(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(104009);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_type", paramInt1);
    localBundle.putInt("err_code", paramInt2);
    localBundle.putString("err_msg", paramString);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramString = new Intent();
    paramString.putExtras(localBundle);
    AppMethodBeat.o(104009);
    return paramString;
  }
  
  private void stopPreview()
  {
    AppMethodBeat.i(104000);
    this.rkX = false;
    this.rlb.rnN.rnt.stopPreview();
    ad.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
    AppMethodBeat.o(104000);
  }
  
  private void v(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104004);
    ad.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt), paramString1 });
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    ctR();
    a(4, paramInt, paramString1, localBundle);
    AppMethodBeat.o(104004);
  }
  
  public final void DS(int paramInt)
  {
    AppMethodBeat.i(104006);
    if (paramInt == 1) {
      this.rlc.b(null);
    }
    AppMethodBeat.o(104006);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103998);
    ad.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (com.tencent.mm.plugin.facedetect.e.a.ctV().isStarted()) && (com.tencent.mm.plugin.facedetect.e.a.ctV().rmv)) {
      com.tencent.mm.plugin.facedetect.e.a.ctV().ctX();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.cth());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    f(paramInt1, paramInt2, paramString, localBundle);
    finish();
    AppMethodBeat.o(103998);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, c paramc)
  {
    AppMethodBeat.i(104003);
    if (paramBoolean1) {
      ctR();
    }
    if (paramBoolean2)
    {
      ad.i("MicroMsg.FaceDetectUI", "hy: need blur");
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103985);
          aj.getContext();
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103984);
              FaceDetectUI.j(FaceDetectUI.this).V(this.rll);
              AppMethodBeat.o(103984);
            }
          });
          AppMethodBeat.o(103985);
        }
      }, "FaceDetectUI_BlurBgMap");
    }
    this.rkq.a(paramc);
    AppMethodBeat.o(104003);
  }
  
  public final void csI()
  {
    AppMethodBeat.i(103996);
    ad.i("MicroMsg.FaceDetectUI", "alvinluo startFaceDetect ");
    Object localObject1 = getWindow().getAttributes();
    if (((WindowManager.LayoutParams)localObject1).screenBrightness < 0.9F)
    {
      ((WindowManager.LayoutParams)localObject1).screenBrightness = 0.9F;
      getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
    }
    this.rlc.roZ = FaceScanRect.a.rpc;
    localObject1 = this.rlc;
    if (((FaceScanRect)localObject1).roZ == FaceScanRect.a.rpa) {
      ad.w("MicroMsg.FaceScanRect", "hy: already opened");
    }
    for (;;)
    {
      this.rlb.rnO.rnI = false;
      this.rlc.setVisibility(0);
      ad.d("MicroMsg.FaceDetectUI", "alvinluo %d, %d, %d, %d", new Object[] { Integer.valueOf(this.rlc.getTop()), Integer.valueOf(this.rlc.getRight()), Integer.valueOf(this.rlc.getLeft()), Integer.valueOf(this.rlc.getBottom()) });
      this.rkX = true;
      this.qcs = false;
      this.rkW.reset();
      if (this.rkX)
      {
        this.rli = new com.tencent.mm.plugin.facedetect.views.c()
        {
          public final void DT(int paramAnonymousInt)
          {
            AppMethodBeat.i(103982);
            ad.i("MicroMsg.FaceDetectUI", "alvinluo onPreviewInitDone: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt == 0)
            {
              FaceDetectUI.f(FaceDetectUI.this);
              AppMethodBeat.o(103982);
              return;
            }
            if (paramAnonymousInt == 1)
            {
              FaceDetectUI.g(FaceDetectUI.this);
              AppMethodBeat.o(103982);
              return;
            }
            if (paramAnonymousInt == 2) {
              FaceDetectUI.a(FaceDetectUI.this, "camera permission not granted", FaceDetectUI.this.getString(2131761860));
            }
            AppMethodBeat.o(103982);
          }
        };
        ad.i("MicroMsg.FaceDetectUI", "hy: start preview");
        localObject1 = this.rli;
        localObject2 = this.rlb;
        ((FaceDetectView)localObject2).rnN.a(new FaceDetectView.4((FaceDetectView)localObject2, (com.tencent.mm.plugin.facedetect.views.c)localObject1));
      }
      AppMethodBeat.o(103996);
      return;
      ((FaceScanRect)localObject1).roY.setVisibility(0);
      ((FaceScanRect)localObject1).roH.setBackgroundResource(2131232165);
      ((FaceScanRect)localObject1).roY.startAnimation(((FaceScanRect)localObject1).roV);
      Object localObject2 = ((FaceScanRect)localObject1).roQ;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        localObject3.clearAnimation();
        localObject3.setBackgroundColor(((FaceScanRect)localObject1).getResources().getColor(2131101179));
        i += 1;
      }
      ((FaceScanRect)localObject1).roZ = FaceScanRect.a.rpa;
    }
  }
  
  public final void csK()
  {
    AppMethodBeat.i(103997);
    ad.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
    if (!this.rkY)
    {
      this.rli = null;
      this.rkY = true;
      if (this.rkW.rlq)
      {
        ctR();
        this.rlb.rnN.rnt.cue();
      }
      if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
      {
        this.wakeLock.release();
        this.wakeLock = null;
      }
      com.tencent.mm.sdk.g.b.c(new FaceDetectUI.2(this), "Face_active_gc");
    }
    clc();
    AppMethodBeat.o(103997);
  }
  
  public final void csN() {}
  
  final void ctP()
  {
    AppMethodBeat.i(103999);
    if (this.qcs)
    {
      ad.i("MicroMsg.FaceDetectUI", "hy: start capture face");
      FaceDetectView localFaceDetectView = this.rlb;
      Rect localRect = new Rect(this.rlc.getLeft(), this.rlc.getTop(), this.rlc.getRight(), this.rlc.getBottom());
      h.a locala = h.ctg();
      if (locala.type == 100)
      {
        AppMethodBeat.o(103999);
        return;
      }
      if (localFaceDetectView.rnS != null) {
        localFaceDetectView.rnS.ctv();
      }
      localFaceDetectView.hhJ = false;
      localFaceDetectView.isPaused = false;
      localFaceDetectView.rnY = bt.HI();
      localFaceDetectView.rnW = locala.rhu;
      localFaceDetectView.rnV = locala.jsG;
      ad.i("MicroMsg.FaceDetectView", "carson logic");
      ad.i("MicroMsg.FaceDetectView", "item.hintStr" + locala.jsG);
      localFaceDetectView.rhv = locala.rhv;
      localFaceDetectView.rnT = true;
      localFaceDetectView.rnX = locala.rhy;
      localFaceDetectView.rnS = b.c.a(locala);
      if (localFaceDetectView.rnS != null)
      {
        if (localFaceDetectView.rnP != null) {
          localFaceDetectView.rnP.removeAllViews();
        }
        if (localFaceDetectView.rnQ != null) {
          localFaceDetectView.rnQ.removeAllViews();
        }
        localFaceDetectView.rnS.a(localFaceDetectView.getContext(), localFaceDetectView.rnP, localFaceDetectView.rnQ);
        ad.d("MicroMsg.FaceDetectView", "mBusinessTip : " + localFaceDetectView.rkz);
        localFaceDetectView.rnS.setBusinessTip(localFaceDetectView.rkz);
      }
      if (localFaceDetectView.rnN != null) {
        localFaceDetectView.rnN.a(localRect, locala.rhs);
      }
      localFaceDetectView.rnU = false;
    }
    AppMethodBeat.o(103999);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public void finish()
  {
    AppMethodBeat.i(104011);
    ad.i("MicroMsg.FaceDetectUI", "alvinluo finish");
    if ((this.rkq != null) && (this.rkq.bni())) {
      this.rkq.dismiss();
    }
    if (this.rkr != null) {
      this.rkr.dismiss();
    }
    ad.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
    csK();
    super.finish();
    AppMethodBeat.o(104011);
  }
  
  public int getLayoutId()
  {
    return 2131493921;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(104012);
    ad.i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
    ctF();
    AppMethodBeat.o(104012);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103992);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    this.fGM = getIntent().getStringExtra("k_user_name");
    this.rfF = getIntent().getIntExtra("k_server_scene", -1);
    this.rkz = getIntent().getStringExtra("business_tips");
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    if (paramBundle != null) {
      FaceDetectReporter.cth().a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.facedetect.c.b.rgI;
    this.rkp = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.rfF, 0, getIntent().getExtras());
    p.am(this);
    this.rle = ((Button)findViewById(2131301383));
    this.rle.setOnClickListener(new FaceDetectUI.1(this));
    this.rkZ = findViewById(2131299667);
    this.rkZ.setVisibility(8);
    this.rla = ((RelativeLayout)findViewById(2131299684));
    this.rlc = ((FaceScanRect)findViewById(2131299683));
    this.rlb = ((FaceDetectView)findViewById(2131299682));
    this.rld = ((TextView)findViewById(2131299514));
    this.rlb.setCallback(this);
    this.rlb.setBusinessTip(this.rkz);
    paramBundle = this.rlb;
    RelativeLayout localRelativeLayout = this.rla;
    ViewGroup localViewGroup = this.rlc.getCenterHintHolder();
    paramBundle.rnP = localRelativeLayout;
    paramBundle.rnQ = localViewGroup;
    this.rlb.setErrTextView(this.rld);
    this.rlb.t(true, this.fGM);
    this.rlc.setOnRefreshRectListener(new FaceScanRect.b()
    {
      public final void ctS()
      {
        AppMethodBeat.i(103979);
        Object localObject = FaceDetectUI.c(FaceDetectUI.this);
        RectF localRectF = new RectF(FaceDetectUI.b(FaceDetectUI.this).getLeft(), FaceDetectUI.b(FaceDetectUI.this).getTop(), FaceDetectUI.b(FaceDetectUI.this).getRight(), FaceDetectUI.b(FaceDetectUI.this).getBottom());
        localObject = ((FaceDetectView)localObject).rnO;
        ((FaceDetectDecorView)localObject).rnJ = true;
        ((FaceDetectDecorView)localObject).rnK = true;
        ((FaceDetectDecorView)localObject).rnL = localRectF;
        ((FaceDetectDecorView)localObject).invalidate();
        AppMethodBeat.o(103979);
      }
    });
    this.rlc.setVisibility(4);
    this.rkW = new b((byte)0);
    AppMethodBeat.o(103992);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104010);
    ad.i("MicroMsg.FaceDetectUI", "hy: current %d instance not destroyed", new Object[] { Integer.valueOf(hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(104010);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(103994);
    super.onStart();
    ad.i("MicroMsg.FaceDetectUI", "alvinluo onStart");
    if (this.wakeLock == null) {
      this.wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(10, "Scan Lock");
    }
    if (!this.wakeLock.isHeld())
    {
      ad.i("MicroMsg.FaceDetectUI", "alvinluo acquire wakeLock");
      this.wakeLock.acquire();
    }
    Intent localIntent = new Intent(this, FaceDetectProcessService.class);
    localIntent.putExtra("key_face_service_connection_from", 2);
    this.mConnection = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(103980);
        ad.i("MicroMsg.FaceDetectUI", "alvinluo service connected %s", new Object[] { paramAnonymousComponentName });
        FaceDetectUI.a(FaceDetectUI.this, true);
        paramAnonymousComponentName = (FaceDetectProcessService.a)paramAnonymousIBinder;
        FaceDetectUI.a(FaceDetectUI.this, paramAnonymousComponentName.rjq);
        paramAnonymousComponentName = com.tencent.mm.plugin.facedetect.model.f.rhk;
        paramAnonymousIBinder = FaceDetectUI.d(FaceDetectUI.this);
        ad.i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", new Object[] { bt.getProcessNameByPid(aj.getContext(), Process.myPid()), Integer.valueOf(paramAnonymousComponentName.hashCode()) });
        paramAnonymousComponentName.rhl = paramAnonymousIBinder;
        ad.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI service hashCode: %d", new Object[] { Integer.valueOf(FaceDetectUI.d(FaceDetectUI.this).hashCode()) });
        FaceDetectUI.e(FaceDetectUI.this);
        AppMethodBeat.o(103980);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(103981);
        ad.i("MicroMsg.FaceDetectUI", "alvinluo service disconnected %s", new Object[] { paramAnonymousComponentName.toString() });
        FaceDetectUI.a(FaceDetectUI.this, false);
        AppMethodBeat.o(103981);
      }
    };
    ad.i("MicroMsg.FaceDetectUI", "alvinluo bindService");
    d.a(localIntent, this.mConnection, "tools");
    AppMethodBeat.o(103994);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(103995);
    super.onStop();
    ad.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
    clc();
    if (!this.rlh)
    {
      a(1, 90006, "cancel with on stop", null);
      AppMethodBeat.o(103995);
      return;
    }
    finish();
    AppMethodBeat.o(103995);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void y(int paramInt, final String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(104005);
    ad.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", new Object[] { Integer.valueOf(paramInt) });
    if (FaceCharacteristicsResult.DI(paramInt))
    {
      if (paramInt == 3)
      {
        v(90017, "face detect time out", paramString);
        AppMethodBeat.o(104005);
        return;
      }
      if ((paramInt == 6) || (paramInt == 5))
      {
        v(90023, "face track failed or not stable", paramString);
        AppMethodBeat.o(104005);
        return;
      }
      if (paramInt == 7)
      {
        v(90009, "audio permission not granted", aj.getContext().getString(2131761871));
        AppMethodBeat.o(104005);
        return;
      }
      v(90018, "system error", paramString);
      AppMethodBeat.o(104005);
      return;
    }
    paramString = this.rkV;
    if (paramString.pPf >= paramString.rhq - 1)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label247;
      }
      ad.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
      this.rlb.lt(true);
      paramString = this.rlb.getPreviewBm();
      if (paramString != null) {
        break label242;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.FaceDetectUI", "alvinluo bitmap == null: %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(103988);
          ad.i("MicroMsg.FaceDetectUI", "alvinluo set result and return to FaceDetectPrepareUI");
          FaceDetectUI.k(FaceDetectUI.this);
          FaceDetectUI.this.a(0, 0, "collect data ok", null);
          AppMethodBeat.o(103988);
        }
      }
      {
        public final void run()
        {
          AppMethodBeat.i(103987);
          aj.getContext();
          p.l(FaceDetectUI.i(FaceDetectUI.this), paramString);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103986);
              if (FaceDetectUI.8.this.rln != null) {
                FaceDetectUI.8.this.rln.onFinish();
              }
              AppMethodBeat.o(103986);
            }
          });
          AppMethodBeat.o(103987);
        }
      }, "save_face_bitmap");
      AppMethodBeat.o(104005);
      return;
      paramInt = 0;
      break;
      label242:
      bool = false;
    }
    label247:
    paramString = this.rkV;
    g localg = com.tencent.mm.plugin.facedetect.model.f.rhk.rhl.rjn;
    if (localg.rho == null) {
      ad.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
    }
    for (;;)
    {
      paramString.pPf += 1;
      paramInt = h.ctg().type;
      ad.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
      if (!h.ctg().rhx) {
        break;
      }
      this.rlc.b(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(103989);
          FaceDetectUI.l(FaceDetectUI.this);
          AppMethodBeat.o(103989);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      AppMethodBeat.o(104005);
      return;
      ad.i("MicroMsg.FaceDetectNativeManager", "hy: start move next motion");
      localg.rho.engineNextMotion();
    }
    ad.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
    ctP();
    AppMethodBeat.o(104005);
  }
  
  static abstract interface a
  {
    public abstract void onFinish();
  }
  
  final class b
  {
    private boolean rlp = true;
    boolean rlq = false;
    private boolean rlr = true;
    private final boolean rls = true;
    
    private b() {}
    
    public final void ctT()
    {
      try
      {
        this.rlq = true;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final void ctU()
    {
      try
      {
        AppMethodBeat.i(103990);
        ad.i("MicroMsg.FaceDetectUI", "toString: %s", new Object[] { toString() });
        if ((this.rlp) && (this.rlq) && (this.rlr)) {
          FaceDetectUI.m(FaceDetectUI.this).setVisibility(0);
        }
        AppMethodBeat.o(103990);
        return;
      }
      finally {}
    }
    
    final void reset()
    {
      try
      {
        this.rlq = false;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(103991);
      String str = "InitHandler{isCgiInitDone=" + this.rlp + ", isCameraInitDone=" + this.rlq + ", isLightInitDone=true, isLibraryInitDone=" + this.rlr + '}';
      AppMethodBeat.o(103991);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI
 * JD-Core Version:    0.7.0.1
 */