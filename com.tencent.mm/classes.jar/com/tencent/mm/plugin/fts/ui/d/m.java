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
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class m
  extends com.tencent.mm.plugin.fts.ui.a
{
  private boolean sFY;
  
  public m(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112215);
    this.sFY = false;
    paramb = (String)g.agR().agA().get(6, null);
    if ((paramb != null) && (paramb.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.sFY = bool;
      this.sFY &= bs.ja(paramContext);
      AppMethodBeat.o(112215);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112216);
    j localj = new j();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    localArrayList.add(Integer.valueOf(131075));
    localArrayList.add(Integer.valueOf(262144));
    localArrayList.add(Integer.valueOf(131076));
    if (this.sFY)
    {
      localArrayList.add(Integer.valueOf(131073));
      localArrayList.add(Integer.valueOf(131074));
    }
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYt, com.tencent.mm.util.c.fwV()) == 1) {
      localArrayList.add(Integer.valueOf(393216));
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    localj.syD = arrayOfInt;
    localj.syF = 3;
    localj.syI = this;
    localj.handler = paramao;
    localj.scene = 0;
    localj.syG = paramHashSet;
    if (this.query.startsWith("@@"))
    {
      localj.query = this.query.substring(2);
      paramao = ((n)g.ad(n.class)).search(10000, localj);
      AppMethodBeat.o(112216);
      return paramao;
    }
    localj.query = this.query;
    paramao = ((n)g.ad(n.class)).search(1, localj);
    AppMethodBeat.o(112216);
    return paramao;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112218);
    int i = paramInt - parama.szm - 1;
    com.tencent.mm.plugin.fts.a.a.m localm;
    Object localObject;
    if ((i < parama.lnk.size()) && (i >= 0))
    {
      localm = (com.tencent.mm.plugin.fts.a.a.m)parama.lnk.get(i);
      if (localm.type == 131075) {
        localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(48, this.context, this.szl, this.kNw);
      }
    }
    for (;;)
    {
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.fts.ui.a)localObject).a(localm.type, paramInt, localm, parama);; localObject = null)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szv = (i + 1);
          if (i == parama.lnk.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szt = false;
          }
        }
        AppMethodBeat.o(112218);
        return localObject;
        if ((localm.type == 131072) || (localm.type == 131073) || (localm.type == 131074))
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(32, this.context, this.szl, this.kNw);
          break;
        }
        if (localm.type == 262144)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(64, this.context, this.szl, this.kNw);
          break;
        }
        if (localm.type == 131076)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(96, this.context, this.szl, this.kNw);
          break;
        }
        if (localm.type != 393216) {
          break label358;
        }
        localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ad(n.class)).createFTSUIUnit(144, this.context, this.szl, this.kNw);
        break;
      }
      label358:
      localObject = null;
    }
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112217);
    Iterator localIterator = paramk.syK.iterator();
    while (localIterator.hasNext()) {
      paramHashSet.add(((com.tencent.mm.plugin.fts.a.a.m)localIterator.next()).sxG);
    }
    if (dJ(paramk.syK))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -8;
      paramHashSet.lnk = dK(paramk.syK);
      paramHashSet.qYO = false;
      paramHashSet.sxM = paramk.sxM;
      this.sBx.add(paramHashSet);
    }
    d.dI(paramk.syK);
    AppMethodBeat.o(112217);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112219);
    com.tencent.mm.plugin.fts.a.a.m localm;
    if ((paramInt < parama.lnk.size()) && (paramInt >= 0))
    {
      localm = (com.tencent.mm.plugin.fts.a.a.m)parama.lnk.get(paramInt);
      parama = new com.tencent.mm.plugin.fts.a.a.c();
      parama.dpE = 2;
      parama.dpt = String.valueOf(localm.hashCode());
      if (localm.type == 131075) {
        parama.sxJ = 4;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112219);
      return parama;
      if ((localm.type == 131072) || (localm.type == 131073) || (localm.type == 131074))
      {
        parama.sxJ = 3;
      }
      else if (localm.type == 262144)
      {
        parama.sxJ = 10;
      }
      else if (localm.type == 131076)
      {
        parama.sxJ = 5;
      }
      else if (localm.type == 393216)
      {
        parama.sxJ = 19;
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