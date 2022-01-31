package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetectlight.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceTraceingNotice;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;

final class c$1
  implements YTFaceTraceInterface.FaceTraceingNotice
{
  c$1(c paramc) {}
  
  public final void onTracing(int paramInt, YTFaceTraceJNIInterface.FaceStatus paramFaceStatus, Rect paramRect, byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(788);
    ab.i("MicroMsg.FaceReflectLogic", "facePreviewState：".concat(String.valueOf(paramFaceStatus)));
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(788);
      return;
    case 0: 
      ab.i("MicroMsg.FaceReflectLogic", "Face mState：init");
      AppMethodBeat.o(788);
      return;
    case 2: 
      ab.i("MicroMsg.FaceReflectLogic", "Face mState：stop detect");
      AppMethodBeat.o(788);
      return;
    }
    ab.i("MicroMsg.FaceReflectLogic", "Face mState：detecting");
    paramArrayOfByte = this.msb;
    ab.i("MicroMsg.FaceReflectLogic", "setFaceRect（）");
    paramArrayOfByte.mqk = paramArrayOfByte.mContext.getResources().getDisplayMetrics().widthPixels;
    paramArrayOfByte.mql = paramArrayOfByte.mContext.getResources().getDisplayMetrics().heightPixels;
    paramArrayOfByte.mqj.left = ((int)(paramArrayOfByte.mqk * 0.15D));
    paramArrayOfByte.mqj.right = ((int)(paramArrayOfByte.mqk * 0.85D));
    paramArrayOfByte.mqj.top = ((int)(paramArrayOfByte.mql * 0.2D));
    paramArrayOfByte.mqj.bottom = ((int)(paramArrayOfByte.mql * 0.65D));
    paramArrayOfByte = this.msb;
    ab.i("MicroMsg.FaceReflectLogic", "setFaceLiveRect（）");
    ab.i("MicroMsg.FaceReflectLogic", "faceInPreviewFrame is".concat(String.valueOf(paramRect)));
    if (paramRect != null)
    {
      paramInt = paramArrayOfByte.mqk;
      int i = paramArrayOfByte.mql;
      int j = paramArrayOfByte.mDesiredPreviewWidth;
      int k = paramArrayOfByte.mDesiredPreviewHeight;
      paramArrayOfByte.mrY = (paramInt / k);
      paramArrayOfByte.mrZ = (i / j);
      paramArrayOfByte.mqi.left = ((int)(paramRect.left * paramArrayOfByte.mrY));
      paramArrayOfByte.mqi.right = ((int)(paramRect.right * paramArrayOfByte.mrY));
      paramArrayOfByte.mqi.top = ((int)(paramRect.top * paramArrayOfByte.mrZ));
      paramArrayOfByte.mqi.bottom = ((int)(paramRect.bottom * paramArrayOfByte.mrZ));
      ab.i("MicroMsg.FaceReflectLogic", "mUiWidth：" + paramArrayOfByte.mqk);
      ab.i("MicroMsg.FaceReflectLogic", "mUiHeight：" + paramArrayOfByte.mql);
      ab.i("MicroMsg.FaceReflectLogic", "previewWidth：".concat(String.valueOf(j)));
      ab.i("MicroMsg.FaceReflectLogic", "previewHeight：".concat(String.valueOf(k)));
      ab.i("MicroMsg.FaceReflectLogic", "faceInPreviewFrame.right：" + paramRect.right);
      ab.i("MicroMsg.FaceReflectLogic", "mReflectWidthRatio：" + paramArrayOfByte.mrY);
    }
    paramRect = this.msb;
    paramArrayOfByte = this.msb.mqj;
    paramCamera = this.msb.mqi;
    ab.i("MicroMsg.FaceReflectLogic", "getFacePreviewAdvise（）");
    if (paramFaceStatus == null)
    {
      ab.i("MicroMsg.FaceReflectLogic", "status == null");
      paramRect.mqg.setText(2131299593);
    }
    for (;;)
    {
      ab.i("MicroMsg.FaceReflectLogic", "Face end");
      break;
      boolean bool = paramArrayOfByte.contains(paramCamera);
      float f = (paramCamera.right - paramCamera.left) * (paramCamera.bottom - paramCamera.top) / ((paramArrayOfByte.right - paramArrayOfByte.left) * (paramArrayOfByte.bottom - paramArrayOfByte.top));
      ab.i("MicroMsg.FaceReflectLogic", "faceInScreen left is ：" + paramCamera.left);
      ab.i("MicroMsg.FaceReflectLogic", "faceInScreen right is ：" + paramCamera.right);
      ab.i("MicroMsg.FaceReflectLogic", "faceInScreen top is ：" + paramCamera.top);
      ab.i("MicroMsg.FaceReflectLogic", "faceInScreen bottom is ：" + paramCamera.bottom);
      ab.i("MicroMsg.FaceReflectLogic", "checkRect left is ：" + paramArrayOfByte.left);
      ab.i("MicroMsg.FaceReflectLogic", "checkRect right is ：" + paramArrayOfByte.right);
      ab.i("MicroMsg.FaceReflectLogic", "checkRect top is ：" + paramArrayOfByte.top);
      ab.i("MicroMsg.FaceReflectLogic", "checkRect bottom is ：" + paramArrayOfByte.bottom);
      ab.i("MicroMsg.FaceReflectLogic", "faceProportion ：".concat(String.valueOf(f)));
      ab.i("MicroMsg.FaceReflectLogic", "isInRect？ ：".concat(String.valueOf(bool)));
      ab.i("MicroMsg.FaceReflectLogic", "status".concat(String.valueOf(paramFaceStatus)));
      if (f < 0.3D)
      {
        ab.i("MicroMsg.FaceReflectLogic", "Detecting result：too far");
        paramRect.mqg.setText(2131299598);
      }
      else if (f > 0.75D)
      {
        ab.i("MicroMsg.FaceReflectLogic", "Detecting result：too close");
        paramRect.mqg.setText(2131299597);
      }
      else if (!bool)
      {
        ab.i("MicroMsg.FaceReflectLogic", "Detecting result：out of rect");
        paramRect.mqg.setText(2131299593);
      }
      else if ((Math.abs(paramFaceStatus.pitch) > 15.0F) || (Math.abs(paramFaceStatus.yaw) > 15.0F) || (Math.abs(paramFaceStatus.roll) > 15.0F))
      {
        ab.i("MicroMsg.FaceReflectLogic", "Detecting result：INCORRECT_POSTURE");
        paramRect.mqg.setText(2131299595);
      }
      else
      {
        ab.i("MicroMsg.FaceReflectLogic", "Detecting result：normal");
        paramRect.mqg.setText(2131299594);
        paramRect.mrP.bvU();
        YTFaceTraceInterface.stop();
        ab.i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.stop()");
        if (a.bvo().mnp) {
          a.bvo().EC();
        }
        al.p(new c.2(paramRect), 2000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.c.1
 * JD-Core Version:    0.7.0.1
 */