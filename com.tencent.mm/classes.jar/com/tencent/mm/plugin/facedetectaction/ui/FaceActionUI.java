package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.a.a;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout;
import com.tencent.mm.plugin.facedetectlight.ui.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.a;

@a(3)
public class FaceActionUI
  extends MMActivity
{
  int cpX;
  private long endTime;
  RelativeLayout mmt;
  RelativeLayout mmu;
  RelativeLayout mmv;
  ImageView mmw;
  ImageView mmx;
  ImageView mmy;
  RelativeLayout mqU;
  private PreviewFrameLayout mqV;
  private FaceActionMask mqW;
  private MMTextureView mqX;
  ImageView mqY;
  private TextView mqZ;
  private int mqd;
  private String mqe;
  private a.a mqh;
  private TextView mra;
  private ImageView mrb;
  private Button mrc;
  private Button mrd;
  private TextView mre;
  public boolean mrf = false;
  b mrg;
  private int mrh;
  private int mri;
  private String mrj;
  private int mrk;
  private int scene;
  private long startTime;
  
  private void bvH()
  {
    AppMethodBeat.i(735);
    this.mqU = ((RelativeLayout)findViewById(2131823871));
    this.mqV = ((PreviewFrameLayout)findViewById(2131823872));
    this.mqX = ((MMTextureView)findViewById(2131823873));
    this.mqX.setVisibility(4);
    this.mqW = ((FaceActionMask)findViewById(2131823876));
    this.mrb = ((ImageView)findViewById(2131823875));
    this.mrb.post(new FaceActionUI.3(this));
    this.mqZ = ((TextView)findViewById(2131823877));
    this.mqZ.post(new FaceActionUI.4(this));
    this.mra = ((TextView)findViewById(2131823878));
    this.mra.setOnClickListener(new FaceActionUI.5(this));
    AppMethodBeat.o(735);
  }
  
  private void bvI()
  {
    AppMethodBeat.i(741);
    ab.i("MicroMsg.FaceActionUI", "preview");
    if (this.mrg != null)
    {
      this.mrg.mrE = true;
      ab.i("MicroMsg.FaceActionUI", "mCamera ！= null");
    }
    this.mqZ.setText(2131299596);
    AppMethodBeat.o(741);
  }
  
  private void bvb()
  {
    AppMethodBeat.i(729);
    this.mqh = new FaceActionUI.1(this);
    d.mqx.mqD = new FaceActionUI.2(this);
    d.mqx.cmc = this;
    d.mqx.a(this);
    AppMethodBeat.o(729);
  }
  
  private void c(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(738);
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
        AppMethodBeat.o(738);
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
    AppMethodBeat.o(738);
    return;
    setResult(1, paramBundle);
    AppMethodBeat.o(738);
    return;
    setResult(0, paramBundle);
    AppMethodBeat.o(738);
  }
  
  private Intent d(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(739);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", paramInt);
    localBundle.putString("err_msg", paramString);
    localBundle.putInt("scene", this.scene);
    localBundle.putInt("countFace", this.mrk);
    localBundle.putInt("err_type", this.cpX);
    this.endTime = bo.yB();
    ab.i("MicroMsg.FaceActionUI", "endTime：" + this.endTime);
    ab.i("MicroMsg.FaceActionUI", "startTime：" + this.startTime);
    localBundle.putLong("totalTime", this.endTime - this.startTime);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramString = new Intent();
    paramString.putExtras(localBundle);
    AppMethodBeat.o(739);
    return paramString;
  }
  
  public final void a(String paramString, int paramInt, Bundle paramBundle, Boolean paramBoolean)
  {
    AppMethodBeat.i(737);
    ab.i("MicroMsg.FaceActionUI", "finishWithResult errMsg: %s, errCode: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = "yes";; paramBoolean = "no")
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("click_other_verify_btn", paramBoolean);
      if (paramBundle != null) {
        localBundle.putAll(paramBundle);
      }
      c(paramString, paramInt, localBundle);
      new ak().postDelayed(new FaceActionUI.9(this), 1500L);
      AppMethodBeat.o(737);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2130969490;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(740);
    d.mqx.onBackPressed();
    AppMethodBeat.o(740);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(728);
    ab.d("MicroMsg.FaceActionUI", "start VerifyActivity");
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getWindow().addFlags(2097280);
    this.scene = getIntent().getIntExtra("scene", 0);
    this.mrk = 0;
    this.startTime = bo.yB();
    this.cpX = 4;
    ab.d("MicroMsg.FaceActionUI", "initLayout");
    this.mqY = ((ImageView)findViewById(2131823874));
    bvH();
    this.mmt = ((RelativeLayout)findViewById(2131823867));
    this.mmu = ((RelativeLayout)findViewById(2131823863));
    this.mmv = ((RelativeLayout)findViewById(2131823858));
    this.mmt.setVisibility(4);
    this.mmu.setVisibility(4);
    this.mmv.setVisibility(4);
    this.mmw = ((ImageView)findViewById(2131823869));
    this.mmx = ((ImageView)findViewById(2131823868));
    this.mmy = ((ImageView)findViewById(2131823865));
    this.mre = ((TextView)findViewById(2131823860));
    this.mrc = ((Button)findViewById(2131823861));
    this.mrd = ((Button)findViewById(2131823862));
    if (!bo.isNullOrNil(d.mqx.cFx))
    {
      this.mrd.setText(d.mqx.cFx);
      this.mrd.setOnClickListener(new FaceActionUI.6(this));
    }
    while (p.S(this))
    {
      ab.i("MicroMsg.FaceActionUI", "carson: checkFacePermissionAnd Request true and do init ");
      bvb();
      AppMethodBeat.o(728);
      return;
      this.mrd.setVisibility(8);
    }
    ab.i("MicroMsg.FaceActionUI", "carson: no camera permission. request permission");
    AppMethodBeat.o(728);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(734);
    super.onDestroy();
    ab.i("MicroMsg.FaceActionUI", "onDestroy");
    d.mqx.release(true);
    AppMethodBeat.o(734);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(732);
    ab.d("MicroMsg.FaceActionUI", "onPause");
    super.onPause();
    AppMethodBeat.o(732);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(742);
    ab.i("MicroMsg.FaceActionUI", "carson onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(742);
      return;
    }
    switch (paramInt)
    {
    }
    String str2;
    String str3;
    for (;;)
    {
      AppMethodBeat.o(742);
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
      bvb();
    }
    String str1;
    Object localObject;
    if (paramArrayOfString[0].equals("android.permission.CAMERA"))
    {
      str1 = "camera permission not granted";
      localObject = getString(2131302067);
    }
    for (;;)
    {
      ab.i("MicroMsg.FaceActionUI", "carson PermissionsResult:errMsg".concat(String.valueOf(str1)));
      ab.i("MicroMsg.FaceActionUI", "carson PermissionsResult:showErrMsg".concat(String.valueOf(localObject)));
      ab.i("MicroMsg.FaceActionUI", "checkPermissionFailedAnimation");
      this.mre.setText((CharSequence)localObject);
      this.mrc.setText(2131299603);
      this.mrc.setOnClickListener(new FaceActionUI.8(this));
      this.mqU.setVisibility(8);
      this.mmv.setVisibility(0);
      this.mmx.clearAnimation();
      this.mqY.setVisibility(0);
      this.mmt.setVisibility(8);
      paramInt = 0;
      break label79;
      localObject = str3;
      str1 = str2;
      if (paramArrayOfString[0].equals("android.permission.RECORD_AUDIO"))
      {
        str1 = "audio permission not granted";
        localObject = getString(2131302075);
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
            paramArrayOfString = getString(2131302067);
          }
          if (paramArrayOfInt[1] != 0)
          {
            str2 = "audio permission not granted";
            paramArrayOfString = getString(2131302075);
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
              localObject = getString(2131302067);
            }
          }
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(731);
    super.onResume();
    ab.d("MicroMsg.FaceActionUI", "onResume");
    bvI();
    AppMethodBeat.o(731);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(730);
    ab.d("MicroMsg.FaceActionUI", "onStart");
    super.onStart();
    if (this.mrg != null)
    {
      this.mrg.a(this.mqX);
      this.mrg.bvP();
    }
    AppMethodBeat.o(730);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(733);
    ab.i("MicroMsg.FaceActionUI", "onStop");
    super.onStop();
    if (this.mrg != null) {
      this.mrg.mlO = false;
    }
    AppMethodBeat.o(733);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void t(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(736);
    ab.i("MicroMsg.FaceActionUI", "callbackDetectFailed（）");
    Bundle localBundle = new Bundle();
    localBundle.putString("token", paramString2);
    a(paramString1, paramInt, localBundle, Boolean.valueOf(this.mrf));
    AppMethodBeat.o(736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI
 * JD-Core Version:    0.7.0.1
 */