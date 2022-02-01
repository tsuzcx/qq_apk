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
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  public String fIQ;
  private d.a.a hsD;
  private boolean hsf;
  public String mAppId;
  private Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  private boolean mIsCameraOpened;
  private Point nQL;
  public ImageView nRq;
  private Point rqi;
  private Point rqj;
  private boolean rqk;
  private int rql;
  private Point rqn;
  public byte[] rsx;
  public volatile boolean rtb;
  private Camera.PreviewCallback rvH;
  d.b rvI;
  public int rxn;
  public String rxo;
  private FaceActionUI rxp;
  private a.a rxr;
  private MMTextureView ryX;
  private HandlerThread ryY;
  private aq ryZ;
  public FaceActionMask ryc;
  v rza;
  public volatile boolean rzb;
  public TextView rzc;
  public FaceReflectMask rzd;
  public PreviewFrameLayout rze;
  private int rzf;
  public String rzg;
  public ImageView rzh;
  private Bitmap rzi;
  private boolean rzj;
  private int rzk;
  private aq rzl;
  private com.tencent.mm.plugin.facedetectlight.ui.a.b rzm;
  
  public b(Context paramContext, com.tencent.mm.plugin.facedetectlight.ui.a.b paramb)
  {
    AppMethodBeat.i(104294);
    this.rqi = null;
    this.nQL = null;
    this.rqj = null;
    this.rqn = null;
    this.rzf = 0;
    this.rzl = new aq("mPreviewHandlerThread");
    this.rvI = new d.b()
    {
      public final void bl(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(104293);
        com.tencent.mm.plugin.facedetect.model.c.rpd.k(paramAnonymousArrayOfByte);
        AppMethodBeat.o(104293);
      }
      
      public final com.tencent.mm.memory.a<byte[]> cuq()
      {
        return com.tencent.mm.plugin.facedetect.model.c.rpd;
      }
    };
    this.rvH = new Camera.PreviewCallback()
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
              if ((b.this.rzb) && (b.this.rtb))
              {
                label142:
                int i;
                if (b.e(b.this) == 1)
                {
                  localc = c.a.cvW();
                  localObject2 = paramAnonymousArrayOfByte;
                  localObject3 = paramAnonymousCamera;
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectLogic", "YTAGReflectLiveCheckInterface.getProcessState() : %s ", new Object[] { Integer.valueOf(YTAGReflectLiveCheckInterface.getProcessState()) });
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectLogic", "current state is:%d", new Object[] { Integer.valueOf(localc.mState) });
                  if (localc.mState != 4)
                  {
                    if (YTAGReflectLiveCheckInterface.getProcessState() != 2) {
                      break label142;
                    }
                    YTAGReflectLiveCheckInterface.onPreviewFrame((byte[])localObject2, (Camera)localObject3);
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.facedetect.model.d.cup().bk((byte[])localObject2);
                    AppMethodBeat.o(104281);
                    return;
                    if (YTAGReflectLiveCheckInterface.getProcessState() == 0)
                    {
                      i = 7;
                      if (localc.mContext != null) {
                        i = YTCameraSetting.getRotate(localc.mContext, localc.kKx, 1);
                      }
                      if (PluginFace.isEnabled()) {
                        localObject1 = YTFaceTrack.getInstance().DoDetectionProcessYUV((byte[])localObject2, localc.mDesiredPreviewWidth, localc.mDesiredPreviewHeight, i, null);
                      }
                      if (localObject1 != null)
                      {
                        ar.f(new c.2(localc, localObject1[0]));
                      }
                      else
                      {
                        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectLogic", "Detecting result：ADVISE_NO_FACE --- faceStatuses is null");
                        ar.f(new c.3(localc));
                      }
                    }
                  }
                }
                Object localObject2 = a.b.cvN();
                Object localObject3 = paramAnonymousArrayOfByte;
                Camera localCamera = paramAnonymousCamera;
                if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxv)
                {
                  i = YTCameraSetting.getRotate(((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mContext, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).kKx, 1);
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
                        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
                        ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxq.setText(2131758750);
                        AppMethodBeat.o(104281);
                        return;
                      }
                      YTFaceUtils.shelterJudge(((YTFaceTrack.FaceStatus)localObject1).pointsVis);
                      if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxu != null) {
                        YTPoseDetectInterface.poseDetect(((YTFaceTrack.FaceStatus)localObject1).xys, ((YTFaceTrack.FaceStatus)localObject1).pointsVis, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxn, (byte[])localObject3, localCamera, ((YTFaceTrack.FaceStatus)localObject1).pitch, ((YTFaceTrack.FaceStatus)localObject1).yaw, ((YTFaceTrack.FaceStatus)localObject1).roll, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxu, 0);
                      }
                    }
                    AppMethodBeat.o(104281);
                    return;
                  }
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceActionLogic", "No face");
                }
              }
              AppMethodBeat.o(104281);
            }
          });
        }
        AppMethodBeat.o(104282);
      }
    };
    this.rzm = paramb;
    this.rzk = 1;
    this.mContext = paramContext;
    this.mIsCameraOpened = false;
    this.rtb = false;
    this.ryY = null;
    this.mIsCameraOpened = false;
    AppMethodBeat.o(104294);
  }
  
  public b(FaceActionUI paramFaceActionUI, a.a parama)
  {
    AppMethodBeat.i(104295);
    this.rqi = null;
    this.nQL = null;
    this.rqj = null;
    this.rqn = null;
    this.rzf = 0;
    this.rzl = new aq("mPreviewHandlerThread");
    this.rvI = new d.b()
    {
      public final void bl(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(104293);
        com.tencent.mm.plugin.facedetect.model.c.rpd.k(paramAnonymousArrayOfByte);
        AppMethodBeat.o(104293);
      }
      
      public final com.tencent.mm.memory.a<byte[]> cuq()
      {
        return com.tencent.mm.plugin.facedetect.model.c.rpd;
      }
    };
    this.rvH = new Camera.PreviewCallback()
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
              if ((b.this.rzb) && (b.this.rtb))
              {
                label142:
                int i;
                if (b.e(b.this) == 1)
                {
                  localc = c.a.cvW();
                  localObject2 = paramAnonymousArrayOfByte;
                  localObject3 = paramAnonymousCamera;
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectLogic", "YTAGReflectLiveCheckInterface.getProcessState() : %s ", new Object[] { Integer.valueOf(YTAGReflectLiveCheckInterface.getProcessState()) });
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectLogic", "current state is:%d", new Object[] { Integer.valueOf(localc.mState) });
                  if (localc.mState != 4)
                  {
                    if (YTAGReflectLiveCheckInterface.getProcessState() != 2) {
                      break label142;
                    }
                    YTAGReflectLiveCheckInterface.onPreviewFrame((byte[])localObject2, (Camera)localObject3);
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.facedetect.model.d.cup().bk((byte[])localObject2);
                    AppMethodBeat.o(104281);
                    return;
                    if (YTAGReflectLiveCheckInterface.getProcessState() == 0)
                    {
                      i = 7;
                      if (localc.mContext != null) {
                        i = YTCameraSetting.getRotate(localc.mContext, localc.kKx, 1);
                      }
                      if (PluginFace.isEnabled()) {
                        localObject1 = YTFaceTrack.getInstance().DoDetectionProcessYUV((byte[])localObject2, localc.mDesiredPreviewWidth, localc.mDesiredPreviewHeight, i, null);
                      }
                      if (localObject1 != null)
                      {
                        ar.f(new c.2(localc, localObject1[0]));
                      }
                      else
                      {
                        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectLogic", "Detecting result：ADVISE_NO_FACE --- faceStatuses is null");
                        ar.f(new c.3(localc));
                      }
                    }
                  }
                }
                Object localObject2 = a.b.cvN();
                Object localObject3 = paramAnonymousArrayOfByte;
                Camera localCamera = paramAnonymousCamera;
                if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxv)
                {
                  i = YTCameraSetting.getRotate(((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mContext, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).kKx, 1);
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
                        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
                        ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxq.setText(2131758750);
                        AppMethodBeat.o(104281);
                        return;
                      }
                      YTFaceUtils.shelterJudge(((YTFaceTrack.FaceStatus)localObject1).pointsVis);
                      if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxu != null) {
                        YTPoseDetectInterface.poseDetect(((YTFaceTrack.FaceStatus)localObject1).xys, ((YTFaceTrack.FaceStatus)localObject1).pointsVis, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxn, (byte[])localObject3, localCamera, ((YTFaceTrack.FaceStatus)localObject1).pitch, ((YTFaceTrack.FaceStatus)localObject1).yaw, ((YTFaceTrack.FaceStatus)localObject1).roll, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxu, 0);
                      }
                    }
                    AppMethodBeat.o(104281);
                    return;
                  }
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceActionLogic", "No face");
                }
              }
              AppMethodBeat.o(104281);
            }
          });
        }
        AppMethodBeat.o(104282);
      }
    };
    this.rzk = 2;
    this.rxp = paramFaceActionUI;
    this.mIsCameraOpened = false;
    this.rtb = false;
    this.ryY = null;
    this.mIsCameraOpened = false;
    this.rzj = false;
    this.rxr = parama;
    AppMethodBeat.o(104295);
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(104304);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new b.a((byte)0));
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    long l = bu.jk(ak.getContext());
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(l) });
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!j(k, m, l))) {
            break label364;
          }
          paramParameters = new Point(i, j);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        if (paramParameters == null) {
          break label534;
        }
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "No suitable preview sizes, using default: ".concat(String.valueOf(paramPoint)));
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "Found best approximate preview size: ".concat(String.valueOf(paramPoint)));
        AppMethodBeat.o(104304);
        return paramPoint;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceReflectCam", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  private static void c(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(104305);
    if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaz > 0)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "set frame rate > 0, do not try set preview fps range");
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(30) });
      if ((j == 2147483647) || (i == 2147483647))
      {
        AppMethodBeat.o(104305);
        return;
      }
      try
      {
        paramParameters.setPreviewFpsRange(j, i);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(104305);
        return;
      }
      catch (Exception paramParameters)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
        AppMethodBeat.o(104305);
        return;
      }
      label391:
      k = n;
      i = i2;
      j = i1;
    }
  }
  
  private boolean cvU()
  {
    AppMethodBeat.i(104300);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "start open camera");
    this.mIsCameraOpened = false;
    this.hsf = true;
    int j = Camera.getNumberOfCameras();
    int i = 0;
    Object localObject1;
    if (i < j)
    {
      localObject1 = new Camera.CameraInfo();
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject1);
      if ((((Camera.CameraInfo)localObject1).facing == 1) && (this.hsf)) {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
      }
    }
    for (;;)
    {
      if (i == -1)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "not found available camera id");
        AppMethodBeat.o(104300);
        return false;
        if ((((Camera.CameraInfo)localObject1).facing == 0) && (!this.hsf))
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
          continue;
        }
        i += 1;
        break;
      }
      long l = bu.HQ();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "openCameraRes：" + this.hsD);
      if (this.hsD == null)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "openCameraRes is null");
        if (this.rzk != 1) {
          break label290;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "mFaceReflectController openCameraRe");
      }
      for (;;)
      {
        try
        {
          this.hsD = com.tencent.mm.compatible.deviceinfo.d.a(this.mContext, i, null);
          if (this.hsD != null) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "in open(), openCameraRes == null");
          try
          {
            localObject1 = new IOException();
            AppMethodBeat.o(104300);
            throw ((Throwable)localObject1);
          }
          catch (IOException localIOException1)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "set cameraRes exception" + localIOException1.getMessage());
            AppMethodBeat.o(104300);
            return false;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "mFaceActionUI openCameraRe");
        }
        catch (Exception localException1)
        {
          AppMethodBeat.o(104300);
          return false;
        }
        label290:
        this.hsD = com.tencent.mm.compatible.deviceinfo.d.a(this.rxp.getContext(), i, null);
      }
      this.rzf = i;
      this.mIsCameraOpened = true;
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(bu.aO(l)) });
      this.rql = this.hsD.dHi;
      boolean bool;
      if (this.hsD.dHi % 180 != 0)
      {
        bool = true;
        this.rqk = bool;
        this.rza = this.hsD.gaZ;
        if (this.rza == null)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceReflectCam", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.rqk) });
          try
          {
            IOException localIOException2 = new IOException();
            AppMethodBeat.o(104300);
            throw localIOException2;
          }
          catch (IOException localIOException3)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "set cameraRotation exception" + localIOException3.getMessage());
          }
        }
      }
      Camera.Parameters localParameters;
      for (;;)
      {
        try
        {
          localParameters = this.rza.getParameters();
          if (this.rzk != 1) {
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
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.FaceReflectCam", localException2, "camera getParameters error: %s", new Object[] { localException2.getMessage() });
          AppMethodBeat.o(104300);
          return false;
        }
        bool = false;
        break;
        label578:
        j = this.rxp.getResources().getDisplayMetrics().widthPixels;
        i = this.rxp.getResources().getDisplayMetrics().heightPixels;
      }
      label611:
      this.nQL = new Point(j, i);
      Point localPoint2 = this.nQL;
      Point localPoint1 = this.rqj;
      Object localObject4 = localParameters.get("preview-size-values");
      Object localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = localParameters.get("preview-size-value");
      }
      if (localObject2 != null) {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "preview-size-values parameter: ".concat(String.valueOf(localObject2)));
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
        this.rqi = ((Point)localObject4);
        this.rqn = new Point(this.rqi);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "getCameraResolution: " + this.nQL + " camera:" + this.rqi + "bestVideoEncodeSize: " + this.rqn);
        this.mDesiredPreviewWidth = this.rqi.x;
        this.mDesiredPreviewHeight = this.rqi.y;
        localParameters.setPreviewSize(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceReflectCam", "mDesiredPreviewWidth：" + this.mDesiredPreviewWidth);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceReflectCam", "mDesiredPreviewHeight：" + this.mDesiredPreviewHeight);
        localParameters.setZoom(0);
        localParameters.setSceneMode("auto");
        try
        {
          if ((localParameters.getSupportedFocusModes() != null) && (localParameters.getSupportedFocusModes().contains("auto")))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "set FocusMode to FOCUS_MODE_AUTO");
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
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "supportedPreviewFormat: ".concat(String.valueOf(j)));
            if (j != 17) {
              break;
            }
            j = 1;
            if (j == 0) {
              break label1268;
            }
            localParameters.setPreviewFormat(17);
            if (this.rqk) {
              localParameters.setRotation(this.rql);
            }
            double d1 = this.rze.getmAspectRatio();
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "original ratio=".concat(String.valueOf(d1)));
            d2 = this.mDesiredPreviewWidth / this.mDesiredPreviewHeight;
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "new ratio=".concat(String.valueOf(d2)));
            if (d1 != d2) {
              break label1337;
            }
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "NO NEED reset ratio");
            c(localParameters);
            localObject2 = localParameters.getSupportedPreviewFpsRange();
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "range:" + ((List)localObject2).size());
            i = 0;
            if (i >= ((List)localObject2).size()) {
              break label1369;
            }
            localObject4 = (int[])((List)localObject2).get(i);
            j = 0;
            while (j < localObject4.length)
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "Camera SupportedPreviewFpsRange：", new Object[] { Integer.valueOf(localObject4[j]) });
              j += 1;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "camera not support FOCUS_MODE_AUTO");
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            final double d2;
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceReflectCam", "set focus mode error: %s", new Object[] { localException3.getMessage() });
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
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                localParameters.setPreviewFormat(842094169);
                break label1026;
              }
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { localException3.get(0) });
              localParameters.setPreviewFormat(((Integer)localException3.get(0)).intValue());
              break label1026;
              label1337:
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "start reset ratio");
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(104287);
                  com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "reset ratio");
                  int i = b.this.rze.getContext().getResources().getDisplayMetrics().widthPixels;
                  RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)b.this.rze.getLayoutParams();
                  localLayoutParams.width = ((int)(i * 0.7D));
                  localLayoutParams.height = ((int)(localLayoutParams.width * d2));
                  localLayoutParams.addRule(13, -1);
                  b.this.rze.setLayoutParams(localLayoutParams);
                  b.this.rze.setAspectRatio(d2);
                  com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "after reset ratio=" + b.this.rze.getmAspectRatio());
                  AppMethodBeat.o(104287);
                }
              });
              break label1106;
              i += 1;
              break label1149;
              label1369:
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + localParameters.get("preview-fps-range"));
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + localParameters.get("preview-frame-rate"));
              try
              {
                this.rza.setParameters(localParameters);
                bool = this.mIsCameraOpened;
                AppMethodBeat.o(104300);
                return bool;
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.FaceReflectCam", localException4, "setParameters error", new Object[0]);
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "openCameraForSurfaceTexture");
    if (this.rzk == 1) {
      this.rzd.setVisibility(0);
    }
    for (;;)
    {
      cvV();
      if (this.ryZ == null) {
        break;
      }
      this.ryZ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104284);
          g localg;
          if (!b.d(b.this))
          {
            localg = g.yxI;
            if (b.e(b.this) == 1)
            {
              l = 3L;
              localg.idkeyStat(917L, l, 1L, false);
              b.d(b.this);
            }
          }
          else
          {
            localg = g.yxI;
            if (b.e(b.this) != 1) {
              break label105;
            }
          }
          label105:
          for (long l = 2L;; l = 38L)
          {
            localg.idkeyStat(917L, l, 1L, false);
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(104283);
                if ((b.f(b.this) == null) || (b.f(b.this).gdl) || (!b.g(b.this)))
                {
                  com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FaceReflectCam", "camera is null or has released!");
                  AppMethodBeat.o(104283);
                  return;
                }
                if (b.e(b.this) == 1)
                {
                  localObject1 = c.a.cvW();
                  localObject2 = b.h(b.this);
                  localObject3 = b.i(b.this);
                  localObject4 = b.f(b.this);
                  i = b.j(b.this);
                  localObject5 = b.this.rzc;
                  localObject6 = b.k(b.this);
                  localObject7 = b.l(b.this);
                  str1 = b.m(b.this);
                  String str2 = b.n(b.this);
                  j = b.o(b.this);
                  k = b.p(b.this);
                  m = b.q(b.this);
                  Point localPoint = b.r(b.this);
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectLogic", "initPreviewDetect（）");
                  ((c)localObject1).mContext = ((Context)localObject2);
                  ((c)localObject1).rza = ((v)localObject4);
                  ((c)localObject1).kKx = i;
                  ((c)localObject1).rxq = ((TextView)localObject5);
                  ((c)localObject1).rzm = ((com.tencent.mm.plugin.facedetectlight.ui.a.b)localObject3);
                  ((c)localObject1).rzd = ((FaceReflectMask)localObject6);
                  ((c)localObject1).rzw = j;
                  ((c)localObject1).mDesiredPreviewWidth = k;
                  ((c)localObject1).mDesiredPreviewHeight = m;
                  ((c)localObject1).rzx = localPoint;
                  ((c)localObject1).rsx = ((byte[])localObject7);
                  ((c)localObject1).rzg = str1;
                  ((c)localObject1).mAppId = str2;
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectLogic", "mConfig is ".concat(String.valueOf(localObject7)));
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectLogic", "mBioID is " + ((c)localObject1).rzg);
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectLogic", "mAppId is ".concat(String.valueOf(str2)));
                  ((c)localObject1).rxs = new Rect(0, 0, 0, 0);
                  ((c)localObject1).rxt = new Rect(0, 0, 0, 0);
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectLogic", "setFaceRect（）");
                  ((c)localObject1).rzu = ((c)localObject1).mContext.getResources().getDisplayMetrics().widthPixels;
                  ((c)localObject1).rzv = ((c)localObject1).mContext.getResources().getDisplayMetrics().heightPixels;
                  ((c)localObject1).rxt.left = ((int)(((c)localObject1).rzu * 0.15D));
                  ((c)localObject1).rxt.right = ((int)(((c)localObject1).rzu * 0.85D));
                  ((c)localObject1).rxt.top = ((int)(((c)localObject1).rzv * 0.2D));
                  ((c)localObject1).rxt.bottom = ((int)(((c)localObject1).rzv * 0.65D));
                  if (com.tencent.mm.plugin.facedetect.e.a.cvw().ruA) {
                    com.tencent.mm.plugin.facedetect.e.a.cvw().a(((c)localObject1).rzw, ((c)localObject1).mDesiredPreviewWidth, ((c)localObject1).mDesiredPreviewHeight, ((c)localObject1).rzx.x, ((c)localObject1).mDesiredPreviewHeight, false);
                  }
                  c.a.cvW();
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectLogic", "initFaceDetect（）");
                  AppMethodBeat.o(104283);
                  return;
                }
                Object localObject2 = a.b.cvN();
                Object localObject3 = b.s(b.this).getApplicationContext();
                Object localObject4 = b.s(b.this);
                Object localObject5 = b.f(b.this).gdk;
                int i = b.j(b.this);
                Object localObject6 = b.this.rzc;
                Object localObject7 = b.t(b.this);
                int j = b.o(b.this);
                Object localObject1 = new Point(b.p(b.this), b.q(b.this));
                int k = b.u(b.this);
                String str1 = b.v(b.this);
                int m = b.p(b.this);
                int n = b.q(b.this);
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceActionLogic", "initFaceDetect（）");
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mContext = ((Context)localObject3);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mCamera = ((Camera)localObject5);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).kKx = i;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxq = ((TextView)localObject6);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxp = ((FaceActionUI)localObject4);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxr = ((a.a)localObject7);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxn = k;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxo = str1;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mDesiredPreviewWidth = m;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mDesiredPreviewHeight = n;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxs = new Rect(0, 0, 0, 0);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxt = new Rect(0, 0, 0, 0);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxv = true;
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceActionLogic", "action：%s,mActionHint:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxn), ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxo });
                if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxo != null) {
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxq.setText(((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxo);
                }
                for (;;)
                {
                  YTPoseDetectInterface.start(((Context)localObject3).getApplicationContext(), (Camera)localObject5, i, new a.1((com.tencent.mm.plugin.facedetectaction.b.a)localObject2));
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceActionLogic", "init face detect, camera, rotate: %s", new Object[] { Integer.valueOf(j) });
                  com.tencent.mm.plugin.facedetectaction.b.d.rxC.hxN = j;
                  localObject2 = com.tencent.mm.plugin.facedetectaction.b.d.rxC;
                  i = ((Point)localObject1).x;
                  j = ((Point)localObject1).y;
                  ((com.tencent.mm.plugin.facedetectaction.b.d)localObject2).rxK = i;
                  ((com.tencent.mm.plugin.facedetectaction.b.d)localObject2).rxL = j;
                  AppMethodBeat.o(104283);
                  return;
                  switch (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxn)
                  {
                  default: 
                    break;
                  case 1: 
                    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxq.setText(2131758677);
                    break;
                  case 2: 
                    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).rxq.setText(2131758678);
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
      this.ryZ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104285);
          try
          {
            b.a(b.this, paramSurfaceTexture);
            b localb = b.this;
            Camera.PreviewCallback localPreviewCallback = b.w(b.this);
            if (localb.rza == null)
            {
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.FaceReflectCam", "hy: camera is null. setPreviewCallback failed");
              AppMethodBeat.o(104285);
              return;
            }
            int j = localb.mDesiredPreviewWidth * localb.mDesiredPreviewHeight * ImageFormat.getBitsPerPixel(localb.rza.getParameters().getPreviewFormat()) / 8;
            int i = 0;
            while (i < 5)
            {
              byte[] arrayOfByte = com.tencent.mm.plugin.facedetect.model.c.rpd.h(Integer.valueOf(j));
              localb.rza.addCallbackBuffer(arrayOfByte);
              i += 1;
            }
            localb.rza.setPreviewCallbackWithBuffer(new b.9(localb, localPreviewCallback));
            com.tencent.mm.plugin.facedetect.model.d.cup().a(localb.rvI);
            AppMethodBeat.o(104285);
            return;
          }
          catch (Exception localException)
          {
            if (b.e(b.this) == 1)
            {
              b.i(b.this).w(90016, "preview error", ak.getContext().getString(2131764085));
              AppMethodBeat.o(104285);
              return;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "preview error");
            b.s(b.this).g("camera error", 90016, "preview error", "");
            AppMethodBeat.o(104285);
          }
        }
      });
      AppMethodBeat.o(104297);
      return;
      this.ryc.setVisibility(0);
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "back thread is not running");
    AppMethodBeat.o(104297);
  }
  
  private static boolean j(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104306);
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.FaceReflectCam", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
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
    this.ryX = paramMMTextureView;
    if (this.ryX.isAvailable()) {
      j(paramMMTextureView.getSurfaceTexture());
    }
    this.ryX.setSurfaceTextureListener(this);
    this.ryX.setVisibility(0);
    this.ryX.setAlpha(0.0F);
    if ((this.rzk == 2) && (!this.rzj)) {
      ar.o(new Runnable()
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
  
  public final void axl()
  {
    AppMethodBeat.i(104302);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "closeCamera start");
    if (this.rzl != null)
    {
      this.rzl.quit();
      this.rzl = null;
    }
    if (this.rza != null) {}
    try
    {
      if (this.rtb)
      {
        this.rtb = false;
        this.rza.stopPreview();
        this.rza.setPreviewCallback(null);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "stop preview, not previewing");
      }
      try
      {
        this.rza.release();
        this.rza = null;
        this.rza = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException2.getMessage());
          this.rza = null;
        }
      }
      finally
      {
        this.rza = null;
        AppMethodBeat.o(104302);
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "closeCamera end");
      AppMethodBeat.o(104302);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException1.getMessage());
      }
    }
  }
  
  public final void cvV()
  {
    AppMethodBeat.i(104303);
    if (this.ryY == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "start camera thread");
      this.ryY = com.tencent.e.c.d.hh("cameraBackground", 5);
      this.ryY.start();
      this.ryZ = new aq(this.ryY.getLooper());
    }
    AppMethodBeat.o(104303);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104299);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "onSurfaceTextureAvailable, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    j(paramSurfaceTexture);
    AppMethodBeat.o(104299);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(104298);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "surfaceDestroyed");
    if (this.ryZ != null)
    {
      this.ryZ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104286);
          b.this.axl();
          AppMethodBeat.o(104286);
        }
      });
      if (this.ryY != null) {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "stop camera thread");
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(500L, 0);
        if (Build.VERSION.SDK_INT >= 18) {
          this.ryY.quitSafely();
        }
      }
      catch (InterruptedException paramSurfaceTexture)
      {
        try
        {
          this.ryY.join();
          this.ryY = null;
          this.ryZ = null;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "stop camera thread finish");
          AppMethodBeat.o(104298);
          return false;
          paramSurfaceTexture = paramSurfaceTexture;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "background thread sleep error：" + paramSurfaceTexture.getMessage());
          continue;
          this.ryY.quit();
          continue;
        }
        catch (InterruptedException paramSurfaceTexture)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "stop xbackground thread error：" + paramSurfaceTexture.getMessage());
          continue;
        }
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "back thread is not running");
    }
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void stopPreview()
  {
    AppMethodBeat.i(104301);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FaceReflectCam", "stopPreview ,isPreview %s camera:%s", new Object[] { Boolean.valueOf(this.rzb), this.rza });
    if (this.rza != null)
    {
      this.rzb = false;
      this.rza.stopPreview();
      this.rza.setPreviewCallback(null);
      this.rzl.removeCallbacksAndMessages(null);
      com.tencent.mm.plugin.facedetect.model.c.rpd.ayL();
    }
    AppMethodBeat.o(104301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b
 * JD-Core Version:    0.7.0.1
 */