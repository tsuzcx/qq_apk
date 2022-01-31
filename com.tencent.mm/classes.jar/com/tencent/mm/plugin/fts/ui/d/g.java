package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.f;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.List;

public final class g
  extends l
{
  public String mSN;
  public int showType;
  public String talker;
  
  public g(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62074);
    this.naH = false;
    paramHashSet = new i();
    paramHashSet.query = this.query;
    paramHashSet.mST = e.mTw;
    paramHashSet.mSN = this.mSN;
    paramHashSet.mSO = this.mSO;
    paramHashSet.talker = this.talker;
    paramHashSet.mSU = this;
    paramHashSet.handler = paramak;
    paramHashSet.hdl = 11;
    paramak = ((n)com.tencent.mm.kernel.g.G(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(62074);
    return paramak;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62076);
    Object localObject2 = null;
    int i;
    Object localObject1;
    if (parama.mTz)
    {
      i = paramInt - parama.mTy - 1;
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (i < parama.mTC.size())
        {
          parama = (com.tencent.mm.plugin.fts.a.a.l)parama.mTC.get(i);
          if (!parama.mRV.equals("no_result​")) {
            break label103;
          }
          localObject1 = new com.tencent.mm.plugin.fts.ui.a.l(paramInt);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62076);
      return localObject1;
      i = paramInt - parama.mTy;
      break;
      label103:
      localObject1 = new com.tencent.mm.plugin.fts.ui.a.g(paramInt);
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).hrL = parama;
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).mRX = ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).hrL.mRX;
      ((com.tencent.mm.plugin.fts.ui.a.g)localObject1).es(parama.type, parama.mRU);
    }
  }
  
  public final k b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62075);
    f localf = new f(paramInt);
    localf.mYP = parama.mTE;
    localf.mSN = this.mSN;
    AppMethodBeat.o(62075);
    return localf;
  }
  
  public final int bDc()
  {
    return this.showType;
  }
  
  public final int getType()
  {
    return 192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.g
 * JD-Core Version:    0.7.0.1
 */