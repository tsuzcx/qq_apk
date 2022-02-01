package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView.4;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect.a;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectUI
  extends MMActivity
  implements com.tencent.mm.plugin.facedetect.c.f, com.tencent.mm.plugin.facedetect.views.a
{
  private String foE = null;
  private ServiceConnection mConnection = null;
  boolean pyN = false;
  private a qAA = null;
  private FaceTutorial qAB = null;
  private String qAJ;
  private com.tencent.mm.plugin.facedetect.c.a qAz = null;
  h qBf = null;
  private b qBg = null;
  private boolean qBh = false;
  private boolean qBi = false;
  private View qBj = null;
  private RelativeLayout qBk;
  FaceDetectView qBl = null;
  FaceScanRect qBm = null;
  private TextView qBn = null;
  private Button qBo = null;
  private FaceDetectProcessService qBp = null;
  private boolean qBq = false;
  private boolean qBr = false;
  private com.tencent.mm.plugin.facedetect.views.c qBs = null;
  private int qvP = -1;
  private PowerManager.WakeLock wakeLock = null;
  
  private void cgy()
  {
    AppMethodBeat.i(103993);
    ac.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", new Object[] { Boolean.valueOf(this.qBq) });
    if (this.qBq)
    {
      ac.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
      d.a(this.mConnection, "tools");
      this.qBq = false;
    }
    AppMethodBeat.o(103993);
  }
  
  private void coa()
  {
    AppMethodBeat.i(104007);
    ac.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
    b.b localb = this.qBl.getCurrentMotionCancelInfo();
    a(1, localb.errCode, localb.errMsg, null);
    AppMethodBeat.o(104007);
  }
  
  private void col()
  {
    AppMethodBeat.i(104001);
    this.pyN = false;
    this.qBl.la(false);
    ac.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
    AppMethodBeat.o(104001);
  }
  
  private void com()
  {
    AppMethodBeat.i(104002);
    col();
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
    this.qBh = false;
    this.qBl.qDX.qDD.stopPreview();
    ac.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
    AppMethodBeat.o(104000);
  }
  
  private void w(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104004);
    ac.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt), paramString1 });
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    com();
    a(4, paramInt, paramString1, localBundle);
    AppMethodBeat.o(104004);
  }
  
  public final void Da(int paramInt)
  {
    AppMethodBeat.i(104006);
    if (paramInt == 1) {
      this.qBm.b(null);
    }
    AppMethodBeat.o(104006);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103998);
    ac.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (com.tencent.mm.plugin.facedetect.e.a.coq().isStarted()) && (com.tencent.mm.plugin.facedetect.e.a.coq().qCF)) {
      com.tencent.mm.plugin.facedetect.e.a.coq().cos();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.cnC());
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
      com();
    }
    if (paramBoolean2)
    {
      ac.i("MicroMsg.FaceDetectUI", "hy: need blur");
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103985);
          ai.getContext();
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103984);
              FaceDetectUI.j(FaceDetectUI.this).V(this.qBv);
              AppMethodBeat.o(103984);
            }
          });
          AppMethodBeat.o(103985);
        }
      }, "FaceDetectUI_BlurBgMap");
    }
    this.qAA.a(paramc);
    AppMethodBeat.o(104003);
  }
  
  public final void cnd()
  {
    AppMethodBeat.i(103996);
    ac.i("MicroMsg.FaceDetectUI", "alvinluo startFaceDetect ");
    Object localObject1 = getWindow().getAttributes();
    if (((WindowManager.LayoutParams)localObject1).screenBrightness < 0.9F)
    {
      ((WindowManager.LayoutParams)localObject1).screenBrightness = 0.9F;
      getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
    }
    this.qBm.qFi = FaceScanRect.a.qFl;
    localObject1 = this.qBm;
    if (((FaceScanRect)localObject1).qFi == FaceScanRect.a.qFj) {
      ac.w("MicroMsg.FaceScanRect", "hy: already opened");
    }
    for (;;)
    {
      this.qBl.qDY.qDS = false;
      this.qBm.setVisibility(0);
      ac.d("MicroMsg.FaceDetectUI", "alvinluo %d, %d, %d, %d", new Object[] { Integer.valueOf(this.qBm.getTop()), Integer.valueOf(this.qBm.getRight()), Integer.valueOf(this.qBm.getLeft()), Integer.valueOf(this.qBm.getBottom()) });
      this.qBh = true;
      this.pyN = false;
      this.qBg.reset();
      if (this.qBh)
      {
        this.qBs = new com.tencent.mm.plugin.facedetect.views.c()
        {
          public final void Db(int paramAnonymousInt)
          {
            AppMethodBeat.i(103982);
            ac.i("MicroMsg.FaceDetectUI", "alvinluo onPreviewInitDone: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
        ac.i("MicroMsg.FaceDetectUI", "hy: start preview");
        localObject1 = this.qBs;
        localObject2 = this.qBl;
        ((FaceDetectView)localObject2).qDX.a(new FaceDetectView.4((FaceDetectView)localObject2, (com.tencent.mm.plugin.facedetect.views.c)localObject1));
      }
      AppMethodBeat.o(103996);
      return;
      ((FaceScanRect)localObject1).qFh.setVisibility(0);
      ((FaceScanRect)localObject1).qEQ.setBackgroundResource(2131232165);
      ((FaceScanRect)localObject1).qFh.startAnimation(((FaceScanRect)localObject1).qFe);
      Object localObject2 = ((FaceScanRect)localObject1).qEZ;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        localObject3.clearAnimation();
        localObject3.setBackgroundColor(((FaceScanRect)localObject1).getResources().getColor(2131101179));
        i += 1;
      }
      ((FaceScanRect)localObject1).qFi = FaceScanRect.a.qFj;
    }
  }
  
  public final void cnf()
  {
    AppMethodBeat.i(103997);
    ac.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
    if (!this.qBi)
    {
      this.qBs = null;
      this.qBi = true;
      if (this.qBg.qBA)
      {
        com();
        this.qBl.qDX.qDD.coz();
      }
      if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
      {
        this.wakeLock.release();
        this.wakeLock = null;
      }
      com.tencent.mm.sdk.g.b.c(new FaceDetectUI.2(this), "Face_active_gc");
    }
    cgy();
    AppMethodBeat.o(103997);
  }
  
  public final void cni() {}
  
  final void cok()
  {
    AppMethodBeat.i(103999);
    if (this.pyN)
    {
      ac.i("MicroMsg.FaceDetectUI", "hy: start capture face");
      FaceDetectView localFaceDetectView = this.qBl;
      Rect localRect = new Rect(this.qBm.getLeft(), this.qBm.getTop(), this.qBm.getRight(), this.qBm.getBottom());
      h.a locala = h.cnB();
      if (locala.type == 100)
      {
        AppMethodBeat.o(103999);
        return;
      }
      if (localFaceDetectView.qEc != null) {
        localFaceDetectView.qEc.cnQ();
      }
      localFaceDetectView.gNN = false;
      localFaceDetectView.isPaused = false;
      localFaceDetectView.qEi = bs.Gn();
      localFaceDetectView.qEg = locala.qxE;
      localFaceDetectView.qEf = locala.iZx;
      ac.i("MicroMsg.FaceDetectView", "carson logic");
      ac.i("MicroMsg.FaceDetectView", "item.hintStr" + locala.iZx);
      localFaceDetectView.qxF = locala.qxF;
      localFaceDetectView.qEd = true;
      localFaceDetectView.qEh = locala.qxI;
      localFaceDetectView.qEc = b.c.a(locala);
      if (localFaceDetectView.qEc != null)
      {
        if (localFaceDetectView.qDZ != null) {
          localFaceDetectView.qDZ.removeAllViews();
        }
        if (localFaceDetectView.qEa != null) {
          localFaceDetectView.qEa.removeAllViews();
        }
        localFaceDetectView.qEc.a(localFaceDetectView.getContext(), localFaceDetectView.qDZ, localFaceDetectView.qEa);
        ac.d("MicroMsg.FaceDetectView", "mBusinessTip : " + localFaceDetectView.qAJ);
        localFaceDetectView.qEc.setBusinessTip(localFaceDetectView.qAJ);
      }
      if (localFaceDetectView.qDX != null) {
        localFaceDetectView.qDX.a(localRect, locala.qxC);
      }
      localFaceDetectView.qEe = false;
    }
    AppMethodBeat.o(103999);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public void finish()
  {
    AppMethodBeat.i(104011);
    ac.i("MicroMsg.FaceDetectUI", "alvinluo finish");
    if ((this.qAA != null) && (this.qAA.bjw())) {
      this.qAA.dismiss();
    }
    if (this.qAB != null) {
      this.qAB.dismiss();
    }
    ac.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
    cnf();
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
    ac.i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
    coa();
    AppMethodBeat.o(104012);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103992);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    this.foE = getIntent().getStringExtra("k_user_name");
    this.qvP = getIntent().getIntExtra("k_server_scene", -1);
    this.qAJ = getIntent().getStringExtra("business_tips");
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    if (paramBundle != null) {
      FaceDetectReporter.cnC().a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.facedetect.c.b.qwS;
    this.qAz = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.qvP, 0, getIntent().getExtras());
    p.am(this);
    this.qBo = ((Button)findViewById(2131301383));
    this.qBo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(103977);
        ac.i("MicroMsg.FaceDetectUI", "hy: user cancelled with left button");
        FaceDetectUI.a(FaceDetectUI.this);
        AppMethodBeat.o(103977);
      }
    });
    this.qBj = findViewById(2131299667);
    this.qBj.setVisibility(8);
    this.qBk = ((RelativeLayout)findViewById(2131299684));
    this.qBm = ((FaceScanRect)findViewById(2131299683));
    this.qBl = ((FaceDetectView)findViewById(2131299682));
    this.qBn = ((TextView)findViewById(2131299514));
    this.qBl.setCallback(this);
    this.qBl.setBusinessTip(this.qAJ);
    paramBundle = this.qBl;
    RelativeLayout localRelativeLayout = this.qBk;
    ViewGroup localViewGroup = this.qBm.getCenterHintHolder();
    paramBundle.qDZ = localRelativeLayout;
    paramBundle.qEa = localViewGroup;
    this.qBl.setErrTextView(this.qBn);
    this.qBl.q(true, this.foE);
    this.qBm.setOnRefreshRectListener(new FaceScanRect.b()
    {
      public final void con()
      {
        AppMethodBeat.i(103979);
        Object localObject = FaceDetectUI.c(FaceDetectUI.this);
        RectF localRectF = new RectF(FaceDetectUI.b(FaceDetectUI.this).getLeft(), FaceDetectUI.b(FaceDetectUI.this).getTop(), FaceDetectUI.b(FaceDetectUI.this).getRight(), FaceDetectUI.b(FaceDetectUI.this).getBottom());
        localObject = ((FaceDetectView)localObject).qDY;
        ((FaceDetectDecorView)localObject).qDT = true;
        ((FaceDetectDecorView)localObject).qDU = true;
        ((FaceDetectDecorView)localObject).qDV = localRectF;
        ((FaceDetectDecorView)localObject).invalidate();
        AppMethodBeat.o(103979);
      }
    });
    this.qBm.setVisibility(4);
    this.qBg = new b((byte)0);
    AppMethodBeat.o(103992);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104010);
    ac.i("MicroMsg.FaceDetectUI", "hy: current %d instance not destroyed", new Object[] { Integer.valueOf(hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(104010);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(103994);
    super.onStart();
    ac.i("MicroMsg.FaceDetectUI", "alvinluo onStart");
    if (this.wakeLock == null) {
      this.wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(10, "Scan Lock");
    }
    if (!this.wakeLock.isHeld())
    {
      ac.i("MicroMsg.FaceDetectUI", "alvinluo acquire wakeLock");
      this.wakeLock.acquire();
    }
    Intent localIntent = new Intent(this, FaceDetectProcessService.class);
    localIntent.putExtra("key_face_service_connection_from", 2);
    this.mConnection = new FaceDetectUI.4(this);
    ac.i("MicroMsg.FaceDetectUI", "alvinluo bindService");
    d.a(localIntent, this.mConnection, "tools");
    AppMethodBeat.o(103994);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(103995);
    super.onStop();
    ac.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
    cgy();
    if (!this.qBr)
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
    ac.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", new Object[] { Integer.valueOf(paramInt) });
    if (FaceCharacteristicsResult.CQ(paramInt))
    {
      if (paramInt == 3)
      {
        w(90017, "face detect time out", paramString);
        AppMethodBeat.o(104005);
        return;
      }
      if ((paramInt == 6) || (paramInt == 5))
      {
        w(90023, "face track failed or not stable", paramString);
        AppMethodBeat.o(104005);
        return;
      }
      if (paramInt == 7)
      {
        w(90009, "audio permission not granted", ai.getContext().getString(2131761871));
        AppMethodBeat.o(104005);
        return;
      }
      w(90018, "system error", paramString);
      AppMethodBeat.o(104005);
      return;
    }
    paramString = this.qBf;
    if (paramString.plF >= paramString.qxA - 1)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label247;
      }
      ac.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
      this.qBl.la(true);
      paramString = this.qBl.getPreviewBm();
      if (paramString != null) {
        break label242;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.FaceDetectUI", "alvinluo bitmap == null: %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(103988);
          ac.i("MicroMsg.FaceDetectUI", "alvinluo set result and return to FaceDetectPrepareUI");
          FaceDetectUI.k(FaceDetectUI.this);
          FaceDetectUI.this.a(0, 0, "collect data ok", null);
          AppMethodBeat.o(103988);
        }
      }
      {
        public final void run()
        {
          AppMethodBeat.i(103987);
          ai.getContext();
          p.l(FaceDetectUI.i(FaceDetectUI.this), paramString);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103986);
              if (FaceDetectUI.8.this.qBx != null) {
                FaceDetectUI.8.this.qBx.onFinish();
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
    paramString = this.qBf;
    g localg = com.tencent.mm.plugin.facedetect.model.f.qxu.qxv.qzy;
    if (localg.qxy == null) {
      ac.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
    }
    for (;;)
    {
      paramString.plF += 1;
      paramInt = h.cnB().type;
      ac.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
      if (!h.cnB().qxH) {
        break;
      }
      this.qBm.b(new Animation.AnimationListener()
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
      ac.i("MicroMsg.FaceDetectNativeManager", "hy: start move next motion");
      localg.qxy.engineNextMotion();
    }
    ac.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
    cok();
    AppMethodBeat.o(104005);
  }
  
  static abstract interface a
  {
    public abstract void onFinish();
  }
  
  final class b
  {
    boolean qBA = false;
    private boolean qBB = true;
    private final boolean qBC = true;
    private boolean qBz = true;
    
    private b() {}
    
    public final void coo()
    {
      try
      {
        this.qBA = true;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final void cop()
    {
      try
      {
        AppMethodBeat.i(103990);
        ac.i("MicroMsg.FaceDetectUI", "toString: %s", new Object[] { toString() });
        if ((this.qBz) && (this.qBA) && (this.qBB)) {
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
        this.qBA = false;
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
      String str = "InitHandler{isCgiInitDone=" + this.qBz + ", isCameraInitDone=" + this.qBA + ", isLightInitDone=true, isLibraryInitDone=" + this.qBB + '}';
      AppMethodBeat.o(103991);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI
 * JD-Core Version:    0.7.0.1
 */