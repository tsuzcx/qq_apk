package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.util.Pair;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "", "()V", "mFavListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1;", "mFavMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mLbsListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1;", "mLbsMethodMap", "", "", "mMixSearchListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1;", "mMixSearchMethodMap", "mProfileListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1;", "mProfileMethodMap", "mTopicListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1;", "mTopicMethodMap", "monitor", "", "onFeedClick", "obj", "position", "", "registerListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"})
public final class a
{
  private static final List<d> mListeners;
  public static final a.a wjQ;
  private final HashMap<String, Pair<String, List<Pair<String, String>>>> wjG;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> wjH;
  private final HashMap<String, List<Pair<String, String>>> wjI;
  private final HashMap<String, Pair<String, List<Pair<String, String>>>> wjJ;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> wjK;
  private final b wjL;
  private final c wjM;
  private final e wjN;
  private final f wjO;
  private final d wjP;
  
  static
  {
    AppMethodBeat.i(254054);
    wjQ = new a.a((byte)0);
    mListeners = (List)new ArrayList();
    AppMethodBeat.o(254054);
  }
  
  public a()
  {
    AppMethodBeat.i(254053);
    this.wjG = new HashMap();
    this.wjH = new HashMap();
    this.wjI = new HashMap();
    this.wjJ = new HashMap();
    this.wjK = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    ((Map)this.wjG).put("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", new Pair("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", localObject));
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;)V"));
    ((List)localObject).add(new Pair("onItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", localObject);
    ((Map)this.wjH).put("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$", localHashMap);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new Pair("jumpProfileTimeline", "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    ((Map)this.wjI).put("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter", localObject);
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    ((Map)this.wjJ).put("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", new Pair("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", localObject));
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", localObject);
    ((Map)this.wjK).put("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", localHashMap);
    this.wjL = new b(this);
    this.wjM = new c(this);
    this.wjN = new e(this);
    this.wjO = new f(this);
    this.wjP = new d(this);
    AppMethodBeat.o(254053);
  }
  
  public final void Xr()
  {
    AppMethodBeat.i(254047);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.c((Map)this.wjG, (com.tencent.mm.hellhoundlib.a.d)this.wjL);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.e((Map)this.wjH, (com.tencent.mm.hellhoundlib.a.d)this.wjM);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((Map)this.wjI, (com.tencent.mm.hellhoundlib.a.d)this.wjN);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.c((Map)this.wjJ, (com.tencent.mm.hellhoundlib.a.d)this.wjO);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.e((Map)this.wjK, (com.tencent.mm.hellhoundlib.a.d)this.wjP);
    AppMethodBeat.o(254047);
  }
  
  public final void a(d paramd)
  {
    try
    {
      AppMethodBeat.i(254049);
      p.k(paramd, "listener");
      if (!mListeners.contains(paramd)) {
        mListeners.add(paramd);
      }
      AppMethodBeat.o(254049);
      return;
    }
    finally {}
  }
  
  public final void b(d paramd)
  {
    try
    {
      AppMethodBeat.i(254050);
      p.k(paramd, "listener");
      mListeners.remove(paramd);
      AppMethodBeat.o(254050);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public final void ddy()
  {
    AppMethodBeat.i(254048);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.d((Map)this.wjG, (com.tencent.mm.hellhoundlib.a.d)this.wjL);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.f((Map)this.wjH, (com.tencent.mm.hellhoundlib.a.d)this.wjM);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.b((Map)this.wjI, (com.tencent.mm.hellhoundlib.a.d)this.wjN);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.d((Map)this.wjJ, (com.tencent.mm.hellhoundlib.a.d)this.wjO);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.f((Map)this.wjK, (com.tencent.mm.hellhoundlib.a.d)this.wjP);
    AppMethodBeat.o(254048);
  }
  
  public final void o(Object paramObject, int paramInt)
  {
    try
    {
      AppMethodBeat.i(254051);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).o(paramObject, paramInt);
      }
      AppMethodBeat.o(254051);
    }
    finally {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(252746);
      if ((paramString1 != null) && (n.M(paramString1, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", false)) && (p.h(paramString2, "onGridItemClick")) && (p.h(paramString3, "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (((paramArrayOfObject[0] instanceof RecyclerView.a)) && (paramArrayOfObject[0] == null))
          {
            paramString1 = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(252746);
            throw paramString1;
          }
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label194;
          }
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(252746);
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
            AppMethodBeat.o(252746);
            throw paramString1;
          }
          i = ((Integer)paramString2).intValue();
        }
        this.wjR.o(paramString1, i);
        AppMethodBeat.o(252746);
        return;
        AppMethodBeat.o(252746);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class c
    implements com.tencent.mm.hellhoundlib.a.d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(253063);
      if ((paramString1 != null) && (n.M(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$", false)) && (p.h(paramString2, "onItemClick")) && ((p.h(paramString3, "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;)V")) || (p.h(paramString3, "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V"))) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (((paramArrayOfObject[0] instanceof RecyclerView.a)) && (paramArrayOfObject[0] == null))
          {
            paramString1 = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(253063);
            throw paramString1;
          }
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label203;
          }
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253063);
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
            AppMethodBeat.o(253063);
            throw paramString1;
          }
          i = ((Integer)paramString2).intValue();
        }
        this.wjR.o(paramString1, i);
        AppMethodBeat.o(253063);
        return;
        AppMethodBeat.o(253063);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class d
    implements com.tencent.mm.hellhoundlib.a.d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(255386);
      if ((paramString1 != null) && (n.M(paramString1, "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", false)) && (p.h(paramString2, "onFeedItemClick")) && (p.h(paramString3, "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V")) && (paramArrayOfObject != null))
      {
        paramString1 = paramArrayOfObject[0];
        this.wjR.o(paramString1, -1);
      }
      AppMethodBeat.o(255386);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class e
    implements com.tencent.mm.hellhoundlib.a.d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(256837);
      if ((p.h(paramString1, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter")) && (p.h(paramString2, "jumpProfileTimeline")) && (p.h(paramString3, "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V")) && (paramArrayOfObject != null))
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
              AppMethodBeat.o(256837);
              throw paramString1;
            }
            i = ((Integer)paramString1).intValue();
          }
          paramString1 = paramArrayOfObject[1];
          this.wjR.o(paramString1, i);
        }
        AppMethodBeat.o(256837);
        return;
      }
      AppMethodBeat.o(256837);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class f
    implements com.tencent.mm.hellhoundlib.a.d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      paramObject = null;
      AppMethodBeat.i(251693);
      if ((paramString1 != null) && (n.M(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", false)) && (p.h(paramString2, "onGridItemClick")) && (p.h(paramString3, "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (!(paramArrayOfObject[0] instanceof RecyclerView.a)) {
            break label232;
          }
          paramString1 = paramArrayOfObject[0];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(251693);
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
            AppMethodBeat.o(251693);
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
            AppMethodBeat.o(251693);
            throw paramString1;
          }
          i = ((Integer)paramString3).intValue();
          if (!(paramString1 instanceof h)) {
            break label229;
          }
          i -= ((h)paramString1).YSk.size();
        }
        for (;;)
        {
          this.wjR.o(paramString2, i);
          AppMethodBeat.o(251693);
          return;
          AppMethodBeat.o(251693);
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