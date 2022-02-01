package com.tencent.mm.plugin.mmsight.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Size;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class MMSightRecordView
  extends FrameLayout
{
  public static b KUl;
  public e KUk;
  
  public MMSightRecordView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148790);
    init(paramContext);
    AppMethodBeat.o(148790);
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
  
  public MMSightRecordView(Context paramContext, Surface paramSurface, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(303649);
    this.KUk = KUl.caS();
    this.KUk.a(paramContext, this, paramSurface, paramInt1, paramInt2);
    AppMethodBeat.o(303649);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(148792);
    this.KUk = KUl.caS();
    this.KUk.b(paramContext, this);
    AppMethodBeat.o(148792);
  }
  
  public final void a(MMSightRecordView.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(148802);
    this.KUk.a(paramg, paramBoolean);
    AppMethodBeat.o(148802);
  }
  
  public final void a(MMSightRecordView.h paramh)
  {
    AppMethodBeat.i(148801);
    this.KUk.a(paramh);
    AppMethodBeat.o(148801);
  }
  
  public final void a(ByteBuffer paramByteBuffer, MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(148819);
    this.KUk.a(paramByteBuffer, paramf);
    AppMethodBeat.o(148819);
  }
  
  public int getCameraRotation()
  {
    AppMethodBeat.i(148809);
    int i = this.KUk.getCameraRotation();
    AppMethodBeat.o(148809);
    return i;
  }
  
  public Bitmap getCurrentFramePicture()
  {
    AppMethodBeat.i(148818);
    Bitmap localBitmap = this.KUk.getCurrentFramePicture();
    AppMethodBeat.o(148818);
    return localBitmap;
  }
  
  public Point getDrawSizePoint()
  {
    AppMethodBeat.i(148807);
    Point localPoint = this.KUk.getDrawSizePoint();
    AppMethodBeat.o(148807);
    return localPoint;
  }
  
  public int getFlashMode()
  {
    AppMethodBeat.i(148813);
    int i = this.KUk.getFlashMode();
    AppMethodBeat.o(148813);
    return i;
  }
  
  public Point getPictureSize()
  {
    AppMethodBeat.i(148804);
    Point localPoint = this.KUk.getPictureSize();
    AppMethodBeat.o(148804);
    return localPoint;
  }
  
  public Point getPreviewSize()
  {
    AppMethodBeat.i(148806);
    Point localPoint = this.KUk.getPreviewSize();
    AppMethodBeat.o(148806);
    return localPoint;
  }
  
  public float[] getSupportZoomMultiple()
  {
    AppMethodBeat.i(148815);
    float[] arrayOfFloat = this.KUk.getSupportZoomMultiple();
    AppMethodBeat.o(148815);
    return arrayOfFloat;
  }
  
  public String getVideoFilePath()
  {
    AppMethodBeat.i(148800);
    String str = this.KUk.getVideoFilePath();
    AppMethodBeat.o(148800);
    return str;
  }
  
  public Point getVideoSize()
  {
    AppMethodBeat.i(148805);
    Point localPoint = this.KUk.getVideoSize();
    AppMethodBeat.o(148805);
    return localPoint;
  }
  
  public final boolean hT(boolean paramBoolean)
  {
    AppMethodBeat.i(303653);
    paramBoolean = this.KUk.hT(paramBoolean);
    AppMethodBeat.o(303653);
    return paramBoolean;
  }
  
  public void setClipPictureSize(boolean paramBoolean)
  {
    AppMethodBeat.i(148811);
    this.KUk.setClipPictureSize(paramBoolean);
    AppMethodBeat.o(148811);
  }
  
  public void setClipVideoSize(boolean paramBoolean)
  {
    AppMethodBeat.i(148810);
    this.KUk.setClipVideoSize(paramBoolean);
    AppMethodBeat.o(148810);
  }
  
  public void setDisplayRatio(float paramFloat)
  {
    AppMethodBeat.i(148795);
    this.KUk.setDisplayRatio(paramFloat);
    AppMethodBeat.o(148795);
  }
  
  public void setDisplayScreenSize(Size paramSize)
  {
    AppMethodBeat.i(303670);
    this.KUk.setDisplayScreenSize(paramSize);
    AppMethodBeat.o(303670);
  }
  
  public void setEnableDragZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(148814);
    this.KUk.setEnableDragZoom(paramBoolean);
    AppMethodBeat.o(148814);
  }
  
  public void setEnableTouchFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(148816);
    this.KUk.setEnableTouchFocus(paramBoolean);
    AppMethodBeat.o(148816);
  }
  
  public void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(148812);
    this.KUk.setFlashMode(paramInt);
    AppMethodBeat.o(148812);
  }
  
  public void setFrameDataCallback(MMSightRecordView.a parama)
  {
    AppMethodBeat.i(148808);
    this.KUk.setFrameDataCallback(parama);
    AppMethodBeat.o(148808);
  }
  
  public void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    AppMethodBeat.i(148794);
    this.KUk.setInitDoneCallback(paramc);
    AppMethodBeat.o(148794);
  }
  
  public void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    AppMethodBeat.i(148793);
    this.KUk.setInitErrorCallback(paramd);
    AppMethodBeat.o(148793);
  }
  
  public void setPreviewMode(int paramInt)
  {
    AppMethodBeat.i(148797);
    this.KUk.setPreviewMode(paramInt);
    AppMethodBeat.o(148797);
  }
  
  public void setPreviewSizeLimit(int paramInt)
  {
    AppMethodBeat.i(148796);
    this.KUk.setPreviewSizeLimit(paramInt);
    AppMethodBeat.o(148796);
  }
  
  public void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(148817);
    this.KUk.setRGBSizeLimit(paramInt);
    AppMethodBeat.o(148817);
  }
  
  public void setUseBackCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(148803);
    this.KUk.setUseBackCamera(paramBoolean);
    AppMethodBeat.o(148803);
  }
  
  public void setVideoFilePath(String paramString)
  {
    AppMethodBeat.i(148799);
    this.KUk.setVideoFilePath(paramString);
    AppMethodBeat.o(148799);
  }
  
  public final void yR(int paramInt)
  {
    AppMethodBeat.i(148798);
    this.KUk.yR(paramInt);
    AppMethodBeat.o(148798);
  }
  
  public static abstract interface b
  {
    public abstract MMSightRecordView.e caS();
  }
  
  public static abstract class e
  {
    public abstract void a(Context paramContext, ViewGroup paramViewGroup, Surface paramSurface, int paramInt1, int paramInt2);
    
    public abstract void a(MMSightRecordView.g paramg, boolean paramBoolean);
    
    public abstract void a(MMSightRecordView.h paramh);
    
    public abstract void a(ByteBuffer paramByteBuffer, MMSightRecordView.f paramf);
    
    public abstract void aPz();
    
    public abstract void b(Context paramContext, ViewGroup paramViewGroup);
    
    public abstract boolean bB(float paramFloat);
    
    public abstract void caT();
    
    public abstract void caY();
    
    public abstract void caZ();
    
    public abstract int getCameraRotation();
    
    public abstract Bitmap getCurrentFramePicture();
    
    public abstract Point getDrawSizePoint();
    
    public abstract int getFlashMode();
    
    public abstract Point getPictureSize();
    
    public abstract Point getPreviewSize();
    
    public abstract float[] getSupportZoomMultiple();
    
    public abstract String getVideoFilePath();
    
    public abstract Point getVideoSize();
    
    public abstract boolean hT(boolean paramBoolean);
    
    public abstract void o(MotionEvent paramMotionEvent);
    
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
    
    public abstract void switchCamera();
    
    public abstract void yR(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.api.MMSightRecordView
 * JD-Core Version:    0.7.0.1
 */