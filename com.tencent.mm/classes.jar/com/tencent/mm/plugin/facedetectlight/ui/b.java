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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  public String foE;
  private d.a.a gXJ;
  private boolean gXl;
  public String mAppId;
  private Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  private boolean mIsCameraOpened;
  private Point nkL;
  public ImageView nle;
  public byte[] qAD;
  public boolean qBh;
  private Camera.PreviewCallback qDM;
  d.b qDN;
  public int qFr;
  public String qFs;
  private FaceActionUI qFt;
  private a.a qFv;
  private MMTextureView qGJ;
  private HandlerThread qGK;
  private ao qGL;
  v qGM;
  public boolean qGN;
  public TextView qGO;
  public FaceReflectMask qGP;
  public PreviewFrameLayout qGQ;
  private int qGR;
  public String qGS;
  public ImageView qGT;
  private Bitmap qGU;
  private boolean qGV;
  private int qGW;
  private ao qGX;
  private com.tencent.mm.plugin.facedetectlight.ui.a.b qGY;
  public FaceActionMask qGf;
  private Point qyo;
  private Point qyp;
  private boolean qyq;
  private int qyr;
  private Point qyt;
  
  public b(Context paramContext, com.tencent.mm.plugin.facedetectlight.ui.a.b paramb)
  {
    AppMethodBeat.i(104294);
    this.qyo = null;
    this.nkL = null;
    this.qyp = null;
    this.qyt = null;
    this.qGR = 0;
    this.qGX = new ao("mPreviewHandlerThread");
    this.qDN = new d.b()
    {
      public final void bj(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(104293);
        com.tencent.mm.plugin.facedetect.model.c.qxj.k(paramAnonymousArrayOfByte);
        AppMethodBeat.o(104293);
      }
      
      public final com.tencent.mm.memory.a<byte[]> cnk()
      {
        return com.tencent.mm.plugin.facedetect.model.c.qxj;
      }
    };
    this.qDM = new Camera.PreviewCallback()
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
              if (b.this.qGN)
              {
                label129:
                int i;
                if (b.e(b.this) == 1)
                {
                  localc = c.a.coQ();
                  localObject2 = paramAnonymousArrayOfByte;
                  localObject3 = paramAnonymousCamera;
                  ac.i("MicroMsg.FaceReflectLogic", "YTAGReflectLiveCheckInterface.getProcessState() : %s ", new Object[] { Integer.valueOf(YTAGReflectLiveCheckInterface.getProcessState()) });
                  ac.i("MicroMsg.FaceReflectLogic", "current state is:%d", new Object[] { Integer.valueOf(localc.mState) });
                  if (localc.mState != 4)
                  {
                    if (YTAGReflectLiveCheckInterface.getProcessState() != 2) {
                      break label129;
                    }
                    YTAGReflectLiveCheckInterface.onPreviewFrame((byte[])localObject2, (Camera)localObject3);
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.facedetect.model.d.cnj().bi((byte[])localObject2);
                    AppMethodBeat.o(104281);
                    return;
                    if (YTAGReflectLiveCheckInterface.getProcessState() == 0)
                    {
                      i = 7;
                      if (localc.mContext != null) {
                        i = YTCameraSetting.getRotate(localc.mContext, localc.kmi, 1);
                      }
                      if (PluginFace.isEnabled()) {
                        localObject1 = YTFaceTrack.getInstance().DoDetectionProcessYUV((byte[])localObject2, localc.mDesiredPreviewWidth, localc.mDesiredPreviewHeight, i, null);
                      }
                      if (localObject1 != null)
                      {
                        ap.f(new c.2(localc, localObject1[0]));
                      }
                      else
                      {
                        ac.i("MicroMsg.FaceReflectLogic", "Detecting result：ADVISE_NO_FACE --- faceStatuses is null");
                        ap.f(new c.3(localc));
                      }
                    }
                  }
                }
                Object localObject2 = a.b.coH();
                Object localObject3 = paramAnonymousArrayOfByte;
                Camera localCamera = paramAnonymousCamera;
                if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFz)
                {
                  i = YTCameraSetting.getRotate(((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mContext, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).kmi, 1);
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
                        ac.i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
                        ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFu.setText(2131758750);
                        AppMethodBeat.o(104281);
                        return;
                      }
                      YTFaceUtils.shelterJudge(((YTFaceTrack.FaceStatus)localObject1).pointsVis);
                      if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFy != null) {
                        YTPoseDetectInterface.poseDetect(((YTFaceTrack.FaceStatus)localObject1).xys, ((YTFaceTrack.FaceStatus)localObject1).pointsVis, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFr, (byte[])localObject3, localCamera, ((YTFaceTrack.FaceStatus)localObject1).pitch, ((YTFaceTrack.FaceStatus)localObject1).yaw, ((YTFaceTrack.FaceStatus)localObject1).roll, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFy);
                      }
                    }
                    AppMethodBeat.o(104281);
                    return;
                  }
                  ac.i("MicroMsg.FaceActionLogic", "No face");
                }
              }
              AppMethodBeat.o(104281);
            }
          });
        }
        AppMethodBeat.o(104282);
      }
    };
    this.qGY = paramb;
    this.qGW = 1;
    this.mContext = paramContext;
    this.mIsCameraOpened = false;
    this.qBh = false;
    this.qGK = null;
    this.mIsCameraOpened = false;
    AppMethodBeat.o(104294);
  }
  
  public b(FaceActionUI paramFaceActionUI, a.a parama)
  {
    AppMethodBeat.i(104295);
    this.qyo = null;
    this.nkL = null;
    this.qyp = null;
    this.qyt = null;
    this.qGR = 0;
    this.qGX = new ao("mPreviewHandlerThread");
    this.qDN = new d.b()
    {
      public final void bj(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(104293);
        com.tencent.mm.plugin.facedetect.model.c.qxj.k(paramAnonymousArrayOfByte);
        AppMethodBeat.o(104293);
      }
      
      public final com.tencent.mm.memory.a<byte[]> cnk()
      {
        return com.tencent.mm.plugin.facedetect.model.c.qxj;
      }
    };
    this.qDM = new Camera.PreviewCallback()
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
              if (b.this.qGN)
              {
                label129:
                int i;
                if (b.e(b.this) == 1)
                {
                  localc = c.a.coQ();
                  localObject2 = paramAnonymousArrayOfByte;
                  localObject3 = paramAnonymousCamera;
                  ac.i("MicroMsg.FaceReflectLogic", "YTAGReflectLiveCheckInterface.getProcessState() : %s ", new Object[] { Integer.valueOf(YTAGReflectLiveCheckInterface.getProcessState()) });
                  ac.i("MicroMsg.FaceReflectLogic", "current state is:%d", new Object[] { Integer.valueOf(localc.mState) });
                  if (localc.mState != 4)
                  {
                    if (YTAGReflectLiveCheckInterface.getProcessState() != 2) {
                      break label129;
                    }
                    YTAGReflectLiveCheckInterface.onPreviewFrame((byte[])localObject2, (Camera)localObject3);
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.facedetect.model.d.cnj().bi((byte[])localObject2);
                    AppMethodBeat.o(104281);
                    return;
                    if (YTAGReflectLiveCheckInterface.getProcessState() == 0)
                    {
                      i = 7;
                      if (localc.mContext != null) {
                        i = YTCameraSetting.getRotate(localc.mContext, localc.kmi, 1);
                      }
                      if (PluginFace.isEnabled()) {
                        localObject1 = YTFaceTrack.getInstance().DoDetectionProcessYUV((byte[])localObject2, localc.mDesiredPreviewWidth, localc.mDesiredPreviewHeight, i, null);
                      }
                      if (localObject1 != null)
                      {
                        ap.f(new c.2(localc, localObject1[0]));
                      }
                      else
                      {
                        ac.i("MicroMsg.FaceReflectLogic", "Detecting result：ADVISE_NO_FACE --- faceStatuses is null");
                        ap.f(new c.3(localc));
                      }
                    }
                  }
                }
                Object localObject2 = a.b.coH();
                Object localObject3 = paramAnonymousArrayOfByte;
                Camera localCamera = paramAnonymousCamera;
                if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFz)
                {
                  i = YTCameraSetting.getRotate(((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mContext, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).kmi, 1);
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
                        ac.i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
                        ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFu.setText(2131758750);
                        AppMethodBeat.o(104281);
                        return;
                      }
                      YTFaceUtils.shelterJudge(((YTFaceTrack.FaceStatus)localObject1).pointsVis);
                      if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFy != null) {
                        YTPoseDetectInterface.poseDetect(((YTFaceTrack.FaceStatus)localObject1).xys, ((YTFaceTrack.FaceStatus)localObject1).pointsVis, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFr, (byte[])localObject3, localCamera, ((YTFaceTrack.FaceStatus)localObject1).pitch, ((YTFaceTrack.FaceStatus)localObject1).yaw, ((YTFaceTrack.FaceStatus)localObject1).roll, ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFy);
                      }
                    }
                    AppMethodBeat.o(104281);
                    return;
                  }
                  ac.i("MicroMsg.FaceActionLogic", "No face");
                }
              }
              AppMethodBeat.o(104281);
            }
          });
        }
        AppMethodBeat.o(104282);
      }
    };
    this.qGW = 2;
    this.qFt = paramFaceActionUI;
    this.mIsCameraOpened = false;
    this.qBh = false;
    this.qGK = null;
    this.mIsCameraOpened = false;
    this.qGV = false;
    this.qFv = parama;
    AppMethodBeat.o(104295);
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(104304);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new b.a((byte)0));
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    ac.d("MicroMsg.FaceReflectCam", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    long l = bs.iU(ai.getContext());
    ac.d("MicroMsg.FaceReflectCam", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(l) });
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
      ac.i("MicroMsg.FaceReflectCam", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
          ac.d("MicroMsg.FaceReflectCam", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!i(k, m, l))) {
            break label364;
          }
          paramParameters = new Point(i, j);
          ac.i("MicroMsg.FaceReflectCam", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
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
          if ((f2 >= f1) || (!i(i, j, l))) {
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
      ac.i("MicroMsg.FaceReflectCam", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        if (paramParameters == null) {
          break label534;
        }
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        ac.i("MicroMsg.FaceReflectCam", "No suitable preview sizes, using default: ".concat(String.valueOf(paramPoint)));
      }
      for (;;)
      {
        ac.i("MicroMsg.FaceReflectCam", "Found best approximate preview size: ".concat(String.valueOf(paramPoint)));
        AppMethodBeat.o(104304);
        return paramPoint;
        ac.e("MicroMsg.FaceReflectCam", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  private boolean coO()
  {
    AppMethodBeat.i(104300);
    ac.i("MicroMsg.FaceReflectCam", "start open camera");
    this.mIsCameraOpened = false;
    this.gXl = true;
    int j = Camera.getNumberOfCameras();
    int i = 0;
    Object localObject1;
    if (i < j)
    {
      localObject1 = new Camera.CameraInfo();
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject1);
      if ((((Camera.CameraInfo)localObject1).facing == 1) && (this.gXl)) {
        ac.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
      }
    }
    for (;;)
    {
      if (i == -1)
      {
        ac.i("MicroMsg.FaceReflectCam", "not found available camera id");
        AppMethodBeat.o(104300);
        return false;
        if ((((Camera.CameraInfo)localObject1).facing == 0) && (!this.gXl))
        {
          ac.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
          continue;
        }
        i += 1;
        break;
      }
      long l = bs.Gn();
      ac.i("MicroMsg.FaceReflectCam", "openCameraRes：" + this.gXJ);
      if (this.gXJ == null)
      {
        ac.i("MicroMsg.FaceReflectCam", "openCameraRes is null");
        if (this.qGW != 1) {
          break label290;
        }
        ac.i("MicroMsg.FaceReflectCam", "mFaceReflectController openCameraRe");
      }
      for (;;)
      {
        try
        {
          this.gXJ = com.tencent.mm.compatible.deviceinfo.d.a(this.mContext, i, null);
          if (this.gXJ != null) {
            break;
          }
          ac.i("MicroMsg.FaceReflectCam", "in open(), openCameraRes == null");
          try
          {
            localObject1 = new IOException();
            AppMethodBeat.o(104300);
            throw ((Throwable)localObject1);
          }
          catch (IOException localIOException1)
          {
            ac.i("MicroMsg.FaceReflectCam", "set cameraRes exception" + localIOException1.getMessage());
            AppMethodBeat.o(104300);
            return false;
          }
          ac.i("MicroMsg.FaceReflectCam", "mFaceActionUI openCameraRe");
        }
        catch (Exception localException1)
        {
          AppMethodBeat.o(104300);
          return false;
        }
        label290:
        this.gXJ = com.tencent.mm.compatible.deviceinfo.d.a(this.qFt.getContext(), i, null);
      }
      this.qGR = i;
      this.mIsCameraOpened = true;
      ac.d("MicroMsg.FaceReflectCam", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(bs.aO(l)) });
      this.qyr = this.gXJ.duc;
      boolean bool;
      if (this.gXJ.duc % 180 != 0)
      {
        bool = true;
        this.qyq = bool;
        this.qGM = this.gXJ.fFt;
        if (this.qGM == null)
        {
          ac.e("MicroMsg.FaceReflectCam", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.qyq) });
          try
          {
            IOException localIOException2 = new IOException();
            AppMethodBeat.o(104300);
            throw localIOException2;
          }
          catch (IOException localIOException3)
          {
            ac.i("MicroMsg.FaceReflectCam", "set cameraRotation exception" + localIOException3.getMessage());
          }
        }
      }
      Camera.Parameters localParameters;
      for (;;)
      {
        try
        {
          localParameters = this.qGM.getParameters();
          if (this.qGW != 1) {
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
          ac.printErrStackTrace("MicroMsg.FaceReflectCam", localException2, "camera getParameters error: %s", new Object[] { localException2.getMessage() });
          AppMethodBeat.o(104300);
          return false;
        }
        bool = false;
        break;
        label578:
        j = this.qFt.getResources().getDisplayMetrics().widthPixels;
        i = this.qFt.getResources().getDisplayMetrics().heightPixels;
      }
      label611:
      this.nkL = new Point(j, i);
      Point localPoint2 = this.nkL;
      Point localPoint1 = this.qyp;
      Object localObject4 = localParameters.get("preview-size-values");
      Object localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = localParameters.get("preview-size-value");
      }
      if (localObject2 != null) {
        ac.d("MicroMsg.FaceReflectCam", "preview-size-values parameter: ".concat(String.valueOf(localObject2)));
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
        this.qyo = ((Point)localObject4);
        this.qyt = new Point(this.qyo);
        ac.d("MicroMsg.FaceReflectCam", "getCameraResolution: " + this.nkL + " camera:" + this.qyo + "bestVideoEncodeSize: " + this.qyt);
        this.mDesiredPreviewWidth = this.qyo.x;
        this.mDesiredPreviewHeight = this.qyo.y;
        localParameters.setPreviewSize(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
        ac.e("MicroMsg.FaceReflectCam", "mDesiredPreviewWidth：" + this.mDesiredPreviewWidth);
        ac.e("MicroMsg.FaceReflectCam", "mDesiredPreviewHeight：" + this.mDesiredPreviewHeight);
        localParameters.setZoom(0);
        localParameters.setSceneMode("auto");
        try
        {
          if ((localParameters.getSupportedFocusModes() != null) && (localParameters.getSupportedFocusModes().contains("auto")))
          {
            ac.i("MicroMsg.FaceReflectCam", "set FocusMode to FOCUS_MODE_AUTO");
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
            ac.d("MicroMsg.FaceReflectCam", "supportedPreviewFormat: ".concat(String.valueOf(j)));
            if (j != 17) {
              break;
            }
            j = 1;
            if (j == 0) {
              break label1268;
            }
            localParameters.setPreviewFormat(17);
            if (this.qyq) {
              localParameters.setRotation(this.qyr);
            }
            double d1 = this.qGQ.getmAspectRatio();
            ac.d("MicroMsg.FaceReflectCam", "original ratio=".concat(String.valueOf(d1)));
            d2 = this.mDesiredPreviewWidth / this.mDesiredPreviewHeight;
            ac.d("MicroMsg.FaceReflectCam", "new ratio=".concat(String.valueOf(d2)));
            if (d1 != d2) {
              break label1337;
            }
            ac.d("MicroMsg.FaceReflectCam", "NO NEED reset ratio");
            e(localParameters);
            localObject2 = localParameters.getSupportedPreviewFpsRange();
            ac.d("MicroMsg.FaceReflectCam", "range:" + ((List)localObject2).size());
            i = 0;
            if (i >= ((List)localObject2).size()) {
              break label1369;
            }
            localObject4 = (int[])((List)localObject2).get(i);
            j = 0;
            while (j < localObject4.length)
            {
              ac.i("MicroMsg.FaceReflectCam", "Camera SupportedPreviewFpsRange：", new Object[] { Integer.valueOf(localObject4[j]) });
              j += 1;
            }
            ac.i("MicroMsg.FaceReflectCam", "camera not support FOCUS_MODE_AUTO");
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            double d2;
            ac.e("MicroMsg.FaceReflectCam", "set focus mode error: %s", new Object[] { localException3.getMessage() });
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
                ac.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                localParameters.setPreviewFormat(842094169);
                break label1026;
              }
              ac.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { localException3.get(0) });
              localParameters.setPreviewFormat(((Integer)localException3.get(0)).intValue());
              break label1026;
              label1337:
              ac.d("MicroMsg.FaceReflectCam", "start reset ratio");
              ap.f(new b.6(this, d2));
              break label1106;
              i += 1;
              break label1149;
              label1369:
              ac.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + localParameters.get("preview-fps-range"));
              ac.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + localParameters.get("preview-frame-rate"));
              try
              {
                this.qGM.setParameters(localParameters);
                bool = this.mIsCameraOpened;
                AppMethodBeat.o(104300);
                return bool;
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  ac.printErrStackTrace("MicroMsg.FaceReflectCam", localException4, "setParameters error", new Object[0]);
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
  
  private static void e(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(104305);
    if (ae.fJd.fET > 0)
    {
      ac.i("MicroMsg.FaceReflectCam", "set frame rate > 0, do not try set preview fps range");
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
      ac.i("MicroMsg.FaceReflectCam", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
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
      ac.i("MicroMsg.FaceReflectCam", "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(30) });
      if ((j == 2147483647) || (i == 2147483647))
      {
        AppMethodBeat.o(104305);
        return;
      }
      try
      {
        paramParameters.setPreviewFpsRange(j, i);
        ac.i("MicroMsg.FaceReflectCam", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(104305);
        return;
      }
      catch (Exception paramParameters)
      {
        ac.i("MicroMsg.FaceReflectCam", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
        AppMethodBeat.o(104305);
        return;
      }
      label391:
      k = n;
      i = i2;
      j = i1;
    }
  }
  
  private static boolean i(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104306);
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    ac.d("MicroMsg.FaceReflectCam", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
    if (paramLong / d >= 5.0D)
    {
      AppMethodBeat.o(104306);
      return true;
    }
    AppMethodBeat.o(104306);
    return false;
  }
  
  private void j(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(104297);
    ac.i("MicroMsg.FaceReflectCam", "openCameraForSurfaceTexture");
    if (this.qGW == 1) {
      this.qGP.setVisibility(0);
    }
    for (;;)
    {
      coP();
      if (this.qGL == null) {
        break;
      }
      this.qGL.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104284);
          h localh;
          if (!b.d(b.this))
          {
            localh = h.wUl;
            if (b.e(b.this) == 1)
            {
              l = 3L;
              localh.idkeyStat(917L, l, 1L, false);
              b.d(b.this);
            }
          }
          else
          {
            localh = h.wUl;
            if (b.e(b.this) != 1) {
              break label105;
            }
          }
          label105:
          for (long l = 2L;; l = 38L)
          {
            localh.idkeyStat(917L, l, 1L, false);
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(104283);
                if ((b.f(b.this) == null) || (b.f(b.this).fHD) || (!b.g(b.this)))
                {
                  ac.e("MicroMsg.FaceReflectCam", "camera is null or has released!");
                  AppMethodBeat.o(104283);
                  return;
                }
                if (b.e(b.this) == 1)
                {
                  localObject1 = c.a.coQ();
                  localObject2 = b.h(b.this);
                  localObject3 = b.i(b.this);
                  localObject4 = b.f(b.this);
                  i = b.j(b.this);
                  localObject5 = b.this.qGO;
                  localObject6 = b.k(b.this);
                  localObject7 = b.l(b.this);
                  str1 = b.m(b.this);
                  String str2 = b.n(b.this);
                  j = b.o(b.this);
                  k = b.p(b.this);
                  m = b.q(b.this);
                  Point localPoint = b.r(b.this);
                  ac.i("MicroMsg.FaceReflectLogic", "initPreviewDetect（）");
                  ((c)localObject1).mContext = ((Context)localObject2);
                  ((c)localObject1).qGM = ((v)localObject4);
                  ((c)localObject1).kmi = i;
                  ((c)localObject1).qFu = ((TextView)localObject5);
                  ((c)localObject1).qGY = ((com.tencent.mm.plugin.facedetectlight.ui.a.b)localObject3);
                  ((c)localObject1).qGP = ((FaceReflectMask)localObject6);
                  ((c)localObject1).qHi = j;
                  ((c)localObject1).mDesiredPreviewWidth = k;
                  ((c)localObject1).mDesiredPreviewHeight = m;
                  ((c)localObject1).qHj = localPoint;
                  ((c)localObject1).qAD = ((byte[])localObject7);
                  ((c)localObject1).qGS = str1;
                  ((c)localObject1).mAppId = str2;
                  ac.i("MicroMsg.FaceReflectLogic", "mConfig is ".concat(String.valueOf(localObject7)));
                  ac.i("MicroMsg.FaceReflectLogic", "mBioID is " + ((c)localObject1).qGS);
                  ac.i("MicroMsg.FaceReflectLogic", "mAppId is ".concat(String.valueOf(str2)));
                  ((c)localObject1).qFw = new Rect(0, 0, 0, 0);
                  ((c)localObject1).qFx = new Rect(0, 0, 0, 0);
                  ac.i("MicroMsg.FaceReflectLogic", "setFaceRect（）");
                  ((c)localObject1).qHg = ((c)localObject1).mContext.getResources().getDisplayMetrics().widthPixels;
                  ((c)localObject1).qHh = ((c)localObject1).mContext.getResources().getDisplayMetrics().heightPixels;
                  ((c)localObject1).qFx.left = ((int)(((c)localObject1).qHg * 0.15D));
                  ((c)localObject1).qFx.right = ((int)(((c)localObject1).qHg * 0.85D));
                  ((c)localObject1).qFx.top = ((int)(((c)localObject1).qHh * 0.2D));
                  ((c)localObject1).qFx.bottom = ((int)(((c)localObject1).qHh * 0.65D));
                  if (com.tencent.mm.plugin.facedetect.e.a.coq().qCF) {
                    com.tencent.mm.plugin.facedetect.e.a.coq().a(((c)localObject1).qHi, ((c)localObject1).mDesiredPreviewWidth, ((c)localObject1).mDesiredPreviewHeight, ((c)localObject1).qHj.x, ((c)localObject1).mDesiredPreviewHeight, false);
                  }
                  c.a.coQ();
                  ac.i("MicroMsg.FaceReflectLogic", "initFaceDetect（）");
                  AppMethodBeat.o(104283);
                  return;
                }
                Object localObject2 = a.b.coH();
                Object localObject3 = b.s(b.this).getApplicationContext();
                Object localObject4 = b.s(b.this);
                Object localObject5 = b.f(b.this).fHC;
                int i = b.j(b.this);
                Object localObject6 = b.this.qGO;
                Object localObject7 = b.t(b.this);
                int j = b.o(b.this);
                Object localObject1 = new Point(b.p(b.this), b.q(b.this));
                int k = b.u(b.this);
                String str1 = b.v(b.this);
                int m = b.p(b.this);
                int n = b.q(b.this);
                ac.i("MicroMsg.FaceActionLogic", "initFaceDetect（）");
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mContext = ((Context)localObject3);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mCamera = ((Camera)localObject5);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).kmi = i;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFu = ((TextView)localObject6);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFt = ((FaceActionUI)localObject4);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFv = ((a.a)localObject7);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFr = k;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFs = str1;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mDesiredPreviewWidth = m;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).mDesiredPreviewHeight = n;
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFw = new Rect(0, 0, 0, 0);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFx = new Rect(0, 0, 0, 0);
                ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFz = true;
                ac.i("MicroMsg.FaceActionLogic", "action：%s,mActionHint:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFr), ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFs });
                if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFs != null) {
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFu.setText(((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFs);
                }
                for (;;)
                {
                  YTPoseDetectInterface.start(((Context)localObject3).getApplicationContext(), (Camera)localObject5, i, new a.1((com.tencent.mm.plugin.facedetectaction.b.a)localObject2));
                  ac.i("MicroMsg.FaceActionLogic", "init face detect, camera, rotate: %s", new Object[] { Integer.valueOf(j) });
                  com.tencent.mm.plugin.facedetectaction.b.d.qFG.hcR = j;
                  localObject2 = com.tencent.mm.plugin.facedetectaction.b.d.qFG;
                  i = ((Point)localObject1).x;
                  j = ((Point)localObject1).y;
                  ((com.tencent.mm.plugin.facedetectaction.b.d)localObject2).qFO = i;
                  ((com.tencent.mm.plugin.facedetectaction.b.d)localObject2).qFP = j;
                  AppMethodBeat.o(104283);
                  return;
                  switch (((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFr)
                  {
                  default: 
                    break;
                  case 1: 
                    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFu.setText(2131758677);
                    break;
                  case 2: 
                    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject2).qFu.setText(2131758678);
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
      this.qGL.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104285);
          try
          {
            b.a(b.this, paramSurfaceTexture);
            b localb = b.this;
            Camera.PreviewCallback localPreviewCallback = b.w(b.this);
            if (localb.qGM == null)
            {
              ac.w("MicroMsg.FaceReflectCam", "hy: camera is null. setPreviewCallback failed");
              AppMethodBeat.o(104285);
              return;
            }
            int j = localb.mDesiredPreviewWidth * localb.mDesiredPreviewHeight * ImageFormat.getBitsPerPixel(localb.qGM.getParameters().getPreviewFormat()) / 8;
            int i = 0;
            while (i < 5)
            {
              byte[] arrayOfByte = com.tencent.mm.plugin.facedetect.model.c.qxj.g(Integer.valueOf(j));
              localb.qGM.addCallbackBuffer(arrayOfByte);
              i += 1;
            }
            localb.qGM.setPreviewCallbackWithBuffer(new b.9(localb, localPreviewCallback));
            com.tencent.mm.plugin.facedetect.model.d.cnj().a(localb.qDN);
            AppMethodBeat.o(104285);
            return;
          }
          catch (Exception localException)
          {
            if (b.e(b.this) == 1)
            {
              b.i(b.this).x(90016, "preview error", ai.getContext().getString(2131764085));
              AppMethodBeat.o(104285);
              return;
            }
            ac.i("MicroMsg.FaceReflectCam", "preview error");
            b.s(b.this).g("camera error", 90016, "preview error", "");
            AppMethodBeat.o(104285);
          }
        }
      });
      AppMethodBeat.o(104297);
      return;
      this.qGf.setVisibility(0);
    }
    ac.i("MicroMsg.FaceReflectCam", "back thread is not running");
    AppMethodBeat.o(104297);
  }
  
  public final void a(MMTextureView paramMMTextureView)
  {
    AppMethodBeat.i(104296);
    this.qGJ = paramMMTextureView;
    if (this.qGJ.isAvailable()) {
      j(paramMMTextureView.getSurfaceTexture());
    }
    this.qGJ.setSurfaceTextureListener(this);
    this.qGJ.setVisibility(0);
    this.qGJ.setAlpha(0.0F);
    if ((this.qGW == 2) && (!this.qGV)) {
      ap.n(new Runnable()
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
  
  public final void auj()
  {
    AppMethodBeat.i(104302);
    ac.i("MicroMsg.FaceReflectCam", "closeCamera start");
    if (this.qGX != null)
    {
      this.qGX.quit();
      this.qGX = null;
    }
    if (this.qGM != null) {}
    try
    {
      if (this.qBh)
      {
        this.qBh = false;
        this.qGM.stopPreview();
        this.qGM.setPreviewCallback(null);
        ac.i("MicroMsg.FaceReflectCam", "stop preview, not previewing");
      }
      try
      {
        this.qGM.release();
        this.qGM = null;
        this.qGM = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException2.getMessage());
          this.qGM = null;
        }
      }
      finally
      {
        this.qGM = null;
        AppMethodBeat.o(104302);
      }
      ac.i("MicroMsg.FaceReflectCam", "closeCamera end");
      AppMethodBeat.o(104302);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ac.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException1.getMessage());
      }
    }
  }
  
  public final void coP()
  {
    AppMethodBeat.i(104303);
    if (this.qGK == null)
    {
      ac.i("MicroMsg.FaceReflectCam", "start camera thread");
      this.qGK = com.tencent.e.c.d.gA("cameraBackground", 5);
      this.qGK.start();
      this.qGL = new ao(this.qGK.getLooper());
    }
    AppMethodBeat.o(104303);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104299);
    ac.i("MicroMsg.FaceReflectCam", "onSurfaceTextureAvailable, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    j(paramSurfaceTexture);
    AppMethodBeat.o(104299);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(104298);
    ac.i("MicroMsg.FaceReflectCam", "surfaceDestroyed");
    if (this.qGL != null)
    {
      this.qGL.post(new b.5(this));
      if (this.qGK != null) {
        ac.i("MicroMsg.FaceReflectCam", "stop camera thread");
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(500L, 0);
        if (Build.VERSION.SDK_INT >= 18) {
          this.qGK.quitSafely();
        }
      }
      catch (InterruptedException paramSurfaceTexture)
      {
        try
        {
          this.qGK.join();
          this.qGK = null;
          this.qGL = null;
          ac.i("MicroMsg.FaceReflectCam", "stop camera thread finish");
          AppMethodBeat.o(104298);
          return false;
          paramSurfaceTexture = paramSurfaceTexture;
          ac.i("MicroMsg.FaceReflectCam", "background thread sleep error：" + paramSurfaceTexture.getMessage());
          continue;
          this.qGK.quit();
          continue;
        }
        catch (InterruptedException paramSurfaceTexture)
        {
          ac.i("MicroMsg.FaceReflectCam", "stop xbackground thread error：" + paramSurfaceTexture.getMessage());
          continue;
        }
      }
      ac.i("MicroMsg.FaceReflectCam", "back thread is not running");
    }
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void stopPreview()
  {
    AppMethodBeat.i(104301);
    ac.i("MicroMsg.FaceReflectCam", "stopPreview, isPreviewing: %s", new Object[] { Boolean.valueOf(this.qGN) });
    if (this.qGM != null)
    {
      this.qGM.stopPreview();
      this.qGN = false;
      com.tencent.mm.plugin.facedetect.model.c.qxj.avJ();
    }
    AppMethodBeat.o(104301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b
 * JD-Core Version:    0.7.0.1
 */