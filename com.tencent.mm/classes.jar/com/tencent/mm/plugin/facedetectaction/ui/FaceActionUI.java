package com.tencent.mm.plugin.facedetectaction.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetectaction.model.a.a;
import com.tencent.mm.plugin.facedetectaction.model.c.a;
import com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

@com.tencent.mm.ui.base.a(3)
public class FaceActionUI
  extends MMActivity
{
  com.tencent.mm.plugin.facedetectlight.ui.a AaA;
  private a.a AaB;
  private int AaC;
  private int AaD;
  private String AaE;
  private int AaF;
  private String AaG = "";
  RelativeLayout Aai;
  RelativeLayout Aaj;
  RelativeLayout Aak;
  RelativeLayout Aal;
  private PreviewFrameLayout Aam;
  private FaceActionMask Aan;
  private MMTextureView Aao;
  ImageView Aap;
  private TextView Aaq;
  private TextView Aar;
  ImageView Aas;
  private ImageView Aat;
  ImageView Aau;
  ImageView Aav;
  private Button Aaw;
  private Button Aax;
  private TextView Aay;
  public boolean Aaz = false;
  private long endTime;
  int hDx;
  private int mStatus = 0;
  private int scene;
  private long startTime;
  private int zZv;
  private String zZw;
  
  private void c(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(104260);
    paramBundle = d(paramString, paramInt, paramBundle);
    switch (paramString.hashCode())
    {
    default: 
      label52:
      paramInt = -1;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        setResult(-1, paramBundle);
        AppMethodBeat.o(104260);
        return;
        if (!paramString.equals("ok")) {
          break label52;
        }
        paramInt = 0;
        continue;
        if (!paramString.equals("fail")) {
          break label52;
        }
        paramInt = 1;
        continue;
        if (!paramString.equals("cancel")) {
          break label52;
        }
        paramInt = 2;
      }
    }
    setResult(-1, paramBundle);
    AppMethodBeat.o(104260);
    return;
    setResult(1, paramBundle);
    AppMethodBeat.o(104260);
    return;
    com.tencent.mm.plugin.flash.c.b.aDA("usrCancel");
    setResult(0, paramBundle);
    AppMethodBeat.o(104260);
  }
  
  private Intent d(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(104261);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramInt);
    localBundle.putString("err_msg", paramString);
    localBundle.putInt("scene", this.scene);
    localBundle.putInt("countFace", this.AaF);
    localBundle.putInt("err_type", this.hDx);
    this.endTime = Util.currentTicks();
    Log.i("MicroMsg.FaceActionUI", "endTime：" + this.endTime);
    Log.i("MicroMsg.FaceActionUI", "startTime：" + this.startTime);
    localBundle.putLong("totalTime", this.endTime - this.startTime);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramString = new Intent();
    paramString.putExtras(localBundle);
    AppMethodBeat.o(104261);
    return paramString;
  }
  
  private void dPQ()
  {
    AppMethodBeat.i(104251);
    this.AaB = new a.a() {};
    com.tencent.mm.plugin.facedetectaction.model.c.zZJ.zZO = new c.a()
    {
      public final void a(int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString1, final String paramAnonymousString2, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(262634);
        Log.i("MicroMsg.FaceActionUI", "onError, err: %s, cgiErrCode: %s, cgiErrMsg: %s,retry: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString1, Integer.valueOf(paramAnonymousInt3) });
        FaceActionUI.b(FaceActionUI.this, paramAnonymousInt1);
        FaceActionUI.c(FaceActionUI.this, paramAnonymousInt2);
        FaceActionUI.c(FaceActionUI.this, paramAnonymousString1);
        FaceActionUI.b(FaceActionUI.this, paramAnonymousString2);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104237);
            if (!Util.isNullOrNil(paramAnonymousString1))
            {
              FaceActionUI.f(FaceActionUI.this).setText(paramAnonymousString1);
              FaceActionUI.g(FaceActionUI.this);
              if (paramAnonymousInt3 != 1) {
                break label193;
              }
              FaceActionUI.h(FaceActionUI.this).setText(a.i.face_try);
              FaceActionUI.h(FaceActionUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous3View)
                {
                  AppMethodBeat.i(104235);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous3View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  Log.i("MicroMsg.FaceActionUI", "click retry");
                  FaceActionUI.i(FaceActionUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(104235);
                }
              });
            }
            for (;;)
            {
              FaceActionUI.e(FaceActionUI.this).clearAnimation();
              FaceActionUI localFaceActionUI = FaceActionUI.this;
              localFaceActionUI.Aai.setVisibility(8);
              localFaceActionUI.Aal.setVisibility(0);
              localFaceActionUI.Aau.clearAnimation();
              localFaceActionUI.Aap.setVisibility(0);
              localFaceActionUI.Aaj.setVisibility(8);
              com.tencent.mm.plugin.facedetectaction.model.c.zZJ.mStatus = 3;
              FaceActionUI.j(FaceActionUI.this);
              AppMethodBeat.o(104237);
              return;
              FaceActionUI.f(FaceActionUI.this).setText(a.i.face_action_upload_failed_tips);
              break;
              label193:
              FaceActionUI.h(FaceActionUI.this).setText(a.i.face_severe_error_main_btn);
              FaceActionUI.h(FaceActionUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous3View)
                {
                  AppMethodBeat.i(104236);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymous3View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  Log.i("MicroMsg.FaceActionUI", "click finish");
                  FaceActionUI.this.f("fail", FaceActionUI.3.4.this.AaP, "", FaceActionUI.3.4.this.AaQ);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(104236);
                }
              });
            }
          }
        });
        AppMethodBeat.o(262634);
      }
      
      public final void a(final cjv paramAnonymouscjv)
      {
        AppMethodBeat.i(262632);
        Log.i("MicroMsg.FaceActionUI", "onVerifyFinish:   authToken ：%s", new Object[] { paramAnonymouscjv.ZpZ });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104234);
            FaceActionUI.e(FaceActionUI.this).clearAnimation();
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            localFaceActionUI.Aai.setVisibility(8);
            localFaceActionUI.Aau.clearAnimation();
            localFaceActionUI.Aaj.setVisibility(8);
            localFaceActionUI.Aap.setVisibility(0);
            localFaceActionUI.Aak.setVisibility(0);
            localFaceActionUI.Aav.setScaleX(0.0F);
            localFaceActionUI.Aav.setScaleY(0.0F);
            localFaceActionUI.Aav.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
            FaceActionUI.b(FaceActionUI.this, paramAnonymouscjv.aasu);
            localFaceActionUI = FaceActionUI.this;
            String str1 = paramAnonymouscjv.ZpZ;
            String str2 = paramAnonymouscjv.aasu;
            Log.i("MicroMsg.FaceActionUI", "callbackDetectSuccess（）");
            Bundle localBundle = new Bundle();
            localBundle.putString("token", str1);
            localBundle.putString("serial_id", str2);
            localFaceActionUI.hDx = 0;
            localFaceActionUI.a("ok", 0, localBundle, Boolean.valueOf(localFaceActionUI.Aaz));
            AppMethodBeat.o(104234);
          }
        });
        AppMethodBeat.o(262632);
      }
      
      public final void bq(final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(104238);
        Log.i("MicroMsg.FaceActionUI", "onInitFaceCheckFinish: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104232);
            FaceActionUI.a(FaceActionUI.this, paramAnonymousInt);
            FaceActionUI.a(FaceActionUI.this, paramAnonymousString);
            FaceActionUI.b(FaceActionUI.this);
            FaceActionUI.c(FaceActionUI.this);
            FaceActionUI.d(FaceActionUI.this);
            AppMethodBeat.o(104232);
          }
        });
        AppMethodBeat.o(104238);
      }
      
      public final void dPP()
      {
        AppMethodBeat.i(104239);
        Log.i("MicroMsg.FaceActionUI", "onStartUpload");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104233);
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            if (localFaceActionUI.AaA != null)
            {
              localObject = localFaceActionUI.AaA;
              Log.i("MicroMsg.FaceReflectCam", "stopPreview ,isPreview %s camera:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).nvB), ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).Abo });
              if (((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).Abo != null)
              {
                ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).nvB = false;
                ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).Abo.auq();
                ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).Abo.a(null);
                ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).Abx.removeCallbacksAndMessages(null);
                com.tencent.mm.plugin.facedetect.model.c.zSD.bvG();
              }
            }
            localFaceActionUI.Aai.setVisibility(8);
            localFaceActionUI.Aaj.setVisibility(0);
            Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, localFaceActionUI.Aas.getHeight());
            ((Animation)localObject).setDuration(2000L);
            ((Animation)localObject).setRepeatMode(2);
            ((Animation)localObject).setRepeatCount(-1);
            ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation.setDuration(1000L);
            localScaleAnimation.setRepeatMode(2);
            localScaleAnimation.setRepeatCount(-1);
            AnimationSet localAnimationSet = new AnimationSet(true);
            localAnimationSet.addAnimation((Animation)localObject);
            localAnimationSet.addAnimation(localScaleAnimation);
            localAnimationSet.setAnimationListener(new FaceActionUI.8(localFaceActionUI));
            localAnimationSet.setRepeatCount(-1);
            localFaceActionUI.Aau.startAnimation(localAnimationSet);
            AppMethodBeat.o(104233);
          }
        });
        AppMethodBeat.o(104239);
      }
    };
    com.tencent.mm.plugin.facedetectaction.model.c.zZJ.lzt = this;
    com.tencent.mm.plugin.facedetectaction.model.c.zZJ.a(this);
    AppMethodBeat.o(104251);
  }
  
  private void dPR()
  {
    AppMethodBeat.i(104257);
    this.Aai = ((RelativeLayout)findViewById(a.e.face_preview_layout));
    this.Aam = ((PreviewFrameLayout)findViewById(a.e.face_live_preview_layout));
    this.Aao = ((MMTextureView)findViewById(a.e.face_live_detection_preview));
    this.Aao.setVisibility(4);
    this.Aan = ((FaceActionMask)findViewById(a.e.face_live_preview_mask));
    this.Aat = ((ImageView)findViewById(a.e.face_action_loading));
    this.Aat.post(new FaceActionUI.4(this));
    this.Aaq = ((TextView)findViewById(a.e.face_live_tip_tv));
    this.Aaq.post(new FaceActionUI.5(this));
    this.Aar = ((TextView)findViewById(a.e.face__back));
    this.Aar.setOnClickListener(new FaceActionUI.6(this));
    this.mStatus = 0;
    AppMethodBeat.o(104257);
  }
  
  private void dPS()
  {
    AppMethodBeat.i(104263);
    Log.i("MicroMsg.FaceActionUI", "preview");
    if (this.AaA != null)
    {
      this.AaA.nvB = true;
      Log.i("MicroMsg.FaceActionUI", "mCamera ！= null");
    }
    this.Aaq.setText(a.i.face_preview_tips);
    AppMethodBeat.o(104263);
  }
  
  public final void a(String paramString, final int paramInt, Bundle paramBundle, Boolean paramBoolean)
  {
    AppMethodBeat.i(104259);
    Log.i("MicroMsg.FaceActionUI", "finishWithResult errMsg: %s, errCode: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = "yes";; paramBoolean = "no")
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("click_other_verify_btn", paramBoolean);
      if (paramBundle != null) {
        localBundle.putAll(paramBundle);
      }
      Log.i("MicroMsg.FaceActionUI", "seriaId:%s", new Object[] { this.AaG });
      localBundle.putString("serial_id", this.AaG);
      c(paramString, paramInt, localBundle);
      if (paramInt != 0) {
        break;
      }
      Log.i("MicroMsg.FaceActionUI", "errCode == ConstantsFace.UploadErrCode.OK");
      h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104249);
          com.tencent.mm.plugin.flash.c.b.VM(paramInt);
          FaceActionUI.this.finish();
          AppMethodBeat.o(104249);
        }
      }, 1500L);
      AppMethodBeat.o(104259);
      return;
    }
    com.tencent.mm.plugin.flash.c.b.VM(paramInt);
    finish();
    AppMethodBeat.o(104259);
  }
  
  public final void f(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(262670);
    Log.i("MicroMsg.FaceActionUI", "callbackDetectFailed（）");
    Bundle localBundle = new Bundle();
    localBundle.putString("token", paramString2);
    localBundle.putString("serial_id", paramString3);
    a(paramString1, paramInt, localBundle, Boolean.valueOf(this.Aaz));
    AppMethodBeat.o(262670);
  }
  
  public int getLayoutId()
  {
    return a.g.face_action_layout;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(104262);
    if (this.mStatus == 3) {
      f("fail", this.AaD, "", this.AaG);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(104262);
      return;
      com.tencent.mm.plugin.facedetectaction.model.c.zZJ.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104250);
    Log.i("MicroMsg.FaceActionUI", "onCreate()");
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.flash.c.b.fuP().ivn = 1L;
    com.tencent.mm.plugin.flash.c.b.aDA("enter");
    getWindow().setFlags(1024, 1024);
    getWindow().addFlags(2097280);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.AaF = 0;
    this.startTime = Util.currentTicks();
    this.hDx = 4;
    if (Build.VERSION.SDK_INT >= 16) {
      getWindow().getDecorView().setSystemUiVisibility(1280);
    }
    setActionbarColor(getContext().getResources().getColor(a.b.white));
    Log.d("MicroMsg.FaceActionUI", "initLayout");
    this.Aap = ((ImageView)findViewById(a.e.background_view));
    dPR();
    this.Aaj = ((RelativeLayout)findViewById(a.e.face_upload_layout));
    this.Aak = ((RelativeLayout)findViewById(a.e.face_upload_success_layout));
    this.Aal = ((RelativeLayout)findViewById(a.e.face_upload_failed_layout));
    this.Aaj.setVisibility(4);
    this.Aak.setVisibility(4);
    this.Aal.setVisibility(4);
    this.Aas = ((ImageView)findViewById(a.e.face_detect_upload));
    this.Aau = ((ImageView)findViewById(a.e.face_detect_scan));
    this.Aav = ((ImageView)findViewById(a.e.face_detect_upload_success_right));
    this.Aay = ((TextView)findViewById(a.e.face_detect_upload_failed_tips));
    this.Aaw = ((Button)findViewById(a.e.face_detect_upload_failed_btn1));
    this.Aax = ((Button)findViewById(a.e.face_detect_upload_failed_btn2));
    if (!Util.isNullOrNil(com.tencent.mm.plugin.facedetectaction.model.c.zZJ.hYA))
    {
      this.Aax.setText(com.tencent.mm.plugin.facedetectaction.model.c.zZJ.hYA);
      this.Aax.setOnClickListener(new FaceActionUI.7(this));
    }
    while (k.at(this))
    {
      Log.i("MicroMsg.FaceActionUI", "carson: checkFacePermissionAnd Request true and do init ");
      dPQ();
      AppMethodBeat.o(104250);
      return;
      this.Aax.setVisibility(8);
    }
    Log.i("MicroMsg.FaceActionUI", "carson: no camera permission. request permission");
    AppMethodBeat.o(104250);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104256);
    super.onDestroy();
    Log.i("MicroMsg.FaceActionUI", "onDestroy");
    com.tencent.mm.plugin.facedetectaction.model.c.zZJ.release(true);
    com.tencent.mm.plugin.facedetectaction.model.c.zZJ.lzt = null;
    AppMethodBeat.o(104256);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(104254);
    Log.d("MicroMsg.FaceActionUI", "onPause");
    super.onPause();
    AppMethodBeat.o(104254);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(104264);
    Log.i("MicroMsg.FaceActionUI", "carson onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(104264);
      return;
    }
    switch (paramInt)
    {
    }
    String str2;
    String str3;
    for (;;)
    {
      AppMethodBeat.o(104264);
      return;
      str2 = "";
      str3 = "";
      if (paramArrayOfInt.length != 1) {
        break label271;
      }
      if (paramArrayOfInt[0] != 0) {
        break;
      }
      paramInt = 1;
      label77:
      if (paramInt == 0) {
        break label300;
      }
      dPQ();
    }
    String str1;
    Object localObject;
    if (paramArrayOfString[0].equals("android.permission.CAMERA"))
    {
      str1 = "camera permission not granted";
      localObject = getString(a.i.permission_camera_request_again_msg);
    }
    for (;;)
    {
      Log.i("MicroMsg.FaceActionUI", "carson PermissionsResult:errMsg".concat(String.valueOf(str1)));
      Log.i("MicroMsg.FaceActionUI", "carson PermissionsResult:showErrMsg".concat(String.valueOf(localObject)));
      Log.i("MicroMsg.FaceActionUI", "checkPermissionFailedAnimation");
      this.Aay.setText((CharSequence)localObject);
      this.Aaw.setText(a.i.face_severe_error_main_btn);
      this.Aaw.setOnClickListener(new FaceActionUI.9(this));
      this.Aai.setVisibility(8);
      this.Aal.setVisibility(0);
      this.Aau.clearAnimation();
      this.Aap.setVisibility(0);
      this.Aaj.setVisibility(8);
      paramInt = 0;
      break label77;
      localObject = str3;
      str1 = str2;
      if (paramArrayOfString[0].equals("android.permission.RECORD_AUDIO"))
      {
        str1 = "audio permission not granted";
        localObject = getString(a.i.permission_microphone_request_again_msg);
        continue;
        label271:
        localObject = str3;
        str1 = str2;
        if (paramArrayOfInt.length == 2)
        {
          if ((paramArrayOfInt[0] == 0) && (paramArrayOfInt[1] == 0))
          {
            paramInt = 1;
            break label77;
            label300:
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
    AppMethodBeat.i(104253);
    super.onResume();
    Log.d("MicroMsg.FaceActionUI", "onResume");
    dPS();
    AppMethodBeat.o(104253);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(104252);
    Log.d("MicroMsg.FaceActionUI", "onStart");
    super.onStart();
    if (this.AaA != null)
    {
      this.AaA.a(this.Aao);
      this.AaA.dPU();
    }
    AppMethodBeat.o(104252);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(104255);
    Log.i("MicroMsg.FaceActionUI", "onStop");
    super.onStop();
    if (this.AaA != null) {
      this.AaA.zVL = false;
    }
    AppMethodBeat.o(104255);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI
 * JD-Core Version:    0.7.0.1
 */