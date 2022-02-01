package com.tencent.mm.mj_template.maas.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/record/VideoFrameInfo;", "", "width", "", "height", "rowStride", "pixelStride", "(IIII)V", "getHeight", "()I", "setHeight", "(I)V", "getPixelStride", "setPixelStride", "getRowStride", "setRowStride", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final int Ue = 8;
  int height = 0;
  int pixelStride = 0;
  int rowStride = 0;
  int width = 0;
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof g)) {
        return false;
      }
      paramObject = (g)paramObject;
      if (this.width != paramObject.width) {
        return false;
      }
      if (this.height != paramObject.height) {
        return false;
      }
      if (this.rowStride != paramObject.rowStride) {
        return false;
      }
    } while (this.pixelStride == paramObject.pixelStride);
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.width * 31 + this.height) * 31 + this.rowStride) * 31 + this.pixelStride;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(240035);
    String str = "VideoFrameInfo(width=" + this.width + ", height=" + this.height + ", rowStride=" + this.rowStride + ", pixelStride=" + this.pixelStride + ')';
    AppMethodBeat.o(240035);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.a.g
 * JD-Core Version:    0.7.0.1
 */