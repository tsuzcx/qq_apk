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
import com.tencent.mm.plugin.facedetectlight.ui.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.a;

@a(3)
public class FaceActionUI
  extends MMActivity
{
  int deV;
  private long endTime;
  RelativeLayout pTe;
  RelativeLayout pTf;
  RelativeLayout pTg;
  ImageView pTh;
  ImageView pTi;
  ImageView pTj;
  private int pWM;
  private String pWN;
  private a.a pWQ;
  private FaceActionMask pXA;
  private MMTextureView pXB;
  ImageView pXC;
  private TextView pXD;
  private TextView pXE;
  private ImageView pXF;
  private Button pXG;
  private Button pXH;
  private TextView pXI;
  public boolean pXJ = false;
  b pXK;
  private int pXL;
  private int pXM;
  private String pXN;
  private int pXO;
  RelativeLayout pXy;
  private PreviewFrameLayout pXz;
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
  
  private void cgw()
  {
    AppMethodBeat.i(104251);
    this.pWQ = new a.a() {};
    d.pXb.pXh = new d.a()
    {
      public final void XP(final String paramAnonymousString)
      {
        AppMethodBeat.i(104240);
        ad.i("MicroMsg.FaceActionUI", "onVerifyFinish:   authToken ：%s", new Object[] { paramAnonymousString });
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104234);
            FaceActionUI.e(FaceActionUI.this).clearAnimation();
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            localFaceActionUI.pXy.setVisibility(8);
            localFaceActionUI.pTi.clearAnimation();
            localFaceActionUI.pTe.setVisibility(8);
            localFaceActionUI.pXC.setVisibility(0);
            localFaceActionUI.pTf.setVisibility(0);
            localFaceActionUI.pTj.setScaleX(0.0F);
            localFaceActionUI.pTj.setScaleY(0.0F);
            localFaceActionUI.pTj.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
            localFaceActionUI = FaceActionUI.this;
            String str = paramAnonymousString;
            ad.i("MicroMsg.FaceActionUI", "callbackDetectSuccess（）");
            Bundle localBundle = new Bundle();
            localBundle.putString("token", str);
            localFaceActionUI.deV = 0;
            localFaceActionUI.a("ok", 0, localBundle, Boolean.valueOf(localFaceActionUI.pXJ));
            AppMethodBeat.o(104234);
          }
        });
        AppMethodBeat.o(104240);
      }
      
      public final void aQ(final int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(104238);
        ad.i("MicroMsg.FaceActionUI", "onInitFaceCheckFinish: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        aq.f(new Runnable()
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
      
      public final void b(int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final int paramAnonymousInt3)
      {
        AppMethodBeat.i(104241);
        ad.i("MicroMsg.FaceActionUI", "onError, err: %s, cgiErrCode: %s, cgiErrMsg: %s,retry: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousInt3) });
        FaceActionUI.b(FaceActionUI.this, paramAnonymousInt1);
        FaceActionUI.c(FaceActionUI.this, paramAnonymousInt2);
        FaceActionUI.b(FaceActionUI.this, paramAnonymousString);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104237);
            if (!bt.isNullOrNil(paramAnonymousString))
            {
              FaceActionUI.f(FaceActionUI.this).setText(paramAnonymousString);
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
                  ad.i("MicroMsg.FaceActionUI", "click retry");
                  FaceActionUI.i(FaceActionUI.this);
                  AppMethodBeat.o(104235);
                }
              });
            }
            for (;;)
            {
              FaceActionUI.e(FaceActionUI.this).clearAnimation();
              FaceActionUI localFaceActionUI = FaceActionUI.this;
              localFaceActionUI.pXy.setVisibility(8);
              localFaceActionUI.pTg.setVisibility(0);
              localFaceActionUI.pTi.clearAnimation();
              localFaceActionUI.pXC.setVisibility(0);
              localFaceActionUI.pTe.setVisibility(8);
              d.pXb.mStatus = 3;
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
                  ad.i("MicroMsg.FaceActionUI", "click finish");
                  FaceActionUI.this.y("fail", FaceActionUI.2.4.this.pXW, "");
                  AppMethodBeat.o(104236);
                }
              });
            }
          }
        });
        AppMethodBeat.o(104241);
      }
      
      public final void chb()
      {
        AppMethodBeat.i(104239);
        ad.i("MicroMsg.FaceActionUI", "onStartUpload");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104233);
            FaceActionUI localFaceActionUI = FaceActionUI.this;
            if (localFaceActionUI.pXK != null) {
              localFaceActionUI.pXK.stopPreview();
            }
            localFaceActionUI.pXy.setVisibility(8);
            localFaceActionUI.pTe.setVisibility(0);
            TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, localFaceActionUI.pTh.getHeight());
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
            localFaceActionUI.pTi.startAnimation(localAnimationSet);
            AppMethodBeat.o(104233);
          }
        });
        AppMethodBeat.o(104239);
      }
    };
    d.pXb.imP = this;
    d.pXb.a(this);
    AppMethodBeat.o(104251);
  }
  
  private void chc()
  {
    AppMethodBeat.i(104257);
    this.pXy = ((RelativeLayout)findViewById(2131299697));
    this.pXz = ((PreviewFrameLayout)findViewById(2131299689));
    this.pXB = ((MMTextureView)findViewById(2131299688));
    this.pXB.setVisibility(4);
    this.pXA = ((FaceActionMask)findViewById(2131299690));
    this.pXF = ((ImageView)findViewById(2131299657));
    this.pXF.post(new FaceActionUI.3(this));
    this.pXD = ((TextView)findViewById(2131299691));
    this.pXD.post(new FaceActionUI.4(this));
    this.pXE = ((TextView)findViewById(2131299656));
    this.pXE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(104244);
        d.pXb.onBackPressed();
        FaceActionUI.this.finish();
        AppMethodBeat.o(104244);
      }
    });
    AppMethodBeat.o(104257);
  }
  
  private void chd()
  {
    AppMethodBeat.i(104263);
    ad.i("MicroMsg.FaceActionUI", "preview");
    if (this.pXK != null)
    {
      this.pXK.pYg = true;
      ad.i("MicroMsg.FaceActionUI", "mCamera ！= null");
    }
    this.pXD.setText(2131758753);
    AppMethodBeat.o(104263);
  }
  
  private Intent d(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(104261);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramInt);
    localBundle.putString("err_msg", paramString);
    localBundle.putInt("scene", this.scene);
    localBundle.putInt("countFace", this.pXO);
    localBundle.putInt("err_type", this.deV);
    this.endTime = bt.GC();
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
      c(paramString, paramInt, localBundle);
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104249);
          FaceActionUI.this.finish();
          AppMethodBeat.o(104249);
        }
      }, 1500L);
      AppMethodBeat.o(104259);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493903;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(104262);
    d.pXb.onBackPressed();
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
    this.pXO = 0;
    this.startTime = bt.GC();
    this.deV = 4;
    if (Build.VERSION.SDK_INT >= 16) {
      getWindow().getDecorView().setSystemUiVisibility(1280);
    }
    setActionbarColor(getContext().getResources().getColor(2131101179));
    ad.d("MicroMsg.FaceActionUI", "initLayout");
    this.pXC = ((ImageView)findViewById(2131297031));
    chc();
    this.pTe = ((RelativeLayout)findViewById(2131299731));
    this.pTf = ((RelativeLayout)findViewById(2131299732));
    this.pTg = ((RelativeLayout)findViewById(2131299730));
    this.pTe.setVisibility(4);
    this.pTf.setVisibility(4);
    this.pTg.setVisibility(4);
    this.pTh = ((ImageView)findViewById(2131299673));
    this.pTi = ((ImageView)findViewById(2131299670));
    this.pTj = ((ImageView)findViewById(2131299680));
    this.pXI = ((TextView)findViewById(2131299678));
    this.pXG = ((Button)findViewById(2131299676));
    this.pXH = ((Button)findViewById(2131299677));
    if (!bt.isNullOrNil(d.pXb.dwh))
    {
      this.pXH.setText(d.pXb.dwh);
      this.pXH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104245);
          ad.i("MicroMsg.FaceActionUI", "click mUploadFailedConfig");
          FaceActionUI.m(FaceActionUI.this);
          FaceActionUI.this.y("fail", FaceActionUI.n(FaceActionUI.this), "");
          AppMethodBeat.o(104245);
        }
      });
    }
    while (p.ah(this))
    {
      ad.i("MicroMsg.FaceActionUI", "carson: checkFacePermissionAnd Request true and do init ");
      cgw();
      AppMethodBeat.o(104250);
      return;
      this.pXH.setVisibility(8);
    }
    ad.i("MicroMsg.FaceActionUI", "carson: no camera permission. request permission");
    AppMethodBeat.o(104250);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104256);
    super.onDestroy();
    ad.i("MicroMsg.FaceActionUI", "onDestroy");
    d.pXb.release(true);
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
        break label273;
      }
      if (paramArrayOfInt[0] != 0) {
        break;
      }
      paramInt = 1;
      label79:
      if (paramInt == 0) {
        break label302;
      }
      cgw();
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
      this.pXI.setText((CharSequence)localObject);
      this.pXG.setText(2131758760);
      this.pXG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(104248);
          ad.i("MicroMsg.FaceActionUI", "click finish");
          FaceActionUI.this.y("fail", 90010, "");
          AppMethodBeat.o(104248);
        }
      });
      this.pXy.setVisibility(8);
      this.pTg.setVisibility(0);
      this.pTi.clearAnimation();
      this.pXC.setVisibility(0);
      this.pTe.setVisibility(8);
      paramInt = 0;
      break label79;
      localObject = str3;
      str1 = str2;
      if (paramArrayOfString[0].equals("android.permission.RECORD_AUDIO"))
      {
        str1 = "audio permission not granted";
        localObject = getString(2131761871);
        continue;
        label273:
        localObject = str3;
        str1 = str2;
        if (paramArrayOfInt.length == 2)
        {
          if ((paramArrayOfInt[0] == 0) && (paramArrayOfInt[1] == 0))
          {
            paramInt = 1;
            break label79;
            label302:
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
    chd();
    AppMethodBeat.o(104253);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(104252);
    ad.d("MicroMsg.FaceActionUI", "onStart");
    super.onStart();
    if (this.pXK != null)
    {
      this.pXK.a(this.pXB);
      this.pXK.chi();
    }
    AppMethodBeat.o(104252);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(104255);
    ad.i("MicroMsg.FaceActionUI", "onStop");
    super.onStop();
    if (this.pXK != null) {
      this.pXK.pSz = false;
    }
    AppMethodBeat.o(104255);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void y(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(104258);
    ad.i("MicroMsg.FaceActionUI", "callbackDetectFailed（）");
    Bundle localBundle = new Bundle();
    localBundle.putString("token", paramString2);
    a(paramString1, paramInt, localBundle, Boolean.valueOf(this.pXJ));
    AppMethodBeat.o(104258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI
 * JD-Core Version:    0.7.0.1
 */