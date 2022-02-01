package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class BaseVideoView
  extends AbstractVideoView
{
  protected boolean bzN;
  private boolean isd = false;
  protected int llD;
  protected int llm = 0;
  protected String url;
  
  public BaseVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BaseVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean aE(float paramFloat)
  {
    boolean bool = false;
    ad.i("MicroMsg.Video.BaseVideoView", "%s set play rate [%f]", new Object[] { boQ(), Float.valueOf(paramFloat) });
    if ((this.lth instanceof AbstractVideoTextureView)) {
      bool = ((AbstractVideoTextureView)this.lth).aE(paramFloat);
    }
    return bool;
  }
  
  public final boolean bhH()
  {
    boolean bool2 = false;
    boolean bool3 = boS();
    int i;
    boolean bool1;
    if (this.lth != null)
    {
      i = this.lth.getDuration();
      if (!this.bzN) {
        break label41;
      }
      bool1 = true;
    }
    label41:
    do
    {
      do
      {
        return bool1;
        i = 0;
        break;
        bool1 = bool2;
      } while (!bool3);
      bool1 = bool2;
    } while (i > 0);
    return true;
  }
  
  public final void bmJ()
  {
    if (this.lth != null)
    {
      ad.i("MicroMsg.Video.BaseVideoView", "%s preloadVideo url:%s, path:%s", new Object[] { boQ(), this.url, this.lth.getVideoPath() });
      if (bt.isNullOrNil(this.lth.getVideoPath()))
      {
        this.lth.setVideoPath(this.url);
        this.ltn = false;
      }
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    this.bzN = paramBoolean;
    this.url = paramString;
    this.llD = paramInt;
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    if (bhH())
    {
      ad.w("MicroMsg.Video.BaseVideoView", "%s it is live, don't seek ", new Object[] { boQ() });
      return false;
    }
    return super.c(paramDouble, paramBoolean);
  }
  
  protected final a dA(Context paramContext)
  {
    return dB(paramContext);
  }
  
  protected abstract a dB(Context paramContext);
  
  public final void ec(int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.Video.BaseVideoView", "%s onInfo [%d %d]", new Object[] { boQ(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701) {
      showLoading();
    }
    while (paramInt1 != 702) {
      return;
    }
    super.hideLoading();
  }
  
  public int getCacheTimeSec()
  {
    try
    {
      if ((this.lth instanceof AbstractVideoTextureView))
      {
        int i = ((AbstractVideoTextureView)this.lth).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        return (int)(i * 1.0F / 100.0F * f);
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Video.BaseVideoView", localException, "%s get cache time sec error", new Object[] { boQ() });
    }
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    if (this.llD <= 0) {
      return super.getVideoDurationSec();
    }
    return this.llD;
  }
  
  public int getVideoSource()
  {
    return this.llm;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void hideLoading()
  {
    super.hideLoading();
  }
  
  public final void onCompletion()
  {
    if (bhH())
    {
      ad.i("MicroMsg.Video.BaseVideoView", "%s it is live video, do not completion", new Object[] { boQ() });
      stop();
      start();
    }
    do
    {
      return;
      super.onCompletion();
    } while (!this.isd);
    c(0.0D, true);
  }
  
  public final void onUIPause()
  {
    super.onUIPause();
  }
  
  public final void onUIResume()
  {
    super.onUIResume();
    if ((this.lth != null) && ((this.lth instanceof AbstractVideoTextureView)))
    {
      if (this.ltl) {
        play();
      }
    }
    else {
      return;
    }
    ((AbstractVideoTextureView)this.lth).boO();
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.isd = paramBoolean;
  }
  
  public void setScaleType(e.h paramh)
  {
    if ((this.lth instanceof AbstractVideoTextureView)) {
      ((AbstractVideoTextureView)this.lth).setScaleType(paramh);
    }
  }
  
  public void setVideoSource(int paramInt)
  {
    this.llm = paramInt;
  }
  
  public final void start()
  {
    if (this.lth != null)
    {
      ad.i("MicroMsg.Video.BaseVideoView", "%s start path [%s] [%s]", new Object[] { boQ(), this.lth.getVideoPath(), bt.flS() });
      if (bt.isNullOrNil(this.lth.getVideoPath()))
      {
        this.lth.setVideoPath(this.url);
        this.ltn = true;
        showLoading();
      }
    }
    else
    {
      return;
    }
    this.ltn = true;
    play();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */