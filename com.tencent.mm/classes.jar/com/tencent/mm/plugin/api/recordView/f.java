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
import android.view.Surface;
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
  private float nFU;
  private com.tencent.mm.plugin.mmsight.model.a.d qpV;
  private com.tencent.mm.plugin.mmsight.model.f qpW;
  private int qpX;
  private int qpY;
  private int qpZ;
  private int qqa;
  private boolean qqb;
  private ObservableTextureView qqc;
  private MMSightCameraGLSurfaceView qqd;
  private boolean qqe;
  private MMSightRecordView.a qqf;
  private boolean qqg;
  private boolean qqh;
  private int qqi;
  private Point qqj;
  private Point qqk;
  private boolean qql;
  private boolean qqm;
  private boolean qqn;
  private g qqo;
  private MMSightRecordView.d qqp;
  private MMSightRecordView.c qqq;
  private boolean qqr;
  private float qqs;
  private h qqt;
  private Point qqu;
  private com.tencent.tinker.a.c.b qqv;
  private byte[] qqw;
  private int videoBitrate;
  private String videoPath;
  private WindowManager windowManager;
  
  public f()
  {
    AppMethodBeat.i(89226);
    this.qpZ = 0;
    this.qqb = true;
    this.qqe = false;
    this.qqg = false;
    this.qqh = false;
    this.qqi = -1;
    this.qql = true;
    this.qqm = true;
    this.qqn = false;
    this.qqr = false;
    this.qqs = 1.0F;
    this.windowManager = null;
    this.qqt = null;
    this.qqu = new Point(0, 0);
    this.qqw = null;
    AppMethodBeat.o(89226);
  }
  
  private void b(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(89241);
    this.qpW.a(new f.b()
    {
      public final void a(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(89224);
        if (paramBoolean) {
          f.d(f.this).gcf();
        }
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousInt1 < 0) || (paramAnonymousInt2 < 0) || (paramAnonymousInt3 < 0))
        {
          Log.e("MicroMsg.MMSightRecordViewImpl", "onPictureYuvTaken, data is null!!");
          paramg.crN();
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
            if (f.d(f.this).KVo)
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
                paramg.X(paramAnonymousArrayOfByte);
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
            paramg.crN();
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
  
  private void caU()
  {
    AppMethodBeat.i(89237);
    if (this.qqe)
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
      AppMethodBeat.o(89237);
      return;
    }
    if (this.qpV != null)
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
      this.qpV.cancel();
      if (this.qpW != null) {
        this.qpW.b(this.qpV.getFrameDataCallback());
      }
      this.qpV = null;
    }
    if ((this.qpX > 0) && (this.qqa > 0) && (this.videoBitrate > 0) && (this.fps > 0) && (this.audioBitrate > 0) && (this.audioSampleRate > 0) && (this.qpW != null) && (this.qpW.dPz() != null))
    {
      VideoTransPara localVideoTransPara = new VideoTransPara();
      localVideoTransPara.width = this.qpX;
      localVideoTransPara.height = ((int)(this.qpX / this.nFU));
      localVideoTransPara.duration = this.qqa;
      localVideoTransPara.videoBitrate = this.videoBitrate;
      localVideoTransPara.fps = this.fps;
      localVideoTransPara.audioBitrate = this.audioBitrate;
      localVideoTransPara.audioSampleRate = this.audioSampleRate;
      localVideoTransPara.oBO = 2;
      localVideoTransPara.oBP = 1;
      localVideoTransPara.nCd = 1;
      com.tencent.mm.plugin.mmsight.model.j.KVJ.nLH = localVideoTransPara;
      com.tencent.mm.plugin.mmsight.model.j.KVJ.videoBitrate = this.videoBitrate;
      com.tencent.mm.plugin.mmsight.model.j.KVJ.nFY = this.qpX;
      k.gcB();
      this.qpV = k.q(localVideoTransPara);
      if (this.qpV == null)
      {
        Log.e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
        if (this.qqp != null) {
          this.qqp.crK();
        }
        AppMethodBeat.o(89237);
        return;
      }
      this.qpV.setFilePath(this.videoPath);
      if ((this.qqg) && (this.qpW != null) && (this.qpW.boa())) {
        caV();
      }
      int k = this.qpW.dPz().x;
      int m = this.qpW.dPz().y;
      int i = m;
      int j = k;
      if (this.qqk != null)
      {
        i = m;
        j = k;
        if (this.qqg)
        {
          j = this.qqk.x;
          i = this.qqk.y;
        }
      }
      j = (int)(j * this.qqs);
      i = (int)(i * this.qqs);
      j = com.tencent.mm.plugin.mmsight.d.aaZ(j);
      i = com.tencent.mm.plugin.mmsight.d.aaZ(i);
      Log.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.qqs) });
      if ((this.qqk != null) && (this.qqg)) {
        this.qpV.A(this.qqk.y, this.qqk.x, j, i);
      }
      for (;;)
      {
        this.qpV.buJ();
        this.qpV.a(this);
        if (this.qpV.uw(this.qpW.getOrientation())) {
          break;
        }
        Log.e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
        if (this.qqp != null) {
          this.qqp.crK();
        }
        AppMethodBeat.o(89237);
        return;
        this.qpV.A(this.qpW.getPreviewWidth(), this.qpW.getPreviewHeight(), j, i);
      }
      this.qqe = true;
    }
    AppMethodBeat.o(89237);
  }
  
  private void caV()
  {
    AppMethodBeat.i(89250);
    if ((this.qpW != null) && (this.qpW.boa())) {
      if (!this.qpW.KVo) {
        break label101;
      }
    }
    label101:
    int i;
    for (this.qqk = new Point(com.tencent.mm.plugin.mmsight.d.jI((int)(this.qpW.getPreviewWidth() / this.nFU), this.qpW.getPreviewHeight()), this.qpW.getPreviewWidth());; this.qqk = new Point(this.qpW.getPreviewHeight(), i))
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "initVideoSize: %s", new Object[] { this.qqk });
      AppMethodBeat.o(89250);
      return;
      i = com.tencent.mm.plugin.mmsight.d.jI((int)(this.qpW.getPreviewHeight() * this.nFU), this.qpW.getPreviewWidth());
    }
  }
  
  private void caW()
  {
    AppMethodBeat.i(89252);
    if ((this.qpW != null) && (this.qpW.boa()))
    {
      if (this.qpW.KVo)
      {
        int i = (int)(this.qpW.getPreviewWidth() / this.nFU);
        this.qqj = new Point(this.qpW.getPreviewWidth(), i);
        AppMethodBeat.o(89252);
        return;
      }
      this.qqj = new Point((int)(this.qpW.getPreviewHeight() * this.nFU), this.qpW.getPreviewHeight());
    }
    AppMethodBeat.o(89252);
  }
  
  private void caX()
  {
    AppMethodBeat.i(89254);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", new Object[] { Integer.valueOf(this.qqi) });
    switch (this.qqi)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89254);
      return;
      this.qpW.gce();
      AppMethodBeat.o(89254);
      return;
      this.qpW.gcf();
      AppMethodBeat.o(89254);
      return;
      this.qpW.gcg();
    }
  }
  
  private void cbb()
  {
    AppMethodBeat.i(89267);
    Point localPoint = getPreviewSize();
    this.qqu.y = this.qpY;
    this.qqu.x = (localPoint.x * this.qpY / localPoint.y);
    if ((getScreenRotation() == 0) || (getScreenRotation() == 180))
    {
      int i = this.qqu.y;
      this.qqu.y = this.qqu.x;
      this.qqu.x = i;
    }
    if (this.qqt != null) {
      this.qqt.l(localPoint.x, localPoint.y, this.qpW.getOrientation(), this.qqu.x, this.qqu.y);
    }
    AppMethodBeat.o(89267);
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
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, Surface paramSurface, int paramInt1, int paramInt2) {}
  
  public final void a(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(89240);
    if ((paramg != null) && (this.qpW != null) && (this.qpW.boa()))
    {
      if (paramBoolean) {
        this.qpW.gce();
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
    if (this.qpV != null)
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", new Object[] { paramh });
      this.qpV.a(new d.a()
      {
        public final void cba()
        {
          AppMethodBeat.i(89221);
          if (paramh != null) {
            paramh.jn(true);
          }
          AppMethodBeat.o(89221);
        }
      });
      this.qpV.J(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89222);
          f.l(f.this);
          if (paramh != null) {
            paramh.jn(false);
          }
          AppMethodBeat.o(89222);
        }
      });
      this.qpV = null;
    }
    AppMethodBeat.o(89239);
  }
  
  public final void a(final ByteBuffer paramByteBuffer, final MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(89266);
    if ((paramf == null) && (paramByteBuffer == null))
    {
      if (this.qqt != null)
      {
        this.qqt.release();
        this.qqt = null;
      }
      AppMethodBeat.o(89266);
      return;
    }
    if (this.qqt == null)
    {
      this.qqt = new h();
      cbb();
      this.qqt.qqG = new i.a()
      {
        public final void cbc()
        {
          AppMethodBeat.i(89225);
          if (paramf != null) {
            paramf.crP();
          }
          AppMethodBeat.o(89225);
        }
        
        public final ByteBuffer getBuffer()
        {
          return paramByteBuffer;
        }
      };
      this.qqt.c(this.qqd.getEglContext());
    }
    AppMethodBeat.o(89266);
  }
  
  public final void aPz()
  {
    AppMethodBeat.i(89232);
    Log.i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", new Object[] { Float.valueOf(this.nFU), Integer.valueOf(this.qpX) });
    this.qqn = false;
    if ((this.nFU > 0.0F) && (this.qpX > 0))
    {
      Object localObject = new VideoTransPara();
      ((VideoTransPara)localObject).width = this.qpX;
      ((VideoTransPara)localObject).height = ((int)(this.qpX / this.nFU));
      Log.i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", new Object[] { Integer.valueOf(((VideoTransPara)localObject).width), Integer.valueOf(((VideoTransPara)localObject).height) });
      this.qpW = new com.tencent.mm.plugin.mmsight.model.f((VideoTransPara)localObject, -1);
      this.qpW.a(this);
      if (!this.qpW.N(this.context, this.qqb))
      {
        Log.i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
        if (this.qqp != null) {
          this.qqp.crK();
        }
        AppMethodBeat.o(89232);
        return;
      }
      Log.i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
      localObject = this.qpW.gcc();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        if (this.qqc.isAvailable())
        {
          if (this.qpW.a(this.qqc.getSurfaceTexture(), this.qpX, this.nFU, this.qqg) < 0)
          {
            Log.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (this.qqp != null) {
              this.qqp.crK();
            }
          }
          if (this.qqi != -1) {
            caX();
          }
          this.qpW.gbZ();
          Log.i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
          caU();
          cbb();
          if (this.qqt != null) {
            this.qqt.c(this.qqd.getEglContext());
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
        this.qqv = new com.tencent.tinker.a.c.b(j);
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
            this.qqv.pX(k, k * i - m);
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
            this.qqv.pX(k, m + k * i);
          }
          else
          {
            m += 1;
            break label467;
            label558:
            this.qqv.pX(k, k * i);
          }
        }
      }
      this.qqc.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
      {
        public final void h(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(89220);
          if (f.d(f.this).a(paramAnonymousSurfaceTexture, f.a(f.this), f.b(f.this), f.c(f.this)) < 0)
          {
            Log.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (f.e(f.this) != null) {
              f.e(f.this).crK();
            }
          }
          if (f.f(f.this) != -1) {
            f.g(f.this);
          }
          f.d(f.this).gbZ();
          f.h(f.this);
          f.i(f.this);
          if (f.j(f.this) != null) {
            f.j(f.this).c(f.k(f.this).getEglContext());
          }
          Log.i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
          AppMethodBeat.o(89220);
        }
      });
    }
    AppMethodBeat.o(89232);
  }
  
  public final void al(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(89262);
    if ((this.qpW != null) && (this.qpW.boa()) && (this.qqm)) {
      this.qpW.gcb();
    }
    AppMethodBeat.o(89262);
  }
  
  public final void b(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(89227);
    this.context = paramContext;
    this.qqc = new ObservableTextureView(paramContext);
    this.qqd = new MMSightCameraGLSurfaceView(paramContext);
    this.qqd.setBackgroundColor(Color.argb(0, 0, 0, 0));
    int i = com.tencent.mm.cd.a.fromDPToPix(paramContext, 1);
    Object localObject = new FrameLayout.LayoutParams(i, i);
    paramViewGroup.addView(this.qqc, (ViewGroup.LayoutParams)localObject);
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    paramViewGroup.addView(this.qqd, (ViewGroup.LayoutParams)localObject);
    this.qqo = new g();
    this.qqo.qqE = this;
    this.qqd.setOnTouchListener(this.qqo);
    com.tencent.mm.plugin.mmsight.model.j.gci();
    Log.i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", new Object[] { paramContext });
    AppMethodBeat.o(89227);
  }
  
  public final boolean bB(float paramFloat)
  {
    AppMethodBeat.i(89255);
    List localList = this.qpW.gcc();
    if ((this.qqv != null) && (this.qqv.mSize != 0)) {
      if (this.qqv.aIG(Math.round(paramFloat * 10.0F)) < 0) {
        break label63;
      }
    }
    label63:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(89255);
      return false;
    }
    i = localList.indexOf(Integer.valueOf(this.qqv.aIF(Math.round(paramFloat * 10.0F))));
    if (i < 0)
    {
      AppMethodBeat.o(89255);
      return false;
    }
    this.qpW.abc(i);
    AppMethodBeat.o(89255);
    return true;
  }
  
  public final void bof()
  {
    AppMethodBeat.i(89263);
    if ((this.qpW != null) && (this.qpW.boa()) && (this.qql)) {
      this.qpW.e(true, false, 1);
    }
    AppMethodBeat.o(89263);
  }
  
  public final void bog()
  {
    AppMethodBeat.i(89264);
    if ((this.qpW != null) && (this.qpW.boa()) && (this.qql)) {
      this.qpW.e(false, false, 1);
    }
    AppMethodBeat.o(89264);
  }
  
  public final void caT()
  {
    AppMethodBeat.i(89236);
    caU();
    AppMethodBeat.o(89236);
  }
  
  public final void caY()
  {
    AppMethodBeat.i(89256);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
    this.qqs = 0.5F;
    AppMethodBeat.o(89256);
  }
  
  public final void caZ()
  {
    AppMethodBeat.i(89257);
    Log.i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
    this.qqs = 0.75F;
    AppMethodBeat.o(89257);
  }
  
  public final void cba()
  {
    AppMethodBeat.i(89261);
    Log.i("MicroMsg.MMSightRecordViewImpl", "onError: %s", new Object[] { Integer.valueOf(1) });
    this.qpV.reset();
    AppMethodBeat.o(89261);
  }
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(89247);
    if (this.qpW != null)
    {
      int i = this.qpW.getOrientation();
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
    if ((this.qpW != null) && (this.qpW.boa()))
    {
      localObject2 = this.qpW;
      if (((com.tencent.mm.plugin.mmsight.model.f)localObject2).nGy != null)
      {
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).nGx = true;
        localObject1 = new byte[((com.tencent.mm.plugin.mmsight.model.f)localObject2).nGy.length];
        System.arraycopy(((com.tencent.mm.plugin.mmsight.model.f)localObject2).nGy, 0, localObject1, 0, ((com.tencent.mm.plugin.mmsight.model.f)localObject2).nGy.length);
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).nGx = false;
        if (localObject1 == null) {
          break label495;
        }
        j = this.qpW.getPreviewWidth();
        i = this.qpW.getPreviewHeight();
        if (!this.qpW.KVo) {
          break label379;
        }
        k = (int)(this.qpW.getPreviewWidth() / this.nFU);
        if (k >= i) {
          break label506;
        }
        if ((this.qqg) || (this.qqw != null)) {
          break label327;
        }
        this.qqw = new byte[j * k * 3 >> 1];
        localObject2 = this.qqw;
        label161:
        if (this.qpZ != 1) {
          break label360;
        }
        SightVideoJNI.cropCameraDataLongEdgeCenterCrop((byte[])localObject1, (byte[])localObject2, i, this.qqk.x, j);
        label185:
        i = k;
        if (this.qqg) {
          i = this.qqk.x;
        }
        this.qqr = true;
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
        localObject2 = BitmapUtil.rotate((Bitmap)localObject1, this.qpW.getOrientation());
        Log.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject1 });
        ((Bitmap)localObject1).recycle();
        AppMethodBeat.o(89258);
        return localObject2;
        localObject1 = null;
        break;
        label327:
        localObject2 = com.tencent.mm.plugin.mmsight.model.a.j.KXq.m(Integer.valueOf(this.qqk.x * this.qqk.y * 3 >> 1));
        break label161;
        label360:
        SightVideoJNI.cropCameraDataLongEdge((byte[])localObject1, (byte[])localObject2, i, this.qqk.x, j);
        break label185;
        label379:
        k = (int)(i * this.nFU);
        if (k < j)
        {
          if ((!this.qqg) && (this.qqw == null)) {
            this.qqw = new byte[k * i * 3 >> 1];
          }
          for (localObject2 = this.qqw;; localObject2 = com.tencent.mm.plugin.mmsight.model.a.j.KXq.m(Integer.valueOf(this.qqk.x * this.qqk.y * 3 >> 1)))
          {
            SightVideoJNI.cropCameraData((byte[])localObject1, (byte[])localObject2, i, j, this.qqk.y);
            j = this.qqk.y;
            this.qqr = true;
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
    Log.i("MicroMsg.MMSightRecordViewImpl", "getDrawSizePoint : %s", new Object[] { this.qqu.toString() });
    Point localPoint = this.qqu;
    AppMethodBeat.o(89246);
    return localPoint;
  }
  
  public final int getFlashMode()
  {
    return this.qqi;
  }
  
  public final Point getPictureSize()
  {
    AppMethodBeat.i(89243);
    if ((this.qpW != null) && (this.qpW.boa()))
    {
      if (!this.qqh)
      {
        localPoint = new Point(this.qpW.getPreviewWidth(), this.qpW.getPreviewHeight());
        AppMethodBeat.o(89243);
        return localPoint;
      }
      caW();
      Point localPoint = this.qqj;
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
    if ((this.qpW.getOrientation() == 0) || (this.qpW.getOrientation() == 180))
    {
      j = 1;
      if (j == 0) {
        break label78;
      }
      i = this.qpW.getPreviewWidth();
      label43:
      if (j == 0) {
        break label89;
      }
    }
    label78:
    label89:
    for (int j = this.qpW.getPreviewHeight();; j = this.qpW.getPreviewWidth())
    {
      Point localPoint = new Point(i, j);
      AppMethodBeat.o(89245);
      return localPoint;
      j = 0;
      break;
      i = this.qpW.getPreviewHeight();
      break label43;
    }
  }
  
  public final float[] getSupportZoomMultiple()
  {
    int i = 0;
    if ((this.qqv == null) || (this.qqv.mSize == 0)) {
      return new float[0];
    }
    float[] arrayOfFloat = new float[this.qqv.mSize];
    while (i < this.qqv.mSize)
    {
      arrayOfFloat[i] = (this.qqv.Sk[i] * 1.0F / 10.0F);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public final String getVideoFilePath()
  {
    AppMethodBeat.i(89235);
    if ((this.qpV != null) && (this.qqe))
    {
      str = this.qpV.getFilePath();
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
    if ((this.qpW != null) && (this.qpW.boa()))
    {
      int k = this.qpW.dPz().x;
      int m = this.qpW.dPz().y;
      int i = m;
      int j = k;
      if (this.qqk != null)
      {
        i = m;
        j = k;
        if (this.qqg)
        {
          j = this.qqk.x;
          i = this.qqk.y;
        }
      }
      j = (int)(j * this.qqs);
      i = (int)(i * this.qqs);
      Point localPoint = new Point(com.tencent.mm.plugin.mmsight.d.aaZ(j), com.tencent.mm.plugin.mmsight.d.aaZ(i));
      AppMethodBeat.o(89244);
      return localPoint;
    }
    AppMethodBeat.o(89244);
    return null;
  }
  
  public final boolean hT(boolean paramBoolean)
  {
    AppMethodBeat.i(260956);
    Log.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", new Object[] { this.qpV });
    caU();
    if (this.qpV == null)
    {
      Log.e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
      AppMethodBeat.o(260956);
      return false;
    }
    int i = getScreenRotation();
    Log.i("MicroMsg.MMSightRecordViewImpl", "screen rotate: %s", new Object[] { Integer.valueOf(i) });
    if ((i == 90) || (i == 270)) {}
    for (i = this.qpV.b(this.qpW.getOrientation(), true, 360 - i);; i = this.qpV.b(this.qpW.getOrientation(), false, i))
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "startRecord now, ret: %s", new Object[] { Integer.valueOf(i) });
      if (i < 0) {
        break;
      }
      AppMethodBeat.o(260956);
      return true;
    }
    AppMethodBeat.o(260956);
    return false;
  }
  
  public final void o(MotionEvent paramMotionEvent) {}
  
  public final boolean onFrameData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89260);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(89260);
      return false;
    }
    if ((this.qqq != null) && (!this.qqn))
    {
      this.qqq.crL();
      this.qqn = true;
    }
    if (this.qqt != null)
    {
      i = getScreenRotation();
      this.qqt.C(paramArrayOfByte, i);
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
    if ((this.nFU > 0.0F) && (this.qpX > 0) && (this.qpW != null))
    {
      j = this.qpW.getPreviewWidth();
      i = this.qpW.getPreviewHeight();
      if (this.qpW.KVo)
      {
        k = (int)(this.qpW.getPreviewWidth() / this.nFU);
        if (k >= i) {
          break label1110;
        }
        if ((!this.qqg) && (this.qqw == null))
        {
          this.qqw = new byte[j * k * 3 >> 1];
          localObject1 = this.qqw;
          Util.currentTicks();
          if (this.qpZ != 1) {
            break label898;
          }
          SightVideoJNI.cropCameraDataLongEdgeCenterCrop(paramArrayOfByte, (byte[])localObject1, i, this.qqk.x, j);
          i = k;
          if (this.qqg) {
            i = this.qqk.x;
          }
          this.qqr = true;
          localObject2 = localObject1;
          if (this.qqd != null)
          {
            localObject2 = this.qqd;
            k = this.qpW.getOrientation();
            if ((i != ((MMSightCameraGLSurfaceView)localObject2).qpD) || (j != ((MMSightCameraGLSurfaceView)localObject2).qpE) || (k != ((MMSightCameraGLSurfaceView)localObject2).nKn))
            {
              Log.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject2 });
              ((MMSightCameraGLSurfaceView)localObject2).qpD = i;
              ((MMSightCameraGLSurfaceView)localObject2).qpE = j;
              ((MMSightCameraGLSurfaceView)localObject2).nKn = k;
            }
            j = getScreenRotation();
            localObject2 = this.qqd;
            if ((localObject1 == null) || (((MMSightCameraGLSurfaceView)localObject2).qpN == null) || (((MMSightCameraGLSurfaceView)localObject2).qpN.qpC)) {
              break label1060;
            }
            locala = ((MMSightCameraGLSurfaceView)localObject2).qpN;
            k = ((MMSightCameraGLSurfaceView)localObject2).qpD;
            m = ((MMSightCameraGLSurfaceView)localObject2).qpE;
            n = ((MMSightCameraGLSurfaceView)localObject2).nKn;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      try
      {
        if ((locala.qpE != m) || (locala.qpD != k) || (locala.hYK != n) || (locala.qpM != j)) {
          continue;
        }
        if (i != 0) {
          Log.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { localObject1, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Boolean.valueOf(locala.nKe), Boolean.TRUE, locala });
        }
        locala.frameData = ((byte[])localObject1);
        locala.qpD = k;
        locala.qpE = m;
        locala.hYK = n;
        locala.qpM = j;
        if (i != 0)
        {
          locala.nEJ = ByteBuffer.allocateDirect(m * k);
          locala.nEQ = ByteBuffer.allocateDirect(k * m / 2);
          locala.nEJ.order(ByteOrder.nativeOrder());
          locala.nEQ.order(ByteOrder.nativeOrder());
          if (locala.qpK != null)
          {
            locala.mVV.put(locala.qpK);
            locala.mVV.position(0);
          }
        }
        if ((locala.nEJ != null) && (locala.nEQ != null))
        {
          locala.nEJ.put((byte[])localObject1, 0, k * m);
          locala.nEJ.position(0);
          locala.nEQ.put((byte[])localObject1, k * m, k * m / 2);
          locala.nEQ.position(0);
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
      if (this.qqf != null)
      {
        localObject1 = getPreviewSize();
        this.qqf.B(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y);
      }
      bool2 = true;
      j = 0;
      boolean bool1 = bool2;
      i = j;
      if (this.qpV != null)
      {
        bool1 = bool2;
        i = j;
        if (this.qpV.getFrameDataCallback() != null)
        {
          if ((!this.qqg) || (!this.qqr)) {
            break label1082;
          }
          bool1 = this.qpV.getFrameDataCallback().onFrameData((byte[])localObject2);
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && ((this.qpV == null) || (this.qpV.buD() != d.c.KWC))) {
          com.tencent.mm.plugin.mmsight.model.a.j.KXq.as((byte[])localObject2);
        }
        AppMethodBeat.o(89260);
        return bool1;
        localObject1 = com.tencent.mm.plugin.mmsight.model.a.j.KXq.m(Integer.valueOf(this.qqk.x * this.qqk.y * 3 >> 1));
        break;
        SightVideoJNI.cropCameraDataLongEdge(paramArrayOfByte, (byte[])localObject1, i, this.qqk.x, j);
        break label199;
        k = (int)(i * this.nFU);
        if (k < j)
        {
          if ((!this.qqg) && (this.qqw == null)) {
            this.qqw = new byte[k * i * 3 >> 1];
          }
          for (localObject1 = this.qqw;; localObject1 = com.tencent.mm.plugin.mmsight.model.a.j.KXq.m(Integer.valueOf(this.qqk.x * this.qqk.y * 3 >> 1)))
          {
            Util.currentTicks();
            SightVideoJNI.cropCameraData(paramArrayOfByte, (byte[])localObject1, i, j, this.qqk.y);
            j = this.qqk.y;
            this.qqr = true;
            break;
          }
          label1060:
          Log.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
          localObject2 = localObject1;
          break label719;
          localObject2 = paramArrayOfByte;
          break label719;
          label1082:
          bool1 = this.qpV.getFrameDataCallback().onFrameData(paramArrayOfByte);
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
  
  public final void release()
  {
    AppMethodBeat.i(89259);
    Log.i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", new Object[] { this.qpW, this.qpV });
    if (this.qpW != null)
    {
      this.qpW.b(this);
      this.qpW.gcd();
    }
    if (this.qpV != null)
    {
      this.qpV.a(null);
      this.qpV.J(null);
      this.qpV = null;
    }
    if (this.qqt != null) {
      this.qqt.release();
    }
    if (this.qqv != null) {
      this.qqv.mSize = 0;
    }
    this.qqv = null;
    this.qqe = false;
    this.qqg = false;
    this.qqh = false;
    this.qqj = null;
    this.qqk = null;
    this.qqi = -1;
    this.qql = true;
    this.qqm = true;
    this.qqn = false;
    com.tencent.mm.plugin.mmsight.model.a.j.KXq.bvG();
    AppMethodBeat.o(89259);
  }
  
  public final void setClipPictureSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89251);
    this.qqh = paramBoolean;
    if ((this.qqh) && (this.qpW != null) && (this.qpW.boa())) {
      caW();
    }
    AppMethodBeat.o(89251);
  }
  
  public final void setClipVideoSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89249);
    this.qqg = paramBoolean;
    if ((this.qqg) && (this.qpW != null) && (this.qpW.boa())) {
      caV();
    }
    AppMethodBeat.o(89249);
  }
  
  public final void setDisplayRatio(float paramFloat)
  {
    AppMethodBeat.i(89228);
    int i = getScreenRotation();
    Log.i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s, screenRotation: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i) });
    this.nFU = paramFloat;
    if ((i == 90) || (i == 270)) {
      this.nFU = (1.0F / this.nFU);
    }
    AppMethodBeat.o(89228);
  }
  
  public final void setDisplayScreenSize(Size paramSize) {}
  
  public final void setEnableDragZoom(boolean paramBoolean)
  {
    this.qql = paramBoolean;
  }
  
  public final void setEnableTouchFocus(boolean paramBoolean)
  {
    this.qqm = paramBoolean;
  }
  
  public final void setFlashMode(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(89253);
    this.qqi = paramInt;
    com.tencent.mm.plugin.mmsight.model.f localf = this.qpW;
    if ((this.qpW != null) && (this.qpW.boa())) {}
    for (;;)
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "setFlashMode: %s, camera: %s, previewing: %s", new Object[] { Integer.valueOf(paramInt), localf, Boolean.valueOf(bool) });
      if ((this.qpW != null) && (this.qpW.boa())) {
        caX();
      }
      AppMethodBeat.o(89253);
      return;
      bool = false;
    }
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.qqf = parama;
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    this.qqq = paramc;
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    this.qqp = paramd;
  }
  
  public final void setPreviewMode(int paramInt)
  {
    AppMethodBeat.i(89231);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setPreviewMode: %s", new Object[] { Integer.valueOf(paramInt) });
    this.qpZ = paramInt;
    AppMethodBeat.o(89231);
  }
  
  public final void setPreviewSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89229);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.qpX = paramInt;
    AppMethodBeat.o(89229);
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89230);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setRGBSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.qpY = paramInt;
    AppMethodBeat.o(89230);
  }
  
  public final void setUseBackCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(89242);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.qqb = paramBoolean;
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
    if ((this.qpW != null) && (this.qpW.boa()) && ((this.qpV == null) || (this.qpV.buD() != d.c.KWC)))
    {
      this.qpW.a(this.context, this.qqc.getSurfaceTexture(), this.qpX, this.nFU, this.qqg);
      if (this.qqt != null) {
        cbb();
      }
    }
    AppMethodBeat.o(89248);
  }
  
  public final void yR(int paramInt)
  {
    AppMethodBeat.i(89233);
    this.qqa = paramInt;
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