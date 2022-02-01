package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.model.t;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends t
  implements b
{
  private static e oWz;
  
  private e()
  {
    super(com.tencent.mm.au.a.class);
  }
  
  public static e cbl()
  {
    try
    {
      AppMethodBeat.i(104543);
      if (oWz == null) {
        oWz = new e();
      }
      e locale = oWz;
      AppMethodBeat.o(104543);
      return locale;
    }
    finally {}
  }
  
  public static String cbm()
  {
    AppMethodBeat.i(104545);
    Object localObject = com.tencent.mm.emoji.d.a.fWM;
    localObject = com.tencent.mm.emoji.d.a.adJ();
    AppMethodBeat.o(104545);
    return localObject;
  }
  
  public final List<String> agY()
  {
    AppMethodBeat.i(104544);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "emoji/" });
    AppMethodBeat.o(104544);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e
 * JD-Core Version:    0.7.0.1
 */