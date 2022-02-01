package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashSet;
import java.util.List;

public final class c
  extends com.tencent.mm.plugin.fts.ui.a
{
  public c(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(5825);
    paramHashSet.add("gh_3dfda90e39d6");
    paramHashSet.add("gh_43f2581f6fd6");
    paramHashSet.add("gh_f0a92aa7146c");
    String str = this.query;
    b localb = b.szh;
    paramao = j.a(str, new int[] { 131076 }, null, -1, paramHashSet, localb, this, paramao);
    paramao = ((n)g.ad(n.class)).search(2, paramao);
    AppMethodBeat.o(5825);
    return paramao;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(5828);
    a locala = new a(paramInt2);
    locala.jPN = paramm;
    locala.sxM = parama.sxM;
    locala.fP(paramm.type, paramm.sxF);
    AppMethodBeat.o(5828);
    return locala;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(5827);
    int i = paramInt - parama.szm - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.lnk.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.lnk.get(i);
        localObject = a(131076, paramInt, localm, parama);
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).fP(localm.type, localm.sxF);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szv = (i + 1);
    }
    AppMethodBeat.o(5827);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(5826);
    if (dJ(paramk.syK))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -7;
      paramHashSet.sxM = paramk.sxM;
      paramHashSet.lnk = paramk.syK;
      this.sBx.add(paramHashSet);
    }
    AppMethodBeat.o(5826);
  }
  
  public final int getType()
  {
    return 4208;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.c
 * JD-Core Version:    0.7.0.1
 */