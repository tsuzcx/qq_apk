package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.a.a;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class AppBrandVideoWrapper
  extends RelativeLayout
  implements e, e.c
{
  private static f kOV;
  private boolean bps;
  private boolean dqZ;
  private boolean hdh;
  protected int kOJ;
  private e kOU;
  private e.c kOW;
  private e.b kOX;
  private e.h kOY;
  private float kOZ;
  private int kPa;
  private a kPb;
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
    this.kOY = e.h.kPl;
    this.hdh = false;
    this.kOZ = -1.0F;
    this.kOJ = 0;
    this.mContext = paramContext;
    this.kPb = new a();
    AppMethodBeat.o(46921);
  }
  
  public static void setVideoViewFactory(f paramf)
  {
    kOV = paramf;
  }
  
  public final boolean aB(float paramFloat)
  {
    AppMethodBeat.i(46947);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(46947);
      return false;
    }
    this.kOZ = paramFloat;
    if (this.kOU != null)
    {
      boolean bool = this.kOU.aB(this.kOZ);
      AppMethodBeat.o(46947);
      return bool;
    }
    AppMethodBeat.o(46947);
    return false;
  }
  
  public final boolean bed()
  {
    AppMethodBeat.i(46937);
    if (this.kOU != null)
    {
      boolean bool = this.kOU.bed();
      AppMethodBeat.o(46937);
      return bool;
    }
    AppMethodBeat.o(46937);
    return false;
  }
  
  public final void biX()
  {
    AppMethodBeat.i(194111);
    ac.i("MicroMsg.Video.AppBrandVideoWrapper", "%s preload video url %s", new Object[] { Integer.valueOf(hashCode()), this.url });
    if (!bs.isNullOrNil(this.url)) {
      this.kOU.biX();
    }
    AppMethodBeat.o(194111);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46949);
    ac.w("MicroMsg.Video.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.kOW != null) {
      this.kOW.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46949);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(46922);
    this.kPa = paramInt;
    this.bps = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!bs.isNullOrNil(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.dqZ = paramBoolean;
      this.url = localPString.value;
      if (this.kOU != null) {
        break label247;
      }
      this.kOU = kOV.dx(this.mContext);
      this.kOU.setVideoSource(this.kOJ);
      this.kOU.setIMMVideoViewCallback(this);
    }
    for (paramInt = i;; paramInt = 0)
    {
      setScaleType(this.kOY);
      aB(this.kOZ);
      setMute(this.hdh);
      if (paramInt != 0)
      {
        setVideoFooterView(this.kOX);
        paramString = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.kOU.getView(), paramString);
      }
      this.kOU.c(this.bps, this.url, this.kPa);
      com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "AppBrandVideo_checkVideoUrl";
        }
        
        public final void run()
        {
          AppMethodBeat.i(194110);
          AppBrandVideoWrapper.a(AppBrandVideoWrapper.this);
          AppMethodBeat.o(194110);
        }
      });
      AppMethodBeat.o(46922);
      return;
      paramBoolean = false;
      break;
      label247:
      this.kOU.stop();
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(46929);
    if (this.kOU != null)
    {
      paramBoolean = this.kOU.c(paramDouble, paramBoolean);
      AppMethodBeat.o(46929);
      return paramBoolean;
    }
    AppMethodBeat.o(46929);
    return false;
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46952);
    ac.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.kOW != null) {
      this.kOW.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46952);
  }
  
  public final void jdMethod_do(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46950);
    ac.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.kOW != null) {
      this.kOW.jdMethod_do(paramString1, paramString2);
    }
    AppMethodBeat.o(46950);
  }
  
  public final void dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46951);
    ac.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.kOW != null) {
      this.kOW.dp(paramString1, paramString2);
    }
    AppMethodBeat.o(46951);
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46953);
    ac.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.kPb.bjL();
    if (this.kOW != null) {
      this.kOW.dq(paramString1, paramString2);
    }
    AppMethodBeat.o(46953);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46954);
    ac.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.kPb.bjK();
    if (this.kOW != null) {
      this.kOW.dr(paramString1, paramString2);
    }
    AppMethodBeat.o(46954);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46955);
    if (this.kOW != null) {
      this.kOW.ds(paramString1, paramString2);
    }
    AppMethodBeat.o(46955);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46956);
    if (this.kOW != null) {
      this.kOW.dt(paramString1, paramString2);
    }
    AppMethodBeat.o(46956);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(46935);
    if (this.kOU != null)
    {
      int i = this.kOU.getCacheTimeSec();
      AppMethodBeat.o(46935);
      return i;
    }
    AppMethodBeat.o(46935);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(46933);
    if (this.kOU != null)
    {
      int i = this.kOU.getCurrPosMs();
      AppMethodBeat.o(46933);
      return i;
    }
    AppMethodBeat.o(46933);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(46934);
    if (this.kOU != null)
    {
      int i = this.kOU.getCurrPosSec();
      AppMethodBeat.o(46934);
      return i;
    }
    AppMethodBeat.o(46934);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(46927);
    if (this.kOU != null)
    {
      int i = this.kOU.getPlayerType();
      AppMethodBeat.o(46927);
      return i;
    }
    AppMethodBeat.o(46927);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(46932);
    if (this.kOU != null)
    {
      i = this.kOU.getVideoDurationSec();
      AppMethodBeat.o(46932);
      return i;
    }
    int i = this.kPa;
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
    if (this.kOU != null)
    {
      boolean bool = this.kOU.isPlaying();
      AppMethodBeat.o(46936);
      return bool;
    }
    AppMethodBeat.o(46936);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(46928);
    if (this.kOU != null)
    {
      boolean bool = this.kOU.o(paramDouble);
      AppMethodBeat.o(46928);
      return bool;
    }
    AppMethodBeat.o(46928);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(46945);
    if (this.kOU != null) {
      this.kOU.onUIDestroy();
    }
    this.kPb.bjL();
    setKeepScreenOn(false);
    AppMethodBeat.o(46945);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(46944);
    if (this.kOU != null) {
      this.kOU.onUIPause();
    }
    this.kPb.bjL();
    setKeepScreenOn(false);
    AppMethodBeat.o(46944);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(46943);
    if (this.kOU != null) {
      this.kOU.onUIResume();
    }
    AppMethodBeat.o(46943);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(46941);
    if (this.kOU != null)
    {
      setKeepScreenOn(false);
      this.kPb.bjL();
      boolean bool = this.kOU.pause();
      AppMethodBeat.o(46941);
      return bool;
    }
    AppMethodBeat.o(46941);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(46938);
    if (this.kOU != null) {
      this.kOU.setCover(paramBitmap);
    }
    AppMethodBeat.o(46938);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(46931);
    if (this.kOU != null) {
      this.kOU.setFullDirection(paramInt);
    }
    AppMethodBeat.o(46931);
  }
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.kOW = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(46930);
    if (this.kOU != null) {
      this.kOU.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(46930);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(46957);
    ac.d("MicroMsg.Video.AppBrandVideoWrapper", "set keep screen on:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(46957);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(46942);
    this.hdh = paramBoolean;
    if (this.kOU != null) {
      this.kOU.setMute(this.hdh);
    }
    AppMethodBeat.o(46942);
  }
  
  public void setScaleType(e.h paramh)
  {
    AppMethodBeat.i(46946);
    this.kOY = paramh;
    if (this.kOU != null) {
      this.kOU.setScaleType(this.kOY);
    }
    AppMethodBeat.o(46946);
  }
  
  public void setVideoFooterView(e.b paramb)
  {
    AppMethodBeat.i(194112);
    this.kOX = paramb;
    if (this.kOU != null) {
      this.kOU.setVideoFooterView(this.kOX);
    }
    AppMethodBeat.o(194112);
  }
  
  public void setVideoSource(int paramInt)
  {
    this.kOJ = paramInt;
  }
  
  public final void start()
  {
    AppMethodBeat.i(46939);
    if (this.kOU != null)
    {
      this.kOU.start();
      setKeepScreenOn(true);
      this.kPb.bjK();
    }
    AppMethodBeat.o(46939);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(46940);
    if (this.kOU != null)
    {
      this.kOU.stop();
      this.kPb.bjL();
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(46940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper
 * JD-Core Version:    0.7.0.1
 */