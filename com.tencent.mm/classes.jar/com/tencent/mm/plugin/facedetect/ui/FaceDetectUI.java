package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
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
import com.tencent.mm.br.d;
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
import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView.4;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectUI
  extends MMActivity
  implements com.tencent.mm.plugin.facedetect.c.f, com.tencent.mm.plugin.facedetect.views.a
{
  private String fIQ = null;
  private ServiceConnection mConnection = null;
  boolean qiX = false;
  private int rnI = -1;
  private String rsD;
  h rsZ = null;
  private com.tencent.mm.plugin.facedetect.c.a rst = null;
  private a rsu = null;
  private FaceTutorial rsv = null;
  private FaceDetectUI.b rta = null;
  private boolean rtb = false;
  private boolean rtc = false;
  private View rtd = null;
  private RelativeLayout rte;
  FaceDetectView rtf = null;
  FaceScanRect rtg = null;
  private TextView rth = null;
  private Button rti = null;
  private FaceDetectProcessService rtj = null;
  private boolean rtk = false;
  private boolean rtl = false;
  private com.tencent.mm.plugin.facedetect.views.c rtm = null;
  private PowerManager.WakeLock wakeLock = null;
  
  private void cms()
  {
    AppMethodBeat.i(103993);
    ae.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", new Object[] { Boolean.valueOf(this.rtk) });
    if (this.rtk)
    {
      ae.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
      d.a(this.mConnection, "tools");
      this.rtk = false;
    }
    AppMethodBeat.o(103993);
  }
  
  private void cvg()
  {
    AppMethodBeat.i(104007);
    ae.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
    b.b localb = this.rtf.getCurrentMotionCancelInfo();
    a(1, localb.errCode, localb.errMsg, null);
    AppMethodBeat.o(104007);
  }
  
  private void cvr()
  {
    AppMethodBeat.i(104001);
    this.qiX = false;
    this.rtf.lt(false);
    ae.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
    AppMethodBeat.o(104001);
  }
  
  private void cvs()
  {
    AppMethodBeat.i(104002);
    cvr();
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
    this.rtb = false;
    this.rtf.rvS.rvy.stopPreview();
    ae.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
    AppMethodBeat.o(104000);
  }
  
  private void v(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104004);
    ae.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt), paramString1 });
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    cvs();
    a(4, paramInt, paramString1, localBundle);
    AppMethodBeat.o(104004);
  }
  
  public final void Ef(int paramInt)
  {
    AppMethodBeat.i(104006);
    if (paramInt == 1) {
      this.rtg.b(null);
    }
    AppMethodBeat.o(104006);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103998);
    ae.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (com.tencent.mm.plugin.facedetect.e.a.cvw().isStarted()) && (com.tencent.mm.plugin.facedetect.e.a.cvw().ruA)) {
      com.tencent.mm.plugin.facedetect.e.a.cvw().cvy();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.cuI());
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
      cvs();
    }
    if (paramBoolean2)
    {
      ae.i("MicroMsg.FaceDetectUI", "hy: need blur");
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103985);
          ak.getContext();
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103984);
              FaceDetectUI.j(FaceDetectUI.this).W(this.rtp);
              AppMethodBeat.o(103984);
            }
          });
          AppMethodBeat.o(103985);
        }
      }, "FaceDetectUI_BlurBgMap");
    }
    this.rsu.a(paramc);
    AppMethodBeat.o(104003);
  }
  
  public final void cuj()
  {
    AppMethodBeat.i(103996);
    ae.i("MicroMsg.FaceDetectUI", "alvinluo startFaceDetect ");
    Object localObject1 = getWindow().getAttributes();
    if (((WindowManager.LayoutParams)localObject1).screenBrightness < 0.9F)
    {
      ((WindowManager.LayoutParams)localObject1).screenBrightness = 0.9F;
      getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
    }
    this.rtg.rxd = FaceScanRect.a.rxg;
    localObject1 = this.rtg;
    if (((FaceScanRect)localObject1).rxd == FaceScanRect.a.rxe) {
      ae.w("MicroMsg.FaceScanRect", "hy: already opened");
    }
    for (;;)
    {
      this.rtf.rvT.rvN = false;
      this.rtg.setVisibility(0);
      ae.d("MicroMsg.FaceDetectUI", "alvinluo %d, %d, %d, %d", new Object[] { Integer.valueOf(this.rtg.getTop()), Integer.valueOf(this.rtg.getRight()), Integer.valueOf(this.rtg.getLeft()), Integer.valueOf(this.rtg.getBottom()) });
      this.rtb = true;
      this.qiX = false;
      this.rta.reset();
      if (this.rtb)
      {
        this.rtm = new com.tencent.mm.plugin.facedetect.views.c()
        {
          public final void Eg(int paramAnonymousInt)
          {
            AppMethodBeat.i(103982);
            ae.i("MicroMsg.FaceDetectUI", "alvinluo onPreviewInitDone: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
        ae.i("MicroMsg.FaceDetectUI", "hy: start preview");
        localObject1 = this.rtm;
        localObject2 = this.rtf;
        ((FaceDetectView)localObject2).rvS.a(new FaceDetectView.4((FaceDetectView)localObject2, (com.tencent.mm.plugin.facedetect.views.c)localObject1));
      }
      AppMethodBeat.o(103996);
      return;
      ((FaceScanRect)localObject1).rxc.setVisibility(0);
      ((FaceScanRect)localObject1).rwL.setBackgroundResource(2131232165);
      ((FaceScanRect)localObject1).rxc.startAnimation(((FaceScanRect)localObject1).rwZ);
      Object localObject2 = ((FaceScanRect)localObject1).rwU;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        localObject3.clearAnimation();
        localObject3.setBackgroundColor(((FaceScanRect)localObject1).getResources().getColor(2131101179));
        i += 1;
      }
      ((FaceScanRect)localObject1).rxd = FaceScanRect.a.rxe;
    }
  }
  
  public final void cul()
  {
    AppMethodBeat.i(103997);
    ae.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
    if (!this.rtc)
    {
      this.rtm = null;
      this.rtc = true;
      if (this.rta.rtv)
      {
        cvs();
        this.rtf.rvS.rvy.cvF();
      }
      if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
      {
        this.wakeLock.release();
        this.wakeLock = null;
      }
      com.tencent.mm.sdk.g.b.c(new FaceDetectUI.2(this), "Face_active_gc");
    }
    cms();
    AppMethodBeat.o(103997);
  }
  
  public final void cuo() {}
  
  final void cvq()
  {
    AppMethodBeat.i(103999);
    if (this.qiX)
    {
      ae.i("MicroMsg.FaceDetectUI", "hy: start capture face");
      FaceDetectView localFaceDetectView = this.rtf;
      Rect localRect = new Rect(this.rtg.getLeft(), this.rtg.getTop(), this.rtg.getRight(), this.rtg.getBottom());
      h.a locala = h.cuH();
      if (locala.type == 100)
      {
        AppMethodBeat.o(103999);
        return;
      }
      if (localFaceDetectView.rvX != null) {
        localFaceDetectView.rvX.cuW();
      }
      localFaceDetectView.hkx = false;
      localFaceDetectView.isPaused = false;
      localFaceDetectView.rwd = bu.HQ();
      localFaceDetectView.rwb = locala.rpy;
      localFaceDetectView.rwa = locala.jvz;
      ae.i("MicroMsg.FaceDetectView", "carson logic");
      ae.i("MicroMsg.FaceDetectView", "item.hintStr" + locala.jvz);
      localFaceDetectView.rpz = locala.rpz;
      localFaceDetectView.rvY = true;
      localFaceDetectView.rwc = locala.rpC;
      localFaceDetectView.rvX = b.c.a(locala);
      if (localFaceDetectView.rvX != null)
      {
        if (localFaceDetectView.rvU != null) {
          localFaceDetectView.rvU.removeAllViews();
        }
        if (localFaceDetectView.rvV != null) {
          localFaceDetectView.rvV.removeAllViews();
        }
        localFaceDetectView.rvX.a(localFaceDetectView.getContext(), localFaceDetectView.rvU, localFaceDetectView.rvV);
        ae.d("MicroMsg.FaceDetectView", "mBusinessTip : " + localFaceDetectView.rsD);
        localFaceDetectView.rvX.setBusinessTip(localFaceDetectView.rsD);
      }
      if (localFaceDetectView.rvS != null) {
        localFaceDetectView.rvS.a(localRect, locala.rpw);
      }
      localFaceDetectView.rvZ = false;
    }
    AppMethodBeat.o(103999);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public void finish()
  {
    AppMethodBeat.i(104011);
    ae.i("MicroMsg.FaceDetectUI", "alvinluo finish");
    if ((this.rsu != null) && (this.rsu.bnS())) {
      this.rsu.dismiss();
    }
    if (this.rsv != null) {
      this.rsv.dismiss();
    }
    ae.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
    cul();
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
    ae.i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
    cvg();
    AppMethodBeat.o(104012);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103992);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    this.fIQ = getIntent().getStringExtra("k_user_name");
    this.rnI = getIntent().getIntExtra("k_server_scene", -1);
    this.rsD = getIntent().getStringExtra("business_tips");
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    if (paramBundle != null) {
      FaceDetectReporter.cuI().a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.facedetect.c.b.roM;
    this.rst = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.rnI, 0, getIntent().getExtras());
    p.an(this);
    this.rti = ((Button)findViewById(2131301383));
    this.rti.setOnClickListener(new FaceDetectUI.1(this));
    this.rtd = findViewById(2131299667);
    this.rtd.setVisibility(8);
    this.rte = ((RelativeLayout)findViewById(2131299684));
    this.rtg = ((FaceScanRect)findViewById(2131299683));
    this.rtf = ((FaceDetectView)findViewById(2131299682));
    this.rth = ((TextView)findViewById(2131299514));
    this.rtf.setCallback(this);
    this.rtf.setBusinessTip(this.rsD);
    paramBundle = this.rtf;
    RelativeLayout localRelativeLayout = this.rte;
    ViewGroup localViewGroup = this.rtg.getCenterHintHolder();
    paramBundle.rvU = localRelativeLayout;
    paramBundle.rvV = localViewGroup;
    this.rtf.setErrTextView(this.rth);
    this.rtf.u(true, this.fIQ);
    this.rtg.setOnRefreshRectListener(new FaceDetectUI.3(this));
    this.rtg.setVisibility(4);
    this.rta = new FaceDetectUI.b(this, (byte)0);
    AppMethodBeat.o(103992);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104010);
    ae.i("MicroMsg.FaceDetectUI", "hy: current %d instance not destroyed", new Object[] { Integer.valueOf(hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(104010);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(103994);
    super.onStart();
    ae.i("MicroMsg.FaceDetectUI", "alvinluo onStart");
    if (this.wakeLock == null) {
      this.wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(10, "Scan Lock");
    }
    if (!this.wakeLock.isHeld())
    {
      ae.i("MicroMsg.FaceDetectUI", "alvinluo acquire wakeLock");
      this.wakeLock.acquire();
    }
    Intent localIntent = new Intent(this, FaceDetectProcessService.class);
    localIntent.putExtra("key_face_service_connection_from", 2);
    this.mConnection = new FaceDetectUI.4(this);
    ae.i("MicroMsg.FaceDetectUI", "alvinluo bindService");
    d.a(localIntent, this.mConnection, "tools");
    AppMethodBeat.o(103994);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(103995);
    super.onStop();
    ae.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
    cms();
    if (!this.rtl)
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
    ae.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", new Object[] { Integer.valueOf(paramInt) });
    if (FaceCharacteristicsResult.DV(paramInt))
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
        v(90009, "audio permission not granted", ak.getContext().getString(2131761871));
        AppMethodBeat.o(104005);
        return;
      }
      v(90018, "system error", paramString);
      AppMethodBeat.o(104005);
      return;
    }
    paramString = this.rsZ;
    if (paramString.pVK >= paramString.rpu - 1)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label247;
      }
      ae.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
      this.rtf.lt(true);
      paramString = this.rtf.getPreviewBm();
      if (paramString != null) {
        break label242;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.FaceDetectUI", "alvinluo bitmap == null: %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(103988);
          ae.i("MicroMsg.FaceDetectUI", "alvinluo set result and return to FaceDetectPrepareUI");
          FaceDetectUI.k(FaceDetectUI.this);
          FaceDetectUI.this.a(0, 0, "collect data ok", null);
          AppMethodBeat.o(103988);
        }
      }
      {
        public final void run()
        {
          AppMethodBeat.i(103987);
          ak.getContext();
          p.l(FaceDetectUI.i(FaceDetectUI.this), paramString);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103986);
              if (FaceDetectUI.8.this.rtr != null) {
                FaceDetectUI.8.this.rtr.onFinish();
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
    paramString = this.rsZ;
    g localg = com.tencent.mm.plugin.facedetect.model.f.rpo.rpp.rrr;
    if (localg.rps == null) {
      ae.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
    }
    for (;;)
    {
      paramString.pVK += 1;
      paramInt = h.cuH().type;
      ae.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
      if (!h.cuH().rpB) {
        break;
      }
      this.rtg.b(new Animation.AnimationListener()
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
      ae.i("MicroMsg.FaceDetectNativeManager", "hy: start move next motion");
      localg.rps.engineNextMotion();
    }
    ae.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
    cvq();
    AppMethodBeat.o(104005);
  }
  
  static abstract interface a
  {
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI
 * JD-Core Version:    0.7.0.1
 */