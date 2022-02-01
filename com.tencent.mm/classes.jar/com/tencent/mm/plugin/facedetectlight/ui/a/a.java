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
import com.tencent.mm.plugin.report.service.g;
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
  PreviewFrameLayout rpX;
  MMTextureView rpZ;
  public FaceReflectMask rqO;
  private ImageView rqa;
  public TextView rqb;
  public com.tencent.mm.plugin.facedetectlight.ui.b rqi;
  public ImageView rrx;
  private TextView rry;
  ImageView rrz;
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    super(paramViewGroup, parama);
  }
  
  public final void a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104349);
    ad.d(this.TAG, "initCamera : bioID=%s ,appID=%s ,userName=%s", new Object[] { paramString1, paramString2, paramString3 });
    this.rqi = new com.tencent.mm.plugin.facedetectlight.ui.b(this.DV.getContext(), this);
    this.rqi.rqN = this.rqb;
    this.rqi.rqO = this.rqO;
    this.rqi.rqP = this.rpX;
    this.rqi.rkt = paramArrayOfByte;
    this.rqi.rqR = paramString1;
    this.rqi.mAppId = paramString2;
    this.rqi.fGM = paramString3;
    this.rqi.nLL = this.rqa;
    AppMethodBeat.o(104349);
  }
  
  public final void aX(int paramInt, String paramString)
  {
    AppMethodBeat.i(104355);
    this.rqH.a(1, paramInt, paramString, null);
    AppMethodBeat.o(104355);
  }
  
  public final void agb(String paramString)
  {
    AppMethodBeat.i(104356);
    ad.i(this.TAG, "callbackDetectSuccess()");
    Bundle localBundle = new Bundle();
    localBundle.putString("key_bio_buffer_path", paramString);
    this.rqH.a(0, 0, "collect data ok", localBundle);
    AppMethodBeat.o(104356);
  }
  
  public final void csI()
  {
    AppMethodBeat.i(104354);
    c.a.cuv();
    ad.i("MicroMsg.FaceReflectLogic", "initAuth()");
    int i = YTCommonInterface.initAuth(aj.getContext(), "rel_wechat_2055-12-06.lic1.2", 0);
    ad.i(this.TAG, "auth：".concat(String.valueOf(i)));
    if (i != 0)
    {
      ad.i(this.TAG, "initAuth failed");
      g.yhR.idkeyStat(917L, 29L, 1L, false);
      AppMethodBeat.o(104354);
      return;
    }
    ad.i(this.TAG, "initAuth success");
    g.yhR.idkeyStat(917L, 28L, 1L, false);
    c localc = c.a.cuv();
    Activity localActivity = (Activity)this.DV.getContext();
    ad.i("MicroMsg.FaceReflectLogic", "initYoutuInstance()");
    i = -1;
    if (PluginFace.isEnabled()) {
      i = YTFaceTrack.GlobalInit(q.k(p.ctl(), false) + "/");
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
      localc.rqX = this;
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
  
  public final int cus()
  {
    return 2131493912;
  }
  
  public final void cux()
  {
    AppMethodBeat.i(104350);
    ad.i(this.TAG, "finish ReflectUI");
    FaceReflectMask localFaceReflectMask = this.rqO;
    localFaceReflectMask.rrr = true;
    localFaceReflectMask.rpV = true;
    localFaceReflectMask.invalidate();
    this.rqO.setBackgroundColor(-16777216);
    this.rqi.stopPreview();
    setVisibility(8);
    this.rrz.setVisibility(0);
    AppMethodBeat.o(104350);
  }
  
  public final void cuy()
  {
    AppMethodBeat.i(104351);
    ad.i(this.TAG, "reflectLoadAnimation()");
    final int i = this.rqO.getWidth();
    final int j = this.rqO.getHeight();
    final RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(2500L);
    localRotateAnimation.setRepeatCount(-1);
    this.rrz.setVisibility(4);
    this.rrz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104346);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)a.this.rrz.getLayoutParams();
        localMarginLayoutParams.width = ((int)(i * 0.7D));
        localMarginLayoutParams.height = ((int)(i * 0.7D));
        localMarginLayoutParams.topMargin = ((int)(j * 0.4D - i * 0.35D));
        a.this.rrz.setLayoutParams(localMarginLayoutParams);
        a.this.rrz.setVisibility(0);
        a.this.rrz.startAnimation(localRotateAnimation);
        AppMethodBeat.o(104346);
      }
    });
    this.rrx.setVisibility(4);
    AppMethodBeat.o(104351);
  }
  
  public final void cuz()
  {
    AppMethodBeat.i(104352);
    this.rry.setVisibility(0);
    AppMethodBeat.o(104352);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(104347);
    this.rqa = ((ImageView)findViewById(2131297031));
    this.rpX = ((PreviewFrameLayout)findViewById(2131299689));
    this.rpZ = ((MMTextureView)findViewById(2131299688));
    this.rqO = ((FaceReflectMask)findViewById(2131299690));
    this.rrx = ((ImageView)findViewById(2131299669));
    this.rqb = ((TextView)findViewById(2131299691));
    this.rrz = ((ImageView)findViewById(2131299692));
    this.rry = ((TextView)findViewById(2131300745));
    AppMethodBeat.o(104347);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(104353);
    ad.i(this.TAG, " FaceReflect Preview UI resume");
    if (this.rqi != null)
    {
      this.rqi.a(this.rpZ);
      this.rqi.cuu();
      this.rqi.rqM = true;
      this.rqb.setText(2131758753);
    }
    AppMethodBeat.o(104353);
  }
  
  public final void setBusinessTip(String paramString)
  {
    AppMethodBeat.i(104348);
    if ((TextUtils.isEmpty(paramString)) || (this.rry == null))
    {
      AppMethodBeat.o(104348);
      return;
    }
    ad.d(this.TAG, "business tip is : ".concat(String.valueOf(paramString)));
    this.rry.setText(paramString);
    AppMethodBeat.o(104348);
  }
  
  public final void w(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104357);
    ad.i(this.TAG, "callbackDetectFailed()");
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    this.rqH.a(4, paramInt, paramString1, localBundle);
    AppMethodBeat.o(104357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a.a
 * JD-Core Version:    0.7.0.1
 */