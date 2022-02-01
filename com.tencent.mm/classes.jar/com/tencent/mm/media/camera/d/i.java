package com.tencent.mm.media.camera.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/model/GLSizeParameter;", "", "surfaceSize", "Lcom/tencent/mm/media/camera/model/GLSize;", "cameraSize", "outputSize", "previewRotate", "", "mirror", "", "(Lcom/tencent/mm/media/camera/model/GLSize;Lcom/tencent/mm/media/camera/model/GLSize;Lcom/tencent/mm/media/camera/model/GLSize;IZ)V", "getCameraSize", "()Lcom/tencent/mm/media/camera/model/GLSize;", "setCameraSize", "(Lcom/tencent/mm/media/camera/model/GLSize;)V", "getMirror", "()Z", "setMirror", "(Z)V", "getOutputSize", "setOutputSize", "getPreviewRotate", "()I", "setPreviewRotate", "(I)V", "getSurfaceSize", "setSurfaceSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "updateCameraSize", "", "width", "height", "updateOutputSize", "updateRotate", "rotate", "updateSurfaceSize", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public volatile boolean nvG;
  public volatile h nvL;
  public volatile h nvM;
  public volatile h nvN;
  public volatile int nvO;
  
  private i(h paramh1, h paramh2, h paramh3)
  {
    AppMethodBeat.i(237120);
    this.nvL = paramh1;
    this.nvM = paramh2;
    this.nvN = paramh3;
    this.nvO = 0;
    this.nvG = false;
    AppMethodBeat.o(237120);
  }
  
  public final void bom()
  {
    AppMethodBeat.i(237149);
    if ((this.nvL.boj()) && (this.nvM.boj()))
    {
      if ((this.nvO == 90) || (this.nvO == 270))
      {
        if (1.0F / this.nvM.bok() > this.nvL.bok())
        {
          this.nvN.width = this.nvM.height;
          this.nvN.height = ((int)(this.nvN.width * this.nvL.bok()));
          AppMethodBeat.o(237149);
          return;
        }
        this.nvN.height = this.nvM.width;
        this.nvN.width = ((int)(this.nvN.height / this.nvL.bok()));
        AppMethodBeat.o(237149);
        return;
      }
      if (this.nvM.bok() > this.nvL.bok())
      {
        this.nvN.width = this.nvM.width;
        this.nvN.height = ((int)(this.nvN.width * this.nvL.bok()));
        AppMethodBeat.o(237149);
        return;
      }
      this.nvN.height = this.nvM.height;
      this.nvN.width = ((int)(this.nvN.height / this.nvL.bok()));
    }
    AppMethodBeat.o(237149);
  }
  
  public final boolean eq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237143);
    if ((this.nvL.width != paramInt1) || (this.nvL.height != paramInt2))
    {
      this.nvL.width = paramInt1;
      this.nvL.height = paramInt2;
      bom();
      AppMethodBeat.o(237143);
      return true;
    }
    AppMethodBeat.o(237143);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237174);
    if (this == paramObject)
    {
      AppMethodBeat.o(237174);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(237174);
      return false;
    }
    paramObject = (i)paramObject;
    if (!s.p(this.nvL, paramObject.nvL))
    {
      AppMethodBeat.o(237174);
      return false;
    }
    if (!s.p(this.nvM, paramObject.nvM))
    {
      AppMethodBeat.o(237174);
      return false;
    }
    if (!s.p(this.nvN, paramObject.nvN))
    {
      AppMethodBeat.o(237174);
      return false;
    }
    if (this.nvO != paramObject.nvO)
    {
      AppMethodBeat.o(237174);
      return false;
    }
    if (this.nvG != paramObject.nvG)
    {
      AppMethodBeat.o(237174);
      return false;
    }
    AppMethodBeat.o(237174);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237157);
    String str = "GLSizeParameter(surfaceSize=" + this.nvL + ", cameraSize=" + this.nvM + ", outputSize=" + this.nvN + ", previewRotate=" + this.nvO + ", mirror=" + this.nvG + ')';
    AppMethodBeat.o(237157);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.camera.d.i
 * JD-Core Version:    0.7.0.1
 */