package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/ImeProcessInputType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Down", "Up", "Cancel", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum h
{
  public final String value;
  
  static
  {
    AppMethodBeat.i(311899);
    Jvy = new h("Down", 0, "d");
    Jvz = new h("Up", 1, "u");
    JvA = new h("Cancel", 2, "c");
    JvB = new h[] { Jvy, Jvz, JvA };
    AppMethodBeat.o(311899);
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