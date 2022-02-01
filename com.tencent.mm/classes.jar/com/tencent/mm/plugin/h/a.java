package com.tencent.mm.plugin.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.t;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends u
  implements b
{
  private static a ppu;
  
  private a()
  {
    super(t.class);
  }
  
  public static String azX()
  {
    AppMethodBeat.i(151486);
    Object localObject = new StringBuilder();
    g.ajS();
    localObject = g.ajR().gDT + "package/";
    AppMethodBeat.o(151486);
    return localObject;
  }
  
  public static a cdp()
  {
    try
    {
      AppMethodBeat.i(151484);
      if (ppu == null) {
        ppu = new a();
      }
      a locala = ppu;
      AppMethodBeat.o(151484);
      return locala;
    }
    finally {}
  }
  
  public final List<String> ajY()
  {
    AppMethodBeat.i(151485);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "package/" });
    AppMethodBeat.o(151485);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.h.a
 * JD-Core Version:    0.7.0.1
 */