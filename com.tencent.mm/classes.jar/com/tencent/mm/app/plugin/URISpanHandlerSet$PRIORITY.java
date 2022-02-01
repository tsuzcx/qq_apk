package com.tencent.mm.app.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum URISpanHandlerSet$PRIORITY
{
  static
  {
    AppMethodBeat.i(19726);
    LOW = new PRIORITY("LOW", 0);
    NORMAL = new PRIORITY("NORMAL", 1);
    HIGH = new PRIORITY("HIGH", 2);
    $VALUES = new PRIORITY[] { LOW, NORMAL, HIGH };
    AppMethodBeat.o(19726);
  }
  
  private URISpanHandlerSet$PRIORITY() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.PRIORITY
 * JD-Core Version:    0.7.0.1
 */