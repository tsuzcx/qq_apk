package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.aa;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.plugin.game.d.aw;
import com.tencent.mm.plugin.game.d.bc;
import com.tencent.mm.plugin.game.d.cs;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad
  extends x
{
  public static void a(bc parambc)
  {
    AppMethodBeat.i(41542);
    if ((parambc == null) || (bt.gL(parambc.sce)))
    {
      AppMethodBeat.o(41542);
      return;
    }
    parambc = parambc.sce.iterator();
    while (parambc.hasNext())
    {
      Object localObject = (af)parambc.next();
      if ((((af)localObject).saP != null) && (((af)localObject).saP.rZp != null))
      {
        d.c(a(((af)localObject).saP.rZp));
      }
      else if ((((af)localObject).saR != null) && (!bt.gL(((af)localObject).saR.rZV)))
      {
        localObject = ((af)localObject).saR.rZV.iterator();
        while (((Iterator)localObject).hasNext()) {
          d.c(a(((aa)((Iterator)localObject).next()).rZp));
        }
      }
      else if ((((af)localObject).saQ != null) && (((af)localObject).saQ.rZp != null))
      {
        d.c(a(((af)localObject).saQ.rZp));
      }
    }
    AppMethodBeat.o(41542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ad
 * JD-Core Version:    0.7.0.1
 */