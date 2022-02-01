package com.tencent.mm.media.widget.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera/CameraConfig;", "", "()V", "encodeVideoBestSizeHeight", "", "getEncodeVideoBestSizeHeight", "()I", "setEncodeVideoBestSizeHeight", "(I)V", "encodeVideoBestSizeWidth", "getEncodeVideoBestSizeWidth", "setEncodeVideoBestSizeWidth", "isCpuCrop", "", "()Z", "setCpuCrop", "(Z)V", "isFrontCamera", "setFrontCamera", "previewHeight", "getPreviewHeight", "setPreviewHeight", "previewWidth", "getPreviewWidth", "setPreviewWidth", "rotateDegree", "getRotateDegree", "setRotateDegree", "cameraTextureSize", "Landroid/graphics/Point;", "toString", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static boolean isFrontCamera;
  private static int nDr;
  public static final b nGj;
  private static int nGk;
  private static int nGl;
  private static boolean nGm;
  private static int previewHeight;
  private static int previewWidth;
  
  static
  {
    AppMethodBeat.i(94010);
    nGj = new b();
    AppMethodBeat.o(94010);
  }
  
  public static int bsL()
  {
    return nDr;
  }
  
  public static int bsM()
  {
    return nGk;
  }
  
  public static int bsN()
  {
    return nGl;
  }
  
  public static boolean bsO()
  {
    return nGm;
  }
  
  public static Point bsP()
  {
    AppMethodBeat.i(94009);
    Point localPoint = new Point(previewWidth, previewHeight);
    AppMethodBeat.o(94009);
    return localPoint;
  }
  
  public static int getPreviewHeight()
  {
    return previewHeight;
  }
  
  public static int getPreviewWidth()
  {
    return previewWidth;
  }
  
  public static void gw(boolean paramBoolean)
  {
    nGm = paramBoolean;
  }
  
  public static boolean isFrontCamera()
  {
    return isFrontCamera;
  }
  
  public static void setFrontCamera(boolean paramBoolean)
  {
    isFrontCamera = paramBoolean;
  }
  
  public static void uj(int paramInt)
  {
    previewHeight = paramInt;
  }
  
  public static void uk(int paramInt)
  {
    previewWidth = paramInt;
  }
  
  public static void ul(int paramInt)
  {
    nDr = paramInt;
  }
  
  public static void um(int paramInt)
  {
    nGk = paramInt;
  }
  
  public static void un(int paramInt)
  {
    nGl = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94008);
    String str = "previewHeight: " + previewHeight + " ,previewWidth:" + previewWidth + " ,rotateDegree: " + nDr + " ,isFrontCamera:" + isFrontCamera + "  encodeVideoBestSizeWidth : " + nGk + " , encodeVideoBestSizeHeight : " + nGl + ", isCpuCrop: " + nGm + ' ';
    AppMethodBeat.o(94008);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.b
 * JD-Core Version:    0.7.0.1
 */