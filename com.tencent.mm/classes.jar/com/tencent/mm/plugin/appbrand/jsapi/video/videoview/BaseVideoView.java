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
  protected boolean ddk;
  private boolean oYG = false;
  protected int sAo;
  protected int szV = 0;
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
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    this.ddk = paramBoolean;
    this.url = paramString;
    this.sAo = paramInt;
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    if (isLive())
    {
      Log.w("MicroMsg.Video.BaseVideoView", "%s it is live, don't seek ", new Object[] { bNL() });
      return false;
    }
    return super.b(paramDouble, paramBoolean);
  }
  
  public final boolean bM(float paramFloat)
  {
    boolean bool = false;
    Log.i("MicroMsg.Video.BaseVideoView", "%s set play rate [%f]", new Object[] { bNL(), Float.valueOf(paramFloat) });
    if ((this.sJc instanceof AbstractVideoTextureView)) {
      bool = ((AbstractVideoTextureView)this.sJc).bM(paramFloat);
    }
    return bool;
  }
  
  public final void cuV()
  {
    if (this.sJc != null)
    {
      Log.i("MicroMsg.Video.BaseVideoView", "%s preloadVideo url:%s, path:%s", new Object[] { bNL(), this.url, this.sJc.getVideoPath() });
      if (Util.isNullOrNil(this.sJc.getVideoPath()))
      {
        this.sJc.setVideoPath(this.url);
        this.sJi = false;
      }
    }
  }
  
  protected final a eR(Context paramContext)
  {
    return eS(paramContext);
  }
  
  protected abstract a eS(Context paramContext);
  
  public int getCacheTimeSec()
  {
    try
    {
      if ((this.sJc instanceof AbstractVideoTextureView))
      {
        int i = ((AbstractVideoTextureView)this.sJc).getDownloadPercent();
        int j = super.getVideoDurationSec();
        float f = j;
        return (int)(i * 1.0F / 100.0F * f);
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Video.BaseVideoView", localException, "%s get cache time sec error", new Object[] { bNL() });
    }
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    if (this.sAo <= 0) {
      return super.getVideoDurationSec();
    }
    return this.sAo;
  }
  
  public int getVideoSource()
  {
    return this.szV;
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
    boolean bool3 = cxs();
    int i;
    boolean bool1;
    if (this.sJc != null)
    {
      i = this.sJc.getDuration();
      if (!this.ddk) {
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
      Log.i("MicroMsg.Video.BaseVideoView", "%s it is live video, do not completion", new Object[] { bNL() });
      stop();
      start();
    }
    do
    {
      return;
      super.onCompletion();
    } while (!this.oYG);
    b(0.0D, true);
  }
  
  public final void onInfo(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.Video.BaseVideoView", "%s onInfo [%d %d]", new Object[] { bNL(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701) {
      showLoading();
    }
    while (paramInt1 != 702) {
      return;
    }
    super.hideLoading();
  }
  
  public final void onUIPause()
  {
    super.onUIPause();
  }
  
  public final void onUIResume()
  {
    boolean bool1 = this.sIU;
    super.onUIResume();
    if ((this.sJc != null) && ((this.sJc instanceof AbstractVideoTextureView)))
    {
      if (!this.sJg) {
        break label39;
      }
      bNU();
    }
    label39:
    boolean bool2;
    do
    {
      return;
      bool2 = isShown();
      Log.i("MicroMsg.Video.BaseVideoView", "onUIResume, oldIsUIAvailable: %b, isShown: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    } while ((bool1) || (!bool2));
    ((AbstractVideoTextureView)this.sJc).cxp();
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.oYG = paramBoolean;
  }
  
  public void setScaleType(d.h paramh)
  {
    if ((this.sJc instanceof AbstractVideoTextureView)) {
      ((AbstractVideoTextureView)this.sJc).setScaleType(paramh);
    }
  }
  
  public void setVideoSource(int paramInt)
  {
    this.szV = paramInt;
  }
  
  public final void start()
  {
    if (this.sJc != null)
    {
      Log.i("MicroMsg.Video.BaseVideoView", "%s start path [%s] [%s]", new Object[] { bNL(), this.sJc.getVideoPath(), Util.getStack() });
      if (Util.isNullOrNil(this.sJc.getVideoPath()))
      {
        this.sJc.setVideoPath(this.url);
        this.sJi = true;
        showLoading();
      }
    }
    else
    {
      return;
    }
    this.sJi = true;
    bNU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */