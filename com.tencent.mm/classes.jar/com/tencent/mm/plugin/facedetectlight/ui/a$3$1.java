package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetectaction.b.a.1;
import com.tencent.mm.plugin.facedetectaction.b.a.2;
import com.tencent.mm.plugin.facedetectaction.b.a.a;
import com.tencent.mm.plugin.facedetectaction.b.a.b;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;

final class a$3$1
  implements Runnable
{
  a$3$1(a.3 param3) {}
  
  public final void run()
  {
    if (a.e(this.jXB.jXz) == 1)
    {
      b localb = b.a.aPE();
      localObject1 = a.f(this.jXB.jXz).getApplicationContext();
      localObject2 = a.f(this.jXB.jXz);
      localObject3 = a.g(this.jXB.jXz);
      i = a.h(this.jXB.jXz);
      localObject4 = this.jXB.jXz.jXn;
      localObject5 = a.i(this.jXB.jXz);
      localObject6 = a.j(this.jXB.jXz);
      str1 = a.k(this.jXB.jXz);
      String str2 = a.l(this.jXB.jXz);
      j = a.m(this.jXB.jXz);
      k = a.n(this.jXB.jXz);
      m = a.o(this.jXB.jXz);
      Point localPoint2 = a.p(this.jXB.jXz);
      y.i("MicroMsg.FaceReflectLogic", "initPreviewDetect（）");
      localb.mContext = ((Context)localObject1);
      localb.mCamera = ((Camera)localObject3);
      localb.gov = i;
      localb.jVO = ((TextView)localObject4);
      localb.jXm = ((FaceReflectUI)localObject2);
      localb.jXo = ((FaceReflectMask)localObject5);
      localb.jXF = j;
      localb.mDesiredPreviewWidth = k;
      localb.mDesiredPreviewHeight = m;
      localb.jXG = localPoint2;
      localb.jQQ = ((byte[])localObject6);
      localb.jXr = str1;
      localb.mAppId = str2;
      y.i("MicroMsg.FaceReflectLogic", "mConfig is " + localObject6);
      y.i("MicroMsg.FaceReflectLogic", "mBioID is " + localb.jXr);
      y.i("MicroMsg.FaceReflectLogic", "mAppId is " + str2);
      localb.jVQ = new Rect(0, 0, 0, 0);
      localb.jVR = new Rect(0, 0, 0, 0);
      localb.jVW = new b.1(localb);
      if (com.tencent.mm.plugin.facedetect.e.a.aPj().jST) {
        com.tencent.mm.plugin.facedetect.e.a.aPj().a(localb.jXF, localb.mDesiredPreviewWidth, localb.mDesiredPreviewHeight, localb.jXG.x, localb.mDesiredPreviewHeight, false);
      }
      localb = b.a.aPE();
      y.i("MicroMsg.FaceReflectLogic", "initFaceDetect（）");
      try
      {
        YTFaceTraceInterface.start(localb.mContext, localb.mCamera, localb.gov, new b.3(localb), localb.jVW);
        return;
      }
      catch (Exception localException1)
      {
        y.i("MicroMsg.FaceReflectLogic", "init FaceDetect() failed ：%s ", new Object[] { localException1.getMessage() });
        return;
      }
    }
    Object localObject1 = a.b.aPw();
    Object localObject2 = a.q(this.jXB.jXz).getApplicationContext();
    Object localObject3 = a.q(this.jXB.jXz);
    Object localObject4 = a.g(this.jXB.jXz);
    int i = a.h(this.jXB.jXz);
    Object localObject5 = this.jXB.jXz.jXn;
    Object localObject6 = a.r(this.jXB.jXz);
    int j = a.m(this.jXB.jXz);
    Point localPoint1 = new Point(a.n(this.jXB.jXz), a.o(this.jXB.jXz));
    int k = a.s(this.jXB.jXz);
    String str1 = a.t(this.jXB.jXz);
    int m = a.n(this.jXB.jXz);
    int n = a.o(this.jXB.jXz);
    y.i("MicroMsg.FaceActionLogic", "initFaceDetect（）");
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mContext = ((Context)localObject2);
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mCamera = ((Camera)localObject4);
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).gov = i;
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).jVO = ((TextView)localObject5);
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).jVN = ((FaceActionUI)localObject3);
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).jVP = ((a.a)localObject6);
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).jVL = k;
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).jVM = str1;
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mDesiredPreviewWidth = m;
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mDesiredPreviewHeight = n;
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).jVQ = new Rect(0, 0, 0, 0);
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).jVR = new Rect(0, 0, 0, 0);
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).jVW = new a.1((com.tencent.mm.plugin.facedetectaction.b.a)localObject1);
    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).jVX = new a.2((com.tencent.mm.plugin.facedetectaction.b.a)localObject1);
    try
    {
      YTFaceTraceInterface.start(((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mContext, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mCamera, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).gov, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).jVX, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).jVW);
      y.i("MicroMsg.FaceActionLogic", "init face detect, camera, rotate: %s", new Object[] { Integer.valueOf(j) });
      d.jWf.jWo = j;
      localObject1 = d.jWf;
      i = localPoint1.x;
      j = localPoint1.y;
      ((d)localObject1).jWp = i;
      ((d)localObject1).jWq = j;
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        y.i("MicroMsg.FaceActionLogic", "init FaceDetect() failed ：%s ", new Object[] { localException2.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a.3.1
 * JD-Core Version:    0.7.0.1
 */