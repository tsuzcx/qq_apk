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
import com.tencent.mm.g.a.mf;
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
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akq;
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
  private com.tencent.mm.sdk.b.c kwD;
  public int ooi;
  public String query;
  public b.c rzA;
  public boolean rzB;
  public boolean rzC;
  public ListView rzD;
  private boolean rzo;
  public List<com.tencent.mm.plugin.fav.a.g> rzp;
  private List<com.tencent.mm.plugin.fav.a.g> rzq;
  private List<com.tencent.mm.plugin.fav.a.g> rzr;
  public List<Long> rzs;
  public boolean rzt;
  private Map<String, com.tencent.mm.plugin.fav.a.g> rzu;
  private List<Integer> rzv;
  private List<String> rzw;
  private List<String> rzx;
  private SparseArray<com.tencent.mm.plugin.fav.ui.e.b> rzy;
  private boolean rzz;
  public int scene;
  
  public b(com.tencent.mm.plugin.fav.ui.o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(107086);
    this.rzo = false;
    this.rzp = new ArrayList();
    this.rzq = new ArrayList();
    this.rzr = new LinkedList();
    this.rzs = new ArrayList();
    this.rzt = false;
    this.rzu = new TreeMap();
    this.rzv = new ArrayList();
    this.rzw = new LinkedList();
    this.rzx = new LinkedList();
    this.rzy = new SparseArray();
    this.rzz = false;
    this.rzB = false;
    this.rzC = false;
    this.query = "";
    this.kwD = new com.tencent.mm.sdk.b.c() {};
    this.type = -1;
    this.rzy.put(1, new com.tencent.mm.plugin.fav.ui.e.o(paramo));
    this.rzy.put(2, new f(paramo));
    this.rzy.put(3, new s(paramo));
    this.rzy.put(4, new r(paramo));
    this.rzy.put(5, new q(paramo));
    this.rzy.put(6, new com.tencent.mm.plugin.fav.ui.e.g(paramo));
    this.rzy.put(7, new i(paramo));
    this.rzy.put(8, new d(paramo));
    this.rzy.put(10, new k(paramo));
    this.rzy.put(12, new n(paramo));
    this.rzy.put(15, new n(paramo));
    this.rzy.put(11, new com.tencent.mm.plugin.fav.ui.e.h(paramo));
    this.rzy.put(14, new l(paramo));
    this.rzy.put(16, new m(paramo));
    this.rzy.put(17, new com.tencent.mm.plugin.fav.ui.e.c(paramo));
    this.rzy.put(18, new j(paramo));
    this.rzy.put(20, new e(paramo));
    this.rzy.put(19, new com.tencent.mm.plugin.fav.ui.e.a(paramo));
    this.rzy.put(-2, new p(paramo));
    if (paramBoolean != this.rzB)
    {
      this.rzB = paramBoolean;
      if (paramBoolean) {
        this.rzu.clear();
      }
    }
    if (!this.rzB) {
      aTt();
    }
    cwH();
    notifyDataSetChanged();
    com.tencent.mm.sdk.b.a.IbL.d(this.kwD);
    com.tencent.mm.sdk.b.a.IbL.c(this.kwD);
    AppMethodBeat.o(107086);
  }
  
  private void cwI()
  {
    AppMethodBeat.i(107090);
    setSubScene(0);
    this.rzs = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cvs();
    AppMethodBeat.o(107090);
  }
  
  private boolean cwJ()
  {
    AppMethodBeat.i(107092);
    if ((!this.rzw.isEmpty()) || (!this.rzx.isEmpty()) || (!this.rzv.isEmpty()))
    {
      AppMethodBeat.o(107092);
      return true;
    }
    AppMethodBeat.o(107092);
    return false;
  }
  
  private void ds(List<com.tencent.mm.plugin.fav.a.g> paramList)
  {
    AppMethodBeat.i(107091);
    if (paramList == null)
    {
      AppMethodBeat.o(107091);
      return;
    }
    ad.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", new Object[] { Integer.valueOf(paramList.size()) });
    ad.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", new Object[] { Integer.valueOf(this.rzr.size()) });
    paramList.clear();
    AppMethodBeat.o(107091);
  }
  
  private static List<com.tencent.mm.plugin.fav.a.g> k(List<com.tencent.mm.plugin.fav.a.g> paramList, List<Long> paramList1)
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
          paramList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(((Long)paramList1.get(j)).longValue());
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
    int i = this.ooi;
    if (paramInt == 0) {
      this.ooi = 0;
    }
    do
    {
      return;
      if (i == 0)
      {
        this.ooi = paramInt;
        return;
      }
    } while (i == paramInt);
    this.ooi = 4;
  }
  
  public final com.tencent.mm.plugin.fav.a.g Ef(int paramInt)
  {
    AppMethodBeat.i(107104);
    if ((paramInt < 0) || (paramInt >= this.rzp.size()))
    {
      ad.e("MicroMsg.FavoriteAdapter", "get item, but position error");
      localg = new com.tencent.mm.plugin.fav.a.g();
      AppMethodBeat.o(107104);
      return localg;
    }
    com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)this.rzp.get(paramInt);
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
    if ((!paramg.rsm) || (paramg.rsn == null))
    {
      ad.w("MicroMsg.FavoriteAdapter", "goFavDetail() originInfo not exist");
      AppMethodBeat.o(107108);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramg.rsn;
    String str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.GjJ;
    if (!bt.hj((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
      }
    }
    localObject = new akf();
    ((akf)localObject).scene = this.scene;
    ((akf)localObject).ooi = this.ooi;
    ((akf)localObject).query = this.query;
    ((akf)localObject).sessionId = str;
    ((akf)localObject).rsG = localStringBuilder.toString();
    if (paramView != null) {}
    for (paramView = paramView.getContext();; paramView = aj.getContext())
    {
      paramg.rsn.rso = paramg.rso;
      ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, paramg.rsn, (akf)localObject);
      ad.d("MicroMsg.FavoriteAdapter", "goFavDetail type %s %s", new Object[] { Integer.valueOf(paramg.rsn.field_type), paramg.rso, Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(107108);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107093);
    if (paramBoolean == this.rzt)
    {
      AppMethodBeat.o(107093);
      return;
    }
    this.rzt = paramBoolean;
    com.tencent.mm.plugin.fav.a.g localg;
    if (paramBoolean)
    {
      this.rzu.clear();
      if (paramg != null)
      {
        localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramg.field_localId);
        if (localg != null)
        {
          if (!paramg.rsm) {
            break label103;
          }
          this.rzu.put(paramg.dsK, paramg);
        }
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(107093);
      return;
      label103:
      this.rzu.put(bt.dT(Long.valueOf(localg.field_localId)), localg);
    }
  }
  
  public final void aTt()
  {
    AppMethodBeat.i(107088);
    if (cwJ())
    {
      ad.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
      AppMethodBeat.o(107088);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.cuK())
    {
      ad.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
      AppMethodBeat.o(107088);
      return;
    }
    if (!this.rzB) {
      try
      {
        this.lastUpdateTime = com.tencent.mm.plugin.fav.a.b.y(this.lastUpdateTime, this.type);
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
    this.rzq = k(this.rzp, this.rzs);
    this.rzo = true;
    AppMethodBeat.o(107088);
  }
  
  public final void c(List<Integer> paramList, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(107097);
    setSubScene(0);
    this.rzv.clear();
    if (paramList != null)
    {
      this.rzv.addAll(paramList);
      if (!paramList.isEmpty()) {
        setSubScene(2);
      }
    }
    this.rzw.clear();
    if (paramList1 != null)
    {
      this.rzw.addAll(paramList1);
      if (!paramList1.isEmpty()) {
        setSubScene(3);
      }
    }
    this.rzx.clear();
    if (paramList2 != null)
    {
      this.rzx.addAll(paramList2);
      if (!paramList2.isEmpty()) {
        setSubScene(1);
      }
    }
    this.rzz = true;
    cwH();
    this.rzz = false;
    AppMethodBeat.o(107097);
  }
  
  public final void cwH()
  {
    AppMethodBeat.i(107098);
    ad.v("MicroMsg.FavoriteAdapter", "reset data list beg");
    this.rzo = false;
    ds(this.rzq);
    if (!cwJ())
    {
      ad.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", new Object[] { Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type) });
      if (!this.rzB)
      {
        this.rzq = com.tencent.mm.plugin.fav.a.b.a(this.lastUpdateTime, this.type, this.rzl, this.rzm);
        if ((this.rzq != null) && (this.lastUpdateTime == 0L) && (this.rzq.size() > 0)) {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)this.rzq.get(this.rzq.size() - 1)).field_updateTime;
        }
      }
    }
    int i;
    for (;;)
    {
      if (this.rzq == null)
      {
        ad.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
        this.rzq = new ArrayList();
      }
      if ((!this.rzB) && (!cwJ()) && (this.rzq.size() < 20) && (!((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().B(this.lastUpdateTime, this.type)))
      {
        ad.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
        aTt();
      }
      this.rzo = true;
      ad.v("MicroMsg.FavoriteAdapter", "reset data list end");
      AppMethodBeat.o(107098);
      return;
      cwI();
      this.rzq = k(null, this.rzs);
      continue;
      ad.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", new Object[] { this.rzw, this.rzx, this.rzv });
      if ((this.rzv == null) || (this.rzv.size() == 1)) {
        break;
      }
      this.rzq = com.tencent.mm.plugin.fav.a.b.a(this.rzw, this.rzx, this.rzv, this.rzr, this.rzl, this.rzm);
      if (this.rzq != null) {
        break label459;
      }
      i = 0;
      label381:
      com.tencent.mm.plugin.report.service.g.yhR.f(10649, new Object[] { Integer.valueOf(i) });
    }
    if (this.rzv != null) {}
    for (Integer localInteger = (Integer)this.rzv.get(0);; localInteger = null)
    {
      this.rzq = com.tencent.mm.plugin.fav.a.b.a(this.rzw, this.rzx, localInteger.intValue(), this.rzr, this.rzl, this.rzm);
      break;
      label459:
      i = this.rzq.size();
      break label381;
    }
  }
  
  public final int cwK()
  {
    AppMethodBeat.i(107095);
    int i = this.rzu.size();
    AppMethodBeat.o(107095);
    return i;
  }
  
  public final long cwL()
  {
    AppMethodBeat.i(107096);
    Iterator localIterator = this.rzu.values().iterator();
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
    com.tencent.mm.sdk.b.a.IbL.d(this.kwD);
    AppMethodBeat.o(107087);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(107105);
    int i = this.rzp.size();
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
    com.tencent.mm.plugin.fav.a.g localg = Ef(paramInt - 1);
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
    com.tencent.mm.plugin.fav.a.g localg = Ef(paramInt - 1);
    com.tencent.mm.plugin.fav.ui.e.b localb = (com.tencent.mm.plugin.fav.ui.e.b)this.rzy.get(localg.field_type);
    if (localb == null)
    {
      ad.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", new Object[] { Integer.valueOf(localg.field_type) });
      localb = (com.tencent.mm.plugin.fav.ui.e.b)this.rzy.get(-2);
      cwG();
      paramView = localb.a(paramView, paramViewGroup, localg);
      AppMethodBeat.o(107103);
      return paramView;
    }
    localb.rDh.nXZ = cwJ();
    localb.rDh.lastUpdateTime = this.lastUpdateTime;
    localb.rDh.rzt = this.rzt;
    localb.rDh.rzu = this.rzu;
    localb.rDh.rDj = this.rzA;
    localb.rDh.rzB = this.rzB;
    paramView = localb.a(paramView, paramViewGroup, localg);
    AppMethodBeat.o(107103);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(107102);
    int i = this.rzy.size();
    AppMethodBeat.o(107102);
    return i + 4;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(107099);
    boolean bool = this.rzp.isEmpty();
    AppMethodBeat.o(107099);
    return bool;
  }
  
  public final List<com.tencent.mm.plugin.fav.a.g> lB(boolean paramBoolean)
  {
    AppMethodBeat.i(107094);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.rzu.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (localg != null) {
        localLinkedList.add(localg);
      }
    }
    if (paramBoolean) {
      this.rzu.clear();
    }
    AppMethodBeat.o(107094);
    return localLinkedList;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(107100);
    ad.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", new Object[] { Boolean.valueOf(this.rzo) });
    if (this.rzo)
    {
      if ((this.rzB) && (this.rzq != null) && (this.rzp != null) && (this.rzq.size() == this.rzp.size())) {
        this.rzC = true;
      }
      List localList = this.rzp;
      this.rzp = this.rzq;
      this.rzq = localList;
      this.rzo = false;
    }
    ad.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
    super.notifyDataSetChanged();
    AppMethodBeat.o(107100);
  }
  
  public final int o(long paramLong, String paramString)
  {
    int i = 1;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(107106);
    Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(107106);
      return -1;
    }
    if (this.rzu.size() >= 30)
    {
      ad.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
      com.tencent.mm.ui.base.h.cl(aj.getContext(), aj.getContext().getResources().getString(2131758927, new Object[] { Integer.valueOf(30) }));
      AppMethodBeat.o(107106);
      return -1;
    }
    com.tencent.mm.plugin.fav.a.g localg;
    if (!bt.isNullOrNil(paramString))
    {
      Iterator localIterator = this.rzp.iterator();
      while (localIterator.hasNext())
      {
        localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
        if (bt.lQ(localg.dsK, paramString))
        {
          localg.rsn = ((com.tencent.mm.plugin.fav.a.g)localObject);
          localObject = localg;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.rzu.put(paramString, localObject);
        if (((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime < this.lastUpdateTime)
        {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime;
          cwH();
          localObject = this.rzq.iterator();
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
            this.rzu.put(bt.dT(Long.valueOf(paramLong)), localObject);
            break;
          }
          if ((localg.field_localId == paramLong) && (bt.lQ(paramString, localg.dsK)))
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
        localObject = this.rzp.iterator();
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
          else if ((localg.field_localId == paramLong) && (bt.lQ(paramString, localg.dsK)))
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
    if (paramAdapterView.rtA == null)
    {
      ad.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
      AppMethodBeat.o(107107);
      return;
    }
    if ((this.rzt) || (this.rzB))
    {
      if ((!paramAdapterView.iVs.isChecked()) && (this.rzu.size() >= 30))
      {
        ad.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
        com.tencent.mm.ui.base.h.cl(aj.getContext(), aj.getContext().getResources().getString(2131758927, new Object[] { Integer.valueOf(30) }));
        AppMethodBeat.o(107107);
        return;
      }
      paramView = paramAdapterView.iVs;
      if (!paramAdapterView.iVs.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        AppMethodBeat.o(107107);
        return;
      }
    }
    com.tencent.mm.plugin.fav.ui.e.b localb = (com.tencent.mm.plugin.fav.ui.e.b)this.rzy.get(paramAdapterView.rtA.field_type);
    StringBuilder localStringBuilder;
    Object localObject;
    String str;
    if (localb != null)
    {
      localStringBuilder = new StringBuilder();
      localObject = paramAdapterView.rtA;
      str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.GjJ;
      if (!bt.hj((List)localObject))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
        }
      }
      localObject = new akf();
      ((akf)localObject).scene = this.scene;
      ((akf)localObject).ooi = this.ooi;
      if (this.rzD == null) {
        break label439;
      }
    }
    label439:
    for (((akf)localObject).index = (paramInt - this.rzD.getHeaderViewsCount());; ((akf)localObject).index = paramInt)
    {
      ((akf)localObject).query = this.query;
      ((akf)localObject).sessionId = str;
      ((akf)localObject).rsG = localStringBuilder.toString();
      localb.a(paramView, (akf)localObject);
      ad.d("MicroMsg.FavoriteAdapter", "item click type %s", new Object[] { Integer.valueOf(paramAdapterView.rtA.field_type) });
      AppMethodBeat.o(107107);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.b
 * JD-Core Version:    0.7.0.1
 */