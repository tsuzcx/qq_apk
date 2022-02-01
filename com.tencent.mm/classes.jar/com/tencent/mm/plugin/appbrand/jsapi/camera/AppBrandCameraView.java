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
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.media.t;
import com.tencent.mm.plugin.appbrand.m.s;
import com.tencent.mm.plugin.appbrand.utils.af;
import com.tencent.mm.plugin.appbrand.utils.af.a;
import com.tencent.mm.plugin.appbrand.utils.af.b;
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
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
  implements f, h.b, h.c, h.d
{
  private String cIF;
  private ImageView fDJ;
  private String lgT;
  private String mAppId;
  private Context mContext;
  private WindowManager mWindowManager;
  private String oLA;
  private boolean oLB;
  private boolean oLC;
  private boolean oLD;
  private boolean oLE;
  private int oLF;
  private int oLG;
  private int oLH;
  private int oLI;
  private Rect oLJ;
  private int oLK;
  private Size oLL;
  private boolean oLM;
  private c oLN;
  private b oLO;
  private MMSightRecordView oLP;
  private String oLQ;
  private String oLR;
  int oLS;
  private boolean oLT;
  private long oLU;
  private long oLV;
  private d oLW;
  private boolean oLX;
  private float oLY;
  private long oLZ;
  private e oLt;
  private String oLu;
  private int oLv;
  private a oLw;
  private int oLx;
  private String oLy;
  private String oLz;
  private boolean oMa;
  private af.a oMb;
  private AtomicBoolean oMc;
  private List<Runnable> oMd;
  private af oMe;
  
  static
  {
    AppMethodBeat.i(46215);
    com.tencent.mm.plugin.appbrand.app.j.bFt();
    AppMethodBeat.o(46215);
  }
  
  public AppBrandCameraView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(46180);
    this.oLu = "scanCode";
    this.cIF = "back";
    this.oLy = "auto";
    this.oLz = "high";
    this.oLB = false;
    this.oLC = false;
    this.oLE = false;
    this.oLF = 1080;
    this.oLG = 1920;
    this.oLH = 1080;
    this.oLI = 1920;
    this.oLS = -1;
    this.oLT = false;
    this.oLU = -1L;
    this.oLV = -1L;
    this.mWindowManager = ((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    this.oMb = af.a.rjq;
    this.oMc = new AtomicBoolean(false);
    this.oMe = new af(MMApplicationContext.getContext(), new af.b()
    {
      public final void a(af.a paramAnonymousa1, af.a paramAnonymousa2)
      {
        AppMethodBeat.i(282468);
        if ((AppBrandCameraView.a(AppBrandCameraView.this)) && (AppBrandCameraView.b(AppBrandCameraView.this)))
        {
          AppMethodBeat.o(282468);
          return;
        }
        if ((paramAnonymousa2 == af.a.rjq) && (AppBrandCameraView.c(AppBrandCameraView.this) == af.a.rjs))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        if ((paramAnonymousa2 == af.a.rjs) && (AppBrandCameraView.c(AppBrandCameraView.this) == af.a.rjq))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        AppMethodBeat.o(282468);
      }
    });
    init(paramContext);
    AppMethodBeat.o(46180);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(46181);
    this.oLu = "scanCode";
    this.cIF = "back";
    this.oLy = "auto";
    this.oLz = "high";
    this.oLB = false;
    this.oLC = false;
    this.oLE = false;
    this.oLF = 1080;
    this.oLG = 1920;
    this.oLH = 1080;
    this.oLI = 1920;
    this.oLS = -1;
    this.oLT = false;
    this.oLU = -1L;
    this.oLV = -1L;
    this.mWindowManager = ((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    this.oMb = af.a.rjq;
    this.oMc = new AtomicBoolean(false);
    this.oMe = new af(MMApplicationContext.getContext(), new af.b()
    {
      public final void a(af.a paramAnonymousa1, af.a paramAnonymousa2)
      {
        AppMethodBeat.i(282468);
        if ((AppBrandCameraView.a(AppBrandCameraView.this)) && (AppBrandCameraView.b(AppBrandCameraView.this)))
        {
          AppMethodBeat.o(282468);
          return;
        }
        if ((paramAnonymousa2 == af.a.rjq) && (AppBrandCameraView.c(AppBrandCameraView.this) == af.a.rjs))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        if ((paramAnonymousa2 == af.a.rjs) && (AppBrandCameraView.c(AppBrandCameraView.this) == af.a.rjq))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        AppMethodBeat.o(282468);
      }
    });
    init(paramContext);
    AppMethodBeat.o(46181);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(46182);
    this.oLu = "scanCode";
    this.cIF = "back";
    this.oLy = "auto";
    this.oLz = "high";
    this.oLB = false;
    this.oLC = false;
    this.oLE = false;
    this.oLF = 1080;
    this.oLG = 1920;
    this.oLH = 1080;
    this.oLI = 1920;
    this.oLS = -1;
    this.oLT = false;
    this.oLU = -1L;
    this.oLV = -1L;
    this.mWindowManager = ((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    this.oMb = af.a.rjq;
    this.oMc = new AtomicBoolean(false);
    this.oMe = new af(MMApplicationContext.getContext(), new af.b()
    {
      public final void a(af.a paramAnonymousa1, af.a paramAnonymousa2)
      {
        AppMethodBeat.i(282468);
        if ((AppBrandCameraView.a(AppBrandCameraView.this)) && (AppBrandCameraView.b(AppBrandCameraView.this)))
        {
          AppMethodBeat.o(282468);
          return;
        }
        if ((paramAnonymousa2 == af.a.rjq) && (AppBrandCameraView.c(AppBrandCameraView.this) == af.a.rjs))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        if ((paramAnonymousa2 == af.a.rjs) && (AppBrandCameraView.c(AppBrandCameraView.this) == af.a.rjq))
        {
          AppBrandCameraView.a(AppBrandCameraView.this, paramAnonymousa2);
          AppBrandCameraView.d(AppBrandCameraView.this);
        }
        AppMethodBeat.o(282468);
      }
    });
    init(paramContext);
    AppMethodBeat.o(46182);
  }
  
  private void bRA()
  {
    AppMethodBeat.i(46204);
    Log.i("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", new Object[] { this.oLu });
    bRB();
    this.oLw = ahw(this.oLu);
    this.oLw.init();
    AppMethodBeat.o(46204);
  }
  
  private void bRB()
  {
    AppMethodBeat.i(46206);
    if (this.oLw != null)
    {
      this.oLw.release();
      this.oLw = null;
    }
    AppMethodBeat.o(46206);
  }
  
  private void bRE()
  {
    int j = 720;
    AppMethodBeat.i(46211);
    int i = j;
    String str;
    if (!Util.isNullOrNil(this.oLA))
    {
      str = this.oLA;
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
      if (this.oLv > i)
      {
        Log.i("MicroMsg.AppBrandCameraView", "framesize is : %d, large than preview size: %d", new Object[] { Integer.valueOf(this.oLv), Integer.valueOf(i) });
        j = this.oLv;
      }
      this.oLP.setPreviewSizeLimit(j);
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
  
  public static void bRs()
  {
    AppMethodBeat.i(46179);
    l.oMz = new l.a() {};
    AppMethodBeat.o(46179);
  }
  
  private void bRu()
  {
    int j = 0;
    AppMethodBeat.i(46197);
    Log.i("MicroMsg.AppBrandCameraView", "initCamera.");
    if (!a.a.bRr().bRq())
    {
      Toast.makeText(this.mContext, au.i.mmsight_capture_init_error, 1).show();
      Log.w("MicroMsg.AppBrandCameraView", "no permission");
      AppMethodBeat.o(46197);
      return;
    }
    if (this.oLP != null)
    {
      Log.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
      AppMethodBeat.o(46197);
      return;
    }
    Object localObject = a.a.bRr().bRp();
    int i;
    if (localObject.length > 0)
    {
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        int m = localObject[i];
        if (m != this.oLx)
        {
          a.a.bRr().O(m, false);
          Log.i("MicroMsg.AppBrandCameraView", "release camera before init new camera, id: %d", new Object[] { Integer.valueOf(m) });
        }
        i += 1;
      }
    }
    if (this.fDJ == null)
    {
      this.fDJ = new ImageView(this.mContext);
      this.fDJ.setScaleType(ImageView.ScaleType.FIT_XY);
      addView(this.fDJ, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      this.oLP = d(this.mContext, this.oLF, this.oLG);
      if (this.oLP == null) {
        this.oLP = new MMSightRecordView(this.mContext);
      }
      this.oLX = false;
      addView(this.oLP);
      bRE();
      this.oLP.setRGBSizeLimit(this.oLv);
      this.oLP.EYy.bBD();
      this.oLP.setDisplayRatio(this.oLF * 1.0F / this.oLG);
      localObject = this.oLP;
      i = j;
      if (this.oLB) {
        i = 1;
      }
      ((MMSightRecordView)localObject).setPreviewMode(i);
      this.oLP.yJ(600000);
      this.oLP.setVideoFilePath(this.oLQ);
      this.oLP.setClipPictureSize(true);
      this.oLP.setClipVideoSize(true);
      this.oLP.setDisplayScreenSize(this.oLL);
      this.oLP.setUseBackCamera("back".equals(this.cIF));
      this.oLP.setFrameDataCallback(new MMSightRecordView.a()
      {
        public final void D(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(246016);
          if (AppBrandCameraView.e(AppBrandCameraView.this) != null) {
            AppBrandCameraView.e(AppBrandCameraView.this).D(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(246016);
        }
      });
      this.oLP.setInitErrorCallback(new MMSightRecordView.d()
      {
        public final void bRF()
        {
          AppMethodBeat.i(270920);
          Log.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
          Object localObject = new HashMap();
          ((Map)localObject).put("cameraId", Integer.valueOf(AppBrandCameraView.f(AppBrandCameraView.this)));
          localObject = new JSONObject((Map)localObject).toString();
          new i().j(AppBrandCameraView.g(AppBrandCameraView.this)).agU((String)localObject).bPO();
          AppMethodBeat.o(270920);
        }
      });
      this.oLP.setInitDoneCallback(new MMSightRecordView.c()
      {
        public final void bRG()
        {
          AppMethodBeat.i(283247);
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
            localh.agU(new JSONObject(localHashMap).toString());
            AppBrandCameraView.g(AppBrandCameraView.this).a(localh, null);
            if (AppBrandCameraView.k(AppBrandCameraView.this) != null)
            {
              localObject = AppBrandCameraView.k(AppBrandCameraView.this).iterator();
              while (((Iterator)localObject).hasNext()) {
                ((Runnable)((Iterator)localObject).next()).run();
              }
              AppBrandCameraView.k(AppBrandCameraView.this).clear();
            }
            AppMethodBeat.o(283247);
            return;
          }
        }
      });
      this.oLP.EYy.ave();
      this.oLP.EYy.bBx();
      this.oLS = 1;
      AppMethodBeat.o(46197);
      return;
      this.fDJ.setImageBitmap(null);
    }
  }
  
  private void bRx()
  {
    AppMethodBeat.i(46201);
    this.lgT = (AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    AppMethodBeat.o(46201);
  }
  
  private void bRy()
  {
    AppMethodBeat.i(46202);
    String str = "MicroMsg_" + System.currentTimeMillis();
    if (!u.agG(com.tencent.mm.loader.j.b.aSJ())) {
      u.bBD(com.tencent.mm.loader.j.b.aSJ());
    }
    this.oLQ = (com.tencent.mm.loader.j.b.aSJ() + str + ".mp4");
    this.oLR = (com.tencent.mm.loader.j.b.aSJ() + str + ".jpeg");
    if (this.oLP != null) {
      this.oLP.setVideoFilePath(this.oLQ);
    }
    AppMethodBeat.o(46202);
  }
  
  private void bRz()
  {
    AppMethodBeat.i(46203);
    if ((this.oLP == null) || (this.oLy == null))
    {
      AppMethodBeat.o(46203);
      return;
    }
    Runnable local7 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(281154);
        if (AppBrandCameraView.n(AppBrandCameraView.this).equals("auto"))
        {
          AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(3);
          AppMethodBeat.o(281154);
          return;
        }
        if (AppBrandCameraView.n(AppBrandCameraView.this).equals("torch"))
        {
          AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(1);
          AppMethodBeat.o(281154);
          return;
        }
        if (AppBrandCameraView.n(AppBrandCameraView.this).equals("on"))
        {
          if ((AppBrandCameraView.o(AppBrandCameraView.this) == 2) || (AppBrandCameraView.o(AppBrandCameraView.this) == 4) || (!AppBrandCameraView.n(AppBrandCameraView.this).equals("on")))
          {
            AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(1);
            AppMethodBeat.o(281154);
          }
        }
        else if (AppBrandCameraView.n(AppBrandCameraView.this).equals("torch"))
        {
          AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(1);
          AppMethodBeat.o(281154);
          return;
        }
        AppBrandCameraView.i(AppBrandCameraView.this).setFlashMode(2);
        AppMethodBeat.o(281154);
      }
    };
    if (!this.oLX)
    {
      if (this.oMd == null) {
        this.oMd = new ArrayList();
      }
      this.oMd.add(local7);
      Log.i("MicroMsg.AppBrandCameraView", "set flash mode before camera init done");
      AppMethodBeat.o(46203);
      return;
    }
    local7.run();
    AppMethodBeat.o(46203);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(46183);
    this.mContext = paramContext;
    this.oMc.set(false);
    LayoutInflater.from(paramContext).inflate(au.g.app_brand_camera_container, this);
    AppMethodBeat.o(46183);
  }
  
  public final float aJ(float paramFloat)
  {
    AppMethodBeat.i(46196);
    if (this.oLP != null)
    {
      if (paramFloat < 1.0F)
      {
        AppMethodBeat.o(46196);
        return paramFloat;
      }
      float f = paramFloat;
      if (paramFloat > this.oLY) {}
      for (f = this.oLY; (!this.oLP.EYy.aD(f)) && (f > 0.0F); f -= 0.1F) {}
      AppMethodBeat.o(46196);
      return f;
    }
    AppMethodBeat.o(46196);
    return 0.0F;
  }
  
  protected a ahw(String paramString)
  {
    AppMethodBeat.i(46205);
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals("scanCode"))) {}
    for (paramString = new c();; paramString = new b((byte)0))
    {
      AppMethodBeat.o(46205);
      return paramString;
    }
  }
  
  public final void at(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46186);
    if (Util.isEqual(this.cIF, paramString))
    {
      AppMethodBeat.o(46186);
      return;
    }
    if (Util.isEqual(this.oLu, "scanCode"))
    {
      AppMethodBeat.o(46186);
      return;
    }
    this.cIF = paramString;
    if ((!paramBoolean) && (this.oLP != null)) {
      this.oLP.EYy.switchCamera();
    }
    AppMethodBeat.o(46186);
  }
  
  public final void bRC()
  {
    AppMethodBeat.i(46209);
    if (this.oLw != null) {
      this.oLw.bRC();
    }
    AppMethodBeat.o(46209);
  }
  
  public final void bRD()
  {
    AppMethodBeat.i(46210);
    if (this.oLw != null) {
      this.oLw.bRD();
    }
    AppMethodBeat.o(46210);
  }
  
  public final void bRt()
  {
    AppMethodBeat.i(46195);
    if (this.oLw != null) {
      this.oLw.bRt();
    }
    AppMethodBeat.o(46195);
  }
  
  public final void bRv()
  {
    AppMethodBeat.i(46198);
    if (this.oLP == null)
    {
      Log.i("MicroMsg.AppBrandCameraView", "recordView is null");
      AppMethodBeat.o(46198);
      return;
    }
    bRA();
    bRz();
    AppMethodBeat.o(46198);
  }
  
  public final void bRw()
  {
    AppMethodBeat.i(46200);
    if (this.oLN == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    if (this.oLW == null)
    {
      AppMethodBeat.o(46200);
      return;
    }
    this.oLW.a(this.oLP);
    this.oLW = null;
    AppMethodBeat.o(46200);
  }
  
  protected MMSightRecordView d(Context paramContext, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public final boolean ey(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46190);
    if ((this.oLF == paramInt1) && (this.oLG == paramInt2))
    {
      AppMethodBeat.o(46190);
      return false;
    }
    Log.i("MicroMsg.AppBrandCameraView", "setViewSize");
    this.oLF = paramInt1;
    this.oLG = paramInt2;
    AppMethodBeat.o(46190);
    return true;
  }
  
  public int getCameraId()
  {
    return this.oLx;
  }
  
  protected MMSightRecordView getRecordView()
  {
    return this.oLP;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(46184);
    Log.i("MicroMsg.AppBrandCameraView", "initView");
    if (!a.a.bRr().bRq())
    {
      AppMethodBeat.o(46184);
      return;
    }
    bRy();
    bRx();
    bRu();
    bRv();
    this.oMc.compareAndSet(false, true);
    if (this.oLM)
    {
      this.oMe.mze = 60;
      this.oMe.enable();
    }
    AppMethodBeat.o(46184);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(46191);
    Log.i("MicroMsg.AppBrandCameraView", "onUIPause");
    if (this.oLM) {
      this.oMe.disable();
    }
    Object localObject;
    if (this.oLS == 2)
    {
      Log.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(this.oLx));
      ((Map)localObject).put("errMsg", "stop on record");
      localObject = new JSONObject((Map)localObject).toString();
      new n().j(this.oLt).agU((String)localObject).bPO();
    }
    if (this.oLP != null)
    {
      localObject = this.oLP.getCurrentFramePicture();
      if (localObject != null) {
        this.fDJ.setImageBitmap((Bitmap)localObject);
      }
    }
    MMSightRecordView localMMSightRecordView;
    if (this.oLW != null)
    {
      localObject = this.oLW;
      localMMSightRecordView = this.oLP;
      Log.i("MicroMsg.FrameDataCallbackHelper", "onUIPause mNeedCallback:%b", new Object[] { Boolean.valueOf(((d)localObject).oMt) });
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
      new k().j(this.oLt).agU((String)localObject).bPO();
      AppMethodBeat.o(46191);
      return;
      label266:
      localMMSightRecordView.a(null, null);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(46193);
    if (this.oLW != null) {
      this.oLW.a(this.oLP);
    }
    release();
    this.oMc.compareAndSet(true, false);
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
        if (this.oLM)
        {
          this.oMe.mze = 60;
          this.oMe.enable();
        }
        if (!this.oMc.get())
        {
          Log.w("MicroMsg.AppBrandCameraView", "no execute initView");
          return;
        }
        bRu();
        bRv();
        d locald;
        if (this.oLW != null)
        {
          locald = this.oLW;
          localMMSightRecordView = this.oLP;
          Log.i("MicroMsg.FrameDataCallbackHelper", "onUIResume mNeedCallback:%b", new Object[] { Boolean.valueOf(locald.oMt) });
          if (locald.oMt)
          {
            if (localMMSightRecordView != null) {
              continue;
            }
            Log.w("MicroMsg.FrameDataCallbackHelper", "onUIResume recordView null");
          }
        }
        return;
        if (locald.oMu == -2147483648)
        {
          Log.w("MicroMsg.FrameDataCallbackHelper", "onUIResume invalid mCurrentSharedBufferId");
          continue;
        }
        if (localf.oMs != null) {
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
      localMMSightRecordView.a(localf.oMs.BA(localf.oMu), localf);
    }
  }
  
  public final void q(e parame)
  {
    AppMethodBeat.i(46199);
    Log.i("MicroMsg.AppBrandCameraView", "listenFrameChange");
    if (this.oLN == null)
    {
      AppMethodBeat.o(46199);
      return;
    }
    if (this.oLP == null)
    {
      Log.w("MicroMsg.AppBrandCameraView", "listenFrameChange recordView null");
      this.oLN.i("camera illegal state", -1, -1, -1);
      AppMethodBeat.o(46199);
      return;
    }
    if (this.oLW == null) {
      this.oLW = new d(parame);
    }
    parame = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(272296);
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
          AppMethodBeat.o(272296);
          return;
          if (locald.oMs == null)
          {
            i = -2;
          }
          else
          {
            if (locald.oMu != -2147483648)
            {
              Log.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange destroy last one bufferId:%d", new Object[] { Integer.valueOf(locald.oMu) });
              locald.oMs.Bz(locald.oMu);
            }
            locald.oMu = locald.oMs.BB(j * k * 4);
            Log.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange bufferId:%d height:%d width:%d", new Object[] { Integer.valueOf(locald.oMu), Integer.valueOf(k), Integer.valueOf(j) });
            locald.oMt = true;
            localMMSightRecordView.a(locald.oMs.BA(locald.oMu), locald);
            i = locald.oMu;
          }
        }
        AppBrandCameraView.m(AppBrandCameraView.this).i(null, i, j, k);
        AppMethodBeat.o(272296);
      }
    };
    if (!this.oLX)
    {
      if (this.oMd == null) {
        this.oMd = new ArrayList();
      }
      Log.i("MicroMsg.AppBrandCameraView", "listen frame change before camera init done");
      this.oMd.add(parame);
      AppMethodBeat.o(46199);
      return;
    }
    parame.run();
    AppMethodBeat.o(46199);
  }
  
  public final void release()
  {
    AppMethodBeat.i(46194);
    Log.i("MicroMsg.AppBrandCameraView", "release");
    try
    {
      this.oLZ = Util.currentTicks();
      if (this.oLM) {
        this.oMe.disable();
      }
      if (this.oLP != null)
      {
        this.oLP.EYy.release();
        removeView(this.oLP);
        this.oLS = -1;
        this.oLP.setFrameDataCallback(null);
        this.oLP.setInitErrorCallback(null);
        this.oLP.setInitDoneCallback(null);
        this.oLP = null;
      }
      if (this.fDJ != null) {
        this.fDJ.setImageBitmap(null);
      }
      if (this.oMd != null) {
        this.oMd.clear();
      }
      this.oLY = 0.0F;
      bRB();
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
    this.oLx = paramInt;
  }
  
  public void setCompressRecord(boolean paramBoolean)
  {
    this.oLC = paramBoolean;
  }
  
  public void setDisplayScreenSize(Size paramSize)
  {
    AppMethodBeat.i(283668);
    if ((paramSize == null) || (paramSize.getHeight() <= 0) || (paramSize.getWidth() <= 0))
    {
      AppMethodBeat.o(283668);
      return;
    }
    this.oLL = paramSize;
    AppMethodBeat.o(283668);
  }
  
  public void setFlash(String paramString)
  {
    AppMethodBeat.i(46187);
    if (Util.isEqual(this.oLy, paramString))
    {
      AppMethodBeat.o(46187);
      return;
    }
    this.oLy = paramString;
    AppMethodBeat.o(46187);
  }
  
  public void setFrameLimitSize(int paramInt)
  {
    AppMethodBeat.i(46185);
    Log.i("MicroMsg.AppBrandCameraView", "setFrameLimitSize:%d", new Object[] { Integer.valueOf(paramInt) });
    this.oLv = paramInt;
    AppMethodBeat.o(46185);
  }
  
  public void setMode(String paramString)
  {
    this.oLu = paramString;
  }
  
  public void setNeedOutput(boolean paramBoolean)
  {
    this.oLD = paramBoolean;
  }
  
  public void setOperateCallBack(c paramc)
  {
    this.oLN = paramc;
  }
  
  public void setOutPutCallBack(b paramb)
  {
    this.oLO = paramb;
  }
  
  public void setPage(g paramg)
  {
    this.oLt = paramg;
  }
  
  public void setPageOrientation(boolean paramBoolean)
  {
    AppMethodBeat.i(283670);
    this.oLM = paramBoolean;
    Log.i("MicroMsg.AppBrandCameraView", "setPageOrientation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(283670);
  }
  
  public void setPreviewCenterCrop(boolean paramBoolean)
  {
    this.oLB = paramBoolean;
  }
  
  public void setQuality(String paramString)
  {
    AppMethodBeat.i(46188);
    if (Util.isEqual(this.oLz, paramString))
    {
      AppMethodBeat.o(46188);
      return;
    }
    this.oLz = paramString;
    AppMethodBeat.o(46188);
  }
  
  public void setResolution(String paramString)
  {
    AppMethodBeat.i(46189);
    if (Util.isEqual(this.oLA, paramString))
    {
      AppMethodBeat.o(46189);
      return;
    }
    Log.i("MicroMsg.AppBrandCameraView", "setPreviewResolution: %s", new Object[] { paramString });
    this.oLA = paramString;
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
    this.oLK = paramInt;
    AppMethodBeat.o(46207);
  }
  
  public final void z(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(46208);
    Log.i("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((paramInt3 <= 0) || (paramInt4 <= 0))
    {
      AppMethodBeat.o(46208);
      return;
    }
    this.oLJ = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    AppMethodBeat.o(46208);
  }
  
  public static abstract interface a
  {
    public abstract void D(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    public abstract void bRC();
    
    public abstract void bRD();
    
    public abstract void bRt();
    
    public abstract void init();
    
    public abstract void release();
  }
  
  final class b
    implements AppBrandCameraView.a
  {
    private b() {}
    
    private void al(int paramInt, String paramString)
    {
      AppMethodBeat.i(46161);
      if (AppBrandCameraView.m(AppBrandCameraView.this) != null) {
        AppBrandCameraView.m(AppBrandCameraView.this).al(paramInt, paramString);
      }
      AppMethodBeat.o(46161);
    }
    
    private static void b(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(46166);
      if (!u.agG(paramString))
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
        l = u.bBQ(paramString3);
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
    
    static String f(e parame, String paramString)
    {
      AppMethodBeat.i(46167);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(46167);
        return paramString;
      }
      com.tencent.mm.plugin.appbrand.ac.i locali = new com.tencent.mm.plugin.appbrand.ac.i();
      if (parame.getFileSystem().a(new q(paramString), "", true, locali) == com.tencent.mm.plugin.appbrand.appstorage.m.nMR)
      {
        parame = (String)locali.value;
        AppMethodBeat.o(46167);
        return parame;
      }
      AppMethodBeat.o(46167);
      return null;
    }
    
    public final void D(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
            Log.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", new Object[] { Long.valueOf(u.bBQ(paramString)) });
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
    
    public final void bRC()
    {
      AppMethodBeat.i(46160);
      Log.i("MicroMsg.AppBrandCameraView", "startRecord.");
      a locala = a.a.bRr();
      if ((!locala.oLp) || (!locala.oLq)) {
        Log.i("MicroMsg.AppBrandCameraMrg", "no all permission");
      }
      if ((locala.oLp) && (locala.oLq)) {}
      for (int i = 1; i == 0; i = 0)
      {
        Toast.makeText(AppBrandCameraView.z(AppBrandCameraView.this), au.i.mmsight_capture_init_error, 1).show();
        Log.w("MicroMsg.AppBrandCameraView", "no micro phone permission");
        al(-1, "permission");
        AppMethodBeat.o(46160);
        return;
      }
      if (AppBrandCameraView.o(AppBrandCameraView.this) == 2)
      {
        Log.w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
        al(-1, "is recording");
        AppMethodBeat.o(46160);
        return;
      }
      if (!AppBrandCameraView.v(AppBrandCameraView.this))
      {
        Log.w("MicroMsg.AppBrandCameraView", "startRecord err, isn't init done");
        al(-1, "camera has not been initialized");
        AppMethodBeat.o(46160);
        return;
      }
      if (AppBrandCameraView.i(AppBrandCameraView.this).EYy.aeU())
      {
        AppBrandCameraView.b(AppBrandCameraView.this, Util.currentTicks());
        AppBrandCameraView.a(AppBrandCameraView.this, 2);
        al(0, "");
        AppBrandCameraView.A(AppBrandCameraView.this);
        AppMethodBeat.o(46160);
        return;
      }
      Log.w("MicroMsg.AppBrandCameraView", "startRecord fail !!");
      al(-1, "startRecord fail");
      AppMethodBeat.o(46160);
    }
    
    public final void bRD()
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
    
    final void bRH()
    {
      AppMethodBeat.i(46163);
      AppBrandCameraView.E(AppBrandCameraView.this);
      AppBrandCameraView.a(AppBrandCameraView.this, false);
      AppMethodBeat.o(46163);
    }
    
    public final void bRt()
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
        public final void P(Bitmap paramAnonymousBitmap)
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
        
        public final void bRI()
        {
          AppMethodBeat.i(46152);
          AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "take picture error");
          AppMethodBeat.o(46152);
        }
      }, "on".equals(AppBrandCameraView.n(AppBrandCameraView.this)));
      AppMethodBeat.o(46158);
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
        public final void ij(boolean paramAnonymousBoolean)
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
          AppBrandCameraView.this.oLS = 1;
          if (paramAnonymousBoolean)
          {
            AppBrandCameraView.b.a(AppBrandCameraView.b.this, "stop error");
            AppBrandCameraView.b.this.bRH();
            AppMethodBeat.o(46153);
            return;
          }
          if (AppBrandCameraView.C(AppBrandCameraView.this))
          {
            AppBrandCameraView.b localb = AppBrandCameraView.b.this;
            com.tencent.e.h.ZvG.be(new AppBrandCameraView.b.3(localb));
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
    private float laP;
    private Point nrC;
    private com.tencent.mm.plugin.appbrand.jsapi.camera.a.c oMk;
    AtomicBoolean oMl;
    private int oMm;
    private Rect oMn;
    private int oMo;
    private int oMp;
    private int oMq;
    private int previewHeight;
    private int previewWidth;
    
    protected c()
    {
      AppMethodBeat.i(46171);
      this.oMl = new AtomicBoolean(false);
      this.oMm = 200;
      this.duration = this.oMm;
      this.laP = (AppBrandCameraView.G(AppBrandCameraView.this) * 1.0F / AppBrandCameraView.H(AppBrandCameraView.this));
      if (AppBrandCameraView.I(AppBrandCameraView.this)) {
        i = 1;
      }
      this.oMp = i;
      AppMethodBeat.o(46171);
    }
    
    public final void D(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int j = 0;
      AppMethodBeat.i(46173);
      int i;
      int k;
      label132:
      float f2;
      if ((this.previewWidth != AppBrandCameraView.G(AppBrandCameraView.this)) || (this.previewHeight != AppBrandCameraView.H(AppBrandCameraView.this))) {
        switch (AppBrandCameraView.L(AppBrandCameraView.this).getDefaultDisplay().getRotation())
        {
        default: 
          i = 0;
          k = AppBrandCameraView.i(AppBrandCameraView.this).getCameraRotation();
          if ("front".equals(AppBrandCameraView.M(AppBrandCameraView.this)))
          {
            this.oMo = (k % 360);
            this.oMo = ((360 - this.oMo) % 360);
            if (AppBrandCameraView.i(AppBrandCameraView.this) != null)
            {
              this.previewWidth = AppBrandCameraView.G(AppBrandCameraView.this);
              this.previewHeight = AppBrandCameraView.H(AppBrandCameraView.this);
            }
            AppBrandCameraView.G(AppBrandCameraView.this);
            AppBrandCameraView.H(AppBrandCameraView.this);
            k = this.oMo;
            f2 = this.laP;
            if ((paramInt1 > 0) && (paramInt2 > 0)) {
              break label323;
            }
            localObject = null;
            label203:
            this.nrC = ((Point)localObject);
            if (this.nrC != null)
            {
              localObject = AppBrandCameraView.K(AppBrandCameraView.this);
              i = AppBrandCameraView.G(AppBrandCameraView.this);
              j = this.nrC.x;
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
        this.oMn = ((Rect)localObject);
        if (!this.oMl.get()) {
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
        this.oMo = ((k - i + 360) % 360);
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
          this.oMp = 1;
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
      if ((this.oMk != null) && (AppBrandCameraView.i(AppBrandCameraView.this) != null)) {
        this.oMk.b(paramArrayOfByte, paramInt1, paramInt2, AppBrandCameraView.G(AppBrandCameraView.this), AppBrandCameraView.H(AppBrandCameraView.this), this.nrC, this.oMn, this.oMo, this.oMp);
      }
      AppMethodBeat.o(46173);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint)
    {
      AppMethodBeat.i(244321);
      if (this.oMl.compareAndSet(false, true))
      {
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46170);
            AppBrandCameraView.c.this.oMl.set(false);
            AppMethodBeat.o(46170);
          }
        }, this.duration);
        Log.d("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d, codeVersion:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if ((paramQBarPoint != null) && (this.oMq % 4 == 0))
        {
          Log.i("MicroMsg.AppBrandCameraView", "x: %f, y: %f, w: %f, h: %f; x0:%f, x1:%f, x2:%f, x3:%f, y0:%f, y1:%f, y2:%f, y3:%f", new Object[] { Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x1 - paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y3 - paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.x1), Float.valueOf(paramQBarPoint.x2), Float.valueOf(paramQBarPoint.x3), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.y1), Float.valueOf(paramQBarPoint.y2), Float.valueOf(paramQBarPoint.y3) });
          this.oMq += 1;
        }
      }
      switch (paramInt1)
      {
      default: 
        Log.w("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
        AppMethodBeat.o(244321);
        return;
      case 1: 
        j.a(AppBrandCameraView.g(AppBrandCameraView.this), AppBrandCameraView.this.getCameraId(), "qrcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
        AppMethodBeat.o(244321);
        return;
      }
      j.a(AppBrandCameraView.g(AppBrandCameraView.this), AppBrandCameraView.this.getCameraId(), "barcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
      AppMethodBeat.o(244321);
    }
    
    public final void bRC()
    {
      AppMethodBeat.i(46176);
      Log.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
      AppMethodBeat.o(46176);
    }
    
    public final void bRD()
    {
      AppMethodBeat.i(46177);
      Log.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
      AppMethodBeat.o(46177);
    }
    
    protected final void bRJ()
    {
      this.oMp = 1;
    }
    
    public final void bRt()
    {
      AppMethodBeat.i(46175);
      Log.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
      AppMethodBeat.o(46175);
    }
    
    public void init()
    {
      AppMethodBeat.i(46172);
      this.oMk = new com.tencent.mm.plugin.appbrand.jsapi.camera.a.d();
      this.oMk.init();
      this.oMk.oNg = this;
      AppBrandCameraView.a(AppBrandCameraView.this, 4);
      if (AppBrandCameraView.J(AppBrandCameraView.this) > 0) {
        this.duration = (1000 / AppBrandCameraView.J(AppBrandCameraView.this));
      }
      this.oMq = 0;
      AppMethodBeat.o(46172);
    }
    
    public final void release()
    {
      AppMethodBeat.i(46178);
      if (this.oMk != null) {
        this.oMk.release();
      }
      this.nrC = null;
      this.oMq = 0;
      AppMethodBeat.o(46178);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView
 * JD-Core Version:    0.7.0.1
 */