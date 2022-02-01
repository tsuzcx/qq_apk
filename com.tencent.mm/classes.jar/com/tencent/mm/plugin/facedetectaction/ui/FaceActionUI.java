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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.a.a;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.plugin.facedetectaction.b.d.a;
import com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;

@com.tencent.mm.ui.base.a(3)
public class FaceActionUI
  extends MMActivity
{
  int doQ;
  private long endTime;
  RelativeLayout rtF;
  RelativeLayout rtG;
  RelativeLayout rtH;
  ImageView rtI;
  ImageView rtJ;
  ImageView rtK;
  private int rxn;
  private String rxo;
  private a.a rxr;
  RelativeLayout rya;
  private PreviewFrameLayout ryb;
  private FaceActionMask ryc;
  private MMTextureView ryd;
  ImageView rye;
  private TextView ryf;
  private TextView ryg;
  private ImageView ryh;
  private Button ryi;
  private Button ryj;
  private TextView ryk;
  public boolean ryl = false;
  com.tencent.mm.plugin.facedetectlight.ui.b rym;
  private int ryn;
  private int ryo;
  private String ryp;
  private int ryq;
  private String ryr = "";
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
  
  private void cvP()
  {
    AppMethodBeat.i(104257);
    this.rya = ((RelativeLayout)findViewById(2131299697));
    this.ryb = ((PreviewFrameLayout)findViewById(2131299689));
    this.ryd = ((MMTextureView)findViewById(2131299688));
    this.ryd.setVisibility(4);
    this.ryc = ((FaceActionMask)findViewById(2131299690));
    this.ryh = ((ImageView)findViewById(2131299657));
    this.ryh.post(new FaceActionUI.3(this));
    this.ryf = ((TextView)findViewById(2131299691));
    this.ryf.post(new FaceActionUI.4(this));
    this.ryg = ((TextView)findViewById(2131299656));
    this.ryg.setOnClickListener(new FaceActionUI.5(this));
    AppMethodBeat.o(104257);
  }
  
  private void cvQ()
  {
    AppMethodBeat.i(104263);
    ae.i("MicroMsg.FaceActionUI", "preview");
    if (this.rym != null)
    {
      this.rym.rzb = true;
      ae.i("MicroMsg.FaceActionUI", "mCamera ！= null");
    }
    this.ryf.setText(2131758753);
    AppMethodBeat.o(104263);
  }
  
  private void cvj()
  {
    AppMethodBeat.i(104251);
    this.rxr = new a.a() {};
    d.rxC.rxI = new d.a()
    {
      public final void a(int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString1, final String paramAnonymousString2, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(188651);
        ae.i("MicroMsg.FaceActionUI", "onError, err: %s, cgiErrCode: %s, cgiErrMsg: %s,retry: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString1, Integer.valueOf(paramAnonymousInt3) });
        FaceActionUI.b(FaceActionUI.this, paramAnonymousInt1);
        FaceActionUI.c(FaceActionUI.this, paramAnonymousInt2);
        FaceActionUI.c(FaceActionUI.this, paramAnonymousString1);
        FaceActionUI.b(FaceActionUI.this, paramAnonymousString2);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104237);
            if (!bu.isNullOrNil(paramAnonymousString1))
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
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  ae.i("MicroMsg.FaceActionUI", "click retry");
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
              localFaceActionUI.rya.setVisibility(8);
              localFaceActionUI.rtH.setVisibility(0);
              localFaceActionUI.rtJ.clearAnimation();
              localFaceActionUI.rye.setVisibility(0);
              localFaceActionUI.rtF.setVisibility(8);
              d.rxC.mStatus = 3;
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
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  ae.i("MicroMsg.FaceActionUI", "click finish");
                  FaceActionUI.this.g("fail", FaceActionUI.2.4.this.ryz, "", FaceActionUI.2.4.this.ryA);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$2$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(104236);
                }
              });
            }
          }
        });
        AppMethodBeat.o(188651);
      }
      
      public final void a(final bbv paramAnonymousbbv)
      {
        AppMethodBeat.i(188650);
        ae.i("MicroMsg.FaceActionUI", "onVerifyFinish:   authToken ：%s", new Object[] { paramAnonymousbbv.Gua });
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104234);
            FaceActionUI.e(FaceActionUI.this).clearAnimation();
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            localFaceActionUI.rya.setVisibility(8);
            localFaceActionUI.rtJ.clearAnimation();
            localFaceActionUI.rtF.setVisibility(8);
            localFaceActionUI.rye.setVisibility(0);
            localFaceActionUI.rtG.setVisibility(0);
            localFaceActionUI.rtK.setScaleX(0.0F);
            localFaceActionUI.rtK.setScaleY(0.0F);
            localFaceActionUI.rtK.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
            FaceActionUI.b(FaceActionUI.this, paramAnonymousbbv.GRP);
            localFaceActionUI = FaceActionUI.this;
            String str1 = paramAnonymousbbv.Gua;
            String str2 = paramAnonymousbbv.GRP;
            ae.i("MicroMsg.FaceActionUI", "callbackDetectSuccess（）");
            Bundle localBundle = new Bundle();
            localBundle.putString("token", str1);
            localBundle.putString("serial_id", str2);
            localFaceActionUI.doQ = 0;
            localFaceActionUI.a("ok", 0, localBundle, Boolean.valueOf(localFaceActionUI.ryl));
            AppMethodBeat.o(104234);
          }
        });
        AppMethodBeat.o(188650);
      }
      
      public final void aV(final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(104238);
        ae.i("MicroMsg.FaceActionUI", "onInitFaceCheckFinish: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        ar.f(new Runnable()
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
      
      public final void cvO()
      {
        AppMethodBeat.i(104239);
        ae.i("MicroMsg.FaceActionUI", "onStartUpload");
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104233);
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            if (localFaceActionUI.rym != null) {
              localFaceActionUI.rym.stopPreview();
            }
            localFaceActionUI.rya.setVisibility(8);
            localFaceActionUI.rtF.setVisibility(0);
            TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, localFaceActionUI.rtI.getHeight());
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
            localFaceActionUI.rtJ.startAnimation(localAnimationSet);
            AppMethodBeat.o(104233);
          }
        });
        AppMethodBeat.o(104239);
      }
    };
    d.rxC.fNT = this;
    d.rxC.a(this);
    AppMethodBeat.o(104251);
  }
  
  private Intent d(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(104261);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramInt);
    localBundle.putString("err_msg", paramString);
    localBundle.putInt("scene", this.scene);
    localBundle.putInt("countFace", this.ryq);
    localBundle.putInt("err_type", this.doQ);
    this.endTime = bu.HQ();
    ae.i("MicroMsg.FaceActionUI", "endTime：" + this.endTime);
    ae.i("MicroMsg.FaceActionUI", "startTime：" + this.startTime);
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
    ae.i("MicroMsg.FaceActionUI", "finishWithResult errMsg: %s, errCode: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = "yes";; paramBoolean = "no")
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("click_other_verify_btn", paramBoolean);
      if (paramBundle != null) {
        localBundle.putAll(paramBundle);
      }
      ae.i("MicroMsg.FaceActionUI", "seriaId:%s", new Object[] { this.ryr });
      localBundle.putString("serial_id", this.ryr);
      c(paramString, paramInt, localBundle);
      finish();
      AppMethodBeat.o(104259);
      return;
    }
  }
  
  public final void g(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188652);
    ae.i("MicroMsg.FaceActionUI", "callbackDetectFailed（）");
    Bundle localBundle = new Bundle();
    localBundle.putString("token", paramString2);
    localBundle.putString("serial_id", paramString3);
    a(paramString1, paramInt, localBundle, Boolean.valueOf(this.ryl));
    AppMethodBeat.o(188652);
  }
  
  public int getLayoutId()
  {
    return 2131493903;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(104262);
    d.rxC.onBackPressed();
    finish();
    AppMethodBeat.o(104262);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104250);
    ae.d("MicroMsg.FaceActionUI", "start VerifyActivity");
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getWindow().addFlags(2097280);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.ryq = 0;
    this.startTime = bu.HQ();
    this.doQ = 4;
    if (Build.VERSION.SDK_INT >= 16) {
      getWindow().getDecorView().setSystemUiVisibility(1280);
    }
    setActionbarColor(getContext().getResources().getColor(2131101179));
    ae.d("MicroMsg.FaceActionUI", "initLayout");
    this.rye = ((ImageView)findViewById(2131297031));
    cvP();
    this.rtF = ((RelativeLayout)findViewById(2131299731));
    this.rtG = ((RelativeLayout)findViewById(2131299732));
    this.rtH = ((RelativeLayout)findViewById(2131299730));
    this.rtF.setVisibility(4);
    this.rtG.setVisibility(4);
    this.rtH.setVisibility(4);
    this.rtI = ((ImageView)findViewById(2131299673));
    this.rtJ = ((ImageView)findViewById(2131299670));
    this.rtK = ((ImageView)findViewById(2131299680));
    this.ryk = ((TextView)findViewById(2131299678));
    this.ryi = ((Button)findViewById(2131299676));
    this.ryj = ((Button)findViewById(2131299677));
    if (!bu.isNullOrNil(d.rxC.dGZ))
    {
      this.ryj.setText(d.rxC.dGZ);
      this.ryj.setOnClickListener(new FaceActionUI.6(this));
    }
    while (p.am(this))
    {
      ae.i("MicroMsg.FaceActionUI", "carson: checkFacePermissionAnd Request true and do init ");
      cvj();
      AppMethodBeat.o(104250);
      return;
      this.ryj.setVisibility(8);
    }
    ae.i("MicroMsg.FaceActionUI", "carson: no camera permission. request permission");
    AppMethodBeat.o(104250);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104256);
    super.onDestroy();
    ae.i("MicroMsg.FaceActionUI", "onDestroy");
    d.rxC.release(true);
    AppMethodBeat.o(104256);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(104254);
    ae.d("MicroMsg.FaceActionUI", "onPause");
    super.onPause();
    AppMethodBeat.o(104254);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(104264);
    ae.i("MicroMsg.FaceActionUI", "carson onRequestPermissionsResult");
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
      cvj();
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
      ae.i("MicroMsg.FaceActionUI", "carson PermissionsResult:errMsg".concat(String.valueOf(str1)));
      ae.i("MicroMsg.FaceActionUI", "carson PermissionsResult:showErrMsg".concat(String.valueOf(localObject)));
      ae.i("MicroMsg.FaceActionUI", "checkPermissionFailedAnimation");
      this.ryk.setText((CharSequence)localObject);
      this.ryi.setText(2131758760);
      this.ryi.setOnClickListener(new FaceActionUI.8(this));
      this.rya.setVisibility(8);
      this.rtH.setVisibility(0);
      this.rtJ.clearAnimation();
      this.rye.setVisibility(0);
      this.rtF.setVisibility(8);
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
    ae.d("MicroMsg.FaceActionUI", "onResume");
    cvQ();
    AppMethodBeat.o(104253);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(104252);
    ae.d("MicroMsg.FaceActionUI", "onStart");
    super.onStart();
    if (this.rym != null)
    {
      this.rym.a(this.ryd);
      this.rym.cvV();
    }
    AppMethodBeat.o(104252);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(104255);
    ae.i("MicroMsg.FaceActionUI", "onStop");
    super.onStop();
    if (this.rym != null) {
      this.rym.rtb = false;
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