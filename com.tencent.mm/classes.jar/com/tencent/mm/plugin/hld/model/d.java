package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/ImeDataType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "General", "Dicts", "Emoji", "plugin-hld_release"})
public enum d
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(210922);
    d locald1 = new d("General", 0, 0);
    DBA = locald1;
    d locald2 = new d("Dicts", 1, 1);
    DBB = locald2;
    d locald3 = new d("Emoji", 2, 2);
    DBC = locald3;
    DBD = new d[] { locald1, locald2, locald3 };
    AppMethodBeat.o(210922);
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