package com.tencent.mm.chatroom.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;

public final class b
  extends t
{
  private static b fpx;
  
  public b()
  {
    super(com.tencent.mm.chatroom.b.class);
  }
  
  public static b UW()
  {
    try
    {
      AppMethodBeat.i(12505);
      if (fpx == null) {
        fpx = new b();
      }
      b localb = fpx;
      AppMethodBeat.o(12505);
      return localb;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.b
 * JD-Core Version:    0.7.0.1
 */