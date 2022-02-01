package com.tencent.mm.plugin.fav.ui.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.List;

public final class e
  extends com.tencent.mm.plugin.fts.ui.a
{
  public e(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(107316);
    j localj = new j();
    localj.nRn = 1;
    localj.query = getQuery();
    localj.BIR = 1;
    localj.BIS = paramHashSet;
    localj.handler = paramMMHandler;
    localj.BIU = this;
    paramMMHandler = ((n)h.ag(n.class)).search(6, localj);
    AppMethodBeat.o(107316);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(107318);
    int i = paramInt - parama.BJz - 1;
    m localm = null;
    Object localObject = localm;
    if (i < parama.pWR.size())
    {
      localObject = localm;
      if (i >= 0)
      {
        localm = (m)parama.pWR.get(i);
        localObject = new a(paramInt);
        ((a)localObject).olG = localm;
        ((a)localObject).BHY = parama.BHY;
        ((a)localObject).hx(localm.type, localm.BHR);
        ((a)localObject).wPW = false;
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJI = (i + 1);
    }
    AppMethodBeat.o(107318);
    return localObject;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(107317);
    if (ff(paramk.BIW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -1;
      paramHashSet.BHY = paramk.BHY;
      paramHashSet.pWR = paramk.BIW;
      if (paramHashSet.pWR.size() > 1)
      {
        paramHashSet.xcp = true;
        paramHashSet.pWR = paramHashSet.pWR.subList(0, 1);
      }
      this.BLN.add(paramHashSet);
    }
    AppMethodBeat.o(107317);
  }
  
  public final c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(107319);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt < parama.pWR.size())
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        parama = (m)parama.pWR.get(paramInt);
        localObject1 = new c();
        ((c)localObject1).fND = String.valueOf(parama.hashCode());
        ((c)localObject1).fNO = 12;
      }
    }
    AppMethodBeat.o(107319);
    return localObject1;
  }
  
  public final int getType()
  {
    return 128;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.e
 * JD-Core Version:    0.7.0.1
 */