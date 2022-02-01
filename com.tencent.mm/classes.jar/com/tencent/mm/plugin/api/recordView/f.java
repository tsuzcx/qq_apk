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
import com.tencent.mm.plugin.mmsight.model.a.l;
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
  float ilP;
  boolean kyA;
  int kyB;
  Point kyC;
  private Point kyD;
  private boolean kyE;
  private boolean kyF;
  private boolean kyG;
  private g kyH;
  MMSightRecordView.d kyI;
  private MMSightRecordView.c kyJ;
  private boolean kyK;
  private float kyL;
  h kyM;
  private Point kyN;
  private com.tencent.tinker.a.c.b kyO;
  private byte[] kyP;
  private com.tencent.mm.plugin.mmsight.model.a.d kyo;
  com.tencent.mm.plugin.mmsight.model.f kyp;
  int kyq;
  private int kyr;
  int kys;
  private int kyt;
  private boolean kyu;
  private ObservableTextureView kyv;
  MMSightCameraGLSurfaceView kyw;
  boolean kyx;
  private MMSightRecordView.a kyy;
  boolean kyz;
  private int videoBitrate;
  private String videoPath;
  private WindowManager windowManager;
  
  public f()
  {
    AppMethodBeat.i(89226);
    this.kys = 0;
    this.kyu = true;
    this.kyx = false;
    this.kyz = false;
    this.kyA = false;
    this.kyB = -1;
    this.kyE = true;
    this.kyF = true;
    this.kyG = false;
    this.kyK = false;
    this.kyL = 1.0F;
    this.windowManager = null;
    this.kyM = null;
    this.kyN = new Point(0, 0);
    this.kyP = null;
    AppMethodBeat.o(89226);
  }
  
  private void bqK()
  {
    AppMethodBeat.i(89250);
    if ((this.kyp != null) && (this.kyp.dEO())) {
      if (!this.kyp.zub) {
        break label98;
      }
    }
    label98:
    int i;
    for (this.kyD = new Point(com.tencent.mm.plugin.mmsight.d.gZ((int)(this.kyp.getPreviewWidth() / this.ilP), this.kyp.getPreviewHeight()), this.kyp.getPreviewWidth());; this.kyD = new Point(this.kyp.getPreviewHeight(), i))
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "initVideoSize: %s", new Object[] { this.kyD });
      AppMethodBeat.o(89250);
      return;
      i = com.tencent.mm.plugin.mmsight.d.gZ((int)(this.kyp.getPreviewHeight() * this.ilP), this.kyp.getPreviewWidth());
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
  
  public final void I(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(89262);
    if ((this.kyp != null) && (this.kyp.dEO()) && (this.kyF)) {
      this.kyp.ejB();
    }
    AppMethodBeat.o(89262);
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void a(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(89240);
    if ((paramg != null) && (this.kyp != null) && (this.kyp.dEO()))
    {
      if (paramBoolean) {
        this.kyp.ejE();
      }
      if (paramBoolean)
      {
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89223);
            f.this.b(paramg, paramBoolean);
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
    if (this.kyo != null)
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", new Object[] { paramh });
      this.kyo.a(new d.a()
      {
        public final void bqP()
        {
          AppMethodBeat.i(89221);
          if (paramh != null) {
            paramh.hs(true);
          }
          AppMethodBeat.o(89221);
        }
      });
      this.kyo.E(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89222);
          f.this.kyx = false;
          if (paramh != null) {
            paramh.hs(false);
          }
          AppMethodBeat.o(89222);
        }
      });
      this.kyo = null;
    }
    AppMethodBeat.o(89239);
  }
  
  public final void a(final ByteBuffer paramByteBuffer, final MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(89266);
    if ((paramf == null) && (paramByteBuffer == null))
    {
      if (this.kyM != null)
      {
        this.kyM.release();
        this.kyM = null;
      }
      AppMethodBeat.o(89266);
      return;
    }
    if (this.kyM == null)
    {
      this.kyM = new h();
      bqS();
      this.kyM.kzb = new i.a()
      {
        public final void bqT()
        {
          AppMethodBeat.i(89225);
          if (paramf != null) {
            paramf.bGa();
          }
          AppMethodBeat.o(89225);
        }
        
        public final ByteBuffer getBuffer()
        {
          return paramByteBuffer;
        }
      };
      this.kyM.b(this.kyw.getEglContext());
    }
    AppMethodBeat.o(89266);
  }
  
  public final boolean aD(float paramFloat)
  {
    AppMethodBeat.i(89255);
    List localList = this.kyp.ejC();
    if ((this.kyO != null) && (this.kyO.mSize != 0)) {
      if (this.kyO.indexOfKey(Math.round(paramFloat * 10.0F)) < 0) {
        break label63;
      }
    }
    label63:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(89255);
      return false;
    }
    i = localList.indexOf(Integer.valueOf(this.kyO.ase(Math.round(paramFloat * 10.0F))));
    if (i < 0)
    {
      AppMethodBeat.o(89255);
      return false;
    }
    this.kyp.QM(i);
    AppMethodBeat.o(89255);
    return true;
  }
  
  public final boolean aai()
  {
    AppMethodBeat.i(89238);
    Log.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", new Object[] { this.kyo });
    bqJ();
    if (this.kyo == null)
    {
      Log.e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
      AppMethodBeat.o(89238);
      return false;
    }
    int i = getScreenRotation();
    Log.i("MicroMsg.MMSightRecordViewImpl", "screen rotate: %s", new Object[] { Integer.valueOf(i) });
    if ((i == 90) || (i == 270)) {}
    for (i = this.kyo.b(this.kyp.getOrientation(), true, 360 - i);; i = this.kyo.b(this.kyp.getOrientation(), false, i))
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
  
  public final boolean ai(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89260);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(89260);
      return false;
    }
    if ((this.kyJ != null) && (!this.kyG))
    {
      this.kyJ.bFX();
      this.kyG = true;
    }
    if (this.kyM != null)
    {
      i = getScreenRotation();
      this.kyM.E(paramArrayOfByte, i);
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
    if ((this.ilP > 0.0F) && (this.kyq > 0) && (this.kyp != null))
    {
      j = this.kyp.getPreviewWidth();
      i = this.kyp.getPreviewHeight();
      if (this.kyp.zub)
      {
        k = (int)(this.kyp.getPreviewWidth() / this.ilP);
        if (k >= i) {
          break label1110;
        }
        if ((!this.kyz) && (this.kyP == null))
        {
          this.kyP = new byte[j * k * 3 >> 1];
          localObject1 = this.kyP;
          Util.currentTicks();
          if (this.kys != 1) {
            break label898;
          }
          SightVideoJNI.cropCameraDataLongEdgeCenterCrop(paramArrayOfByte, (byte[])localObject1, i, this.kyD.x, j);
          i = k;
          if (this.kyz) {
            i = this.kyD.x;
          }
          this.kyK = true;
          localObject2 = localObject1;
          if (this.kyw != null)
          {
            localObject2 = this.kyw;
            k = this.kyp.getOrientation();
            if ((i != ((MMSightCameraGLSurfaceView)localObject2).kxW) || (j != ((MMSightCameraGLSurfaceView)localObject2).kxX) || (k != ((MMSightCameraGLSurfaceView)localObject2).iqx))
            {
              Log.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject2 });
              ((MMSightCameraGLSurfaceView)localObject2).kxW = i;
              ((MMSightCameraGLSurfaceView)localObject2).kxX = j;
              ((MMSightCameraGLSurfaceView)localObject2).iqx = k;
            }
            j = getScreenRotation();
            localObject2 = this.kyw;
            if ((localObject1 == null) || (((MMSightCameraGLSurfaceView)localObject2).kyg == null) || (((MMSightCameraGLSurfaceView)localObject2).kyg.kxV)) {
              break label1060;
            }
            locala = ((MMSightCameraGLSurfaceView)localObject2).kyg;
            k = ((MMSightCameraGLSurfaceView)localObject2).kxW;
            m = ((MMSightCameraGLSurfaceView)localObject2).kxX;
            n = ((MMSightCameraGLSurfaceView)localObject2).iqx;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      try
      {
        if ((locala.kxX != m) || (locala.kxW != k) || (locala.dYT != n) || (locala.kyf != j)) {
          continue;
        }
        if (i != 0) {
          Log.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { localObject1, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Boolean.valueOf(locala.iqo), Boolean.TRUE, locala });
        }
        locala.frameData = ((byte[])localObject1);
        locala.kxW = k;
        locala.kxX = m;
        locala.dYT = n;
        locala.kyf = j;
        if (i != 0)
        {
          locala.ikI = ByteBuffer.allocateDirect(m * k);
          locala.ikP = ByteBuffer.allocateDirect(k * m / 2);
          locala.ikI.order(ByteOrder.nativeOrder());
          locala.ikP.order(ByteOrder.nativeOrder());
          if (locala.kyd != null)
          {
            locala.hDU.put(locala.kyd);
            locala.hDU.position(0);
          }
        }
        if ((locala.ikI != null) && (locala.ikP != null))
        {
          locala.ikI.put((byte[])localObject1, 0, k * m);
          locala.ikI.position(0);
          locala.ikP.put((byte[])localObject1, k * m, k * m / 2);
          locala.ikP.position(0);
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
      if (this.kyy != null)
      {
        localObject1 = getPreviewSize();
        this.kyy.C(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y);
      }
      bool2 = true;
      j = 0;
      boolean bool1 = bool2;
      i = j;
      if (this.kyo != null)
      {
        bool1 = bool2;
        i = j;
        if (this.kyo.getFrameDataCallback() != null)
        {
          if ((!this.kyz) || (!this.kyK)) {
            break label1082;
          }
          bool1 = this.kyo.getFrameDataCallback().ai((byte[])localObject2);
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && ((this.kyo == null) || (this.kyo.aQN() != d.c.zvu))) {
          com.tencent.mm.plugin.mmsight.model.a.k.zwi.k((byte[])localObject2);
        }
        AppMethodBeat.o(89260);
        return bool1;
        localObject1 = com.tencent.mm.plugin.mmsight.model.a.k.zwi.h(Integer.valueOf(this.kyD.x * this.kyD.y * 3 >> 1));
        break;
        SightVideoJNI.cropCameraDataLongEdge(paramArrayOfByte, (byte[])localObject1, i, this.kyD.x, j);
        break label199;
        k = (int)(i * this.ilP);
        if (k < j)
        {
          if ((!this.kyz) && (this.kyP == null)) {
            this.kyP = new byte[k * i * 3 >> 1];
          }
          for (localObject1 = this.kyP;; localObject1 = com.tencent.mm.plugin.mmsight.model.a.k.zwi.h(Integer.valueOf(this.kyD.x * this.kyD.y * 3 >> 1)))
          {
            Util.currentTicks();
            SightVideoJNI.cropCameraData(paramArrayOfByte, (byte[])localObject1, i, j, this.kyD.y);
            j = this.kyD.y;
            this.kyK = true;
            break;
          }
          label1060:
          Log.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
          localObject2 = localObject1;
          break label719;
          localObject2 = paramArrayOfByte;
          break label719;
          label1082:
          bool1 = this.kyo.getFrameDataCallback().ai(paramArrayOfByte);
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
  
  public final void b(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(89227);
    this.context = paramContext;
    this.kyv = new ObservableTextureView(paramContext);
    this.kyw = new MMSightCameraGLSurfaceView(paramContext);
    this.kyw.setBackgroundColor(Color.argb(0, 0, 0, 0));
    int i = com.tencent.mm.cb.a.fromDPToPix(paramContext, 1);
    Object localObject = new FrameLayout.LayoutParams(i, i);
    paramViewGroup.addView(this.kyv, (ViewGroup.LayoutParams)localObject);
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    paramViewGroup.addView(this.kyw, (ViewGroup.LayoutParams)localObject);
    this.kyH = new g();
    this.kyH.kyZ = this;
    this.kyw.setOnTouchListener(this.kyH);
    com.tencent.mm.plugin.mmsight.model.k.ejI();
    Log.i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", new Object[] { paramContext });
    AppMethodBeat.o(89227);
  }
  
  final void b(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(89241);
    this.kyp.a(new f.b()
    {
      public final void a(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(89224);
        if (paramBoolean) {
          f.this.kyp.ejF();
        }
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousInt1 < 0) || (paramAnonymousInt2 < 0) || (paramAnonymousInt3 < 0))
        {
          Log.e("MicroMsg.MMSightRecordViewImpl", "onPictureYuvTaken, data is null!!");
          paramg.bFZ();
          AppMethodBeat.o(89224);
          return;
        }
        for (;;)
        {
          try
          {
            if (!f.this.kyA) {
              break label473;
            }
            f.this.bqL();
            if (f.this.kyp.zub)
            {
              if (f.this.kyC.y >= paramAnonymousInt1) {
                break label473;
              }
              localObject = new byte[f.this.kyC.x * f.this.kyC.y * 3 >> 1];
              if (f.this.kys == 1)
              {
                SightVideoJNI.cropCameraDataLongEdgeCenterCrop(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, f.this.kyC.y, paramAnonymousInt2);
                paramAnonymousInt1 = f.this.kyC.y;
                paramAnonymousInt2 = f.this.kyC.x;
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
                paramg.R(paramAnonymousArrayOfByte);
                AppMethodBeat.o(89224);
                return;
              }
              SightVideoJNI.cropCameraDataLongEdge(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, f.this.kyC.y, paramAnonymousInt2);
              continue;
            }
            if (f.this.kyC.x >= paramAnonymousInt2) {
              break label473;
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.MMSightRecordViewImpl", paramAnonymousArrayOfByte, "saveCaptureYuvDataToBitmap error: %s", new Object[] { paramAnonymousArrayOfByte.getMessage() });
            paramg.bFZ();
            AppMethodBeat.o(89224);
            return;
          }
          Object localObject = new byte[f.this.kyC.x * f.this.kyC.y * 3 >> 1];
          SightVideoJNI.cropCameraData(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, paramAnonymousInt2, f.this.kyC.x);
          paramAnonymousInt1 = f.this.kyC.y;
          paramAnonymousInt2 = f.this.kyC.x;
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
  
  public final void bqI()
  {
    AppMethodBeat.i(89236);
    bqJ();
    AppMethodBeat.o(89236);
  }
  
  final void bqJ()
  {
    AppMethodBeat.i(89237);
    if (this.kyx)
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
      AppMethodBeat.o(89237);
      return;
    }
    if (this.kyo != null)
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
      this.kyo.cancel();
      if (this.kyp != null) {
        this.kyp.b(this.kyo.getFrameDataCallback());
      }
      this.kyo = null;
    }
    if ((this.kyq > 0) && (this.kyt > 0) && (this.videoBitrate > 0) && (this.fps > 0) && (this.audioBitrate > 0) && (this.audioSampleRate > 0) && (this.kyp != null) && (this.kyp.getEncodeVideoBestSize() != null))
    {
      VideoTransPara localVideoTransPara = new VideoTransPara();
      localVideoTransPara.width = this.kyq;
      localVideoTransPara.height = ((int)(this.kyq / this.ilP));
      localVideoTransPara.duration = this.kyt;
      localVideoTransPara.videoBitrate = this.videoBitrate;
      localVideoTransPara.fps = this.fps;
      localVideoTransPara.audioBitrate = this.audioBitrate;
      localVideoTransPara.audioSampleRate = this.audioSampleRate;
      localVideoTransPara.iSU = 2;
      localVideoTransPara.iSV = 1;
      localVideoTransPara.iiH = 1;
      com.tencent.mm.plugin.mmsight.model.k.zuy.irT = localVideoTransPara;
      com.tencent.mm.plugin.mmsight.model.k.zuy.videoBitrate = this.videoBitrate;
      com.tencent.mm.plugin.mmsight.model.k.zuy.ilT = this.kyq;
      l.ekc();
      this.kyo = l.q(localVideoTransPara);
      if (this.kyo == null)
      {
        Log.e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
        if (this.kyI != null) {
          this.kyI.bFW();
        }
        AppMethodBeat.o(89237);
        return;
      }
      this.kyo.setFilePath(this.videoPath);
      if ((this.kyz) && (this.kyp != null) && (this.kyp.dEO())) {
        bqK();
      }
      int k = this.kyp.getEncodeVideoBestSize().x;
      int m = this.kyp.getEncodeVideoBestSize().y;
      int i = m;
      int j = k;
      if (this.kyD != null)
      {
        i = m;
        j = k;
        if (this.kyz)
        {
          j = this.kyD.x;
          i = this.kyD.y;
        }
      }
      j = (int)(j * this.kyL);
      i = (int)(i * this.kyL);
      j = com.tencent.mm.plugin.mmsight.d.QJ(j);
      i = com.tencent.mm.plugin.mmsight.d.QJ(i);
      Log.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.kyL) });
      if ((this.kyD != null) && (this.kyz)) {
        this.kyo.s(this.kyD.y, this.kyD.x, j, i);
      }
      for (;;)
      {
        this.kyo.aQT();
        this.kyo.a(this);
        if (this.kyo.rC(this.kyp.getOrientation())) {
          break;
        }
        Log.e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
        if (this.kyI != null) {
          this.kyI.bFW();
        }
        AppMethodBeat.o(89237);
        return;
        this.kyo.s(this.kyp.getPreviewWidth(), this.kyp.getPreviewHeight(), j, i);
      }
      this.kyx = true;
    }
    AppMethodBeat.o(89237);
  }
  
  final void bqL()
  {
    AppMethodBeat.i(89252);
    if ((this.kyp != null) && (this.kyp.dEO()))
    {
      if (this.kyp.zub)
      {
        int i = (int)(this.kyp.getPreviewWidth() / this.ilP);
        this.kyC = new Point(this.kyp.getPreviewWidth(), i);
        AppMethodBeat.o(89252);
        return;
      }
      this.kyC = new Point((int)(this.kyp.getPreviewHeight() * this.ilP), this.kyp.getPreviewHeight());
    }
    AppMethodBeat.o(89252);
  }
  
  final void bqM()
  {
    AppMethodBeat.i(89254);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", new Object[] { Integer.valueOf(this.kyB) });
    switch (this.kyB)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89254);
      return;
      this.kyp.ejE();
      AppMethodBeat.o(89254);
      return;
      this.kyp.ejF();
      AppMethodBeat.o(89254);
      return;
      this.kyp.ejG();
    }
  }
  
  public final void bqN()
  {
    AppMethodBeat.i(89256);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
    this.kyL = 0.5F;
    AppMethodBeat.o(89256);
  }
  
  public final void bqO()
  {
    AppMethodBeat.i(89257);
    Log.i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
    this.kyL = 0.75F;
    AppMethodBeat.o(89257);
  }
  
  public final void bqP()
  {
    AppMethodBeat.i(89261);
    Log.i("MicroMsg.MMSightRecordViewImpl", "onError: %s", new Object[] { Integer.valueOf(1) });
    this.kyo.reset();
    AppMethodBeat.o(89261);
  }
  
  public final void bqQ()
  {
    AppMethodBeat.i(89263);
    if ((this.kyp != null) && (this.kyp.dEO()) && (this.kyE)) {
      this.kyp.d(true, false, 1);
    }
    AppMethodBeat.o(89263);
  }
  
  public final void bqR()
  {
    AppMethodBeat.i(89264);
    if ((this.kyp != null) && (this.kyp.dEO()) && (this.kyE)) {
      this.kyp.d(false, false, 1);
    }
    AppMethodBeat.o(89264);
  }
  
  final void bqS()
  {
    AppMethodBeat.i(89267);
    Point localPoint = getPreviewSize();
    this.kyN.y = this.kyr;
    this.kyN.x = (localPoint.x * this.kyr / localPoint.y);
    if ((getScreenRotation() == 0) || (getScreenRotation() == 180))
    {
      int i = this.kyN.y;
      this.kyN.y = this.kyN.x;
      this.kyN.x = i;
    }
    if (this.kyM != null) {
      this.kyM.i(localPoint.x, localPoint.y, this.kyp.getOrientation(), this.kyN.x, this.kyN.y);
    }
    AppMethodBeat.o(89267);
  }
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(89247);
    if (this.kyp != null)
    {
      int i = this.kyp.getOrientation();
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
    if ((this.kyp != null) && (this.kyp.dEO()))
    {
      localObject2 = this.kyp;
      if (((com.tencent.mm.plugin.mmsight.model.f)localObject2).ims != null)
      {
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).imr = true;
        localObject1 = new byte[((com.tencent.mm.plugin.mmsight.model.f)localObject2).ims.length];
        System.arraycopy(((com.tencent.mm.plugin.mmsight.model.f)localObject2).ims, 0, localObject1, 0, ((com.tencent.mm.plugin.mmsight.model.f)localObject2).ims.length);
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).imr = false;
        if (localObject1 == null) {
          break label495;
        }
        j = this.kyp.getPreviewWidth();
        i = this.kyp.getPreviewHeight();
        if (!this.kyp.zub) {
          break label379;
        }
        k = (int)(this.kyp.getPreviewWidth() / this.ilP);
        if (k >= i) {
          break label506;
        }
        if ((this.kyz) || (this.kyP != null)) {
          break label327;
        }
        this.kyP = new byte[j * k * 3 >> 1];
        localObject2 = this.kyP;
        label161:
        if (this.kys != 1) {
          break label360;
        }
        SightVideoJNI.cropCameraDataLongEdgeCenterCrop((byte[])localObject1, (byte[])localObject2, i, this.kyD.x, j);
        label185:
        i = k;
        if (this.kyz) {
          i = this.kyD.x;
        }
        this.kyK = true;
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
        localObject2 = BitmapUtil.rotate((Bitmap)localObject1, this.kyp.getOrientation());
        Log.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject1 });
        ((Bitmap)localObject1).recycle();
        AppMethodBeat.o(89258);
        return localObject2;
        localObject1 = null;
        break;
        label327:
        localObject2 = com.tencent.mm.plugin.mmsight.model.a.k.zwi.h(Integer.valueOf(this.kyD.x * this.kyD.y * 3 >> 1));
        break label161;
        label360:
        SightVideoJNI.cropCameraDataLongEdge((byte[])localObject1, (byte[])localObject2, i, this.kyD.x, j);
        break label185;
        label379:
        k = (int)(i * this.ilP);
        if (k < j)
        {
          if ((!this.kyz) && (this.kyP == null)) {
            this.kyP = new byte[k * i * 3 >> 1];
          }
          for (localObject2 = this.kyP;; localObject2 = com.tencent.mm.plugin.mmsight.model.a.k.zwi.h(Integer.valueOf(this.kyD.x * this.kyD.y * 3 >> 1)))
          {
            SightVideoJNI.cropCameraData((byte[])localObject1, (byte[])localObject2, i, j, this.kyD.y);
            j = this.kyD.y;
            this.kyK = true;
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
    Log.i("MicroMsg.MMSightRecordViewImpl", "getDrawSizePoint : %s", new Object[] { this.kyN.toString() });
    Point localPoint = this.kyN;
    AppMethodBeat.o(89246);
    return localPoint;
  }
  
  public final int getFlashMode()
  {
    return this.kyB;
  }
  
  public final Point getPictureSize()
  {
    AppMethodBeat.i(89243);
    if ((this.kyp != null) && (this.kyp.dEO()))
    {
      if (!this.kyA)
      {
        localPoint = new Point(this.kyp.getPreviewWidth(), this.kyp.getPreviewHeight());
        AppMethodBeat.o(89243);
        return localPoint;
      }
      bqL();
      Point localPoint = this.kyC;
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
    if ((this.kyp.getOrientation() == 0) || (this.kyp.getOrientation() == 180))
    {
      j = 1;
      if (j == 0) {
        break label78;
      }
      i = this.kyp.getPreviewWidth();
      label43:
      if (j == 0) {
        break label89;
      }
    }
    label78:
    label89:
    for (int j = this.kyp.getPreviewHeight();; j = this.kyp.getPreviewWidth())
    {
      Point localPoint = new Point(i, j);
      AppMethodBeat.o(89245);
      return localPoint;
      j = 0;
      break;
      i = this.kyp.getPreviewHeight();
      break label43;
    }
  }
  
  public final float[] getSupportZoomMultiple()
  {
    int i = 0;
    if ((this.kyO == null) || (this.kyO.mSize == 0)) {
      return new float[0];
    }
    float[] arrayOfFloat = new float[this.kyO.mSize];
    while (i < this.kyO.mSize)
    {
      arrayOfFloat[i] = (this.kyO.Pi[i] * 1.0F / 10.0F);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public final String getVideoFilePath()
  {
    AppMethodBeat.i(89235);
    if ((this.kyo != null) && (this.kyx))
    {
      str = this.kyo.getFilePath();
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
    if ((this.kyp != null) && (this.kyp.dEO()))
    {
      int k = this.kyp.getEncodeVideoBestSize().x;
      int m = this.kyp.getEncodeVideoBestSize().y;
      int i = m;
      int j = k;
      if (this.kyD != null)
      {
        i = m;
        j = k;
        if (this.kyz)
        {
          j = this.kyD.x;
          i = this.kyD.y;
        }
      }
      j = (int)(j * this.kyL);
      i = (int)(i * this.kyL);
      Point localPoint = new Point(com.tencent.mm.plugin.mmsight.d.QJ(j), com.tencent.mm.plugin.mmsight.d.QJ(i));
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
    Log.i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", new Object[] { this.kyp, this.kyo });
    if (this.kyp != null)
    {
      this.kyp.b(this);
      this.kyp.ejD();
    }
    if (this.kyo != null)
    {
      this.kyo.a(null);
      this.kyo.E(null);
      this.kyo = null;
    }
    if (this.kyM != null) {
      this.kyM.release();
    }
    if (this.kyO != null) {
      this.kyO.mSize = 0;
    }
    this.kyO = null;
    this.kyx = false;
    this.kyz = false;
    this.kyA = false;
    this.kyC = null;
    this.kyD = null;
    this.kyB = -1;
    this.kyE = true;
    this.kyF = true;
    this.kyG = false;
    com.tencent.mm.plugin.mmsight.model.a.k.zwi.aRR();
    AppMethodBeat.o(89259);
  }
  
  public final void setClipPictureSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89251);
    this.kyA = paramBoolean;
    if ((this.kyA) && (this.kyp != null) && (this.kyp.dEO())) {
      bqL();
    }
    AppMethodBeat.o(89251);
  }
  
  public final void setClipVideoSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89249);
    this.kyz = paramBoolean;
    if ((this.kyz) && (this.kyp != null) && (this.kyp.dEO())) {
      bqK();
    }
    AppMethodBeat.o(89249);
  }
  
  public final void setDisplayRatio(float paramFloat)
  {
    AppMethodBeat.i(89228);
    int i = getScreenRotation();
    Log.i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s, screenRotation: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i) });
    this.ilP = paramFloat;
    if ((i == 90) || (i == 270)) {
      this.ilP = (1.0F / this.ilP);
    }
    AppMethodBeat.o(89228);
  }
  
  public final void setDisplayScreenSize(Size paramSize) {}
  
  public final void setEnableDragZoom(boolean paramBoolean)
  {
    this.kyE = paramBoolean;
  }
  
  public final void setEnableTouchFocus(boolean paramBoolean)
  {
    this.kyF = paramBoolean;
  }
  
  public final void setFlashMode(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(89253);
    this.kyB = paramInt;
    com.tencent.mm.plugin.mmsight.model.f localf = this.kyp;
    if ((this.kyp != null) && (this.kyp.dEO())) {}
    for (;;)
    {
      Log.i("MicroMsg.MMSightRecordViewImpl", "setFlashMode: %s, camera: %s, previewing: %s", new Object[] { Integer.valueOf(paramInt), localf, Boolean.valueOf(bool) });
      if ((this.kyp != null) && (this.kyp.dEO())) {
        bqM();
      }
      AppMethodBeat.o(89253);
      return;
      bool = false;
    }
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.kyy = parama;
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    this.kyJ = paramc;
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    this.kyI = paramd;
  }
  
  public final void setPreviewMode(int paramInt)
  {
    AppMethodBeat.i(89231);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setPreviewMode: %s", new Object[] { Integer.valueOf(paramInt) });
    this.kys = paramInt;
    AppMethodBeat.o(89231);
  }
  
  public final void setPreviewSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89229);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.kyq = paramInt;
    AppMethodBeat.o(89229);
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89230);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setRGBSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.kyr = paramInt;
    AppMethodBeat.o(89230);
  }
  
  public final void setUseBackCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(89242);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kyu = paramBoolean;
    AppMethodBeat.o(89242);
  }
  
  public final void setVideoFilePath(String paramString)
  {
    AppMethodBeat.i(89234);
    Log.i("MicroMsg.MMSightRecordViewImpl", "setVideoFilePath: %s", new Object[] { paramString });
    this.videoPath = paramString;
    AppMethodBeat.o(89234);
  }
  
  public final void setVideoPara$2e715812(int paramInt)
  {
    AppMethodBeat.i(89233);
    this.kyt = paramInt;
    this.videoBitrate = 4800000;
    this.fps = 30;
    this.audioBitrate = 64000;
    this.audioSampleRate = 44100;
    Log.i("MicroMsg.MMSightRecordViewImpl", "setVideoPara, maxDuration: %s, videoBitrate: %s, fps: %s, audioBitrate: %s, audioSampleRate: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(4800000), Integer.valueOf(30), Integer.valueOf(64000), Integer.valueOf(44100) });
    AppMethodBeat.o(89233);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(89232);
    Log.i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", new Object[] { Float.valueOf(this.ilP), Integer.valueOf(this.kyq) });
    this.kyG = false;
    if ((this.ilP > 0.0F) && (this.kyq > 0))
    {
      Object localObject = new VideoTransPara();
      ((VideoTransPara)localObject).width = this.kyq;
      ((VideoTransPara)localObject).height = ((int)(this.kyq / this.ilP));
      Log.i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", new Object[] { Integer.valueOf(((VideoTransPara)localObject).width), Integer.valueOf(((VideoTransPara)localObject).height) });
      this.kyp = new com.tencent.mm.plugin.mmsight.model.f((VideoTransPara)localObject, -1);
      this.kyp.a(this);
      if (!this.kyp.D(this.context, this.kyu))
      {
        Log.i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
        if (this.kyI != null) {
          this.kyI.bFW();
        }
        AppMethodBeat.o(89232);
        return;
      }
      Log.i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
      localObject = this.kyp.ejC();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        if (this.kyv.isAvailable())
        {
          if (this.kyp.a(this.kyv.getSurfaceTexture(), this.kyq, this.ilP, this.kyz) < 0)
          {
            Log.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (this.kyI != null) {
              this.kyI.bFW();
            }
          }
          if (this.kyB != -1) {
            bqM();
          }
          this.kyp.ejz();
          Log.i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
          bqJ();
          bqS();
          if (this.kyM != null) {
            this.kyM.b(this.kyw.getEglContext());
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
        this.kyO = new com.tencent.tinker.a.c.b(j);
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
            this.kyO.append(k, k * i - m);
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
            this.kyO.append(k, m + k * i);
          }
          else
          {
            m += 1;
            break label467;
            label558:
            this.kyO.append(k, k * i);
          }
        }
      }
      this.kyv.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
      {
        public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(89220);
          if (f.this.kyp.a(paramAnonymousSurfaceTexture, f.this.kyq, f.this.ilP, f.this.kyz) < 0)
          {
            Log.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (f.this.kyI != null) {
              f.this.kyI.bFW();
            }
          }
          if (f.this.kyB != -1) {
            f.this.bqM();
          }
          f.this.kyp.ejz();
          f.this.bqJ();
          f.this.bqS();
          if (f.this.kyM != null) {
            f.this.kyM.b(f.this.kyw.getEglContext());
          }
          Log.i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
          AppMethodBeat.o(89220);
        }
      });
    }
    AppMethodBeat.o(89232);
  }
  
  public final void switchCamera()
  {
    AppMethodBeat.i(89248);
    if ((this.kyp != null) && (this.kyp.dEO()) && ((this.kyo == null) || (this.kyo.aQN() != d.c.zvu)))
    {
      this.kyp.a(this.context, this.kyv.getSurfaceTexture(), this.kyq, this.ilP, this.kyz);
      if (this.kyM != null) {
        bqS();
      }
    }
    AppMethodBeat.o(89248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f
 * JD-Core Version:    0.7.0.1
 */