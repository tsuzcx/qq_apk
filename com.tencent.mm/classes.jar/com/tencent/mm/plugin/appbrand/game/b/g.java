package com.tencent.mm.plugin.appbrand.game.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class g
  extends com.tencent.mm.plugin.fts.ui.a
{
  public g(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(130088);
    i locali = new i();
    locali.query = this.query;
    locali.mST = d.mTv;
    locali.mSU = this;
    locali.handler = paramak;
    locali.mSS = paramHashSet;
    locali.mST = h.hsK;
    paramak = ((n)com.tencent.mm.kernel.g.G(n.class)).search(10, locali);
    AppMethodBeat.o(130088);
    return paramak;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(130090);
    int i = paramInt - parama.mTy - 1;
    l locall = null;
    Object localObject = locall;
    if (i < parama.mTC.size())
    {
      localObject = locall;
      if (i >= 0)
      {
        locall = (l)parama.mTC.get(i);
        localObject = new c(paramInt);
        ((c)localObject).hrL = locall;
        ((c)localObject).mRX = parama.mRX;
        ((c)localObject).es(locall.type, locall.mRU);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTJ = (i + 1);
    }
    AppMethodBeat.o(130090);
    return localObject;
  }
  
  public final void a(j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(130089);
    if (bU(paramj.mSW))
    {
      e.a locala = new e.a();
      locala.businessType = -15;
      locala.mTC = paramj.mSW;
      locala.mRX = paramj.mRX;
      paramj = paramj.mSW.iterator();
      while (paramj.hasNext()) {
        paramHashSet.add(((l)paramj.next()).mRV);
      }
      if (locala.mTC.size() > 3)
      {
        locala.mTB = true;
        locala.mTC = locala.mTC.subList(0, 3);
      }
      this.mVO.add(locala);
    }
    AppMethodBeat.o(130089);
  }
  
  public final int getType()
  {
    return 208;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.g
 * JD-Core Version:    0.7.0.1
 */