package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends g
{
  protected h(String paramString)
  {
    super(paramString);
  }
  
  public final void bGg()
  {
    AppMethodBeat.i(111246);
    LinkedList localLinkedList = u(optJSONArray("items"));
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      localc.iW(localc.nlU);
    }
    d.ag(localLinkedList);
    AppMethodBeat.o(111246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.h
 * JD-Core Version:    0.7.0.1
 */