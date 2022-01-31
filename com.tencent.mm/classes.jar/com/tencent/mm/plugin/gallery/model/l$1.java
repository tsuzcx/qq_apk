package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.LinkedList;

final class l$1
  implements Runnable
{
  l$1(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(21318);
    LinkedList localLinkedList = this.ndA.ndy.bDJ();
    l locall = this.ndA;
    i.a[] arrayOfa = new i.a[locall.ndv.size()];
    locall.ndv.toArray(arrayOfa);
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      arrayOfa[i].V(localLinkedList);
      i += 1;
    }
    AppMethodBeat.o(21318);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(21319);
    String str = super.toString() + "|queryAlbums";
    AppMethodBeat.o(21319);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.l.1
 * JD-Core Version:    0.7.0.1
 */