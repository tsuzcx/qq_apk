package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewEventId;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "toString", "", "INVALIDATE", "TOUCH", "SINGLE_CLICK", "LONG_CLICK", "DOUBLE_CLICK", "ITEM_CLICK", "ITEM_LONG_CLICK", "ITEM_SELECTED", "DRAG", "KEY", "HOVER", "GLIDE", "plugin-expt_release"})
public enum d
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(254349);
    d locald1 = new d("INVALIDATE", 0, -1);
    wgx = locald1;
    d locald2 = new d("TOUCH", 1, 0);
    wgy = locald2;
    d locald3 = new d("SINGLE_CLICK", 2, 1);
    wgz = locald3;
    d locald4 = new d("LONG_CLICK", 3, 2);
    wgA = locald4;
    d locald5 = new d("DOUBLE_CLICK", 4, 3);
    wgB = locald5;
    d locald6 = new d("ITEM_CLICK", 5, 4);
    wgC = locald6;
    d locald7 = new d("ITEM_LONG_CLICK", 6, 5);
    wgD = locald7;
    d locald8 = new d("ITEM_SELECTED", 7, 6);
    wgE = locald8;
    d locald9 = new d("DRAG", 8, 7);
    wgF = locald9;
    d locald10 = new d("KEY", 9, 8);
    wgG = locald10;
    d locald11 = new d("HOVER", 10, 9);
    wgH = locald11;
    d locald12 = new d("GLIDE", 11, 10);
    wgI = locald12;
    wgJ = new d[] { locald1, locald2, locald3, locald4, locald5, locald6, locald7, locald8, locald9, locald10, locald11, locald12 };
    AppMethodBeat.o(254349);
  }
  
  private d(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(254350);
    String str = name() + '=' + this.value;
    AppMethodBeat.o(254350);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.d
 * JD-Core Version:    0.7.0.1
 */