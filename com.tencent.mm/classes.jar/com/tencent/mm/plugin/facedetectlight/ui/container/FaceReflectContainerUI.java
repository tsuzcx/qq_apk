package com.tencent.mm.plugin.facedetectlight.ui.container;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.c.f;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.ui.FaceReflectMask;
import com.tencent.mm.plugin.facedetectlight.ui.a.a.1;
import com.tencent.mm.plugin.facedetectlight.ui.c.a;
import com.tencent.mm.plugin.facedetectlight.ui.d;
import com.tencent.mm.plugin.facedetectlight.ui.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;

@com.tencent.mm.ui.base.a(3)
public class FaceReflectContainerUI
  extends MMActivity
  implements View.OnClickListener, f, a
{
  private String foE;
  private String mAppId;
  private byte[] qAD;
  private String qAJ;
  private String qGS;
  private com.tencent.mm.plugin.facedetectlight.ui.a.a qHu;
  private d qHv;
  private e qHw;
  private TextView qHx;
  
  static
  {
    AppMethodBeat.i(104344);
    tryLoadLibrary();
    YTCommonExInterface.setBusinessCode(1);
    YTCommonExInterface.setIsEnabledLog(true);
    YTCommonExInterface.setIsEnabledNativeLog(true);
    AppMethodBeat.o(104344);
  }
  
  private void coR()
  {
    AppMethodBeat.i(104334);
    ac.d("MicroMsg.FaceReflectContainerUI", "initLayout");
    this.qHx = ((TextView)findViewById(2131299658));
    this.qHx.setOnClickListener(this);
    this.qHu = new com.tencent.mm.plugin.facedetectlight.ui.a.a((ViewGroup)findViewById(2131299697), this);
    this.qHv = new d((ViewGroup)findViewById(2131299718), this);
    this.qHw = new e((ViewGroup)findViewById(2131299731), this);
    this.qHu.setBusinessTip(this.qAJ);
    AppMethodBeat.o(104334);
  }
  
  private static void tryLoadLibrary()
  {
    AppMethodBeat.i(104331);
    if (PluginFace.isEnabled())
    {
      com.tencent.mm.plugin.expansions.a.Zu("YTCommon");
      com.tencent.mm.plugin.expansions.a.Zu("YTFaceTrack");
      com.tencent.mm.plugin.expansions.a.Zu("YTAGReflectLiveCheck");
    }
    AppMethodBeat.o(104331);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(104339);
    ac.i("MicroMsg.FaceReflectContainerUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (com.tencent.mm.plugin.facedetect.e.a.coq().isStarted()) && (com.tencent.mm.plugin.facedetect.e.a.coq().qCF)) {
      com.tencent.mm.plugin.facedetect.e.a.coq().cos();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.cnC());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramBundle = new Bundle();
    paramBundle.putInt("err_type", paramInt1);
    paramBundle.putInt("err_code", paramInt2);
    paramBundle.putString("err_msg", paramString);
    paramBundle.putString("k_bio_id", this.qGS);
    paramBundle.putAll(localBundle);
    paramString = new Intent();
    paramString.putExtras(paramBundle);
    setResult(-1, paramString);
    finish();
    AppMethodBeat.o(104339);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.facedetect.ui.c paramc) {}
  
  public final void cnd()
  {
    AppMethodBeat.i(104333);
    this.qHu.cnd();
    AppMethodBeat.o(104333);
  }
  
  public final void cnf()
  {
    AppMethodBeat.i(210516);
    c.a.coQ().release();
    AppMethodBeat.o(210516);
  }
  
  public final void cni() {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public int getLayoutId()
  {
    return 2131493911;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(104340);
    super.onBackPressed();
    c.a.coQ().onBackPressed();
    AppMethodBeat.o(104340);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(104343);
    c.a.coQ().onBackPressed();
    finish();
    AppMethodBeat.o(104343);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104332);
    tryLoadLibrary();
    ac.d("MicroMsg.FaceReflectContainerUI", "start VerifyActivity");
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    ac.d("MicroMsg.FaceReflectContainerUI", "getData");
    this.mAppId = getIntent().getStringExtra("k_app_id");
    this.foE = getIntent().getStringExtra("k_user_name");
    this.qAD = getIntent().getByteArrayExtra("k_bio_config");
    this.qGS = getIntent().getStringExtra("k_bio_id");
    this.qAJ = getIntent().getStringExtra("business_tips");
    ac.i("MicroMsg.FaceReflectContainerUI", "mConfig " + this.qAD);
    ac.i("MicroMsg.FaceReflectContainerUI", "mBioID is %s", new Object[] { this.qGS });
    ac.i("MicroMsg.FaceReflectContainerUI", "mAppID is %s", new Object[] { this.mAppId });
    ac.i("MicroMsg.FaceReflectContainerUI", "mBusinessTip is %s", new Object[] { this.qAJ });
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    if (paramBundle != null) {
      FaceDetectReporter.cnC().a(paramBundle);
    }
    FaceDetectReporter.cnC().appId = this.mAppId;
    FaceDetectReporter.cnC().qye = 6;
    if (p.al(this))
    {
      ac.i("MicroMsg.FaceReflectContainerUI", "carson: checkFacePermissionAnd Request true and do init ");
      coR();
      cnd();
      AppMethodBeat.o(104332);
      return;
    }
    ac.i("MicroMsg.FaceReflectContainerUI", "carson: no camera permission. request permission");
    AppMethodBeat.o(104332);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(207495);
    super.onDestroy();
    ac.i("MicroMsg.FaceReflectContainerUI", "onDestroy");
    c.a.coQ().release();
    AppMethodBeat.o(207495);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(104342);
    ac.i("MicroMsg.FaceReflectContainerUI", "carson onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(104342);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(104342);
      return;
      coR();
      this.qHu.cnd();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104335);
    super.onResume();
    if (this.qHu != null) {
      this.qHu.resume();
    }
    AppMethodBeat.o(104335);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(104336);
    super.onStop();
    if (this.qHu != null)
    {
      com.tencent.mm.plugin.facedetectlight.ui.a.a locala = this.qHu;
      ac.i(locala.TAG, " FaceReflect Preview UI pause");
      if (locala.qGp != null) {
        locala.qGp.qBh = false;
      }
    }
    AppMethodBeat.o(104336);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(104338);
    this.qHx.setTextColor(-1);
    com.tencent.mm.plugin.facedetectlight.ui.a.a locala = this.qHu;
    locala.a(this.qAD, this.qGS, this.mAppId, this.foE);
    locala.qGP.setVisibility(0);
    locala.qHy.setVisibility(4);
    locala.qHy.post(new a.1(locala));
    locala.resume();
    locala.qGi.setVisibility(0);
    FaceDetectReporter.cnC().Y(0, System.currentTimeMillis());
    AppMethodBeat.o(104338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.container.FaceReflectContainerUI
 * JD-Core Version:    0.7.0.1
 */