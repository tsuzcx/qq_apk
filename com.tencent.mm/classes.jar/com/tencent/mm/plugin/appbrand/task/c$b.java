package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum c$b
{
  static
  {
    AppMethodBeat.i(48380);
    lvT = new b("NOT_PRELOAD", 0);
    lvU = new b("PRELOADING", 1);
    lvV = new b("PRELOADED_DOWNGRADE", 2);
    lvW = new b("PRELOADED_FULL", 3);
    lvX = new b[] { lvT, lvU, lvV, lvW };
    AppMethodBeat.o(48380);
  }
  
  private c$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.c.b
 * JD-Core Version:    0.7.0.1
 */