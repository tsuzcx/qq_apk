package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/ImeDataType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "General", "Dicts", "Emoji", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum d
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(311895);
    Juz = new d("General", 0, 0);
    JuA = new d("Dicts", 1, 1);
    JuB = new d("Emoji", 2, 2);
    JuC = new d[] { Juz, JuA, JuB };
    AppMethodBeat.o(311895);
  }
  
  private d(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.d
 * JD-Core Version:    0.7.0.1
 */