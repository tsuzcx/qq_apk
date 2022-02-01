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
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashSet;
import java.util.List;

public final class g
  extends l
{
  public int cZX;
  public String syB;
  public String talker;
  
  public g(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112188);
    this.sFZ = false;
    paramHashSet = new j();
    paramHashSet.query = this.query;
    paramHashSet.syH = e.szk;
    paramHashSet.syB = this.syB;
    paramHashSet.syC = this.syC;
    paramHashSet.talker = this.talker;
    paramHashSet.syI = this;
    paramHashSet.handler = paramao;
    paramHashSet.jwR = 11;
    paramao = ((n)com.tencent.mm.kernel.g.ad(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112188);
    return paramao;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112190);
    Object localObject2 = null;
    int i;
    Object localObject1;
    if (parama.szn)
    {
      i = paramInt - parama.szm - 1;
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (i < parama.lnk.size())
        {
          parama = (m)parama.lnk.get(i);
          if (!parama.sxG.equals("no_result​")) {
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
      i = paramInt - parama.szm;
      break;
      label103:
      localObject1 = new com.tencent.mm.plugin.fts.ui.a.g(paramInt);
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).jPN = parama;
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).sxM = ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).jPN.sxM;
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).fP(parama.type, parama.sxF);
    }
  }
  
  public final k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112189);
    f localf = new f(paramInt);
    localf.sEg = parama.szq;
    localf.syB = this.syB;
    AppMethodBeat.o(112189);
    return localf;
  }
  
  public final int cLz()
  {
    return this.cZX;
  }
  
  public final int getType()
  {
    return 192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.g
 * JD-Core Version:    0.7.0.1
 */