package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.protocal.protobuf.dlx;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public int favCount;
  public String query;
  public long tJJ;
  public int tNA;
  public int tNB;
  public String tNC;
  public boolean tND;
  public int tNE;
  public List<Integer> tNF;
  public List<c> tNG;
  public long tNh;
  public long tNj;
  public int tNk;
  public int tNl;
  public int tNm;
  public int tNn;
  public int tNo;
  public int tNp;
  public int tNq;
  public int tNr;
  public int tNs;
  public int tNt;
  public int tNu;
  public int tNv;
  public int tNw;
  public int tNx;
  public int tNy;
  public int tNz;
  
  public b()
  {
    AppMethodBeat.i(112145);
    this.tNC = "";
    this.tNj = 0L;
    this.tND = false;
    this.tNE = 0;
    this.tNF = new ArrayList();
    this.tNG = new ArrayList();
    AppMethodBeat.o(112145);
  }
  
  public final void Hv(int paramInt)
  {
    AppMethodBeat.i(112151);
    ae.i("MicroMsg.FTS.FTSSearchStaticsObj", "addClickItemType %s", new Object[] { Integer.valueOf(paramInt) });
    this.tNF.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(112151);
  }
  
  public final void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(112149);
    c localc = new c();
    localc.position = paramInt1;
    localc.dCw = 27;
    localc.tEZ = (System.currentTimeMillis() - this.tJJ);
    localc.tFa = (paramLong - this.tJJ);
    localc.tFb = paramInt2;
    localc.tFc = paramString2;
    localc.dCl = paramString1;
    if (!this.tNG.contains(localc)) {
      this.tNG.add(localc);
    }
    AppMethodBeat.o(112149);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112150);
    Hv(l.a(parama));
    AppMethodBeat.o(112150);
  }
  
  public final int cWp()
  {
    int i = this.tNB;
    this.tNB = 2;
    return i;
  }
  
  public final void cWq()
  {
    AppMethodBeat.i(112147);
    c localc = new c();
    if ((this.tNw > 0) || (this.tNx > 0)) {}
    for (localc.position = (this.tNA + 2);; localc.position = (this.tNA + 1))
    {
      localc.dCl = "SOSBar";
      localc.tFa = (System.currentTimeMillis() - this.tJJ);
      localc.dCw = 18;
      if (!this.tNG.contains(localc)) {
        this.tNG.add(localc);
      }
      AppMethodBeat.o(112147);
      return;
    }
  }
  
  public final String cWr()
  {
    AppMethodBeat.i(112152);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.tNF.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((Integer)localIterator.next()).intValue());
      ((StringBuffer)localObject).append("#");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112152);
    return localObject;
  }
  
  public final String cWs()
  {
    AppMethodBeat.i(112153);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.tNG.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.dCw != 0)
      {
        ((StringBuffer)localObject).append(localc.position + localc.index);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.dCw);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.tEZ);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.tFa);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112153);
    return localObject;
  }
  
  public final String cWt()
  {
    AppMethodBeat.i(112154);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.tNG.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.dCw != 0) && (localc.tFb != 0))
      {
        ((StringBuffer)localObject).append(localc.position);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.dCw);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.tFb);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112154);
    return localObject;
  }
  
  public final String cWu()
  {
    AppMethodBeat.i(112155);
    Object localObject = this.tNG.iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      if (localc.dCw == 27)
      {
        localObject = localc.tFc;
        AppMethodBeat.o(112155);
        return localObject;
      }
    }
    AppMethodBeat.o(112155);
    return "";
  }
  
  public final String cWv()
  {
    AppMethodBeat.i(112156);
    Object localObject = new StringBuffer();
    if (this.tNk > 0)
    {
      ((StringBuffer)localObject).append(2);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNk);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNl > 0)
    {
      ((StringBuffer)localObject).append(3);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNl);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNm > 0)
    {
      ((StringBuffer)localObject).append(4);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNm);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNn > 0)
    {
      ((StringBuffer)localObject).append(5);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNn);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNo > 0)
    {
      ((StringBuffer)localObject).append(11);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNo);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNp > 0)
    {
      ((StringBuffer)localObject).append(10);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNp);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNr > 0)
    {
      ((StringBuffer)localObject).append(19);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNr);
      ((StringBuffer)localObject).append("|");
    }
    if (this.favCount > 0)
    {
      ((StringBuffer)localObject).append(12);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.favCount);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNs > 0)
    {
      ((StringBuffer)localObject).append(25);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNs);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNt > 0)
    {
      ((StringBuffer)localObject).append(26);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNt);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNu > 0)
    {
      ((StringBuffer)localObject).append(28);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNu);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNv > 0)
    {
      ((StringBuffer)localObject).append(27);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNv);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNz > 0)
    {
      ((StringBuffer)localObject).append(23);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNz);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNy > 0)
    {
      ((StringBuffer)localObject).append(18);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNy);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNw > 0)
    {
      ((StringBuffer)localObject).append(8);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNw);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tNx > 0)
    {
      ((StringBuffer)localObject).append(9);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tNx);
      ((StringBuffer)localObject).append("|");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112156);
    return localObject;
  }
  
  public final void ea(List<dlx> paramList)
  {
    AppMethodBeat.i(194919);
    if ((this.tNw > 0) || (this.tNx > 0)) {}
    for (int i = this.tNA + 3;; i = this.tNA + 2)
    {
      int j = 0;
      while (j < paramList.size())
      {
        c localc = new c();
        localc.index = j;
        localc.position = i;
        localc.dCl = ("SOSRelevant-" + ((dlx)paramList.get(j)).Hvr);
        localc.tFa = (System.currentTimeMillis() - this.tJJ);
        localc.dCw = 23;
        if (!this.tNG.contains(localc)) {
          this.tNG.add(localc);
        }
        j += 1;
      }
    }
    AppMethodBeat.o(194919);
  }
  
  public final void gg(int paramInt1, int paramInt2)
  {
    this.tNu = paramInt1;
    this.tNv = paramInt2;
  }
  
  public final void gh(int paramInt1, int paramInt2)
  {
    this.tNz = paramInt1;
    this.tNy = paramInt2;
  }
  
  public final void p(long paramLong, String paramString)
  {
    AppMethodBeat.i(176914);
    c localc = new c();
    localc.position = 1;
    localc.dCw = 28;
    localc.tEZ = (System.currentTimeMillis() - this.tJJ);
    localc.tFa = (paramLong - this.tJJ);
    localc.dCl = paramString;
    if (!this.tNG.contains(localc)) {
      this.tNG.add(localc);
    }
    AppMethodBeat.o(176914);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(112146);
    this.query = "";
    this.tNh = 0L;
    this.tNk = 0;
    this.tNl = 0;
    this.tNm = 0;
    this.tNn = 0;
    this.tNo = 0;
    this.tNp = 0;
    this.favCount = 0;
    this.tNq = 0;
    this.tNr = 0;
    this.tNj = 0L;
    this.tNs = 0;
    this.tNt = 0;
    this.tNu = 0;
    this.tNw = 0;
    this.tNx = 0;
    this.tNv = 0;
    this.tNy = 0;
    this.tNz = 0;
    this.tNA = 0;
    this.tNG.clear();
    this.tNF.clear();
    AppMethodBeat.o(112146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.b
 * JD-Core Version:    0.7.0.1
 */