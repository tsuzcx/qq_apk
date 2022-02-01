package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.a.a;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.plugin.facedetectaction.b.d.a;
import com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;

@com.tencent.mm.ui.base.a(3)
public class FaceActionUI
  extends MMActivity
{
  int dnL;
  private long endTime;
  RelativeLayout rlA;
  RelativeLayout rlB;
  RelativeLayout rlC;
  ImageView rlD;
  ImageView rlE;
  ImageView rlF;
  RelativeLayout rpW;
  private PreviewFrameLayout rpX;
  private FaceActionMask rpY;
  private MMTextureView rpZ;
  private int rpj;
  private String rpk;
  private a.a rpn;
  ImageView rqa;
  private TextView rqb;
  private TextView rqc;
  private ImageView rqd;
  private Button rqe;
  private Button rqf;
  private TextView rqg;
  public boolean rqh = false;
  com.tencent.mm.plugin.facedetectlight.ui.b rqi;
  private int rqj;
  private int rqk;
  private String rql;
  private int rqm;
  private String rqn = "";
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
    setResult(0, paramBundle);
    AppMethodBeat.o(104260);
  }
  
  private void ctI()
  {
    AppMethodBeat.i(104251);
    this.rpn = new a.a() {};
    d.rpy.rpE = new d.a()
    {
      public final void a(int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString1, final String paramAnonymousString2, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(213179);
        ad.i("MicroMsg.FaceActionUI", "onError, err: %s, cgiErrCode: %s, cgiErrMsg: %s,retry: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString1, Integer.valueOf(paramAnonymousInt3) });
        FaceActionUI.b(FaceActionUI.this, paramAnonymousInt1);
        FaceActionUI.c(FaceActionUI.this, paramAnonymousInt2);
        FaceActionUI.c(FaceActionUI.this, paramAnonymousString1);
        FaceActionUI.b(FaceActionUI.this, paramAnonymousString2);
        com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104237);
            if (!bt.isNullOrNil(paramAnonymousString1))
            {
              FaceActionUI.f(FaceActionUI.this).setText(paramAnonymousString1);
              FaceActionUI.g(FaceActionUI.this);
              if (paramAnonymousInt3 != 1) {
                break label180;
              }
              FaceActionUI.h(FaceActionUI.this).setText(2131758761);
              FaceActionUI.h(FaceActionUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous3View)
                {
                  AppMethodBeat.i(104235);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous3View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  ad.i("MicroMsg.FaceActionUI", "click retry");
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
              localFaceActionUI.rpW.setVisibility(8);
              localFaceActionUI.rlC.setVisibility(0);
              localFaceActionUI.rlE.clearAnimation();
              localFaceActionUI.rqa.setVisibility(0);
              localFaceActionUI.rlA.setVisibility(8);
              d.rpy.mStatus = 3;
              AppMethodBeat.o(104237);
              return;
              FaceActionUI.f(FaceActionUI.this).setText(2131758680);
              break;
              label180:
              FaceActionUI.h(FaceActionUI.this).setText(2131758760);
              FaceActionUI.h(FaceActionUI.this).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous3View)
                {
                  AppMethodBeat.i(104236);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous3View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  ad.i("MicroMsg.FaceActionUI", "click finish");
                  FaceActionUI.this.g("fail", FaceActionUI.2.4.this.rqv, "", FaceActionUI.2.4.this.rqw);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(104236);
                }
              });
            }
          }
        });
        AppMethodBeat.o(213179);
      }
      
      public final void a(final bbf paramAnonymousbbf)
      {
        AppMethodBeat.i(213178);
        ad.i("MicroMsg.FaceActionUI", "onVerifyFinish:   authToken ：%s", new Object[] { paramAnonymousbbf.Gbt });
        com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104234);
            FaceActionUI.e(FaceActionUI.this).clearAnimation();
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            localFaceActionUI.rpW.setVisibility(8);
            localFaceActionUI.rlE.clearAnimation();
            localFaceActionUI.rlA.setVisibility(8);
            localFaceActionUI.rqa.setVisibility(0);
            localFaceActionUI.rlB.setVisibility(0);
            localFaceActionUI.rlF.setScaleX(0.0F);
            localFaceActionUI.rlF.setScaleY(0.0F);
            localFaceActionUI.rlF.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
            FaceActionUI.b(FaceActionUI.this, paramAnonymousbbf.Gyp);
            localFaceActionUI = FaceActionUI.this;
            String str1 = paramAnonymousbbf.Gbt;
            String str2 = paramAnonymousbbf.Gyp;
            ad.i("MicroMsg.FaceActionUI", "callbackDetectSuccess（）");
            Bundle localBundle = new Bundle();
            localBundle.putString("token", str1);
            localBundle.putString("serial_id", str2);
            localFaceActionUI.dnL = 0;
            localFaceActionUI.a("ok", 0, localBundle, Boolean.valueOf(localFaceActionUI.rqh));
            AppMethodBeat.o(104234);
          }
        });
        AppMethodBeat.o(213178);
      }
      
      public final void aW(final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(104238);
        ad.i("MicroMsg.FaceActionUI", "onInitFaceCheckFinish: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
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
      
      public final void cun()
      {
        AppMethodBeat.i(104239);
        ad.i("MicroMsg.FaceActionUI", "onStartUpload");
        com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104233);
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            if (localFaceActionUI.rqi != null) {
              localFaceActionUI.rqi.stopPreview();
            }
            localFaceActionUI.rpW.setVisibility(8);
            localFaceActionUI.rlA.setVisibility(0);
            TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, localFaceActionUI.rlD.getHeight());
            localTranslateAnimation.setDuration(2000L);
            localTranslateAnimation.setRepeatMode(2);
            localTranslateAnimation.setRepeatCount(-1);
            ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation.setDuration(1000L);
            localScaleAnimation.setRepeatMode(2);
            localScaleAnimation.setRepeatCount(-1);
            AnimationSet localAnimationSet = new AnimationSet(true);
            localAnimationSet.addAnimation(localTranslateAnimation);
            localAnimationSet.addAnimation(localScaleAnimation);
            localAnimationSet.setAnimationListener(new FaceActionUI.7(localFaceActionUI));
            localAnimationSet.setRepeatCount(-1);
            localFaceActionUI.rlE.startAnimation(localAnimationSet);
            AppMethodBeat.o(104233);
          }
        });
        AppMethodBeat.o(104239);
      }
    };
    d.rpy.fLP = this;
    d.rpy.a(this);
    AppMethodBeat.o(104251);
  }
  
  private void cuo()
  {
    AppMethodBeat.i(104257);
    this.rpW = ((RelativeLayout)findViewById(2131299697));
    this.rpX = ((PreviewFrameLayout)findViewById(2131299689));
    this.rpZ = ((MMTextureView)findViewById(2131299688));
    this.rpZ.setVisibility(4);
    this.rpY = ((FaceActionMask)findViewById(2131299690));
    this.rqd = ((ImageView)findViewById(2131299657));
    this.rqd.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104242);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.j(FaceActionUI.this).getLayoutParams();
        localMarginLayoutParams.topMargin = ((int)(FaceActionUI.k(FaceActionUI.this).getHeight() * 0.4D));
        FaceActionUI.j(FaceActionUI.this).setLayoutParams(localMarginLayoutParams);
        FaceActionUI.j(FaceActionUI.this).setVisibility(0);
        AppMethodBeat.o(104242);
      }
    });
    this.rqb = ((TextView)findViewById(2131299691));
    this.rqb.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104243);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.l(FaceActionUI.this).getLayoutParams();
        int i = (int)(FaceActionUI.k(FaceActionUI.this).getHeight() * 0.4D) + (int)(FaceActionUI.k(FaceActionUI.this).getWidth() * 0.35D) + com.tencent.mm.ui.aq.fromDPToPix(FaceActionUI.this, 30);
        localMarginLayoutParams.topMargin = i;
        ad.i("MicroMsg.FaceActionUI", "topMargin：%d", new Object[] { Integer.valueOf(i) });
        FaceActionUI.l(FaceActionUI.this).setLayoutParams(localMarginLayoutParams);
        FaceActionUI.l(FaceActionUI.this).setVisibility(0);
        AppMethodBeat.o(104243);
      }
    });
    this.rqc = ((TextView)findViewById(2131299656));
    this.rqc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(104244);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        d.rpy.onBackPressed();
        FaceActionUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(104244);
      }
    });
    AppMethodBeat.o(104257);
  }
  
  private void cup()
  {
    AppMethodBeat.i(104263);
    ad.i("MicroMsg.FaceActionUI", "preview");
    if (this.rqi != null)
    {
      this.rqi.rqM = true;
      ad.i("MicroMsg.FaceActionUI", "mCamera ！= null");
    }
    this.rqb.setText(2131758753);
    AppMethodBeat.o(104263);
  }
  
  private Intent d(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(104261);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramInt);
    localBundle.putString("err_msg", paramString);
    localBundle.putInt("scene", this.scene);
    localBundle.putInt("countFace", this.rqm);
    localBundle.putInt("err_type", this.dnL);
    this.endTime = bt.HI();
    ad.i("MicroMsg.FaceActionUI", "endTime：" + this.endTime);
    ad.i("MicroMsg.FaceActionUI", "startTime：" + this.startTime);
    localBundle.putLong("totalTime", this.endTime - this.startTime);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramString = new Intent();
    paramString.putExtras(localBundle);
    AppMethodBeat.o(104261);
    return paramString;
  }
  
  public final void a(String paramString, int paramInt, Bundle paramBundle, Boolean paramBoolean)
  {
    AppMethodBeat.i(104259);
    ad.i("MicroMsg.FaceActionUI", "finishWithResult errMsg: %s, errCode: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = "yes";; paramBoolean = "no")
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("click_other_verify_btn", paramBoolean);
      if (paramBundle != null) {
        localBundle.putAll(paramBundle);
      }
      ad.i("MicroMsg.FaceActionUI", "seriaId:%s", new Object[] { this.rqn });
      localBundle.putString("serial_id", this.rqn);
      c(paramString, paramInt, localBundle);
      finish();
      AppMethodBeat.o(104259);
      return;
    }
  }
  
  public final void g(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213180);
    ad.i("MicroMsg.FaceActionUI", "callbackDetectFailed（）");
    Bundle localBundle = new Bundle();
    localBundle.putString("token", paramString2);
    localBundle.putString("serial_id", paramString3);
    a(paramString1, paramInt, localBundle, Boolean.valueOf(this.rqh));
    AppMethodBeat.o(213180);
  }
  
  public int getLayoutId()
  {
    return 2131493903;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(104262);
    d.rpy.onBackPressed();
    finish();
    AppMethodBeat.o(104262);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104250);
    ad.d("MicroMsg.FaceActionUI", "start VerifyActivity");
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getWindow().addFlags(2097280);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.rqm = 0;
    this.startTime = bt.HI();
    this.dnL = 4;
    if (Build.VERSION.SDK_INT >= 16) {
      getWindow().getDecorView().setSystemUiVisibility(1280);
    }
    setActionbarColor(getContext().getResources().getColor(2131101179));
    ad.d("MicroMsg.FaceActionUI", "initLayout");
    this.rqa = ((ImageView)findViewById(2131297031));
    cuo();
    this.rlA = ((RelativeLayout)findViewById(2131299731));
    this.rlB = ((RelativeLayout)findViewById(2131299732));
    this.rlC = ((RelativeLayout)findViewById(2131299730));
    this.rlA.setVisibility(4);
    this.rlB.setVisibility(4);
    this.rlC.setVisibility(4);
    this.rlD = ((ImageView)findViewById(2131299673));
    this.rlE = ((ImageView)findViewById(2131299670));
    this.rlF = ((ImageView)findViewById(2131299680));
    this.rqg = ((TextView)findViewById(2131299678));
    this.rqe = ((Button)findViewById(2131299676));
    this.rqf = ((Button)findViewById(2131299677));
    if (!bt.isNullOrNil(d.rpy.dFU))
    {
      this.rqf.setText(d.rpy.dFU);
      this.rqf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104245);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.FaceActionUI", "click mUploadFailedConfig");
          FaceActionUI.m(FaceActionUI.this);
          FaceActionUI.this.g("fail", FaceActionUI.n(FaceActionUI.this), "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(104245);
        }
      });
    }
    while (p.al(this))
    {
      ad.i("MicroMsg.FaceActionUI", "carson: checkFacePermissionAnd Request true and do init ");
      ctI();
      AppMethodBeat.o(104250);
      return;
      this.rqf.setVisibility(8);
    }
    ad.i("MicroMsg.FaceActionUI", "carson: no camera permission. request permission");
    AppMethodBeat.o(104250);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104256);
    super.onDestroy();
    ad.i("MicroMsg.FaceActionUI", "onDestroy");
    d.rpy.release(true);
    AppMethodBeat.o(104256);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(104254);
    ad.d("MicroMsg.FaceActionUI", "onPause");
    super.onPause();
    AppMethodBeat.o(104254);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(104264);
    ad.i("MicroMsg.FaceActionUI", "carson onRequestPermissionsResult");
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
      ctI();
    }
    String str1;
    Object localObject;
    if (paramArrayOfString[0].equals("android.permission.CAMERA"))
    {
      str1 = "camera permission not granted";
      localObject = getString(2131761860);
    }
    for (;;)
    {
      ad.i("MicroMsg.FaceActionUI", "carson PermissionsResult:errMsg".concat(String.valueOf(str1)));
      ad.i("MicroMsg.FaceActionUI", "carson PermissionsResult:showErrMsg".concat(String.valueOf(localObject)));
      ad.i("MicroMsg.FaceActionUI", "checkPermissionFailedAnimation");
      this.rqg.setText((CharSequence)localObject);
      this.rqe.setText(2131758760);
      this.rqe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104248);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.FaceActionUI", "click finish");
          FaceActionUI.this.g("fail", 90010, "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(104248);
        }
      });
      this.rpW.setVisibility(8);
      this.rlC.setVisibility(0);
      this.rlE.clearAnimation();
      this.rqa.setVisibility(0);
      this.rlA.setVisibility(8);
      paramInt = 0;
      break label77;
      localObject = str3;
      str1 = str2;
      if (paramArrayOfString[0].equals("android.permission.RECORD_AUDIO"))
      {
        str1 = "audio permission not granted";
        localObject = getString(2131761871);
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
            paramArrayOfString = getString(2131761860);
          }
          if (paramArrayOfInt[1] != 0)
          {
            str2 = "audio permission not granted";
            paramArrayOfString = getString(2131761871);
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
              localObject = getString(2131761860);
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
    ad.d("MicroMsg.FaceActionUI", "onResume");
    cup();
    AppMethodBeat.o(104253);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(104252);
    ad.d("MicroMsg.FaceActionUI", "onStart");
    super.onStart();
    if (this.rqi != null)
    {
      this.rqi.a(this.rpZ);
      this.rqi.cuu();
    }
    AppMethodBeat.o(104252);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(104255);
    ad.i("MicroMsg.FaceActionUI", "onStop");
    super.onStop();
    if (this.rqi != null) {
      this.rqi.rkX = false;
    }
    AppMethodBeat.o(104255);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI
 * JD-Core Version:    0.7.0.1
 */