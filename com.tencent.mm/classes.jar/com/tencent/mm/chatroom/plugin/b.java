package com.tencent.mm.chatroom.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;

public final class b
  extends y
{
  private static b iWZ;
  
  public b()
  {
    super(com.tencent.mm.chatroom.b.class);
  }
  
  public static b ash()
  {
    try
    {
      AppMethodBeat.i(12505);
      if (iWZ == null) {
        iWZ = new b();
      }
      b localb = iWZ;
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