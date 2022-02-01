package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public int favCount;
  public String query;
  public long sCr;
  public int sFA;
  public int sFB;
  public int sFC;
  public int sFD;
  public int sFE;
  public int sFF;
  public int sFG;
  public int sFH;
  public int sFI;
  public int sFJ;
  public int sFK;
  public int sFL;
  public int sFM;
  public int sFN;
  public int sFO;
  public int sFP;
  public int sFQ;
  public String sFR;
  public boolean sFS;
  public int sFT;
  public List<Integer> sFU;
  public List<c> sFV;
  public long sFw;
  public long sFy;
  public int sFz;
  
  public b()
  {
    AppMethodBeat.i(112145);
    this.sFR = "";
    this.sFy = 0L;
    this.sFS = false;
    this.sFT = 0;
    this.sFU = new ArrayList();
    this.sFV = new ArrayList();
    AppMethodBeat.o(112145);
  }
  
  public final void FJ(int paramInt)
  {
    AppMethodBeat.i(112151);
    ac.i("MicroMsg.FTS.FTSSearchStaticsObj", "addClickItemType %s", new Object[] { Integer.valueOf(paramInt) });
    this.sFU.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(112151);
  }
  
  public final void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(112149);
    c localc = new c();
    localc.position = paramInt1;
    localc.dpE = 27;
    localc.sxH = (System.currentTimeMillis() - this.sCr);
    localc.sxI = (paramLong - this.sCr);
    localc.sxJ = paramInt2;
    localc.sxK = paramString2;
    localc.dpt = paramString1;
    if (!this.sFV.contains(localc)) {
      this.sFV.add(localc);
    }
    AppMethodBeat.o(112149);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112150);
    FJ(k.a(parama));
    AppMethodBeat.o(112150);
  }
  
  public final int cLr()
  {
    int i = this.sFQ;
    this.sFQ = 2;
    return i;
  }
  
  public final void cLs()
  {
    AppMethodBeat.i(112147);
    c localc = new c();
    if ((this.sFL > 0) || (this.sFM > 0)) {}
    for (localc.position = (this.sFP + 2);; localc.position = (this.sFP + 1))
    {
      localc.dpt = "SOSBar";
      localc.sxI = (System.currentTimeMillis() - this.sCr);
      localc.dpE = 18;
      if (!this.sFV.contains(localc)) {
        this.sFV.add(localc);
      }
      AppMethodBeat.o(112147);
      return;
    }
  }
  
  public final String cLt()
  {
    AppMethodBeat.i(112152);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.sFU.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((Integer)localIterator.next()).intValue());
      ((StringBuffer)localObject).append("#");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112152);
    return localObject;
  }
  
  public final String cLu()
  {
    AppMethodBeat.i(112153);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.sFV.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.dpE != 0)
      {
        ((StringBuffer)localObject).append(localc.position + localc.index);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.dpE);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.sxH);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.sxI);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112153);
    return localObject;
  }
  
  public final String cLv()
  {
    AppMethodBeat.i(112154);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.sFV.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.dpE != 0) && (localc.sxJ != 0))
      {
        ((StringBuffer)localObject).append(localc.position);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.dpE);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.sxJ);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112154);
    return localObject;
  }
  
  public final String cLw()
  {
    AppMethodBeat.i(112155);
    Object localObject = this.sFV.iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      if (localc.dpE == 27)
      {
        localObject = localc.sxK;
        AppMethodBeat.o(112155);
        return localObject;
      }
    }
    AppMethodBeat.o(112155);
    return "";
  }
  
  public final String cLx()
  {
    AppMethodBeat.i(112156);
    Object localObject = new StringBuffer();
    if (this.sFz > 0)
    {
      ((StringBuffer)localObject).append(2);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFz);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFA > 0)
    {
      ((StringBuffer)localObject).append(3);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFA);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFB > 0)
    {
      ((StringBuffer)localObject).append(4);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFB);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFC > 0)
    {
      ((StringBuffer)localObject).append(5);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFC);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFD > 0)
    {
      ((StringBuffer)localObject).append(11);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFD);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFE > 0)
    {
      ((StringBuffer)localObject).append(10);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFE);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFG > 0)
    {
      ((StringBuffer)localObject).append(19);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFG);
      ((StringBuffer)localObject).append("|");
    }
    if (this.favCount > 0)
    {
      ((StringBuffer)localObject).append(12);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.favCount);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFH > 0)
    {
      ((StringBuffer)localObject).append(25);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFH);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFI > 0)
    {
      ((StringBuffer)localObject).append(26);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFI);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFJ > 0)
    {
      ((StringBuffer)localObject).append(28);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFJ);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFK > 0)
    {
      ((StringBuffer)localObject).append(27);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFK);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFO > 0)
    {
      ((StringBuffer)localObject).append(23);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFO);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFN > 0)
    {
      ((StringBuffer)localObject).append(18);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFN);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFL > 0)
    {
      ((StringBuffer)localObject).append(8);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFL);
      ((StringBuffer)localObject).append("|");
    }
    if (this.sFM > 0)
    {
      ((StringBuffer)localObject).append(9);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.sFM);
      ((StringBuffer)localObject).append("|");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112156);
    return localObject;
  }
  
  public final void dM(List<dfn> paramList)
  {
    AppMethodBeat.i(209772);
    if ((this.sFL > 0) || (this.sFM > 0)) {}
    for (int i = this.sFP + 3;; i = this.sFP + 2)
    {
      int j = 0;
      while (j < paramList.size())
      {
        c localc = new c();
        localc.index = j;
        localc.position = i;
        localc.dpt = ("SOSRelevant-" + ((dfn)paramList.get(j)).FrN);
        localc.sxI = (System.currentTimeMillis() - this.sCr);
        localc.dpE = 23;
        if (!this.sFV.contains(localc)) {
          this.sFV.add(localc);
        }
        j += 1;
      }
    }
    AppMethodBeat.o(209772);
  }
  
  public final void fQ(int paramInt1, int paramInt2)
  {
    this.sFJ = paramInt1;
    this.sFK = paramInt2;
  }
  
  public final void fR(int paramInt1, int paramInt2)
  {
    this.sFO = paramInt1;
    this.sFN = paramInt2;
  }
  
  public final void o(long paramLong, String paramString)
  {
    AppMethodBeat.i(176914);
    c localc = new c();
    localc.position = 1;
    localc.dpE = 28;
    localc.sxH = (System.currentTimeMillis() - this.sCr);
    localc.sxI = (paramLong - this.sCr);
    localc.dpt = paramString;
    if (!this.sFV.contains(localc)) {
      this.sFV.add(localc);
    }
    AppMethodBeat.o(176914);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(112146);
    this.query = "";
    this.sFw = 0L;
    this.sFz = 0;
    this.sFA = 0;
    this.sFB = 0;
    this.sFC = 0;
    this.sFD = 0;
    this.sFE = 0;
    this.favCount = 0;
    this.sFF = 0;
    this.sFG = 0;
    this.sFy = 0L;
    this.sFH = 0;
    this.sFI = 0;
    this.sFJ = 0;
    this.sFL = 0;
    this.sFM = 0;
    this.sFK = 0;
    this.sFN = 0;
    this.sFO = 0;
    this.sFP = 0;
    this.sFV.clear();
    this.sFU.clear();
    AppMethodBeat.o(112146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.b
 * JD-Core Version:    0.7.0.1
 */