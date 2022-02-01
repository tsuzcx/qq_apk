package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public int favCount;
  public String query;
  public int tCA;
  public int tCB;
  public int tCC;
  public int tCD;
  public int tCE;
  public int tCF;
  public int tCG;
  public int tCH;
  public int tCI;
  public int tCJ;
  public int tCK;
  public String tCL;
  public boolean tCM;
  public int tCN;
  public List<Integer> tCO;
  public List<c> tCP;
  public long tCq;
  public long tCs;
  public int tCt;
  public int tCu;
  public int tCv;
  public int tCw;
  public int tCx;
  public int tCy;
  public int tCz;
  public long tyS;
  
  public b()
  {
    AppMethodBeat.i(112145);
    this.tCL = "";
    this.tCs = 0L;
    this.tCM = false;
    this.tCN = 0;
    this.tCO = new ArrayList();
    this.tCP = new ArrayList();
    AppMethodBeat.o(112145);
  }
  
  public final void GY(int paramInt)
  {
    AppMethodBeat.i(112151);
    ad.i("MicroMsg.FTS.FTSSearchStaticsObj", "addClickItemType %s", new Object[] { Integer.valueOf(paramInt) });
    this.tCO.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(112151);
  }
  
  public final void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(112149);
    c localc = new c();
    localc.position = paramInt1;
    localc.dBr = 27;
    localc.tui = (System.currentTimeMillis() - this.tyS);
    localc.tuj = (paramLong - this.tyS);
    localc.tuk = paramInt2;
    localc.tul = paramString2;
    localc.dBg = paramString1;
    if (!this.tCP.contains(localc)) {
      this.tCP.add(localc);
    }
    AppMethodBeat.o(112149);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112150);
    GY(l.a(parama));
    AppMethodBeat.o(112150);
  }
  
  public final int cTK()
  {
    int i = this.tCK;
    this.tCK = 2;
    return i;
  }
  
  public final void cTL()
  {
    AppMethodBeat.i(112147);
    c localc = new c();
    if ((this.tCF > 0) || (this.tCG > 0)) {}
    for (localc.position = (this.tCJ + 2);; localc.position = (this.tCJ + 1))
    {
      localc.dBg = "SOSBar";
      localc.tuj = (System.currentTimeMillis() - this.tyS);
      localc.dBr = 18;
      if (!this.tCP.contains(localc)) {
        this.tCP.add(localc);
      }
      AppMethodBeat.o(112147);
      return;
    }
  }
  
  public final String cTM()
  {
    AppMethodBeat.i(112152);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.tCO.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((Integer)localIterator.next()).intValue());
      ((StringBuffer)localObject).append("#");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112152);
    return localObject;
  }
  
  public final String cTN()
  {
    AppMethodBeat.i(112153);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.tCP.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.dBr != 0)
      {
        ((StringBuffer)localObject).append(localc.position + localc.index);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.dBr);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.tui);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.tuj);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112153);
    return localObject;
  }
  
  public final String cTO()
  {
    AppMethodBeat.i(112154);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.tCP.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.dBr != 0) && (localc.tuk != 0))
      {
        ((StringBuffer)localObject).append(localc.position);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.dBr);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.tuk);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112154);
    return localObject;
  }
  
  public final String cTP()
  {
    AppMethodBeat.i(112155);
    Object localObject = this.tCP.iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      if (localc.dBr == 27)
      {
        localObject = localc.tul;
        AppMethodBeat.o(112155);
        return localObject;
      }
    }
    AppMethodBeat.o(112155);
    return "";
  }
  
  public final String cTQ()
  {
    AppMethodBeat.i(112156);
    Object localObject = new StringBuffer();
    if (this.tCt > 0)
    {
      ((StringBuffer)localObject).append(2);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCt);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCu > 0)
    {
      ((StringBuffer)localObject).append(3);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCu);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCv > 0)
    {
      ((StringBuffer)localObject).append(4);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCv);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCw > 0)
    {
      ((StringBuffer)localObject).append(5);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCw);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCx > 0)
    {
      ((StringBuffer)localObject).append(11);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCx);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCy > 0)
    {
      ((StringBuffer)localObject).append(10);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCy);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCA > 0)
    {
      ((StringBuffer)localObject).append(19);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCA);
      ((StringBuffer)localObject).append("|");
    }
    if (this.favCount > 0)
    {
      ((StringBuffer)localObject).append(12);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.favCount);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCB > 0)
    {
      ((StringBuffer)localObject).append(25);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCB);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCC > 0)
    {
      ((StringBuffer)localObject).append(26);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCC);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCD > 0)
    {
      ((StringBuffer)localObject).append(28);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCD);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCE > 0)
    {
      ((StringBuffer)localObject).append(27);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCE);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCI > 0)
    {
      ((StringBuffer)localObject).append(23);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCI);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCH > 0)
    {
      ((StringBuffer)localObject).append(18);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCH);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCF > 0)
    {
      ((StringBuffer)localObject).append(8);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCF);
      ((StringBuffer)localObject).append("|");
    }
    if (this.tCG > 0)
    {
      ((StringBuffer)localObject).append(9);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.tCG);
      ((StringBuffer)localObject).append("|");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112156);
    return localObject;
  }
  
  public final void dW(List<dla> paramList)
  {
    AppMethodBeat.i(219349);
    if ((this.tCF > 0) || (this.tCG > 0)) {}
    for (int i = this.tCJ + 3;; i = this.tCJ + 2)
    {
      int j = 0;
      while (j < paramList.size())
      {
        c localc = new c();
        localc.index = j;
        localc.position = i;
        localc.dBg = ("SOSRelevant-" + ((dla)paramList.get(j)).HbR);
        localc.tuj = (System.currentTimeMillis() - this.tyS);
        localc.dBr = 23;
        if (!this.tCP.contains(localc)) {
          this.tCP.add(localc);
        }
        j += 1;
      }
    }
    AppMethodBeat.o(219349);
  }
  
  public final void gg(int paramInt1, int paramInt2)
  {
    this.tCD = paramInt1;
    this.tCE = paramInt2;
  }
  
  public final void gh(int paramInt1, int paramInt2)
  {
    this.tCI = paramInt1;
    this.tCH = paramInt2;
  }
  
  public final void p(long paramLong, String paramString)
  {
    AppMethodBeat.i(176914);
    c localc = new c();
    localc.position = 1;
    localc.dBr = 28;
    localc.tui = (System.currentTimeMillis() - this.tyS);
    localc.tuj = (paramLong - this.tyS);
    localc.dBg = paramString;
    if (!this.tCP.contains(localc)) {
      this.tCP.add(localc);
    }
    AppMethodBeat.o(176914);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(112146);
    this.query = "";
    this.tCq = 0L;
    this.tCt = 0;
    this.tCu = 0;
    this.tCv = 0;
    this.tCw = 0;
    this.tCx = 0;
    this.tCy = 0;
    this.favCount = 0;
    this.tCz = 0;
    this.tCA = 0;
    this.tCs = 0L;
    this.tCB = 0;
    this.tCC = 0;
    this.tCD = 0;
    this.tCF = 0;
    this.tCG = 0;
    this.tCE = 0;
    this.tCH = 0;
    this.tCI = 0;
    this.tCJ = 0;
    this.tCP.clear();
    this.tCO.clear();
    AppMethodBeat.o(112146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.b
 * JD-Core Version:    0.7.0.1
 */