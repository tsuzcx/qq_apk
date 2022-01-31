package com.tencent.mm.plugin.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.r;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends q
  implements b
{
  private static a kVe;
  
  private a()
  {
    super(r.class);
  }
  
  public static String YR()
  {
    AppMethodBeat.i(79091);
    Object localObject = new StringBuilder();
    g.RM();
    localObject = g.RL().eHR + "package/";
    AppMethodBeat.o(79091);
    return localObject;
  }
  
  public static a bjc()
  {
    try
    {
      AppMethodBeat.i(79089);
      if (kVe == null) {
        kVe = new a();
      }
      a locala = kVe;
      AppMethodBeat.o(79089);
      return locala;
    }
    finally {}
  }
  
  public final List<String> RR()
  {
    AppMethodBeat.i(79090);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "package/" });
    AppMethodBeat.o(79090);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.h.a
 * JD-Core Version:    0.7.0.1
 */