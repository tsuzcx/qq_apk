package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.media.t;
import com.tencent.mm.plugin.appbrand.jsruntime.s;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
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
  private String cuf;
  private ImageView dtJ;
  private String hxR;
  private String kKA;
  private boolean kKB;
  private boolean kKC;
  private boolean kKD;
  private boolean kKE;
  private int kKF;
  private int kKG;
  private int kKH;
  private int kKI;
  private Rect kKJ;
  private int kKK;
  private Size kKL;
  private c kKM;
  private b kKN;
  private MMSightRecordView kKO;
  private String kKP;
  private String kKQ;
  int kKR;
  private boolean kKS;
  private long kKT;
  private long kKU;
  private d kKV;
  private boolean kKW;
  private float kKX;
  private AtomicBoolean kKY;
  private List<Runnable> kKZ;
  private com.tencent.mm.plugin.appbrand.jsapi.c kKt;
  private String kKu;
  private int kKv;
  private a kKw;
  private int kKx;
  private String kKy;
  private String kKz;
  private String mAppId;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(46215);
    g.aZc();
    AppMethodBeat.o(46215);
  }
  
  public AppBrandCameraView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(46180);
    this.kKu = "scanCode";
    this.cuf = "back";
    this.kKy = "auto";
    this.kKz = "high";
    this.kKB = false;
    this.kKC = false;
    this.kKE = false;
    this.kKF = 1080;
    this.kKG = 1920;
    this.kKH = 1080;
    this.kKI = 1920;
    this.kKR = -1;
    this.kKS = false;
    this.kKT = -1L;
    this.kKU = -1L;
    this.kKY = new AtomicBoolean(false);
    init(paramContext);
    AppMethodBeat.o(46180);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(46181);
    this.kKu = "scanCode";
    this.cuf = "back";
    this.kKy = "auto";
    this.kKz = "high";
    this.kKB = false;
    this.kKC = false;
    this.kKE = false;
    this.kKF = 1080;
    this.kKG = 1920;
    this.kKH = 1080;
    this.kKI = 1920;
    this.kKR = -1;
    this.kKS = false;
    this.kKT = -1L;
    this.kKU = -1L;
    this.kKY = new AtomicBoolean(false);
    init(paramContext);
    AppMethodBeat.o(46181);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(46182);
    this.kKu = "scanCode";
    this.cuf = "back";
    this.kKy = "auto";
    this.kKz = "high";
    this.kKB = false;
    this.kKC = false;
    this.kKE = false;
    this.kKF = 1080;
    this.kKG = 1920;
    this.kKH = 1080;
    this.kKI = 1920;
    this.kKR = -1;
    this.kKS = false;
    this.kKT = -1L;
    this.kKU = -1L;
    this.kKY = new AtomicBoolean(false);
    init(paramContext);
    AppMethodBeat.o(46182);
  }
  
  public static void bkn()
  {
    AppMethodBeat.i(46179);
    l.kLt = new l.a() {};
    AppMethodBeat.o(46179);
  }
  
  private void bkp()
  {
    int j = 0;
    AppMethodBeat.i(46197);
    ae.i("MicroMsg.AppBrandCameraView", "initCamera.");
    if (!a.a.bkm().bkl())
    {
      Toast.makeText(this.mContext, 2131761241, 1).show();
      ae.w("MicroMsg.AppBrandCameraView", "no permission");
      AppMethodBeat.o(46197);
      return;
    }
    if (this.kKO != null)
    {
      ae.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
      AppMethodBeat.o(46197);
      return;
    }
    Object localObject = a.a.bkm().bkk();
    int i;
    if (localObject.length > 0)
    {
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        int m = localObject[i];
        if (m != this.kKx)
        {
          a.a.bkm().I(m, false);
          ae.i("MicroMsg.AppBrandCameraView", "release camera before init new camera, id: %d", new Object[] { Integer.valueOf(m) });
        }
        i += 1;
      }
    }
    if (this.dtJ == null)
    {
      this.dtJ = new ImageView(this.mContext);
      this.dtJ.setScaleType(ImageView.ScaleType.FIT_XY);
      addView(this.dtJ, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      this.kKO = e(this.mContext, this.kKF, this.kKG);
      if (this.kKO == null) {
        this.kKO = new MMSightRecordView(this.mContext);
      }
      this.kKW = false;
      addView(this.kKO);
      bkz();
      this.kKO.setRGBSizeLimit(this.kKv);
      this.kKO.vYV.aVR();
      this.kKO.setDisplayRatio(this.kKF * 1.0F / this.kKG);
      localObject = this.kKO;
      i = j;
      if (this.kKB) {
        i = 1;
      }
      ((MMSightRecordView)localObject).setPreviewMode(i);
      this.kKO.setVideoPara$2e715812(600000);
      this.kKO.setVideoFilePath(this.kKP);
      this.kKO.setClipPictureSize(true);
      this.kKO.setClipVideoSize(true);
      this.kKO.setDisplayScreenSize(this.kKL);
      this.kKO.setUseBackCamera("back".equals(this.cuf));
      this.kKO.setFrameDataCallback(new MMSightRecordView.a()
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
      this.kKO.setInitErrorCallback(new MMSightRecordView.d()
      {
        public final void bkA()
        {
          AppMethodBeat.i(46148);
          ae.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
          Object localObject = new HashMap();
          ((Map)localObject).put("cameraId", Integer.valueOf(AppBrandCameraView.b(AppBrandCameraView.this)));
          localObject = new JSONObject((Map)localObject).toString();
          new i().h(AppBrandCameraView.c(AppBrandCameraView.this)).PQ((String)localObject).bja();
          AppMethodBeat.o(46148);
        }
      });
      this.kKO.setInitDoneCallback(new MMSightRecordView.c()
      {
        public final void bkB()
        {
          AppMethodBeat.i(46149);
          AppBrandCameraView.d(AppBrandCameraView.this);
          ae.i("MicroMsg.AppBrandCameraView", "InitDoneCallback");
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
          localh.PQ(new JSONObject(localHashMap).toString());
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
      this.kKO.vYV.startPreview();
      this.kKO.vYV.aVL();
      this.kKR = 1;
      AppMethodBeat.o(46197);
      return;
      this.dtJ.setImageBitmap(null);
    }
  }
  
  private void bks()
  {
    AppMethodBeat.i(46201);
    this.hxR = (com.tencent.mm.loader.j.b.asv() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    AppMethodBeat.o(46201);
  }
  
  private void bkt()
  {
    AppMethodBeat.i(46202);
    String str = "MicroMsg_" + System.currentTimeMillis();
    if (!o.fB(com.tencent.mm.loader.j.b.ash())) {
      o.aZI(com.tencent.mm.loader.j.b.ash());
    }
    this.kKP = (com.tencent.mm.loader.j.b.ash() + str + ".mp4");
    this.kKQ = (com.tencent.mm.loader.j.b.ash() + str + ".jpeg");
    if (this.kKO != null) {
      this.kKO.setVideoFilePath(this.kKP);
    }
    AppMethodBeat.o(46202);
  }
  
  private void bku()
  {
    AppMethodBeat.i(46203);
    if ((this.kKO == null) || (this.kKy == null))
    {
      AppMethodBeat.o(46203);
      return;
    }
    if (this.kKy.equals("auto"))
    {
      this.kKO.setFlashMode(3);
      AppMethodBeat.o(46203);
      return;
    }
    if (this.kKy.equals("torch"))
    {
      this.kKO.setFlashMode(1);
      AppMethodBeat.o(46203);
      return;
    }
    if (this.kKy.equals("on"))
    {
      if ((this.kKR == 2) || (this.kKR == 4) || (!this.kKy.equals("on")))
      {
        this.kKO.setFlashMode(1);
        AppMethodBeat.o(46203);
      }
    }
    else if (this.kKy.equals("torch"))
    {
      this.kKO.setFlashMode(1);
      AppMethodBeat.o(46203);
      return;
    }
    this.kKO.setFlashMode(2);
    AppMethodBeat.o(46203);
  }
  
  private void bkv()
  {
    AppMethodBeat.i(46204);
    ae.i("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", new Object[] { this.kKu });
    bkw();
    this.kKw = Qh(this.kKu);
    this.kKw.init();
    AppMethodBeat.o(46204);
  }
  
  private void bkw()
  {
    AppMethodBeat.i(46206);
    if (this.kKw != null)
    {
      this.kKw.release();
      this.kKw = null;
    }
    AppMethodBeat.o(46206);
  }
  
  private void bkz()
  {
    int j = 720;
    AppMethodBeat.i(46211);
    int i = j;
    String str;
    if (!bu.isNullOrNil(this.kKA))
    {
      str = this.kKA;
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
      if (this.kKv > i)
      {
        ae.i("MicroMsg.AppBrandCameraView", "framesize is : %d, large than preview size: %d", new Object[] { Integer.valueOf(this.kKv), Integer.valueOf(i) });
        j = this.kKv;
      }
      this.kKO.setPreviewSizeLimit(j);
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
    this.kKY.set(false);
    LayoutInflater.from(paramContext).inflate(2131492976, this);
    AppMethodBeat.o(46183);
  }
  
  protected a Qh(String paramString)
  {
    AppMethodBeat.i(46205);
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals("scanCode"))) {}
    for (paramString = new AppBrandCameraView.c(this);; paramString = new b((byte)0))
    {
      AppMethodBeat.o(46205);
      return paramString;
    }
  }
  
  public final void ap(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46186);
    if (bu.lX(this.cuf, paramString))
    {
      AppMethodBeat.o(46186);
      return;
    }
    if (bu.lX(this.kKu, "scanCode"))
    {
      AppMethodBeat.o(46186);
      return;
    }
    this.cuf = paramString;
    if ((!paramBoolean) && (this.kKO != null)) {
      this.kKO.vYV.switchCamera();
    }
    AppMethodBeat.o(46186);
  }
  
  public final float az(float paramFloat)
  {
    AppMethodBeat.i(46196);
    if (this.kKO != null)
    {
      if (paramFloat < 1.0F)
      {
        AppMethodBeat.o(46196);
        return paramFloat;
      }
      float f = paramFloat;
      if (paramFloat > this.kKX) {}
      for (f = this.kKX; (!this.kKO.vYV.at(f)) && (f > 0.0F); f -= 0.1F) {}
      AppMethodBeat.o(46196);
      return f;
    }
    AppMethodBeat.o(46196);
    return 0.0F;
  }
  
  public final void bko()
  {
    AppMethodBeat.i(46195);
    if (this.kKw != null) {
      this.kKw.bko();
    }
    AppMethodBeat.o(46195);
  }
  
  public final void bkq()
  {
    AppMethodBeat.i(46198);
    if (this.kKO == null)
    {
      ae.i("MicroMsg.AppBrandCameraView", "recordView is null");
      AppMethodBeat.o(46198);
      return;
    }
    bkv();
    bku();
    AppMethodBeat.o(46198);
  }
  
  public final void bkr()
  {
    AppMethodBeat.i(46200);
    if (this.kKM == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    if (this.kKV == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    this.kKV.a(this.kKO);
    this.kKV = null;
    AppMethodBeat.o(46200);
  }
  
  public final void bkx()
  {
    AppMethodBeat.i(46209);
    if (this.kKw != null) {
      this.kKw.bkx();
    }
    AppMethodBeat.o(46209);
  }
  
  public final void bky()
  {
    AppMethodBeat.i(46210);
    if (this.kKw != null) {
      this.kKw.bky();
    }
    AppMethodBeat.o(46210);
  }
  
  public final boolean dO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46190);
    if ((this.kKF == paramInt1) && (this.kKG == paramInt2))
    {
      AppMethodBeat.o(46190);
      return false;
    }
    ae.i("MicroMsg.AppBrandCameraView", "setViewSize");
    this.kKF = paramInt1;
    this.kKG = paramInt2;
    AppMethodBeat.o(46190);
    return true;
  }
  
  protected MMSightRecordView e(Context paramContext, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public int getCameraId()
  {
    return this.kKx;
  }
  
  protected MMSightRecordView getRecordView()
  {
    return this.kKO;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(46184);
    ae.i("MicroMsg.AppBrandCameraView", "initView");
    if (!a.a.bkm().bkl())
    {
      AppMethodBeat.o(46184);
      return;
    }
    bkt();
    bks();
    bkp();
    bkq();
    this.kKY.compareAndSet(false, true);
    AppMethodBeat.o(46184);
  }
  
  public final void o(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(46199);
    ae.i("MicroMsg.AppBrandCameraView", "listenFrameChange");
    if (this.kKM == null)
    {
      AppMethodBeat.o(46199);
      return;
    }
    if (this.kKO == null)
    {
      ae.w("MicroMsg.AppBrandCameraView", "listenFrameChange recordView null");
      this.kKM.h("camera illegal state", -1, -1, -1);
      AppMethodBeat.o(46199);
      return;
    }
    if (this.kKV == null) {
      this.kKV = new d(paramc);
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
          ae.w("MicroMsg.FrameDataCallbackHelper", "listenFrameChange recordView null");
          i = -1;
        }
        while (i < 0)
        {
          AppBrandCameraView.i(AppBrandCameraView.this).h(String.format(Locale.US, "illegal state:%d", new Object[] { Integer.valueOf(i) }), -1, -1, -1);
          AppMethodBeat.o(46150);
          return;
          if (locald.kLm == null)
          {
            i = -2;
          }
          else
          {
            if (locald.kLo != -2147483648)
            {
              ae.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange destroy last one bufferId:%d", new Object[] { Integer.valueOf(locald.kLo) });
              locald.kLm.ua(locald.kLo);
            }
            locald.kLo = locald.kLm.uc(j * k * 4);
            ae.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange bufferId:%d height:%d width:%d", new Object[] { Integer.valueOf(locald.kLo), Integer.valueOf(k), Integer.valueOf(j) });
            locald.kLn = true;
            localMMSightRecordView.a(locald.kLm.ub(locald.kLo), locald);
            i = locald.kLo;
          }
        }
        AppBrandCameraView.i(AppBrandCameraView.this).h(null, i, j, k);
        AppMethodBeat.o(46150);
      }
    };
    if (!this.kKW)
    {
      if (this.kKZ == null) {
        this.kKZ = new ArrayList();
      }
      this.kKZ.add(paramc);
      AppMethodBeat.o(46199);
      return;
    }
    paramc.run();
    AppMethodBeat.o(46199);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(46191);
    ae.i("MicroMsg.AppBrandCameraView", "onUIPause");
    Object localObject;
    if (this.kKR == 2)
    {
      ae.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(this.kKx));
      ((Map)localObject).put("errMsg", "stop on record");
      localObject = new JSONObject((Map)localObject).toString();
      new m().h(this.kKt).PQ((String)localObject).bja();
    }
    if (this.kKO != null)
    {
      localObject = this.kKO.getCurrentFramePicture();
      if (localObject != null) {
        this.dtJ.setImageBitmap((Bitmap)localObject);
      }
    }
    MMSightRecordView localMMSightRecordView;
    if (this.kKV != null)
    {
      localObject = this.kKV;
      localMMSightRecordView = this.kKO;
      ae.i("MicroMsg.FrameDataCallbackHelper", "onUIPause mNeedCallback:%b", new Object[] { Boolean.valueOf(((d)localObject).kLn) });
      if (localMMSightRecordView != null) {
        break label250;
      }
      ae.w("MicroMsg.FrameDataCallbackHelper", "onUIPause recordView null");
    }
    for (;;)
    {
      release();
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(getCameraId()));
      localObject = new JSONObject((Map)localObject).toString();
      new k().h(this.kKt).PQ((String)localObject).bja();
      AppMethodBeat.o(46191);
      return;
      label250:
      localMMSightRecordView.a(null, null);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(46193);
    if (this.kKV != null) {
      this.kKV.a(this.kKO);
    }
    release();
    this.kKY.compareAndSet(true, false);
    AppMethodBeat.o(46193);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(46192);
    ae.i("MicroMsg.AppBrandCameraView", "onUIResume");
    for (;;)
    {
      MMSightRecordView localMMSightRecordView;
      try
      {
        if (!this.kKY.get())
        {
          ae.w("MicroMsg.AppBrandCameraView", "no execute initView");
          return;
        }
        bkp();
        bkv();
        bku();
        d locald;
        if (this.kKV != null)
        {
          locald = this.kKV;
          localMMSightRecordView = this.kKO;
          ae.i("MicroMsg.FrameDataCallbackHelper", "onUIResume mNeedCallback:%b", new Object[] { Boolean.valueOf(locald.kLn) });
          if (locald.kLn)
          {
            if (localMMSightRecordView != null) {
              continue;
            }
            ae.w("MicroMsg.FrameDataCallbackHelper", "onUIResume recordView null");
          }
        }
        return;
        if (locald.kLo == -2147483648)
        {
          ae.w("MicroMsg.FrameDataCallbackHelper", "onUIResume invalid mCurrentSharedBufferId");
          continue;
        }
        if (localf.kLm != null) {
          break label180;
        }
      }
      finally
      {
        AppMethodBeat.o(46192);
      }
      ae.w("MicroMsg.FrameDataCallbackHelper", "onUIResume mSharedBufferAddon null");
      continue;
      label180:
      localMMSightRecordView.a(localf.kLm.ub(localf.kLo), localf);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(46194);
    ae.i("MicroMsg.AppBrandCameraView", "release");
    try
    {
      if (this.kKO != null)
      {
        this.kKO.vYV.release();
        removeView(this.kKO);
        this.kKR = -1;
        this.kKO.setFrameDataCallback(null);
        this.kKO.setInitErrorCallback(null);
        this.kKO.setInitDoneCallback(null);
        this.kKO = null;
      }
      if (this.dtJ != null) {
        this.dtJ.setImageBitmap(null);
      }
      if (this.kKZ != null) {
        this.kKZ.clear();
      }
      this.kKX = 0.0F;
      bkw();
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
    this.kKx = paramInt;
  }
  
  public void setCompressRecord(boolean paramBoolean)
  {
    this.kKC = paramBoolean;
  }
  
  public void setDisplayScreenSize(Size paramSize)
  {
    AppMethodBeat.i(222426);
    if ((paramSize == null) || (paramSize.getHeight() <= 0) || (paramSize.getWidth() <= 0))
    {
      AppMethodBeat.o(222426);
      return;
    }
    this.kKL = paramSize;
    AppMethodBeat.o(222426);
  }
  
  public void setFlash(String paramString)
  {
    AppMethodBeat.i(46187);
    if (bu.lX(this.kKy, paramString))
    {
      AppMethodBeat.o(46187);
      return;
    }
    this.kKy = paramString;
    AppMethodBeat.o(46187);
  }
  
  public void setFrameLimitSize(int paramInt)
  {
    AppMethodBeat.i(46185);
    ae.i("MicroMsg.AppBrandCameraView", "setFrameLimitSize:%d", new Object[] { Integer.valueOf(paramInt) });
    this.kKv = paramInt;
    AppMethodBeat.o(46185);
  }
  
  public void setMode(String paramString)
  {
    this.kKu = paramString;
  }
  
  public void setNeedOutput(boolean paramBoolean)
  {
    this.kKD = paramBoolean;
  }
  
  public void setOperateCallBack(c paramc)
  {
    this.kKM = paramc;
  }
  
  public void setOutPutCallBack(b paramb)
  {
    this.kKN = paramb;
  }
  
  public void setPage(e parame)
  {
    this.kKt = parame;
  }
  
  public void setPreviewCenterCrop(boolean paramBoolean)
  {
    this.kKB = paramBoolean;
  }
  
  public void setQuality(String paramString)
  {
    AppMethodBeat.i(46188);
    if (bu.lX(this.kKz, paramString))
    {
      AppMethodBeat.o(46188);
      return;
    }
    this.kKz = paramString;
    AppMethodBeat.o(46188);
  }
  
  public void setResolution(String paramString)
  {
    AppMethodBeat.i(46189);
    if (bu.lX(this.kKA, paramString))
    {
      AppMethodBeat.o(46189);
      return;
    }
    ae.i("MicroMsg.AppBrandCameraView", "setPreviewResolution: %s", new Object[] { paramString });
    this.kKA = paramString;
    AppMethodBeat.o(46189);
  }
  
  public void setScanFreq(int paramInt)
  {
    AppMethodBeat.i(46207);
    ae.i("MicroMsg.AppBrandCameraView", "scanFreq:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ae.e("MicroMsg.AppBrandCameraView", "scanFreq is err");
      AppMethodBeat.o(46207);
      return;
    }
    this.kKK = paramInt;
    AppMethodBeat.o(46207);
  }
  
  public final void x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(46208);
    ae.i("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((paramInt3 <= 0) || (paramInt4 <= 0))
    {
      AppMethodBeat.o(46208);
      return;
    }
    this.kKJ = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    AppMethodBeat.o(46208);
  }
  
  public static abstract interface a
  {
    public abstract void bko();
    
    public abstract void bkx();
    
    public abstract void bky();
    
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
      if (!o.fB(paramString))
      {
        ae.i("MicroMsg.AppBrandCameraView", "getInfoFromMetaData file isn't exist, filename: %s", new Object[] { paramString });
        AppMethodBeat.o(46166);
        return;
      }
      try
      {
        com.tencent.mm.compatible.h.d locald = new com.tencent.mm.compatible.h.d();
        try
        {
          locald.setDataSource(paramString);
          paramArrayOfInt[0] = bu.getInt(locald.extractMetadata(9), 0);
          int i = bu.getInt(locald.extractMetadata(24), 0);
          if ((i == 90) || (i == 270))
          {
            paramArrayOfInt[1] = bu.getInt(locald.extractMetadata(19), 0);
            paramArrayOfInt[2] = bu.getInt(locald.extractMetadata(18), 0);
          }
          for (;;)
          {
            locald.release();
            AppMethodBeat.o(46166);
            return;
            paramArrayOfInt[1] = bu.getInt(locald.extractMetadata(18), 0);
            paramArrayOfInt[2] = bu.getInt(locald.extractMetadata(19), 0);
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
        l = o.aZR(paramString3);
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
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(46167);
        return paramString;
      }
      com.tencent.mm.plugin.appbrand.y.i locali = new com.tencent.mm.plugin.appbrand.y.i();
      if (paramc.Fl().a(new com.tencent.mm.vfs.k(paramString), "", true, locali) == com.tencent.mm.plugin.appbrand.appstorage.m.jPM)
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
            com.tencent.mm.sdk.platformtools.h.a(paramBitmap, i, Bitmap.CompressFormat.JPEG, paramString, true);
            ae.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", new Object[] { Long.valueOf(o.aZR(paramString)) });
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
          ae.e("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", new Object[] { paramBitmap.getMessage() });
        }
      }
      return false;
    }
    
    final void bkC()
    {
      AppMethodBeat.i(46163);
      AppBrandCameraView.x(AppBrandCameraView.this);
      AppBrandCameraView.a(AppBrandCameraView.this, false);
      AppMethodBeat.o(46163);
    }
    
    public final void bko()
    {
      AppMethodBeat.i(46158);
      ae.i("MicroMsg.AppBrandCameraView", "takePicture.");
      if (AppBrandCameraView.e(AppBrandCameraView.this) == null)
      {
        ae.i("MicroMsg.AppBrandCameraView", "recordView is null");
        AppMethodBeat.o(46158);
        return;
      }
      if (AppBrandCameraView.k(AppBrandCameraView.this) == 2)
      {
        ae.w("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
        AppMethodBeat.o(46158);
        return;
      }
      if ((AppBrandCameraView.l(AppBrandCameraView.this)) || (bu.aO(AppBrandCameraView.m(AppBrandCameraView.this)) < 300L))
      {
        ae.i("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
        AppMethodBeat.o(46158);
        return;
      }
      if (!AppBrandCameraView.n(AppBrandCameraView.this))
      {
        ae.w("MicroMsg.AppBrandCameraView", "takePicture err, isn't init done");
        AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "camera has not been initialized");
        AppMethodBeat.o(46158);
        return;
      }
      AppBrandCameraView.a(AppBrandCameraView.this, bu.HQ());
      AppBrandCameraView.o(AppBrandCameraView.this);
      AppBrandCameraView.a(AppBrandCameraView.this, 3);
      AppBrandCameraView.e(AppBrandCameraView.this).a(new MMSightRecordView.g()
      {
        public final void O(Bitmap paramAnonymousBitmap)
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
        
        public final void bkD()
        {
          AppMethodBeat.i(46152);
          AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "take picture error");
          AppMethodBeat.o(46152);
        }
      }, "on".equals(AppBrandCameraView.q(AppBrandCameraView.this)));
      AppMethodBeat.o(46158);
    }
    
    public final void bkx()
    {
      AppMethodBeat.i(46160);
      ae.i("MicroMsg.AppBrandCameraView", "startRecord.");
      a locala = a.a.bkm();
      if ((!locala.kKp) || (!locala.kKq)) {
        ae.i("MicroMsg.AppBrandCameraMrg", "no all permission");
      }
      if ((locala.kKp) && (locala.kKq)) {}
      for (int i = 1; i == 0; i = 0)
      {
        Toast.makeText(AppBrandCameraView.s(AppBrandCameraView.this), 2131761241, 1).show();
        ae.w("MicroMsg.AppBrandCameraView", "no micro phone permission");
        ag(-1, "permission");
        AppMethodBeat.o(46160);
        return;
      }
      if (AppBrandCameraView.k(AppBrandCameraView.this) == 2)
      {
        ae.w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
        ag(-1, "is recording");
        AppMethodBeat.o(46160);
        return;
      }
      if (!AppBrandCameraView.n(AppBrandCameraView.this))
      {
        ae.w("MicroMsg.AppBrandCameraView", "startRecord err, isn't init done");
        ag(-1, "camera has not been initialized");
        AppMethodBeat.o(46160);
        return;
      }
      if (AppBrandCameraView.e(AppBrandCameraView.this).vYV.PO())
      {
        AppBrandCameraView.b(AppBrandCameraView.this, bu.HQ());
        AppBrandCameraView.a(AppBrandCameraView.this, 2);
        ag(0, "");
        AppBrandCameraView.t(AppBrandCameraView.this);
        AppMethodBeat.o(46160);
        return;
      }
      ae.w("MicroMsg.AppBrandCameraView", "startRecord fail !!");
      ag(-1, "startRecord fail");
      AppMethodBeat.o(46160);
    }
    
    public final void bky()
    {
      AppMethodBeat.i(46165);
      long l = bu.aO(AppBrandCameraView.y(AppBrandCameraView.this));
      if (l < 1500L)
      {
        ae.i("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", new Object[] { Long.valueOf(1500L - l) });
        ar.o(new Runnable()
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
      ae.i("MicroMsg.AppBrandCameraView", "stopRecord");
      if (AppBrandCameraView.e(AppBrandCameraView.this) == null)
      {
        ae.i("MicroMsg.AppBrandCameraView", "recordView is null");
        d(-1, "camera is null", null, null);
        AppMethodBeat.o(46162);
        return;
      }
      if (AppBrandCameraView.k(AppBrandCameraView.this) != 2)
      {
        ae.w("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
        d(-1, "is not recording", null, null);
        AppMethodBeat.o(46162);
        return;
      }
      if (AppBrandCameraView.u(AppBrandCameraView.this))
      {
        ae.i("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
        d(-1, "is stopping", null, null);
        AppMethodBeat.o(46162);
        return;
      }
      AppBrandCameraView.a(AppBrandCameraView.this, true);
      AppBrandCameraView.e(AppBrandCameraView.this).a(new MMSightRecordView.h()
      {
        public final void gu(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(46153);
          ae.i("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (AppBrandCameraView.e(AppBrandCameraView.this) == null)
          {
            ae.i("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
            AppBrandCameraView.b.a(AppBrandCameraView.b.this, "camera is null");
            AppMethodBeat.o(46153);
            return;
          }
          AppBrandCameraView.this.kKR = 1;
          if (paramAnonymousBoolean)
          {
            AppBrandCameraView.b.a(AppBrandCameraView.b.this, "stop error");
            AppBrandCameraView.b.this.bkC();
            AppMethodBeat.o(46153);
            return;
          }
          if (AppBrandCameraView.v(AppBrandCameraView.this))
          {
            AppBrandCameraView.b localb = AppBrandCameraView.b.this;
            com.tencent.e.h.MqF.aO(new AppBrandCameraView.b.3(localb));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView
 * JD-Core Version:    0.7.0.1
 */