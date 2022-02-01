package com.tencent.mm.media.widget.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camera/CameraConfig;", "", "()V", "encodeVideoBestSizeHeight", "", "getEncodeVideoBestSizeHeight", "()I", "setEncodeVideoBestSizeHeight", "(I)V", "encodeVideoBestSizeWidth", "getEncodeVideoBestSizeWidth", "setEncodeVideoBestSizeWidth", "isCpuCrop", "", "()Z", "setCpuCrop", "(Z)V", "isFrontCamera", "setFrontCamera", "previewHeight", "getPreviewHeight", "setPreviewHeight", "previewWidth", "getPreviewWidth", "setPreviewWidth", "rotateDegree", "getRotateDegree", "setRotateDegree", "cameraTextureSize", "Landroid/graphics/Point;", "toString", "", "plugin-mediaeditor_release"})
public final class b
{
  private static boolean isFrontCamera;
  private static int kYg;
  private static int lbe;
  private static int lbf;
  private static boolean lbg;
  public static final b lbh;
  private static int previewHeight;
  private static int previewWidth;
  
  static
  {
    AppMethodBeat.i(94010);
    lbh = new b();
    AppMethodBeat.o(94010);
  }
  
  public static int aVp()
  {
    return kYg;
  }
  
  public static int aXY()
  {
    return lbe;
  }
  
  public static int aXZ()
  {
    return lbf;
  }
  
  public static Point aYa()
  {
    AppMethodBeat.i(94009);
    Point localPoint = new Point(previewWidth, previewHeight);
    AppMethodBeat.o(94009);
    return localPoint;
  }
  
  public static void fI(boolean paramBoolean)
  {
    lbg = paramBoolean;
  }
  
  public static int getPreviewHeight()
  {
    return previewHeight;
  }
  
  public static int getPreviewWidth()
  {
    return previewWidth;
  }
  
  public static boolean isFrontCamera()
  {
    return isFrontCamera;
  }
  
  public static void setFrontCamera(boolean paramBoolean)
  {
    isFrontCamera = paramBoolean;
  }
  
  public static void uk(int paramInt)
  {
    previewHeight = paramInt;
  }
  
  public static void ul(int paramInt)
  {
    previewWidth = paramInt;
  }
  
  public static void um(int paramInt)
  {
    kYg = paramInt;
  }
  
  public static void un(int paramInt)
  {
    lbe = paramInt;
  }
  
  public static void uo(int paramInt)
  {
    lbf = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94008);
    String str = "previewHeight: " + previewHeight + " ,previewWidth:" + previewWidth + " ,rotateDegree: " + kYg + " ,isFrontCamera:" + isFrontCamera + ' ' + " encodeVideoBestSizeWidth : " + lbe + " , encodeVideoBestSizeHeight : " + lbf + ", isCpuCrop: " + lbg + ' ';
    AppMethodBeat.o(94008);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.b
 * JD-Core Version:    0.7.0.1
 */