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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class AppBrandVideoWrapper
  extends RelativeLayout
  implements e, e.c
{
  private static f lly;
  private boolean bzN;
  private boolean dCQ;
  private boolean hvp;
  private e.b llA;
  private e.h llB;
  private float llC;
  private int llD;
  private a llE;
  protected int llm;
  private e llx;
  private e.c llz;
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
    this.llB = e.h.llO;
    this.hvp = false;
    this.llC = -1.0F;
    this.llm = 0;
    this.mContext = paramContext;
    this.llE = new a();
    AppMethodBeat.o(46921);
  }
  
  public static void setVideoViewFactory(f paramf)
  {
    lly = paramf;
  }
  
  public final boolean aE(float paramFloat)
  {
    AppMethodBeat.i(46947);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(46947);
      return false;
    }
    this.llC = paramFloat;
    if (this.llx != null)
    {
      boolean bool = this.llx.aE(this.llC);
      AppMethodBeat.o(46947);
      return bool;
    }
    AppMethodBeat.o(46947);
    return false;
  }
  
  public final boolean bhH()
  {
    AppMethodBeat.i(46937);
    if (this.llx != null)
    {
      boolean bool = this.llx.bhH();
      AppMethodBeat.o(46937);
      return bool;
    }
    AppMethodBeat.o(46937);
    return false;
  }
  
  public final void bmJ()
  {
    AppMethodBeat.i(205923);
    ad.i("MicroMsg.Video.AppBrandVideoWrapper", "%s preload video url %s", new Object[] { Integer.valueOf(hashCode()), this.url });
    if (!bt.isNullOrNil(this.url)) {
      this.llx.bmJ();
    }
    AppMethodBeat.o(205923);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46949);
    ad.w("MicroMsg.Video.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.llz != null) {
      this.llz.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46949);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(46922);
    this.llD = paramInt;
    this.bzN = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!bt.isNullOrNil(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.dCQ = paramBoolean;
      this.url = localPString.value;
      if (this.llx != null) {
        break label247;
      }
      this.llx = lly.dv(this.mContext);
      this.llx.setVideoSource(this.llm);
      this.llx.setIMMVideoViewCallback(this);
    }
    for (paramInt = i;; paramInt = 0)
    {
      setScaleType(this.llB);
      aE(this.llC);
      setMute(this.hvp);
      if (paramInt != 0)
      {
        setVideoFooterView(this.llA);
        paramString = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.llx.getView(), paramString);
      }
      this.llx.c(this.bzN, this.url, this.llD);
      com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "AppBrandVideo_checkVideoUrl";
        }
        
        public final void run()
        {
          AppMethodBeat.i(205922);
          AppBrandVideoWrapper.a(AppBrandVideoWrapper.this);
          AppMethodBeat.o(205922);
        }
      });
      AppMethodBeat.o(46922);
      return;
      paramBoolean = false;
      break;
      label247:
      this.llx.stop();
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(46929);
    if (this.llx != null)
    {
      paramBoolean = this.llx.c(paramDouble, paramBoolean);
      AppMethodBeat.o(46929);
      return paramBoolean;
    }
    AppMethodBeat.o(46929);
    return false;
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46952);
    ad.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.llz != null) {
      this.llz.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46952);
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46950);
    ad.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.llz != null) {
      this.llz.dq(paramString1, paramString2);
    }
    AppMethodBeat.o(46950);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46951);
    ad.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.llz != null) {
      this.llz.dr(paramString1, paramString2);
    }
    AppMethodBeat.o(46951);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46953);
    ad.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.llE.bnw();
    if (this.llz != null) {
      this.llz.ds(paramString1, paramString2);
    }
    AppMethodBeat.o(46953);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46954);
    ad.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.llE.bnv();
    if (this.llz != null) {
      this.llz.dt(paramString1, paramString2);
    }
    AppMethodBeat.o(46954);
  }
  
  public final void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46955);
    if (this.llz != null) {
      this.llz.du(paramString1, paramString2);
    }
    AppMethodBeat.o(46955);
  }
  
  public final void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46956);
    if (this.llz != null) {
      this.llz.dv(paramString1, paramString2);
    }
    AppMethodBeat.o(46956);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(46935);
    if (this.llx != null)
    {
      int i = this.llx.getCacheTimeSec();
      AppMethodBeat.o(46935);
      return i;
    }
    AppMethodBeat.o(46935);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(46933);
    if (this.llx != null)
    {
      int i = this.llx.getCurrPosMs();
      AppMethodBeat.o(46933);
      return i;
    }
    AppMethodBeat.o(46933);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(46934);
    if (this.llx != null)
    {
      int i = this.llx.getCurrPosSec();
      AppMethodBeat.o(46934);
      return i;
    }
    AppMethodBeat.o(46934);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(46927);
    if (this.llx != null)
    {
      int i = this.llx.getPlayerType();
      AppMethodBeat.o(46927);
      return i;
    }
    AppMethodBeat.o(46927);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(46932);
    if (this.llx != null)
    {
      i = this.llx.getVideoDurationSec();
      AppMethodBeat.o(46932);
      return i;
    }
    int i = this.llD;
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
    if (this.llx != null)
    {
      boolean bool = this.llx.isPlaying();
      AppMethodBeat.o(46936);
      return bool;
    }
    AppMethodBeat.o(46936);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(46928);
    if (this.llx != null)
    {
      boolean bool = this.llx.o(paramDouble);
      AppMethodBeat.o(46928);
      return bool;
    }
    AppMethodBeat.o(46928);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(46945);
    if (this.llx != null) {
      this.llx.onUIDestroy();
    }
    this.llE.bnw();
    setKeepScreenOn(false);
    AppMethodBeat.o(46945);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(46944);
    if (this.llx != null) {
      this.llx.onUIPause();
    }
    this.llE.bnw();
    setKeepScreenOn(false);
    AppMethodBeat.o(46944);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(46943);
    if (this.llx != null) {
      this.llx.onUIResume();
    }
    AppMethodBeat.o(46943);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(46941);
    if (this.llx != null)
    {
      setKeepScreenOn(false);
      this.llE.bnw();
      boolean bool = this.llx.pause();
      AppMethodBeat.o(46941);
      return bool;
    }
    AppMethodBeat.o(46941);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(46938);
    if (this.llx != null) {
      this.llx.setCover(paramBitmap);
    }
    AppMethodBeat.o(46938);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(46931);
    if (this.llx != null) {
      this.llx.setFullDirection(paramInt);
    }
    AppMethodBeat.o(46931);
  }
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.llz = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(46930);
    if (this.llx != null) {
      this.llx.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(46930);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(46957);
    ad.d("MicroMsg.Video.AppBrandVideoWrapper", "set keep screen on:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(46957);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(46942);
    this.hvp = paramBoolean;
    if (this.llx != null) {
      this.llx.setMute(this.hvp);
    }
    AppMethodBeat.o(46942);
  }
  
  public void setScaleType(e.h paramh)
  {
    AppMethodBeat.i(46946);
    this.llB = paramh;
    if (this.llx != null) {
      this.llx.setScaleType(this.llB);
    }
    AppMethodBeat.o(46946);
  }
  
  public void setVideoFooterView(e.b paramb)
  {
    AppMethodBeat.i(205924);
    this.llA = paramb;
    if (this.llx != null) {
      this.llx.setVideoFooterView(this.llA);
    }
    AppMethodBeat.o(205924);
  }
  
  public void setVideoSource(int paramInt)
  {
    this.llm = paramInt;
  }
  
  public final void start()
  {
    AppMethodBeat.i(46939);
    if (this.llx != null)
    {
      this.llx.start();
      setKeepScreenOn(true);
      this.llE.bnv();
    }
    AppMethodBeat.o(46939);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(46940);
    if (this.llx != null)
    {
      this.llx.stop();
      this.llE.bnw();
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(46940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper
 * JD-Core Version:    0.7.0.1
 */