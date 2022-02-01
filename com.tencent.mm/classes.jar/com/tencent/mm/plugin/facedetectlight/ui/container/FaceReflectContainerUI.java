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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;

@com.tencent.mm.ui.base.a(3)
public class FaceReflectContainerUI
  extends MMActivity
  implements View.OnClickListener, f, a
{
  private String fGM;
  private String mAppId;
  private byte[] rkt;
  private String rkz;
  private String rqR;
  private com.tencent.mm.plugin.facedetectlight.ui.a.a rrt;
  private d rru;
  private e rrv;
  private TextView rrw;
  
  static
  {
    AppMethodBeat.i(104344);
    tryLoadLibrary();
    YTCommonExInterface.setBusinessCode(1);
    YTCommonExInterface.setIsEnabledLog(true);
    YTCommonExInterface.setIsEnabledNativeLog(true);
    AppMethodBeat.o(104344);
  }
  
  private void cuw()
  {
    AppMethodBeat.i(104334);
    ad.d("MicroMsg.FaceReflectContainerUI", "initLayout");
    this.rrw = ((TextView)findViewById(2131299658));
    this.rrw.setOnClickListener(this);
    this.rrt = new com.tencent.mm.plugin.facedetectlight.ui.a.a((ViewGroup)findViewById(2131299697), this);
    this.rru = new d((ViewGroup)findViewById(2131299718), this);
    this.rrv = new e((ViewGroup)findViewById(2131299731), this);
    this.rrt.setBusinessTip(this.rkz);
    AppMethodBeat.o(104334);
  }
  
  private static void tryLoadLibrary()
  {
    AppMethodBeat.i(104331);
    if (PluginFace.isEnabled())
    {
      com.tencent.mm.plugin.expansions.a.ada("YTCommon");
      com.tencent.mm.plugin.expansions.a.ada("YTFaceTrack");
      com.tencent.mm.plugin.expansions.a.ada("YTAGReflectLiveCheck");
    }
    AppMethodBeat.o(104331);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(104339);
    ad.i("MicroMsg.FaceReflectContainerUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (com.tencent.mm.plugin.facedetect.e.a.ctV().isStarted()) && (com.tencent.mm.plugin.facedetect.e.a.ctV().rmv)) {
      com.tencent.mm.plugin.facedetect.e.a.ctV().ctX();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.cth());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramBundle = new Bundle();
    paramBundle.putInt("err_type", paramInt1);
    paramBundle.putInt("err_code", paramInt2);
    paramBundle.putString("err_msg", paramString);
    paramBundle.putString("k_bio_id", this.rqR);
    paramBundle.putAll(localBundle);
    paramString = new Intent();
    paramString.putExtras(paramBundle);
    setResult(-1, paramString);
    finish();
    AppMethodBeat.o(104339);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.facedetect.ui.c paramc) {}
  
  public final void csI()
  {
    AppMethodBeat.i(104333);
    this.rrt.csI();
    AppMethodBeat.o(104333);
  }
  
  public final void csK()
  {
    AppMethodBeat.i(221174);
    c.a.cuv().release();
    AppMethodBeat.o(221174);
  }
  
  public final void csN() {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public int getLayoutId()
  {
    return 2131493911;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(104340);
    super.onBackPressed();
    c.a.cuv().onBackPressed();
    AppMethodBeat.o(104340);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(104343);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectlight/ui/container/FaceReflectContainerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    c.a.cuv().onBackPressed();
    finish();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectlight/ui/container/FaceReflectContainerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(104343);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104332);
    tryLoadLibrary();
    ad.d("MicroMsg.FaceReflectContainerUI", "start VerifyActivity");
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    ad.d("MicroMsg.FaceReflectContainerUI", "getData");
    this.mAppId = getIntent().getStringExtra("k_app_id");
    this.fGM = getIntent().getStringExtra("k_user_name");
    this.rkt = getIntent().getByteArrayExtra("k_bio_config");
    this.rqR = getIntent().getStringExtra("k_bio_id");
    this.rkz = getIntent().getStringExtra("business_tips");
    ad.i("MicroMsg.FaceReflectContainerUI", "mConfig " + this.rkt);
    ad.i("MicroMsg.FaceReflectContainerUI", "mBioID is %s", new Object[] { this.rqR });
    ad.i("MicroMsg.FaceReflectContainerUI", "mAppID is %s", new Object[] { this.mAppId });
    ad.i("MicroMsg.FaceReflectContainerUI", "mBusinessTip is %s", new Object[] { this.rkz });
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    if (paramBundle != null) {
      FaceDetectReporter.cth().a(paramBundle);
    }
    FaceDetectReporter.cth().appId = this.mAppId;
    FaceDetectReporter.cth().rhU = 6;
    if (p.al(this))
    {
      ad.i("MicroMsg.FaceReflectContainerUI", "carson: checkFacePermissionAnd Request true and do init ");
      cuw();
      csI();
      AppMethodBeat.o(104332);
      return;
    }
    ad.i("MicroMsg.FaceReflectContainerUI", "carson: no camera permission. request permission");
    AppMethodBeat.o(104332);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(213195);
    super.onDestroy();
    ad.i("MicroMsg.FaceReflectContainerUI", "onDestroy");
    c.a.cuv().release();
    AppMethodBeat.o(213195);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(104342);
    ad.i("MicroMsg.FaceReflectContainerUI", "carson onRequestPermissionsResult");
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
      cuw();
      this.rrt.csI();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104335);
    super.onResume();
    if (this.rrt != null) {
      this.rrt.resume();
    }
    AppMethodBeat.o(104335);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(104336);
    super.onStop();
    if (this.rrt != null)
    {
      com.tencent.mm.plugin.facedetectlight.ui.a.a locala = this.rrt;
      ad.i(locala.TAG, " FaceReflect Preview UI pause");
      if (locala.rqi != null) {
        locala.rqi.rkX = false;
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
    this.rrw.setTextColor(-1);
    com.tencent.mm.plugin.facedetectlight.ui.a.a locala = this.rrt;
    locala.a(this.rkt, this.rqR, this.mAppId, this.fGM);
    locala.rqO.setVisibility(0);
    locala.rrx.setVisibility(4);
    locala.rrx.post(new a.1(locala));
    locala.resume();
    locala.rqb.setVisibility(0);
    FaceDetectReporter.cth().ab(0, System.currentTimeMillis());
    AppMethodBeat.o(104338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.container.FaceReflectContainerUI
 * JD-Core Version:    0.7.0.1
 */