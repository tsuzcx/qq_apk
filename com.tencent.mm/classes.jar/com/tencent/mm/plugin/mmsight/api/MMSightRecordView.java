package com.tencent.mm.plugin.mmsight.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class MMSightRecordView
  extends FrameLayout
{
  public static MMSightRecordView.b oGh;
  public MMSightRecordView.e oGg;
  
  public MMSightRecordView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(60284);
    init(paramContext);
    AppMethodBeat.o(60284);
  }
  
  public MMSightRecordView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(60283);
    init(paramContext);
    AppMethodBeat.o(60283);
  }
  
  public MMSightRecordView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(60282);
    init(paramContext);
    AppMethodBeat.o(60282);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(60285);
    this.oGg = oGh.asG();
    this.oGg.b(paramContext, this);
    AppMethodBeat.o(60285);
  }
  
  public final void a(MMSightRecordView.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(60294);
    this.oGg.a(paramg, paramBoolean);
    AppMethodBeat.o(60294);
  }
  
  public final void a(MMSightRecordView.h paramh)
  {
    AppMethodBeat.i(60293);
    this.oGg.a(paramh);
    AppMethodBeat.o(60293);
  }
  
  public final void a(ByteBuffer paramByteBuffer, MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(60310);
    this.oGg.a(paramByteBuffer, paramf);
    AppMethodBeat.o(60310);
  }
  
  public int getCameraRotation()
  {
    AppMethodBeat.i(60301);
    int i = this.oGg.getCameraRotation();
    AppMethodBeat.o(60301);
    return i;
  }
  
  public Bitmap getCurrentFramePicture()
  {
    AppMethodBeat.i(60309);
    Bitmap localBitmap = this.oGg.getCurrentFramePicture();
    AppMethodBeat.o(60309);
    return localBitmap;
  }
  
  public Point getDrawSizePoint()
  {
    AppMethodBeat.i(60299);
    Point localPoint = this.oGg.getDrawSizePoint();
    AppMethodBeat.o(60299);
    return localPoint;
  }
  
  public int getFlashMode()
  {
    AppMethodBeat.i(60305);
    int i = this.oGg.getFlashMode();
    AppMethodBeat.o(60305);
    return i;
  }
  
  public Point getPictureSize()
  {
    AppMethodBeat.i(60296);
    Point localPoint = this.oGg.getPictureSize();
    AppMethodBeat.o(60296);
    return localPoint;
  }
  
  public Point getPreviewSize()
  {
    AppMethodBeat.i(60298);
    Point localPoint = this.oGg.getPreviewSize();
    AppMethodBeat.o(60298);
    return localPoint;
  }
  
  public String getVideoFilePath()
  {
    AppMethodBeat.i(60292);
    String str = this.oGg.getVideoFilePath();
    AppMethodBeat.o(60292);
    return str;
  }
  
  public Point getVideoSize()
  {
    AppMethodBeat.i(60297);
    Point localPoint = this.oGg.getVideoSize();
    AppMethodBeat.o(60297);
    return localPoint;
  }
  
  public void setClipPictureSize(boolean paramBoolean)
  {
    AppMethodBeat.i(60303);
    this.oGg.setClipPictureSize(paramBoolean);
    AppMethodBeat.o(60303);
  }
  
  public void setClipVideoSize(boolean paramBoolean)
  {
    AppMethodBeat.i(60302);
    this.oGg.setClipVideoSize(paramBoolean);
    AppMethodBeat.o(60302);
  }
  
  public void setDisplayRatio(float paramFloat)
  {
    AppMethodBeat.i(60288);
    this.oGg.setDisplayRatio(paramFloat);
    AppMethodBeat.o(60288);
  }
  
  public void setEnableDragZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(60306);
    this.oGg.setEnableDragZoom(paramBoolean);
    AppMethodBeat.o(60306);
  }
  
  public void setEnableTouchFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(60307);
    this.oGg.setEnableTouchFocus(paramBoolean);
    AppMethodBeat.o(60307);
  }
  
  public void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(60304);
    this.oGg.setFlashMode(paramInt);
    AppMethodBeat.o(60304);
  }
  
  public void setFrameDataCallback(MMSightRecordView.a parama)
  {
    AppMethodBeat.i(60300);
    this.oGg.setFrameDataCallback(parama);
    AppMethodBeat.o(60300);
  }
  
  public void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    AppMethodBeat.i(60287);
    this.oGg.setInitDoneCallback(paramc);
    AppMethodBeat.o(60287);
  }
  
  public void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    AppMethodBeat.i(60286);
    this.oGg.setInitErrorCallback(paramd);
    AppMethodBeat.o(60286);
  }
  
  public void setPreviewSizeLimit(int paramInt)
  {
    AppMethodBeat.i(60289);
    this.oGg.setPreviewSizeLimit(paramInt);
    AppMethodBeat.o(60289);
  }
  
  public void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(60308);
    this.oGg.setRGBSizeLimit(paramInt);
    AppMethodBeat.o(60308);
  }
  
  public void setUseBackCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(60295);
    this.oGg.setUseBackCamera(paramBoolean);
    AppMethodBeat.o(60295);
  }
  
  public void setVideoFilePath(String paramString)
  {
    AppMethodBeat.i(60291);
    this.oGg.setVideoFilePath(paramString);
    AppMethodBeat.o(60291);
  }
  
  public final void setVideoPara$2e715812(int paramInt)
  {
    AppMethodBeat.i(60290);
    this.oGg.setVideoPara$2e715812(paramInt);
    AppMethodBeat.o(60290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.api.MMSightRecordView
 * JD-Core Version:    0.7.0.1
 */