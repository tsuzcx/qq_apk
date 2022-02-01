package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
{
  long mMA;
  public int mMB;
  public int mMC;
  int mMD;
  int mME;
  public int mMF;
  public int mMG;
  int mMH;
  int mMI;
  public int mMJ;
  public int mMK;
  public int mML;
  StringBuilder mMM;
  StringBuilder mMN;
  StringBuilder mMO;
  StringBuilder mMP;
  int mMQ;
  public int mMR;
  public int mMS;
  int mMT;
  public int mMU;
  public int mMV;
  public int mMW;
  StringBuilder mMX;
  StringBuilder mMY;
  public StringBuilder mMZ;
  StringBuilder mNa;
  public StringBuilder mNb;
  public StringBuilder mNc;
  public int mNd;
  int mNe;
  public int mNf;
  public boolean mNg;
  public String mNh;
  public String mNi;
  
  public b()
  {
    AppMethodBeat.i(153245);
    this.mMA = 0L;
    this.mMB = 0;
    this.mMM = new StringBuilder();
    this.mMN = new StringBuilder();
    this.mMO = new StringBuilder();
    this.mMP = new StringBuilder();
    this.mMX = new StringBuilder();
    this.mMY = new StringBuilder();
    this.mMZ = new StringBuilder();
    this.mNa = new StringBuilder();
    this.mNb = new StringBuilder();
    this.mNc = new StringBuilder();
    this.mNh = "";
    this.mNi = "";
    AppMethodBeat.o(153245);
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(153255);
    ac.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportDuplicatedName: %s", new Object[] { parama });
    com.tencent.mm.plugin.report.service.h.wUl.f(15796, new Object[] { parama.mNk, parama.mNl, parama.mNm.toString(), parama.mNn.toString(), parama.mNo.toString(), parama.mNp.toString(), parama.mNq.toString() });
    AppMethodBeat.o(153255);
  }
  
  public static void j(List<a> paramList1, List<a> paramList2)
  {
    AppMethodBeat.i(153254);
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
      if ((localObject2 != null) && (((a)localObject2).mxs != null) && (!bs.isNullOrNil(((a)localObject2).mxs.appId)) && (!bs.isNullOrNil(((a)localObject2).mxs.nickname)))
      {
        if (i >= paramList1.size()) {
          break label341;
        }
        j = 2;
        if (i >= paramList1.size()) {
          break label346;
        }
        k = i - 1;
        ac.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickName: %s, type: %d, pos: %d", new Object[] { ((a)localObject2).mxs.nickname, Integer.valueOf(j), Integer.valueOf(k) });
        localObject3 = ((a)localObject2).mxs.appId + "," + ((a)localObject2).mxs.hxM + "," + j + "," + k;
        if (!paramList2.containsKey(((a)localObject2).mxs.nickname)) {
          break label361;
        }
        ac.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains nickName: %s", new Object[] { ((a)localObject2).mxs.nickname });
        localObject4 = (Map)paramList2.get(((a)localObject2).mxs.nickname);
        if (!((Map)localObject4).containsKey(localObject3)) {
          ((Map)localObject4).put(localObject3, localObject2);
        }
        label312:
        if (!bs.isNullOrNil(((a)localObject2).mxs.ccm)) {
          break label425;
        }
        ac.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not shortNickName");
      }
      for (;;)
      {
        i += 1;
        break;
        label341:
        j = 1;
        break label119;
        label346:
        k = i - 1 - paramList1.size();
        break label134;
        label361:
        ac.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains nickName: %s", new Object[] { ((a)localObject2).mxs.nickname });
        localObject4 = new HashMap();
        ((Map)localObject4).put(localObject3, localObject2);
        paramList2.put(((a)localObject2).mxs.nickname, localObject4);
        break label312;
        label425:
        if (((a)localObject2).mxs.nickname.equals(((a)localObject2).mxs.ccm))
        {
          ac.e("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickname equals shortNickName %s, %s", new Object[] { ((a)localObject2).mxs.nickname, ((a)localObject2).mxs.ccm });
        }
        else if (paramList2.containsKey(((a)localObject2).mxs.ccm))
        {
          ac.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains shortNickname: %s", new Object[] { ((a)localObject2).mxs.ccm });
          localObject4 = (Map)paramList2.get(((a)localObject2).mxs.ccm);
          if (!((Map)localObject4).containsKey(localObject3)) {
            ((Map)localObject4).put(localObject3, localObject2);
          }
        }
        else
        {
          ac.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains shortNickname: %s", new Object[] { ((a)localObject2).mxs.ccm });
          localObject4 = new HashMap();
          ((Map)localObject4).put(localObject3, localObject2);
          paramList2.put(((a)localObject2).mxs.ccm, localObject4);
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
        ac.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated", new Object[] { localObject1 });
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
          if ((localObject5 != null) && (((a)localObject5).mxs != null) && (!bs.isNullOrNil(((a)localObject5).mxs.appId)) && (!((Map)localObject3).containsKey(((a)localObject5).mxs.appId))) {
            ((Map)localObject3).put(((a)localObject5).mxs.appId, localObject5);
          }
        }
        if (((Map)localObject3).size() <= 1)
        {
          ac.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated2", new Object[] { localObject1 });
        }
        else
        {
          localObject3 = new a((String)localObject1);
          localObject4 = ((Set)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (String)((Iterator)localObject4).next();
            String[] arrayOfString = ((String)localObject5).split(",");
            localIterator = arrayOfString[2];
            i = bs.getInt(arrayOfString[3], 0);
            localObject5 = (a)((Map)localObject2).get(localObject5);
            if ((localObject5 != null) && (((a)localObject5).mxs != null))
            {
              ac.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo duplicated appId: %s, name: %s, shortName: %s, type: %s, pos: %d", new Object[] { ((a)localObject5).mxs.appId, ((a)localObject5).mxs.nickname, ((a)localObject5).mxs.ccm, localIterator, Integer.valueOf(i) });
              if (((String)localObject1).equals(((a)localObject5).mxs.ccm))
              {
                ((a)localObject3).mNl.append(((a)localObject5).mxs.appId).append("#");
                ((a)localObject3).mNm.append("1#");
                ((a)localObject3).mNn.append(localIterator).append("#");
                ((a)localObject3).mNo.append(i).append("#");
                ((a)localObject3).mNp.append(((a)localObject5).mxs.aBM).append("#");
                ((a)localObject3).mNq.append(((a)localObject5).mxs.hxM + 1).append("#");
              }
              if (((String)localObject1).equals(((a)localObject5).mxs.nickname))
              {
                ((a)localObject3).mNl.append(((a)localObject5).mxs.appId).append("#");
                ((a)localObject3).mNm.append("2#");
                ((a)localObject3).mNn.append(localIterator).append("#");
                ((a)localObject3).mNo.append(i).append("#");
                ((a)localObject3).mNp.append(((a)localObject5).mxs.aBM).append("#");
                ((a)localObject3).mNq.append(((a)localObject5).mxs.hxM + 1).append("#");
              }
            }
          }
          a((a)localObject3);
        }
      }
    }
    AppMethodBeat.o(153254);
  }
  
  public final void O(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(153247);
    this.mMF = paramInt1;
    this.mMR = paramInt2;
    this.mMC = paramInt3;
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153241);
        if (b.this.mMA <= 0L)
        {
          ac.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
          AppMethodBeat.o(153241);
          return;
        }
        ac.i("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime: %s, mRecentCountAtOpen: %s, mRecentCountAtClose: %s, mCloseType: %s, mScrollRecentCount: %s, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %s, mDeleteRecentAppBrandList: %s, \ndragCountWhenClose: %d, mStarCountAtOpen: %d, mStarCountAtClose: %d, mScrollStarCount: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s, \nmMoveToFirstCount: %d, mClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mMoveStarAppBrandToFirstList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s", new Object[] { Long.valueOf(b.this.mMA), Integer.valueOf(b.this.mME), Integer.valueOf(b.this.mMF), Integer.valueOf(b.this.mMC), Integer.valueOf(b.this.mMG), b.this.mMM.toString(), Integer.valueOf(b.this.mMH), b.this.mMN.toString(), Integer.valueOf(b.this.mMD), Integer.valueOf(b.this.mMQ), Integer.valueOf(b.this.mMR), Integer.valueOf(b.this.mMS), b.this.mMX.toString(), Integer.valueOf(b.this.mMT), b.this.mMY.toString(), Integer.valueOf(b.this.mMU), b.this.mMO.toString(), b.this.mNa.toString(), b.this.mMZ.toString(), Integer.valueOf(b.this.mMI), b.this.mMP.toString() });
        com.tencent.mm.plugin.report.service.h.wUl.f(15081, new Object[] { Long.valueOf(b.this.mMA), Integer.valueOf(b.this.mME), Integer.valueOf(b.this.mMF), Integer.valueOf(b.this.mMC), Integer.valueOf(b.this.mMG), b.this.mMM.toString(), Integer.valueOf(b.this.mMH), b.this.mMN.toString(), Integer.valueOf(b.this.mMD), Integer.valueOf(b.this.mMQ), Integer.valueOf(b.this.mMR), Integer.valueOf(b.this.mMS), b.this.mMX.toString(), Integer.valueOf(b.this.mMT), b.this.mMY.toString(), Integer.valueOf(b.this.mMU), b.this.mMO.toString(), b.this.mNa.toString(), b.this.mMZ.toString(), Integer.valueOf(b.this.mMI), b.this.mMP.toString() });
        b.a(b.this);
        AppMethodBeat.o(153241);
      }
    });
    AppMethodBeat.o(153247);
  }
  
  public final void Se(String paramString)
  {
    AppMethodBeat.i(153250);
    ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteRecentAppBrand id: %s", new Object[] { paramString });
    this.mMH += 1;
    this.mMN.append(paramString + ":");
    AppMethodBeat.o(153250);
  }
  
  public final void Sf(String paramString)
  {
    AppMethodBeat.i(153251);
    ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteStarAppBrand id: %s", new Object[] { paramString });
    this.mMT += 1;
    this.mMY.append(paramString + ":");
    AppMethodBeat.o(153251);
  }
  
  public final void Sg(String paramString)
  {
    AppMethodBeat.i(153252);
    ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo addRecentAppBrandToCollection id: %s", new Object[] { paramString });
    this.mMI += 1;
    this.mMP.append(paramString + ":");
    AppMethodBeat.o(153252);
  }
  
  public final void bBA()
  {
    AppMethodBeat.i(153253);
    this.mNe += 1;
    ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo showSearchView %d", new Object[] { Integer.valueOf(this.mNe) });
    AppMethodBeat.o(153253);
  }
  
  public final void bBz()
  {
    this.mMD += 1;
  }
  
  public final void ce(String paramString, int paramInt)
  {
    AppMethodBeat.i(153248);
    ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openRecentAppBrand id: %s, pos: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.mMM.append(paramString + ":");
    this.mMO.append(paramInt + ":");
    AppMethodBeat.o(153248);
  }
  
  public final void cf(String paramString, int paramInt)
  {
    AppMethodBeat.i(153249);
    ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openStarAppBrand id: %s, pos: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.mMX.append(paramString + ":");
    this.mNa.append(paramInt + ":");
    AppMethodBeat.o(153249);
  }
  
  public final void ey(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153246);
    this.mMA = (System.currentTimeMillis() / 1000L);
    this.mMB = ((int)this.mMA);
    this.mME = paramInt1;
    this.mMQ = paramInt2;
    AppMethodBeat.o(153246);
  }
  
  static final class a
  {
    String mNk;
    StringBuilder mNl;
    StringBuilder mNm;
    StringBuilder mNn;
    StringBuilder mNo;
    StringBuilder mNp;
    StringBuilder mNq;
    
    public a(String paramString)
    {
      AppMethodBeat.i(153243);
      this.mNk = paramString;
      this.mNl = new StringBuilder();
      this.mNm = new StringBuilder();
      this.mNn = new StringBuilder();
      this.mNo = new StringBuilder();
      this.mNp = new StringBuilder();
      this.mNq = new StringBuilder();
      AppMethodBeat.o(153243);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(153244);
      String str = String.format("DuplicateNameInfo: {duplicatedName: %s, appId: %s, \nnameType: %s, \nlistType: %s, \nposition: %s, \nversion: %s, \nversionType: %s", new Object[] { this.mNk, this.mNl.toString(), this.mNm.toString(), this.mNn.toString(), this.mNo.toString(), this.mNp.toString(), this.mNq.toString() });
      AppMethodBeat.o(153244);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.b
 * JD-Core Version:    0.7.0.1
 */