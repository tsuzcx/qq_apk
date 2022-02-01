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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "", "()V", "mFavListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1;", "mFavMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mLbsListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1;", "mLbsMethodMap", "", "", "mMixSearchListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1;", "mMixSearchMethodMap", "mProfileListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1;", "mProfileMethodMap", "mTopicListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1;", "mTopicMethodMap", "monitor", "", "onFeedClick", "obj", "position", "", "registerListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a KGg;
  private static final List<d> mListeners;
  private final HashMap<String, Pair<String, List<Pair<String, String>>>> KFW;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> KFX;
  private final HashMap<String, List<Pair<String, String>>> KFY;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> KFZ;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> KGa;
  private final b KGb;
  private final c KGc;
  private final e KGd;
  private final f KGe;
  private final d KGf;
  
  static
  {
    AppMethodBeat.i(205161);
    KGg = new a((byte)0);
    mListeners = (List)new ArrayList();
    AppMethodBeat.o(205161);
  }
  
  public a()
  {
    AppMethodBeat.i(205160);
    this.KFW = new HashMap();
    this.KFX = new HashMap();
    this.KFY = new HashMap();
    this.KFZ = new HashMap();
    this.KGa = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    ((Map)this.KFW).put("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", new Pair("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", localObject));
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", localObject);
    ((Map)this.KFX).put("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$", localHashMap);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new Pair("jumpProfileTimeline", "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    ((Map)this.KFY).put("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter", localObject);
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", localObject);
    ((Map)this.KFZ).put("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$", localHashMap);
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", localObject);
    ((Map)this.KGa).put("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", localHashMap);
    this.KGb = new b(this);
    this.KGc = new c(this);
    this.KGd = new e(this);
    this.KGe = new f(this);
    this.KGf = new d(this);
    AppMethodBeat.o(205160);
  }
  
  public final void a(d paramd)
  {
    try
    {
      AppMethodBeat.i(205157);
      k.h(paramd, "listener");
      if (!mListeners.contains(paramd)) {
        mListeners.add(paramd);
      }
      AppMethodBeat.o(205157);
      return;
    }
    finally {}
  }
  
  public final void b(d paramd)
  {
    try
    {
      AppMethodBeat.i(205158);
      k.h(paramd, "listener");
      mListeners.remove(paramd);
      AppMethodBeat.o(205158);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public final void ccE()
  {
    AppMethodBeat.i(205155);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.c((Map)this.KFW, (c)this.KGb);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.e((Map)this.KFX, (c)this.KGc);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.a((Map)this.KFY, (c)this.KGd);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.e((Map)this.KFZ, (c)this.KGe);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.e((Map)this.KGa, (c)this.KGf);
    AppMethodBeat.o(205155);
  }
  
  public final void fRu()
  {
    AppMethodBeat.i(205156);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.d((Map)this.KFW, (c)this.KGb);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.f((Map)this.KFX, (c)this.KGc);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.b((Map)this.KFY, (c)this.KGd);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.f((Map)this.KFZ, (c)this.KGe);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.f((Map)this.KGa, (c)this.KGf);
    AppMethodBeat.o(205156);
  }
  
  public final void m(Object paramObject, int paramInt)
  {
    try
    {
      AppMethodBeat.i(205159);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).m(paramObject, paramInt);
      }
      AppMethodBeat.o(205159);
    }
    finally {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$Companion;", "", "()V", "FAV_CLASS_HEADER", "", "FAV_METHOD_DESC", "FAV_METHOD_NAME", "FAV_SUPER", "LBS_CLASS_HEADER", "LBS_INTERFACE", "LBS_METHOD_DESC", "LBS_METHOD_NAME", "MIXSEARCH_CLASS_HEADER", "MIXSEARCH_INTERFACE", "MIXSEARCH_METHOD_DESC", "MIXSEARCH_METHOD_NAME", "PROFILE_CLASS", "PROFILE_METHOD_DESC", "PROFILE_METHOD_NAME", "TOPIC_CLASS_HEADER", "TOPIC_INTERFACE", "TOPIC_METHOD_DESC", "TOPIC_METHOD_NAME", "mListeners", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "plugin-expt_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(205150);
      if ((paramString1 != null) && (n.mA(paramString1, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback")) && (k.g(paramString2, "onGridItemClick")) && (k.g(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (((paramArrayOfObject[0] instanceof RecyclerView.a)) && (paramArrayOfObject[0] == null))
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(205150);
            throw paramString1;
          }
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label193;
          }
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(205150);
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
            AppMethodBeat.o(205150);
            throw paramString1;
          }
          i = ((Integer)paramString2).intValue();
        }
        this.KGh.m(paramString1, i);
        AppMethodBeat.o(205150);
        return;
        AppMethodBeat.o(205150);
        return;
      }
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class c
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(205151);
      if ((paramString1 != null) && (n.mA(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$")) && (k.g(paramString2, "onItemClick")) && (k.g(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (((paramArrayOfObject[0] instanceof RecyclerView.a)) && (paramArrayOfObject[0] == null))
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(205151);
            throw paramString1;
          }
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label193;
          }
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(205151);
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
            AppMethodBeat.o(205151);
            throw paramString1;
          }
          i = ((Integer)paramString2).intValue();
        }
        this.KGh.m(paramString1, i);
        AppMethodBeat.o(205151);
        return;
        AppMethodBeat.o(205151);
        return;
      }
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class d
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(205152);
      if ((paramString1 != null) && (n.mA(paramString1, "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter")) && (k.g(paramString2, "onFeedItemClick")) && (k.g(paramString3, "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V")) && (paramArrayOfObject != null))
      {
        paramString1 = paramArrayOfObject[0];
        this.KGh.m(paramString1, -1);
      }
      AppMethodBeat.o(205152);
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class e
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(205153);
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
              AppMethodBeat.o(205153);
              throw paramString1;
            }
            i = ((Integer)paramString1).intValue();
          }
          paramString1 = paramArrayOfObject[1];
          this.KGh.m(paramString1, i);
        }
        AppMethodBeat.o(205153);
        return;
      }
      AppMethodBeat.o(205153);
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class f
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      paramObject = null;
      AppMethodBeat.i(205154);
      if ((paramString1 != null) && (n.mA(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$")) && (k.g(paramString2, "onItemClick")) && (k.g(paramString3, "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null)) {
        if (paramArrayOfObject.length >= 3)
        {
          if (!(paramArrayOfObject[0] instanceof RecyclerView.a)) {
            break label231;
          }
          paramString1 = paramArrayOfObject[0];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.Adapter<*>");
            AppMethodBeat.o(205154);
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
            AppMethodBeat.o(205154);
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
            AppMethodBeat.o(205154);
            throw paramString1;
          }
          i = ((Integer)paramString3).intValue();
          if (!(paramString1 instanceof com.tencent.mm.view.recyclerview.d)) {
            break label228;
          }
          i -= ((com.tencent.mm.view.recyclerview.d)paramString1).Ibl.size();
        }
        for (;;)
        {
          this.KGh.m(paramString2, i);
          AppMethodBeat.o(205154);
          return;
          AppMethodBeat.o(205154);
          return;
        }
      }
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */