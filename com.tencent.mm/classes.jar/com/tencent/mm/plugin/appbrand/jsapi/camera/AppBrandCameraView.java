package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.e.d;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppBrandCameraView
  extends RelativeLayout
  implements d, e.b, e.c, e.d
{
  private ImageView bNu;
  private boolean goA = false;
  private int goB = 1080;
  private int goC = 1920;
  private int goD = 1080;
  private int goE = 1920;
  private Rect goF;
  private int goG;
  private c goH;
  private b goI;
  private MMSightRecordView goJ;
  private String goK;
  private String goL;
  private String goM;
  int goN = -1;
  private boolean goO = false;
  private long goP = -1L;
  private long goQ = -1L;
  MMSightRecordView.a goR = new AppBrandCameraView.3(this);
  private com.tencent.mm.plugin.appbrand.jsapi.e gos;
  private String got = "scanCode";
  private AppBrandCameraView.a gou;
  private int gov;
  private String gow = "back";
  private String gox = "auto";
  private String goy = "high";
  private boolean goz;
  private String mAppId;
  private Context mContext;
  
  public AppBrandCameraView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public static void aiE()
  {
    h.gpa = new AppBrandCameraView.1();
  }
  
  private void aiG()
  {
    y.i("MicroMsg.AppBrandCameraView", "initCamera.");
    if (!a.a.aiD().aiC())
    {
      Toast.makeText(this.mContext, y.j.mmsight_capture_init_error, 1).show();
      y.w("MicroMsg.AppBrandCameraView", "no permission");
      return;
    }
    if (this.goJ != null)
    {
      y.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
      return;
    }
    if (this.bNu == null)
    {
      this.bNu = new ImageView(this.mContext);
      this.bNu.setScaleType(ImageView.ScaleType.FIT_XY);
      addView(this.bNu, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      this.goJ = new MMSightRecordView(this.mContext);
      addView(this.goJ);
      this.goJ.setPreviewSizeLimit(720);
      this.goJ.mfG.Ze();
      this.goJ.setDisplayRatio(this.goB * 1.0F / this.goC);
      this.goJ.setVideoPara$2e715812(600000);
      this.goJ.setVideoFilePath(this.goK);
      this.goJ.setClipPictureSize(true);
      this.goJ.setClipVideoSize(true);
      this.goJ.setUseBackCamera("back".equals(this.gow));
      this.goJ.setFrameDataCallback(this.goR);
      this.goJ.mfG.startPreview();
      this.goJ.mfG.YY();
      this.goJ.setInitErrorCallback(new AppBrandCameraView.2(this));
      this.goN = 1;
      return;
      this.bNu.setImageBitmap(null);
    }
  }
  
  private void aiI()
  {
    this.goM = (com.tencent.mm.compatible.util.e.dzD + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
  }
  
  private void aiJ()
  {
    String str = "MicroMsg_" + System.currentTimeMillis();
    this.goK = (com.tencent.mm.compatible.util.e.dzD + str + ".mp4");
    this.goL = (com.tencent.mm.compatible.util.e.dzD + str + ".jpeg");
    if (this.goJ != null) {
      this.goJ.setVideoFilePath(this.goK);
    }
  }
  
  private void aiK()
  {
    if ((this.goJ == null) || (this.gox == null)) {}
    do
    {
      return;
      if ((this.goN == 2) || (this.goN == 4)) {
        break;
      }
      if (this.goJ.getFlashMode() == 1) {
        this.goJ.setFlashMode(2);
      }
    } while (!this.gox.equals("auto"));
    this.goJ.setFlashMode(3);
    return;
    if (this.gox.equals("on"))
    {
      this.goJ.setFlashMode(1);
      return;
    }
    this.goJ.setFlashMode(2);
  }
  
  private void aiL()
  {
    y.i("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", new Object[] { this.got });
    aiM();
    if ((!bk.bl(this.got)) && (this.got.equals("scanCode"))) {}
    for (this.gou = new AppBrandCameraView.c(this, (byte)0);; this.gou = new b((byte)0))
    {
      this.gou.init();
      return;
    }
  }
  
  private void aiM()
  {
    if (this.gou != null)
    {
      this.gou.release();
      this.gou = null;
    }
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(y.h.app_brand_camera_container, this);
  }
  
  public final void ae(String paramString, boolean paramBoolean)
  {
    if (bk.isEqual(this.gow, paramString)) {}
    do
    {
      do
      {
        return;
      } while (bk.isEqual(this.got, "scanCode"));
      this.gow = paramString;
    } while ((paramBoolean) || (this.goJ == null));
    this.goJ.mfG.switchCamera();
  }
  
  public final void aiF()
  {
    if (this.gou != null) {
      this.gou.aiF();
    }
  }
  
  public final void aiH()
  {
    if (this.goJ == null)
    {
      y.i("MicroMsg.AppBrandCameraView", "recordView is null");
      return;
    }
    aiL();
    aiK();
  }
  
  public final void aiN()
  {
    if (this.gou != null) {
      this.gou.aiN();
    }
  }
  
  public final boolean bV(int paramInt1, int paramInt2)
  {
    if ((this.goB == paramInt1) && (this.goC == paramInt2)) {
      return false;
    }
    y.i("MicroMsg.AppBrandCameraView", "setViewSize");
    this.goB = paramInt1;
    this.goC = paramInt2;
    return true;
  }
  
  public int getCameraId()
  {
    return this.gov;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void initView()
  {
    y.i("MicroMsg.AppBrandCameraView", "initView");
    if (!a.a.aiD().aiC()) {
      return;
    }
    aiJ();
    aiI();
    aiG();
    aiH();
  }
  
  public final void o(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.i("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
      return;
    }
    this.goF = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  public final void onDestroy()
  {
    release();
    aiM();
  }
  
  public final void pY()
  {
    y.i("MicroMsg.AppBrandCameraView", "onUIResume");
    try
    {
      aiG();
      aiL();
      return;
    }
    finally {}
  }
  
  public final void qa()
  {
    y.i("MicroMsg.AppBrandCameraView", "onUIPause");
    if (this.goN == 2)
    {
      y.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(this.gov));
      ((Map)localObject).put("errMsg", "stop on record");
      localObject = new JSONObject((Map)localObject).toString();
      new i().e(this.gos).tM((String)localObject).dispatch();
    }
    if (this.goJ != null)
    {
      localObject = this.goJ.getCurrentFramePicture();
      if (localObject != null) {
        this.bNu.setImageBitmap((Bitmap)localObject);
      }
    }
    release();
    aiM();
    Object localObject = new HashMap();
    ((Map)localObject).put("cameraId", Integer.valueOf(getCameraId()));
    localObject = new JSONObject((Map)localObject).toString();
    new g().e(this.gos).tM((String)localObject).dispatch();
  }
  
  public final void release()
  {
    y.i("MicroMsg.AppBrandCameraView", "release");
    try
    {
      if (this.goJ != null)
      {
        this.goJ.mfG.release();
        removeView(this.goJ);
        this.goN = -1;
        this.goJ = null;
      }
      return;
    }
    finally {}
  }
  
  public void setAppId(String paramString)
  {
    this.mAppId = paramString;
  }
  
  public void setCameraId(int paramInt)
  {
    this.gov = paramInt;
  }
  
  public void setFlash(String paramString)
  {
    if (bk.isEqual(this.gox, paramString)) {
      return;
    }
    this.gox = paramString;
  }
  
  public void setMode(String paramString)
  {
    this.got = paramString;
  }
  
  public void setNeedOutput(boolean paramBoolean)
  {
    this.goz = paramBoolean;
  }
  
  public void setOperateCallBack(c paramc)
  {
    this.goH = paramc;
  }
  
  public void setOutPutCallBack(b paramb)
  {
    this.goI = paramb;
  }
  
  public void setPage(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    this.gos = parame;
  }
  
  public void setQuality(String paramString)
  {
    if (bk.isEqual(this.goy, paramString)) {
      return;
    }
    this.goy = paramString;
  }
  
  public void setScanFreq(int paramInt)
  {
    y.i("MicroMsg.AppBrandCameraView", "scanFreq:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      y.e("MicroMsg.AppBrandCameraView", "scanFreq is err");
      return;
    }
    this.goG = paramInt;
  }
  
  public final void startRecord()
  {
    if (this.gou != null) {
      this.gou.startRecord();
    }
  }
  
  private final class b
    implements AppBrandCameraView.a
  {
    private b() {}
    
    private void H(int paramInt, String paramString)
    {
      if (AppBrandCameraView.o(AppBrandCameraView.this) != null) {
        AppBrandCameraView.o(AppBrandCameraView.this).H(paramInt, paramString);
      }
    }
    
    private void c(int paramInt, String paramString1, String paramString2, String paramString3)
    {
      if (AppBrandCameraView.o(AppBrandCameraView.this) != null) {
        AppBrandCameraView.o(AppBrandCameraView.this).c(paramInt, paramString1, g(AppBrandCameraView.b(AppBrandCameraView.this), paramString2), g(AppBrandCameraView.b(AppBrandCameraView.this), paramString3));
      }
      AppBrandCameraView.n(AppBrandCameraView.this);
    }
    
    static String g(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString)
    {
      if (bk.bl(paramString)) {
        return paramString;
      }
      com.tencent.mm.plugin.appbrand.u.k localk = new com.tencent.mm.plugin.appbrand.u.k();
      if (paramc.Zl().a(new File(paramString), "", true, localk) == h.fGU) {
        return (String)localk.value;
      }
      return null;
    }
    
    final boolean a(Bitmap paramBitmap, String paramString)
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        try
        {
          int i = paramBitmap.getWidth();
          int j = paramBitmap.getHeight();
          Bitmap localBitmap = paramBitmap;
          if (i != 0)
          {
            localBitmap = paramBitmap;
            if (j != 0)
            {
              if (!"normal".equals(AppBrandCameraView.l(AppBrandCameraView.this))) {
                break label132;
              }
              localBitmap = com.tencent.mm.sdk.platformtools.c.a(paramBitmap, j * 2 / 3, i * 2 / 3, false, true);
            }
          }
          for (;;)
          {
            AppBrandCameraView.b(AppBrandCameraView.this, localBitmap.getWidth());
            AppBrandCameraView.c(AppBrandCameraView.this, localBitmap.getHeight());
            com.tencent.mm.sdk.platformtools.c.a(localBitmap, 90, Bitmap.CompressFormat.JPEG, paramString, true);
            y.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", new Object[] { Long.valueOf(com.tencent.mm.vfs.e.aeQ(paramString)) });
            return true;
            label132:
            localBitmap = paramBitmap;
            if ("low".equals(AppBrandCameraView.l(AppBrandCameraView.this))) {
              localBitmap = com.tencent.mm.sdk.platformtools.c.a(paramBitmap, j / 2, i / 2, false, true);
            }
          }
          return false;
        }
        catch (Exception paramBitmap)
        {
          y.e("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", new Object[] { paramBitmap.getMessage() });
        }
      }
    }
    
    public final void aiF()
    {
      y.i("MicroMsg.AppBrandCameraView", "takePicture.");
      if (AppBrandCameraView.e(AppBrandCameraView.this) == null)
      {
        y.i("MicroMsg.AppBrandCameraView", "recordView is null");
        return;
      }
      if (AppBrandCameraView.f(AppBrandCameraView.this) == 2)
      {
        y.w("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
        return;
      }
      if ((AppBrandCameraView.g(AppBrandCameraView.this)) || (bk.cp(AppBrandCameraView.h(AppBrandCameraView.this)) < 300L))
      {
        y.i("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
        return;
      }
      AppBrandCameraView.a(AppBrandCameraView.this, bk.UZ());
      AppBrandCameraView.i(AppBrandCameraView.this);
      AppBrandCameraView.a(AppBrandCameraView.this, 3);
      AppBrandCameraView.e(AppBrandCameraView.this).a(new AppBrandCameraView.b.1(this), "on".equals(AppBrandCameraView.k(AppBrandCameraView.this)));
    }
    
    public final void aiN()
    {
      long l = bk.cp(AppBrandCameraView.u(AppBrandCameraView.this));
      if (l < 1500L)
      {
        y.i("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", new Object[] { Long.valueOf(1500L - l) });
        ai.l(new AppBrandCameraView.b.3(this), 1500L - l);
        return;
      }
      stopRecord();
    }
    
    public final void init() {}
    
    public final void n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (!AppBrandCameraView.d(AppBrandCameraView.this)) {}
    }
    
    public final void release() {}
    
    public final void startRecord()
    {
      y.i("MicroMsg.AppBrandCameraView", "startRecord.");
      a locala = a.a.aiD();
      if ((!locala.gon) || (!locala.goo)) {
        y.i("MicroMsg.AppBrandCameraMrg", "no all permission");
      }
      if ((locala.gon) && (locala.goo)) {}
      for (int i = 1; i == 0; i = 0)
      {
        Toast.makeText(AppBrandCameraView.m(AppBrandCameraView.this), y.j.mmsight_capture_init_error, 1).show();
        y.w("MicroMsg.AppBrandCameraView", "no micro phone permission");
        H(-1, "permission");
        return;
      }
      if (AppBrandCameraView.f(AppBrandCameraView.this) == 2)
      {
        y.w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
        H(-1, "is recording");
        return;
      }
      AppBrandCameraView.b(AppBrandCameraView.this, bk.UZ());
      AppBrandCameraView.e(AppBrandCameraView.this).mfG.uq();
      AppBrandCameraView.a(AppBrandCameraView.this, 2);
      H(0, "");
      AppBrandCameraView.n(AppBrandCameraView.this);
    }
    
    public final void stopRecord()
    {
      y.i("MicroMsg.AppBrandCameraView", "stopRecord");
      if (AppBrandCameraView.e(AppBrandCameraView.this) == null)
      {
        y.i("MicroMsg.AppBrandCameraView", "recordView is null");
        c(-1, "camera is null", null, null);
        return;
      }
      if (AppBrandCameraView.f(AppBrandCameraView.this) != 2)
      {
        y.w("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
        c(-1, "is not recording", null, null);
        return;
      }
      if (AppBrandCameraView.p(AppBrandCameraView.this))
      {
        y.i("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
        c(-1, "is stopping", null, null);
        return;
      }
      AppBrandCameraView.a(AppBrandCameraView.this, true);
      AppBrandCameraView.e(AppBrandCameraView.this).a(new AppBrandCameraView.b.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView
 * JD-Core Version:    0.7.0.1
 */