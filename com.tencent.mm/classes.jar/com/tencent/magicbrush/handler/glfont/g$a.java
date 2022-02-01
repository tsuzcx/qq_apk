package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

final class g$a
{
  Queue<k> czb;
  
  g$a()
  {
    AppMethodBeat.i(140019);
    this.czb = new LinkedList();
    AppMethodBeat.o(140019);
  }
  
  final k HK()
  {
    AppMethodBeat.i(140020);
    k localk = (k)this.czb.poll();
    if (localk == null)
    {
      localk = new k();
      AppMethodBeat.o(140020);
      return localk;
    }
    AppMethodBeat.o(140020);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.g.a
 * JD-Core Version:    0.7.0.1
 */