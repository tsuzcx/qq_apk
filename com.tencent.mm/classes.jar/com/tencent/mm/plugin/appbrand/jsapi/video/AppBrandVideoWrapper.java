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
  private static f knB;
  private boolean bqS;
  private boolean dtp;
  private boolean gCJ;
  private e knA;
  private e.c knC;
  private e.b knD;
  private e.h knE;
  private float knF;
  private int knG;
  private a knH;
  protected int knr;
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
    this.knE = e.h.knR;
    this.gCJ = false;
    this.knF = -1.0F;
    this.knr = 0;
    this.mContext = paramContext;
    this.knH = new a();
    AppMethodBeat.o(46921);
  }
  
  public static void setVideoViewFactory(f paramf)
  {
    knB = paramf;
  }
  
  public final boolean aXf()
  {
    AppMethodBeat.i(46937);
    if (this.knA != null)
    {
      boolean bool = this.knA.aXf();
      AppMethodBeat.o(46937);
      return bool;
    }
    AppMethodBeat.o(46937);
    return false;
  }
  
  public final boolean ax(float paramFloat)
  {
    AppMethodBeat.i(46947);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(46947);
      return false;
    }
    this.knF = paramFloat;
    if (this.knA != null)
    {
      boolean bool = this.knA.ax(this.knF);
      AppMethodBeat.o(46947);
      return bool;
    }
    AppMethodBeat.o(46947);
    return false;
  }
  
  public final void bcc()
  {
    AppMethodBeat.i(193764);
    ad.i("MicroMsg.Video.AppBrandVideoWrapper", "%s preload video url %s", new Object[] { Integer.valueOf(hashCode()), this.url });
    if (!bt.isNullOrNil(this.url)) {
      this.knA.bcc();
    }
    AppMethodBeat.o(193764);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46949);
    ad.w("MicroMsg.Video.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.knC != null) {
      this.knC.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46949);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(46922);
    this.knG = paramInt;
    this.bqS = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!bt.isNullOrNil(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.dtp = paramBoolean;
      this.url = localPString.value;
      if (this.knA != null) {
        break label247;
      }
      this.knA = knB.jdMethod_do(this.mContext);
      this.knA.setVideoSource(this.knr);
      this.knA.setIMMVideoViewCallback(this);
    }
    for (paramInt = i;; paramInt = 0)
    {
      setScaleType(this.knE);
      ax(this.knF);
      setMute(this.gCJ);
      if (paramInt != 0)
      {
        setVideoFooterView(this.knD);
        paramString = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.knA.getView(), paramString);
      }
      this.knA.c(this.bqS, this.url, this.knG);
      com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "AppBrandVideo_checkVideoUrl";
        }
        
        public final void run()
        {
          AppMethodBeat.i(193763);
          AppBrandVideoWrapper.a(AppBrandVideoWrapper.this);
          AppMethodBeat.o(193763);
        }
      });
      AppMethodBeat.o(46922);
      return;
      paramBoolean = false;
      break;
      label247:
      this.knA.stop();
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(46929);
    if (this.knA != null)
    {
      paramBoolean = this.knA.c(paramDouble, paramBoolean);
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
    if (this.knC != null) {
      this.knC.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(46952);
  }
  
  public final void db(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46950);
    ad.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.knC != null) {
      this.knC.db(paramString1, paramString2);
    }
    AppMethodBeat.o(46950);
  }
  
  public final void dc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46951);
    ad.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.knC != null) {
      this.knC.dc(paramString1, paramString2);
    }
    AppMethodBeat.o(46951);
  }
  
  public final void dd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46953);
    ad.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.knH.bcQ();
    if (this.knC != null) {
      this.knC.dd(paramString1, paramString2);
    }
    AppMethodBeat.o(46953);
  }
  
  public final void de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46954);
    ad.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.knH.bcO();
    if (this.knC != null) {
      this.knC.de(paramString1, paramString2);
    }
    AppMethodBeat.o(46954);
  }
  
  public final void dg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46955);
    if (this.knC != null) {
      this.knC.dg(paramString1, paramString2);
    }
    AppMethodBeat.o(46955);
  }
  
  public final void dh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46956);
    if (this.knC != null) {
      this.knC.dh(paramString1, paramString2);
    }
    AppMethodBeat.o(46956);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(46935);
    if (this.knA != null)
    {
      int i = this.knA.getCacheTimeSec();
      AppMethodBeat.o(46935);
      return i;
    }
    AppMethodBeat.o(46935);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(46933);
    if (this.knA != null)
    {
      int i = this.knA.getCurrPosMs();
      AppMethodBeat.o(46933);
      return i;
    }
    AppMethodBeat.o(46933);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(46934);
    if (this.knA != null)
    {
      int i = this.knA.getCurrPosSec();
      AppMethodBeat.o(46934);
      return i;
    }
    AppMethodBeat.o(46934);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(46927);
    if (this.knA != null)
    {
      int i = this.knA.getPlayerType();
      AppMethodBeat.o(46927);
      return i;
    }
    AppMethodBeat.o(46927);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(46932);
    if (this.knA != null)
    {
      i = this.knA.getVideoDurationSec();
      AppMethodBeat.o(46932);
      return i;
    }
    int i = this.knG;
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
    if (this.knA != null)
    {
      boolean bool = this.knA.isPlaying();
      AppMethodBeat.o(46936);
      return bool;
    }
    AppMethodBeat.o(46936);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(46945);
    if (this.knA != null) {
      this.knA.onUIDestroy();
    }
    this.knH.bcQ();
    setKeepScreenOn(false);
    AppMethodBeat.o(46945);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(46944);
    if (this.knA != null) {
      this.knA.onUIPause();
    }
    this.knH.bcQ();
    setKeepScreenOn(false);
    AppMethodBeat.o(46944);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(46943);
    if (this.knA != null) {
      this.knA.onUIResume();
    }
    AppMethodBeat.o(46943);
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(46928);
    if (this.knA != null)
    {
      boolean bool = this.knA.p(paramDouble);
      AppMethodBeat.o(46928);
      return bool;
    }
    AppMethodBeat.o(46928);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(46941);
    if (this.knA != null)
    {
      setKeepScreenOn(false);
      this.knH.bcQ();
      boolean bool = this.knA.pause();
      AppMethodBeat.o(46941);
      return bool;
    }
    AppMethodBeat.o(46941);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(46938);
    if (this.knA != null) {
      this.knA.setCover(paramBitmap);
    }
    AppMethodBeat.o(46938);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(46931);
    if (this.knA != null) {
      this.knA.setFullDirection(paramInt);
    }
    AppMethodBeat.o(46931);
  }
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.knC = paramc;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(46930);
    if (this.knA != null) {
      this.knA.setIsShowBasicControls(paramBoolean);
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
    this.gCJ = paramBoolean;
    if (this.knA != null) {
      this.knA.setMute(this.gCJ);
    }
    AppMethodBeat.o(46942);
  }
  
  public void setScaleType(e.h paramh)
  {
    AppMethodBeat.i(46946);
    this.knE = paramh;
    if (this.knA != null) {
      this.knA.setScaleType(this.knE);
    }
    AppMethodBeat.o(46946);
  }
  
  public void setVideoFooterView(e.b paramb)
  {
    AppMethodBeat.i(193765);
    this.knD = paramb;
    if (this.knA != null) {
      this.knA.setVideoFooterView(this.knD);
    }
    AppMethodBeat.o(193765);
  }
  
  public void setVideoSource(int paramInt)
  {
    this.knr = paramInt;
  }
  
  public final void start()
  {
    AppMethodBeat.i(46939);
    if (this.knA != null)
    {
      this.knA.start();
      setKeepScreenOn(true);
      this.knH.bcO();
    }
    AppMethodBeat.o(46939);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(46940);
    if (this.knA != null)
    {
      this.knA.stop();
      this.knH.bcQ();
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(46940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper
 * JD-Core Version:    0.7.0.1
 */