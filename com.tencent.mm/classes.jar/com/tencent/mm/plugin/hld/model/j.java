package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/ImeRecommendationType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Geography", "Interest", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum j
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(311889);
    JvE = new j("Geography", 0, 1);
    JvF = new j("Interest", 1, 2);
    JvG = new j[] { JvE, JvF };
    AppMethodBeat.o(311889);
  }
  
  private j(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.j
 * JD-Core Version:    0.7.0.1
 */