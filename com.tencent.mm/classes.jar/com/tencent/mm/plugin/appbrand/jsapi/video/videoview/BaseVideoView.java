package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class BaseVideoView
  extends AbstractVideoView
{
  protected boolean bzP;
  private boolean jqj = false;
  protected int mwI;
  protected int mwp = 0;
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
  
  public final boolean aO(float paramFloat)
  {
    boolean bool = false;
    Log.i("MicroMsg.Video.BaseVideoView", "%s set play rate [%f]", new Object[] { bgQ(), Float.valueOf(paramFloat) });
    if ((this.mEE instanceof AbstractVideoTextureView)) {
      bool = ((AbstractVideoTextureView)this.mEE).aO(paramFloat);
    }
    return bool;
  }
  
  public final void bIW()
  {
    if (this.mEE != null)
    {
      Log.i("MicroMsg.Video.BaseVideoView", "%s preloadVideo url:%s, path:%s", new Object[] { bgQ(), this.url, this.mEE.getVideoPath() });
      if (Util.isNullOrNil(this.mEE.getVideoPath()))
      {
        this.mEE.setVideoPath(this.url);
        this.mEK = false;
      }
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    this.bzP = paramBoolean;
    this.url = paramString;
    this.mwI = paramInt;
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    if (isLive())
    {
      Log.w("MicroMsg.Video.BaseVideoView", "%s it is live, don't seek ", new Object[] { bgQ() });
      return false;
    }
    return super.c(paramDouble, paramBoolean);
  }
  
  protected final a dZ(Context paramContext)
  {
    return ea(paramContext);
  }
  
  protected abstract a ea(Context paramContext);
  
  public final void ep(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.Video.BaseVideoView", "%s onInfo [%d %d]", new Object[] { bgQ(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      if ((this.mEE instanceof AbstractVideoTextureView))
      {
        int i = ((AbstractVideoTextureView)this.mEE).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        return (int)(i * 1.0F / 100.0F * f);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Video.BaseVideoView", localException, "%s get cache time sec error", new Object[] { bgQ() });
    }
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    if (this.mwI <= 0) {
      return super.getVideoDurationSec();
    }
    return this.mwI;
  }
  
  public int getVideoSource()
  {
    return this.mwp;
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
    boolean bool3 = asa();
    int i;
    boolean bool1;
    if (this.mEE != null)
    {
      i = this.mEE.getDuration();
      if (!this.bzP) {
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
      Log.i("MicroMsg.Video.BaseVideoView", "%s it is live video, do not completion", new Object[] { bgQ() });
      stop();
      start();
    }
    do
    {
      return;
      super.onCompletion();
    } while (!this.jqj);
    c(0.0D, true);
  }
  
  public final void onUIPause()
  {
    super.onUIPause();
  }
  
  public final void onUIResume()
  {
    boolean bool1 = this.mEw;
    super.onUIResume();
    if ((this.mEE != null) && ((this.mEE instanceof AbstractVideoTextureView)))
    {
      if (!this.mEI) {
        break label39;
      }
      play();
    }
    label39:
    boolean bool2;
    do
    {
      return;
      bool2 = isShown();
      Log.i("MicroMsg.Video.BaseVideoView", "onUIResume, oldIsUIAvailable: %b, isShown: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    } while ((bool1) || (!bool2));
    ((AbstractVideoTextureView)this.mEE).bLe();
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.jqj = paramBoolean;
  }
  
  public void setScaleType(e.h paramh)
  {
    if ((this.mEE instanceof AbstractVideoTextureView)) {
      ((AbstractVideoTextureView)this.mEE).setScaleType(paramh);
    }
  }
  
  public void setVideoSource(int paramInt)
  {
    this.mwp = paramInt;
  }
  
  public final void start()
  {
    if (this.mEE != null)
    {
      Log.i("MicroMsg.Video.BaseVideoView", "%s start path [%s] [%s]", new Object[] { bgQ(), this.mEE.getVideoPath(), Util.getStack() });
      if (Util.isNullOrNil(this.mEE.getVideoPath()))
      {
        this.mEE.setVideoPath(this.url);
        this.mEK = true;
        showLoading();
      }
    }
    else
    {
      return;
    }
    this.mEK = true;
    play();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */