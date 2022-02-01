package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ab.a;
import com.tencent.mm.plugin.game.d.d;
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
  
  public final void eyo()
  {
    AppMethodBeat.i(41408);
    LinkedList localLinkedList = z(optJSONArray("items"));
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      localc.Ia(localc.CHW);
    }
    d.bs(localLinkedList);
    AppMethodBeat.o(41408);
  }
  
  public final int eyp()
  {
    AppMethodBeat.i(198447);
    int i = optInt("remainingCount");
    AppMethodBeat.o(198447);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.i
 * JD-Core Version:    0.7.0.1
 */