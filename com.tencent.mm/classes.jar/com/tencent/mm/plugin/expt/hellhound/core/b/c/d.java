package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewEventId;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "toString", "", "INVALIDATE", "TOUCH", "SINGLE_CLICK", "LONG_CLICK", "DOUBLE_CLICK", "ITEM_CLICK", "ITEM_LONG_CLICK", "ITEM_SELECTED", "DRAG", "KEY", "HOVER", "GLIDE", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum d
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(300085);
    zCz = new d("INVALIDATE", 0, -1);
    zCA = new d("TOUCH", 1, 0);
    zCB = new d("SINGLE_CLICK", 2, 1);
    zCC = new d("LONG_CLICK", 3, 2);
    zCD = new d("DOUBLE_CLICK", 4, 3);
    zCE = new d("ITEM_CLICK", 5, 4);
    zCF = new d("ITEM_LONG_CLICK", 6, 5);
    zCG = new d("ITEM_SELECTED", 7, 6);
    zCH = new d("DRAG", 8, 7);
    zCI = new d("KEY", 9, 8);
    zCJ = new d("HOVER", 10, 9);
    zCK = new d("GLIDE", 11, 10);
    zCL = new d[] { zCz, zCA, zCB, zCC, zCD, zCE, zCF, zCG, zCH, zCI, zCJ, zCK };
    AppMethodBeat.o(300085);
  }
  
  private d(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(300088);
    String str = name() + '=' + this.value;
    AppMethodBeat.o(300088);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.d
 * JD-Core Version:    0.7.0.1
 */