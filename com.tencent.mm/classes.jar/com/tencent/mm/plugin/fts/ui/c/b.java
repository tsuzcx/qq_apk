package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public int favCount;
  public String query;
  public long rty;
  public long rwE;
  public long rwG;
  public int rwH;
  public int rwI;
  public int rwJ;
  public int rwK;
  public int rwL;
  public int rwM;
  public int rwN;
  public int rwO;
  public int rwP;
  public int rwQ;
  public int rwR;
  public int rwS;
  public int rwT;
  public int rwU;
  public int rwV;
  public int rwW;
  public int rwX;
  public int rwY;
  public String rwZ;
  public boolean rxa;
  public int rxb;
  public List<Integer> rxc;
  public List<c> rxd;
  
  public b()
  {
    AppMethodBeat.i(112145);
    this.rwZ = "";
    this.rwG = 0L;
    this.rxa = false;
    this.rxb = 0;
    this.rxc = new ArrayList();
    this.rxd = new ArrayList();
    AppMethodBeat.o(112145);
  }
  
  public final void DN(int paramInt)
  {
    AppMethodBeat.i(112151);
    ad.i("MicroMsg.FTS.FTSSearchStaticsObj", "addClickItemType %s", new Object[] { Integer.valueOf(paramInt) });
    this.rxc.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(112151);
  }
  
  public final void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(112149);
    c localc = new c();
    localc.position = paramInt1;
    localc.drT = 27;
    localc.exposeTime = (System.currentTimeMillis() - this.rty);
    localc.roO = (paramLong - this.rty);
    localc.roP = paramInt2;
    localc.roQ = paramString2;
    localc.drI = paramString1;
    if (!this.rxd.contains(localc)) {
      this.rxd.add(localc);
    }
    AppMethodBeat.o(112149);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112150);
    DN(k.a(parama));
    AppMethodBeat.o(112150);
  }
  
  public final int cyf()
  {
    int i = this.rwY;
    this.rwY = 2;
    return i;
  }
  
  public final void cyg()
  {
    AppMethodBeat.i(112147);
    c localc = new c();
    if ((this.rwT > 0) || (this.rwU > 0)) {}
    for (localc.position = (this.rwX + 2);; localc.position = (this.rwX + 1))
    {
      localc.drI = "SOSBar";
      localc.roO = (System.currentTimeMillis() - this.rty);
      localc.drT = 18;
      if (!this.rxd.contains(localc)) {
        this.rxd.add(localc);
      }
      AppMethodBeat.o(112147);
      return;
    }
  }
  
  public final String cyh()
  {
    AppMethodBeat.i(112152);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.rxc.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((Integer)localIterator.next()).intValue());
      ((StringBuffer)localObject).append("#");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112152);
    return localObject;
  }
  
  public final String cyi()
  {
    AppMethodBeat.i(112153);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.rxd.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.drT != 0)
      {
        ((StringBuffer)localObject).append(localc.position + localc.index);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.drT);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.exposeTime);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.roO);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112153);
    return localObject;
  }
  
  public final String cyj()
  {
    AppMethodBeat.i(112154);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.rxd.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.drT != 0) && (localc.roP != 0))
      {
        ((StringBuffer)localObject).append(localc.position);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.drT);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.roP);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112154);
    return localObject;
  }
  
  public final String cyk()
  {
    AppMethodBeat.i(112155);
    Object localObject = this.rxd.iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      if (localc.drT == 27)
      {
        localObject = localc.roQ;
        AppMethodBeat.o(112155);
        return localObject;
      }
    }
    AppMethodBeat.o(112155);
    return "";
  }
  
  public final String cyl()
  {
    AppMethodBeat.i(112156);
    Object localObject = new StringBuffer();
    if (this.rwH > 0)
    {
      ((StringBuffer)localObject).append(2);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwH);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwI > 0)
    {
      ((StringBuffer)localObject).append(3);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwI);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwJ > 0)
    {
      ((StringBuffer)localObject).append(4);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwJ);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwK > 0)
    {
      ((StringBuffer)localObject).append(5);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwK);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwL > 0)
    {
      ((StringBuffer)localObject).append(11);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwL);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwM > 0)
    {
      ((StringBuffer)localObject).append(10);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwM);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwO > 0)
    {
      ((StringBuffer)localObject).append(19);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwO);
      ((StringBuffer)localObject).append("|");
    }
    if (this.favCount > 0)
    {
      ((StringBuffer)localObject).append(12);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.favCount);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwP > 0)
    {
      ((StringBuffer)localObject).append(25);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwP);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwQ > 0)
    {
      ((StringBuffer)localObject).append(26);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwQ);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwR > 0)
    {
      ((StringBuffer)localObject).append(28);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwR);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwS > 0)
    {
      ((StringBuffer)localObject).append(27);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwS);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwW > 0)
    {
      ((StringBuffer)localObject).append(23);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwW);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwV > 0)
    {
      ((StringBuffer)localObject).append(18);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwV);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwT > 0)
    {
      ((StringBuffer)localObject).append(8);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwT);
      ((StringBuffer)localObject).append("|");
    }
    if (this.rwU > 0)
    {
      ((StringBuffer)localObject).append(9);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.rwU);
      ((StringBuffer)localObject).append("|");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112156);
    return localObject;
  }
  
  public final void dI(List<dab> paramList)
  {
    AppMethodBeat.i(193545);
    if ((this.rwT > 0) || (this.rwU > 0)) {}
    for (int i = this.rwX + 3;; i = this.rwX + 2)
    {
      int j = 0;
      while (j < paramList.size())
      {
        c localc = new c();
        localc.index = j;
        localc.position = i;
        localc.drI = ("SOSRelevant-" + ((dab)paramList.get(j)).DUZ);
        localc.roO = (System.currentTimeMillis() - this.rty);
        localc.drT = 23;
        if (!this.rxd.contains(localc)) {
          this.rxd.add(localc);
        }
        j += 1;
      }
    }
    AppMethodBeat.o(193545);
  }
  
  public final void fJ(int paramInt1, int paramInt2)
  {
    this.rwR = paramInt1;
    this.rwS = paramInt2;
  }
  
  public final void fK(int paramInt1, int paramInt2)
  {
    this.rwW = paramInt1;
    this.rwV = paramInt2;
  }
  
  public final void q(long paramLong, String paramString)
  {
    AppMethodBeat.i(176914);
    c localc = new c();
    localc.position = 1;
    localc.drT = 28;
    localc.exposeTime = (System.currentTimeMillis() - this.rty);
    localc.roO = (paramLong - this.rty);
    localc.drI = paramString;
    if (!this.rxd.contains(localc)) {
      this.rxd.add(localc);
    }
    AppMethodBeat.o(176914);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(112146);
    this.query = "";
    this.rwE = 0L;
    this.rwH = 0;
    this.rwI = 0;
    this.rwJ = 0;
    this.rwK = 0;
    this.rwL = 0;
    this.rwM = 0;
    this.favCount = 0;
    this.rwN = 0;
    this.rwO = 0;
    this.rwG = 0L;
    this.rwP = 0;
    this.rwQ = 0;
    this.rwR = 0;
    this.rwT = 0;
    this.rwU = 0;
    this.rwS = 0;
    this.rwV = 0;
    this.rwW = 0;
    this.rwX = 0;
    this.rxd.clear();
    this.rxc.clear();
    AppMethodBeat.o(112146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.b
 * JD-Core Version:    0.7.0.1
 */