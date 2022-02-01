package com.tencent.mm.plugin.facedetectlight.ui.a;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.ui.FaceReflectMask;
import com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout;
import com.tencent.mm.plugin.facedetectlight.ui.c;
import com.tencent.mm.plugin.facedetectlight.ui.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import com.tencent.ytcommon.util.YTCommonInterface;

public final class a
  extends com.tencent.mm.plugin.facedetectlight.ui.a
  implements b
{
  public FaceReflectMask qGP;
  PreviewFrameLayout qGe;
  MMTextureView qGg;
  private ImageView qGh;
  public TextView qGi;
  public com.tencent.mm.plugin.facedetectlight.ui.b qGp;
  ImageView qHA;
  public ImageView qHy;
  private TextView qHz;
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    super(paramViewGroup, parama);
  }
  
  public final void a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104349);
    ac.d(this.TAG, "initCamera : bioID=%s ,appID=%s ,userName=%s", new Object[] { paramString1, paramString2, paramString3 });
    this.qGp = new com.tencent.mm.plugin.facedetectlight.ui.b(this.Cd.getContext(), this);
    this.qGp.qGO = this.qGi;
    this.qGp.qGP = this.qGP;
    this.qGp.qGQ = this.qGe;
    this.qGp.qAD = paramArrayOfByte;
    this.qGp.qGS = paramString1;
    this.qGp.mAppId = paramString2;
    this.qGp.foE = paramString3;
    this.qGp.nle = this.qGh;
    AppMethodBeat.o(104349);
  }
  
  public final void aU(int paramInt, String paramString)
  {
    AppMethodBeat.i(104355);
    this.qGI.a(1, paramInt, paramString, null);
    AppMethodBeat.o(104355);
  }
  
  public final void acm(String paramString)
  {
    AppMethodBeat.i(104356);
    ac.i(this.TAG, "callbackDetectSuccess()");
    Bundle localBundle = new Bundle();
    localBundle.putString("key_bio_buffer_path", paramString);
    this.qGI.a(0, 0, "collect data ok", localBundle);
    AppMethodBeat.o(104356);
  }
  
  public final void cnd()
  {
    AppMethodBeat.i(104354);
    c.a.coQ();
    ac.i("MicroMsg.FaceReflectLogic", "initAuth()");
    int i = YTCommonInterface.initAuth(ai.getContext(), "rel_wechat_2055-12-06.lic1.2", 0);
    ac.i(this.TAG, "auth：".concat(String.valueOf(i)));
    if (i != 0)
    {
      ac.i(this.TAG, "initAuth failed");
      h.wUl.idkeyStat(917L, 29L, 1L, false);
      AppMethodBeat.o(104354);
      return;
    }
    ac.i(this.TAG, "initAuth success");
    h.wUl.idkeyStat(917L, 28L, 1L, false);
    c localc = c.a.coQ();
    Activity localActivity = (Activity)this.Cd.getContext();
    ac.i("MicroMsg.FaceReflectLogic", "initYoutuInstance()");
    i = -1;
    if (PluginFace.isEnabled()) {
      i = YTFaceTrack.GlobalInit(q.k(p.cnG(), false) + "/");
    }
    ac.i("MicroMsg.FaceReflectLogic", "YTFaceTrack.GlobalInit ret: %s", new Object[] { Integer.valueOf(i) });
    if (i != 0) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        YTCommonExInterface.setAppBrightness(localActivity, 255);
      }
      localc.mState = 0;
      localc.qGY = this;
      AppMethodBeat.o(104354);
      return;
      Object localObject = YTFaceTrack.getInstance().GetFaceDetectParam();
      ((YTFaceDetectParam)localObject).bigger_face_mode = true;
      ((YTFaceDetectParam)localObject).min_face_size = 50;
      YTFaceTrack.getInstance().SetFaceDetectParam((YTFaceDetectParam)localObject);
      localObject = YTFaceTrack.getInstance().GetFaceTrackParam();
      ((YTFaceTrackParam)localObject).need_pose_estimate = true;
      ((YTFaceTrackParam)localObject).detect_interval = 20;
      YTFaceTrack.getInstance().SetFaceTrackParam((YTFaceTrackParam)localObject);
      i = YTAGReflectLiveCheckInterface.initModel(localc.mAppId);
      ac.i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.initModel return:".concat(String.valueOf(i)));
      if (i != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final int coN()
  {
    return 2131493912;
  }
  
  public final void coS()
  {
    AppMethodBeat.i(104350);
    ac.i(this.TAG, "finish ReflectUI");
    FaceReflectMask localFaceReflectMask = this.qGP;
    localFaceReflectMask.qHs = true;
    localFaceReflectMask.qGc = true;
    localFaceReflectMask.invalidate();
    this.qGP.setBackgroundColor(-16777216);
    this.qGp.stopPreview();
    setVisibility(8);
    this.qHA.setVisibility(0);
    AppMethodBeat.o(104350);
  }
  
  public final void coT()
  {
    AppMethodBeat.i(104351);
    ac.i(this.TAG, "reflectLoadAnimation()");
    final int i = this.qGP.getWidth();
    final int j = this.qGP.getHeight();
    final RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(2500L);
    localRotateAnimation.setRepeatCount(-1);
    this.qHA.setVisibility(4);
    this.qHA.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104346);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)a.this.qHA.getLayoutParams();
        localMarginLayoutParams.width = ((int)(i * 0.7D));
        localMarginLayoutParams.height = ((int)(i * 0.7D));
        localMarginLayoutParams.topMargin = ((int)(j * 0.4D - i * 0.35D));
        a.this.qHA.setLayoutParams(localMarginLayoutParams);
        a.this.qHA.setVisibility(0);
        a.this.qHA.startAnimation(localRotateAnimation);
        AppMethodBeat.o(104346);
      }
    });
    this.qHy.setVisibility(4);
    AppMethodBeat.o(104351);
  }
  
  public final void coU()
  {
    AppMethodBeat.i(104352);
    this.qHz.setVisibility(0);
    AppMethodBeat.o(104352);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(104347);
    this.qGh = ((ImageView)findViewById(2131297031));
    this.qGe = ((PreviewFrameLayout)findViewById(2131299689));
    this.qGg = ((MMTextureView)findViewById(2131299688));
    this.qGP = ((FaceReflectMask)findViewById(2131299690));
    this.qHy = ((ImageView)findViewById(2131299669));
    this.qGi = ((TextView)findViewById(2131299691));
    this.qHA = ((ImageView)findViewById(2131299692));
    this.qHz = ((TextView)findViewById(2131300745));
    AppMethodBeat.o(104347);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(104353);
    ac.i(this.TAG, " FaceReflect Preview UI resume");
    if (this.qGp != null)
    {
      this.qGp.a(this.qGg);
      this.qGp.coP();
      this.qGp.qGN = true;
      this.qGi.setText(2131758753);
    }
    AppMethodBeat.o(104353);
  }
  
  public final void setBusinessTip(String paramString)
  {
    AppMethodBeat.i(104348);
    if ((TextUtils.isEmpty(paramString)) || (this.qHz == null))
    {
      AppMethodBeat.o(104348);
      return;
    }
    ac.d(this.TAG, "business tip is : ".concat(String.valueOf(paramString)));
    this.qHz.setText(paramString);
    AppMethodBeat.o(104348);
  }
  
  public final void x(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104357);
    ac.i(this.TAG, "callbackDetectFailed()");
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    this.qGI.a(4, paramInt, paramString1, localBundle);
    AppMethodBeat.o(104357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a.a
 * JD-Core Version:    0.7.0.1
 */