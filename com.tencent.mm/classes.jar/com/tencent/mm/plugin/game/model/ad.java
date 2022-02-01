package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.protobuf.aj;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.bg;
import com.tencent.mm.plugin.game.protobuf.bi;
import com.tencent.mm.plugin.game.protobuf.bo;
import com.tencent.mm.plugin.game.protobuf.dm;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad
  extends x
{
  public static void a(bo parambo)
  {
    AppMethodBeat.i(41542);
    if ((parambo == null) || (Util.isNullOrNil(parambo.IJV)))
    {
      AppMethodBeat.o(41542);
      return;
    }
    parambo = parambo.IJV.iterator();
    while (parambo.hasNext())
    {
      Object localObject = (aq)parambo.next();
      if ((((aq)localObject).IIK != null) && (((aq)localObject).IIK.IGJ != null))
      {
        d.c(a(((aq)localObject).IIK.IGJ));
      }
      else if ((((aq)localObject).IIM != null) && (!Util.isNullOrNil(((aq)localObject).IIM.IHH)))
      {
        localObject = ((aq)localObject).IIM.IHH.iterator();
        while (((Iterator)localObject).hasNext()) {
          d.c(a(((aj)((Iterator)localObject).next()).IGJ));
        }
      }
      else if ((((aq)localObject).IIL != null) && (((aq)localObject).IIL.IGJ != null))
      {
        d.c(a(((aq)localObject).IIL.IGJ));
      }
    }
    AppMethodBeat.o(41542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ad
 * JD-Core Version:    0.7.0.1
 */