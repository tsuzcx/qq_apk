package com.tencent.mm.media.camera.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/model/CameraKitInfo;", "", "deviceInfo", "Lcom/tencent/mm/media/camera/model/CameraDeviceInfo;", "sizeParameter", "Lcom/tencent/mm/media/camera/model/GLSizeParameter;", "isBackCamera", "", "cameraId", "", "rotate", "isPreviewing", "frameRate", "(Lcom/tencent/mm/media/camera/model/CameraDeviceInfo;Lcom/tencent/mm/media/camera/model/GLSizeParameter;ZIIZI)V", "getCameraId", "()I", "setCameraId", "(I)V", "getDeviceInfo", "()Lcom/tencent/mm/media/camera/model/CameraDeviceInfo;", "setDeviceInfo", "(Lcom/tencent/mm/media/camera/model/CameraDeviceInfo;)V", "getFrameRate", "setFrameRate", "()Z", "setBackCamera", "(Z)V", "setPreviewing", "getRotate", "setRotate", "getSizeParameter", "()Lcom/tencent/mm/media/camera/model/GLSizeParameter;", "setSizeParameter", "(Lcom/tencent/mm/media/camera/model/GLSizeParameter;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public int cameraId;
  public int frameRate;
  public int hYK;
  public i ntB;
  public boolean nvA;
  public boolean nvB;
  public a nvz;
  
  private c(a parama, i parami)
  {
    AppMethodBeat.i(237101);
    this.nvz = parama;
    this.ntB = parami;
    this.nvA = true;
    this.cameraId = -1;
    this.hYK = 0;
    this.nvB = false;
    this.frameRate = 0;
    AppMethodBeat.o(237101);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237125);
    if (this == paramObject)
    {
      AppMethodBeat.o(237125);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(237125);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.nvz, paramObject.nvz))
    {
      AppMethodBeat.o(237125);
      return false;
    }
    if (!s.p(this.ntB, paramObject.ntB))
    {
      AppMethodBeat.o(237125);
      return false;
    }
    if (this.nvA != paramObject.nvA)
    {
      AppMethodBeat.o(237125);
      return false;
    }
    if (this.cameraId != paramObject.cameraId)
    {
      AppMethodBeat.o(237125);
      return false;
    }
    if (this.hYK != paramObject.hYK)
    {
      AppMethodBeat.o(237125);
      return false;
    }
    if (this.nvB != paramObject.nvB)
    {
      AppMethodBeat.o(237125);
      return false;
    }
    if (this.frameRate != paramObject.frameRate)
    {
      AppMethodBeat.o(237125);
      return false;
    }
    AppMethodBeat.o(237125);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237110);
    String str = "CameraKitInfo(deviceInfo=" + this.nvz + ", sizeParameter=" + this.ntB + ", isBackCamera=" + this.nvA + ", cameraId=" + this.cameraId + ", rotate=" + this.hYK + ", isPreviewing=" + this.nvB + ", frameRate=" + this.frameRate + ')';
    AppMethodBeat.o(237110);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.camera.d.c
 * JD-Core Version:    0.7.0.1
 */