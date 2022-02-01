package com.tencent.mm.chatroom.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;

public final class b
  extends t
{
  private static b fsY;
  
  public b()
  {
    super(com.tencent.mm.chatroom.b.class);
  }
  
  public static b VS()
  {
    try
    {
      AppMethodBeat.i(12505);
      if (fsY == null) {
        fsY = new b();
      }
      b localb = fsY;
      AppMethodBeat.o(12505);
      return localb;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.b
 * JD-Core Version:    0.7.0.1
 */