package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
{
  long nmW;
  public int nmX;
  public int nmY;
  int nmZ;
  int nnA;
  public int nnB;
  public boolean nnC;
  public String nnD;
  public String nnE;
  int nna;
  public int nnb;
  public int nnc;
  int nnd;
  int nne;
  public int nnf;
  public int nng;
  public int nnh;
  StringBuilder nni;
  StringBuilder nnj;
  StringBuilder nnk;
  StringBuilder nnl;
  int nnm;
  public int nnn;
  public int nno;
  int nnp;
  public int nnq;
  public int nnr;
  public int nns;
  StringBuilder nnt;
  StringBuilder nnu;
  public StringBuilder nnv;
  StringBuilder nnw;
  public StringBuilder nnx;
  public StringBuilder nny;
  public int nnz;
  
  public b()
  {
    AppMethodBeat.i(153245);
    this.nmW = 0L;
    this.nmX = 0;
    this.nni = new StringBuilder();
    this.nnj = new StringBuilder();
    this.nnk = new StringBuilder();
    this.nnl = new StringBuilder();
    this.nnt = new StringBuilder();
    this.nnu = new StringBuilder();
    this.nnv = new StringBuilder();
    this.nnw = new StringBuilder();
    this.nnx = new StringBuilder();
    this.nny = new StringBuilder();
    this.nnD = "";
    this.nnE = "";
    AppMethodBeat.o(153245);
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(153255);
    ad.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportDuplicatedName: %s", new Object[] { parama });
    g.yhR.f(15796, new Object[] { parama.nnG, parama.nnH, parama.nnI.toString(), parama.nnJ.toString(), parama.nnK.toString(), parama.nnL.toString(), parama.nnM.toString() });
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
      if ((localObject2 != null) && (((a)localObject2).mXW != null) && (!bt.isNullOrNil(((a)localObject2).mXW.appId)) && (!bt.isNullOrNil(((a)localObject2).mXW.nickname)))
      {
        if (i >= paramList1.size()) {
          break label341;
        }
        j = 2;
        if (i >= paramList1.size()) {
          break label346;
        }
        k = i - 1;
        ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickName: %s, type: %d, pos: %d", new Object[] { ((a)localObject2).mXW.nickname, Integer.valueOf(j), Integer.valueOf(k) });
        localObject3 = ((a)localObject2).mXW.appId + "," + ((a)localObject2).mXW.hQh + "," + j + "," + k;
        if (!paramList2.containsKey(((a)localObject2).mXW.nickname)) {
          break label361;
        }
        ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains nickName: %s", new Object[] { ((a)localObject2).mXW.nickname });
        localObject4 = (Map)paramList2.get(((a)localObject2).mXW.nickname);
        if (!((Map)localObject4).containsKey(localObject3)) {
          ((Map)localObject4).put(localObject3, localObject2);
        }
        label312:
        if (!bt.isNullOrNil(((a)localObject2).mXW.cmD)) {
          break label425;
        }
        ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not shortNickName");
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
        ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains nickName: %s", new Object[] { ((a)localObject2).mXW.nickname });
        localObject4 = new HashMap();
        ((Map)localObject4).put(localObject3, localObject2);
        paramList2.put(((a)localObject2).mXW.nickname, localObject4);
        break label312;
        label425:
        if (((a)localObject2).mXW.nickname.equals(((a)localObject2).mXW.cmD))
        {
          ad.e("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickname equals shortNickName %s, %s", new Object[] { ((a)localObject2).mXW.nickname, ((a)localObject2).mXW.cmD });
        }
        else if (paramList2.containsKey(((a)localObject2).mXW.cmD))
        {
          ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains shortNickname: %s", new Object[] { ((a)localObject2).mXW.cmD });
          localObject4 = (Map)paramList2.get(((a)localObject2).mXW.cmD);
          if (!((Map)localObject4).containsKey(localObject3)) {
            ((Map)localObject4).put(localObject3, localObject2);
          }
        }
        else
        {
          ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains shortNickname: %s", new Object[] { ((a)localObject2).mXW.cmD });
          localObject4 = new HashMap();
          ((Map)localObject4).put(localObject3, localObject2);
          paramList2.put(((a)localObject2).mXW.cmD, localObject4);
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
        ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated", new Object[] { localObject1 });
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
          if ((localObject5 != null) && (((a)localObject5).mXW != null) && (!bt.isNullOrNil(((a)localObject5).mXW.appId)) && (!((Map)localObject3).containsKey(((a)localObject5).mXW.appId))) {
            ((Map)localObject3).put(((a)localObject5).mXW.appId, localObject5);
          }
        }
        if (((Map)localObject3).size() <= 1)
        {
          ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated2", new Object[] { localObject1 });
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
            i = bt.getInt(arrayOfString[3], 0);
            localObject5 = (a)((Map)localObject2).get(localObject5);
            if ((localObject5 != null) && (((a)localObject5).mXW != null))
            {
              ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo duplicated appId: %s, name: %s, shortName: %s, type: %s, pos: %d", new Object[] { ((a)localObject5).mXW.appId, ((a)localObject5).mXW.nickname, ((a)localObject5).mXW.cmD, localIterator, Integer.valueOf(i) });
              if (((String)localObject1).equals(((a)localObject5).mXW.cmD))
              {
                ((a)localObject3).nnH.append(((a)localObject5).mXW.appId).append("#");
                ((a)localObject3).nnI.append("1#");
                ((a)localObject3).nnJ.append(localIterator).append("#");
                ((a)localObject3).nnK.append(i).append("#");
                ((a)localObject3).nnL.append(((a)localObject5).mXW.aDD).append("#");
                ((a)localObject3).nnM.append(((a)localObject5).mXW.hQh + 1).append("#");
              }
              if (((String)localObject1).equals(((a)localObject5).mXW.nickname))
              {
                ((a)localObject3).nnH.append(((a)localObject5).mXW.appId).append("#");
                ((a)localObject3).nnI.append("2#");
                ((a)localObject3).nnJ.append(localIterator).append("#");
                ((a)localObject3).nnK.append(i).append("#");
                ((a)localObject3).nnL.append(((a)localObject5).mXW.aDD).append("#");
                ((a)localObject3).nnM.append(((a)localObject5).mXW.hQh + 1).append("#");
              }
            }
          }
          a((a)localObject3);
        }
      }
    }
    AppMethodBeat.o(153254);
  }
  
  public final void Q(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(153247);
    this.nnb = paramInt1;
    this.nnn = paramInt2;
    this.nmY = paramInt3;
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153241);
        if (b.this.nmW <= 0L)
        {
          ad.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
          AppMethodBeat.o(153241);
          return;
        }
        ad.i("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime: %s, mRecentCountAtOpen: %s, mRecentCountAtClose: %s, mCloseType: %s, mScrollRecentCount: %s, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %s, mDeleteRecentAppBrandList: %s, \ndragCountWhenClose: %d, mStarCountAtOpen: %d, mStarCountAtClose: %d, mScrollStarCount: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s, \nmMoveToFirstCount: %d, mClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mMoveStarAppBrandToFirstList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s", new Object[] { Long.valueOf(b.this.nmW), Integer.valueOf(b.this.nna), Integer.valueOf(b.this.nnb), Integer.valueOf(b.this.nmY), Integer.valueOf(b.this.nnc), b.this.nni.toString(), Integer.valueOf(b.this.nnd), b.this.nnj.toString(), Integer.valueOf(b.this.nmZ), Integer.valueOf(b.this.nnm), Integer.valueOf(b.this.nnn), Integer.valueOf(b.this.nno), b.this.nnt.toString(), Integer.valueOf(b.this.nnp), b.this.nnu.toString(), Integer.valueOf(b.this.nnq), b.this.nnk.toString(), b.this.nnw.toString(), b.this.nnv.toString(), Integer.valueOf(b.this.nne), b.this.nnl.toString() });
        g.yhR.f(15081, new Object[] { Long.valueOf(b.this.nmW), Integer.valueOf(b.this.nna), Integer.valueOf(b.this.nnb), Integer.valueOf(b.this.nmY), Integer.valueOf(b.this.nnc), b.this.nni.toString(), Integer.valueOf(b.this.nnd), b.this.nnj.toString(), Integer.valueOf(b.this.nmZ), Integer.valueOf(b.this.nnm), Integer.valueOf(b.this.nnn), Integer.valueOf(b.this.nno), b.this.nnt.toString(), Integer.valueOf(b.this.nnp), b.this.nnu.toString(), Integer.valueOf(b.this.nnq), b.this.nnk.toString(), b.this.nnw.toString(), b.this.nnv.toString(), Integer.valueOf(b.this.nne), b.this.nnl.toString() });
        b.a(b.this);
        AppMethodBeat.o(153241);
      }
    });
    AppMethodBeat.o(153247);
  }
  
  public final void VB(String paramString)
  {
    AppMethodBeat.i(153250);
    ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteRecentAppBrand id: %s", new Object[] { paramString });
    this.nnd += 1;
    this.nnj.append(paramString + ":");
    AppMethodBeat.o(153250);
  }
  
  public final void VC(String paramString)
  {
    AppMethodBeat.i(153251);
    ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteStarAppBrand id: %s", new Object[] { paramString });
    this.nnp += 1;
    this.nnu.append(paramString + ":");
    AppMethodBeat.o(153251);
  }
  
  public final void VD(String paramString)
  {
    AppMethodBeat.i(153252);
    ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo addRecentAppBrandToCollection id: %s", new Object[] { paramString });
    this.nne += 1;
    this.nnl.append(paramString + ":");
    AppMethodBeat.o(153252);
  }
  
  public final void bFB()
  {
    this.nmZ += 1;
  }
  
  public final void bFC()
  {
    AppMethodBeat.i(153253);
    this.nnA += 1;
    ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo showSearchView %d", new Object[] { Integer.valueOf(this.nnA) });
    AppMethodBeat.o(153253);
  }
  
  public final void ch(String paramString, int paramInt)
  {
    AppMethodBeat.i(153248);
    ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openRecentAppBrand id: %s, pos: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.nni.append(paramString + ":");
    this.nnk.append(paramInt + ":");
    AppMethodBeat.o(153248);
  }
  
  public final void ci(String paramString, int paramInt)
  {
    AppMethodBeat.i(153249);
    ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openStarAppBrand id: %s, pos: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.nnt.append(paramString + ":");
    this.nnw.append(paramInt + ":");
    AppMethodBeat.o(153249);
  }
  
  public final void eB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153246);
    this.nmW = (System.currentTimeMillis() / 1000L);
    this.nmX = ((int)this.nmW);
    this.nna = paramInt1;
    this.nnm = paramInt2;
    AppMethodBeat.o(153246);
  }
  
  static final class a
  {
    String nnG;
    StringBuilder nnH;
    StringBuilder nnI;
    StringBuilder nnJ;
    StringBuilder nnK;
    StringBuilder nnL;
    StringBuilder nnM;
    
    public a(String paramString)
    {
      AppMethodBeat.i(153243);
      this.nnG = paramString;
      this.nnH = new StringBuilder();
      this.nnI = new StringBuilder();
      this.nnJ = new StringBuilder();
      this.nnK = new StringBuilder();
      this.nnL = new StringBuilder();
      this.nnM = new StringBuilder();
      AppMethodBeat.o(153243);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(153244);
      String str = String.format("DuplicateNameInfo: {duplicatedName: %s, appId: %s, \nnameType: %s, \nlistType: %s, \nposition: %s, \nversion: %s, \nversionType: %s", new Object[] { this.nnG, this.nnH.toString(), this.nnI.toString(), this.nnJ.toString(), this.nnK.toString(), this.nnL.toString(), this.nnM.toString() });
      AppMethodBeat.o(153244);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.b
 * JD-Core Version:    0.7.0.1
 */