package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends h
{
  protected i(String paramString)
  {
    super(paramString);
  }
  
  public final void dbA()
  {
    AppMethodBeat.i(41408);
    LinkedList localLinkedList = y(optJSONArray("items"));
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      localc.sV(localc.ulD);
    }
    d.aE(localLinkedList);
    AppMethodBeat.o(41408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.i
 * JD-Core Version:    0.7.0.1
 */