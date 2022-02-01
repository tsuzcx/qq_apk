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
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.media.r;
import com.tencent.mm.plugin.appbrand.jsruntime.s;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
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
  private String cmk;
  private ImageView djK;
  private String gCx;
  private com.tencent.mm.plugin.appbrand.jsapi.c jLD;
  private String jLE;
  private int jLF;
  private a jLG;
  private int jLH;
  private String jLI;
  private String jLJ;
  private String jLK;
  private boolean jLL;
  private boolean jLM;
  private boolean jLN;
  private boolean jLO;
  private int jLP;
  private int jLQ;
  private int jLR;
  private int jLS;
  private Rect jLT;
  private int jLU;
  private Size jLV;
  private c jLW;
  private b jLX;
  private MMSightRecordView jLY;
  private String jLZ;
  private String jMa;
  int jMb;
  private boolean jMc;
  private long jMd;
  private long jMe;
  private d jMf;
  private boolean jMg;
  private float jMh;
  private AtomicBoolean jMi;
  private List<Runnable> jMj;
  private String mAppId;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(46215);
    g.aOt();
    AppMethodBeat.o(46215);
  }
  
  public AppBrandCameraView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(46180);
    this.jLE = "scanCode";
    this.cmk = "back";
    this.jLI = "auto";
    this.jLJ = "high";
    this.jLL = false;
    this.jLM = false;
    this.jLO = false;
    this.jLP = 1080;
    this.jLQ = 1920;
    this.jLR = 1080;
    this.jLS = 1920;
    this.jMb = -1;
    this.jMc = false;
    this.jMd = -1L;
    this.jMe = -1L;
    this.jMi = new AtomicBoolean(false);
    init(paramContext);
    AppMethodBeat.o(46180);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(46181);
    this.jLE = "scanCode";
    this.cmk = "back";
    this.jLI = "auto";
    this.jLJ = "high";
    this.jLL = false;
    this.jLM = false;
    this.jLO = false;
    this.jLP = 1080;
    this.jLQ = 1920;
    this.jLR = 1080;
    this.jLS = 1920;
    this.jMb = -1;
    this.jMc = false;
    this.jMd = -1L;
    this.jMe = -1L;
    this.jMi = new AtomicBoolean(false);
    init(paramContext);
    AppMethodBeat.o(46181);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(46182);
    this.jLE = "scanCode";
    this.cmk = "back";
    this.jLI = "auto";
    this.jLJ = "high";
    this.jLL = false;
    this.jLM = false;
    this.jLO = false;
    this.jLP = 1080;
    this.jLQ = 1920;
    this.jLR = 1080;
    this.jLS = 1920;
    this.jMb = -1;
    this.jMc = false;
    this.jMd = -1L;
    this.jMe = -1L;
    this.jMi = new AtomicBoolean(false);
    init(paramContext);
    AppMethodBeat.o(46182);
  }
  
  public static void aZi()
  {
    AppMethodBeat.i(46179);
    l.jMD = new l.a() {};
    AppMethodBeat.o(46179);
  }
  
  private void aZk()
  {
    int j = 0;
    AppMethodBeat.i(46197);
    ad.i("MicroMsg.AppBrandCameraView", "initCamera.");
    if (!a.a.aZh().aZg())
    {
      Toast.makeText(this.mContext, 2131761241, 1).show();
      ad.w("MicroMsg.AppBrandCameraView", "no permission");
      AppMethodBeat.o(46197);
      return;
    }
    if (this.jLY != null)
    {
      ad.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
      AppMethodBeat.o(46197);
      return;
    }
    Object localObject = a.a.aZh().aZf();
    int i;
    if (localObject.length > 0)
    {
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        int m = localObject[i];
        if (m != this.jLH)
        {
          a.a.aZh().I(m, false);
          ad.i("MicroMsg.AppBrandCameraView", "release camera before init new camera, id: %d", new Object[] { Integer.valueOf(m) });
        }
        i += 1;
      }
    }
    if (this.djK == null)
    {
      this.djK = new ImageView(this.mContext);
      this.djK.setScaleType(ImageView.ScaleType.FIT_XY);
      addView(this.djK, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      this.jLY = c(this.mContext, this.jLP, this.jLQ);
      if (this.jLY == null) {
        this.jLY = new MMSightRecordView(this.mContext);
      }
      this.jMg = false;
      addView(this.jLY);
      aZu();
      this.jLY.setRGBSizeLimit(this.jLF);
      this.jLY.tBp.aLp();
      this.jLY.setDisplayRatio(this.jLP * 1.0F / this.jLQ);
      localObject = this.jLY;
      i = j;
      if (this.jLL) {
        i = 1;
      }
      ((MMSightRecordView)localObject).setPreviewMode(i);
      this.jLY.setVideoPara$2e715812(600000);
      this.jLY.setVideoFilePath(this.jLZ);
      this.jLY.setClipPictureSize(true);
      this.jLY.setClipVideoSize(true);
      this.jLY.setDisplayScreenSize(this.jLV);
      this.jLY.setUseBackCamera("back".equals(this.cmk));
      this.jLY.setFrameDataCallback(new MMSightRecordView.a()
      {
        public final void t(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(46147);
          if (AppBrandCameraView.a(AppBrandCameraView.this) != null) {
            AppBrandCameraView.a(AppBrandCameraView.this).t(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(46147);
        }
      });
      this.jLY.setInitErrorCallback(new MMSightRecordView.d()
      {
        public final void aZv()
        {
          AppMethodBeat.i(46148);
          ad.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
          Object localObject = new HashMap();
          ((Map)localObject).put("cameraId", Integer.valueOf(AppBrandCameraView.b(AppBrandCameraView.this)));
          localObject = new JSONObject((Map)localObject).toString();
          new i().h(AppBrandCameraView.c(AppBrandCameraView.this)).HK((String)localObject).aXQ();
          AppMethodBeat.o(46148);
        }
      });
      this.jLY.setInitDoneCallback(new MMSightRecordView.c()
      {
        public final void aZw()
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
          localh.HK(new JSONObject(localHashMap).toString());
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
      this.jLY.tBp.startPreview();
      this.jLY.tBp.aLj();
      this.jMb = 1;
      AppMethodBeat.o(46197);
      return;
      this.djK.setImageBitmap(null);
    }
  }
  
  private void aZn()
  {
    AppMethodBeat.i(46201);
    this.gCx = (com.tencent.mm.loader.j.b.ais() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    AppMethodBeat.o(46201);
  }
  
  private void aZo()
  {
    AppMethodBeat.i(46202);
    String str = "MicroMsg_" + System.currentTimeMillis();
    this.jLZ = (com.tencent.mm.loader.j.b.ais() + str + ".mp4");
    this.jMa = (com.tencent.mm.loader.j.b.ais() + str + ".jpeg");
    if (this.jLY != null) {
      this.jLY.setVideoFilePath(this.jLZ);
    }
    AppMethodBeat.o(46202);
  }
  
  private void aZp()
  {
    AppMethodBeat.i(46203);
    if ((this.jLY == null) || (this.jLI == null))
    {
      AppMethodBeat.o(46203);
      return;
    }
    if (this.jLI.equals("auto"))
    {
      this.jLY.setFlashMode(3);
      AppMethodBeat.o(46203);
      return;
    }
    if (this.jLI.equals("torch"))
    {
      this.jLY.setFlashMode(1);
      AppMethodBeat.o(46203);
      return;
    }
    if (this.jLI.equals("on"))
    {
      if ((this.jMb == 2) || (this.jMb == 4) || (!this.jLI.equals("on")))
      {
        this.jLY.setFlashMode(1);
        AppMethodBeat.o(46203);
      }
    }
    else if (this.jLI.equals("torch"))
    {
      this.jLY.setFlashMode(1);
      AppMethodBeat.o(46203);
      return;
    }
    this.jLY.setFlashMode(2);
    AppMethodBeat.o(46203);
  }
  
  private void aZq()
  {
    AppMethodBeat.i(46204);
    ad.i("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", new Object[] { this.jLE });
    aZr();
    this.jLG = HY(this.jLE);
    this.jLG.init();
    AppMethodBeat.o(46204);
  }
  
  private void aZr()
  {
    AppMethodBeat.i(46206);
    if (this.jLG != null)
    {
      this.jLG.release();
      this.jLG = null;
    }
    AppMethodBeat.o(46206);
  }
  
  private void aZu()
  {
    int j = 720;
    AppMethodBeat.i(46211);
    int i = j;
    String str;
    if (!bt.isNullOrNil(this.jLK))
    {
      str = this.jLK;
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
      if (this.jLF > i)
      {
        ad.i("MicroMsg.AppBrandCameraView", "framesize is : %d, large than preview size: %d", new Object[] { Integer.valueOf(this.jLF), Integer.valueOf(i) });
        j = this.jLF;
      }
      this.jLY.setPreviewSizeLimit(j);
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
    this.jMi.set(false);
    LayoutInflater.from(paramContext).inflate(2131492976, this);
    AppMethodBeat.o(46183);
  }
  
  protected a HY(String paramString)
  {
    AppMethodBeat.i(46205);
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals("scanCode"))) {}
    for (paramString = new c();; paramString = new b((byte)0))
    {
      AppMethodBeat.o(46205);
      return paramString;
    }
  }
  
  public final void aZj()
  {
    AppMethodBeat.i(46195);
    if (this.jLG != null) {
      this.jLG.aZj();
    }
    AppMethodBeat.o(46195);
  }
  
  public final void aZl()
  {
    AppMethodBeat.i(46198);
    if (this.jLY == null)
    {
      ad.i("MicroMsg.AppBrandCameraView", "recordView is null");
      AppMethodBeat.o(46198);
      return;
    }
    aZq();
    aZp();
    AppMethodBeat.o(46198);
  }
  
  public final void aZm()
  {
    AppMethodBeat.i(46200);
    if (this.jLW == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    if (this.jMf == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    this.jMf.a(this.jLY);
    this.jMf = null;
    AppMethodBeat.o(46200);
  }
  
  public final void aZs()
  {
    AppMethodBeat.i(46209);
    if (this.jLG != null) {
      this.jLG.aZs();
    }
    AppMethodBeat.o(46209);
  }
  
  public final void aZt()
  {
    AppMethodBeat.i(46210);
    if (this.jLG != null) {
      this.jLG.aZt();
    }
    AppMethodBeat.o(46210);
  }
  
  public final void an(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46186);
    if (bt.kU(this.cmk, paramString))
    {
      AppMethodBeat.o(46186);
      return;
    }
    if (bt.kU(this.jLE, "scanCode"))
    {
      AppMethodBeat.o(46186);
      return;
    }
    this.cmk = paramString;
    if ((!paramBoolean) && (this.jLY != null)) {
      this.jLY.tBp.switchCamera();
    }
    AppMethodBeat.o(46186);
  }
  
  public final float as(float paramFloat)
  {
    AppMethodBeat.i(46196);
    if (this.jLY != null)
    {
      if (paramFloat < 1.0F)
      {
        AppMethodBeat.o(46196);
        return paramFloat;
      }
      float f = paramFloat;
      if (paramFloat > this.jMh) {}
      for (f = this.jMh; (!this.jLY.tBp.am(f)) && (f > 0.0F); f -= 0.1F) {}
      AppMethodBeat.o(46196);
      return f;
    }
    AppMethodBeat.o(46196);
    return 0.0F;
  }
  
  protected MMSightRecordView c(Context paramContext, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public final boolean dM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46190);
    if ((this.jLP == paramInt1) && (this.jLQ == paramInt2))
    {
      AppMethodBeat.o(46190);
      return false;
    }
    ad.i("MicroMsg.AppBrandCameraView", "setViewSize");
    this.jLP = paramInt1;
    this.jLQ = paramInt2;
    AppMethodBeat.o(46190);
    return true;
  }
  
  public int getCameraId()
  {
    return this.jLH;
  }
  
  protected MMSightRecordView getRecordView()
  {
    return this.jLY;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(46184);
    ad.i("MicroMsg.AppBrandCameraView", "initView");
    if (!a.a.aZh().aZg())
    {
      AppMethodBeat.o(46184);
      return;
    }
    aZo();
    aZn();
    aZk();
    aZl();
    this.jMi.compareAndSet(false, true);
    AppMethodBeat.o(46184);
  }
  
  public final void o(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(46199);
    ad.i("MicroMsg.AppBrandCameraView", "listenFrameChange");
    if (this.jLW == null)
    {
      AppMethodBeat.o(46199);
      return;
    }
    if (this.jLY == null)
    {
      ad.w("MicroMsg.AppBrandCameraView", "listenFrameChange recordView null");
      this.jLW.h("camera illegal state", -1, -1, -1);
      AppMethodBeat.o(46199);
      return;
    }
    if (this.jMf == null) {
      this.jMf = new d(paramc);
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
          if (locald.jMw == null)
          {
            i = -2;
          }
          else
          {
            if (locald.jMy != -2147483648)
            {
              ad.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange destroy last one bufferId:%d", new Object[] { Integer.valueOf(locald.jMy) });
              locald.jMw.sA(locald.jMy);
            }
            locald.jMy = locald.jMw.sC(j * k * 4);
            ad.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange bufferId:%d height:%d width:%d", new Object[] { Integer.valueOf(locald.jMy), Integer.valueOf(k), Integer.valueOf(j) });
            locald.jMx = true;
            localMMSightRecordView.a(locald.jMw.sB(locald.jMy), locald);
            i = locald.jMy;
          }
        }
        AppBrandCameraView.i(AppBrandCameraView.this).h(null, i, j, k);
        AppMethodBeat.o(46150);
      }
    };
    if (!this.jMg)
    {
      if (this.jMj == null) {
        this.jMj = new ArrayList();
      }
      this.jMj.add(paramc);
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
    if (this.jMb == 2)
    {
      ad.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(this.jLH));
      ((Map)localObject).put("errMsg", "stop on record");
      localObject = new JSONObject((Map)localObject).toString();
      new m().h(this.jLD).HK((String)localObject).aXQ();
    }
    if (this.jLY != null)
    {
      localObject = this.jLY.getCurrentFramePicture();
      if (localObject != null) {
        this.djK.setImageBitmap((Bitmap)localObject);
      }
    }
    MMSightRecordView localMMSightRecordView;
    if (this.jMf != null)
    {
      localObject = this.jMf;
      localMMSightRecordView = this.jLY;
      ad.i("MicroMsg.FrameDataCallbackHelper", "onUIPause mNeedCallback:%b", new Object[] { Boolean.valueOf(((d)localObject).jMx) });
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
      new k().h(this.jLD).HK((String)localObject).aXQ();
      AppMethodBeat.o(46191);
      return;
      label250:
      localMMSightRecordView.a(null, null);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(46193);
    if (this.jMf != null) {
      this.jMf.a(this.jLY);
    }
    release();
    this.jMi.compareAndSet(true, false);
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
        if (!this.jMi.get())
        {
          ad.w("MicroMsg.AppBrandCameraView", "no execute initView");
          return;
        }
        aZk();
        aZq();
        aZp();
        d locald;
        if (this.jMf != null)
        {
          locald = this.jMf;
          localMMSightRecordView = this.jLY;
          ad.i("MicroMsg.FrameDataCallbackHelper", "onUIResume mNeedCallback:%b", new Object[] { Boolean.valueOf(locald.jMx) });
          if (locald.jMx)
          {
            if (localMMSightRecordView != null) {
              continue;
            }
            ad.w("MicroMsg.FrameDataCallbackHelper", "onUIResume recordView null");
          }
        }
        return;
        if (locald.jMy == -2147483648)
        {
          ad.w("MicroMsg.FrameDataCallbackHelper", "onUIResume invalid mCurrentSharedBufferId");
          continue;
        }
        if (localf.jMw != null) {
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
      localMMSightRecordView.a(localf.jMw.sB(localf.jMy), localf);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(46194);
    ad.i("MicroMsg.AppBrandCameraView", "release");
    try
    {
      if (this.jLY != null)
      {
        this.jLY.tBp.release();
        removeView(this.jLY);
        this.jMb = -1;
        this.jLY.setFrameDataCallback(null);
        this.jLY.setInitErrorCallback(null);
        this.jLY.setInitDoneCallback(null);
        this.jLY = null;
      }
      if (this.djK != null) {
        this.djK.setImageBitmap(null);
      }
      if (this.jMj != null) {
        this.jMj.clear();
      }
      this.jMh = 0.0F;
      aZr();
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
    this.jLH = paramInt;
  }
  
  public void setCompressRecord(boolean paramBoolean)
  {
    this.jLM = paramBoolean;
  }
  
  public void setDisplayScreenSize(Size paramSize)
  {
    AppMethodBeat.i(195817);
    if ((paramSize == null) || (paramSize.getHeight() <= 0) || (paramSize.getWidth() <= 0))
    {
      AppMethodBeat.o(195817);
      return;
    }
    this.jLV = paramSize;
    AppMethodBeat.o(195817);
  }
  
  public void setFlash(String paramString)
  {
    AppMethodBeat.i(46187);
    if (bt.kU(this.jLI, paramString))
    {
      AppMethodBeat.o(46187);
      return;
    }
    this.jLI = paramString;
    AppMethodBeat.o(46187);
  }
  
  public void setFrameLimitSize(int paramInt)
  {
    AppMethodBeat.i(46185);
    ad.i("MicroMsg.AppBrandCameraView", "setFrameLimitSize:%d", new Object[] { Integer.valueOf(paramInt) });
    this.jLF = paramInt;
    AppMethodBeat.o(46185);
  }
  
  public void setMode(String paramString)
  {
    this.jLE = paramString;
  }
  
  public void setNeedOutput(boolean paramBoolean)
  {
    this.jLN = paramBoolean;
  }
  
  public void setOperateCallBack(c paramc)
  {
    this.jLW = paramc;
  }
  
  public void setOutPutCallBack(b paramb)
  {
    this.jLX = paramb;
  }
  
  public void setPage(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    this.jLD = parame;
  }
  
  public void setPreviewCenterCrop(boolean paramBoolean)
  {
    this.jLL = paramBoolean;
  }
  
  public void setQuality(String paramString)
  {
    AppMethodBeat.i(46188);
    if (bt.kU(this.jLJ, paramString))
    {
      AppMethodBeat.o(46188);
      return;
    }
    this.jLJ = paramString;
    AppMethodBeat.o(46188);
  }
  
  public void setResolution(String paramString)
  {
    AppMethodBeat.i(46189);
    if (bt.kU(this.jLK, paramString))
    {
      AppMethodBeat.o(46189);
      return;
    }
    ad.i("MicroMsg.AppBrandCameraView", "setPreviewResolution: %s", new Object[] { paramString });
    this.jLK = paramString;
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
    this.jLU = paramInt;
    AppMethodBeat.o(46207);
  }
  
  public final void w(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(46208);
    ad.i("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((paramInt3 <= 0) || (paramInt4 <= 0))
    {
      AppMethodBeat.o(46208);
      return;
    }
    this.jLT = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    AppMethodBeat.o(46208);
  }
  
  public static abstract interface a
  {
    public abstract void aZj();
    
    public abstract void aZs();
    
    public abstract void aZt();
    
    public abstract void init();
    
    public abstract void release();
    
    public abstract void t(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  final class b
    implements AppBrandCameraView.a
  {
    private b() {}
    
    private void ad(int paramInt, String paramString)
    {
      AppMethodBeat.i(46161);
      if (AppBrandCameraView.i(AppBrandCameraView.this) != null) {
        AppBrandCameraView.i(AppBrandCameraView.this).ad(paramInt, paramString);
      }
      AppMethodBeat.o(46161);
    }
    
    private static void c(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(46166);
      if (!com.tencent.mm.vfs.i.eK(paramString))
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
        l = com.tencent.mm.vfs.i.aMN(paramString3);
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
      com.tencent.mm.plugin.appbrand.aa.i locali = new com.tencent.mm.plugin.appbrand.aa.i();
      if (paramc.Ee().a(new com.tencent.mm.vfs.e(paramString), "", true, locali) == com.tencent.mm.plugin.appbrand.appstorage.l.iSq)
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
            com.tencent.mm.sdk.platformtools.f.a(paramBitmap, i, Bitmap.CompressFormat.JPEG, paramString, true);
            ad.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aMN(paramString)) });
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
    
    public final void aZj()
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
      if ((AppBrandCameraView.l(AppBrandCameraView.this)) || (bt.aS(AppBrandCameraView.m(AppBrandCameraView.this)) < 300L))
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
      AppBrandCameraView.a(AppBrandCameraView.this, bt.GC());
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
        
        public final void aZy()
        {
          AppMethodBeat.i(46152);
          AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "take picture error");
          AppMethodBeat.o(46152);
        }
      }, "on".equals(AppBrandCameraView.q(AppBrandCameraView.this)));
      AppMethodBeat.o(46158);
    }
    
    public final void aZs()
    {
      AppMethodBeat.i(46160);
      ad.i("MicroMsg.AppBrandCameraView", "startRecord.");
      a locala = a.a.aZh();
      if ((!locala.jLz) || (!locala.jLA)) {
        ad.i("MicroMsg.AppBrandCameraMrg", "no all permission");
      }
      if ((locala.jLz) && (locala.jLA)) {}
      for (int i = 1; i == 0; i = 0)
      {
        Toast.makeText(AppBrandCameraView.s(AppBrandCameraView.this), 2131761241, 1).show();
        ad.w("MicroMsg.AppBrandCameraView", "no micro phone permission");
        ad(-1, "permission");
        AppMethodBeat.o(46160);
        return;
      }
      if (AppBrandCameraView.k(AppBrandCameraView.this) == 2)
      {
        ad.w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
        ad(-1, "is recording");
        AppMethodBeat.o(46160);
        return;
      }
      if (!AppBrandCameraView.n(AppBrandCameraView.this))
      {
        ad.w("MicroMsg.AppBrandCameraView", "startRecord err, isn't init done");
        ad(-1, "camera has not been initialized");
        AppMethodBeat.o(46160);
        return;
      }
      if (AppBrandCameraView.e(AppBrandCameraView.this).tBp.Ok())
      {
        AppBrandCameraView.b(AppBrandCameraView.this, bt.GC());
        AppBrandCameraView.a(AppBrandCameraView.this, 2);
        ad(0, "");
        AppBrandCameraView.t(AppBrandCameraView.this);
        AppMethodBeat.o(46160);
        return;
      }
      ad.w("MicroMsg.AppBrandCameraView", "startRecord fail !!");
      ad(-1, "startRecord fail");
      AppMethodBeat.o(46160);
    }
    
    public final void aZt()
    {
      AppMethodBeat.i(46165);
      long l = bt.aS(AppBrandCameraView.y(AppBrandCameraView.this));
      if (l < 1500L)
      {
        ad.i("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", new Object[] { Long.valueOf(1500L - l) });
        aq.n(new Runnable()
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
    
    final void aZx()
    {
      AppMethodBeat.i(46163);
      AppBrandCameraView.x(AppBrandCameraView.this);
      AppBrandCameraView.a(AppBrandCameraView.this, false);
      AppMethodBeat.o(46163);
    }
    
    public final void init() {}
    
    public final void release() {}
    
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
        public final void fU(boolean paramAnonymousBoolean)
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
          AppBrandCameraView.this.jMb = 1;
          if (paramAnonymousBoolean)
          {
            AppBrandCameraView.b.a(AppBrandCameraView.b.this, "stop error");
            AppBrandCameraView.b.this.aZx();
            AppMethodBeat.o(46153);
            return;
          }
          if (AppBrandCameraView.v(AppBrandCameraView.this))
          {
            AppBrandCameraView.b localb = AppBrandCameraView.b.this;
            com.tencent.e.h.Iye.aP(new AppBrandCameraView.b.3(localb));
            AppMethodBeat.o(46153);
            return;
          }
          AppBrandCameraView.b.b(AppBrandCameraView.b.this, AppBrandCameraView.e(AppBrandCameraView.this).getVideoFilePath());
          AppMethodBeat.o(46153);
        }
      });
      AppMethodBeat.o(46162);
    }
    
    public final void t(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(46157);
      if (!AppBrandCameraView.j(AppBrandCameraView.this))
      {
        AppMethodBeat.o(46157);
        return;
      }
      AppMethodBeat.o(46157);
    }
  }
  
  protected class c
    implements AppBrandCameraView.a, c.a
  {
    private int aMk;
    private int aMl;
    private int duration;
    private float gwC;
    private Point iBO;
    private com.tencent.mm.plugin.appbrand.jsapi.camera.a.c jMo;
    AtomicBoolean jMp;
    private int jMq;
    private Rect jMr;
    private int jMs;
    int jMt;
    private int jMu;
    
    protected c()
    {
      AppMethodBeat.i(46171);
      this.jMp = new AtomicBoolean(false);
      this.jMq = 200;
      this.duration = this.jMq;
      this.gwC = (AppBrandCameraView.z(AppBrandCameraView.this) * 1.0F / AppBrandCameraView.A(AppBrandCameraView.this));
      if (AppBrandCameraView.B(AppBrandCameraView.this)) {
        i = 1;
      }
      this.jMt = i;
      AppMethodBeat.o(46171);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint)
    {
      AppMethodBeat.i(195816);
      if (this.jMp.compareAndSet(false, true))
      {
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46170);
            AppBrandCameraView.c.this.jMp.set(false);
            AppMethodBeat.o(46170);
          }
        }, this.duration);
        ad.d("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d, codeVersion:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if ((paramQBarPoint != null) && (this.jMu % 4 == 0))
        {
          ad.i("MicroMsg.AppBrandCameraView", "x: %f, y: %f, w: %f, h: %f; x0:%f, x1:%f, x2:%f, x3:%f, y0:%f, y1:%f, y2:%f, y3:%f", new Object[] { Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x1 - paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y3 - paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.x1), Float.valueOf(paramQBarPoint.x2), Float.valueOf(paramQBarPoint.x3), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.y1), Float.valueOf(paramQBarPoint.y2), Float.valueOf(paramQBarPoint.y3) });
          this.jMu += 1;
        }
      }
      switch (paramInt1)
      {
      default: 
        ad.w("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
        AppMethodBeat.o(195816);
        return;
      case 1: 
        j.a(AppBrandCameraView.c(AppBrandCameraView.this), AppBrandCameraView.this.getCameraId(), "qrcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
        AppMethodBeat.o(195816);
        return;
      }
      j.a(AppBrandCameraView.c(AppBrandCameraView.this), AppBrandCameraView.this.getCameraId(), "barcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
      AppMethodBeat.o(195816);
    }
    
    public final void aZj()
    {
      AppMethodBeat.i(46175);
      ad.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
      AppMethodBeat.o(46175);
    }
    
    public final void aZs()
    {
      AppMethodBeat.i(46176);
      ad.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
      AppMethodBeat.o(46176);
    }
    
    public final void aZt()
    {
      AppMethodBeat.i(46177);
      ad.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
      AppMethodBeat.o(46177);
    }
    
    public void init()
    {
      AppMethodBeat.i(46172);
      this.jMo = new com.tencent.mm.plugin.appbrand.jsapi.camera.a.d();
      this.jMo.init();
      this.jMo.jNj = this;
      AppBrandCameraView.a(AppBrandCameraView.this, 4);
      if (AppBrandCameraView.C(AppBrandCameraView.this) > 0) {
        this.duration = (1000 / AppBrandCameraView.C(AppBrandCameraView.this));
      }
      this.jMu = 0;
      AppMethodBeat.o(46172);
    }
    
    public final void release()
    {
      AppMethodBeat.i(46178);
      if (this.jMo != null) {
        this.jMo.release();
      }
      this.iBO = null;
      this.jMu = 0;
      AppMethodBeat.o(46178);
    }
    
    public final void t(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int j = 0;
      AppMethodBeat.i(46173);
      int i;
      int k;
      label140:
      float f2;
      if ((this.aMk != AppBrandCameraView.z(AppBrandCameraView.this)) || (this.aMl != AppBrandCameraView.A(AppBrandCameraView.this))) {
        switch (((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay().getRotation())
        {
        default: 
          i = 0;
          k = AppBrandCameraView.e(AppBrandCameraView.this).getCameraRotation();
          if ("front".equals(AppBrandCameraView.E(AppBrandCameraView.this)))
          {
            this.jMs = (k % 360);
            this.jMs = ((360 - this.jMs) % 360);
            if (AppBrandCameraView.e(AppBrandCameraView.this) != null)
            {
              this.aMk = AppBrandCameraView.z(AppBrandCameraView.this);
              this.aMl = AppBrandCameraView.A(AppBrandCameraView.this);
            }
            AppBrandCameraView.z(AppBrandCameraView.this);
            AppBrandCameraView.A(AppBrandCameraView.this);
            k = this.jMs;
            f2 = this.gwC;
            if ((paramInt1 > 0) && (paramInt2 > 0)) {
              break label332;
            }
            localObject = null;
            label211:
            this.iBO = ((Point)localObject);
            if (this.iBO != null)
            {
              localObject = AppBrandCameraView.D(AppBrandCameraView.this);
              i = AppBrandCameraView.z(AppBrandCameraView.this);
              j = this.iBO.x;
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
        this.jMr = ((Rect)localObject);
        if (!this.jMp.get()) {
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
        this.jMs = ((k - i + 360) % 360);
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
          this.jMt = 1;
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
      if ((this.jMo != null) && (AppBrandCameraView.e(AppBrandCameraView.this) != null)) {
        this.jMo.b(paramArrayOfByte, paramInt1, paramInt2, AppBrandCameraView.z(AppBrandCameraView.this), AppBrandCameraView.A(AppBrandCameraView.this), this.iBO, this.jMr, this.jMs, this.jMt);
      }
      AppMethodBeat.o(46173);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView
 * JD-Core Version:    0.7.0.1
 */