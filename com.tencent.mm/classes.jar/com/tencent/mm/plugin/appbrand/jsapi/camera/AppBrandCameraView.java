package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.util.Size;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.media.t;
import com.tencent.mm.plugin.appbrand.jsruntime.s;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.qbar.QbarNative.QBarPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class AppBrandCameraView
  extends RelativeLayout
  implements f, f.b, f.c, f.d
{
  private String ctC;
  private ImageView dsD;
  private String hvd;
  private String kHA;
  private String kHB;
  int kHC;
  private boolean kHD;
  private long kHE;
  private long kHF;
  private d kHG;
  private boolean kHH;
  private float kHI;
  private AtomicBoolean kHJ;
  private List<Runnable> kHK;
  private com.tencent.mm.plugin.appbrand.jsapi.c kHe;
  private String kHf;
  private int kHg;
  private a kHh;
  private int kHi;
  private String kHj;
  private String kHk;
  private String kHl;
  private boolean kHm;
  private boolean kHn;
  private boolean kHo;
  private boolean kHp;
  private int kHq;
  private int kHr;
  private int kHs;
  private int kHt;
  private Rect kHu;
  private int kHv;
  private Size kHw;
  private c kHx;
  private b kHy;
  private MMSightRecordView kHz;
  private String mAppId;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(46215);
    com.tencent.mm.plugin.appbrand.app.g.aYG();
    AppMethodBeat.o(46215);
  }
  
  public AppBrandCameraView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(46180);
    this.kHf = "scanCode";
    this.ctC = "back";
    this.kHj = "auto";
    this.kHk = "high";
    this.kHm = false;
    this.kHn = false;
    this.kHp = false;
    this.kHq = 1080;
    this.kHr = 1920;
    this.kHs = 1080;
    this.kHt = 1920;
    this.kHC = -1;
    this.kHD = false;
    this.kHE = -1L;
    this.kHF = -1L;
    this.kHJ = new AtomicBoolean(false);
    init(paramContext);
    AppMethodBeat.o(46180);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(46181);
    this.kHf = "scanCode";
    this.ctC = "back";
    this.kHj = "auto";
    this.kHk = "high";
    this.kHm = false;
    this.kHn = false;
    this.kHp = false;
    this.kHq = 1080;
    this.kHr = 1920;
    this.kHs = 1080;
    this.kHt = 1920;
    this.kHC = -1;
    this.kHD = false;
    this.kHE = -1L;
    this.kHF = -1L;
    this.kHJ = new AtomicBoolean(false);
    init(paramContext);
    AppMethodBeat.o(46181);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(46182);
    this.kHf = "scanCode";
    this.ctC = "back";
    this.kHj = "auto";
    this.kHk = "high";
    this.kHm = false;
    this.kHn = false;
    this.kHp = false;
    this.kHq = 1080;
    this.kHr = 1920;
    this.kHs = 1080;
    this.kHt = 1920;
    this.kHC = -1;
    this.kHD = false;
    this.kHE = -1L;
    this.kHF = -1L;
    this.kHJ = new AtomicBoolean(false);
    init(paramContext);
    AppMethodBeat.o(46182);
  }
  
  public static void bjE()
  {
    AppMethodBeat.i(46179);
    l.kIe = new AppBrandCameraView.1();
    AppMethodBeat.o(46179);
  }
  
  private void bjG()
  {
    int j = 0;
    AppMethodBeat.i(46197);
    ad.i("MicroMsg.AppBrandCameraView", "initCamera.");
    if (!a.a.bjD().bjC())
    {
      Toast.makeText(this.mContext, 2131761241, 1).show();
      ad.w("MicroMsg.AppBrandCameraView", "no permission");
      AppMethodBeat.o(46197);
      return;
    }
    if (this.kHz != null)
    {
      ad.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
      AppMethodBeat.o(46197);
      return;
    }
    Object localObject = a.a.bjD().bjB();
    int i;
    if (localObject.length > 0)
    {
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        int m = localObject[i];
        if (m != this.kHi)
        {
          a.a.bjD().I(m, false);
          ad.i("MicroMsg.AppBrandCameraView", "release camera before init new camera, id: %d", new Object[] { Integer.valueOf(m) });
        }
        i += 1;
      }
    }
    if (this.dsD == null)
    {
      this.dsD = new ImageView(this.mContext);
      this.dsD.setScaleType(ImageView.ScaleType.FIT_XY);
      addView(this.dsD, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      this.kHz = e(this.mContext, this.kHq, this.kHr);
      if (this.kHz == null) {
        this.kHz = new MMSightRecordView(this.mContext);
      }
      this.kHH = false;
      addView(this.kHz);
      bjQ();
      this.kHz.setRGBSizeLimit(this.kHg);
      this.kHz.vMS.aVs();
      this.kHz.setDisplayRatio(this.kHq * 1.0F / this.kHr);
      localObject = this.kHz;
      i = j;
      if (this.kHm) {
        i = 1;
      }
      ((MMSightRecordView)localObject).setPreviewMode(i);
      this.kHz.setVideoPara$2e715812(600000);
      this.kHz.setVideoFilePath(this.kHA);
      this.kHz.setClipPictureSize(true);
      this.kHz.setClipVideoSize(true);
      this.kHz.setDisplayScreenSize(this.kHw);
      this.kHz.setUseBackCamera("back".equals(this.ctC));
      this.kHz.setFrameDataCallback(new MMSightRecordView.a()
      {
        public final void s(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(46147);
          if (AppBrandCameraView.a(AppBrandCameraView.this) != null) {
            AppBrandCameraView.a(AppBrandCameraView.this).s(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(46147);
        }
      });
      this.kHz.setInitErrorCallback(new AppBrandCameraView.3(this));
      this.kHz.setInitDoneCallback(new MMSightRecordView.c()
      {
        public final void bjS()
        {
          AppMethodBeat.i(46149);
          AppBrandCameraView.d(AppBrandCameraView.this);
          ad.i("MicroMsg.AppBrandCameraView", "InitDoneCallback");
          h localh = new h();
          HashMap localHashMap = new HashMap();
          localHashMap.put("cameraId", Integer.valueOf(AppBrandCameraView.b(AppBrandCameraView.this)));
          Object localObject = null;
          if (AppBrandCameraView.e(AppBrandCameraView.this) != null) {
            localObject = AppBrandCameraView.e(AppBrandCameraView.this).getSupportZoomMultiple();
          }
          if ((localObject != null) && (localObject.length > 0)) {
            AppBrandCameraView.a(AppBrandCameraView.this, localObject[(localObject.length - 1)]);
          }
          localHashMap.put("maxZoom", Float.valueOf(AppBrandCameraView.f(AppBrandCameraView.this)));
          localh.Pi(new JSONObject(localHashMap).toString());
          AppBrandCameraView.c(AppBrandCameraView.this).b(localh);
          if (AppBrandCameraView.g(AppBrandCameraView.this) != null)
          {
            localObject = AppBrandCameraView.g(AppBrandCameraView.this).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((Runnable)((Iterator)localObject).next()).run();
            }
            AppBrandCameraView.g(AppBrandCameraView.this).clear();
          }
          AppMethodBeat.o(46149);
        }
      });
      this.kHz.vMS.startPreview();
      this.kHz.vMS.aVm();
      this.kHC = 1;
      AppMethodBeat.o(46197);
      return;
      this.dsD.setImageBitmap(null);
    }
  }
  
  private void bjJ()
  {
    AppMethodBeat.i(46201);
    this.hvd = (com.tencent.mm.loader.j.b.asg() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    AppMethodBeat.o(46201);
  }
  
  private void bjK()
  {
    AppMethodBeat.i(46202);
    String str = "MicroMsg_" + System.currentTimeMillis();
    if (!com.tencent.mm.vfs.i.fv(com.tencent.mm.loader.j.b.arS())) {
      com.tencent.mm.vfs.i.aYg(com.tencent.mm.loader.j.b.arS());
    }
    this.kHA = (com.tencent.mm.loader.j.b.arS() + str + ".mp4");
    this.kHB = (com.tencent.mm.loader.j.b.arS() + str + ".jpeg");
    if (this.kHz != null) {
      this.kHz.setVideoFilePath(this.kHA);
    }
    AppMethodBeat.o(46202);
  }
  
  private void bjL()
  {
    AppMethodBeat.i(46203);
    if ((this.kHz == null) || (this.kHj == null))
    {
      AppMethodBeat.o(46203);
      return;
    }
    if (this.kHj.equals("auto"))
    {
      this.kHz.setFlashMode(3);
      AppMethodBeat.o(46203);
      return;
    }
    if (this.kHj.equals("torch"))
    {
      this.kHz.setFlashMode(1);
      AppMethodBeat.o(46203);
      return;
    }
    if (this.kHj.equals("on"))
    {
      if ((this.kHC == 2) || (this.kHC == 4) || (!this.kHj.equals("on")))
      {
        this.kHz.setFlashMode(1);
        AppMethodBeat.o(46203);
      }
    }
    else if (this.kHj.equals("torch"))
    {
      this.kHz.setFlashMode(1);
      AppMethodBeat.o(46203);
      return;
    }
    this.kHz.setFlashMode(2);
    AppMethodBeat.o(46203);
  }
  
  private void bjM()
  {
    AppMethodBeat.i(46204);
    ad.i("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", new Object[] { this.kHf });
    bjN();
    this.kHh = Pz(this.kHf);
    this.kHh.init();
    AppMethodBeat.o(46204);
  }
  
  private void bjN()
  {
    AppMethodBeat.i(46206);
    if (this.kHh != null)
    {
      this.kHh.release();
      this.kHh = null;
    }
    AppMethodBeat.o(46206);
  }
  
  private void bjQ()
  {
    int j = 720;
    AppMethodBeat.i(46211);
    int i = j;
    String str;
    if (!bt.isNullOrNil(this.kHl))
    {
      str = this.kHl;
      i = -1;
      switch (str.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          i = j;
        }
        break;
      }
    }
    for (;;)
    {
      j = i;
      if (this.kHg > i)
      {
        ad.i("MicroMsg.AppBrandCameraView", "framesize is : %d, large than preview size: %d", new Object[] { Integer.valueOf(this.kHg), Integer.valueOf(i) });
        j = this.kHg;
      }
      this.kHz.setPreviewSizeLimit(j);
      AppMethodBeat.o(46211);
      return;
      if (!str.equals("high")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("low")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("medium")) {
        break;
      }
      i = 2;
      break;
      i = 1080;
      continue;
      i = 480;
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(46183);
    this.mContext = paramContext;
    this.kHJ.set(false);
    LayoutInflater.from(paramContext).inflate(2131492976, this);
    AppMethodBeat.o(46183);
  }
  
  protected a Pz(String paramString)
  {
    AppMethodBeat.i(46205);
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals("scanCode"))) {}
    for (paramString = new c();; paramString = new b((byte)0))
    {
      AppMethodBeat.o(46205);
      return paramString;
    }
  }
  
  public final void ap(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46186);
    if (bt.lQ(this.ctC, paramString))
    {
      AppMethodBeat.o(46186);
      return;
    }
    if (bt.lQ(this.kHf, "scanCode"))
    {
      AppMethodBeat.o(46186);
      return;
    }
    this.ctC = paramString;
    if ((!paramBoolean) && (this.kHz != null)) {
      this.kHz.vMS.switchCamera();
    }
    AppMethodBeat.o(46186);
  }
  
  public final float az(float paramFloat)
  {
    AppMethodBeat.i(46196);
    if (this.kHz != null)
    {
      if (paramFloat < 1.0F)
      {
        AppMethodBeat.o(46196);
        return paramFloat;
      }
      float f = paramFloat;
      if (paramFloat > this.kHI) {}
      for (f = this.kHI; (!this.kHz.vMS.at(f)) && (f > 0.0F); f -= 0.1F) {}
      AppMethodBeat.o(46196);
      return f;
    }
    AppMethodBeat.o(46196);
    return 0.0F;
  }
  
  public final void bjF()
  {
    AppMethodBeat.i(46195);
    if (this.kHh != null) {
      this.kHh.bjF();
    }
    AppMethodBeat.o(46195);
  }
  
  public final void bjH()
  {
    AppMethodBeat.i(46198);
    if (this.kHz == null)
    {
      ad.i("MicroMsg.AppBrandCameraView", "recordView is null");
      AppMethodBeat.o(46198);
      return;
    }
    bjM();
    bjL();
    AppMethodBeat.o(46198);
  }
  
  public final void bjI()
  {
    AppMethodBeat.i(46200);
    if (this.kHx == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    if (this.kHG == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    this.kHG.a(this.kHz);
    this.kHG = null;
    AppMethodBeat.o(46200);
  }
  
  public final void bjO()
  {
    AppMethodBeat.i(46209);
    if (this.kHh != null) {
      this.kHh.bjO();
    }
    AppMethodBeat.o(46209);
  }
  
  public final void bjP()
  {
    AppMethodBeat.i(46210);
    if (this.kHh != null) {
      this.kHh.bjP();
    }
    AppMethodBeat.o(46210);
  }
  
  public final boolean dO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46190);
    if ((this.kHq == paramInt1) && (this.kHr == paramInt2))
    {
      AppMethodBeat.o(46190);
      return false;
    }
    ad.i("MicroMsg.AppBrandCameraView", "setViewSize");
    this.kHq = paramInt1;
    this.kHr = paramInt2;
    AppMethodBeat.o(46190);
    return true;
  }
  
  protected MMSightRecordView e(Context paramContext, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public int getCameraId()
  {
    return this.kHi;
  }
  
  protected MMSightRecordView getRecordView()
  {
    return this.kHz;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(46184);
    ad.i("MicroMsg.AppBrandCameraView", "initView");
    if (!a.a.bjD().bjC())
    {
      AppMethodBeat.o(46184);
      return;
    }
    bjK();
    bjJ();
    bjG();
    bjH();
    this.kHJ.compareAndSet(false, true);
    AppMethodBeat.o(46184);
  }
  
  public final void o(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(46199);
    ad.i("MicroMsg.AppBrandCameraView", "listenFrameChange");
    if (this.kHx == null)
    {
      AppMethodBeat.o(46199);
      return;
    }
    if (this.kHz == null)
    {
      ad.w("MicroMsg.AppBrandCameraView", "listenFrameChange recordView null");
      this.kHx.h("camera illegal state", -1, -1, -1);
      AppMethodBeat.o(46199);
      return;
    }
    if (this.kHG == null) {
      this.kHG = new d(paramc);
    }
    paramc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46150);
        int j = AppBrandCameraView.e(AppBrandCameraView.this).getDrawSizePoint().x;
        int k = AppBrandCameraView.e(AppBrandCameraView.this).getDrawSizePoint().y;
        d locald = AppBrandCameraView.h(AppBrandCameraView.this);
        MMSightRecordView localMMSightRecordView = AppBrandCameraView.e(AppBrandCameraView.this);
        int i;
        if (localMMSightRecordView == null)
        {
          ad.w("MicroMsg.FrameDataCallbackHelper", "listenFrameChange recordView null");
          i = -1;
        }
        while (i < 0)
        {
          AppBrandCameraView.i(AppBrandCameraView.this).h(String.format(Locale.US, "illegal state:%d", new Object[] { Integer.valueOf(i) }), -1, -1, -1);
          AppMethodBeat.o(46150);
          return;
          if (locald.kHX == null)
          {
            i = -2;
          }
          else
          {
            if (locald.kHZ != -2147483648)
            {
              ad.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange destroy last one bufferId:%d", new Object[] { Integer.valueOf(locald.kHZ) });
              locald.kHX.tU(locald.kHZ);
            }
            locald.kHZ = locald.kHX.tW(j * k * 4);
            ad.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange bufferId:%d height:%d width:%d", new Object[] { Integer.valueOf(locald.kHZ), Integer.valueOf(k), Integer.valueOf(j) });
            locald.kHY = true;
            localMMSightRecordView.a(locald.kHX.tV(locald.kHZ), locald);
            i = locald.kHZ;
          }
        }
        AppBrandCameraView.i(AppBrandCameraView.this).h(null, i, j, k);
        AppMethodBeat.o(46150);
      }
    };
    if (!this.kHH)
    {
      if (this.kHK == null) {
        this.kHK = new ArrayList();
      }
      this.kHK.add(paramc);
      AppMethodBeat.o(46199);
      return;
    }
    paramc.run();
    AppMethodBeat.o(46199);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(46191);
    ad.i("MicroMsg.AppBrandCameraView", "onUIPause");
    Object localObject;
    if (this.kHC == 2)
    {
      ad.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(this.kHi));
      ((Map)localObject).put("errMsg", "stop on record");
      localObject = new JSONObject((Map)localObject).toString();
      new m().h(this.kHe).Pi((String)localObject).bir();
    }
    if (this.kHz != null)
    {
      localObject = this.kHz.getCurrentFramePicture();
      if (localObject != null) {
        this.dsD.setImageBitmap((Bitmap)localObject);
      }
    }
    MMSightRecordView localMMSightRecordView;
    if (this.kHG != null)
    {
      localObject = this.kHG;
      localMMSightRecordView = this.kHz;
      ad.i("MicroMsg.FrameDataCallbackHelper", "onUIPause mNeedCallback:%b", new Object[] { Boolean.valueOf(((d)localObject).kHY) });
      if (localMMSightRecordView != null) {
        break label250;
      }
      ad.w("MicroMsg.FrameDataCallbackHelper", "onUIPause recordView null");
    }
    for (;;)
    {
      release();
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(getCameraId()));
      localObject = new JSONObject((Map)localObject).toString();
      new k().h(this.kHe).Pi((String)localObject).bir();
      AppMethodBeat.o(46191);
      return;
      label250:
      localMMSightRecordView.a(null, null);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(46193);
    if (this.kHG != null) {
      this.kHG.a(this.kHz);
    }
    release();
    this.kHJ.compareAndSet(true, false);
    AppMethodBeat.o(46193);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(46192);
    ad.i("MicroMsg.AppBrandCameraView", "onUIResume");
    for (;;)
    {
      MMSightRecordView localMMSightRecordView;
      try
      {
        if (!this.kHJ.get())
        {
          ad.w("MicroMsg.AppBrandCameraView", "no execute initView");
          return;
        }
        bjG();
        bjM();
        bjL();
        d locald;
        if (this.kHG != null)
        {
          locald = this.kHG;
          localMMSightRecordView = this.kHz;
          ad.i("MicroMsg.FrameDataCallbackHelper", "onUIResume mNeedCallback:%b", new Object[] { Boolean.valueOf(locald.kHY) });
          if (locald.kHY)
          {
            if (localMMSightRecordView != null) {
              continue;
            }
            ad.w("MicroMsg.FrameDataCallbackHelper", "onUIResume recordView null");
          }
        }
        return;
        if (locald.kHZ == -2147483648)
        {
          ad.w("MicroMsg.FrameDataCallbackHelper", "onUIResume invalid mCurrentSharedBufferId");
          continue;
        }
        if (localf.kHX != null) {
          break label180;
        }
      }
      finally
      {
        AppMethodBeat.o(46192);
      }
      ad.w("MicroMsg.FrameDataCallbackHelper", "onUIResume mSharedBufferAddon null");
      continue;
      label180:
      localMMSightRecordView.a(localf.kHX.tV(localf.kHZ), localf);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(46194);
    ad.i("MicroMsg.AppBrandCameraView", "release");
    try
    {
      if (this.kHz != null)
      {
        this.kHz.vMS.release();
        removeView(this.kHz);
        this.kHC = -1;
        this.kHz.setFrameDataCallback(null);
        this.kHz.setInitErrorCallback(null);
        this.kHz.setInitDoneCallback(null);
        this.kHz = null;
      }
      if (this.dsD != null) {
        this.dsD.setImageBitmap(null);
      }
      if (this.kHK != null) {
        this.kHK.clear();
      }
      this.kHI = 0.0F;
      bjN();
      AppMethodBeat.o(46194);
      return;
    }
    finally
    {
      AppMethodBeat.o(46194);
    }
  }
  
  public void setAppId(String paramString)
  {
    this.mAppId = paramString;
  }
  
  public void setCameraId(int paramInt)
  {
    this.kHi = paramInt;
  }
  
  public void setCompressRecord(boolean paramBoolean)
  {
    this.kHn = paramBoolean;
  }
  
  public void setDisplayScreenSize(Size paramSize)
  {
    AppMethodBeat.i(188300);
    if ((paramSize == null) || (paramSize.getHeight() <= 0) || (paramSize.getWidth() <= 0))
    {
      AppMethodBeat.o(188300);
      return;
    }
    this.kHw = paramSize;
    AppMethodBeat.o(188300);
  }
  
  public void setFlash(String paramString)
  {
    AppMethodBeat.i(46187);
    if (bt.lQ(this.kHj, paramString))
    {
      AppMethodBeat.o(46187);
      return;
    }
    this.kHj = paramString;
    AppMethodBeat.o(46187);
  }
  
  public void setFrameLimitSize(int paramInt)
  {
    AppMethodBeat.i(46185);
    ad.i("MicroMsg.AppBrandCameraView", "setFrameLimitSize:%d", new Object[] { Integer.valueOf(paramInt) });
    this.kHg = paramInt;
    AppMethodBeat.o(46185);
  }
  
  public void setMode(String paramString)
  {
    this.kHf = paramString;
  }
  
  public void setNeedOutput(boolean paramBoolean)
  {
    this.kHo = paramBoolean;
  }
  
  public void setOperateCallBack(c paramc)
  {
    this.kHx = paramc;
  }
  
  public void setOutPutCallBack(b paramb)
  {
    this.kHy = paramb;
  }
  
  public void setPage(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    this.kHe = parame;
  }
  
  public void setPreviewCenterCrop(boolean paramBoolean)
  {
    this.kHm = paramBoolean;
  }
  
  public void setQuality(String paramString)
  {
    AppMethodBeat.i(46188);
    if (bt.lQ(this.kHk, paramString))
    {
      AppMethodBeat.o(46188);
      return;
    }
    this.kHk = paramString;
    AppMethodBeat.o(46188);
  }
  
  public void setResolution(String paramString)
  {
    AppMethodBeat.i(46189);
    if (bt.lQ(this.kHl, paramString))
    {
      AppMethodBeat.o(46189);
      return;
    }
    ad.i("MicroMsg.AppBrandCameraView", "setPreviewResolution: %s", new Object[] { paramString });
    this.kHl = paramString;
    AppMethodBeat.o(46189);
  }
  
  public void setScanFreq(int paramInt)
  {
    AppMethodBeat.i(46207);
    ad.i("MicroMsg.AppBrandCameraView", "scanFreq:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ad.e("MicroMsg.AppBrandCameraView", "scanFreq is err");
      AppMethodBeat.o(46207);
      return;
    }
    this.kHv = paramInt;
    AppMethodBeat.o(46207);
  }
  
  public final void x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(46208);
    ad.i("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((paramInt3 <= 0) || (paramInt4 <= 0))
    {
      AppMethodBeat.o(46208);
      return;
    }
    this.kHu = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    AppMethodBeat.o(46208);
  }
  
  public static abstract interface a
  {
    public abstract void bjF();
    
    public abstract void bjO();
    
    public abstract void bjP();
    
    public abstract void init();
    
    public abstract void release();
    
    public abstract void s(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  final class b
    implements AppBrandCameraView.a
  {
    private b() {}
    
    private void ag(int paramInt, String paramString)
    {
      AppMethodBeat.i(46161);
      if (AppBrandCameraView.i(AppBrandCameraView.this) != null) {
        AppBrandCameraView.i(AppBrandCameraView.this).ag(paramInt, paramString);
      }
      AppMethodBeat.o(46161);
    }
    
    private static void c(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(46166);
      if (!com.tencent.mm.vfs.i.fv(paramString))
      {
        ad.i("MicroMsg.AppBrandCameraView", "getInfoFromMetaData file isn't exist, filename: %s", new Object[] { paramString });
        AppMethodBeat.o(46166);
        return;
      }
      try
      {
        com.tencent.mm.compatible.h.d locald = new com.tencent.mm.compatible.h.d();
        try
        {
          locald.setDataSource(paramString);
          paramArrayOfInt[0] = bt.getInt(locald.extractMetadata(9), 0);
          int i = bt.getInt(locald.extractMetadata(24), 0);
          if ((i == 90) || (i == 270))
          {
            paramArrayOfInt[1] = bt.getInt(locald.extractMetadata(19), 0);
            paramArrayOfInt[2] = bt.getInt(locald.extractMetadata(18), 0);
          }
          for (;;)
          {
            locald.release();
            AppMethodBeat.o(46166);
            return;
            paramArrayOfInt[1] = bt.getInt(locald.extractMetadata(18), 0);
            paramArrayOfInt[2] = bt.getInt(locald.extractMetadata(19), 0);
          }
          if (paramArrayOfInt == null) {
            break label159;
          }
        }
        finally
        {
          paramArrayOfInt = locald;
        }
      }
      finally
      {
        label159:
        paramArrayOfInt = null;
      }
      paramArrayOfInt.release();
      AppMethodBeat.o(46166);
      throw paramString;
    }
    
    private void d(int paramInt, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(46164);
      long l;
      int i;
      int j;
      int k;
      if (AppBrandCameraView.i(AppBrandCameraView.this) != null)
      {
        l = 0L;
        if (paramInt != 0) {
          break label128;
        }
        int[] arrayOfInt = new int[3];
        c(paramString3, arrayOfInt);
        i = (int)Math.round(arrayOfInt[0] * 1.0D / 1000.0D);
        l = com.tencent.mm.vfs.i.aYo(paramString3);
        j = arrayOfInt[1];
        k = arrayOfInt[2];
      }
      for (;;)
      {
        AppBrandCameraView.i(AppBrandCameraView.this).a(paramInt, paramString1, f(AppBrandCameraView.c(AppBrandCameraView.this), paramString2), f(AppBrandCameraView.c(AppBrandCameraView.this), paramString3), i, l, j, k);
        AppBrandCameraView.t(AppBrandCameraView.this);
        AppMethodBeat.o(46164);
        return;
        label128:
        k = 0;
        j = 0;
        i = 0;
      }
    }
    
    static String f(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString)
    {
      AppMethodBeat.i(46167);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(46167);
        return paramString;
      }
      com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
      if (paramc.Fg().a(new com.tencent.mm.vfs.e(paramString), "", true, locali) == l.jMv)
      {
        paramc = (String)locali.value;
        AppMethodBeat.o(46167);
        return paramc;
      }
      AppMethodBeat.o(46167);
      return null;
    }
    
    final boolean a(Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(46159);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        try
        {
          AppBrandCameraView.b(AppBrandCameraView.this, paramBitmap.getWidth());
          AppBrandCameraView.c(AppBrandCameraView.this, paramBitmap.getHeight());
          int i = 90;
          if ("normal".equals(AppBrandCameraView.r(AppBrandCameraView.this))) {
            i = 44;
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.g.a(paramBitmap, i, Bitmap.CompressFormat.JPEG, paramString, true);
            ad.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aYo(paramString)) });
            AppMethodBeat.o(46159);
            return true;
            boolean bool = "low".equals(AppBrandCameraView.r(AppBrandCameraView.this));
            if (bool) {
              i = 25;
            }
          }
          AppMethodBeat.o(46159);
        }
        catch (Exception paramBitmap)
        {
          ad.e("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", new Object[] { paramBitmap.getMessage() });
        }
      }
      return false;
    }
    
    public final void bjF()
    {
      AppMethodBeat.i(46158);
      ad.i("MicroMsg.AppBrandCameraView", "takePicture.");
      if (AppBrandCameraView.e(AppBrandCameraView.this) == null)
      {
        ad.i("MicroMsg.AppBrandCameraView", "recordView is null");
        AppMethodBeat.o(46158);
        return;
      }
      if (AppBrandCameraView.k(AppBrandCameraView.this) == 2)
      {
        ad.w("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
        AppMethodBeat.o(46158);
        return;
      }
      if ((AppBrandCameraView.l(AppBrandCameraView.this)) || (bt.aO(AppBrandCameraView.m(AppBrandCameraView.this)) < 300L))
      {
        ad.i("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
        AppMethodBeat.o(46158);
        return;
      }
      if (!AppBrandCameraView.n(AppBrandCameraView.this))
      {
        ad.w("MicroMsg.AppBrandCameraView", "takePicture err, isn't init done");
        AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "camera has not been initialized");
        AppMethodBeat.o(46158);
        return;
      }
      AppBrandCameraView.a(AppBrandCameraView.this, bt.HI());
      AppBrandCameraView.o(AppBrandCameraView.this);
      AppBrandCameraView.a(AppBrandCameraView.this, 3);
      AppBrandCameraView.e(AppBrandCameraView.this).a(new MMSightRecordView.g()
      {
        public final void N(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(46151);
          if (paramAnonymousBitmap != null)
          {
            if (AppBrandCameraView.b.this.a(paramAnonymousBitmap, AppBrandCameraView.p(AppBrandCameraView.this)))
            {
              AppBrandCameraView.a(AppBrandCameraView.this, 0, AppBrandCameraView.b.f(AppBrandCameraView.c(AppBrandCameraView.this), AppBrandCameraView.p(AppBrandCameraView.this)), "");
              AppMethodBeat.o(46151);
              return;
            }
            AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "save fail");
            AppMethodBeat.o(46151);
            return;
          }
          AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "bitmap is null");
          AppMethodBeat.o(46151);
        }
        
        public final void bjU()
        {
          AppMethodBeat.i(46152);
          AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "take picture error");
          AppMethodBeat.o(46152);
        }
      }, "on".equals(AppBrandCameraView.q(AppBrandCameraView.this)));
      AppMethodBeat.o(46158);
    }
    
    public final void bjO()
    {
      AppMethodBeat.i(46160);
      ad.i("MicroMsg.AppBrandCameraView", "startRecord.");
      a locala = a.a.bjD();
      if ((!locala.kHa) || (!locala.kHb)) {
        ad.i("MicroMsg.AppBrandCameraMrg", "no all permission");
      }
      if ((locala.kHa) && (locala.kHb)) {}
      for (int i = 1; i == 0; i = 0)
      {
        Toast.makeText(AppBrandCameraView.s(AppBrandCameraView.this), 2131761241, 1).show();
        ad.w("MicroMsg.AppBrandCameraView", "no micro phone permission");
        ag(-1, "permission");
        AppMethodBeat.o(46160);
        return;
      }
      if (AppBrandCameraView.k(AppBrandCameraView.this) == 2)
      {
        ad.w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
        ag(-1, "is recording");
        AppMethodBeat.o(46160);
        return;
      }
      if (!AppBrandCameraView.n(AppBrandCameraView.this))
      {
        ad.w("MicroMsg.AppBrandCameraView", "startRecord err, isn't init done");
        ag(-1, "camera has not been initialized");
        AppMethodBeat.o(46160);
        return;
      }
      if (AppBrandCameraView.e(AppBrandCameraView.this).vMS.PP())
      {
        AppBrandCameraView.b(AppBrandCameraView.this, bt.HI());
        AppBrandCameraView.a(AppBrandCameraView.this, 2);
        ag(0, "");
        AppBrandCameraView.t(AppBrandCameraView.this);
        AppMethodBeat.o(46160);
        return;
      }
      ad.w("MicroMsg.AppBrandCameraView", "startRecord fail !!");
      ag(-1, "startRecord fail");
      AppMethodBeat.o(46160);
    }
    
    public final void bjP()
    {
      AppMethodBeat.i(46165);
      long l = bt.aO(AppBrandCameraView.y(AppBrandCameraView.this));
      if (l < 1500L)
      {
        ad.i("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", new Object[] { Long.valueOf(1500L - l) });
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46156);
            AppBrandCameraView.b.this.stopRecord();
            AppMethodBeat.o(46156);
          }
        }, 1500L - l);
        AppMethodBeat.o(46165);
        return;
      }
      stopRecord();
      AppMethodBeat.o(46165);
    }
    
    final void bjT()
    {
      AppMethodBeat.i(46163);
      AppBrandCameraView.x(AppBrandCameraView.this);
      AppBrandCameraView.a(AppBrandCameraView.this, false);
      AppMethodBeat.o(46163);
    }
    
    public final void init() {}
    
    public final void release() {}
    
    public final void s(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(46157);
      if (!AppBrandCameraView.j(AppBrandCameraView.this))
      {
        AppMethodBeat.o(46157);
        return;
      }
      AppMethodBeat.o(46157);
    }
    
    public final void stopRecord()
    {
      AppMethodBeat.i(46162);
      ad.i("MicroMsg.AppBrandCameraView", "stopRecord");
      if (AppBrandCameraView.e(AppBrandCameraView.this) == null)
      {
        ad.i("MicroMsg.AppBrandCameraView", "recordView is null");
        d(-1, "camera is null", null, null);
        AppMethodBeat.o(46162);
        return;
      }
      if (AppBrandCameraView.k(AppBrandCameraView.this) != 2)
      {
        ad.w("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
        d(-1, "is not recording", null, null);
        AppMethodBeat.o(46162);
        return;
      }
      if (AppBrandCameraView.u(AppBrandCameraView.this))
      {
        ad.i("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
        d(-1, "is stopping", null, null);
        AppMethodBeat.o(46162);
        return;
      }
      AppBrandCameraView.a(AppBrandCameraView.this, true);
      AppBrandCameraView.e(AppBrandCameraView.this).a(new MMSightRecordView.h()
      {
        public final void gw(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(46153);
          ad.i("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (AppBrandCameraView.e(AppBrandCameraView.this) == null)
          {
            ad.i("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
            AppBrandCameraView.b.a(AppBrandCameraView.b.this, "camera is null");
            AppMethodBeat.o(46153);
            return;
          }
          AppBrandCameraView.this.kHC = 1;
          if (paramAnonymousBoolean)
          {
            AppBrandCameraView.b.a(AppBrandCameraView.b.this, "stop error");
            AppBrandCameraView.b.this.bjT();
            AppMethodBeat.o(46153);
            return;
          }
          if (AppBrandCameraView.v(AppBrandCameraView.this))
          {
            AppBrandCameraView.b localb = AppBrandCameraView.b.this;
            com.tencent.e.h.LTJ.aR(new AppBrandCameraView.b.3(localb));
            AppMethodBeat.o(46153);
            return;
          }
          AppBrandCameraView.b.b(AppBrandCameraView.b.this, AppBrandCameraView.e(AppBrandCameraView.this).getVideoFilePath());
          AppMethodBeat.o(46153);
        }
      });
      AppMethodBeat.o(46162);
    }
  }
  
  protected class c
    implements AppBrandCameraView.a, c.a
  {
    private int aXs;
    private int aXt;
    private int duration;
    private float hpf;
    private Point juY;
    private com.tencent.mm.plugin.appbrand.jsapi.camera.a.c kHP;
    AtomicBoolean kHQ;
    private int kHR;
    private Rect kHS;
    private int kHT;
    int kHU;
    private int kHV;
    
    protected c()
    {
      AppMethodBeat.i(46171);
      this.kHQ = new AtomicBoolean(false);
      this.kHR = 200;
      this.duration = this.kHR;
      this.hpf = (AppBrandCameraView.z(AppBrandCameraView.this) * 1.0F / AppBrandCameraView.A(AppBrandCameraView.this));
      if (AppBrandCameraView.B(AppBrandCameraView.this)) {
        i = 1;
      }
      this.kHU = i;
      AppMethodBeat.o(46171);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint)
    {
      AppMethodBeat.i(188299);
      if (this.kHQ.compareAndSet(false, true))
      {
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46170);
            AppBrandCameraView.c.this.kHQ.set(false);
            AppMethodBeat.o(46170);
          }
        }, this.duration);
        ad.d("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d, codeVersion:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if ((paramQBarPoint != null) && (this.kHV % 4 == 0))
        {
          ad.i("MicroMsg.AppBrandCameraView", "x: %f, y: %f, w: %f, h: %f; x0:%f, x1:%f, x2:%f, x3:%f, y0:%f, y1:%f, y2:%f, y3:%f", new Object[] { Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x1 - paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y3 - paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.x1), Float.valueOf(paramQBarPoint.x2), Float.valueOf(paramQBarPoint.x3), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.y1), Float.valueOf(paramQBarPoint.y2), Float.valueOf(paramQBarPoint.y3) });
          this.kHV += 1;
        }
      }
      switch (paramInt1)
      {
      default: 
        ad.w("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
        AppMethodBeat.o(188299);
        return;
      case 1: 
        j.a(AppBrandCameraView.c(AppBrandCameraView.this), AppBrandCameraView.this.getCameraId(), "qrcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
        AppMethodBeat.o(188299);
        return;
      }
      j.a(AppBrandCameraView.c(AppBrandCameraView.this), AppBrandCameraView.this.getCameraId(), "barcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
      AppMethodBeat.o(188299);
    }
    
    public final void bjF()
    {
      AppMethodBeat.i(46175);
      ad.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
      AppMethodBeat.o(46175);
    }
    
    public final void bjO()
    {
      AppMethodBeat.i(46176);
      ad.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
      AppMethodBeat.o(46176);
    }
    
    public final void bjP()
    {
      AppMethodBeat.i(46177);
      ad.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
      AppMethodBeat.o(46177);
    }
    
    public void init()
    {
      AppMethodBeat.i(46172);
      this.kHP = new com.tencent.mm.plugin.appbrand.jsapi.camera.a.d();
      this.kHP.init();
      this.kHP.kIK = this;
      AppBrandCameraView.a(AppBrandCameraView.this, 4);
      if (AppBrandCameraView.C(AppBrandCameraView.this) > 0) {
        this.duration = (1000 / AppBrandCameraView.C(AppBrandCameraView.this));
      }
      this.kHV = 0;
      AppMethodBeat.o(46172);
    }
    
    public final void release()
    {
      AppMethodBeat.i(46178);
      if (this.kHP != null) {
        this.kHP.release();
      }
      this.juY = null;
      this.kHV = 0;
      AppMethodBeat.o(46178);
    }
    
    public final void s(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int j = 0;
      AppMethodBeat.i(46173);
      int i;
      int k;
      label140:
      float f2;
      if ((this.aXs != AppBrandCameraView.z(AppBrandCameraView.this)) || (this.aXt != AppBrandCameraView.A(AppBrandCameraView.this))) {
        switch (((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay().getRotation())
        {
        default: 
          i = 0;
          k = AppBrandCameraView.e(AppBrandCameraView.this).getCameraRotation();
          if ("front".equals(AppBrandCameraView.E(AppBrandCameraView.this)))
          {
            this.kHT = (k % 360);
            this.kHT = ((360 - this.kHT) % 360);
            if (AppBrandCameraView.e(AppBrandCameraView.this) != null)
            {
              this.aXs = AppBrandCameraView.z(AppBrandCameraView.this);
              this.aXt = AppBrandCameraView.A(AppBrandCameraView.this);
            }
            AppBrandCameraView.z(AppBrandCameraView.this);
            AppBrandCameraView.A(AppBrandCameraView.this);
            k = this.kHT;
            f2 = this.hpf;
            if ((paramInt1 > 0) && (paramInt2 > 0)) {
              break label332;
            }
            localObject = null;
            label211:
            this.juY = ((Point)localObject);
            if (this.juY != null)
            {
              localObject = AppBrandCameraView.D(AppBrandCameraView.this);
              i = AppBrandCameraView.z(AppBrandCameraView.this);
              j = this.juY.x;
              if (localObject != null) {
                break label517;
              }
            }
          }
          break;
        }
      }
      label332:
      float f1;
      for (Object localObject = null;; localObject = new Rect(Math.round(((Rect)localObject).left / f1), Math.round(((Rect)localObject).top / f1), Math.round(((Rect)localObject).right / f1), Math.round(((Rect)localObject).bottom / f1)))
      {
        this.kHS = ((Rect)localObject);
        if (!this.kHQ.get()) {
          break label588;
        }
        ad.d("MicroMsg.AppBrandCameraView", "[onFrameData] isScanPause, return");
        AppMethodBeat.o(46173);
        return;
        i = 90;
        break;
        i = 180;
        break;
        i = 270;
        break;
        this.kHT = ((k - i + 360) % 360);
        break label140;
        if (k != 90)
        {
          f1 = f2;
          if (k != 270) {}
        }
        else
        {
          f1 = 1.0F / f2;
        }
        i = j;
        if (paramInt2 * f1 < paramInt1) {
          i = 1;
        }
        f1 = 1.0F / f1;
        if (i == 0)
        {
          this.kHU = 1;
          i = Math.max(paramInt2, paramInt1);
          j = (int)(f1 * i);
          if ((k == 90) || (k == 270))
          {
            localObject = new Point(j, i);
            break label211;
          }
          localObject = new Point(i, j);
          break label211;
        }
        i = Math.min(paramInt2, paramInt1);
        j = (int)(i / f1);
        if ((k == 90) || (k == 270))
        {
          localObject = new Point(i, j);
          break label211;
        }
        localObject = new Point(j, i);
        break label211;
        label517:
        f1 = i * 1.0F / j;
      }
      label588:
      if ((this.kHP != null) && (AppBrandCameraView.e(AppBrandCameraView.this) != null)) {
        this.kHP.b(paramArrayOfByte, paramInt1, paramInt2, AppBrandCameraView.z(AppBrandCameraView.this), AppBrandCameraView.A(AppBrandCameraView.this), this.juY, this.kHS, this.kHT, this.kHU);
      }
      AppMethodBeat.o(46173);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView
 * JD-Core Version:    0.7.0.1
 */