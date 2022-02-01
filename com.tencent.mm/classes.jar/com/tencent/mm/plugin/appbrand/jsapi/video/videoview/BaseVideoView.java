package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public abstract class BaseVideoView
  extends AbstractVideoView
{
  protected boolean bps;
  private boolean hYH = false;
  protected int kOJ = 0;
  protected int kPa;
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
  
  public final boolean aB(float paramFloat)
  {
    boolean bool = false;
    ac.i("MicroMsg.Video.BaseVideoView", "%s set play rate [%f]", new Object[] { blf(), Float.valueOf(paramFloat) });
    if ((this.kWi instanceof AbstractVideoTextureView)) {
      bool = ((AbstractVideoTextureView)this.kWi).aB(paramFloat);
    }
    return bool;
  }
  
  public final boolean bed()
  {
    boolean bool2 = false;
    boolean bool3 = blh();
    int i;
    boolean bool1;
    if (this.kWi != null)
    {
      i = this.kWi.getDuration();
      if (!this.bps) {
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
  
  public final void biX()
  {
    if (this.kWi != null)
    {
      ac.i("MicroMsg.Video.BaseVideoView", "%s preloadVideo url:%s, path:%s", new Object[] { blf(), this.url, this.kWi.getVideoPath() });
      if (bs.isNullOrNil(this.kWi.getVideoPath()))
      {
        this.kWi.setVideoPath(this.url);
        this.kWo = false;
      }
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    this.bps = paramBoolean;
    this.url = paramString;
    this.kPa = paramInt;
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    if (bed())
    {
      ac.w("MicroMsg.Video.BaseVideoView", "%s it is live, don't seek ", new Object[] { blf() });
      return false;
    }
    return super.c(paramDouble, paramBoolean);
  }
  
  protected final a dC(Context paramContext)
  {
    return dD(paramContext);
  }
  
  protected abstract a dD(Context paramContext);
  
  public final void ea(int paramInt1, int paramInt2)
  {
    ac.i("MicroMsg.Video.BaseVideoView", "%s onInfo [%d %d]", new Object[] { blf(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      if ((this.kWi instanceof AbstractVideoTextureView))
      {
        int i = ((AbstractVideoTextureView)this.kWi).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        return (int)(i * 1.0F / 100.0F * f);
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Video.BaseVideoView", localException, "%s get cache time sec error", new Object[] { blf() });
    }
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    if (this.kPa <= 0) {
      return super.getVideoDurationSec();
    }
    return this.kPa;
  }
  
  public int getVideoSource()
  {
    return this.kOJ;
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
    if (bed())
    {
      ac.i("MicroMsg.Video.BaseVideoView", "%s it is live video, do not completion", new Object[] { blf() });
      stop();
      start();
    }
    do
    {
      return;
      super.onCompletion();
    } while (!this.hYH);
    c(0.0D, true);
  }
  
  public final void onUIPause()
  {
    super.onUIPause();
  }
  
  public final void onUIResume()
  {
    super.onUIResume();
    if ((this.kWi != null) && ((this.kWi instanceof AbstractVideoTextureView)))
    {
      if (this.kWm) {
        play();
      }
    }
    else {
      return;
    }
    ((AbstractVideoTextureView)this.kWi).bld();
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.hYH = paramBoolean;
  }
  
  public void setScaleType(e.h paramh)
  {
    if ((this.kWi instanceof AbstractVideoTextureView)) {
      ((AbstractVideoTextureView)this.kWi).setScaleType(paramh);
    }
  }
  
  public void setVideoSource(int paramInt)
  {
    this.kOJ = paramInt;
  }
  
  public final void start()
  {
    if (this.kWi != null)
    {
      ac.i("MicroMsg.Video.BaseVideoView", "%s start path [%s] [%s]", new Object[] { blf(), this.kWi.getVideoPath(), bs.eWi() });
      if (bs.isNullOrNil(this.kWi.getVideoPath()))
      {
        this.kWi.setVideoPath(this.url);
        this.kWo = true;
        showLoading();
      }
    }
    else
    {
      return;
    }
    this.kWo = true;
    play();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */