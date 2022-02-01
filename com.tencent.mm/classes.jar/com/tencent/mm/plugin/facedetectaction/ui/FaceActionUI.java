package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.plugin.facedetect.model.c;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.a.a;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.plugin.facedetectaction.b.d.a;
import com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;

@com.tencent.mm.ui.base.a(3)
public class FaceActionUI
  extends MMActivity
{
  int dGe;
  private long endTime;
  private int mStatus = 0;
  RelativeLayout sXY;
  RelativeLayout sXZ;
  private int sXk;
  private String sXl;
  private a.a sXn;
  RelativeLayout sYa;
  RelativeLayout sYb;
  private PreviewFrameLayout sYc;
  private FaceActionMask sYd;
  private MMTextureView sYe;
  ImageView sYf;
  private TextView sYg;
  private TextView sYh;
  ImageView sYi;
  private ImageView sYj;
  ImageView sYk;
  ImageView sYl;
  private Button sYm;
  private Button sYn;
  private TextView sYo;
  public boolean sYp = false;
  com.tencent.mm.plugin.facedetectlight.ui.a sYq;
  private int sYr;
  private int sYs;
  private String sYt;
  private int sYu;
  private String sYv = "";
  private int scene;
  private long startTime;
  
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
    com.tencent.mm.plugin.flash.c.b.axn("usrCancel");
    setResult(0, paramBundle);
    AppMethodBeat.o(104260);
  }
  
  private void cTZ()
  {
    AppMethodBeat.i(104251);
    this.sXn = new a.a() {};
    d.sXz.sXE = new d.a()
    {
      public final void a(int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString1, final String paramAnonymousString2, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(186395);
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
                break label191;
              }
              FaceActionUI.h(FaceActionUI.this).setText(2131759082);
              FaceActionUI.h(FaceActionUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous3View)
                {
                  AppMethodBeat.i(104235);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous3View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
              localFaceActionUI.sXY.setVisibility(8);
              localFaceActionUI.sYb.setVisibility(0);
              localFaceActionUI.sYk.clearAnimation();
              localFaceActionUI.sYf.setVisibility(0);
              localFaceActionUI.sXZ.setVisibility(8);
              d.sXz.mStatus = 3;
              FaceActionUI.j(FaceActionUI.this);
              AppMethodBeat.o(104237);
              return;
              FaceActionUI.f(FaceActionUI.this).setText(2131758986);
              break;
              label191:
              FaceActionUI.h(FaceActionUI.this).setText(2131759081);
              FaceActionUI.h(FaceActionUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous3View)
                {
                  AppMethodBeat.i(104236);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous3View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  Log.i("MicroMsg.FaceActionUI", "click finish");
                  FaceActionUI.this.g("fail", FaceActionUI.3.4.this.sYE, "", FaceActionUI.3.4.this.sYF);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(104236);
                }
              });
            }
          }
        });
        AppMethodBeat.o(186395);
      }
      
      public final void a(final bnh paramAnonymousbnh)
      {
        AppMethodBeat.i(186394);
        Log.i("MicroMsg.FaceActionUI", "onVerifyFinish:   authToken ：%s", new Object[] { paramAnonymousbnh.LpC });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104234);
            FaceActionUI.e(FaceActionUI.this).clearAnimation();
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            localFaceActionUI.sXY.setVisibility(8);
            localFaceActionUI.sYk.clearAnimation();
            localFaceActionUI.sXZ.setVisibility(8);
            localFaceActionUI.sYf.setVisibility(0);
            localFaceActionUI.sYa.setVisibility(0);
            localFaceActionUI.sYl.setScaleX(0.0F);
            localFaceActionUI.sYl.setScaleY(0.0F);
            localFaceActionUI.sYl.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
            FaceActionUI.b(FaceActionUI.this, paramAnonymousbnh.LVU);
            localFaceActionUI = FaceActionUI.this;
            String str1 = paramAnonymousbnh.LpC;
            String str2 = paramAnonymousbnh.LVU;
            Log.i("MicroMsg.FaceActionUI", "callbackDetectSuccess（）");
            Bundle localBundle = new Bundle();
            localBundle.putString("token", str1);
            localBundle.putString("serial_id", str2);
            localFaceActionUI.dGe = 0;
            localFaceActionUI.a("ok", 0, localBundle, Boolean.valueOf(localFaceActionUI.sYp));
            AppMethodBeat.o(104234);
          }
        });
        AppMethodBeat.o(186394);
      }
      
      public final void aX(final int paramAnonymousInt, final String paramAnonymousString)
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
      
      public final void cTY()
      {
        AppMethodBeat.i(104239);
        Log.i("MicroMsg.FaceActionUI", "onStartUpload");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104233);
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            if (localFaceActionUI.sYq != null)
            {
              localObject = localFaceActionUI.sYq;
              Log.i("MicroMsg.FaceReflectCam", "stopPreview ,isPreview %s camera:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).sZd), ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).sZb });
              if (((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).sZb != null)
              {
                ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).sZd = false;
                ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).sZb.stopPreview();
                ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).sZb.setPreviewCallback(null);
                ((com.tencent.mm.plugin.facedetectlight.ui.a)localObject).sZm.removeCallbacksAndMessages(null);
                c.sQB.aRR();
              }
            }
            localFaceActionUI.sXY.setVisibility(8);
            localFaceActionUI.sXZ.setVisibility(0);
            Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, localFaceActionUI.sYi.getHeight());
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
            localFaceActionUI.sYk.startAnimation(localAnimationSet);
            AppMethodBeat.o(104233);
          }
        });
        AppMethodBeat.o(104239);
      }
    };
    d.sXz.gte = this;
    d.sXz.a(this);
    AppMethodBeat.o(104251);
  }
  
  private void cUa()
  {
    AppMethodBeat.i(104257);
    this.sXY = ((RelativeLayout)findViewById(2131300362));
    this.sYc = ((PreviewFrameLayout)findViewById(2131300351));
    this.sYe = ((MMTextureView)findViewById(2131300350));
    this.sYe.setVisibility(4);
    this.sYd = ((FaceActionMask)findViewById(2131300352));
    this.sYj = ((ImageView)findViewById(2131300298));
    this.sYj.post(new FaceActionUI.4(this));
    this.sYg = ((TextView)findViewById(2131300353));
    this.sYg.post(new FaceActionUI.5(this));
    this.sYh = ((TextView)findViewById(2131300297));
    this.sYh.setOnClickListener(new FaceActionUI.6(this));
    this.mStatus = 0;
    AppMethodBeat.o(104257);
  }
  
  private void cUb()
  {
    AppMethodBeat.i(104263);
    Log.i("MicroMsg.FaceActionUI", "preview");
    if (this.sYq != null)
    {
      this.sYq.sZd = true;
      Log.i("MicroMsg.FaceActionUI", "mCamera ！= null");
    }
    this.sYg.setText(2131759074);
    AppMethodBeat.o(104263);
  }
  
  private Intent d(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(104261);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramInt);
    localBundle.putString("err_msg", paramString);
    localBundle.putInt("scene", this.scene);
    localBundle.putInt("countFace", this.sYu);
    localBundle.putInt("err_type", this.dGe);
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
      Log.i("MicroMsg.FaceActionUI", "seriaId:%s", new Object[] { this.sYv });
      localBundle.putString("serial_id", this.sYv);
      c(paramString, paramInt, localBundle);
      if (paramInt != 0) {
        break;
      }
      Log.i("MicroMsg.FaceActionUI", "errCode == ConstantsFace.UploadErrCode.OK");
      h.RTc.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104249);
          com.tencent.mm.plugin.flash.c.b.MX(paramInt);
          FaceActionUI.this.finish();
          AppMethodBeat.o(104249);
        }
      }, 1500L);
      AppMethodBeat.o(104259);
      return;
    }
    com.tencent.mm.plugin.flash.c.b.MX(paramInt);
    finish();
    AppMethodBeat.o(104259);
  }
  
  public final void g(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(186396);
    Log.i("MicroMsg.FaceActionUI", "callbackDetectFailed（）");
    Bundle localBundle = new Bundle();
    localBundle.putString("token", paramString2);
    localBundle.putString("serial_id", paramString3);
    a(paramString1, paramInt, localBundle, Boolean.valueOf(this.sYp));
    AppMethodBeat.o(186396);
  }
  
  public int getLayoutId()
  {
    return 2131494060;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(104262);
    if (this.mStatus == 3) {
      g("fail", this.sYs, "", this.sYv);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(104262);
      return;
      d.sXz.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104250);
    Log.d("MicroMsg.FaceActionUI", "start VerifyActivity");
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.flash.c.b.dLj().eqQ = 1L;
    com.tencent.mm.plugin.flash.c.b.axn("enter");
    getWindow().setFlags(1024, 1024);
    getWindow().addFlags(2097280);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.sYu = 0;
    this.startTime = Util.currentTicks();
    this.dGe = 4;
    if (Build.VERSION.SDK_INT >= 16) {
      getWindow().getDecorView().setSystemUiVisibility(1280);
    }
    setActionbarColor(getContext().getResources().getColor(2131101424));
    Log.d("MicroMsg.FaceActionUI", "initLayout");
    this.sYf = ((ImageView)findViewById(2131297177));
    cUa();
    this.sXZ = ((RelativeLayout)findViewById(2131300397));
    this.sYa = ((RelativeLayout)findViewById(2131300398));
    this.sYb = ((RelativeLayout)findViewById(2131300396));
    this.sXZ.setVisibility(4);
    this.sYa.setVisibility(4);
    this.sYb.setVisibility(4);
    this.sYi = ((ImageView)findViewById(2131300325));
    this.sYk = ((ImageView)findViewById(2131300322));
    this.sYl = ((ImageView)findViewById(2131300332));
    this.sYo = ((TextView)findViewById(2131300330));
    this.sYm = ((Button)findViewById(2131300328));
    this.sYn = ((Button)findViewById(2131300329));
    if (!Util.isNullOrNil(d.sXz.dYL))
    {
      this.sYn.setText(d.sXz.dYL);
      this.sYn.setOnClickListener(new FaceActionUI.7(this));
    }
    while (p.aj(this))
    {
      Log.i("MicroMsg.FaceActionUI", "carson: checkFacePermissionAnd Request true and do init ");
      cTZ();
      AppMethodBeat.o(104250);
      return;
      this.sYn.setVisibility(8);
    }
    Log.i("MicroMsg.FaceActionUI", "carson: no camera permission. request permission");
    AppMethodBeat.o(104250);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104256);
    super.onDestroy();
    Log.i("MicroMsg.FaceActionUI", "onDestroy");
    d.sXz.release(true);
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
      cTZ();
    }
    String str1;
    Object localObject;
    if (paramArrayOfString[0].equals("android.permission.CAMERA"))
    {
      str1 = "camera permission not granted";
      localObject = getString(2131763864);
    }
    for (;;)
    {
      Log.i("MicroMsg.FaceActionUI", "carson PermissionsResult:errMsg".concat(String.valueOf(str1)));
      Log.i("MicroMsg.FaceActionUI", "carson PermissionsResult:showErrMsg".concat(String.valueOf(localObject)));
      Log.i("MicroMsg.FaceActionUI", "checkPermissionFailedAnimation");
      this.sYo.setText((CharSequence)localObject);
      this.sYm.setText(2131759081);
      this.sYm.setOnClickListener(new FaceActionUI.9(this));
      this.sXY.setVisibility(8);
      this.sYb.setVisibility(0);
      this.sYk.clearAnimation();
      this.sYf.setVisibility(0);
      this.sXZ.setVisibility(8);
      paramInt = 0;
      break label77;
      localObject = str3;
      str1 = str2;
      if (paramArrayOfString[0].equals("android.permission.RECORD_AUDIO"))
      {
        str1 = "audio permission not granted";
        localObject = getString(2131763876);
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
            paramArrayOfString = getString(2131763864);
          }
          if (paramArrayOfInt[1] != 0)
          {
            str2 = "audio permission not granted";
            paramArrayOfString = getString(2131763876);
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
              localObject = getString(2131763864);
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
    cUb();
    AppMethodBeat.o(104253);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(104252);
    Log.d("MicroMsg.FaceActionUI", "onStart");
    super.onStart();
    if (this.sYq != null)
    {
      this.sYq.a(this.sYe);
      this.sYq.cUd();
    }
    AppMethodBeat.o(104252);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(104255);
    Log.i("MicroMsg.FaceActionUI", "onStop");
    super.onStop();
    if (this.sYq != null) {
      this.sYq.sTE = false;
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