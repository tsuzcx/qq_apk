package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class m
  extends com.tencent.mm.plugin.fts.ui.a
{
  private boolean tNJ;
  
  public m(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112215);
    this.tNJ = false;
    paramb = (String)g.ajR().ajA().get(6, null);
    if ((paramb != null) && (paramb.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.tNJ = bool;
      this.tNJ &= bu.jq(paramContext);
      AppMethodBeat.o(112215);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(aq paramaq, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112216);
    j localj = new j();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    localArrayList.add(Integer.valueOf(131075));
    localArrayList.add(Integer.valueOf(262144));
    localArrayList.add(Integer.valueOf(131076));
    if (this.tNJ)
    {
      localArrayList.add(Integer.valueOf(131073));
      localArrayList.add(Integer.valueOf(131074));
    }
    Object localObject = (com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class);
    b.a locala = b.a.qLe;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (((com.tencent.mm.plugin.expt.b.b)localObject).a(locala, com.tencent.mm.util.c.fSe()) == 1) {
      localArrayList.add(Integer.valueOf(393216));
    }
    localObject = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      localObject[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    localj.tFV = ((int[])localObject);
    localj.tFX = 3;
    localj.tGa = this;
    localj.handler = paramaq;
    localj.scene = 0;
    localj.tFY = paramHashSet;
    if (this.query.startsWith("@@"))
    {
      localj.query = this.query.substring(2);
      paramaq = ((n)g.ad(n.class)).search(10000, localj);
      AppMethodBeat.o(112216);
      return paramaq;
    }
    localj.query = this.query;
    paramaq = ((n)g.ad(n.class)).search(1, localj);
    AppMethodBeat.o(112216);
    return paramaq;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112218);
    int i = paramInt - parama.tGE - 1;
    com.tencent.mm.plugin.fts.a.a.m localm;
    Object localObject;
    if ((i < parama.lPc.size()) && (i >= 0))
    {
      localm = (com.tencent.mm.plugin.fts.a.a.m)parama.lPc.get(i);
      if (localm.type == 131075) {
        localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(48, this.context, this.tGD, this.lox);
      }
    }
    for (;;)
    {
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.fts.ui.a)localObject).a(localm.type, paramInt, localm, parama);; localObject = null)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGN = (i + 1);
          if (i == parama.lPc.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).tGL = false;
          }
        }
        AppMethodBeat.o(112218);
        return localObject;
        if ((localm.type == 131072) || (localm.type == 131073) || (localm.type == 131074))
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(32, this.context, this.tGD, this.lox);
          break;
        }
        if (localm.type == 262144)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(64, this.context, this.tGD, this.lox);
          break;
        }
        if (localm.type == 131076)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(96, this.context, this.tGD, this.lox);
          break;
        }
        if (localm.type != 393216) {
          break label358;
        }
        localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(144, this.context, this.tGD, this.lox);
        break;
      }
      label358:
      localObject = null;
    }
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112217);
    Iterator localIterator = paramk.tGc.iterator();
    while (localIterator.hasNext()) {
      paramHashSet.add(((com.tencent.mm.plugin.fts.a.a.m)localIterator.next()).tEY);
    }
    if (dX(paramk.tGc))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -8;
      paramHashSet.lPc = dY(paramk.tGc);
      paramHashSet.rRg = false;
      paramHashSet.tFe = paramk.tFe;
      this.tIP.add(paramHashSet);
    }
    d.dW(paramk.tGc);
    AppMethodBeat.o(112217);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112219);
    com.tencent.mm.plugin.fts.a.a.m localm;
    if ((paramInt < parama.lPc.size()) && (paramInt >= 0))
    {
      localm = (com.tencent.mm.plugin.fts.a.a.m)parama.lPc.get(paramInt);
      parama = new com.tencent.mm.plugin.fts.a.a.c();
      parama.dCw = 2;
      parama.dCl = String.valueOf(localm.hashCode());
      if (localm.type == 131075) {
        parama.tFb = 4;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112219);
      return parama;
      if ((localm.type == 131072) || (localm.type == 131073) || (localm.type == 131074))
      {
        parama.tFb = 3;
      }
      else if (localm.type == 262144)
      {
        parama.tFb = 10;
      }
      else if (localm.type == 131076)
      {
        parama.tFb = 5;
      }
      else if (localm.type == 393216)
      {
        parama.tFb = 19;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.m
 * JD-Core Version:    0.7.0.1
 */