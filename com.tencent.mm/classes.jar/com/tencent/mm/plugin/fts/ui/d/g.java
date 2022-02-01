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
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.List;

public final class g
  extends l
{
  public int dlp;
  public String talker;
  public String tvc;
  
  public g(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112188);
    this.tCT = false;
    paramHashSet = new j();
    paramHashSet.query = this.query;
    paramHashSet.tvi = e.tvL;
    paramHashSet.tvc = this.tvc;
    paramHashSet.tvd = this.tvd;
    paramHashSet.talker = this.talker;
    paramHashSet.tvj = this;
    paramHashSet.handler = paramap;
    paramHashSet.jQN = 11;
    paramap = ((n)com.tencent.mm.kernel.g.ad(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112188);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112190);
    Object localObject2 = null;
    int i;
    Object localObject1;
    if (parama.tvO)
    {
      i = paramInt - parama.tvN - 1;
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (i < parama.lKC.size())
        {
          parama = (m)parama.lKC.get(i);
          if (!parama.tuh.equals("no_result​")) {
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
      i = paramInt - parama.tvN;
      break;
      label103:
      localObject1 = new com.tencent.mm.plugin.fts.ui.a.g(paramInt);
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).kjY = parama;
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).tun = ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).kjY.tun;
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).gf(parama.type, parama.tug);
    }
  }
  
  public final k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112189);
    f localf = new f(paramInt);
    localf.tAX = parama.tvR;
    localf.tvc = this.tvc;
    AppMethodBeat.o(112189);
    return localf;
  }
  
  public final int cTS()
  {
    return this.dlp;
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