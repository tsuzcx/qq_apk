package com.tencent.mm.plugin.fts.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.protocal.protobuf.fkk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public long HBX;
  public long HBZ;
  public String HCA;
  public List<e> HCB;
  public int HCa;
  public int HCb;
  public int HCc;
  public int HCd;
  public String HCe;
  public int HCf;
  public String HCg;
  public int HCh;
  public int HCi;
  public int HCj;
  public int HCk;
  public int HCl;
  public int HCm;
  public String HCn;
  public int HCo;
  public int HCp;
  public int HCq;
  public int HCr;
  public int HCs;
  public int HCt;
  public int HCu;
  public int HCv;
  public String HCw;
  public boolean HCx;
  public int HCy;
  public List<Integer> HCz;
  public long HxE;
  public int favCount;
  public String query;
  
  public b()
  {
    AppMethodBeat.i(112145);
    this.HCw = "";
    this.HBZ = 0L;
    this.HCx = false;
    this.HCy = 0;
    this.HCz = new ArrayList();
    this.HCA = "";
    this.HCB = new ArrayList();
    AppMethodBeat.o(112145);
  }
  
  public static String a(e.a parama)
  {
    AppMethodBeat.i(265682);
    if ((parama.tbH != null) && (parama.tbH.size() > 0) && (parama.tbH.get(0) != null))
    {
      parama = ((o)parama.tbH.get(0)).Hsz;
      AppMethodBeat.o(265682);
      return parama;
    }
    AppMethodBeat.o(265682);
    return null;
  }
  
  public final void L(long paramLong, String paramString)
  {
    AppMethodBeat.i(176914);
    long l = cn.bDv();
    e locale = new e();
    locale.position = 1;
    locale.itemType = 28;
    locale.HsA = (l - this.HxE);
    locale.HsF = l;
    locale.HsB = (paramLong - this.HxE);
    locale.hTs = paramString;
    if (!this.HCB.contains(locale)) {
      this.HCB.add(locale);
    }
    AppMethodBeat.o(176914);
  }
  
  public final void Wq(int paramInt)
  {
    AppMethodBeat.i(112151);
    this.HCz.add(Integer.valueOf(paramInt));
    if (paramInt == 31) {
      this.HCA = this.HCg;
    }
    for (;;)
    {
      Log.i("MicroMsg.FTS.FTSSearchStaticsObj", "addClickItemType %s, currentClickUserName %s.", new Object[] { Integer.valueOf(paramInt), this.HCA });
      AppMethodBeat.o(112151);
      return;
      if (paramInt == 5) {
        this.HCA = this.HCe;
      } else if (paramInt == 19) {
        this.HCA = this.HCn;
      }
    }
  }
  
  public final void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(112149);
    long l = cn.bDv();
    e locale = new e();
    locale.position = paramInt1;
    locale.itemType = 27;
    locale.HsA = (l - this.HxE);
    locale.HsF = l;
    locale.HsB = (paramLong - this.HxE);
    locale.HsC = paramInt2;
    locale.HsD = paramString2;
    locale.hTs = paramString1;
    if (!this.HCB.contains(locale)) {
      this.HCB.add(locale);
    }
    AppMethodBeat.o(112149);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112150);
    Wq(l.a(parama));
    AppMethodBeat.o(112150);
  }
  
  public final int fyX()
  {
    int i = this.HCv;
    this.HCv = 2;
    return i;
  }
  
  public final void fyY()
  {
    AppMethodBeat.i(112147);
    e locale = new e();
    if ((this.HCq > 0) || (this.HCr > 0)) {}
    for (locale.position = (this.HCu + 2);; locale.position = (this.HCu + 1))
    {
      locale.hTs = "SOSBar";
      locale.HsB = (System.currentTimeMillis() - this.HxE);
      locale.itemType = 18;
      if (!this.HCB.contains(locale)) {
        this.HCB.add(locale);
      }
      AppMethodBeat.o(112147);
      return;
    }
  }
  
  public final String fyZ()
  {
    AppMethodBeat.i(112152);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.HCz.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((Integer)localIterator.next()).intValue());
      ((StringBuffer)localObject).append("#");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112152);
    return localObject;
  }
  
  public final String fza()
  {
    AppMethodBeat.i(112153);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.HCB.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (locale.itemType != 0)
      {
        ((StringBuffer)localObject).append(locale.position + locale.index);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(locale.itemType);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(locale.HsA);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(locale.HsB);
        if ((!c.hm(locale.HsE)) && ((locale.itemType == 31) || (locale.HsC == 31) || (locale.itemType == 19) || (locale.HsC == 19) || (locale.itemType == 5) || (locale.HsC == 5)))
        {
          ((StringBuffer)localObject).append("#");
          ((StringBuffer)localObject).append(locale.HsE);
        }
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(locale.HsF);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112153);
    return localObject;
  }
  
  public final String fzb()
  {
    AppMethodBeat.i(112154);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.HCB.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if ((locale.itemType != 0) && (locale.HsC != 0))
      {
        ((StringBuffer)localObject).append(locale.position);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(locale.itemType);
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(locale.HsC);
        ((StringBuffer)localObject).append("|");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112154);
    return localObject;
  }
  
  public final String fzc()
  {
    AppMethodBeat.i(112155);
    Object localObject = this.HCB.iterator();
    while (((Iterator)localObject).hasNext())
    {
      e locale = (e)((Iterator)localObject).next();
      if (locale.itemType == 27)
      {
        localObject = locale.HsD;
        AppMethodBeat.o(112155);
        return localObject;
      }
    }
    AppMethodBeat.o(112155);
    return "";
  }
  
  public final String fzd()
  {
    AppMethodBeat.i(112156);
    Object localObject = new StringBuffer();
    if (this.HCa > 0)
    {
      ((StringBuffer)localObject).append(2);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCa);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCb > 0)
    {
      ((StringBuffer)localObject).append(3);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCb);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCc > 0)
    {
      ((StringBuffer)localObject).append(4);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCc);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCd > 0)
    {
      ((StringBuffer)localObject).append(5);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCd);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCh > 0)
    {
      ((StringBuffer)localObject).append(11);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCh);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCi > 0)
    {
      ((StringBuffer)localObject).append(10);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCi);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCk > 0)
    {
      ((StringBuffer)localObject).append(19);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCk);
      ((StringBuffer)localObject).append("|");
    }
    if (this.favCount > 0)
    {
      ((StringBuffer)localObject).append(12);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.favCount);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCl > 0)
    {
      ((StringBuffer)localObject).append(25);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCl);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCf > 0)
    {
      ((StringBuffer)localObject).append(31);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCf);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCm > 0)
    {
      ((StringBuffer)localObject).append(26);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCm);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCo > 0)
    {
      ((StringBuffer)localObject).append(28);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCo);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCp > 0)
    {
      ((StringBuffer)localObject).append(27);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCp);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCt > 0)
    {
      ((StringBuffer)localObject).append(23);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCt);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCs > 0)
    {
      ((StringBuffer)localObject).append(18);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCs);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCq > 0)
    {
      ((StringBuffer)localObject).append(8);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCq);
      ((StringBuffer)localObject).append("|");
    }
    if (this.HCr > 0)
    {
      ((StringBuffer)localObject).append(9);
      ((StringBuffer)localObject).append("#");
      ((StringBuffer)localObject).append(this.HCr);
      ((StringBuffer)localObject).append("|");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(112156);
    return localObject;
  }
  
  public final void hW(List<fkk> paramList)
  {
    AppMethodBeat.i(265711);
    if ((this.HCq > 0) || (this.HCr > 0)) {}
    for (int i = this.HCu + 3;; i = this.HCu + 2)
    {
      int j = 0;
      while (j < paramList.size())
      {
        e locale = new e();
        locale.index = j;
        locale.position = i;
        locale.hTs = ("SOSRelevant-" + ((fkk)paramList.get(j)).abgw);
        locale.HsB = (System.currentTimeMillis() - this.HxE);
        locale.itemType = 23;
        if (!this.HCB.contains(locale)) {
          this.HCB.add(locale);
        }
        j += 1;
      }
    }
    AppMethodBeat.o(265711);
  }
  
  public final void iX(int paramInt1, int paramInt2)
  {
    this.HCo = paramInt1;
    this.HCp = paramInt2;
  }
  
  public final void iY(int paramInt1, int paramInt2)
  {
    this.HCt = paramInt1;
    this.HCs = paramInt2;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(112146);
    this.query = "";
    this.HBX = 0L;
    this.HCa = 0;
    this.HCb = 0;
    this.HCc = 0;
    this.HCd = 0;
    this.HCh = 0;
    this.HCi = 0;
    this.favCount = 0;
    this.HCj = 0;
    this.HCk = 0;
    this.HBZ = 0L;
    this.HCl = 0;
    this.HCm = 0;
    this.HCo = 0;
    this.HCq = 0;
    this.HCr = 0;
    this.HCp = 0;
    this.HCs = 0;
    this.HCt = 0;
    this.HCu = 0;
    this.HCB.clear();
    this.HCz.clear();
    this.HCe = "";
    this.HCg = "";
    this.HCn = "";
    this.HCA = "";
    AppMethodBeat.o(112146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.b
 * JD-Core Version:    0.7.0.1
 */