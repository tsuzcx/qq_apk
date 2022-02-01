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
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.k;
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
import com.tencent.threadpool.i;
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
  private com.tencent.mm.plugin.facedetectaction.model.a.a AaB;
  public FaceActionMask Aan;
  boolean AbA;
  private MMTextureView Abl;
  private HandlerThread Abm;
  private MMHandler Abn;
  public w Abo;
  public TextView Abp;
  private FaceReflectMask Abq;
  public PreviewFrameLayout Abr;
  private int Abs;
  public ImageView Abt;
  private Bitmap Abu;
  private boolean Abv;
  private int Abw;
  public MMHandler Abx;
  int Aby;
  private volatile AtomicInteger Abz;
  boolean enable;
  private boolean isFrontCamera;
  private String luk;
  private Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  private volatile boolean mIsCameraOpened;
  private d.a.a nGr;
  public volatile boolean nvB;
  public ImageView vpW;
  private Point vpf;
  private Point zTH;
  private Point zTI;
  private boolean zTJ;
  private int zTK;
  private Point zTM;
  public volatile boolean zVL;
  private Camera.PreviewCallback zXN;
  d.b zXO;
  private FaceActionUI zZR;
  public int zZv;
  public String zZw;
  
  public a(FaceActionUI paramFaceActionUI, com.tencent.mm.plugin.facedetectaction.model.a.a parama)
  {
    AppMethodBeat.i(104295);
    this.zTH = null;
    this.vpf = null;
    this.zTI = null;
    this.zTM = null;
    this.Abs = 0;
    this.Abx = new MMHandler("mPreviewHandlerThread");
    this.Aby = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbz, 5);
    this.Abz = new AtomicInteger(0);
    this.enable = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbx, true);
    this.AbA = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbA, false);
    this.zXN = new Camera.PreviewCallback()
    {
      public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(260940);
        if (!a.this.AbA)
        {
          if (a.a(a.this) != null)
          {
            if ((a.this.enable) && (a.b(a.this).get() >= a.this.Aby))
            {
              Log.i("MicroMsg.FaceReflectCam", "drop frame  %d", new Object[] { Integer.valueOf(a.b(a.this).get()) });
              AppMethodBeat.o(260940);
              return;
            }
            MMHandler localMMHandler = a.a(a.this);
            if (a.this.enable) {}
            for (paramAnonymousArrayOfByte = new a.a(a.this, paramAnonymousArrayOfByte, paramAnonymousCamera);; paramAnonymousArrayOfByte = new a.b(a.this, paramAnonymousArrayOfByte, paramAnonymousCamera))
            {
              localMMHandler.postToWorker(paramAnonymousArrayOfByte);
              AppMethodBeat.o(260940);
              return;
            }
          }
        }
        else if ((a.this.nvB) && (a.this.zVL) && (a.c(a.this) == 2)) {
          com.tencent.mm.plugin.facedetectaction.model.a.b.dPO().a(paramAnonymousArrayOfByte, paramAnonymousCamera);
        }
        AppMethodBeat.o(260940);
      }
    };
    this.zXO = new d.b()
    {
      public final void bQ(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(104293);
        com.tencent.mm.plugin.facedetect.model.c.zSD.as(paramAnonymousArrayOfByte);
        AppMethodBeat.o(104293);
      }
      
      public final com.tencent.mm.memory.a<byte[]> dOH()
      {
        return com.tencent.mm.plugin.facedetect.model.c.zSD;
      }
    };
    this.Abw = 2;
    this.zZR = paramFaceActionUI;
    this.mIsCameraOpened = false;
    this.zVL = false;
    this.Abm = null;
    this.mIsCameraOpened = false;
    this.Abv = false;
    this.AaB = parama;
    Log.i("MicroMsg.FaceReflectCam", "clicfg_face_action_copy_data :%b，enableCameraPreviewSy：%b", new Object[] { Boolean.valueOf(this.enable), Boolean.valueOf(this.AbA) });
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
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!m(k, m, l))) {
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
          if ((f2 >= f1) || (!m(i, j, l))) {
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
  
  private boolean dPT()
  {
    AppMethodBeat.i(104300);
    Log.i("MicroMsg.FaceReflectCam", "start open camera");
    this.mIsCameraOpened = false;
    this.isFrontCamera = true;
    Object localObject1 = com.tencent.mm.compatible.c.a.lQF;
    int j = com.tencent.mm.compatible.c.a.aOk();
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
      Log.i("MicroMsg.FaceReflectCam", "openCameraRes：" + this.nGr);
      if (this.nGr == null)
      {
        Log.i("MicroMsg.FaceReflectCam", "openCameraRes is null");
        if (this.Abw != 1) {
          break label294;
        }
        Log.i("MicroMsg.FaceReflectCam", "mFaceReflectController openCameraRe");
      }
      for (;;)
      {
        try
        {
          this.nGr = com.tencent.mm.compatible.deviceinfo.d.G(this.mContext, i);
          if (this.nGr != null) {
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
        this.nGr = com.tencent.mm.compatible.deviceinfo.d.G(this.zZR.getContext(), i);
      }
      this.Abs = i;
      this.mIsCameraOpened = true;
      Log.d("MicroMsg.FaceReflectCam", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
      this.zTK = this.nGr.hYK;
      boolean bool;
      if (this.nGr.hYK % 180 != 0)
      {
        bool = true;
        this.zTJ = bool;
        this.Abo = this.nGr.lTN;
        if (this.Abo == null)
        {
          Log.e("MicroMsg.FaceReflectCam", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.zTJ) });
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
          localParameters = this.Abo.aPy();
          if (this.Abw != 1) {
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
        j = this.zZR.getResources().getDisplayMetrics().widthPixels;
        i = this.zZR.getResources().getDisplayMetrics().heightPixels;
      }
      label614:
      this.vpf = new Point(j, i);
      Point localPoint2 = this.vpf;
      Point localPoint1 = this.zTI;
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
        this.zTH = ((Point)localObject3);
        this.zTM = new Point(this.zTH);
        Log.d("MicroMsg.FaceReflectCam", "getCameraResolution: " + this.vpf + " camera:" + this.zTH + "bestVideoEncodeSize: " + this.zTM);
        this.mDesiredPreviewWidth = this.zTH.x;
        this.mDesiredPreviewHeight = this.zTH.y;
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
            if (this.zTJ) {
              localParameters.setRotation(this.zTK);
            }
            double d1 = this.Abr.getmAspectRatio();
            Log.d("MicroMsg.FaceReflectCam", "original ratio=".concat(String.valueOf(d1)));
            d2 = this.mDesiredPreviewWidth / this.mDesiredPreviewHeight;
            Log.d("MicroMsg.FaceReflectCam", "new ratio=".concat(String.valueOf(d2)));
            if (d1 != d2) {
              break label1339;
            }
            Log.d("MicroMsg.FaceReflectCam", "NO NEED reset ratio");
            label1108:
            f(localParameters);
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
                  int i = a.this.Abr.getContext().getResources().getDisplayMetrics().widthPixels;
                  RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)a.this.Abr.getLayoutParams();
                  localLayoutParams.width = ((int)(i * 0.7D));
                  localLayoutParams.height = ((int)(localLayoutParams.width * d2));
                  localLayoutParams.addRule(13, -1);
                  a.this.Abr.setLayoutParams(localLayoutParams);
                  a.this.Abr.setAspectRatio(d2);
                  Log.d("MicroMsg.FaceReflectCam", "after reset ratio=" + a.this.Abr.getmAspectRatio());
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
                this.Abo.c(localParameters);
                bool = this.mIsCameraOpened;
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
  
  private static void f(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(104305);
    if (af.lXY.lTg > 0)
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
  
  private void j(final SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(104297);
    Log.i("MicroMsg.FaceReflectCam", "openCameraForSurfaceTexture");
    if (this.Abw == 1) {
      this.Abq.setVisibility(0);
    }
    for (;;)
    {
      dPU();
      if (this.Abn == null) {
        break;
      }
      this.Abn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104285);
          a.a(a.this, a.g(a.this));
          com.tencent.mm.plugin.report.service.h localh;
          if (!a.h(a.this))
          {
            localh = com.tencent.mm.plugin.report.service.h.OAn;
            if (a.c(a.this) == 1)
            {
              l = 3L;
              localh.idkeyStat(917L, l, 1L, false);
              a.a(a.this, a.g(a.this));
            }
          }
          else
          {
            localh = com.tencent.mm.plugin.report.service.h.OAn;
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
                AppMethodBeat.i(260943);
                if ((a.i(a.this) == null) || (a.i(a.this).lWt) || (!a.h(a.this)))
                {
                  Log.e("MicroMsg.FaceReflectCam", "camera is null or has released!");
                  AppMethodBeat.o(260943);
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
                  localObject = com.tencent.mm.plugin.facedetectaction.model.a.b.dPO();
                  localContext = a.j(a.this).getApplicationContext();
                  FaceActionUI localFaceActionUI = a.j(a.this);
                  localCamera = a.i(a.this).lWs;
                  i = a.k(a.this);
                  TextView localTextView = a.this.Abp;
                  a.l(a.this);
                  j = a.m(a.this);
                  localPoint = new Point(a.n(a.this), a.o(a.this));
                  int k = a.p(a.this);
                  String str = a.q(a.this);
                  int m = a.n(a.this);
                  int n = a.o(a.this);
                  Log.i("MicroMsg.FaceActionLogic", "initFaceDetect（）");
                  ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).mContext = localContext;
                  ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zS = i;
                  ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZx = localTextView;
                  ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZA = localFaceActionUI.getResources().getDisplayMetrics().widthPixels;
                  ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZB = localFaceActionUI.getResources().getDisplayMetrics().heightPixels;
                  Log.i("MicroMsg.FaceActionLogic", "mUiWidth:%s  mUiHeight：%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZA), Integer.valueOf(((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZB) });
                  ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZv = k;
                  ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZw = str;
                  ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).mDesiredPreviewWidth = m;
                  ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).mDesiredPreviewHeight = n;
                  ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZy = new Rect(0, 0, 0, 0);
                  ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZz = new Rect(0, 0, 0, 0);
                  ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZD = true;
                  Log.i("MicroMsg.FaceActionLogic", "action：%s,mActionHint:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZv), ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZw });
                  if (((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZw == null) {
                    break label531;
                  }
                  ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZx.setText(((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZw);
                }
                for (;;)
                {
                  YTPoseDetectInterface.start(localContext.getApplicationContext(), localCamera, i, new com.tencent.mm.plugin.facedetectaction.model.a.1((com.tencent.mm.plugin.facedetectaction.model.a)localObject));
                  Log.i("MicroMsg.FaceActionLogic", "init face detect, camera, rotate: %s", new Object[] { Integer.valueOf(j) });
                  com.tencent.mm.plugin.facedetectaction.model.c.zZJ.nLz = j;
                  localObject = com.tencent.mm.plugin.facedetectaction.model.c.zZJ;
                  i = localPoint.x;
                  j = localPoint.y;
                  ((com.tencent.mm.plugin.facedetectaction.model.c)localObject).zZP = i;
                  ((com.tencent.mm.plugin.facedetectaction.model.c)localObject).zZQ = j;
                  AppMethodBeat.o(260943);
                  return;
                  label531:
                  switch (((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZv)
                  {
                  default: 
                    break;
                  case 1: 
                    ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZx.setText(a.i.face_action_blink);
                    break;
                  case 2: 
                    ((com.tencent.mm.plugin.facedetectaction.model.a)localObject).zZx.setText(a.i.face_action_open);
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
      this.Abn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104286);
          try
          {
            a.a(a.this, paramSurfaceTexture);
            a locala = a.this;
            Camera.PreviewCallback localPreviewCallback = a.r(a.this);
            if (locala.Abo == null) {
              Log.w("MicroMsg.FaceReflectCam", "hy: camera is null. setPreviewCallback failed");
            }
            for (;;)
            {
              b.aDA("openCamera");
              AppMethodBeat.o(104286);
              return;
              int j = locala.mDesiredPreviewWidth * locala.mDesiredPreviewHeight * ImageFormat.getBitsPerPixel(locala.Abo.aPy().getPreviewFormat()) / 8;
              int i = 0;
              while (i < locala.Aby)
              {
                byte[] arrayOfByte = com.tencent.mm.plugin.facedetect.model.c.zSD.m(Integer.valueOf(j));
                locala.Abo.aj(arrayOfByte);
                i += 1;
              }
              locala.Abo.b(new a.2(locala, localPreviewCallback));
              com.tencent.mm.plugin.facedetect.model.d.dOG().a(locala.zXO);
            }
            FaceActionUI localFaceActionUI;
            return;
          }
          catch (Exception localException)
          {
            b.F("openCamera", Integer.valueOf(-1));
            if (a.c(a.this) != 1)
            {
              Log.i("MicroMsg.FaceReflectCam", "preview error");
              localFaceActionUI = a.j(a.this);
              com.tencent.threadpool.h.ahAA.bk(new FaceActionUI.2(localFaceActionUI));
            }
            AppMethodBeat.o(104286);
          }
        }
      });
      AppMethodBeat.o(104297);
      return;
      this.Aan.setVisibility(0);
    }
    Log.i("MicroMsg.FaceReflectCam", "back thread is not running");
    AppMethodBeat.o(104297);
  }
  
  private static boolean m(int paramInt1, int paramInt2, long paramLong)
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
    this.Abl = paramMMTextureView;
    if (this.Abl.isAvailable()) {
      j(paramMMTextureView.getSurfaceTexture());
    }
    this.Abl.setSurfaceTextureListener(this);
    this.Abl.setVisibility(0);
    this.Abl.setAlpha(0.0F);
    if ((this.Abw == 2) && (!this.Abv)) {
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
  
  public final void bty()
  {
    AppMethodBeat.i(104302);
    Log.i("MicroMsg.FaceReflectCam", "closeCamera start");
    this.Abl = null;
    this.AaB = null;
    if (this.Abx != null)
    {
      this.Abx.quit();
      this.Abx = null;
    }
    if (this.Abo != null) {}
    try
    {
      if (this.zVL)
      {
        this.zVL = false;
        this.Abo.auq();
        this.Abo.a(null);
        Log.i("MicroMsg.FaceReflectCam", "stop preview, not previewing");
      }
      try
      {
        this.Abo.release();
        this.Abo = null;
        com.tencent.mm.plugin.facedetect.model.d.dOG().b(this.zXO);
        com.tencent.mm.plugin.facedetectaction.model.a.b.dPO().zZx = null;
        this.Abo = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException2.getMessage());
          this.Abo = null;
        }
      }
      finally
      {
        this.Abo = null;
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
  
  public final void dPU()
  {
    AppMethodBeat.i(104303);
    if (this.Abm == null)
    {
      Log.i("MicroMsg.FaceReflectCam", "start camera thread");
      this.Abm = com.tencent.threadpool.c.d.jx("cameraBackground", 5);
      this.Abm.start();
      this.Abn = new MMHandler(this.Abm.getLooper());
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
    if (this.Abn != null)
    {
      this.Abn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104287);
          a.this.bty();
          AppMethodBeat.o(104287);
        }
      });
      if (this.Abm != null) {
        Log.i("MicroMsg.FaceReflectCam", "stop camera thread");
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(500L, 0);
        if (Build.VERSION.SDK_INT >= 18) {
          this.Abm.quitSafely();
        }
      }
      catch (InterruptedException paramSurfaceTexture)
      {
        try
        {
          this.Abm.join();
          this.Abm = null;
          this.Abn = null;
          Log.i("MicroMsg.FaceReflectCam", "stop camera thread finish");
          AppMethodBeat.o(104298);
          return false;
          paramSurfaceTexture = paramSurfaceTexture;
          Log.i("MicroMsg.FaceReflectCam", "background thread sleep error：" + paramSurfaceTexture.getMessage());
          continue;
          this.Abm.quit();
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
    private byte[] AbG;
    private Camera lWs;
    
    a(byte[] paramArrayOfByte, Camera paramCamera)
    {
      AppMethodBeat.i(260936);
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
      this.AbG = arrayOfByte;
      this.lWs = paramCamera;
      a.b(a.this).set(a.b(a.this).get() + 1);
      AppMethodBeat.o(260936);
    }
    
    public final void run()
    {
      AppMethodBeat.i(260938);
      if ((a.this.nvB) && (a.this.zVL) && (a.c(a.this) == 2) && (this.AbG != null) && (this.AbG.length > 0))
      {
        com.tencent.mm.plugin.facedetectaction.model.a.b.dPO().a(this.AbG, this.lWs);
        this.AbG = null;
        a.b(a.this).set(a.b(a.this).get() - 1);
      }
      AppMethodBeat.o(260938);
    }
  }
  
  final class b
    implements Runnable
  {
    private byte[] data;
    private Camera lWs;
    
    b(byte[] paramArrayOfByte, Camera paramCamera)
    {
      this.data = paramArrayOfByte;
      this.lWs = paramCamera;
    }
    
    public final void run()
    {
      AppMethodBeat.i(260941);
      if ((a.this.nvB) && (a.this.zVL) && (a.c(a.this) == 2)) {
        com.tencent.mm.plugin.facedetectaction.model.a.b.dPO().a(this.data, this.lWs);
      }
      AppMethodBeat.o(260941);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a
 * JD-Core Version:    0.7.0.1
 */