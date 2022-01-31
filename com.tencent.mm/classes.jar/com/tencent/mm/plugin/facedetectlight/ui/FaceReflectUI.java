package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@com.tencent.mm.ui.base.a(3)
public class FaceReflectUI
  extends MMActivity
  implements com.tencent.mm.plugin.facedetect.c.e
{
  private String djD;
  private int jMm;
  private com.tencent.mm.plugin.facedetect.b.d jMn = null;
  private int jMx;
  private com.tencent.mm.plugin.facedetect.c.a jQM = null;
  private boolean jQP;
  private byte[] jQQ;
  private boolean jQR = false;
  private boolean jQS = false;
  private boolean jQU = false;
  private FaceDetectProcessService jRA = null;
  private ServiceConnection jRB = null;
  private boolean jRC = false;
  private RelativeLayout jRX;
  private RelativeLayout jRY;
  private RelativeLayout jRZ;
  private ImageView jSa;
  private ImageView jSb;
  private ImageView jSc;
  private RelativeLayout jWD;
  private PreviewFrameLayout jWE;
  private MMTextureView jWG;
  private ImageView jWH;
  private TextView jWI;
  private TextView jWJ;
  private a jWP;
  private ViewGroup jXP;
  ImageView jXQ;
  ImageView jXR;
  private Button jXS;
  private FaceReflectMask jXo;
  private String jXr;
  private MMAnimateView jhT;
  private String mAppId;
  
  static
  {
    k.b("YTCommonEx", FaceReflectUI.class.getClassLoader());
    k.b("YTFaceTrace", FaceReflectUI.class.getClassLoader());
    k.b("YTNextCV", FaceReflectUI.class.getClassLoader());
    k.b("YTAGReflectLiveCheck", FaceReflectUI.class.getClassLoader());
    YTCommonExInterface.setBusinessCode(1);
  }
  
  private void aPF()
  {
    y.d("MicroMsg.FaceReflectUI", "initLayout");
    this.jWH = ((ImageView)findViewById(a.e.background_view));
    this.jWD = ((RelativeLayout)findViewById(a.e.face_preview_layout));
    this.jWE = ((PreviewFrameLayout)findViewById(a.e.face_live_preview_layout));
    this.jWG = ((MMTextureView)findViewById(a.e.face_live_detection_preview));
    this.jXo = ((FaceReflectMask)findViewById(a.e.face_live_preview_mask));
    this.jXQ = ((ImageView)findViewById(a.e.face_detect_ret));
    this.jWI = ((TextView)findViewById(a.e.face_live_tip_tv));
    FaceDetectReporter.aOy().aOz();
    FaceDetectReporter.aOy().aOA();
    FaceDetectReporter.aOy().jOy = System.currentTimeMillis();
    this.jXP = ((ViewGroup)findViewById(a.e.face_transition_layout));
    this.jhT = ((MMAnimateView)findViewById(a.e.face_ready_gif));
    this.jhT.setImageResource(a.h.face_ready_gif);
    this.jhT.start();
    this.jXS = ((Button)findViewById(a.e.face_ready_btn));
    this.jXS.setOnClickListener(new FaceReflectUI.1(this));
    this.jWJ = ((TextView)findViewById(a.e.face__back));
    this.jWJ.setOnClickListener(new FaceReflectUI.2(this));
    this.jRX = ((RelativeLayout)findViewById(a.e.face_upload_layout));
    this.jRY = ((RelativeLayout)findViewById(a.e.face_upload_success_layout));
    this.jRZ = ((RelativeLayout)findViewById(a.e.face_upload_failed_layout));
    this.jRX.setVisibility(4);
    this.jRY.setVisibility(4);
    this.jRZ.setVisibility(4);
    this.jSa = ((ImageView)findViewById(a.e.face_detect_upload));
    this.jSb = ((ImageView)findViewById(a.e.face_detect_scan));
    this.jXR = ((ImageView)findViewById(a.e.face_loading));
    this.jSc = ((ImageView)findViewById(a.e.face_detect_upload_success_right));
  }
  
  private void aiG()
  {
    y.d("MicroMsg.FaceReflectUI", "initCamera");
    this.jWP = new a(this);
    this.jWP.jXn = this.jWI;
    this.jWP.jXo = this.jXo;
    this.jWP.jXp = this.jWE;
    this.jWP.jQQ = this.jQQ;
    this.jWP.jXr = this.jXr;
    this.jWP.mAppId = this.mAppId;
    this.jWP.djD = this.djD;
    this.jWP.jXs = this.jWH;
    this.jWP.aPD();
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    y.i("MicroMsg.FaceReflectUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.facedetect.ui.d paramd) {}
  
  public final void aNZ()
  {
    b.a.aPE();
    y.i("MicroMsg.FaceReflectLogic", "initAuth()");
    int i = YTCommonExInterface.initAuth(ae.getContext(), "rel_wechat_2055-12-06.lic1.2", 0, false);
    y.i("MicroMsg.FaceReflectUI", "auth：" + i);
    if (i != 0)
    {
      y.i("MicroMsg.FaceReflectUI", "initAuth failed");
      h.nFQ.a(917L, 29L, 1L, false);
      return;
    }
    y.i("MicroMsg.FaceReflectUI", "initAuth success");
    h.nFQ.a(917L, 28L, 1L, false);
    b localb = b.a.aPE();
    y.i("MicroMsg.FaceReflectLogic", "initYoutuInstance()");
    for (;;)
    {
      try
      {
        InputStream localInputStream1 = ae.getContext().getAssets().open("face_detect" + File.separator + "ufdmtcc.bin");
        InputStream localInputStream2 = ae.getContext().getAssets().open("face_detect" + File.separator + "ufat.bin");
        arrayOfByte2 = new byte[localInputStream1.available()];
        y.i("MicroMsg.FaceReflectLogic", "load ufat.bin or ufdmtcc.bin failed" + localIOException1.getMessage());
      }
      catch (IOException localIOException1)
      {
        try
        {
          localInputStream1.read(arrayOfByte2);
          arrayOfByte1 = new byte[localInputStream2.available()];
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            byte[] arrayOfByte2;
            byte[] arrayOfByte1 = null;
          }
        }
        try
        {
          localInputStream2.read(arrayOfByte1);
          localInputStream1.close();
          localInputStream2.close();
          i = YTFaceTraceInterface.initModel(arrayOfByte2, arrayOfByte1);
          y.i("MicroMsg.FaceReflectLogic", "YTFaceTraceInterface.initModel ret: %s", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label338;
          }
          y.i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.initModel failed，return:" + i);
          i = 0;
          if (i != 0) {
            YTCommonExInterface.setAppBrightness(this, 255);
          }
          localb.mState = 0;
          localb.jXm = this;
          return;
        }
        catch (IOException localIOException3)
        {
          break label308;
        }
        localIOException1 = localIOException1;
        arrayOfByte1 = null;
        arrayOfByte2 = null;
      }
      label308:
      continue;
      label338:
      i = YTAGReflectLiveCheckInterface.initModel(arrayOfByte2, arrayOfByte1);
      if (i != 0)
      {
        y.i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.initModel failed，return:" + i);
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
  }
  
  public final void aOb()
  {
    b localb = b.a.aPE();
    try
    {
      if ((localb.mState == 0) || (localb.mState == 1))
      {
        YTAGReflectLiveCheckInterface.cancel();
        return;
      }
      YTAGReflectLiveCheckInterface.releaseModel();
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.FaceReflectLogic", localException, "release error, e: %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final void aOe() {}
  
  public final void aPG()
  {
    y.i("MicroMsg.FaceReflectUI", "finish ReflectUI");
    FaceReflectMask localFaceReflectMask = this.jXo;
    localFaceReflectMask.jXO = true;
    localFaceReflectMask.jWC = true;
    localFaceReflectMask.invalidate();
    this.jXo.setBackgroundColor(-16777216);
    this.jXR.setVisibility(8);
    this.jWP.stopPreview();
    this.jWD.setVisibility(8);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  protected final int getLayoutId()
  {
    return a.g.face_live_layout;
  }
  
  public final void k(int paramInt, String paramString1, String paramString2)
  {
    y.i("MicroMsg.FaceReflectUI", "callbackDetectFailed()");
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    a(4, paramInt, paramString1, localBundle);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    b.a.aPE().onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    y.d("MicroMsg.FaceReflectUI", "start VerifyActivity");
    super.onCreate(paramBundle);
    YTCommonExInterface.setIsEnabledLog(true);
    YTCommonExInterface.setIsEnabledNativeLog(true);
    getWindow().addFlags(2097280);
    y.d("MicroMsg.FaceReflectUI", "getData");
    this.mAppId = getIntent().getStringExtra("k_app_id");
    this.djD = getIntent().getStringExtra("k_user_name");
    this.jMm = getIntent().getIntExtra("k_server_scene", -1);
    this.jQP = getIntent().getBooleanExtra("k_need_signature", false);
    if ((com.tencent.mm.plugin.facedetect.model.e.aOj()) || (getIntent().getBooleanExtra("key_is_need_video", false))) {
      bool = true;
    }
    this.jQU = bool;
    this.jMx = getIntent().getIntExtra("check_alive_flag", -1);
    this.jQQ = getIntent().getByteArrayExtra("k_bio_config");
    this.jXr = getIntent().getStringExtra("k_bio_id");
    y.i("MicroMsg.FaceReflectUI", "mConfig " + this.jQQ);
    y.i("MicroMsg.FaceReflectUI", "mBioID is " + this.jXr);
    y.i("MicroMsg.FaceReflectUI", "mAppID is " + this.mAppId);
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    if (paramBundle != null) {
      FaceDetectReporter.aOy().a(paramBundle);
    }
    FaceDetectReporter.aOy().appId = this.mAppId;
    if (o.y(this))
    {
      y.i("MicroMsg.FaceReflectUI", "carson: checkFacePermissionAnd Request true and do init ");
      aNZ();
      aPF();
      aiG();
      return;
    }
    y.i("MicroMsg.FaceReflectUI", "carson: no camera permission. request permission");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.FaceReflectUI", "onDestroy");
    aOb();
  }
  
  public void onPause()
  {
    y.d("MicroMsg.FaceReflectUI", "onPause");
    super.onPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.FaceReflectUI", "carson onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    aNZ();
    aPF();
    aiG();
  }
  
  public void onResume()
  {
    super.onResume();
    y.d("MicroMsg.FaceReflectUI", "onResume");
    y.i("MicroMsg.FaceReflectUI", "preview");
    this.jWP.jXl = true;
    this.jWI.setText(a.i.face_preview_tips);
  }
  
  public void onStart()
  {
    y.d("MicroMsg.FaceReflectUI", "onStart");
    super.onStart();
    if (this.jWP != null)
    {
      this.jWP.a(this.jWG);
      this.jWP.aPD();
    }
  }
  
  public void onStop()
  {
    y.i("MicroMsg.FaceReflectUI", "onStop");
    super.onStop();
    if (this.jWP != null) {
      this.jWP.jRs = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.FaceReflectUI
 * JD-Core Version:    0.7.0.1
 */