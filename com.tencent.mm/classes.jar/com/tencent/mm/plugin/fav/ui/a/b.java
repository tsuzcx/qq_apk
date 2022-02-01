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
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b.b;
import com.tencent.mm.plugin.fav.ui.d.b.c;
import com.tencent.mm.plugin.fav.ui.d.c;
import com.tencent.mm.plugin.fav.ui.d.d;
import com.tencent.mm.plugin.fav.ui.d.e;
import com.tencent.mm.plugin.fav.ui.d.f;
import com.tencent.mm.plugin.fav.ui.d.i;
import com.tencent.mm.plugin.fav.ui.d.j;
import com.tencent.mm.plugin.fav.ui.d.k;
import com.tencent.mm.plugin.fav.ui.d.l;
import com.tencent.mm.plugin.fav.ui.d.m;
import com.tencent.mm.plugin.fav.ui.d.n;
import com.tencent.mm.plugin.fav.ui.d.p;
import com.tencent.mm.plugin.fav.ui.d.q;
import com.tencent.mm.plugin.fav.ui.d.r;
import com.tencent.mm.plugin.fav.ui.d.s;
import com.tencent.mm.plugin.fav.ui.d.t;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.sdk.event.EventCenter;
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
  private IListener lEl;
  public int pHw;
  public String query;
  public int scene;
  private boolean thg;
  public List<com.tencent.mm.plugin.fav.a.g> thh;
  private List<com.tencent.mm.plugin.fav.a.g> thi;
  private List<com.tencent.mm.plugin.fav.a.g> thj;
  public List<Long> thk;
  public boolean thl;
  private Map<String, com.tencent.mm.plugin.fav.a.g> thm;
  private List<Integer> thn;
  private List<String> tho;
  private List<String> thp;
  private SparseArray<com.tencent.mm.plugin.fav.ui.d.b> thq;
  private boolean thr;
  public b.c ths;
  public boolean tht;
  public boolean thu;
  public ListView thv;
  
  public b(com.tencent.mm.plugin.fav.ui.o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(107086);
    this.thg = false;
    this.thh = new ArrayList();
    this.thi = new ArrayList();
    this.thj = new LinkedList();
    this.thk = new ArrayList();
    this.thl = false;
    this.thm = new TreeMap();
    this.thn = new ArrayList();
    this.tho = new LinkedList();
    this.thp = new LinkedList();
    this.thq = new SparseArray();
    this.thr = false;
    this.tht = false;
    this.thu = false;
    this.query = "";
    this.lEl = new IListener() {};
    this.type = -1;
    this.thq.put(1, new p(paramo));
    this.thq.put(2, new f(paramo));
    this.thq.put(3, new t(paramo));
    this.thq.put(4, new s(paramo));
    this.thq.put(5, new r(paramo));
    this.thq.put(6, new com.tencent.mm.plugin.fav.ui.d.g(paramo));
    this.thq.put(7, new i(paramo));
    this.thq.put(21, new j(paramo));
    this.thq.put(8, new d(paramo));
    this.thq.put(10, new l(paramo));
    this.thq.put(12, new com.tencent.mm.plugin.fav.ui.d.o(paramo));
    this.thq.put(15, new com.tencent.mm.plugin.fav.ui.d.o(paramo));
    this.thq.put(11, new com.tencent.mm.plugin.fav.ui.d.h(paramo));
    this.thq.put(14, new m(paramo));
    this.thq.put(16, new n(paramo));
    this.thq.put(17, new c(paramo));
    this.thq.put(18, new k(paramo));
    this.thq.put(20, new e(paramo));
    this.thq.put(19, new com.tencent.mm.plugin.fav.ui.d.a(paramo));
    this.thq.put(-2, new q(paramo));
    if (paramBoolean != this.tht)
    {
      this.tht = paramBoolean;
      if (paramBoolean) {
        this.thm.clear();
      }
    }
    if (!this.tht) {
      boE();
    }
    cWm();
    notifyDataSetChanged();
    EventCenter.instance.removeListener(this.lEl);
    EventCenter.instance.addListener(this.lEl);
    AppMethodBeat.o(107086);
  }
  
  private void cWn()
  {
    AppMethodBeat.i(107090);
    setSubScene(0);
    this.thk = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUX();
    AppMethodBeat.o(107090);
  }
  
  private boolean cWo()
  {
    AppMethodBeat.i(107092);
    if ((!this.tho.isEmpty()) || (!this.thp.isEmpty()) || (!this.thn.isEmpty()))
    {
      AppMethodBeat.o(107092);
      return true;
    }
    AppMethodBeat.o(107092);
    return false;
  }
  
  private void dJ(List<com.tencent.mm.plugin.fav.a.g> paramList)
  {
    AppMethodBeat.i(107091);
    if (paramList == null)
    {
      AppMethodBeat.o(107091);
      return;
    }
    Log.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", new Object[] { Integer.valueOf(paramList.size()) });
    Log.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", new Object[] { Integer.valueOf(this.thj.size()) });
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
          paramList = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(((Long)paramList1.get(j)).longValue());
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
    int i = this.pHw;
    if (paramInt == 0) {
      this.pHw = 0;
    }
    do
    {
      return;
      if (i == 0)
      {
        this.pHw = paramInt;
        return;
      }
    } while (i == paramInt);
    this.pHw = 4;
  }
  
  public final com.tencent.mm.plugin.fav.a.g Id(int paramInt)
  {
    AppMethodBeat.i(107104);
    if ((paramInt < 0) || (paramInt >= this.thh.size()))
    {
      Log.e("MicroMsg.FavoriteAdapter", "get item, but position error");
      localg = new com.tencent.mm.plugin.fav.a.g();
      AppMethodBeat.o(107104);
      return localg;
    }
    com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)this.thh.get(paramInt);
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
    if ((!paramg.tad) || (paramg.tae == null))
    {
      Log.w("MicroMsg.FavoriteAdapter", "goFavDetail() originInfo not exist");
      AppMethodBeat.o(107108);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramg.tae;
    String str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.Lyo;
    if (!Util.isNullOrNil((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
      }
    }
    localObject = new and();
    ((and)localObject).scene = this.scene;
    ((and)localObject).pHw = this.pHw;
    ((and)localObject).query = this.query;
    ((and)localObject).sessionId = str;
    ((and)localObject).tay = localStringBuilder.toString();
    if (paramView != null) {}
    for (paramView = paramView.getContext();; paramView = MMApplicationContext.getContext())
    {
      paramg.tae.taf = paramg.taf;
      ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, paramg.tae, (and)localObject);
      Log.d("MicroMsg.FavoriteAdapter", "goFavDetail type %s %s", new Object[] { Integer.valueOf(paramg.tae.field_type), paramg.taf, Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(107108);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107093);
    if (paramBoolean == this.thl)
    {
      AppMethodBeat.o(107093);
      return;
    }
    this.thl = paramBoolean;
    com.tencent.mm.plugin.fav.a.g localg;
    if (paramBoolean)
    {
      this.thm.clear();
      if (paramg != null)
      {
        localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramg.field_localId);
        if (localg != null)
        {
          if (!paramg.tad) {
            break label103;
          }
          this.thm.put(paramg.dLb, paramg);
        }
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(107093);
      return;
      label103:
      this.thm.put(Util.notNullToString(Long.valueOf(localg.field_localId)), localg);
    }
  }
  
  public final void boE()
  {
    AppMethodBeat.i(107088);
    if (cWo())
    {
      Log.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
      AppMethodBeat.o(107088);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.cUo())
    {
      Log.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
      AppMethodBeat.o(107088);
      return;
    }
    if (!this.tht) {
      try
      {
        this.lastUpdateTime = com.tencent.mm.plugin.fav.a.b.v(this.lastUpdateTime, this.type);
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
    this.thi = l(this.thh, this.thk);
    this.thg = true;
    AppMethodBeat.o(107088);
  }
  
  public final void c(List<Integer> paramList, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(107097);
    setSubScene(0);
    this.thn.clear();
    if (paramList != null)
    {
      this.thn.addAll(paramList);
      if (!paramList.isEmpty()) {
        setSubScene(2);
      }
    }
    this.tho.clear();
    if (paramList1 != null)
    {
      this.tho.addAll(paramList1);
      if (!paramList1.isEmpty()) {
        setSubScene(3);
      }
    }
    this.thp.clear();
    if (paramList2 != null)
    {
      this.thp.addAll(paramList2);
      if (!paramList2.isEmpty()) {
        setSubScene(1);
      }
    }
    this.thr = true;
    cWm();
    this.thr = false;
    AppMethodBeat.o(107097);
  }
  
  public final void cWm()
  {
    AppMethodBeat.i(107098);
    Log.v("MicroMsg.FavoriteAdapter", "reset data list beg");
    this.thg = false;
    dJ(this.thi);
    if (!cWo())
    {
      Log.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", new Object[] { Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type) });
      if (!this.tht)
      {
        this.thi = com.tencent.mm.plugin.fav.a.b.a(this.lastUpdateTime, this.type, this.thd, this.the);
        if ((this.thi != null) && (this.lastUpdateTime == 0L) && (this.thi.size() > 0)) {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)this.thi.get(this.thi.size() - 1)).field_updateTime;
        }
      }
    }
    int i;
    for (;;)
    {
      if (this.thi == null)
      {
        Log.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
        this.thi = new ArrayList();
      }
      if ((!this.tht) && (!cWo()) && (this.thi.size() < 20) && (!((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().z(this.lastUpdateTime, this.type)))
      {
        Log.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
        boE();
      }
      this.thg = true;
      Log.v("MicroMsg.FavoriteAdapter", "reset data list end");
      AppMethodBeat.o(107098);
      return;
      cWn();
      this.thi = l(null, this.thk);
      continue;
      Log.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", new Object[] { this.tho, this.thp, this.thn });
      if ((this.thn == null) || (this.thn.size() == 1)) {
        break;
      }
      this.thi = com.tencent.mm.plugin.fav.a.b.a(this.tho, this.thp, this.thn, this.thj, this.thd, this.the);
      if (this.thi != null) {
        break label459;
      }
      i = 0;
      label381:
      com.tencent.mm.plugin.report.service.h.CyF.a(10649, new Object[] { Integer.valueOf(i) });
    }
    if (this.thn != null) {}
    for (Integer localInteger = (Integer)this.thn.get(0);; localInteger = null)
    {
      this.thi = com.tencent.mm.plugin.fav.a.b.a(this.tho, this.thp, localInteger.intValue(), this.thj, this.thd, this.the);
      break;
      label459:
      i = this.thi.size();
      break label381;
    }
  }
  
  public final int cWp()
  {
    AppMethodBeat.i(107095);
    int i = this.thm.size();
    AppMethodBeat.o(107095);
    return i;
  }
  
  public final long cWq()
  {
    AppMethodBeat.i(107096);
    Iterator localIterator = this.thm.values().iterator();
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
    EventCenter.instance.removeListener(this.lEl);
    AppMethodBeat.o(107087);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(107105);
    int i = this.thh.size();
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
    com.tencent.mm.plugin.fav.a.g localg = Id(paramInt - 1);
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
      paramView.setBackgroundResource(2131100387);
      paramView.setPadding(0, 0, 0, 0);
      paramView.setEnabled(false);
      AppMethodBeat.o(107103);
      return paramView;
    }
    com.tencent.mm.plugin.fav.a.g localg = Id(paramInt - 1);
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
          if (localg.field_favProto.Lya != null) {
            localObject1 = localg.field_favProto.Lya.appId;
          }
        }
      }
      localObject2 = com.tencent.mm.plugin.comm.a.qCo;
      if (!com.tencent.mm.plugin.comm.a.akQ((String)localObject1)) {
        break label236;
      }
      localg.field_type = 21;
    }
    for (;;)
    {
      localObject1 = (com.tencent.mm.plugin.fav.ui.d.b)this.thq.get(localg.field_type);
      if (localObject1 != null) {
        break;
      }
      Log.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", new Object[] { Integer.valueOf(localg.field_type) });
      localObject1 = (com.tencent.mm.plugin.fav.ui.d.b)this.thq.get(-2);
      cWl();
      paramView = ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).a(paramView, paramViewGroup, localg);
      AppMethodBeat.o(107103);
      return paramView;
      label236:
      localObject1 = com.tencent.mm.plugin.comm.a.qCo;
      if (!com.tencent.mm.plugin.comm.a.cAI()) {
        localg.field_type = 7;
      } else {
        localg.field_type = 5;
      }
    }
    ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).tle.poG = cWo();
    ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).tle.lastUpdateTime = this.lastUpdateTime;
    ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).tle.thl = this.thl;
    ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).tle.thm = this.thm;
    ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).tle.tlg = this.ths;
    ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).tle.tht = this.tht;
    paramView = ((com.tencent.mm.plugin.fav.ui.d.b)localObject1).a(paramView, paramViewGroup, localg);
    AppMethodBeat.o(107103);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(107102);
    int i = this.thq.size();
    AppMethodBeat.o(107102);
    return i + 4;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(107099);
    boolean bool = this.thh.isEmpty();
    AppMethodBeat.o(107099);
    return bool;
  }
  
  public final List<com.tencent.mm.plugin.fav.a.g> mE(boolean paramBoolean)
  {
    AppMethodBeat.i(107094);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.thm.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (localg != null) {
        localLinkedList.add(localg);
      }
    }
    if (paramBoolean) {
      this.thm.clear();
    }
    AppMethodBeat.o(107094);
    return localLinkedList;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(107100);
    Log.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", new Object[] { Boolean.valueOf(this.thg) });
    if (this.thg)
    {
      if ((this.tht) && (this.thi != null) && (this.thh != null) && (this.thi.size() == this.thh.size())) {
        this.thu = true;
      }
      List localList = this.thh;
      this.thh = this.thi;
      this.thi = localList;
      this.thg = false;
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
    if (paramAdapterView.tbr == null)
    {
      Log.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
      AppMethodBeat.o(107107);
      return;
    }
    if ((this.thl) || (this.tht))
    {
      if ((!paramAdapterView.jVQ.isChecked()) && (this.thm.size() >= 30))
      {
        Log.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
        com.tencent.mm.ui.base.h.cD(MMApplicationContext.getContext(), MMApplicationContext.getContext().getResources().getString(2131759251, new Object[] { Integer.valueOf(30) }));
        AppMethodBeat.o(107107);
        return;
      }
      paramView = paramAdapterView.jVQ;
      if (!paramAdapterView.jVQ.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        AppMethodBeat.o(107107);
        return;
      }
    }
    com.tencent.mm.plugin.fav.ui.d.b localb = (com.tencent.mm.plugin.fav.ui.d.b)this.thq.get(paramAdapterView.tbr.field_type);
    StringBuilder localStringBuilder;
    Object localObject;
    String str;
    if (localb != null)
    {
      localStringBuilder = new StringBuilder();
      localObject = paramAdapterView.tbr;
      str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.Lyo;
      if (!Util.isNullOrNil((List)localObject))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
        }
      }
      localObject = new and();
      ((and)localObject).scene = this.scene;
      ((and)localObject).pHw = this.pHw;
      if (this.thv == null) {
        break label439;
      }
    }
    label439:
    for (((and)localObject).index = (paramInt - this.thv.getHeaderViewsCount());; ((and)localObject).index = paramInt)
    {
      ((and)localObject).query = this.query;
      ((and)localObject).sessionId = str;
      ((and)localObject).tay = localStringBuilder.toString();
      localb.a(paramView, (and)localObject);
      Log.d("MicroMsg.FavoriteAdapter", "item click type %s", new Object[] { Integer.valueOf(paramAdapterView.tbr.field_type) });
      AppMethodBeat.o(107107);
      return;
    }
  }
  
  public final int p(long paramLong, String paramString)
  {
    int i = 1;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(107106);
    Object localObject = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(107106);
      return -1;
    }
    if (this.thm.size() >= 30)
    {
      Log.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
      com.tencent.mm.ui.base.h.cD(MMApplicationContext.getContext(), MMApplicationContext.getContext().getResources().getString(2131759251, new Object[] { Integer.valueOf(30) }));
      AppMethodBeat.o(107106);
      return -1;
    }
    com.tencent.mm.plugin.fav.a.g localg;
    if (!Util.isNullOrNil(paramString))
    {
      Iterator localIterator = this.thh.iterator();
      while (localIterator.hasNext())
      {
        localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
        if (Util.isEqual(localg.dLb, paramString))
        {
          localg.tae = ((com.tencent.mm.plugin.fav.a.g)localObject);
          localObject = localg;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.thm.put(paramString, localObject);
        if (((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime < this.lastUpdateTime)
        {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime;
          cWm();
          localObject = this.thi.iterator();
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
            this.thm.put(Util.notNullToString(Long.valueOf(paramLong)), localObject);
            break;
          }
          if ((localg.field_localId == paramLong) && (Util.isEqual(paramString, localg.dLb)))
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
        localObject = this.thh.iterator();
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
          else if ((localg.field_localId == paramLong) && (Util.isEqual(paramString, localg.dLb)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.b
 * JD-Core Version:    0.7.0.1
 */