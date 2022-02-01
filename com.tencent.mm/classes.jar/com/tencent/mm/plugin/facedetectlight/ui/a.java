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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionMask;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.2;
import com.tencent.mm.plugin.flash.view.FaceReflectMask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  implements TextureView.SurfaceTextureListener
{
  boolean enable;
  private String iSn;
  private boolean isFrontCamera;
  private d.a.a lbk;
  private Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  private Point sdD;
  public ImageView seg;
  private Camera.PreviewCallback wBC;
  d.b wBD;
  private FaceActionUI wDG;
  public int wDk;
  public String wDl;
  public FaceActionMask wEc;
  private com.tencent.mm.plugin.facedetectaction.b.a.a wEq;
  private MMTextureView wFa;
  private HandlerThread wFb;
  private MMHandler wFc;
  public w wFd;
  private volatile boolean wFe;
  public volatile boolean wFf;
  public TextView wFg;
  private FaceReflectMask wFh;
  public PreviewFrameLayout wFi;
  private int wFj;
  public ImageView wFk;
  private Bitmap wFl;
  private boolean wFm;
  private int wFn;
  public MMHandler wFo;
  int wFp;
  private volatile AtomicInteger wFq;
  boolean wFr;
  private Point wxB;
  private Point wxC;
  private boolean wxD;
  private int wxE;
  private Point wxG;
  public volatile boolean wzA;
  
  public a(FaceActionUI paramFaceActionUI, com.tencent.mm.plugin.facedetectaction.b.a.a parama)
  {
    AppMethodBeat.i(104295);
    this.wxB = null;
    this.sdD = null;
    this.wxC = null;
    this.wxG = null;
    this.wFj = 0;
    this.wFo = new MMHandler("mPreviewHandlerThread");
    this.wFp = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKZ, 5);
    this.wFq = new AtomicInteger(0);
    this.enable = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKX, true);
    this.wFr = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vLa, false);
    this.wBC = new Camera.PreviewCallback()
    {
      public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(194835);
        if (!a.this.wFr)
        {
          if (a.a(a.this) != null)
          {
            if ((a.this.enable) && (a.b(a.this).get() >= a.this.wFp))
            {
              Log.i("MicroMsg.FaceReflectCam", "drop frame  %d", new Object[] { Integer.valueOf(a.b(a.this).get()) });
              AppMethodBeat.o(194835);
              return;
            }
            MMHandler localMMHandler = a.a(a.this);
            if (a.this.enable) {}
            for (paramAnonymousArrayOfByte = new a.a(a.this, paramAnonymousArrayOfByte, paramAnonymousCamera);; paramAnonymousArrayOfByte = new a.b(a.this, paramAnonymousArrayOfByte, paramAnonymousCamera))
            {
              localMMHandler.postToWorker(paramAnonymousArrayOfByte);
              AppMethodBeat.o(194835);
              return;
            }
          }
        }
        else if ((a.this.wFf) && (a.this.wzA) && (a.c(a.this) == 2)) {
          com.tencent.mm.plugin.facedetectaction.b.a.b.djd().a(paramAnonymousArrayOfByte, paramAnonymousCamera);
        }
        AppMethodBeat.o(194835);
      }
    };
    this.wBD = new d.b()
    {
      public final void bQ(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(104293);
        com.tencent.mm.plugin.facedetect.model.c.wwx.as(paramAnonymousArrayOfByte);
        AppMethodBeat.o(104293);
      }
      
      public final com.tencent.mm.memory.a<byte[]> dhW()
      {
        return com.tencent.mm.plugin.facedetect.model.c.wwx;
      }
    };
    this.wFn = 2;
    this.wDG = paramFaceActionUI;
    this.wFe = false;
    this.wzA = false;
    this.wFb = null;
    this.wFe = false;
    this.wFm = false;
    this.wEq = parama;
    Log.i("MicroMsg.FaceReflectCam", "clicfg_face_action_copy_data :%b，enableCameraPreviewSy：%b", new Object[] { Boolean.valueOf(this.enable), Boolean.valueOf(this.wFr) });
    AppMethodBeat.o(104295);
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(104304);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new a.c((byte)0));
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
    label245:
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
            break label352;
          }
          k = j;
          if (m == 0) {
            break label359;
          }
        }
        label352:
        label359:
        for (int m = i;; m = j)
        {
          Log.d("MicroMsg.FaceReflectCam", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!l(k, m, l))) {
            break label366;
          }
          paramParameters = new Point(i, j);
          Log.i("MicroMsg.FaceReflectCam", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
          AppMethodBeat.o(104304);
          return paramParameters;
          m = 0;
          break;
          k = i;
          break label245;
        }
        label366:
        f2 = Math.abs(k / m - f3);
        if (i % 10 == 0)
        {
          if ((f2 >= f1) || (!l(i, j, l))) {
            break label550;
          }
          localPoint = new Point(i, j);
          f1 = f2;
        }
      }
    }
    label536:
    label550:
    for (;;)
    {
      Log.i("MicroMsg.FaceReflectCam", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        if (paramParameters == null) {
          break label536;
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
  
  private static void d(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(104305);
    if (af.juH.jpZ > 0)
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
  
  private boolean dji()
  {
    AppMethodBeat.i(104300);
    Log.i("MicroMsg.FaceReflectCam", "start open camera");
    this.wFe = false;
    this.isFrontCamera = true;
    Object localObject1 = com.tencent.mm.compatible.c.a.jnC;
    int j = com.tencent.mm.compatible.c.a.atL();
    int i = 0;
    if (i < j)
    {
      localObject1 = new Camera.CameraInfo();
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject1);
      if ((((Camera.CameraInfo)localObject1).facing == 1) && (this.isFrontCamera)) {
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
        if ((((Camera.CameraInfo)localObject1).facing == 0) && (!this.isFrontCamera))
        {
          Log.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
          continue;
        }
        i += 1;
        break;
      }
      long l = Util.currentTicks();
      Log.i("MicroMsg.FaceReflectCam", "openCameraRes：" + this.lbk);
      if (this.lbk == null)
      {
        Log.i("MicroMsg.FaceReflectCam", "openCameraRes is null");
        if (this.wFn != 1) {
          break label294;
        }
        Log.i("MicroMsg.FaceReflectCam", "mFaceReflectController openCameraRe");
      }
      for (;;)
      {
        try
        {
          this.lbk = com.tencent.mm.compatible.deviceinfo.d.D(this.mContext, i);
          if (this.lbk != null) {
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
        label294:
        this.lbk = com.tencent.mm.compatible.deviceinfo.d.D(this.wDG.getContext(), i);
      }
      this.wFj = i;
      this.wFe = true;
      Log.d("MicroMsg.FaceReflectCam", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
      this.wxE = this.lbk.fSM;
      boolean bool;
      if (this.lbk.fSM % 180 != 0)
      {
        bool = true;
        this.wxD = bool;
        this.wFd = this.lbk.jqD;
        if (this.wFd == null)
        {
          Log.e("MicroMsg.FaceReflectCam", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.wxD) });
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
          localParameters = this.wFd.avd();
          if (this.wFn != 1) {
            break label581;
          }
          j = this.mContext.getResources().getDisplayMetrics().widthPixels;
          i = this.mContext.getResources().getDisplayMetrics().heightPixels;
          if (localParameters != null) {
            break label614;
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
        label581:
        j = this.wDG.getResources().getDisplayMetrics().widthPixels;
        i = this.wDG.getResources().getDisplayMetrics().heightPixels;
      }
      label614:
      this.sdD = new Point(j, i);
      Point localPoint2 = this.sdD;
      Point localPoint1 = this.wxC;
      Object localObject3 = localParameters.get("preview-size-values");
      if (localObject3 == null) {
        localObject3 = localParameters.get("preview-size-value");
      }
      for (;;)
      {
        Object localObject2 = null;
        if (localObject3 != null)
        {
          Log.d("MicroMsg.FaceReflectCam", "preview-size-values parameter: ".concat(String.valueOf(localObject3)));
          localObject2 = a(localParameters, localPoint2);
        }
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = new Point(localPoint1.x >> 3 << 3, localPoint1.y >> 3 << 3);
        }
        this.wxB = ((Point)localObject3);
        this.wxG = new Point(this.wxB);
        Log.d("MicroMsg.FaceReflectCam", "getCameraResolution: " + this.sdD + " camera:" + this.wxB + "bestVideoEncodeSize: " + this.wxG);
        this.mDesiredPreviewWidth = this.wxB.x;
        this.mDesiredPreviewHeight = this.wxB.y;
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
            localObject3 = ((List)localObject2).iterator();
            i = 0;
            if (!((Iterator)localObject3).hasNext()) {
              break label1475;
            }
            j = ((Integer)((Iterator)localObject3).next()).intValue();
            Log.d("MicroMsg.FaceReflectCam", "supportedPreviewFormat: ".concat(String.valueOf(j)));
            if (j != 17) {
              break;
            }
            j = 1;
            if (j == 0) {
              break label1270;
            }
            localParameters.setPreviewFormat(17);
            label1028:
            if (this.wxD) {
              localParameters.setRotation(this.wxE);
            }
            double d1 = this.wFi.getmAspectRatio();
            Log.d("MicroMsg.FaceReflectCam", "original ratio=".concat(String.valueOf(d1)));
            d2 = this.mDesiredPreviewWidth / this.mDesiredPreviewHeight;
            Log.d("MicroMsg.FaceReflectCam", "new ratio=".concat(String.valueOf(d2)));
            if (d1 != d2) {
              break label1339;
            }
            Log.d("MicroMsg.FaceReflectCam", "NO NEED reset ratio");
            label1108:
            d(localParameters);
            localObject2 = localParameters.getSupportedPreviewFpsRange();
            Log.d("MicroMsg.FaceReflectCam", "range:" + ((List)localObject2).size());
            i = 0;
            label1151:
            if (i >= ((List)localObject2).size()) {
              break label1371;
            }
            localObject3 = (int[])((List)localObject2).get(i);
            j = 0;
            while (j < localObject3.length)
            {
              Log.i("MicroMsg.FaceReflectCam", "Camera SupportedPreviewFpsRange：", new Object[] { Integer.valueOf(localObject3[j]) });
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
              label1270:
              if (i != 0)
              {
                Log.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                localParameters.setPreviewFormat(842094169);
                break label1028;
              }
              Log.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { localException3.get(0) });
              localParameters.setPreviewFormat(((Integer)localException3.get(0)).intValue());
              break label1028;
              label1339:
              Log.d("MicroMsg.FaceReflectCam", "start reset ratio");
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(104288);
                  Log.d("MicroMsg.FaceReflectCam", "reset ratio");
                  int i = a.this.wFi.getContext().getResources().getDisplayMetrics().widthPixels;
                  RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)a.this.wFi.getLayoutParams();
                  localLayoutParams.width = ((int)(i * 0.7D));
                  localLayoutParams.height = ((int)(localLayoutParams.width * d2));
                  localLayoutParams.addRule(13, -1);
                  a.this.wFi.setLayoutParams(localLayoutParams);
                  a.this.wFi.setAspectRatio(d2);
                  Log.d("MicroMsg.FaceReflectCam", "after reset ratio=" + a.this.wFi.getmAspectRatio());
                  AppMethodBeat.o(104288);
                }
              });
              break label1108;
              i += 1;
              break label1151;
              label1371:
              Log.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + localParameters.get("preview-fps-range"));
              Log.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + localParameters.get("preview-frame-rate"));
              try
              {
                this.wFd.c(localParameters);
                bool = this.wFe;
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
            label1475:
            j = 0;
          }
        }
      }
      i = -1;
    }
  }
  
  private void k(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(104297);
    Log.i("MicroMsg.FaceReflectCam", "openCameraForSurfaceTexture");
    if (this.wFn == 1) {
      this.wFh.setVisibility(0);
    }
    for (;;)
    {
      djj();
      if (this.wFc == null) {
        break;
      }
      this.wFc.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104285);
          a.a(a.this, a.g(a.this));
          com.tencent.mm.plugin.report.service.h localh;
          if (!a.h(a.this))
          {
            localh = com.tencent.mm.plugin.report.service.h.IzE;
            if (a.c(a.this) == 1)
            {
              l = 3L;
              localh.idkeyStat(917L, l, 1L, false);
              a.a(a.this, a.g(a.this));
            }
          }
          else
          {
            localh = com.tencent.mm.plugin.report.service.h.IzE;
            if (a.c(a.this) != 1) {
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
                AppMethodBeat.i(195352);
                if ((a.i(a.this) == null) || (a.i(a.this).jtb) || (!a.h(a.this)))
                {
                  Log.e("MicroMsg.FaceReflectCam", "camera is null or has released!");
                  AppMethodBeat.o(195352);
                  return;
                }
                Object localObject;
                Context localContext;
                Camera localCamera;
                int i;
                int j;
                Point localPoint;
                if (a.c(a.this) != 1)
                {
                  localObject = com.tencent.mm.plugin.facedetectaction.b.a.b.djd();
                  localContext = a.j(a.this).getApplicationContext();
                  FaceActionUI localFaceActionUI = a.j(a.this);
                  localCamera = a.i(a.this).jta;
                  i = a.k(a.this);
                  TextView localTextView = a.this.wFg;
                  a.l(a.this);
                  j = a.m(a.this);
                  localPoint = new Point(a.n(a.this), a.o(a.this));
                  int k = a.p(a.this);
                  String str = a.q(a.this);
                  int m = a.n(a.this);
                  int n = a.o(a.this);
                  Log.i("MicroMsg.FaceActionLogic", "initFaceDetect（）");
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).mContext = localContext;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).oLx = i;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDm = localTextView;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDp = localFaceActionUI.getResources().getDisplayMetrics().widthPixels;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDq = localFaceActionUI.getResources().getDisplayMetrics().heightPixels;
                  Log.i("MicroMsg.FaceActionLogic", "mUiWidth:%s  mUiHeight：%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDp), Integer.valueOf(((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDq) });
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDk = k;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDl = str;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).mDesiredPreviewWidth = m;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).mDesiredPreviewHeight = n;
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDn = new Rect(0, 0, 0, 0);
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDo = new Rect(0, 0, 0, 0);
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDs = true;
                  Log.i("MicroMsg.FaceActionLogic", "action：%s,mActionHint:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDk), ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDl });
                  if (((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDl == null) {
                    break label531;
                  }
                  ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDm.setText(((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDl);
                }
                for (;;)
                {
                  YTPoseDetectInterface.start(localContext.getApplicationContext(), localCamera, i, new com.tencent.mm.plugin.facedetectaction.b.a.1((com.tencent.mm.plugin.facedetectaction.b.a)localObject));
                  Log.i("MicroMsg.FaceActionLogic", "init face detect, camera, rotate: %s", new Object[] { Integer.valueOf(j) });
                  com.tencent.mm.plugin.facedetectaction.b.d.wDy.lgP = j;
                  localObject = com.tencent.mm.plugin.facedetectaction.b.d.wDy;
                  i = localPoint.x;
                  j = localPoint.y;
                  ((com.tencent.mm.plugin.facedetectaction.b.d)localObject).wDE = i;
                  ((com.tencent.mm.plugin.facedetectaction.b.d)localObject).wDF = j;
                  AppMethodBeat.o(195352);
                  return;
                  label531:
                  switch (((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDk)
                  {
                  default: 
                    break;
                  case 1: 
                    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDm.setText(a.i.face_action_blink);
                    break;
                  case 2: 
                    ((com.tencent.mm.plugin.facedetectaction.b.a)localObject).wDm.setText(a.i.face_action_open);
                  }
                }
              }
            });
            AppMethodBeat.o(104285);
            return;
            l = 39L;
            break;
          }
        }
      });
      this.wFc.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104286);
          try
          {
            a.a(a.this, paramSurfaceTexture);
            a locala = a.this;
            Camera.PreviewCallback localPreviewCallback = a.r(a.this);
            if (locala.wFd == null) {
              Log.w("MicroMsg.FaceReflectCam", "hy: camera is null. setPreviewCallback failed");
            }
            for (;;)
            {
              com.tencent.mm.plugin.flash.c.b.aHi("openCamera");
              AppMethodBeat.o(104286);
              return;
              int j = locala.mDesiredPreviewWidth * locala.mDesiredPreviewHeight * ImageFormat.getBitsPerPixel(locala.wFd.avd().getPreviewFormat()) / 8;
              int i = 0;
              while (i < locala.wFp)
              {
                byte[] arrayOfByte = com.tencent.mm.plugin.facedetect.model.c.wwx.k(Integer.valueOf(j));
                locala.wFd.aj(arrayOfByte);
                i += 1;
              }
              locala.wFd.b(new a.2(locala, localPreviewCallback));
              com.tencent.mm.plugin.facedetect.model.d.dhV().a(locala.wBD);
            }
            FaceActionUI localFaceActionUI;
            return;
          }
          catch (Exception localException)
          {
            com.tencent.mm.plugin.flash.c.b.s("openCamera", Integer.valueOf(-1));
            if (a.c(a.this) != 1)
            {
              Log.i("MicroMsg.FaceReflectCam", "preview error");
              localFaceActionUI = a.j(a.this);
              com.tencent.e.h.ZvG.bc(new FaceActionUI.2(localFaceActionUI));
            }
            AppMethodBeat.o(104286);
          }
        }
      });
      AppMethodBeat.o(104297);
      return;
      this.wEc.setVisibility(0);
    }
    Log.i("MicroMsg.FaceReflectCam", "back thread is not running");
    AppMethodBeat.o(104297);
  }
  
  private static boolean l(int paramInt1, int paramInt2, long paramLong)
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
    this.wFa = paramMMTextureView;
    if (this.wFa.isAvailable()) {
      k(paramMMTextureView.getSurfaceTexture());
    }
    this.wFa.setSurfaceTextureListener(this);
    this.wFa.setVisibility(0);
    this.wFa.setAlpha(0.0F);
    if ((this.wFn == 2) && (!this.wFm)) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104284);
          a.d(a.this).setVisibility(8);
          a.e(a.this).setVisibility(8);
          a.f(a.this);
          AppMethodBeat.o(104284);
        }
      }, 700L);
    }
    AppMethodBeat.o(104296);
  }
  
  public final void aYA()
  {
    AppMethodBeat.i(104302);
    Log.i("MicroMsg.FaceReflectCam", "closeCamera start");
    this.wFa = null;
    this.wEq = null;
    if (this.wFo != null)
    {
      this.wFo.quit();
      this.wFo = null;
    }
    if (this.wFd != null) {}
    try
    {
      if (this.wzA)
      {
        this.wzA = false;
        this.wFd.TL();
        this.wFd.a(null);
        Log.i("MicroMsg.FaceReflectCam", "stop preview, not previewing");
      }
      try
      {
        this.wFd.release();
        this.wFd = null;
        com.tencent.mm.plugin.facedetect.model.d.dhV().b(this.wBD);
        com.tencent.mm.plugin.facedetectaction.b.a.b.djd().wDm = null;
        this.wFd = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException2.getMessage());
          this.wFd = null;
        }
      }
      finally
      {
        this.wFd = null;
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
  
  public final void djj()
  {
    AppMethodBeat.i(104303);
    if (this.wFb == null)
    {
      Log.i("MicroMsg.FaceReflectCam", "start camera thread");
      this.wFb = com.tencent.e.c.d.il("cameraBackground", 5);
      this.wFb.start();
      this.wFc = new MMHandler(this.wFb.getLooper());
    }
    AppMethodBeat.o(104303);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104299);
    Log.i("MicroMsg.FaceReflectCam", "onSurfaceTextureAvailable, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    k(paramSurfaceTexture);
    AppMethodBeat.o(104299);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(104298);
    Log.i("MicroMsg.FaceReflectCam", "surfaceDestroyed");
    if (this.wFc != null)
    {
      this.wFc.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104287);
          a.this.aYA();
          AppMethodBeat.o(104287);
        }
      });
      if (this.wFb != null) {
        Log.i("MicroMsg.FaceReflectCam", "stop camera thread");
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(500L, 0);
        if (Build.VERSION.SDK_INT >= 18) {
          this.wFb.quitSafely();
        }
      }
      catch (InterruptedException paramSurfaceTexture)
      {
        try
        {
          this.wFb.join();
          this.wFb = null;
          this.wFc = null;
          Log.i("MicroMsg.FaceReflectCam", "stop camera thread finish");
          AppMethodBeat.o(104298);
          return false;
          paramSurfaceTexture = paramSurfaceTexture;
          Log.i("MicroMsg.FaceReflectCam", "background thread sleep error：" + paramSurfaceTexture.getMessage());
          continue;
          this.wFb.quit();
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
  
  final class a
    implements Runnable
  {
    private Camera jta;
    private byte[] wFx;
    
    a(byte[] paramArrayOfByte, Camera paramCamera)
    {
      AppMethodBeat.i(193122);
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
      this.wFx = arrayOfByte;
      this.jta = paramCamera;
      a.b(a.this).set(a.b(a.this).get() + 1);
      AppMethodBeat.o(193122);
    }
    
    public final void run()
    {
      AppMethodBeat.i(193127);
      if ((a.this.wFf) && (a.this.wzA) && (a.c(a.this) == 2) && (this.wFx != null) && (this.wFx.length > 0))
      {
        com.tencent.mm.plugin.facedetectaction.b.a.b.djd().a(this.wFx, this.jta);
        this.wFx = null;
        a.b(a.this).set(a.b(a.this).get() - 1);
      }
      AppMethodBeat.o(193127);
    }
  }
  
  final class b
    implements Runnable
  {
    private byte[] data;
    private Camera jta;
    
    b(byte[] paramArrayOfByte, Camera paramCamera)
    {
      this.data = paramArrayOfByte;
      this.jta = paramCamera;
    }
    
    public final void run()
    {
      AppMethodBeat.i(190813);
      if ((a.this.wFf) && (a.this.wzA) && (a.c(a.this) == 2)) {
        com.tencent.mm.plugin.facedetectaction.b.a.b.djd().a(this.data, this.jta);
      }
      AppMethodBeat.o(190813);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a
 * JD-Core Version:    0.7.0.1
 */