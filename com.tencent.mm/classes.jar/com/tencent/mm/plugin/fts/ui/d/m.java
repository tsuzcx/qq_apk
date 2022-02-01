package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.a.c;
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
  private boolean BQT;
  
  public m(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112215);
    this.BQT = false;
    paramb = (String)h.aHG().aHp().b(6, null);
    if ((paramb != null) && (paramb.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.BQT = bool;
      this.BQT &= Util.isOverseasUser(paramContext);
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
    if (this.BQT)
    {
      localArrayList.add(Integer.valueOf(131073));
      localArrayList.add(Integer.valueOf(131074));
    }
    if (((b)h.ae(b.class)).a(b.a.vRk, 0) == 1) {
      localArrayList.add(Integer.valueOf(393216));
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    localj.BIP = arrayOfInt;
    localj.BIR = 3;
    localj.BIU = this;
    localj.handler = paramMMHandler;
    localj.scene = 0;
    localj.BIS = paramHashSet;
    if (getQuery().startsWith("@@"))
    {
      localj.query = getQuery().substring(2);
      paramMMHandler = ((n)h.ag(n.class)).search(10000, localj);
      AppMethodBeat.o(112216);
      return paramMMHandler;
    }
    localj.query = getQuery();
    paramMMHandler = ((n)h.ag(n.class)).search(1, localj);
    AppMethodBeat.o(112216);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112218);
    int i = paramInt - parama.BJz - 1;
    com.tencent.mm.plugin.fts.a.a.m localm;
    Object localObject;
    if ((i < parama.pWR.size()) && (i >= 0))
    {
      localm = (com.tencent.mm.plugin.fts.a.a.m)parama.pWR.get(i);
      if (localm.type == 131075) {
        localObject = (com.tencent.mm.plugin.fts.ui.a)((n)h.ag(n.class)).createFTSUIUnit(48, getContext(), eqX(), eqY());
      }
    }
    for (;;)
    {
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.fts.ui.a)localObject).a(localm.type, paramInt, localm, parama);; localObject = null)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJI = (i + 1);
          if (i == parama.pWR.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).BJG = false;
          }
        }
        AppMethodBeat.o(112218);
        return localObject;
        if ((localm.type == 131072) || (localm.type == 131073) || (localm.type == 131074))
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)h.ag(n.class)).createFTSUIUnit(32, getContext(), eqX(), eqY());
          break;
        }
        if (localm.type == 262144)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)h.ag(n.class)).createFTSUIUnit(64, getContext(), eqX(), eqY());
          break;
        }
        if (localm.type == 131076)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((n)h.ag(n.class)).createFTSUIUnit(96, getContext(), eqX(), eqY());
          break;
        }
        if (localm.type != 393216) {
          break label358;
        }
        localObject = (com.tencent.mm.plugin.fts.ui.a)((n)h.ag(n.class)).createFTSUIUnit(144, getContext(), eqX(), eqY());
        break;
      }
      label358:
      localObject = null;
    }
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112217);
    Iterator localIterator = paramk.BIW.iterator();
    while (localIterator.hasNext()) {
      paramHashSet.add(((com.tencent.mm.plugin.fts.a.a.m)localIterator.next()).BHS);
    }
    if (ff(paramk.BIW))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -8;
      paramHashSet.pWR = fg(paramk.BIW);
      paramHashSet.xcp = false;
      paramHashSet.BHY = paramk.BHY;
      this.BLN.add(paramHashSet);
    }
    d.fe(paramk.BIW);
    AppMethodBeat.o(112217);
  }
  
  public final c b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112219);
    com.tencent.mm.plugin.fts.a.a.m localm;
    if ((paramInt < parama.pWR.size()) && (paramInt >= 0))
    {
      localm = (com.tencent.mm.plugin.fts.a.a.m)parama.pWR.get(paramInt);
      parama = new c();
      parama.fNO = 2;
      parama.fND = String.valueOf(localm.hashCode());
      if (localm.type == 131075) {
        parama.BHV = 4;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112219);
      return parama;
      if ((localm.type == 131072) || (localm.type == 131073) || (localm.type == 131074))
      {
        parama.BHV = 3;
      }
      else if (localm.type == 262144)
      {
        parama.BHV = 10;
      }
      else if (localm.type == 131076)
      {
        parama.BHV = 5;
      }
      else if (localm.type == 393216)
      {
        parama.BHV = 19;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.m
 * JD-Core Version:    0.7.0.1
 */