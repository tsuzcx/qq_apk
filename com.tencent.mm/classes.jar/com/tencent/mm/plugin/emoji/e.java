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
  private static e osY;
  
  private e()
  {
    super(com.tencent.mm.av.a.class);
  }
  
  public static e bTX()
  {
    try
    {
      AppMethodBeat.i(104543);
      if (osY == null) {
        osY = new e();
      }
      e locale = osY;
      AppMethodBeat.o(104543);
      return locale;
    }
    finally {}
  }
  
  public static String bTY()
  {
    AppMethodBeat.i(104545);
    Object localObject = com.tencent.mm.emoji.d.a.fSR;
    localObject = com.tencent.mm.emoji.d.a.acD();
    AppMethodBeat.o(104545);
    return localObject;
  }
  
  public final List<String> afI()
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