package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.p;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends t
  implements b
{
  private static c nsp;
  
  private c()
  {
    super(p.class);
  }
  
  public static c bGP()
  {
    try
    {
      AppMethodBeat.i(151426);
      if (nsp == null) {
        nsp = new c();
      }
      c localc = nsp;
      AppMethodBeat.o(151426);
      return localc;
    }
    finally {}
  }
  
  public static String bGQ()
  {
    AppMethodBeat.i(151428);
    String str = g.ajC().cachePath + "avatar/";
    AppMethodBeat.o(151428);
    return str;
  }
  
  public final List<String> ajJ()
  {
    AppMethodBeat.i(151427);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "avatar/" });
    AppMethodBeat.o(151427);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.c
 * JD-Core Version:    0.7.0.1
 */