package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.b.m;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.flash.FaceFlashUI;
import com.tencent.mm.plugin.flash.d.b.b;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectConfirmUI
  extends MMActivity
  implements i
{
  private String appId;
  private int businessType;
  private String qnk;
  private s tipDialog;
  private String wvL = null;
  private String wvM = null;
  private String wvN = null;
  private float wvO;
  private String wvQ;
  private float wvR = 0.0F;
  private TextView wyX;
  private Button wyY;
  private CheckBox wyZ;
  private TextView wza;
  private TextView wzb;
  private dov wzc = null;
  private String wzd;
  private int wze;
  private int wzf;
  private ImageView wzg;
  private TextView wzh;
  private String wzi;
  private String wzj;
  private String wzk = "";
  private ViewGroup wzl;
  private long wzm = 0L;
  private ViewGroup wzn;
  private ViewGroup wzo;
  private boolean wzp = false;
  
  private void bQm()
  {
    AppMethodBeat.i(103893);
    Intent localIntent = new Intent();
    localIntent.putExtra("err_code", l.Lv(90024));
    localIntent.putExtra("err_msg", "user cancel in confirm ui");
    FaceDetectReporter.dij().ae(this.businessType, 1, 90024);
    com.tencent.mm.plugin.flash.c.b.s("msgVerify", "user cancel in confirm ui");
    com.tencent.mm.plugin.flash.c.b.Ss(90024);
    FaceDetectReporter.dij().wxx = System.currentTimeMillis();
    FaceDetectReporter.dij().dM(this.qnk, this.businessType);
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(103893);
  }
  
  private void diF()
  {
    AppMethodBeat.i(196022);
    Intent localIntent = new Intent();
    localIntent.putExtra("err_code", l.Lv(90022));
    localIntent.putExtra("err_msg", "get confirm info error");
    localIntent.putExtra("verify_result", this.wzk);
    FaceDetectReporter.dij().ae(this.businessType, 2, 90022);
    com.tencent.mm.plugin.flash.c.b.Ss(90022);
    FaceDetectReporter.dij().wxx = System.currentTimeMillis();
    FaceDetectReporter.dij().dM(this.qnk, this.businessType);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(196022);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(103896);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(103896);
  }
  
  public void finish()
  {
    AppMethodBeat.i(103895);
    dismissDialog();
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
    FaceDetectReporter.dij().wxx = System.currentTimeMillis();
    if (paramIntent.hasExtra("err_code")) {
      paramIntent.putExtra("err_code", l.Lv(paramIntent.getIntExtra("err_code", -1)));
    }
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(103892);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(103894);
    if (this.wzp) {
      diF();
    }
    for (;;)
    {
      super.onBackPressed();
      AppMethodBeat.o(103894);
      return;
      bQm();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103890);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.flash.c.b.epM().gmv = System.currentTimeMillis();
    this.appId = getIntent().getStringExtra("appId");
    this.wzd = getIntent().getStringExtra("request_verify_pre_info");
    this.qnk = getIntent().getStringExtra("key_function_name");
    this.businessType = getIntent().getIntExtra("key_business_type", -1);
    this.wze = getIntent().getIntExtra("check_alive_type", 0);
    this.wzm = System.currentTimeMillis();
    Log.i("MicroMsg.FaceDetectConfirmUI", "appId:%s jsonData:%s functionName:%s businessType:%s check_alive_type_request:%s", new Object[] { this.appId, this.wzd, this.qnk, Integer.valueOf(this.businessType), Integer.valueOf(this.wze) });
    this.wzn = ((ViewGroup)findViewById(a.e.face_confirm_success_layout));
    this.wzo = ((ViewGroup)findViewById(a.e.face_confirm_fail_layout));
    setMMTitle("");
    setActionbarColor(getResources().getColor(a.b.white));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(103882);
        Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo cancel with back button");
        FaceDetectConfirmUI.a(FaceDetectConfirmUI.this);
        AppMethodBeat.o(103882);
        return false;
      }
    });
    this.wyX = ((TextView)findViewById(a.e.face_confirm_header_tips));
    this.wyY = ((Button)findViewById(a.e.start_face_detect_button));
    this.wzg = ((ImageView)findViewById(a.e.applicant_icon));
    this.wzh = ((TextView)findViewById(a.e.applicant_name));
    this.wzl = ((ViewGroup)findViewById(a.e.face_confirm_protocol_checkbox_parent));
    this.wzl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191743);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = FaceDetectConfirmUI.b(FaceDetectConfirmUI.this);
        if (!FaceDetectConfirmUI.b(FaceDetectConfirmUI.this).isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(191743);
          return;
        }
      }
    });
    this.wyZ = ((CheckBox)findViewById(a.e.face_confirm_protocol_checkbox));
    this.wyZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(195488);
        if (paramAnonymousBoolean)
        {
          FaceDetectConfirmUI.c(FaceDetectConfirmUI.this).setEnabled(true);
          AppMethodBeat.o(195488);
          return;
        }
        FaceDetectConfirmUI.c(FaceDetectConfirmUI.this).setEnabled(false);
        AppMethodBeat.o(195488);
      }
    });
    this.wyZ.setVisibility(8);
    this.wza = ((TextView)findViewById(a.e.face_confirm_protocol_checkbox_text));
    this.wza.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(103885);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = FaceDetectConfirmUI.b(FaceDetectConfirmUI.this);
        if (!FaceDetectConfirmUI.b(FaceDetectConfirmUI.this).isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(103885);
          return;
        }
      }
    });
    this.wzb = ((TextView)findViewById(a.e.face_complain));
    this.wyY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194154);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.d("MicroMsg.FaceDetectConfirmUI", "check_alive_type is %s", new Object[] { Integer.valueOf(FaceDetectConfirmUI.d(FaceDetectConfirmUI.this)) });
        if (!p.aj(FaceDetectConfirmUI.this))
        {
          Log.e("MicroMsg.FaceDetectConfirmUI", "carson: no camera permission. request permission");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(194154);
          return;
        }
        paramAnonymousView = FaceDetectConfirmUI.this.getIntent().getExtras();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.putInt("check_alive_type", FaceDetectConfirmUI.d(FaceDetectConfirmUI.this));
          paramAnonymousView.putString("appId", FaceDetectConfirmUI.e(FaceDetectConfirmUI.this));
          paramAnonymousView.putString("feedbackUrl", FaceDetectConfirmUI.f(FaceDetectConfirmUI.this));
          paramAnonymousView.putString("business_tips", FaceDetectConfirmUI.g(FaceDetectConfirmUI.this));
          paramAnonymousView.putFloat("mLight_threshold", FaceDetectConfirmUI.h(FaceDetectConfirmUI.this));
          paramAnonymousView.putLong("confirm_page_timestamp", FaceDetectConfirmUI.i(FaceDetectConfirmUI.this));
          if ((FaceDetectConfirmUI.j(FaceDetectConfirmUI.this) >= 0.2D) && (FaceDetectConfirmUI.j(FaceDetectConfirmUI.this) <= 0.9D)) {
            com.tencent.mm.plugin.flash.view.FaceFlashReflectMask.BCc = FaceDetectConfirmUI.j(FaceDetectConfirmUI.this) / 2.0F;
          }
          Log.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type_response is " + FaceDetectConfirmUI.d(FaceDetectConfirmUI.this));
          FaceFlashUI.d(FaceDetectConfirmUI.this, paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(194154);
          return;
          Log.e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
        }
      }
    });
    Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
    paramBundle = getContext();
    getString(a.i.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(paramBundle, getString(a.i.app_waiting), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    paramBundle = new m(this.appId, this.wzd, this.wze);
    com.tencent.mm.kernel.h.aGY().a(1147, this);
    com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
    b.b.epQ().epP();
    com.tencent.mm.plugin.flash.c.b.Su(1);
    AppMethodBeat.o(103890);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(103897);
    super.onDestroy();
    b.b.epQ().stop();
    AppMethodBeat.o(103897);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196035);
    Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(196035);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196035);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.wyY.performClick();
        AppMethodBeat.o(196035);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(a.i.face_permission_camera_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(196714);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = FaceDetectConfirmUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(196714);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(196635);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(196635);
        }
      });
      AppMethodBeat.o(196035);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.wyY.performClick();
        AppMethodBeat.o(196035);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(a.i.face_permission_micro_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(191022);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = FaceDetectConfirmUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(191022);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(194422);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(194422);
        }
      });
    }
  }
  
  public void onSceneEnd(int paramInt1, final int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(103891);
    Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.plugin.flash.c.b.s("confirmCode", Integer.valueOf(paramInt1));
    com.tencent.mm.plugin.flash.c.b.s("confirmMsg", paramString);
    this.wvM = ((m)paramq).wvM;
    this.wzk = ((m)paramq).wvT;
    this.wvR = ((m)paramq).wvR;
    Log.i("MicroMsg.FaceDetectConfirmUI", "mFeedbackUrl:%s", new Object[] { this.wvM });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.wzc = ((m)paramq).wvI;
      this.wvL = ((m)paramq).wvL;
      this.wvN = ((m)paramq).wvN;
      this.wvO = ((m)paramq).wvO;
      this.wzf = ((m)paramq).wvP;
      this.wvQ = ((m)paramq).wvQ;
      this.wzi = ((m)paramq).wvJ;
      this.wzj = ((m)paramq).wvK;
      Log.d("MicroMsg.FaceDetectConfirmUI", paramq.toString());
      if (Util.isNullOrNil(this.wvL)) {
        this.wvL = getString(a.i.face_confirm_tips);
      }
      dismissDialog();
      this.wyY.setEnabled(true);
      this.wyX.setText(this.wvL);
      paramString = String.format(getString(a.i.face_confirm_ui_request_use_tip), new Object[] { this.wzj });
      this.wzh.setText(paramString);
      com.tencent.mm.ay.q.bml().loadImage(this.wzi, this.wzg);
      if (this.wzc != null)
      {
        Log.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s, url_wording: %s, url: %s", new Object[] { this.wzc.wording, this.wzc.SLb, this.wzc.url });
        localObject1 = this.wzc;
        Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo protocol info: %s", new Object[] { ((dov)localObject1).wording });
        if (!Util.isNullOrNil(((dov)localObject1).wording)) {
          break label608;
        }
        paramString = getString(a.i.face_confirm_protocol_tips);
        if (!Util.isNullOrNil(((dov)localObject1).SLb)) {
          break label617;
        }
        paramq = getString(a.i.face_confirm_protocol_details);
        label435:
        localObject2 = Spannable.Factory.getInstance().newSpannable(paramString + paramq);
        ((Spannable)localObject2).setSpan(new ClickableSpan()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(197738);
            if (!Util.isNullOrNil(this.wzr.url))
            {
              FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, this.wzr.url);
              AppMethodBeat.o(197738);
              return;
            }
            Log.e("MicroMsg.FaceDetectConfirmUI", "alvinluo promptInfo url is null");
            AppMethodBeat.o(197738);
          }
          
          public final void updateDrawState(TextPaint paramAnonymousTextPaint)
          {
            AppMethodBeat.i(197740);
            paramAnonymousTextPaint.setColor(FaceDetectConfirmUI.this.getResources().getColor(a.b.link_color));
            AppMethodBeat.o(197740);
          }
        }, paramString.length(), paramString.length() + paramq.length(), 33);
        this.wyZ.setVisibility(0);
        this.wza.setVisibility(0);
        this.wza.setText((CharSequence)localObject2);
        this.wza.setMovementMethod(LinkMovementMethod.getInstance());
        if (((dov)localObject1).TVV != 0) {
          break label627;
        }
        this.wyZ.setChecked(false);
        this.wyY.setEnabled(false);
      }
      for (;;)
      {
        this.wzb.setText(getString(a.i.face_confirm_complain_tips));
        this.wzb.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(190837);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            for (;;)
            {
              try
              {
                if (FaceDetectConfirmUI.e(FaceDetectConfirmUI.this) == null) {
                  continue;
                }
                paramAnonymousView = FaceDetectConfirmUI.e(FaceDetectConfirmUI.this);
                paramAnonymousView = com.tencent.mm.compatible.util.q.an(String.format("appid=%s", new Object[] { paramAnonymousView }), "UTF-8");
                paramAnonymousView = FaceDetectConfirmUI.l(FaceDetectConfirmUI.this) + "?customInfo=" + paramAnonymousView;
                Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo jump realUrl: %s", new Object[] { paramAnonymousView });
                FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, paramAnonymousView);
              }
              catch (Exception paramAnonymousView)
              {
                Log.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", paramAnonymousView, "alvinluo jumpToWebView exception", new Object[0]);
                continue;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(190837);
              return;
              paramAnonymousView = "";
            }
          }
        });
        this.wzb.setVisibility(0);
        com.tencent.mm.kernel.h.aGY().b(1147, this);
        AppMethodBeat.o(103891);
        return;
        label608:
        paramString = ((dov)localObject1).wording;
        break;
        label617:
        paramq = ((dov)localObject1).SLb;
        break label435;
        label627:
        if (((dov)localObject1).TVV == 1)
        {
          this.wyZ.setChecked(true);
          this.wyY.setEnabled(true);
        }
      }
    }
    Object localObject1 = paramString;
    if (Util.isNullOrNil(paramString)) {
      localObject1 = getString(a.i.face_get_confirm_info_failed_tips);
    }
    paramString = ((m)paramq).wvS;
    dismissDialog();
    this.wzp = true;
    paramq = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_bg_scale);
    Object localObject2 = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_fail_scale);
    TextView localTextView1 = (TextView)this.wzo.findViewById(a.e.face_flash_header_tip);
    TextView localTextView2 = (TextView)this.wzo.findViewById(a.e.face_flash_header_hint);
    ImageView localImageView1 = (ImageView)this.wzo.findViewById(a.e.face_flash_header_icon);
    Button localButton = (Button)this.wzo.findViewById(a.e.face_flash_bottom_verify);
    TextView localTextView3 = (TextView)this.wzo.findViewById(a.e.face_flash_bottom_feedback);
    ImageView localImageView2 = (ImageView)this.wzo.findViewById(a.e.face_flash_header_bg);
    this.wzo.setVisibility(0);
    localButton.setText(a.i.app_ok);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(103887);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FaceDetectConfirmUI.k(FaceDetectConfirmUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(103887);
      }
    });
    localImageView2.setImageResource(a.d.face_flash_fail_circle);
    localImageView2.startAnimation(paramq);
    localImageView1.setImageDrawable(com.tencent.mm.ci.a.m(getContext(), a.h.icons_filled_error3));
    localImageView1.startAnimation((Animation)localObject2);
    localTextView1.setText((CharSequence)localObject1);
    if (!TextUtils.isEmpty(paramString)) {
      localTextView2.setText(paramString);
    }
    if (TextUtils.isEmpty(this.wvM)) {}
    for (paramInt1 = 4;; paramInt1 = 0)
    {
      localTextView3.setVisibility(paramInt1);
      localTextView3.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(103889);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          try
          {
            paramAnonymousView = com.tencent.mm.compatible.util.q.an(String.format("appid=%s;errcode=%d", new Object[] { FaceDetectConfirmUI.e(FaceDetectConfirmUI.this), Integer.valueOf(paramInt2) }), "UTF-8");
            paramAnonymousView = FaceDetectConfirmUI.f(FaceDetectConfirmUI.this) + "?customInfo=" + paramAnonymousView;
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
            c.b(FaceDetectConfirmUI.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(103889);
            return;
          }
          catch (Exception paramAnonymousView)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", paramAnonymousView, "face start feedback webview exception", new Object[0]);
            }
          }
        }
      });
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI
 * JD-Core Version:    0.7.0.1
 */