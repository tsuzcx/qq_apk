package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.c;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.a.a;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.plugin.facedetectaction.b.d.a;
import com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMTextureView;

@com.tencent.mm.ui.base.a(3)
public class FaceActionUI
  extends MMActivity
{
  private long endTime;
  int fyO;
  private int mStatus = 0;
  private int scene;
  private long startTime;
  RelativeLayout wDX;
  RelativeLayout wDY;
  RelativeLayout wDZ;
  private int wDk;
  private String wDl;
  RelativeLayout wEa;
  private PreviewFrameLayout wEb;
  private FaceActionMask wEc;
  private MMTextureView wEd;
  ImageView wEe;
  private TextView wEf;
  private TextView wEg;
  ImageView wEh;
  private ImageView wEi;
  ImageView wEj;
  ImageView wEk;
  private Button wEl;
  private Button wEm;
  private TextView wEn;
  public boolean wEo = false;
  com.tencent.mm.plugin.facedetectlight.ui.a wEp;
  private a.a wEq;
  private int wEr;
  private int wEs;
  private String wEt;
  private int wEu;
  private String wEv = "";
  
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
    com.tencent.mm.plugin.flash.c.b.aHi("usrCancel");
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
    localBundle.putInt("countFace", this.wEu);
    localBundle.putInt("err_type", this.fyO);
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
  
  private void djf()
  {
    AppMethodBeat.i(104251);
    this.wEq = new a.a() {};
    d.wDy.wDD = new d.a()
    {
      public final void a(int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString1, final String paramAnonymousString2, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(193990);
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
                  localb.bn(paramAnonymous3View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
              localFaceActionUI.wDX.setVisibility(8);
              localFaceActionUI.wEa.setVisibility(0);
              localFaceActionUI.wEj.clearAnimation();
              localFaceActionUI.wEe.setVisibility(0);
              localFaceActionUI.wDY.setVisibility(8);
              d.wDy.mStatus = 3;
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
                  localb.bn(paramAnonymous3View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  Log.i("MicroMsg.FaceActionUI", "click finish");
                  FaceActionUI.this.h("fail", FaceActionUI.3.4.this.wEE, "", FaceActionUI.3.4.this.wEF);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(104236);
                }
              });
            }
          }
        });
        AppMethodBeat.o(193990);
      }
      
      public final void a(final bux paramAnonymousbux)
      {
        AppMethodBeat.i(193988);
        Log.i("MicroMsg.FaceActionUI", "onVerifyFinish:   authToken ：%s", new Object[] { paramAnonymousbux.SqY });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104234);
            FaceActionUI.e(FaceActionUI.this).clearAnimation();
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            localFaceActionUI.wDX.setVisibility(8);
            localFaceActionUI.wEj.clearAnimation();
            localFaceActionUI.wDY.setVisibility(8);
            localFaceActionUI.wEe.setVisibility(0);
            localFaceActionUI.wDZ.setVisibility(0);
            localFaceActionUI.wEk.setScaleX(0.0F);
            localFaceActionUI.wEk.setScaleY(0.0F);
            localFaceActionUI.wEk.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
            FaceActionUI.b(FaceActionUI.this, paramAnonymousbux.Tfa);
            localFaceActionUI = FaceActionUI.this;
            String str1 = paramAnonymousbux.SqY;
            String str2 = paramAnonymousbux.Tfa;
            Log.i("MicroMsg.FaceActionUI", "callbackDetectSuccess（）");
            Bundle localBundle = new Bundle();
            localBundle.putString("token", str1);
            localBundle.putString("serial_id", str2);
            localFaceActionUI.fyO = 0;
            localFaceActionUI.a("ok", 0, localBundle, Boolean.valueOf(localFaceActionUI.wEo));
            AppMethodBeat.o(104234);
          }
        });
        AppMethodBeat.o(193988);
      }
      
      public final void aW(final int paramAnonymousInt, final String paramAnonymousString)
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
      
      public final void dje()
      {
        AppMethodBeat.i(104239);
        Log.i("MicroMsg.FaceActionUI", "onStartUpload");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104233);
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            if (localFaceActionUI.wEp != null)
            {
              localObject = localFaceActionUI.wEp;
              Log.i("MicroMsg.FaceReflectCam", "stopPreview ,isPreview %s camera:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).wFf), ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).wFd });
              if (((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).wFd != null)
              {
                ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).wFf = false;
                ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).wFd.TL();
                ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).wFd.a(null);
                ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).wFo.removeCallbacksAndMessages(null);
                c.wwx.baL();
              }
            }
            localFaceActionUI.wDX.setVisibility(8);
            localFaceActionUI.wDY.setVisibility(0);
            Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, localFaceActionUI.wEh.getHeight());
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
            localFaceActionUI.wEj.startAnimation(localAnimationSet);
            AppMethodBeat.o(104233);
          }
        });
        AppMethodBeat.o(104239);
      }
    };
    d.wDy.iXq = this;
    d.wDy.a(this);
    AppMethodBeat.o(104251);
  }
  
  private void djg()
  {
    AppMethodBeat.i(104257);
    this.wDX = ((RelativeLayout)findViewById(a.e.face_preview_layout));
    this.wEb = ((PreviewFrameLayout)findViewById(a.e.face_live_preview_layout));
    this.wEd = ((MMTextureView)findViewById(a.e.face_live_detection_preview));
    this.wEd.setVisibility(4);
    this.wEc = ((FaceActionMask)findViewById(a.e.face_live_preview_mask));
    this.wEi = ((ImageView)findViewById(a.e.face_action_loading));
    this.wEi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104242);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.k(FaceActionUI.this).getLayoutParams();
        localMarginLayoutParams.topMargin = ((int)(FaceActionUI.l(FaceActionUI.this).getHeight() * 0.4D));
        FaceActionUI.k(FaceActionUI.this).setLayoutParams(localMarginLayoutParams);
        FaceActionUI.k(FaceActionUI.this).setVisibility(0);
        AppMethodBeat.o(104242);
      }
    });
    this.wEf = ((TextView)findViewById(a.e.face_live_tip_tv));
    this.wEf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104243);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.m(FaceActionUI.this).getLayoutParams();
        int i = (int)(FaceActionUI.l(FaceActionUI.this).getHeight() * 0.4D) + (int)(FaceActionUI.l(FaceActionUI.this).getWidth() * 0.35D) + aw.fromDPToPix(FaceActionUI.this, 30);
        localMarginLayoutParams.topMargin = i;
        Log.i("MicroMsg.FaceActionUI", "topMargin：%d", new Object[] { Integer.valueOf(i) });
        FaceActionUI.m(FaceActionUI.this).setLayoutParams(localMarginLayoutParams);
        FaceActionUI.m(FaceActionUI.this).setVisibility(0);
        AppMethodBeat.o(104243);
      }
    });
    this.wEg = ((TextView)findViewById(a.e.face__back));
    this.wEg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(104244);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (FaceActionUI.n(FaceActionUI.this) == 3) {
          FaceActionUI.this.h("fail", FaceActionUI.o(FaceActionUI.this), "", FaceActionUI.p(FaceActionUI.this));
        }
        for (;;)
        {
          FaceActionUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(104244);
          return;
          d.wDy.onBackPressed();
        }
      }
    });
    this.mStatus = 0;
    AppMethodBeat.o(104257);
  }
  
  private void djh()
  {
    AppMethodBeat.i(104263);
    Log.i("MicroMsg.FaceActionUI", "preview");
    if (this.wEp != null)
    {
      this.wEp.wFf = true;
      Log.i("MicroMsg.FaceActionUI", "mCamera ！= null");
    }
    this.wEf.setText(a.i.face_preview_tips);
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
      Log.i("MicroMsg.FaceActionUI", "seriaId:%s", new Object[] { this.wEv });
      localBundle.putString("serial_id", this.wEv);
      c(paramString, paramInt, localBundle);
      if (paramInt != 0) {
        break;
      }
      Log.i("MicroMsg.FaceActionUI", "errCode == ConstantsFace.UploadErrCode.OK");
      h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104249);
          com.tencent.mm.plugin.flash.c.b.St(paramInt);
          FaceActionUI.this.finish();
          AppMethodBeat.o(104249);
        }
      }, 1500L);
      AppMethodBeat.o(104259);
      return;
    }
    com.tencent.mm.plugin.flash.c.b.St(paramInt);
    finish();
    AppMethodBeat.o(104259);
  }
  
  public int getLayoutId()
  {
    return a.g.face_action_layout;
  }
  
  public final void h(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(190443);
    Log.i("MicroMsg.FaceActionUI", "callbackDetectFailed（）");
    Bundle localBundle = new Bundle();
    localBundle.putString("token", paramString2);
    localBundle.putString("serial_id", paramString3);
    a(paramString1, paramInt, localBundle, Boolean.valueOf(this.wEo));
    AppMethodBeat.o(190443);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(104262);
    if (this.mStatus == 3) {
      h("fail", this.wEs, "", this.wEv);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(104262);
      return;
      d.wDy.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104250);
    Log.i("MicroMsg.FaceActionUI", "onCreate()");
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.flash.c.b.epN().gmj = 1L;
    com.tencent.mm.plugin.flash.c.b.aHi("enter");
    getWindow().setFlags(1024, 1024);
    getWindow().addFlags(2097280);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.wEu = 0;
    this.startTime = Util.currentTicks();
    this.fyO = 4;
    if (Build.VERSION.SDK_INT >= 16) {
      getWindow().getDecorView().setSystemUiVisibility(1280);
    }
    setActionbarColor(getContext().getResources().getColor(a.b.white));
    Log.d("MicroMsg.FaceActionUI", "initLayout");
    this.wEe = ((ImageView)findViewById(a.e.background_view));
    djg();
    this.wDY = ((RelativeLayout)findViewById(a.e.face_upload_layout));
    this.wDZ = ((RelativeLayout)findViewById(a.e.face_upload_success_layout));
    this.wEa = ((RelativeLayout)findViewById(a.e.face_upload_failed_layout));
    this.wDY.setVisibility(4);
    this.wDZ.setVisibility(4);
    this.wEa.setVisibility(4);
    this.wEh = ((ImageView)findViewById(a.e.face_detect_upload));
    this.wEj = ((ImageView)findViewById(a.e.face_detect_scan));
    this.wEk = ((ImageView)findViewById(a.e.face_detect_upload_success_right));
    this.wEn = ((TextView)findViewById(a.e.face_detect_upload_failed_tips));
    this.wEl = ((Button)findViewById(a.e.face_detect_upload_failed_btn1));
    this.wEm = ((Button)findViewById(a.e.face_detect_upload_failed_btn2));
    if (!Util.isNullOrNil(d.wDy.fSD))
    {
      this.wEm.setText(d.wDy.fSD);
      this.wEm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104245);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.FaceActionUI", "click mUploadFailedConfig");
          FaceActionUI.q(FaceActionUI.this);
          FaceActionUI.this.h("fail", FaceActionUI.o(FaceActionUI.this), "", FaceActionUI.p(FaceActionUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(104245);
        }
      });
    }
    while (p.ak(this))
    {
      Log.i("MicroMsg.FaceActionUI", "carson: checkFacePermissionAnd Request true and do init ");
      djf();
      AppMethodBeat.o(104250);
      return;
      this.wEm.setVisibility(8);
    }
    Log.i("MicroMsg.FaceActionUI", "carson: no camera permission. request permission");
    AppMethodBeat.o(104250);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104256);
    super.onDestroy();
    Log.i("MicroMsg.FaceActionUI", "onDestroy");
    d.wDy.release(true);
    d.wDy.iXq = null;
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
      djf();
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
      this.wEn.setText((CharSequence)localObject);
      this.wEl.setText(a.i.face_severe_error_main_btn);
      this.wEl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104248);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.FaceActionUI", "click finish");
          FaceActionUI.this.h("fail", 90010, "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(104248);
        }
      });
      this.wDX.setVisibility(8);
      this.wEa.setVisibility(0);
      this.wEj.clearAnimation();
      this.wEe.setVisibility(0);
      this.wDY.setVisibility(8);
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
    djh();
    AppMethodBeat.o(104253);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(104252);
    Log.d("MicroMsg.FaceActionUI", "onStart");
    super.onStart();
    if (this.wEp != null)
    {
      this.wEp.a(this.wEd);
      this.wEp.djj();
    }
    AppMethodBeat.o(104252);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(104255);
    Log.i("MicroMsg.FaceActionUI", "onStop");
    super.onStop();
    if (this.wEp != null) {
      this.wEp.wzA = false;
    }
    AppMethodBeat.o(104255);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI
 * JD-Core Version:    0.7.0.1
 */