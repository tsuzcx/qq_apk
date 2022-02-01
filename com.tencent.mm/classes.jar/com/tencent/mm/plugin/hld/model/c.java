package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/ImeCompressionAlgo;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "None", "Zlib", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum c
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(311878);
    Juw = new c("None", 0, 1);
    Jux = new c("Zlib", 1, 2);
    Juy = new c[] { Juw, Jux };
    AppMethodBeat.o(311878);
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