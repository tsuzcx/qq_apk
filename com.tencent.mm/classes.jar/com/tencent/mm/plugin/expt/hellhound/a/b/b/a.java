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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "", "()V", "mFavListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1;", "mFavMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mLbsListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1;", "mLbsMethodMap", "", "", "mMixSearchListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1;", "mMixSearchMethodMap", "mProfileListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1;", "mProfileMethodMap", "mTopicListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1;", "mTopicMethodMap", "monitor", "", "onFeedClick", "obj", "position", "", "registerListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"})
public final class a
{
  private static final List<d> mListeners;
  public static final a.a qVr;
  private final HashMap<String, Pair<String, List<Pair<String, String>>>> qVh;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> qVi;
  private final HashMap<String, List<Pair<String, String>>> qVj;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> qVk;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> qVl;
  private final b qVm;
  private final c qVn;
  private final e qVo;
  private final f qVp;
  private final d qVq;
  
  static
  {
    AppMethodBeat.i(210767);
    qVr = new a.a((byte)0);
    mListeners = (List)new ArrayList();
    AppMethodBeat.o(210767);
  }
  
  public a()
  {
    AppMethodBeat.i(210766);
    this.qVh = new HashMap();
    this.qVi = new HashMap();
    this.qVj = new HashMap();
    this.qVk = new HashMap();
    this.qVl = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    ((Map)this.qVh).put("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", new Pair("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", localObject));
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", localObject);
    ((Map)this.qVi).put("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$", localHashMap);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new Pair("jumpProfileTimeline", "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    ((Map)this.qVj).put("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter", localObject);
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", localObject);
    ((Map)this.qVk).put("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$", localHashMap);
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", localObject);
    ((Map)this.qVl).put("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", localHashMap);
    this.qVm = new b(this);
    this.qVn = new c(this);
    this.qVo = new e(this);
    this.qVp = new f(this);
    this.qVq = new d(this);
    AppMethodBeat.o(210766);
  }
  
  public final void a(d paramd)
  {
    try
    {
      AppMethodBeat.i(210763);
      p.h(paramd, "listener");
      if (!mListeners.contains(paramd)) {
        mListeners.add(paramd);
      }
      AppMethodBeat.o(210763);
      return;
    }
    finally {}
  }
  
  public final void b(d paramd)
  {
    try
    {
      AppMethodBeat.i(210764);
      p.h(paramd, "listener");
      mListeners.remove(paramd);
      AppMethodBeat.o(210764);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public final void cnf()
  {
    AppMethodBeat.i(210761);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.c((Map)this.qVh, (c)this.qVm);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.e((Map)this.qVi, (c)this.qVn);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a((Map)this.qVj, (c)this.qVo);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.e((Map)this.qVk, (c)this.qVp);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.e((Map)this.qVl, (c)this.qVq);
    AppMethodBeat.o(210761);
  }
  
  public final void coM()
  {
    AppMethodBeat.i(210762);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.d((Map)this.qVh, (c)this.qVm);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.f((Map)this.qVi, (c)this.qVn);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.b((Map)this.qVj, (c)this.qVo);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.f((Map)this.qVk, (c)this.qVp);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.f((Map)this.qVl, (c)this.qVq);
    AppMethodBeat.o(210762);
  }
  
  public final void i(Object paramObject, int paramInt)
  {
    try
    {
      AppMethodBeat.i(210765);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).i(paramObject, paramInt);
      }
      AppMethodBeat.o(210765);
    }
    finally {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(210756);
      if ((paramString1 != null) && (n.nz(paramString1, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback")) && (p.i(paramString2, "onGridItemClick")) && (p.i(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (((paramArrayOfObject[0] instanceof RecyclerView.a)) && (paramArrayOfObject[0] == null))
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(210756);
            throw paramString1;
          }
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label193;
          }
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(210756);
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
            AppMethodBeat.o(210756);
            throw paramString1;
          }
          i = ((Integer)paramString2).intValue();
        }
        this.qVs.i(paramString1, i);
        AppMethodBeat.o(210756);
        return;
        AppMethodBeat.o(210756);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class c
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(210757);
      if ((paramString1 != null) && (n.nz(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$")) && (p.i(paramString2, "onItemClick")) && (p.i(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (((paramArrayOfObject[0] instanceof RecyclerView.a)) && (paramArrayOfObject[0] == null))
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(210757);
            throw paramString1;
          }
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label193;
          }
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(210757);
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
            AppMethodBeat.o(210757);
            throw paramString1;
          }
          i = ((Integer)paramString2).intValue();
        }
        this.qVs.i(paramString1, i);
        AppMethodBeat.o(210757);
        return;
        AppMethodBeat.o(210757);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class d
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(210758);
      if ((paramString1 != null) && (n.nz(paramString1, "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter")) && (p.i(paramString2, "onFeedItemClick")) && (p.i(paramString3, "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V")) && (paramArrayOfObject != null))
      {
        paramString1 = paramArrayOfObject[0];
        this.qVs.i(paramString1, -1);
      }
      AppMethodBeat.o(210758);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class e
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(210759);
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
              AppMethodBeat.o(210759);
              throw paramString1;
            }
            i = ((Integer)paramString1).intValue();
          }
          paramString1 = paramArrayOfObject[1];
          this.qVs.i(paramString1, i);
        }
        AppMethodBeat.o(210759);
        return;
      }
      AppMethodBeat.o(210759);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class f
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      paramObject = null;
      AppMethodBeat.i(210760);
      if ((paramString1 != null) && (n.nz(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$")) && (p.i(paramString2, "onItemClick")) && (p.i(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (!(paramArrayOfObject[0] instanceof RecyclerView.a)) {
            break label231;
          }
          paramString1 = paramArrayOfObject[0];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(210760);
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
            AppMethodBeat.o(210760);
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
            AppMethodBeat.o(210760);
            throw paramString1;
          }
          i = ((Integer)paramString3).intValue();
          if (!(paramString1 instanceof com.tencent.mm.view.recyclerview.d)) {
            break label228;
          }
          i -= ((com.tencent.mm.view.recyclerview.d)paramString1).Lvi.size();
        }
        for (;;)
        {
          this.qVs.i(paramString2, i);
          AppMethodBeat.o(210760);
          return;
          AppMethodBeat.o(210760);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */