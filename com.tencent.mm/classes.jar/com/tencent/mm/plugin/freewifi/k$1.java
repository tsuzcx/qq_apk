package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class k$1
  extends HashMap<String, String>
{
  k$1()
  {
    AppMethodBeat.i(20605);
    k.b[] arrayOfb = k.b.values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      k.b localb = arrayOfb[i];
      put(localb.name, localb.mJr);
      i += 1;
    }
    AppMethodBeat.o(20605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.k.1
 * JD-Core Version:    0.7.0.1
 */