package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.model.y;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends y
  implements b
{
  private static f qWz;
  
  private f()
  {
    super(com.tencent.mm.au.a.class);
  }
  
  public static f cER()
  {
    try
    {
      AppMethodBeat.i(104543);
      if (qWz == null) {
        qWz = new f();
      }
      f localf = qWz;
      AppMethodBeat.o(104543);
      return localf;
    }
    finally {}
  }
  
  public static String cES()
  {
    AppMethodBeat.i(104545);
    Object localObject = com.tencent.mm.emoji.e.a.hdT;
    localObject = com.tencent.mm.emoji.e.a.awt();
    AppMethodBeat.o(104545);
    return localObject;
  }
  
  public final List<String> aAo()
  {
    AppMethodBeat.i(104544);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "emoji/" });
    AppMethodBeat.o(104544);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f
 * JD-Core Version:    0.7.0.1
 */