package com.tencent.mm.plugin.fts.ui.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.f;
import com.tencent.mm.plugin.fts.ui.b.k;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public final class g
  extends m
{
  public String Htv;
  public int hAN;
  public String talker;
  
  public g(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112188);
    this.HCE = false;
    paramHashSet = new com.tencent.mm.plugin.fts.a.a.l();
    paramHashSet.query = getQuery();
    paramHashSet.HtB = e.Huh;
    paramHashSet.Htv = this.Htv;
    paramHashSet.Htw = this.Htw;
    paramHashSet.talker = this.talker;
    paramHashSet.HtC = this;
    paramHashSet.handler = paramMMHandler;
    paramHashSet.qRb = 11;
    paramMMHandler = ((n)h.az(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112188);
    return paramMMHandler;
  }
  
  public final a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112190);
    Object localObject2 = null;
    int i;
    Object localObject1;
    if (parama.Huk)
    {
      i = paramInt - parama.Huj - 1;
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (i < parama.tbH.size())
        {
          parama = (o)parama.tbH.get(i);
          if (!parama.Hsz.equals("no_result​")) {
            break label103;
          }
          localObject1 = new com.tencent.mm.plugin.fts.ui.b.l(paramInt);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112190);
      return localObject1;
      i = paramInt - parama.Huj;
      break;
      label103:
      localObject1 = new com.tencent.mm.plugin.fts.ui.b.g(paramInt);
      ((com.tencent.mm.plugin.fts.ui.b.g)localObject1).rpp = parama;
      ((com.tencent.mm.plugin.fts.ui.b.g)localObject1).FWt = ((com.tencent.mm.plugin.fts.ui.b.g)localObject1).rpp.FWt;
      ((com.tencent.mm.plugin.fts.ui.b.g)localObject1).iW(parama.type, parama.subtype);
    }
  }
  
  public final k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112189);
    f localf = new f(paramInt);
    localf.HAD = parama.Hum;
    localf.Htv = this.Htv;
    AppMethodBeat.o(112189);
    return localf;
  }
  
  public final int fzf()
  {
    return this.hAN;
  }
  
  public final int getType()
  {
    return 192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.g
 * JD-Core Version:    0.7.0.1
 */