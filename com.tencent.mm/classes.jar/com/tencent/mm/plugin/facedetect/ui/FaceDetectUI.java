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
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectUI
  extends MMActivity
  implements com.tencent.mm.plugin.facedetect.c.f, com.tencent.mm.plugin.facedetect.views.a
{
  private String eaX = null;
  boolean lEQ = false;
  private int mgs = -1;
  h mlM = null;
  private FaceDetectUI.b mlN = null;
  private boolean mlO = false;
  private boolean mlP = false;
  private View mlQ = null;
  private RelativeLayout mlR;
  FaceDetectView mlS = null;
  FaceScanRect mlT = null;
  private TextView mlU = null;
  private Button mlV = null;
  private FaceDetectProcessService mlW = null;
  private ServiceConnection mlX = null;
  private boolean mlY = false;
  private boolean mlZ = false;
  private com.tencent.mm.plugin.facedetect.c.a mlg = null;
  private a mlh = null;
  private FaceTutorial mli = null;
  private String mlq;
  private com.tencent.mm.plugin.facedetect.views.c mma = null;
  private PowerManager.WakeLock wakeLock = null;
  
  private void bpI()
  {
    AppMethodBeat.i(474);
    ab.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", new Object[] { Boolean.valueOf(this.mlY) });
    if (this.mlY)
    {
      ab.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
      com.tencent.mm.bq.d.a(this.mlX, "tools");
      this.mlY = false;
    }
    AppMethodBeat.o(474);
  }
  
  private void buZ()
  {
    AppMethodBeat.i(488);
    ab.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
    b.b localb = this.mlS.getCurrentMotionCancelInfo();
    a(1, localb.errCode, localb.errMsg, null);
    AppMethodBeat.o(488);
  }
  
  private void bvj()
  {
    AppMethodBeat.i(482);
    this.lEQ = false;
    this.mlS.ht(false);
    ab.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
    AppMethodBeat.o(482);
  }
  
  private void bvk()
  {
    AppMethodBeat.i(483);
    bvj();
    stopPreview();
    AppMethodBeat.o(483);
  }
  
  private void f(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(489);
    setResult(-1, g(paramInt1, paramInt2, paramString, paramBundle));
    AppMethodBeat.o(489);
  }
  
  private static Intent g(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(490);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_type", paramInt1);
    localBundle.putInt("err_code", paramInt2);
    localBundle.putString("err_msg", paramString);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramString = new Intent();
    paramString.putExtras(localBundle);
    AppMethodBeat.o(490);
    return paramString;
  }
  
  private void stopPreview()
  {
    AppMethodBeat.i(481);
    this.mlO = false;
    this.mlS.moJ.mop.stopPreview();
    ab.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
    AppMethodBeat.o(481);
  }
  
  private void t(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(485);
    ab.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt), paramString1 });
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    bvk();
    a(4, paramInt, paramString1, localBundle);
    AppMethodBeat.o(485);
  }
  
  public final void U(int paramInt, final String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(486);
    ab.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", new Object[] { Integer.valueOf(paramInt) });
    if (FaceCharacteristicsResult.vD(paramInt))
    {
      if (paramInt == 3)
      {
        t(90017, "face detect time out", paramString);
        AppMethodBeat.o(486);
        return;
      }
      if ((paramInt == 6) || (paramInt == 5))
      {
        t(90023, "face track failed or not stable", paramString);
        AppMethodBeat.o(486);
        return;
      }
      if (paramInt == 7)
      {
        t(90009, "audio permission not granted", ah.getContext().getString(2131302075));
        AppMethodBeat.o(486);
        return;
      }
      t(90018, "system error", paramString);
      AppMethodBeat.o(486);
      return;
    }
    paramString = this.mlM;
    if (paramString.lrL >= paramString.mie - 1)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label247;
      }
      ab.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
      this.mlS.ht(true);
      paramString = this.mlS.getPreviewBm();
      if (paramString != null) {
        break label242;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.FaceDetectUI", "alvinluo bitmap == null: %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.sdk.g.d.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(468);
          ah.getContext();
          p.n(FaceDetectUI.i(FaceDetectUI.this), paramString);
          al.d(new FaceDetectUI.8.1(this));
          AppMethodBeat.o(468);
        }
      }, "save_face_bitmap");
      AppMethodBeat.o(486);
      return;
      paramInt = 0;
      break;
      label242:
      bool = false;
    }
    label247:
    paramString = this.mlM;
    g localg = com.tencent.mm.plugin.facedetect.model.f.mhY.mhZ.mkf;
    if (localg.mic == null) {
      ab.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
    }
    for (;;)
    {
      paramString.lrL += 1;
      paramInt = h.buA().type;
      ab.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
      if (!h.buA().mil) {
        break;
      }
      this.mlT.b(new FaceDetectUI.10(this));
      AppMethodBeat.o(486);
      return;
      ab.i("MicroMsg.FaceDetectNativeManager", "hy: start move next motion");
      localg.mic.engineNextMotion();
    }
    ab.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
    bvi();
    AppMethodBeat.o(486);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(479);
    ab.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (com.tencent.mm.plugin.facedetect.e.a.bvo().isStarted()) && (com.tencent.mm.plugin.facedetect.e.a.bvo().mnp)) {
      com.tencent.mm.plugin.facedetect.e.a.bvo().bvq();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.buB());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    f(paramInt1, paramInt2, paramString, localBundle);
    finish();
    AppMethodBeat.o(479);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, c paramc)
  {
    AppMethodBeat.i(484);
    if (paramBoolean1) {
      bvk();
    }
    if (paramBoolean2)
    {
      ab.i("MicroMsg.FaceDetectUI", "hy: need blur");
      com.tencent.mm.sdk.g.d.post(new FaceDetectUI.7(this, this.mlS.getPreviewBm()), "FaceDetectUI_BlurBgMap");
    }
    this.mlh.a(paramc);
    AppMethodBeat.o(484);
  }
  
  public final void buc()
  {
    AppMethodBeat.i(477);
    ab.i("MicroMsg.FaceDetectUI", "alvinluo startFaceDetect ");
    Object localObject1 = getWindow().getAttributes();
    if (((WindowManager.LayoutParams)localObject1).screenBrightness < 0.9F)
    {
      ((WindowManager.LayoutParams)localObject1).screenBrightness = 0.9F;
      getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
    }
    this.mlT.mpU = FaceScanRect.a.mpX;
    localObject1 = this.mlT;
    if (((FaceScanRect)localObject1).mpU == FaceScanRect.a.mpV) {
      ab.w("MicroMsg.FaceScanRect", "hy: already opened");
    }
    for (;;)
    {
      this.mlS.moK.moE = false;
      this.mlT.setVisibility(0);
      ab.d("MicroMsg.FaceDetectUI", "alvinluo %d, %d, %d, %d", new Object[] { Integer.valueOf(this.mlT.getTop()), Integer.valueOf(this.mlT.getRight()), Integer.valueOf(this.mlT.getLeft()), Integer.valueOf(this.mlT.getBottom()) });
      this.mlO = true;
      this.lEQ = false;
      this.mlN.reset();
      if (this.mlO)
      {
        this.mma = new FaceDetectUI.5(this);
        ab.i("MicroMsg.FaceDetectUI", "hy: start preview");
        localObject1 = this.mma;
        localObject2 = this.mlS;
        ((FaceDetectView)localObject2).moJ.a(new FaceDetectView.4((FaceDetectView)localObject2, (com.tencent.mm.plugin.facedetect.views.c)localObject1));
      }
      AppMethodBeat.o(477);
      return;
      ((FaceScanRect)localObject1).mpT.setVisibility(0);
      ((FaceScanRect)localObject1).mpC.setBackgroundResource(2130838724);
      ((FaceScanRect)localObject1).mpT.startAnimation(((FaceScanRect)localObject1).mpQ);
      Object localObject2 = ((FaceScanRect)localObject1).mpL;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        localObject3.clearAnimation();
        localObject3.setBackgroundColor(((FaceScanRect)localObject1).getResources().getColor(2131690709));
        i += 1;
      }
      ((FaceScanRect)localObject1).mpU = FaceScanRect.a.mpV;
    }
  }
  
  public final void bue()
  {
    AppMethodBeat.i(478);
    ab.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
    if (!this.mlP)
    {
      this.mma = null;
      this.mlP = true;
      if (this.mlN.mmi)
      {
        bvk();
        this.mlS.moJ.mop.bvx();
      }
      if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
      {
        this.wakeLock.release();
        this.wakeLock = null;
      }
      com.tencent.mm.sdk.g.d.post(new FaceDetectUI.2(this), "Face_active_gc");
    }
    bpI();
    AppMethodBeat.o(478);
  }
  
  public final void buh() {}
  
  final void bvi()
  {
    AppMethodBeat.i(480);
    if (this.lEQ)
    {
      ab.i("MicroMsg.FaceDetectUI", "hy: start capture face");
      FaceDetectView localFaceDetectView = this.mlS;
      Rect localRect = new Rect(this.mlT.getLeft(), this.mlT.getTop(), this.mlT.getRight(), this.mlT.getBottom());
      h.a locala = h.buA();
      if (locala.type == 100)
      {
        AppMethodBeat.o(480);
        return;
      }
      if (localFaceDetectView.moO != null) {
        localFaceDetectView.moO.buP();
      }
      localFaceDetectView.eRq = false;
      localFaceDetectView.isPaused = false;
      localFaceDetectView.moU = bo.yB();
      localFaceDetectView.moS = locala.mii;
      localFaceDetectView.moR = locala.gLL;
      ab.i("MicroMsg.FaceDetectView", "carson logic");
      ab.i("MicroMsg.FaceDetectView", "item.hintStr" + locala.gLL);
      localFaceDetectView.mij = locala.mij;
      localFaceDetectView.moP = true;
      localFaceDetectView.moT = locala.mim;
      localFaceDetectView.moO = b.c.a(locala);
      if (localFaceDetectView.moO != null)
      {
        if (localFaceDetectView.moL != null) {
          localFaceDetectView.moL.removeAllViews();
        }
        if (localFaceDetectView.moM != null) {
          localFaceDetectView.moM.removeAllViews();
        }
        localFaceDetectView.moO.a(localFaceDetectView.getContext(), localFaceDetectView.moL, localFaceDetectView.moM);
        ab.d("MicroMsg.FaceDetectView", "mBusinessTip : " + localFaceDetectView.mlq);
        localFaceDetectView.moO.setBusinessTip(localFaceDetectView.mlq);
      }
      if (localFaceDetectView.moJ != null) {
        localFaceDetectView.moJ.a(localRect, locala.mig);
      }
      localFaceDetectView.moQ = false;
    }
    AppMethodBeat.o(480);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public void finish()
  {
    AppMethodBeat.i(492);
    ab.i("MicroMsg.FaceDetectUI", "alvinluo finish");
    if ((this.mlh != null) && (this.mlh.Pk())) {
      this.mlh.dismiss();
    }
    if (this.mli != null) {
      this.mli.dismiss();
    }
    ab.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
    bue();
    super.finish();
    AppMethodBeat.o(492);
  }
  
  public int getLayoutId()
  {
    return 2130969508;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(493);
    ab.i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
    buZ();
    AppMethodBeat.o(493);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(473);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    this.eaX = getIntent().getStringExtra("k_user_name");
    this.mgs = getIntent().getIntExtra("k_server_scene", -1);
    this.mlq = getIntent().getStringExtra("business_tips");
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    if (paramBundle != null) {
      FaceDetectReporter.buB().a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.facedetect.c.b.mhw;
    this.mlg = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.mgs, 0, getIntent().getExtras());
    p.T(this);
    this.mlV = ((Button)findViewById(2131823924));
    this.mlV.setOnClickListener(new FaceDetectUI.1(this));
    this.mlQ = findViewById(2131823921);
    this.mlQ.setVisibility(8);
    this.mlR = ((RelativeLayout)findViewById(2131823923));
    this.mlT = ((FaceScanRect)findViewById(2131823925));
    this.mlS = ((FaceDetectView)findViewById(2131823922));
    this.mlU = ((TextView)findViewById(2131823926));
    this.mlS.setCallback(this);
    this.mlS.setBusinessTip(this.mlq);
    paramBundle = this.mlS;
    RelativeLayout localRelativeLayout = this.mlR;
    ViewGroup localViewGroup = this.mlT.getCenterHintHolder();
    paramBundle.moL = localRelativeLayout;
    paramBundle.moM = localViewGroup;
    this.mlS.setErrTextView(this.mlU);
    this.mlS.o(true, this.eaX);
    this.mlT.setOnRefreshRectListener(new FaceDetectUI.3(this));
    this.mlT.setVisibility(4);
    this.mlN = new FaceDetectUI.b(this, (byte)0);
    AppMethodBeat.o(473);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(491);
    ab.i("MicroMsg.FaceDetectUI", "hy: current %d instance not destroyed", new Object[] { Integer.valueOf(hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(491);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(475);
    super.onStart();
    ab.i("MicroMsg.FaceDetectUI", "alvinluo onStart");
    if (this.wakeLock == null) {
      this.wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(10, "Scan Lock");
    }
    if (!this.wakeLock.isHeld())
    {
      ab.i("MicroMsg.FaceDetectUI", "alvinluo acquire wakeLock");
      this.wakeLock.acquire();
    }
    Intent localIntent = new Intent(this, FaceDetectProcessService.class);
    localIntent.putExtra("key_face_service_connection_from", 2);
    this.mlX = new FaceDetectUI.4(this);
    ab.i("MicroMsg.FaceDetectUI", "alvinluo bindService");
    com.tencent.mm.bq.d.a(localIntent, this.mlX, "tools");
    AppMethodBeat.o(475);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(476);
    super.onStop();
    ab.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
    bpI();
    if (!this.mlZ)
    {
      a(1, 90006, "cancel with on stop", null);
      AppMethodBeat.o(476);
      return;
    }
    finish();
    AppMethodBeat.o(476);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vN(int paramInt)
  {
    AppMethodBeat.i(487);
    if (paramInt == 1) {
      this.mlT.b(null);
    }
    AppMethodBeat.o(487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI
 * JD-Core Version:    0.7.0.1
 */