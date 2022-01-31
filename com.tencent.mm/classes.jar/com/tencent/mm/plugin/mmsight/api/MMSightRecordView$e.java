package com.tencent.mm.plugin.mmsight.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.ViewGroup;
import java.nio.ByteBuffer;

public abstract class MMSightRecordView$e
{
  public abstract boolean EC();
  
  public abstract void a(MMSightRecordView.g paramg, boolean paramBoolean);
  
  public abstract void a(MMSightRecordView.h paramh);
  
  public abstract void a(ByteBuffer paramByteBuffer, MMSightRecordView.f paramf);
  
  public abstract void asH();
  
  public abstract void asM();
  
  public abstract void asN();
  
  public abstract void b(Context paramContext, ViewGroup paramViewGroup);
  
  public abstract int getCameraRotation();
  
  public abstract Bitmap getCurrentFramePicture();
  
  public abstract Point getDrawSizePoint();
  
  public abstract int getFlashMode();
  
  public abstract Point getPictureSize();
  
  public abstract Point getPreviewSize();
  
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
  
  public abstract void setInitDoneCallback(MMSightRecordView.c paramc);
  
  public abstract void setInitErrorCallback(MMSightRecordView.d paramd);
  
  public abstract void setPreviewSizeLimit(int paramInt);
  
  public abstract void setRGBSizeLimit(int paramInt);
  
  public abstract void setUseBackCamera(boolean paramBoolean);
  
  public abstract void setVideoFilePath(String paramString);
  
  public abstract void setVideoPara$2e715812(int paramInt);
  
  public abstract void startPreview();
  
  public abstract void switchCamera();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e
 * JD-Core Version:    0.7.0.1
 */