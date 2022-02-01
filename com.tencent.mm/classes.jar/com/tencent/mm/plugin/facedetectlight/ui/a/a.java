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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
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
  PreviewFrameLayout ryb;
  MMTextureView ryd;
  private ImageView rye;
  public TextView ryf;
  public com.tencent.mm.plugin.facedetectlight.ui.b rym;
  public ImageView rzM;
  private TextView rzN;
  ImageView rzO;
  public FaceReflectMask rzd;
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    super(paramViewGroup, parama);
  }
  
  public final void a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104349);
    ae.d(this.TAG, "initCamera : bioID=%s ,appID=%s ,userName=%s", new Object[] { paramString1, paramString2, paramString3 });
    this.rym = new com.tencent.mm.plugin.facedetectlight.ui.b(this.DV.getContext(), this);
    this.rym.rzc = this.ryf;
    this.rym.rzd = this.rzd;
    this.rym.rze = this.ryb;
    this.rym.rsx = paramArrayOfByte;
    this.rym.rzg = paramString1;
    this.rym.mAppId = paramString2;
    this.rym.fIQ = paramString3;
    this.rym.nRq = this.rye;
    AppMethodBeat.o(104349);
  }
  
  public final void aW(int paramInt, String paramString)
  {
    AppMethodBeat.i(104355);
    this.ryW.a(1, paramInt, paramString, null);
    AppMethodBeat.o(104355);
  }
  
  public final void agY(String paramString)
  {
    AppMethodBeat.i(104356);
    ae.i(this.TAG, "callbackDetectSuccess()");
    Bundle localBundle = new Bundle();
    localBundle.putString("key_bio_buffer_path", paramString);
    this.ryW.a(0, 0, "collect data ok", localBundle);
    AppMethodBeat.o(104356);
  }
  
  public final void cuj()
  {
    AppMethodBeat.i(104354);
    c.a.cvW();
    ae.i("MicroMsg.FaceReflectLogic", "initAuth()");
    int i = YTCommonInterface.initAuth(ak.getContext(), "rel_wechat_2055-12-06.lic1.2", 0);
    ae.i(this.TAG, "auth：".concat(String.valueOf(i)));
    if (i != 0)
    {
      ae.i(this.TAG, "initAuth failed");
      g.yxI.idkeyStat(917L, 29L, 1L, false);
      AppMethodBeat.o(104354);
      return;
    }
    ae.i(this.TAG, "initAuth success");
    g.yxI.idkeyStat(917L, 28L, 1L, false);
    c localc = c.a.cvW();
    Activity localActivity = (Activity)this.DV.getContext();
    ae.i("MicroMsg.FaceReflectLogic", "initYoutuInstance()");
    i = -1;
    if (PluginFace.isEnabled()) {
      i = YTFaceTrack.GlobalInit(q.k(p.cuM(), false) + "/");
    }
    ae.i("MicroMsg.FaceReflectLogic", "YTFaceTrack.GlobalInit ret: %s", new Object[] { Integer.valueOf(i) });
    if (i != 0) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        YTCommonExInterface.setAppBrightness(localActivity, 255);
      }
      localc.mState = 0;
      localc.rzm = this;
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
      ae.i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.initModel return:".concat(String.valueOf(i)));
      if (i != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final int cvT()
  {
    return 2131493912;
  }
  
  public final void cvY()
  {
    AppMethodBeat.i(104350);
    ae.i(this.TAG, "finish ReflectUI");
    FaceReflectMask localFaceReflectMask = this.rzd;
    localFaceReflectMask.rzG = true;
    localFaceReflectMask.rxZ = true;
    localFaceReflectMask.invalidate();
    this.rzd.setBackgroundColor(-16777216);
    this.rym.stopPreview();
    setVisibility(8);
    this.rzO.setVisibility(0);
    AppMethodBeat.o(104350);
  }
  
  public final void cvZ()
  {
    AppMethodBeat.i(104351);
    ae.i(this.TAG, "reflectLoadAnimation()");
    final int i = this.rzd.getWidth();
    final int j = this.rzd.getHeight();
    final RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(2500L);
    localRotateAnimation.setRepeatCount(-1);
    this.rzO.setVisibility(4);
    this.rzO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104346);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)a.this.rzO.getLayoutParams();
        localMarginLayoutParams.width = ((int)(i * 0.7D));
        localMarginLayoutParams.height = ((int)(i * 0.7D));
        localMarginLayoutParams.topMargin = ((int)(j * 0.4D - i * 0.35D));
        a.this.rzO.setLayoutParams(localMarginLayoutParams);
        a.this.rzO.setVisibility(0);
        a.this.rzO.startAnimation(localRotateAnimation);
        AppMethodBeat.o(104346);
      }
    });
    this.rzM.setVisibility(4);
    AppMethodBeat.o(104351);
  }
  
  public final void cwa()
  {
    AppMethodBeat.i(104352);
    this.rzN.setVisibility(0);
    AppMethodBeat.o(104352);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(104347);
    this.rye = ((ImageView)findViewById(2131297031));
    this.ryb = ((PreviewFrameLayout)findViewById(2131299689));
    this.ryd = ((MMTextureView)findViewById(2131299688));
    this.rzd = ((FaceReflectMask)findViewById(2131299690));
    this.rzM = ((ImageView)findViewById(2131299669));
    this.ryf = ((TextView)findViewById(2131299691));
    this.rzO = ((ImageView)findViewById(2131299692));
    this.rzN = ((TextView)findViewById(2131300745));
    AppMethodBeat.o(104347);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(104353);
    ae.i(this.TAG, " FaceReflect Preview UI resume");
    if (this.rym != null)
    {
      this.rym.a(this.ryd);
      this.rym.cvV();
      this.rym.rzb = true;
      this.ryf.setText(2131758753);
    }
    AppMethodBeat.o(104353);
  }
  
  public final void setBusinessTip(String paramString)
  {
    AppMethodBeat.i(104348);
    if ((TextUtils.isEmpty(paramString)) || (this.rzN == null))
    {
      AppMethodBeat.o(104348);
      return;
    }
    ae.d(this.TAG, "business tip is : ".concat(String.valueOf(paramString)));
    this.rzN.setText(paramString);
    AppMethodBeat.o(104348);
  }
  
  public final void w(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104357);
    ae.i(this.TAG, "callbackDetectFailed()");
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    this.ryW.a(4, paramInt, paramString1, localBundle);
    AppMethodBeat.o(104357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a.a
 * JD-Core Version:    0.7.0.1
 */