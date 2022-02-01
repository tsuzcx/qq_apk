package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.a.a;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class AppBrandVideoWrapper
  extends RelativeLayout
  implements e, e.c
{
  private static f mwD;
  private boolean bzP;
  private a cEM;
  private boolean dLQ;
  private boolean isb;
  private Context mContext;
  private e mwC;
  private f mwE;
  private e.b mwF;
  private e.h mwG;
  private float mwH;
  private int mwI;
  private boolean mwJ;
  protected int mwp;
  private e.c mwz;
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
    this.mwE = null;
    this.mwG = e.h.mwT;
    this.isb = false;
    this.mwH = -1.0F;
    this.mwp = 0;
    this.mwJ = true;
    this.mContext = paramContext;
    this.cEM = new a();
    this.mwE = mwD;
    AppMethodBeat.o(46921);
  }
  
  public static void setVideoViewFactory(f paramf)
  {
    AppMethodBeat.i(234614);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setVideoViewFactory, videoViewFactory: " + paramf.getName());
    mwD = paramf;
    AppMethodBeat.o(234614);
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(46947);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(46947);
      return false;
    }
    this.mwH = paramFloat;
    if (this.mwC != null)
    {
      boolean bool = this.mwC.aO(this.mwH);
      AppMethodBeat.o(46947);
      return bool;
    }
    AppMethodBeat.o(46947);
    return false;
  }
  
  public final void bIW()
  {
    AppMethodBeat.i(234616);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%s preload video url %s", new Object[] { Integer.valueOf(hashCode()), this.url });
    if (!Util.isNullOrNil(this.url)) {
      this.mwC.bIW();
    }
    AppMethodBeat.o(234616);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46949);
    Log.w("MicroMsg.Video.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.mwz != null) {
      this.mwz.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46949);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(46922);
    this.mwI = paramInt;
    this.bzP = paramBoolean;
    Object localObject = new PString();
    ((PString)localObject).value = paramString;
    if ((!Util.isNullOrNil(((PString)localObject).value)) && (((PString)localObject).value.indexOf("file://") == 0))
    {
      ((PString)localObject).value = ((PString)localObject).value.substring(7);
      paramBoolean = true;
      this.dLQ = paramBoolean;
      this.url = ((PString)localObject).value;
      if (this.mwC != null) {
        break label289;
      }
      localObject = this.mwE;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = mwD;
      }
      Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setVideoPath, videoViewFactory: " + paramString.getName());
      this.mwC = paramString.dU(this.mContext);
      this.mwC.setVideoSource(this.mwp);
      this.mwC.setIMMVideoViewCallback(this);
    }
    for (paramInt = i;; paramInt = 0)
    {
      setScaleType(this.mwG);
      aO(this.mwH);
      setMute(this.isb);
      if (paramInt != 0)
      {
        setVideoFooterView(this.mwF);
        paramString = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.mwC.getView(), paramString);
      }
      this.mwC.c(this.bzP, this.url, this.mwI);
      com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
      {
        public final String getKey()
        {
          return "AppBrandVideo_checkVideoUrl";
        }
        
        public final void run()
        {
          AppMethodBeat.i(234613);
          AppBrandVideoWrapper.a(AppBrandVideoWrapper.this);
          AppMethodBeat.o(234613);
        }
      });
      AppMethodBeat.o(46922);
      return;
      paramBoolean = false;
      break;
      label289:
      this.mwC.stop();
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(46929);
    if (this.mwC != null)
    {
      paramBoolean = this.mwC.c(paramDouble, paramBoolean);
      AppMethodBeat.o(46929);
      return paramBoolean;
    }
    AppMethodBeat.o(46929);
    return false;
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46952);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.mwz != null) {
      this.mwz.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46952);
  }
  
  public final void dH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46950);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.mwz != null) {
      this.mwz.dH(paramString1, paramString2);
    }
    AppMethodBeat.o(46950);
  }
  
  public final void dI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46951);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.mwz != null) {
      this.mwz.dI(paramString1, paramString2);
    }
    AppMethodBeat.o(46951);
  }
  
  public final void dJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46953);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    if (this.mwJ) {
      this.cEM.bJJ();
    }
    if (this.mwz != null) {
      this.mwz.dJ(paramString1, paramString2);
    }
    AppMethodBeat.o(46953);
  }
  
  public final void dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46954);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    if (this.mwJ) {
      this.cEM.bJI();
    }
    if (this.mwz != null) {
      this.mwz.dK(paramString1, paramString2);
    }
    AppMethodBeat.o(46954);
  }
  
  public final void dL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46955);
    if (this.mwz != null) {
      this.mwz.dL(paramString1, paramString2);
    }
    AppMethodBeat.o(46955);
  }
  
  public final void dM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46956);
    if (this.mwz != null) {
      this.mwz.dM(paramString1, paramString2);
    }
    AppMethodBeat.o(46956);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(46935);
    if (this.mwC != null)
    {
      int i = this.mwC.getCacheTimeSec();
      AppMethodBeat.o(46935);
      return i;
    }
    AppMethodBeat.o(46935);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(46933);
    if (this.mwC != null)
    {
      int i = this.mwC.getCurrPosMs();
      AppMethodBeat.o(46933);
      return i;
    }
    AppMethodBeat.o(46933);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(46934);
    if (this.mwC != null)
    {
      int i = this.mwC.getCurrPosSec();
      AppMethodBeat.o(46934);
      return i;
    }
    AppMethodBeat.o(46934);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(46927);
    if (this.mwC != null)
    {
      int i = this.mwC.getPlayerType();
      AppMethodBeat.o(46927);
      return i;
    }
    AppMethodBeat.o(46927);
    return 0;
  }
  
  public TextureView getTexture()
  {
    AppMethodBeat.i(234618);
    if ((this.mwC != null) && ((this.mwC.getView() instanceof com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.e)))
    {
      TextureView localTextureView = ((com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.e)this.mwC.getView()).getVideoTexture();
      AppMethodBeat.o(234618);
      return localTextureView;
    }
    AppMethodBeat.o(234618);
    return null;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(46932);
    if (this.mwC != null)
    {
      i = this.mwC.getVideoDurationSec();
      AppMethodBeat.o(46932);
      return i;
    }
    int i = this.mwI;
    AppMethodBeat.o(46932);
    return i;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(46937);
    if (this.mwC != null)
    {
      boolean bool = this.mwC.isLive();
      AppMethodBeat.o(46937);
      return bool;
    }
    AppMethodBeat.o(46937);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(46936);
    if (this.mwC != null)
    {
      boolean bool = this.mwC.isPlaying();
      AppMethodBeat.o(46936);
      return bool;
    }
    AppMethodBeat.o(46936);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(46945);
    if (this.mwC != null) {
      this.mwC.onUIDestroy();
    }
    if (this.mwJ) {
      this.cEM.bJJ();
    }
    setKeepScreenOn(false);
    AppMethodBeat.o(46945);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(46944);
    if (this.mwC != null) {
      this.mwC.onUIPause();
    }
    if (this.mwJ) {
      this.cEM.bJJ();
    }
    setKeepScreenOn(false);
    AppMethodBeat.o(46944);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(46943);
    if (this.mwC != null) {
      this.mwC.onUIResume();
    }
    AppMethodBeat.o(46943);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(46928);
    if (this.mwC != null)
    {
      boolean bool = this.mwC.p(paramDouble);
      AppMethodBeat.o(46928);
      return bool;
    }
    AppMethodBeat.o(46928);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(46941);
    if (this.mwC != null)
    {
      setKeepScreenOn(false);
      if (this.mwJ) {
        this.cEM.bJJ();
      }
      boolean bool = this.mwC.pause();
      AppMethodBeat.o(46941);
      return bool;
    }
    AppMethodBeat.o(46941);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(46938);
    if (this.mwC != null) {
      this.mwC.setCover(paramBitmap);
    }
    AppMethodBeat.o(46938);
  }
  
  public void setFocusAudio(boolean paramBoolean)
  {
    this.mwJ = paramBoolean;
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(46931);
    if (this.mwC != null) {
      this.mwC.setFullDirection(paramInt);
    }
    AppMethodBeat.o(46931);
  }
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.mwz = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(46930);
    if (this.mwC != null) {
      this.mwC.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(46930);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(46957);
    Log.d("MicroMsg.Video.AppBrandVideoWrapper", "set keep screen on:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(46957);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(46942);
    this.isb = paramBoolean;
    if (this.mwC != null) {
      this.mwC.setMute(this.isb);
    }
    AppMethodBeat.o(46942);
  }
  
  public void setMyVideoViewFactory(f paramf)
  {
    AppMethodBeat.i(234615);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setMyVideoViewFactory, videoViewFactory: " + paramf.getName());
    this.mwE = paramf;
    AppMethodBeat.o(234615);
  }
  
  public void setScaleType(e.h paramh)
  {
    AppMethodBeat.i(46946);
    this.mwG = paramh;
    if (this.mwC != null) {
      this.mwC.setScaleType(this.mwG);
    }
    AppMethodBeat.o(46946);
  }
  
  public void setVideoFooterView(e.b paramb)
  {
    AppMethodBeat.i(234617);
    this.mwF = paramb;
    if (this.mwC != null) {
      this.mwC.setVideoFooterView(this.mwF);
    }
    AppMethodBeat.o(234617);
  }
  
  public void setVideoSource(int paramInt)
  {
    this.mwp = paramInt;
  }
  
  public final void start()
  {
    AppMethodBeat.i(46939);
    if (this.mwC != null)
    {
      this.mwC.start();
      setKeepScreenOn(true);
      if (this.mwJ) {
        this.cEM.bJI();
      }
    }
    AppMethodBeat.o(46939);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(46940);
    if (this.mwC != null)
    {
      this.mwC.stop();
      if (this.mwJ) {
        this.cEM.bJJ();
      }
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(46940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper
 * JD-Core Version:    0.7.0.1
 */