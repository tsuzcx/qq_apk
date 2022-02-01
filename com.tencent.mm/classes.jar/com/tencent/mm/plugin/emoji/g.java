package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a;
import com.tencent.mm.emoji.f.c;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.model.y;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends y
  implements b
{
  private static g xFN;
  
  private g()
  {
    super(a.class);
  }
  
  public static g dxR()
  {
    try
    {
      AppMethodBeat.i(104543);
      if (xFN == null) {
        xFN = new g();
      }
      g localg = xFN;
      AppMethodBeat.o(104543);
      return localg;
    }
    finally {}
  }
  
  public static String dxS()
  {
    AppMethodBeat.i(104545);
    Object localObject = c.moq;
    localObject = c.aWA();
    AppMethodBeat.o(104545);
    return localObject;
  }
  
  public final List<String> baM()
  {
    AppMethodBeat.i(104544);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "emoji/" });
    AppMethodBeat.o(104544);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g
 * JD-Core Version:    0.7.0.1
 */