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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.c.f;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.ui.FaceReflectMask;
import com.tencent.mm.plugin.facedetectlight.ui.a.a.1;
import com.tencent.mm.plugin.facedetectlight.ui.c.a;
import com.tencent.mm.plugin.facedetectlight.ui.d;
import com.tencent.mm.plugin.facedetectlight.ui.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;

@com.tencent.mm.ui.base.a(3)
public class FaceReflectContainerUI
  extends MMActivity
  implements View.OnClickListener, f, a
{
  private String fIQ;
  private String mAppId;
  private String rsD;
  private byte[] rsx;
  private com.tencent.mm.plugin.facedetectlight.ui.a.a rzI;
  private d rzJ;
  private e rzK;
  private TextView rzL;
  private String rzg;
  
  static
  {
    AppMethodBeat.i(104344);
    tryLoadLibrary();
    YTCommonExInterface.setBusinessCode(1);
    YTCommonExInterface.setIsEnabledLog(true);
    YTCommonExInterface.setIsEnabledNativeLog(true);
    AppMethodBeat.o(104344);
  }
  
  private void cvX()
  {
    AppMethodBeat.i(104334);
    ae.d("MicroMsg.FaceReflectContainerUI", "initLayout");
    this.rzL = ((TextView)findViewById(2131299658));
    this.rzL.setOnClickListener(this);
    this.rzI = new com.tencent.mm.plugin.facedetectlight.ui.a.a((ViewGroup)findViewById(2131299697), this);
    this.rzJ = new d((ViewGroup)findViewById(2131299718), this);
    this.rzK = new e((ViewGroup)findViewById(2131299731), this);
    this.rzI.setBusinessTip(this.rsD);
    AppMethodBeat.o(104334);
  }
  
  private static void tryLoadLibrary()
  {
    AppMethodBeat.i(104331);
    if (PluginFace.isEnabled())
    {
      com.tencent.mm.plugin.expansions.a.adR("YTCommon");
      com.tencent.mm.plugin.expansions.a.adR("YTFaceTrack");
      com.tencent.mm.plugin.expansions.a.adR("YTAGReflectLiveCheck");
    }
    AppMethodBeat.o(104331);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(104339);
    ae.i("MicroMsg.FaceReflectContainerUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (com.tencent.mm.plugin.facedetect.e.a.cvw().isStarted()) && (com.tencent.mm.plugin.facedetect.e.a.cvw().ruA)) {
      com.tencent.mm.plugin.facedetect.e.a.cvw().cvy();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.cuI());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramBundle = new Bundle();
    paramBundle.putInt("err_type", paramInt1);
    paramBundle.putInt("err_code", paramInt2);
    paramBundle.putString("err_msg", paramString);
    paramBundle.putString("k_bio_id", this.rzg);
    paramBundle.putAll(localBundle);
    paramString = new Intent();
    paramString.putExtras(paramBundle);
    setResult(-1, paramString);
    finish();
    AppMethodBeat.o(104339);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.facedetect.ui.c paramc) {}
  
  public final void cuj()
  {
    AppMethodBeat.i(104333);
    this.rzI.cuj();
    AppMethodBeat.o(104333);
  }
  
  public final void cul()
  {
    AppMethodBeat.i(224493);
    c.a.cvW().release();
    AppMethodBeat.o(224493);
  }
  
  public final void cuo() {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public int getLayoutId()
  {
    return 2131493911;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(104340);
    super.onBackPressed();
    c.a.cvW().onBackPressed();
    AppMethodBeat.o(104340);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(104343);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectlight/ui/container/FaceReflectContainerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    c.a.cvW().onBackPressed();
    finish();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectlight/ui/container/FaceReflectContainerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(104343);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104332);
    tryLoadLibrary();
    ae.d("MicroMsg.FaceReflectContainerUI", "start VerifyActivity");
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    ae.d("MicroMsg.FaceReflectContainerUI", "getData");
    this.mAppId = getIntent().getStringExtra("k_app_id");
    this.fIQ = getIntent().getStringExtra("k_user_name");
    this.rsx = getIntent().getByteArrayExtra("k_bio_config");
    this.rzg = getIntent().getStringExtra("k_bio_id");
    this.rsD = getIntent().getStringExtra("business_tips");
    ae.i("MicroMsg.FaceReflectContainerUI", "mConfig " + this.rsx);
    ae.i("MicroMsg.FaceReflectContainerUI", "mBioID is %s", new Object[] { this.rzg });
    ae.i("MicroMsg.FaceReflectContainerUI", "mAppID is %s", new Object[] { this.mAppId });
    ae.i("MicroMsg.FaceReflectContainerUI", "mBusinessTip is %s", new Object[] { this.rsD });
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    if (paramBundle != null) {
      FaceDetectReporter.cuI().a(paramBundle);
    }
    FaceDetectReporter.cuI().appId = this.mAppId;
    FaceDetectReporter.cuI().rpY = 6;
    if (p.am(this))
    {
      ae.i("MicroMsg.FaceReflectContainerUI", "carson: checkFacePermissionAnd Request true and do init ");
      cvX();
      cuj();
      AppMethodBeat.o(104332);
      return;
    }
    ae.i("MicroMsg.FaceReflectContainerUI", "carson: no camera permission. request permission");
    AppMethodBeat.o(104332);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(188674);
    super.onDestroy();
    ae.i("MicroMsg.FaceReflectContainerUI", "onDestroy");
    c.a.cvW().release();
    AppMethodBeat.o(188674);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(104342);
    ae.i("MicroMsg.FaceReflectContainerUI", "carson onRequestPermissionsResult");
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
      cvX();
      this.rzI.cuj();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104335);
    super.onResume();
    if (this.rzI != null) {
      this.rzI.resume();
    }
    AppMethodBeat.o(104335);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(104336);
    super.onStop();
    if (this.rzI != null)
    {
      com.tencent.mm.plugin.facedetectlight.ui.a.a locala = this.rzI;
      ae.i(locala.TAG, " FaceReflect Preview UI pause");
      if (locala.rym != null) {
        locala.rym.rtb = false;
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
    this.rzL.setTextColor(-1);
    com.tencent.mm.plugin.facedetectlight.ui.a.a locala = this.rzI;
    locala.a(this.rsx, this.rzg, this.mAppId, this.fIQ);
    locala.rzd.setVisibility(0);
    locala.rzM.setVisibility(4);
    locala.rzM.post(new a.1(locala));
    locala.resume();
    locala.ryf.setVisibility(0);
    FaceDetectReporter.cuI().aa(0, System.currentTimeMillis());
    AppMethodBeat.o(104338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.container.FaceReflectContainerUI
 * JD-Core Version:    0.7.0.1
 */