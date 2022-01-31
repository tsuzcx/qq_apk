package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

final class f$a
{
  Queue<j> bJW;
  
  f$a()
  {
    AppMethodBeat.i(115918);
    this.bJW = new LinkedList();
    AppMethodBeat.o(115918);
  }
  
  final j yu()
  {
    AppMethodBeat.i(115919);
    j localj = (j)this.bJW.poll();
    if (localj == null)
    {
      localj = new j();
      AppMethodBeat.o(115919);
      return localj;
    }
    AppMethodBeat.o(115919);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.f.a
 * JD-Core Version:    0.7.0.1
 */