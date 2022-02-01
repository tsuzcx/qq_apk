package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public abstract class BaseVideoView
  extends AbstractVideoView
{
  protected boolean bzN;
  private boolean iuX = false;
  protected int lpK = 0;
  protected int lqc;
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
    ae.i("MicroMsg.Video.BaseVideoView", "%s set play rate [%f]", new Object[] { bpA(), Float.valueOf(paramFloat) });
    if ((this.lxG instanceof AbstractVideoTextureView)) {
      bool = ((AbstractVideoTextureView)this.lxG).aE(paramFloat);
    }
    return bool;
  }
  
  public final boolean bip()
  {
    boolean bool2 = false;
    boolean bool3 = bpC();
    int i;
    boolean bool1;
    if (this.lxG != null)
    {
      i = this.lxG.getDuration();
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
  
  public final void bns()
  {
    if (this.lxG != null)
    {
      ae.i("MicroMsg.Video.BaseVideoView", "%s preloadVideo url:%s, path:%s", new Object[] { bpA(), this.url, this.lxG.getVideoPath() });
      if (bu.isNullOrNil(this.lxG.getVideoPath()))
      {
        this.lxG.setVideoPath(this.url);
        this.lxM = false;
      }
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    this.bzN = paramBoolean;
    this.url = paramString;
    this.lqc = paramInt;
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    if (bip())
    {
      ae.w("MicroMsg.Video.BaseVideoView", "%s it is live, don't seek ", new Object[] { bpA() });
      return false;
    }
    return super.c(paramDouble, paramBoolean);
  }
  
  protected final a dE(Context paramContext)
  {
    return dF(paramContext);
  }
  
  protected abstract a dF(Context paramContext);
  
  public final void ec(int paramInt1, int paramInt2)
  {
    ae.i("MicroMsg.Video.BaseVideoView", "%s onInfo [%d %d]", new Object[] { bpA(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      if ((this.lxG instanceof AbstractVideoTextureView))
      {
        int i = ((AbstractVideoTextureView)this.lxG).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        return (int)(i * 1.0F / 100.0F * f);
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Video.BaseVideoView", localException, "%s get cache time sec error", new Object[] { bpA() });
    }
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    if (this.lqc <= 0) {
      return super.getVideoDurationSec();
    }
    return this.lqc;
  }
  
  public int getVideoSource()
  {
    return this.lpK;
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
    if (bip())
    {
      ae.i("MicroMsg.Video.BaseVideoView", "%s it is live video, do not completion", new Object[] { bpA() });
      stop();
      start();
    }
    do
    {
      return;
      super.onCompletion();
    } while (!this.iuX);
    c(0.0D, true);
  }
  
  public final void onUIPause()
  {
    super.onUIPause();
  }
  
  public final void onUIResume()
  {
    super.onUIResume();
    if ((this.lxG != null) && ((this.lxG instanceof AbstractVideoTextureView)))
    {
      if (!this.lxK) {
        break label34;
      }
      play();
    }
    label34:
    boolean bool;
    do
    {
      return;
      bool = isShown();
      ae.i("MicroMsg.Video.BaseVideoView", "onUIResume, isShown: ".concat(String.valueOf(bool)));
    } while (!bool);
    ((AbstractVideoTextureView)this.lxG).bpy();
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.iuX = paramBoolean;
  }
  
  public void setScaleType(e.h paramh)
  {
    if ((this.lxG instanceof AbstractVideoTextureView)) {
      ((AbstractVideoTextureView)this.lxG).setScaleType(paramh);
    }
  }
  
  public void setVideoSource(int paramInt)
  {
    this.lpK = paramInt;
  }
  
  public final void start()
  {
    if (this.lxG != null)
    {
      ae.i("MicroMsg.Video.BaseVideoView", "%s start path [%s] [%s]", new Object[] { bpA(), this.lxG.getVideoPath(), bu.fpN() });
      if (bu.isNullOrNil(this.lxG.getVideoPath()))
      {
        this.lxG.setVideoPath(this.url);
        this.lxM = true;
        showLoading();
      }
    }
    else
    {
      return;
    }
    this.lxM = true;
    play();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */