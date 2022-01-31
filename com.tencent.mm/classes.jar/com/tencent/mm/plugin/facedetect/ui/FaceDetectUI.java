package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
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
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.d.b.c;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.model.h.a;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView.4;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectUI
  extends MMActivity
  implements com.tencent.mm.plugin.facedetect.c.e, com.tencent.mm.plugin.facedetect.views.a
{
  private String djD = null;
  private int jMm = -1;
  private com.tencent.mm.plugin.facedetect.c.a jQM = null;
  private a jQN = null;
  private c jQO = null;
  private boolean jQP = false;
  private FaceDetectProcessService jRA = null;
  private ServiceConnection jRB = null;
  private boolean jRC = false;
  private boolean jRD = false;
  private com.tencent.mm.plugin.facedetect.views.c jRE = null;
  h jRq = null;
  private FaceDetectUI.b jRr = null;
  private boolean jRs = false;
  private boolean jRt = false;
  private View jRu = null;
  private RelativeLayout jRv;
  FaceDetectView jRw = null;
  FaceScanRect jRx = null;
  private TextView jRy = null;
  private Button jRz = null;
  boolean jvr = false;
  private PowerManager.WakeLock wakeLock = null;
  
  private void aLu()
  {
    y.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", new Object[] { Boolean.valueOf(this.jRC) });
    if (this.jRC)
    {
      y.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
      unbindService(this.jRB);
      this.jRC = false;
    }
  }
  
  private void aOV()
  {
    y.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
    b.b localb = this.jRw.getCurrentMotionCancelInfo();
    a(1, localb.errCode, localb.aox, null);
  }
  
  private void aPf()
  {
    this.jvr = false;
    this.jRw.fQ(false);
    y.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
    this.jRs = false;
    this.jRw.jUq.jTW.stopPreview();
    y.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
  }
  
  private void j(int paramInt, String paramString1, String paramString2)
  {
    y.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt), paramString1 });
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    aPf();
    a(4, paramInt, paramString1, localBundle);
  }
  
  public final void J(int paramInt, String paramString)
  {
    boolean bool = true;
    y.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", new Object[] { Integer.valueOf(paramInt) });
    if (FaceCharacteristicsResult.qI(paramInt))
    {
      if (paramInt == 3)
      {
        j(90017, "face detect time out", paramString);
        return;
      }
      if ((paramInt == 6) || (paramInt == 5))
      {
        j(90023, "face track failed or not stable", paramString);
        return;
      }
      if (paramInt == 7)
      {
        j(90009, "audio permission not granted", ae.getContext().getString(a.i.permission_microphone_request_again_msg));
        return;
      }
      j(90018, "system error", paramString);
      return;
    }
    paramString = this.jRq;
    if (paramString.jiU >= paramString.jNS - 1)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label211;
      }
      y.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
      this.jRw.fQ(true);
      paramString = this.jRw.getPreviewBm();
      if (paramString != null) {
        break label206;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.FaceDetectUI", "alvinluo bitmap == null: %b", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.sdk.f.e.post(new FaceDetectUI.8(this, paramString, new FaceDetectUI.9(this)), "save_face_bitmap");
      return;
      paramInt = 0;
      break;
      label206:
      bool = false;
    }
    label211:
    paramString = this.jRq;
    g localg = f.jNM.jNN.jPP;
    if (localg.jNQ == null) {
      y.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
    }
    for (;;)
    {
      paramString.jiU += 1;
      paramInt = h.aOx().type;
      y.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
      if (!h.aOx().jNZ) {
        break;
      }
      this.jRx.b(new FaceDetectUI.10(this));
      return;
      y.i("MicroMsg.FaceDetectNativeManager", "hy: start move next motion");
      localg.jNQ.engineNextMotion();
    }
    y.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
    aPe();
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    y.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (com.tencent.mm.plugin.facedetect.e.a.aPj().isStarted()) && (com.tencent.mm.plugin.facedetect.e.a.aPj().jST)) {
      com.tencent.mm.plugin.facedetect.e.a.aPj().aPl();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.aOy());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramBundle = new Bundle();
    paramBundle.putInt("err_type", paramInt1);
    paramBundle.putInt("err_code", paramInt2);
    paramBundle.putString("err_msg", paramString);
    paramBundle.putAll(localBundle);
    paramString = new Intent();
    paramString.putExtras(paramBundle);
    setResult(-1, paramString);
    finish();
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, d paramd)
  {
    if (paramBoolean1) {
      aPf();
    }
    if (paramBoolean2)
    {
      y.i("MicroMsg.FaceDetectUI", "hy: need blur");
      com.tencent.mm.sdk.f.e.post(new FaceDetectUI.7(this, this.jRw.getPreviewBm()), "FaceDetectUI_BlurBgMap");
    }
    this.jQN.a(paramd);
  }
  
  public final void aNZ()
  {
    y.i("MicroMsg.FaceDetectUI", "alvinluo startFaceDetect ");
    Object localObject1 = getWindow().getAttributes();
    if (((WindowManager.LayoutParams)localObject1).screenBrightness < 0.9F)
    {
      ((WindowManager.LayoutParams)localObject1).screenBrightness = 0.9F;
      getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
    }
    this.jRx.jVC = FaceScanRect.a.jVF;
    localObject1 = this.jRx;
    if (((FaceScanRect)localObject1).jVC == FaceScanRect.a.jVD) {
      y.w("MicroMsg.FaceScanRect", "hy: already opened");
    }
    for (;;)
    {
      this.jRw.jUr.jUl = false;
      this.jRx.setVisibility(0);
      y.d("MicroMsg.FaceDetectUI", "alvinluo %d, %d, %d, %d", new Object[] { Integer.valueOf(this.jRx.getTop()), Integer.valueOf(this.jRx.getRight()), Integer.valueOf(this.jRx.getLeft()), Integer.valueOf(this.jRx.getBottom()) });
      this.jRs = true;
      this.jvr = false;
      this.jRr.reset();
      if (this.jRs)
      {
        this.jRE = new FaceDetectUI.5(this);
        y.i("MicroMsg.FaceDetectUI", "hy: start preview");
        localObject1 = this.jRE;
        localObject2 = this.jRw;
        ((FaceDetectView)localObject2).jUq.a(new FaceDetectView.4((FaceDetectView)localObject2, (com.tencent.mm.plugin.facedetect.views.c)localObject1));
      }
      return;
      ((FaceScanRect)localObject1).jVB.setVisibility(0);
      ((FaceScanRect)localObject1).jVk.setBackgroundResource(a.d.face_scan_net);
      ((FaceScanRect)localObject1).jVB.startAnimation(((FaceScanRect)localObject1).jVy);
      Object localObject2 = ((FaceScanRect)localObject1).jVt;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        localObject3.clearAnimation();
        localObject3.setBackgroundColor(((FaceScanRect)localObject1).getResources().getColor(a.b.white));
        i += 1;
      }
      ((FaceScanRect)localObject1).jVC = FaceScanRect.a.jVD;
    }
  }
  
  public final void aOb()
  {
    y.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
    if (!this.jRt)
    {
      this.jRE = null;
      this.jRt = true;
      if (this.jRr.jRM)
      {
        aPf();
        this.jRw.jUq.jTW.aPr();
      }
      if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
      {
        this.wakeLock.release();
        this.wakeLock = null;
      }
      com.tencent.mm.sdk.f.e.post(new FaceDetectUI.2(this), "Face_active_gc");
    }
    aLu();
  }
  
  public final void aOe() {}
  
  final void aPe()
  {
    FaceDetectView localFaceDetectView;
    Rect localRect;
    h.a locala;
    if (this.jvr)
    {
      y.i("MicroMsg.FaceDetectUI", "hy: start capture face");
      localFaceDetectView = this.jRw;
      localRect = new Rect(this.jRx.getLeft(), this.jRx.getTop(), this.jRx.getRight(), this.jRx.getBottom());
      locala = h.aOx();
      if (locala.type != 100) {}
    }
    else
    {
      return;
    }
    if (localFaceDetectView.jUv != null) {
      localFaceDetectView.jUv.aOL();
    }
    localFaceDetectView.inQ = false;
    localFaceDetectView.isPaused = false;
    localFaceDetectView.jUB = bk.UZ();
    localFaceDetectView.jUz = locala.jNW;
    localFaceDetectView.jUy = locala.fuj;
    y.i("MicroMsg.FaceDetectView", "carson logic");
    y.i("MicroMsg.FaceDetectView", "item.hintStr" + locala.fuj);
    localFaceDetectView.jNX = locala.jNX;
    localFaceDetectView.jUw = true;
    localFaceDetectView.jUA = locala.jOa;
    localFaceDetectView.jUv = b.c.a(locala);
    if (localFaceDetectView.jUv != null)
    {
      if (localFaceDetectView.jUs != null) {
        localFaceDetectView.jUs.removeAllViews();
      }
      if (localFaceDetectView.jUt != null) {
        localFaceDetectView.jUt.removeAllViews();
      }
      localFaceDetectView.jUv.a(localFaceDetectView.getContext(), localFaceDetectView.jUs, localFaceDetectView.jUt);
    }
    if (localFaceDetectView.jUq != null) {
      localFaceDetectView.jUq.a(localRect, locala.jNU);
    }
    localFaceDetectView.jUx = false;
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public void finish()
  {
    y.i("MicroMsg.FaceDetectUI", "alvinluo finish");
    if ((this.jQN != null) && (this.jQN.akH())) {
      this.jQN.dismiss();
    }
    if (this.jQO != null) {
      this.jQO.dismiss();
    }
    y.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
    aOb();
    super.finish();
  }
  
  protected final int getLayoutId()
  {
    return a.g.face_recognize_ui;
  }
  
  public void onBackPressed()
  {
    y.i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
    aOV();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    this.djD = getIntent().getStringExtra("k_user_name");
    this.jQP = getIntent().getBooleanExtra("k_need_signature", false);
    this.jMm = getIntent().getIntExtra("k_server_scene", -1);
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    if (paramBundle != null) {
      FaceDetectReporter.aOy().a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.facedetect.c.b.jNn;
    this.jQM = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.jMm, 0, getIntent().getExtras());
    o.z(this);
    this.jRz = ((Button)findViewById(a.e.left_btn));
    this.jRz.setOnClickListener(new FaceDetectUI.1(this));
    this.jRu = findViewById(a.e.face_detect_cover);
    this.jRu.setVisibility(8);
    this.jRv = ((RelativeLayout)findViewById(a.e.face_hold_area));
    this.jRx = ((FaceScanRect)findViewById(a.e.face_fixed_rect));
    this.jRw = ((FaceDetectView)findViewById(a.e.face_detect_view));
    this.jRy = ((TextView)findViewById(a.e.err_msg_tv));
    this.jRw.setCallback(this);
    paramBundle = this.jRw;
    RelativeLayout localRelativeLayout = this.jRv;
    ViewGroup localViewGroup = this.jRx.getCenterHintHolder();
    paramBundle.jUs = localRelativeLayout;
    paramBundle.jUt = localViewGroup;
    this.jRw.setErrTextView(this.jRy);
    this.jRw.j(true, this.djD);
    this.jRx.setOnRefreshRectListener(new FaceDetectUI.3(this));
    this.jRx.setVisibility(4);
    this.jRr = new FaceDetectUI.b(this, (byte)0);
  }
  
  protected void onDestroy()
  {
    y.i("MicroMsg.FaceDetectUI", "hy: current %d instance not destroyed", new Object[] { Integer.valueOf(hashCode()) });
    super.onDestroy();
  }
  
  public void onStart()
  {
    super.onStart();
    y.i("MicroMsg.FaceDetectUI", "alvinluo onStart");
    if (this.wakeLock == null) {
      this.wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(10, "Scan Lock");
    }
    if (!this.wakeLock.isHeld())
    {
      y.i("MicroMsg.FaceDetectUI", "alvinluo acquire wakeLock");
      this.wakeLock.acquire();
    }
    Intent localIntent = new Intent(this, FaceDetectProcessService.class);
    localIntent.putExtra("key_face_service_connection_from", 2);
    this.jRB = new FaceDetectUI.4(this);
    y.i("MicroMsg.FaceDetectUI", "alvinluo bindService");
    bindService(localIntent, this.jRB, 1);
  }
  
  protected void onStop()
  {
    super.onStop();
    y.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
    aLu();
    if (!this.jRD)
    {
      a(1, 90006, "cancel with on stop", null);
      return;
    }
    finish();
  }
  
  public final void qS(int paramInt)
  {
    if (paramInt == 1) {
      this.jRx.b(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI
 * JD-Core Version:    0.7.0.1
 */