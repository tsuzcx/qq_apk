package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.c;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.List;

public final class h
  extends com.tencent.mm.plugin.fts.ui.a
{
  public h(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62077);
    i locali = new i();
    locali.query = this.query;
    locali.handler = paramak;
    locali.mSS = paramHashSet;
    locali.mSU = this;
    locali.mST = c.mTu;
    paramak = ((n)g.G(n.class)).search(4, locali);
    AppMethodBeat.o(62077);
    return paramak;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, l paraml, e.a parama)
  {
    AppMethodBeat.i(62080);
    com.tencent.mm.plugin.fts.ui.a.j localj = new com.tencent.mm.plugin.fts.ui.a.j(paramInt2);
    localj.hrL = paraml;
    localj.mRX = parama.mRX;
    localj.es(paraml.type, paraml.mRU);
    AppMethodBeat.o(62080);
    return localj;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62079);
    int i = paramInt - parama.mTy - 1;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i < parama.mTC.size())
    {
      localObject1 = localObject2;
      if (i >= 0) {
        localObject1 = a(262144, paramInt, (l)parama.mTC.get(i), parama);
      }
    }
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject1).mTJ = (i + 1);
    }
    AppMethodBeat.o(62079);
    return localObject1;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62078);
    if (bU(paramj.mSW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -6;
      paramHashSet.mRX = paramj.mRX;
      paramHashSet.mTC = paramj.mSW;
      paramHashSet.mTB = false;
      this.mVO.add(paramHashSet);
    }
    AppMethodBeat.o(62078);
  }
  
  public final int getType()
  {
    return 64;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.h
 * JD-Core Version:    0.7.0.1
 */