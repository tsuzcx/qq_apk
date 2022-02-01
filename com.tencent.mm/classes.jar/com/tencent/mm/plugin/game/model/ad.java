package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.d.bm;
import com.tencent.mm.plugin.game.d.dh;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad
  extends x
{
  public static void a(bm parambm)
  {
    AppMethodBeat.i(41542);
    if ((parambm == null) || (bu.ht(parambm.utA)))
    {
      AppMethodBeat.o(41542);
      return;
    }
    parambm = parambm.utA.iterator();
    while (parambm.hasNext())
    {
      Object localObject = (an)parambm.next();
      if ((((an)localObject).usb != null) && (((an)localObject).usb.uqg != null))
      {
        d.c(a(((an)localObject).usb.uqg));
      }
      else if ((((an)localObject).usd != null) && (!bu.ht(((an)localObject).usd.uqZ)))
      {
        localObject = ((an)localObject).usd.uqZ.iterator();
        while (((Iterator)localObject).hasNext()) {
          d.c(a(((ag)((Iterator)localObject).next()).uqg));
        }
      }
      else if ((((an)localObject).usc != null) && (((an)localObject).usc.uqg != null))
      {
        d.c(a(((an)localObject).usc.uqg));
      }
    }
    AppMethodBeat.o(41542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ad
 * JD-Core Version:    0.7.0.1
 */