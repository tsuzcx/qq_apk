package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/model/AcceptEvent;", "", "(Ljava/lang/String;I)V", "Succeed", "Failed", "Denied", "FatalError", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a
{
  static
  {
    AppMethodBeat.i(266511);
    xEw = new a("Succeed", 0);
    xEx = new a("Failed", 1);
    xEy = new a("Denied", 2);
    xEz = new a("FatalError", 3);
    xEA = new a[] { xEw, xEx, xEy, xEz };
    AppMethodBeat.o(266511);
  }
  
  private a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.a
 * JD-Core Version:    0.7.0.1
 */