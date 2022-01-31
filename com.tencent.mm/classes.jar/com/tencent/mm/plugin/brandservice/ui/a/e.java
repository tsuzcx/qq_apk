package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.List;

public final class e
  extends com.tencent.mm.plugin.fts.ui.a
{
  public e(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(14093);
    String str = this.query;
    b localb = b.mTt;
    paramak = i.a(str, new int[] { 131076 }, null, 4, paramHashSet, localb, this, paramak);
    paramak = ((n)g.G(n.class)).search(2, paramak);
    AppMethodBeat.o(14093);
    return paramak;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, l paraml, e.a parama)
  {
    AppMethodBeat.i(14096);
    a locala = new a(paramInt2);
    locala.hrL = paraml;
    locala.mRX = parama.mRX;
    locala.es(paraml.type, paraml.mRU);
    AppMethodBeat.o(14096);
    return locala;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(14095);
    int i = paramInt - parama.mTy - 1;
    l locall = null;
    Object localObject = locall;
    if (i < parama.mTC.size())
    {
      localObject = locall;
      if (i >= 0)
      {
        locall = (l)parama.mTC.get(i);
        localObject = a(131076, paramInt, locall, parama);
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).es(locall.type, locall.mRU);
      }
    }
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTJ = (i + 1);
      if (i == parama.mTC.size() - 1) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTH = false;
      }
    }
    AppMethodBeat.o(14095);
    return localObject;
  }
  
  public final void a(j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(14094);
    if (bU(paramj.mSW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -7;
      paramHashSet.mTC = paramj.mSW;
      paramHashSet.mRX = paramj.mRX;
      if (paramHashSet.mTC.size() > 3)
      {
        paramHashSet.mTB = true;
        paramHashSet.mTC = paramHashSet.mTC.subList(0, 3);
      }
      this.mVO.add(paramHashSet);
    }
    AppMethodBeat.o(14094);
  }
  
  public final int getType()
  {
    return 96;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.e
 * JD-Core Version:    0.7.0.1
 */