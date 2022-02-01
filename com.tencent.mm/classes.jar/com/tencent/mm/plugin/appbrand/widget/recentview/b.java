package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
{
  public int nsA;
  public int nsB;
  public int nsC;
  StringBuilder nsD;
  StringBuilder nsE;
  public StringBuilder nsF;
  StringBuilder nsG;
  public StringBuilder nsH;
  public StringBuilder nsI;
  public int nsJ;
  int nsK;
  public int nsL;
  public boolean nsM;
  public String nsN;
  public String nsO;
  long nsg;
  public int nsh;
  public int nsi;
  int nsj;
  int nsk;
  public int nsl;
  public int nsm;
  int nsn;
  int nso;
  public int nsp;
  public int nsq;
  public int nsr;
  StringBuilder nss;
  StringBuilder nst;
  StringBuilder nsu;
  StringBuilder nsv;
  int nsw;
  public int nsx;
  public int nsy;
  int nsz;
  
  public b()
  {
    AppMethodBeat.i(153245);
    this.nsg = 0L;
    this.nsh = 0;
    this.nss = new StringBuilder();
    this.nst = new StringBuilder();
    this.nsu = new StringBuilder();
    this.nsv = new StringBuilder();
    this.nsD = new StringBuilder();
    this.nsE = new StringBuilder();
    this.nsF = new StringBuilder();
    this.nsG = new StringBuilder();
    this.nsH = new StringBuilder();
    this.nsI = new StringBuilder();
    this.nsN = "";
    this.nsO = "";
    AppMethodBeat.o(153245);
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(153255);
    ae.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportDuplicatedName: %s", new Object[] { parama });
    g.yxI.f(15796, new Object[] { parama.nsQ, parama.nsR, parama.nsS.toString(), parama.nsT.toString(), parama.nsU.toString(), parama.nsV.toString(), parama.nsW.toString() });
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
      if ((localObject2 != null) && (((a)localObject2).ndd != null) && (!bu.isNullOrNil(((a)localObject2).ndd.appId)) && (!bu.isNullOrNil(((a)localObject2).ndd.nickname)))
      {
        if (i >= paramList1.size()) {
          break label341;
        }
        j = 2;
        if (i >= paramList1.size()) {
          break label346;
        }
        k = i - 1;
        ae.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickName: %s, type: %d, pos: %d", new Object[] { ((a)localObject2).ndd.nickname, Integer.valueOf(j), Integer.valueOf(k) });
        localObject3 = ((a)localObject2).ndd.appId + "," + ((a)localObject2).ndd.hSZ + "," + j + "," + k;
        if (!paramList2.containsKey(((a)localObject2).ndd.nickname)) {
          break label361;
        }
        ae.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains nickName: %s", new Object[] { ((a)localObject2).ndd.nickname });
        localObject4 = (Map)paramList2.get(((a)localObject2).ndd.nickname);
        if (!((Map)localObject4).containsKey(localObject3)) {
          ((Map)localObject4).put(localObject3, localObject2);
        }
        label312:
        if (!bu.isNullOrNil(((a)localObject2).ndd.cmF)) {
          break label425;
        }
        ae.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not shortNickName");
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
        ae.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains nickName: %s", new Object[] { ((a)localObject2).ndd.nickname });
        localObject4 = new HashMap();
        ((Map)localObject4).put(localObject3, localObject2);
        paramList2.put(((a)localObject2).ndd.nickname, localObject4);
        break label312;
        label425:
        if (((a)localObject2).ndd.nickname.equals(((a)localObject2).ndd.cmF))
        {
          ae.e("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickname equals shortNickName %s, %s", new Object[] { ((a)localObject2).ndd.nickname, ((a)localObject2).ndd.cmF });
        }
        else if (paramList2.containsKey(((a)localObject2).ndd.cmF))
        {
          ae.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains shortNickname: %s", new Object[] { ((a)localObject2).ndd.cmF });
          localObject4 = (Map)paramList2.get(((a)localObject2).ndd.cmF);
          if (!((Map)localObject4).containsKey(localObject3)) {
            ((Map)localObject4).put(localObject3, localObject2);
          }
        }
        else
        {
          ae.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains shortNickname: %s", new Object[] { ((a)localObject2).ndd.cmF });
          localObject4 = new HashMap();
          ((Map)localObject4).put(localObject3, localObject2);
          paramList2.put(((a)localObject2).ndd.cmF, localObject4);
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
        ae.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated", new Object[] { localObject1 });
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
          if ((localObject5 != null) && (((a)localObject5).ndd != null) && (!bu.isNullOrNil(((a)localObject5).ndd.appId)) && (!((Map)localObject3).containsKey(((a)localObject5).ndd.appId))) {
            ((Map)localObject3).put(((a)localObject5).ndd.appId, localObject5);
          }
        }
        if (((Map)localObject3).size() <= 1)
        {
          ae.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated2", new Object[] { localObject1 });
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
            i = bu.getInt(arrayOfString[3], 0);
            localObject5 = (a)((Map)localObject2).get(localObject5);
            if ((localObject5 != null) && (((a)localObject5).ndd != null))
            {
              ae.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo duplicated appId: %s, name: %s, shortName: %s, type: %s, pos: %d", new Object[] { ((a)localObject5).ndd.appId, ((a)localObject5).ndd.nickname, ((a)localObject5).ndd.cmF, localIterator, Integer.valueOf(i) });
              if (((String)localObject1).equals(((a)localObject5).ndd.cmF))
              {
                ((a)localObject3).nsR.append(((a)localObject5).ndd.appId).append("#");
                ((a)localObject3).nsS.append("1#");
                ((a)localObject3).nsT.append(localIterator).append("#");
                ((a)localObject3).nsU.append(i).append("#");
                ((a)localObject3).nsV.append(((a)localObject5).ndd.aDD).append("#");
                ((a)localObject3).nsW.append(((a)localObject5).ndd.hSZ + 1).append("#");
              }
              if (((String)localObject1).equals(((a)localObject5).ndd.nickname))
              {
                ((a)localObject3).nsR.append(((a)localObject5).ndd.appId).append("#");
                ((a)localObject3).nsS.append("2#");
                ((a)localObject3).nsT.append(localIterator).append("#");
                ((a)localObject3).nsU.append(i).append("#");
                ((a)localObject3).nsV.append(((a)localObject5).ndd.aDD).append("#");
                ((a)localObject3).nsW.append(((a)localObject5).ndd.hSZ + 1).append("#");
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
    this.nsl = paramInt1;
    this.nsx = paramInt2;
    this.nsi = paramInt3;
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153241);
        if (b.this.nsg <= 0L)
        {
          ae.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
          AppMethodBeat.o(153241);
          return;
        }
        ae.i("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime: %s, mRecentCountAtOpen: %s, mRecentCountAtClose: %s, mCloseType: %s, mScrollRecentCount: %s, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %s, mDeleteRecentAppBrandList: %s, \ndragCountWhenClose: %d, mStarCountAtOpen: %d, mStarCountAtClose: %d, mScrollStarCount: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s, \nmMoveToFirstCount: %d, mClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mMoveStarAppBrandToFirstList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s", new Object[] { Long.valueOf(b.this.nsg), Integer.valueOf(b.this.nsk), Integer.valueOf(b.this.nsl), Integer.valueOf(b.this.nsi), Integer.valueOf(b.this.nsm), b.this.nss.toString(), Integer.valueOf(b.this.nsn), b.this.nst.toString(), Integer.valueOf(b.this.nsj), Integer.valueOf(b.this.nsw), Integer.valueOf(b.this.nsx), Integer.valueOf(b.this.nsy), b.this.nsD.toString(), Integer.valueOf(b.this.nsz), b.this.nsE.toString(), Integer.valueOf(b.this.nsA), b.this.nsu.toString(), b.this.nsG.toString(), b.this.nsF.toString(), Integer.valueOf(b.this.nso), b.this.nsv.toString() });
        g.yxI.f(15081, new Object[] { Long.valueOf(b.this.nsg), Integer.valueOf(b.this.nsk), Integer.valueOf(b.this.nsl), Integer.valueOf(b.this.nsi), Integer.valueOf(b.this.nsm), b.this.nss.toString(), Integer.valueOf(b.this.nsn), b.this.nst.toString(), Integer.valueOf(b.this.nsj), Integer.valueOf(b.this.nsw), Integer.valueOf(b.this.nsx), Integer.valueOf(b.this.nsy), b.this.nsD.toString(), Integer.valueOf(b.this.nsz), b.this.nsE.toString(), Integer.valueOf(b.this.nsA), b.this.nsu.toString(), b.this.nsG.toString(), b.this.nsF.toString(), Integer.valueOf(b.this.nso), b.this.nsv.toString() });
        b.a(b.this);
        AppMethodBeat.o(153241);
      }
    });
    AppMethodBeat.o(153247);
  }
  
  public final void Wn(String paramString)
  {
    AppMethodBeat.i(153250);
    ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteRecentAppBrand id: %s", new Object[] { paramString });
    this.nsn += 1;
    this.nst.append(paramString + ":");
    AppMethodBeat.o(153250);
  }
  
  public final void Wo(String paramString)
  {
    AppMethodBeat.i(153251);
    ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteStarAppBrand id: %s", new Object[] { paramString });
    this.nsz += 1;
    this.nsE.append(paramString + ":");
    AppMethodBeat.o(153251);
  }
  
  public final void Wp(String paramString)
  {
    AppMethodBeat.i(153252);
    ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo addRecentAppBrandToCollection id: %s", new Object[] { paramString });
    this.nso += 1;
    this.nsv.append(paramString + ":");
    AppMethodBeat.o(153252);
  }
  
  public final void bGw()
  {
    this.nsj += 1;
  }
  
  public final void bGx()
  {
    AppMethodBeat.i(153253);
    this.nsK += 1;
    ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo showSearchView %d", new Object[] { Integer.valueOf(this.nsK) });
    AppMethodBeat.o(153253);
  }
  
  public final void cl(String paramString, int paramInt)
  {
    AppMethodBeat.i(153248);
    ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openRecentAppBrand id: %s, pos: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.nss.append(paramString + ":");
    this.nsu.append(paramInt + ":");
    AppMethodBeat.o(153248);
  }
  
  public final void cm(String paramString, int paramInt)
  {
    AppMethodBeat.i(153249);
    ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openStarAppBrand id: %s, pos: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.nsD.append(paramString + ":");
    this.nsG.append(paramInt + ":");
    AppMethodBeat.o(153249);
  }
  
  public final void eB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153246);
    this.nsg = (System.currentTimeMillis() / 1000L);
    this.nsh = ((int)this.nsg);
    this.nsk = paramInt1;
    this.nsw = paramInt2;
    AppMethodBeat.o(153246);
  }
  
  static final class a
  {
    String nsQ;
    StringBuilder nsR;
    StringBuilder nsS;
    StringBuilder nsT;
    StringBuilder nsU;
    StringBuilder nsV;
    StringBuilder nsW;
    
    public a(String paramString)
    {
      AppMethodBeat.i(153243);
      this.nsQ = paramString;
      this.nsR = new StringBuilder();
      this.nsS = new StringBuilder();
      this.nsT = new StringBuilder();
      this.nsU = new StringBuilder();
      this.nsV = new StringBuilder();
      this.nsW = new StringBuilder();
      AppMethodBeat.o(153243);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(153244);
      String str = String.format("DuplicateNameInfo: {duplicatedName: %s, appId: %s, \nnameType: %s, \nlistType: %s, \nposition: %s, \nversion: %s, \nversionType: %s", new Object[] { this.nsQ, this.nsR.toString(), this.nsS.toString(), this.nsT.toString(), this.nsU.toString(), this.nsV.toString(), this.nsW.toString() });
      AppMethodBeat.o(153244);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.b
 * JD-Core Version:    0.7.0.1
 */