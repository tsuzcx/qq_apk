package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
{
  int juA;
  StringBuilder juB;
  StringBuilder juC;
  StringBuilder juD;
  StringBuilder juE;
  int juF;
  public int juG;
  public int juH;
  int juI;
  public int juJ;
  public int juK;
  public int juL;
  StringBuilder juM;
  StringBuilder juN;
  public StringBuilder juO;
  StringBuilder juP;
  public StringBuilder juQ;
  public StringBuilder juR;
  public int juS;
  public int juT;
  public int juU;
  public boolean juV;
  long jut;
  public int juu;
  int juv;
  int juw;
  public int jux;
  public int juy;
  int juz;
  
  public b()
  {
    AppMethodBeat.i(114935);
    this.jut = 0L;
    this.juB = new StringBuilder();
    this.juC = new StringBuilder();
    this.juD = new StringBuilder();
    this.juE = new StringBuilder();
    this.juM = new StringBuilder();
    this.juN = new StringBuilder();
    this.juO = new StringBuilder();
    this.juP = new StringBuilder();
    this.juQ = new StringBuilder();
    this.juR = new StringBuilder();
    AppMethodBeat.o(114935);
  }
  
  private static void a(b.a parama)
  {
    AppMethodBeat.i(114944);
    ab.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportDuplicatedName: %s", new Object[] { parama });
    h.qsU.e(15796, new Object[] { parama.juX, parama.juY, parama.juZ.toString(), parama.jva.toString(), parama.jvb.toString(), parama.jvc.toString(), parama.jvd.toString() });
    AppMethodBeat.o(114944);
  }
  
  public static void g(List<a> paramList1, List<a> paramList2)
  {
    AppMethodBeat.i(114943);
    Object localObject1 = new ArrayList();
    ((List)localObject1).addAll(paramList1);
    ((List)localObject1).addAll(paramList2);
    paramList2 = new HashMap();
    int i = 0;
    Object localObject2;
    label119:
    Object localObject3;
    label134:
    Object localObject4;
    if (i < ((List)localObject1).size())
    {
      localObject2 = (a)((List)localObject1).get(i);
      int j;
      int k;
      if ((localObject2 != null) && (((a)localObject2).jfk != null) && (!bo.isNullOrNil(((a)localObject2).jfk.appId)) && (!bo.isNullOrNil(((a)localObject2).jfk.nickname)))
      {
        if (i >= paramList1.size()) {
          break label339;
        }
        j = 2;
        if (i >= paramList1.size()) {
          break label344;
        }
        k = i - 1;
        ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickName: %s, type: %d, pos: %d", new Object[] { ((a)localObject2).jfk.nickname, Integer.valueOf(j), Integer.valueOf(k) });
        localObject3 = ((a)localObject2).jfk.appId + "," + ((a)localObject2).jfk.hcr + "," + j + "," + k;
        if (!paramList2.containsKey(((a)localObject2).jfk.nickname)) {
          break label359;
        }
        ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains nickName: %s", new Object[] { ((a)localObject2).jfk.nickname });
        localObject4 = (Map)paramList2.get(((a)localObject2).jfk.nickname);
        if (!((Map)localObject4).containsKey(localObject3)) {
          ((Map)localObject4).put(localObject3, localObject2);
        }
        label311:
        if (!bo.isNullOrNil(((a)localObject2).jfk.bDi)) {
          break label423;
        }
        ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not shortNickName");
      }
      for (;;)
      {
        i += 1;
        break;
        label339:
        j = 1;
        break label119;
        label344:
        k = i - 1 - paramList1.size();
        break label134;
        label359:
        ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains nickName: %s", new Object[] { ((a)localObject2).jfk.nickname });
        localObject4 = new HashMap();
        ((Map)localObject4).put(localObject3, localObject2);
        paramList2.put(((a)localObject2).jfk.nickname, localObject4);
        break label311;
        label423:
        if (((a)localObject2).jfk.nickname.equals(((a)localObject2).jfk.bDi))
        {
          ab.e("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickname equals shortNickName %s, %s", new Object[] { ((a)localObject2).jfk.nickname, ((a)localObject2).jfk.bDi });
        }
        else if (paramList2.containsKey(((a)localObject2).jfk.bDi))
        {
          ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains shortNickname: %s", new Object[] { ((a)localObject2).jfk.bDi });
          localObject4 = (Map)paramList2.get(((a)localObject2).jfk.bDi);
          if (!((Map)localObject4).containsKey(localObject3)) {
            ((Map)localObject4).put(localObject3, localObject2);
          }
        }
        else
        {
          ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains shortNickname: %s", new Object[] { ((a)localObject2).jfk.bDi });
          localObject4 = new HashMap();
          ((Map)localObject4).put(localObject3, localObject2);
          paramList2.put(((a)localObject2).jfk.bDi, localObject4);
        }
      }
    }
    paramList1 = paramList2.keySet().iterator();
    while (paramList1.hasNext())
    {
      localObject1 = (String)paramList1.next();
      localObject2 = (Map)paramList2.get(localObject1);
      if ((localObject2 == null) || (((Map)localObject2).size() <= 1))
      {
        ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated", new Object[] { localObject1 });
      }
      else
      {
        localObject4 = ((Map)localObject2).keySet();
        localObject3 = new HashMap();
        Iterator localIterator = ((Set)localObject4).iterator();
        Object localObject5;
        while (localIterator.hasNext())
        {
          localObject5 = (a)((Map)localObject2).get((String)localIterator.next());
          if ((localObject5 != null) && (((a)localObject5).jfk != null) && (!bo.isNullOrNil(((a)localObject5).jfk.appId)) && (!((Map)localObject3).containsKey(((a)localObject5).jfk.appId))) {
            ((Map)localObject3).put(((a)localObject5).jfk.appId, localObject5);
          }
        }
        if (((Map)localObject3).size() <= 1)
        {
          ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated2", new Object[] { localObject1 });
        }
        else
        {
          localObject3 = new b.a((String)localObject1);
          localObject4 = ((Set)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (String)((Iterator)localObject4).next();
            String[] arrayOfString = ((String)localObject5).split(",");
            localIterator = arrayOfString[2];
            i = Integer.valueOf(arrayOfString[3]).intValue();
            localObject5 = (a)((Map)localObject2).get(localObject5);
            if ((localObject5 != null) && (((a)localObject5).jfk != null))
            {
              ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo duplicated appId: %s, name: %s, shortName: %s, type: %s, pos: %d", new Object[] { ((a)localObject5).jfk.appId, ((a)localObject5).jfk.nickname, ((a)localObject5).jfk.bDi, localIterator, Integer.valueOf(i) });
              if (((String)localObject1).equals(((a)localObject5).jfk.bDi))
              {
                ((b.a)localObject3).juY.append(((a)localObject5).jfk.appId).append("#");
                ((b.a)localObject3).juZ.append("1#");
                ((b.a)localObject3).jva.append(localIterator).append("#");
                ((b.a)localObject3).jvb.append(i).append("#");
                ((b.a)localObject3).jvc.append(((a)localObject5).jfk.bDc).append("#");
                ((b.a)localObject3).jvd.append(((a)localObject5).jfk.hcr + 1).append("#");
              }
              if (((String)localObject1).equals(((a)localObject5).jfk.nickname))
              {
                ((b.a)localObject3).juY.append(((a)localObject5).jfk.appId).append("#");
                ((b.a)localObject3).juZ.append("2#");
                ((b.a)localObject3).jva.append(localIterator).append("#");
                ((b.a)localObject3).jvb.append(i).append("#");
                ((b.a)localObject3).jvc.append(((a)localObject5).jfk.bDc).append("#");
                ((b.a)localObject3).jvd.append(((a)localObject5).jfk.hcr + 1).append("#");
              }
            }
          }
          a((b.a)localObject3);
        }
      }
    }
    AppMethodBeat.o(114943);
  }
  
  public final void FY(String paramString)
  {
    AppMethodBeat.i(114940);
    ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteRecentAppBrand id: %s", new Object[] { paramString });
    this.juz += 1;
    this.juC.append(paramString + ":");
    AppMethodBeat.o(114940);
  }
  
  public final void FZ(String paramString)
  {
    AppMethodBeat.i(114941);
    ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteStarAppBrand id: %s", new Object[] { paramString });
    this.juI += 1;
    this.juN.append(paramString + ":");
    AppMethodBeat.o(114941);
  }
  
  public final void Ga(String paramString)
  {
    AppMethodBeat.i(114942);
    ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo addRecentAppBrandToCollection id: %s", new Object[] { paramString });
    this.juA += 1;
    this.juE.append(paramString + ":");
    AppMethodBeat.o(114942);
  }
  
  public final void M(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(114937);
    this.jux = paramInt1;
    this.juG = paramInt2;
    this.juu = paramInt3;
    d.ysm.execute(new b.1(this));
    AppMethodBeat.o(114937);
  }
  
  public final void aSh()
  {
    this.juv += 1;
  }
  
  public final void bC(String paramString, int paramInt)
  {
    AppMethodBeat.i(114938);
    ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openRecentAppBrand id: %s, pos: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.juB.append(paramString + ":");
    this.juD.append(paramInt + ":");
    AppMethodBeat.o(114938);
  }
  
  public final void bD(String paramString, int paramInt)
  {
    AppMethodBeat.i(114939);
    ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openStarAppBrand id: %s, pos: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.juM.append(paramString + ":");
    this.juP.append(paramInt + ":");
    AppMethodBeat.o(114939);
  }
  
  public final void dB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114936);
    this.jut = (System.currentTimeMillis() / 1000L);
    this.juw = paramInt1;
    this.juF = paramInt2;
    AppMethodBeat.o(114936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.b
 * JD-Core Version:    0.7.0.1
 */