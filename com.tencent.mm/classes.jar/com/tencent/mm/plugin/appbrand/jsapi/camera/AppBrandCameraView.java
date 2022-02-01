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
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private String cjm;
  private ImageView dhf;
  private String hcV;
  private String kmA;
  private String kmB;
  int kmC;
  private boolean kmD;
  private long kmE;
  private long kmF;
  private d kmG;
  private boolean kmH;
  private float kmI;
  private AtomicBoolean kmJ;
  private List<Runnable> kmK;
  private com.tencent.mm.plugin.appbrand.jsapi.c kme;
  private String kmf;
  private int kmg;
  private a kmh;
  private int kmi;
  private String kmj;
  private String kmk;
  private String kml;
  private boolean kmm;
  private boolean kmn;
  private boolean kmo;
  private boolean kmp;
  private int kmq;
  private int kmr;
  private int kms;
  private int kmt;
  private Rect kmu;
  private int kmv;
  private Size kmw;
  private c kmx;
  private b kmy;
  private MMSightRecordView kmz;
  private String mAppId;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(46215);
    g.aVl();
    AppMethodBeat.o(46215);
  }
  
  public AppBrandCameraView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(46180);
    this.kmf = "scanCode";
    this.cjm = "back";
    this.kmj = "auto";
    this.kmk = "high";
    this.kmm = false;
    this.kmn = false;
    this.kmp = false;
    this.kmq = 1080;
    this.kmr = 1920;
    this.kms = 1080;
    this.kmt = 1920;
    this.kmC = -1;
    this.kmD = false;
    this.kmE = -1L;
    this.kmF = -1L;
    this.kmJ = new AtomicBoolean(false);
    init(paramContext);
    AppMethodBeat.o(46180);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(46181);
    this.kmf = "scanCode";
    this.cjm = "back";
    this.kmj = "auto";
    this.kmk = "high";
    this.kmm = false;
    this.kmn = false;
    this.kmp = false;
    this.kmq = 1080;
    this.kmr = 1920;
    this.kms = 1080;
    this.kmt = 1920;
    this.kmC = -1;
    this.kmD = false;
    this.kmE = -1L;
    this.kmF = -1L;
    this.kmJ = new AtomicBoolean(false);
    init(paramContext);
    AppMethodBeat.o(46181);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(46182);
    this.kmf = "scanCode";
    this.cjm = "back";
    this.kmj = "auto";
    this.kmk = "high";
    this.kmm = false;
    this.kmn = false;
    this.kmp = false;
    this.kmq = 1080;
    this.kmr = 1920;
    this.kms = 1080;
    this.kmt = 1920;
    this.kmC = -1;
    this.kmD = false;
    this.kmE = -1L;
    this.kmF = -1L;
    this.kmJ = new AtomicBoolean(false);
    init(paramContext);
    AppMethodBeat.o(46182);
  }
  
  public static void bga()
  {
    AppMethodBeat.i(46179);
    l.kne = new l.a() {};
    AppMethodBeat.o(46179);
  }
  
  private void bgc()
  {
    int j = 0;
    AppMethodBeat.i(46197);
    ac.i("MicroMsg.AppBrandCameraView", "initCamera.");
    if (!a.a.bfZ().bfY())
    {
      Toast.makeText(this.mContext, 2131761241, 1).show();
      ac.w("MicroMsg.AppBrandCameraView", "no permission");
      AppMethodBeat.o(46197);
      return;
    }
    if (this.kmz != null)
    {
      ac.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
      AppMethodBeat.o(46197);
      return;
    }
    Object localObject = a.a.bfZ().bfX();
    int i;
    if (localObject.length > 0)
    {
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        int m = localObject[i];
        if (m != this.kmi)
        {
          a.a.bfZ().I(m, false);
          ac.i("MicroMsg.AppBrandCameraView", "release camera before init new camera, id: %d", new Object[] { Integer.valueOf(m) });
        }
        i += 1;
      }
    }
    if (this.dhf == null)
    {
      this.dhf = new ImageView(this.mContext);
      this.dhf.setScaleType(ImageView.ScaleType.FIT_XY);
      addView(this.dhf, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      this.kmz = e(this.mContext, this.kmq, this.kmr);
      if (this.kmz == null) {
        this.kmz = new MMSightRecordView(this.mContext);
      }
      this.kmH = false;
      addView(this.kmz);
      bgm();
      this.kmz.setRGBSizeLimit(this.kmg);
      this.kmz.uJM.aSg();
      this.kmz.setDisplayRatio(this.kmq * 1.0F / this.kmr);
      localObject = this.kmz;
      i = j;
      if (this.kmm) {
        i = 1;
      }
      ((MMSightRecordView)localObject).setPreviewMode(i);
      this.kmz.setVideoPara$2e715812(600000);
      this.kmz.setVideoFilePath(this.kmA);
      this.kmz.setClipPictureSize(true);
      this.kmz.setClipVideoSize(true);
      this.kmz.setDisplayScreenSize(this.kmw);
      this.kmz.setUseBackCamera("back".equals(this.cjm));
      this.kmz.setFrameDataCallback(new MMSightRecordView.a()
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
      this.kmz.setInitErrorCallback(new MMSightRecordView.d()
      {
        public final void bgn()
        {
          AppMethodBeat.i(46148);
          ac.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
          Object localObject = new HashMap();
          ((Map)localObject).put("cameraId", Integer.valueOf(AppBrandCameraView.b(AppBrandCameraView.this)));
          localObject = new JSONObject((Map)localObject).toString();
          new i().h(AppBrandCameraView.c(AppBrandCameraView.this)).LO((String)localObject).beN();
          AppMethodBeat.o(46148);
        }
      });
      this.kmz.setInitDoneCallback(new MMSightRecordView.c()
      {
        public final void bgo()
        {
          AppMethodBeat.i(46149);
          AppBrandCameraView.d(AppBrandCameraView.this);
          ac.i("MicroMsg.AppBrandCameraView", "InitDoneCallback");
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
          localh.LO(new JSONObject(localHashMap).toString());
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
      this.kmz.uJM.startPreview();
      this.kmz.uJM.aSa();
      this.kmC = 1;
      AppMethodBeat.o(46197);
      return;
      this.dhf.setImageBitmap(null);
    }
  }
  
  private void bgf()
  {
    AppMethodBeat.i(46201);
    this.hcV = (com.tencent.mm.loader.j.b.aps() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    AppMethodBeat.o(46201);
  }
  
  private void bgg()
  {
    AppMethodBeat.i(46202);
    String str = "MicroMsg_" + System.currentTimeMillis();
    if (!com.tencent.mm.vfs.i.eA(com.tencent.mm.loader.j.b.apf())) {
      com.tencent.mm.vfs.i.aSh(com.tencent.mm.loader.j.b.apf());
    }
    this.kmA = (com.tencent.mm.loader.j.b.apf() + str + ".mp4");
    this.kmB = (com.tencent.mm.loader.j.b.apf() + str + ".jpeg");
    if (this.kmz != null) {
      this.kmz.setVideoFilePath(this.kmA);
    }
    AppMethodBeat.o(46202);
  }
  
  private void bgh()
  {
    AppMethodBeat.i(46203);
    if ((this.kmz == null) || (this.kmj == null))
    {
      AppMethodBeat.o(46203);
      return;
    }
    if (this.kmj.equals("auto"))
    {
      this.kmz.setFlashMode(3);
      AppMethodBeat.o(46203);
      return;
    }
    if (this.kmj.equals("torch"))
    {
      this.kmz.setFlashMode(1);
      AppMethodBeat.o(46203);
      return;
    }
    if (this.kmj.equals("on"))
    {
      if ((this.kmC == 2) || (this.kmC == 4) || (!this.kmj.equals("on")))
      {
        this.kmz.setFlashMode(1);
        AppMethodBeat.o(46203);
      }
    }
    else if (this.kmj.equals("torch"))
    {
      this.kmz.setFlashMode(1);
      AppMethodBeat.o(46203);
      return;
    }
    this.kmz.setFlashMode(2);
    AppMethodBeat.o(46203);
  }
  
  private void bgi()
  {
    AppMethodBeat.i(46204);
    ac.i("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", new Object[] { this.kmf });
    bgj();
    this.kmh = Md(this.kmf);
    this.kmh.init();
    AppMethodBeat.o(46204);
  }
  
  private void bgj()
  {
    AppMethodBeat.i(46206);
    if (this.kmh != null)
    {
      this.kmh.release();
      this.kmh = null;
    }
    AppMethodBeat.o(46206);
  }
  
  private void bgm()
  {
    int j = 720;
    AppMethodBeat.i(46211);
    int i = j;
    String str;
    if (!bs.isNullOrNil(this.kml))
    {
      str = this.kml;
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
      if (this.kmg > i)
      {
        ac.i("MicroMsg.AppBrandCameraView", "framesize is : %d, large than preview size: %d", new Object[] { Integer.valueOf(this.kmg), Integer.valueOf(i) });
        j = this.kmg;
      }
      this.kmz.setPreviewSizeLimit(j);
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
    this.kmJ.set(false);
    LayoutInflater.from(paramContext).inflate(2131492976, this);
    AppMethodBeat.o(46183);
  }
  
  protected a Md(String paramString)
  {
    AppMethodBeat.i(46205);
    if ((!bs.isNullOrNil(paramString)) && (paramString.equals("scanCode"))) {}
    for (paramString = new c();; paramString = new b((byte)0))
    {
      AppMethodBeat.o(46205);
      return paramString;
    }
  }
  
  public final void ao(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46186);
    if (bs.lr(this.cjm, paramString))
    {
      AppMethodBeat.o(46186);
      return;
    }
    if (bs.lr(this.kmf, "scanCode"))
    {
      AppMethodBeat.o(46186);
      return;
    }
    this.cjm = paramString;
    if ((!paramBoolean) && (this.kmz != null)) {
      this.kmz.uJM.switchCamera();
    }
    AppMethodBeat.o(46186);
  }
  
  public final float aw(float paramFloat)
  {
    AppMethodBeat.i(46196);
    if (this.kmz != null)
    {
      if (paramFloat < 1.0F)
      {
        AppMethodBeat.o(46196);
        return paramFloat;
      }
      float f = paramFloat;
      if (paramFloat > this.kmI) {}
      for (f = this.kmI; (!this.kmz.uJM.aq(f)) && (f > 0.0F); f -= 0.1F) {}
      AppMethodBeat.o(46196);
      return f;
    }
    AppMethodBeat.o(46196);
    return 0.0F;
  }
  
  public final void bgb()
  {
    AppMethodBeat.i(46195);
    if (this.kmh != null) {
      this.kmh.bgb();
    }
    AppMethodBeat.o(46195);
  }
  
  public final void bgd()
  {
    AppMethodBeat.i(46198);
    if (this.kmz == null)
    {
      ac.i("MicroMsg.AppBrandCameraView", "recordView is null");
      AppMethodBeat.o(46198);
      return;
    }
    bgi();
    bgh();
    AppMethodBeat.o(46198);
  }
  
  public final void bge()
  {
    AppMethodBeat.i(46200);
    if (this.kmx == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    if (this.kmG == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    this.kmG.a(this.kmz);
    this.kmG = null;
    AppMethodBeat.o(46200);
  }
  
  public final void bgk()
  {
    AppMethodBeat.i(46209);
    if (this.kmh != null) {
      this.kmh.bgk();
    }
    AppMethodBeat.o(46209);
  }
  
  public final void bgl()
  {
    AppMethodBeat.i(46210);
    if (this.kmh != null) {
      this.kmh.bgl();
    }
    AppMethodBeat.o(46210);
  }
  
  public final boolean dM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46190);
    if ((this.kmq == paramInt1) && (this.kmr == paramInt2))
    {
      AppMethodBeat.o(46190);
      return false;
    }
    ac.i("MicroMsg.AppBrandCameraView", "setViewSize");
    this.kmq = paramInt1;
    this.kmr = paramInt2;
    AppMethodBeat.o(46190);
    return true;
  }
  
  protected MMSightRecordView e(Context paramContext, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public int getCameraId()
  {
    return this.kmi;
  }
  
  protected MMSightRecordView getRecordView()
  {
    return this.kmz;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(46184);
    ac.i("MicroMsg.AppBrandCameraView", "initView");
    if (!a.a.bfZ().bfY())
    {
      AppMethodBeat.o(46184);
      return;
    }
    bgg();
    bgf();
    bgc();
    bgd();
    this.kmJ.compareAndSet(false, true);
    AppMethodBeat.o(46184);
  }
  
  public final void o(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(46199);
    ac.i("MicroMsg.AppBrandCameraView", "listenFrameChange");
    if (this.kmx == null)
    {
      AppMethodBeat.o(46199);
      return;
    }
    if (this.kmz == null)
    {
      ac.w("MicroMsg.AppBrandCameraView", "listenFrameChange recordView null");
      this.kmx.h("camera illegal state", -1, -1, -1);
      AppMethodBeat.o(46199);
      return;
    }
    if (this.kmG == null) {
      this.kmG = new d(paramc);
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
          ac.w("MicroMsg.FrameDataCallbackHelper", "listenFrameChange recordView null");
          i = -1;
        }
        while (i < 0)
        {
          AppBrandCameraView.i(AppBrandCameraView.this).h(String.format(Locale.US, "illegal state:%d", new Object[] { Integer.valueOf(i) }), -1, -1, -1);
          AppMethodBeat.o(46150);
          return;
          if (locald.kmX == null)
          {
            i = -2;
          }
          else
          {
            if (locald.kmZ != -2147483648)
            {
              ac.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange destroy last one bufferId:%d", new Object[] { Integer.valueOf(locald.kmZ) });
              locald.kmX.tr(locald.kmZ);
            }
            locald.kmZ = locald.kmX.tt(j * k * 4);
            ac.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange bufferId:%d height:%d width:%d", new Object[] { Integer.valueOf(locald.kmZ), Integer.valueOf(k), Integer.valueOf(j) });
            locald.kmY = true;
            localMMSightRecordView.a(locald.kmX.ts(locald.kmZ), locald);
            i = locald.kmZ;
          }
        }
        AppBrandCameraView.i(AppBrandCameraView.this).h(null, i, j, k);
        AppMethodBeat.o(46150);
      }
    };
    if (!this.kmH)
    {
      if (this.kmK == null) {
        this.kmK = new ArrayList();
      }
      this.kmK.add(paramc);
      AppMethodBeat.o(46199);
      return;
    }
    paramc.run();
    AppMethodBeat.o(46199);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(46191);
    ac.i("MicroMsg.AppBrandCameraView", "onUIPause");
    Object localObject;
    if (this.kmC == 2)
    {
      ac.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(this.kmi));
      ((Map)localObject).put("errMsg", "stop on record");
      localObject = new JSONObject((Map)localObject).toString();
      new m().h(this.kme).LO((String)localObject).beN();
    }
    if (this.kmz != null)
    {
      localObject = this.kmz.getCurrentFramePicture();
      if (localObject != null) {
        this.dhf.setImageBitmap((Bitmap)localObject);
      }
    }
    MMSightRecordView localMMSightRecordView;
    if (this.kmG != null)
    {
      localObject = this.kmG;
      localMMSightRecordView = this.kmz;
      ac.i("MicroMsg.FrameDataCallbackHelper", "onUIPause mNeedCallback:%b", new Object[] { Boolean.valueOf(((d)localObject).kmY) });
      if (localMMSightRecordView != null) {
        break label250;
      }
      ac.w("MicroMsg.FrameDataCallbackHelper", "onUIPause recordView null");
    }
    for (;;)
    {
      release();
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(getCameraId()));
      localObject = new JSONObject((Map)localObject).toString();
      new k().h(this.kme).LO((String)localObject).beN();
      AppMethodBeat.o(46191);
      return;
      label250:
      localMMSightRecordView.a(null, null);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(46193);
    if (this.kmG != null) {
      this.kmG.a(this.kmz);
    }
    release();
    this.kmJ.compareAndSet(true, false);
    AppMethodBeat.o(46193);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(46192);
    ac.i("MicroMsg.AppBrandCameraView", "onUIResume");
    for (;;)
    {
      MMSightRecordView localMMSightRecordView;
      try
      {
        if (!this.kmJ.get())
        {
          ac.w("MicroMsg.AppBrandCameraView", "no execute initView");
          return;
        }
        bgc();
        bgi();
        bgh();
        d locald;
        if (this.kmG != null)
        {
          locald = this.kmG;
          localMMSightRecordView = this.kmz;
          ac.i("MicroMsg.FrameDataCallbackHelper", "onUIResume mNeedCallback:%b", new Object[] { Boolean.valueOf(locald.kmY) });
          if (locald.kmY)
          {
            if (localMMSightRecordView != null) {
              continue;
            }
            ac.w("MicroMsg.FrameDataCallbackHelper", "onUIResume recordView null");
          }
        }
        return;
        if (locald.kmZ == -2147483648)
        {
          ac.w("MicroMsg.FrameDataCallbackHelper", "onUIResume invalid mCurrentSharedBufferId");
          continue;
        }
        if (localf.kmX != null) {
          break label180;
        }
      }
      finally
      {
        AppMethodBeat.o(46192);
      }
      ac.w("MicroMsg.FrameDataCallbackHelper", "onUIResume mSharedBufferAddon null");
      continue;
      label180:
      localMMSightRecordView.a(localf.kmX.ts(localf.kmZ), localf);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(46194);
    ac.i("MicroMsg.AppBrandCameraView", "release");
    try
    {
      if (this.kmz != null)
      {
        this.kmz.uJM.release();
        removeView(this.kmz);
        this.kmC = -1;
        this.kmz.setFrameDataCallback(null);
        this.kmz.setInitErrorCallback(null);
        this.kmz.setInitDoneCallback(null);
        this.kmz = null;
      }
      if (this.dhf != null) {
        this.dhf.setImageBitmap(null);
      }
      if (this.kmK != null) {
        this.kmK.clear();
      }
      this.kmI = 0.0F;
      bgj();
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
    this.kmi = paramInt;
  }
  
  public void setCompressRecord(boolean paramBoolean)
  {
    this.kmn = paramBoolean;
  }
  
  public void setDisplayScreenSize(Size paramSize)
  {
    AppMethodBeat.i(186580);
    if ((paramSize == null) || (paramSize.getHeight() <= 0) || (paramSize.getWidth() <= 0))
    {
      AppMethodBeat.o(186580);
      return;
    }
    this.kmw = paramSize;
    AppMethodBeat.o(186580);
  }
  
  public void setFlash(String paramString)
  {
    AppMethodBeat.i(46187);
    if (bs.lr(this.kmj, paramString))
    {
      AppMethodBeat.o(46187);
      return;
    }
    this.kmj = paramString;
    AppMethodBeat.o(46187);
  }
  
  public void setFrameLimitSize(int paramInt)
  {
    AppMethodBeat.i(46185);
    ac.i("MicroMsg.AppBrandCameraView", "setFrameLimitSize:%d", new Object[] { Integer.valueOf(paramInt) });
    this.kmg = paramInt;
    AppMethodBeat.o(46185);
  }
  
  public void setMode(String paramString)
  {
    this.kmf = paramString;
  }
  
  public void setNeedOutput(boolean paramBoolean)
  {
    this.kmo = paramBoolean;
  }
  
  public void setOperateCallBack(c paramc)
  {
    this.kmx = paramc;
  }
  
  public void setOutPutCallBack(b paramb)
  {
    this.kmy = paramb;
  }
  
  public void setPage(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    this.kme = parame;
  }
  
  public void setPreviewCenterCrop(boolean paramBoolean)
  {
    this.kmm = paramBoolean;
  }
  
  public void setQuality(String paramString)
  {
    AppMethodBeat.i(46188);
    if (bs.lr(this.kmk, paramString))
    {
      AppMethodBeat.o(46188);
      return;
    }
    this.kmk = paramString;
    AppMethodBeat.o(46188);
  }
  
  public void setResolution(String paramString)
  {
    AppMethodBeat.i(46189);
    if (bs.lr(this.kml, paramString))
    {
      AppMethodBeat.o(46189);
      return;
    }
    ac.i("MicroMsg.AppBrandCameraView", "setPreviewResolution: %s", new Object[] { paramString });
    this.kml = paramString;
    AppMethodBeat.o(46189);
  }
  
  public void setScanFreq(int paramInt)
  {
    AppMethodBeat.i(46207);
    ac.i("MicroMsg.AppBrandCameraView", "scanFreq:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ac.e("MicroMsg.AppBrandCameraView", "scanFreq is err");
      AppMethodBeat.o(46207);
      return;
    }
    this.kmv = paramInt;
    AppMethodBeat.o(46207);
  }
  
  public final void w(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(46208);
    ac.i("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((paramInt3 <= 0) || (paramInt4 <= 0))
    {
      AppMethodBeat.o(46208);
      return;
    }
    this.kmu = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    AppMethodBeat.o(46208);
  }
  
  public static abstract interface a
  {
    public abstract void bgb();
    
    public abstract void bgk();
    
    public abstract void bgl();
    
    public abstract void init();
    
    public abstract void release();
    
    public abstract void s(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  final class b
    implements AppBrandCameraView.a
  {
    private b() {}
    
    private void ae(int paramInt, String paramString)
    {
      AppMethodBeat.i(46161);
      if (AppBrandCameraView.i(AppBrandCameraView.this) != null) {
        AppBrandCameraView.i(AppBrandCameraView.this).ae(paramInt, paramString);
      }
      AppMethodBeat.o(46161);
    }
    
    private static void c(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(46166);
      if (!com.tencent.mm.vfs.i.eA(paramString))
      {
        ac.i("MicroMsg.AppBrandCameraView", "getInfoFromMetaData file isn't exist, filename: %s", new Object[] { paramString });
        AppMethodBeat.o(46166);
        return;
      }
      try
      {
        com.tencent.mm.compatible.h.d locald = new com.tencent.mm.compatible.h.d();
        try
        {
          locald.setDataSource(paramString);
          paramArrayOfInt[0] = bs.getInt(locald.extractMetadata(9), 0);
          int i = bs.getInt(locald.extractMetadata(24), 0);
          if ((i == 90) || (i == 270))
          {
            paramArrayOfInt[1] = bs.getInt(locald.extractMetadata(19), 0);
            paramArrayOfInt[2] = bs.getInt(locald.extractMetadata(18), 0);
          }
          for (;;)
          {
            locald.release();
            AppMethodBeat.o(46166);
            return;
            paramArrayOfInt[1] = bs.getInt(locald.extractMetadata(18), 0);
            paramArrayOfInt[2] = bs.getInt(locald.extractMetadata(19), 0);
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
        l = com.tencent.mm.vfs.i.aSp(paramString3);
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
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(46167);
        return paramString;
      }
      com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
      if (paramc.DH().a(new com.tencent.mm.vfs.e(paramString), "", true, locali) == com.tencent.mm.plugin.appbrand.appstorage.l.jsB)
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
            ac.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aSp(paramString)) });
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
          ac.e("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", new Object[] { paramBitmap.getMessage() });
        }
      }
      return false;
    }
    
    public final void bgb()
    {
      AppMethodBeat.i(46158);
      ac.i("MicroMsg.AppBrandCameraView", "takePicture.");
      if (AppBrandCameraView.e(AppBrandCameraView.this) == null)
      {
        ac.i("MicroMsg.AppBrandCameraView", "recordView is null");
        AppMethodBeat.o(46158);
        return;
      }
      if (AppBrandCameraView.k(AppBrandCameraView.this) == 2)
      {
        ac.w("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
        AppMethodBeat.o(46158);
        return;
      }
      if ((AppBrandCameraView.l(AppBrandCameraView.this)) || (bs.aO(AppBrandCameraView.m(AppBrandCameraView.this)) < 300L))
      {
        ac.i("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
        AppMethodBeat.o(46158);
        return;
      }
      if (!AppBrandCameraView.n(AppBrandCameraView.this))
      {
        ac.w("MicroMsg.AppBrandCameraView", "takePicture err, isn't init done");
        AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "camera has not been initialized");
        AppMethodBeat.o(46158);
        return;
      }
      AppBrandCameraView.a(AppBrandCameraView.this, bs.Gn());
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
        
        public final void bgq()
        {
          AppMethodBeat.i(46152);
          AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "take picture error");
          AppMethodBeat.o(46152);
        }
      }, "on".equals(AppBrandCameraView.q(AppBrandCameraView.this)));
      AppMethodBeat.o(46158);
    }
    
    public final void bgk()
    {
      AppMethodBeat.i(46160);
      ac.i("MicroMsg.AppBrandCameraView", "startRecord.");
      a locala = a.a.bfZ();
      if ((!locala.kma) || (!locala.kmb)) {
        ac.i("MicroMsg.AppBrandCameraMrg", "no all permission");
      }
      if ((locala.kma) && (locala.kmb)) {}
      for (int i = 1; i == 0; i = 0)
      {
        Toast.makeText(AppBrandCameraView.s(AppBrandCameraView.this), 2131761241, 1).show();
        ac.w("MicroMsg.AppBrandCameraView", "no micro phone permission");
        ae(-1, "permission");
        AppMethodBeat.o(46160);
        return;
      }
      if (AppBrandCameraView.k(AppBrandCameraView.this) == 2)
      {
        ac.w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
        ae(-1, "is recording");
        AppMethodBeat.o(46160);
        return;
      }
      if (!AppBrandCameraView.n(AppBrandCameraView.this))
      {
        ac.w("MicroMsg.AppBrandCameraView", "startRecord err, isn't init done");
        ae(-1, "camera has not been initialized");
        AppMethodBeat.o(46160);
        return;
      }
      if (AppBrandCameraView.e(AppBrandCameraView.this).uJM.Og())
      {
        AppBrandCameraView.b(AppBrandCameraView.this, bs.Gn());
        AppBrandCameraView.a(AppBrandCameraView.this, 2);
        ae(0, "");
        AppBrandCameraView.t(AppBrandCameraView.this);
        AppMethodBeat.o(46160);
        return;
      }
      ac.w("MicroMsg.AppBrandCameraView", "startRecord fail !!");
      ae(-1, "startRecord fail");
      AppMethodBeat.o(46160);
    }
    
    public final void bgl()
    {
      AppMethodBeat.i(46165);
      long l = bs.aO(AppBrandCameraView.y(AppBrandCameraView.this));
      if (l < 1500L)
      {
        ac.i("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", new Object[] { Long.valueOf(1500L - l) });
        ap.n(new Runnable()
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
    
    final void bgp()
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
      ac.i("MicroMsg.AppBrandCameraView", "stopRecord");
      if (AppBrandCameraView.e(AppBrandCameraView.this) == null)
      {
        ac.i("MicroMsg.AppBrandCameraView", "recordView is null");
        d(-1, "camera is null", null, null);
        AppMethodBeat.o(46162);
        return;
      }
      if (AppBrandCameraView.k(AppBrandCameraView.this) != 2)
      {
        ac.w("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
        d(-1, "is not recording", null, null);
        AppMethodBeat.o(46162);
        return;
      }
      if (AppBrandCameraView.u(AppBrandCameraView.this))
      {
        ac.i("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
        d(-1, "is stopping", null, null);
        AppMethodBeat.o(46162);
        return;
      }
      AppBrandCameraView.a(AppBrandCameraView.this, true);
      AppBrandCameraView.e(AppBrandCameraView.this).a(new MMSightRecordView.h()
      {
        public final void gq(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(46153);
          ac.i("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (AppBrandCameraView.e(AppBrandCameraView.this) == null)
          {
            ac.i("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
            AppBrandCameraView.b.a(AppBrandCameraView.b.this, "camera is null");
            AppMethodBeat.o(46153);
            return;
          }
          AppBrandCameraView.this.kmC = 1;
          if (paramAnonymousBoolean)
          {
            AppBrandCameraView.b.a(AppBrandCameraView.b.this, "stop error");
            AppBrandCameraView.b.this.bgp();
            AppMethodBeat.o(46153);
            return;
          }
          if (AppBrandCameraView.v(AppBrandCameraView.this))
          {
            AppBrandCameraView.b localb = AppBrandCameraView.b.this;
            com.tencent.e.h.JZN.aS(new AppBrandCameraView.b.3(localb));
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
    private int aNa;
    private int aNb;
    private int duration;
    private float gWZ;
    private Point jbP;
    private com.tencent.mm.plugin.appbrand.jsapi.camera.a.c kmP;
    AtomicBoolean kmQ;
    private int kmR;
    private Rect kmS;
    private int kmT;
    int kmU;
    private int kmV;
    
    protected c()
    {
      AppMethodBeat.i(46171);
      this.kmQ = new AtomicBoolean(false);
      this.kmR = 200;
      this.duration = this.kmR;
      this.gWZ = (AppBrandCameraView.z(AppBrandCameraView.this) * 1.0F / AppBrandCameraView.A(AppBrandCameraView.this));
      if (AppBrandCameraView.B(AppBrandCameraView.this)) {
        i = 1;
      }
      this.kmU = i;
      AppMethodBeat.o(46171);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint)
    {
      AppMethodBeat.i(186579);
      if (this.kmQ.compareAndSet(false, true))
      {
        ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46170);
            AppBrandCameraView.c.this.kmQ.set(false);
            AppMethodBeat.o(46170);
          }
        }, this.duration);
        ac.d("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d, codeVersion:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if ((paramQBarPoint != null) && (this.kmV % 4 == 0))
        {
          ac.i("MicroMsg.AppBrandCameraView", "x: %f, y: %f, w: %f, h: %f; x0:%f, x1:%f, x2:%f, x3:%f, y0:%f, y1:%f, y2:%f, y3:%f", new Object[] { Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x1 - paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y3 - paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.x1), Float.valueOf(paramQBarPoint.x2), Float.valueOf(paramQBarPoint.x3), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.y1), Float.valueOf(paramQBarPoint.y2), Float.valueOf(paramQBarPoint.y3) });
          this.kmV += 1;
        }
      }
      switch (paramInt1)
      {
      default: 
        ac.w("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
        AppMethodBeat.o(186579);
        return;
      case 1: 
        j.a(AppBrandCameraView.c(AppBrandCameraView.this), AppBrandCameraView.this.getCameraId(), "qrcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
        AppMethodBeat.o(186579);
        return;
      }
      j.a(AppBrandCameraView.c(AppBrandCameraView.this), AppBrandCameraView.this.getCameraId(), "barcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
      AppMethodBeat.o(186579);
    }
    
    public final void bgb()
    {
      AppMethodBeat.i(46175);
      ac.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
      AppMethodBeat.o(46175);
    }
    
    public final void bgk()
    {
      AppMethodBeat.i(46176);
      ac.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
      AppMethodBeat.o(46176);
    }
    
    public final void bgl()
    {
      AppMethodBeat.i(46177);
      ac.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
      AppMethodBeat.o(46177);
    }
    
    public void init()
    {
      AppMethodBeat.i(46172);
      this.kmP = new com.tencent.mm.plugin.appbrand.jsapi.camera.a.d();
      this.kmP.init();
      this.kmP.knK = this;
      AppBrandCameraView.a(AppBrandCameraView.this, 4);
      if (AppBrandCameraView.C(AppBrandCameraView.this) > 0) {
        this.duration = (1000 / AppBrandCameraView.C(AppBrandCameraView.this));
      }
      this.kmV = 0;
      AppMethodBeat.o(46172);
    }
    
    public final void release()
    {
      AppMethodBeat.i(46178);
      if (this.kmP != null) {
        this.kmP.release();
      }
      this.jbP = null;
      this.kmV = 0;
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
      if ((this.aNa != AppBrandCameraView.z(AppBrandCameraView.this)) || (this.aNb != AppBrandCameraView.A(AppBrandCameraView.this))) {
        switch (((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay().getRotation())
        {
        default: 
          i = 0;
          k = AppBrandCameraView.e(AppBrandCameraView.this).getCameraRotation();
          if ("front".equals(AppBrandCameraView.E(AppBrandCameraView.this)))
          {
            this.kmT = (k % 360);
            this.kmT = ((360 - this.kmT) % 360);
            if (AppBrandCameraView.e(AppBrandCameraView.this) != null)
            {
              this.aNa = AppBrandCameraView.z(AppBrandCameraView.this);
              this.aNb = AppBrandCameraView.A(AppBrandCameraView.this);
            }
            AppBrandCameraView.z(AppBrandCameraView.this);
            AppBrandCameraView.A(AppBrandCameraView.this);
            k = this.kmT;
            f2 = this.gWZ;
            if ((paramInt1 > 0) && (paramInt2 > 0)) {
              break label332;
            }
            localObject = null;
            label211:
            this.jbP = ((Point)localObject);
            if (this.jbP != null)
            {
              localObject = AppBrandCameraView.D(AppBrandCameraView.this);
              i = AppBrandCameraView.z(AppBrandCameraView.this);
              j = this.jbP.x;
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
        this.kmS = ((Rect)localObject);
        if (!this.kmQ.get()) {
          break label588;
        }
        ac.d("MicroMsg.AppBrandCameraView", "[onFrameData] isScanPause, return");
        AppMethodBeat.o(46173);
        return;
        i = 90;
        break;
        i = 180;
        break;
        i = 270;
        break;
        this.kmT = ((k - i + 360) % 360);
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
          this.kmU = 1;
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
      if ((this.kmP != null) && (AppBrandCameraView.e(AppBrandCameraView.this) != null)) {
        this.kmP.b(paramArrayOfByte, paramInt1, paramInt2, AppBrandCameraView.z(AppBrandCameraView.this), AppBrandCameraView.A(AppBrandCameraView.this), this.jbP, this.kmS, this.kmT, this.kmU);
      }
      AppMethodBeat.o(46173);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView
 * JD-Core Version:    0.7.0.1
 */