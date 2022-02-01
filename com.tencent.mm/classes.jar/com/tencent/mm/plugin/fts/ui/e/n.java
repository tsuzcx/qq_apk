package com.tencent.mm.plugin.fts.ui.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class n
  extends com.tencent.mm.plugin.fts.ui.a
{
  private boolean HCD;
  
  public n(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    AppMethodBeat.i(112215);
    this.HCD = false;
    paramb = (String)h.baE().ban().d(6, null);
    if ((paramb != null) && (paramb.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.HCD = bool;
      this.HCD &= Util.isOverseasUser(paramContext);
      AppMethodBeat.o(112215);
      return;
    }
  }
  
  public final c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112216);
    l locall = new l();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    localArrayList.add(Integer.valueOf(131075));
    localArrayList.add(Integer.valueOf(262144));
    localArrayList.add(Integer.valueOf(131076));
    if (this.HCD)
    {
      localArrayList.add(Integer.valueOf(131073));
      localArrayList.add(Integer.valueOf(131074));
    }
    localArrayList.add(Integer.valueOf(393216));
    if (!((bw)h.ax(bw.class)).aBu()) {
      localArrayList.add(Integer.valueOf(589824));
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    locall.Htx = arrayOfInt;
    locall.Htz = 3;
    locall.HtC = this;
    locall.handler = paramMMHandler;
    locall.scene = 0;
    locall.HtA = paramHashSet;
    if (getQuery().startsWith("@@"))
    {
      locall.query = getQuery().substring(2);
      paramMMHandler = ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).search(10000, locall);
      AppMethodBeat.o(112216);
      return paramMMHandler;
    }
    locall.query = getQuery();
    paramMMHandler = ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).search(1, locall);
    AppMethodBeat.o(112216);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112218);
    int i = paramInt - parama.Huj - 1;
    o localo;
    Object localObject;
    if ((i < parama.tbH.size()) && (i >= 0))
    {
      localo = (o)parama.tbH.get(i);
      if (localo.type == 131075) {
        localObject = (com.tencent.mm.plugin.fts.ui.a)((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnit(48, getContext(), fxE(), fxF());
      }
    }
    for (;;)
    {
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.fts.ui.a)localObject).a(localo.type, paramInt, localo, parama);; localObject = null)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hur = (i + 1);
          if (i == parama.tbH.size() - 1) {
            ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hup = false;
          }
        }
        AppMethodBeat.o(112218);
        return localObject;
        if ((localo.type == 131072) || (localo.type == 131073) || (localo.type == 131074))
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnit(32, getContext(), fxE(), fxF());
          break;
        }
        if (localo.type == 262144)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnit(64, getContext(), fxE(), fxF());
          break;
        }
        if (localo.type == 131076)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnit(96, getContext(), fxE(), fxF());
          break;
        }
        if (localo.type == 393216)
        {
          localObject = (com.tencent.mm.plugin.fts.ui.a)((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnit(144, getContext(), fxE(), fxF());
          break;
        }
        if (localo.type != 589824) {
          break label410;
        }
        localObject = (com.tencent.mm.plugin.fts.ui.a)((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).createFTSUIUnit(133, getContext(), fxE(), fxF());
        localo.HtW = true;
        break;
      }
      label410:
      localObject = null;
    }
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112217);
    Iterator localIterator = paramm.HtF.iterator();
    while (localIterator.hasNext()) {
      paramHashSet.add(((o)localIterator.next()).Hsz);
    }
    if (hS(paramm.HtF))
    {
      paramHashSet = new e.a();
      paramHashSet.businessType = -8;
      paramHashSet.tbH = hT(paramm.HtF);
      paramHashSet.ABD = false;
      paramHashSet.FWt = paramm.FWt;
      this.HwJ.add(paramHashSet);
    }
    d.hQ(paramm.HtF);
    AppMethodBeat.o(112217);
  }
  
  public final e b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112219);
    o localo;
    if ((paramInt < parama.tbH.size()) && (paramInt >= 0))
    {
      localo = (o)parama.tbH.get(paramInt);
      parama = new e();
      parama.itemType = 2;
      parama.hTs = String.valueOf(localo.hashCode());
      if (localo.type == 131075) {
        parama.HsC = 4;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112219);
      return parama;
      if ((localo.type == 131072) || (localo.type == 131073) || (localo.type == 131074))
      {
        parama.HsC = 3;
      }
      else if (localo.type == 262144)
      {
        parama.HsC = 10;
      }
      else if (localo.type == 131076)
      {
        parama.HsC = 5;
        parama.HsE = localo.Hsz;
      }
      else if (localo.type == 393216)
      {
        parama.HsC = 19;
        parama.HsE = localo.Hsz;
      }
      else if (localo.type == 589824)
      {
        parama.HsC = 31;
        parama.HsE = localo.Hsz;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.n
 * JD-Core Version:    0.7.0.1
 */