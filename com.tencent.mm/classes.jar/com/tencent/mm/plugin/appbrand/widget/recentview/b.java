package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
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
  public int mkA;
  public int mkB;
  int mkC;
  int mkD;
  public int mkE;
  public int mkF;
  int mkG;
  int mkH;
  public int mkI;
  public int mkJ;
  public int mkK;
  StringBuilder mkL;
  StringBuilder mkM;
  StringBuilder mkN;
  StringBuilder mkO;
  int mkP;
  public int mkQ;
  public int mkR;
  int mkS;
  public int mkT;
  public int mkU;
  public int mkV;
  StringBuilder mkW;
  StringBuilder mkX;
  public StringBuilder mkY;
  StringBuilder mkZ;
  long mkz;
  public StringBuilder mla;
  public StringBuilder mlb;
  public int mlc;
  int mld;
  public int mle;
  public boolean mlf;
  public String mlg;
  public String mlh;
  
  public b()
  {
    AppMethodBeat.i(153245);
    this.mkz = 0L;
    this.mkA = 0;
    this.mkL = new StringBuilder();
    this.mkM = new StringBuilder();
    this.mkN = new StringBuilder();
    this.mkO = new StringBuilder();
    this.mkW = new StringBuilder();
    this.mkX = new StringBuilder();
    this.mkY = new StringBuilder();
    this.mkZ = new StringBuilder();
    this.mla = new StringBuilder();
    this.mlb = new StringBuilder();
    this.mlg = "";
    this.mlh = "";
    AppMethodBeat.o(153245);
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(153255);
    ad.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportDuplicatedName: %s", new Object[] { parama });
    com.tencent.mm.plugin.report.service.h.vKh.f(15796, new Object[] { parama.mlj, parama.mlk, parama.mll.toString(), parama.mlm.toString(), parama.mln.toString(), parama.mlo.toString(), parama.mlp.toString() });
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
      if ((localObject2 != null) && (((a)localObject2).lVq != null) && (!bt.isNullOrNil(((a)localObject2).lVq.appId)) && (!bt.isNullOrNil(((a)localObject2).lVq.nickname)))
      {
        if (i >= paramList1.size()) {
          break label341;
        }
        j = 2;
        if (i >= paramList1.size()) {
          break label346;
        }
        k = i - 1;
        ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickName: %s, type: %d, pos: %d", new Object[] { ((a)localObject2).lVq.nickname, Integer.valueOf(j), Integer.valueOf(k) });
        localObject3 = ((a)localObject2).lVq.appId + "," + ((a)localObject2).lVq.gXn + "," + j + "," + k;
        if (!paramList2.containsKey(((a)localObject2).lVq.nickname)) {
          break label361;
        }
        ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains nickName: %s", new Object[] { ((a)localObject2).lVq.nickname });
        localObject4 = (Map)paramList2.get(((a)localObject2).lVq.nickname);
        if (!((Map)localObject4).containsKey(localObject3)) {
          ((Map)localObject4).put(localObject3, localObject2);
        }
        label312:
        if (!bt.isNullOrNil(((a)localObject2).lVq.cfp)) {
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
        ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains nickName: %s", new Object[] { ((a)localObject2).lVq.nickname });
        localObject4 = new HashMap();
        ((Map)localObject4).put(localObject3, localObject2);
        paramList2.put(((a)localObject2).lVq.nickname, localObject4);
        break label312;
        label425:
        if (((a)localObject2).lVq.nickname.equals(((a)localObject2).lVq.cfp))
        {
          ad.e("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickname equals shortNickName %s, %s", new Object[] { ((a)localObject2).lVq.nickname, ((a)localObject2).lVq.cfp });
        }
        else if (paramList2.containsKey(((a)localObject2).lVq.cfp))
        {
          ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains shortNickname: %s", new Object[] { ((a)localObject2).lVq.cfp });
          localObject4 = (Map)paramList2.get(((a)localObject2).lVq.cfp);
          if (!((Map)localObject4).containsKey(localObject3)) {
            ((Map)localObject4).put(localObject3, localObject2);
          }
        }
        else
        {
          ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains shortNickname: %s", new Object[] { ((a)localObject2).lVq.cfp });
          localObject4 = new HashMap();
          ((Map)localObject4).put(localObject3, localObject2);
          paramList2.put(((a)localObject2).lVq.cfp, localObject4);
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
          if ((localObject5 != null) && (((a)localObject5).lVq != null) && (!bt.isNullOrNil(((a)localObject5).lVq.appId)) && (!((Map)localObject3).containsKey(((a)localObject5).lVq.appId))) {
            ((Map)localObject3).put(((a)localObject5).lVq.appId, localObject5);
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
            if ((localObject5 != null) && (((a)localObject5).lVq != null))
            {
              ad.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo duplicated appId: %s, name: %s, shortName: %s, type: %s, pos: %d", new Object[] { ((a)localObject5).lVq.appId, ((a)localObject5).lVq.nickname, ((a)localObject5).lVq.cfp, localIterator, Integer.valueOf(i) });
              if (((String)localObject1).equals(((a)localObject5).lVq.cfp))
              {
                ((a)localObject3).mlk.append(((a)localObject5).lVq.appId).append("#");
                ((a)localObject3).mll.append("1#");
                ((a)localObject3).mlm.append(localIterator).append("#");
                ((a)localObject3).mln.append(i).append("#");
                ((a)localObject3).mlo.append(((a)localObject5).lVq.aAS).append("#");
                ((a)localObject3).mlp.append(((a)localObject5).lVq.gXn + 1).append("#");
              }
              if (((String)localObject1).equals(((a)localObject5).lVq.nickname))
              {
                ((a)localObject3).mlk.append(((a)localObject5).lVq.appId).append("#");
                ((a)localObject3).mll.append("2#");
                ((a)localObject3).mlm.append(localIterator).append("#");
                ((a)localObject3).mln.append(i).append("#");
                ((a)localObject3).mlo.append(((a)localObject5).lVq.aAS).append("#");
                ((a)localObject3).mlp.append(((a)localObject5).lVq.gXn + 1).append("#");
              }
            }
          }
          a((a)localObject3);
        }
      }
    }
    AppMethodBeat.o(153254);
  }
  
  public final void N(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(153247);
    this.mkE = paramInt1;
    this.mkQ = paramInt2;
    this.mkB = paramInt3;
    com.tencent.e.h.Iye.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153241);
        if (b.this.mkz <= 0L)
        {
          ad.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
          AppMethodBeat.o(153241);
          return;
        }
        ad.i("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime: %s, mRecentCountAtOpen: %s, mRecentCountAtClose: %s, mCloseType: %s, mScrollRecentCount: %s, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %s, mDeleteRecentAppBrandList: %s, \ndragCountWhenClose: %d, mStarCountAtOpen: %d, mStarCountAtClose: %d, mScrollStarCount: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s, \nmMoveToFirstCount: %d, mClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mMoveStarAppBrandToFirstList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s", new Object[] { Long.valueOf(b.this.mkz), Integer.valueOf(b.this.mkD), Integer.valueOf(b.this.mkE), Integer.valueOf(b.this.mkB), Integer.valueOf(b.this.mkF), b.this.mkL.toString(), Integer.valueOf(b.this.mkG), b.this.mkM.toString(), Integer.valueOf(b.this.mkC), Integer.valueOf(b.this.mkP), Integer.valueOf(b.this.mkQ), Integer.valueOf(b.this.mkR), b.this.mkW.toString(), Integer.valueOf(b.this.mkS), b.this.mkX.toString(), Integer.valueOf(b.this.mkT), b.this.mkN.toString(), b.this.mkZ.toString(), b.this.mkY.toString(), Integer.valueOf(b.this.mkH), b.this.mkO.toString() });
        com.tencent.mm.plugin.report.service.h.vKh.f(15081, new Object[] { Long.valueOf(b.this.mkz), Integer.valueOf(b.this.mkD), Integer.valueOf(b.this.mkE), Integer.valueOf(b.this.mkB), Integer.valueOf(b.this.mkF), b.this.mkL.toString(), Integer.valueOf(b.this.mkG), b.this.mkM.toString(), Integer.valueOf(b.this.mkC), Integer.valueOf(b.this.mkP), Integer.valueOf(b.this.mkQ), Integer.valueOf(b.this.mkR), b.this.mkW.toString(), Integer.valueOf(b.this.mkS), b.this.mkX.toString(), Integer.valueOf(b.this.mkT), b.this.mkN.toString(), b.this.mkZ.toString(), b.this.mkY.toString(), Integer.valueOf(b.this.mkH), b.this.mkO.toString() });
        b.a(b.this);
        AppMethodBeat.o(153241);
      }
    });
    AppMethodBeat.o(153247);
  }
  
  public final void NV(String paramString)
  {
    AppMethodBeat.i(153250);
    ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteRecentAppBrand id: %s", new Object[] { paramString });
    this.mkG += 1;
    this.mkM.append(paramString + ":");
    AppMethodBeat.o(153250);
  }
  
  public final void NW(String paramString)
  {
    AppMethodBeat.i(153251);
    ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteStarAppBrand id: %s", new Object[] { paramString });
    this.mkS += 1;
    this.mkX.append(paramString + ":");
    AppMethodBeat.o(153251);
  }
  
  public final void NX(String paramString)
  {
    AppMethodBeat.i(153252);
    ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo addRecentAppBrandToCollection id: %s", new Object[] { paramString });
    this.mkH += 1;
    this.mkO.append(paramString + ":");
    AppMethodBeat.o(153252);
  }
  
  public final void bZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(153248);
    ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openRecentAppBrand id: %s, pos: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.mkL.append(paramString + ":");
    this.mkN.append(paramInt + ":");
    AppMethodBeat.o(153248);
  }
  
  public final void buC()
  {
    this.mkC += 1;
  }
  
  public final void buD()
  {
    AppMethodBeat.i(153253);
    this.mld += 1;
    ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo showSearchView %d", new Object[] { Integer.valueOf(this.mld) });
    AppMethodBeat.o(153253);
  }
  
  public final void ca(String paramString, int paramInt)
  {
    AppMethodBeat.i(153249);
    ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openStarAppBrand id: %s, pos: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.mkW.append(paramString + ":");
    this.mkZ.append(paramInt + ":");
    AppMethodBeat.o(153249);
  }
  
  public final void ev(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153246);
    this.mkz = (System.currentTimeMillis() / 1000L);
    this.mkA = ((int)this.mkz);
    this.mkD = paramInt1;
    this.mkP = paramInt2;
    AppMethodBeat.o(153246);
  }
  
  static final class a
  {
    String mlj;
    StringBuilder mlk;
    StringBuilder mll;
    StringBuilder mlm;
    StringBuilder mln;
    StringBuilder mlo;
    StringBuilder mlp;
    
    public a(String paramString)
    {
      AppMethodBeat.i(153243);
      this.mlj = paramString;
      this.mlk = new StringBuilder();
      this.mll = new StringBuilder();
      this.mlm = new StringBuilder();
      this.mln = new StringBuilder();
      this.mlo = new StringBuilder();
      this.mlp = new StringBuilder();
      AppMethodBeat.o(153243);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(153244);
      String str = String.format("DuplicateNameInfo: {duplicatedName: %s, appId: %s, \nnameType: %s, \nlistType: %s, \nposition: %s, \nversion: %s, \nversionType: %s", new Object[] { this.mlj, this.mlk.toString(), this.mll.toString(), this.mlm.toString(), this.mln.toString(), this.mlo.toString(), this.mlp.toString() });
      AppMethodBeat.o(153244);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.b
 * JD-Core Version:    0.7.0.1
 */