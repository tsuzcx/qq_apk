package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class BaseVideoView
  extends AbstractVideoView
{
  protected boolean bjq;
  private boolean mfK = false;
  protected int puP = 0;
  protected int pvi;
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
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    if (isLive())
    {
      Log.w("MicroMsg.Video.BaseVideoView", "%s it is live, don't seek ", new Object[] { bqf() });
      return false;
    }
    return super.a(paramDouble, paramBoolean);
  }
  
  public final boolean aO(float paramFloat)
  {
    boolean bool = false;
    Log.i("MicroMsg.Video.BaseVideoView", "%s set play rate [%f]", new Object[] { bqf(), Float.valueOf(paramFloat) });
    if ((this.pDQ instanceof AbstractVideoTextureView)) {
      bool = ((AbstractVideoTextureView)this.pDQ).aO(paramFloat);
    }
    return bool;
  }
  
  public final void bUF()
  {
    if (this.pDQ != null)
    {
      Log.i("MicroMsg.Video.BaseVideoView", "%s preloadVideo url:%s, path:%s", new Object[] { bqf(), this.url, this.pDQ.getVideoPath() });
      if (Util.isNullOrNil(this.pDQ.getVideoPath()))
      {
        this.pDQ.setVideoPath(this.url);
        this.pDW = false;
      }
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    this.bjq = paramBoolean;
    this.url = paramString;
    this.pvi = paramInt;
  }
  
  protected final a dX(Context paramContext)
  {
    return dY(paramContext);
  }
  
  protected abstract a dY(Context paramContext);
  
  public final void eN(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.Video.BaseVideoView", "%s onInfo [%d %d]", new Object[] { bqf(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      if ((this.pDQ instanceof AbstractVideoTextureView))
      {
        int i = ((AbstractVideoTextureView)this.pDQ).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        return (int)(i * 1.0F / 100.0F * f);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Video.BaseVideoView", localException, "%s get cache time sec error", new Object[] { bqf() });
    }
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    if (this.pvi <= 0) {
      return super.getVideoDurationSec();
    }
    return this.pvi;
  }
  
  public int getVideoSource()
  {
    return this.puP;
  }
  
  public View getView()
  {
    return this;
  }
  
  public final void hideLoading()
  {
    super.hideLoading();
  }
  
  public final boolean isLive()
  {
    boolean bool2 = false;
    boolean bool3 = ayN();
    int i;
    boolean bool1;
    if (this.pDQ != null)
    {
      i = this.pDQ.getDuration();
      if (!this.bjq) {
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
  
  public final void onCompletion()
  {
    if (isLive())
    {
      Log.i("MicroMsg.Video.BaseVideoView", "%s it is live video, do not completion", new Object[] { bqf() });
      stop();
      start();
    }
    do
    {
      return;
      super.onCompletion();
    } while (!this.mfK);
    a(0.0D, true);
  }
  
  public final void onUIPause()
  {
    super.onUIPause();
  }
  
  public final void onUIResume()
  {
    boolean bool1 = this.pDI;
    super.onUIResume();
    if ((this.pDQ != null) && ((this.pDQ instanceof AbstractVideoTextureView)))
    {
      if (!this.pDU) {
        break label39;
      }
      bqo();
    }
    label39:
    boolean bool2;
    do
    {
      return;
      bool2 = isShown();
      Log.i("MicroMsg.Video.BaseVideoView", "onUIResume, oldIsUIAvailable: %b, isShown: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    } while ((bool1) || (!bool2));
    ((AbstractVideoTextureView)this.pDQ).bXe();
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.mfK = paramBoolean;
  }
  
  public void setScaleType(d.h paramh)
  {
    if ((this.pDQ instanceof AbstractVideoTextureView)) {
      ((AbstractVideoTextureView)this.pDQ).setScaleType(paramh);
    }
  }
  
  public void setVideoSource(int paramInt)
  {
    this.puP = paramInt;
  }
  
  public final void start()
  {
    if (this.pDQ != null)
    {
      Log.i("MicroMsg.Video.BaseVideoView", "%s start path [%s] [%s]", new Object[] { bqf(), this.pDQ.getVideoPath(), Util.getStack() });
      if (Util.isNullOrNil(this.pDQ.getVideoPath()))
      {
        this.pDQ.setVideoPath(this.url);
        this.pDW = true;
        showLoading();
      }
    }
    else
    {
      return;
    }
    this.pDW = true;
    bqo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */