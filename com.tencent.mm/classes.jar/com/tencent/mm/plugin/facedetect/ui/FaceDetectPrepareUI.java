package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Messenger;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.b.p;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetectlight.Utils.a.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMFragmentActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectPrepareUI
  extends MMFragmentActivity
  implements android.support.v4.app.a.a, com.tencent.mm.plugin.facedetect.c.e
{
  private String djD;
  private boolean edT = false;
  private boolean gxZ = false;
  private String jMP = null;
  private float jMR;
  private int jMm;
  private com.tencent.mm.plugin.facedetect.b.d jMn = null;
  private int jMx;
  private long jNI;
  private com.tencent.mm.plugin.facedetect.c.a jQM = null;
  private a jQN = null;
  private c jQO = null;
  private boolean jQP;
  private byte[] jQQ;
  private boolean jQR = false;
  private boolean jQS = false;
  private FaceDetectPrepareUI.b jQT;
  private boolean jQU = false;
  private boolean jQV = false;
  private long jQW = -1L;
  private Messenger jQX = null;
  private FaceDetectPrepareUI.a jQY = null;
  private int jQZ = -1;
  private int jQp;
  private boolean jRa = false;
  private com.tencent.mm.plugin.facedetectlight.Utils.a jRb;
  private RelativeLayout jRc;
  private boolean jRd = false;
  private int jRe = -1;
  private boolean jRf = false;
  private String mAppId;
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean, FaceDetectPrepareUI.c paramc)
  {
    y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo showFailJumper showErrMsg: %s", new Object[] { paramString2 });
    Object localObject;
    if (this.jRf)
    {
      localObject = findViewById(a.e.face_tutorial_root);
      if (localObject != null)
      {
        y.i("MicroMsg.FaceDetectPrepareUI", "carson: hide tutorialRoot");
        ((View)localObject).setVisibility(8);
      }
      this.jRc.setVisibility(0);
    }
    if (paramBoolean)
    {
      localObject = getResources().getString(a.i.face_try_again);
      if (!paramBoolean) {
        break label183;
      }
    }
    label183:
    for (String str = getResources().getString(a.i.app_cancel);; str = null)
    {
      paramString1 = a.a(a.d.face_err_icon, paramString2, (String)localObject, str, new FaceDetectPrepareUI.2(this, paramBoolean, paramc, paramInt1, paramInt2, paramString1), new FaceDetectPrepareUI.3(this, paramInt1, paramInt2, paramString1));
      paramString1.status = 3;
      a.a(paramString1, getString(a.i.face_detect_feedback), new FaceDetectPrepareUI.4(this, paramInt2));
      ai.d(new FaceDetectPrepareUI.5(this, paramString1));
      return;
      localObject = getString(a.i.face_severe_error_main_btn);
      break;
    }
  }
  
  private void aOX()
  {
    if (this.jQM != null) {
      this.jQM.aNZ();
    }
  }
  
  private void aOY()
  {
    switch (this.jQp)
    {
    default: 
      return;
    case 0: 
      this.jRe = 0;
      return;
    case 1: 
      this.jRe = 1;
      return;
    }
    com.tencent.mm.plugin.facedetectlight.Utils.a locala = this.jRb;
    if (locala.jXd != null) {
      new StringBuilder("Light lux: ").append(com.tencent.mm.plugin.facedetectlight.Utils.a.a.a(locala.jXd));
    }
    for (float f = com.tencent.mm.plugin.facedetectlight.Utils.a.a.a(locala.jXd);; f = -1.0F)
    {
      y.i("MicroMsg.FaceDetectPrepareUI", "curLux is : " + f);
      y.i("MicroMsg.FaceDetectPrepareUI", "Light threshold is : " + this.jMR);
      if (f >= this.jMR) {
        break;
      }
      this.jRb.stop();
      this.jRe = 1;
      return;
    }
    this.jRe = 0;
  }
  
  private void aOZ()
  {
    this.jQZ = 2;
    if (this.jQM != null) {
      this.jQM.qG(0);
    }
    Intent localIntent = new Intent(this, FaceDetectUI.class);
    localIntent.putExtra("k_user_name", this.djD);
    localIntent.putExtra("k_server_scene", this.jMm);
    localIntent.putExtra("k_need_signature", this.jQP);
    localIntent.putExtra("k_bio_id", String.valueOf(this.jNI));
    localIntent.putExtra("k_bio_config", this.jQQ);
    y.i("MicroMsg.FaceDetectPrepareUI", "carson logic ");
    y.i("MicroMsg.FaceDetectPrepareUI", "Config is " + this.jQQ);
    y.i("MicroMsg.FaceDetectPrepareUI", "Carson bioID is " + this.jNI + "  string：" + String.valueOf(this.jNI));
    y.v("MicroMsg.FaceDetectPrepareUI", "alvinluo FaceDetectReporter info: %s", new Object[] { Long.valueOf(FaceDetectReporter.aOy().fKz) });
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.aOy());
    localIntent.putExtra("key_reporter_bundle", localBundle);
    if (this.jQN != null) {
      this.jQN.aOW();
    }
    startActivityForResult(localIntent, 1);
  }
  
  private void aPa()
  {
    if (this.jQN != null) {
      this.jQN.dismiss();
    }
    y.i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", new Object[] { Boolean.valueOf(this.jRd) });
    if (!this.jRd)
    {
      this.jQN = new a(this);
      this.jQN.create();
      return;
    }
    this.jQN = new b(this);
    this.jQN.create();
  }
  
  private void aPb()
  {
    String str = getString(a.i.face_detect_uploading);
    d locald = a.b(a.d.face_confirm_icon, str, null, getString(a.i.app_cancel), null, new FaceDetectPrepareUI.17(this));
    locald.jSs = true;
    locald.jSu = (str.length() - 3);
    locald.status = 1;
    a(false, true, locald);
  }
  
  private void aPc()
  {
    d(4, 90011, "get image failed", getString(a.i.face_detect_get_face_image_failed));
  }
  
  private void ag(int paramInt, String paramString)
  {
    if (hasError()) {
      if (this.jQM != null) {
        this.jQM.c(this.jQT.errType, this.jQT.errCode, this.jQT.aox, this.jQT.extras);
      }
    }
    for (;;)
    {
      this.edT = true;
      finish();
      return;
      if (this.jQM != null) {
        this.jQM.ae(paramInt, paramString);
      }
    }
  }
  
  private void aiO()
  {
    d(4, 90013, "init lib failed", getString(a.i.face_detect_init_err));
  }
  
  private void d(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    y.i("MicroMsg.FaceDetectPrepareUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
    d(paramInt1, paramInt2, paramString1, null);
    this.jQS = true;
    a(paramInt1, paramInt2, paramString1, paramString2, false, new FaceDetectPrepareUI.10(this));
  }
  
  private boolean hasError()
  {
    boolean bool2 = this.jQR;
    if (this.jQT == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo hasLastError: %b, lastError == null: %b, hashCode: %d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(hashCode()) });
      if ((!this.jQR) || (this.jQT == null)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void l(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (Object localObject = paramBundle.toString();; localObject = "null")
    {
      y.i("MicroMsg.FaceDetectPrepareUI", "hy: sending msg: cmd: %d, data: %s", new Object[] { Integer.valueOf(paramInt), localObject });
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putInt("k_cmd", paramInt);
      paramBundle = new Intent(this, FaceDetectProcessService.class);
      paramBundle.putExtras((Bundle)localObject);
      startService(paramBundle);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    y.i("MicroMsg.FaceDetectPrepareUI", "finishWithResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", k.qM(paramInt2));
    localBundle.putString("err_msg", paramString);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramString = new Intent();
    paramString.putExtras(localBundle);
    setResult(-1, paramString);
    if (this.jQU)
    {
      this.jQV = true;
      l(5, this.jQM.aOd());
    }
    finish();
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, d paramd)
  {
    if (paramBoolean2)
    {
      y.i("MicroMsg.FaceDetectPrepareUI", "hy: need blur");
      com.tencent.mm.sdk.f.e.post(new FaceDetectPrepareUI.16(this), "face_refresh_background");
    }
    this.jQN.a(paramd);
  }
  
  public final void aNZ()
  {
    y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo startFaceDetect");
    y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo preparing");
    if (this.jQM != null)
    {
      String str = getIntent().getExtras().getString("k_ticket");
      if (!bk.bl(str))
      {
        y.i("MicroMsg.FaceDetectBaseController", "hy: has prepared ticket. force set");
        p.Cm(str);
      }
    }
    y.i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", new Object[] { Boolean.valueOf(this.jRd) });
    if (!this.jRd)
    {
      y.i("MicroMsg.FaceDetectPrepareUI", "hy: start show jumper: %b", new Object[] { Boolean.valueOf(true) });
      this.jQW = bk.UZ();
      com.tencent.mm.sdk.f.e.post(new FaceDetectPrepareUI.15(this), "face_prepareInit");
    }
    aOY();
    int i;
    switch (this.jRe)
    {
    default: 
      i = 1;
    }
    for (;;)
    {
      if ((this.jMm == 0) || (this.jMm == 1) || (this.jMm == 3) || (this.jMm == 4)) {
        i = 1;
      }
      this.jMx = i;
      if (this.jQM != null)
      {
        this.jQM.jNj = this.jMx;
        this.jQM.aNY();
      }
      this.jRa = true;
      return;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  public final void aOb() {}
  
  public final void aOe()
  {
    this.jRa = false;
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo saveError errType: %d, errCode: %d, errMsg: %s, hashCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(hashCode()) });
    if (this.jQT == null) {
      this.jQT = new FaceDetectPrepareUI.b(this, (byte)0);
    }
    this.jQR = true;
    FaceDetectPrepareUI.b localb = this.jQT;
    localb.errType = paramInt1;
    localb.errCode = paramInt2;
    localb.aox = paramString;
    localb.extras = paramBundle;
  }
  
  public void finish()
  {
    y.i("MicroMsg.FaceDetectPrepareUI", "dismissJumper");
    if ((this.jQN != null) && (this.jQN.akH())) {
      this.jQN.dismiss();
    }
    if (this.jQO != null) {
      this.jQO.dismiss();
    }
    y.v("MicroMsg.FaceDetectPrepareUI", "alvinluo: releaseFaceDetect");
    if (this.jQM != null) {
      this.jQM.aOb();
    }
    super.finish();
    this.gxZ = true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 2)
    {
      this.jQZ = 1;
      this.jRc.setVisibility(0);
      if (paramIntent == null)
      {
        y.e("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult data is null");
        a(4, 90018, "system error", getString(a.i.face_get_confirm_info_failed_tips), false, new FaceDetectPrepareUI.11(this));
      }
    }
    String str;
    do
    {
      do
      {
        return;
        localObject = (FaceDetectReporter)paramIntent.getParcelableExtra("key_parcelable_reporter");
        if (localObject != null) {
          FaceDetectReporter.aOy().a((FaceDetectReporter)localObject);
        }
        paramInt1 = paramIntent.getIntExtra("err_type", -1);
        paramInt2 = paramIntent.getIntExtra("err_code", -1);
        str = paramIntent.getStringExtra("err_msg");
        if (this.jQM != null)
        {
          localObject = this.jQM;
          paramIntent.getExtras();
          ((com.tencent.mm.plugin.facedetect.c.a)localObject).m(paramInt1, paramInt2, str);
        }
        y.i("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          aPb();
          l(6, paramIntent.getExtras());
          return;
        }
        if (paramInt1 != 1) {
          break;
        }
      } while ((paramInt2 != 90004) && (paramInt2 != 90025));
      ag(paramInt2, str);
      return;
      localObject = paramIntent.getStringExtra("show_err_msg");
      if (paramInt2 == 90013) {
        paramIntent = getString(a.i.face_detect_init_err);
      }
      for (;;)
      {
        d(paramInt1, paramInt2, str, null);
        if (paramInt2 == 90023) {
          bool1 = true;
        }
        a(paramInt1, paramInt2, str, paramIntent, bool1, new FaceDetectPrepareUI.12(this));
        return;
        if ((paramInt2 == 90008) || (paramInt2 == 90010))
        {
          paramIntent = getString(a.i.permission_camera_request_again_msg);
        }
        else if (paramInt2 == 90009)
        {
          paramIntent = getString(a.i.permission_microphone_request_again_msg);
        }
        else
        {
          paramIntent = (Intent)localObject;
          if (bk.bl((String)localObject)) {
            paramIntent = getString(a.i.soter_face_err_msg_retry);
          }
        }
      }
      this.jQZ = 1;
      if (paramIntent == null)
      {
        y.e("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult data is null");
        a(4, 90018, "system error", getString(a.i.face_get_confirm_info_failed_tips), false, new FaceDetectPrepareUI.13(this));
        return;
      }
      localObject = (FaceDetectReporter)paramIntent.getParcelableExtra("key_parcelable_reporter");
      if (localObject != null) {
        FaceDetectReporter.aOy().a((FaceDetectReporter)localObject);
      }
      paramInt1 = paramIntent.getIntExtra("err_type", -1);
      paramInt2 = paramIntent.getIntExtra("err_code", -1);
      str = paramIntent.getStringExtra("err_msg");
      if (this.jQM != null)
      {
        localObject = this.jQM;
        paramIntent.getExtras();
        ((com.tencent.mm.plugin.facedetect.c.a)localObject).m(paramInt1, paramInt2, str);
      }
      y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aPb();
        l(1, null);
        return;
      }
      if (paramInt1 != 1) {
        break;
      }
    } while ((paramInt2 != 90004) && (paramInt2 != 90025));
    ag(paramInt2, str);
    return;
    Object localObject = paramIntent.getStringExtra("show_err_msg");
    if (paramInt2 == 90013) {
      paramIntent = getString(a.i.face_detect_init_err);
    }
    for (;;)
    {
      d(paramInt1, paramInt2, str, null);
      bool1 = bool2;
      if (paramInt2 == 90023) {
        bool1 = true;
      }
      a(paramInt1, paramInt2, str, paramIntent, bool1, new FaceDetectPrepareUI.14(this));
      return;
      if ((paramInt2 == 90008) || (paramInt2 == 90010))
      {
        paramIntent = getString(a.i.permission_camera_request_again_msg);
      }
      else if (paramInt2 == 90009)
      {
        paramIntent = getString(a.i.permission_microphone_request_again_msg);
      }
      else
      {
        paramIntent = (Intent)localObject;
        if (bk.bl((String)localObject)) {
          paramIntent = getString(a.i.soter_face_err_msg_retry);
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    if (hasError())
    {
      if (this.jQM != null) {
        this.jQM.c(this.jQT.errType, this.jQT.errCode, this.jQT.aox, this.jQT.extras);
      }
      return;
    }
    if (this.jQZ == 1)
    {
      ag(90003, "user cancel in init");
      return;
    }
    if (this.jQZ == 3)
    {
      ag(90005, "user cancel in uploading");
      return;
    }
    if (this.jQZ == 0)
    {
      ag(90002, "user cancel in tutorial");
      return;
    }
    ag(90050, "user cancel unknown");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(a.g.face_prepare_ui);
    this.jRc = ((RelativeLayout)findViewById(a.e.face_prepare_ui));
    this.jRc.setVisibility(4);
    getWindow().addFlags(2097280);
    this.mAppId = getIntent().getStringExtra("k_app_id");
    this.djD = getIntent().getStringExtra("k_user_name");
    this.jMm = getIntent().getIntExtra("k_server_scene", -1);
    this.jQP = getIntent().getBooleanExtra("k_need_signature", false);
    boolean bool;
    if ((com.tencent.mm.plugin.facedetect.model.e.aOj()) || (getIntent().getBooleanExtra("key_is_need_video", false)))
    {
      bool = true;
      this.jQU = bool;
      this.jMP = getIntent().getStringExtra("key_feedback_url");
      this.jQp = getIntent().getIntExtra("check_alive_type_response", -1);
      this.jMR = getIntent().getFloatExtra("mLight_threshold", -1.0F);
      this.jRb = a.b.aPA();
      this.jRb.de(this);
      y.i("MicroMsg.FaceDetectPrepareUI", "mIsNeedVideo： " + this.jQU);
      y.i("MicroMsg.FaceDetectPrepareUI", "check_alive_type is " + this.jQp);
      y.i("MicroMsg.FaceDetectPrepareUI", "mLight_threshold is " + this.jMR);
      y.i("MicroMsg.FaceDetectPrepareUI", "mChechLiveFlag is " + this.jMx);
      this.jQY = new FaceDetectPrepareUI.a(this, (byte)0);
      this.jQX = new Messenger(this.jQY);
      paramBundle = new Intent(this, FaceDetectProcessService.class);
      paramBundle.putExtra("k_messenger", this.jQX);
      startService(paramBundle);
      FaceContextData.a(new FaceContextData());
      o.z(this);
      paramBundle = com.tencent.mm.plugin.facedetect.c.b.jNn;
      this.jQM = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.jMm, this.jMx, getIntent().getExtras());
      if (this.jQM != null) {
        break label515;
      }
      aiO();
      label401:
      if (this.jQT != null)
      {
        paramBundle = this.jQT;
        paramBundle.errType = -1;
        paramBundle.errCode = -1;
        paramBundle.aox = "";
        if (paramBundle.extras != null) {
          paramBundle.extras.clear();
        }
      }
      this.jQR = false;
      this.jQZ = 1;
      aPa();
      if (!o.y(this)) {
        break label556;
      }
      y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo checkFacePermissionAnd Request true and do init ");
      aOX();
    }
    for (;;)
    {
      if (this.jQU)
      {
        paramBundle = new Bundle();
        paramBundle.putBoolean("key_is_need_video", this.jQU);
        l(4, paramBundle);
      }
      return;
      bool = false;
      break;
      label515:
      this.jQM.a(new FaceDetectPrepareUI.6(this));
      this.jMn = new com.tencent.mm.plugin.facedetect.b.d()
      {
        private double jRk = 0.0D;
        
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString)
        {
          y.i("MicroMsg.FaceDetectPrepareUI", "onError scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, FaceDetectPrepareUI.this.getString(a.i.soter_face_err_msg_retry));
        }
        
        public final void h(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousm.getType()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousInt1 = FaceDetectPrepareUI.qR(paramAnonymousInt1);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            FaceDetectPrepareUI.this.d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null);
          }
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).h(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousm);
          }
        }
        
        public final void i(String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onUploadEnd");
          int i = FaceDetectPrepareUI.qR(0);
          if (i != 0) {
            FaceDetectPrepareUI.this.d(i, 0, paramAnonymousString, paramAnonymousBundle);
          }
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).b(i, paramAnonymousString, paramAnonymousBundle);
          }
        }
        
        public final void s(double paramAnonymousDouble)
        {
          y.i("MicroMsg.FaceDetectPrepareUI", "hy: reg on process : %f", new Object[] { Double.valueOf(paramAnonymousDouble) });
          this.jRk = (100.0D * paramAnonymousDouble);
        }
      };
      this.jQM.a(this.jMn);
      break label401;
      label556:
      y.i("MicroMsg.FaceDetectPrepareUI", "hy: no camera permission. request permission");
    }
  }
  
  protected void onDestroy()
  {
    y.i("MicroMsg.FaceDetectPrepareUI", "onDestroy");
    super.onDestroy();
    if (!this.jQV) {
      stopService(new Intent(this, FaceDetectProcessService.class));
    }
    if (this.jRb != null) {
      this.jRb.stop();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 90008;
    y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      y.i("MicroMsg.FaceDetectPrepareUI", "carson：finish()");
      return;
    }
    Object localObject1 = "";
    String str = "";
    if (paramArrayOfInt.length == 1)
    {
      if (paramArrayOfInt[0] == 0)
      {
        paramInt = 1;
        label77:
        if (paramInt == 0) {
          break label232;
        }
        aOX();
        return;
      }
      if (paramArrayOfString[0].equals("android.permission.CAMERA"))
      {
        localObject1 = "camera permission not granted";
        paramArrayOfString = getString(a.i.permission_camera_request_again_msg);
        paramInt = i;
      }
    }
    for (;;)
    {
      this.jRc.setVisibility(0);
      y.i("MicroMsg.FaceDetectPrepareUI", " mFacePrepareLayout, visible: %s", new Object[] { Integer.valueOf(this.jRc.getVisibility()) });
      paramArrayOfInt = findViewById(a.e.face_tutorial_root);
      if (paramArrayOfInt != null) {
        paramArrayOfInt.setVisibility(8);
      }
      d(1, paramInt, (String)localObject1, paramArrayOfString);
      paramInt = 0;
      break label77;
      if (paramArrayOfString[0].equals("android.permission.RECORD_AUDIO"))
      {
        localObject1 = "audio permission not granted";
        paramArrayOfString = getString(a.i.permission_microphone_request_again_msg);
        paramInt = 90009;
        continue;
        if (paramArrayOfInt.length == 2)
        {
          if ((paramArrayOfInt[0] == 0) && (paramArrayOfInt[1] == 0))
          {
            paramInt = 1;
            break label77;
            label232:
            break;
          }
          Object localObject2;
          if (paramArrayOfInt[0] != 0)
          {
            localObject2 = "camera permission not granted";
            str = getString(a.i.permission_camera_request_again_msg);
          }
          for (;;)
          {
            if (paramArrayOfInt[1] != 0)
            {
              localObject2 = "audio permission not granted";
              str = getString(a.i.permission_microphone_request_again_msg);
              i = 90009;
            }
            paramArrayOfString = str;
            localObject1 = localObject2;
            paramInt = i;
            if (paramArrayOfInt[0] == 0) {
              break;
            }
            paramArrayOfString = str;
            localObject1 = localObject2;
            paramInt = i;
            if (paramArrayOfInt[1] == 0) {
              break;
            }
            paramInt = 90010;
            localObject1 = "both camera and audio permission not granted";
            paramArrayOfString = getString(a.i.permission_camera_request_again_msg);
            break;
            i = -1;
            localObject2 = localObject1;
          }
        }
      }
      paramInt = -1;
      paramArrayOfString = str;
    }
  }
  
  protected void onResume()
  {
    y.i("MicroMsg.FaceDetectPrepareUI", "onResume");
    super.onResume();
    this.jRa = true;
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jRa)
    {
      if ((!this.gxZ) && (hasError())) {
        a(this.jQT.errType, this.jQT.errCode, this.jQT.aox, this.jQT.extras);
      }
    }
    else {
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI
 * JD-Core Version:    0.7.0.1
 */