package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.f;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public final class g
  extends l
{
  public String BIN;
  public int fwp;
  public String talker;
  
  public g(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112188);
    this.BQU = false;
    paramHashSet = new j();
    paramHashSet.query = getQuery();
    paramHashSet.BIT = e.BJx;
    paramHashSet.BIN = this.BIN;
    paramHashSet.BIO = this.BIO;
    paramHashSet.talker = this.talker;
    paramHashSet.BIU = this;
    paramHashSet.handler = paramMMHandler;
    paramHashSet.nRn = 11;
    paramMMHandler = ((n)h.ag(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112188);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112190);
    Object localObject2 = null;
    int i;
    Object localObject1;
    if (parama.BJA)
    {
      i = paramInt - parama.BJz - 1;
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (i < parama.pWR.size())
        {
          parama = (m)parama.pWR.get(i);
          if (!parama.BHS.equals("no_result​")) {
            break label103;
          }
          localObject1 = new com.tencent.mm.plugin.fts.ui.a.l(paramInt);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112190);
      return localObject1;
      i = paramInt - parama.BJz;
      break;
      label103:
      localObject1 = new com.tencent.mm.plugin.fts.ui.a.g(paramInt);
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).olG = parama;
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).BHY = ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).olG.BHY;
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).hx(parama.type, parama.BHR);
    }
  }
  
  public final k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112189);
    f localf = new f(paramInt);
    localf.BON = parama.BJD;
    localf.BIN = this.BIN;
    AppMethodBeat.o(112189);
    return localf;
  }
  
  public final int esh()
  {
    return this.fwp;
  }
  
  public final int getType()
  {
    return 192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.g
 * JD-Core Version:    0.7.0.1
 */