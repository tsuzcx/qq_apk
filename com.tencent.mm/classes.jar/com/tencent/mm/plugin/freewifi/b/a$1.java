package com.tencent.mm.plugin.freewifi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class a$1
  extends LinkedHashMap<String, a.b>
{
  a$1(a parama) {}
  
  protected final boolean removeEldestEntry(Map.Entry paramEntry)
  {
    AppMethodBeat.i(24738);
    if (size() > 512)
    {
      AppMethodBeat.o(24738);
      return true;
    }
    AppMethodBeat.o(24738);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.a.1
 * JD-Core Version:    0.7.0.1
 */