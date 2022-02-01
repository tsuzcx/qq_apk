package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/ImeRecommendationType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Geography", "Interest", "plugin-hld_release"})
public enum j
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(209791);
    j localj1 = new j("Geography", 0, 1);
    DCV = localj1;
    j localj2 = new j("Interest", 1, 2);
    DCW = localj2;
    DCX = new j[] { localj1, localj2 };
    AppMethodBeat.o(209791);
  }
  
  private j(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.j
 * JD-Core Version:    0.7.0.1
 */