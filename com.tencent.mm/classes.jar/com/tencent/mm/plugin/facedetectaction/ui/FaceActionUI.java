package com.tencent.mm.plugin.facedetectaction.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetectaction.b.a.a;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;

@com.tencent.mm.ui.base.a(3)
public class FaceActionUI
  extends MMActivity
{
  int bIC;
  private long endTime;
  RelativeLayout jRX;
  RelativeLayout jRY;
  RelativeLayout jRZ;
  ImageView jSa;
  ImageView jSb;
  ImageView jSc;
  private int jVL;
  private String jVM;
  private a.a jVP;
  RelativeLayout jWD;
  private PreviewFrameLayout jWE;
  private FaceActionMask jWF;
  private MMTextureView jWG;
  ImageView jWH;
  private TextView jWI;
  private TextView jWJ;
  private ImageView jWK;
  private Button jWL;
  private Button jWM;
  private TextView jWN;
  public boolean jWO = false;
  com.tencent.mm.plugin.facedetectlight.ui.a jWP;
  private int jWQ;
  private int jWR;
  private String jWS;
  private int jWT;
  private int scene;
  private long startTime;
  
  private void aOX()
  {
    this.jVP = new FaceActionUI.1(this);
    d.jWf.jWl = new FaceActionUI.2(this);
    d.jWf.bER = this;
    d.jWf.a(this);
  }
  
  private void aPy()
  {
    this.jWD = ((RelativeLayout)findViewById(a.e.face_preview_layout));
    this.jWE = ((PreviewFrameLayout)findViewById(a.e.face_live_preview_layout));
    this.jWG = ((MMTextureView)findViewById(a.e.face_live_detection_preview));
    this.jWG.setVisibility(4);
    this.jWF = ((FaceActionMask)findViewById(a.e.face_live_preview_mask));
    this.jWK = ((ImageView)findViewById(a.e.face_action_loading));
    this.jWK.post(new FaceActionUI.3(this));
    this.jWI = ((TextView)findViewById(a.e.face_live_tip_tv));
    this.jWI.post(new FaceActionUI.4(this));
    this.jWJ = ((TextView)findViewById(a.e.face__back));
    this.jWJ.setOnClickListener(new FaceActionUI.5(this));
  }
  
  private void aPz()
  {
    y.i("MicroMsg.FaceActionUI", "preview");
    if (this.jWP != null)
    {
      this.jWP.jXl = true;
      y.i("MicroMsg.FaceActionUI", "mCamera ！= null");
    }
    this.jWI.setText(a.i.face_preview_tips);
  }
  
  public final void a(String paramString, int paramInt, Bundle paramBundle, Boolean paramBoolean)
  {
    y.i("MicroMsg.FaceActionUI", "finishWithResult errMsg: %s, errCode: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramBoolean.booleanValue())
    {
      paramBoolean = "yes";
      Bundle localBundle = new Bundle();
      localBundle.putString("click_other_verify_btn", paramBoolean);
      if (paramBundle != null) {
        localBundle.putAll(paramBundle);
      }
      paramBundle = new Bundle();
      paramBundle.putInt("err_code", paramInt);
      paramBundle.putString("err_msg", paramString);
      paramBundle.putInt("scene", this.scene);
      paramBundle.putInt("countFace", this.jWT);
      paramBundle.putInt("err_type", this.bIC);
      this.endTime = bk.UZ();
      y.i("MicroMsg.FaceActionUI", "endTime：" + this.endTime);
      y.i("MicroMsg.FaceActionUI", "startTime：" + this.startTime);
      paramBundle.putLong("totalTime", this.endTime - this.startTime);
      paramBundle.putAll(localBundle);
      paramBoolean = new Intent();
      paramBoolean.putExtras(paramBundle);
      paramInt = -1;
      switch (paramString.hashCode())
      {
      default: 
        switch (paramInt)
        {
        default: 
          label256:
          setResult(-1, paramBoolean);
        }
        break;
      }
    }
    for (;;)
    {
      new ah().postDelayed(new FaceActionUI.9(this), 1500L);
      return;
      paramBoolean = "no";
      break;
      if (!paramString.equals("ok")) {
        break label256;
      }
      paramInt = 0;
      break label256;
      if (!paramString.equals("fail")) {
        break label256;
      }
      paramInt = 1;
      break label256;
      if (!paramString.equals("cancel")) {
        break label256;
      }
      paramInt = 2;
      break label256;
      setResult(-1, paramBoolean);
      continue;
      setResult(1, paramBoolean);
      continue;
      setResult(0, paramBoolean);
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.face_action_layout;
  }
  
  public void onBackPressed()
  {
    d.jWf.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    y.d("MicroMsg.FaceActionUI", "start VerifyActivity");
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getWindow().addFlags(2097280);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.jWT = 0;
    this.startTime = bk.UZ();
    this.bIC = 4;
    y.d("MicroMsg.FaceActionUI", "initLayout");
    this.jWH = ((ImageView)findViewById(a.e.background_view));
    aPy();
    this.jRX = ((RelativeLayout)findViewById(a.e.face_upload_layout));
    this.jRY = ((RelativeLayout)findViewById(a.e.face_upload_success_layout));
    this.jRZ = ((RelativeLayout)findViewById(a.e.face_upload_failed_layout));
    this.jRX.setVisibility(4);
    this.jRY.setVisibility(4);
    this.jRZ.setVisibility(4);
    this.jSa = ((ImageView)findViewById(a.e.face_detect_upload));
    this.jSb = ((ImageView)findViewById(a.e.face_detect_scan));
    this.jSc = ((ImageView)findViewById(a.e.face_detect_upload_success_right));
    this.jWN = ((TextView)findViewById(a.e.face_detect_upload_failed_tips));
    this.jWL = ((Button)findViewById(a.e.face_detect_upload_failed_btn1));
    this.jWM = ((Button)findViewById(a.e.face_detect_upload_failed_btn2));
    if (!bk.bl(d.jWf.bXB))
    {
      this.jWM.setText(d.jWf.bXB);
      this.jWM.setOnClickListener(new FaceActionUI.6(this));
    }
    while (o.y(this))
    {
      y.i("MicroMsg.FaceActionUI", "carson: checkFacePermissionAnd Request true and do init ");
      aOX();
      return;
      this.jWM.setVisibility(8);
    }
    y.i("MicroMsg.FaceActionUI", "carson: no camera permission. request permission");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.FaceActionUI", "onDestroy");
    d.jWf.release(true);
  }
  
  public void onPause()
  {
    y.d("MicroMsg.FaceActionUI", "onPause");
    super.onPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.FaceActionUI", "carson onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    String str2 = "";
    String str3 = "";
    label61:
    String str1;
    Object localObject;
    if (paramArrayOfInt.length == 1)
    {
      if (paramArrayOfInt[0] == 0)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label296;
        }
        aOX();
        return;
      }
      if (paramArrayOfString[0].equals("android.permission.CAMERA"))
      {
        str1 = "camera permission not granted";
        localObject = getString(a.i.permission_camera_request_again_msg);
      }
    }
    for (;;)
    {
      y.i("MicroMsg.FaceActionUI", "carson PermissionsResult:errMsg" + str1);
      y.i("MicroMsg.FaceActionUI", "carson PermissionsResult:showErrMsg" + (String)localObject);
      y.i("MicroMsg.FaceActionUI", "checkPermissionFailedAnimation");
      this.jWN.setText((CharSequence)localObject);
      this.jWL.setText(a.i.face_severe_error_main_btn);
      this.jWL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          y.i("MicroMsg.FaceActionUI", "click finish");
          FaceActionUI.this.u("fail", 90010, "");
        }
      });
      this.jWD.setVisibility(8);
      this.jRZ.setVisibility(0);
      this.jSb.clearAnimation();
      this.jWH.setVisibility(0);
      this.jRX.setVisibility(8);
      paramInt = 0;
      break label61;
      localObject = str3;
      str1 = str2;
      if (paramArrayOfString[0].equals("android.permission.RECORD_AUDIO"))
      {
        str1 = "audio permission not granted";
        localObject = getString(a.i.permission_microphone_request_again_msg);
        continue;
        localObject = str3;
        str1 = str2;
        if (paramArrayOfInt.length == 2)
        {
          if ((paramArrayOfInt[0] == 0) && (paramArrayOfInt[1] == 0))
          {
            paramInt = 1;
            break label61;
            label296:
            break;
          }
          paramArrayOfString = str3;
          if (paramArrayOfInt[0] != 0)
          {
            str2 = "camera permission not granted";
            paramArrayOfString = getString(a.i.permission_camera_request_again_msg);
          }
          if (paramArrayOfInt[1] != 0)
          {
            str2 = "audio permission not granted";
            paramArrayOfString = getString(a.i.permission_microphone_request_again_msg);
          }
          localObject = paramArrayOfString;
          str1 = str2;
          if (paramArrayOfInt[0] != 0)
          {
            localObject = paramArrayOfString;
            str1 = str2;
            if (paramArrayOfInt[1] != 0)
            {
              str1 = "both camera and audio permission not granted";
              localObject = getString(a.i.permission_camera_request_again_msg);
            }
          }
        }
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    y.d("MicroMsg.FaceActionUI", "onResume");
    aPz();
  }
  
  public void onStart()
  {
    y.d("MicroMsg.FaceActionUI", "onStart");
    super.onStart();
    if (this.jWP != null)
    {
      this.jWP.a(this.jWG);
      this.jWP.aPD();
    }
  }
  
  public void onStop()
  {
    y.i("MicroMsg.FaceActionUI", "onStop");
    super.onStop();
    if (this.jWP != null) {
      this.jWP.jRs = false;
    }
  }
  
  public final void u(String paramString1, int paramInt, String paramString2)
  {
    y.i("MicroMsg.FaceActionUI", "callbackDetectFailed（）");
    Bundle localBundle = new Bundle();
    localBundle.putString("token", paramString2);
    a(paramString1, paramInt, localBundle, Boolean.valueOf(this.jWO));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI
 * JD-Core Version:    0.7.0.1
 */