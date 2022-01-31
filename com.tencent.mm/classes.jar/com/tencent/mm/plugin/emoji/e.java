package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.a;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends q
  implements b
{
  private static e ldp;
  
  private e()
  {
    super(a.class);
  }
  
  public static e bki()
  {
    try
    {
      AppMethodBeat.i(62315);
      if (ldp == null) {
        ldp = new e();
      }
      e locale = ldp;
      AppMethodBeat.o(62315);
      return locale;
    }
    finally {}
  }
  
  public static String bkj()
  {
    AppMethodBeat.i(62317);
    String str = g.RL().eHR + "emoji/";
    AppMethodBeat.o(62317);
    return str;
  }
  
  public final List<String> RR()
  {
    AppMethodBeat.i(62316);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "emoji/" });
    AppMethodBeat.o(62316);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e
 * JD-Core Version:    0.7.0.1
 */