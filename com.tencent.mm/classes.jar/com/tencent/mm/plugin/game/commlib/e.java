package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private static LinkedList<String> niY;
  private static final String niZ;
  private static final String nja;
  
  static
  {
    AppMethodBeat.i(116988);
    niY = new LinkedList();
    niZ = ah.getPackageName();
    nja = ah.getPackageName() + ":tools";
    niY.add(nja);
    AppMethodBeat.o(116988);
  }
  
  public static void PO(String paramString)
  {
    AppMethodBeat.i(116986);
    if ((paramString.equals(niZ)) || (niY.contains(paramString))) {
      a.bEY();
    }
    AppMethodBeat.o(116986);
  }
  
  public static void bFk()
  {
    AppMethodBeat.i(116987);
    Iterator localIterator = niY.iterator();
    while (localIterator.hasNext()) {
      f.a((String)localIterator.next(), null, e.a.class, null);
    }
    AppMethodBeat.o(116987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e
 * JD-Core Version:    0.7.0.1
 */