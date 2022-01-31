package com.tencent.mm.plugin.facedetectlight.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetectlight.ui.FaceReflectMask;
import com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout;
import com.tencent.mm.plugin.facedetectlight.ui.c;
import com.tencent.mm.plugin.facedetectlight.ui.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class a
  extends com.tencent.mm.plugin.facedetectlight.ui.a
  implements b
{
  PreviewFrameLayout mqV;
  MMTextureView mqX;
  private ImageView mqY;
  public TextView mqZ;
  public FaceReflectMask mrG;
  public com.tencent.mm.plugin.facedetectlight.ui.b mrg;
  public ImageView msl;
  private TextView msm;
  ImageView msn;
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    super(paramViewGroup, parama);
  }
  
  public final void Nw(String paramString)
  {
    AppMethodBeat.i(834);
    ab.i(this.TAG, "callbackDetectSuccess()");
    Bundle localBundle = new Bundle();
    localBundle.putString("key_bio_buffer_path", paramString);
    this.mrz.a(0, 0, "collect data ok", localBundle);
    AppMethodBeat.o(834);
  }
  
  public final void a(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(827);
    ab.d(this.TAG, "initCamera : bioID=%s ,appID=%s ,userName=%s", new Object[] { paramString1, paramString2, paramString3 });
    this.mrg = new com.tencent.mm.plugin.facedetectlight.ui.b(this.uR.getContext(), this);
    this.mrg.mrF = this.mqZ;
    this.mrg.mrG = this.mrG;
    this.mrg.mrH = this.mqV;
    this.mrg.mlk = paramArrayOfByte;
    this.mrg.mrJ = paramString1;
    this.mrg.mAppId = paramString2;
    this.mrg.eaX = paramString3;
    this.mrg.mrK = this.mqY;
    AppMethodBeat.o(827);
  }
  
  public final void aB(int paramInt, String paramString)
  {
    AppMethodBeat.i(833);
    this.mrz.a(1, paramInt, paramString, null);
    AppMethodBeat.o(833);
  }
  
  public final void buc()
  {
    AppMethodBeat.i(832);
    c.a.bvQ();
    ab.i("MicroMsg.FaceReflectLogic", "initAuth()");
    int i = YTCommonExInterface.initAuth(ah.getContext(), "rel_wechat_2055-12-06.lic1.2", 0, false);
    ab.i(this.TAG, "auth：".concat(String.valueOf(i)));
    if (i != 0)
    {
      ab.i(this.TAG, "initAuth failed");
      h.qsU.idkeyStat(917L, 29L, 1L, false);
      AppMethodBeat.o(832);
      return;
    }
    ab.i(this.TAG, "initAuth success");
    h.qsU.idkeyStat(917L, 28L, 1L, false);
    c localc = c.a.bvQ();
    Activity localActivity = (Activity)this.uR.getContext();
    ab.i("MicroMsg.FaceReflectLogic", "initYoutuInstance()");
    for (;;)
    {
      try
      {
        InputStream localInputStream1 = ah.getContext().getAssets().open("face_detect" + File.separator + "ufdmtcc.bin");
        InputStream localInputStream2 = ah.getContext().getAssets().open("face_detect" + File.separator + "ufat.bin");
        arrayOfByte2 = new byte[localInputStream1.available()];
        ab.i("MicroMsg.FaceReflectLogic", "load ufat.bin or ufdmtcc.bin failed" + localIOException1.getMessage());
      }
      catch (IOException localIOException1)
      {
        try
        {
          localInputStream1.read(arrayOfByte2);
          arrayOfByte1 = new byte[localInputStream2.available()];
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            byte[] arrayOfByte2;
            byte[] arrayOfByte1 = null;
          }
        }
        try
        {
          localInputStream2.read(arrayOfByte1);
          localInputStream1.close();
          localInputStream2.close();
          i = YTFaceTraceInterface.initModel(arrayOfByte2, arrayOfByte1);
          ab.i("MicroMsg.FaceReflectLogic", "YTFaceTraceInterface.initModel ret: %s", new Object[] { Integer.valueOf(i) });
          if (i == 0) {
            break label344;
          }
          ab.i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.initModel failed，return:".concat(String.valueOf(i)));
          i = 0;
          if (i != 0) {
            YTCommonExInterface.setAppBrightness(localActivity, 255);
          }
          localc.mState = 0;
          localc.mrP = this;
          AppMethodBeat.o(832);
          return;
        }
        catch (IOException localIOException3)
        {
          break label315;
        }
        localIOException1 = localIOException1;
        arrayOfByte1 = null;
        arrayOfByte2 = null;
      }
      label315:
      continue;
      label344:
      i = YTAGReflectLiveCheckInterface.initModel(arrayOfByte2, arrayOfByte1);
      if (i != 0)
      {
        ab.i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.initModel failed，return:".concat(String.valueOf(i)));
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
  }
  
  public final int bvM()
  {
    return 2130969499;
  }
  
  public final void bvS()
  {
    AppMethodBeat.i(828);
    ab.i(this.TAG, "finish ReflectUI");
    FaceReflectMask localFaceReflectMask = this.mrG;
    localFaceReflectMask.msf = true;
    localFaceReflectMask.mqT = true;
    localFaceReflectMask.invalidate();
    this.mrG.setBackgroundColor(-16777216);
    this.mrg.stopPreview();
    setVisibility(8);
    this.msn.setVisibility(0);
    AppMethodBeat.o(828);
  }
  
  public final void bvT()
  {
    AppMethodBeat.i(829);
    ab.i(this.TAG, "reflectLoadAnimation()");
    int i = this.mrG.getWidth();
    int j = this.mrG.getHeight();
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(2500L);
    localRotateAnimation.setRepeatCount(-1);
    this.msn.setVisibility(4);
    this.msn.post(new a.2(this, i, j, localRotateAnimation));
    this.msl.setVisibility(4);
    AppMethodBeat.o(829);
  }
  
  public final void bvU()
  {
    AppMethodBeat.i(830);
    this.msm.setVisibility(0);
    AppMethodBeat.o(830);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(825);
    this.mqY = ((ImageView)findViewById(2131823874));
    this.mqV = ((PreviewFrameLayout)findViewById(2131823872));
    this.mqX = ((MMTextureView)findViewById(2131823873));
    this.mrG = ((FaceReflectMask)findViewById(2131823876));
    this.msl = ((ImageView)findViewById(2131823898));
    this.mqZ = ((TextView)findViewById(2131823877));
    this.msn = ((ImageView)findViewById(2131823899));
    this.msm = ((TextView)findViewById(2131823891));
    AppMethodBeat.o(825);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(831);
    ab.i(this.TAG, " FaceReflect Preview UI resume");
    if (this.mrg != null)
    {
      this.mrg.a(this.mqX);
      this.mrg.bvP();
      this.mrg.mrE = true;
      this.mqZ.setText(2131299596);
    }
    AppMethodBeat.o(831);
  }
  
  public final void setBusinessTip(String paramString)
  {
    AppMethodBeat.i(826);
    if ((TextUtils.isEmpty(paramString)) || (this.msm == null))
    {
      AppMethodBeat.o(826);
      return;
    }
    ab.d(this.TAG, "business tip is : ".concat(String.valueOf(paramString)));
    this.msm.setText(paramString);
    AppMethodBeat.o(826);
  }
  
  public final void u(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(835);
    ab.i(this.TAG, "callbackDetectFailed()");
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    this.mrz.a(4, paramInt, paramString1, localBundle);
    AppMethodBeat.o(835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a.a
 * JD-Core Version:    0.7.0.1
 */