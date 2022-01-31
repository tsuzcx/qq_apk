package com.tencent.mm.plugin.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements b, com.tencent.mm.kernel.b.c
{
  private static c nLk;
  
  public static String YK()
  {
    AppMethodBeat.i(79099);
    Object localObject = new StringBuilder();
    g.RM();
    localObject = g.RL().eHR + "image/";
    AppMethodBeat.o(79099);
    return localObject;
  }
  
  public static String YL()
  {
    AppMethodBeat.i(79100);
    Object localObject = new StringBuilder();
    g.RM();
    localObject = g.RL().eHR + "image2/";
    AppMethodBeat.o(79100);
    return localObject;
  }
  
  public static c bIB()
  {
    try
    {
      AppMethodBeat.i(79097);
      if (nLk == null) {
        nLk = new c();
      }
      c localc = nLk;
      AppMethodBeat.o(79097);
      return localc;
    }
    finally {}
  }
  
  public static String bIC()
  {
    AppMethodBeat.i(79101);
    Object localObject = new StringBuilder();
    g.RM();
    localObject = g.RL().eHR + "bizimg/";
    AppMethodBeat.o(79101);
    return localObject;
  }
  
  public final List<String> RR()
  {
    AppMethodBeat.i(79098);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "image/", "image2/", "sfs", "bizimg/" });
    AppMethodBeat.o(79098);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.i.c
 * JD-Core Version:    0.7.0.1
 */