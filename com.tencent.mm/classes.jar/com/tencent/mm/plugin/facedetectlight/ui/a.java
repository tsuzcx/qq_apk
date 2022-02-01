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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.a.b;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionMask;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.2;
import com.tencent.mm.plugin.flash.c.b;
import com.tencent.mm.plugin.flash.view.FaceReflectMask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;
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

public final class a
  implements TextureView.SurfaceTextureListener
{
  private String goe;
  private boolean imf;
  private d.a.a imk;
  private Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  private Point pbD;
  public ImageView pcg;
  private Point sRF;
  private Point sRG;
  private boolean sRH;
  private int sRI;
  private Point sRK;
  public volatile boolean sTE;
  private Camera.PreviewCallback sVE;
  d.b sVF;
  private FaceActionUI sXH;
  public int sXk;
  public String sXl;
  private com.tencent.mm.plugin.facedetectaction.b.a.a sXn;
  private MMTextureView sYY;
  private HandlerThread sYZ;
  public FaceActionMask sYd;
  private MMHandler sZa;
  public v sZb;
  private volatile boolean sZc;
  public volatile boolean sZd;
  public TextView sZe;
  private FaceReflectMask sZf;
  public PreviewFrameLayout sZg;
  private int sZh;
  public ImageView sZi;
  private Bitmap sZj;
  private boolean sZk;
  private int sZl;
  public MMHandler sZm;
  
  public a(FaceActionUI paramFaceActionUI, com.tencent.mm.plugin.facedetectaction.b.a.a parama)
  {
    AppMethodBeat.i(104295);
    this.sRF = null;
    this.pbD = null;
    this.sRG = null;
    this.sRK = null;
    this.sZh = 0;
    this.sZm = new MMHandler("mPreviewHandlerThread");
    this.sVF = new d.b()
    {
      public final void bC(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(104293);
        com.tencent.mm.plugin.facedetect.model.c.sQB.k(paramAnonymousArrayOfByte);
        AppMethodBeat.o(104293);
      }
      
      public final com.tencent.mm.memory.a<byte[]> cSS()
      {
        return com.tencent.mm.plugin.facedetect.model.c.sQB;
      }
    };
    this.sVE = new Camera.PreviewCallback()
    {
      public final void onPreviewFrame(final byte[] paramAnonymousArrayOfByte, final Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(104282);
        if (a.u(a.this) != null) {
          a.u(a.this).postToWorker(new Runnable()
          {
            public final void run()
            {
              Object localObject = null;
              AppMethodBeat.i(104281);
              if ((a.this.sZd) && (a.this.sTE) && (a.f(a.this) == 2))
              {
                com.tencent.mm.plugin.facedetectaction.b.a locala = a.b.cTX();
                byte[] arrayOfByte = paramAnonymousArrayOfByte;
                Camera localCamera = paramAnonymousCamera;
                if ((locala.sXt) && (YTFaceTrack.IsInstanceExist()))
                {
                  int i = YTCameraSetting.getRotate(locala.mContext, locala.lPd, 1);
                  if (PluginFace.isEnabled()) {
                    localObject = YTFaceTrack.getInstance().DoDetectionProcessYUV(arrayOfByte, locala.mDesiredPreviewWidth, locala.mDesiredPreviewHeight, i, null);
                  }
                  if (localObject != null)
                  {
                    b.axo("faceRecognized");
                    localObject = localObject[0];
                    if (YTPoseDetectInterface.isDetecting())
                    {
                      if (localObject == null)
                      {
                        Log.i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
                        locala.sXm.setText(2131759071);
                        AppMethodBeat.o(104281);
                        return;
                      }
                      YTFaceUtils.shelterJudge(((YTFaceTrack.FaceStatus)localObject).pointsVis);
                      if (locala.sXs != null) {
                        YTPoseDetectInterface.poseDetect(((YTFaceTrack.FaceStatus)localObject).xys, ((YTFaceTrack.FaceStatus)localObject).pointsVis, locala.sXk, arrayOfByte, localCamera, ((YTFaceTrack.FaceStatus)localObject).pitch, ((YTFaceTrack.FaceStatus)localObject).yaw, ((YTFaceTrack.FaceStatus)localObject).roll, locala.sXs, 0);
                      }
                    }
                    AppMethodBeat.o(104281);
                    return;
                  }
                  Log.i("MicroMsg.FaceActionLogic", "No face");
                }
              }
              AppMethodBeat.o(104281);
            }
          });
        }
        AppMethodBeat.o(104282);
      }
    };
    this.sZl = 2;
    this.sXH = paramFaceActionUI;
    this.sZc = false;
    this.sTE = false;
    this.sYZ = null;
    this.sZc = false;
    this.sZk = false;
    this.sXn = parama;
    AppMethodBeat.o(104295);
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(104304);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new a.a((byte)0));
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    Log.d("MicroMsg.FaceReflectCam", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    long l = Util.getAvailableMemoryMB(MMApplicationContext.getContext());
    Log.d("MicroMsg.FaceReflectCam", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(l) });
    int i = paramPoint.x;
    i = paramPoint.y;
    float f1 = (1.0F / 1.0F);
    localObject = ((List)localObject).iterator();
    int j;
    label240:
    float f2;
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
      i = localSize.width;
      j = localSize.height;
      Log.i("MicroMsg.FaceReflectCam", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      int k = i * j;
      if ((k >= 150400) && (k <= 983040))
      {
        if (i > j)
        {
          m = 1;
          if (m == 0) {
            break label347;
          }
          k = j;
          if (m == 0) {
            break label354;
          }
        }
        label347:
        label354:
        for (int m = i;; m = j)
        {
          Log.d("MicroMsg.FaceReflectCam", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!k(k, m, l))) {
            break label361;
          }
          paramParameters = new Point(i, j);
          Log.i("MicroMsg.FaceReflectCam", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
          AppMethodBeat.o(104304);
          return paramParameters;
          m = 0;
          break;
          k = i;
          break label240;
        }
        label361:
        f2 = Math.abs(k / m - f3);
        if (i % 10 == 0)
        {
          if ((f2 >= f1) || (!k(i, j, l))) {
            break label545;
          }
          localPoint = new Point(i, j);
          f1 = f2;
        }
      }
    }
    label531:
    label545:
    for (;;)
    {
      Log.i("MicroMsg.FaceReflectCam", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        if (paramParameters == null) {
          break label531;
        }
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        Log.i("MicroMsg.FaceReflectCam", "No suitable preview sizes, using default: ".concat(String.valueOf(paramPoint)));
      }
      for (;;)
      {
        Log.i("MicroMsg.FaceReflectCam", "Found best approximate preview size: ".concat(String.valueOf(paramPoint)));
        AppMethodBeat.o(104304);
        return paramPoint;
        Log.e("MicroMsg.FaceReflectCam", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  private static void a(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(104305);
    if (ae.gKt.gFP > 0)
    {
      Log.i("MicroMsg.FaceReflectCam", "set frame rate > 0, do not try set preview fps range");
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
      Log.i("MicroMsg.FaceReflectCam", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
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
      Log.i("MicroMsg.FaceReflectCam", "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(30) });
      if ((j == 2147483647) || (i == 2147483647))
      {
        AppMethodBeat.o(104305);
        return;
      }
      try
      {
        paramParameters.setPreviewFpsRange(j, i);
        Log.i("MicroMsg.FaceReflectCam", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(104305);
        return;
      }
      catch (Exception paramParameters)
      {
        Log.i("MicroMsg.FaceReflectCam", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
        AppMethodBeat.o(104305);
        return;
      }
      label391:
      k = n;
      i = i2;
      j = i1;
    }
  }
  
  private boolean cUc()
  {
    AppMethodBeat.i(104300);
    Log.i("MicroMsg.FaceReflectCam", "start open camera");
    this.sZc = false;
    this.imf = true;
    Object localObject1 = com.tencent.mm.compatible.c.a.gDs;
    int j = com.tencent.mm.compatible.c.a.anJ();
    int i = 0;
    if (i < j)
    {
      localObject1 = new Camera.CameraInfo();
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject1);
      if ((((Camera.CameraInfo)localObject1).facing == 1) && (this.imf)) {
        Log.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
      }
    }
    for (;;)
    {
      if (i == -1)
      {
        Log.i("MicroMsg.FaceReflectCam", "not found available camera id");
        AppMethodBeat.o(104300);
        return false;
        if ((((Camera.CameraInfo)localObject1).facing == 0) && (!this.imf))
        {
          Log.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
          continue;
        }
        i += 1;
        break;
      }
      long l = Util.currentTicks();
      Log.i("MicroMsg.FaceReflectCam", "openCameraRes：" + this.imk);
      if (this.imk == null)
      {
        Log.i("MicroMsg.FaceReflectCam", "openCameraRes is null");
        if (this.sZl != 1) {
          break label295;
        }
        Log.i("MicroMsg.FaceReflectCam", "mFaceReflectController openCameraRe");
      }
      for (;;)
      {
        try
        {
          this.imk = com.tencent.mm.compatible.deviceinfo.d.a(this.mContext, i, null);
          if (this.imk != null) {
            break;
          }
          Log.i("MicroMsg.FaceReflectCam", "in open(), openCameraRes == null");
          try
          {
            localObject1 = new IOException();
            AppMethodBeat.o(104300);
            throw ((Throwable)localObject1);
          }
          catch (IOException localIOException1)
          {
            Log.i("MicroMsg.FaceReflectCam", "set cameraRes exception" + localIOException1.getMessage());
            AppMethodBeat.o(104300);
            return false;
          }
          Log.i("MicroMsg.FaceReflectCam", "mFaceActionUI openCameraRe");
        }
        catch (Exception localException1)
        {
          AppMethodBeat.o(104300);
          return false;
        }
        label295:
        this.imk = com.tencent.mm.compatible.deviceinfo.d.a(this.sXH.getContext(), i, null);
      }
      this.sZh = i;
      this.sZc = true;
      Log.d("MicroMsg.FaceReflectCam", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
      this.sRI = this.imk.dYT;
      boolean bool;
      if (this.imk.dYT % 180 != 0)
      {
        bool = true;
        this.sRH = bool;
        this.sZb = this.imk.gGr;
        if (this.sZb == null)
        {
          Log.e("MicroMsg.FaceReflectCam", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.sRH) });
          try
          {
            IOException localIOException2 = new IOException();
            AppMethodBeat.o(104300);
            throw localIOException2;
          }
          catch (IOException localIOException3)
          {
            Log.i("MicroMsg.FaceReflectCam", "set cameraRotation exception" + localIOException3.getMessage());
          }
        }
      }
      Camera.Parameters localParameters;
      for (;;)
      {
        try
        {
          localParameters = this.sZb.getParameters();
          if (this.sZl != 1) {
            break label583;
          }
          j = this.mContext.getResources().getDisplayMetrics().widthPixels;
          i = this.mContext.getResources().getDisplayMetrics().heightPixels;
          if (localParameters != null) {
            break label616;
          }
          AppMethodBeat.o(104300);
          return false;
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("MicroMsg.FaceReflectCam", localException2, "camera getParameters error: %s", new Object[] { localException2.getMessage() });
          AppMethodBeat.o(104300);
          return false;
        }
        bool = false;
        break;
        label583:
        j = this.sXH.getResources().getDisplayMetrics().widthPixels;
        i = this.sXH.getResources().getDisplayMetrics().heightPixels;
      }
      label616:
      this.pbD = new Point(j, i);
      Point localPoint2 = this.pbD;
      Point localPoint1 = this.sRG;
      Object localObject4 = localParameters.get("preview-size-values");
      Object localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = localParameters.get("preview-size-value");
      }
      if (localObject2 != null) {
        Log.d("MicroMsg.FaceReflectCam", "preview-size-values parameter: ".concat(String.valueOf(localObject2)));
      }
      label1031:
      label1111:
      label1273:
      Object localObject3;
      for (localObject2 = a(localParameters, localPoint2);; localObject3 = null)
      {
        localObject4 = localObject2;
        if (localObject2 == null) {
          localObject4 = new Point(localPoint1.x >> 3 << 3, localPoint1.y >> 3 << 3);
        }
        this.sRF = ((Point)localObject4);
        this.sRK = new Point(this.sRF);
        Log.d("MicroMsg.FaceReflectCam", "getCameraResolution: " + this.pbD + " camera:" + this.sRF + "bestVideoEncodeSize: " + this.sRK);
        this.mDesiredPreviewWidth = this.sRF.x;
        this.mDesiredPreviewHeight = this.sRF.y;
        localParameters.setPreviewSize(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
        Log.e("MicroMsg.FaceReflectCam", "mDesiredPreviewWidth：" + this.mDesiredPreviewWidth);
        Log.e("MicroMsg.FaceReflectCam", "mDesiredPreviewHeight：" + this.mDesiredPreviewHeight);
        localParameters.setZoom(0);
        localParameters.setSceneMode("auto");
        try
        {
          if ((localParameters.getSupportedFocusModes() != null) && (localParameters.getSupportedFocusModes().contains("auto")))
          {
            Log.i("MicroMsg.FaceReflectCam", "set FocusMode to FOCUS_MODE_AUTO");
            localParameters.setFocusMode("auto");
          }
          for (;;)
          {
            localObject2 = localParameters.getSupportedPreviewFormats();
            localObject4 = ((List)localObject2).iterator();
            i = 0;
            if (!((Iterator)localObject4).hasNext()) {
              break label1478;
            }
            j = ((Integer)((Iterator)localObject4).next()).intValue();
            Log.d("MicroMsg.FaceReflectCam", "supportedPreviewFormat: ".concat(String.valueOf(j)));
            if (j != 17) {
              break;
            }
            j = 1;
            if (j == 0) {
              break label1273;
            }
            localParameters.setPreviewFormat(17);
            if (this.sRH) {
              localParameters.setRotation(this.sRI);
            }
            double d1 = this.sZg.getmAspectRatio();
            Log.d("MicroMsg.FaceReflectCam", "original ratio=".concat(String.valueOf(d1)));
            d2 = this.mDesiredPreviewWidth / this.mDesiredPreviewHeight;
            Log.d("MicroMsg.FaceReflectCam", "new ratio=".concat(String.valueOf(d2)));
            if (d1 != d2) {
              break label1342;
            }
            Log.d("MicroMsg.FaceReflectCam", "NO NEED reset ratio");
            a(localParameters);
            localObject2 = localParameters.getSupportedPreviewFpsRange();
            Log.d("MicroMsg.FaceReflectCam", "range:" + ((List)localObject2).size());
            i = 0;
            label1154:
            if (i >= ((List)localObject2).size()) {
              break label1374;
            }
            localObject4 = (int[])((List)localObject2).get(i);
            j = 0;
            while (j < localObject4.length)
            {
              Log.i("MicroMsg.FaceReflectCam", "Camera SupportedPreviewFpsRange：", new Object[] { Integer.valueOf(localObject4[j]) });
              j += 1;
            }
            Log.i("MicroMsg.FaceReflectCam", "camera not support FOCUS_MODE_AUTO");
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            final double d2;
            Log.e("MicroMsg.FaceReflectCam", "set focus mode error: %s", new Object[] { localException3.getMessage() });
            continue;
            if (j == 842094169) {
              i = 1;
            }
            for (;;)
            {
              break;
              if (i != 0)
              {
                Log.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                localParameters.setPreviewFormat(842094169);
                break label1031;
              }
              Log.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { localException3.get(0) });
              localParameters.setPreviewFormat(((Integer)localException3.get(0)).intValue());
              break label1031;
              label1342:
              Log.d("MicroMsg.FaceReflectCam", "start reset ratio");
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(104287);
                  Log.d("MicroMsg.FaceReflectCam", "reset ratio");
                  int i = a.this.sZg.getContext().getResources().getDisplayMetrics().widthPixels;
                  RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)a.this.sZg.getLayoutParams();
                  localLayoutParams.width = ((int)(i * 0.7D));
                  localLayoutParams.height = ((int)(localLayoutParams.width * d2));
                  localLayoutParams.addRule(13, -1);
                  a.this.sZg.setLayoutParams(localLayoutParams);
                  a.this.sZg.setAspectRatio(d2);
                  Log.d("MicroMsg.FaceReflectCam", "after reset ratio=" + a.this.sZg.getmAspectRatio());
                  AppMethodBeat.o(104287);
                }
              });
              break label1111;
              i += 1;
              break label1154;
              label1374:
              Log.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + localParameters.get("preview-fps-range"));
              Log.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + localParameters.get("preview-frame-rate"));
              try
              {
                this.sZb.setParameters(localParameters);
                bool = this.sZc;
                AppMethodBeat.o(104300);
                return bool;
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.FaceReflectCam", localException4, "setParameters error", new Object[0]);
                }
              }
            }
            label1478:
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
    Log.i("MicroMsg.FaceReflectCam", "openCameraForSurfaceTexture");
    if (this.sZl == 1) {
      this.sZf.setVisibility(0);
    }
    for (;;)
    {
      cUd();
      if (this.sZa == null) {
        break;
      }
      this.sZa.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104284);
          a.a(a.this, a.d(a.this));
          com.tencent.mm.plugin.report.service.h localh;
          if (!a.e(a.this))
          {
            localh = com.tencent.mm.plugin.report.service.h.CyF;
            if (a.f(a.this) == 1)
            {
              l = 3L;
              localh.idkeyStat(917L, l, 1L, false);
              a.a(a.this, a.d(a.this));
            }
          }
          else
          {
            localh = com.tencent.mm.plugin.report.service.h.CyF;
            if (a.f(a.this) != 1) {
              break label127;
            }
          }
          label127:
          for (long l = 2L;; l = 38L)
          {
            localh.idkeyStat(917L, l, 1L, false);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(104283);
                if ((a.g(a.this) == null) || (a.g(a.this).gIJ) || (!a.e(a.this)))
                {
                  Log.e("MicroMsg.FaceReflectCam", "camera is null or has released!");
                  AppMethodBeat.o(104283);
                  return;
                }
                Object localObject;
                Context localContext;
                Camera localCamera;
                int i;
                int j;
                Point localPoint;
                if (a.f(a.this) != 1)
                {
                  localObject = a.b.cTX();
                  localContext = a.h(a.this).getApplicationContext();
                  FaceActionUI localFaceActionUI = a.h(a.this);
                  localCamera = a.g(a.this).gII;
                  i = a.i(a.this);
                  TextView localTextView = a.this.sZe;
                  com.tencent.mm.plugin.facedetectaction.b.a.a locala = a.j(a.this);
                  j = a.k(a.this);
                  localPoint = new Point(a.l(a.this), a.m(a.this));
                  int k = a.n(a.this);
                  String str = a.o(a.this);
                  int m = a.l(a.this);
                  int n = a.m(a.this);
                  Log.i("MicroMsg.FaceActionLogic", "initFaceDetect（）");
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).mContext = localContext;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).mCamera = localCamera;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).lPd = i;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXm = localTextView;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXq = localFaceActionUI.getResources().getDisplayMetrics().widthPixels;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXr = localFaceActionUI.getResources().getDisplayMetrics().heightPixels;
                  Log.i("MicroMsg.FaceActionLogic", "mUiWidth:%s  mUiHeight：%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXq), Integer.valueOf(((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXr) });
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXn = locala;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXk = k;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXl = str;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).mDesiredPreviewWidth = m;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).mDesiredPreviewHeight = n;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXo = new Rect(0, 0, 0, 0);
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXp = new Rect(0, 0, 0, 0);
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXt = true;
                  Log.i("MicroMsg.FaceActionLogic", "action：%s,mActionHint:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXk), ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXl });
                  if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXl == null) {
                    break label546;
                  }
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXm.setText(((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXl);
                }
                for (;;)
                {
                  YTPoseDetectInterface.start(localContext.getApplicationContext(), localCamera, i, new com.tencent.mm.plugin.facedetectaction.b.a.1((com.tencent.mm.plugin.facedetectaction.b.a)localObject));
                  Log.i("MicroMsg.FaceActionLogic", "init face detect, camera, rotate: %s", new Object[] { Integer.valueOf(j) });
                  com.tencent.mm.plugin.facedetectaction.b.d.sXz.irL = j;
                  localObject = com.tencent.mm.plugin.facedetectaction.b.d.sXz;
                  i = localPoint.x;
                  j = localPoint.y;
                  ((com.tencent.mm.plugin.facedetectaction.b.d)localObject).sXF = i;
                  ((com.tencent.mm.plugin.facedetectaction.b.d)localObject).sXG = j;
                  AppMethodBeat.o(104283);
                  return;
                  label546:
                  switch (((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXk)
                  {
                  default: 
                    break;
                  case 1: 
                    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXm.setText(2131758983);
                    break;
                  case 2: 
                    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).sXm.setText(2131758984);
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
      this.sZa.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104285);
          try
          {
            a.a(a.this, paramSurfaceTexture);
            a locala = a.this;
            Camera.PreviewCallback localPreviewCallback = a.p(a.this);
            if (locala.sZb == null) {
              Log.w("MicroMsg.FaceReflectCam", "hy: camera is null. setPreviewCallback failed");
            }
            for (;;)
            {
              b.axn("openCamera");
              AppMethodBeat.o(104285);
              return;
              int j = locala.mDesiredPreviewWidth * locala.mDesiredPreviewHeight * ImageFormat.getBitsPerPixel(locala.sZb.getParameters().getPreviewFormat()) / 8;
              int i = 0;
              while (i < 5)
              {
                byte[] arrayOfByte = com.tencent.mm.plugin.facedetect.model.c.sQB.h(Integer.valueOf(j));
                locala.sZb.addCallbackBuffer(arrayOfByte);
                i += 1;
              }
              locala.sZb.setPreviewCallbackWithBuffer(new a.9(locala, localPreviewCallback));
              com.tencent.mm.plugin.facedetect.model.d.cSR().a(locala.sVF);
            }
            FaceActionUI localFaceActionUI;
            return;
          }
          catch (Exception localException)
          {
            b.s("openCamera", Integer.valueOf(-1));
            if (a.f(a.this) != 1)
            {
              Log.i("MicroMsg.FaceReflectCam", "preview error");
              localFaceActionUI = a.h(a.this);
              com.tencent.f.h.RTc.aV(new FaceActionUI.2(localFaceActionUI));
            }
            AppMethodBeat.o(104285);
          }
        }
      });
      AppMethodBeat.o(104297);
      return;
      this.sYd.setVisibility(0);
    }
    Log.i("MicroMsg.FaceReflectCam", "back thread is not running");
    AppMethodBeat.o(104297);
  }
  
  private static boolean k(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104306);
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    Log.d("MicroMsg.FaceReflectCam", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
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
    this.sYY = paramMMTextureView;
    if (this.sYY.isAvailable()) {
      j(paramMMTextureView.getSurfaceTexture());
    }
    this.sYY.setSurfaceTextureListener(this);
    this.sYY.setVisibility(0);
    this.sYY.setAlpha(0.0F);
    if ((this.sZl == 2) && (!this.sZk)) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104280);
          a.a(a.this).setVisibility(8);
          a.b(a.this).setVisibility(8);
          a.c(a.this);
          AppMethodBeat.o(104280);
        }
      }, 700L);
    }
    AppMethodBeat.o(104296);
  }
  
  public final void aPK()
  {
    AppMethodBeat.i(104302);
    Log.i("MicroMsg.FaceReflectCam", "closeCamera start");
    if (this.sZm != null)
    {
      this.sZm.quit();
      this.sZm = null;
    }
    if (this.sZb != null) {}
    try
    {
      if (this.sTE)
      {
        this.sTE = false;
        this.sZb.stopPreview();
        this.sZb.setPreviewCallback(null);
        Log.i("MicroMsg.FaceReflectCam", "stop preview, not previewing");
      }
      try
      {
        this.sZb.release();
        this.sZb = null;
        com.tencent.mm.plugin.facedetect.model.d.cSR().b(this.sVF);
        a.b.cTX().sXm = null;
        this.sZb = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException2.getMessage());
          this.sZb = null;
        }
      }
      finally
      {
        this.sZb = null;
        AppMethodBeat.o(104302);
      }
      Log.i("MicroMsg.FaceReflectCam", "closeCamera end");
      AppMethodBeat.o(104302);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Log.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException1.getMessage());
      }
    }
  }
  
  public final void cUd()
  {
    AppMethodBeat.i(104303);
    if (this.sYZ == null)
    {
      Log.i("MicroMsg.FaceReflectCam", "start camera thread");
      this.sYZ = com.tencent.f.c.d.hB("cameraBackground", 5);
      this.sYZ.start();
      this.sZa = new MMHandler(this.sYZ.getLooper());
    }
    AppMethodBeat.o(104303);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104299);
    Log.i("MicroMsg.FaceReflectCam", "onSurfaceTextureAvailable, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    j(paramSurfaceTexture);
    AppMethodBeat.o(104299);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(104298);
    Log.i("MicroMsg.FaceReflectCam", "surfaceDestroyed");
    if (this.sZa != null)
    {
      this.sZa.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104286);
          a.this.aPK();
          AppMethodBeat.o(104286);
        }
      });
      if (this.sYZ != null) {
        Log.i("MicroMsg.FaceReflectCam", "stop camera thread");
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(500L, 0);
        if (Build.VERSION.SDK_INT >= 18) {
          this.sYZ.quitSafely();
        }
      }
      catch (InterruptedException paramSurfaceTexture)
      {
        try
        {
          this.sYZ.join();
          this.sYZ = null;
          this.sZa = null;
          Log.i("MicroMsg.FaceReflectCam", "stop camera thread finish");
          AppMethodBeat.o(104298);
          return false;
          paramSurfaceTexture = paramSurfaceTexture;
          Log.i("MicroMsg.FaceReflectCam", "background thread sleep error：" + paramSurfaceTexture.getMessage());
          continue;
          this.sYZ.quit();
          continue;
        }
        catch (InterruptedException paramSurfaceTexture)
        {
          Log.i("MicroMsg.FaceReflectCam", "stop xbackground thread error：" + paramSurfaceTexture.getMessage());
          continue;
        }
      }
      Log.i("MicroMsg.FaceReflectCam", "back thread is not running");
    }
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a
 * JD-Core Version:    0.7.0.1
 */