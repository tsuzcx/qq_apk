package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.e.b.b;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.e.d;
import com.tencent.mm.plugin.fav.ui.e.e;
import com.tencent.mm.plugin.fav.ui.e.f;
import com.tencent.mm.plugin.fav.ui.e.i;
import com.tencent.mm.plugin.fav.ui.e.j;
import com.tencent.mm.plugin.fav.ui.e.k;
import com.tencent.mm.plugin.fav.ui.e.l;
import com.tencent.mm.plugin.fav.ui.e.m;
import com.tencent.mm.plugin.fav.ui.e.n;
import com.tencent.mm.plugin.fav.ui.e.p;
import com.tencent.mm.plugin.fav.ui.e.q;
import com.tencent.mm.plugin.fav.ui.e.r;
import com.tencent.mm.plugin.fav.ui.e.s;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class b
  extends a
{
  private com.tencent.mm.sdk.b.c jBI;
  public int niJ;
  private boolean qgN;
  public List<com.tencent.mm.plugin.fav.a.g> qgO;
  private List<com.tencent.mm.plugin.fav.a.g> qgP;
  private List<com.tencent.mm.plugin.fav.a.g> qgQ;
  public List<Long> qgR;
  public boolean qgS;
  private Map<String, com.tencent.mm.plugin.fav.a.g> qgT;
  private List<Integer> qgU;
  private List<String> qgV;
  private List<String> qgW;
  private SparseArray<com.tencent.mm.plugin.fav.ui.e.b> qgX;
  private boolean qgY;
  public b.c qgZ;
  public boolean qha;
  public boolean qhb;
  public ListView qhc;
  public String query;
  public int scene;
  
  public b(com.tencent.mm.plugin.fav.ui.o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(107086);
    this.qgN = false;
    this.qgO = new ArrayList();
    this.qgP = new ArrayList();
    this.qgQ = new LinkedList();
    this.qgR = new ArrayList();
    this.qgS = false;
    this.qgT = new TreeMap();
    this.qgU = new ArrayList();
    this.qgV = new LinkedList();
    this.qgW = new LinkedList();
    this.qgX = new SparseArray();
    this.qgY = false;
    this.qha = false;
    this.qhb = false;
    this.query = "";
    this.jBI = new com.tencent.mm.sdk.b.c() {};
    this.type = -1;
    this.qgX.put(1, new com.tencent.mm.plugin.fav.ui.e.o(paramo));
    this.qgX.put(2, new f(paramo));
    this.qgX.put(3, new s(paramo));
    this.qgX.put(4, new r(paramo));
    this.qgX.put(5, new q(paramo));
    this.qgX.put(6, new com.tencent.mm.plugin.fav.ui.e.g(paramo));
    this.qgX.put(7, new i(paramo));
    this.qgX.put(8, new d(paramo));
    this.qgX.put(10, new k(paramo));
    this.qgX.put(12, new n(paramo));
    this.qgX.put(15, new n(paramo));
    this.qgX.put(11, new com.tencent.mm.plugin.fav.ui.e.h(paramo));
    this.qgX.put(14, new l(paramo));
    this.qgX.put(16, new m(paramo));
    this.qgX.put(17, new com.tencent.mm.plugin.fav.ui.e.c(paramo));
    this.qgX.put(18, new j(paramo));
    this.qgX.put(20, new e(paramo));
    this.qgX.put(19, new com.tencent.mm.plugin.fav.ui.e.a(paramo));
    this.qgX.put(-2, new p(paramo));
    if (paramBoolean != this.qha)
    {
      this.qha = paramBoolean;
      if (paramBoolean) {
        this.qgT.clear();
      }
    }
    if (!this.qha) {
      aJq();
    }
    cjq();
    notifyDataSetChanged();
    com.tencent.mm.sdk.b.a.ESL.d(this.jBI);
    com.tencent.mm.sdk.b.a.ESL.c(this.jBI);
    AppMethodBeat.o(107086);
  }
  
  private void cjr()
  {
    AppMethodBeat.i(107090);
    setSubScene(0);
    this.qgR = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cig();
    AppMethodBeat.o(107090);
  }
  
  private boolean cjs()
  {
    AppMethodBeat.i(107092);
    if ((!this.qgV.isEmpty()) || (!this.qgW.isEmpty()) || (!this.qgU.isEmpty()))
    {
      AppMethodBeat.o(107092);
      return true;
    }
    AppMethodBeat.o(107092);
    return false;
  }
  
  private void jdMethod_do(List<com.tencent.mm.plugin.fav.a.g> paramList)
  {
    AppMethodBeat.i(107091);
    if (paramList == null)
    {
      AppMethodBeat.o(107091);
      return;
    }
    ad.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", new Object[] { Integer.valueOf(paramList.size()) });
    ad.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", new Object[] { Integer.valueOf(this.qgQ.size()) });
    paramList.clear();
    AppMethodBeat.o(107091);
  }
  
  private static List<com.tencent.mm.plugin.fav.a.g> l(List<com.tencent.mm.plugin.fav.a.g> paramList, List<Long> paramList1)
  {
    int k = 0;
    AppMethodBeat.i(107089);
    ArrayList localArrayList = new ArrayList();
    if (paramList1 == null)
    {
      AppMethodBeat.o(107089);
      return localArrayList;
    }
    int i = k;
    long l;
    int j;
    if (paramList != null)
    {
      i = k;
      if (paramList.size() > 0)
      {
        localArrayList.addAll(paramList);
        l = ((com.tencent.mm.plugin.fav.a.g)paramList.get(paramList.size() - 1)).field_localId;
        j = 0;
      }
    }
    for (;;)
    {
      i = k;
      if (j < paramList1.size())
      {
        if (Long.valueOf(l).equals(paramList1.get(j))) {
          i = j + 1;
        }
      }
      else
      {
        j = i;
        while ((j < i + 20) && (j < paramList1.size()))
        {
          paramList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(((Long)paramList1.get(j)).longValue());
          if (paramList != null) {
            localArrayList.add(paramList);
          }
          j += 1;
        }
      }
      j += 1;
    }
    AppMethodBeat.o(107089);
    return localArrayList;
  }
  
  private void setSubScene(int paramInt)
  {
    int i = this.niJ;
    if (paramInt == 0) {
      this.niJ = 0;
    }
    do
    {
      return;
      if (i == 0)
      {
        this.niJ = paramInt;
        return;
      }
    } while (i == paramInt);
    this.niJ = 4;
  }
  
  public final com.tencent.mm.plugin.fav.a.g Cr(int paramInt)
  {
    AppMethodBeat.i(107104);
    if ((paramInt < 0) || (paramInt >= this.qgO.size()))
    {
      ad.e("MicroMsg.FavoriteAdapter", "get item, but position error");
      localg = new com.tencent.mm.plugin.fav.a.g();
      AppMethodBeat.o(107104);
      return localg;
    }
    com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)this.qgO.get(paramInt);
    AppMethodBeat.o(107104);
    return localg;
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107108);
    if (paramg == null)
    {
      ad.w("MicroMsg.FavoriteAdapter", "goFavDetail() favItemInfo is null");
      AppMethodBeat.o(107108);
      return;
    }
    if ((!paramg.pZE) || (paramg.pZF == null))
    {
      ad.w("MicroMsg.FavoriteAdapter", "goFavDetail() originInfo not exist");
      AppMethodBeat.o(107108);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramg.pZF;
    String str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.DiR;
    if (!bt.gL((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
      }
    }
    localObject = new agq();
    ((agq)localObject).scene = this.scene;
    ((agq)localObject).niJ = this.niJ;
    ((agq)localObject).query = this.query;
    ((agq)localObject).sessionId = str;
    ((agq)localObject).pZZ = localStringBuilder.toString();
    if (paramView != null) {}
    for (paramView = paramView.getContext();; paramView = aj.getContext())
    {
      paramg.pZF.pZG = paramg.pZG;
      ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, paramg.pZF, (agq)localObject);
      ad.d("MicroMsg.FavoriteAdapter", "goFavDetail type %s %s", new Object[] { Integer.valueOf(paramg.pZF.field_type), paramg.pZG, Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(107108);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107093);
    if (paramBoolean == this.qgS)
    {
      AppMethodBeat.o(107093);
      return;
    }
    this.qgS = paramBoolean;
    com.tencent.mm.plugin.fav.a.g localg;
    if (paramBoolean)
    {
      this.qgT.clear();
      if (paramg != null)
      {
        localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramg.field_localId);
        if (localg != null)
        {
          if (!paramg.pZE) {
            break label103;
          }
          this.qgT.put(paramg.djR, paramg);
        }
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(107093);
      return;
      label103:
      this.qgT.put(bt.dP(Long.valueOf(localg.field_localId)), localg);
    }
  }
  
  public final void aJq()
  {
    AppMethodBeat.i(107088);
    if (cjs())
    {
      ad.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
      AppMethodBeat.o(107088);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.chy())
    {
      ad.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
      AppMethodBeat.o(107088);
      return;
    }
    if (!this.qha) {
      try
      {
        this.lastUpdateTime = com.tencent.mm.plugin.fav.a.b.w(this.lastUpdateTime, this.type);
        AppMethodBeat.o(107088);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.FavoriteAdapter", localException, "", new Object[0]);
        AppMethodBeat.o(107088);
        return;
      }
    }
    this.qgP = l(this.qgO, this.qgR);
    this.qgN = true;
    AppMethodBeat.o(107088);
  }
  
  public final void c(List<Integer> paramList, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(107097);
    setSubScene(0);
    this.qgU.clear();
    if (paramList != null)
    {
      this.qgU.addAll(paramList);
      if (!paramList.isEmpty()) {
        setSubScene(2);
      }
    }
    this.qgV.clear();
    if (paramList1 != null)
    {
      this.qgV.addAll(paramList1);
      if (!paramList1.isEmpty()) {
        setSubScene(3);
      }
    }
    this.qgW.clear();
    if (paramList2 != null)
    {
      this.qgW.addAll(paramList2);
      if (!paramList2.isEmpty()) {
        setSubScene(1);
      }
    }
    this.qgY = true;
    cjq();
    this.qgY = false;
    AppMethodBeat.o(107097);
  }
  
  public final void cjq()
  {
    AppMethodBeat.i(107098);
    ad.v("MicroMsg.FavoriteAdapter", "reset data list beg");
    this.qgN = false;
    jdMethod_do(this.qgP);
    if (!cjs())
    {
      ad.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", new Object[] { Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type) });
      if (!this.qha)
      {
        this.qgP = com.tencent.mm.plugin.fav.a.b.a(this.lastUpdateTime, this.type, this.qgK, this.qgL);
        if ((this.qgP != null) && (this.lastUpdateTime == 0L) && (this.qgP.size() > 0)) {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)this.qgP.get(this.qgP.size() - 1)).field_updateTime;
        }
      }
    }
    int i;
    for (;;)
    {
      if (this.qgP == null)
      {
        ad.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
        this.qgP = new ArrayList();
      }
      if ((!this.qha) && (!cjs()) && (this.qgP.size() < 20) && (!((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().z(this.lastUpdateTime, this.type)))
      {
        ad.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
        aJq();
      }
      this.qgN = true;
      ad.v("MicroMsg.FavoriteAdapter", "reset data list end");
      AppMethodBeat.o(107098);
      return;
      cjr();
      this.qgP = l(null, this.qgR);
      continue;
      ad.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", new Object[] { this.qgV, this.qgW, this.qgU });
      if ((this.qgU == null) || (this.qgU.size() == 1)) {
        break;
      }
      this.qgP = com.tencent.mm.plugin.fav.a.b.a(this.qgV, this.qgW, this.qgU, this.qgQ, this.qgK, this.qgL);
      if (this.qgP != null) {
        break label459;
      }
      i = 0;
      label381:
      com.tencent.mm.plugin.report.service.h.vKh.f(10649, new Object[] { Integer.valueOf(i) });
    }
    if (this.qgU != null) {}
    for (Integer localInteger = (Integer)this.qgU.get(0);; localInteger = null)
    {
      this.qgP = com.tencent.mm.plugin.fav.a.b.a(this.qgV, this.qgW, localInteger.intValue(), this.qgQ, this.qgK, this.qgL);
      break;
      label459:
      i = this.qgP.size();
      break label381;
    }
  }
  
  public final int cjt()
  {
    AppMethodBeat.i(107095);
    int i = this.qgT.size();
    AppMethodBeat.o(107095);
    return i;
  }
  
  public final long cju()
  {
    AppMethodBeat.i(107096);
    Iterator localIterator = this.qgT.values().iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (localg == null) {
        break label67;
      }
      l = localg.field_datatotalsize + l;
    }
    label67:
    for (;;)
    {
      break;
      AppMethodBeat.o(107096);
      return l;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(107087);
    com.tencent.mm.sdk.b.a.ESL.d(this.jBI);
    AppMethodBeat.o(107087);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(107105);
    int i = this.qgO.size();
    AppMethodBeat.o(107105);
    return i + 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(107101);
    if (paramInt == 0)
    {
      AppMethodBeat.o(107101);
      return 0;
    }
    com.tencent.mm.plugin.fav.a.g localg = Cr(paramInt - 1);
    switch (localg.field_type)
    {
    case 9: 
    case 13: 
    default: 
      ad.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", new Object[] { Integer.valueOf(localg.field_type) });
      AppMethodBeat.o(107101);
      return -2;
    }
    paramInt = localg.field_type;
    AppMethodBeat.o(107101);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107103);
    if (paramInt == 0)
    {
      paramView = new View(paramViewGroup.getContext());
      paramView.setLayoutParams(new AbsListView.LayoutParams(0, 0));
      paramView.setBackgroundResource(2131100352);
      paramView.setPadding(0, 0, 0, 0);
      paramView.setEnabled(false);
      AppMethodBeat.o(107103);
      return paramView;
    }
    com.tencent.mm.plugin.fav.a.g localg = Cr(paramInt - 1);
    com.tencent.mm.plugin.fav.ui.e.b localb = (com.tencent.mm.plugin.fav.ui.e.b)this.qgX.get(localg.field_type);
    if (localb == null)
    {
      ad.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", new Object[] { Integer.valueOf(localg.field_type) });
      localb = (com.tencent.mm.plugin.fav.ui.e.b)this.qgX.get(-2);
      cjp();
      paramView = localb.a(paramView, paramViewGroup, localg);
      AppMethodBeat.o(107103);
      return paramView;
    }
    localb.qkC.mUj = cjs();
    localb.qkC.lastUpdateTime = this.lastUpdateTime;
    localb.qkC.qgS = this.qgS;
    localb.qkC.qgT = this.qgT;
    localb.qkC.qkE = this.qgZ;
    localb.qkC.qha = this.qha;
    paramView = localb.a(paramView, paramViewGroup, localg);
    AppMethodBeat.o(107103);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(107102);
    int i = this.qgX.size();
    AppMethodBeat.o(107102);
    return i + 4;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(107099);
    boolean bool = this.qgO.isEmpty();
    AppMethodBeat.o(107099);
    return bool;
  }
  
  public final List<com.tencent.mm.plugin.fav.a.g> kE(boolean paramBoolean)
  {
    AppMethodBeat.i(107094);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.qgT.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (localg != null) {
        localLinkedList.add(localg);
      }
    }
    if (paramBoolean) {
      this.qgT.clear();
    }
    AppMethodBeat.o(107094);
    return localLinkedList;
  }
  
  public final int n(long paramLong, String paramString)
  {
    int i = 1;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(107106);
    Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(107106);
      return -1;
    }
    if (this.qgT.size() >= 30)
    {
      ad.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
      com.tencent.mm.ui.base.h.cf(aj.getContext(), aj.getContext().getResources().getString(2131758927, new Object[] { Integer.valueOf(30) }));
      AppMethodBeat.o(107106);
      return -1;
    }
    com.tencent.mm.plugin.fav.a.g localg;
    if (!bt.isNullOrNil(paramString))
    {
      Iterator localIterator = this.qgO.iterator();
      while (localIterator.hasNext())
      {
        localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
        if (bt.kU(localg.djR, paramString))
        {
          localg.pZF = ((com.tencent.mm.plugin.fav.a.g)localObject);
          localObject = localg;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.qgT.put(paramString, localObject);
        if (((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime < this.lastUpdateTime)
        {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime;
          cjq();
          localObject = this.qgP.iterator();
          i = j;
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label362;
          }
          localg = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next();
          if (bt.isNullOrNil(paramString))
          {
            if (localg.field_localId != paramLong) {
              break label353;
            }
            notifyDataSetChanged();
            AppMethodBeat.o(107106);
            return i;
            this.qgT.put(bt.dP(Long.valueOf(paramLong)), localObject);
            break;
          }
          if ((localg.field_localId == paramLong) && (bt.kU(paramString, localg.djR)))
          {
            notifyDataSetChanged();
            AppMethodBeat.o(107106);
            return i;
          }
          label353:
          i += 1;
        }
        label362:
        notifyDataSetChanged();
      }
      for (;;)
      {
        AppMethodBeat.o(107106);
        return -1;
        localObject = this.qgO.iterator();
        i = k;
        while (((Iterator)localObject).hasNext())
        {
          localg = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next();
          if (bt.isNullOrNil(paramString))
          {
            if (localg.field_localId == paramLong)
            {
              notifyDataSetChanged();
              AppMethodBeat.o(107106);
              return i;
            }
          }
          else if ((localg.field_localId == paramLong) && (bt.kU(paramString, localg.djR)))
          {
            notifyDataSetChanged();
            AppMethodBeat.o(107106);
            return i;
          }
          i += 1;
        }
      }
      i = 0;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(107100);
    ad.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", new Object[] { Boolean.valueOf(this.qgN) });
    if (this.qgN)
    {
      if ((this.qha) && (this.qgP != null) && (this.qgO != null) && (this.qgP.size() == this.qgO.size())) {
        this.qhb = true;
      }
      List localList = this.qgO;
      this.qgO = this.qgP;
      this.qgP = localList;
      this.qgN = false;
    }
    ad.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
    super.notifyDataSetChanged();
    AppMethodBeat.o(107100);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107107);
    paramAdapterView = (b.b)paramView.getTag();
    if (paramAdapterView == null)
    {
      ad.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
      AppMethodBeat.o(107107);
      return;
    }
    if (paramAdapterView.qaS == null)
    {
      ad.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
      AppMethodBeat.o(107107);
      return;
    }
    if ((this.qgS) || (this.qha))
    {
      if ((!paramAdapterView.icb.isChecked()) && (this.qgT.size() >= 30))
      {
        ad.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
        com.tencent.mm.ui.base.h.cf(aj.getContext(), aj.getContext().getResources().getString(2131758927, new Object[] { Integer.valueOf(30) }));
        AppMethodBeat.o(107107);
        return;
      }
      paramView = paramAdapterView.icb;
      if (!paramAdapterView.icb.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        AppMethodBeat.o(107107);
        return;
      }
    }
    com.tencent.mm.plugin.fav.ui.e.b localb = (com.tencent.mm.plugin.fav.ui.e.b)this.qgX.get(paramAdapterView.qaS.field_type);
    StringBuilder localStringBuilder;
    Object localObject;
    String str;
    if (localb != null)
    {
      localStringBuilder = new StringBuilder();
      localObject = paramAdapterView.qaS;
      str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.DiR;
      if (!bt.gL((List)localObject))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
        }
      }
      localObject = new agq();
      ((agq)localObject).scene = this.scene;
      ((agq)localObject).niJ = this.niJ;
      if (this.qhc == null) {
        break label439;
      }
    }
    label439:
    for (((agq)localObject).index = (paramInt - this.qhc.getHeaderViewsCount());; ((agq)localObject).index = paramInt)
    {
      ((agq)localObject).query = this.query;
      ((agq)localObject).sessionId = str;
      ((agq)localObject).pZZ = localStringBuilder.toString();
      localb.a(paramView, (agq)localObject);
      ad.d("MicroMsg.FavoriteAdapter", "item click type %s", new Object[] { Integer.valueOf(paramAdapterView.qaS.field_type) });
      AppMethodBeat.o(107107);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.b
 * JD-Core Version:    0.7.0.1
 */