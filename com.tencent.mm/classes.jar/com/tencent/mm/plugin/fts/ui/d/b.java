package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.ui.a
{
  public b(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62056);
    i locali = new i();
    locali.hdl = 32;
    locali.query = this.query;
    locali.mSS = paramHashSet;
    locali.mST = com.tencent.mm.plugin.fts.a.c.a.mTs;
    locali.mSU = this;
    locali.handler = paramak;
    paramak = ((n)g.G(n.class)).search(2, locali);
    AppMethodBeat.o(62056);
    return paramak;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62058);
    int i = paramInt - parama.mTy - 1;
    l locall = null;
    Object localObject = locall;
    if (i < parama.mTC.size())
    {
      localObject = locall;
      if (i >= 0)
      {
        locall = (l)parama.mTC.get(i);
        if (!locall.mRV.equals("create_chatroom​")) {
          break label110;
        }
        localObject = new h(paramInt);
        ((h)localObject).mRX = parama.mRX;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTJ = (i + 1);
      }
      AppMethodBeat.o(62058);
      return localObject;
      label110:
      localObject = new q(paramInt);
      ((q)localObject).hrL = locall;
      ((q)localObject).mRX = parama.mRX;
      ((q)localObject).es(locall.type, locall.mRU);
    }
  }
  
  public final void a(j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62057);
    if (bU(paramj.mSW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -3;
      paramHashSet.mTC = paramj.mSW;
      paramHashSet.mRX = paramj.mRX;
      paramHashSet.mTB = false;
      this.mVO.add(paramHashSet);
    }
    AppMethodBeat.o(62057);
  }
  
  public final int getType()
  {
    return 4128;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.b
 * JD-Core Version:    0.7.0.1
 */