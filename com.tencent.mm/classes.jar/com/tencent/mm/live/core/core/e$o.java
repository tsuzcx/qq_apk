package com.tencent.mm.live.core.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/LiveCoreConstants$SEIMode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SEIMode_OFF", "SEIMode_GAMEREPORT", "SEIMode_SUBTITLE", "SEIMode_LINKMIC", "SEIMode_OWD", "SEIMode_ANCHOR_INFO", "plugin-core_release"})
public enum e$o
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(198506);
    o localo1 = new o("SEIMode_OFF", 0, 0);
    kkM = localo1;
    o localo2 = new o("SEIMode_GAMEREPORT", 1, 1);
    kkN = localo2;
    o localo3 = new o("SEIMode_SUBTITLE", 2, 2);
    kkO = localo3;
    o localo4 = new o("SEIMode_LINKMIC", 3, 4);
    kkP = localo4;
    o localo5 = new o("SEIMode_OWD", 4, 8);
    kkQ = localo5;
    o localo6 = new o("SEIMode_ANCHOR_INFO", 5, 16);
    kkR = localo6;
    kkS = new o[] { localo1, localo2, localo3, localo4, localo5, localo6 };
    AppMethodBeat.o(198506);
  }
  
  private e$o(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.e.o
 * JD-Core Version:    0.7.0.1
 */