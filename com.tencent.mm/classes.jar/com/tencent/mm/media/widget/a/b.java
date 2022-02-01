package com.tencent.mm.media.widget.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camera/CameraConfig;", "", "()V", "encodeVideoBestSizeHeight", "", "getEncodeVideoBestSizeHeight", "()I", "setEncodeVideoBestSizeHeight", "(I)V", "encodeVideoBestSizeWidth", "getEncodeVideoBestSizeWidth", "setEncodeVideoBestSizeWidth", "isCpuCrop", "", "()Z", "setCpuCrop", "(Z)V", "isFrontCamera", "setFrontCamera", "previewHeight", "getPreviewHeight", "setPreviewHeight", "previewWidth", "getPreviewWidth", "setPreviewWidth", "rotateDegree", "getRotateDegree", "setRotateDegree", "cameraTextureSize", "Landroid/graphics/Point;", "toString", "", "plugin-mediaeditor_release"})
public final class b
{
  private static int aMk;
  private static int aMl;
  private static int guD;
  private static int gwM;
  private static int gwN;
  private static boolean gwO;
  private static boolean gwP;
  public static final b gwQ;
  
  static
  {
    AppMethodBeat.i(94010);
    gwQ = new b();
    AppMethodBeat.o(94010);
  }
  
  public static int amA()
  {
    return gwN;
  }
  
  public static boolean amB()
  {
    return gwO;
  }
  
  public static Point amC()
  {
    AppMethodBeat.i(94009);
    Point localPoint = new Point(aMk, aMl);
    AppMethodBeat.o(94009);
    return localPoint;
  }
  
  public static int amy()
  {
    return guD;
  }
  
  public static int amz()
  {
    return gwM;
  }
  
  public static void dK(boolean paramBoolean)
  {
    gwP = paramBoolean;
  }
  
  public static int getPreviewHeight()
  {
    return aMl;
  }
  
  public static int getPreviewWidth()
  {
    return aMk;
  }
  
  public static void mD(int paramInt)
  {
    aMl = paramInt;
  }
  
  public static void mE(int paramInt)
  {
    aMk = paramInt;
  }
  
  public static void mF(int paramInt)
  {
    guD = paramInt;
  }
  
  public static void mG(int paramInt)
  {
    gwM = paramInt;
  }
  
  public static void mH(int paramInt)
  {
    gwN = paramInt;
  }
  
  public static void setFrontCamera(boolean paramBoolean)
  {
    gwO = paramBoolean;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94008);
    String str = "previewHeight: " + aMl + " ,previewWidth:" + aMk + " ,rotateDegree: " + guD + " ,isFrontCamera:" + gwO + ' ' + " encodeVideoBestSizeWidth : " + gwM + " , encodeVideoBestSizeHeight : " + gwN + ", isCpuCrop: " + gwP + ' ';
    AppMethodBeat.o(94008);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.b
 * JD-Core Version:    0.7.0.1
 */