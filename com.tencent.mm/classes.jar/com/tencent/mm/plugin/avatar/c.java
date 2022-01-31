package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements b
{
  private static c jyt;
  
  private c()
  {
    super(o.class);
  }
  
  public static c aSD()
  {
    try
    {
      AppMethodBeat.i(79053);
      if (jyt == null) {
        jyt = new c();
      }
      c localc = jyt;
      AppMethodBeat.o(79053);
      return localc;
    }
    finally {}
  }
  
  public static String aSE()
  {
    AppMethodBeat.i(79055);
    String str = g.RL().cachePath + "avatar/";
    AppMethodBeat.o(79055);
    return str;
  }
  
  public final List<String> RR()
  {
    AppMethodBeat.i(79054);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "avatar/" });
    AppMethodBeat.o(79054);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.c
 * JD-Core Version:    0.7.0.1
 */