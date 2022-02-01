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
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.f.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  float gwC;
  private com.tencent.mm.plugin.mmsight.model.a.d iBA;
  com.tencent.mm.plugin.mmsight.model.f iBB;
  int iBC;
  private int iBD;
  int iBE;
  private int iBF;
  private boolean iBG;
  private ObservableTextureView iBH;
  MMSightCameraGLSurfaceView iBI;
  boolean iBJ;
  private MMSightRecordView.a iBK;
  boolean iBL;
  boolean iBM;
  int iBN;
  Point iBO;
  private Point iBP;
  private boolean iBQ;
  private boolean iBR;
  private boolean iBS;
  private g iBT;
  MMSightRecordView.d iBU;
  private MMSightRecordView.c iBV;
  private boolean iBW;
  private float iBX;
  h iBY;
  private Point iBZ;
  private com.tencent.tinker.a.c.b iCa;
  private byte[] iCb;
  private int videoBitrate;
  private String videoPath;
  private WindowManager windowManager;
  
  public f()
  {
    AppMethodBeat.i(89226);
    this.iBE = 0;
    this.iBG = true;
    this.iBJ = false;
    this.iBL = false;
    this.iBM = false;
    this.iBN = -1;
    this.iBQ = true;
    this.iBR = true;
    this.iBS = false;
    this.iBW = false;
    this.iBX = 1.0F;
    this.windowManager = null;
    this.iBY = null;
    this.iBZ = new Point(0, 0);
    this.iCb = null;
    AppMethodBeat.o(89226);
  }
  
  private void aLl()
  {
    AppMethodBeat.i(89250);
    if ((this.iBB != null) && (this.iBB.cPP())) {
      if (!this.iBB.tCs) {
        break label98;
      }
    }
    label98:
    int i;
    for (this.iBP = new Point(com.tencent.mm.plugin.mmsight.d.ga((int)(this.iBB.getPreviewWidth() / this.gwC), this.iBB.getPreviewHeight()), this.iBB.getPreviewWidth());; this.iBP = new Point(this.iBB.getPreviewHeight(), i))
    {
      ad.i("MicroMsg.MMSightRecordViewImpl", "initVideoSize: %s", new Object[] { this.iBP });
      AppMethodBeat.o(89250);
      return;
      i = com.tencent.mm.plugin.mmsight.d.ga((int)(this.iBB.getPreviewHeight() * this.gwC), this.iBB.getPreviewWidth());
    }
  }
  
  private int getScreenRotation()
  {
    AppMethodBeat.i(89265);
    if (this.windowManager == null) {
      this.windowManager = ((WindowManager)aj.getContext().getSystemService("window"));
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
  
  public final void A(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(89262);
    if ((this.iBB != null) && (this.iBB.cPP()) && (this.iBR)) {
      this.iBB.cPJ();
    }
    AppMethodBeat.o(89262);
  }
  
  public final boolean Ok()
  {
    AppMethodBeat.i(89238);
    ad.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", new Object[] { this.iBA });
    aLk();
    if (this.iBA == null)
    {
      ad.e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
      AppMethodBeat.o(89238);
      return false;
    }
    int i = getScreenRotation();
    ad.i("MicroMsg.MMSightRecordViewImpl", "screen rotate: %s", new Object[] { Integer.valueOf(i) });
    if ((i == 90) || (i == 270)) {}
    for (i = this.iBA.b(this.iBB.getOrientation(), true, 360 - i);; i = this.iBA.b(this.iBB.getOrientation(), false, i))
    {
      ad.i("MicroMsg.MMSightRecordViewImpl", "startRecord now, ret: %s", new Object[] { Integer.valueOf(i) });
      if (i < 0) {
        break;
      }
      AppMethodBeat.o(89238);
      return true;
    }
    AppMethodBeat.o(89238);
    return false;
  }
  
  public final boolean W(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89260);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(89260);
      return false;
    }
    if ((this.iBV != null) && (!this.iBS))
    {
      this.iBV.aZw();
      this.iBS = true;
    }
    if (this.iBY != null)
    {
      i = getScreenRotation();
      this.iBY.E(paramArrayOfByte, i);
    }
    int j;
    int k;
    Object localObject1;
    label197:
    label220:
    Object localObject2;
    a locala;
    int m;
    int n;
    if ((this.gwC > 0.0F) && (this.iBC > 0) && (this.iBB != null))
    {
      j = this.iBB.getPreviewWidth();
      i = this.iBB.getPreviewHeight();
      if (this.iBB.tCs)
      {
        k = (int)(this.iBB.getPreviewWidth() / this.gwC);
        if (k >= i) {
          break label1107;
        }
        if ((!this.iBL) && (this.iCb == null))
        {
          this.iCb = new byte[j * k * 3 >> 1];
          localObject1 = this.iCb;
          bt.GC();
          if (this.iBE != 1) {
            break label895;
          }
          SightVideoJNI.cropCameraDataLongEdgeCenterCrop(paramArrayOfByte, (byte[])localObject1, i, this.iBP.x, j);
          i = k;
          if (this.iBL) {
            i = this.iBP.x;
          }
          this.iBW = true;
          localObject2 = localObject1;
          if (this.iBI != null)
          {
            localObject2 = this.iBI;
            k = this.iBB.getOrientation();
            if ((i != ((MMSightCameraGLSurfaceView)localObject2).iBi) || (j != ((MMSightCameraGLSurfaceView)localObject2).iBj) || (k != ((MMSightCameraGLSurfaceView)localObject2).gBD))
            {
              ad.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject2 });
              ((MMSightCameraGLSurfaceView)localObject2).iBi = i;
              ((MMSightCameraGLSurfaceView)localObject2).iBj = j;
              ((MMSightCameraGLSurfaceView)localObject2).gBD = k;
            }
            j = getScreenRotation();
            localObject2 = this.iBI;
            if ((localObject1 == null) || (((MMSightCameraGLSurfaceView)localObject2).iBs == null) || (((MMSightCameraGLSurfaceView)localObject2).iBs.iBh)) {
              break label1057;
            }
            locala = ((MMSightCameraGLSurfaceView)localObject2).iBs;
            k = ((MMSightCameraGLSurfaceView)localObject2).iBi;
            m = ((MMSightCameraGLSurfaceView)localObject2).iBj;
            n = ((MMSightCameraGLSurfaceView)localObject2).gBD;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      try
      {
        if ((locala.iBj != m) || (locala.iBi != k) || (locala.dwp != n) || (locala.iBr != j)) {
          continue;
        }
        if (i != 0) {
          ad.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { localObject1, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Boolean.valueOf(locala.gBu), Boolean.TRUE, locala });
        }
        locala.frameData = ((byte[])localObject1);
        locala.iBi = k;
        locala.iBj = m;
        locala.dwp = n;
        locala.iBr = j;
        if (i != 0)
        {
          locala.gvZ = ByteBuffer.allocateDirect(m * k);
          locala.gwa = ByteBuffer.allocateDirect(k * m / 2);
          locala.gvZ.order(ByteOrder.nativeOrder());
          locala.gwa.order(ByteOrder.nativeOrder());
          if (locala.iBp != null)
          {
            locala.guT.put(locala.iBp);
            locala.guT.position(0);
          }
        }
        if ((locala.gvZ != null) && (locala.gwa != null))
        {
          locala.gvZ.put((byte[])localObject1, 0, k * m);
          locala.gvZ.position(0);
          locala.gwa.put((byte[])localObject1, k * m, k * m / 2);
          locala.gwa.position(0);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label717:
          boolean bool2;
          label895:
          ad.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[] { localException.getMessage() });
        }
      }
      ((MMSightCameraGLSurfaceView)localObject2).requestRender();
      localObject2 = localObject1;
      if (this.iBK != null)
      {
        localObject1 = getPreviewSize();
        this.iBK.t(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y);
      }
      bool2 = true;
      j = 0;
      boolean bool1 = bool2;
      i = j;
      if (this.iBA != null)
      {
        bool1 = bool2;
        i = j;
        if (this.iBA.getFrameDataCallback() != null)
        {
          if ((!this.iBL) || (!this.iBW)) {
            break label1079;
          }
          bool1 = this.iBA.getFrameDataCallback().W((byte[])localObject2);
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && ((this.iBA == null) || (this.iBA.aoq() != d.c.tDO))) {
          j.tEA.k((byte[])localObject2);
        }
        AppMethodBeat.o(89260);
        return bool1;
        localObject1 = j.tEA.g(Integer.valueOf(this.iBP.x * this.iBP.y * 3 >> 1));
        break;
        SightVideoJNI.cropCameraDataLongEdge(paramArrayOfByte, (byte[])localObject1, i, this.iBP.x, j);
        break label197;
        k = (int)(i * this.gwC);
        if (k < j)
        {
          if ((!this.iBL) && (this.iCb == null)) {
            this.iCb = new byte[k * i * 3 >> 1];
          }
          for (localObject1 = this.iCb;; localObject1 = j.tEA.g(Integer.valueOf(this.iBP.x * this.iBP.y * 3 >> 1)))
          {
            bt.GC();
            SightVideoJNI.cropCameraData(paramArrayOfByte, (byte[])localObject1, i, j, this.iBP.y);
            j = this.iBP.y;
            this.iBW = true;
            break;
          }
          label1057:
          ad.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
          localObject2 = localObject1;
          break label717;
          localObject2 = paramArrayOfByte;
          break label717;
          label1079:
          bool1 = this.iBA.getFrameDataCallback().W(paramArrayOfByte);
          i = j;
          continue;
        }
        localObject1 = paramArrayOfByte;
        break label220;
        label1107:
        localObject1 = paramArrayOfByte;
        break label220;
      }
    }
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void a(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(89240);
    if ((paramg != null) && (this.iBB != null) && (this.iBB.cPP()))
    {
      if (paramBoolean) {
        this.iBB.cPM();
      }
      if (paramBoolean)
      {
        aq.n(new Runnable()
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
    if (this.iBA != null)
    {
      ad.i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", new Object[] { paramh });
      this.iBA.a(new d.a()
      {
        public final void aLq()
        {
          AppMethodBeat.i(89221);
          if (paramh != null) {
            paramh.fU(true);
          }
          AppMethodBeat.o(89221);
        }
      });
      this.iBA.C(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89222);
          f.this.iBJ = false;
          if (paramh != null) {
            paramh.fU(false);
          }
          AppMethodBeat.o(89222);
        }
      });
      this.iBA = null;
    }
    AppMethodBeat.o(89239);
  }
  
  public final void a(final ByteBuffer paramByteBuffer, final MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(89266);
    if ((paramf == null) && (paramByteBuffer == null))
    {
      if (this.iBY != null)
      {
        this.iBY.release();
        this.iBY = null;
      }
      AppMethodBeat.o(89266);
      return;
    }
    if (this.iBY == null)
    {
      this.iBY = new h();
      aLt();
      this.iBY.iCn = new i.a()
      {
        public final void aLu()
        {
          AppMethodBeat.i(89225);
          if (paramf != null) {
            paramf.aZz();
          }
          AppMethodBeat.o(89225);
        }
        
        public final ByteBuffer getBuffer()
        {
          return paramByteBuffer;
        }
      };
      this.iBY.b(this.iBI.getEglContext());
    }
    AppMethodBeat.o(89266);
  }
  
  public final void aLj()
  {
    AppMethodBeat.i(89236);
    aLk();
    AppMethodBeat.o(89236);
  }
  
  final void aLk()
  {
    AppMethodBeat.i(89237);
    if (this.iBJ)
    {
      ad.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
      AppMethodBeat.o(89237);
      return;
    }
    if (this.iBA != null)
    {
      ad.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
      this.iBA.cancel();
      if (this.iBB != null) {
        this.iBB.b(this.iBA.getFrameDataCallback());
      }
      this.iBA = null;
    }
    if ((this.iBC > 0) && (this.iBF > 0) && (this.videoBitrate > 0) && (this.fps > 0) && (this.audioBitrate > 0) && (this.audioSampleRate > 0) && (this.iBB != null) && (this.iBB.getEncodeVideoBestSize() != null))
    {
      VideoTransPara localVideoTransPara = new VideoTransPara();
      localVideoTransPara.width = this.iBC;
      localVideoTransPara.height = ((int)(this.iBC / this.gwC));
      localVideoTransPara.duration = this.iBF;
      localVideoTransPara.videoBitrate = this.videoBitrate;
      localVideoTransPara.fps = this.fps;
      localVideoTransPara.audioBitrate = this.audioBitrate;
      localVideoTransPara.audioSampleRate = this.audioSampleRate;
      localVideoTransPara.hbX = 2;
      localVideoTransPara.hbY = 1;
      localVideoTransPara.hbW = 1;
      com.tencent.mm.plugin.mmsight.model.k.tCN.gCB = localVideoTransPara;
      com.tencent.mm.plugin.mmsight.model.k.tCN.videoBitrate = this.videoBitrate;
      com.tencent.mm.plugin.mmsight.model.k.tCN.gwG = this.iBC;
      com.tencent.mm.plugin.mmsight.model.a.k.cQk();
      this.iBA = com.tencent.mm.plugin.mmsight.model.a.k.q(localVideoTransPara);
      if (this.iBA == null)
      {
        ad.e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
        if (this.iBU != null) {
          this.iBU.aZv();
        }
        AppMethodBeat.o(89237);
        return;
      }
      this.iBA.setFilePath(this.videoPath);
      if ((this.iBL) && (this.iBB != null) && (this.iBB.cPP())) {
        aLl();
      }
      int k = this.iBB.getEncodeVideoBestSize().x;
      int m = this.iBB.getEncodeVideoBestSize().y;
      int i = m;
      int j = k;
      if (this.iBP != null)
      {
        i = m;
        j = k;
        if (this.iBL)
        {
          j = this.iBP.x;
          i = this.iBP.y;
        }
      }
      j = (int)(j * this.iBX);
      i = (int)(i * this.iBX);
      j = com.tencent.mm.plugin.mmsight.d.GP(j);
      i = com.tencent.mm.plugin.mmsight.d.GP(i);
      ad.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.iBX) });
      if ((this.iBP != null) && (this.iBL)) {
        this.iBA.s(this.iBP.y, this.iBP.x, j, i);
      }
      for (;;)
      {
        this.iBA.aox();
        this.iBA.a(this);
        if (this.iBA.mQ(this.iBB.getOrientation())) {
          break;
        }
        ad.e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
        if (this.iBU != null) {
          this.iBU.aZv();
        }
        AppMethodBeat.o(89237);
        return;
        this.iBA.s(this.iBB.getPreviewWidth(), this.iBB.getPreviewHeight(), j, i);
      }
      this.iBJ = true;
    }
    AppMethodBeat.o(89237);
  }
  
  final void aLm()
  {
    AppMethodBeat.i(89252);
    if ((this.iBB != null) && (this.iBB.cPP()))
    {
      if (this.iBB.tCs)
      {
        int i = (int)(this.iBB.getPreviewWidth() / this.gwC);
        this.iBO = new Point(this.iBB.getPreviewWidth(), i);
        AppMethodBeat.o(89252);
        return;
      }
      this.iBO = new Point((int)(this.iBB.getPreviewHeight() * this.gwC), this.iBB.getPreviewHeight());
    }
    AppMethodBeat.o(89252);
  }
  
  final void aLn()
  {
    AppMethodBeat.i(89254);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", new Object[] { Integer.valueOf(this.iBN) });
    switch (this.iBN)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89254);
      return;
      this.iBB.cPM();
      AppMethodBeat.o(89254);
      return;
      this.iBB.cPN();
      AppMethodBeat.o(89254);
      return;
      this.iBB.cPO();
    }
  }
  
  public final void aLo()
  {
    AppMethodBeat.i(89256);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
    this.iBX = 0.5F;
    AppMethodBeat.o(89256);
  }
  
  public final void aLp()
  {
    AppMethodBeat.i(89257);
    ad.i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
    this.iBX = 0.75F;
    AppMethodBeat.o(89257);
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(89261);
    ad.i("MicroMsg.MMSightRecordViewImpl", "onError: %s", new Object[] { Integer.valueOf(1) });
    this.iBA.reset();
    AppMethodBeat.o(89261);
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(89263);
    if ((this.iBB != null) && (this.iBB.cPP()) && (this.iBQ)) {
      this.iBB.c(true, false, 1);
    }
    AppMethodBeat.o(89263);
  }
  
  public final void aLs()
  {
    AppMethodBeat.i(89264);
    if ((this.iBB != null) && (this.iBB.cPP()) && (this.iBQ)) {
      this.iBB.c(false, false, 1);
    }
    AppMethodBeat.o(89264);
  }
  
  final void aLt()
  {
    AppMethodBeat.i(89267);
    Point localPoint = getPreviewSize();
    this.iBZ.y = this.iBD;
    this.iBZ.x = (localPoint.x * this.iBD / localPoint.y);
    if ((getScreenRotation() == 0) || (getScreenRotation() == 180))
    {
      int i = this.iBZ.y;
      this.iBZ.y = this.iBZ.x;
      this.iBZ.x = i;
    }
    if (this.iBY != null) {
      this.iBY.h(localPoint.x, localPoint.y, this.iBB.getOrientation(), this.iBZ.x, this.iBZ.y);
    }
    AppMethodBeat.o(89267);
  }
  
  public final boolean am(float paramFloat)
  {
    AppMethodBeat.i(89255);
    List localList = this.iBB.cPK();
    if ((this.iCa != null) && (this.iCa.mSize != 0)) {
      if (this.iCa.indexOfKey(Math.round(paramFloat * 10.0F)) < 0) {
        break label63;
      }
    }
    label63:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(89255);
      return false;
    }
    i = localList.indexOf(Integer.valueOf(this.iCa.acz(Math.round(paramFloat * 10.0F))));
    if (i < 0)
    {
      AppMethodBeat.o(89255);
      return false;
    }
    this.iBB.GS(i);
    AppMethodBeat.o(89255);
    return true;
  }
  
  public final void b(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(89227);
    this.context = paramContext;
    this.iBH = new ObservableTextureView(paramContext);
    this.iBI = new MMSightCameraGLSurfaceView(paramContext);
    this.iBI.setBackgroundColor(Color.argb(0, 0, 0, 0));
    int i = com.tencent.mm.cd.a.fromDPToPix(paramContext, 1);
    Object localObject = new FrameLayout.LayoutParams(i, i);
    paramViewGroup.addView(this.iBH, (ViewGroup.LayoutParams)localObject);
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    paramViewGroup.addView(this.iBI, (ViewGroup.LayoutParams)localObject);
    this.iBT = new g();
    this.iBT.iCl = this;
    this.iBI.setOnTouchListener(this.iBT);
    com.tencent.mm.plugin.mmsight.model.k.cPR();
    ad.i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", new Object[] { paramContext });
    AppMethodBeat.o(89227);
  }
  
  final void b(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(89241);
    this.iBB.a(new f.b()
    {
      public final void a(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(89224);
        if (paramBoolean) {
          f.this.iBB.cPN();
        }
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousInt1 < 0) || (paramAnonymousInt2 < 0) || (paramAnonymousInt3 < 0))
        {
          ad.e("MicroMsg.MMSightRecordViewImpl", "onPictureYuvTaken, data is null!!");
          paramg.aZy();
          AppMethodBeat.o(89224);
          return;
        }
        for (;;)
        {
          try
          {
            if (!f.this.iBM) {
              break label473;
            }
            f.this.aLm();
            if (f.this.iBB.tCs)
            {
              if (f.this.iBO.y >= paramAnonymousInt1) {
                break label473;
              }
              localObject = new byte[f.this.iBO.x * f.this.iBO.y * 3 >> 1];
              if (f.this.iBE == 1)
              {
                SightVideoJNI.cropCameraDataLongEdgeCenterCrop(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, f.this.iBO.y, paramAnonymousInt2);
                paramAnonymousInt1 = f.this.iBO.y;
                paramAnonymousInt2 = f.this.iBO.x;
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
                ad.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject.toString() });
                ((Bitmap)localObject).recycle();
                paramg.N(paramAnonymousArrayOfByte);
                AppMethodBeat.o(89224);
                return;
              }
              SightVideoJNI.cropCameraDataLongEdge(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, f.this.iBO.y, paramAnonymousInt2);
              continue;
            }
            if (f.this.iBO.x >= paramAnonymousInt2) {
              break label473;
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ad.printErrStackTrace("MicroMsg.MMSightRecordViewImpl", paramAnonymousArrayOfByte, "saveCaptureYuvDataToBitmap error: %s", new Object[] { paramAnonymousArrayOfByte.getMessage() });
            paramg.aZy();
            AppMethodBeat.o(89224);
            return;
          }
          Object localObject = new byte[f.this.iBO.x * f.this.iBO.y * 3 >> 1];
          SightVideoJNI.cropCameraData(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, paramAnonymousInt2, f.this.iBO.x);
          paramAnonymousInt1 = f.this.iBO.y;
          paramAnonymousInt2 = f.this.iBO.x;
          paramAnonymousArrayOfByte = (byte[])localObject;
          continue;
          label473:
          label476:
          label490:
          do
          {
            paramAnonymousArrayOfByte = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject, paramAnonymousInt1);
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
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(89247);
    if (this.iBB != null)
    {
      int i = this.iBB.getOrientation();
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
    if ((this.iBB != null) && (this.iBB.cPP()))
    {
      localObject2 = this.iBB;
      if (((com.tencent.mm.plugin.mmsight.model.f)localObject2).gxw != null)
      {
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).gxv = true;
        localObject1 = new byte[((com.tencent.mm.plugin.mmsight.model.f)localObject2).gxw.length];
        System.arraycopy(((com.tencent.mm.plugin.mmsight.model.f)localObject2).gxw, 0, localObject1, 0, ((com.tencent.mm.plugin.mmsight.model.f)localObject2).gxw.length);
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).gxv = false;
        if (localObject1 == null) {
          break label495;
        }
        j = this.iBB.getPreviewWidth();
        i = this.iBB.getPreviewHeight();
        if (!this.iBB.tCs) {
          break label379;
        }
        k = (int)(this.iBB.getPreviewWidth() / this.gwC);
        if (k >= i) {
          break label506;
        }
        if ((this.iBL) || (this.iCb != null)) {
          break label327;
        }
        this.iCb = new byte[j * k * 3 >> 1];
        localObject2 = this.iCb;
        label161:
        if (this.iBE != 1) {
          break label360;
        }
        SightVideoJNI.cropCameraDataLongEdgeCenterCrop((byte[])localObject1, (byte[])localObject2, i, this.iBP.x, j);
        label185:
        i = k;
        if (this.iBL) {
          i = this.iBP.x;
        }
        this.iBW = true;
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
        localObject2 = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject1, this.iBB.getOrientation());
        ad.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject1 });
        ((Bitmap)localObject1).recycle();
        AppMethodBeat.o(89258);
        return localObject2;
        localObject1 = null;
        break;
        label327:
        localObject2 = j.tEA.g(Integer.valueOf(this.iBP.x * this.iBP.y * 3 >> 1));
        break label161;
        label360:
        SightVideoJNI.cropCameraDataLongEdge((byte[])localObject1, (byte[])localObject2, i, this.iBP.x, j);
        break label185;
        label379:
        k = (int)(i * this.gwC);
        if (k < j)
        {
          if ((!this.iBL) && (this.iCb == null)) {
            this.iCb = new byte[k * i * 3 >> 1];
          }
          for (localObject2 = this.iCb;; localObject2 = j.tEA.g(Integer.valueOf(this.iBP.x * this.iBP.y * 3 >> 1)))
          {
            SightVideoJNI.cropCameraData((byte[])localObject1, (byte[])localObject2, i, j, this.iBP.y);
            j = this.iBP.y;
            this.iBW = true;
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
    ad.i("MicroMsg.MMSightRecordViewImpl", "getDrawSizePoint : %s", new Object[] { this.iBZ.toString() });
    Point localPoint = this.iBZ;
    AppMethodBeat.o(89246);
    return localPoint;
  }
  
  public final int getFlashMode()
  {
    return this.iBN;
  }
  
  public final Point getPictureSize()
  {
    AppMethodBeat.i(89243);
    if ((this.iBB != null) && (this.iBB.cPP()))
    {
      if (!this.iBM)
      {
        localPoint = new Point(this.iBB.getPreviewWidth(), this.iBB.getPreviewHeight());
        AppMethodBeat.o(89243);
        return localPoint;
      }
      aLm();
      Point localPoint = this.iBO;
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
    if ((this.iBB.getOrientation() == 0) || (this.iBB.getOrientation() == 180))
    {
      j = 1;
      if (j == 0) {
        break label78;
      }
      i = this.iBB.getPreviewWidth();
      label43:
      if (j == 0) {
        break label89;
      }
    }
    label78:
    label89:
    for (int j = this.iBB.getPreviewHeight();; j = this.iBB.getPreviewWidth())
    {
      Point localPoint = new Point(i, j);
      AppMethodBeat.o(89245);
      return localPoint;
      j = 0;
      break;
      i = this.iBB.getPreviewHeight();
      break label43;
    }
  }
  
  public final float[] getSupportZoomMultiple()
  {
    int i = 0;
    if ((this.iCa == null) || (this.iCa.mSize == 0)) {
      return new float[0];
    }
    float[] arrayOfFloat = new float[this.iCa.mSize];
    while (i < this.iCa.mSize)
    {
      arrayOfFloat[i] = (this.iCa.Mi[i] * 1.0F / 10.0F);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public final String getVideoFilePath()
  {
    AppMethodBeat.i(89235);
    if ((this.iBA != null) && (this.iBJ))
    {
      str = this.iBA.getFilePath();
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
    if ((this.iBB != null) && (this.iBB.cPP()))
    {
      int k = this.iBB.getEncodeVideoBestSize().x;
      int m = this.iBB.getEncodeVideoBestSize().y;
      int i = m;
      int j = k;
      if (this.iBP != null)
      {
        i = m;
        j = k;
        if (this.iBL)
        {
          j = this.iBP.x;
          i = this.iBP.y;
        }
      }
      j = (int)(j * this.iBX);
      i = (int)(i * this.iBX);
      Point localPoint = new Point(com.tencent.mm.plugin.mmsight.d.GP(j), com.tencent.mm.plugin.mmsight.d.GP(i));
      AppMethodBeat.o(89244);
      return localPoint;
    }
    AppMethodBeat.o(89244);
    return null;
  }
  
  public final void n(MotionEvent paramMotionEvent) {}
  
  public final void release()
  {
    AppMethodBeat.i(89259);
    ad.i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", new Object[] { this.iBB, this.iBA });
    if (this.iBB != null)
    {
      this.iBB.b(this);
      this.iBB.cPL();
    }
    if (this.iBA != null)
    {
      this.iBA.a(null);
      this.iBA.C(null);
      this.iBA = null;
    }
    if (this.iBY != null) {
      this.iBY.release();
    }
    if (this.iCa != null) {
      this.iCa.mSize = 0;
    }
    this.iCa = null;
    this.iBJ = false;
    this.iBL = false;
    this.iBM = false;
    this.iBO = null;
    this.iBP = null;
    this.iBN = -1;
    this.iBQ = true;
    this.iBR = true;
    this.iBS = false;
    j.tEA.aoS();
    AppMethodBeat.o(89259);
  }
  
  public final void setClipPictureSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89251);
    this.iBM = paramBoolean;
    if ((this.iBM) && (this.iBB != null) && (this.iBB.cPP())) {
      aLm();
    }
    AppMethodBeat.o(89251);
  }
  
  public final void setClipVideoSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89249);
    this.iBL = paramBoolean;
    if ((this.iBL) && (this.iBB != null) && (this.iBB.cPP())) {
      aLl();
    }
    AppMethodBeat.o(89249);
  }
  
  public final void setDisplayRatio(float paramFloat)
  {
    AppMethodBeat.i(89228);
    int i = getScreenRotation();
    ad.i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s, screenRotation: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i) });
    this.gwC = paramFloat;
    if ((i == 90) || (i == 270)) {
      this.gwC = (1.0F / this.gwC);
    }
    AppMethodBeat.o(89228);
  }
  
  public final void setDisplayScreenSize(Size paramSize) {}
  
  public final void setEnableDragZoom(boolean paramBoolean)
  {
    this.iBQ = paramBoolean;
  }
  
  public final void setEnableTouchFocus(boolean paramBoolean)
  {
    this.iBR = paramBoolean;
  }
  
  public final void setFlashMode(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(89253);
    this.iBN = paramInt;
    com.tencent.mm.plugin.mmsight.model.f localf = this.iBB;
    if ((this.iBB != null) && (this.iBB.cPP())) {}
    for (;;)
    {
      ad.i("MicroMsg.MMSightRecordViewImpl", "setFlashMode: %s, camera: %s, previewing: %s", new Object[] { Integer.valueOf(paramInt), localf, Boolean.valueOf(bool) });
      if ((this.iBB != null) && (this.iBB.cPP())) {
        aLn();
      }
      AppMethodBeat.o(89253);
      return;
      bool = false;
    }
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.iBK = parama;
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    this.iBV = paramc;
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    this.iBU = paramd;
  }
  
  public final void setPreviewMode(int paramInt)
  {
    AppMethodBeat.i(89231);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setPreviewMode: %s", new Object[] { Integer.valueOf(paramInt) });
    this.iBE = paramInt;
    AppMethodBeat.o(89231);
  }
  
  public final void setPreviewSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89229);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.iBC = paramInt;
    AppMethodBeat.o(89229);
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89230);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setRGBSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.iBD = paramInt;
    AppMethodBeat.o(89230);
  }
  
  public final void setUseBackCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(89242);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.iBG = paramBoolean;
    AppMethodBeat.o(89242);
  }
  
  public final void setVideoFilePath(String paramString)
  {
    AppMethodBeat.i(89234);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setVideoFilePath: %s", new Object[] { paramString });
    this.videoPath = paramString;
    AppMethodBeat.o(89234);
  }
  
  public final void setVideoPara$2e715812(int paramInt)
  {
    AppMethodBeat.i(89233);
    this.iBF = paramInt;
    this.videoBitrate = 4800000;
    this.fps = 30;
    this.audioBitrate = 64000;
    this.audioSampleRate = 44100;
    ad.i("MicroMsg.MMSightRecordViewImpl", "setVideoPara, maxDuration: %s, videoBitrate: %s, fps: %s, audioBitrate: %s, audioSampleRate: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(4800000), Integer.valueOf(30), Integer.valueOf(64000), Integer.valueOf(44100) });
    AppMethodBeat.o(89233);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(89232);
    ad.i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", new Object[] { Float.valueOf(this.gwC), Integer.valueOf(this.iBC) });
    this.iBS = false;
    if ((this.gwC > 0.0F) && (this.iBC > 0))
    {
      Object localObject = new VideoTransPara();
      ((VideoTransPara)localObject).width = this.iBC;
      ((VideoTransPara)localObject).height = ((int)(this.iBC / this.gwC));
      ad.i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", new Object[] { Integer.valueOf(((VideoTransPara)localObject).width), Integer.valueOf(((VideoTransPara)localObject).height) });
      this.iBB = new com.tencent.mm.plugin.mmsight.model.f((VideoTransPara)localObject, -1);
      this.iBB.a(this);
      if (!this.iBB.x(this.context, this.iBG))
      {
        ad.i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
        if (this.iBU != null) {
          this.iBU.aZv();
        }
        AppMethodBeat.o(89232);
        return;
      }
      ad.i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
      localObject = this.iBB.cPK();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        if (this.iBH.isAvailable())
        {
          if (this.iBB.a(this.iBH.getSurfaceTexture(), this.iBC, this.gwC, this.iBL) < 0)
          {
            ad.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (this.iBU != null) {
              this.iBU.aZv();
            }
          }
          if (this.iBN != -1) {
            aLn();
          }
          this.iBB.cPH();
          ad.i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
          aLk();
          aLt();
          if (this.iBY != null) {
            this.iBY.b(this.iBI.getEglContext());
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
        this.iCa = new com.tencent.tinker.a.c.b(j);
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
            this.iCa.append(k, k * i - m);
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
            this.iCa.append(k, m + k * i);
          }
          else
          {
            m += 1;
            break label467;
            label558:
            this.iCa.append(k, k * i);
          }
        }
      }
      this.iBH.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
      {
        public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(89220);
          if (f.this.iBB.a(paramAnonymousSurfaceTexture, f.this.iBC, f.this.gwC, f.this.iBL) < 0)
          {
            ad.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (f.this.iBU != null) {
              f.this.iBU.aZv();
            }
          }
          if (f.this.iBN != -1) {
            f.this.aLn();
          }
          f.this.iBB.cPH();
          f.this.aLk();
          f.this.aLt();
          if (f.this.iBY != null) {
            f.this.iBY.b(f.this.iBI.getEglContext());
          }
          ad.i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
          AppMethodBeat.o(89220);
        }
      });
    }
    AppMethodBeat.o(89232);
  }
  
  public final void switchCamera()
  {
    AppMethodBeat.i(89248);
    if ((this.iBB != null) && (this.iBB.cPP()) && ((this.iBA == null) || (this.iBA.aoq() != d.c.tDO)))
    {
      this.iBB.a(this.context, this.iBH.getSurfaceTexture(), this.iBC, this.gwC, this.iBL);
      if (this.iBY != null) {
        aLt();
      }
    }
    AppMethodBeat.o(89248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f
 * JD-Core Version:    0.7.0.1
 */