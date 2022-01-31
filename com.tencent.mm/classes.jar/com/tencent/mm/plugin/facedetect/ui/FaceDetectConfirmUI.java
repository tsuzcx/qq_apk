package com.tencent.mm.plugin.facedetect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.b.l;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetectlight.Utils.a.b;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectConfirmUI
  extends MMActivity
  implements f
{
  private String appId;
  private int businessType;
  private String gYJ;
  private String gyF;
  private String jMO = null;
  private String jMP = null;
  private String jMQ = null;
  private float jMR;
  private TextView jQi;
  private Button jQj;
  private CheckBox jQk;
  private TextView jQl;
  private TextView jQm;
  private bfr jQn = null;
  private int jQo;
  private int jQp;
  private com.tencent.mm.ui.base.p tipDialog;
  
  private void aOV()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("err_code", k.qM(90024));
    localIntent.putExtra("err_msg", "user cancel in confirm ui");
    FaceDetectReporter.aOy().a(this.businessType, false, 3, 1, 90024);
    FaceDetectReporter.aOy().jOz = System.currentTimeMillis();
    FaceDetectReporter.aOy().bA(this.gYJ, this.businessType);
    setResult(0, localIntent);
    finish();
  }
  
  private void dismissDialog()
  {
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
  }
  
  public void finish()
  {
    dismissDialog();
    super.finish();
  }
  
  protected final int getLayoutId()
  {
    return a.g.face_confirm_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    FaceDetectReporter.aOy().jOz = System.currentTimeMillis();
    FaceDetectReporter.aOy().bA(this.gYJ, this.businessType);
    setResult(paramInt2, paramIntent);
    finish();
  }
  
  public void onBackPressed()
  {
    aOV();
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.appId = getIntent().getStringExtra("k_app_id");
    this.gyF = getIntent().getStringExtra("request_verify_pre_info");
    this.gYJ = getIntent().getStringExtra("key_function_name");
    this.businessType = getIntent().getIntExtra("key_business_type", -1);
    this.jQo = getIntent().getIntExtra("check_alive_type", 0);
    y.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type : %s", new Object[] { Integer.valueOf(this.jQo) });
    y.i("MicroMsg.FaceDetectConfirmUI", "carson businessType : %s", new Object[] { Integer.valueOf(this.businessType) });
    setMMTitle(getString(a.i.face_confirm_ui_title));
    setBackBtn(new FaceDetectConfirmUI.1(this));
    this.jQi = ((TextView)findViewById(a.e.face_confirm_header_tips));
    this.jQj = ((Button)findViewById(a.e.start_face_detect_button));
    this.jQk = ((CheckBox)findViewById(a.e.face_confirm_protocol_checkbox));
    this.jQk.setOnCheckedChangeListener(new FaceDetectConfirmUI.2(this));
    this.jQk.setVisibility(8);
    this.jQl = ((TextView)findViewById(a.e.face_confirm_protocol_checkbox_text));
    this.jQm = ((TextView)findViewById(a.e.face_complain));
    this.jQj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        y.d("MicroMsg.FaceDetectConfirmUI", "check_alive_type is %s", new Object[] { Integer.valueOf(FaceDetectConfirmUI.c(FaceDetectConfirmUI.this)) });
        paramAnonymousView = new Intent(FaceDetectConfirmUI.this, FaceDetectPrepareUI.class);
        Bundle localBundle = FaceDetectConfirmUI.this.getIntent().getExtras();
        if (localBundle != null)
        {
          localBundle.putString("key_feedback_url", FaceDetectConfirmUI.d(FaceDetectConfirmUI.this));
          localBundle.putInt("check_alive_type_response", FaceDetectConfirmUI.c(FaceDetectConfirmUI.this));
          localBundle.putString("key_feedback_url", FaceDetectConfirmUI.d(FaceDetectConfirmUI.this));
          localBundle.putFloat("mLight_threshold", FaceDetectConfirmUI.e(FaceDetectConfirmUI.this));
          y.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type_response is " + FaceDetectConfirmUI.c(FaceDetectConfirmUI.this));
          paramAnonymousView.putExtras(localBundle);
          FaceDetectConfirmUI.this.startActivityForResult(paramAnonymousView, 1);
          return;
        }
        y.e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
      }
    });
    y.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
    paramBundle = this.mController.uMN;
    getString(a.i.app_tip);
    this.tipDialog = h.b(paramBundle, getString(a.i.app_waiting), false, new FaceDetectConfirmUI.4(this));
    paramBundle = new l(this.appId, this.gyF, this.jQo);
    g.Dk().a(1147, this);
    g.Dk().a(paramBundle, 0);
    a.b.aPA().de(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    a.b.aPA().stop();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    bfr localbfr;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jQn = ((l)paramm).jMN;
      this.jMO = ((l)paramm).jMO;
      this.jMP = ((l)paramm).jMP;
      this.jMQ = ((l)paramm).jMQ;
      this.jMR = ((l)paramm).jMR;
      this.jQp = ((l)paramm).jMS;
      if (bk.bl(this.jMO)) {
        this.jMO = getString(a.i.face_confirm_tips);
      }
      dismissDialog();
      this.jQj.setEnabled(true);
      this.jQi.setText(this.jMO);
      if (this.jQn != null)
      {
        y.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s, url_wording: %s, url: %s", new Object[] { this.jQn.bQZ, this.jQn.tAy, this.jQn.url });
        localbfr = this.jQn;
        y.i("MicroMsg.FaceDetectConfirmUI", "alvinluo protocol info: %s", new Object[] { localbfr.bQZ });
        if (!bk.bl(localbfr.bQZ)) {
          break label446;
        }
        paramString = getString(a.i.face_confirm_protocol_tips);
        if (!bk.bl(localbfr.tAy)) {
          break label455;
        }
        paramm = getString(a.i.face_confirm_protocol_details);
        label279:
        Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramString + paramm);
        localSpannable.setSpan(new FaceDetectConfirmUI.6(this, localbfr), paramString.length(), paramString.length() + paramm.length(), 33);
        this.jQk.setVisibility(0);
        this.jQl.setVisibility(0);
        this.jQl.setText(localSpannable);
        this.jQl.setMovementMethod(LinkMovementMethod.getInstance());
        if (localbfr.tAz != 0) {
          break label465;
        }
        this.jQk.setChecked(false);
        this.jQj.setEnabled(false);
        label398:
        this.jQm.setText(getString(a.i.face_confirm_complain_tips));
        this.jQm.setOnClickListener(new FaceDetectConfirmUI.7(this));
        this.jQm.setVisibility(0);
      }
    }
    for (;;)
    {
      g.Dk().b(1147, this);
      return;
      label446:
      paramString = localbfr.bQZ;
      break;
      label455:
      paramm = localbfr.tAy;
      break label279;
      label465:
      if (localbfr.tAz != 1) {
        break label398;
      }
      this.jQk.setChecked(true);
      this.jQj.setEnabled(true);
      break label398;
      paramm = paramString;
      if (bk.bl(paramString)) {
        paramm = getString(a.i.face_get_confirm_info_failed_tips);
      }
      dismissDialog();
      h.a(this, paramm, getString(a.i.app_tip), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("err_code", k.qM(90022));
          paramAnonymousDialogInterface.putExtra("err_msg", "get confirm info error");
          FaceDetectReporter.aOy().a(FaceDetectConfirmUI.f(FaceDetectConfirmUI.this), false, 3, 2, 90022);
          FaceDetectReporter.aOy().jOz = System.currentTimeMillis();
          FaceDetectReporter.aOy().bA(FaceDetectConfirmUI.g(FaceDetectConfirmUI.this), FaceDetectConfirmUI.f(FaceDetectConfirmUI.this));
          FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, paramAnonymousDialogInterface);
          FaceDetectConfirmUI.this.finish();
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI
 * JD-Core Version:    0.7.0.1
 */