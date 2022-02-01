package com.tencent.mm.media.widget.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camera/CameraConfig;", "", "()V", "encodeVideoBestSizeHeight", "", "getEncodeVideoBestSizeHeight", "()I", "setEncodeVideoBestSizeHeight", "(I)V", "encodeVideoBestSizeWidth", "getEncodeVideoBestSizeWidth", "setEncodeVideoBestSizeWidth", "isCpuCrop", "", "()Z", "setCpuCrop", "(Z)V", "isFrontCamera", "setFrontCamera", "previewHeight", "getPreviewHeight", "setPreviewHeight", "previewWidth", "getPreviewWidth", "setPreviewWidth", "rotateDegree", "getRotateDegree", "setRotateDegree", "cameraTextureSize", "Landroid/graphics/Point;", "toString", "", "plugin-mediaeditor_release"})
public final class b
{
  private static int aNa;
  private static int aNb;
  private static int gVh;
  private static int gXj;
  private static int gXk;
  private static boolean gXl;
  private static boolean gXm;
  public static final b gXn;
  
  static
  {
    AppMethodBeat.i(94010);
    gXn = new b();
    AppMethodBeat.o(94010);
  }
  
  public static int atq()
  {
    return gVh;
  }
  
  public static int atr()
  {
    return gXj;
  }
  
  public static int ats()
  {
    return gXk;
  }
  
  public static boolean att()
  {
    return gXl;
  }
  
  public static Point atu()
  {
    AppMethodBeat.i(94009);
    Point localPoint = new Point(aNa, aNb);
    AppMethodBeat.o(94009);
    return localPoint;
  }
  
  public static void ef(boolean paramBoolean)
  {
    gXm = paramBoolean;
  }
  
  public static int getPreviewHeight()
  {
    return aNb;
  }
  
  public static int getPreviewWidth()
  {
    return aNa;
  }
  
  public static void nr(int paramInt)
  {
    aNb = paramInt;
  }
  
  public static void ns(int paramInt)
  {
    aNa = paramInt;
  }
  
  public static void nt(int paramInt)
  {
    gVh = paramInt;
  }
  
  public static void nu(int paramInt)
  {
    gXj = paramInt;
  }
  
  public static void nv(int paramInt)
  {
    gXk = paramInt;
  }
  
  public static void setFrontCamera(boolean paramBoolean)
  {
    gXl = paramBoolean;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94008);
    String str = "previewHeight: " + aNb + " ,previewWidth:" + aNa + " ,rotateDegree: " + gVh + " ,isFrontCamera:" + gXl + ' ' + " encodeVideoBestSizeWidth : " + gXj + " , encodeVideoBestSizeHeight : " + gXk + ", isCpuCrop: " + gXm + ' ';
    AppMethodBeat.o(94008);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.b
 * JD-Core Version:    0.7.0.1
 */