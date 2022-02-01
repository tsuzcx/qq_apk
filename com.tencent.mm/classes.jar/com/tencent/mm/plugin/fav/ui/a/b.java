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
import com.tencent.mm.g.a.mg;
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
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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
  private com.tencent.mm.sdk.b.c kzS;
  public int otZ;
  public String query;
  public List<com.tencent.mm.plugin.fav.a.g> rHA;
  private List<com.tencent.mm.plugin.fav.a.g> rHB;
  private List<com.tencent.mm.plugin.fav.a.g> rHC;
  public List<Long> rHD;
  public boolean rHE;
  private Map<String, com.tencent.mm.plugin.fav.a.g> rHF;
  private List<Integer> rHG;
  private List<String> rHH;
  private List<String> rHI;
  private SparseArray<com.tencent.mm.plugin.fav.ui.e.b> rHJ;
  private boolean rHK;
  public b.c rHL;
  public boolean rHM;
  public boolean rHN;
  public ListView rHO;
  private boolean rHz;
  public int scene;
  
  public b(com.tencent.mm.plugin.fav.ui.o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(107086);
    this.rHz = false;
    this.rHA = new ArrayList();
    this.rHB = new ArrayList();
    this.rHC = new LinkedList();
    this.rHD = new ArrayList();
    this.rHE = false;
    this.rHF = new TreeMap();
    this.rHG = new ArrayList();
    this.rHH = new LinkedList();
    this.rHI = new LinkedList();
    this.rHJ = new SparseArray();
    this.rHK = false;
    this.rHM = false;
    this.rHN = false;
    this.query = "";
    this.kzS = new com.tencent.mm.sdk.b.c() {};
    this.type = -1;
    this.rHJ.put(1, new com.tencent.mm.plugin.fav.ui.e.o(paramo));
    this.rHJ.put(2, new f(paramo));
    this.rHJ.put(3, new s(paramo));
    this.rHJ.put(4, new r(paramo));
    this.rHJ.put(5, new q(paramo));
    this.rHJ.put(6, new com.tencent.mm.plugin.fav.ui.e.g(paramo));
    this.rHJ.put(7, new i(paramo));
    this.rHJ.put(8, new d(paramo));
    this.rHJ.put(10, new k(paramo));
    this.rHJ.put(12, new n(paramo));
    this.rHJ.put(15, new n(paramo));
    this.rHJ.put(11, new com.tencent.mm.plugin.fav.ui.e.h(paramo));
    this.rHJ.put(14, new l(paramo));
    this.rHJ.put(16, new m(paramo));
    this.rHJ.put(17, new com.tencent.mm.plugin.fav.ui.e.c(paramo));
    this.rHJ.put(18, new j(paramo));
    this.rHJ.put(20, new e(paramo));
    this.rHJ.put(19, new com.tencent.mm.plugin.fav.ui.e.a(paramo));
    this.rHJ.put(-2, new p(paramo));
    if (paramBoolean != this.rHM)
    {
      this.rHM = paramBoolean;
      if (paramBoolean) {
        this.rHF.clear();
      }
    }
    if (!this.rHM) {
      aTS();
    }
    cyi();
    notifyDataSetChanged();
    com.tencent.mm.sdk.b.a.IvT.d(this.kzS);
    com.tencent.mm.sdk.b.a.IvT.c(this.kzS);
    AppMethodBeat.o(107086);
  }
  
  private void cyj()
  {
    AppMethodBeat.i(107090);
    setSubScene(0);
    this.rHD = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cwT();
    AppMethodBeat.o(107090);
  }
  
  private boolean cyk()
  {
    AppMethodBeat.i(107092);
    if ((!this.rHH.isEmpty()) || (!this.rHI.isEmpty()) || (!this.rHG.isEmpty()))
    {
      AppMethodBeat.o(107092);
      return true;
    }
    AppMethodBeat.o(107092);
    return false;
  }
  
  private void dv(List<com.tencent.mm.plugin.fav.a.g> paramList)
  {
    AppMethodBeat.i(107091);
    if (paramList == null)
    {
      AppMethodBeat.o(107091);
      return;
    }
    ae.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", new Object[] { Integer.valueOf(paramList.size()) });
    ae.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", new Object[] { Integer.valueOf(this.rHC.size()) });
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
          paramList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(((Long)paramList1.get(j)).longValue());
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
    int i = this.otZ;
    if (paramInt == 0) {
      this.otZ = 0;
    }
    do
    {
      return;
      if (i == 0)
      {
        this.otZ = paramInt;
        return;
      }
    } while (i == paramInt);
    this.otZ = 4;
  }
  
  public final com.tencent.mm.plugin.fav.a.g Es(int paramInt)
  {
    AppMethodBeat.i(107104);
    if ((paramInt < 0) || (paramInt >= this.rHA.size()))
    {
      ae.e("MicroMsg.FavoriteAdapter", "get item, but position error");
      localg = new com.tencent.mm.plugin.fav.a.g();
      AppMethodBeat.o(107104);
      return localg;
    }
    com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)this.rHA.get(paramInt);
    AppMethodBeat.o(107104);
    return localg;
  }
  
  public final void a(View paramView, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107108);
    if (paramg == null)
    {
      ae.w("MicroMsg.FavoriteAdapter", "goFavDetail() favItemInfo is null");
      AppMethodBeat.o(107108);
      return;
    }
    if ((!paramg.rAz) || (paramg.rAA == null))
    {
      ae.w("MicroMsg.FavoriteAdapter", "goFavDetail() originInfo not exist");
      AppMethodBeat.o(107108);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramg.rAA;
    String str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
    localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.GCs;
    if (!bu.ht((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
      }
    }
    localObject = new akp();
    ((akp)localObject).scene = this.scene;
    ((akp)localObject).otZ = this.otZ;
    ((akp)localObject).query = this.query;
    ((akp)localObject).sessionId = str;
    ((akp)localObject).rAT = localStringBuilder.toString();
    if (paramView != null) {}
    for (paramView = paramView.getContext();; paramView = ak.getContext())
    {
      paramg.rAA.rAB = paramg.rAB;
      ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, paramg.rAA, (akp)localObject);
      ae.d("MicroMsg.FavoriteAdapter", "goFavDetail type %s %s", new Object[] { Integer.valueOf(paramg.rAA.field_type), paramg.rAB, Integer.valueOf(paramg.field_type) });
      AppMethodBeat.o(107108);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107093);
    if (paramBoolean == this.rHE)
    {
      AppMethodBeat.o(107093);
      return;
    }
    this.rHE = paramBoolean;
    com.tencent.mm.plugin.fav.a.g localg;
    if (paramBoolean)
    {
      this.rHF.clear();
      if (paramg != null)
      {
        localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramg.field_localId);
        if (localg != null)
        {
          if (!paramg.rAz) {
            break label103;
          }
          this.rHF.put(paramg.dtQ, paramg);
        }
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(107093);
      return;
      label103:
      this.rHF.put(bu.dU(Long.valueOf(localg.field_localId)), localg);
    }
  }
  
  public final void aTS()
  {
    AppMethodBeat.i(107088);
    if (cyk())
    {
      ae.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
      AppMethodBeat.o(107088);
      return;
    }
    if (com.tencent.mm.plugin.fav.a.b.cwl())
    {
      ae.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
      AppMethodBeat.o(107088);
      return;
    }
    if (!this.rHM) {
      try
      {
        this.lastUpdateTime = com.tencent.mm.plugin.fav.a.b.y(this.lastUpdateTime, this.type);
        AppMethodBeat.o(107088);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.FavoriteAdapter", localException, "", new Object[0]);
        AppMethodBeat.o(107088);
        return;
      }
    }
    this.rHB = k(this.rHA, this.rHD);
    this.rHz = true;
    AppMethodBeat.o(107088);
  }
  
  public final void c(List<Integer> paramList, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(107097);
    setSubScene(0);
    this.rHG.clear();
    if (paramList != null)
    {
      this.rHG.addAll(paramList);
      if (!paramList.isEmpty()) {
        setSubScene(2);
      }
    }
    this.rHH.clear();
    if (paramList1 != null)
    {
      this.rHH.addAll(paramList1);
      if (!paramList1.isEmpty()) {
        setSubScene(3);
      }
    }
    this.rHI.clear();
    if (paramList2 != null)
    {
      this.rHI.addAll(paramList2);
      if (!paramList2.isEmpty()) {
        setSubScene(1);
      }
    }
    this.rHK = true;
    cyi();
    this.rHK = false;
    AppMethodBeat.o(107097);
  }
  
  public final void cyi()
  {
    AppMethodBeat.i(107098);
    ae.v("MicroMsg.FavoriteAdapter", "reset data list beg");
    this.rHz = false;
    dv(this.rHB);
    if (!cyk())
    {
      ae.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", new Object[] { Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type) });
      if (!this.rHM)
      {
        this.rHB = com.tencent.mm.plugin.fav.a.b.a(this.lastUpdateTime, this.type, this.rHw, this.rHx);
        if ((this.rHB != null) && (this.lastUpdateTime == 0L) && (this.rHB.size() > 0)) {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)this.rHB.get(this.rHB.size() - 1)).field_updateTime;
        }
      }
    }
    int i;
    for (;;)
    {
      if (this.rHB == null)
      {
        ae.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
        this.rHB = new ArrayList();
      }
      if ((!this.rHM) && (!cyk()) && (this.rHB.size() < 20) && (!((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().B(this.lastUpdateTime, this.type)))
      {
        ae.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
        aTS();
      }
      this.rHz = true;
      ae.v("MicroMsg.FavoriteAdapter", "reset data list end");
      AppMethodBeat.o(107098);
      return;
      cyj();
      this.rHB = k(null, this.rHD);
      continue;
      ae.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", new Object[] { this.rHH, this.rHI, this.rHG });
      if ((this.rHG == null) || (this.rHG.size() == 1)) {
        break;
      }
      this.rHB = com.tencent.mm.plugin.fav.a.b.a(this.rHH, this.rHI, this.rHG, this.rHC, this.rHw, this.rHx);
      if (this.rHB != null) {
        break label459;
      }
      i = 0;
      label381:
      com.tencent.mm.plugin.report.service.g.yxI.f(10649, new Object[] { Integer.valueOf(i) });
    }
    if (this.rHG != null) {}
    for (Integer localInteger = (Integer)this.rHG.get(0);; localInteger = null)
    {
      this.rHB = com.tencent.mm.plugin.fav.a.b.a(this.rHH, this.rHI, localInteger.intValue(), this.rHC, this.rHw, this.rHx);
      break;
      label459:
      i = this.rHB.size();
      break label381;
    }
  }
  
  public final int cyl()
  {
    AppMethodBeat.i(107095);
    int i = this.rHF.size();
    AppMethodBeat.o(107095);
    return i;
  }
  
  public final long cym()
  {
    AppMethodBeat.i(107096);
    Iterator localIterator = this.rHF.values().iterator();
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
    com.tencent.mm.sdk.b.a.IvT.d(this.kzS);
    AppMethodBeat.o(107087);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(107105);
    int i = this.rHA.size();
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
    com.tencent.mm.plugin.fav.a.g localg = Es(paramInt - 1);
    switch (localg.field_type)
    {
    case 9: 
    case 13: 
    default: 
      ae.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", new Object[] { Integer.valueOf(localg.field_type) });
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
    com.tencent.mm.plugin.fav.a.g localg = Es(paramInt - 1);
    com.tencent.mm.plugin.fav.ui.e.b localb = (com.tencent.mm.plugin.fav.ui.e.b)this.rHJ.get(localg.field_type);
    if (localb == null)
    {
      ae.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", new Object[] { Integer.valueOf(localg.field_type) });
      localb = (com.tencent.mm.plugin.fav.ui.e.b)this.rHJ.get(-2);
      cyh();
      paramView = localb.a(paramView, paramViewGroup, localg);
      AppMethodBeat.o(107103);
      return paramView;
    }
    localb.rLs.odI = cyk();
    localb.rLs.lastUpdateTime = this.lastUpdateTime;
    localb.rLs.rHE = this.rHE;
    localb.rLs.rHF = this.rHF;
    localb.rLs.rLu = this.rHL;
    localb.rLs.rHM = this.rHM;
    paramView = localb.a(paramView, paramViewGroup, localg);
    AppMethodBeat.o(107103);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(107102);
    int i = this.rHJ.size();
    AppMethodBeat.o(107102);
    return i + 4;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(107099);
    boolean bool = this.rHA.isEmpty();
    AppMethodBeat.o(107099);
    return bool;
  }
  
  public final List<com.tencent.mm.plugin.fav.a.g> lB(boolean paramBoolean)
  {
    AppMethodBeat.i(107094);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.rHF.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (localg != null) {
        localLinkedList.add(localg);
      }
    }
    if (paramBoolean) {
      this.rHF.clear();
    }
    AppMethodBeat.o(107094);
    return localLinkedList;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(107100);
    ae.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", new Object[] { Boolean.valueOf(this.rHz) });
    if (this.rHz)
    {
      if ((this.rHM) && (this.rHB != null) && (this.rHA != null) && (this.rHB.size() == this.rHA.size())) {
        this.rHN = true;
      }
      List localList = this.rHA;
      this.rHA = this.rHB;
      this.rHB = localList;
      this.rHz = false;
    }
    ae.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
    super.notifyDataSetChanged();
    AppMethodBeat.o(107100);
  }
  
  public final int o(long paramLong, String paramString)
  {
    int i = 1;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(107106);
    Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(107106);
      return -1;
    }
    if (this.rHF.size() >= 30)
    {
      ae.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
      com.tencent.mm.ui.base.h.cm(ak.getContext(), ak.getContext().getResources().getString(2131758927, new Object[] { Integer.valueOf(30) }));
      AppMethodBeat.o(107106);
      return -1;
    }
    com.tencent.mm.plugin.fav.a.g localg;
    if (!bu.isNullOrNil(paramString))
    {
      Iterator localIterator = this.rHA.iterator();
      while (localIterator.hasNext())
      {
        localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
        if (bu.lX(localg.dtQ, paramString))
        {
          localg.rAA = ((com.tencent.mm.plugin.fav.a.g)localObject);
          localObject = localg;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.rHF.put(paramString, localObject);
        if (((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime < this.lastUpdateTime)
        {
          this.lastUpdateTime = ((com.tencent.mm.plugin.fav.a.g)localObject).field_updateTime;
          cyi();
          localObject = this.rHB.iterator();
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
          if (bu.isNullOrNil(paramString))
          {
            if (localg.field_localId != paramLong) {
              break label353;
            }
            notifyDataSetChanged();
            AppMethodBeat.o(107106);
            return i;
            this.rHF.put(bu.dU(Long.valueOf(paramLong)), localObject);
            break;
          }
          if ((localg.field_localId == paramLong) && (bu.lX(paramString, localg.dtQ)))
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
        localObject = this.rHA.iterator();
        i = k;
        while (((Iterator)localObject).hasNext())
        {
          localg = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject).next();
          if (bu.isNullOrNil(paramString))
          {
            if (localg.field_localId == paramLong)
            {
              notifyDataSetChanged();
              AppMethodBeat.o(107106);
              return i;
            }
          }
          else if ((localg.field_localId == paramLong) && (bu.lX(paramString, localg.dtQ)))
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
      ae.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
      AppMethodBeat.o(107107);
      return;
    }
    if (paramAdapterView.rBM == null)
    {
      ae.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
      AppMethodBeat.o(107107);
      return;
    }
    if ((this.rHE) || (this.rHM))
    {
      if ((!paramAdapterView.iYl.isChecked()) && (this.rHF.size() >= 30))
      {
        ae.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[] { Integer.valueOf(30) });
        com.tencent.mm.ui.base.h.cm(ak.getContext(), ak.getContext().getResources().getString(2131758927, new Object[] { Integer.valueOf(30) }));
        AppMethodBeat.o(107107);
        return;
      }
      paramView = paramAdapterView.iYl;
      if (!paramAdapterView.iYl.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        AppMethodBeat.o(107107);
        return;
      }
    }
    com.tencent.mm.plugin.fav.ui.e.b localb = (com.tencent.mm.plugin.fav.ui.e.b)this.rHJ.get(paramAdapterView.rBM.field_type);
    StringBuilder localStringBuilder;
    Object localObject;
    String str;
    if (localb != null)
    {
      localStringBuilder = new StringBuilder();
      localObject = paramAdapterView.rBM;
      str = ((com.tencent.mm.plugin.fav.a.g)localObject).field_id + "_" + System.currentTimeMillis() / 1000L;
      localObject = ((com.tencent.mm.plugin.fav.a.g)localObject).field_tagProto.GCs;
      if (!bu.ht((List)localObject))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append((String)((Iterator)localObject).next()).append(";");
        }
      }
      localObject = new akp();
      ((akp)localObject).scene = this.scene;
      ((akp)localObject).otZ = this.otZ;
      if (this.rHO == null) {
        break label439;
      }
    }
    label439:
    for (((akp)localObject).index = (paramInt - this.rHO.getHeaderViewsCount());; ((akp)localObject).index = paramInt)
    {
      ((akp)localObject).query = this.query;
      ((akp)localObject).sessionId = str;
      ((akp)localObject).rAT = localStringBuilder.toString();
      localb.a(paramView, (akp)localObject);
      ae.d("MicroMsg.FavoriteAdapter", "item click type %s", new Object[] { Integer.valueOf(paramAdapterView.rBM.field_type) });
      AppMethodBeat.o(107107);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.b
 * JD-Core Version:    0.7.0.1
 */