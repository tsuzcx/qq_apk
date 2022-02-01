package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/model/AcceptEvent;", "", "(Ljava/lang/String;I)V", "Succeed", "Failed", "Denied", "FatalError", "plugin-eggspring_release"})
public enum a
{
  static
  {
    AppMethodBeat.i(194568);
    a locala1 = new a("Succeed", 0);
    qUY = locala1;
    a locala2 = new a("Failed", 1);
    qUZ = locala2;
    a locala3 = new a("Denied", 2);
    qVa = locala3;
    a locala4 = new a("FatalError", 3);
    qVb = locala4;
    qVc = new a[] { locala1, locala2, locala3, locala4 };
    AppMethodBeat.o(194568);
  }
  
  private a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.a
 * JD-Core Version:    0.7.0.1
 */