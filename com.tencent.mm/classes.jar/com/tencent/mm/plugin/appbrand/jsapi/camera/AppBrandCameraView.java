package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
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
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.n.s;
import com.tencent.mm.plugin.appbrand.utils.ak;
import com.tencent.mm.plugin.appbrand.utils.ak.a;
import com.tencent.mm.plugin.appbrand.utils.ak.b;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.y;
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
  implements f, i.b, i.c, i.d
{
  private String eCl;
  private ImageView hIz;
  private String mAppId;
  private Context mContext;
  private WindowManager mWindowManager;
  private String nLD;
  private int rPA;
  private int rPB;
  private int rPC;
  private int rPD;
  private Rect rPE;
  private int rPF;
  private Size rPG;
  private boolean rPH;
  private c rPI;
  private b rPJ;
  private MMSightRecordView rPK;
  private String rPL;
  private String rPM;
  int rPN;
  private boolean rPO;
  private long rPP;
  private long rPQ;
  private d rPR;
  private boolean rPS;
  private float rPT;
  private long rPU;
  private boolean rPV;
  private ak.a rPW;
  private AtomicBoolean rPX;
  private List<Runnable> rPY;
  private ak rPZ;
  private com.tencent.mm.plugin.appbrand.jsapi.f rPp;
  private String rPq;
  private int rPr;
  private a rPs;
  private String rPt;
  private String rPu;
  private String rPv;
  private boolean rPw;
  private boolean rPx;
  private boolean rPy;
  private boolean rPz;
  private int zS;
  
  public AppBrandCameraView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(46180);
    this.rPq = "scanCode";
    this.eCl = "back";
    this.rPt = "auto";
    this.rPu = "high";
    this.rPw = false;
    this.rPx = false;
    this.rPz = false;
    this.rPA = 1080;
    this.rPB = 1920;
    this.rPC = 1080;
    this.rPD = 1920;
    this.rPN = -1;
    this.rPO = false;
    this.rPP = -1L;
    this.rPQ = -1L;
    this.mWindowManager = ((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    this.rPW = ak.a.urF;
    this.rPX = new AtomicBoolean(false);
    this.rPZ = new ak(MMApplicationContext.getContext(), new ak.b()
    {
      public final void onFourOrientationsChange(ak.a paramAnonymousa1, ak.a paramAnonymousa2)
      {
        AppMethodBeat.i(326000);
        if ((AppBrandCameraView.a(AppBrandCameraView.this)) && (AppBrandCameraView.b(AppBrandCameraView.this)))
        {
          AppMethodBeat.o(326000);
          return;
        }
        if ((paramAnonymousa2 == ak.a.urF) && (AppBrandCameraView.c(AppBrandCameraView.this) == ak.a.urH))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        if ((paramAnonymousa2 == ak.a.urH) && (AppBrandCameraView.c(AppBrandCameraView.this) == ak.a.urF))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        AppMethodBeat.o(326000);
      }
    });
    init(paramContext);
    AppMethodBeat.o(46180);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(46181);
    this.rPq = "scanCode";
    this.eCl = "back";
    this.rPt = "auto";
    this.rPu = "high";
    this.rPw = false;
    this.rPx = false;
    this.rPz = false;
    this.rPA = 1080;
    this.rPB = 1920;
    this.rPC = 1080;
    this.rPD = 1920;
    this.rPN = -1;
    this.rPO = false;
    this.rPP = -1L;
    this.rPQ = -1L;
    this.mWindowManager = ((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    this.rPW = ak.a.urF;
    this.rPX = new AtomicBoolean(false);
    this.rPZ = new ak(MMApplicationContext.getContext(), new ak.b()
    {
      public final void onFourOrientationsChange(ak.a paramAnonymousa1, ak.a paramAnonymousa2)
      {
        AppMethodBeat.i(326000);
        if ((AppBrandCameraView.a(AppBrandCameraView.this)) && (AppBrandCameraView.b(AppBrandCameraView.this)))
        {
          AppMethodBeat.o(326000);
          return;
        }
        if ((paramAnonymousa2 == ak.a.urF) && (AppBrandCameraView.c(AppBrandCameraView.this) == ak.a.urH))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        if ((paramAnonymousa2 == ak.a.urH) && (AppBrandCameraView.c(AppBrandCameraView.this) == ak.a.urF))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        AppMethodBeat.o(326000);
      }
    });
    init(paramContext);
    AppMethodBeat.o(46181);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(46182);
    this.rPq = "scanCode";
    this.eCl = "back";
    this.rPt = "auto";
    this.rPu = "high";
    this.rPw = false;
    this.rPx = false;
    this.rPz = false;
    this.rPA = 1080;
    this.rPB = 1920;
    this.rPC = 1080;
    this.rPD = 1920;
    this.rPN = -1;
    this.rPO = false;
    this.rPP = -1L;
    this.rPQ = -1L;
    this.mWindowManager = ((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    this.rPW = ak.a.urF;
    this.rPX = new AtomicBoolean(false);
    this.rPZ = new ak(MMApplicationContext.getContext(), new ak.b()
    {
      public final void onFourOrientationsChange(ak.a paramAnonymousa1, ak.a paramAnonymousa2)
      {
        AppMethodBeat.i(326000);
        if ((AppBrandCameraView.a(AppBrandCameraView.this)) && (AppBrandCameraView.b(AppBrandCameraView.this)))
        {
          AppMethodBeat.o(326000);
          return;
        }
        if ((paramAnonymousa2 == ak.a.urF) && (AppBrandCameraView.c(AppBrandCameraView.this) == ak.a.urH))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        if ((paramAnonymousa2 == ak.a.urH) && (AppBrandCameraView.c(AppBrandCameraView.this) == ak.a.urF))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        AppMethodBeat.o(326000);
      }
    });
    init(paramContext);
    AppMethodBeat.o(46182);
  }
  
  private void crA()
  {
    int j = 0;
    AppMethodBeat.i(46197);
    Log.i("MicroMsg.AppBrandCameraView", "initCamera.");
    if (!a.a.cry().hasCameraPermission())
    {
      Toast.makeText(this.mContext, ba.i.mmsight_capture_init_error, 1).show();
      Log.w("MicroMsg.AppBrandCameraView", "no permission");
      AppMethodBeat.o(46197);
      return;
    }
    if (this.rPK != null)
    {
      Log.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
      AppMethodBeat.o(46197);
      return;
    }
    Object localObject = a.a.cry().crw();
    int i;
    if (localObject.length > 0)
    {
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        int m = localObject[i];
        if (m != this.zS)
        {
          a.a.cry().ad(m, false);
          Log.i("MicroMsg.AppBrandCameraView", "release camera before init new camera, id: %d", new Object[] { Integer.valueOf(m) });
        }
        i += 1;
      }
    }
    if (this.hIz == null)
    {
      this.hIz = new ImageView(this.mContext);
      this.hIz.setScaleType(ImageView.ScaleType.FIT_XY);
      addView(this.hIz, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      this.rPK = d(this.mContext, this.rPA, this.rPB);
      if (this.rPK == null) {
        this.rPK = new MMSightRecordView(this.mContext);
      }
      this.rPS = false;
      addView(this.rPK);
      crJ();
      this.rPK.setRGBSizeLimit(this.rPr);
      this.rPK.KUk.caZ();
      this.rPK.setDisplayRatio(this.rPA * 1.0F / this.rPB);
      localObject = this.rPK;
      i = j;
      if (this.rPw) {
        i = 1;
      }
      ((MMSightRecordView)localObject).setPreviewMode(i);
      this.rPK.yR(600000);
      this.rPK.setVideoFilePath(this.rPL);
      this.rPK.setClipPictureSize(true);
      this.rPK.setClipVideoSize(true);
      this.rPK.setDisplayScreenSize(this.rPG);
      this.rPK.setUseBackCamera("back".equals(this.eCl));
      this.rPK.setFrameDataCallback(new MMSightRecordView.a()
      {
        public final void B(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(325999);
          if (AppBrandCameraView.e(AppBrandCameraView.this) != null) {
            AppBrandCameraView.e(AppBrandCameraView.this).B(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(325999);
        }
      });
      this.rPK.setInitErrorCallback(new MMSightRecordView.d()
      {
        public final void crK()
        {
          AppMethodBeat.i(325997);
          Log.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
          Object localObject = new HashMap();
          ((Map)localObject).put("cameraId", Integer.valueOf(AppBrandCameraView.f(AppBrandCameraView.this)));
          localObject = new JSONObject((Map)localObject).toString();
          new i().i(AppBrandCameraView.g(AppBrandCameraView.this)).ZR((String)localObject).cpV();
          AppMethodBeat.o(325997);
        }
      });
      this.rPK.setInitDoneCallback(new MMSightRecordView.c()
      {
        public final void crL()
        {
          AppMethodBeat.i(326004);
          AppBrandCameraView.h(AppBrandCameraView.this);
          Log.i("MicroMsg.AppBrandCameraView", "InitDoneCallback");
          h localh = new h();
          HashMap localHashMap = new HashMap();
          localHashMap.put("cameraId", Integer.valueOf(AppBrandCameraView.f(AppBrandCameraView.this)));
          if (AppBrandCameraView.i(AppBrandCameraView.this) != null) {}
          for (Object localObject = AppBrandCameraView.i(AppBrandCameraView.this).getSupportZoomMultiple();; localObject = null)
          {
            if ((localObject != null) && (localObject.length > 0)) {
              AppBrandCameraView.a(AppBrandCameraView.this, localObject[(localObject.length - 1)]);
            }
            localHashMap.put("maxZoom", Float.valueOf(AppBrandCameraView.j(AppBrandCameraView.this)));
            localh.ZR(new JSONObject(localHashMap).toString());
            AppBrandCameraView.g(AppBrandCameraView.this).a(localh, null);
            if (AppBrandCameraView.k(AppBrandCameraView.this) != null)
            {
              localObject = AppBrandCameraView.k(AppBrandCameraView.this).iterator();
              while (((Iterator)localObject).hasNext()) {
                ((Runnable)((Iterator)localObject).next()).run();
              }
              AppBrandCameraView.k(AppBrandCameraView.this).clear();
            }
            AppMethodBeat.o(326004);
            return;
          }
        }
      });
      this.rPK.KUk.aPz();
      this.rPK.KUk.caT();
      this.rPN = 1;
      AppMethodBeat.o(46197);
      return;
      this.hIz.setImageBitmap(null);
    }
  }
  
  private void crD()
  {
    AppMethodBeat.i(46201);
    String str = String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    if (a.a.cry().crx())
    {
      this.nLD = (AndroidMediaUtil.getSysCameraDirPath() + str);
      AppMethodBeat.o(46201);
      return;
    }
    this.nLD = (com.tencent.mm.loader.i.b.bmx() + str);
    AppMethodBeat.o(46201);
  }
  
  private void crE()
  {
    AppMethodBeat.i(46202);
    String str = "MicroMsg_" + System.currentTimeMillis();
    if (!y.ZC(com.tencent.mm.loader.i.b.bmx())) {
      y.bDX(com.tencent.mm.loader.i.b.bmx());
    }
    this.rPL = (com.tencent.mm.loader.i.b.bmx() + str + ".mp4");
    this.rPM = (com.tencent.mm.loader.i.b.bmx() + str + ".jpeg");
    if (this.rPK != null) {
      this.rPK.setVideoFilePath(this.rPL);
    }
    AppMethodBeat.o(46202);
  }
  
  private void crF()
  {
    AppMethodBeat.i(46203);
    if ((this.rPK == null) || (this.rPt == null))
    {
      AppMethodBeat.o(46203);
      return;
    }
    Runnable local7 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(326001);
        if (AppBrandCameraView.n(AppBrandCameraView.this).equals("auto"))
        {
          AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(3);
          AppMethodBeat.o(326001);
          return;
        }
        if (AppBrandCameraView.n(AppBrandCameraView.this).equals("torch"))
        {
          AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(1);
          AppMethodBeat.o(326001);
          return;
        }
        if (AppBrandCameraView.n(AppBrandCameraView.this).equals("on"))
        {
          if ((AppBrandCameraView.o(AppBrandCameraView.this) == 2) || (AppBrandCameraView.o(AppBrandCameraView.this) == 4) || (!AppBrandCameraView.n(AppBrandCameraView.this).equals("on")))
          {
            AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(1);
            AppMethodBeat.o(326001);
          }
        }
        else if (AppBrandCameraView.n(AppBrandCameraView.this).equals("torch"))
        {
          AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(1);
          AppMethodBeat.o(326001);
          return;
        }
        AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(2);
        AppMethodBeat.o(326001);
      }
    };
    if (!this.rPS)
    {
      if (this.rPY == null) {
        this.rPY = new ArrayList();
      }
      this.rPY.add(local7);
      Log.i("MicroMsg.AppBrandCameraView", "set flash mode before camera init done");
      AppMethodBeat.o(46203);
      return;
    }
    local7.run();
    AppMethodBeat.o(46203);
  }
  
  private void crG()
  {
    AppMethodBeat.i(46204);
    Log.i("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", new Object[] { this.rPq });
    crH();
    this.rPs = aat(this.rPq);
    this.rPs.init();
    AppMethodBeat.o(46204);
  }
  
  private void crH()
  {
    AppMethodBeat.i(46206);
    if (this.rPs != null)
    {
      this.rPs.release();
      this.rPs = null;
    }
    AppMethodBeat.o(46206);
  }
  
  private void crJ()
  {
    int j = 720;
    AppMethodBeat.i(46211);
    int i = j;
    String str;
    if (!Util.isNullOrNil(this.rPv))
    {
      str = this.rPv;
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
      if (this.rPr > i)
      {
        Log.i("MicroMsg.AppBrandCameraView", "framesize is : %d, large than preview size: %d", new Object[] { Integer.valueOf(this.rPr), Integer.valueOf(i) });
        j = this.rPr;
      }
      this.rPK.setPreviewSizeLimit(j);
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
  
  public static void crz()
  {
    AppMethodBeat.i(46179);
    l.rQv = new l.a() {};
    AppMethodBeat.o(46179);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(46183);
    this.mContext = paramContext;
    this.rPX.set(false);
    LayoutInflater.from(paramContext).inflate(ba.g.app_brand_camera_container, this);
    AppMethodBeat.o(46183);
  }
  
  public final void F(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(46208);
    Log.i("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((paramInt3 <= 0) || (paramInt4 <= 0))
    {
      AppMethodBeat.o(46208);
      return;
    }
    this.rPE = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    AppMethodBeat.o(46208);
  }
  
  public final void aE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46186);
    if (Util.isEqual(this.eCl, paramString))
    {
      AppMethodBeat.o(46186);
      return;
    }
    if (Util.isEqual(this.rPq, "scanCode"))
    {
      AppMethodBeat.o(46186);
      return;
    }
    this.eCl = paramString;
    if ((!paramBoolean) && (this.rPK != null)) {
      this.rPK.KUk.switchCamera();
    }
    AppMethodBeat.o(46186);
  }
  
  protected a aat(String paramString)
  {
    AppMethodBeat.i(46205);
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals("scanCode"))) {}
    for (paramString = new c();; paramString = new b((byte)0))
    {
      AppMethodBeat.o(46205);
      return paramString;
    }
  }
  
  public final float bH(float paramFloat)
  {
    AppMethodBeat.i(46196);
    if (this.rPK != null)
    {
      if (paramFloat < 1.0F)
      {
        AppMethodBeat.o(46196);
        return paramFloat;
      }
      float f = paramFloat;
      if (paramFloat > this.rPT) {}
      for (f = this.rPT; (!this.rPK.KUk.bB(f)) && (f > 0.0F); f -= 0.1F) {}
      AppMethodBeat.o(46196);
      return f;
    }
    AppMethodBeat.o(46196);
    return 0.0F;
  }
  
  public final void crB()
  {
    AppMethodBeat.i(46198);
    if (this.rPK == null)
    {
      Log.i("MicroMsg.AppBrandCameraView", "recordView is null");
      AppMethodBeat.o(46198);
      return;
    }
    crG();
    crF();
    AppMethodBeat.o(46198);
  }
  
  public final void crC()
  {
    AppMethodBeat.i(46200);
    if (this.rPI == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    if (this.rPR == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    this.rPR.a(this.rPK);
    this.rPR = null;
    AppMethodBeat.o(46200);
  }
  
  public final void crI()
  {
    AppMethodBeat.i(46210);
    if (this.rPs != null) {
      this.rPs.crI();
    }
    AppMethodBeat.o(46210);
  }
  
  protected MMSightRecordView d(Context paramContext, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public final boolean fs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46190);
    if ((this.rPA == paramInt1) && (this.rPB == paramInt2))
    {
      AppMethodBeat.o(46190);
      return false;
    }
    Log.i("MicroMsg.AppBrandCameraView", "setViewSize");
    this.rPA = paramInt1;
    this.rPB = paramInt2;
    AppMethodBeat.o(46190);
    return true;
  }
  
  public int getCameraId()
  {
    return this.zS;
  }
  
  protected MMSightRecordView getRecordView()
  {
    return this.rPK;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(46184);
    Log.i("MicroMsg.AppBrandCameraView", "initView");
    if (!a.a.cry().hasCameraPermission())
    {
      AppMethodBeat.o(46184);
      return;
    }
    crE();
    crD();
    crA();
    crB();
    this.rPX.compareAndSet(false, true);
    if (this.rPH)
    {
      this.rPZ.pvP = 60;
      this.rPZ.enable();
    }
    AppMethodBeat.o(46184);
  }
  
  public final void jl(boolean paramBoolean)
  {
    AppMethodBeat.i(326195);
    if (this.rPs != null) {
      this.rPs.jl(paramBoolean);
    }
    AppMethodBeat.o(326195);
  }
  
  public final void jm(boolean paramBoolean)
  {
    AppMethodBeat.i(326219);
    if (this.rPs != null) {
      this.rPs.jm(paramBoolean);
    }
    AppMethodBeat.o(326219);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(46191);
    if (a.a.cry().rPm)
    {
      Log.i("MicroMsg.AppBrandCameraView", "onBackground, but is requesting microphone permission");
      AppMethodBeat.o(46191);
      return;
    }
    Log.i("MicroMsg.AppBrandCameraView", "onUIPause");
    if (this.rPH) {
      this.rPZ.disable();
    }
    Object localObject;
    if (this.rPN == 2)
    {
      Log.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(this.zS));
      ((Map)localObject).put("errMsg", "stop on record");
      localObject = new JSONObject((Map)localObject).toString();
      new n().i(this.rPp).ZR((String)localObject).cpV();
    }
    if (this.rPK != null)
    {
      localObject = this.rPK.getCurrentFramePicture();
      if (localObject != null) {
        this.hIz.setImageBitmap((Bitmap)localObject);
      }
    }
    MMSightRecordView localMMSightRecordView;
    if (this.rPR != null)
    {
      localObject = this.rPR;
      localMMSightRecordView = this.rPK;
      Log.i("MicroMsg.FrameDataCallbackHelper", "onUIPause mNeedCallback:%b", new Object[] { Boolean.valueOf(((d)localObject).rQp) });
      if (localMMSightRecordView != null) {
        break label291;
      }
      Log.w("MicroMsg.FrameDataCallbackHelper", "onUIPause recordView null");
    }
    for (;;)
    {
      release();
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(getCameraId()));
      localObject = new JSONObject((Map)localObject).toString();
      new k().i(this.rPp).ZR((String)localObject).cpV();
      AppMethodBeat.o(46191);
      return;
      label291:
      localMMSightRecordView.a(null, null);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(46193);
    if (this.rPR != null) {
      this.rPR.a(this.rPK);
    }
    release();
    this.rPX.compareAndSet(true, false);
    AppMethodBeat.o(46193);
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(46192);
    Log.i("MicroMsg.AppBrandCameraView", "onUIResume");
    for (;;)
    {
      MMSightRecordView localMMSightRecordView;
      try
      {
        if (this.rPH)
        {
          this.rPZ.pvP = 60;
          this.rPZ.enable();
        }
        if (!this.rPX.get())
        {
          Log.w("MicroMsg.AppBrandCameraView", "no execute initView");
          return;
        }
        crA();
        crB();
        d locald;
        if (this.rPR != null)
        {
          locald = this.rPR;
          localMMSightRecordView = this.rPK;
          Log.i("MicroMsg.FrameDataCallbackHelper", "onUIResume mNeedCallback:%b", new Object[] { Boolean.valueOf(locald.rQp) });
          if (locald.rQp)
          {
            if (localMMSightRecordView != null) {
              continue;
            }
            Log.w("MicroMsg.FrameDataCallbackHelper", "onUIResume recordView null");
          }
        }
        return;
        if (locald.rQq == -2147483648)
        {
          Log.w("MicroMsg.FrameDataCallbackHelper", "onUIResume invalid mCurrentSharedBufferId");
          continue;
        }
        if (localf.rQo != null) {
          break label201;
        }
      }
      finally
      {
        AppMethodBeat.o(46192);
      }
      Log.w("MicroMsg.FrameDataCallbackHelper", "onUIResume mSharedBufferAddon null");
      continue;
      label201:
      localMMSightRecordView.a(localf.rQo.BN(localf.rQq), localf);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(46194);
    Log.i("MicroMsg.AppBrandCameraView", "release");
    try
    {
      this.rPU = Util.currentTicks();
      if (this.rPH) {
        this.rPZ.disable();
      }
      if (this.rPK != null)
      {
        this.rPK.KUk.release();
        removeView(this.rPK);
        this.rPN = -1;
        this.rPK.setFrameDataCallback(null);
        this.rPK.setInitErrorCallback(null);
        this.rPK.setInitDoneCallback(null);
        this.rPK = null;
      }
      if (this.hIz != null) {
        this.hIz.setImageBitmap(null);
      }
      if (this.rPY != null) {
        this.rPY.clear();
      }
      this.rPT = 0.0F;
      crH();
      AppMethodBeat.o(46194);
      return;
    }
    finally
    {
      AppMethodBeat.o(46194);
    }
  }
  
  public final void s(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    AppMethodBeat.i(46199);
    Log.i("MicroMsg.AppBrandCameraView", "listenFrameChange");
    if (this.rPI == null)
    {
      AppMethodBeat.o(46199);
      return;
    }
    if (this.rPK == null)
    {
      Log.w("MicroMsg.AppBrandCameraView", "listenFrameChange recordView null");
      this.rPI.i("camera illegal state", -1, -1, -1);
      AppMethodBeat.o(46199);
      return;
    }
    if (this.rPR == null) {
      this.rPR = new d(paramf);
    }
    paramf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(326002);
        int j = AppBrandCameraView.i(AppBrandCameraView.this).getDrawSizePoint().x;
        int k = AppBrandCameraView.i(AppBrandCameraView.this).getDrawSizePoint().y;
        d locald = AppBrandCameraView.l(AppBrandCameraView.this);
        MMSightRecordView localMMSightRecordView = AppBrandCameraView.i(AppBrandCameraView.this);
        int i;
        if (localMMSightRecordView == null)
        {
          Log.w("MicroMsg.FrameDataCallbackHelper", "listenFrameChange recordView null");
          i = -1;
        }
        while (i < 0)
        {
          AppBrandCameraView.m(AppBrandCameraView.this).i(String.format(Locale.US, "illegal state:%d", new Object[] { Integer.valueOf(i) }), -1, -1, -1);
          AppMethodBeat.o(326002);
          return;
          if (locald.rQo == null)
          {
            i = -2;
          }
          else
          {
            if (locald.rQq != -2147483648)
            {
              Log.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange destroy last one bufferId:%d", new Object[] { Integer.valueOf(locald.rQq) });
              locald.rQo.BM(locald.rQq);
            }
            locald.rQq = locald.rQo.BO(j * k * 4);
            Log.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange bufferId:%d height:%d width:%d", new Object[] { Integer.valueOf(locald.rQq), Integer.valueOf(k), Integer.valueOf(j) });
            locald.rQp = true;
            localMMSightRecordView.a(locald.rQo.BN(locald.rQq), locald);
            i = locald.rQq;
          }
        }
        AppBrandCameraView.m(AppBrandCameraView.this).i(null, i, j, k);
        AppMethodBeat.o(326002);
      }
    };
    if (!this.rPS)
    {
      if (this.rPY == null) {
        this.rPY = new ArrayList();
      }
      Log.i("MicroMsg.AppBrandCameraView", "listen frame change before camera init done");
      this.rPY.add(paramf);
      AppMethodBeat.o(46199);
      return;
    }
    paramf.run();
    AppMethodBeat.o(46199);
  }
  
  public void setAppId(String paramString)
  {
    this.mAppId = paramString;
  }
  
  public void setCameraId(int paramInt)
  {
    this.zS = paramInt;
  }
  
  public void setCompressRecord(boolean paramBoolean)
  {
    this.rPx = paramBoolean;
  }
  
  public void setDisplayScreenSize(Size paramSize)
  {
    AppMethodBeat.i(326152);
    if ((paramSize == null) || (paramSize.getHeight() <= 0) || (paramSize.getWidth() <= 0))
    {
      AppMethodBeat.o(326152);
      return;
    }
    this.rPG = paramSize;
    AppMethodBeat.o(326152);
  }
  
  public void setFlash(String paramString)
  {
    AppMethodBeat.i(46187);
    if (Util.isEqual(this.rPt, paramString))
    {
      AppMethodBeat.o(46187);
      return;
    }
    this.rPt = paramString;
    AppMethodBeat.o(46187);
  }
  
  public void setFrameLimitSize(int paramInt)
  {
    AppMethodBeat.i(46185);
    Log.i("MicroMsg.AppBrandCameraView", "setFrameLimitSize:%d", new Object[] { Integer.valueOf(paramInt) });
    this.rPr = paramInt;
    AppMethodBeat.o(46185);
  }
  
  public void setMode(String paramString)
  {
    this.rPq = paramString;
  }
  
  public void setNeedOutput(boolean paramBoolean)
  {
    this.rPy = paramBoolean;
  }
  
  public void setOperateCallBack(c paramc)
  {
    this.rPI = paramc;
  }
  
  public void setOutPutCallBack(b paramb)
  {
    this.rPJ = paramb;
  }
  
  public void setPage(com.tencent.mm.plugin.appbrand.jsapi.h paramh)
  {
    this.rPp = paramh;
  }
  
  public void setPageOrientation(boolean paramBoolean)
  {
    AppMethodBeat.i(326158);
    this.rPH = paramBoolean;
    Log.i("MicroMsg.AppBrandCameraView", "setPageOrientation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(326158);
  }
  
  public void setPreviewCenterCrop(boolean paramBoolean)
  {
    this.rPw = paramBoolean;
  }
  
  public void setQuality(String paramString)
  {
    AppMethodBeat.i(46188);
    if (Util.isEqual(this.rPu, paramString))
    {
      AppMethodBeat.o(46188);
      return;
    }
    this.rPu = paramString;
    AppMethodBeat.o(46188);
  }
  
  public void setResolution(String paramString)
  {
    AppMethodBeat.i(46189);
    if (Util.isEqual(this.rPv, paramString))
    {
      AppMethodBeat.o(46189);
      return;
    }
    Log.i("MicroMsg.AppBrandCameraView", "setPreviewResolution: %s", new Object[] { paramString });
    this.rPv = paramString;
    AppMethodBeat.o(46189);
  }
  
  public void setScanFreq(int paramInt)
  {
    AppMethodBeat.i(46207);
    Log.i("MicroMsg.AppBrandCameraView", "scanFreq:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      Log.e("MicroMsg.AppBrandCameraView", "scanFreq is err");
      AppMethodBeat.o(46207);
      return;
    }
    this.rPF = paramInt;
    AppMethodBeat.o(46207);
  }
  
  public static abstract interface a
  {
    public abstract void B(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    public abstract void crI();
    
    public abstract void init();
    
    public abstract void jl(boolean paramBoolean);
    
    public abstract void jm(boolean paramBoolean);
    
    public abstract void release();
  }
  
  final class b
    implements AppBrandCameraView.a
  {
    private b() {}
    
    private void av(int paramInt, String paramString)
    {
      AppMethodBeat.i(46161);
      if (AppBrandCameraView.m(AppBrandCameraView.this) != null) {
        AppBrandCameraView.m(AppBrandCameraView.this).av(paramInt, paramString);
      }
      AppMethodBeat.o(46161);
    }
    
    private static void b(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(46166);
      if (!y.ZC(paramString))
      {
        Log.i("MicroMsg.AppBrandCameraView", "getInfoFromMetaData file isn't exist, filename: %s", new Object[] { paramString });
        AppMethodBeat.o(46166);
        return;
      }
      try
      {
        com.tencent.mm.compatible.i.d locald = new com.tencent.mm.compatible.i.d();
        try
        {
          locald.setDataSource(paramString);
          paramArrayOfInt[0] = Util.getInt(locald.extractMetadata(9), 0);
          int i = Util.getInt(locald.extractMetadata(24), 0);
          if ((i == 90) || (i == 270))
          {
            paramArrayOfInt[1] = Util.getInt(locald.extractMetadata(19), 0);
            paramArrayOfInt[2] = Util.getInt(locald.extractMetadata(18), 0);
          }
          for (;;)
          {
            locald.release();
            AppMethodBeat.o(46166);
            return;
            paramArrayOfInt[1] = Util.getInt(locald.extractMetadata(18), 0);
            paramArrayOfInt[2] = Util.getInt(locald.extractMetadata(19), 0);
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
      if (AppBrandCameraView.m(AppBrandCameraView.this) != null)
      {
        l = 0L;
        if (paramInt != 0) {
          break label128;
        }
        int[] arrayOfInt = new int[3];
        b(paramString3, arrayOfInt);
        i = (int)Math.round(arrayOfInt[0] * 1.0D / 1000.0D);
        l = y.bEl(paramString3);
        j = arrayOfInt[1];
        k = arrayOfInt[2];
      }
      for (;;)
      {
        AppBrandCameraView.m(AppBrandCameraView.this).a(paramInt, paramString1, f(AppBrandCameraView.g(AppBrandCameraView.this), paramString2), f(AppBrandCameraView.g(AppBrandCameraView.this), paramString3), i, l, j, k);
        AppBrandCameraView.B(AppBrandCameraView.this);
        AppMethodBeat.o(46164);
        return;
        label128:
        k = 0;
        j = 0;
        i = 0;
      }
    }
    
    static String f(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString)
    {
      AppMethodBeat.i(46167);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(46167);
        return paramString;
      }
      com.tencent.mm.plugin.appbrand.af.k localk = new com.tencent.mm.plugin.appbrand.af.k();
      if (paramf.getFileSystem().a(new com.tencent.mm.vfs.u(paramString), "", true, localk) == r.qML)
      {
        paramf = (String)localk.value;
        AppMethodBeat.o(46167);
        return paramf;
      }
      AppMethodBeat.o(46167);
      return null;
    }
    
    public final void B(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(46157);
      if (!AppBrandCameraView.s(AppBrandCameraView.this))
      {
        AppMethodBeat.o(46157);
        return;
      }
      AppMethodBeat.o(46157);
    }
    
    public final void crI()
    {
      AppMethodBeat.i(46165);
      long l = Util.ticksToNow(AppBrandCameraView.G(AppBrandCameraView.this));
      if (l < 1500L)
      {
        Log.i("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", new Object[] { Long.valueOf(1500L - l) });
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
    
    final void crM()
    {
      AppMethodBeat.i(46163);
      AppBrandCameraView.F(AppBrandCameraView.this);
      AppBrandCameraView.a(AppBrandCameraView.this, false);
      AppMethodBeat.o(46163);
    }
    
    final boolean d(Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(46159);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        try
        {
          AppBrandCameraView.b(AppBrandCameraView.this, paramBitmap.getWidth());
          AppBrandCameraView.c(AppBrandCameraView.this, paramBitmap.getHeight());
          int i = 90;
          if ("normal".equals(AppBrandCameraView.z(AppBrandCameraView.this))) {
            i = 44;
          }
          for (;;)
          {
            BitmapUtil.saveBitmapToImage(paramBitmap, i, Bitmap.CompressFormat.JPEG, paramString, true);
            Log.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", new Object[] { Long.valueOf(y.bEl(paramString)) });
            AppMethodBeat.o(46159);
            return true;
            boolean bool = "low".equals(AppBrandCameraView.z(AppBrandCameraView.this));
            if (bool) {
              i = 25;
            }
          }
          AppMethodBeat.o(46159);
        }
        catch (Exception paramBitmap)
        {
          Log.e("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", new Object[] { paramBitmap.getMessage() });
        }
      }
      return false;
    }
    
    public final void init() {}
    
    public final void jl(final boolean paramBoolean)
    {
      AppMethodBeat.i(326038);
      Log.i("MicroMsg.AppBrandCameraView", "takePicture.");
      if (AppBrandCameraView.i(AppBrandCameraView.this) == null)
      {
        Log.i("MicroMsg.AppBrandCameraView", "recordView is null");
        AppMethodBeat.o(326038);
        return;
      }
      if (AppBrandCameraView.o(AppBrandCameraView.this) == 2)
      {
        Log.w("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
        AppMethodBeat.o(326038);
        return;
      }
      if ((AppBrandCameraView.t(AppBrandCameraView.this)) || (Util.ticksToNow(AppBrandCameraView.u(AppBrandCameraView.this)) < 300L))
      {
        Log.i("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
        AppMethodBeat.o(326038);
        return;
      }
      if (!AppBrandCameraView.v(AppBrandCameraView.this))
      {
        Log.w("MicroMsg.AppBrandCameraView", "takePicture err, isn't init done");
        AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "camera has not been initialized");
        AppMethodBeat.o(326038);
        return;
      }
      AppBrandCameraView.a(AppBrandCameraView.this, Util.currentTicks());
      AppBrandCameraView.w(AppBrandCameraView.this);
      AppBrandCameraView.a(AppBrandCameraView.this, 3);
      AppBrandCameraView.i(AppBrandCameraView.this).a(new MMSightRecordView.g()
      {
        public final void X(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(46151);
          if (paramAnonymousBitmap != null)
          {
            Object localObject = paramAnonymousBitmap;
            if ("front".equals(AppBrandCameraView.x(AppBrandCameraView.this)))
            {
              localObject = paramAnonymousBitmap;
              if (!paramBoolean)
              {
                localObject = new Matrix();
                ((Matrix)localObject).postScale(-1.0F, 1.0F);
                localObject = Bitmap.createBitmap(paramAnonymousBitmap, 0, 0, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight(), (Matrix)localObject, true);
                paramAnonymousBitmap.recycle();
              }
            }
            if (AppBrandCameraView.b.this.d((Bitmap)localObject, AppBrandCameraView.y(AppBrandCameraView.this)))
            {
              AppBrandCameraView.a(AppBrandCameraView.this, 0, AppBrandCameraView.b.f(AppBrandCameraView.g(AppBrandCameraView.this), AppBrandCameraView.y(AppBrandCameraView.this)), "");
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
        
        public final void crN()
        {
          AppMethodBeat.i(46152);
          AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "take picture error");
          AppMethodBeat.o(46152);
        }
      }, "on".equals(AppBrandCameraView.n(AppBrandCameraView.this)));
      AppMethodBeat.o(326038);
    }
    
    public final void jm(boolean paramBoolean)
    {
      AppMethodBeat.i(326052);
      Log.i("MicroMsg.AppBrandCameraView", "startRecord.");
      a locala = a.a.cry();
      if ((!locala.rPk) || (!locala.rPl)) {
        Log.i("MicroMsg.AppBrandCameraMrg", "no all permission");
      }
      if ((locala.rPk) && (locala.rPl)) {}
      for (int i = 1; i == 0; i = 0)
      {
        Toast.makeText(AppBrandCameraView.A(AppBrandCameraView.this), ba.i.mmsight_capture_init_error, 1).show();
        Log.w("MicroMsg.AppBrandCameraView", "no micro phone permission");
        av(-1, "permission");
        AppMethodBeat.o(326052);
        return;
      }
      if (AppBrandCameraView.o(AppBrandCameraView.this) == 2)
      {
        Log.w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
        av(-1, "is recording");
        AppMethodBeat.o(326052);
        return;
      }
      if (!AppBrandCameraView.v(AppBrandCameraView.this))
      {
        Log.w("MicroMsg.AppBrandCameraView", "startRecord err, isn't init done");
        av(-1, "camera has not been initialized");
        AppMethodBeat.o(326052);
        return;
      }
      if (AppBrandCameraView.i(AppBrandCameraView.this).hT(paramBoolean))
      {
        AppBrandCameraView.b(AppBrandCameraView.this, Util.currentTicks());
        AppBrandCameraView.a(AppBrandCameraView.this, 2);
        av(0, "");
        AppBrandCameraView.B(AppBrandCameraView.this);
        AppMethodBeat.o(326052);
        return;
      }
      Log.w("MicroMsg.AppBrandCameraView", "startRecord fail !!");
      av(-1, "startRecord fail");
      AppMethodBeat.o(326052);
    }
    
    public final void release() {}
    
    public final void stopRecord()
    {
      AppMethodBeat.i(46162);
      Log.i("MicroMsg.AppBrandCameraView", "stopRecord");
      if (AppBrandCameraView.i(AppBrandCameraView.this) == null)
      {
        Log.i("MicroMsg.AppBrandCameraView", "recordView is null");
        d(-1, "camera is null", null, null);
        AppMethodBeat.o(46162);
        return;
      }
      if (AppBrandCameraView.o(AppBrandCameraView.this) != 2)
      {
        Log.w("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
        d(-1, "is not recording", null, null);
        AppMethodBeat.o(46162);
        return;
      }
      if (AppBrandCameraView.C(AppBrandCameraView.this))
      {
        Log.i("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
        d(-1, "is stopping", null, null);
        AppMethodBeat.o(46162);
        return;
      }
      AppBrandCameraView.a(AppBrandCameraView.this, true);
      AppBrandCameraView.i(AppBrandCameraView.this).a(new MMSightRecordView.h()
      {
        public final void jn(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(46153);
          Log.i("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (AppBrandCameraView.i(AppBrandCameraView.this) == null)
          {
            Log.i("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
            AppBrandCameraView.b.a(AppBrandCameraView.b.this, "camera is null");
            AppMethodBeat.o(46153);
            return;
          }
          AppBrandCameraView.this.rPN = 1;
          if (paramAnonymousBoolean)
          {
            AppBrandCameraView.b.a(AppBrandCameraView.b.this, "stop error");
            AppBrandCameraView.b.this.crM();
            AppMethodBeat.o(46153);
            return;
          }
          if (AppBrandCameraView.D(AppBrandCameraView.this))
          {
            AppBrandCameraView.b localb = AppBrandCameraView.b.this;
            com.tencent.threadpool.h.ahAA.bm(new AppBrandCameraView.b.3(localb));
            AppMethodBeat.o(46153);
            return;
          }
          AppBrandCameraView.b.b(AppBrandCameraView.b.this, AppBrandCameraView.i(AppBrandCameraView.this).getVideoFilePath());
          AppMethodBeat.o(46153);
        }
      });
      AppMethodBeat.o(46162);
    }
  }
  
  protected class c
    implements AppBrandCameraView.a, c.a
  {
    private int duration;
    private float nFU;
    private int previewHeight;
    private int previewWidth;
    private Point qqj;
    private com.tencent.mm.plugin.appbrand.jsapi.camera.a.c rQg;
    AtomicBoolean rQh;
    private int rQi;
    private Rect rQj;
    private int rQk;
    private int rQl;
    private int rQm;
    
    protected c()
    {
      AppMethodBeat.i(46171);
      this.rQh = new AtomicBoolean(false);
      this.rQi = 200;
      this.duration = this.rQi;
      this.nFU = (AppBrandCameraView.H(AppBrandCameraView.this) * 1.0F / AppBrandCameraView.I(AppBrandCameraView.this));
      if (AppBrandCameraView.J(AppBrandCameraView.this)) {
        i = 1;
      }
      this.rQl = i;
      AppMethodBeat.o(46171);
    }
    
    public final void B(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int j = 0;
      AppMethodBeat.i(46173);
      int i;
      int k;
      label132:
      float f2;
      if ((this.previewWidth != AppBrandCameraView.H(AppBrandCameraView.this)) || (this.previewHeight != AppBrandCameraView.I(AppBrandCameraView.this))) {
        switch (AppBrandCameraView.M(AppBrandCameraView.this).getDefaultDisplay().getRotation())
        {
        default: 
          i = 0;
          k = AppBrandCameraView.i(AppBrandCameraView.this).getCameraRotation();
          if ("front".equals(AppBrandCameraView.x(AppBrandCameraView.this)))
          {
            this.rQk = (k % 360);
            this.rQk = ((360 - this.rQk) % 360);
            if (AppBrandCameraView.i(AppBrandCameraView.this) != null)
            {
              this.previewWidth = AppBrandCameraView.H(AppBrandCameraView.this);
              this.previewHeight = AppBrandCameraView.I(AppBrandCameraView.this);
            }
            AppBrandCameraView.H(AppBrandCameraView.this);
            AppBrandCameraView.I(AppBrandCameraView.this);
            k = this.rQk;
            f2 = this.nFU;
            if ((paramInt1 > 0) && (paramInt2 > 0)) {
              break label323;
            }
            localObject = null;
            label203:
            this.qqj = ((Point)localObject);
            if (this.qqj != null)
            {
              localObject = AppBrandCameraView.L(AppBrandCameraView.this);
              i = AppBrandCameraView.H(AppBrandCameraView.this);
              j = this.qqj.x;
              if (localObject != null) {
                break label508;
              }
            }
          }
          break;
        }
      }
      label323:
      float f1;
      for (Object localObject = null;; localObject = new Rect(Math.round(((Rect)localObject).left / f1), Math.round(((Rect)localObject).top / f1), Math.round(((Rect)localObject).right / f1), Math.round(((Rect)localObject).bottom / f1)))
      {
        this.rQj = ((Rect)localObject);
        if (!this.rQh.get()) {
          break label579;
        }
        Log.d("MicroMsg.AppBrandCameraView", "[onFrameData] isScanPause, return");
        AppMethodBeat.o(46173);
        return;
        i = 90;
        break;
        i = 180;
        break;
        i = 270;
        break;
        this.rQk = ((k - i + 360) % 360);
        break label132;
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
          this.rQl = 1;
          i = Math.max(paramInt2, paramInt1);
          j = (int)(f1 * i);
          if ((k == 90) || (k == 270))
          {
            localObject = new Point(j, i);
            break label203;
          }
          localObject = new Point(i, j);
          break label203;
        }
        i = Math.min(paramInt2, paramInt1);
        j = (int)(i / f1);
        if ((k == 90) || (k == 270))
        {
          localObject = new Point(i, j);
          break label203;
        }
        localObject = new Point(j, i);
        break label203;
        label508:
        f1 = i * 1.0F / j;
      }
      label579:
      if ((this.rQg != null) && (AppBrandCameraView.i(AppBrandCameraView.this) != null)) {
        this.rQg.b(paramArrayOfByte, paramInt1, paramInt2, AppBrandCameraView.H(AppBrandCameraView.this), AppBrandCameraView.I(AppBrandCameraView.this), this.qqj, this.rQj, this.rQk, this.rQl);
      }
      AppMethodBeat.o(46173);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint)
    {
      AppMethodBeat.i(326003);
      if (this.rQh.compareAndSet(false, true))
      {
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46170);
            AppBrandCameraView.c.this.rQh.set(false);
            AppMethodBeat.o(46170);
          }
        }, this.duration);
        Log.d("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d, codeVersion:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if ((paramQBarPoint != null) && (this.rQm % 4 == 0))
        {
          Log.i("MicroMsg.AppBrandCameraView", "x: %f, y: %f, w: %f, h: %f; x0:%f, x1:%f, x2:%f, x3:%f, y0:%f, y1:%f, y2:%f, y3:%f", new Object[] { Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x1 - paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y3 - paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.x1), Float.valueOf(paramQBarPoint.x2), Float.valueOf(paramQBarPoint.x3), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.y1), Float.valueOf(paramQBarPoint.y2), Float.valueOf(paramQBarPoint.y3) });
          this.rQm += 1;
        }
      }
      switch (paramInt1)
      {
      default: 
        Log.w("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
        AppMethodBeat.o(326003);
        return;
      case 1: 
        j.a(AppBrandCameraView.g(AppBrandCameraView.this), AppBrandCameraView.this.getCameraId(), "qrcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
        AppMethodBeat.o(326003);
        return;
      }
      j.a(AppBrandCameraView.g(AppBrandCameraView.this), AppBrandCameraView.this.getCameraId(), "barcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
      AppMethodBeat.o(326003);
    }
    
    public final void crI()
    {
      AppMethodBeat.i(46177);
      Log.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
      AppMethodBeat.o(46177);
    }
    
    protected final void crO()
    {
      this.rQl = 1;
    }
    
    public void init()
    {
      AppMethodBeat.i(46172);
      this.rQg = new com.tencent.mm.plugin.appbrand.jsapi.camera.a.d();
      this.rQg.init();
      this.rQg.rRd = this;
      AppBrandCameraView.a(AppBrandCameraView.this, 4);
      if (AppBrandCameraView.K(AppBrandCameraView.this) > 0) {
        this.duration = (1000 / AppBrandCameraView.K(AppBrandCameraView.this));
      }
      this.rQm = 0;
      AppMethodBeat.o(46172);
    }
    
    public final void jl(boolean paramBoolean)
    {
      AppMethodBeat.i(326008);
      Log.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
      AppMethodBeat.o(326008);
    }
    
    public final void jm(boolean paramBoolean)
    {
      AppMethodBeat.i(326010);
      Log.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
      AppMethodBeat.o(326010);
    }
    
    public final void release()
    {
      AppMethodBeat.i(46178);
      if (this.rQg != null) {
        this.rQg.release();
      }
      this.qqj = null;
      this.rQm = 0;
      AppMethodBeat.o(46178);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView
 * JD-Core Version:    0.7.0.1
 */