package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import android.util.Pair;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback;", "", "()V", "mFavListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1;", "mFavMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mLbsListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1;", "mLbsMethodMap", "", "", "mMixSearchListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1;", "mMixSearchMethodMap", "mProfileListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1;", "mProfileMethodMap", "mTopicListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1;", "mTopicMethodMap", "monitor", "", "onFeedClick", "obj", "position", "", "registerListener", "listener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "unmonitor", "unregisterListener", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final List<d> mListeners;
  public static final a.a zFJ;
  private final HashMap<String, Pair<String, List<Pair<String, String>>>> zFK;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> zFL;
  private final HashMap<String, List<Pair<String, String>>> zFM;
  private final HashMap<String, Pair<String, List<Pair<String, String>>>> zFN;
  private final HashMap<String, Map<String, List<Pair<String, String>>>> zFO;
  private final b zFP;
  private final c zFQ;
  private final e zFR;
  private final f zFS;
  private final d zFT;
  
  static
  {
    AppMethodBeat.i(300596);
    zFJ = new a.a((byte)0);
    mListeners = (List)new ArrayList();
    AppMethodBeat.o(300596);
  }
  
  public a()
  {
    AppMethodBeat.i(300590);
    this.zFK = new HashMap();
    this.zFL = new HashMap();
    this.zFM = new HashMap();
    this.zFN = new HashMap();
    this.zFO = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    ((Map)this.zFK).put("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", new Pair("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", localObject));
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;)V"));
    ((List)localObject).add(new Pair("onItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", localObject);
    ((Map)this.zFL).put("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$", localHashMap);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new Pair("jumpProfileTimeline", "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    ((Map)this.zFM).put("com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter", localObject);
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V"));
    ((Map)this.zFN).put("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", new Pair("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", localObject));
    localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("onFeedItemClick", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V"));
    localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/plugin/finder/search/FinderMixSearchUIContract$Presenter", localObject);
    ((Map)this.zFO).put("com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", localHashMap);
    this.zFP = new b(this);
    this.zFQ = new c(this);
    this.zFR = new e(this);
    this.zFS = new f(this);
    this.zFT = new d(this);
    AppMethodBeat.o(300590);
  }
  
  public final void a(d paramd)
  {
    try
    {
      AppMethodBeat.i(300616);
      s.u(paramd, "listener");
      if (!mListeners.contains(paramd)) {
        mListeners.add(paramd);
      }
      AppMethodBeat.o(300616);
      return;
    }
    finally {}
  }
  
  public final void ayW()
  {
    AppMethodBeat.i(300602);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.c((Map)this.zFK, (com.tencent.mm.hellhoundlib.a.d)this.zFP);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.e((Map)this.zFL, (com.tencent.mm.hellhoundlib.a.d)this.zFQ);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)this.zFM, (com.tencent.mm.hellhoundlib.a.d)this.zFR);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.c((Map)this.zFN, (com.tencent.mm.hellhoundlib.a.d)this.zFS);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.e((Map)this.zFO, (com.tencent.mm.hellhoundlib.a.d)this.zFT);
    AppMethodBeat.o(300602);
  }
  
  public final void b(d paramd)
  {
    try
    {
      AppMethodBeat.i(300618);
      s.u(paramd, "listener");
      mListeners.remove(paramd);
      AppMethodBeat.o(300618);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public final void dKh()
  {
    AppMethodBeat.i(300608);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.d((Map)this.zFK, (com.tencent.mm.hellhoundlib.a.d)this.zFP);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.f((Map)this.zFL, (com.tencent.mm.hellhoundlib.a.d)this.zFQ);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.b((Map)this.zFM, (com.tencent.mm.hellhoundlib.a.d)this.zFR);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.d((Map)this.zFN, (com.tencent.mm.hellhoundlib.a.d)this.zFS);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.f((Map)this.zFO, (com.tencent.mm.hellhoundlib.a.d)this.zFT);
    AppMethodBeat.o(300608);
  }
  
  public final void r(Object paramObject, int paramInt)
  {
    try
    {
      AppMethodBeat.i(300624);
      Iterator localIterator = ((Iterable)mListeners).iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).r(paramObject, paramInt);
      }
      AppMethodBeat.o(300624);
    }
    finally {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mFavListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.d
  {
    b(a parama) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(300617);
      if (paramString1 != null)
      {
        paramObject = this.zFU;
        if ((n.U(paramString1, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", false)) && (s.p(paramString2, "onGridItemClick")) && (s.p(paramString3, "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 3)) {
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label112;
          }
        }
      }
      label112:
      for (paramString1 = (View)paramArrayOfObject[1];; paramString1 = null)
      {
        int i = -1;
        if ((paramArrayOfObject[2] instanceof Integer)) {
          i = ((Integer)paramArrayOfObject[2]).intValue();
        }
        paramObject.r(paramString1, i);
        AppMethodBeat.o(300617);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mLbsListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.hellhoundlib.a.d
  {
    c(a parama) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(300620);
      if (paramString1 != null)
      {
        paramObject = this.zFU;
        if ((n.U(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback$initView$", false)) && (s.p(paramString2, "onItemClick")) && ((s.p(paramString3, "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;)V")) || (s.p(paramString3, "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V"))) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 3)) {
          if (!(paramArrayOfObject[1] instanceof View)) {
            break label121;
          }
        }
      }
      label121:
      for (paramString1 = (View)paramArrayOfObject[1];; paramString1 = null)
      {
        int i = -1;
        if ((paramArrayOfObject[2] instanceof Integer)) {
          i = ((Integer)paramArrayOfObject[2]).intValue();
        }
        paramObject.r(paramString1, i);
        AppMethodBeat.o(300620);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mMixSearchListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.hellhoundlib.a.d
  {
    d(a parama) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(300626);
      if (paramString1 != null)
      {
        paramObject = this.zFU;
        if ((n.U(paramString1, "com/tencent/mm/plugin/finder/search/FinderMixSearchPresenter", false)) && (s.p(paramString2, "onFeedItemClick")) && (s.p(paramString3, "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V")) && (paramArrayOfObject != null)) {
          paramObject.r(paramArrayOfObject[0], -1);
        }
      }
      AppMethodBeat.o(300626);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mProfileListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.hellhoundlib.a.d
  {
    e(a parama) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(300621);
      if ((s.p(paramString1, "com/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter")) && (s.p(paramString2, "jumpProfileTimeline")) && (s.p(paramString3, "(ILcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V")) && (paramArrayOfObject != null))
      {
        paramString1 = this.zFU;
        if (paramArrayOfObject.length >= 2)
        {
          int i = -1;
          if ((paramArrayOfObject[0] instanceof Integer)) {
            i = ((Integer)paramArrayOfObject[0]).intValue();
          }
          paramString1.r(paramArrayOfObject[1], i);
        }
      }
      AppMethodBeat.o(300621);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/FinderClickCallback$mTopicListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.hellhoundlib.a.d
  {
    f(a parama) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      paramObject = null;
      AppMethodBeat.i(300613);
      a locala;
      if (paramString1 != null)
      {
        locala = this.zFU;
        if ((n.U(paramString1, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback", false)) && (s.p(paramString2, "onGridItemClick")) && (s.p(paramString3, "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V")) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 3)) {
          if (!(paramArrayOfObject[0] instanceof RecyclerView.a)) {
            break label161;
          }
        }
      }
      label158:
      label161:
      for (paramString1 = (RecyclerView.a)paramArrayOfObject[0];; paramString1 = null)
      {
        paramString2 = paramObject;
        if ((paramArrayOfObject[1] instanceof View)) {
          paramString2 = (View)paramArrayOfObject[1];
        }
        int i = -1;
        if ((paramArrayOfObject[2] instanceof Integer))
        {
          i = ((Integer)paramArrayOfObject[2]).intValue();
          if (!(paramString1 instanceof i)) {
            break label158;
          }
          i -= ((i)paramString1).agOb.size();
        }
        for (;;)
        {
          locala.r(paramString2, i);
          AppMethodBeat.o(300613);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.a
 * JD-Core Version:    0.7.0.1
 */