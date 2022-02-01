package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.a.a;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class AppBrandVideoWrapper
  extends RelativeLayout
  implements d, d.c
{
  private static e pvd;
  private boolean bjq;
  private a cFs;
  private boolean fEF;
  private boolean lhf;
  private Context mContext;
  protected int puP;
  private d.c puZ;
  private d pvc;
  private e pve;
  private d.b pvf;
  private d.h pvg;
  private float pvh;
  private int pvi;
  private boolean pvj;
  private int pvk;
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
    this.pve = null;
    this.pvg = d.h.pvn;
    this.lhf = false;
    this.pvh = -1.0F;
    this.puP = 0;
    this.pvj = true;
    this.pvk = 0;
    this.mContext = paramContext;
    this.cFs = new a();
    this.pve = pvd;
    AppMethodBeat.o(46921);
  }
  
  public static void setVideoViewFactory(e parame)
  {
    AppMethodBeat.i(227550);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setVideoViewFactory, videoViewFactory: " + parame.getName());
    pvd = parame;
    AppMethodBeat.o(227550);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(46929);
    if (this.pvc != null)
    {
      paramBoolean = this.pvc.a(paramDouble, paramBoolean);
      AppMethodBeat.o(46929);
      return paramBoolean;
    }
    AppMethodBeat.o(46929);
    return false;
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(46947);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(46947);
      return false;
    }
    this.pvh = paramFloat;
    if (this.pvc != null)
    {
      boolean bool = this.pvc.aO(this.pvh);
      AppMethodBeat.o(46947);
      return bool;
    }
    AppMethodBeat.o(46947);
    return false;
  }
  
  public final void bUF()
  {
    AppMethodBeat.i(227562);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%s preload video url %s", new Object[] { Integer.valueOf(hashCode()), this.url });
    if (!Util.isNullOrNil(this.url)) {
      this.pvc.bUF();
    }
    AppMethodBeat.o(227562);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46949);
    Log.w("MicroMsg.Video.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.puZ != null) {
      this.puZ.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46949);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(46922);
    this.pvi = paramInt;
    this.bjq = paramBoolean;
    Object localObject = new PString();
    ((PString)localObject).value = paramString;
    if ((!Util.isNullOrNil(((PString)localObject).value)) && (((PString)localObject).value.indexOf("file://") == 0))
    {
      ((PString)localObject).value = ((PString)localObject).value.substring(7);
      paramBoolean = true;
      this.fEF = paramBoolean;
      this.url = ((PString)localObject).value;
      if (this.pvc != null) {
        break label276;
      }
      localObject = this.pve;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = pvd;
      }
      Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setVideoPath, videoViewFactory: " + paramString.getName());
      this.pvc = paramString.Q(this.mContext, this.pvk);
      this.pvc.setVideoSource(this.puP);
      this.pvc.setIMMVideoViewCallback(this);
    }
    for (paramInt = i;; paramInt = 0)
    {
      setScaleType(this.pvg);
      aO(this.pvh);
      setMute(this.lhf);
      if (paramInt != 0)
      {
        setVideoFooterView(this.pvf);
        paramString = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.pvc.getView(), paramString);
      }
      this.pvc.c(this.bjq, this.url, this.pvi);
      AppMethodBeat.o(46922);
      return;
      paramBoolean = false;
      break;
      label276:
      this.pvc.stop();
    }
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46952);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.puZ != null) {
      this.puZ.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46952);
  }
  
  public final void dS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46950);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.puZ != null) {
      this.puZ.dS(paramString1, paramString2);
    }
    AppMethodBeat.o(46950);
  }
  
  public final void dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46951);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.puZ != null) {
      this.puZ.dT(paramString1, paramString2);
    }
    AppMethodBeat.o(46951);
  }
  
  public final void dU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46953);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    if (this.pvj) {
      this.cFs.bVs();
    }
    if (this.puZ != null) {
      this.puZ.dU(paramString1, paramString2);
    }
    AppMethodBeat.o(46953);
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46954);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    if (this.pvj) {
      this.cFs.bVr();
    }
    if (this.puZ != null) {
      this.puZ.dV(paramString1, paramString2);
    }
    AppMethodBeat.o(46954);
  }
  
  public final void dW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46955);
    if (this.puZ != null) {
      this.puZ.dW(paramString1, paramString2);
    }
    AppMethodBeat.o(46955);
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46956);
    if (this.puZ != null) {
      this.puZ.dX(paramString1, paramString2);
    }
    AppMethodBeat.o(46956);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(46935);
    if (this.pvc != null)
    {
      int i = this.pvc.getCacheTimeSec();
      AppMethodBeat.o(46935);
      return i;
    }
    AppMethodBeat.o(46935);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(46933);
    if (this.pvc != null)
    {
      int i = this.pvc.getCurrPosMs();
      AppMethodBeat.o(46933);
      return i;
    }
    AppMethodBeat.o(46933);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(46934);
    if (this.pvc != null)
    {
      int i = this.pvc.getCurrPosSec();
      AppMethodBeat.o(46934);
      return i;
    }
    AppMethodBeat.o(46934);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(46927);
    if (this.pvc != null)
    {
      int i = this.pvc.getPlayerType();
      AppMethodBeat.o(46927);
      return i;
    }
    AppMethodBeat.o(46927);
    return 0;
  }
  
  public TextureView getTexture()
  {
    AppMethodBeat.i(227609);
    if ((this.pvc != null) && ((this.pvc.getView() instanceof com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.e)))
    {
      TextureView localTextureView = ((com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.e)this.pvc.getView()).getVideoTexture();
      AppMethodBeat.o(227609);
      return localTextureView;
    }
    AppMethodBeat.o(227609);
    return null;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(46932);
    if (this.pvc != null)
    {
      i = this.pvc.getVideoDurationSec();
      AppMethodBeat.o(46932);
      return i;
    }
    int i = this.pvi;
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
    if (this.pvc != null)
    {
      boolean bool = this.pvc.isLive();
      AppMethodBeat.o(46937);
      return bool;
    }
    AppMethodBeat.o(46937);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(46936);
    if (this.pvc != null)
    {
      boolean bool = this.pvc.isPlaying();
      AppMethodBeat.o(46936);
      return bool;
    }
    AppMethodBeat.o(46936);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(46945);
    if (this.pvc != null) {
      this.pvc.onUIDestroy();
    }
    if (this.pvj) {
      this.cFs.bVs();
    }
    setKeepScreenOn(false);
    AppMethodBeat.o(46945);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(46944);
    if (this.pvc != null) {
      this.pvc.onUIPause();
    }
    if (this.pvj) {
      this.cFs.bVs();
    }
    setKeepScreenOn(false);
    AppMethodBeat.o(46944);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(46943);
    if (this.pvc != null) {
      this.pvc.onUIResume();
    }
    AppMethodBeat.o(46943);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(46928);
    if (this.pvc != null)
    {
      boolean bool = this.pvc.p(paramDouble);
      AppMethodBeat.o(46928);
      return bool;
    }
    AppMethodBeat.o(46928);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(46941);
    if (this.pvc != null)
    {
      setKeepScreenOn(false);
      if (this.pvj) {
        this.cFs.bVs();
      }
      boolean bool = this.pvc.pause();
      AppMethodBeat.o(46941);
      return bool;
    }
    AppMethodBeat.o(46941);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(46938);
    if (this.pvc != null) {
      this.pvc.setCover(paramBitmap);
    }
    AppMethodBeat.o(46938);
  }
  
  public void setFocusAudio(boolean paramBoolean)
  {
    this.pvj = paramBoolean;
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(46931);
    if (this.pvc != null) {
      this.pvc.setFullDirection(paramInt);
    }
    AppMethodBeat.o(46931);
  }
  
  public void setIMMVideoViewCallback(d.c paramc)
  {
    this.puZ = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(46930);
    if (this.pvc != null) {
      this.pvc.setIsShowBasicControls(paramBoolean);
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
    this.lhf = paramBoolean;
    if (this.pvc != null) {
      this.pvc.setMute(this.lhf);
    }
    AppMethodBeat.o(46942);
  }
  
  public void setMyVideoViewFactory(e parame)
  {
    AppMethodBeat.i(227556);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setMyVideoViewFactory, videoViewFactory: " + parame.getName());
    this.pve = parame;
    AppMethodBeat.o(227556);
  }
  
  public void setPlayerHint(int paramInt)
  {
    AppMethodBeat.i(227558);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setPlayerHint, playerHint: ".concat(String.valueOf(paramInt)));
    this.pvk = paramInt;
    AppMethodBeat.o(227558);
  }
  
  public void setScaleType(d.h paramh)
  {
    AppMethodBeat.i(46946);
    this.pvg = paramh;
    if (this.pvc != null) {
      this.pvc.setScaleType(this.pvg);
    }
    AppMethodBeat.o(46946);
  }
  
  public void setVideoFooterView(d.b paramb)
  {
    AppMethodBeat.i(227566);
    this.pvf = paramb;
    if (this.pvc != null) {
      this.pvc.setVideoFooterView(this.pvf);
    }
    AppMethodBeat.o(227566);
  }
  
  public void setVideoSource(int paramInt)
  {
    this.puP = paramInt;
  }
  
  public final void start()
  {
    AppMethodBeat.i(46939);
    if (this.pvc != null)
    {
      this.pvc.start();
      setKeepScreenOn(true);
      if (this.pvj) {
        this.cFs.bVr();
      }
    }
    AppMethodBeat.o(46939);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(46940);
    if (this.pvc != null)
    {
      this.pvc.stop();
      if (this.pvj) {
        this.cFs.bVs();
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