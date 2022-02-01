package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.aa;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.plugin.game.d.aw;
import com.tencent.mm.plugin.game.d.bc;
import com.tencent.mm.plugin.game.d.cs;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad
  extends x
{
  public static void a(bc parambc)
  {
    AppMethodBeat.i(41542);
    if ((parambc == null) || (bs.gY(parambc.tjY)))
    {
      AppMethodBeat.o(41542);
      return;
    }
    parambc = parambc.tjY.iterator();
    while (parambc.hasNext())
    {
      Object localObject = (af)parambc.next();
      if ((((af)localObject).tiJ != null) && (((af)localObject).tiJ.thi != null))
      {
        d.c(a(((af)localObject).tiJ.thi));
      }
      else if ((((af)localObject).tiL != null) && (!bs.gY(((af)localObject).tiL.thO)))
      {
        localObject = ((af)localObject).tiL.thO.iterator();
        while (((Iterator)localObject).hasNext()) {
          d.c(a(((aa)((Iterator)localObject).next()).thi));
        }
      }
      else if ((((af)localObject).tiK != null) && (((af)localObject).tiK.thi != null))
      {
        d.c(a(((af)localObject).tiK.thi));
      }
    }
    AppMethodBeat.o(41542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ad
 * JD-Core Version:    0.7.0.1
 */