package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.model.u;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends u
  implements b
{
  private static e pGN;
  
  private e()
  {
    super(com.tencent.mm.au.a.class);
  }
  
  public static e chf()
  {
    try
    {
      AppMethodBeat.i(104543);
      if (pGN == null) {
        pGN = new e();
      }
      e locale = pGN;
      AppMethodBeat.o(104543);
      return locale;
    }
    finally {}
  }
  
  public static String chg()
  {
    AppMethodBeat.i(104545);
    Object localObject = com.tencent.mm.emoji.d.a.gsI;
    localObject = com.tencent.mm.emoji.d.a.agD();
    AppMethodBeat.o(104545);
    return localObject;
  }
  
  public final List<String> ajY()
  {
    AppMethodBeat.i(104544);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "emoji/" });
    AppMethodBeat.o(104544);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e
 * JD-Core Version:    0.7.0.1
 */