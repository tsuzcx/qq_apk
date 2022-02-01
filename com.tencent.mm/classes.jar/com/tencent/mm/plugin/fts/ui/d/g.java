package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public int dDG;
  public String talker;
  public String wWS;
  
  public g(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112188);
    this.xeL = false;
    paramHashSet = new j();
    paramHashSet.query = this.query;
    paramHashSet.wWY = e.wXB;
    paramHashSet.wWS = this.wWS;
    paramHashSet.wWT = this.wWT;
    paramHashSet.talker = this.talker;
    paramHashSet.wWZ = this;
    paramHashSet.handler = paramMMHandler;
    paramHashSet.kXb = 11;
    paramMMHandler = ((n)com.tencent.mm.kernel.g.ah(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112188);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112190);
    Object localObject2 = null;
    int i;
    Object localObject1;
    if (parama.wXE)
    {
      i = paramInt - parama.wXD - 1;
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (i < parama.mWl.size())
        {
          parama = (m)parama.mWl.get(i);
          if (!parama.wVX.equals("no_result​")) {
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
      i = paramInt - parama.wXD;
      break;
      label103:
      localObject1 = new com.tencent.mm.plugin.fts.ui.a.g(paramInt);
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).lqW = parama;
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).wWd = ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).lqW.wWd;
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).gE(parama.type, parama.wVW);
    }
  }
  
  public final k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112189);
    f localf = new f(paramInt);
    localf.xcP = parama.wXH;
    localf.wWS = this.wWS;
    AppMethodBeat.o(112189);
    return localf;
  }
  
  public final int dPI()
  {
    return this.dDG;
  }
  
  public final int getType()
  {
    return 192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.g
 * JD-Core Version:    0.7.0.1
 */