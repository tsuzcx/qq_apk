package com.tencent.mm.plugin.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.model.t
  implements b
{
  private static a oFl;
  
  private a()
  {
    super(com.tencent.mm.bb.t.class);
  }
  
  public static String awS()
  {
    AppMethodBeat.i(151486);
    Object localObject = new StringBuilder();
    g.agS();
    localObject = g.agR().ghC + "package/";
    AppMethodBeat.o(151486);
    return localObject;
  }
  
  public static a bXx()
  {
    try
    {
      AppMethodBeat.i(151484);
      if (oFl == null) {
        oFl = new a();
      }
      a locala = oFl;
      AppMethodBeat.o(151484);
      return locala;
    }
    finally {}
  }
  
  public final List<String> agY()
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