package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.support.v7.widget.RecyclerView.a;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "", "()V", "mFavListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1;", "mFavMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mLbsListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1;", "mLbsMethodMap", "", "", "mMixSearchListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1;", "mMixSearchMethodMap", "mProfileListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1;", "mProfileMethodMap", "mTopicListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1;", "mTopicMethodMap", "monitor", "", "onFeedClick", "obj", "position", "", "registerListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"})
public final class a
{
  private static final List<d> mListeners;
  public static final a.a sDW;
  private final HashMap<String, Pair<String, List<Pair<String, String>>>> sDM;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> sDN;
  private final HashMap<String, List<Pair<String, String>>> sDO;
  private final HashMap<String, Pair<String, List<Pair<String, String>>>> sDP;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> sDQ;
  private final b sDR;
  private final c sDS;
  private final e sDT;
  private final f sDU;
  private final d sDV;
  
  static
  {
    AppMethodBeat.i(220899);
    sDW = new a.a((byte)0);
    mListeners = (List)new ArrayList();
    AppMethodBeat.o(220899);
  }
  
  public a()
  {
    AppMethodBeat.i(220898);
    this.sDM = new HashMap();
    this.sDN = new HashMap();
    this.sDO = new HashMap();
    this.sDP = new HashMap();
    this.sDQ = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    ((Map)this.sDM).put("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", new Pair("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", localObject));
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)V"));
    ((List)localObject).add(new Pair("onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", localObject);
    ((Map)this.sDN).put("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$", localHashMap);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new Pair("jumpProfileTimeline", "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    ((Map)this.sDO).put("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter", localObject);
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    ((Map)this.sDP).put("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", new Pair("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", localObject));
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", localObject);
    ((Map)this.sDQ).put("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", localHashMap);
    this.sDR = new b(this);
    this.sDS = new c(this);
    this.sDT = new e(this);
    this.sDU = new f(this);
    this.sDV = new d(this);
    AppMethodBeat.o(220898);
  }
  
  public final void a(d paramd)
  {
    try
    {
      AppMethodBeat.i(220895);
      p.h(paramd, "listener");
      if (!mListeners.contains(paramd)) {
        mListeners.add(paramd);
      }
      AppMethodBeat.o(220895);
      return;
    }
    finally {}
  }
  
  public final void b(d paramd)
  {
    try
    {
      AppMethodBeat.i(220896);
      p.h(paramd, "listener");
      mListeners.remove(paramd);
      AppMethodBeat.o(220896);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public final void cMH()
  {
    AppMethodBeat.i(220893);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.c((Map)this.sDM, (c)this.sDR);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.e((Map)this.sDN, (c)this.sDS);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a((Map)this.sDO, (c)this.sDT);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.c((Map)this.sDP, (c)this.sDU);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.e((Map)this.sDQ, (c)this.sDV);
    AppMethodBeat.o(220893);
  }
  
  public final void cOG()
  {
    AppMethodBeat.i(220894);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.d((Map)this.sDM, (c)this.sDR);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.f((Map)this.sDN, (c)this.sDS);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.b((Map)this.sDO, (c)this.sDT);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.d((Map)this.sDP, (c)this.sDU);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.f((Map)this.sDQ, (c)this.sDV);
    AppMethodBeat.o(220894);
  }
  
  public final void k(Object paramObject, int paramInt)
  {
    try
    {
      AppMethodBeat.i(220897);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).k(paramObject, paramInt);
      }
      AppMethodBeat.o(220897);
    }
    finally {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(220888);
      if ((paramString1 != null) && (n.J(paramString1, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", false)) && (p.j(paramString2, "onGridItemClick")) && (p.j(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (((paramArrayOfObject[0] instanceof RecyclerView.a)) && (paramArrayOfObject[0] == null))
          {
            paramString1 = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(220888);
            throw paramString1;
          }
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label194;
          }
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(220888);
            throw paramString1;
          }
        }
      }
      label194:
      for (paramString1 = (View)paramString1;; paramString1 = null)
      {
        int i = -1;
        if ((paramArrayOfObject[2] instanceof Integer))
        {
          paramString2 = paramArrayOfObject[2];
          if (paramString2 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(220888);
            throw paramString1;
          }
          i = ((Integer)paramString2).intValue();
        }
        this.sDX.k(paramString1, i);
        AppMethodBeat.o(220888);
        return;
        AppMethodBeat.o(220888);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class c
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(220889);
      if ((paramString1 != null) && (n.J(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$", false)) && (p.j(paramString2, "onItemClick")) && ((p.j(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)V")) || (p.j(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V"))) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (((paramArrayOfObject[0] instanceof RecyclerView.a)) && (paramArrayOfObject[0] == null))
          {
            paramString1 = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(220889);
            throw paramString1;
          }
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label203;
          }
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(220889);
            throw paramString1;
          }
        }
      }
      label203:
      for (paramString1 = (View)paramString1;; paramString1 = null)
      {
        int i = -1;
        if ((paramArrayOfObject[2] instanceof Integer))
        {
          paramString2 = paramArrayOfObject[2];
          if (paramString2 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(220889);
            throw paramString1;
          }
          i = ((Integer)paramString2).intValue();
        }
        this.sDX.k(paramString1, i);
        AppMethodBeat.o(220889);
        return;
        AppMethodBeat.o(220889);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class d
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(220890);
      if ((paramString1 != null) && (n.J(paramString1, "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", false)) && (p.j(paramString2, "onFeedItemClick")) && (p.j(paramString3, "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V")) && (paramArrayOfObject != null))
      {
        paramString1 = paramArrayOfObject[0];
        this.sDX.k(paramString1, -1);
      }
      AppMethodBeat.o(220890);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class e
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(220891);
      if ((p.j(paramString1, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter")) && (p.j(paramString2, "jumpProfileTimeline")) && (p.j(paramString3, "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V")) && (paramArrayOfObject != null))
      {
        if (paramArrayOfObject.length >= 2)
        {
          int i = -1;
          if ((paramArrayOfObject[0] instanceof Integer))
          {
            paramString1 = paramArrayOfObject[0];
            if (paramString1 == null)
            {
              paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(220891);
              throw paramString1;
            }
            i = ((Integer)paramString1).intValue();
          }
          paramString1 = paramArrayOfObject[1];
          this.sDX.k(paramString1, i);
        }
        AppMethodBeat.o(220891);
        return;
      }
      AppMethodBeat.o(220891);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class f
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      paramObject = null;
      AppMethodBeat.i(220892);
      if ((paramString1 != null) && (n.J(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", false)) && (p.j(paramString2, "onGridItemClick")) && (p.j(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (!(paramArrayOfObject[0] instanceof RecyclerView.a)) {
            break label232;
          }
          paramString1 = paramArrayOfObject[0];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(220892);
            throw paramString1;
          }
        }
      }
      label229:
      label232:
      for (paramString1 = (RecyclerView.a)paramString1;; paramString1 = null)
      {
        paramString2 = paramObject;
        if ((paramArrayOfObject[1] instanceof View))
        {
          paramString2 = paramArrayOfObject[1];
          if (paramString2 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(220892);
            throw paramString1;
          }
          paramString2 = (View)paramString2;
        }
        int i = -1;
        if ((paramArrayOfObject[2] instanceof Integer))
        {
          paramString3 = paramArrayOfObject[2];
          if (paramString3 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(220892);
            throw paramString1;
          }
          i = ((Integer)paramString3).intValue();
          if (!(paramString1 instanceof g)) {
            break label229;
          }
          i -= ((g)paramString1).RqM.size();
        }
        for (;;)
        {
          this.sDX.k(paramString2, i);
          AppMethodBeat.o(220892);
          return;
          AppMethodBeat.o(220892);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */