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
  private String flk = null;
  boolean oVC = false;
  private int pNh = -1;
  private com.tencent.mm.plugin.facedetect.c.a pRR = null;
  private a pRS = null;
  private FaceTutorial pRT = null;
  private boolean pSA = false;
  private View pSB = null;
  private RelativeLayout pSC;
  FaceDetectView pSD = null;
  FaceScanRect pSE = null;
  private TextView pSF = null;
  private Button pSG = null;
  private FaceDetectProcessService pSH = null;
  private ServiceConnection pSI = null;
  private boolean pSJ = false;
  private boolean pSK = false;
  private com.tencent.mm.plugin.facedetect.views.c pSL = null;
  private String pSb;
  h pSx = null;
  private b pSy = null;
  private boolean pSz = false;
  private PowerManager.WakeLock wakeLock = null;
  
  private void bZp()
  {
    AppMethodBeat.i(103993);
    ad.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", new Object[] { Boolean.valueOf(this.pSJ) });
    if (this.pSJ)
    {
      ad.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
      d.a(this.pSI, "tools");
      this.pSJ = false;
    }
    AppMethodBeat.o(103993);
  }
  
  private void cgE()
  {
    AppMethodBeat.i(104001);
    this.oVC = false;
    this.pSD.kw(false);
    ad.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
    AppMethodBeat.o(104001);
  }
  
  private void cgF()
  {
    AppMethodBeat.i(104002);
    cgE();
    stopPreview();
    AppMethodBeat.o(104002);
  }
  
  private void cgt()
  {
    AppMethodBeat.i(104007);
    ad.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
    b.b localb = this.pSD.getCurrentMotionCancelInfo();
    a(1, localb.errCode, localb.errMsg, null);
    AppMethodBeat.o(104007);
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
    this.pSz = false;
    this.pSD.pVs.pUY.stopPreview();
    ad.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
    AppMethodBeat.o(104000);
  }
  
  private void w(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104004);
    ad.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt), paramString1 });
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    cgF();
    a(4, paramInt, paramString1, localBundle);
    AppMethodBeat.o(104004);
  }
  
  public final void Cf(int paramInt)
  {
    AppMethodBeat.i(104006);
    if (paramInt == 1) {
      this.pSE.b(null);
    }
    AppMethodBeat.o(104006);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103998);
    ad.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (com.tencent.mm.plugin.facedetect.e.a.cgJ().isStarted()) && (com.tencent.mm.plugin.facedetect.e.a.cgJ().pUa)) {
      com.tencent.mm.plugin.facedetect.e.a.cgJ().cgL();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.cfV());
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
      cgF();
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
              FaceDetectUI.j(FaceDetectUI.this).V(this.pSO);
              AppMethodBeat.o(103984);
            }
          });
          AppMethodBeat.o(103985);
        }
      }, "FaceDetectUI_BlurBgMap");
    }
    this.pRS.a(paramc);
    AppMethodBeat.o(104003);
  }
  
  public final void cfB() {}
  
  public final void cfw()
  {
    AppMethodBeat.i(103996);
    ad.i("MicroMsg.FaceDetectUI", "alvinluo startFaceDetect ");
    Object localObject1 = getWindow().getAttributes();
    if (((WindowManager.LayoutParams)localObject1).screenBrightness < 0.9F)
    {
      ((WindowManager.LayoutParams)localObject1).screenBrightness = 0.9F;
      getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
    }
    this.pSE.pWD = FaceScanRect.a.pWG;
    localObject1 = this.pSE;
    if (((FaceScanRect)localObject1).pWD == FaceScanRect.a.pWE) {
      ad.w("MicroMsg.FaceScanRect", "hy: already opened");
    }
    for (;;)
    {
      this.pSD.pVt.pVn = false;
      this.pSE.setVisibility(0);
      ad.d("MicroMsg.FaceDetectUI", "alvinluo %d, %d, %d, %d", new Object[] { Integer.valueOf(this.pSE.getTop()), Integer.valueOf(this.pSE.getRight()), Integer.valueOf(this.pSE.getLeft()), Integer.valueOf(this.pSE.getBottom()) });
      this.pSz = true;
      this.oVC = false;
      this.pSy.reset();
      if (this.pSz)
      {
        this.pSL = new com.tencent.mm.plugin.facedetect.views.c()
        {
          public final void Cg(int paramAnonymousInt)
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
        localObject1 = this.pSL;
        localObject2 = this.pSD;
        ((FaceDetectView)localObject2).pVs.a(new FaceDetectView.4((FaceDetectView)localObject2, (com.tencent.mm.plugin.facedetect.views.c)localObject1));
      }
      AppMethodBeat.o(103996);
      return;
      ((FaceScanRect)localObject1).pWC.setVisibility(0);
      ((FaceScanRect)localObject1).pWl.setBackgroundResource(2131232165);
      ((FaceScanRect)localObject1).pWC.startAnimation(((FaceScanRect)localObject1).pWz);
      Object localObject2 = ((FaceScanRect)localObject1).pWu;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        localObject3.clearAnimation();
        localObject3.setBackgroundColor(((FaceScanRect)localObject1).getResources().getColor(2131101179));
        i += 1;
      }
      ((FaceScanRect)localObject1).pWD = FaceScanRect.a.pWE;
    }
  }
  
  public final void cfy()
  {
    AppMethodBeat.i(103997);
    ad.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
    if (!this.pSA)
    {
      this.pSL = null;
      this.pSA = true;
      if (this.pSy.pST)
      {
        cgF();
        this.pSD.pVs.pUY.cgS();
      }
      if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
      {
        this.wakeLock.release();
        this.wakeLock = null;
      }
      com.tencent.mm.sdk.g.b.c(new FaceDetectUI.2(this), "Face_active_gc");
    }
    bZp();
    AppMethodBeat.o(103997);
  }
  
  final void cgD()
  {
    AppMethodBeat.i(103999);
    if (this.oVC)
    {
      ad.i("MicroMsg.FaceDetectUI", "hy: start capture face");
      FaceDetectView localFaceDetectView = this.pSD;
      Rect localRect = new Rect(this.pSE.getLeft(), this.pSE.getTop(), this.pSE.getRight(), this.pSE.getBottom());
      h.a locala = h.cfU();
      if (locala.type == 100)
      {
        AppMethodBeat.o(103999);
        return;
      }
      if (localFaceDetectView.pVx != null) {
        localFaceDetectView.pVx.cgj();
      }
      localFaceDetectView.gna = false;
      localFaceDetectView.isPaused = false;
      localFaceDetectView.pVD = bt.GC();
      localFaceDetectView.pVB = locala.pOW;
      localFaceDetectView.pVA = locala.izu;
      ad.i("MicroMsg.FaceDetectView", "carson logic");
      ad.i("MicroMsg.FaceDetectView", "item.hintStr" + locala.izu);
      localFaceDetectView.pOX = locala.pOX;
      localFaceDetectView.pVy = true;
      localFaceDetectView.pVC = locala.pPa;
      localFaceDetectView.pVx = b.c.a(locala);
      if (localFaceDetectView.pVx != null)
      {
        if (localFaceDetectView.pVu != null) {
          localFaceDetectView.pVu.removeAllViews();
        }
        if (localFaceDetectView.pVv != null) {
          localFaceDetectView.pVv.removeAllViews();
        }
        localFaceDetectView.pVx.a(localFaceDetectView.getContext(), localFaceDetectView.pVu, localFaceDetectView.pVv);
        ad.d("MicroMsg.FaceDetectView", "mBusinessTip : " + localFaceDetectView.pSb);
        localFaceDetectView.pVx.setBusinessTip(localFaceDetectView.pSb);
      }
      if (localFaceDetectView.pVs != null) {
        localFaceDetectView.pVs.a(localRect, locala.pOU);
      }
      localFaceDetectView.pVz = false;
    }
    AppMethodBeat.o(103999);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public void finish()
  {
    AppMethodBeat.i(104011);
    ad.i("MicroMsg.FaceDetectUI", "alvinluo finish");
    if ((this.pRS != null) && (this.pRS.bcB())) {
      this.pRS.dismiss();
    }
    if (this.pRT != null) {
      this.pRT.dismiss();
    }
    ad.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
    cfy();
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
    cgt();
    AppMethodBeat.o(104012);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103992);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    this.flk = getIntent().getStringExtra("k_user_name");
    this.pNh = getIntent().getIntExtra("k_server_scene", -1);
    this.pSb = getIntent().getStringExtra("business_tips");
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    if (paramBundle != null) {
      FaceDetectReporter.cfV().a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.facedetect.c.b.pOk;
    this.pRR = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.pNh, 0, getIntent().getExtras());
    p.ai(this);
    this.pSG = ((Button)findViewById(2131301383));
    this.pSG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(103977);
        ad.i("MicroMsg.FaceDetectUI", "hy: user cancelled with left button");
        FaceDetectUI.a(FaceDetectUI.this);
        AppMethodBeat.o(103977);
      }
    });
    this.pSB = findViewById(2131299667);
    this.pSB.setVisibility(8);
    this.pSC = ((RelativeLayout)findViewById(2131299684));
    this.pSE = ((FaceScanRect)findViewById(2131299683));
    this.pSD = ((FaceDetectView)findViewById(2131299682));
    this.pSF = ((TextView)findViewById(2131299514));
    this.pSD.setCallback(this);
    this.pSD.setBusinessTip(this.pSb);
    paramBundle = this.pSD;
    RelativeLayout localRelativeLayout = this.pSC;
    ViewGroup localViewGroup = this.pSE.getCenterHintHolder();
    paramBundle.pVu = localRelativeLayout;
    paramBundle.pVv = localViewGroup;
    this.pSD.setErrTextView(this.pSF);
    this.pSD.p(true, this.flk);
    this.pSE.setOnRefreshRectListener(new FaceScanRect.b()
    {
      public final void cgG()
      {
        AppMethodBeat.i(103979);
        Object localObject = FaceDetectUI.c(FaceDetectUI.this);
        RectF localRectF = new RectF(FaceDetectUI.b(FaceDetectUI.this).getLeft(), FaceDetectUI.b(FaceDetectUI.this).getTop(), FaceDetectUI.b(FaceDetectUI.this).getRight(), FaceDetectUI.b(FaceDetectUI.this).getBottom());
        localObject = ((FaceDetectView)localObject).pVt;
        ((FaceDetectDecorView)localObject).pVo = true;
        ((FaceDetectDecorView)localObject).pVp = true;
        ((FaceDetectDecorView)localObject).pVq = localRectF;
        ((FaceDetectDecorView)localObject).invalidate();
        AppMethodBeat.o(103979);
      }
    });
    this.pSE.setVisibility(4);
    this.pSy = new b((byte)0);
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
    this.pSI = new FaceDetectUI.4(this);
    ad.i("MicroMsg.FaceDetectUI", "alvinluo bindService");
    d.a(localIntent, this.pSI, "tools");
    AppMethodBeat.o(103994);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(103995);
    super.onStop();
    ad.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
    bZp();
    if (!this.pSK)
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
    if (FaceCharacteristicsResult.BV(paramInt))
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
        w(90009, "audio permission not granted", aj.getContext().getString(2131761871));
        AppMethodBeat.o(104005);
        return;
      }
      w(90018, "system error", paramString);
      AppMethodBeat.o(104005);
      return;
    }
    paramString = this.pSx;
    if (paramString.oIf >= paramString.pOS - 1)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label247;
      }
      ad.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
      this.pSD.kw(true);
      paramString = this.pSD.getPreviewBm();
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
          p.m(FaceDetectUI.i(FaceDetectUI.this), paramString);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103986);
              if (FaceDetectUI.8.this.pSQ != null) {
                FaceDetectUI.8.this.pSQ.onFinish();
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
    paramString = this.pSx;
    g localg = com.tencent.mm.plugin.facedetect.model.f.pOM.pON.pQQ;
    if (localg.pOQ == null) {
      ad.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
    }
    for (;;)
    {
      paramString.oIf += 1;
      paramInt = h.cfU().type;
      ad.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
      if (!h.cfU().pOZ) {
        break;
      }
      this.pSE.b(new Animation.AnimationListener()
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
      localg.pOQ.engineNextMotion();
    }
    ad.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
    cgD();
    AppMethodBeat.o(104005);
  }
  
  static abstract interface a
  {
    public abstract void onFinish();
  }
  
  final class b
  {
    private boolean pSS = true;
    boolean pST = false;
    private boolean pSU = true;
    private final boolean pSV = true;
    
    private b() {}
    
    public final void cgH()
    {
      try
      {
        this.pST = true;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final void cgI()
    {
      try
      {
        AppMethodBeat.i(103990);
        ad.i("MicroMsg.FaceDetectUI", "toString: %s", new Object[] { toString() });
        if ((this.pSS) && (this.pST) && (this.pSU)) {
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
        this.pST = false;
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
      String str = "InitHandler{isCgiInitDone=" + this.pSS + ", isCameraInitDone=" + this.pST + ", isLightInitDone=true, isLibraryInitDone=" + this.pSU + '}';
      AppMethodBeat.o(103991);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI
 * JD-Core Version:    0.7.0.1
 */