package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.support.v7.widget.RecyclerView.a;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "", "()V", "mFavListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1;", "mFavMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mLbsListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1;", "mLbsMethodMap", "", "", "mMixSearchListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1;", "mMixSearchMethodMap", "mProfileListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1;", "mProfileMethodMap", "mTopicListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1;", "mTopicMethodMap", "monitor", "", "onFeedClick", "obj", "position", "", "registerListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"})
public final class a
{
  private static final List<d> mListeners;
  public static final a.a qmu;
  private final HashMap<String, Pair<String, List<Pair<String, String>>>> qmk;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> qml;
  private final HashMap<String, List<Pair<String, String>>> qmm;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> qmn;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> qmo;
  private final b qmp;
  private final c qmq;
  private final e qmr;
  private final f qms;
  private final d qmt;
  
  static
  {
    AppMethodBeat.i(195420);
    qmu = new a.a((byte)0);
    mListeners = (List)new ArrayList();
    AppMethodBeat.o(195420);
  }
  
  public a()
  {
    AppMethodBeat.i(195419);
    this.qmk = new HashMap();
    this.qml = new HashMap();
    this.qmm = new HashMap();
    this.qmn = new HashMap();
    this.qmo = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    ((Map)this.qmk).put("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", new Pair("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", localObject));
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", localObject);
    ((Map)this.qml).put("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$", localHashMap);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new Pair("jumpProfileTimeline", "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    ((Map)this.qmm).put("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter", localObject);
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", localObject);
    ((Map)this.qmn).put("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$", localHashMap);
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", localObject);
    ((Map)this.qmo).put("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", localHashMap);
    this.qmp = new b(this);
    this.qmq = new c(this);
    this.qmr = new e(this);
    this.qms = new f(this);
    this.qmt = new d(this);
    AppMethodBeat.o(195419);
  }
  
  public final void a(d paramd)
  {
    try
    {
      AppMethodBeat.i(195416);
      k.h(paramd, "listener");
      if (!mListeners.contains(paramd)) {
        mListeners.add(paramd);
      }
      AppMethodBeat.o(195416);
      return;
    }
    finally {}
  }
  
  public final void b(d paramd)
  {
    try
    {
      AppMethodBeat.i(195417);
      k.h(paramd, "listener");
      mListeners.remove(paramd);
      AppMethodBeat.o(195417);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public final void cjA()
  {
    AppMethodBeat.i(195414);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.c((Map)this.qmk, (c)this.qmp);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.e((Map)this.qml, (c)this.qmq);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.a((Map)this.qmm, (c)this.qmr);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.e((Map)this.qmn, (c)this.qms);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.e((Map)this.qmo, (c)this.qmt);
    AppMethodBeat.o(195414);
  }
  
  public final void cjB()
  {
    AppMethodBeat.i(195415);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.d((Map)this.qmk, (c)this.qmp);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.f((Map)this.qml, (c)this.qmq);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.b((Map)this.qmm, (c)this.qmr);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.f((Map)this.qmn, (c)this.qms);
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.f((Map)this.qmo, (c)this.qmt);
    AppMethodBeat.o(195415);
  }
  
  public final void h(Object paramObject, int paramInt)
  {
    try
    {
      AppMethodBeat.i(195418);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).h(paramObject, paramInt);
      }
      AppMethodBeat.o(195418);
    }
    finally {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(195409);
      if ((paramString1 != null) && (n.nb(paramString1, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback")) && (k.g(paramString2, "onGridItemClick")) && (k.g(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (((paramArrayOfObject[0] instanceof RecyclerView.a)) && (paramArrayOfObject[0] == null))
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(195409);
            throw paramString1;
          }
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label193;
          }
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(195409);
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
            AppMethodBeat.o(195409);
            throw paramString1;
          }
          i = ((Integer)paramString2).intValue();
        }
        this.qmv.h(paramString1, i);
        AppMethodBeat.o(195409);
        return;
        AppMethodBeat.o(195409);
        return;
      }
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class c
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(195410);
      if ((paramString1 != null) && (n.nb(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$")) && (k.g(paramString2, "onItemClick")) && (k.g(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (((paramArrayOfObject[0] instanceof RecyclerView.a)) && (paramArrayOfObject[0] == null))
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(195410);
            throw paramString1;
          }
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label193;
          }
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(195410);
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
            AppMethodBeat.o(195410);
            throw paramString1;
          }
          i = ((Integer)paramString2).intValue();
        }
        this.qmv.h(paramString1, i);
        AppMethodBeat.o(195410);
        return;
        AppMethodBeat.o(195410);
        return;
      }
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class d
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(195411);
      if ((paramString1 != null) && (n.nb(paramString1, "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter")) && (k.g(paramString2, "onFeedItemClick")) && (k.g(paramString3, "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V")) && (paramArrayOfObject != null))
      {
        paramString1 = paramArrayOfObject[0];
        this.qmv.h(paramString1, -1);
      }
      AppMethodBeat.o(195411);
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class e
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(195412);
      if ((k.g(paramString1, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter")) && (k.g(paramString2, "jumpProfileTimeline")) && (k.g(paramString3, "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V")) && (paramArrayOfObject != null))
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
              AppMethodBeat.o(195412);
              throw paramString1;
            }
            i = ((Integer)paramString1).intValue();
          }
          paramString1 = paramArrayOfObject[1];
          this.qmv.h(paramString1, i);
        }
        AppMethodBeat.o(195412);
        return;
      }
      AppMethodBeat.o(195412);
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class f
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      paramObject = null;
      AppMethodBeat.i(195413);
      if ((paramString1 != null) && (n.nb(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$")) && (k.g(paramString2, "onItemClick")) && (k.g(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (!(paramArrayOfObject[0] instanceof RecyclerView.a)) {
            break label231;
          }
          paramString1 = paramArrayOfObject[0];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(195413);
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
            AppMethodBeat.o(195413);
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
            AppMethodBeat.o(195413);
            throw paramString1;
          }
          i = ((Integer)paramString3).intValue();
          if (!(paramString1 instanceof com.tencent.mm.view.recyclerview.d)) {
            break label228;
          }
          i -= ((com.tencent.mm.view.recyclerview.d)paramString1).JCb.size();
        }
        for (;;)
        {
          this.qmv.h(paramString2, i);
          AppMethodBeat.o(195413);
          return;
          AppMethodBeat.o(195413);
          return;
        }
      }
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */