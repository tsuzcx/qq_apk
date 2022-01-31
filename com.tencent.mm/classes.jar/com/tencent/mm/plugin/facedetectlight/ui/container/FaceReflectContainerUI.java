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
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.facedetect.c.f;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.ui.FaceReflectMask;
import com.tencent.mm.plugin.facedetectlight.ui.a.a.1;
import com.tencent.mm.plugin.facedetectlight.ui.c.a;
import com.tencent.mm.plugin.facedetectlight.ui.d;
import com.tencent.mm.plugin.facedetectlight.ui.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;

@com.tencent.mm.ui.base.a(3)
public class FaceReflectContainerUI
  extends MMActivity
  implements View.OnClickListener, f, a
{
  private String eaX;
  private String mAppId;
  private byte[] mlk;
  private String mlq;
  private String mrJ;
  private com.tencent.mm.plugin.facedetectlight.ui.a.a msh;
  private d msi;
  private e msj;
  private TextView msk;
  
  static
  {
    AppMethodBeat.i(822);
    k.a("YTCommonEx", FaceReflectContainerUI.class.getClassLoader());
    k.a("YTFaceTrace", FaceReflectContainerUI.class.getClassLoader());
    k.a("YTNextCV", FaceReflectContainerUI.class.getClassLoader());
    k.a("YTAGReflectLiveCheck", FaceReflectContainerUI.class.getClassLoader());
    YTCommonExInterface.setBusinessCode(1);
    AppMethodBeat.o(822);
  }
  
  private void bvR()
  {
    AppMethodBeat.i(812);
    ab.d("MicroMsg.FaceReflectContainerUI", "initLayout");
    this.msk = ((TextView)findViewById(2131823897));
    this.msk.setOnClickListener(this);
    this.msh = new com.tencent.mm.plugin.facedetectlight.ui.a.a((ViewGroup)findViewById(2131823871), this);
    this.msi = new d((ViewGroup)findViewById(2131823896), this);
    this.msj = new e((ViewGroup)findViewById(2131823867), this);
    this.msh.setBusinessTip(this.mlq);
    AppMethodBeat.o(812);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(817);
    ab.i("MicroMsg.FaceReflectContainerUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (com.tencent.mm.plugin.facedetect.e.a.bvo().isStarted()) && (com.tencent.mm.plugin.facedetect.e.a.bvo().mnp)) {
      com.tencent.mm.plugin.facedetect.e.a.bvo().bvq();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.buB());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramBundle = new Bundle();
    paramBundle.putInt("err_type", paramInt1);
    paramBundle.putInt("err_code", paramInt2);
    paramBundle.putString("err_msg", paramString);
    paramBundle.putString("k_bio_id", this.mrJ);
    paramBundle.putAll(localBundle);
    paramString = new Intent();
    paramString.putExtras(paramBundle);
    setResult(-1, paramString);
    finish();
    AppMethodBeat.o(817);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.facedetect.ui.c paramc) {}
  
  public final void buc()
  {
    AppMethodBeat.i(811);
    this.msh.buc();
    AppMethodBeat.o(811);
  }
  
  public final void bue()
  {
    AppMethodBeat.i(156794);
    c.a.bvQ().release();
    AppMethodBeat.o(156794);
  }
  
  public final void buh() {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public int getLayoutId()
  {
    return 2130969498;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(818);
    super.onBackPressed();
    c.a.bvQ().onBackPressed();
    AppMethodBeat.o(818);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(821);
    c.a.bvQ().onBackPressed();
    finish();
    AppMethodBeat.o(821);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(810);
    ab.d("MicroMsg.FaceReflectContainerUI", "start VerifyActivity");
    super.onCreate(paramBundle);
    YTCommonExInterface.setIsEnabledLog(true);
    YTCommonExInterface.setIsEnabledNativeLog(true);
    getWindow().addFlags(2097280);
    ab.d("MicroMsg.FaceReflectContainerUI", "getData");
    this.mAppId = getIntent().getStringExtra("k_app_id");
    this.eaX = getIntent().getStringExtra("k_user_name");
    this.mlk = getIntent().getByteArrayExtra("k_bio_config");
    this.mrJ = getIntent().getStringExtra("k_bio_id");
    this.mlq = getIntent().getStringExtra("business_tips");
    ab.i("MicroMsg.FaceReflectContainerUI", "mConfig " + this.mlk);
    ab.i("MicroMsg.FaceReflectContainerUI", "mBioID is %s", new Object[] { this.mrJ });
    ab.i("MicroMsg.FaceReflectContainerUI", "mAppID is %s", new Object[] { this.mAppId });
    ab.i("MicroMsg.FaceReflectContainerUI", "mBusinessTip is %s", new Object[] { this.mlq });
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    if (paramBundle != null) {
      FaceDetectReporter.buB().a(paramBundle);
    }
    FaceDetectReporter.buB().appId = this.mAppId;
    FaceDetectReporter.buB().miJ = 6;
    if (p.S(this))
    {
      ab.i("MicroMsg.FaceReflectContainerUI", "carson: checkFacePermissionAnd Request true and do init ");
      bvR();
      buc();
      AppMethodBeat.o(810);
      return;
    }
    ab.i("MicroMsg.FaceReflectContainerUI", "carson: no camera permission. request permission");
    AppMethodBeat.o(810);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(815);
    super.onDestroy();
    ab.i("MicroMsg.FaceReflectContainerUI", "onDestroy");
    c.a.bvQ().release();
    AppMethodBeat.o(815);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(820);
    ab.i("MicroMsg.FaceReflectContainerUI", "carson onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(820);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(820);
      return;
      bvR();
      this.msh.buc();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(813);
    super.onResume();
    if (this.msh != null) {
      this.msh.resume();
    }
    AppMethodBeat.o(813);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(814);
    super.onStop();
    if (this.msh != null)
    {
      com.tencent.mm.plugin.facedetectlight.ui.a.a locala = this.msh;
      ab.i(locala.TAG, " FaceReflect Preview UI pause");
      if (locala.mrg != null) {
        locala.mrg.mlO = false;
      }
    }
    AppMethodBeat.o(814);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(816);
    this.msk.setTextColor(-1);
    com.tencent.mm.plugin.facedetectlight.ui.a.a locala = this.msh;
    locala.a(this.mlk, this.mrJ, this.mAppId, this.eaX);
    locala.mrG.setVisibility(0);
    locala.msl.setVisibility(4);
    locala.msl.post(new a.1(locala));
    locala.resume();
    locala.mqZ.setVisibility(0);
    FaceDetectReporter.buB().M(0, System.currentTimeMillis());
    AppMethodBeat.o(816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.container.FaceReflectContainerUI
 * JD-Core Version:    0.7.0.1
 */