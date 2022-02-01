package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.a.1;
import com.tencent.mm.plugin.facedetectaction.b.a.a;
import com.tencent.mm.plugin.facedetectaction.b.a.b;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionMask;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTFaceUtils;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b
  implements TextureView.SurfaceTextureListener
{
  public String fGM;
  private d.a.a hpP;
  private boolean hpr;
  public String mAppId;
  private Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  private boolean mIsCameraOpened;
  public ImageView nLL;
  private Point nLi;
  private Point rie;
  private Point rif;
  private boolean rig;
  private int rih;
  private Point rij;
  public boolean rkX;
  public byte[] rkt;
  private Camera.PreviewCallback rnC;
  d.b rnD;
  public FaceActionMask rpY;
  public int rpj;
  public String rpk;
  private FaceActionUI rpl;
  private a.a rpn;
  private MMTextureView rqI;
  private HandlerThread rqJ;
  private ap rqK;
  v rqL;
  public boolean rqM;
  public TextView rqN;
  public FaceReflectMask rqO;
  public PreviewFrameLayout rqP;
  private int rqQ;
  public String rqR;
  public ImageView rqS;
  private Bitmap rqT;
  private boolean rqU;
  private int rqV;
  private ap rqW;
  private com.tencent.mm.plugin.facedetectlight.ui.a.b rqX;
  
  public b(Context paramContext, com.tencent.mm.plugin.facedetectlight.ui.a.b paramb)
  {
    AppMethodBeat.i(104294);
    this.rie = null;
    this.nLi = null;
    this.rif = null;
    this.rij = null;
    this.rqQ = 0;
    this.rqW = new ap("mPreviewHandlerThread");
    this.rnD = new d.b()
    {
      public final void bm(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(104293);
        com.tencent.mm.plugin.facedetect.model.c.rgZ.k(paramAnonymousArrayOfByte);
        AppMethodBeat.o(104293);
      }
      
      public final com.tencent.mm.memory.a<byte[]> csP()
      {
        return com.tencent.mm.plugin.facedetect.model.c.rgZ;
      }
    };
    this.rnC = new Camera.PreviewCallback()
    {
      public final void onPreviewFrame(final byte[] paramAnonymousArrayOfByte, final Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(104282);
        if (b.B(b.this) != null) {
          b.B(b.this).postToWorker(new Runnable()
          {
            public final void run()
            {
              c localc = null;
              Object localObject1 = null;
              AppMethodBeat.i(104281);
              if (b.this.rqM)
              {
                label129:
                int i;
                if (b.e(b.this) == 1)
                {
                  localc = c.a.cuv();
                  localObject2 = paramAnonymousArrayOfByte;
                  localObject3 = paramAnonymousCamera;
                  ad.i("MicroMsg.FaceReflectLogic", "YTAGReflectLiveCheckInterface.getProcessState() : %s ", new Object[] { Integer.valueOf(YTAGReflectLiveCheckInterface.getProcessState()) });
                  ad.i("MicroMsg.FaceReflectLogic", "current state is:%d", new Object[] { Integer.valueOf(localc.mState) });
                  if (localc.mState != 4)
                  {
                    if (YTAGReflectLiveCheckInterface.getProcessState() != 2) {
                      break label129;
                    }
                    YTAGReflectLiveCheckInterface.onPreviewFrame((byte[])localObject2, (Camera)localObject3);
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.facedetect.model.d.csO().bl((byte[])localObject2);
                    AppMethodBeat.o(104281);
                    return;
                    if (YTAGReflectLiveCheckInterface.getProcessState() == 0)
                    {
                      i = 7;
                      if (localc.mContext != null) {
                        i = YTCameraSetting.getRotate(localc.mContext, localc.kHi, 1);
                      }
                      if (PluginFace.isEnabled()) {
                        localObject1 = YTFaceTrack.getInstance().DoDetectionProcessYUV((byte[])localObject2, localc.mDesiredPreviewWidth, localc.mDesiredPreviewHeight, i, null);
                      }
                      if (localObject1 != null)
                      {
                        aq.f(new c.2(localc, localObject1[0]));
                      }
                      else
                      {
                        ad.i("MicroMsg.FaceReflectLogic", "Detecting result：ADVISE_NO_FACE --- faceStatuses is null");
                        aq.f(new c.3(localc));
                      }
                    }
                  }
                }
                Object localObject2 = a.b.cum();
                Object localObject3 = paramAnonymousArrayOfByte;
                Camera localCamera = paramAnonymousCamera;
                if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpr)
                {
                  i = YTCameraSetting.getRotate(((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mContext, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).kHi, 1);
                  localObject1 = localc;
                  if (PluginFace.isEnabled()) {
                    localObject1 = YTFaceTrack.getInstance().DoDetectionProcessYUV((byte[])localObject3, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mDesiredPreviewWidth, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mDesiredPreviewHeight, i, null);
                  }
                  if (localObject1 != null)
                  {
                    localObject1 = localObject1[0];
                    if (YTPoseDetectInterface.isDetecting())
                    {
                      if (localObject1 == null)
                      {
                        ad.i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
                        ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpm.setText(2131758750);
                        AppMethodBeat.o(104281);
                        return;
                      }
                      YTFaceUtils.shelterJudge(((YTFaceTrack.FaceStatus)localObject1).pointsVis);
                      if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpq != null) {
                        YTPoseDetectInterface.poseDetect(((YTFaceTrack.FaceStatus)localObject1).xys, ((YTFaceTrack.FaceStatus)localObject1).pointsVis, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpj, (byte[])localObject3, localCamera, ((YTFaceTrack.FaceStatus)localObject1).pitch, ((YTFaceTrack.FaceStatus)localObject1).yaw, ((YTFaceTrack.FaceStatus)localObject1).roll, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpq, 0);
                      }
                    }
                    AppMethodBeat.o(104281);
                    return;
                  }
                  ad.i("MicroMsg.FaceActionLogic", "No face");
                }
              }
              AppMethodBeat.o(104281);
            }
          });
        }
        AppMethodBeat.o(104282);
      }
    };
    this.rqX = paramb;
    this.rqV = 1;
    this.mContext = paramContext;
    this.mIsCameraOpened = false;
    this.rkX = false;
    this.rqJ = null;
    this.mIsCameraOpened = false;
    AppMethodBeat.o(104294);
  }
  
  public b(FaceActionUI paramFaceActionUI, a.a parama)
  {
    AppMethodBeat.i(104295);
    this.rie = null;
    this.nLi = null;
    this.rif = null;
    this.rij = null;
    this.rqQ = 0;
    this.rqW = new ap("mPreviewHandlerThread");
    this.rnD = new d.b()
    {
      public final void bm(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(104293);
        com.tencent.mm.plugin.facedetect.model.c.rgZ.k(paramAnonymousArrayOfByte);
        AppMethodBeat.o(104293);
      }
      
      public final com.tencent.mm.memory.a<byte[]> csP()
      {
        return com.tencent.mm.plugin.facedetect.model.c.rgZ;
      }
    };
    this.rnC = new Camera.PreviewCallback()
    {
      public final void onPreviewFrame(final byte[] paramAnonymousArrayOfByte, final Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(104282);
        if (b.B(b.this) != null) {
          b.B(b.this).postToWorker(new Runnable()
          {
            public final void run()
            {
              c localc = null;
              Object localObject1 = null;
              AppMethodBeat.i(104281);
              if (b.this.rqM)
              {
                label129:
                int i;
                if (b.e(b.this) == 1)
                {
                  localc = c.a.cuv();
                  localObject2 = paramAnonymousArrayOfByte;
                  localObject3 = paramAnonymousCamera;
                  ad.i("MicroMsg.FaceReflectLogic", "YTAGReflectLiveCheckInterface.getProcessState() : %s ", new Object[] { Integer.valueOf(YTAGReflectLiveCheckInterface.getProcessState()) });
                  ad.i("MicroMsg.FaceReflectLogic", "current state is:%d", new Object[] { Integer.valueOf(localc.mState) });
                  if (localc.mState != 4)
                  {
                    if (YTAGReflectLiveCheckInterface.getProcessState() != 2) {
                      break label129;
                    }
                    YTAGReflectLiveCheckInterface.onPreviewFrame((byte[])localObject2, (Camera)localObject3);
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.facedetect.model.d.csO().bl((byte[])localObject2);
                    AppMethodBeat.o(104281);
                    return;
                    if (YTAGReflectLiveCheckInterface.getProcessState() == 0)
                    {
                      i = 7;
                      if (localc.mContext != null) {
                        i = YTCameraSetting.getRotate(localc.mContext, localc.kHi, 1);
                      }
                      if (PluginFace.isEnabled()) {
                        localObject1 = YTFaceTrack.getInstance().DoDetectionProcessYUV((byte[])localObject2, localc.mDesiredPreviewWidth, localc.mDesiredPreviewHeight, i, null);
                      }
                      if (localObject1 != null)
                      {
                        aq.f(new c.2(localc, localObject1[0]));
                      }
                      else
                      {
                        ad.i("MicroMsg.FaceReflectLogic", "Detecting result：ADVISE_NO_FACE --- faceStatuses is null");
                        aq.f(new c.3(localc));
                      }
                    }
                  }
                }
                Object localObject2 = a.b.cum();
                Object localObject3 = paramAnonymousArrayOfByte;
                Camera localCamera = paramAnonymousCamera;
                if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpr)
                {
                  i = YTCameraSetting.getRotate(((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mContext, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).kHi, 1);
                  localObject1 = localc;
                  if (PluginFace.isEnabled()) {
                    localObject1 = YTFaceTrack.getInstance().DoDetectionProcessYUV((byte[])localObject3, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mDesiredPreviewWidth, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mDesiredPreviewHeight, i, null);
                  }
                  if (localObject1 != null)
                  {
                    localObject1 = localObject1[0];
                    if (YTPoseDetectInterface.isDetecting())
                    {
                      if (localObject1 == null)
                      {
                        ad.i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
                        ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpm.setText(2131758750);
                        AppMethodBeat.o(104281);
                        return;
                      }
                      YTFaceUtils.shelterJudge(((YTFaceTrack.FaceStatus)localObject1).pointsVis);
                      if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpq != null) {
                        YTPoseDetectInterface.poseDetect(((YTFaceTrack.FaceStatus)localObject1).xys, ((YTFaceTrack.FaceStatus)localObject1).pointsVis, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpj, (byte[])localObject3, localCamera, ((YTFaceTrack.FaceStatus)localObject1).pitch, ((YTFaceTrack.FaceStatus)localObject1).yaw, ((YTFaceTrack.FaceStatus)localObject1).roll, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpq, 0);
                      }
                    }
                    AppMethodBeat.o(104281);
                    return;
                  }
                  ad.i("MicroMsg.FaceActionLogic", "No face");
                }
              }
              AppMethodBeat.o(104281);
            }
          });
        }
        AppMethodBeat.o(104282);
      }
    };
    this.rqV = 2;
    this.rpl = paramFaceActionUI;
    this.mIsCameraOpened = false;
    this.rkX = false;
    this.rqJ = null;
    this.mIsCameraOpened = false;
    this.rqU = false;
    this.rpn = parama;
    AppMethodBeat.o(104295);
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(104304);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new b.a((byte)0));
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    ad.d("MicroMsg.FaceReflectCam", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    long l = bt.je(aj.getContext());
    ad.d("MicroMsg.FaceReflectCam", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(l) });
    int i = paramPoint.x;
    i = paramPoint.y;
    float f1 = (1.0F / 1.0F);
    localObject = ((List)localObject).iterator();
    int j;
    label243:
    float f2;
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
      i = localSize.width;
      j = localSize.height;
      ad.i("MicroMsg.FaceReflectCam", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      int k = i * j;
      if ((k >= 150400) && (k <= 983040))
      {
        if (i > j)
        {
          m = 1;
          if (m == 0) {
            break label350;
          }
          k = j;
          if (m == 0) {
            break label357;
          }
        }
        label350:
        label357:
        for (int m = i;; m = j)
        {
          ad.d("MicroMsg.FaceReflectCam", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!j(k, m, l))) {
            break label364;
          }
          paramParameters = new Point(i, j);
          ad.i("MicroMsg.FaceReflectCam", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
          AppMethodBeat.o(104304);
          return paramParameters;
          m = 0;
          break;
          k = i;
          break label243;
        }
        label364:
        f2 = Math.abs(k / m - f3);
        if (i % 10 == 0)
        {
          if ((f2 >= f1) || (!j(i, j, l))) {
            break label548;
          }
          localPoint = new Point(i, j);
          f1 = f2;
        }
      }
    }
    label534:
    label548:
    for (;;)
    {
      ad.i("MicroMsg.FaceReflectCam", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        if (paramParameters == null) {
          break label534;
        }
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        ad.i("MicroMsg.FaceReflectCam", "No suitable preview sizes, using default: ".concat(String.valueOf(paramPoint)));
      }
      for (;;)
      {
        ad.i("MicroMsg.FaceReflectCam", "Found best approximate preview size: ".concat(String.valueOf(paramPoint)));
        AppMethodBeat.o(104304);
        return paramPoint;
        ad.e("MicroMsg.FaceReflectCam", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  private static void c(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(104305);
    if (ae.gcE.fYs > 0)
    {
      ad.i("MicroMsg.FaceReflectCam", "set frame rate > 0, do not try set preview fps range");
      AppMethodBeat.o(104305);
      return;
    }
    List localList = paramParameters.getSupportedPreviewFpsRange();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(104305);
      return;
    }
    int j = -2147483648;
    int i = -2147483648;
    int n = 0;
    int i6 = localList.size();
    int i3 = 0;
    int i2;
    int i1;
    int k;
    if (i3 < i6)
    {
      int[] arrayOfInt = (int[])localList.get(i3);
      i2 = i;
      i1 = j;
      if (arrayOfInt == null) {
        break label391;
      }
      i2 = i;
      i1 = j;
      if (arrayOfInt.length <= 1) {
        break label391;
      }
      int i5 = arrayOfInt[0];
      int i4 = arrayOfInt[1];
      ad.i("MicroMsg.FaceReflectCam", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
      i2 = i;
      i1 = j;
      if (i5 < 0) {
        break label391;
      }
      i2 = i;
      i1 = j;
      if (i4 < i5) {
        break label391;
      }
      k = i;
      int m = j;
      if (i4 >= i)
      {
        k = i;
        m = j;
        if (n == 0)
        {
          k = i4;
          m = i5;
        }
      }
      i2 = k;
      i1 = m;
      if (i4 < 30000) {
        break label391;
      }
      n = 1;
      j = m;
      i = k;
      k = n;
    }
    for (;;)
    {
      i3 += 1;
      n = k;
      break;
      ad.i("MicroMsg.FaceReflectCam", "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(30) });
      if ((j == 2147483647) || (i == 2147483647))
      {
        AppMethodBeat.o(104305);
        return;
      }
      try
      {
        paramParameters.setPreviewFpsRange(j, i);
        ad.i("MicroMsg.FaceReflectCam", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(104305);
        return;
      }
      catch (Exception paramParameters)
      {
        ad.i("MicroMsg.FaceReflectCam", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
        AppMethodBeat.o(104305);
        return;
      }
      label391:
      k = n;
      i = i2;
      j = i1;
    }
  }
  
  private boolean cut()
  {
    AppMethodBeat.i(104300);
    ad.i("MicroMsg.FaceReflectCam", "start open camera");
    this.mIsCameraOpened = false;
    this.hpr = true;
    int j = Camera.getNumberOfCameras();
    int i = 0;
    Object localObject1;
    if (i < j)
    {
      localObject1 = new Camera.CameraInfo();
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject1);
      if ((((Camera.CameraInfo)localObject1).facing == 1) && (this.hpr)) {
        ad.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
      }
    }
    for (;;)
    {
      if (i == -1)
      {
        ad.i("MicroMsg.FaceReflectCam", "not found available camera id");
        AppMethodBeat.o(104300);
        return false;
        if ((((Camera.CameraInfo)localObject1).facing == 0) && (!this.hpr))
        {
          ad.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
          continue;
        }
        i += 1;
        break;
      }
      long l = bt.HI();
      ad.i("MicroMsg.FaceReflectCam", "openCameraRes：" + this.hpP);
      if (this.hpP == null)
      {
        ad.i("MicroMsg.FaceReflectCam", "openCameraRes is null");
        if (this.rqV != 1) {
          break label290;
        }
        ad.i("MicroMsg.FaceReflectCam", "mFaceReflectController openCameraRe");
      }
      for (;;)
      {
        try
        {
          this.hpP = com.tencent.mm.compatible.deviceinfo.d.a(this.mContext, i, null);
          if (this.hpP != null) {
            break;
          }
          ad.i("MicroMsg.FaceReflectCam", "in open(), openCameraRes == null");
          try
          {
            localObject1 = new IOException();
            AppMethodBeat.o(104300);
            throw ((Throwable)localObject1);
          }
          catch (IOException localIOException1)
          {
            ad.i("MicroMsg.FaceReflectCam", "set cameraRes exception" + localIOException1.getMessage());
            AppMethodBeat.o(104300);
            return false;
          }
          ad.i("MicroMsg.FaceReflectCam", "mFaceActionUI openCameraRe");
        }
        catch (Exception localException1)
        {
          AppMethodBeat.o(104300);
          return false;
        }
        label290:
        this.hpP = com.tencent.mm.compatible.deviceinfo.d.a(this.rpl.getContext(), i, null);
      }
      this.rqQ = i;
      this.mIsCameraOpened = true;
      ad.d("MicroMsg.FaceReflectCam", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(bt.aO(l)) });
      this.rih = this.hpP.dGc;
      boolean bool;
      if (this.hpP.dGc % 180 != 0)
      {
        bool = true;
        this.rig = bool;
        this.rqL = this.hpP.fYS;
        if (this.rqL == null)
        {
          ad.e("MicroMsg.FaceReflectCam", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.rig) });
          try
          {
            IOException localIOException2 = new IOException();
            AppMethodBeat.o(104300);
            throw localIOException2;
          }
          catch (IOException localIOException3)
          {
            ad.i("MicroMsg.FaceReflectCam", "set cameraRotation exception" + localIOException3.getMessage());
          }
        }
      }
      Camera.Parameters localParameters;
      for (;;)
      {
        try
        {
          localParameters = this.rqL.getParameters();
          if (this.rqV != 1) {
            break label578;
          }
          j = this.mContext.getResources().getDisplayMetrics().widthPixels;
          i = this.mContext.getResources().getDisplayMetrics().heightPixels;
          if (localParameters != null) {
            break label611;
          }
          AppMethodBeat.o(104300);
          return false;
        }
        catch (Exception localException2)
        {
          ad.printErrStackTrace("MicroMsg.FaceReflectCam", localException2, "camera getParameters error: %s", new Object[] { localException2.getMessage() });
          AppMethodBeat.o(104300);
          return false;
        }
        bool = false;
        break;
        label578:
        j = this.rpl.getResources().getDisplayMetrics().widthPixels;
        i = this.rpl.getResources().getDisplayMetrics().heightPixels;
      }
      label611:
      this.nLi = new Point(j, i);
      Point localPoint2 = this.nLi;
      Point localPoint1 = this.rif;
      Object localObject4 = localParameters.get("preview-size-values");
      Object localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = localParameters.get("preview-size-value");
      }
      if (localObject2 != null) {
        ad.d("MicroMsg.FaceReflectCam", "preview-size-values parameter: ".concat(String.valueOf(localObject2)));
      }
      label1026:
      label1106:
      label1149:
      Object localObject3;
      for (localObject2 = a(localParameters, localPoint2);; localObject3 = null)
      {
        localObject4 = localObject2;
        if (localObject2 == null) {
          localObject4 = new Point(localPoint1.x >> 3 << 3, localPoint1.y >> 3 << 3);
        }
        this.rie = ((Point)localObject4);
        this.rij = new Point(this.rie);
        ad.d("MicroMsg.FaceReflectCam", "getCameraResolution: " + this.nLi + " camera:" + this.rie + "bestVideoEncodeSize: " + this.rij);
        this.mDesiredPreviewWidth = this.rie.x;
        this.mDesiredPreviewHeight = this.rie.y;
        localParameters.setPreviewSize(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
        ad.e("MicroMsg.FaceReflectCam", "mDesiredPreviewWidth：" + this.mDesiredPreviewWidth);
        ad.e("MicroMsg.FaceReflectCam", "mDesiredPreviewHeight：" + this.mDesiredPreviewHeight);
        localParameters.setZoom(0);
        localParameters.setSceneMode("auto");
        try
        {
          if ((localParameters.getSupportedFocusModes() != null) && (localParameters.getSupportedFocusModes().contains("auto")))
          {
            ad.i("MicroMsg.FaceReflectCam", "set FocusMode to FOCUS_MODE_AUTO");
            localParameters.setFocusMode("auto");
          }
          for (;;)
          {
            localObject2 = localParameters.getSupportedPreviewFormats();
            localObject4 = ((List)localObject2).iterator();
            i = 0;
            if (!((Iterator)localObject4).hasNext()) {
              break label1473;
            }
            j = ((Integer)((Iterator)localObject4).next()).intValue();
            ad.d("MicroMsg.FaceReflectCam", "supportedPreviewFormat: ".concat(String.valueOf(j)));
            if (j != 17) {
              break;
            }
            j = 1;
            if (j == 0) {
              break label1268;
            }
            localParameters.setPreviewFormat(17);
            if (this.rig) {
              localParameters.setRotation(this.rih);
            }
            double d1 = this.rqP.getmAspectRatio();
            ad.d("MicroMsg.FaceReflectCam", "original ratio=".concat(String.valueOf(d1)));
            d2 = this.mDesiredPreviewWidth / this.mDesiredPreviewHeight;
            ad.d("MicroMsg.FaceReflectCam", "new ratio=".concat(String.valueOf(d2)));
            if (d1 != d2) {
              break label1337;
            }
            ad.d("MicroMsg.FaceReflectCam", "NO NEED reset ratio");
            c(localParameters);
            localObject2 = localParameters.getSupportedPreviewFpsRange();
            ad.d("MicroMsg.FaceReflectCam", "range:" + ((List)localObject2).size());
            i = 0;
            if (i >= ((List)localObject2).size()) {
              break label1369;
            }
            localObject4 = (int[])((List)localObject2).get(i);
            j = 0;
            while (j < localObject4.length)
            {
              ad.i("MicroMsg.FaceReflectCam", "Camera SupportedPreviewFpsRange：", new Object[] { Integer.valueOf(localObject4[j]) });
              j += 1;
            }
            ad.i("MicroMsg.FaceReflectCam", "camera not support FOCUS_MODE_AUTO");
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            final double d2;
            ad.e("MicroMsg.FaceReflectCam", "set focus mode error: %s", new Object[] { localException3.getMessage() });
            continue;
            if (j == 842094169) {
              i = 1;
            }
            for (;;)
            {
              break;
              label1268:
              if (i != 0)
              {
                ad.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                localParameters.setPreviewFormat(842094169);
                break label1026;
              }
              ad.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { localException3.get(0) });
              localParameters.setPreviewFormat(((Integer)localException3.get(0)).intValue());
              break label1026;
              label1337:
              ad.d("MicroMsg.FaceReflectCam", "start reset ratio");
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(104287);
                  ad.d("MicroMsg.FaceReflectCam", "reset ratio");
                  int i = b.this.rqP.getContext().getResources().getDisplayMetrics().widthPixels;
                  RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)b.this.rqP.getLayoutParams();
                  localLayoutParams.width = ((int)(i * 0.7D));
                  localLayoutParams.height = ((int)(localLayoutParams.width * d2));
                  localLayoutParams.addRule(13, -1);
                  b.this.rqP.setLayoutParams(localLayoutParams);
                  b.this.rqP.setAspectRatio(d2);
                  ad.d("MicroMsg.FaceReflectCam", "after reset ratio=" + b.this.rqP.getmAspectRatio());
                  AppMethodBeat.o(104287);
                }
              });
              break label1106;
              i += 1;
              break label1149;
              label1369:
              ad.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + localParameters.get("preview-fps-range"));
              ad.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + localParameters.get("preview-frame-rate"));
              try
              {
                this.rqL.setParameters(localParameters);
                bool = this.mIsCameraOpened;
                AppMethodBeat.o(104300);
                return bool;
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  ad.printErrStackTrace("MicroMsg.FaceReflectCam", localException4, "setParameters error", new Object[0]);
                }
              }
            }
            label1473:
            j = 0;
          }
        }
      }
      i = -1;
    }
  }
  
  private void j(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(104297);
    ad.i("MicroMsg.FaceReflectCam", "openCameraForSurfaceTexture");
    if (this.rqV == 1) {
      this.rqO.setVisibility(0);
    }
    for (;;)
    {
      cuu();
      if (this.rqK == null) {
        break;
      }
      this.rqK.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104284);
          g localg;
          if (!b.d(b.this))
          {
            localg = g.yhR;
            if (b.e(b.this) == 1)
            {
              l = 3L;
              localg.idkeyStat(917L, l, 1L, false);
              b.d(b.this);
            }
          }
          else
          {
            localg = g.yhR;
            if (b.e(b.this) != 1) {
              break label105;
            }
          }
          label105:
          for (long l = 2L;; l = 38L)
          {
            localg.idkeyStat(917L, l, 1L, false);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(104283);
                if ((b.f(b.this) == null) || (b.f(b.this).gbd) || (!b.g(b.this)))
                {
                  ad.e("MicroMsg.FaceReflectCam", "camera is null or has released!");
                  AppMethodBeat.o(104283);
                  return;
                }
                if (b.e(b.this) == 1)
                {
                  localObject1 = c.a.cuv();
                  localObject2 = b.h(b.this);
                  localObject3 = b.i(b.this);
                  localObject4 = b.f(b.this);
                  i = b.j(b.this);
                  localObject5 = b.this.rqN;
                  localObject6 = b.k(b.this);
                  localObject7 = b.l(b.this);
                  str1 = b.m(b.this);
                  String str2 = b.n(b.this);
                  j = b.o(b.this);
                  k = b.p(b.this);
                  m = b.q(b.this);
                  Point localPoint = b.r(b.this);
                  ad.i("MicroMsg.FaceReflectLogic", "initPreviewDetect（）");
                  ((c)localObject1).mContext = ((Context)localObject2);
                  ((c)localObject1).rqL = ((v)localObject4);
                  ((c)localObject1).kHi = i;
                  ((c)localObject1).rpm = ((TextView)localObject5);
                  ((c)localObject1).rqX = ((com.tencent.mm.plugin.facedetectlight.ui.a.b)localObject3);
                  ((c)localObject1).rqO = ((FaceReflectMask)localObject6);
                  ((c)localObject1).rrh = j;
                  ((c)localObject1).mDesiredPreviewWidth = k;
                  ((c)localObject1).mDesiredPreviewHeight = m;
                  ((c)localObject1).rri = localPoint;
                  ((c)localObject1).rkt = ((byte[])localObject7);
                  ((c)localObject1).rqR = str1;
                  ((c)localObject1).mAppId = str2;
                  ad.i("MicroMsg.FaceReflectLogic", "mConfig is ".concat(String.valueOf(localObject7)));
                  ad.i("MicroMsg.FaceReflectLogic", "mBioID is " + ((c)localObject1).rqR);
                  ad.i("MicroMsg.FaceReflectLogic", "mAppId is ".concat(String.valueOf(str2)));
                  ((c)localObject1).rpo = new Rect(0, 0, 0, 0);
                  ((c)localObject1).rpp = new Rect(0, 0, 0, 0);
                  ad.i("MicroMsg.FaceReflectLogic", "setFaceRect（）");
                  ((c)localObject1).rrf = ((c)localObject1).mContext.getResources().getDisplayMetrics().widthPixels;
                  ((c)localObject1).rrg = ((c)localObject1).mContext.getResources().getDisplayMetrics().heightPixels;
                  ((c)localObject1).rpp.left = ((int)(((c)localObject1).rrf * 0.15D));
                  ((c)localObject1).rpp.right = ((int)(((c)localObject1).rrf * 0.85D));
                  ((c)localObject1).rpp.top = ((int)(((c)localObject1).rrg * 0.2D));
                  ((c)localObject1).rpp.bottom = ((int)(((c)localObject1).rrg * 0.65D));
                  if (com.tencent.mm.plugin.facedetect.e.a.ctV().rmv) {
                    com.tencent.mm.plugin.facedetect.e.a.ctV().a(((c)localObject1).rrh, ((c)localObject1).mDesiredPreviewWidth, ((c)localObject1).mDesiredPreviewHeight, ((c)localObject1).rri.x, ((c)localObject1).mDesiredPreviewHeight, false);
                  }
                  c.a.cuv();
                  ad.i("MicroMsg.FaceReflectLogic", "initFaceDetect（）");
                  AppMethodBeat.o(104283);
                  return;
                }
                Object localObject2 = a.b.cum();
                Object localObject3 = b.s(b.this).getApplicationContext();
                Object localObject4 = b.s(b.this);
                Object localObject5 = b.f(b.this).gbc;
                int i = b.j(b.this);
                Object localObject6 = b.this.rqN;
                Object localObject7 = b.t(b.this);
                int j = b.o(b.this);
                Object localObject1 = new Point(b.p(b.this), b.q(b.this));
                int k = b.u(b.this);
                String str1 = b.v(b.this);
                int m = b.p(b.this);
                int n = b.q(b.this);
                ad.i("MicroMsg.FaceActionLogic", "initFaceDetect（）");
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mContext = ((Context)localObject3);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mCamera = ((Camera)localObject5);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).kHi = i;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpm = ((TextView)localObject6);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpl = ((FaceActionUI)localObject4);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpn = ((a.a)localObject7);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpj = k;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpk = str1;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mDesiredPreviewWidth = m;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mDesiredPreviewHeight = n;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpo = new Rect(0, 0, 0, 0);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpp = new Rect(0, 0, 0, 0);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpr = true;
                ad.i("MicroMsg.FaceActionLogic", "action：%s,mActionHint:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpj), ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpk });
                if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpk != null) {
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpm.setText(((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpk);
                }
                for (;;)
                {
                  YTPoseDetectInterface.start(((Context)localObject3).getApplicationContext(), (Camera)localObject5, i, new a.1((com.tencent.mm.plugin.facedetectaction.b.a)localObject2));
                  ad.i("MicroMsg.FaceActionLogic", "init face detect, camera, rotate: %s", new Object[] { Integer.valueOf(j) });
                  com.tencent.mm.plugin.facedetectaction.b.d.rpy.huZ = j;
                  localObject2 = com.tencent.mm.plugin.facedetectaction.b.d.rpy;
                  i = ((Point)localObject1).x;
                  j = ((Point)localObject1).y;
                  ((com.tencent.mm.plugin.facedetectaction.b.d)localObject2).rpG = i;
                  ((com.tencent.mm.plugin.facedetectaction.b.d)localObject2).rpH = j;
                  AppMethodBeat.o(104283);
                  return;
                  switch (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpj)
                  {
                  default: 
                    break;
                  case 1: 
                    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpm.setText(2131758677);
                    break;
                  case 2: 
                    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rpm.setText(2131758678);
                  }
                }
              }
            });
            AppMethodBeat.o(104284);
            return;
            l = 39L;
            break;
          }
        }
      });
      this.rqK.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104285);
          try
          {
            b.a(b.this, paramSurfaceTexture);
            b localb = b.this;
            Camera.PreviewCallback localPreviewCallback = b.w(b.this);
            if (localb.rqL == null)
            {
              ad.w("MicroMsg.FaceReflectCam", "hy: camera is null. setPreviewCallback failed");
              AppMethodBeat.o(104285);
              return;
            }
            int j = localb.mDesiredPreviewWidth * localb.mDesiredPreviewHeight * ImageFormat.getBitsPerPixel(localb.rqL.getParameters().getPreviewFormat()) / 8;
            int i = 0;
            while (i < 5)
            {
              byte[] arrayOfByte = com.tencent.mm.plugin.facedetect.model.c.rgZ.g(Integer.valueOf(j));
              localb.rqL.addCallbackBuffer(arrayOfByte);
              i += 1;
            }
            localb.rqL.setPreviewCallbackWithBuffer(new b.9(localb, localPreviewCallback));
            com.tencent.mm.plugin.facedetect.model.d.csO().a(localb.rnD);
            AppMethodBeat.o(104285);
            return;
          }
          catch (Exception localException)
          {
            if (b.e(b.this) == 1)
            {
              b.i(b.this).w(90016, "preview error", aj.getContext().getString(2131764085));
              AppMethodBeat.o(104285);
              return;
            }
            ad.i("MicroMsg.FaceReflectCam", "preview error");
            b.s(b.this).g("camera error", 90016, "preview error", "");
            AppMethodBeat.o(104285);
          }
        }
      });
      AppMethodBeat.o(104297);
      return;
      this.rpY.setVisibility(0);
    }
    ad.i("MicroMsg.FaceReflectCam", "back thread is not running");
    AppMethodBeat.o(104297);
  }
  
  private static boolean j(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104306);
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    ad.d("MicroMsg.FaceReflectCam", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
    if (paramLong / d >= 5.0D)
    {
      AppMethodBeat.o(104306);
      return true;
    }
    AppMethodBeat.o(104306);
    return false;
  }
  
  public final void a(MMTextureView paramMMTextureView)
  {
    AppMethodBeat.i(104296);
    this.rqI = paramMMTextureView;
    if (this.rqI.isAvailable()) {
      j(paramMMTextureView.getSurfaceTexture());
    }
    this.rqI.setSurfaceTextureListener(this);
    this.rqI.setVisibility(0);
    this.rqI.setAlpha(0.0F);
    if ((this.rqV == 2) && (!this.rqU)) {
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104280);
          b.a(b.this).setVisibility(8);
          b.b(b.this).setVisibility(8);
          b.c(b.this);
          AppMethodBeat.o(104280);
        }
      }, 700L);
    }
    AppMethodBeat.o(104296);
  }
  
  public final void awW()
  {
    AppMethodBeat.i(104302);
    ad.i("MicroMsg.FaceReflectCam", "closeCamera start");
    if (this.rqW != null)
    {
      this.rqW.quit();
      this.rqW = null;
    }
    if (this.rqL != null) {}
    try
    {
      if (this.rkX)
      {
        this.rkX = false;
        this.rqL.stopPreview();
        this.rqL.setPreviewCallback(null);
        ad.i("MicroMsg.FaceReflectCam", "stop preview, not previewing");
      }
      try
      {
        this.rqL.release();
        this.rqL = null;
        this.rqL = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException2.getMessage());
          this.rqL = null;
        }
      }
      finally
      {
        this.rqL = null;
        AppMethodBeat.o(104302);
      }
      ad.i("MicroMsg.FaceReflectCam", "closeCamera end");
      AppMethodBeat.o(104302);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ad.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException1.getMessage());
      }
    }
  }
  
  public final void cuu()
  {
    AppMethodBeat.i(104303);
    if (this.rqJ == null)
    {
      ad.i("MicroMsg.FaceReflectCam", "start camera thread");
      this.rqJ = com.tencent.e.c.d.gY("cameraBackground", 5);
      this.rqJ.start();
      this.rqK = new ap(this.rqJ.getLooper());
    }
    AppMethodBeat.o(104303);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104299);
    ad.i("MicroMsg.FaceReflectCam", "onSurfaceTextureAvailable, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    j(paramSurfaceTexture);
    AppMethodBeat.o(104299);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(104298);
    ad.i("MicroMsg.FaceReflectCam", "surfaceDestroyed");
    if (this.rqK != null)
    {
      this.rqK.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104286);
          b.this.awW();
          AppMethodBeat.o(104286);
        }
      });
      if (this.rqJ != null) {
        ad.i("MicroMsg.FaceReflectCam", "stop camera thread");
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(500L, 0);
        if (Build.VERSION.SDK_INT >= 18) {
          this.rqJ.quitSafely();
        }
      }
      catch (InterruptedException paramSurfaceTexture)
      {
        try
        {
          this.rqJ.join();
          this.rqJ = null;
          this.rqK = null;
          ad.i("MicroMsg.FaceReflectCam", "stop camera thread finish");
          AppMethodBeat.o(104298);
          return false;
          paramSurfaceTexture = paramSurfaceTexture;
          ad.i("MicroMsg.FaceReflectCam", "background thread sleep error：" + paramSurfaceTexture.getMessage());
          continue;
          this.rqJ.quit();
          continue;
        }
        catch (InterruptedException paramSurfaceTexture)
        {
          ad.i("MicroMsg.FaceReflectCam", "stop xbackground thread error：" + paramSurfaceTexture.getMessage());
          continue;
        }
      }
      ad.i("MicroMsg.FaceReflectCam", "back thread is not running");
    }
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void stopPreview()
  {
    AppMethodBeat.i(104301);
    ad.i("MicroMsg.FaceReflectCam", "stopPreview, isPreviewing: %s", new Object[] { Boolean.valueOf(this.rqM) });
    if (this.rqL != null)
    {
      this.rqL.stopPreview();
      this.rqM = false;
      com.tencent.mm.plugin.facedetect.model.c.rgZ.ayw();
    }
    AppMethodBeat.o(104301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b
 * JD-Core Version:    0.7.0.1
 */