package com.tencent.mm.plugin.fts.ui.d;

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
import com.tencent.mm.plugin.fts.ui.a.r;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.List;

public final class d
  extends com.tencent.mm.plugin.fts.ui.a
{
  public d(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62063);
    i locali = new i();
    locali.query = this.query;
    locali.mSP = new int[] { 131072, 131081 };
    locali.mST = b.mTt;
    locali.mSS = paramHashSet;
    locali.mSU = this;
    locali.handler = paramak;
    locali.hdl = 16;
    paramak = ((n)g.G(n.class)).search(2, locali);
    AppMethodBeat.o(62063);
    return paramak;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62065);
    int i = paramInt - parama.mTy - 1;
    l locall = null;
    Object localObject = locall;
    if (i < parama.mTC.size())
    {
      localObject = locall;
      if (i >= 0)
      {
        locall = (l)parama.mTC.get(i);
        localObject = new r(paramInt);
        ((r)localObject).hrL = locall;
        ((r)localObject).mRX = parama.mRX;
        ((r)localObject).es(locall.type, locall.mRU);
      }
    }
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTJ = (i + 1);
    }
    AppMethodBeat.o(62065);
    return localObject;
  }
  
  public final void a(j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62064);
    if (bU(paramj.mSW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -4;
      paramHashSet.mTC = paramj.mSW;
      paramHashSet.mRX = paramj.mRX;
      paramHashSet.mTB = false;
      this.mVO.add(paramHashSet);
    }
    AppMethodBeat.o(62064);
  }
  
  public final int getType()
  {
    return 4112;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.d
 * JD-Core Version:    0.7.0.1
 */