package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.model.y;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends y
  implements b
{
  private static h uzn;
  
  private h()
  {
    super(com.tencent.mm.ax.a.class);
  }
  
  public static h cTw()
  {
    try
    {
      AppMethodBeat.i(104543);
      if (uzn == null) {
        uzn = new h();
      }
      h localh = uzn;
      AppMethodBeat.o(104543);
      return localh;
    }
    finally {}
  }
  
  public static String cTx()
  {
    AppMethodBeat.i(104545);
    Object localObject = com.tencent.mm.emoji.e.a.jPz;
    localObject = com.tencent.mm.emoji.e.a.aDB();
    AppMethodBeat.o(104545);
    return localObject;
  }
  
  public final List<String> aHP()
  {
    AppMethodBeat.i(104544);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "emoji/" });
    AppMethodBeat.o(104544);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h
 * JD-Core Version:    0.7.0.1
 */