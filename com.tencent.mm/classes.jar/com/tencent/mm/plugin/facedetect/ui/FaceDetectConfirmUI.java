package com.tencent.mm.plugin.facedetect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.b.m;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.i;
import com.tencent.mm.plugin.flash.FaceFlashUI;
import com.tencent.mm.plugin.flash.d.b.b;
import com.tencent.mm.protocal.protobuf.ehp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.pulldown.c;

@com.tencent.mm.ui.base.a(3)
@c(0)
public class FaceDetectConfirmUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String appId;
  private int businessType;
  private w tipDialog;
  private String trR;
  private String zRQ = null;
  private String zRR = null;
  private String zRS = null;
  private float zRT;
  private String zRV;
  private float zRW = 0.0F;
  private ehp zRZ;
  private String zSa;
  private boolean zVA = false;
  private TextView zVe;
  private Button zVf;
  private CheckBox zVg;
  private TextView zVh;
  private TextView zVi;
  private ehp zVj = null;
  private String zVk;
  private int zVl;
  private int zVm;
  private ImageView zVn;
  private TextView zVo;
  private String zVp;
  private String zVq;
  private String zVr = "";
  private ViewGroup zVs;
  private long zVt = 0L;
  private ViewGroup zVu;
  private ViewGroup zVv;
  private TextView zVw;
  private ViewGroup zVx;
  private CheckBox zVy;
  private TextView zVz;
  
  private void aDM()
  {
    AppMethodBeat.i(103896);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(103896);
  }
  
  private void bSt()
  {
    AppMethodBeat.i(103893);
    Intent localIntent = new Intent();
    localIntent.putExtra("err_code", i.Ms(90024));
    localIntent.putExtra("err_msg", "user cancel in confirm ui");
    FaceDetectReporter.dOU().av(this.businessType, 1, 90024);
    com.tencent.mm.plugin.flash.c.b.F("msgVerify", "user cancel in confirm ui");
    com.tencent.mm.plugin.flash.c.b.VL(90024);
    FaceDetectReporter.dOU().zTD = System.currentTimeMillis();
    FaceDetectReporter.dOU().eq(this.trR, this.businessType);
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(103893);
  }
  
  private void dPq()
  {
    AppMethodBeat.i(271915);
    Intent localIntent = new Intent();
    localIntent.putExtra("err_code", i.Ms(90022));
    localIntent.putExtra("err_msg", "get confirm info error");
    localIntent.putExtra("verify_result", this.zVr);
    FaceDetectReporter.dOU().av(this.businessType, 2, 90022);
    com.tencent.mm.plugin.flash.c.b.VL(90022);
    FaceDetectReporter.dOU().zTD = System.currentTimeMillis();
    FaceDetectReporter.dOU().eq(this.trR, this.businessType);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(271915);
  }
  
  public void finish()
  {
    AppMethodBeat.i(103895);
    aDM();
    super.finish();
    AppMethodBeat.o(103895);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.face_confirm_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(103892);
    Log.i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    FaceDetectReporter.dOU().zTD = System.currentTimeMillis();
    if ((paramIntent != null) && (paramIntent.hasExtra("err_code"))) {
      paramIntent.putExtra("err_code", i.Ms(paramIntent.getIntExtra("err_code", -1)));
    }
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(103892);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(103894);
    if (this.zVA) {
      dPq();
    }
    for (;;)
    {
      super.onBackPressed();
      AppMethodBeat.o(103894);
      return;
      bSt();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103890);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.flash.c.b.fuO().ivz = System.currentTimeMillis();
    hideActionbarLine();
    this.appId = getIntent().getStringExtra("appId");
    this.zVk = getIntent().getStringExtra("request_verify_pre_info");
    this.trR = getIntent().getStringExtra("key_function_name");
    this.businessType = getIntent().getIntExtra("key_business_type", -1);
    this.zVl = getIntent().getIntExtra("check_alive_type", 0);
    this.zVt = System.currentTimeMillis();
    Log.i("MicroMsg.FaceDetectConfirmUI", "appId:%s jsonData:%s functionName:%s businessType:%s check_alive_type_request:%s", new Object[] { this.appId, this.zVk, this.trR, Integer.valueOf(this.businessType), Integer.valueOf(this.zVl) });
    this.zVu = ((ViewGroup)findViewById(a.e.face_confirm_success_layout));
    this.zVv = ((ViewGroup)findViewById(a.e.face_confirm_fail_layout));
    setMMTitle("");
    setActionbarColor(getResources().getColor(a.b.white));
    setBackBtn(new FaceDetectConfirmUI.1(this));
    this.zVe = ((TextView)findViewById(a.e.face_confirm_header_tips));
    this.zVf = ((Button)findViewById(a.e.start_face_detect_button));
    this.zVn = ((ImageView)findViewById(a.e.applicant_icon));
    this.zVo = ((TextView)findViewById(a.e.applicant_name));
    this.zVs = ((ViewGroup)findViewById(a.e.face_confirm_protocol_checkbox_parent));
    this.zVs.setOnClickListener(new FaceDetectConfirmUI.6(this));
    this.zVg = ((CheckBox)findViewById(a.e.face_confirm_protocol_checkbox));
    this.zVg.setOnCheckedChangeListener(new FaceDetectConfirmUI..ExternalSyntheticLambda2(this));
    this.zVg.setVisibility(8);
    this.zVh = ((TextView)findViewById(a.e.face_confirm_protocol_checkbox_text));
    this.zVh.setOnClickListener(new FaceDetectConfirmUI.7(this));
    this.zVi = ((TextView)findViewById(a.e.face_complain));
    this.zVw = ((TextView)findViewById(a.e.wechat_header_tips_confirm_tv));
    this.zVx = ((ViewGroup)findViewById(a.e.face_confirm_wechat_protocol_checkbox_parent));
    this.zVz = ((TextView)findViewById(a.e.face_confirm_wechat_protocol_checkbox_text));
    this.zVy = ((CheckBox)findViewById(a.e.face_confirm_wechat_protocol_checkbox));
    this.zVx.setVisibility(8);
    this.zVy.setOnCheckedChangeListener(new FaceDetectConfirmUI..ExternalSyntheticLambda1(this));
    this.zVx.setOnClickListener(new FaceDetectConfirmUI..ExternalSyntheticLambda0(this));
    this.zVf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(103885);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.d("MicroMsg.FaceDetectConfirmUI", "check_alive_type is %s", new Object[] { Integer.valueOf(FaceDetectConfirmUI.c(FaceDetectConfirmUI.this)) });
        if (!com.tencent.mm.plugin.facedetect.model.k.as(FaceDetectConfirmUI.this))
        {
          Log.e("MicroMsg.FaceDetectConfirmUI", "carson: no camera permission. request permission");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(103885);
          return;
        }
        paramAnonymousView = FaceDetectConfirmUI.this.getIntent().getExtras();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.putInt("check_alive_type", FaceDetectConfirmUI.c(FaceDetectConfirmUI.this));
          paramAnonymousView.putString("appId", FaceDetectConfirmUI.d(FaceDetectConfirmUI.this));
          paramAnonymousView.putString("feedbackUrl", FaceDetectConfirmUI.e(FaceDetectConfirmUI.this));
          paramAnonymousView.putString("business_tips", FaceDetectConfirmUI.f(FaceDetectConfirmUI.this));
          paramAnonymousView.putFloat("mLight_threshold", FaceDetectConfirmUI.g(FaceDetectConfirmUI.this));
          paramAnonymousView.putLong("confirm_page_timestamp", FaceDetectConfirmUI.h(FaceDetectConfirmUI.this));
          if ((FaceDetectConfirmUI.i(FaceDetectConfirmUI.this) >= 0.2D) && (FaceDetectConfirmUI.i(FaceDetectConfirmUI.this) <= 0.9D)) {
            com.tencent.mm.plugin.flash.view.FaceFlashReflectMask.HjJ = FaceDetectConfirmUI.i(FaceDetectConfirmUI.this) / 2.0F;
          }
          Log.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type_response is " + FaceDetectConfirmUI.c(FaceDetectConfirmUI.this));
          FaceFlashUI.d(FaceDetectConfirmUI.this, paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(103885);
          return;
          Log.e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
        }
      }
    });
    Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
    paramBundle = getContext();
    getString(a.i.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.k.a(paramBundle, getString(a.i.app_waiting), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    paramBundle = new m(this.appId, this.zVk, this.zVl);
    com.tencent.mm.kernel.h.aZW().a(1147, this);
    com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
    b.b.fuS().fuR();
    com.tencent.mm.plugin.flash.c.b.VN(1);
    AppMethodBeat.o(103890);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(103897);
    super.onDestroy();
    b.b.fuS().stop();
    AppMethodBeat.o(103897);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(271949);
    Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(271949);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(271949);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.zVf.performClick();
        AppMethodBeat.o(271949);
        return;
      }
      com.tencent.mm.ui.base.k.a(this, getString(a.i.face_permission_camera_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(271900);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.pluginsdk.permission.b.lx(FaceDetectConfirmUI.this.getContext());
          AppMethodBeat.o(271900);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(271901);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(271901);
        }
      });
      AppMethodBeat.o(271949);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.zVf.performClick();
        AppMethodBeat.o(271949);
        return;
      }
      com.tencent.mm.ui.base.k.a(this, getString(a.i.face_permission_micro_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(271902);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.pluginsdk.permission.b.lx(FaceDetectConfirmUI.this.getContext());
          AppMethodBeat.o(271902);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(271904);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(271904);
        }
      });
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(103891);
    Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.plugin.flash.c.b.F("confirmCode", Integer.valueOf(paramInt1));
    com.tencent.mm.plugin.flash.c.b.F("confirmMsg", paramString);
    this.zRR = ((m)paramp).zRR;
    this.zVr = ((m)paramp).zRY;
    this.zRW = ((m)paramp).zRW;
    Log.i("MicroMsg.FaceDetectConfirmUI", "mFeedbackUrl:%s", new Object[] { this.zRR });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.zVj = ((m)paramp).zRN;
      this.zRQ = ((m)paramp).zRQ;
      this.zRS = ((m)paramp).zRS;
      this.zRT = ((m)paramp).zRT;
      this.zVm = ((m)paramp).zRU;
      this.zRV = ((m)paramp).zRV;
      this.zVp = ((m)paramp).zRO;
      this.zVq = ((m)paramp).zRP;
      this.zSa = ((m)paramp).zSa;
      this.zRZ = ((m)paramp).zRZ;
      Log.d("MicroMsg.FaceDetectConfirmUI", paramp.toString());
      if (Util.isNullOrNil(this.zRQ)) {
        this.zRQ = getString(a.i.face_confirm_tips);
      }
      aDM();
      this.zVf.setEnabled(true);
      this.zVe.setText(this.zRQ);
      paramString = String.format(getString(a.i.face_confirm_ui_request_use_tip), new Object[] { this.zVq });
      this.zVo.setText(paramString);
      r.bKe().loadImage(this.zVp, this.zVn);
      if (this.zVj != null)
      {
        Log.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s, url_wording: %s, url: %s", new Object[] { this.zVj.wording, this.zVj.ZQe, this.zVj.url });
        localObject1 = this.zVj;
        Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo protocol info: %s", new Object[] { ((ehp)localObject1).wording });
        if (Util.isNullOrNil(((ehp)localObject1).wording))
        {
          paramString = getString(a.i.face_confirm_protocol_tips);
          if (!Util.isNullOrNil(((ehp)localObject1).ZQe)) {
            break label789;
          }
          paramp = getString(a.i.face_confirm_protocol_details);
          label459:
          localObject2 = Spannable.Factory.getInstance().newSpannable(paramString + paramp);
          ((Spannable)localObject2).setSpan(new ClickableSpan()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(103889);
              if (!Util.isNullOrNil(this.zVC.url))
              {
                FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, this.zVC.url);
                AppMethodBeat.o(103889);
                return;
              }
              Log.e("MicroMsg.FaceDetectConfirmUI", "alvinluo promptInfo url is null");
              AppMethodBeat.o(103889);
            }
            
            public final void updateDrawState(TextPaint paramAnonymousTextPaint)
            {
              AppMethodBeat.i(271910);
              paramAnonymousTextPaint.setColor(FaceDetectConfirmUI.this.getResources().getColor(a.b.link_color));
              AppMethodBeat.o(271910);
            }
          }, paramString.length(), paramString.length() + paramp.length(), 33);
          this.zVg.setVisibility(0);
          this.zVh.setVisibility(0);
          this.zVh.setText((CharSequence)localObject2);
          this.zVh.setMovementMethod(LinkMovementMethod.getInstance());
          if (((ehp)localObject1).abmK != 0) {
            break label799;
          }
          this.zVg.setChecked(false);
          this.zVf.setEnabled(false);
          label578:
          this.zVi.setText(getString(a.i.face_confirm_complain_tips));
          this.zVi.setOnClickListener(new FaceDetectConfirmUI.13(this));
          this.zVi.setVisibility(0);
        }
      }
      else
      {
        Log.i("MicroMsg.FaceDetectConfirmUI", "wechat header text: %s", new Object[] { this.zSa });
        if (!Util.isNullOrNil(this.zSa))
        {
          this.zVw.setVisibility(0);
          this.zVw.setText(this.zSa);
        }
        if ((this.zRZ != null) && (this.zRZ.wording != null))
        {
          Log.i("MicroMsg.FaceDetectConfirmUI", "wechat promptInfo wording: %s, check status: %d", new Object[] { this.zRZ.wording, Integer.valueOf(this.zRZ.abmK) });
          this.zVx.setVisibility(0);
          if (this.zRZ.abmK != 0) {
            break label827;
          }
          this.zVy.setChecked(false);
          this.zVf.setEnabled(false);
        }
      }
      for (;;)
      {
        this.zVz.setText(this.zRZ.wording);
        com.tencent.mm.kernel.h.aZW().b(1147, this);
        AppMethodBeat.o(103891);
        return;
        paramString = ((ehp)localObject1).wording;
        break;
        label789:
        paramp = ((ehp)localObject1).ZQe;
        break label459;
        label799:
        if (((ehp)localObject1).abmK != 1) {
          break label578;
        }
        this.zVg.setChecked(true);
        this.zVf.setEnabled(true);
        break label578;
        label827:
        if (this.zRZ.abmK == 1)
        {
          this.zVy.setChecked(true);
          this.zVf.setEnabled(true);
        }
      }
    }
    Object localObject1 = paramString;
    if (Util.isNullOrNil(paramString)) {
      localObject1 = getString(a.i.face_get_confirm_info_failed_tips);
    }
    paramString = ((m)paramp).zRX;
    aDM();
    this.zVA = true;
    paramp = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_bg_scale);
    Object localObject2 = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_fail_scale);
    TextView localTextView1 = (TextView)this.zVv.findViewById(a.e.face_flash_header_tip);
    TextView localTextView2 = (TextView)this.zVv.findViewById(a.e.face_flash_header_hint);
    ImageView localImageView1 = (ImageView)this.zVv.findViewById(a.e.face_flash_header_icon);
    Button localButton = (Button)this.zVv.findViewById(a.e.face_flash_bottom_verify);
    TextView localTextView3 = (TextView)this.zVv.findViewById(a.e.face_flash_bottom_feedback);
    ImageView localImageView2 = (ImageView)this.zVv.findViewById(a.e.face_flash_header_bg);
    this.zVv.setVisibility(0);
    localButton.setText(a.i.app_ok);
    localButton.setOnClickListener(new FaceDetectConfirmUI.10(this));
    localImageView2.setImageResource(a.d.face_flash_fail_circle);
    localImageView2.startAnimation(paramp);
    localImageView1.setImageDrawable(com.tencent.mm.cd.a.m(getContext(), a.h.icons_filled_error3));
    localImageView1.startAnimation((Animation)localObject2);
    localTextView1.setText((CharSequence)localObject1);
    if (!TextUtils.isEmpty(paramString)) {
      localTextView2.setText(paramString);
    }
    if (TextUtils.isEmpty(this.zRR)) {}
    for (paramInt1 = 4;; paramInt1 = 0)
    {
      localTextView3.setVisibility(paramInt1);
      localTextView3.setOnClickListener(new FaceDetectConfirmUI.11(this, paramInt2));
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI
 * JD-Core Version:    0.7.0.1
 */