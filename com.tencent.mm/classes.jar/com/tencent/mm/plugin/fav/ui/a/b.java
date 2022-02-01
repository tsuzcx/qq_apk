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
import com.tencent.mm.f.a.no;
import com.tencent.mm.f.a.np;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.e.b.b;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.e.c;
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
import com.tencent.mm.plugin.fav.ui.e.t;
import com.tencent.mm.plugin.fav.ui.s.b;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
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
  private IListener ozM;
  public String query;
  public int scene;
  public int wGA;
  public List<Long> wNA;
  public boolean wNB;
  private Map<String, com.tencent.mm.plugin.fav.a.g> wNC;
  private List<Integer> wND;
  private List<String> wNE;
  private List<String> wNF;
  private SparseArray<com.tencent.mm.plugin.fav.ui.e.b> wNG;
  private boolean wNH;
  public b.c wNI;
  public boolean wNJ;
  public boolean wNK;
  public ListView wNL;
  private IListener wNM;
  private boolean wNw;
  public List<com.tencent.mm.plugin.fav.a.g> wNx;
  private List<com.tencent.mm.plugin.fav.a.g> wNy;
  private List<com.tencent.mm.plugin.fav.a.g> wNz;
  
  public b(com.tencent.mm.plugin.fav.ui.o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(107086);
    this.wNw = false;
    this.wNx = new ArrayList();
    this.wNy = new ArrayList();
    this.wNz = new LinkedList();
    this.wNA = new ArrayList();
    this.wNB = false;
    this.wNC = new TreeMap();
    this.wND = new ArrayList();
    this.wNE = new LinkedList();
    this.wNF = new LinkedList();
    this.wNG = new SparseArray();
    this.wNH = false;
    this.wNJ = false;
    this.wNK = false;
    this.query = "";
    this.ozM = new IListener() {};
    this.wNM = new IListener() {};
    this.type = -1;
    this.wNG.put(1, new p(paramo));
    this.wNG.put(2, new f(paramo));
    this.wNG.put(3, new t(paramo));
    this.wNG.put(4, new s(paramo));
    this.wNG.put(5, new r(paramo));
    this.wNG.put(6, new com.tencent.mm.plugin.fav.ui.e.g(paramo));
    this.wNG.put(7, new i(paramo));
    this.wNG.put(21, new j(paramo));
    this.wNG.put(8, new d(paramo));
    this.wNG.put(10, new l(paramo));
    this.wNG.put(12, new com.tencent.mm.plugin.fav.ui.e.o(paramo));
    this.wNG.put(15, new com.tencent.mm.plugin.fav.ui.e.o(paramo));
    this.wNG.put(11, new com.tencent.mm.plugin.fav.ui.e.h(paramo));
    this.wNG.put(14, new m(paramo));
    this.wNG.put(16, new n(paramo));
    this.wNG.put(17, new c(paramo));
    this.wNG.put(18, new k(paramo));
    this.wNG.put(20, new e(paramo));
    this.wNG.put(19, new com.tencent.mm.plugin.fav.ui.e.a(paramo));
    this.wNG.put(-2, new q(paramo));
    if (paramBoolean != this.wNJ)
    {
      this.wNJ = paramBoolean;
      if (paramBoolean) {
        this.wNC.clear();
      }
    }
    if (!this.wNJ) {
      byN();
    }
    dlt();
    notifyDataSetChanged();
    AppMethodBeat.o(107086);
  }
  
  private void dP(List<com.tencent.mm.plugin.fav.a.g> paramList)
  {
    AppMethodBeat.i(107091);
    if (paramList == null)
    {
      AppMethodBeat.o(107091);
      return;
    }
    Log.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", new Object[] { Integer.valueOf(paramList.size()) });
    Log.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", new Object[] { Integer.valueOf(this.wNz.size()) });
    paramList.clear();
    AppMethodBeat.o(107091);
  }
  
  private void dlu()
  {
    AppMethodBeat.i(107090);
    setSubScene(0);
    this.wNA = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().dkd();
    AppMethodBeat.o(107090);
  }
  
  private boolean dlv()
  {
    AppMethodBeat.i(107092);
    if ((!this.wNE.isEmpty()) || (!this.wNF.isEmpty()) || (!this.wND.isEmpty()))
    {
      AppMethodBeat.o(107092);
      return true;
    }
    AppMethodBeat.o(107092);
    return false;
  }
  
  private static List<com.tencent.mm.plugin.fav.a.g> n(List<com.tencent.mm.plugin.fav.a.g> paramList, List<Long> paramList1)
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
          paramList = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(((Long)paramList1.get(j)).longValue());
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
    int i = this.wGA;
    if (paramInt == 0) {
      this.wGA = 0;
    }
    do
    {
      return;
      if (i == 0)
      {
        this.wGA = paramInt;
        return;
      }
    } while (i == paramInt);
    this.wGA = 4;
  }
  
  public final com.tencent.mm.plugin.fav.a.g LN(int paramInt)
  {
    AppMethodBeat.i(107104);
    if ((paramInt < 0) || (paramInt >= this.wNx.size()))
    {
      Log.e("MicroMsg.FavoriteAdapter", "get item, but position error");
      localg = new com.tencent.mm.plugin.fav.a.g();
      AppMethodBeat.o(107104);
      return localg;
    }
    com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)this.wNx.get(paramInt);
    AppMethodBeat.o(107104);
    return localg;
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107108);
    if (paramg == null)
    {
      Log.w("MicroMsg.FavoriteAdapter", "goFavDetail() favItemInfo is null");
      AppMethodBeat.o(107108);
      return;
    }
    if ((!paramg.wGh) || (paramg.wGi == null))
    {
      Log.w("MicroMsg.FavoriteAdapter", "goFavDetail() originInfo not exist");
      AppMethodBeat.o(107108);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramg.wGi;
    String str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.SAP;
    if (!Util.isNullOrNil((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
      }
    }
    localObject = new aoe();
    ((aoe)localObject).scene = this.scene;
    ((aoe)localObject).wGA = this.wGA;
    ((aoe)localObject).query = this.query;
    ((aoe)localObject).sessionId = str;
    ((aoe)localObject).wGC = localStringBuilder.toString();
    if (paramView != null) {}
    for (paramView = paramView.getContext();; paramView = MMApplicationContext.getContext())
    {
      paramg.wGi.wGj = paramg.wGj;
      ((z)com.tencent.mm.kernel.h.ae(z.class)).a(paramView, paramg.wGi, (aoe)localObject);
      Log.d("MicroMsg.FavoriteAdapter", "goFavDetail type %s %s", new Object[] { Integer.valueOf(paramg.wGi.field_type), paramg.wGj, Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(107108);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107093);
    if (paramBoolean == this.wNB)
    {
      AppMethodBeat.o(107093);
      return;
    }
    this.wNB = paramBoolean;
    com.tencent.mm.plugin.fav.a.g localg;
    if (paramBoolean)
    {
      this.wNC.clear();
      if (paramg != null)
      {
        localg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramg.field_localId);
        if (localg != null)
        {
          if (!paramg.wGh) {
            break label103;
          }
          this.wNC.put(paramg.fDQ, paramg);
        }
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(107093);
      return;
      label103:
      this.wNC.put(Util.notNullToString(Long.valueOf(localg.field_localId)), localg);
    }
  }
  
  public final void byN()
  {
    AppMethodBeat.i(107088);
    if (dlv())
    {
      Log.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
      AppMethodBeat.o(107088);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.dju())
    {
      Log.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
      AppMethodBeat.o(107088);
      return;
    }
    if (!this.wNJ) {
      try
      {
        this.lastUpdateTime = com.tencent.mm.plugin.fav.a.b.x(this.lastUpdateTime, this.type);
        AppMethodBeat.o(107088);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.FavoriteAdapter", localException, "", new Object[0]);
        AppMethodBeat.o(107088);
        return;
      }
    }
    this.wNy = n(this.wNx, this.wNA);
    this.wNw = true;
    AppMethodBeat.o(107088);
  }
  
  public final void c(List<Integer> paramList, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(107097);
    setSubScene(0);
    this.wND.clear();
    if (paramList != null)
    {
      this.wND.addAll(paramList);
      if (!paramList.isEmpty()) {
        setSubScene(2);
      }
    }
    this.wNE.clear();
    if (paramList1 != null)
    {
      this.wNE.addAll(paramList1);
      if (!paramList1.isEmpty()) {
        setSubScene(3);
      }
    }
    this.wNF.clear();
    if (paramList2 != null)
    {
      this.wNF.addAll(paramList2);
      if (!paramList2.isEmpty()) {
        setSubScene(1);
      }
    }
    this.wNH = true;
    dlt();
    this.wNH = false;
    AppMethodBeat.o(107097);
  }
  
  public final void dlt()
  {
    AppMethodBeat.i(107098);
    Log.v("MicroMsg.FavoriteAdapter", "reset data list beg");
    this.wNw = false;
    dP(this.wNy);
    if (!dlv())
    {
      Log.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", new Object[] { Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type) });
      if (!this.wNJ)
      {
        this.wNy = com.tencent.mm.plugin.fav.a.b.a(this.lastUpdateTime, this.type, this.wNt, this.wNu);
        if ((this.wNy != null) && (this.lastUpdateTime == 0L) && (this.wNy.size() > 0)) {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)this.wNy.get(this.wNy.size() - 1)).field_updateTime;
        }
      }
    }
    int i;
    for (;;)
    {
      if (this.wNy == null)
      {
        Log.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
        this.wNy = new ArrayList();
      }
      if ((!this.wNJ) && (!dlv()) && (this.wNy.size() < 20) && (!((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().B(this.lastUpdateTime, this.type)))
      {
        Log.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
        byN();
      }
      this.wNw = true;
      Log.v("MicroMsg.FavoriteAdapter", "reset data list end");
      AppMethodBeat.o(107098);
      return;
      dlu();
      this.wNy = n(null, this.wNA);
      continue;
      Log.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", new Object[] { this.wNE, this.wNF, this.wND });
      if ((this.wND == null) || (this.wND.size() == 1)) {
        break;
      }
      this.wNy = com.tencent.mm.plugin.fav.a.b.a(this.wNE, this.wNF, this.wND, this.wNz, this.wNt, this.wNu);
      if (this.wNy != null) {
        break label459;
      }
      i = 0;
      label381:
      com.tencent.mm.plugin.report.service.h.IzE.a(10649, new Object[] { Integer.valueOf(i) });
    }
    if (this.wND != null) {}
    for (Integer localInteger = (Integer)this.wND.get(0);; localInteger = null)
    {
      this.wNy = com.tencent.mm.plugin.fav.a.b.a(this.wNE, this.wNF, localInteger.intValue(), this.wNz, this.wNt, this.wNu);
      break;
      label459:
      i = this.wNy.size();
      break label381;
    }
  }
  
  public final int dlw()
  {
    AppMethodBeat.i(107095);
    int i = this.wNC.size();
    AppMethodBeat.o(107095);
    return i;
  }
  
  public final long dlx()
  {
    AppMethodBeat.i(107096);
    Iterator localIterator = this.wNC.values().iterator();
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
  
  public final int getCount()
  {
    AppMethodBeat.i(107105);
    int i = this.wNx.size();
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
    com.tencent.mm.plugin.fav.a.g localg = LN(paramInt - 1);
    switch (localg.field_type)
    {
    case 9: 
    case 13: 
    default: 
      Log.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", new Object[] { Integer.valueOf(localg.field_type) });
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
      paramView.setBackgroundResource(s.b.fav_listitem_divider_bg);
      paramView.setPadding(0, 0, 0, 0);
      paramView.setEnabled(false);
      AppMethodBeat.o(107103);
      return paramView;
    }
    com.tencent.mm.plugin.fav.a.g localg = LN(paramInt - 1);
    Object localObject1;
    if (7 == localg.field_type)
    {
      Object localObject2 = "";
      localObject1 = localObject2;
      if (localg != null)
      {
        localObject1 = localObject2;
        if (localg.field_favProto != null)
        {
          localObject1 = localObject2;
          if (localg.field_favProto.SAB != null) {
            localObject1 = localg.field_favProto.SAB.appId;
          }
        }
      }
      localObject2 = com.tencent.mm.plugin.comm.a.ubo;
      if (!com.tencent.mm.plugin.comm.a.asG((String)localObject1)) {
        break label236;
      }
      localg.field_type = 21;
    }
    for (;;)
    {
      localObject1 = (com.tencent.mm.plugin.fav.ui.e.b)this.wNG.get(localg.field_type);
      if (localObject1 != null) {
        break;
      }
      Log.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", new Object[] { Integer.valueOf(localg.field_type) });
      localObject1 = (com.tencent.mm.plugin.fav.ui.e.b)this.wNG.get(-2);
      dls();
      paramView = ((com.tencent.mm.plugin.fav.ui.e.b)localObject1).a(paramView, paramViewGroup, localg);
      AppMethodBeat.o(107103);
      return paramView;
      label236:
      localObject1 = com.tencent.mm.plugin.comm.a.ubo;
      if (!com.tencent.mm.plugin.comm.a.cPi()) {
        localg.field_type = 7;
      } else {
        localg.field_type = 5;
      }
    }
    ((com.tencent.mm.plugin.fav.ui.e.b)localObject1).wRC.sxF = dlv();
    ((com.tencent.mm.plugin.fav.ui.e.b)localObject1).wRC.lastUpdateTime = this.lastUpdateTime;
    ((com.tencent.mm.plugin.fav.ui.e.b)localObject1).wRC.wNB = this.wNB;
    ((com.tencent.mm.plugin.fav.ui.e.b)localObject1).wRC.wNC = this.wNC;
    ((com.tencent.mm.plugin.fav.ui.e.b)localObject1).wRC.wRE = this.wNI;
    ((com.tencent.mm.plugin.fav.ui.e.b)localObject1).wRC.wNJ = this.wNJ;
    paramView = ((com.tencent.mm.plugin.fav.ui.e.b)localObject1).a(paramView, paramViewGroup, localg);
    AppMethodBeat.o(107103);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(107102);
    int i = this.wNG.size();
    AppMethodBeat.o(107102);
    return i + 4;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(107099);
    boolean bool = this.wNx.isEmpty();
    AppMethodBeat.o(107099);
    return bool;
  }
  
  public final List<com.tencent.mm.plugin.fav.a.g> nS(boolean paramBoolean)
  {
    AppMethodBeat.i(107094);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.wNC.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (localg != null) {
        localLinkedList.add(localg);
      }
    }
    if (paramBoolean) {
      this.wNC.clear();
    }
    AppMethodBeat.o(107094);
    return localLinkedList;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(107100);
    Log.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", new Object[] { Boolean.valueOf(this.wNw) });
    if (this.wNw)
    {
      if ((this.wNJ) && (this.wNy != null) && (this.wNx != null) && (this.wNy.size() == this.wNx.size())) {
        this.wNK = true;
      }
      List localList = this.wNx;
      this.wNx = this.wNy;
      this.wNy = localList;
      this.wNw = false;
    }
    Log.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
    super.notifyDataSetChanged();
    AppMethodBeat.o(107100);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107107);
    paramAdapterView = (b.b)paramView.getTag();
    if (paramAdapterView == null)
    {
      Log.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
      AppMethodBeat.o(107107);
      return;
    }
    if (paramAdapterView.wHw == null)
    {
      Log.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
      AppMethodBeat.o(107107);
      return;
    }
    if ((this.wNB) || (this.wNJ))
    {
      if ((!paramAdapterView.mNd.isChecked()) && (this.wNC.size() >= 30))
      {
        Log.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
        com.tencent.mm.ui.base.h.cO(MMApplicationContext.getContext(), MMApplicationContext.getContext().getResources().getString(s.i.favorite_max_selected_tips, new Object[] { Integer.valueOf(30) }));
        AppMethodBeat.o(107107);
        return;
      }
      paramView = paramAdapterView.mNd;
      if (!paramAdapterView.mNd.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        AppMethodBeat.o(107107);
        return;
      }
    }
    com.tencent.mm.plugin.fav.ui.e.b localb = (com.tencent.mm.plugin.fav.ui.e.b)this.wNG.get(paramAdapterView.wHw.field_type);
    StringBuilder localStringBuilder;
    Object localObject;
    String str;
    if (localb != null)
    {
      localStringBuilder = new StringBuilder();
      localObject = paramAdapterView.wHw;
      str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.SAP;
      if (!Util.isNullOrNil((List)localObject))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
        }
      }
      localObject = new aoe();
      ((aoe)localObject).scene = this.scene;
      ((aoe)localObject).wGA = this.wGA;
      if (this.wNL == null) {
        break label439;
      }
    }
    label439:
    for (((aoe)localObject).index = (paramInt - this.wNL.getHeaderViewsCount());; ((aoe)localObject).index = paramInt)
    {
      ((aoe)localObject).query = this.query;
      ((aoe)localObject).sessionId = str;
      ((aoe)localObject).wGC = localStringBuilder.toString();
      localb.a(paramView, (aoe)localObject);
      Log.d("MicroMsg.FavoriteAdapter", "item click type %s", new Object[] { Integer.valueOf(paramAdapterView.wHw.field_type) });
      AppMethodBeat.o(107107);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(228963);
    this.ozM.dead();
    this.wNM.dead();
    AppMethodBeat.o(228963);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(228961);
    this.ozM.alive();
    this.wNM.alive();
    AppMethodBeat.o(228961);
  }
  
  public final int r(long paramLong, String paramString)
  {
    int i = 1;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(107106);
    Object localObject = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(107106);
      return -1;
    }
    if (this.wNC.size() >= 30)
    {
      Log.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
      com.tencent.mm.ui.base.h.cO(MMApplicationContext.getContext(), MMApplicationContext.getContext().getResources().getString(s.i.favorite_max_selected_tips, new Object[] { Integer.valueOf(30) }));
      AppMethodBeat.o(107106);
      return -1;
    }
    com.tencent.mm.plugin.fav.a.g localg;
    if (!Util.isNullOrNil(paramString))
    {
      Iterator localIterator = this.wNx.iterator();
      while (localIterator.hasNext())
      {
        localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
        if (Util.isEqual(localg.fDQ, paramString))
        {
          localg.wGi = ((com.tencent.mm.plugin.fav.a.g)localObject);
          localObject = localg;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.wNC.put(paramString, localObject);
        if (((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime < this.lastUpdateTime)
        {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime;
          dlt();
          localObject = this.wNy.iterator();
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
          if (Util.isNullOrNil(paramString))
          {
            if (localg.field_localId != paramLong) {
              break label353;
            }
            notifyDataSetChanged();
            AppMethodBeat.o(107106);
            return i;
            this.wNC.put(Util.notNullToString(Long.valueOf(paramLong)), localObject);
            break;
          }
          if ((localg.field_localId == paramLong) && (Util.isEqual(paramString, localg.fDQ)))
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
        localObject = this.wNx.iterator();
        i = k;
        while (((Iterator)localObject).hasNext())
        {
          localg = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next();
          if (Util.isNullOrNil(paramString))
          {
            if (localg.field_localId == paramLong)
            {
              notifyDataSetChanged();
              AppMethodBeat.o(107106);
              return i;
            }
          }
          else if ((localg.field_localId == paramLong) && (Util.isEqual(paramString, localg.fDQ)))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.b
 * JD-Core Version:    0.7.0.1
 */