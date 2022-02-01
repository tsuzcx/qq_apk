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
  private static e sAj;
  private boolean ddk;
  private a eyG;
  private boolean hJv;
  private Context mContext;
  private boolean nLP;
  private d.c sAf;
  private d sAi;
  private e sAk;
  private d.b sAl;
  private d.h sAm;
  private float sAn;
  private int sAo;
  private boolean sAp;
  private int sAq;
  protected int szV;
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
    this.sAk = null;
    this.sAm = d.h.sAt;
    this.nLP = false;
    this.sAn = -1.0F;
    this.szV = 0;
    this.sAp = true;
    this.sAq = 0;
    this.mContext = paramContext;
    this.eyG = new a();
    this.sAk = sAj;
    AppMethodBeat.o(46921);
  }
  
  public static void setVideoViewFactory(e parame)
  {
    AppMethodBeat.i(328189);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setVideoViewFactory, videoViewFactory: " + parame.getName());
    sAj = parame;
    AppMethodBeat.o(328189);
  }
  
  public final boolean G(double paramDouble)
  {
    AppMethodBeat.i(46928);
    if (this.sAi != null)
    {
      boolean bool = this.sAi.G(paramDouble);
      AppMethodBeat.o(46928);
      return bool;
    }
    AppMethodBeat.o(46928);
    return false;
  }
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(46922);
    this.sAo = paramInt;
    this.ddk = paramBoolean;
    Object localObject = new PString();
    ((PString)localObject).value = paramString;
    if ((!Util.isNullOrNil(((PString)localObject).value)) && (((PString)localObject).value.indexOf("file://") == 0))
    {
      ((PString)localObject).value = ((PString)localObject).value.substring(7);
      paramBoolean = true;
      this.hJv = paramBoolean;
      this.url = ((PString)localObject).value;
      if (this.sAi != null) {
        break label276;
      }
      localObject = this.sAk;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = sAj;
      }
      Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setVideoPath, videoViewFactory: " + paramString.getName());
      this.sAi = paramString.V(this.mContext, this.sAq);
      this.sAi.setVideoSource(this.szV);
      this.sAi.setIMMVideoViewCallback(this);
    }
    for (paramInt = i;; paramInt = 0)
    {
      setScaleType(this.sAm);
      bM(this.sAn);
      setMute(this.nLP);
      if (paramInt != 0)
      {
        setVideoFooterView(this.sAl);
        paramString = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.sAi.getView(), paramString);
      }
      this.sAi.b(this.ddk, this.url, this.sAo);
      AppMethodBeat.o(46922);
      return;
      paramBoolean = false;
      break;
      label276:
      this.sAi.stop();
    }
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(46929);
    if (this.sAi != null)
    {
      paramBoolean = this.sAi.b(paramDouble, paramBoolean);
      AppMethodBeat.o(46929);
      return paramBoolean;
    }
    AppMethodBeat.o(46929);
    return false;
  }
  
  public final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(46947);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(46947);
      return false;
    }
    this.sAn = paramFloat;
    if (this.sAi != null)
    {
      boolean bool = this.sAi.bM(this.sAn);
      AppMethodBeat.o(46947);
      return bool;
    }
    AppMethodBeat.o(46947);
    return false;
  }
  
  public final void cuV()
  {
    AppMethodBeat.i(328232);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%s preload video url %s", new Object[] { Integer.valueOf(hashCode()), this.url });
    if (!Util.isNullOrNil(this.url)) {
      this.sAi.cuV();
    }
    AppMethodBeat.o(328232);
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46949);
    Log.w("MicroMsg.Video.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.sAf != null) {
      this.sAf.d(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46949);
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46952);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.sAf != null) {
      this.sAf.e(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46952);
  }
  
  public final void el(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46950);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.sAf != null) {
      this.sAf.el(paramString1, paramString2);
    }
    AppMethodBeat.o(46950);
  }
  
  public final void em(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46951);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.sAf != null) {
      this.sAf.em(paramString1, paramString2);
    }
    AppMethodBeat.o(46951);
  }
  
  public final void en(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46953);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    if (this.sAp) {
      this.eyG.cvG();
    }
    if (this.sAf != null) {
      this.sAf.en(paramString1, paramString2);
    }
    AppMethodBeat.o(46953);
  }
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46954);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    if (this.sAp) {
      this.eyG.cvF();
    }
    if (this.sAf != null) {
      this.sAf.eo(paramString1, paramString2);
    }
    AppMethodBeat.o(46954);
  }
  
  public final void ep(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46955);
    if (this.sAf != null) {
      this.sAf.ep(paramString1, paramString2);
    }
    AppMethodBeat.o(46955);
  }
  
  public final void eq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46956);
    if (this.sAf != null) {
      this.sAf.eq(paramString1, paramString2);
    }
    AppMethodBeat.o(46956);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(46935);
    if (this.sAi != null)
    {
      int i = this.sAi.getCacheTimeSec();
      AppMethodBeat.o(46935);
      return i;
    }
    AppMethodBeat.o(46935);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(46933);
    if (this.sAi != null)
    {
      int i = this.sAi.getCurrPosMs();
      AppMethodBeat.o(46933);
      return i;
    }
    AppMethodBeat.o(46933);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(46934);
    if (this.sAi != null)
    {
      int i = this.sAi.getCurrPosSec();
      AppMethodBeat.o(46934);
      return i;
    }
    AppMethodBeat.o(46934);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(46927);
    if (this.sAi != null)
    {
      int i = this.sAi.getPlayerType();
      AppMethodBeat.o(46927);
      return i;
    }
    AppMethodBeat.o(46927);
    return 0;
  }
  
  public TextureView getTexture()
  {
    AppMethodBeat.i(328439);
    if ((this.sAi != null) && ((this.sAi.getView() instanceof com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.e)))
    {
      TextureView localTextureView = ((com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.e)this.sAi.getView()).getVideoTexture();
      AppMethodBeat.o(328439);
      return localTextureView;
    }
    AppMethodBeat.o(328439);
    return null;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(46932);
    if (this.sAi != null)
    {
      i = this.sAi.getVideoDurationSec();
      AppMethodBeat.o(46932);
      return i;
    }
    int i = this.sAo;
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
    if (this.sAi != null)
    {
      boolean bool = this.sAi.isLive();
      AppMethodBeat.o(46937);
      return bool;
    }
    AppMethodBeat.o(46937);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(46936);
    if (this.sAi != null)
    {
      boolean bool = this.sAi.isPlaying();
      AppMethodBeat.o(46936);
      return bool;
    }
    AppMethodBeat.o(46936);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(46945);
    if (this.sAi != null) {
      this.sAi.onUIDestroy();
    }
    if (this.sAp) {
      this.eyG.cvG();
    }
    setKeepScreenOn(false);
    AppMethodBeat.o(46945);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(46944);
    if (this.sAi != null) {
      this.sAi.onUIPause();
    }
    if (this.sAp) {
      this.eyG.cvG();
    }
    setKeepScreenOn(false);
    AppMethodBeat.o(46944);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(46943);
    if (this.sAi != null) {
      this.sAi.onUIResume();
    }
    AppMethodBeat.o(46943);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(46941);
    if (this.sAi != null)
    {
      setKeepScreenOn(false);
      if (this.sAp) {
        this.eyG.cvG();
      }
      boolean bool = this.sAi.pause();
      AppMethodBeat.o(46941);
      return bool;
    }
    AppMethodBeat.o(46941);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(46938);
    if (this.sAi != null) {
      this.sAi.setCover(paramBitmap);
    }
    AppMethodBeat.o(46938);
  }
  
  public void setFocusAudio(boolean paramBoolean)
  {
    this.sAp = paramBoolean;
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(46931);
    if (this.sAi != null) {
      this.sAi.setFullDirection(paramInt);
    }
    AppMethodBeat.o(46931);
  }
  
  public void setIMMVideoViewCallback(d.c paramc)
  {
    this.sAf = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(46930);
    if (this.sAi != null) {
      this.sAi.setIsShowBasicControls(paramBoolean);
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
    this.nLP = paramBoolean;
    if (this.sAi != null) {
      this.sAi.setMute(this.nLP);
    }
    AppMethodBeat.o(46942);
  }
  
  public void setMyVideoViewFactory(e parame)
  {
    AppMethodBeat.i(328210);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setMyVideoViewFactory, videoViewFactory: " + parame.getName());
    this.sAk = parame;
    AppMethodBeat.o(328210);
  }
  
  public void setPlayerHint(int paramInt)
  {
    AppMethodBeat.i(328217);
    Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setPlayerHint, playerHint: ".concat(String.valueOf(paramInt)));
    this.sAq = paramInt;
    AppMethodBeat.o(328217);
  }
  
  public void setScaleType(d.h paramh)
  {
    AppMethodBeat.i(46946);
    this.sAm = paramh;
    if (this.sAi != null) {
      this.sAi.setScaleType(this.sAm);
    }
    AppMethodBeat.o(46946);
  }
  
  public void setVideoFooterView(d.b paramb)
  {
    AppMethodBeat.i(328246);
    this.sAl = paramb;
    if (this.sAi != null) {
      this.sAi.setVideoFooterView(this.sAl);
    }
    AppMethodBeat.o(328246);
  }
  
  public void setVideoSource(int paramInt)
  {
    this.szV = paramInt;
  }
  
  public final void start()
  {
    AppMethodBeat.i(46939);
    if (this.sAi != null)
    {
      this.sAi.start();
      setKeepScreenOn(true);
      if (this.sAp) {
        this.eyG.cvF();
      }
    }
    AppMethodBeat.o(46939);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(46940);
    if (this.sAi != null)
    {
      this.sAi.stop();
      if (this.sAp) {
        this.eyG.cvG();
      }
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(46940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper
 * JD-Core Version:    0.7.0.1
 */