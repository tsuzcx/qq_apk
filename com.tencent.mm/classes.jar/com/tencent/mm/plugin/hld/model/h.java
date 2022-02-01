package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/ImeProcessInputType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Down", "Up", "Cancel", "plugin-hld_release"})
public enum h
{
  public final String value;
  
  static
  {
    AppMethodBeat.i(210100);
    h localh1 = new h("Down", 0, "d");
    DCP = localh1;
    h localh2 = new h("Up", 1, "u");
    DCQ = localh2;
    h localh3 = new h("Cancel", 2, "c");
    DCR = localh3;
    DCS = new h[] { localh1, localh2, localh3 };
    AppMethodBeat.o(210100);
  }
  
  private h(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.h
 * JD-Core Version:    0.7.0.1
 */