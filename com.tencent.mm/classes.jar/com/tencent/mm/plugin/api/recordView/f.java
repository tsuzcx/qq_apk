package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.view.Display;
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
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.model.e.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class f
  extends MMSightRecordView.e
  implements g.a, d.a, com.tencent.mm.plugin.mmsight.model.f
{
  private int audioSampleRate;
  private WindowManager bTq;
  private Context context;
  private int fps;
  private int fzT;
  private com.tencent.mm.plugin.mmsight.model.a.d gNO;
  e gNP;
  int gNQ;
  private int gNR;
  float gNS;
  private int gNT;
  private boolean gNU;
  private ObservableTextureView gNV;
  MMSightCameraGLSurfaceView gNW;
  boolean gNX;
  private MMSightRecordView.a gNY;
  boolean gNZ;
  boolean gOa;
  int gOb;
  Point gOc;
  private Point gOd;
  private boolean gOe;
  private boolean gOf;
  private g gOg;
  MMSightRecordView.d gOh;
  MMSightRecordView.c gOi;
  private boolean gOj;
  private float gOk;
  h gOl;
  private Point gOm;
  private byte[] gOn;
  private int videoBitrate;
  private String videoPath;
  
  public f()
  {
    AppMethodBeat.i(76344);
    this.gNU = true;
    this.gNX = false;
    this.gNZ = false;
    this.gOa = false;
    this.gOb = -1;
    this.gOe = true;
    this.gOf = true;
    this.gOj = false;
    this.gOk = 1.0F;
    this.bTq = null;
    this.gOl = null;
    this.gOm = new Point(0, 0);
    this.gOn = null;
    AppMethodBeat.o(76344);
  }
  
  private void asJ()
  {
    AppMethodBeat.i(76367);
    if ((this.gNP != null) && (this.gNP.bQT())) {
      if (!this.gNP.oHl) {
        break label98;
      }
    }
    label98:
    int i;
    for (this.gOd = new Point(com.tencent.mm.plugin.mmsight.d.eE((int)(this.gNP.getPreviewWidth() / this.gNS), this.gNP.getPreviewHeight()), this.gNP.getPreviewWidth());; this.gOd = new Point(this.gNP.getPreviewHeight(), i))
    {
      ab.i("MicroMsg.MMSightRecordViewImpl", "initVideoSize: %s", new Object[] { this.gOd });
      AppMethodBeat.o(76367);
      return;
      i = com.tencent.mm.plugin.mmsight.d.eE((int)(this.gNP.getPreviewHeight() * this.gNS), this.gNP.getPreviewWidth());
    }
  }
  
  private int asS()
  {
    AppMethodBeat.i(76381);
    if (this.bTq == null) {
      this.bTq = ((WindowManager)ah.getContext().getSystemService("window"));
    }
    if (this.bTq == null)
    {
      AppMethodBeat.o(76381);
      return 0;
    }
    switch (this.bTq.getDefaultDisplay().getRotation())
    {
    default: 
      AppMethodBeat.o(76381);
      return 0;
    case 0: 
      AppMethodBeat.o(76381);
      return 0;
    case 1: 
      AppMethodBeat.o(76381);
      return 90;
    case 2: 
      AppMethodBeat.o(76381);
      return 180;
    }
    AppMethodBeat.o(76381);
    return 270;
  }
  
  public final boolean EC()
  {
    AppMethodBeat.i(76355);
    ab.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", new Object[] { this.gNO });
    asI();
    if (this.gNO == null)
    {
      ab.e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
      AppMethodBeat.o(76355);
      return false;
    }
    int i = asS();
    ab.i("MicroMsg.MMSightRecordViewImpl", "screen rotate: %s", new Object[] { Integer.valueOf(i) });
    if ((i == 90) || (i == 270)) {}
    for (i = this.gNO.b(this.gNP.getOrientation(), true, 360 - i);; i = this.gNO.b(this.gNP.getOrientation(), false, i))
    {
      ab.i("MicroMsg.MMSightRecordViewImpl", "startRecord now, ret: %s", new Object[] { Integer.valueOf(i) });
      if (i < 0) {
        break;
      }
      AppMethodBeat.o(76355);
      return true;
    }
    AppMethodBeat.o(76355);
    return false;
  }
  
  public final boolean N(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76376);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(76376);
      return false;
    }
    Object localObject1;
    if (this.gOl != null)
    {
      i = asS();
      localObject1 = this.gOl;
      if ((((h)localObject1).eAT) || (((h)localObject1).gOy != null)) {
        ((h)localObject1).queue(new h.2((h)localObject1, paramArrayOfByte, i));
      }
    }
    int j;
    int k;
    label213:
    Object localObject2;
    a locala;
    int m;
    int n;
    if ((this.gNS > 0.0F) && (this.gNQ > 0) && (this.gNP != null))
    {
      j = this.gNP.getPreviewWidth();
      i = this.gNP.getPreviewHeight();
      if (this.gNP.oHl)
      {
        k = (int)(this.gNP.getPreviewWidth() / this.gNS);
        if (k >= i) {
          break label1082;
        }
        if ((!this.gNZ) && (this.gOn == null))
        {
          this.gOn = new byte[j * k * 3 >> 1];
          localObject1 = this.gOn;
          bo.yB();
          SightVideoJNI.cropCameraDataLongEdge(paramArrayOfByte, (byte[])localObject1, i, this.gOd.x, j);
          i = k;
          if (this.gNZ) {
            i = this.gOd.x;
          }
          this.gOj = true;
          localObject2 = localObject1;
          if (this.gNW != null)
          {
            localObject2 = this.gNW;
            k = this.gNP.getOrientation();
            if ((i != ((MMSightCameraGLSurfaceView)localObject2).gNA) || (j != ((MMSightCameraGLSurfaceView)localObject2).gNB) || (k != ((MMSightCameraGLSurfaceView)localObject2).fbz))
            {
              ab.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject2 });
              ((MMSightCameraGLSurfaceView)localObject2).gNA = i;
              ((MMSightCameraGLSurfaceView)localObject2).gNB = j;
              ((MMSightCameraGLSurfaceView)localObject2).fbz = k;
            }
            j = asS();
            localObject2 = this.gNW;
            if ((localObject1 == null) || (((MMSightCameraGLSurfaceView)localObject2).gNI == null) || (((MMSightCameraGLSurfaceView)localObject2).gNI.gNz)) {
              break label1032;
            }
            locala = ((MMSightCameraGLSurfaceView)localObject2).gNI;
            k = ((MMSightCameraGLSurfaceView)localObject2).gNA;
            m = ((MMSightCameraGLSurfaceView)localObject2).gNB;
            n = ((MMSightCameraGLSurfaceView)localObject2).fbz;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      try
      {
        if ((locala.gNB != m) || (locala.gNA != k) || (locala.rotate != n) || (locala.gNH != j)) {
          continue;
        }
        if (i != 0) {
          ab.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { localObject1, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Boolean.valueOf(locala.fcx), Boolean.TRUE, locala });
        }
        locala.frameData = ((byte[])localObject1);
        locala.gNA = k;
        locala.gNB = m;
        locala.rotate = n;
        locala.gNH = j;
        if (i != 0)
        {
          locala.eZm = ByteBuffer.allocateDirect(m * k);
          locala.eZn = ByteBuffer.allocateDirect(k * m / 2);
          locala.eZm.order(ByteOrder.nativeOrder());
          locala.eZn.order(ByteOrder.nativeOrder());
          if (locala.gNF != null)
          {
            locala.eYv.put(locala.gNF);
            locala.eYv.position(0);
          }
        }
        if ((locala.eZm != null) && (locala.eZn != null))
        {
          locala.eZm.put((byte[])localObject1, 0, k * m);
          locala.eZm.position(0);
          locala.eZn.put((byte[])localObject1, k * m, k * m / 2);
          locala.eZn.position(0);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label710:
          boolean bool2;
          ab.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[] { localException.getMessage() });
        }
      }
      ((MMSightCameraGLSurfaceView)localObject2).requestRender();
      localObject2 = localObject1;
      if (this.gNY != null)
      {
        localObject1 = getPreviewSize();
        this.gNY.q(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y);
      }
      bool2 = true;
      j = 0;
      boolean bool1 = bool2;
      i = j;
      if (this.gNO != null)
      {
        bool1 = bool2;
        i = j;
        if (this.gNO.getFrameDataCallback() != null)
        {
          if ((!this.gNZ) || (!this.gOj)) {
            break label1054;
          }
          bool1 = this.gNO.getFrameDataCallback().N((byte[])localObject2);
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && ((this.gNO == null) || (this.gNO.Xw() != d.c.oIG))) {
          com.tencent.mm.plugin.mmsight.model.a.j.oJp.O((byte[])localObject2);
        }
        AppMethodBeat.o(76376);
        return bool1;
        localObject1 = com.tencent.mm.plugin.mmsight.model.a.j.oJp.f(Integer.valueOf(this.gOd.x * this.gOd.y * 3 >> 1));
        break;
        k = (int)(i * this.gNS);
        if (k < j)
        {
          if ((!this.gNZ) && (this.gOn == null)) {
            this.gOn = new byte[k * i * 3 >> 1];
          }
          for (localObject1 = this.gOn;; localObject1 = com.tencent.mm.plugin.mmsight.model.a.j.oJp.f(Integer.valueOf(this.gOd.x * this.gOd.y * 3 >> 1)))
          {
            bo.yB();
            SightVideoJNI.cropCameraData(paramArrayOfByte, (byte[])localObject1, i, j, this.gOd.y);
            j = this.gOd.y;
            this.gOj = true;
            break;
          }
          label1032:
          ab.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
          localObject2 = localObject1;
          break label710;
          localObject2 = paramArrayOfByte;
          break label710;
          label1054:
          bool1 = this.gNO.getFrameDataCallback().N(paramArrayOfByte);
          i = j;
          continue;
        }
        localObject1 = paramArrayOfByte;
        break label213;
        label1082:
        localObject1 = paramArrayOfByte;
        break label213;
      }
    }
  }
  
  public final void a(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(76357);
    if ((paramg != null) && (this.gNP != null) && (this.gNP.bQT()))
    {
      if (paramBoolean) {
        this.gNP.bQQ();
      }
      if (paramBoolean)
      {
        al.p(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(138314);
            f.this.b(paramg, paramBoolean);
            AppMethodBeat.o(138314);
          }
        }, 100L);
        AppMethodBeat.o(76357);
        return;
      }
      b(paramg, paramBoolean);
    }
    AppMethodBeat.o(76357);
  }
  
  public final void a(MMSightRecordView.h paramh)
  {
    AppMethodBeat.i(76356);
    if (this.gNO != null)
    {
      ab.i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", new Object[] { paramh });
      this.gNO.a(new f.3(this, paramh));
      this.gNO.u(new f.4(this, paramh));
      this.gNO = null;
    }
    AppMethodBeat.o(76356);
  }
  
  public final void a(ByteBuffer paramByteBuffer, MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(76382);
    if ((paramf == null) && (paramByteBuffer == null))
    {
      if (this.gOl != null)
      {
        this.gOl.release();
        this.gOl = null;
      }
      AppMethodBeat.o(76382);
      return;
    }
    if (this.gOl == null)
    {
      this.gOl = new h();
      asT();
      this.gOl.gOz = new f.7(this, paramf, paramByteBuffer);
      this.gOl.b(this.gNW.eZz);
    }
    AppMethodBeat.o(76382);
  }
  
  public final void asH()
  {
    AppMethodBeat.i(76353);
    asI();
    AppMethodBeat.o(76353);
  }
  
  final void asI()
  {
    AppMethodBeat.i(76354);
    if (this.gNX)
    {
      ab.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
      AppMethodBeat.o(76354);
      return;
    }
    if (this.gNO != null)
    {
      ab.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
      this.gNO.cancel();
      if (this.gNP != null) {
        this.gNP.b(this.gNO.getFrameDataCallback());
      }
      this.gNO = null;
    }
    if ((this.gNQ > 0) && (this.gNT > 0) && (this.videoBitrate > 0) && (this.fps > 0) && (this.fzT > 0) && (this.audioSampleRate > 0) && (this.gNP != null) && (this.gNP.getEncodeVideoBestSize() != null))
    {
      VideoTransPara localVideoTransPara = new VideoTransPara();
      localVideoTransPara.width = this.gNQ;
      localVideoTransPara.height = ((int)(this.gNQ / this.gNS));
      localVideoTransPara.duration = this.gNT;
      localVideoTransPara.videoBitrate = this.videoBitrate;
      localVideoTransPara.fps = this.fps;
      localVideoTransPara.fzT = this.fzT;
      localVideoTransPara.audioSampleRate = this.audioSampleRate;
      localVideoTransPara.fzV = 2;
      localVideoTransPara.fzW = 1;
      localVideoTransPara.fzU = 1;
      com.tencent.mm.plugin.mmsight.model.j.oHG.fcu = localVideoTransPara;
      com.tencent.mm.plugin.mmsight.model.j.oHG.videoBitrate = this.videoBitrate;
      com.tencent.mm.plugin.mmsight.model.j.oHG.eZQ = this.gNQ;
      k.bRq();
      this.gNO = k.q(localVideoTransPara);
      if (this.gNO == null)
      {
        ab.e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
        if (this.gOh != null) {
          this.gOh.aCL();
        }
        AppMethodBeat.o(76354);
        return;
      }
      this.gNO.setFilePath(this.videoPath);
      if ((this.gNZ) && (this.gNP != null) && (this.gNP.bQT())) {
        asJ();
      }
      int k = this.gNP.getEncodeVideoBestSize().x;
      int m = this.gNP.getEncodeVideoBestSize().y;
      int i = m;
      int j = k;
      if (this.gOd != null)
      {
        i = m;
        j = k;
        if (this.gNZ)
        {
          j = this.gOd.x;
          i = this.gOd.y;
        }
      }
      j = (int)(j * this.gOk);
      i = (int)(i * this.gOk);
      j = com.tencent.mm.plugin.mmsight.d.zp(j);
      i = com.tencent.mm.plugin.mmsight.d.zp(i);
      ab.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.gOk) });
      if ((this.gOd != null) && (this.gNZ)) {
        this.gNO.s(this.gOd.y, this.gOd.x, j, i);
      }
      for (;;)
      {
        this.gNO.XC();
        this.gNO.a(this);
        if (this.gNO.km(this.gNP.getOrientation())) {
          break;
        }
        ab.e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
        if (this.gOh != null) {
          this.gOh.aCL();
        }
        AppMethodBeat.o(76354);
        return;
        this.gNO.s(this.gNP.getPreviewWidth(), this.gNP.getPreviewHeight(), j, i);
      }
      al.p(new f.2(this), 100L);
      this.gNX = true;
    }
    AppMethodBeat.o(76354);
  }
  
  final void asK()
  {
    AppMethodBeat.i(76369);
    if ((this.gNP != null) && (this.gNP.bQT()))
    {
      if (this.gNP.oHl)
      {
        int i = (int)(this.gNP.getPreviewWidth() / this.gNS);
        this.gOc = new Point(this.gNP.getPreviewWidth(), i);
        AppMethodBeat.o(76369);
        return;
      }
      this.gOc = new Point((int)(this.gNP.getPreviewHeight() * this.gNS), this.gNP.getPreviewHeight());
    }
    AppMethodBeat.o(76369);
  }
  
  final void asL()
  {
    AppMethodBeat.i(76371);
    ab.i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", new Object[] { Integer.valueOf(this.gOb) });
    switch (this.gOb)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(76371);
      return;
      this.gNP.bQQ();
      AppMethodBeat.o(76371);
      return;
      this.gNP.bQR();
      AppMethodBeat.o(76371);
      return;
      this.gNP.bQS();
    }
  }
  
  public final void asM()
  {
    AppMethodBeat.i(76372);
    ab.i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
    this.gOk = 0.5F;
    AppMethodBeat.o(76372);
  }
  
  public final void asN()
  {
    AppMethodBeat.i(76373);
    ab.i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
    this.gOk = 0.75F;
    AppMethodBeat.o(76373);
  }
  
  public final void asO()
  {
    AppMethodBeat.i(76377);
    ab.i("MicroMsg.MMSightRecordViewImpl", "onError: %s", new Object[] { Integer.valueOf(1) });
    this.gNO.reset();
    AppMethodBeat.o(76377);
  }
  
  public final void asP()
  {
    AppMethodBeat.i(76378);
    if ((this.gNP != null) && (this.gNP.bQT()) && (this.gOf)) {
      this.gNP.bQO();
    }
    AppMethodBeat.o(76378);
  }
  
  public final void asQ()
  {
    AppMethodBeat.i(76379);
    if ((this.gNP != null) && (this.gNP.bQT()) && (this.gOe)) {
      this.gNP.d(true, false, 1);
    }
    AppMethodBeat.o(76379);
  }
  
  public final void asR()
  {
    AppMethodBeat.i(76380);
    if ((this.gNP != null) && (this.gNP.bQT()) && (this.gOe)) {
      this.gNP.d(false, false, 1);
    }
    AppMethodBeat.o(76380);
  }
  
  final void asT()
  {
    AppMethodBeat.i(76383);
    Point localPoint = getPreviewSize();
    this.gOm.y = this.gNR;
    this.gOm.x = (localPoint.x * this.gNR / localPoint.y);
    if ((getCameraRotation() == 90) || (getCameraRotation() == 270))
    {
      int i = this.gOm.y;
      this.gOm.y = this.gOm.x;
      this.gOm.x = i;
    }
    if (this.gOl != null) {
      this.gOl.h(localPoint.x, localPoint.y, this.gNP.getOrientation(), this.gOm.x, this.gOm.y);
    }
    AppMethodBeat.o(76383);
  }
  
  public final void b(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(76345);
    this.context = paramContext;
    this.gNV = new ObservableTextureView(paramContext);
    this.gNW = new MMSightCameraGLSurfaceView(paramContext);
    int i = com.tencent.mm.cb.a.fromDPToPix(paramContext, 1);
    Object localObject = new FrameLayout.LayoutParams(i, i);
    paramViewGroup.addView(this.gNV, (ViewGroup.LayoutParams)localObject);
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    paramViewGroup.addView(this.gNW, (ViewGroup.LayoutParams)localObject);
    this.gOg = new g();
    this.gOg.gOx = this;
    this.gNW.setOnTouchListener(this.gOg);
    com.tencent.mm.plugin.mmsight.model.j.bQW();
    ab.i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", new Object[] { paramContext });
    AppMethodBeat.o(76345);
  }
  
  final void b(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(76358);
    this.gNP.a(new e.b()
    {
      public final void a(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(138315);
        if (paramBoolean) {
          f.this.gNP.bQR();
        }
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousInt1 < 0) || (paramAnonymousInt2 < 0) || (paramAnonymousInt3 < 0))
        {
          ab.e("MicroMsg.MMSightRecordViewImpl", "onPictureYuvTaken, data is null!!");
          paramg.aCO();
          AppMethodBeat.o(138315);
          return;
        }
        for (;;)
        {
          try
          {
            if (f.this.gOa)
            {
              f.this.asK();
              Object localObject;
              if (f.this.gNP.oHl)
              {
                if (f.this.gOc.y < paramAnonymousInt1)
                {
                  localObject = new byte[f.this.gOc.x * f.this.gOc.y * 3 >> 1];
                  SightVideoJNI.cropCameraDataLongEdge(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, f.this.gOc.y, paramAnonymousInt2);
                  paramAnonymousInt1 = f.this.gOc.y;
                  paramAnonymousInt2 = f.this.gOc.x;
                  paramAnonymousArrayOfByte = (byte[])localObject;
                  paramAnonymousArrayOfByte = new YuvImage(paramAnonymousArrayOfByte, 17, paramAnonymousInt1, paramAnonymousInt2, null);
                  localObject = new ByteArrayOutputStream();
                  paramAnonymousArrayOfByte.compressToJpeg(new Rect(0, 0, paramAnonymousInt1, paramAnonymousInt2), 100, (OutputStream)localObject);
                  paramAnonymousArrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
                  localObject = MMBitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
                  if (paramAnonymousInt4 == 90) {
                    break label444;
                  }
                  paramAnonymousInt1 = paramAnonymousInt3;
                  if (paramAnonymousInt4 != 270) {
                    break label458;
                  }
                  break label444;
                  paramAnonymousArrayOfByte = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, false);
                  ab.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject.toString() });
                  ((Bitmap)localObject).recycle();
                  paramg.D(paramAnonymousArrayOfByte);
                  AppMethodBeat.o(138315);
                }
              }
              else if (f.this.gOc.x < paramAnonymousInt2)
              {
                localObject = new byte[f.this.gOc.x * f.this.gOc.y * 3 >> 1];
                SightVideoJNI.cropCameraData(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, paramAnonymousInt2, f.this.gOc.x);
                paramAnonymousInt1 = f.this.gOc.y;
                paramAnonymousInt2 = f.this.gOc.x;
                paramAnonymousArrayOfByte = (byte[])localObject;
                continue;
                paramAnonymousArrayOfByte = com.tencent.mm.sdk.platformtools.d.b((Bitmap)localObject, paramAnonymousInt1);
                continue;
              }
            }
            continue;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ab.printErrStackTrace("MicroMsg.MMSightRecordViewImpl", paramAnonymousArrayOfByte, "saveCaptureYuvDataToBitmap error: %s", new Object[] { paramAnonymousArrayOfByte.getMessage() });
            paramg.aCO();
            AppMethodBeat.o(138315);
            return;
          }
          label444:
          paramAnonymousInt1 = (paramAnonymousInt3 - paramAnonymousInt4 + 360) % 360;
          label458:
          if (paramAnonymousInt1 != 0) {
            if (paramAnonymousInt1 != 360) {}
          }
        }
      }
    }, false, asS());
    AppMethodBeat.o(76358);
  }
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(76364);
    if (this.gNP != null)
    {
      int i = this.gNP.getOrientation();
      AppMethodBeat.o(76364);
      return i;
    }
    AppMethodBeat.o(76364);
    return 0;
  }
  
  public final Bitmap getCurrentFramePicture()
  {
    AppMethodBeat.i(76374);
    Object localObject2;
    Object localObject1;
    int j;
    int i;
    int k;
    if ((this.gNP != null) && (this.gNP.bQT()))
    {
      localObject2 = this.gNP;
      if (((e)localObject2).faE != null)
      {
        ((e)localObject2).faD = true;
        localObject1 = new byte[((e)localObject2).faE.length];
        System.arraycopy(((e)localObject2).faE, 0, localObject1, 0, ((e)localObject2).faE.length);
        ((e)localObject2).faD = false;
        if (localObject1 == null) {
          break label468;
        }
        j = this.gNP.getPreviewWidth();
        i = this.gNP.getPreviewHeight();
        if (!this.gNP.oHl) {
          break label352;
        }
        k = (int)(this.gNP.getPreviewWidth() / this.gNS);
        if (k >= i) {
          break label479;
        }
        if ((this.gNZ) || (this.gOn != null)) {
          break label319;
        }
        this.gOn = new byte[j * k * 3 >> 1];
        localObject2 = this.gOn;
        label161:
        SightVideoJNI.cropCameraDataLongEdge((byte[])localObject1, (byte[])localObject2, i, this.gOd.x, j);
        i = k;
        if (this.gNZ) {
          i = this.gOd.x;
        }
        this.gOj = true;
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
        localObject2 = com.tencent.mm.sdk.platformtools.d.b((Bitmap)localObject1, this.gNP.getOrientation());
        ab.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject1 });
        ((Bitmap)localObject1).recycle();
        AppMethodBeat.o(76374);
        return localObject2;
        localObject1 = null;
        break;
        label319:
        localObject2 = com.tencent.mm.plugin.mmsight.model.a.j.oJp.f(Integer.valueOf(this.gOd.x * this.gOd.y * 3 >> 1));
        break label161;
        label352:
        k = (int)(i * this.gNS);
        if (k < j)
        {
          if ((!this.gNZ) && (this.gOn == null)) {
            this.gOn = new byte[k * i * 3 >> 1];
          }
          for (localObject2 = this.gOn;; localObject2 = com.tencent.mm.plugin.mmsight.model.a.j.oJp.f(Integer.valueOf(this.gOd.x * this.gOd.y * 3 >> 1)))
          {
            SightVideoJNI.cropCameraData((byte[])localObject1, (byte[])localObject2, i, j, this.gOd.y);
            j = this.gOd.y;
            this.gOj = true;
            localObject1 = localObject2;
            break;
          }
          label468:
          AppMethodBeat.o(76374);
          return null;
        }
      }
      label479:
      localObject2 = localObject1;
    }
  }
  
  public final Point getDrawSizePoint()
  {
    AppMethodBeat.i(76363);
    ab.i("MicroMsg.MMSightRecordViewImpl", "getDrawSizePoint : %s", new Object[] { this.gOm.toString() });
    Point localPoint = this.gOm;
    AppMethodBeat.o(76363);
    return localPoint;
  }
  
  public final int getFlashMode()
  {
    return this.gOb;
  }
  
  public final Point getPictureSize()
  {
    AppMethodBeat.i(76360);
    if ((this.gNP != null) && (this.gNP.bQT()))
    {
      if (!this.gOa)
      {
        localPoint = new Point(this.gNP.getPreviewWidth(), this.gNP.getPreviewHeight());
        AppMethodBeat.o(76360);
        return localPoint;
      }
      asK();
      Point localPoint = this.gOc;
      AppMethodBeat.o(76360);
      return localPoint;
    }
    AppMethodBeat.o(76360);
    return null;
  }
  
  public final Point getPreviewSize()
  {
    AppMethodBeat.i(76362);
    int i;
    if ((this.gNP.getOrientation() == 0) || (this.gNP.getOrientation() == 180))
    {
      j = 1;
      if (j == 0) {
        break label78;
      }
      i = this.gNP.getPreviewWidth();
      label43:
      if (j == 0) {
        break label89;
      }
    }
    label78:
    label89:
    for (int j = this.gNP.getPreviewHeight();; j = this.gNP.getPreviewWidth())
    {
      Point localPoint = new Point(i, j);
      AppMethodBeat.o(76362);
      return localPoint;
      j = 0;
      break;
      i = this.gNP.getPreviewHeight();
      break label43;
    }
  }
  
  public final String getVideoFilePath()
  {
    AppMethodBeat.i(76352);
    if ((this.gNO != null) && (this.gNX))
    {
      str = this.gNO.getFilePath();
      AppMethodBeat.o(76352);
      return str;
    }
    String str = this.videoPath;
    AppMethodBeat.o(76352);
    return str;
  }
  
  public final Point getVideoSize()
  {
    AppMethodBeat.i(76361);
    if ((this.gNP != null) && (this.gNP.bQT()))
    {
      int k = this.gNP.getEncodeVideoBestSize().x;
      int m = this.gNP.getEncodeVideoBestSize().y;
      int i = m;
      int j = k;
      if (this.gOd != null)
      {
        i = m;
        j = k;
        if (this.gNZ)
        {
          j = this.gOd.x;
          i = this.gOd.y;
        }
      }
      j = (int)(j * this.gOk);
      i = (int)(i * this.gOk);
      Point localPoint = new Point(com.tencent.mm.plugin.mmsight.d.zp(j), com.tencent.mm.plugin.mmsight.d.zp(i));
      AppMethodBeat.o(76361);
      return localPoint;
    }
    AppMethodBeat.o(76361);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(76375);
    ab.i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", new Object[] { this.gNP, this.gNO });
    if (this.gNP != null) {
      this.gNP.bQP();
    }
    if (this.gNO != null)
    {
      this.gNO.a(null);
      this.gNO.u(null);
      this.gNO = null;
    }
    if (this.gOl != null) {
      this.gOl.release();
    }
    this.gNX = false;
    this.gNZ = false;
    this.gOa = false;
    this.gOc = null;
    this.gOd = null;
    this.gOb = -1;
    this.gOe = true;
    this.gOf = true;
    com.tencent.mm.plugin.mmsight.model.a.j.oJp.XJ();
    AppMethodBeat.o(76375);
  }
  
  public final void setClipPictureSize(boolean paramBoolean)
  {
    AppMethodBeat.i(76368);
    this.gOa = paramBoolean;
    if ((this.gOa) && (this.gNP != null) && (this.gNP.bQT())) {
      asK();
    }
    AppMethodBeat.o(76368);
  }
  
  public final void setClipVideoSize(boolean paramBoolean)
  {
    AppMethodBeat.i(76366);
    this.gNZ = paramBoolean;
    if ((this.gNZ) && (this.gNP != null) && (this.gNP.bQT())) {
      asJ();
    }
    AppMethodBeat.o(76366);
  }
  
  public final void setDisplayRatio(float paramFloat)
  {
    AppMethodBeat.i(76346);
    int i = asS();
    ab.i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s, screenRotation: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i) });
    this.gNS = paramFloat;
    if ((i == 90) || (i == 270)) {
      this.gNS = (1.0F / this.gNS);
    }
    AppMethodBeat.o(76346);
  }
  
  public final void setEnableDragZoom(boolean paramBoolean)
  {
    this.gOe = paramBoolean;
  }
  
  public final void setEnableTouchFocus(boolean paramBoolean)
  {
    this.gOf = paramBoolean;
  }
  
  public final void setFlashMode(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(76370);
    this.gOb = paramInt;
    e locale = this.gNP;
    if ((this.gNP != null) && (this.gNP.bQT())) {}
    for (;;)
    {
      ab.i("MicroMsg.MMSightRecordViewImpl", "setFlashMode: %s, camera: %s, previewing: %s", new Object[] { Integer.valueOf(paramInt), locale, Boolean.valueOf(bool) });
      if ((this.gNP != null) && (this.gNP.bQT())) {
        asL();
      }
      AppMethodBeat.o(76370);
      return;
      bool = false;
    }
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.gNY = parama;
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    this.gOi = paramc;
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    this.gOh = paramd;
  }
  
  public final void setPreviewSizeLimit(int paramInt)
  {
    AppMethodBeat.i(76347);
    ab.i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gNQ = paramInt;
    AppMethodBeat.o(76347);
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(76348);
    ab.i("MicroMsg.MMSightRecordViewImpl", "setRGBSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gNR = paramInt;
    AppMethodBeat.o(76348);
  }
  
  public final void setUseBackCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(76359);
    ab.i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gNU = paramBoolean;
    AppMethodBeat.o(76359);
  }
  
  public final void setVideoFilePath(String paramString)
  {
    AppMethodBeat.i(76351);
    ab.i("MicroMsg.MMSightRecordViewImpl", "setVideoFilePath: %s", new Object[] { paramString });
    this.videoPath = paramString;
    AppMethodBeat.o(76351);
  }
  
  public final void setVideoPara$2e715812(int paramInt)
  {
    AppMethodBeat.i(76350);
    this.gNT = paramInt;
    this.videoBitrate = 4800000;
    this.fps = 30;
    this.fzT = 64000;
    this.audioSampleRate = 44100;
    ab.i("MicroMsg.MMSightRecordViewImpl", "setVideoPara, maxDuration: %s, videoBitrate: %s, fps: %s, audioBitrate: %s, audioSampleRate: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(4800000), Integer.valueOf(30), Integer.valueOf(64000), Integer.valueOf(44100) });
    AppMethodBeat.o(76350);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(76349);
    ab.i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", new Object[] { Float.valueOf(this.gNS), Integer.valueOf(this.gNQ) });
    if ((this.gNS > 0.0F) && (this.gNQ > 0))
    {
      VideoTransPara localVideoTransPara = new VideoTransPara();
      localVideoTransPara.width = this.gNQ;
      localVideoTransPara.height = ((int)(this.gNQ / this.gNS));
      ab.i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", new Object[] { Integer.valueOf(localVideoTransPara.width), Integer.valueOf(localVideoTransPara.height) });
      this.gNP = new e(localVideoTransPara, -1);
      this.gNP.a(this);
      if (!this.gNP.v(this.context, this.gNU))
      {
        ab.i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
        if (this.gOh != null) {
          this.gOh.aCL();
        }
        AppMethodBeat.o(76349);
        return;
      }
      ab.i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
      if (this.gNV.isAvailable())
      {
        if (this.gNP.a(this.gNV.getSurfaceTexture(), this.gNQ, this.gNS, this.gNZ) < 0)
        {
          ab.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
          if (this.gOh != null) {
            this.gOh.aCL();
          }
        }
        if (this.gOb != -1) {
          asL();
        }
        this.gNP.bQM();
        ab.i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
        asI();
        asT();
        if (this.gOl != null) {
          this.gOl.b(this.gNW.eZz);
        }
        AppMethodBeat.o(76349);
        return;
      }
      this.gNV.setTextureChangeCallback(new f.1(this));
    }
    AppMethodBeat.o(76349);
  }
  
  public final void switchCamera()
  {
    AppMethodBeat.i(76365);
    if ((this.gNP != null) && (this.gNP.bQT()) && ((this.gNO == null) || (this.gNO.Xw() != d.c.oIG)))
    {
      this.gNP.a(this.context, this.gNV.getSurfaceTexture(), this.gNQ, this.gNS, this.gNZ);
      if (this.gOl != null) {
        asT();
      }
    }
    AppMethodBeat.o(76365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f
 * JD-Core Version:    0.7.0.1
 */