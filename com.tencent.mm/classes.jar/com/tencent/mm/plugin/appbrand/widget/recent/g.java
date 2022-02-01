package com.tencent.mm.plugin.appbrand.widget.recent;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g
{
  StringBuilder oCA;
  public StringBuilder oCB;
  public StringBuilder oCC;
  public StringBuilder oCD;
  public int oCE;
  int oCF;
  public int oCG;
  public boolean oCH;
  public String oCI;
  public String oCJ;
  long oCb;
  public int oCc;
  public int oCd;
  int oCe;
  int oCf;
  public int oCg;
  int oCh;
  public int oCi;
  public int oCj;
  public int oCk;
  public int oCl;
  public int oCm;
  public StringBuilder oCn;
  public StringBuilder oCo;
  public StringBuilder oCp;
  public StringBuilder oCq;
  int oCr;
  public int oCs;
  int oCt;
  public int oCu;
  int oCv;
  public int oCw;
  public int oCx;
  public StringBuilder oCy;
  public StringBuilder oCz;
  
  public g()
  {
    AppMethodBeat.i(194392);
    this.oCb = 0L;
    this.oCc = 0;
    this.oCn = new StringBuilder();
    this.oCo = new StringBuilder();
    this.oCp = new StringBuilder();
    this.oCq = new StringBuilder();
    this.oCy = new StringBuilder();
    this.oCz = new StringBuilder();
    this.oCA = new StringBuilder();
    this.oCB = new StringBuilder();
    this.oCC = new StringBuilder();
    this.oCD = new StringBuilder();
    this.oCI = "";
    this.oCJ = "";
    AppMethodBeat.o(194392);
  }
  
  public static void k(List<e> paramList1, List<e> paramList2)
  {
    AppMethodBeat.i(194396);
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
      localObject2 = (e)((List)localObject1).get(i);
      int j;
      int k;
      if ((localObject2 != null) && (((e)localObject2).ooj != null) && (!Util.isNullOrNil(((e)localObject2).ooj.appId)) && (!Util.isNullOrNil(((e)localObject2).ooj.nickname)))
      {
        if (i >= paramList1.size()) {
          break label339;
        }
        j = 2;
        if (i >= paramList1.size()) {
          break label344;
        }
        k = i - 1;
        Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickName: %s, type: %d, pos: %d", new Object[] { ((e)localObject2).ooj.nickname, Integer.valueOf(j), Integer.valueOf(k) });
        localObject3 = ((e)localObject2).ooj.appId + "," + ((e)localObject2).ooj.iOo + "," + j + "," + k;
        if (!paramList2.containsKey(((e)localObject2).ooj.nickname)) {
          break label359;
        }
        Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains nickName: %s", new Object[] { ((e)localObject2).ooj.nickname });
        localObject4 = (Map)paramList2.get(((e)localObject2).ooj.nickname);
        if (!((Map)localObject4).containsKey(localObject3)) {
          ((Map)localObject4).put(localObject3, localObject2);
        }
        label311:
        if (!Util.isNullOrNil(((e)localObject2).ooj.cyB)) {
          break label422;
        }
        Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not shortNickName");
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
        Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains nickName: %s", new Object[] { ((e)localObject2).ooj.nickname });
        localObject4 = new HashMap();
        ((Map)localObject4).put(localObject3, localObject2);
        paramList2.put(((e)localObject2).ooj.nickname, localObject4);
        break label311;
        label422:
        if (((e)localObject2).ooj.nickname.equals(((e)localObject2).ooj.cyB))
        {
          Log.e("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickname equals shortNickName %s, %s", new Object[] { ((e)localObject2).ooj.nickname, ((e)localObject2).ooj.cyB });
        }
        else if (paramList2.containsKey(((e)localObject2).ooj.cyB))
        {
          Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains shortNickname: %s", new Object[] { ((e)localObject2).ooj.cyB });
          localObject4 = (Map)paramList2.get(((e)localObject2).ooj.cyB);
          if (!((Map)localObject4).containsKey(localObject3)) {
            ((Map)localObject4).put(localObject3, localObject2);
          }
        }
        else
        {
          Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains shortNickname: %s", new Object[] { ((e)localObject2).ooj.cyB });
          localObject4 = new HashMap();
          ((Map)localObject4).put(localObject3, localObject2);
          paramList2.put(((e)localObject2).ooj.cyB, localObject4);
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
        Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated", new Object[] { localObject1 });
      }
      else
      {
        localObject4 = ((Map)localObject2).keySet();
        localObject3 = new HashMap();
        Iterator localIterator = ((Set)localObject4).iterator();
        Object localObject5;
        while (localIterator.hasNext())
        {
          localObject5 = (e)((Map)localObject2).get((String)localIterator.next());
          if ((localObject5 != null) && (((e)localObject5).ooj != null) && (!Util.isNullOrNil(((e)localObject5).ooj.appId)) && (!((Map)localObject3).containsKey(((e)localObject5).ooj.appId))) {
            ((Map)localObject3).put(((e)localObject5).ooj.appId, localObject5);
          }
        }
        if (((Map)localObject3).size() <= 1)
        {
          Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated2", new Object[] { localObject1 });
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
            i = Util.getInt(arrayOfString[3], 0);
            localObject5 = (e)((Map)localObject2).get(localObject5);
            if ((localObject5 != null) && (((e)localObject5).ooj != null))
            {
              Log.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo duplicated appId: %s, name: %s, shortName: %s, type: %s, pos: %d", new Object[] { ((e)localObject5).ooj.appId, ((e)localObject5).ooj.nickname, ((e)localObject5).ooj.cyB, localIterator, Integer.valueOf(i) });
              if (((String)localObject1).equals(((e)localObject5).ooj.cyB))
              {
                ((a)localObject3).oCM.append(((e)localObject5).ooj.appId).append("#");
                ((a)localObject3).oCN.append("1#");
                ((a)localObject3).oCO.append(localIterator).append("#");
                ((a)localObject3).oCP.append(i).append("#");
                ((a)localObject3).oCQ.append(((e)localObject5).ooj.appVersion).append("#");
                ((a)localObject3).oCR.append(((e)localObject5).ooj.iOo + 1).append("#");
              }
              if (((String)localObject1).equals(((e)localObject5).ooj.nickname))
              {
                ((a)localObject3).oCM.append(((e)localObject5).ooj.appId).append("#");
                ((a)localObject3).oCN.append("2#");
                ((a)localObject3).oCO.append(localIterator).append("#");
                ((a)localObject3).oCP.append(i).append("#");
                ((a)localObject3).oCQ.append(((e)localObject5).ooj.appVersion).append("#");
                ((a)localObject3).oCR.append(((e)localObject5).ooj.iOo + 1).append("#");
              }
            }
          }
          Log.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportDuplicatedName: %s", new Object[] { localObject3 });
          com.tencent.mm.plugin.report.service.h.CyF.a(15796, new Object[] { ((a)localObject3).oCL, ((a)localObject3).oCM, ((a)localObject3).oCN.toString(), ((a)localObject3).oCO.toString(), ((a)localObject3).oCP.toString(), ((a)localObject3).oCQ.toString(), ((a)localObject3).oCR.toString() });
        }
      }
    }
    AppMethodBeat.o(194396);
  }
  
  public final void R(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(194394);
    this.oCg = paramInt1;
    this.oCs = paramInt2;
    this.oCd = paramInt3;
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194388);
        if (g.this.oCb <= 0L)
        {
          Log.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
          AppMethodBeat.o(194388);
          return;
        }
        Log.i("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime: %s, mRecentCountAtOpen: %s, mRecentCountAtClose: %s, mCloseType: %s, mScrollRecentCount: %s, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %s, mDeleteRecentAppBrandList: %s, \ndragCountWhenClose: %d, mStarCountAtOpen: %d, mStarCountAtClose: %d, mScrollStarCount: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s, \nmMoveToFirstCount: %d, mClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mMoveStarAppBrandToFirstList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s", new Object[] { Long.valueOf(g.this.oCb), Integer.valueOf(g.this.oCf), Integer.valueOf(g.this.oCg), Integer.valueOf(g.this.oCd), Integer.valueOf(g.this.oCh), g.this.oCn.toString(), Integer.valueOf(g.this.oCi), g.this.oCo.toString(), Integer.valueOf(g.this.oCe), Integer.valueOf(g.this.oCr), Integer.valueOf(g.this.oCs), Integer.valueOf(g.this.oCt), g.this.oCy.toString(), Integer.valueOf(g.this.oCu), g.this.oCz.toString(), Integer.valueOf(g.this.oCv), g.this.oCp.toString(), g.this.oCB.toString(), g.this.oCA.toString(), Integer.valueOf(g.this.oCj), g.this.oCq.toString() });
        com.tencent.mm.plugin.report.service.h.CyF.a(15081, new Object[] { Long.valueOf(g.this.oCb), Integer.valueOf(g.this.oCf), Integer.valueOf(g.this.oCg), Integer.valueOf(g.this.oCd), Integer.valueOf(g.this.oCh), g.this.oCn.toString(), Integer.valueOf(g.this.oCi), g.this.oCo.toString(), Integer.valueOf(g.this.oCe), Integer.valueOf(g.this.oCr), Integer.valueOf(g.this.oCs), Integer.valueOf(g.this.oCt), g.this.oCy.toString(), Integer.valueOf(g.this.oCu), g.this.oCz.toString(), Integer.valueOf(g.this.oCv), g.this.oCp.toString(), g.this.oCB.toString(), g.this.oCA.toString(), Integer.valueOf(g.this.oCj), g.this.oCq.toString() });
        g.a(g.this);
        AppMethodBeat.o(194388);
      }
    });
    AppMethodBeat.o(194394);
  }
  
  public final void ccT()
  {
    this.oCe += 1;
  }
  
  public final void ccU()
  {
    AppMethodBeat.i(194395);
    this.oCF += 1;
    Log.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo showSearchView %d", new Object[] { Integer.valueOf(this.oCF) });
    AppMethodBeat.o(194395);
  }
  
  public final void eO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194393);
    this.oCb = (System.currentTimeMillis() / 1000L);
    this.oCc = ((int)this.oCb);
    this.oCf = paramInt1;
    this.oCr = paramInt2;
    AppMethodBeat.o(194393);
  }
  
  static final class a
  {
    String oCL;
    StringBuilder oCM;
    StringBuilder oCN;
    StringBuilder oCO;
    StringBuilder oCP;
    StringBuilder oCQ;
    StringBuilder oCR;
    
    public a(String paramString)
    {
      AppMethodBeat.i(194390);
      this.oCL = paramString;
      this.oCM = new StringBuilder();
      this.oCN = new StringBuilder();
      this.oCO = new StringBuilder();
      this.oCP = new StringBuilder();
      this.oCQ = new StringBuilder();
      this.oCR = new StringBuilder();
      AppMethodBeat.o(194390);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(194391);
      String str = String.format("DuplicateNameInfo: {duplicatedName: %s, appId: %s, \nnameType: %s, \nlistType: %s, \nposition: %s, \nversion: %s, \nversionType: %s", new Object[] { this.oCL, this.oCM.toString(), this.oCN.toString(), this.oCO.toString(), this.oCP.toString(), this.oCQ.toString(), this.oCR.toString() });
      AppMethodBeat.o(194391);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.g
 * JD-Core Version:    0.7.0.1
 */