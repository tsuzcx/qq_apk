package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.openapi.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends h
{
  protected i(String paramString)
  {
    super(paramString);
  }
  
  public final void fGk()
  {
    AppMethodBeat.i(41408);
    LinkedList localLinkedList = C(optJSONArray("items"));
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      localc.AF(localc.ICg);
    }
    d.bz(localLinkedList);
    AppMethodBeat.o(41408);
  }
  
  public final int fGl()
  {
    AppMethodBeat.i(275404);
    int i = optInt("remainingCount");
    AppMethodBeat.o(275404);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.i
 * JD-Core Version:    0.7.0.1
 */