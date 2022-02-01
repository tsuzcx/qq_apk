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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
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
  MMTextureView pXB;
  private ImageView pXC;
  public TextView pXD;
  public com.tencent.mm.plugin.facedetectlight.ui.b pXK;
  PreviewFrameLayout pXz;
  public ImageView pYR;
  private TextView pYS;
  ImageView pYT;
  public FaceReflectMask pYi;
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    super(paramViewGroup, parama);
  }
  
  public final void XQ(String paramString)
  {
    AppMethodBeat.i(104356);
    ad.i(this.TAG, "callbackDetectSuccess()");
    Bundle localBundle = new Bundle();
    localBundle.putString("key_bio_buffer_path", paramString);
    this.pYb.a(0, 0, "collect data ok", localBundle);
    AppMethodBeat.o(104356);
  }
  
  public final void a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104349);
    ad.d(this.TAG, "initCamera : bioID=%s ,appID=%s ,userName=%s", new Object[] { paramString1, paramString2, paramString3 });
    this.pXK = new com.tencent.mm.plugin.facedetectlight.ui.b(this.Bf.getContext(), this);
    this.pXK.pYh = this.pXD;
    this.pXK.pYi = this.pYi;
    this.pXK.pYj = this.pXz;
    this.pXK.pRV = paramArrayOfByte;
    this.pXK.pYl = paramString1;
    this.pXK.mAppId = paramString2;
    this.pXK.flk = paramString3;
    this.pXK.mJb = this.pXC;
    AppMethodBeat.o(104349);
  }
  
  public final void aR(int paramInt, String paramString)
  {
    AppMethodBeat.i(104355);
    this.pYb.a(1, paramInt, paramString, null);
    AppMethodBeat.o(104355);
  }
  
  public final void cfw()
  {
    AppMethodBeat.i(104354);
    c.a.chj();
    ad.i("MicroMsg.FaceReflectLogic", "initAuth()");
    int i = YTCommonInterface.initAuth(aj.getContext(), "rel_wechat_2055-12-06.lic1.2", 0);
    ad.i(this.TAG, "auth：".concat(String.valueOf(i)));
    if (i != 0)
    {
      ad.i(this.TAG, "initAuth failed");
      h.vKh.idkeyStat(917L, 29L, 1L, false);
      AppMethodBeat.o(104354);
      return;
    }
    ad.i(this.TAG, "initAuth success");
    h.vKh.idkeyStat(917L, 28L, 1L, false);
    c localc = c.a.chj();
    Activity localActivity = (Activity)this.Bf.getContext();
    ad.i("MicroMsg.FaceReflectLogic", "initYoutuInstance()");
    i = -1;
    if (PluginFace.isEnabled()) {
      i = YTFaceTrack.GlobalInit(q.k(p.cfZ(), false) + "/");
    }
    ad.i("MicroMsg.FaceReflectLogic", "YTFaceTrack.GlobalInit ret: %s", new Object[] { Integer.valueOf(i) });
    if (i != 0) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        YTCommonExInterface.setAppBrightness(localActivity, 255);
      }
      localc.mState = 0;
      localc.pYr = this;
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
      ad.i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.initModel return:".concat(String.valueOf(i)));
      if (i != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final int chg()
  {
    return 2131493912;
  }
  
  public final void chl()
  {
    AppMethodBeat.i(104350);
    ad.i(this.TAG, "finish ReflectUI");
    FaceReflectMask localFaceReflectMask = this.pYi;
    localFaceReflectMask.pYL = true;
    localFaceReflectMask.pXx = true;
    localFaceReflectMask.invalidate();
    this.pYi.setBackgroundColor(-16777216);
    this.pXK.stopPreview();
    setVisibility(8);
    this.pYT.setVisibility(0);
    AppMethodBeat.o(104350);
  }
  
  public final void chm()
  {
    AppMethodBeat.i(104351);
    ad.i(this.TAG, "reflectLoadAnimation()");
    final int i = this.pYi.getWidth();
    final int j = this.pYi.getHeight();
    final RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(2500L);
    localRotateAnimation.setRepeatCount(-1);
    this.pYT.setVisibility(4);
    this.pYT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104346);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)a.this.pYT.getLayoutParams();
        localMarginLayoutParams.width = ((int)(i * 0.7D));
        localMarginLayoutParams.height = ((int)(i * 0.7D));
        localMarginLayoutParams.topMargin = ((int)(j * 0.4D - i * 0.35D));
        a.this.pYT.setLayoutParams(localMarginLayoutParams);
        a.this.pYT.setVisibility(0);
        a.this.pYT.startAnimation(localRotateAnimation);
        AppMethodBeat.o(104346);
      }
    });
    this.pYR.setVisibility(4);
    AppMethodBeat.o(104351);
  }
  
  public final void chn()
  {
    AppMethodBeat.i(104352);
    this.pYS.setVisibility(0);
    AppMethodBeat.o(104352);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(104347);
    this.pXC = ((ImageView)findViewById(2131297031));
    this.pXz = ((PreviewFrameLayout)findViewById(2131299689));
    this.pXB = ((MMTextureView)findViewById(2131299688));
    this.pYi = ((FaceReflectMask)findViewById(2131299690));
    this.pYR = ((ImageView)findViewById(2131299669));
    this.pXD = ((TextView)findViewById(2131299691));
    this.pYT = ((ImageView)findViewById(2131299692));
    this.pYS = ((TextView)findViewById(2131300745));
    AppMethodBeat.o(104347);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(104353);
    ad.i(this.TAG, " FaceReflect Preview UI resume");
    if (this.pXK != null)
    {
      this.pXK.a(this.pXB);
      this.pXK.chi();
      this.pXK.pYg = true;
      this.pXD.setText(2131758753);
    }
    AppMethodBeat.o(104353);
  }
  
  public final void setBusinessTip(String paramString)
  {
    AppMethodBeat.i(104348);
    if ((TextUtils.isEmpty(paramString)) || (this.pYS == null))
    {
      AppMethodBeat.o(104348);
      return;
    }
    ad.d(this.TAG, "business tip is : ".concat(String.valueOf(paramString)));
    this.pYS.setText(paramString);
    AppMethodBeat.o(104348);
  }
  
  public final void x(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104357);
    ad.i(this.TAG, "callbackDetectFailed()");
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    this.pYb.a(4, paramInt, paramString1, localBundle);
    AppMethodBeat.o(104357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a.a
 * JD-Core Version:    0.7.0.1
 */