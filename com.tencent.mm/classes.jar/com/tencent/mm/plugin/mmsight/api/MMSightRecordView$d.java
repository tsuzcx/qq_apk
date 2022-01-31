package com.tencent.mm.plugin.mmsight.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.ViewGroup;

public abstract class MMSightRecordView$d
{
  public abstract void YY();
  
  public abstract void Zd();
  
  public abstract void Ze();
  
  public abstract void a(MMSightRecordView.e parame, boolean paramBoolean);
  
  public abstract void a(MMSightRecordView.f paramf);
  
  public abstract void b(Context paramContext, ViewGroup paramViewGroup);
  
  public abstract int getCameraRotation();
  
  public abstract Bitmap getCurrentFramePicture();
  
  public abstract int getFlashMode();
  
  public abstract Point getPictureSize();
  
  public abstract String getVideoFilePath();
  
  public abstract Point getVideoSize();
  
  public abstract void release();
  
  public abstract void setClipPictureSize(boolean paramBoolean);
  
  public abstract void setClipVideoSize(boolean paramBoolean);
  
  public abstract void setDisplayRatio(float paramFloat);
  
  public abstract void setEnableDragZoom(boolean paramBoolean);
  
  public abstract void setEnableTouchFocus(boolean paramBoolean);
  
  public abstract void setFlashMode(int paramInt);
  
  public abstract void setFrameDataCallback(MMSightRecordView.a parama);
  
  public abstract void setInitErrorCallback(MMSightRecordView.c paramc);
  
  public abstract void setPreviewSizeLimit(int paramInt);
  
  public abstract void setUseBackCamera(boolean paramBoolean);
  
  public abstract void setVideoFilePath(String paramString);
  
  public abstract void setVideoPara$2e715812(int paramInt);
  
  public abstract void startPreview();
  
  public abstract void switchCamera();
  
  public abstract boolean uq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d
 * JD-Core Version:    0.7.0.1
 */