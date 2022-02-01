package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewEventId;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "toString", "", "INVALIDATE", "TOUCH", "SINGLE_CLICK", "LONG_CLICK", "DOUBLE_CLICK", "ITEM_CLICK", "ITEM_LONG_CLICK", "ITEM_SELECTED", "DRAG", "KEY", "HOVER", "GLIDE", "plugin-expt_release"})
public enum d
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(210644);
    d locald1 = new d("INVALIDATE", 0, -1);
    qSo = locald1;
    d locald2 = new d("TOUCH", 1, 0);
    qSp = locald2;
    d locald3 = new d("SINGLE_CLICK", 2, 1);
    qSq = locald3;
    d locald4 = new d("LONG_CLICK", 3, 2);
    qSr = locald4;
    d locald5 = new d("DOUBLE_CLICK", 4, 3);
    qSs = locald5;
    d locald6 = new d("ITEM_CLICK", 5, 4);
    qSt = locald6;
    d locald7 = new d("ITEM_LONG_CLICK", 6, 5);
    qSu = locald7;
    d locald8 = new d("ITEM_SELECTED", 7, 6);
    qSv = locald8;
    d locald9 = new d("DRAG", 8, 7);
    qSw = locald9;
    d locald10 = new d("KEY", 9, 8);
    qSx = locald10;
    d locald11 = new d("HOVER", 10, 9);
    qSy = locald11;
    d locald12 = new d("GLIDE", 11, 10);
    qSz = locald12;
    qSA = new d[] { locald1, locald2, locald3, locald4, locald5, locald6, locald7, locald8, locald9, locald10, locald11, locald12 };
    AppMethodBeat.o(210644);
  }
  
  private d(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210645);
    String str = name() + '=' + this.value;
    AppMethodBeat.o(210645);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.d
 * JD-Core Version:    0.7.0.1
 */