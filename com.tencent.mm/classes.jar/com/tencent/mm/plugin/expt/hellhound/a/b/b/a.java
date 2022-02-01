package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.support.v7.widget.RecyclerView.a;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "", "()V", "mFavListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1;", "mFavMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mLbsListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1;", "mLbsMethodMap", "", "", "mMixSearchListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1;", "mMixSearchMethodMap", "mProfileListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1;", "mProfileMethodMap", "mTopicListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1;", "mTopicMethodMap", "monitor", "", "onFeedClick", "obj", "position", "", "registerListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"})
public final class a
{
  private static final List<d> mListeners;
  public static final a.a rdp;
  private final HashMap<String, Pair<String, List<Pair<String, String>>>> rdf;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> rdg;
  private final HashMap<String, List<Pair<String, String>>> rdh;
  private final HashMap<String, Pair<String, List<Pair<String, String>>>> rdi;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> rdj;
  private final b rdk;
  private final c rdl;
  private final e rdm;
  private final f rdn;
  private final d rdo;
  
  static
  {
    AppMethodBeat.i(196434);
    rdp = new a.a((byte)0);
    mListeners = (List)new ArrayList();
    AppMethodBeat.o(196434);
  }
  
  public a()
  {
    AppMethodBeat.i(196433);
    this.rdf = new HashMap();
    this.rdg = new HashMap();
    this.rdh = new HashMap();
    this.rdi = new HashMap();
    this.rdj = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    ((Map)this.rdf).put("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", new Pair("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", localObject));
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)V"));
    ((List)localObject).add(new Pair("onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", localObject);
    ((Map)this.rdg).put("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$", localHashMap);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new Pair("jumpProfileTimeline", "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    ((Map)this.rdh).put("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter", localObject);
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    ((Map)this.rdi).put("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", new Pair("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", localObject));
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", localObject);
    ((Map)this.rdj).put("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", localHashMap);
    this.rdk = new b(this);
    this.rdl = new c(this);
    this.rdm = new e(this);
    this.rdn = new f(this);
    this.rdo = new d(this);
    AppMethodBeat.o(196433);
  }
  
  public final void a(d paramd)
  {
    try
    {
      AppMethodBeat.i(196430);
      p.h(paramd, "listener");
      if (!mListeners.contains(paramd)) {
        mListeners.add(paramd);
      }
      AppMethodBeat.o(196430);
      return;
    }
    finally {}
  }
  
  public final void b(d paramd)
  {
    try
    {
      AppMethodBeat.i(196431);
      p.h(paramd, "listener");
      mListeners.remove(paramd);
      AppMethodBeat.o(196431);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public final void cov()
  {
    AppMethodBeat.i(196428);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.c((Map)this.rdf, (c)this.rdk);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.e((Map)this.rdg, (c)this.rdl);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a((Map)this.rdh, (c)this.rdm);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.c((Map)this.rdi, (c)this.rdn);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.e((Map)this.rdj, (c)this.rdo);
    AppMethodBeat.o(196428);
  }
  
  public final void cqo()
  {
    AppMethodBeat.i(196429);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.d((Map)this.rdf, (c)this.rdk);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.f((Map)this.rdg, (c)this.rdl);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.b((Map)this.rdh, (c)this.rdm);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.d((Map)this.rdi, (c)this.rdn);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.f((Map)this.rdj, (c)this.rdo);
    AppMethodBeat.o(196429);
  }
  
  public final void i(Object paramObject, int paramInt)
  {
    try
    {
      AppMethodBeat.i(196432);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).i(paramObject, paramInt);
      }
      AppMethodBeat.o(196432);
    }
    finally {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(196423);
      if ((paramString1 != null) && (n.nF(paramString1, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback")) && (p.i(paramString2, "onGridItemClick")) && (p.i(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (((paramArrayOfObject[0] instanceof RecyclerView.a)) && (paramArrayOfObject[0] == null))
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(196423);
            throw paramString1;
          }
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label193;
          }
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(196423);
            throw paramString1;
          }
        }
      }
      label193:
      for (paramString1 = (View)paramString1;; paramString1 = null)
      {
        int i = -1;
        if ((paramArrayOfObject[2] instanceof Integer))
        {
          paramString2 = paramArrayOfObject[2];
          if (paramString2 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(196423);
            throw paramString1;
          }
          i = ((Integer)paramString2).intValue();
        }
        this.rdq.i(paramString1, i);
        AppMethodBeat.o(196423);
        return;
        AppMethodBeat.o(196423);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class c
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(196424);
      if ((paramString1 != null) && (n.nF(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$")) && (p.i(paramString2, "onItemClick")) && ((p.i(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILandroid/support/v7/widget/RecyclerView$ViewHolder;)V")) || (p.i(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V"))) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (((paramArrayOfObject[0] instanceof RecyclerView.a)) && (paramArrayOfObject[0] == null))
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(196424);
            throw paramString1;
          }
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label202;
          }
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(196424);
            throw paramString1;
          }
        }
      }
      label202:
      for (paramString1 = (View)paramString1;; paramString1 = null)
      {
        int i = -1;
        if ((paramArrayOfObject[2] instanceof Integer))
        {
          paramString2 = paramArrayOfObject[2];
          if (paramString2 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(196424);
            throw paramString1;
          }
          i = ((Integer)paramString2).intValue();
        }
        this.rdq.i(paramString1, i);
        AppMethodBeat.o(196424);
        return;
        AppMethodBeat.o(196424);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class d
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(196425);
      if ((paramString1 != null) && (n.nF(paramString1, "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter")) && (p.i(paramString2, "onFeedItemClick")) && (p.i(paramString3, "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V")) && (paramArrayOfObject != null))
      {
        paramString1 = paramArrayOfObject[0];
        this.rdq.i(paramString1, -1);
      }
      AppMethodBeat.o(196425);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class e
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(196426);
      if ((p.i(paramString1, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter")) && (p.i(paramString2, "jumpProfileTimeline")) && (p.i(paramString3, "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V")) && (paramArrayOfObject != null))
      {
        if (paramArrayOfObject.length >= 2)
        {
          int i = -1;
          if ((paramArrayOfObject[0] instanceof Integer))
          {
            paramString1 = paramArrayOfObject[0];
            if (paramString1 == null)
            {
              paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(196426);
              throw paramString1;
            }
            i = ((Integer)paramString1).intValue();
          }
          paramString1 = paramArrayOfObject[1];
          this.rdq.i(paramString1, i);
        }
        AppMethodBeat.o(196426);
        return;
      }
      AppMethodBeat.o(196426);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class f
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      paramObject = null;
      AppMethodBeat.i(196427);
      if ((paramString1 != null) && (n.nF(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback")) && (p.i(paramString2, "onGridItemClick")) && (p.i(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (!(paramArrayOfObject[0] instanceof RecyclerView.a)) {
            break label231;
          }
          paramString1 = paramArrayOfObject[0];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(196427);
            throw paramString1;
          }
        }
      }
      label228:
      label231:
      for (paramString1 = (RecyclerView.a)paramString1;; paramString1 = null)
      {
        paramString2 = paramObject;
        if ((paramArrayOfObject[1] instanceof View))
        {
          paramString2 = paramArrayOfObject[1];
          if (paramString2 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(196427);
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
            paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(196427);
            throw paramString1;
          }
          i = ((Integer)paramString3).intValue();
          if (!(paramString1 instanceof com.tencent.mm.view.recyclerview.d)) {
            break label228;
          }
          i -= ((com.tencent.mm.view.recyclerview.d)paramString1).LRV.size();
        }
        for (;;)
        {
          this.rdq.i(paramString2, i);
          AppMethodBeat.o(196427);
          return;
          AppMethodBeat.o(196427);
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