package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/ImeRequiredType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Required", "Optional", "Common", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum l
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(311903);
    JvM = new l("Required", 0, 1);
    JvN = new l("Optional", 1, 2);
    JvO = new l("Common", 2, 3);
    JvP = new l[] { JvM, JvN, JvO };
    AppMethodBeat.o(311903);
  }
  
  private l(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.l
 * JD-Core Version:    0.7.0.1
 */