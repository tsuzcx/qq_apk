package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class m
  extends com.tencent.mm.plugin.fts.ui.a
{
  private boolean rxg;
  
  public m(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112215);
    this.rxg = false;
    paramb = (String)g.afB().afk().get(6, null);
    if ((paramb != null) && (paramb.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.rxg = bool;
      this.rxg &= bt.iP(paramContext);
      AppMethodBeat.o(112215);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112216);
    j localj = new j();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    localArrayList.add(Integer.valueOf(131075));
    localArrayList.add(Integer.valueOf(262144));
    localArrayList.add(Integer.valueOf(131076));
    if (this.rxg)
    {
      localArrayList.add(Integer.valueOf(131073));
      localArrayList.add(Integer.valueOf(131074));
    }
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puf, com.tencent.mm.util.c.fgV()) == 1) {
      localArrayList.add(Integer.valueOf(393216));
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    localj.rpJ = arrayOfInt;
    localj.rpL = 3;
    localj.rpO = this;
    localj.handler = paramap;
    localj.scene = 0;
    localj.rpM = paramHashSet;
    if (this.query.startsWith("@@"))
    {
      localj.query = this.query.substring(2);
      paramap = ((n)g.ad(n.class)).search(10000, localj);
      AppMethodBeat.o(112216);
      return paramap;
    }
    localj.query = this.query;
    paramap = ((n)g.ad(n.class)).search(1, localj);
    AppMethodBeat.o(112216);
    return paramap;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112218);
    int i = paramInt - parama.rqs - 1;
    com.tencent.mm.plugin.fts.a.a.m localm;
    Object localObject;
    if ((i < parama.kLN.size()) && (i >= 0))
    {
      localm = (com.tencent.mm.plugin.fts.a.a.m)parama.kLN.get(i);
      if (localm.type == 131075) {
        localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(48, this.context, this.rqr, this.kme);
      }
    }
    for (;;)
    {
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.fts.ui.a)localObject).a(localm.type, paramInt, localm, parama);; localObject = null)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rqB = (i + 1);
          if (i == parama.kLN.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).rqz = false;
          }
        }
        AppMethodBeat.o(112218);
        return localObject;
        if ((localm.type == 131072) || (localm.type == 131073) || (localm.type == 131074))
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(32, this.context, this.rqr, this.kme);
          break;
        }
        if (localm.type == 262144)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(64, this.context, this.rqr, this.kme);
          break;
        }
        if (localm.type == 131076)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(96, this.context, this.rqr, this.kme);
          break;
        }
        if (localm.type != 393216) {
          break label358;
        }
        localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(144, this.context, this.rqr, this.kme);
        break;
      }
      label358:
      localObject = null;
    }
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112217);
    Iterator localIterator = paramk.rpQ.iterator();
    while (localIterator.hasNext()) {
      paramHashSet.add(((com.tencent.mm.plugin.fts.a.a.m)localIterator.next()).roN);
    }
    if (dF(paramk.rpQ))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -8;
      paramHashSet.kLN = dG(paramk.rpQ);
      paramHashSet.qpI = false;
      paramHashSet.roS = paramk.roS;
      this.rsD.add(paramHashSet);
    }
    d.dE(paramk.rpQ);
    AppMethodBeat.o(112217);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112219);
    com.tencent.mm.plugin.fts.a.a.m localm;
    if ((paramInt < parama.kLN.size()) && (paramInt >= 0))
    {
      localm = (com.tencent.mm.plugin.fts.a.a.m)parama.kLN.get(paramInt);
      parama = new com.tencent.mm.plugin.fts.a.a.c();
      parama.drT = 2;
      parama.drI = String.valueOf(localm.hashCode());
      if (localm.type == 131075) {
        parama.roP = 4;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112219);
      return parama;
      if ((localm.type == 131072) || (localm.type == 131073) || (localm.type == 131074))
      {
        parama.roP = 3;
      }
      else if (localm.type == 262144)
      {
        parama.roP = 10;
      }
      else if (localm.type == 131076)
      {
        parama.roP = 5;
      }
      else if (localm.type == 393216)
      {
        parama.roP = 19;
      }
      else
      {
        parama = null;
        continue;
        parama = null;
      }
    }
  }
  
  public final int getType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.m
 * JD-Core Version:    0.7.0.1
 */