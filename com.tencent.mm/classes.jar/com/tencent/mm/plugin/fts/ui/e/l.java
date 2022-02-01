package com.tencent.mm.plugin.fts.ui.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.k;
import com.tencent.mm.plugin.fts.ui.b.p;
import com.tencent.mm.plugin.fts.ui.b.q;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class l
  extends com.tencent.mm.plugin.fts.ui.a
{
  public String Htv;
  
  public l(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  private static int hX(List<com.tencent.mm.plugin.fts.a.a.o> paramList)
  {
    AppMethodBeat.i(265936);
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.o localo = (com.tencent.mm.plugin.fts.a.a.o)paramList.next();
      if ((localo == null) || (localo.subtype != 55)) {
        break label60;
      }
      i += 1;
    }
    label60:
    for (;;)
    {
      break;
      AppMethodBeat.o(265936);
      return i;
    }
  }
  
  public final c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(265938);
    paramHashSet = new com.tencent.mm.plugin.fts.a.a.l();
    paramHashSet.query = getQuery();
    paramHashSet.Htv = this.Htv;
    paramHashSet.HtB = e.Huh;
    paramHashSet.HtC = this;
    paramHashSet.handler = paramMMHandler;
    switch (fxF())
    {
    default: 
      paramHashSet.qRb = 0;
    }
    for (;;)
    {
      paramMMHandler = ((n)com.tencent.mm.kernel.h.az(n.class)).search(12, paramHashSet);
      AppMethodBeat.o(265938);
      return paramMMHandler;
      paramHashSet.qRb = 1;
      continue;
      paramHashSet.qRb = 10;
      continue;
      paramHashSet.qRb = 12;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(265941);
    int j = paramInt - parama.Huj;
    int i = j;
    if (parama.Huk) {
      i = j - 1;
    }
    com.tencent.mm.plugin.fts.a.a.o localo;
    Object localObject;
    if ((i < parama.tbH.size()) && (i >= 0))
    {
      localo = (com.tencent.mm.plugin.fts.a.a.o)parama.tbH.get(i);
      if (localo.subtype == 55)
      {
        localObject = new p(paramInt);
        ((p)localObject).iW(localo.type, localo.subtype);
        ((p)localObject).syO = fxF();
        ((p)localObject).rpp = localo;
        ((p)localObject).FWt = parama.FWt;
        ((p)localObject).xVf = -21;
        ((p)localObject).Huq = paramInt;
        ((p)localObject).pageType = 7;
        if (((com.tencent.mm.plugin.fts.a.d.a.a)localObject).position == parama.tbH.size() - 1) {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hup = true;
        }
        parama = (e.a)localObject;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(265941);
      return parama;
      if (localo.subtype == 56)
      {
        localObject = new com.tencent.mm.plugin.fts.ui.b.o(paramInt);
        ((com.tencent.mm.plugin.fts.ui.b.o)localObject).iW(localo.type, localo.subtype);
        i = fxF();
        ((com.tencent.mm.plugin.fts.ui.b.o)localObject).syO = i;
        if (((com.tencent.mm.plugin.fts.ui.b.o)localObject).HBu != null) {
          ((com.tencent.mm.plugin.fts.ui.b.o)localObject).HBu.syO = i;
        }
        ((com.tencent.mm.plugin.fts.ui.b.o)localObject).rpp = localo;
        ((com.tencent.mm.plugin.fts.ui.b.o)localObject).FWt = parama.FWt;
        ((com.tencent.mm.plugin.fts.ui.b.o)localObject).xVf = -21;
        ((com.tencent.mm.plugin.fts.ui.b.o)localObject).Huq = paramInt;
        ((com.tencent.mm.plugin.fts.ui.b.o)localObject).pageType = 7;
        parama = (e.a)localObject;
      }
      else
      {
        parama = null;
      }
    }
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(265939);
    paramHashSet = new a();
    paramHashSet.businessType = -21;
    Object localObject = paramm.HtF;
    if (localObject != null)
    {
      localObject = ((List)localObject).listIterator();
      while (((Iterator)localObject).hasNext()) {
        if (Util.isNullOrNil(((com.tencent.mm.plugin.fts.a.a.o)((Iterator)localObject).next()).Hsz)) {
          ((Iterator)localObject).remove();
        }
      }
    }
    paramHashSet.tbH = paramm.HtF;
    int i;
    if (hS(paramm.HtF))
    {
      if (hX(paramm.HtF) <= 0) {
        break label225;
      }
      i = 1;
      if (i != 0) {}
    }
    else
    {
      if (fxF() != 4) {
        break label230;
      }
    }
    ArrayList localArrayList;
    label225:
    label230:
    for (boolean bool = true;; bool = false)
    {
      paramHashSet.Huk = bool;
      paramHashSet.FWt = paramm.FWt;
      i = hX(paramm.HtF);
      paramHashSet.HCF = i;
      if ((fxF() == 4) || (i <= 3)) {
        break label246;
      }
      localObject = paramHashSet.tbH;
      int j = hX((List)localObject);
      if (j <= 3) {
        break label246;
      }
      localArrayList = new ArrayList();
      i = 3;
      while (i < j)
      {
        localArrayList.add((com.tencent.mm.plugin.fts.a.a.o)((List)localObject).get(i));
        i += 1;
      }
      i = 0;
      break;
    }
    ((List)localObject).removeAll(localArrayList);
    label246:
    if (hS(paramm.HtF)) {
      this.HwJ.add(paramHashSet);
    }
    paramm = paramm.HtF;
    long l;
    switch (fxF())
    {
    default: 
      i = 0;
      paramHashSet = com.tencent.mm.plugin.report.service.h.OAn;
      l = Util.nowSecond();
      if (!paramm.isEmpty()) {
        break;
      }
    }
    for (paramm = "0";; paramm = "1")
    {
      paramHashSet.b(23903, new Object[] { Integer.valueOf(8), Long.valueOf(l), paramm, Integer.valueOf(i) });
      AppMethodBeat.o(265939);
      return;
      i = 1;
      break;
      i = 3;
      break;
      i = 4;
      break;
    }
  }
  
  public final k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(265940);
    int i = fxF();
    q localq;
    if ((i == 1) || (i == 2))
    {
      localq = new q(paramInt);
      if ((parama instanceof a))
      {
        ((q)localq).HBF = ((a)parama).HCF;
        parama = localq;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(265940);
      return parama;
      ((q)localq).HBF = hX(parama.tbH);
      parama = localq;
      continue;
      parama = new k(paramInt);
    }
  }
  
  public final int getType()
  {
    return 8208;
  }
  
  public static final class a
    extends e.a
  {
    public int HCF = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.l
 * JD-Core Version:    0.7.0.1
 */