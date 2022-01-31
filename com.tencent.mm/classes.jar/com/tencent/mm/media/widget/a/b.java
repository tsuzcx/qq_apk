package com.tencent.mm.media.widget.a;

import a.l;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camera/CameraConfig;", "", "()V", "encodeVideoBestSizeHeight", "", "getEncodeVideoBestSizeHeight", "()I", "setEncodeVideoBestSizeHeight", "(I)V", "encodeVideoBestSizeWidth", "getEncodeVideoBestSizeWidth", "setEncodeVideoBestSizeWidth", "isCpuCrop", "", "()Z", "setCpuCrop", "(Z)V", "isFrontCamera", "setFrontCamera", "previewHeight", "getPreviewHeight", "setPreviewHeight", "previewWidth", "getPreviewWidth", "setPreviewWidth", "rotateDegree", "getRotateDegree", "setRotateDegree", "cameraTextureSize", "Landroid/graphics/Point;", "toString", "", "plugin-mediaeditor_release"})
public final class b
{
  private static int arA;
  private static int arz;
  private static int eYe;
  private static int eZU;
  private static int eZV;
  private static boolean eZW;
  public static final b eZX;
  private static boolean isFrontCamera;
  
  static
  {
    AppMethodBeat.i(13188);
    eZX = new b();
    AppMethodBeat.o(13188);
  }
  
  public static int WP()
  {
    return eYe;
  }
  
  public static int WQ()
  {
    return eZU;
  }
  
  public static int WR()
  {
    return eZV;
  }
  
  public static boolean WS()
  {
    return isFrontCamera;
  }
  
  public static Point WT()
  {
    AppMethodBeat.i(13187);
    Point localPoint = new Point(arz, arA);
    AppMethodBeat.o(13187);
    return localPoint;
  }
  
  public static void cF(boolean paramBoolean)
  {
    eZW = paramBoolean;
  }
  
  public static int getPreviewHeight()
  {
    return arA;
  }
  
  public static int getPreviewWidth()
  {
    return arz;
  }
  
  public static void kb(int paramInt)
  {
    arA = paramInt;
  }
  
  public static void kc(int paramInt)
  {
    arz = paramInt;
  }
  
  public static void kd(int paramInt)
  {
    eYe = paramInt;
  }
  
  public static void ke(int paramInt)
  {
    eZU = paramInt;
  }
  
  public static void kf(int paramInt)
  {
    eZV = paramInt;
  }
  
  public static void setFrontCamera(boolean paramBoolean)
  {
    isFrontCamera = paramBoolean;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(13186);
    String str = "previewHeight: " + arA + " ,previewWidth:" + arz + " ,rotateDegree: " + eYe + " ,isFrontCamera:" + isFrontCamera + ' ' + " encodeVideoBestSizeWidth : " + eZU + " , encodeVideoBestSizeHeight : " + eZV + ", isCpuCrop: " + eZW + ' ';
    AppMethodBeat.o(13186);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.b
 * JD-Core Version:    0.7.0.1
 */