package com.tencent.mm.chatroom.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.b;
import com.tencent.mm.model.q;

public final class a
  extends q
{
  private static a eeM;
  
  public a()
  {
    super(b.class);
  }
  
  public static a Jz()
  {
    try
    {
      AppMethodBeat.i(103960);
      if (eeM == null) {
        eeM = new a();
      }
      a locala = eeM;
      AppMethodBeat.o(103960);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.a
 * JD-Core Version:    0.7.0.1
 */