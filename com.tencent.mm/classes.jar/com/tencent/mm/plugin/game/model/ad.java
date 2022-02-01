package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ab;
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.ax;
import com.tencent.mm.plugin.game.d.az;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.d.cz;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad
  extends x
{
  public static void a(bf parambf)
  {
    AppMethodBeat.i(41542);
    if ((parambf == null) || (bt.hj(parambf.uia)))
    {
      AppMethodBeat.o(41542);
      return;
    }
    parambf = parambf.uia.iterator();
    while (parambf.hasNext())
    {
      Object localObject = (ah)parambf.next();
      if ((((ah)localObject).ugE != null) && (((ah)localObject).ugE.ueZ != null))
      {
        d.c(a(((ah)localObject).ugE.ueZ));
      }
      else if ((((ah)localObject).ugG != null) && (!bt.hj(((ah)localObject).ugG.ufF)))
      {
        localObject = ((ah)localObject).ugG.ufF.iterator();
        while (((Iterator)localObject).hasNext()) {
          d.c(a(((ab)((Iterator)localObject).next()).ueZ));
        }
      }
      else if ((((ah)localObject).ugF != null) && (((ah)localObject).ugF.ueZ != null))
      {
        d.c(a(((ah)localObject).ugF.ueZ));
      }
    }
    AppMethodBeat.o(41542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ad
 * JD-Core Version:    0.7.0.1
 */