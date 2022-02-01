package com.tencent.mm.media.widget.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera/CameraConfig;", "", "()V", "encodeVideoBestSizeHeight", "", "getEncodeVideoBestSizeHeight", "()I", "setEncodeVideoBestSizeHeight", "(I)V", "encodeVideoBestSizeWidth", "getEncodeVideoBestSizeWidth", "setEncodeVideoBestSizeWidth", "isCpuCrop", "", "()Z", "setCpuCrop", "(Z)V", "isFrontCamera", "setFrontCamera", "previewHeight", "getPreviewHeight", "setPreviewHeight", "previewWidth", "getPreviewWidth", "setPreviewWidth", "rotateDegree", "getRotateDegree", "setRotateDegree", "cameraTextureSize", "Landroid/graphics/Point;", "toString", "", "plugin-mediaeditor_release"})
public final class b
{
  private static int ijt;
  private static int imd;
  private static int ime;
  private static boolean imf;
  private static boolean img;
  public static final b imh;
  private static int previewHeight;
  private static int previewWidth;
  
  static
  {
    AppMethodBeat.i(94010);
    imh = new b();
    AppMethodBeat.o(94010);
  }
  
  public static int aPk()
  {
    return ijt;
  }
  
  public static int aPl()
  {
    return imd;
  }
  
  public static int aPm()
  {
    return ime;
  }
  
  public static boolean aPn()
  {
    return imf;
  }
  
  public static Point aPo()
  {
    AppMethodBeat.i(94009);
    Point localPoint = new Point(previewWidth, previewHeight);
    AppMethodBeat.o(94009);
    return localPoint;
  }
  
  public static void eZ(boolean paramBoolean)
  {
    img = paramBoolean;
  }
  
  public static int getPreviewHeight()
  {
    return previewHeight;
  }
  
  public static int getPreviewWidth()
  {
    return previewWidth;
  }
  
  public static void rr(int paramInt)
  {
    previewHeight = paramInt;
  }
  
  public static void rs(int paramInt)
  {
    previewWidth = paramInt;
  }
  
  public static void rt(int paramInt)
  {
    ijt = paramInt;
  }
  
  public static void ru(int paramInt)
  {
    imd = paramInt;
  }
  
  public static void rv(int paramInt)
  {
    ime = paramInt;
  }
  
  public static void setFrontCamera(boolean paramBoolean)
  {
    imf = paramBoolean;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94008);
    String str = "previewHeight: " + previewHeight + " ,previewWidth:" + previewWidth + " ,rotateDegree: " + ijt + " ,isFrontCamera:" + imf + ' ' + " encodeVideoBestSizeWidth : " + imd + " , encodeVideoBestSizeHeight : " + ime + ", isCpuCrop: " + img + ' ';
    AppMethodBeat.o(94008);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.b
 * JD-Core Version:    0.7.0.1
 */