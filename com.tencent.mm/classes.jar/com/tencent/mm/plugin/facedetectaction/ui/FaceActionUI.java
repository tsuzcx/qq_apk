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
import com.tencent.mm.plugin.facedetectlight.ui.b;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.a;

@a(3)
public class FaceActionUI
  extends MMActivity
{
  int dcp;
  private long endTime;
  RelativeLayout qBK;
  RelativeLayout qBL;
  RelativeLayout qBM;
  ImageView qBN;
  ImageView qBO;
  ImageView qBP;
  private int qFr;
  private String qFs;
  private a.a qFv;
  RelativeLayout qGd;
  private PreviewFrameLayout qGe;
  private FaceActionMask qGf;
  private MMTextureView qGg;
  ImageView qGh;
  private TextView qGi;
  private TextView qGj;
  private ImageView qGk;
  private Button qGl;
  private Button qGm;
  private TextView qGn;
  public boolean qGo = false;
  b qGp;
  private int qGq;
  private int qGr;
  private String qGs;
  private int qGt;
  private String qGu = "";
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
  
  private void coJ()
  {
    AppMethodBeat.i(104257);
    this.qGd = ((RelativeLayout)findViewById(2131299697));
    this.qGe = ((PreviewFrameLayout)findViewById(2131299689));
    this.qGg = ((MMTextureView)findViewById(2131299688));
    this.qGg.setVisibility(4);
    this.qGf = ((FaceActionMask)findViewById(2131299690));
    this.qGk = ((ImageView)findViewById(2131299657));
    this.qGk.post(new Runnable()
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
    this.qGi = ((TextView)findViewById(2131299691));
    this.qGi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104243);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)FaceActionUI.l(FaceActionUI.this).getLayoutParams();
        int i = (int)(FaceActionUI.k(FaceActionUI.this).getHeight() * 0.4D) + (int)(FaceActionUI.k(FaceActionUI.this).getWidth() * 0.35D) + ao.fromDPToPix(FaceActionUI.this, 30);
        localMarginLayoutParams.topMargin = i;
        ac.i("MicroMsg.FaceActionUI", "topMargin：%d", new Object[] { Integer.valueOf(i) });
        FaceActionUI.l(FaceActionUI.this).setLayoutParams(localMarginLayoutParams);
        FaceActionUI.l(FaceActionUI.this).setVisibility(0);
        AppMethodBeat.o(104243);
      }
    });
    this.qGj = ((TextView)findViewById(2131299656));
    this.qGj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(104244);
        d.qFG.onBackPressed();
        FaceActionUI.this.finish();
        AppMethodBeat.o(104244);
      }
    });
    AppMethodBeat.o(104257);
  }
  
  private void coK()
  {
    AppMethodBeat.i(104263);
    ac.i("MicroMsg.FaceActionUI", "preview");
    if (this.qGp != null)
    {
      this.qGp.qGN = true;
      ac.i("MicroMsg.FaceActionUI", "mCamera ！= null");
    }
    this.qGi.setText(2131758753);
    AppMethodBeat.o(104263);
  }
  
  private void cod()
  {
    AppMethodBeat.i(104251);
    this.qFv = new a.a() {};
    d.qFG.qFM = new d.a()
    {
      public final void a(int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString1, final String paramAnonymousString2, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(207492);
        ac.i("MicroMsg.FaceActionUI", "onError, err: %s, cgiErrCode: %s, cgiErrMsg: %s,retry: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString1, Integer.valueOf(paramAnonymousInt3) });
        FaceActionUI.b(FaceActionUI.this, paramAnonymousInt1);
        FaceActionUI.c(FaceActionUI.this, paramAnonymousInt2);
        FaceActionUI.c(FaceActionUI.this, paramAnonymousString1);
        FaceActionUI.b(FaceActionUI.this, paramAnonymousString2);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104237);
            if (!bs.isNullOrNil(paramAnonymousString1))
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
                  ac.i("MicroMsg.FaceActionUI", "click retry");
                  FaceActionUI.i(FaceActionUI.this);
                  AppMethodBeat.o(104235);
                }
              });
            }
            for (;;)
            {
              FaceActionUI.e(FaceActionUI.this).clearAnimation();
              FaceActionUI localFaceActionUI = FaceActionUI.this;
              localFaceActionUI.qGd.setVisibility(8);
              localFaceActionUI.qBM.setVisibility(0);
              localFaceActionUI.qBO.clearAnimation();
              localFaceActionUI.qGh.setVisibility(0);
              localFaceActionUI.qBK.setVisibility(8);
              d.qFG.mStatus = 3;
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
                  ac.i("MicroMsg.FaceActionUI", "click finish");
                  FaceActionUI.this.g("fail", FaceActionUI.2.4.this.qGC, "", FaceActionUI.2.4.this.qGD);
                  AppMethodBeat.o(104236);
                }
              });
            }
          }
        });
        AppMethodBeat.o(207492);
      }
      
      public final void a(final axf paramAnonymousaxf)
      {
        AppMethodBeat.i(207491);
        ac.i("MicroMsg.FaceActionUI", "onVerifyFinish:   authToken ：%s", new Object[] { paramAnonymousaxf.Eua });
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104234);
            FaceActionUI.e(FaceActionUI.this).clearAnimation();
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            localFaceActionUI.qGd.setVisibility(8);
            localFaceActionUI.qBO.clearAnimation();
            localFaceActionUI.qBK.setVisibility(8);
            localFaceActionUI.qGh.setVisibility(0);
            localFaceActionUI.qBL.setVisibility(0);
            localFaceActionUI.qBP.setScaleX(0.0F);
            localFaceActionUI.qBP.setScaleY(0.0F);
            localFaceActionUI.qBP.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
            FaceActionUI.b(FaceActionUI.this, paramAnonymousaxf.EPh);
            localFaceActionUI = FaceActionUI.this;
            String str1 = paramAnonymousaxf.Eua;
            String str2 = paramAnonymousaxf.EPh;
            ac.i("MicroMsg.FaceActionUI", "callbackDetectSuccess（）");
            Bundle localBundle = new Bundle();
            localBundle.putString("token", str1);
            localBundle.putString("serial_id", str2);
            localFaceActionUI.dcp = 0;
            localFaceActionUI.a("ok", 0, localBundle, Boolean.valueOf(localFaceActionUI.qGo));
            AppMethodBeat.o(104234);
          }
        });
        AppMethodBeat.o(207491);
      }
      
      public final void aT(final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(104238);
        ac.i("MicroMsg.FaceActionUI", "onInitFaceCheckFinish: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        ap.f(new Runnable()
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
      
      public final void coI()
      {
        AppMethodBeat.i(104239);
        ac.i("MicroMsg.FaceActionUI", "onStartUpload");
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104233);
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            if (localFaceActionUI.qGp != null) {
              localFaceActionUI.qGp.stopPreview();
            }
            localFaceActionUI.qGd.setVisibility(8);
            localFaceActionUI.qBK.setVisibility(0);
            TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, localFaceActionUI.qBN.getHeight());
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
            localFaceActionUI.qBO.startAnimation(localAnimationSet);
            AppMethodBeat.o(104233);
          }
        });
        AppMethodBeat.o(104239);
      }
    };
    d.qFG.iMV = this;
    d.qFG.a(this);
    AppMethodBeat.o(104251);
  }
  
  private Intent d(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(104261);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramInt);
    localBundle.putString("err_msg", paramString);
    localBundle.putInt("scene", this.scene);
    localBundle.putInt("countFace", this.qGt);
    localBundle.putInt("err_type", this.dcp);
    this.endTime = bs.Gn();
    ac.i("MicroMsg.FaceActionUI", "endTime：" + this.endTime);
    ac.i("MicroMsg.FaceActionUI", "startTime：" + this.startTime);
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
    ac.i("MicroMsg.FaceActionUI", "finishWithResult errMsg: %s, errCode: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = "yes";; paramBoolean = "no")
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("click_other_verify_btn", paramBoolean);
      if (paramBundle != null) {
        localBundle.putAll(paramBundle);
      }
      ac.i("MicroMsg.FaceActionUI", "seriaId:%s", new Object[] { this.qGu });
      localBundle.putString("serial_id", this.qGu);
      c(paramString, paramInt, localBundle);
      finish();
      AppMethodBeat.o(104259);
      return;
    }
  }
  
  public final void g(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(207493);
    ac.i("MicroMsg.FaceActionUI", "callbackDetectFailed（）");
    Bundle localBundle = new Bundle();
    localBundle.putString("token", paramString2);
    localBundle.putString("serial_id", paramString3);
    a(paramString1, paramInt, localBundle, Boolean.valueOf(this.qGo));
    AppMethodBeat.o(207493);
  }
  
  public int getLayoutId()
  {
    return 2131493903;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(104262);
    d.qFG.onBackPressed();
    finish();
    AppMethodBeat.o(104262);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104250);
    ac.d("MicroMsg.FaceActionUI", "start VerifyActivity");
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getWindow().addFlags(2097280);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.qGt = 0;
    this.startTime = bs.Gn();
    this.dcp = 4;
    if (Build.VERSION.SDK_INT >= 16) {
      getWindow().getDecorView().setSystemUiVisibility(1280);
    }
    setActionbarColor(getContext().getResources().getColor(2131101179));
    ac.d("MicroMsg.FaceActionUI", "initLayout");
    this.qGh = ((ImageView)findViewById(2131297031));
    coJ();
    this.qBK = ((RelativeLayout)findViewById(2131299731));
    this.qBL = ((RelativeLayout)findViewById(2131299732));
    this.qBM = ((RelativeLayout)findViewById(2131299730));
    this.qBK.setVisibility(4);
    this.qBL.setVisibility(4);
    this.qBM.setVisibility(4);
    this.qBN = ((ImageView)findViewById(2131299673));
    this.qBO = ((ImageView)findViewById(2131299670));
    this.qBP = ((ImageView)findViewById(2131299680));
    this.qGn = ((TextView)findViewById(2131299678));
    this.qGl = ((Button)findViewById(2131299676));
    this.qGm = ((Button)findViewById(2131299677));
    if (!bs.isNullOrNil(d.qFG.dtU))
    {
      this.qGm.setText(d.qFG.dtU);
      this.qGm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104245);
          ac.i("MicroMsg.FaceActionUI", "click mUploadFailedConfig");
          FaceActionUI.m(FaceActionUI.this);
          FaceActionUI.this.g("fail", FaceActionUI.n(FaceActionUI.this), "", "");
          AppMethodBeat.o(104245);
        }
      });
    }
    while (p.al(this))
    {
      ac.i("MicroMsg.FaceActionUI", "carson: checkFacePermissionAnd Request true and do init ");
      cod();
      AppMethodBeat.o(104250);
      return;
      this.qGm.setVisibility(8);
    }
    ac.i("MicroMsg.FaceActionUI", "carson: no camera permission. request permission");
    AppMethodBeat.o(104250);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104256);
    super.onDestroy();
    ac.i("MicroMsg.FaceActionUI", "onDestroy");
    d.qFG.release(true);
    AppMethodBeat.o(104256);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(104254);
    ac.d("MicroMsg.FaceActionUI", "onPause");
    super.onPause();
    AppMethodBeat.o(104254);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(104264);
    ac.i("MicroMsg.FaceActionUI", "carson onRequestPermissionsResult");
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
      cod();
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
      ac.i("MicroMsg.FaceActionUI", "carson PermissionsResult:errMsg".concat(String.valueOf(str1)));
      ac.i("MicroMsg.FaceActionUI", "carson PermissionsResult:showErrMsg".concat(String.valueOf(localObject)));
      ac.i("MicroMsg.FaceActionUI", "checkPermissionFailedAnimation");
      this.qGn.setText((CharSequence)localObject);
      this.qGl.setText(2131758760);
      this.qGl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104248);
          ac.i("MicroMsg.FaceActionUI", "click finish");
          FaceActionUI.this.g("fail", 90010, "", "");
          AppMethodBeat.o(104248);
        }
      });
      this.qGd.setVisibility(8);
      this.qBM.setVisibility(0);
      this.qBO.clearAnimation();
      this.qGh.setVisibility(0);
      this.qBK.setVisibility(8);
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
    ac.d("MicroMsg.FaceActionUI", "onResume");
    coK();
    AppMethodBeat.o(104253);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(104252);
    ac.d("MicroMsg.FaceActionUI", "onStart");
    super.onStart();
    if (this.qGp != null)
    {
      this.qGp.a(this.qGg);
      this.qGp.coP();
    }
    AppMethodBeat.o(104252);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(104255);
    ac.i("MicroMsg.FaceActionUI", "onStop");
    super.onStop();
    if (this.qGp != null) {
      this.qGp.qBh = false;
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