package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h<E extends e>
  extends LinkedList<E>
{
  public final int a(E paramE)
  {
    AppMethodBeat.i(136144);
    int i = 0;
    if (i < size())
    {
      e locale = (e)get(i);
      if (paramE.bjP() >= locale.bjP()) {}
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        i = size();
      }
      add(i, paramE);
      AppMethodBeat.o(136144);
      return i;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public final int ub(int paramInt)
  {
    AppMethodBeat.i(136145);
    int i = 0;
    int k;
    for (int j = 0; i < size(); j = k)
    {
      k = j;
      if (((e)get(i)).bjP() == paramInt) {
        k = j + 1;
      }
      i += 1;
    }
    AppMethodBeat.o(136145);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.h
 * JD-Core Version:    0.7.0.1
 */