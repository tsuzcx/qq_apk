package com.tencent.mm.plugin.mmsight.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class MMSightRecordView
  extends FrameLayout
{
  public static MMSightRecordView.b mfH;
  public MMSightRecordView.d mfG;
  
  public MMSightRecordView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MMSightRecordView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MMSightRecordView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mfG = mfH.YX();
    this.mfG.b(paramContext, this);
  }
  
  public final void a(MMSightRecordView.e parame, boolean paramBoolean)
  {
    this.mfG.a(parame, paramBoolean);
  }
  
  public final void a(MMSightRecordView.f paramf)
  {
    this.mfG.a(paramf);
  }
  
  public int getCameraRotation()
  {
    return this.mfG.getCameraRotation();
  }
  
  public Bitmap getCurrentFramePicture()
  {
    return this.mfG.getCurrentFramePicture();
  }
  
  public int getFlashMode()
  {
    return this.mfG.getFlashMode();
  }
  
  public Point getPictureSize()
  {
    return this.mfG.getPictureSize();
  }
  
  public String getVideoFilePath()
  {
    return this.mfG.getVideoFilePath();
  }
  
  public Point getVideoSize()
  {
    return this.mfG.getVideoSize();
  }
  
  public void setClipPictureSize(boolean paramBoolean)
  {
    this.mfG.setClipPictureSize(paramBoolean);
  }
  
  public void setClipVideoSize(boolean paramBoolean)
  {
    this.mfG.setClipVideoSize(paramBoolean);
  }
  
  public void setDisplayRatio(float paramFloat)
  {
    this.mfG.setDisplayRatio(paramFloat);
  }
  
  public void setEnableDragZoom(boolean paramBoolean)
  {
    this.mfG.setEnableDragZoom(paramBoolean);
  }
  
  public void setEnableTouchFocus(boolean paramBoolean)
  {
    this.mfG.setEnableTouchFocus(paramBoolean);
  }
  
  public void setFlashMode(int paramInt)
  {
    this.mfG.setFlashMode(paramInt);
  }
  
  public void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.mfG.setFrameDataCallback(parama);
  }
  
  public void setInitErrorCallback(MMSightRecordView.c paramc)
  {
    this.mfG.setInitErrorCallback(paramc);
  }
  
  public void setPreviewSizeLimit(int paramInt)
  {
    this.mfG.setPreviewSizeLimit(paramInt);
  }
  
  public void setUseBackCamera(boolean paramBoolean)
  {
    this.mfG.setUseBackCamera(paramBoolean);
  }
  
  public void setVideoFilePath(String paramString)
  {
    this.mfG.setVideoFilePath(paramString);
  }
  
  public final void setVideoPara$2e715812(int paramInt)
  {
    this.mfG.setVideoPara$2e715812(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.api.MMSightRecordView
 * JD-Core Version:    0.7.0.1
 */