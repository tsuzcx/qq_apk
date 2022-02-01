package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.protobuf.ah;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.be;
import com.tencent.mm.plugin.game.protobuf.bg;
import com.tencent.mm.plugin.game.protobuf.bm;
import com.tencent.mm.plugin.game.protobuf.dh;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad
  extends x
{
  public static void a(bm parambm)
  {
    AppMethodBeat.i(41542);
    if ((parambm == null) || (Util.isNullOrNil(parambm.xLC)))
    {
      AppMethodBeat.o(41542);
      return;
    }
    parambm = parambm.xLC.iterator();
    while (parambm.hasNext())
    {
      Object localObject = (ao)parambm.next();
      if ((((ao)localObject).xKt != null) && (((ao)localObject).xKt.xIz != null))
      {
        d.c(a(((ao)localObject).xKt.xIz));
      }
      else if ((((ao)localObject).xKv != null) && (!Util.isNullOrNil(((ao)localObject).xKv.xJs)))
      {
        localObject = ((ao)localObject).xKv.xJs.iterator();
        while (((Iterator)localObject).hasNext()) {
          d.c(a(((ah)((Iterator)localObject).next()).xIz));
        }
      }
      else if ((((ao)localObject).xKu != null) && (((ao)localObject).xKu.xIz != null))
      {
        d.c(a(((ao)localObject).xKu.xIz));
      }
    }
    AppMethodBeat.o(41542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ad
 * JD-Core Version:    0.7.0.1
 */