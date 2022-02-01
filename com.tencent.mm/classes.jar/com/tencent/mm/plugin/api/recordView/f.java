package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.f.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

public final class f
  extends MMSightRecordView.e
  implements g.a, d.a, com.tencent.mm.plugin.mmsight.model.g
{
  private int audioBitrate;
  private int audioSampleRate;
  private Context context;
  private int fps;
  private float laP;
  private boolean nrA;
  private int nrB;
  private Point nrC;
  private Point nrD;
  private boolean nrE;
  private boolean nrF;
  private boolean nrG;
  private g nrH;
  private MMSightRecordView.d nrI;
  private MMSightRecordView.c nrJ;
  private boolean nrK;
  private float nrL;
  private h nrM;
  private Point nrN;
  private com.tencent.tinker.a.c.b nrO;
  private byte[] nrP;
  private com.tencent.mm.plugin.mmsight.model.a.d nro;
  private com.tencent.mm.plugin.mmsight.model.f nrp;
  private int nrq;
  private int nrr;
  private int nrs;
  private int nrt;
  private boolean nru;
  private ObservableTextureView nrv;
  private MMSightCameraGLSurfaceView nrw;
  private boolean nrx;
  private MMSightRecordView.a nry;
  private boolean nrz;
  private int videoBitrate;
  private String videoPath;
  private WindowManager windowManager;
  
  public f()
  {
    AppMethodBeat.i(89226);
    this.nrs = 0;
    this.nru = true;
    this.nrx = false;
    this.nrz = false;
    this.nrA = false;
    this.nrB = -1;
    this.nrE = true;
    this.nrF = true;
    this.nrG = false;
    this.nrK = false;
    this.nrL = 1.0F;
    this.windowManager = null;
    this.nrM = null;
    this.nrN = new Point(0, 0);
    this.nrP = null;
    AppMethodBeat.o(89226);
  }
  
  private void b(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(89241);
    this.nrp.a(new f.b()
    {
      public final void a(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(89224);
        if (paramBoolean) {
          f.d(f.this).eTm();
        }
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousInt1 < 0) || (paramAnonymousInt2 < 0) || (paramAnonymousInt3 < 0))
        {
          Log.e("MicroMsg.MMSightRecordViewImpl", "onPictureYuvTaken, data is null!!");
          paramg.bRI();
          AppMethodBeat.o(89224);
          return;
        }
        for (;;)
        {
          try
          {
            if (!f.m(f.this)) {
              break label473;
            }
            f.n(f.this);
            if (f.d(f.this).EZC)
            {
              if (f.o(f.this).y >= paramAnonymousInt1) {
                break label473;
              }
              localObject = new byte[f.o(f.this).x * f.o(f.this).y * 3 >> 1];
              if (f.p(f.this) == 1)
              {
                SightVideoJNI.cropCameraDataLongEdgeCenterCrop(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, f.o(f.this).y, paramAnonymousInt2);
                paramAnonymousInt1 = f.o(f.this).y;
                paramAnonymousInt2 = f.o(f.this).x;
                paramAnonymousArrayOfByte = (byte[])localObject;
                paramAnonymousArrayOfByte = new YuvImage(paramAnonymousArrayOfByte, 17, paramAnonymousInt1, paramAnonymousInt2, null);
                localObject = new ByteArrayOutputStream();
                paramAnonymousArrayOfByte.compressToJpeg(new Rect(0, 0, paramAnonymousInt1, paramAnonymousInt2), 100, (OutputStream)localObject);
                paramAnonymousArrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
                localObject = MMBitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
                if (paramAnonymousInt4 == 90) {
                  break label476;
                }
                paramAnonymousInt1 = paramAnonymousInt3;
                if (paramAnonymousInt4 != 270) {
                  break label490;
                }
                break label476;
                label267:
                paramAnonymousArrayOfByte = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, false);
                label277:
                Log.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject.toString() });
                ((Bitmap)localObject).recycle();
                paramg.P(paramAnonymousArrayOfByte);
                AppMethodBeat.o(89224);
                return;
              }
              SightVideoJNI.cropCameraDataLongEdge(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, f.o(f.this).y, paramAnonymousInt2);
              continue;
            }
            if (f.o(f.this).x >= paramAnonymousInt2) {
              break label473;
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.MMSightRecordViewImpl", paramAnonymousArrayOfByte, "saveCaptureYuvDataToBitmap error: %s", new Object[] { paramAnonymousArrayOfByte.getMessage() });
            paramg.bRI();
            AppMethodBeat.o(89224);
            return;
          }
          Object localObject = new byte[f.o(f.this).x * f.o(f.this).y * 3 >> 1];
          SightVideoJNI.cropCameraData(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, paramAnonymousInt2, f.o(f.this).x);
          paramAnonymousInt1 = f.o(f.this).y;
          paramAnonymousInt2 = f.o(f.this).x;
          paramAnonymousArrayOfByte = (byte[])localObject;
          continue;
          label473:
          label476:
          label490:
          do
          {
            paramAnonymousArrayOfByte = BitmapUtil.rotate((Bitmap)localObject, paramAnonymousInt1);
            break label277;
            break;
            paramAnonymousInt1 = (paramAnonymousInt3 - paramAnonymousInt4 + 360) % 360;
            if (paramAnonymousInt1 == 0) {
              break label267;
            }
          } while (paramAnonymousInt1 != 360);
        }
      }
    }, false, getScreenRotation());
    AppMethodBeat.o(89241);
  }
  
  private void bBA()
  {
    AppMethodBeat.i(89252);
    if ((this.nrp != null) && (this.nrp.egx()))
    {
      if (this.nrp.EZC)
      {
        int i = (int)(this.nrp.getPreviewWidth() / this.laP);
        this.nrC = new Point(this.nrp.getPreviewWidth(), i);
        AppMethodBeat.o(89252);
        return;
      }
      this.nrC = new Point((int)(this.nrp.getPreviewHeight() * this.laP), this.nrp.getPreviewHeight());
    }
    AppMethodBeat.o(89252);
  }
  
  private void bBB()
  {
    AppMethodBeat.i(89254);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", new Object[] { Integer.valueOf(this.nrB) });
    switch (this.nrB)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89254);
      return;
      this.nrp.eTl();
      AppMethodBeat.o(89254);
      return;
      this.nrp.eTm();
      AppMethodBeat.o(89254);
      return;
      this.nrp.eTn();
    }
  }
  
  private void bBH()
  {
    AppMethodBeat.i(89267);
    Point localPoint = getPreviewSize();
    this.nrN.y = this.nrr;
    this.nrN.x = (localPoint.x * this.nrr / localPoint.y);
    if ((getScreenRotation() == 0) || (getScreenRotation() == 180))
    {
      int i = this.nrN.y;
      this.nrN.y = this.nrN.x;
      this.nrN.x = i;
    }
    if (this.nrM != null) {
      this.nrM.k(localPoint.x, localPoint.y, this.nrp.getOrientation(), this.nrN.x, this.nrN.y);
    }
    AppMethodBeat.o(89267);
  }
  
  private void bBy()
  {
    AppMethodBeat.i(89237);
    if (this.nrx)
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
      AppMethodBeat.o(89237);
      return;
    }
    if (this.nro != null)
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
      this.nro.cancel();
      if (this.nrp != null) {
        this.nrp.b(this.nro.getFrameDataCallback());
      }
      this.nro = null;
    }
    if ((this.nrq > 0) && (this.nrt > 0) && (this.videoBitrate > 0) && (this.fps > 0) && (this.audioBitrate > 0) && (this.audioSampleRate > 0) && (this.nrp != null) && (this.nrp.diO() != null))
    {
      VideoTransPara localVideoTransPara = new VideoTransPara();
      localVideoTransPara.width = this.nrq;
      localVideoTransPara.height = ((int)(this.nrq / this.laP));
      localVideoTransPara.duration = this.nrt;
      localVideoTransPara.videoBitrate = this.videoBitrate;
      localVideoTransPara.fps = this.fps;
      localVideoTransPara.audioBitrate = this.audioBitrate;
      localVideoTransPara.audioSampleRate = this.audioSampleRate;
      localVideoTransPara.lJm = 2;
      localVideoTransPara.lJn = 1;
      localVideoTransPara.kXt = 1;
      com.tencent.mm.plugin.mmsight.model.j.EZX.lgX = localVideoTransPara;
      com.tencent.mm.plugin.mmsight.model.j.EZX.videoBitrate = this.videoBitrate;
      com.tencent.mm.plugin.mmsight.model.j.EZX.laT = this.nrq;
      k.eTI();
      this.nro = k.q(localVideoTransPara);
      if (this.nro == null)
      {
        Log.e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
        if (this.nrI != null) {
          this.nrI.bRF();
        }
        AppMethodBeat.o(89237);
        return;
      }
      this.nro.setFilePath(this.videoPath);
      if ((this.nrz) && (this.nrp != null) && (this.nrp.egx())) {
        bBz();
      }
      int k = this.nrp.diO().x;
      int m = this.nrp.diO().y;
      int i = m;
      int j = k;
      if (this.nrD != null)
      {
        i = m;
        j = k;
        if (this.nrz)
        {
          j = this.nrD.x;
          i = this.nrD.y;
        }
      }
      j = (int)(j * this.nrL);
      i = (int)(i * this.nrL);
      j = com.tencent.mm.plugin.mmsight.d.WX(j);
      i = com.tencent.mm.plugin.mmsight.d.WX(i);
      Log.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.nrL) });
      if ((this.nrD != null) && (this.nrz)) {
        this.nro.u(this.nrD.y, this.nrD.x, j, i);
      }
      for (;;)
      {
        this.nro.aZL();
        this.nro.a(this);
        if (this.nro.uw(this.nrp.getOrientation())) {
          break;
        }
        Log.e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
        if (this.nrI != null) {
          this.nrI.bRF();
        }
        AppMethodBeat.o(89237);
        return;
        this.nro.u(this.nrp.getPreviewWidth(), this.nrp.getPreviewHeight(), j, i);
      }
      this.nrx = true;
    }
    AppMethodBeat.o(89237);
  }
  
  private void bBz()
  {
    AppMethodBeat.i(89250);
    if ((this.nrp != null) && (this.nrp.egx())) {
      if (!this.nrp.EZC) {
        break label101;
      }
    }
    label101:
    int i;
    for (this.nrD = new Point(com.tencent.mm.plugin.mmsight.d.id((int)(this.nrp.getPreviewWidth() / this.laP), this.nrp.getPreviewHeight()), this.nrp.getPreviewWidth());; this.nrD = new Point(this.nrp.getPreviewHeight(), i))
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "initVideoSize: %s", new Object[] { this.nrD });
      AppMethodBeat.o(89250);
      return;
      i = com.tencent.mm.plugin.mmsight.d.id((int)(this.nrp.getPreviewHeight() * this.laP), this.nrp.getPreviewWidth());
    }
  }
  
  private int getScreenRotation()
  {
    AppMethodBeat.i(89265);
    if (this.windowManager == null) {
      this.windowManager = ((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    }
    if (this.windowManager == null)
    {
      AppMethodBeat.o(89265);
      return 0;
    }
    switch (this.windowManager.getDefaultDisplay().getRotation())
    {
    default: 
      AppMethodBeat.o(89265);
      return 0;
    case 0: 
      AppMethodBeat.o(89265);
      return 0;
    case 1: 
      AppMethodBeat.o(89265);
      return 90;
    case 2: 
      AppMethodBeat.o(89265);
      return 180;
    }
    AppMethodBeat.o(89265);
    return 270;
  }
  
  public final void J(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(89262);
    if ((this.nrp != null) && (this.nrp.egx()) && (this.nrF)) {
      this.nrp.eTi();
    }
    AppMethodBeat.o(89262);
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void a(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(89240);
    if ((paramg != null) && (this.nrp != null) && (this.nrp.egx()))
    {
      if (paramBoolean) {
        this.nrp.eTl();
      }
      if (paramBoolean)
      {
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89223);
            f.a(f.this, paramg, paramBoolean);
            AppMethodBeat.o(89223);
          }
        }, 100L);
        AppMethodBeat.o(89240);
        return;
      }
      b(paramg, paramBoolean);
    }
    AppMethodBeat.o(89240);
  }
  
  public final void a(final MMSightRecordView.h paramh)
  {
    AppMethodBeat.i(89239);
    if (this.nro != null)
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", new Object[] { paramh });
      this.nro.a(new d.a()
      {
        public final void bBE()
        {
          AppMethodBeat.i(89221);
          if (paramh != null) {
            paramh.ij(true);
          }
          AppMethodBeat.o(89221);
        }
      });
      this.nro.E(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89222);
          f.l(f.this);
          if (paramh != null) {
            paramh.ij(false);
          }
          AppMethodBeat.o(89222);
        }
      });
      this.nro = null;
    }
    AppMethodBeat.o(89239);
  }
  
  public final void a(ByteBuffer paramByteBuffer, MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(89266);
    if ((paramf == null) && (paramByteBuffer == null))
    {
      if (this.nrM != null)
      {
        this.nrM.release();
        this.nrM = null;
      }
      AppMethodBeat.o(89266);
      return;
    }
    if (this.nrM == null)
    {
      this.nrM = new h();
      bBH();
      this.nrM.nsb = new f.6(this, paramf, paramByteBuffer);
      this.nrM.b(this.nrw.getEglContext());
    }
    AppMethodBeat.o(89266);
  }
  
  public final boolean aD(float paramFloat)
  {
    AppMethodBeat.i(89255);
    List localList = this.nrp.eTj();
    if ((this.nrO == null) || (this.nrO.size() == 0) || (!this.nrO.iM(Math.round(paramFloat * 10.0F))))
    {
      AppMethodBeat.o(89255);
      return false;
    }
    int i = localList.indexOf(Integer.valueOf(this.nrO.get(Math.round(paramFloat * 10.0F))));
    if (i < 0)
    {
      AppMethodBeat.o(89255);
      return false;
    }
    this.nrp.Xa(i);
    AppMethodBeat.o(89255);
    return true;
  }
  
  public final boolean aeU()
  {
    AppMethodBeat.i(89238);
    Log.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", new Object[] { this.nro });
    bBy();
    if (this.nro == null)
    {
      Log.e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
      AppMethodBeat.o(89238);
      return false;
    }
    int i = getScreenRotation();
    Log.i("MicroMsg.MMSightRecordViewImpl", "screen rotate: %s", new Object[] { Integer.valueOf(i) });
    if ((i == 90) || (i == 270)) {}
    for (i = this.nro.b(this.nrp.getOrientation(), true, 360 - i);; i = this.nro.b(this.nrp.getOrientation(), false, i))
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "startRecord now, ret: %s", new Object[] { Integer.valueOf(i) });
      if (i < 0) {
        break;
      }
      AppMethodBeat.o(89238);
      return true;
    }
    AppMethodBeat.o(89238);
    return false;
  }
  
  public final boolean ar(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89260);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(89260);
      return false;
    }
    if ((this.nrJ != null) && (!this.nrG))
    {
      this.nrJ.bRG();
      this.nrG = true;
    }
    if (this.nrM != null)
    {
      i = getScreenRotation();
      this.nrM.D(paramArrayOfByte, i);
    }
    int j;
    int k;
    Object localObject1;
    label199:
    label222:
    Object localObject2;
    a locala;
    int m;
    int n;
    if ((this.laP > 0.0F) && (this.nrq > 0) && (this.nrp != null))
    {
      j = this.nrp.getPreviewWidth();
      i = this.nrp.getPreviewHeight();
      if (this.nrp.EZC)
      {
        k = (int)(this.nrp.getPreviewWidth() / this.laP);
        if (k >= i) {
          break label1110;
        }
        if ((!this.nrz) && (this.nrP == null))
        {
          this.nrP = new byte[j * k * 3 >> 1];
          localObject1 = this.nrP;
          Util.currentTicks();
          if (this.nrs != 1) {
            break label898;
          }
          SightVideoJNI.cropCameraDataLongEdgeCenterCrop(paramArrayOfByte, (byte[])localObject1, i, this.nrD.x, j);
          i = k;
          if (this.nrz) {
            i = this.nrD.x;
          }
          this.nrK = true;
          localObject2 = localObject1;
          if (this.nrw != null)
          {
            localObject2 = this.nrw;
            k = this.nrp.getOrientation();
            if ((i != ((MMSightCameraGLSurfaceView)localObject2).nqW) || (j != ((MMSightCameraGLSurfaceView)localObject2).nqX) || (k != ((MMSightCameraGLSurfaceView)localObject2).lfC))
            {
              Log.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject2 });
              ((MMSightCameraGLSurfaceView)localObject2).nqW = i;
              ((MMSightCameraGLSurfaceView)localObject2).nqX = j;
              ((MMSightCameraGLSurfaceView)localObject2).lfC = k;
            }
            j = getScreenRotation();
            localObject2 = this.nrw;
            if ((localObject1 == null) || (((MMSightCameraGLSurfaceView)localObject2).nrg == null) || (((MMSightCameraGLSurfaceView)localObject2).nrg.nqV)) {
              break label1060;
            }
            locala = ((MMSightCameraGLSurfaceView)localObject2).nrg;
            k = ((MMSightCameraGLSurfaceView)localObject2).nqW;
            m = ((MMSightCameraGLSurfaceView)localObject2).nqX;
            n = ((MMSightCameraGLSurfaceView)localObject2).lfC;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      try
      {
        if ((locala.nqX != m) || (locala.nqW != k) || (locala.fSM != n) || (locala.nrf != j)) {
          continue;
        }
        if (i != 0) {
          Log.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { localObject1, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Boolean.valueOf(locala.lft), Boolean.TRUE, locala });
        }
        locala.frameData = ((byte[])localObject1);
        locala.nqW = k;
        locala.nqX = m;
        locala.fSM = n;
        locala.nrf = j;
        if (i != 0)
        {
          locala.kZC = ByteBuffer.allocateDirect(m * k);
          locala.kZJ = ByteBuffer.allocateDirect(k * m / 2);
          locala.kZC.order(ByteOrder.nativeOrder());
          locala.kZJ.order(ByteOrder.nativeOrder());
          if (locala.nrd != null)
          {
            locala.ksb.put(locala.nrd);
            locala.ksb.position(0);
          }
        }
        if ((locala.kZC != null) && (locala.kZJ != null))
        {
          locala.kZC.put((byte[])localObject1, 0, k * m);
          locala.kZC.position(0);
          locala.kZJ.put((byte[])localObject1, k * m, k * m / 2);
          locala.kZJ.position(0);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label719:
          boolean bool2;
          label898:
          Log.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[] { localException.getMessage() });
        }
      }
      ((MMSightCameraGLSurfaceView)localObject2).requestRender();
      localObject2 = localObject1;
      if (this.nry != null)
      {
        localObject1 = getPreviewSize();
        this.nry.D(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y);
      }
      bool2 = true;
      j = 0;
      boolean bool1 = bool2;
      i = j;
      if (this.nro != null)
      {
        bool1 = bool2;
        i = j;
        if (this.nro.getFrameDataCallback() != null)
        {
          if ((!this.nrz) || (!this.nrK)) {
            break label1082;
          }
          bool1 = this.nro.getFrameDataCallback().ar((byte[])localObject2);
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && ((this.nro == null) || (this.nro.aZF() != d.c.FaT))) {
          com.tencent.mm.plugin.mmsight.model.a.j.FbH.as((byte[])localObject2);
        }
        AppMethodBeat.o(89260);
        return bool1;
        localObject1 = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(this.nrD.x * this.nrD.y * 3 >> 1));
        break;
        SightVideoJNI.cropCameraDataLongEdge(paramArrayOfByte, (byte[])localObject1, i, this.nrD.x, j);
        break label199;
        k = (int)(i * this.laP);
        if (k < j)
        {
          if ((!this.nrz) && (this.nrP == null)) {
            this.nrP = new byte[k * i * 3 >> 1];
          }
          for (localObject1 = this.nrP;; localObject1 = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(this.nrD.x * this.nrD.y * 3 >> 1)))
          {
            Util.currentTicks();
            SightVideoJNI.cropCameraData(paramArrayOfByte, (byte[])localObject1, i, j, this.nrD.y);
            j = this.nrD.y;
            this.nrK = true;
            break;
          }
          label1060:
          Log.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
          localObject2 = localObject1;
          break label719;
          localObject2 = paramArrayOfByte;
          break label719;
          label1082:
          bool1 = this.nro.getFrameDataCallback().ar(paramArrayOfByte);
          i = j;
          continue;
        }
        localObject1 = paramArrayOfByte;
        break label222;
        label1110:
        localObject1 = paramArrayOfByte;
        break label222;
      }
    }
  }
  
  public final void ave()
  {
    AppMethodBeat.i(89232);
    Log.i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", new Object[] { Float.valueOf(this.laP), Integer.valueOf(this.nrq) });
    this.nrG = false;
    if ((this.laP > 0.0F) && (this.nrq > 0))
    {
      Object localObject = new VideoTransPara();
      ((VideoTransPara)localObject).width = this.nrq;
      ((VideoTransPara)localObject).height = ((int)(this.nrq / this.laP));
      Log.i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", new Object[] { Integer.valueOf(((VideoTransPara)localObject).width), Integer.valueOf(((VideoTransPara)localObject).height) });
      this.nrp = new com.tencent.mm.plugin.mmsight.model.f((VideoTransPara)localObject, -1);
      this.nrp.a(this);
      if (!this.nrp.G(this.context, this.nru))
      {
        Log.i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
        if (this.nrI != null) {
          this.nrI.bRF();
        }
        AppMethodBeat.o(89232);
        return;
      }
      Log.i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
      localObject = this.nrp.eTj();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        if (this.nrv.isAvailable())
        {
          if (this.nrp.a(this.nrv.getSurfaceTexture(), this.nrq, this.laP, this.nrz) < 0)
          {
            Log.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (this.nrI != null) {
              this.nrI.bRF();
            }
          }
          if (this.nrB != -1) {
            bBB();
          }
          this.nrp.eTg();
          Log.i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
          bBy();
          bBH();
          if (this.nrM != null) {
            this.nrM.b(this.nrw.getEglContext());
          }
          AppMethodBeat.o(89232);
        }
      }
      else
      {
        int k = ((Integer)((List)localObject).get(((List)localObject).size() - 1)).intValue();
        int j = k;
        int i = 1;
        while (j / 10 >= 10)
        {
          i *= 10;
          j /= 10;
        }
        int m = k / i;
        j = m;
        if ((k + 4) / i > m) {
          j = m + 1;
        }
        this.nrO = new com.tencent.tinker.a.c.b(j);
        k = 10;
        label443:
        if (k <= j)
        {
          if (((List)localObject).indexOf(Integer.valueOf(k * i)) >= 0) {
            break label558;
          }
          m = 1;
          label467:
          if (m <= 4)
          {
            if (((List)localObject).indexOf(Integer.valueOf(k * i - m)) <= 0) {
              break label513;
            }
            this.nrO.oa(k, k * i - m);
          }
        }
        for (;;)
        {
          k += 1;
          break label443;
          break;
          label513:
          if (((List)localObject).indexOf(Integer.valueOf(k * i + m)) > 0)
          {
            this.nrO.oa(k, m + k * i);
          }
          else
          {
            m += 1;
            break label467;
            label558:
            this.nrO.oa(k, k * i);
          }
        }
      }
      this.nrv.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
      {
        public final void g(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(89220);
          if (f.d(f.this).a(paramAnonymousSurfaceTexture, f.a(f.this), f.b(f.this), f.c(f.this)) < 0)
          {
            Log.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (f.e(f.this) != null) {
              f.e(f.this).bRF();
            }
          }
          if (f.f(f.this) != -1) {
            f.g(f.this);
          }
          f.d(f.this).eTg();
          f.h(f.this);
          f.i(f.this);
          if (f.j(f.this) != null) {
            f.j(f.this).b(f.k(f.this).getEglContext());
          }
          Log.i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
          AppMethodBeat.o(89220);
        }
      });
    }
    AppMethodBeat.o(89232);
  }
  
  public final void b(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(89227);
    this.context = paramContext;
    this.nrv = new ObservableTextureView(paramContext);
    this.nrw = new MMSightCameraGLSurfaceView(paramContext);
    this.nrw.setBackgroundColor(Color.argb(0, 0, 0, 0));
    int i = com.tencent.mm.ci.a.fromDPToPix(paramContext, 1);
    Object localObject = new FrameLayout.LayoutParams(i, i);
    paramViewGroup.addView(this.nrv, (ViewGroup.LayoutParams)localObject);
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    paramViewGroup.addView(this.nrw, (ViewGroup.LayoutParams)localObject);
    this.nrH = new g();
    this.nrH.nrZ = this;
    this.nrw.setOnTouchListener(this.nrH);
    com.tencent.mm.plugin.mmsight.model.j.eTp();
    Log.i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", new Object[] { paramContext });
    AppMethodBeat.o(89227);
  }
  
  public final void bBC()
  {
    AppMethodBeat.i(89256);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
    this.nrL = 0.5F;
    AppMethodBeat.o(89256);
  }
  
  public final void bBD()
  {
    AppMethodBeat.i(89257);
    Log.i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
    this.nrL = 0.75F;
    AppMethodBeat.o(89257);
  }
  
  public final void bBE()
  {
    AppMethodBeat.i(89261);
    Log.i("MicroMsg.MMSightRecordViewImpl", "onError: %s", new Object[] { Integer.valueOf(1) });
    this.nro.reset();
    AppMethodBeat.o(89261);
  }
  
  public final void bBF()
  {
    AppMethodBeat.i(89263);
    if ((this.nrp != null) && (this.nrp.egx()) && (this.nrE)) {
      this.nrp.d(true, false, 1);
    }
    AppMethodBeat.o(89263);
  }
  
  public final void bBG()
  {
    AppMethodBeat.i(89264);
    if ((this.nrp != null) && (this.nrp.egx()) && (this.nrE)) {
      this.nrp.d(false, false, 1);
    }
    AppMethodBeat.o(89264);
  }
  
  public final void bBx()
  {
    AppMethodBeat.i(89236);
    bBy();
    AppMethodBeat.o(89236);
  }
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(89247);
    if (this.nrp != null)
    {
      int i = this.nrp.getOrientation();
      AppMethodBeat.o(89247);
      return i;
    }
    AppMethodBeat.o(89247);
    return 0;
  }
  
  public final Bitmap getCurrentFramePicture()
  {
    AppMethodBeat.i(89258);
    Object localObject2;
    Object localObject1;
    int j;
    int i;
    int k;
    if ((this.nrp != null) && (this.nrp.egx()))
    {
      localObject2 = this.nrp;
      if (((com.tencent.mm.plugin.mmsight.model.f)localObject2).lbt != null)
      {
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).lbr = true;
        localObject1 = new byte[((com.tencent.mm.plugin.mmsight.model.f)localObject2).lbt.length];
        System.arraycopy(((com.tencent.mm.plugin.mmsight.model.f)localObject2).lbt, 0, localObject1, 0, ((com.tencent.mm.plugin.mmsight.model.f)localObject2).lbt.length);
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).lbr = false;
        if (localObject1 == null) {
          break label495;
        }
        j = this.nrp.getPreviewWidth();
        i = this.nrp.getPreviewHeight();
        if (!this.nrp.EZC) {
          break label379;
        }
        k = (int)(this.nrp.getPreviewWidth() / this.laP);
        if (k >= i) {
          break label506;
        }
        if ((this.nrz) || (this.nrP != null)) {
          break label327;
        }
        this.nrP = new byte[j * k * 3 >> 1];
        localObject2 = this.nrP;
        label161:
        if (this.nrs != 1) {
          break label360;
        }
        SightVideoJNI.cropCameraDataLongEdgeCenterCrop((byte[])localObject1, (byte[])localObject2, i, this.nrD.x, j);
        label185:
        i = k;
        if (this.nrz) {
          i = this.nrD.x;
        }
        this.nrK = true;
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      for (;;)
      {
        localObject1 = new YuvImage((byte[])localObject1, 17, i, j, null);
        localObject2 = new ByteArrayOutputStream();
        ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, i, j), 100, (OutputStream)localObject2);
        localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
        localObject1 = MMBitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
        localObject2 = BitmapUtil.rotate((Bitmap)localObject1, this.nrp.getOrientation());
        Log.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject1 });
        ((Bitmap)localObject1).recycle();
        AppMethodBeat.o(89258);
        return localObject2;
        localObject1 = null;
        break;
        label327:
        localObject2 = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(this.nrD.x * this.nrD.y * 3 >> 1));
        break label161;
        label360:
        SightVideoJNI.cropCameraDataLongEdge((byte[])localObject1, (byte[])localObject2, i, this.nrD.x, j);
        break label185;
        label379:
        k = (int)(i * this.laP);
        if (k < j)
        {
          if ((!this.nrz) && (this.nrP == null)) {
            this.nrP = new byte[k * i * 3 >> 1];
          }
          for (localObject2 = this.nrP;; localObject2 = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(this.nrD.x * this.nrD.y * 3 >> 1)))
          {
            SightVideoJNI.cropCameraData((byte[])localObject1, (byte[])localObject2, i, j, this.nrD.y);
            j = this.nrD.y;
            this.nrK = true;
            localObject1 = localObject2;
            break;
          }
          label495:
          AppMethodBeat.o(89258);
          return null;
        }
      }
      label506:
      localObject2 = localObject1;
    }
  }
  
  public final Point getDrawSizePoint()
  {
    AppMethodBeat.i(89246);
    Log.i("MicroMsg.MMSightRecordViewImpl", "getDrawSizePoint : %s", new Object[] { this.nrN.toString() });
    Point localPoint = this.nrN;
    AppMethodBeat.o(89246);
    return localPoint;
  }
  
  public final int getFlashMode()
  {
    return this.nrB;
  }
  
  public final Point getPictureSize()
  {
    AppMethodBeat.i(89243);
    if ((this.nrp != null) && (this.nrp.egx()))
    {
      if (!this.nrA)
      {
        localPoint = new Point(this.nrp.getPreviewWidth(), this.nrp.getPreviewHeight());
        AppMethodBeat.o(89243);
        return localPoint;
      }
      bBA();
      Point localPoint = this.nrC;
      AppMethodBeat.o(89243);
      return localPoint;
    }
    AppMethodBeat.o(89243);
    return null;
  }
  
  public final Point getPreviewSize()
  {
    AppMethodBeat.i(89245);
    int i;
    if ((this.nrp.getOrientation() == 0) || (this.nrp.getOrientation() == 180))
    {
      j = 1;
      if (j == 0) {
        break label78;
      }
      i = this.nrp.getPreviewWidth();
      label43:
      if (j == 0) {
        break label89;
      }
    }
    label78:
    label89:
    for (int j = this.nrp.getPreviewHeight();; j = this.nrp.getPreviewWidth())
    {
      Point localPoint = new Point(i, j);
      AppMethodBeat.o(89245);
      return localPoint;
      j = 0;
      break;
      i = this.nrp.getPreviewHeight();
      break label43;
    }
  }
  
  public final float[] getSupportZoomMultiple()
  {
    int i = 0;
    AppMethodBeat.i(253624);
    if ((this.nrO == null) || (this.nrO.size() == 0))
    {
      AppMethodBeat.o(253624);
      return new float[0];
    }
    float[] arrayOfFloat = new float[this.nrO.size()];
    while (i < this.nrO.size())
    {
      arrayOfFloat[i] = (this.nrO.aP(i) * 1.0F / 10.0F);
      i += 1;
    }
    AppMethodBeat.o(253624);
    return arrayOfFloat;
  }
  
  public final String getVideoFilePath()
  {
    AppMethodBeat.i(89235);
    if ((this.nro != null) && (this.nrx))
    {
      str = this.nro.getFilePath();
      AppMethodBeat.o(89235);
      return str;
    }
    String str = this.videoPath;
    AppMethodBeat.o(89235);
    return str;
  }
  
  public final Point getVideoSize()
  {
    AppMethodBeat.i(89244);
    if ((this.nrp != null) && (this.nrp.egx()))
    {
      int k = this.nrp.diO().x;
      int m = this.nrp.diO().y;
      int i = m;
      int j = k;
      if (this.nrD != null)
      {
        i = m;
        j = k;
        if (this.nrz)
        {
          j = this.nrD.x;
          i = this.nrD.y;
        }
      }
      j = (int)(j * this.nrL);
      i = (int)(i * this.nrL);
      Point localPoint = new Point(com.tencent.mm.plugin.mmsight.d.WX(j), com.tencent.mm.plugin.mmsight.d.WX(i));
      AppMethodBeat.o(89244);
      return localPoint;
    }
    AppMethodBeat.o(89244);
    return null;
  }
  
  public final void o(MotionEvent paramMotionEvent) {}
  
  public final void release()
  {
    AppMethodBeat.i(89259);
    Log.i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", new Object[] { this.nrp, this.nro });
    if (this.nrp != null)
    {
      this.nrp.b(this);
      this.nrp.eTk();
    }
    if (this.nro != null)
    {
      this.nro.a(null);
      this.nro.E(null);
      this.nro = null;
    }
    if (this.nrM != null) {
      this.nrM.release();
    }
    if (this.nrO != null) {
      this.nrO.clear();
    }
    this.nrO = null;
    this.nrx = false;
    this.nrz = false;
    this.nrA = false;
    this.nrC = null;
    this.nrD = null;
    this.nrB = -1;
    this.nrE = true;
    this.nrF = true;
    this.nrG = false;
    com.tencent.mm.plugin.mmsight.model.a.j.FbH.baL();
    AppMethodBeat.o(89259);
  }
  
  public final void setClipPictureSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89251);
    this.nrA = paramBoolean;
    if ((this.nrA) && (this.nrp != null) && (this.nrp.egx())) {
      bBA();
    }
    AppMethodBeat.o(89251);
  }
  
  public final void setClipVideoSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89249);
    this.nrz = paramBoolean;
    if ((this.nrz) && (this.nrp != null) && (this.nrp.egx())) {
      bBz();
    }
    AppMethodBeat.o(89249);
  }
  
  public final void setDisplayRatio(float paramFloat)
  {
    AppMethodBeat.i(89228);
    int i = getScreenRotation();
    Log.i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s, screenRotation: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i) });
    this.laP = paramFloat;
    if ((i == 90) || (i == 270)) {
      this.laP = (1.0F / this.laP);
    }
    AppMethodBeat.o(89228);
  }
  
  public final void setDisplayScreenSize(Size paramSize) {}
  
  public final void setEnableDragZoom(boolean paramBoolean)
  {
    this.nrE = paramBoolean;
  }
  
  public final void setEnableTouchFocus(boolean paramBoolean)
  {
    this.nrF = paramBoolean;
  }
  
  public final void setFlashMode(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(89253);
    this.nrB = paramInt;
    com.tencent.mm.plugin.mmsight.model.f localf = this.nrp;
    if ((this.nrp != null) && (this.nrp.egx())) {}
    for (;;)
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "setFlashMode: %s, camera: %s, previewing: %s", new Object[] { Integer.valueOf(paramInt), localf, Boolean.valueOf(bool) });
      if ((this.nrp != null) && (this.nrp.egx())) {
        bBB();
      }
      AppMethodBeat.o(89253);
      return;
      bool = false;
    }
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.nry = parama;
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    this.nrJ = paramc;
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    this.nrI = paramd;
  }
  
  public final void setPreviewMode(int paramInt)
  {
    AppMethodBeat.i(89231);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setPreviewMode: %s", new Object[] { Integer.valueOf(paramInt) });
    this.nrs = paramInt;
    AppMethodBeat.o(89231);
  }
  
  public final void setPreviewSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89229);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.nrq = paramInt;
    AppMethodBeat.o(89229);
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89230);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setRGBSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.nrr = paramInt;
    AppMethodBeat.o(89230);
  }
  
  public final void setUseBackCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(89242);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nru = paramBoolean;
    AppMethodBeat.o(89242);
  }
  
  public final void setVideoFilePath(String paramString)
  {
    AppMethodBeat.i(89234);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setVideoFilePath: %s", new Object[] { paramString });
    this.videoPath = paramString;
    AppMethodBeat.o(89234);
  }
  
  public final void switchCamera()
  {
    AppMethodBeat.i(89248);
    if ((this.nrp != null) && (this.nrp.egx()) && ((this.nro == null) || (this.nro.aZF() != d.c.FaT)))
    {
      this.nrp.a(this.context, this.nrv.getSurfaceTexture(), this.nrq, this.laP, this.nrz);
      if (this.nrM != null) {
        bBH();
      }
    }
    AppMethodBeat.o(89248);
  }
  
  public final void yJ(int paramInt)
  {
    AppMethodBeat.i(89233);
    this.nrt = paramInt;
    this.videoBitrate = 4800000;
    this.fps = 30;
    this.audioBitrate = 64000;
    this.audioSampleRate = 44100;
    Log.i("MicroMsg.MMSightRecordViewImpl", "setVideoPara, maxDuration: %s, videoBitrate: %s, fps: %s, audioBitrate: %s, audioSampleRate: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(4800000), Integer.valueOf(30), Integer.valueOf(64000), Integer.valueOf(44100) });
    AppMethodBeat.o(89233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f
 * JD-Core Version:    0.7.0.1
 */