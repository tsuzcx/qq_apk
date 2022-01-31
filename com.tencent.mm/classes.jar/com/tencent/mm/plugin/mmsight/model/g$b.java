package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g$b
{
  public Point oHu;
  public Point oHv;
  public Point oHw;
  public Point oHx;
  public Point oHy;
  public Point oHz;
  
  public final String toString()
  {
    AppMethodBeat.i(76513);
    Object localObject = new StringBuffer();
    if (this.oHu != null) {
      ((StringBuffer)localObject).append(this.oHu.toString() + ",");
    }
    if (this.oHv != null) {
      ((StringBuffer)localObject).append(this.oHv.toString() + ",");
    }
    if (this.oHw != null) {
      ((StringBuffer)localObject).append(this.oHw.toString() + ",");
    }
    if (this.oHx != null) {
      ((StringBuffer)localObject).append(this.oHx.toString() + ",");
    }
    if (this.oHy != null) {
      ((StringBuffer)localObject).append(this.oHy.toString() + ",");
    }
    if (this.oHz != null) {
      ((StringBuffer)localObject).append(this.oHz.toString() + ",");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76513);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.g.b
 * JD-Core Version:    0.7.0.1
 */