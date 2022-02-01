package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public int favCount;
  public String query;
  public long xaI;
  public int xeA;
  public int xeB;
  public String xeC;
  public boolean xeD;
  public int xeE;
  public List<Integer> xeF;
  public List<c> xeG;
  public long xeh;
  public long xej;
  public int xek;
  public int xel;
  public int xem;
  public int xen;
  public int xeo;
  public int xep;
  public int xeq;
  public int xer;
  public int xes;
  public int xet;
  public int xeu;
  public int xev;
  public int xew;
  public int xex;
  public int xey;
  public int xez;
  
  public b()
  {
    AppMethodBeat.i(112145);
    this.xeC = "";
    this.xej = 0L;
    this.xeD = false;
    this.xeE = 0;
    this.xeF = new ArrayList();
    this.xeG = new ArrayList();
    AppMethodBeat.o(112145);
  }
  
  public final void Nv(int paramInt)
  {
    AppMethodBeat.i(112151);
    Log.i("MicroMsg.FTS.FTSSearchStaticsObj", "addClickItemType %s", new Object[] { Integer.valueOf(paramInt) });
    this.xeF.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(112151);
  }
  
  public final void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(112149);
    c localc = new c();
    localc.position = paramInt1;
    localc.dUm = 27;
    localc.wVY = (System.currentTimeMillis() - this.xaI);
    localc.wVZ = (paramLong - this.xaI);
    localc.wWa = paramInt2;
    localc.wWb = paramString2;
    localc.dUb = paramString1;
    if (!this.xeG.contains(localc)) {
      this.xeG.add(localc);
    }
    AppMethodBeat.o(112149);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112150);
    Nv(l.a(parama));
    AppMethodBeat.o(112150);
  }
  
  public final int dPA()
  {
    int i = this.xeB;
    this.xeB = 2;
    return i;
  }
  
  public final void dPB()
  {
    AppMethodBeat.i(112147);
    c localc = new c();
    if ((this.xew > 0) || (this.xex > 0)) {}
    for (localc.position = (this.xeA + 2);; localc.position = (this.xeA + 1))
    {
      localc.dUb = "SOSBar";
      localc.wVZ = (System.currentTimeMillis() - this.xaI);
      localc.dUm = 18;
      if (!this.xeG.contains(localc)) {
        this.xeG.add(localc);
      }
      AppMethodBeat.o(112147);
      return;
    }
  }
  
  public final String dPC()
  {
    AppMethodBeat.i(112152);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.xeF.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((Integer)localIterator.next()).intValue());
      ((StringBuffer)localObject).append("#");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112152);
    return localObject;
  }
  
  public final String dPD()
  {
    AppMethodBeat.i(112153);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.xeG.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.dUm != 0)
      {
        ((StringBuffer)localObject).append(localc.position + localc.index);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.dUm);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.wVY);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.wVZ);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112153);
    return localObject;
  }
  
  public final String dPE()
  {
    AppMethodBeat.i(112154);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.xeG.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.dUm != 0) && (localc.wWa != 0))
      {
        ((StringBuffer)localObject).append(localc.position);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.dUm);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.wWa);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112154);
    return localObject;
  }
  
  public final String dPF()
  {
    AppMethodBeat.i(112155);
    Object localObject = this.xeG.iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      if (localc.dUm == 27)
      {
        localObject = localc.wWb;
        AppMethodBeat.o(112155);
        return localObject;
      }
    }
    AppMethodBeat.o(112155);
    return "";
  }
  
  public final String dPG()
  {
    AppMethodBeat.i(112156);
    Object localObject = new StringBuffer();
    if (this.xek > 0)
    {
      ((StringBuffer)localObject).append(2);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xek);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xel > 0)
    {
      ((StringBuffer)localObject).append(3);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xel);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xem > 0)
    {
      ((StringBuffer)localObject).append(4);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xem);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xen > 0)
    {
      ((StringBuffer)localObject).append(5);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xen);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xeo > 0)
    {
      ((StringBuffer)localObject).append(11);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xeo);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xep > 0)
    {
      ((StringBuffer)localObject).append(10);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xep);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xer > 0)
    {
      ((StringBuffer)localObject).append(19);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xer);
      ((StringBuffer)localObject).append("|");
    }
    if (this.favCount > 0)
    {
      ((StringBuffer)localObject).append(12);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.favCount);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xes > 0)
    {
      ((StringBuffer)localObject).append(25);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xes);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xet > 0)
    {
      ((StringBuffer)localObject).append(26);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xet);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xeu > 0)
    {
      ((StringBuffer)localObject).append(28);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xeu);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xev > 0)
    {
      ((StringBuffer)localObject).append(27);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xev);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xez > 0)
    {
      ((StringBuffer)localObject).append(23);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xez);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xey > 0)
    {
      ((StringBuffer)localObject).append(18);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xey);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xew > 0)
    {
      ((StringBuffer)localObject).append(8);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xew);
      ((StringBuffer)localObject).append("|");
    }
    if (this.xex > 0)
    {
      ((StringBuffer)localObject).append(9);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.xex);
      ((StringBuffer)localObject).append("|");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112156);
    return localObject;
  }
  
  public final void eS(List<efk> paramList)
  {
    AppMethodBeat.i(235409);
    if ((this.xew > 0) || (this.xex > 0)) {}
    for (int i = this.xeA + 3;; i = this.xeA + 2)
    {
      int j = 0;
      while (j < paramList.size())
      {
        c localc = new c();
        localc.index = j;
        localc.position = i;
        localc.dUb = ("SOSRelevant-" + ((efk)paramList.get(j)).MEq);
        localc.wVZ = (System.currentTimeMillis() - this.xaI);
        localc.dUm = 23;
        if (!this.xeG.contains(localc)) {
          this.xeG.add(localc);
        }
        j += 1;
      }
    }
    AppMethodBeat.o(235409);
  }
  
  public final void gF(int paramInt1, int paramInt2)
  {
    this.xeu = paramInt1;
    this.xev = paramInt2;
  }
  
  public final void gG(int paramInt1, int paramInt2)
  {
    this.xez = paramInt1;
    this.xey = paramInt2;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(112146);
    this.query = "";
    this.xeh = 0L;
    this.xek = 0;
    this.xel = 0;
    this.xem = 0;
    this.xen = 0;
    this.xeo = 0;
    this.xep = 0;
    this.favCount = 0;
    this.xeq = 0;
    this.xer = 0;
    this.xej = 0L;
    this.xes = 0;
    this.xet = 0;
    this.xeu = 0;
    this.xew = 0;
    this.xex = 0;
    this.xev = 0;
    this.xey = 0;
    this.xez = 0;
    this.xeA = 0;
    this.xeG.clear();
    this.xeF.clear();
    AppMethodBeat.o(112146);
  }
  
  public final void t(long paramLong, String paramString)
  {
    AppMethodBeat.i(176914);
    c localc = new c();
    localc.position = 1;
    localc.dUm = 28;
    localc.wVY = (System.currentTimeMillis() - this.xaI);
    localc.wVZ = (paramLong - this.xaI);
    localc.dUb = paramString;
    if (!this.xeG.contains(localc)) {
      this.xeG.add(localc);
    }
    AppMethodBeat.o(176914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.b
 * JD-Core Version:    0.7.0.1
 */