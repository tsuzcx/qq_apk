package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public long BMI;
  public int BQA;
  public int BQB;
  public int BQC;
  public int BQD;
  public int BQE;
  public int BQF;
  public int BQG;
  public int BQH;
  public int BQI;
  public int BQJ;
  public int BQK;
  public String BQL;
  public boolean BQM;
  public int BQN;
  public List<Integer> BQO;
  public List<c> BQP;
  public long BQq;
  public long BQs;
  public int BQt;
  public int BQu;
  public int BQv;
  public int BQw;
  public int BQx;
  public int BQy;
  public int BQz;
  public int favCount;
  public String query;
  
  public b()
  {
    AppMethodBeat.i(112145);
    this.BQL = "";
    this.BQs = 0L;
    this.BQM = false;
    this.BQN = 0;
    this.BQO = new ArrayList();
    this.BQP = new ArrayList();
    AppMethodBeat.o(112145);
  }
  
  public final void A(long paramLong, String paramString)
  {
    AppMethodBeat.i(176914);
    c localc = new c();
    localc.position = 1;
    localc.fNO = 28;
    localc.BHT = (System.currentTimeMillis() - this.BMI);
    localc.BHU = (paramLong - this.BMI);
    localc.fND = paramString;
    if (!this.BQP.contains(localc)) {
      this.BQP.add(localc);
    }
    AppMethodBeat.o(176914);
  }
  
  public final void SJ(int paramInt)
  {
    AppMethodBeat.i(112151);
    Log.i("MicroMsg.FTS.FTSSearchStaticsObj", "addClickItemType %s", new Object[] { Integer.valueOf(paramInt) });
    this.BQO.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(112151);
  }
  
  public final void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(112149);
    c localc = new c();
    localc.position = paramInt1;
    localc.fNO = 27;
    localc.BHT = (System.currentTimeMillis() - this.BMI);
    localc.BHU = (paramLong - this.BMI);
    localc.BHV = paramInt2;
    localc.BHW = paramString2;
    localc.fND = paramString1;
    if (!this.BQP.contains(localc)) {
      this.BQP.add(localc);
    }
    AppMethodBeat.o(112149);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112150);
    SJ(l.a(parama));
    AppMethodBeat.o(112150);
  }
  
  public final int erZ()
  {
    int i = this.BQK;
    this.BQK = 2;
    return i;
  }
  
  public final void esa()
  {
    AppMethodBeat.i(112147);
    c localc = new c();
    if ((this.BQF > 0) || (this.BQG > 0)) {}
    for (localc.position = (this.BQJ + 2);; localc.position = (this.BQJ + 1))
    {
      localc.fND = "SOSBar";
      localc.BHU = (System.currentTimeMillis() - this.BMI);
      localc.fNO = 18;
      if (!this.BQP.contains(localc)) {
        this.BQP.add(localc);
      }
      AppMethodBeat.o(112147);
      return;
    }
  }
  
  public final String esb()
  {
    AppMethodBeat.i(112152);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.BQO.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((Integer)localIterator.next()).intValue());
      ((StringBuffer)localObject).append("#");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112152);
    return localObject;
  }
  
  public final String esc()
  {
    AppMethodBeat.i(112153);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.BQP.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.fNO != 0)
      {
        ((StringBuffer)localObject).append(localc.position + localc.index);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.fNO);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.BHT);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.BHU);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112153);
    return localObject;
  }
  
  public final String esd()
  {
    AppMethodBeat.i(112154);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.BQP.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.fNO != 0) && (localc.BHV != 0))
      {
        ((StringBuffer)localObject).append(localc.position);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.fNO);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(localc.BHV);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112154);
    return localObject;
  }
  
  public final String ese()
  {
    AppMethodBeat.i(112155);
    Object localObject = this.BQP.iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      if (localc.fNO == 27)
      {
        localObject = localc.BHW;
        AppMethodBeat.o(112155);
        return localObject;
      }
    }
    AppMethodBeat.o(112155);
    return "";
  }
  
  public final String esf()
  {
    AppMethodBeat.i(112156);
    Object localObject = new StringBuffer();
    if (this.BQt > 0)
    {
      ((StringBuffer)localObject).append(2);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQt);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQu > 0)
    {
      ((StringBuffer)localObject).append(3);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQu);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQv > 0)
    {
      ((StringBuffer)localObject).append(4);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQv);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQw > 0)
    {
      ((StringBuffer)localObject).append(5);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQw);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQx > 0)
    {
      ((StringBuffer)localObject).append(11);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQx);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQy > 0)
    {
      ((StringBuffer)localObject).append(10);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQy);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQA > 0)
    {
      ((StringBuffer)localObject).append(19);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQA);
      ((StringBuffer)localObject).append("|");
    }
    if (this.favCount > 0)
    {
      ((StringBuffer)localObject).append(12);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.favCount);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQB > 0)
    {
      ((StringBuffer)localObject).append(25);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQB);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQC > 0)
    {
      ((StringBuffer)localObject).append(26);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQC);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQD > 0)
    {
      ((StringBuffer)localObject).append(28);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQD);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQE > 0)
    {
      ((StringBuffer)localObject).append(27);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQE);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQI > 0)
    {
      ((StringBuffer)localObject).append(23);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQI);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQH > 0)
    {
      ((StringBuffer)localObject).append(18);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQH);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQF > 0)
    {
      ((StringBuffer)localObject).append(8);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQF);
      ((StringBuffer)localObject).append("|");
    }
    if (this.BQG > 0)
    {
      ((StringBuffer)localObject).append(9);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.BQG);
      ((StringBuffer)localObject).append("|");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112156);
    return localObject;
  }
  
  public final void fi(List<epl> paramList)
  {
    AppMethodBeat.i(190634);
    if ((this.BQF > 0) || (this.BQG > 0)) {}
    for (int i = this.BQJ + 3;; i = this.BQJ + 2)
    {
      int j = 0;
      while (j < paramList.size())
      {
        c localc = new c();
        localc.index = j;
        localc.position = i;
        localc.fND = ("SOSRelevant-" + ((epl)paramList.get(j)).TPZ);
        localc.BHU = (System.currentTimeMillis() - this.BMI);
        localc.fNO = 23;
        if (!this.BQP.contains(localc)) {
          this.BQP.add(localc);
        }
        j += 1;
      }
    }
    AppMethodBeat.o(190634);
  }
  
  public final void hy(int paramInt1, int paramInt2)
  {
    this.BQD = paramInt1;
    this.BQE = paramInt2;
  }
  
  public final void hz(int paramInt1, int paramInt2)
  {
    this.BQI = paramInt1;
    this.BQH = paramInt2;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(112146);
    this.query = "";
    this.BQq = 0L;
    this.BQt = 0;
    this.BQu = 0;
    this.BQv = 0;
    this.BQw = 0;
    this.BQx = 0;
    this.BQy = 0;
    this.favCount = 0;
    this.BQz = 0;
    this.BQA = 0;
    this.BQs = 0L;
    this.BQB = 0;
    this.BQC = 0;
    this.BQD = 0;
    this.BQF = 0;
    this.BQG = 0;
    this.BQE = 0;
    this.BQH = 0;
    this.BQI = 0;
    this.BQJ = 0;
    this.BQP.clear();
    this.BQO.clear();
    AppMethodBeat.o(112146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.b
 * JD-Core Version:    0.7.0.1
 */