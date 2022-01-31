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

public final class c
  extends com.tencent.mm.plugin.fts.ui.a
{
  public c(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62059);
    i locali = new i();
    locali.hdl = 96;
    locali.mSR = 3;
    locali.query = this.query;
    locali.mSS = paramHashSet;
    locali.mST = com.tencent.mm.plugin.fts.a.c.a.mTs;
    locali.mSU = this;
    locali.handler = paramak;
    paramak = ((n)g.G(n.class)).search(2, locali);
    AppMethodBeat.o(62059);
    return paramak;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, l paraml, e.a parama)
  {
    AppMethodBeat.i(62062);
    q localq = new q(paramInt2);
    localq.hrL = paraml;
    localq.mRX = parama.mRX;
    localq.es(paraml.type, paraml.mRU);
    AppMethodBeat.o(62062);
    return localq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62061);
    int i = paramInt - parama.mTy - 1;
    l locall;
    Object localObject;
    if ((i < parama.mTC.size()) && (i >= 0))
    {
      locall = (l)parama.mTC.get(i);
      if (locall.mRV.equals("create_chatroom​"))
      {
        localObject = new h(paramInt);
        ((h)localObject).mRX = parama.mRX;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTJ = (i + 1);
        if (i == parama.mTC.size() - 1) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).mTH = false;
        }
      }
      AppMethodBeat.o(62061);
      return localObject;
      if (locall.type == 131075)
      {
        localObject = a(131075, paramInt, locall, parama);
        ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).es(locall.type, locall.mRU);
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public final void a(j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62060);
    boolean bool;
    if (bU(paramj.mSW))
    {
      paramHashSet = new e.a();
      paramHashSet.mTC = paramj.mSW;
      paramHashSet.businessType = -3;
      paramHashSet.mRX = paramj.mRX;
      if (paramHashSet.mTC.size() > 3)
      {
        if (!((l)paramHashSet.mTC.get(3)).mRV.equals("create_chatroom​")) {
          break label139;
        }
        if (paramHashSet.mTC.size() <= 4) {
          break label134;
        }
        bool = true;
        paramHashSet.mTB = bool;
      }
    }
    for (paramHashSet.mTC = paramHashSet.mTC.subList(0, 4);; paramHashSet.mTC = paramHashSet.mTC.subList(0, 3))
    {
      this.mVO.add(paramHashSet);
      AppMethodBeat.o(62060);
      return;
      label134:
      bool = false;
      break;
      label139:
      paramHashSet.mTB = true;
    }
  }
  
  public final int getType()
  {
    return 48;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.c
 * JD-Core Version:    0.7.0.1
 */