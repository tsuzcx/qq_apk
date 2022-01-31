package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.as;
import com.tencent.mm.plugin.game.d.aw;
import com.tencent.mm.plugin.game.d.bc;
import com.tencent.mm.plugin.game.d.cs;
import com.tencent.mm.plugin.game.d.y;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad
  extends x
{
  public static void a(bc parambc)
  {
    AppMethodBeat.i(111377);
    if ((parambc == null) || (bo.es(parambc.nsC)))
    {
      AppMethodBeat.o(111377);
      return;
    }
    parambc = parambc.nsC.iterator();
    while (parambc.hasNext())
    {
      Object localObject = (com.tencent.mm.plugin.game.d.ad)parambc.next();
      if ((((com.tencent.mm.plugin.game.d.ad)localObject).nrm != null) && (((com.tencent.mm.plugin.game.d.ad)localObject).nrm.npS != null))
      {
        d.c(a(((com.tencent.mm.plugin.game.d.ad)localObject).nrm.npS));
      }
      else if ((((com.tencent.mm.plugin.game.d.ad)localObject).nro != null) && (!bo.es(((com.tencent.mm.plugin.game.d.ad)localObject).nro.nqs)))
      {
        localObject = ((com.tencent.mm.plugin.game.d.ad)localObject).nro.nqs.iterator();
        while (((Iterator)localObject).hasNext()) {
          d.c(a(((y)((Iterator)localObject).next()).npS));
        }
      }
      else if ((((com.tencent.mm.plugin.game.d.ad)localObject).nrn != null) && (((com.tencent.mm.plugin.game.d.ad)localObject).nrn.npS != null))
      {
        d.c(a(((com.tencent.mm.plugin.game.d.ad)localObject).nrn.npS));
      }
    }
    AppMethodBeat.o(111377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ad
 * JD-Core Version:    0.7.0.1
 */