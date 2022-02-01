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
  protected boolean bqS;
  private boolean hyg = false;
  protected int knG;
  protected int knr = 0;
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
  
  public final boolean aXf()
  {
    boolean bool2 = false;
    boolean bool3 = ben();
    int i;
    boolean bool1;
    if (this.kuU != null)
    {
      i = this.kuU.getDuration();
      if (!this.bqS) {
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
  
  public final boolean ax(float paramFloat)
  {
    boolean bool = false;
    ad.i("MicroMsg.Video.BaseVideoView", "%s set play rate [%f]", new Object[] { bel(), Float.valueOf(paramFloat) });
    if ((this.kuU instanceof AbstractVideoTextureView)) {
      bool = ((AbstractVideoTextureView)this.kuU).ax(paramFloat);
    }
    return bool;
  }
  
  public final void bcc()
  {
    if (this.kuU != null)
    {
      ad.i("MicroMsg.Video.BaseVideoView", "%s preloadVideo url:%s, path:%s", new Object[] { bel(), this.url, this.kuU.getVideoPath() });
      if (bt.isNullOrNil(this.kuU.getVideoPath()))
      {
        this.kuU.setVideoPath(this.url);
        this.kva = false;
      }
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    this.bqS = paramBoolean;
    this.url = paramString;
    this.knG = paramInt;
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    if (aXf())
    {
      ad.w("MicroMsg.Video.BaseVideoView", "%s it is live, don't seek ", new Object[] { bel() });
      return false;
    }
    return super.c(paramDouble, paramBoolean);
  }
  
  public final void dZ(int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.Video.BaseVideoView", "%s onInfo [%d %d]", new Object[] { bel(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701) {
      showLoading();
    }
    while (paramInt1 != 702) {
      return;
    }
    super.hideLoading();
  }
  
  protected final a dt(Context paramContext)
  {
    return du(paramContext);
  }
  
  protected abstract a du(Context paramContext);
  
  public int getCacheTimeSec()
  {
    try
    {
      if ((this.kuU instanceof AbstractVideoTextureView))
      {
        int i = ((AbstractVideoTextureView)this.kuU).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        return (int)(i * 1.0F / 100.0F * f);
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Video.BaseVideoView", localException, "%s get cache time sec error", new Object[] { bel() });
    }
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    if (this.knG <= 0) {
      return super.getVideoDurationSec();
    }
    return this.knG;
  }
  
  public int getVideoSource()
  {
    return this.knr;
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
    if (aXf())
    {
      ad.i("MicroMsg.Video.BaseVideoView", "%s it is live video, do not completion", new Object[] { bel() });
      stop();
      start();
    }
    do
    {
      return;
      super.onCompletion();
    } while (!this.hyg);
    c(0.0D, true);
  }
  
  public final void onUIPause()
  {
    super.onUIPause();
  }
  
  public final void onUIResume()
  {
    super.onUIResume();
    if ((this.kuU != null) && ((this.kuU instanceof AbstractVideoTextureView)))
    {
      if (this.kuY) {
        play();
      }
    }
    else {
      return;
    }
    ((AbstractVideoTextureView)this.kuU).bej();
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.hyg = paramBoolean;
  }
  
  public void setScaleType(e.h paramh)
  {
    if ((this.kuU instanceof AbstractVideoTextureView)) {
      ((AbstractVideoTextureView)this.kuU).setScaleType(paramh);
    }
  }
  
  public void setVideoSource(int paramInt)
  {
    this.knr = paramInt;
  }
  
  public final void start()
  {
    if (this.kuU != null)
    {
      ad.i("MicroMsg.Video.BaseVideoView", "%s start path [%s] [%s]", new Object[] { bel(), this.kuU.getVideoPath(), bt.eGN() });
      if (bt.isNullOrNil(this.kuU.getVideoPath()))
      {
        this.kuU.setVideoPath(this.url);
        this.kva = true;
        showLoading();
      }
    }
    else
    {
      return;
    }
    this.kva = true;
    play();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */