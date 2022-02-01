package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashSet;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.ui.a
{
  public b(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112168);
    j localj = new j();
    localj.jwR = 32;
    localj.query = this.query;
    localj.syG = paramHashSet;
    localj.syH = com.tencent.mm.plugin.fts.a.c.a.szg;
    localj.syI = this;
    localj.handler = paramao;
    paramao = ((n)g.ad(n.class)).search(2, localj);
    AppMethodBeat.o(112168);
    return paramao;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112170);
    int i = paramInt - parama.szm - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.lnk.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.lnk.get(i);
        if (!localm.sxG.equals("create_chatroom​")) {
          break label110;
        }
        localObject = new h(paramInt);
        ((h)localObject).sxM = parama.sxM;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szv = (i + 1);
      }
      AppMethodBeat.o(112170);
      return localObject;
      label110:
      localObject = new q(paramInt);
      ((q)localObject).jPN = localm;
      ((q)localObject).sxM = parama.sxM;
      ((q)localObject).fP(localm.type, localm.sxF);
    }
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112169);
    if (dJ(paramk.syK))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -3;
      paramHashSet.lnk = paramk.syK;
      paramHashSet.sxM = paramk.sxM;
      paramHashSet.qYO = false;
      this.sBx.add(paramHashSet);
    }
    AppMethodBeat.o(112169);
  }
  
  public final int getType()
  {
    return 4128;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.b
 * JD-Core Version:    0.7.0.1
 */