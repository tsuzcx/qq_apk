package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.facedetectaction.b.a.1;
import com.tencent.mm.plugin.facedetectaction.b.a.2;
import com.tencent.mm.plugin.facedetectaction.b.a.a;
import com.tencent.mm.plugin.facedetectaction.b.a.b;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(762);
    h localh;
    if (!b.d(this.mrQ))
    {
      localh = h.qsU;
      if (b.e(this.mrQ) == 1)
      {
        l = 3L;
        localh.idkeyStat(917L, l, 1L, false);
        b.d(this.mrQ);
      }
    }
    else
    {
      localh = h.qsU;
      if (b.e(this.mrQ) != 1) {
        break label107;
      }
    }
    label107:
    for (long l = 2L;; l = 38L)
    {
      localh.idkeyStat(917L, l, 1L, false);
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(761);
          if (b.f(b.3.this.mrQ) == null)
          {
            ab.e("MicroMsg.FaceReflectCam", "mCamera is null");
            AppMethodBeat.o(761);
            return;
          }
          if (b.e(b.3.this.mrQ) == 1)
          {
            c localc = c.a.bvQ();
            localObject1 = b.g(b.3.this.mrQ);
            localObject2 = b.h(b.3.this.mrQ);
            localObject3 = b.f(b.3.this.mrQ);
            i = b.i(b.3.this.mrQ);
            localObject4 = b.3.this.mrQ.mrF;
            localObject5 = b.j(b.3.this.mrQ);
            localObject6 = b.k(b.3.this.mrQ);
            str1 = b.l(b.3.this.mrQ);
            String str2 = b.m(b.3.this.mrQ);
            j = b.n(b.3.this.mrQ);
            k = b.o(b.3.this.mrQ);
            m = b.p(b.3.this.mrQ);
            Point localPoint2 = b.q(b.3.this.mrQ);
            ab.i("MicroMsg.FaceReflectLogic", "initPreviewDetect（）");
            localc.mContext = ((Context)localObject1);
            localc.mrD = ((u)localObject3);
            localc.hIs = i;
            localc.mqg = ((TextView)localObject4);
            localc.mrP = ((com.tencent.mm.plugin.facedetectlight.ui.a.b)localObject2);
            localc.mrG = ((FaceReflectMask)localObject5);
            localc.mrW = j;
            localc.mDesiredPreviewWidth = k;
            localc.mDesiredPreviewHeight = m;
            localc.mrX = localPoint2;
            localc.mlk = ((byte[])localObject6);
            localc.mrJ = str1;
            localc.mAppId = str2;
            ab.i("MicroMsg.FaceReflectLogic", "mConfig is ".concat(String.valueOf(localObject6)));
            ab.i("MicroMsg.FaceReflectLogic", "mBioID is " + localc.mrJ);
            ab.i("MicroMsg.FaceReflectLogic", "mAppId is ".concat(String.valueOf(str2)));
            localc.mqi = new Rect(0, 0, 0, 0);
            localc.mqj = new Rect(0, 0, 0, 0);
            localc.mqo = new c.1(localc);
            if (com.tencent.mm.plugin.facedetect.e.a.bvo().mnp) {
              com.tencent.mm.plugin.facedetect.e.a.bvo().a(localc.mrW, localc.mDesiredPreviewWidth, localc.mDesiredPreviewHeight, localc.mrX.x, localc.mDesiredPreviewHeight, false);
            }
            localc = c.a.bvQ();
            ab.i("MicroMsg.FaceReflectLogic", "initFaceDetect（）");
            try
            {
              YTFaceTraceInterface.start(localc.mContext, localc.mrD.eqF, localc.hIs, new c.3(localc), localc.mqo);
              AppMethodBeat.o(761);
              return;
            }
            catch (Exception localException1)
            {
              ab.i("MicroMsg.FaceReflectLogic", "init FaceDetect() failed ：%s ", new Object[] { localException1.getMessage() });
              AppMethodBeat.o(761);
              return;
            }
          }
          Object localObject1 = a.b.bvF();
          Object localObject2 = b.r(b.3.this.mrQ).getApplicationContext();
          Object localObject3 = b.r(b.3.this.mrQ);
          Object localObject4 = b.f(b.3.this.mrQ).eqF;
          int i = b.i(b.3.this.mrQ);
          Object localObject5 = b.3.this.mrQ.mrF;
          Object localObject6 = b.s(b.3.this.mrQ);
          int j = b.n(b.3.this.mrQ);
          Point localPoint1 = new Point(b.o(b.3.this.mrQ), b.p(b.3.this.mrQ));
          int k = b.t(b.3.this.mrQ);
          String str1 = b.u(b.3.this.mrQ);
          int m = b.o(b.3.this.mrQ);
          int n = b.p(b.3.this.mrQ);
          ab.i("MicroMsg.FaceActionLogic", "initFaceDetect（）");
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mContext = ((Context)localObject2);
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mCamera = ((Camera)localObject4);
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).hIs = i;
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mqg = ((TextView)localObject5);
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mqf = ((FaceActionUI)localObject3);
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mqh = ((a.a)localObject6);
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mqd = k;
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mqe = str1;
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mDesiredPreviewWidth = m;
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mDesiredPreviewHeight = n;
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mqi = new Rect(0, 0, 0, 0);
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mqj = new Rect(0, 0, 0, 0);
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mqo = new a.1((com.tencent.mm.plugin.facedetectaction.b.a)localObject1);
          ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mqp = new a.2((com.tencent.mm.plugin.facedetectaction.b.a)localObject1);
          try
          {
            YTFaceTraceInterface.start(((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mContext, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mCamera, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).hIs, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mqp, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject1).mqo);
            ab.i("MicroMsg.FaceActionLogic", "init face detect, camera, rotate: %s", new Object[] { Integer.valueOf(j) });
            d.mqx.fcn = j;
            localObject1 = d.mqx;
            i = localPoint1.x;
            j = localPoint1.y;
            ((d)localObject1).mqG = i;
            ((d)localObject1).mqH = j;
            AppMethodBeat.o(761);
            return;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ab.i("MicroMsg.FaceActionLogic", "init FaceDetect() failed ：%s ", new Object[] { localException2.getMessage() });
            }
          }
        }
      });
      AppMethodBeat.o(762);
      return;
      l = 39L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.3
 * JD-Core Version:    0.7.0.1
 */