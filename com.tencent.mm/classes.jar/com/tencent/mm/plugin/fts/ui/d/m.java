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
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class m
  extends com.tencent.mm.plugin.fts.ui.a
{
  private boolean xeK;
  
  public m(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112215);
    this.xeK = false;
    paramb = (String)g.aAh().azQ().get(6, null);
    if ((paramb != null) && (paramb.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.xeK = bool;
      this.xeK &= Util.isOverseasUser(paramContext);
      AppMethodBeat.o(112215);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112216);
    j localj = new j();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    localArrayList.add(Integer.valueOf(131075));
    localArrayList.add(Integer.valueOf(262144));
    localArrayList.add(Integer.valueOf(131076));
    if (this.xeK)
    {
      localArrayList.add(Integer.valueOf(131073));
      localArrayList.add(Integer.valueOf(131074));
    }
    Object localObject = (com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class);
    b.a locala = b.a.shm;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    if (((com.tencent.mm.plugin.expt.b.b)localObject).a(locala, com.tencent.mm.util.c.hdd()) == 1) {
      localArrayList.add(Integer.valueOf(393216));
    }
    localObject = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      localObject[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    localj.wWU = ((int[])localObject);
    localj.wWW = 3;
    localj.wWZ = this;
    localj.handler = paramMMHandler;
    localj.scene = 0;
    localj.wWX = paramHashSet;
    if (this.query.startsWith("@@"))
    {
      localj.query = this.query.substring(2);
      paramMMHandler = ((n)g.ah(n.class)).search(10000, localj);
      AppMethodBeat.o(112216);
      return paramMMHandler;
    }
    localj.query = this.query;
    paramMMHandler = ((n)g.ah(n.class)).search(1, localj);
    AppMethodBeat.o(112216);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112218);
    int i = paramInt - parama.wXD - 1;
    com.tencent.mm.plugin.fts.a.a.m localm;
    Object localObject;
    if ((i < parama.mWl.size()) && (i >= 0))
    {
      localm = (com.tencent.mm.plugin.fts.a.a.m)parama.mWl.get(i);
      if (localm.type == 131075) {
        localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ah(n.class)).createFTSUIUnit(48, this.context, this.wXC, this.mve);
      }
    }
    for (;;)
    {
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.fts.ui.a)localObject).a(localm.type, paramInt, localm, parama);; localObject = null)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).wXM = (i + 1);
          if (i == parama.mWl.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).wXK = false;
          }
        }
        AppMethodBeat.o(112218);
        return localObject;
        if ((localm.type == 131072) || (localm.type == 131073) || (localm.type == 131074))
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ah(n.class)).createFTSUIUnit(32, this.context, this.wXC, this.mve);
          break;
        }
        if (localm.type == 262144)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ah(n.class)).createFTSUIUnit(64, this.context, this.wXC, this.mve);
          break;
        }
        if (localm.type == 131076)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ah(n.class)).createFTSUIUnit(96, this.context, this.wXC, this.mve);
          break;
        }
        if (localm.type != 393216) {
          break label358;
        }
        localObject = (com.tencent.mm.plugin.fts.ui.a)((n)g.ah(n.class)).createFTSUIUnit(144, this.context, this.wXC, this.mve);
        break;
      }
      label358:
      localObject = null;
    }
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112217);
    Iterator localIterator = paramk.wXb.iterator();
    while (localIterator.hasNext()) {
      paramHashSet.add(((com.tencent.mm.plugin.fts.a.a.m)localIterator.next()).wVX);
    }
    if (eP(paramk.wXb))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -8;
      paramHashSet.mWl = eQ(paramk.wXb);
      paramHashSet.tuG = false;
      paramHashSet.wWd = paramk.wWd;
      this.wZO.add(paramHashSet);
    }
    d.eO(paramk.wXb);
    AppMethodBeat.o(112217);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112219);
    com.tencent.mm.plugin.fts.a.a.m localm;
    if ((paramInt < parama.mWl.size()) && (paramInt >= 0))
    {
      localm = (com.tencent.mm.plugin.fts.a.a.m)parama.mWl.get(paramInt);
      parama = new com.tencent.mm.plugin.fts.a.a.c();
      parama.dUm = 2;
      parama.dUb = String.valueOf(localm.hashCode());
      if (localm.type == 131075) {
        parama.wWa = 4;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112219);
      return parama;
      if ((localm.type == 131072) || (localm.type == 131073) || (localm.type == 131074))
      {
        parama.wWa = 3;
      }
      else if (localm.type == 262144)
      {
        parama.wWa = 10;
      }
      else if (localm.type == 131076)
      {
        parama.wWa = 5;
      }
      else if (localm.type == 393216)
      {
        parama.wWa = 19;
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