package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.b;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class AppBrandVideoWrapper
  extends RelativeLayout
  implements e, e.c
{
  private static f lpY;
  private boolean bzN;
  private boolean dDV;
  private boolean hyd;
  protected int lpK;
  private e.c lpU;
  private e lpX;
  private e.b lpZ;
  private e.h lqa;
  private float lqb;
  private int lqc;
  private a lqd;
  private boolean lqe;
  private Context mContext;
  private String url;
  
  public AppBrandVideoWrapper(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppBrandVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppBrandVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(46921);
    this.lqa = e.h.lqo;
    this.hyd = false;
    this.lqb = -1.0F;
    this.lpK = 0;
    this.lqe = true;
    this.mContext = paramContext;
    this.lqd = new a();
    AppMethodBeat.o(46921);
  }
  
  public static void setVideoViewFactory(f paramf)
  {
    lpY = paramf;
  }
  
  public final boolean aE(float paramFloat)
  {
    AppMethodBeat.i(46947);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(46947);
      return false;
    }
    this.lqb = paramFloat;
    if (this.lpX != null)
    {
      boolean bool = this.lpX.aE(this.lqb);
      AppMethodBeat.o(46947);
      return bool;
    }
    AppMethodBeat.o(46947);
    return false;
  }
  
  public final boolean bip()
  {
    AppMethodBeat.i(46937);
    if (this.lpX != null)
    {
      boolean bool = this.lpX.bip();
      AppMethodBeat.o(46937);
      return bool;
    }
    AppMethodBeat.o(46937);
    return false;
  }
  
  public final void bns()
  {
    AppMethodBeat.i(210949);
    ae.i("MicroMsg.Video.AppBrandVideoWrapper", "%s preload video url %s", new Object[] { Integer.valueOf(hashCode()), this.url });
    if (!bu.isNullOrNil(this.url)) {
      this.lpX.bns();
    }
    AppMethodBeat.o(210949);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46949);
    ae.w("MicroMsg.Video.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.lpU != null) {
      this.lpU.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46949);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(46922);
    this.lqc = paramInt;
    this.bzN = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!bu.isNullOrNil(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.dDV = paramBoolean;
      this.url = localPString.value;
      if (this.lpX != null) {
        break label247;
      }
      this.lpX = lpY.dz(this.mContext);
      this.lpX.setVideoSource(this.lpK);
      this.lpX.setIMMVideoViewCallback(this);
    }
    for (paramInt = i;; paramInt = 0)
    {
      setScaleType(this.lqa);
      aE(this.lqb);
      setMute(this.hyd);
      if (paramInt != 0)
      {
        setVideoFooterView(this.lpZ);
        paramString = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.lpX.getView(), paramString);
      }
      this.lpX.c(this.bzN, this.url, this.lqc);
      com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "AppBrandVideo_checkVideoUrl";
        }
        
        public final void run()
        {
          AppMethodBeat.i(210948);
          AppBrandVideoWrapper.a(AppBrandVideoWrapper.this);
          AppMethodBeat.o(210948);
        }
      });
      AppMethodBeat.o(46922);
      return;
      paramBoolean = false;
      break;
      label247:
      this.lpX.stop();
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(46929);
    if (this.lpX != null)
    {
      paramBoolean = this.lpX.c(paramDouble, paramBoolean);
      AppMethodBeat.o(46929);
      return paramBoolean;
    }
    AppMethodBeat.o(46929);
    return false;
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46952);
    ae.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.lpU != null) {
      this.lpU.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46952);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46950);
    ae.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.lpU != null) {
      this.lpU.ds(paramString1, paramString2);
    }
    AppMethodBeat.o(46950);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46951);
    ae.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.lpU != null) {
      this.lpU.dt(paramString1, paramString2);
    }
    AppMethodBeat.o(46951);
  }
  
  public final void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46953);
    ae.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    if (this.lqe) {
      this.lqd.bog();
    }
    if (this.lpU != null) {
      this.lpU.du(paramString1, paramString2);
    }
    AppMethodBeat.o(46953);
  }
  
  public final void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46954);
    ae.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    if (this.lqe) {
      this.lqd.bof();
    }
    if (this.lpU != null) {
      this.lpU.dv(paramString1, paramString2);
    }
    AppMethodBeat.o(46954);
  }
  
  public final void dw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46955);
    if (this.lpU != null) {
      this.lpU.dw(paramString1, paramString2);
    }
    AppMethodBeat.o(46955);
  }
  
  public final void dx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46956);
    if (this.lpU != null) {
      this.lpU.dx(paramString1, paramString2);
    }
    AppMethodBeat.o(46956);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(46935);
    if (this.lpX != null)
    {
      int i = this.lpX.getCacheTimeSec();
      AppMethodBeat.o(46935);
      return i;
    }
    AppMethodBeat.o(46935);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(46933);
    if (this.lpX != null)
    {
      int i = this.lpX.getCurrPosMs();
      AppMethodBeat.o(46933);
      return i;
    }
    AppMethodBeat.o(46933);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(46934);
    if (this.lpX != null)
    {
      int i = this.lpX.getCurrPosSec();
      AppMethodBeat.o(46934);
      return i;
    }
    AppMethodBeat.o(46934);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(46927);
    if (this.lpX != null)
    {
      int i = this.lpX.getPlayerType();
      AppMethodBeat.o(46927);
      return i;
    }
    AppMethodBeat.o(46927);
    return 0;
  }
  
  public TextureView getTexture()
  {
    AppMethodBeat.i(210951);
    if ((this.lpX != null) && ((this.lpX.getView() instanceof b)))
    {
      TextureView localTextureView = ((b)this.lpX.getView()).getVideoTexture();
      AppMethodBeat.o(210951);
      return localTextureView;
    }
    AppMethodBeat.o(210951);
    return null;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(46932);
    if (this.lpX != null)
    {
      i = this.lpX.getVideoDurationSec();
      AppMethodBeat.o(46932);
      return i;
    }
    int i = this.lqc;
    AppMethodBeat.o(46932);
    return i;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(46936);
    if (this.lpX != null)
    {
      boolean bool = this.lpX.isPlaying();
      AppMethodBeat.o(46936);
      return bool;
    }
    AppMethodBeat.o(46936);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(46928);
    if (this.lpX != null)
    {
      boolean bool = this.lpX.o(paramDouble);
      AppMethodBeat.o(46928);
      return bool;
    }
    AppMethodBeat.o(46928);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(46945);
    if (this.lpX != null) {
      this.lpX.onUIDestroy();
    }
    if (this.lqe) {
      this.lqd.bog();
    }
    setKeepScreenOn(false);
    AppMethodBeat.o(46945);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(46944);
    if (this.lpX != null) {
      this.lpX.onUIPause();
    }
    if (this.lqe) {
      this.lqd.bog();
    }
    setKeepScreenOn(false);
    AppMethodBeat.o(46944);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(46943);
    if (this.lpX != null) {
      this.lpX.onUIResume();
    }
    AppMethodBeat.o(46943);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(46941);
    if (this.lpX != null)
    {
      setKeepScreenOn(false);
      if (this.lqe) {
        this.lqd.bog();
      }
      boolean bool = this.lpX.pause();
      AppMethodBeat.o(46941);
      return bool;
    }
    AppMethodBeat.o(46941);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(46938);
    if (this.lpX != null) {
      this.lpX.setCover(paramBitmap);
    }
    AppMethodBeat.o(46938);
  }
  
  public void setFocusAudio(boolean paramBoolean)
  {
    this.lqe = paramBoolean;
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(46931);
    if (this.lpX != null) {
      this.lpX.setFullDirection(paramInt);
    }
    AppMethodBeat.o(46931);
  }
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.lpU = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(46930);
    if (this.lpX != null) {
      this.lpX.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(46930);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(46957);
    ae.d("MicroMsg.Video.AppBrandVideoWrapper", "set keep screen on:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(46957);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(46942);
    this.hyd = paramBoolean;
    if (this.lpX != null) {
      this.lpX.setMute(this.hyd);
    }
    AppMethodBeat.o(46942);
  }
  
  public void setScaleType(e.h paramh)
  {
    AppMethodBeat.i(46946);
    this.lqa = paramh;
    if (this.lpX != null) {
      this.lpX.setScaleType(this.lqa);
    }
    AppMethodBeat.o(46946);
  }
  
  public void setVideoFooterView(e.b paramb)
  {
    AppMethodBeat.i(210950);
    this.lpZ = paramb;
    if (this.lpX != null) {
      this.lpX.setVideoFooterView(this.lpZ);
    }
    AppMethodBeat.o(210950);
  }
  
  public void setVideoSource(int paramInt)
  {
    this.lpK = paramInt;
  }
  
  public final void start()
  {
    AppMethodBeat.i(46939);
    if (this.lpX != null)
    {
      this.lpX.start();
      setKeepScreenOn(true);
      if (this.lqe) {
        this.lqd.bof();
      }
    }
    AppMethodBeat.o(46939);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(46940);
    if (this.lpX != null)
    {
      this.lpX.stop();
      if (this.lqe) {
        this.lqd.bog();
      }
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(46940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper
 * JD-Core Version:    0.7.0.1
 */