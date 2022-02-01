package com.tencent.mm.media.widget.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camera/CameraConfig;", "", "()V", "encodeVideoBestSizeHeight", "", "getEncodeVideoBestSizeHeight", "()I", "setEncodeVideoBestSizeHeight", "(I)V", "encodeVideoBestSizeWidth", "getEncodeVideoBestSizeWidth", "setEncodeVideoBestSizeWidth", "isCpuCrop", "", "()Z", "setCpuCrop", "(Z)V", "isFrontCamera", "setFrontCamera", "previewHeight", "getPreviewHeight", "setPreviewHeight", "previewWidth", "getPreviewWidth", "setPreviewWidth", "rotateDegree", "getRotateDegree", "setRotateDegree", "cameraTextureSize", "Landroid/graphics/Point;", "toString", "", "plugin-mediaeditor_release"})
public final class b
{
  private static int aXs;
  private static int aXt;
  private static int hpY;
  private static int hsd;
  private static int hse;
  private static boolean hsf;
  private static boolean hsg;
  public static final b hsh;
  
  static
  {
    AppMethodBeat.i(94010);
    hsh = new b();
    AppMethodBeat.o(94010);
  }
  
  public static int aws()
  {
    return hpY;
  }
  
  public static int awt()
  {
    return hsd;
  }
  
  public static int awu()
  {
    return hse;
  }
  
  public static boolean awv()
  {
    return hsf;
  }
  
  public static Point aww()
  {
    AppMethodBeat.i(94009);
    Point localPoint = new Point(aXs, aXt);
    AppMethodBeat.o(94009);
    return localPoint;
  }
  
  public static void ej(boolean paramBoolean)
  {
    hsg = paramBoolean;
  }
  
  public static int getPreviewHeight()
  {
    return aXt;
  }
  
  public static int getPreviewWidth()
  {
    return aXs;
  }
  
  public static void nT(int paramInt)
  {
    aXt = paramInt;
  }
  
  public static void nU(int paramInt)
  {
    aXs = paramInt;
  }
  
  public static void nV(int paramInt)
  {
    hpY = paramInt;
  }
  
  public static void nW(int paramInt)
  {
    hsd = paramInt;
  }
  
  public static void nX(int paramInt)
  {
    hse = paramInt;
  }
  
  public static void setFrontCamera(boolean paramBoolean)
  {
    hsf = paramBoolean;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94008);
    String str = "previewHeight: " + aXt + " ,previewWidth:" + aXs + " ,rotateDegree: " + hpY + " ,isFrontCamera:" + hsf + ' ' + " encodeVideoBestSizeWidth : " + hsd + " , encodeVideoBestSizeHeight : " + hse + ", isCpuCrop: " + hsg + ' ';
    AppMethodBeat.o(94008);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.b
 * JD-Core Version:    0.7.0.1
 */