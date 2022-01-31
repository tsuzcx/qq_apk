package com.tencent.mm.plugin.facedetectaction.b;

import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceTraceingNotice;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;

public final class a$1
  implements YTFaceTraceInterface.FaceTraceingNotice
{
  public a$1(a parama) {}
  
  public final void onTracing(int paramInt, YTFaceTraceJNIInterface.FaceStatus paramFaceStatus, Rect paramRect, byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(678);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(678);
      return;
    case 0: 
      ab.i("MicroMsg.FaceActionLogic", "Face mState：init");
      YTPoseDetectInterface.start(ah.getContext(), this.mqq.mCamera, this.mqq.hIs, new YTPoseDetectInterface.PoseDetectResult()
      {
        public final void onFailed(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(677);
          ab.i("MicroMsg.FaceActionLogic", "YTPoseDetectInterface start failed：[%s],[%s]", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(677);
        }
        
        public final void onSuccess()
        {
          AppMethodBeat.i(676);
          ab.i("MicroMsg.FaceActionLogic", "YTPoseDetectInterface start success");
          AppMethodBeat.o(676);
        }
      });
      AppMethodBeat.o(678);
      return;
    case 2: 
      ab.i("MicroMsg.FaceActionLogic", "Face mState：stop detect");
      AppMethodBeat.o(678);
      return;
    }
    ab.i("MicroMsg.FaceActionLogic", "Face mState：detecting");
    paramCamera = this.mqq;
    ab.i("MicroMsg.FaceActionLogic", "setFaceRect（）");
    paramCamera.mqk = paramCamera.mqf.getResources().getDisplayMetrics().widthPixels;
    paramCamera.mql = paramCamera.mqf.getResources().getDisplayMetrics().heightPixels;
    paramCamera.mqj.left = ((int)(paramCamera.mqk * 0.15D));
    paramCamera.mqj.right = ((int)(paramCamera.mqk * 0.85D));
    paramCamera.mqj.top = ((int)(paramCamera.mql * 0.2D));
    paramCamera.mqj.bottom = ((int)(paramCamera.mql * 0.65D));
    paramCamera = this.mqq;
    ab.i("MicroMsg.FaceActionLogic", "setFaceLiveRect（）");
    ab.i("MicroMsg.FaceActionLogic", "faceInPreviewFrame is".concat(String.valueOf(paramRect)));
    if (paramRect != null)
    {
      paramInt = paramCamera.mqk;
      int i = paramCamera.mql;
      int j = paramCamera.mDesiredPreviewWidth;
      int k = paramCamera.mDesiredPreviewHeight;
      paramCamera.mqm = (paramInt / k);
      paramCamera.mqn = (i / j);
      paramCamera.mqi.left = ((int)(paramRect.left * paramCamera.mqm));
      paramCamera.mqi.right = ((int)(paramRect.right * paramCamera.mqm));
      paramCamera.mqi.top = ((int)(paramRect.top * paramCamera.mqn));
      paramCamera.mqi.bottom = ((int)(paramRect.bottom * paramCamera.mqn));
      ab.i("MicroMsg.FaceActionLogic", "mUiWidth：" + paramCamera.mqk);
      ab.i("MicroMsg.FaceActionLogic", "mUiHeight：" + paramCamera.mql);
      ab.i("MicroMsg.FaceActionLogic", "previewWidth：".concat(String.valueOf(j)));
      ab.i("MicroMsg.FaceActionLogic", "previewHeight：".concat(String.valueOf(k)));
      ab.i("MicroMsg.FaceActionLogic", "faceInPreviewFrame.right：" + paramRect.right);
      ab.i("MicroMsg.FaceActionLogic", "mWidthRatio：" + paramCamera.mqm);
    }
    paramRect = this.mqq;
    paramCamera = this.mqq.mqj;
    Rect localRect = this.mqq.mqi;
    ab.i("MicroMsg.FaceActionLogic", "getFacePreviewAdvise（）");
    if (paramFaceStatus == null)
    {
      ab.i("MicroMsg.FaceActionLogic", "status == null");
      paramRect.mqg.setText(2131299593);
      AppMethodBeat.o(678);
      return;
    }
    boolean bool = paramCamera.contains(localRect);
    float f = (localRect.right - localRect.left) * (localRect.bottom - localRect.top) / ((paramCamera.right - paramCamera.left) * (paramCamera.bottom - paramCamera.top));
    ab.i("MicroMsg.FaceActionLogic", "faceInScreen left is ：" + localRect.left);
    ab.i("MicroMsg.FaceActionLogic", "faceInScreen right is ：" + localRect.right);
    ab.i("MicroMsg.FaceActionLogic", "faceInScreen top is ：" + localRect.top);
    ab.i("MicroMsg.FaceActionLogic", "faceInScreen bottom is ：" + localRect.bottom);
    ab.i("MicroMsg.FaceActionLogic", "checkRect left is ：" + paramCamera.left);
    ab.i("MicroMsg.FaceActionLogic", "checkRect right is ：" + paramCamera.right);
    ab.i("MicroMsg.FaceActionLogic", "checkRect top is ：" + paramCamera.top);
    ab.i("MicroMsg.FaceActionLogic", "checkRect bottom is ：" + paramCamera.bottom);
    ab.i("MicroMsg.FaceActionLogic", "faceProportion ：".concat(String.valueOf(f)));
    ab.i("MicroMsg.FaceActionLogic", "isInRect？ ：".concat(String.valueOf(bool)));
    ab.i("MicroMsg.FaceActionLogic", "status".concat(String.valueOf(paramFaceStatus)));
    if (f < 0.3D)
    {
      ab.i("MicroMsg.FaceActionLogic", "Detecting result：too far");
      paramRect.mqg.setText(2131299598);
      AppMethodBeat.o(678);
      return;
    }
    if (f > 0.75D)
    {
      ab.i("MicroMsg.FaceActionLogic", "Detecting result：too close");
      paramRect.mqg.setText(2131299597);
      AppMethodBeat.o(678);
      return;
    }
    if (!bool)
    {
      ab.i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
      paramRect.mqg.setText(2131299593);
      AppMethodBeat.o(678);
      return;
    }
    ab.i("MicroMsg.FaceActionLogic", "Detecting result：normal");
    ab.i("MicroMsg.FaceActionLogic", "action：%s,mActionHint:%s", new Object[] { Integer.valueOf(paramRect.mqd), paramRect.mqe });
    if (paramRect.mqe != null) {
      paramRect.mqg.setText(paramRect.mqe);
    }
    for (;;)
    {
      paramRect.mqh.a(paramFaceStatus, paramArrayOfByte);
      break;
      switch (paramRect.mqd)
      {
      default: 
        break;
      case 0: 
        paramRect.mqg.setText(2131299522);
        break;
      case 1: 
        paramRect.mqg.setText(2131299520);
        break;
      case 2: 
        paramRect.mqg.setText(2131299521);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.a.1
 * JD-Core Version:    0.7.0.1
 */