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
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.media.t;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.utils.ad.a;
import com.tencent.mm.plugin.appbrand.utils.ad.b;
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
  implements f, i.b, i.c, i.d
{
  private String cHZ;
  private ImageView dKU;
  private String irP;
  private com.tencent.mm.plugin.appbrand.jsapi.f lOZ;
  private long lPA;
  private long lPB;
  private d lPC;
  private boolean lPD;
  private float lPE;
  private long lPF;
  private boolean lPG;
  private ad.a lPH;
  private AtomicBoolean lPI;
  private List<Runnable> lPJ;
  private ad lPK;
  private String lPa;
  private int lPb;
  private a lPc;
  private int lPd;
  private String lPe;
  private String lPf;
  private String lPg;
  private boolean lPh;
  private boolean lPi;
  private boolean lPj;
  private boolean lPk;
  private int lPl;
  private int lPm;
  private int lPn;
  private int lPo;
  private Rect lPp;
  private int lPq;
  private Size lPr;
  private boolean lPs;
  private c lPt;
  private b lPu;
  private MMSightRecordView lPv;
  private String lPw;
  private String lPx;
  int lPy;
  private boolean lPz;
  private String mAppId;
  private Context mContext;
  private WindowManager mWindowManager;
  
  static
  {
    AppMethodBeat.i(46215);
    j.bur();
    AppMethodBeat.o(46215);
  }
  
  public AppBrandCameraView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(46180);
    this.lPa = "scanCode";
    this.cHZ = "back";
    this.lPe = "auto";
    this.lPf = "high";
    this.lPh = false;
    this.lPi = false;
    this.lPk = false;
    this.lPl = 1080;
    this.lPm = 1920;
    this.lPn = 1080;
    this.lPo = 1920;
    this.lPy = -1;
    this.lPz = false;
    this.lPA = -1L;
    this.lPB = -1L;
    this.mWindowManager = ((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    this.lPH = ad.a.ohC;
    this.lPI = new AtomicBoolean(false);
    this.lPK = new ad(MMApplicationContext.getContext(), new ad.b()
    {
      public final void a(ad.a paramAnonymousa1, ad.a paramAnonymousa2)
      {
        AppMethodBeat.i(226712);
        if ((AppBrandCameraView.a(AppBrandCameraView.this)) && (AppBrandCameraView.b(AppBrandCameraView.this)))
        {
          AppMethodBeat.o(226712);
          return;
        }
        if ((paramAnonymousa2 == ad.a.ohC) && (AppBrandCameraView.c(AppBrandCameraView.this) == ad.a.ohE))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        if ((paramAnonymousa2 == ad.a.ohE) && (AppBrandCameraView.c(AppBrandCameraView.this) == ad.a.ohC))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        AppMethodBeat.o(226712);
      }
    });
    init(paramContext);
    AppMethodBeat.o(46180);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(46181);
    this.lPa = "scanCode";
    this.cHZ = "back";
    this.lPe = "auto";
    this.lPf = "high";
    this.lPh = false;
    this.lPi = false;
    this.lPk = false;
    this.lPl = 1080;
    this.lPm = 1920;
    this.lPn = 1080;
    this.lPo = 1920;
    this.lPy = -1;
    this.lPz = false;
    this.lPA = -1L;
    this.lPB = -1L;
    this.mWindowManager = ((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    this.lPH = ad.a.ohC;
    this.lPI = new AtomicBoolean(false);
    this.lPK = new ad(MMApplicationContext.getContext(), new ad.b()
    {
      public final void a(ad.a paramAnonymousa1, ad.a paramAnonymousa2)
      {
        AppMethodBeat.i(226712);
        if ((AppBrandCameraView.a(AppBrandCameraView.this)) && (AppBrandCameraView.b(AppBrandCameraView.this)))
        {
          AppMethodBeat.o(226712);
          return;
        }
        if ((paramAnonymousa2 == ad.a.ohC) && (AppBrandCameraView.c(AppBrandCameraView.this) == ad.a.ohE))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        if ((paramAnonymousa2 == ad.a.ohE) && (AppBrandCameraView.c(AppBrandCameraView.this) == ad.a.ohC))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        AppMethodBeat.o(226712);
      }
    });
    init(paramContext);
    AppMethodBeat.o(46181);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(46182);
    this.lPa = "scanCode";
    this.cHZ = "back";
    this.lPe = "auto";
    this.lPf = "high";
    this.lPh = false;
    this.lPi = false;
    this.lPk = false;
    this.lPl = 1080;
    this.lPm = 1920;
    this.lPn = 1080;
    this.lPo = 1920;
    this.lPy = -1;
    this.lPz = false;
    this.lPA = -1L;
    this.lPB = -1L;
    this.mWindowManager = ((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    this.lPH = ad.a.ohC;
    this.lPI = new AtomicBoolean(false);
    this.lPK = new ad(MMApplicationContext.getContext(), new ad.b()
    {
      public final void a(ad.a paramAnonymousa1, ad.a paramAnonymousa2)
      {
        AppMethodBeat.i(226712);
        if ((AppBrandCameraView.a(AppBrandCameraView.this)) && (AppBrandCameraView.b(AppBrandCameraView.this)))
        {
          AppMethodBeat.o(226712);
          return;
        }
        if ((paramAnonymousa2 == ad.a.ohC) && (AppBrandCameraView.c(AppBrandCameraView.this) == ad.a.ohE))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        if ((paramAnonymousa2 == ad.a.ohE) && (AppBrandCameraView.c(AppBrandCameraView.this) == ad.a.ohC))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        AppMethodBeat.o(226712);
      }
    });
    init(paramContext);
    AppMethodBeat.o(46182);
  }
  
  public static void bFJ()
  {
    AppMethodBeat.i(46179);
    l.lQf = new l.a() {};
    AppMethodBeat.o(46179);
  }
  
  private void bFL()
  {
    int j = 0;
    AppMethodBeat.i(46197);
    Log.i("MicroMsg.AppBrandCameraView", "initCamera.");
    if (!a.a.bFI().bFH())
    {
      Toast.makeText(this.mContext, 2131763067, 1).show();
      Log.w("MicroMsg.AppBrandCameraView", "no permission");
      AppMethodBeat.o(46197);
      return;
    }
    if (this.lPv != null)
    {
      Log.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
      AppMethodBeat.o(46197);
      return;
    }
    Object localObject = a.a.bFI().bFG();
    int i;
    if (localObject.length > 0)
    {
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        int m = localObject[i];
        if (m != this.lPd)
        {
          a.a.bFI().M(m, false);
          Log.i("MicroMsg.AppBrandCameraView", "release camera before init new camera, id: %d", new Object[] { Integer.valueOf(m) });
        }
        i += 1;
      }
    }
    if (this.dKU == null)
    {
      this.dKU = new ImageView(this.mContext);
      this.dKU.setScaleType(ImageView.ScaleType.FIT_XY);
      addView(this.dKU, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      this.lPv = d(this.mContext, this.lPl, this.lPm);
      if (this.lPv == null) {
        this.lPv = new MMSightRecordView(this.mContext);
      }
      this.lPD = false;
      addView(this.lPv);
      bFV();
      this.lPv.setRGBSizeLimit(this.lPb);
      this.lPv.zsX.bqO();
      this.lPv.setDisplayRatio(this.lPl * 1.0F / this.lPm);
      localObject = this.lPv;
      i = j;
      if (this.lPh) {
        i = 1;
      }
      ((MMSightRecordView)localObject).setPreviewMode(i);
      this.lPv.setVideoPara$2e715812(600000);
      this.lPv.setVideoFilePath(this.lPw);
      this.lPv.setClipPictureSize(true);
      this.lPv.setClipVideoSize(true);
      this.lPv.setDisplayScreenSize(this.lPr);
      this.lPv.setUseBackCamera("back".equals(this.cHZ));
      this.lPv.setFrameDataCallback(new MMSightRecordView.a()
      {
        public final void C(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(226714);
          if (AppBrandCameraView.e(AppBrandCameraView.this) != null) {
            AppBrandCameraView.e(AppBrandCameraView.this).C(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(226714);
        }
      });
      this.lPv.setInitErrorCallback(new MMSightRecordView.d()
      {
        public final void bFW()
        {
          AppMethodBeat.i(226715);
          Log.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
          Object localObject = new HashMap();
          ((Map)localObject).put("cameraId", Integer.valueOf(AppBrandCameraView.f(AppBrandCameraView.this)));
          localObject = new JSONObject((Map)localObject).toString();
          new i().h(AppBrandCameraView.g(AppBrandCameraView.this)).Zh((String)localObject).bEo();
          AppMethodBeat.o(226715);
        }
      });
      this.lPv.setInitDoneCallback(new MMSightRecordView.c()
      {
        public final void bFX()
        {
          AppMethodBeat.i(226716);
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
            localh.Zh(new JSONObject(localHashMap).toString());
            AppBrandCameraView.g(AppBrandCameraView.this).a(localh, null);
            if (AppBrandCameraView.k(AppBrandCameraView.this) != null)
            {
              localObject = AppBrandCameraView.k(AppBrandCameraView.this).iterator();
              while (((Iterator)localObject).hasNext()) {
                ((Runnable)((Iterator)localObject).next()).run();
              }
              AppBrandCameraView.k(AppBrandCameraView.this).clear();
            }
            AppMethodBeat.o(226716);
            return;
          }
        }
      });
      this.lPv.zsX.startPreview();
      this.lPv.zsX.bqI();
      this.lPy = 1;
      AppMethodBeat.o(46197);
      return;
      this.dKU.setImageBitmap(null);
    }
  }
  
  private void bFO()
  {
    AppMethodBeat.i(46201);
    this.irP = (AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    AppMethodBeat.o(46201);
  }
  
  private void bFP()
  {
    AppMethodBeat.i(46202);
    String str = "MicroMsg_" + System.currentTimeMillis();
    if (!com.tencent.mm.vfs.s.YS(com.tencent.mm.loader.j.b.aKH())) {
      com.tencent.mm.vfs.s.boN(com.tencent.mm.loader.j.b.aKH());
    }
    this.lPw = (com.tencent.mm.loader.j.b.aKH() + str + ".mp4");
    this.lPx = (com.tencent.mm.loader.j.b.aKH() + str + ".jpeg");
    if (this.lPv != null) {
      this.lPv.setVideoFilePath(this.lPw);
    }
    AppMethodBeat.o(46202);
  }
  
  private void bFQ()
  {
    AppMethodBeat.i(46203);
    if ((this.lPv == null) || (this.lPe == null))
    {
      AppMethodBeat.o(46203);
      return;
    }
    Runnable local7 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226718);
        if (AppBrandCameraView.n(AppBrandCameraView.this).equals("auto"))
        {
          AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(3);
          AppMethodBeat.o(226718);
          return;
        }
        if (AppBrandCameraView.n(AppBrandCameraView.this).equals("torch"))
        {
          AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(1);
          AppMethodBeat.o(226718);
          return;
        }
        if (AppBrandCameraView.n(AppBrandCameraView.this).equals("on"))
        {
          if ((AppBrandCameraView.o(AppBrandCameraView.this) == 2) || (AppBrandCameraView.o(AppBrandCameraView.this) == 4) || (!AppBrandCameraView.n(AppBrandCameraView.this).equals("on")))
          {
            AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(1);
            AppMethodBeat.o(226718);
          }
        }
        else if (AppBrandCameraView.n(AppBrandCameraView.this).equals("torch"))
        {
          AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(1);
          AppMethodBeat.o(226718);
          return;
        }
        AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(2);
        AppMethodBeat.o(226718);
      }
    };
    if (!this.lPD)
    {
      if (this.lPJ == null) {
        this.lPJ = new ArrayList();
      }
      this.lPJ.add(local7);
      Log.i("MicroMsg.AppBrandCameraView", "set flash mode before camera init done");
      AppMethodBeat.o(46203);
      return;
    }
    local7.run();
    AppMethodBeat.o(46203);
  }
  
  private void bFR()
  {
    AppMethodBeat.i(46204);
    Log.i("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", new Object[] { this.lPa });
    bFS();
    this.lPc = ZI(this.lPa);
    this.lPc.init();
    AppMethodBeat.o(46204);
  }
  
  private void bFS()
  {
    AppMethodBeat.i(46206);
    if (this.lPc != null)
    {
      this.lPc.release();
      this.lPc = null;
    }
    AppMethodBeat.o(46206);
  }
  
  private void bFV()
  {
    int j = 720;
    AppMethodBeat.i(46211);
    int i = j;
    String str;
    if (!Util.isNullOrNil(this.lPg))
    {
      str = this.lPg;
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
      if (this.lPb > i)
      {
        Log.i("MicroMsg.AppBrandCameraView", "framesize is : %d, large than preview size: %d", new Object[] { Integer.valueOf(this.lPb), Integer.valueOf(i) });
        j = this.lPb;
      }
      this.lPv.setPreviewSizeLimit(j);
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
    this.lPI.set(false);
    LayoutInflater.from(paramContext).inflate(2131493015, this);
    AppMethodBeat.o(46183);
  }
  
  protected a ZI(String paramString)
  {
    AppMethodBeat.i(46205);
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals("scanCode"))) {}
    for (paramString = new AppBrandCameraView.c(this);; paramString = new b((byte)0))
    {
      AppMethodBeat.o(46205);
      return paramString;
    }
  }
  
  public final float aJ(float paramFloat)
  {
    AppMethodBeat.i(46196);
    if (this.lPv != null)
    {
      if (paramFloat < 1.0F)
      {
        AppMethodBeat.o(46196);
        return paramFloat;
      }
      float f = paramFloat;
      if (paramFloat > this.lPE) {}
      for (f = this.lPE; (!this.lPv.zsX.aD(f)) && (f > 0.0F); f -= 0.1F) {}
      AppMethodBeat.o(46196);
      return f;
    }
    AppMethodBeat.o(46196);
    return 0.0F;
  }
  
  public final void ar(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46186);
    if (Util.isEqual(this.cHZ, paramString))
    {
      AppMethodBeat.o(46186);
      return;
    }
    if (Util.isEqual(this.lPa, "scanCode"))
    {
      AppMethodBeat.o(46186);
      return;
    }
    this.cHZ = paramString;
    if ((!paramBoolean) && (this.lPv != null)) {
      this.lPv.zsX.switchCamera();
    }
    AppMethodBeat.o(46186);
  }
  
  public final void bFK()
  {
    AppMethodBeat.i(46195);
    if (this.lPc != null) {
      this.lPc.bFK();
    }
    AppMethodBeat.o(46195);
  }
  
  public final void bFM()
  {
    AppMethodBeat.i(46198);
    if (this.lPv == null)
    {
      Log.i("MicroMsg.AppBrandCameraView", "recordView is null");
      AppMethodBeat.o(46198);
      return;
    }
    bFR();
    bFQ();
    AppMethodBeat.o(46198);
  }
  
  public final void bFN()
  {
    AppMethodBeat.i(46200);
    if (this.lPt == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    if (this.lPC == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    this.lPC.a(this.lPv);
    this.lPC = null;
    AppMethodBeat.o(46200);
  }
  
  public final void bFT()
  {
    AppMethodBeat.i(46209);
    if (this.lPc != null) {
      this.lPc.bFT();
    }
    AppMethodBeat.o(46209);
  }
  
  public final void bFU()
  {
    AppMethodBeat.i(46210);
    if (this.lPc != null) {
      this.lPc.bFU();
    }
    AppMethodBeat.o(46210);
  }
  
  protected MMSightRecordView d(Context paramContext, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public final boolean dZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46190);
    if ((this.lPl == paramInt1) && (this.lPm == paramInt2))
    {
      AppMethodBeat.o(46190);
      return false;
    }
    Log.i("MicroMsg.AppBrandCameraView", "setViewSize");
    this.lPl = paramInt1;
    this.lPm = paramInt2;
    AppMethodBeat.o(46190);
    return true;
  }
  
  public int getCameraId()
  {
    return this.lPd;
  }
  
  protected MMSightRecordView getRecordView()
  {
    return this.lPv;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(46184);
    Log.i("MicroMsg.AppBrandCameraView", "initView");
    if (!a.a.bFI().bFH())
    {
      AppMethodBeat.o(46184);
      return;
    }
    bFP();
    bFO();
    bFL();
    bFM();
    this.lPI.compareAndSet(false, true);
    if (this.lPs)
    {
      this.lPK.jHZ = 60;
      this.lPK.enable();
    }
    AppMethodBeat.o(46184);
  }
  
  public final void o(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    AppMethodBeat.i(46199);
    Log.i("MicroMsg.AppBrandCameraView", "listenFrameChange");
    if (this.lPt == null)
    {
      AppMethodBeat.o(46199);
      return;
    }
    if (this.lPv == null)
    {
      Log.w("MicroMsg.AppBrandCameraView", "listenFrameChange recordView null");
      this.lPt.h("camera illegal state", -1, -1, -1);
      AppMethodBeat.o(46199);
      return;
    }
    if (this.lPC == null) {
      this.lPC = new d(paramf);
    }
    paramf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226717);
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
          AppBrandCameraView.m(AppBrandCameraView.this).h(String.format(Locale.US, "illegal state:%d", new Object[] { Integer.valueOf(i) }), -1, -1, -1);
          AppMethodBeat.o(226717);
          return;
          if (locald.lPY == null)
          {
            i = -2;
          }
          else
          {
            if (locald.lQa != -2147483648)
            {
              Log.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange destroy last one bufferId:%d", new Object[] { Integer.valueOf(locald.lQa) });
              locald.lPY.xZ(locald.lQa);
            }
            locald.lQa = locald.lPY.yb(j * k * 4);
            Log.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange bufferId:%d height:%d width:%d", new Object[] { Integer.valueOf(locald.lQa), Integer.valueOf(k), Integer.valueOf(j) });
            locald.lPZ = true;
            localMMSightRecordView.a(locald.lPY.ya(locald.lQa), locald);
            i = locald.lQa;
          }
        }
        AppBrandCameraView.m(AppBrandCameraView.this).h(null, i, j, k);
        AppMethodBeat.o(226717);
      }
    };
    if (!this.lPD)
    {
      if (this.lPJ == null) {
        this.lPJ = new ArrayList();
      }
      Log.i("MicroMsg.AppBrandCameraView", "listen frame change before camera init done");
      this.lPJ.add(paramf);
      AppMethodBeat.o(46199);
      return;
    }
    paramf.run();
    AppMethodBeat.o(46199);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(46191);
    Log.i("MicroMsg.AppBrandCameraView", "onUIPause");
    if (this.lPs) {
      this.lPK.disable();
    }
    Object localObject;
    if (this.lPy == 2)
    {
      Log.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(this.lPd));
      ((Map)localObject).put("errMsg", "stop on record");
      localObject = new JSONObject((Map)localObject).toString();
      new m().h(this.lOZ).Zh((String)localObject).bEo();
    }
    if (this.lPv != null)
    {
      localObject = this.lPv.getCurrentFramePicture();
      if (localObject != null) {
        this.dKU.setImageBitmap((Bitmap)localObject);
      }
    }
    MMSightRecordView localMMSightRecordView;
    if (this.lPC != null)
    {
      localObject = this.lPC;
      localMMSightRecordView = this.lPv;
      Log.i("MicroMsg.FrameDataCallbackHelper", "onUIPause mNeedCallback:%b", new Object[] { Boolean.valueOf(((d)localObject).lPZ) });
      if (localMMSightRecordView != null) {
        break label266;
      }
      Log.w("MicroMsg.FrameDataCallbackHelper", "onUIPause recordView null");
    }
    for (;;)
    {
      release();
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(getCameraId()));
      localObject = new JSONObject((Map)localObject).toString();
      new k().h(this.lOZ).Zh((String)localObject).bEo();
      AppMethodBeat.o(46191);
      return;
      label266:
      localMMSightRecordView.a(null, null);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(46193);
    if (this.lPC != null) {
      this.lPC.a(this.lPv);
    }
    release();
    this.lPI.compareAndSet(true, false);
    AppMethodBeat.o(46193);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(46192);
    Log.i("MicroMsg.AppBrandCameraView", "onUIResume");
    for (;;)
    {
      MMSightRecordView localMMSightRecordView;
      try
      {
        if (this.lPs)
        {
          this.lPK.jHZ = 60;
          this.lPK.enable();
        }
        if (!this.lPI.get())
        {
          Log.w("MicroMsg.AppBrandCameraView", "no execute initView");
          return;
        }
        bFL();
        bFM();
        d locald;
        if (this.lPC != null)
        {
          locald = this.lPC;
          localMMSightRecordView = this.lPv;
          Log.i("MicroMsg.FrameDataCallbackHelper", "onUIResume mNeedCallback:%b", new Object[] { Boolean.valueOf(locald.lPZ) });
          if (locald.lPZ)
          {
            if (localMMSightRecordView != null) {
              continue;
            }
            Log.w("MicroMsg.FrameDataCallbackHelper", "onUIResume recordView null");
          }
        }
        return;
        if (locald.lQa == -2147483648)
        {
          Log.w("MicroMsg.FrameDataCallbackHelper", "onUIResume invalid mCurrentSharedBufferId");
          continue;
        }
        if (localf.lPY != null) {
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
      localMMSightRecordView.a(localf.lPY.ya(localf.lQa), localf);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(46194);
    Log.i("MicroMsg.AppBrandCameraView", "release");
    try
    {
      this.lPF = Util.currentTicks();
      if (this.lPs) {
        this.lPK.disable();
      }
      if (this.lPv != null)
      {
        this.lPv.zsX.release();
        removeView(this.lPv);
        this.lPy = -1;
        this.lPv.setFrameDataCallback(null);
        this.lPv.setInitErrorCallback(null);
        this.lPv.setInitDoneCallback(null);
        this.lPv = null;
      }
      if (this.dKU != null) {
        this.dKU.setImageBitmap(null);
      }
      if (this.lPJ != null) {
        this.lPJ.clear();
      }
      this.lPE = 0.0F;
      bFS();
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
    this.lPd = paramInt;
  }
  
  public void setCompressRecord(boolean paramBoolean)
  {
    this.lPi = paramBoolean;
  }
  
  public void setDisplayScreenSize(Size paramSize)
  {
    AppMethodBeat.i(226723);
    if ((paramSize == null) || (paramSize.getHeight() <= 0) || (paramSize.getWidth() <= 0))
    {
      AppMethodBeat.o(226723);
      return;
    }
    this.lPr = paramSize;
    AppMethodBeat.o(226723);
  }
  
  public void setFlash(String paramString)
  {
    AppMethodBeat.i(46187);
    if (Util.isEqual(this.lPe, paramString))
    {
      AppMethodBeat.o(46187);
      return;
    }
    this.lPe = paramString;
    AppMethodBeat.o(46187);
  }
  
  public void setFrameLimitSize(int paramInt)
  {
    AppMethodBeat.i(46185);
    Log.i("MicroMsg.AppBrandCameraView", "setFrameLimitSize:%d", new Object[] { Integer.valueOf(paramInt) });
    this.lPb = paramInt;
    AppMethodBeat.o(46185);
  }
  
  public void setMode(String paramString)
  {
    this.lPa = paramString;
  }
  
  public void setNeedOutput(boolean paramBoolean)
  {
    this.lPj = paramBoolean;
  }
  
  public void setOperateCallBack(c paramc)
  {
    this.lPt = paramc;
  }
  
  public void setOutPutCallBack(b paramb)
  {
    this.lPu = paramb;
  }
  
  public void setPage(com.tencent.mm.plugin.appbrand.jsapi.h paramh)
  {
    this.lOZ = paramh;
  }
  
  public void setPageOrientation(boolean paramBoolean)
  {
    AppMethodBeat.i(226724);
    this.lPs = paramBoolean;
    Log.i("MicroMsg.AppBrandCameraView", "setPageOrientation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(226724);
  }
  
  public void setPreviewCenterCrop(boolean paramBoolean)
  {
    this.lPh = paramBoolean;
  }
  
  public void setQuality(String paramString)
  {
    AppMethodBeat.i(46188);
    if (Util.isEqual(this.lPf, paramString))
    {
      AppMethodBeat.o(46188);
      return;
    }
    this.lPf = paramString;
    AppMethodBeat.o(46188);
  }
  
  public void setResolution(String paramString)
  {
    AppMethodBeat.i(46189);
    if (Util.isEqual(this.lPg, paramString))
    {
      AppMethodBeat.o(46189);
      return;
    }
    Log.i("MicroMsg.AppBrandCameraView", "setPreviewResolution: %s", new Object[] { paramString });
    this.lPg = paramString;
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
    this.lPq = paramInt;
    AppMethodBeat.o(46207);
  }
  
  public final void x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(46208);
    Log.i("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((paramInt3 <= 0) || (paramInt4 <= 0))
    {
      AppMethodBeat.o(46208);
      return;
    }
    this.lPp = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    AppMethodBeat.o(46208);
  }
  
  public static abstract interface a
  {
    public abstract void C(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    public abstract void bFK();
    
    public abstract void bFT();
    
    public abstract void bFU();
    
    public abstract void init();
    
    public abstract void release();
  }
  
  final class b
    implements AppBrandCameraView.a
  {
    private b() {}
    
    private void aj(int paramInt, String paramString)
    {
      AppMethodBeat.i(46161);
      if (AppBrandCameraView.m(AppBrandCameraView.this) != null) {
        AppBrandCameraView.m(AppBrandCameraView.this).aj(paramInt, paramString);
      }
      AppMethodBeat.o(46161);
    }
    
    private static void c(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(46166);
      if (!com.tencent.mm.vfs.s.YS(paramString))
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
        c(paramString3, arrayOfInt);
        i = (int)Math.round(arrayOfInt[0] * 1.0D / 1000.0D);
        l = com.tencent.mm.vfs.s.boW(paramString3);
        j = arrayOfInt[1];
        k = arrayOfInt[2];
      }
      for (;;)
      {
        AppBrandCameraView.m(AppBrandCameraView.this).a(paramInt, paramString1, f(AppBrandCameraView.g(AppBrandCameraView.this), paramString2), f(AppBrandCameraView.g(AppBrandCameraView.this), paramString3), i, l, j, k);
        AppBrandCameraView.A(AppBrandCameraView.this);
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
      com.tencent.mm.plugin.appbrand.ac.i locali = new com.tencent.mm.plugin.appbrand.ac.i();
      if (paramf.getFileSystem().a(new o(paramString), "", true, locali) == com.tencent.mm.plugin.appbrand.appstorage.m.kSu)
      {
        paramf = (String)locali.value;
        AppMethodBeat.o(46167);
        return paramf;
      }
      AppMethodBeat.o(46167);
      return null;
    }
    
    public final void C(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(46157);
      if (!AppBrandCameraView.s(AppBrandCameraView.this))
      {
        AppMethodBeat.o(46157);
        return;
      }
      AppMethodBeat.o(46157);
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
          if ("normal".equals(AppBrandCameraView.y(AppBrandCameraView.this))) {
            i = 44;
          }
          for (;;)
          {
            BitmapUtil.saveBitmapToImage(paramBitmap, i, Bitmap.CompressFormat.JPEG, paramString, true);
            Log.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", new Object[] { Long.valueOf(com.tencent.mm.vfs.s.boW(paramString)) });
            AppMethodBeat.o(46159);
            return true;
            boolean bool = "low".equals(AppBrandCameraView.y(AppBrandCameraView.this));
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
    
    public final void bFK()
    {
      AppMethodBeat.i(46158);
      Log.i("MicroMsg.AppBrandCameraView", "takePicture.");
      if (AppBrandCameraView.i(AppBrandCameraView.this) == null)
      {
        Log.i("MicroMsg.AppBrandCameraView", "recordView is null");
        AppMethodBeat.o(46158);
        return;
      }
      if (AppBrandCameraView.o(AppBrandCameraView.this) == 2)
      {
        Log.w("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
        AppMethodBeat.o(46158);
        return;
      }
      if ((AppBrandCameraView.t(AppBrandCameraView.this)) || (Util.ticksToNow(AppBrandCameraView.u(AppBrandCameraView.this)) < 300L))
      {
        Log.i("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
        AppMethodBeat.o(46158);
        return;
      }
      if (!AppBrandCameraView.v(AppBrandCameraView.this))
      {
        Log.w("MicroMsg.AppBrandCameraView", "takePicture err, isn't init done");
        AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "camera has not been initialized");
        AppMethodBeat.o(46158);
        return;
      }
      AppBrandCameraView.a(AppBrandCameraView.this, Util.currentTicks());
      AppBrandCameraView.w(AppBrandCameraView.this);
      AppBrandCameraView.a(AppBrandCameraView.this, 3);
      AppBrandCameraView.i(AppBrandCameraView.this).a(new MMSightRecordView.g()
      {
        public final void R(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(46151);
          if (paramAnonymousBitmap != null)
          {
            if (AppBrandCameraView.b.this.a(paramAnonymousBitmap, AppBrandCameraView.x(AppBrandCameraView.this)))
            {
              AppBrandCameraView.a(AppBrandCameraView.this, 0, AppBrandCameraView.b.f(AppBrandCameraView.g(AppBrandCameraView.this), AppBrandCameraView.x(AppBrandCameraView.this)), "");
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
        
        public final void bFZ()
        {
          AppMethodBeat.i(46152);
          AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "take picture error");
          AppMethodBeat.o(46152);
        }
      }, "on".equals(AppBrandCameraView.n(AppBrandCameraView.this)));
      AppMethodBeat.o(46158);
    }
    
    public final void bFT()
    {
      AppMethodBeat.i(46160);
      Log.i("MicroMsg.AppBrandCameraView", "startRecord.");
      a locala = a.a.bFI();
      if ((!locala.lOV) || (!locala.lOW)) {
        Log.i("MicroMsg.AppBrandCameraMrg", "no all permission");
      }
      if ((locala.lOV) && (locala.lOW)) {}
      for (int i = 1; i == 0; i = 0)
      {
        Toast.makeText(AppBrandCameraView.z(AppBrandCameraView.this), 2131763067, 1).show();
        Log.w("MicroMsg.AppBrandCameraView", "no micro phone permission");
        aj(-1, "permission");
        AppMethodBeat.o(46160);
        return;
      }
      if (AppBrandCameraView.o(AppBrandCameraView.this) == 2)
      {
        Log.w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
        aj(-1, "is recording");
        AppMethodBeat.o(46160);
        return;
      }
      if (!AppBrandCameraView.v(AppBrandCameraView.this))
      {
        Log.w("MicroMsg.AppBrandCameraView", "startRecord err, isn't init done");
        aj(-1, "camera has not been initialized");
        AppMethodBeat.o(46160);
        return;
      }
      if (AppBrandCameraView.i(AppBrandCameraView.this).zsX.aai())
      {
        AppBrandCameraView.b(AppBrandCameraView.this, Util.currentTicks());
        AppBrandCameraView.a(AppBrandCameraView.this, 2);
        aj(0, "");
        AppBrandCameraView.A(AppBrandCameraView.this);
        AppMethodBeat.o(46160);
        return;
      }
      Log.w("MicroMsg.AppBrandCameraView", "startRecord fail !!");
      aj(-1, "startRecord fail");
      AppMethodBeat.o(46160);
    }
    
    public final void bFU()
    {
      AppMethodBeat.i(46165);
      long l = Util.ticksToNow(AppBrandCameraView.F(AppBrandCameraView.this));
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
    
    final void bFY()
    {
      AppMethodBeat.i(46163);
      AppBrandCameraView.E(AppBrandCameraView.this);
      AppBrandCameraView.a(AppBrandCameraView.this, false);
      AppMethodBeat.o(46163);
    }
    
    public final void init() {}
    
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
      if (AppBrandCameraView.B(AppBrandCameraView.this))
      {
        Log.i("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
        d(-1, "is stopping", null, null);
        AppMethodBeat.o(46162);
        return;
      }
      AppBrandCameraView.a(AppBrandCameraView.this, true);
      AppBrandCameraView.i(AppBrandCameraView.this).a(new MMSightRecordView.h()
      {
        public final void hs(boolean paramAnonymousBoolean)
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
          AppBrandCameraView.this.lPy = 1;
          if (paramAnonymousBoolean)
          {
            AppBrandCameraView.b.a(AppBrandCameraView.b.this, "stop error");
            AppBrandCameraView.b.this.bFY();
            AppMethodBeat.o(46153);
            return;
          }
          if (AppBrandCameraView.C(AppBrandCameraView.this))
          {
            AppBrandCameraView.b localb = AppBrandCameraView.b.this;
            com.tencent.f.h.RTc.aX(new AppBrandCameraView.b.3(localb));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView
 * JD-Core Version:    0.7.0.1
 */