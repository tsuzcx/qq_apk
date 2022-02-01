package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/ImeCompressionAlgo;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "None", "Zlib", "plugin-hld_release"})
public enum c
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(211989);
    c localc1 = new c("None", 0, 1);
    DBx = localc1;
    c localc2 = new c("Zlib", 1, 2);
    DBy = localc2;
    DBz = new c[] { localc1, localc2 };
    AppMethodBeat.o(211989);
  }
  
  private c(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.c
 * JD-Core Version:    0.7.0.1
 */