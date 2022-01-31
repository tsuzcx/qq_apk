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
import com.tencent.mm.plugin.fts.ui.a.r;
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
    AppMethodBeat.i(62066);
    i locali = new i();
    locali.hdl = 64;
    locali.query = this.query;
    locali.mSP = new int[] { 131072, 131081 };
    locali.mSR = 3;
    locali.mST = com.tencent.mm.plugin.fts.a.c.b.mTt;
    locali.mSS = paramHashSet;
    locali.mSU = this;
    locali.handler = paramak;
    paramak = ((n)g.G(n.class)).search(2, locali);
    AppMethodBeat.o(62066);
    return paramak;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, l paraml, e.a parama)
  {
    AppMethodBeat.i(62069);
    Object localObject = null;
    if ((paraml.type == 131072) || (paraml.type == 131081))
    {
      localObject = new r(paramInt2);
      ((r)localObject).hrL = paraml;
      ((r)localObject).mRX = parama.mRX;
      ((r)localObject).es(paraml.type, paraml.mRU);
    }
    for (;;)
    {
      AppMethodBeat.o(62069);
      return localObject;
      if ((paraml.type == 131073) || (paraml.type == 131074)) {
        localObject = ((com.tencent.mm.plugin.fts.ui.a)((n)g.G(n.class)).createFTSUIUnit(33, this.context, this.mTx, this.ibk)).a(paramInt1, paramInt2, paraml, parama);
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62068);
    Object localObject = null;
    com.tencent.mm.plugin.fts.a.d.a.a locala = null;
    int i;
    if (parama.mTz)
    {
      i = paramInt - parama.mTy - 1;
      localObject = locala;
      if (i < parama.mTC.size())
      {
        localObject = locala;
        if (i >= 0)
        {
          l locall = (l)parama.mTC.get(i);
          locala = a(locall.type, paramInt, locall, parama);
          localObject = locala;
          if (locala != null)
          {
            locala.es(locall.type, locall.mRU);
            localObject = locala;
          }
        }
      }
    }
    for (paramInt = i;; paramInt = 0)
    {
      if (localObject != null)
      {
        localObject.mTJ = (paramInt + 1);
        if (paramInt == parama.mTC.size() - 1) {
          localObject.mTH = false;
        }
      }
      AppMethodBeat.o(62068);
      return localObject;
    }
  }
  
  public final void a(j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62067);
    paramHashSet = new e.a();
    paramHashSet.businessType = -4;
    paramHashSet.mTC = paramj.mSW;
    paramHashSet.mTz = bU(paramj.mSW);
    paramHashSet.mRX = paramj.mRX;
    if (paramHashSet.mTC.size() > 3)
    {
      paramHashSet.mTB = true;
      paramHashSet.mTC = paramHashSet.mTC.subList(0, 3);
    }
    if (bU(paramj.mSW)) {
      this.mVO.add(paramHashSet);
    }
    AppMethodBeat.o(62067);
  }
  
  public final int getType()
  {
    return 32;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.e
 * JD-Core Version:    0.7.0.1
 */