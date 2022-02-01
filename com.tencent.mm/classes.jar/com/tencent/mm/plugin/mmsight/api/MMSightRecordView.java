package com.tencent.mm.plugin.mmsight.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Size;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class MMSightRecordView
  extends FrameLayout
{
  public static b tBq;
  public e tBp;
  
  public MMSightRecordView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148790);
    init(paramContext);
    AppMethodBeat.o(148790);
  }
  
  public MMSightRecordView(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(148791);
    this.tBp = tBq.aLi();
    this.tBp.a(paramContext, this, paramSurfaceTexture, paramInt1, paramInt2);
    AppMethodBeat.o(148791);
  }
  
  public MMSightRecordView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(148789);
    init(paramContext);
    AppMethodBeat.o(148789);
  }
  
  public MMSightRecordView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(148788);
    init(paramContext);
    AppMethodBeat.o(148788);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(148792);
    this.tBp = tBq.aLi();
    this.tBp.b(paramContext, this);
    AppMethodBeat.o(148792);
  }
  
  public final void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(148802);
    this.tBp.a(paramg, paramBoolean);
    AppMethodBeat.o(148802);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(148801);
    this.tBp.a(paramh);
    AppMethodBeat.o(148801);
  }
  
  public final void a(ByteBuffer paramByteBuffer, f paramf)
  {
    AppMethodBeat.i(148819);
    this.tBp.a(paramByteBuffer, paramf);
    AppMethodBeat.o(148819);
  }
  
  public int getCameraRotation()
  {
    AppMethodBeat.i(148809);
    int i = this.tBp.getCameraRotation();
    AppMethodBeat.o(148809);
    return i;
  }
  
  public Bitmap getCurrentFramePicture()
  {
    AppMethodBeat.i(148818);
    Bitmap localBitmap = this.tBp.getCurrentFramePicture();
    AppMethodBeat.o(148818);
    return localBitmap;
  }
  
  public Point getDrawSizePoint()
  {
    AppMethodBeat.i(148807);
    Point localPoint = this.tBp.getDrawSizePoint();
    AppMethodBeat.o(148807);
    return localPoint;
  }
  
  public int getFlashMode()
  {
    AppMethodBeat.i(148813);
    int i = this.tBp.getFlashMode();
    AppMethodBeat.o(148813);
    return i;
  }
  
  public Point getPictureSize()
  {
    AppMethodBeat.i(148804);
    Point localPoint = this.tBp.getPictureSize();
    AppMethodBeat.o(148804);
    return localPoint;
  }
  
  public Point getPreviewSize()
  {
    AppMethodBeat.i(148806);
    Point localPoint = this.tBp.getPreviewSize();
    AppMethodBeat.o(148806);
    return localPoint;
  }
  
  public float[] getSupportZoomMultiple()
  {
    AppMethodBeat.i(148815);
    float[] arrayOfFloat = this.tBp.getSupportZoomMultiple();
    AppMethodBeat.o(148815);
    return arrayOfFloat;
  }
  
  public String getVideoFilePath()
  {
    AppMethodBeat.i(148800);
    String str = this.tBp.getVideoFilePath();
    AppMethodBeat.o(148800);
    return str;
  }
  
  public Point getVideoSize()
  {
    AppMethodBeat.i(148805);
    Point localPoint = this.tBp.getVideoSize();
    AppMethodBeat.o(148805);
    return localPoint;
  }
  
  public void setClipPictureSize(boolean paramBoolean)
  {
    AppMethodBeat.i(148811);
    this.tBp.setClipPictureSize(paramBoolean);
    AppMethodBeat.o(148811);
  }
  
  public void setClipVideoSize(boolean paramBoolean)
  {
    AppMethodBeat.i(148810);
    this.tBp.setClipVideoSize(paramBoolean);
    AppMethodBeat.o(148810);
  }
  
  public void setDisplayRatio(float paramFloat)
  {
    AppMethodBeat.i(148795);
    this.tBp.setDisplayRatio(paramFloat);
    AppMethodBeat.o(148795);
  }
  
  public void setDisplayScreenSize(Size paramSize)
  {
    AppMethodBeat.i(195201);
    this.tBp.setDisplayScreenSize(paramSize);
    AppMethodBeat.o(195201);
  }
  
  public void setEnableDragZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(148814);
    this.tBp.setEnableDragZoom(paramBoolean);
    AppMethodBeat.o(148814);
  }
  
  public void setEnableTouchFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(148816);
    this.tBp.setEnableTouchFocus(paramBoolean);
    AppMethodBeat.o(148816);
  }
  
  public void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(148812);
    this.tBp.setFlashMode(paramInt);
    AppMethodBeat.o(148812);
  }
  
  public void setFrameDataCallback(a parama)
  {
    AppMethodBeat.i(148808);
    this.tBp.setFrameDataCallback(parama);
    AppMethodBeat.o(148808);
  }
  
  public void setInitDoneCallback(c paramc)
  {
    AppMethodBeat.i(148794);
    this.tBp.setInitDoneCallback(paramc);
    AppMethodBeat.o(148794);
  }
  
  public void setInitErrorCallback(d paramd)
  {
    AppMethodBeat.i(148793);
    this.tBp.setInitErrorCallback(paramd);
    AppMethodBeat.o(148793);
  }
  
  public void setPreviewMode(int paramInt)
  {
    AppMethodBeat.i(148797);
    this.tBp.setPreviewMode(paramInt);
    AppMethodBeat.o(148797);
  }
  
  public void setPreviewSizeLimit(int paramInt)
  {
    AppMethodBeat.i(148796);
    this.tBp.setPreviewSizeLimit(paramInt);
    AppMethodBeat.o(148796);
  }
  
  public void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(148817);
    this.tBp.setRGBSizeLimit(paramInt);
    AppMethodBeat.o(148817);
  }
  
  public void setUseBackCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(148803);
    this.tBp.setUseBackCamera(paramBoolean);
    AppMethodBeat.o(148803);
  }
  
  public void setVideoFilePath(String paramString)
  {
    AppMethodBeat.i(148799);
    this.tBp.setVideoFilePath(paramString);
    AppMethodBeat.o(148799);
  }
  
  public final void setVideoPara$2e715812(int paramInt)
  {
    AppMethodBeat.i(148798);
    this.tBp.setVideoPara$2e715812(paramInt);
    AppMethodBeat.o(148798);
  }
  
  public static abstract interface a
  {
    public abstract void t(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract MMSightRecordView.e aLi();
  }
  
  public static abstract interface c
  {
    public abstract void aZw();
  }
  
  public static abstract interface d
  {
    public abstract void aZv();
  }
  
  public static abstract class e
  {
    public abstract boolean Ok();
    
    public abstract void a(Context paramContext, ViewGroup paramViewGroup, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2);
    
    public abstract void a(MMSightRecordView.g paramg, boolean paramBoolean);
    
    public abstract void a(MMSightRecordView.h paramh);
    
    public abstract void a(ByteBuffer paramByteBuffer, MMSightRecordView.f paramf);
    
    public abstract void aLj();
    
    public abstract void aLo();
    
    public abstract void aLp();
    
    public abstract boolean am(float paramFloat);
    
    public abstract void b(Context paramContext, ViewGroup paramViewGroup);
    
    public abstract int getCameraRotation();
    
    public abstract Bitmap getCurrentFramePicture();
    
    public abstract Point getDrawSizePoint();
    
    public abstract int getFlashMode();
    
    public abstract Point getPictureSize();
    
    public abstract Point getPreviewSize();
    
    public abstract float[] getSupportZoomMultiple();
    
    public abstract String getVideoFilePath();
    
    public abstract Point getVideoSize();
    
    public abstract void n(MotionEvent paramMotionEvent);
    
    public abstract void release();
    
    public abstract void setClipPictureSize(boolean paramBoolean);
    
    public abstract void setClipVideoSize(boolean paramBoolean);
    
    public abstract void setDisplayRatio(float paramFloat);
    
    public abstract void setDisplayScreenSize(Size paramSize);
    
    public abstract void setEnableDragZoom(boolean paramBoolean);
    
    public abstract void setEnableTouchFocus(boolean paramBoolean);
    
    public abstract void setFlashMode(int paramInt);
    
    public abstract void setFrameDataCallback(MMSightRecordView.a parama);
    
    public abstract void setInitDoneCallback(MMSightRecordView.c paramc);
    
    public abstract void setInitErrorCallback(MMSightRecordView.d paramd);
    
    public abstract void setPreviewMode(int paramInt);
    
    public abstract void setPreviewSizeLimit(int paramInt);
    
    public abstract void setRGBSizeLimit(int paramInt);
    
    public abstract void setUseBackCamera(boolean paramBoolean);
    
    public abstract void setVideoFilePath(String paramString);
    
    public abstract void setVideoPara$2e715812(int paramInt);
    
    public abstract void startPreview();
    
    public abstract void switchCamera();
  }
  
  public static abstract interface f
  {
    public abstract void aZz();
  }
  
  public static abstract interface g
  {
    public abstract void N(Bitmap paramBitmap);
    
    public abstract void aZy();
  }
  
  public static abstract interface h
  {
    public abstract void fU(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.api.MMSightRecordView
 * JD-Core Version:    0.7.0.1
 */