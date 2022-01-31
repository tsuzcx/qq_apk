package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import java.util.Arrays;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    b localb = this.jXK;
    y.i("MicroMsg.FaceReflectLogic", " beginFaceReflectiton()");
    Object localObject = localb.jXm;
    y.i("MicroMsg.FaceReflectUI", "reflectLoadAnimation()");
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(2500L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setAnimationListener(new FaceReflectUI.4((FaceReflectUI)localObject));
    ((FaceReflectUI)localObject).jXR.setVisibility(4);
    ((FaceReflectUI)localObject).jXR.post(new FaceReflectUI.5((FaceReflectUI)localObject, localRotateAnimation));
    y.i("MicroMsg.FaceReflectLogic", " mBioID is " + localb.jXr);
    y.i("MicroMsg.FaceReflectLogic", " mConfig is " + Arrays.toString(localb.jQQ));
    y.i("MicroMsg.FaceReflectLogic", "mConfig.length is " + localb.jQQ.length);
    localObject = YTAGFaceReflectForWXJNIInterface.decrypt(localb.jXr, localb.jQQ, localb.jQQ.length);
    y.i("MicroMsg.FaceReflectLogic", " real Config is " + (String)localObject);
    YTAGReflectLiveCheckInterface.setRGBConfigRequest(new b.4(localb, (String)localObject));
    localb.mState = 1;
    YTAGReflectLiveCheckInterface.start(localb.mContext, localb.mCamera, localb.gov, localb.jXo, new b.5(localb));
    localb = this.jXK;
    y.i("MicroMsg.FaceReflectLogic", " setUploadDataCallback()");
    YTAGReflectLiveCheckInterface.setUploadVideoRequester(new b.6(localb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.2
 * JD-Core Version:    0.7.0.1
 */