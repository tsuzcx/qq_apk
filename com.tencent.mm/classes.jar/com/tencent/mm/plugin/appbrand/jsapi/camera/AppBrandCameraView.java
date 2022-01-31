package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.p;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppBrandCameraView
  extends RelativeLayout
  implements e, f.b, f.c, f.d
{
  private String bGU;
  private ImageView cuM;
  private String fcq;
  private int hIA;
  private int hIB;
  private Rect hIC;
  private int hID;
  private c hIE;
  private b hIF;
  private MMSightRecordView hIG;
  private String hIH;
  private String hII;
  int hIJ;
  private boolean hIK;
  private long hIL;
  private long hIM;
  private d hIN;
  private boolean hIO;
  MMSightRecordView.a hIP;
  private com.tencent.mm.plugin.appbrand.jsapi.e hIo;
  private String hIp;
  private int hIq;
  private AppBrandCameraView.a hIr;
  private int hIs;
  private String hIt;
  private String hIu;
  private boolean hIv;
  private boolean hIw;
  private boolean hIx;
  private int hIy;
  private int hIz;
  private String mAppId;
  private Context mContext;
  
  public AppBrandCameraView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(130937);
    this.hIp = "scanCode";
    this.bGU = "back";
    this.hIt = "auto";
    this.hIu = "high";
    this.hIv = false;
    this.hIx = false;
    this.hIy = 1080;
    this.hIz = 1920;
    this.hIA = 1080;
    this.hIB = 1920;
    this.hIJ = -1;
    this.hIK = false;
    this.hIL = -1L;
    this.hIM = -1L;
    this.hIP = new AppBrandCameraView.4(this);
    init(paramContext);
    AppMethodBeat.o(130937);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(130938);
    this.hIp = "scanCode";
    this.bGU = "back";
    this.hIt = "auto";
    this.hIu = "high";
    this.hIv = false;
    this.hIx = false;
    this.hIy = 1080;
    this.hIz = 1920;
    this.hIA = 1080;
    this.hIB = 1920;
    this.hIJ = -1;
    this.hIK = false;
    this.hIL = -1L;
    this.hIM = -1L;
    this.hIP = new AppBrandCameraView.4(this);
    init(paramContext);
    AppMethodBeat.o(130938);
  }
  
  public AppBrandCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(130939);
    this.hIp = "scanCode";
    this.bGU = "back";
    this.hIt = "auto";
    this.hIu = "high";
    this.hIv = false;
    this.hIx = false;
    this.hIy = 1080;
    this.hIz = 1920;
    this.hIA = 1080;
    this.hIB = 1920;
    this.hIJ = -1;
    this.hIK = false;
    this.hIL = -1L;
    this.hIM = -1L;
    this.hIP = new AppBrandCameraView.4(this);
    init(paramContext);
    AppMethodBeat.o(130939);
  }
  
  private void aCB()
  {
    AppMethodBeat.i(130952);
    ab.i("MicroMsg.AppBrandCameraView", "initCamera.");
    if (!a.a.aCy().aCx())
    {
      Toast.makeText(this.mContext, 2131301569, 1).show();
      ab.w("MicroMsg.AppBrandCameraView", "no permission");
      AppMethodBeat.o(130952);
      return;
    }
    if (this.hIG != null)
    {
      ab.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
      AppMethodBeat.o(130952);
      return;
    }
    if (this.cuM == null)
    {
      this.cuM = new ImageView(this.mContext);
      this.cuM.setScaleType(ImageView.ScaleType.FIT_XY);
      addView(this.cuM, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      this.hIG = new MMSightRecordView(this.mContext);
      this.hIO = false;
      addView(this.hIG);
      this.hIG.setPreviewSizeLimit(720);
      this.hIG.setRGBSizeLimit(this.hIq);
      this.hIG.oGg.asN();
      this.hIG.setDisplayRatio(this.hIy * 1.0F / this.hIz);
      this.hIG.setVideoPara$2e715812(600000);
      this.hIG.setVideoFilePath(this.hIH);
      this.hIG.setClipPictureSize(true);
      this.hIG.setClipVideoSize(true);
      this.hIG.setUseBackCamera("back".equals(this.bGU));
      this.hIG.setFrameDataCallback(this.hIP);
      this.hIG.setInitErrorCallback(new AppBrandCameraView.2(this));
      this.hIG.setInitDoneCallback(new AppBrandCameraView.3(this));
      this.hIG.oGg.startPreview();
      this.hIG.oGg.asH();
      this.hIJ = 1;
      AppMethodBeat.o(130952);
      return;
      this.cuM.setImageBitmap(null);
    }
  }
  
  private void aCE()
  {
    AppMethodBeat.i(130956);
    this.fcq = (com.tencent.mm.compatible.util.e.esr + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    AppMethodBeat.o(130956);
  }
  
  private void aCF()
  {
    AppMethodBeat.i(130957);
    String str = "MicroMsg_" + System.currentTimeMillis();
    this.hIH = (com.tencent.mm.compatible.util.e.esr + str + ".mp4");
    this.hII = (com.tencent.mm.compatible.util.e.esr + str + ".jpeg");
    if (this.hIG != null) {
      this.hIG.setVideoFilePath(this.hIH);
    }
    AppMethodBeat.o(130957);
  }
  
  private void aCG()
  {
    AppMethodBeat.i(130958);
    if ((this.hIG == null) || (this.hIt == null))
    {
      AppMethodBeat.o(130958);
      return;
    }
    if (this.hIt.equals("auto"))
    {
      this.hIG.setFlashMode(3);
      AppMethodBeat.o(130958);
      return;
    }
    if (this.hIt.equals("torch"))
    {
      this.hIG.setFlashMode(1);
      AppMethodBeat.o(130958);
      return;
    }
    if (this.hIt.equals("on"))
    {
      if ((this.hIJ == 2) || (this.hIJ == 4) || (!this.hIt.equals("on")))
      {
        this.hIG.setFlashMode(1);
        AppMethodBeat.o(130958);
      }
    }
    else if (this.hIt.equals("torch"))
    {
      this.hIG.setFlashMode(1);
      AppMethodBeat.o(130958);
      return;
    }
    this.hIG.setFlashMode(2);
    AppMethodBeat.o(130958);
  }
  
  private void aCH()
  {
    AppMethodBeat.i(130959);
    ab.i("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", new Object[] { this.hIp });
    aCI();
    if ((!bo.isNullOrNil(this.hIp)) && (this.hIp.equals("scanCode"))) {}
    for (this.hIr = new AppBrandCameraView.c(this, (byte)0);; this.hIr = new AppBrandCameraView.b(this, (byte)0))
    {
      this.hIr.init();
      AppMethodBeat.o(130959);
      return;
    }
  }
  
  private void aCI()
  {
    AppMethodBeat.i(130960);
    if (this.hIr != null)
    {
      this.hIr.release();
      this.hIr = null;
    }
    AppMethodBeat.o(130960);
  }
  
  public static void aCz()
  {
    AppMethodBeat.i(130936);
    j.hJe = new AppBrandCameraView.1();
    AppMethodBeat.o(130936);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(130940);
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2130968666, this);
    AppMethodBeat.o(130940);
  }
  
  public final void aCA()
  {
    AppMethodBeat.i(130951);
    if (this.hIr != null) {
      this.hIr.aCA();
    }
    AppMethodBeat.o(130951);
  }
  
  public final void aCC()
  {
    AppMethodBeat.i(130953);
    if (this.hIG == null)
    {
      ab.i("MicroMsg.AppBrandCameraView", "recordView is null");
      AppMethodBeat.o(130953);
      return;
    }
    aCH();
    aCG();
    AppMethodBeat.o(130953);
  }
  
  public final void aCD()
  {
    AppMethodBeat.i(130955);
    if (this.hIE == null)
    {
      AppMethodBeat.o(130955);
      return;
    }
    if (this.hIN == null)
    {
      AppMethodBeat.o(130955);
      return;
    }
    this.hIN.a(this.hIG);
    this.hIN = null;
    AppMethodBeat.o(130955);
  }
  
  public final void aCJ()
  {
    AppMethodBeat.i(130963);
    if (this.hIr != null) {
      this.hIr.aCJ();
    }
    AppMethodBeat.o(130963);
  }
  
  public final void aCK()
  {
    AppMethodBeat.i(130964);
    if (this.hIr != null) {
      this.hIr.aCK();
    }
    AppMethodBeat.o(130964);
  }
  
  public final void aj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(130943);
    if (bo.isEqual(this.bGU, paramString))
    {
      AppMethodBeat.o(130943);
      return;
    }
    if (bo.isEqual(this.hIp, "scanCode"))
    {
      AppMethodBeat.o(130943);
      return;
    }
    this.bGU = paramString;
    if ((!paramBoolean) && (this.hIG != null)) {
      this.hIG.oGg.switchCamera();
    }
    AppMethodBeat.o(130943);
  }
  
  public final boolean dg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130946);
    if ((this.hIy == paramInt1) && (this.hIz == paramInt2))
    {
      AppMethodBeat.o(130946);
      return false;
    }
    ab.i("MicroMsg.AppBrandCameraView", "setViewSize");
    this.hIy = paramInt1;
    this.hIz = paramInt2;
    AppMethodBeat.o(130946);
    return true;
  }
  
  public int getCameraId()
  {
    return this.hIs;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(130941);
    ab.i("MicroMsg.AppBrandCameraView", "initView");
    if (!a.a.aCy().aCx())
    {
      AppMethodBeat.o(130941);
      return;
    }
    aCF();
    aCE();
    aCB();
    aCC();
    AppMethodBeat.o(130941);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(130947);
    ab.i("MicroMsg.AppBrandCameraView", "onUIPause");
    Object localObject;
    if (this.hIJ == 2)
    {
      ab.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(this.hIs));
      ((Map)localObject).put("errMsg", "stop on record");
      localObject = new JSONObject((Map)localObject).toString();
      new k().j(this.hIo).BN((String)localObject).aBz();
    }
    if (this.hIG != null)
    {
      localObject = this.hIG.getCurrentFramePicture();
      if (localObject != null) {
        this.cuM.setImageBitmap((Bitmap)localObject);
      }
    }
    MMSightRecordView localMMSightRecordView;
    if (this.hIN != null)
    {
      localObject = this.hIN;
      localMMSightRecordView = this.hIG;
      ab.i("MicroMsg.FrameDataCallbackHelper", "onUIPause mNeedCallback:%b", new Object[] { Boolean.valueOf(((d)localObject).hIZ) });
      if (localMMSightRecordView != null) {
        break label250;
      }
      ab.w("MicroMsg.FrameDataCallbackHelper", "onUIPause recordView null");
    }
    for (;;)
    {
      release();
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(getCameraId()));
      localObject = new JSONObject((Map)localObject).toString();
      new i().j(this.hIo).BN((String)localObject).aBz();
      AppMethodBeat.o(130947);
      return;
      label250:
      localMMSightRecordView.a(null, null);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(130949);
    if (this.hIN != null) {
      this.hIN.a(this.hIG);
    }
    release();
    AppMethodBeat.o(130949);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(130948);
    ab.i("MicroMsg.AppBrandCameraView", "onUIResume");
    for (;;)
    {
      MMSightRecordView localMMSightRecordView;
      try
      {
        aCB();
        aCH();
        aCG();
        d locald;
        if (this.hIN != null)
        {
          locald = this.hIN;
          localMMSightRecordView = this.hIG;
          ab.i("MicroMsg.FrameDataCallbackHelper", "onUIResume mNeedCallback:%b", new Object[] { Boolean.valueOf(locald.hIZ) });
          if (locald.hIZ)
          {
            if (localMMSightRecordView != null) {
              continue;
            }
            ab.w("MicroMsg.FrameDataCallbackHelper", "onUIResume recordView null");
          }
        }
        return;
        if (locald.hJa == -2147483648)
        {
          ab.w("MicroMsg.FrameDataCallbackHelper", "onUIResume invalid mCurrentSharedBufferId");
          continue;
        }
        if (localf.hIY != null) {
          break label152;
        }
      }
      finally
      {
        AppMethodBeat.o(130948);
      }
      ab.w("MicroMsg.FrameDataCallbackHelper", "onUIResume mSharedBufferAddon null");
      continue;
      label152:
      localMMSightRecordView.a(localf.hIY.oz(localf.hJa), localf);
    }
  }
  
  public final void p(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(130954);
    if (this.hIE == null)
    {
      AppMethodBeat.o(130954);
      return;
    }
    if (this.hIG == null)
    {
      ab.w("MicroMsg.AppBrandCameraView", "listenFrameChange recordView null");
      this.hIE.g("camera illegal state", -1, -1, -1);
      AppMethodBeat.o(130954);
      return;
    }
    if (this.hIN == null) {
      this.hIN = new d(paramc);
    }
    int j = this.hIG.getDrawSizePoint().x;
    int k = this.hIG.getDrawSizePoint().y;
    paramc = this.hIN;
    MMSightRecordView localMMSightRecordView = this.hIG;
    int i;
    if (localMMSightRecordView == null)
    {
      ab.w("MicroMsg.FrameDataCallbackHelper", "listenFrameChange recordView null");
      i = -1;
    }
    while (i < 0)
    {
      this.hIE.g(String.format("illegal state:%d", new Object[] { Integer.valueOf(i) }), -1, -1, -1);
      AppMethodBeat.o(130954);
      return;
      if (paramc.hIY == null)
      {
        i = -2;
      }
      else
      {
        if (paramc.hJa != -2147483648)
        {
          ab.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange destroy last one bufferId:%d", new Object[] { Integer.valueOf(paramc.hJa) });
          paramc.hIY.oy(paramc.hJa);
        }
        paramc.hJa = paramc.hIY.oA(j * k * 4);
        ab.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange bufferId:%d height:%d width:%d", new Object[] { Integer.valueOf(paramc.hJa), Integer.valueOf(k), Integer.valueOf(j) });
        paramc.hIZ = true;
        localMMSightRecordView.a(paramc.hIY.oz(paramc.hJa), paramc);
        i = paramc.hJa;
      }
    }
    this.hIE.g(null, i, j, k);
    AppMethodBeat.o(130954);
  }
  
  public final void release()
  {
    AppMethodBeat.i(130950);
    ab.i("MicroMsg.AppBrandCameraView", "release");
    try
    {
      if (this.hIG != null)
      {
        this.hIG.oGg.release();
        removeView(this.hIG);
        this.hIJ = -1;
        this.hIG = null;
      }
      aCI();
      AppMethodBeat.o(130950);
      return;
    }
    finally
    {
      AppMethodBeat.o(130950);
    }
  }
  
  public void setAppId(String paramString)
  {
    this.mAppId = paramString;
  }
  
  public void setCameraId(int paramInt)
  {
    this.hIs = paramInt;
  }
  
  public void setCompressRecord(boolean paramBoolean)
  {
    this.hIv = paramBoolean;
  }
  
  public void setFlash(String paramString)
  {
    AppMethodBeat.i(130944);
    if (bo.isEqual(this.hIt, paramString))
    {
      AppMethodBeat.o(130944);
      return;
    }
    this.hIt = paramString;
    AppMethodBeat.o(130944);
  }
  
  public void setFrameLimitSize(int paramInt)
  {
    AppMethodBeat.i(130942);
    ab.i("MicroMsg.AppBrandCameraView", "setFrameLimitSize:%d", new Object[] { Integer.valueOf(paramInt) });
    this.hIq = paramInt;
    AppMethodBeat.o(130942);
  }
  
  public void setMode(String paramString)
  {
    this.hIp = paramString;
  }
  
  public void setNeedOutput(boolean paramBoolean)
  {
    this.hIw = paramBoolean;
  }
  
  public void setOperateCallBack(c paramc)
  {
    this.hIE = paramc;
  }
  
  public void setOutPutCallBack(b paramb)
  {
    this.hIF = paramb;
  }
  
  public void setPage(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    this.hIo = parame;
  }
  
  public void setQuality(String paramString)
  {
    AppMethodBeat.i(130945);
    if (bo.isEqual(this.hIu, paramString))
    {
      AppMethodBeat.o(130945);
      return;
    }
    this.hIu = paramString;
    AppMethodBeat.o(130945);
  }
  
  public void setScanFreq(int paramInt)
  {
    AppMethodBeat.i(130961);
    ab.i("MicroMsg.AppBrandCameraView", "scanFreq:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      ab.e("MicroMsg.AppBrandCameraView", "scanFreq is err");
      AppMethodBeat.o(130961);
      return;
    }
    this.hID = paramInt;
    AppMethodBeat.o(130961);
  }
  
  public final void w(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(130962);
    ab.i("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((paramInt3 <= 0) || (paramInt4 <= 0))
    {
      AppMethodBeat.o(130962);
      return;
    }
    this.hIC = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    AppMethodBeat.o(130962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView
 * JD-Core Version:    0.7.0.1
 */