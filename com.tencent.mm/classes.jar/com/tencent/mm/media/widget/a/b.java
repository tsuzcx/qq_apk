package com.tencent.mm.media.widget.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camera/CameraConfig;", "", "()V", "encodeVideoBestSizeHeight", "", "getEncodeVideoBestSizeHeight", "()I", "setEncodeVideoBestSizeHeight", "(I)V", "encodeVideoBestSizeWidth", "getEncodeVideoBestSizeWidth", "setEncodeVideoBestSizeWidth", "isCpuCrop", "", "()Z", "setCpuCrop", "(Z)V", "isFrontCamera", "setFrontCamera", "previewHeight", "getPreviewHeight", "setPreviewHeight", "previewWidth", "getPreviewWidth", "setPreviewWidth", "rotateDegree", "getRotateDegree", "setRotateDegree", "cameraTextureSize", "Landroid/graphics/Point;", "toString", "", "plugin-mediaeditor_release"})
public final class b
{
  private static int aXs;
  private static int aXt;
  private static int hnk;
  private static int hpp;
  private static int hpq;
  private static boolean hpr;
  private static boolean hps;
  public static final b hpt;
  
  static
  {
    AppMethodBeat.i(94010);
    hpt = new b();
    AppMethodBeat.o(94010);
  }
  
  public static int awd()
  {
    return hnk;
  }
  
  public static int awe()
  {
    return hpp;
  }
  
  public static int awf()
  {
    return hpq;
  }
  
  public static boolean awg()
  {
    return hpr;
  }
  
  public static Point awh()
  {
    AppMethodBeat.i(94009);
    Point localPoint = new Point(aXs, aXt);
    AppMethodBeat.o(94009);
    return localPoint;
  }
  
  public static void eh(boolean paramBoolean)
  {
    hps = paramBoolean;
  }
  
  public static int getPreviewHeight()
  {
    return aXt;
  }
  
  public static int getPreviewWidth()
  {
    return aXs;
  }
  
  public static void nQ(int paramInt)
  {
    aXt = paramInt;
  }
  
  public static void nR(int paramInt)
  {
    aXs = paramInt;
  }
  
  public static void nS(int paramInt)
  {
    hnk = paramInt;
  }
  
  public static void nT(int paramInt)
  {
    hpp = paramInt;
  }
  
  public static void nU(int paramInt)
  {
    hpq = paramInt;
  }
  
  public static void setFrontCamera(boolean paramBoolean)
  {
    hpr = paramBoolean;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94008);
    String str = "previewHeight: " + aXt + " ,previewWidth:" + aXs + " ,rotateDegree: " + hnk + " ,isFrontCamera:" + hpr + ' ' + " encodeVideoBestSizeWidth : " + hpp + " , encodeVideoBestSizeHeight : " + hpq + ", isCpuCrop: " + hps + ' ';
    AppMethodBeat.o(94008);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.b
 * JD-Core Version:    0.7.0.1
 */