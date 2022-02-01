package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.r;
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
    AppMethodBeat.i(112179);
    j localj = new j();
    localj.nRn = 64;
    localj.query = getQuery();
    localj.BIP = new int[] { 131072, 131081 };
    localj.BIR = 3;
    localj.BIT = b.BJu;
    localj.BIS = paramHashSet;
    localj.BIU = this;
    localj.handler = paramMMHandler;
    paramMMHandler = ((n)h.ag(n.class)).search(2, localj);
    AppMethodBeat.o(112179);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(112182);
    Object localObject = null;
    if ((paramm.type == 131072) || (paramm.type == 131081))
    {
      localObject = new r(paramInt2);
      ((r)localObject).olG = paramm;
      ((r)localObject).BHY = parama.BHY;
      ((r)localObject).hx(paramm.type, paramm.BHR);
    }
    for (;;)
    {
      AppMethodBeat.o(112182);
      return localObject;
      if ((paramm.type == 131073) || (paramm.type == 131074)) {
        localObject = ((com.tencent.mm.plugin.fts.ui.a)((n)h.ag(n.class)).createFTSUIUnit(33, getContext(), eqX(), eqY())).a(paramInt1, paramInt2, paramm, parama);
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112181);
    Object localObject = null;
    com.tencent.mm.plugin.fts.a.d.a.a locala = null;
    int i;
    if (parama.BJA)
    {
      i = paramInt - parama.BJz - 1;
      localObject = locala;
      if (i < parama.pWR.size())
      {
        localObject = locala;
        if (i >= 0)
        {
          m localm = (m)parama.pWR.get(i);
          locala = a(localm.type, paramInt, localm, parama);
          localObject = locala;
          if (locala != null)
          {
            locala.hx(localm.type, localm.BHR);
            localObject = locala;
          }
        }
      }
    }
    for (paramInt = i;; paramInt = 0)
    {
      if (localObject != null)
      {
        localObject.BJI = (paramInt + 1);
        if (paramInt == parama.pWR.size() - 1) {
          localObject.BJG = false;
        }
      }
      AppMethodBeat.o(112181);
      return localObject;
    }
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112180);
    paramHashSet = new e.a();
    paramHashSet.businessType = -4;
    paramHashSet.pWR = paramk.BIW;
    paramHashSet.BJA = ff(paramk.BIW);
    paramHashSet.BHY = paramk.BHY;
    if (paramHashSet.pWR.size() > 3)
    {
      paramHashSet.xcp = true;
      paramHashSet.pWR = paramHashSet.pWR.subList(0, 3);
    }
    if (ff(paramk.BIW)) {
      this.BLN.add(paramHashSet);
    }
    AppMethodBeat.o(112180);
  }
  
  public final c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112183);
    if ((paramInt < parama.pWR.size()) && (paramInt >= 0))
    {
      m localm = (m)parama.pWR.get(paramInt);
      parama = new c();
      parama.fND = String.valueOf(localm.hashCode());
      if ((localm.type == 131072) || (localm.type == 131081) || (localm.type == 131073) || (localm.type == 131074)) {
        parama.fNO = 3;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112183);
      return parama;
      parama = null;
      continue;
      parama = null;
    }
  }
  
  public final int getType()
  {
    return 32;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.e
 * JD-Core Version:    0.7.0.1
 */