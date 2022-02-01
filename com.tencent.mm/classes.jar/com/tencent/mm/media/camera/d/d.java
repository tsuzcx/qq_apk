package com.tencent.mm.media.camera.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/model/CameraKitPictureSetting;", "", "alignLongSide", "", "alignShortSide", "forceWidth", "forceHeight", "(IIII)V", "getAlignLongSide", "()I", "setAlignLongSide", "(I)V", "getAlignShortSide", "setAlignShortSide", "getForceHeight", "setForceHeight", "getForceWidth", "setForceWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private int nvC = -1;
  private int nvD = -1;
  private int nvE = -1;
  private int nvF = -1;
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
      if (this.nvC != paramObject.nvC) {
        return false;
      }
      if (this.nvD != paramObject.nvD) {
        return false;
      }
      if (this.nvE != paramObject.nvE) {
        return false;
      }
    } while (this.nvF == paramObject.nvF);
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.nvC * 31 + this.nvD) * 31 + this.nvE) * 31 + this.nvF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237119);
    String str = "CameraKitPictureSetting(alignLongSide=" + this.nvC + ", alignShortSide=" + this.nvD + ", forceWidth=" + this.nvE + ", forceHeight=" + this.nvF + ')';
    AppMethodBeat.o(237119);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.camera.d.d
 * JD-Core Version:    0.7.0.1
 */