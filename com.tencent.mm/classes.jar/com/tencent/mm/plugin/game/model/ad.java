package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.protobuf.ai;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.bf;
import com.tencent.mm.plugin.game.protobuf.bh;
import com.tencent.mm.plugin.game.protobuf.bn;
import com.tencent.mm.plugin.game.protobuf.di;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad
  extends x
{
  public static void a(bn parambn)
  {
    AppMethodBeat.i(41542);
    if ((parambn == null) || (Util.isNullOrNil(parambn.CPL)))
    {
      AppMethodBeat.o(41542);
      return;
    }
    parambn = parambn.CPL.iterator();
    while (parambn.hasNext())
    {
      Object localObject = (ap)parambn.next();
      if ((((ap)localObject).COA != null) && (((ap)localObject).COA.CME != null))
      {
        d.c(a(((ap)localObject).COA.CME));
      }
      else if ((((ap)localObject).COC != null) && (!Util.isNullOrNil(((ap)localObject).COC.CNz)))
      {
        localObject = ((ap)localObject).COC.CNz.iterator();
        while (((Iterator)localObject).hasNext()) {
          d.c(a(((ai)((Iterator)localObject).next()).CME));
        }
      }
      else if ((((ap)localObject).COB != null) && (((ap)localObject).COB.CME != null))
      {
        d.c(a(((ap)localObject).COB.CME));
      }
    }
    AppMethodBeat.o(41542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ad
 * JD-Core Version:    0.7.0.1
 */