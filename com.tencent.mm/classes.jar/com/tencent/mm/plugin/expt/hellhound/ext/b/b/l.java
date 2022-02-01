package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import android.util.Pair;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "", "()V", "mItemDecorationListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mRecyclerListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1;", "mRecyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "illegalPage", "", "pageName", "monitor", "", "needNotRun", "className", "unmonitor", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l.a zHZ;
  WeakReference<RecyclerView> zDZ;
  final HashMap<String, Pair<String, List<Pair<String, String>>>> zGg;
  final b zIa;
  final l.c zIb;
  
  static
  {
    AppMethodBeat.i(300610);
    zHZ = new l.a((byte)0);
    AppMethodBeat.o(300610);
  }
  
  public l()
  {
    AppMethodBeat.i(300577);
    this.zGg = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V"));
    ((List)localObject).add(new Pair("onDrawOver", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V"));
    ((Map)this.zGg).put("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$SpacesItemDecoration", new Pair("androidx/recyclerview/widget/RecyclerView$ItemDecoration", localObject));
    ((Map)this.zGg).put("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", new Pair("androidx/recyclerview/widget/RecyclerView$ItemDecoration", localObject));
    ((Map)this.zGg).put("com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$", new Pair("androidx/recyclerview/widget/RecyclerView$ItemDecoration", localObject));
    localObject = this.zDZ;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    this.zIa = new b(this);
    this.zIb = new l.c();
    AppMethodBeat.o(300577);
  }
  
  static boolean asa(String paramString)
  {
    AppMethodBeat.i(300581);
    if ((!s.p("com.tencent.mm.plugin.finder.ui.FinderTimelineMachineUI", paramString)) && (!s.p("com.tencent.mm.plugin.finder.search.FinderMixSearchUI", paramString)) && (!s.p("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI", paramString)))
    {
      AppMethodBeat.o(300581);
      return true;
    }
    AppMethodBeat.o(300581);
    return false;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements d
  {
    b(l paraml) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(300545);
      if (l.asb(paramString1))
      {
        AppMethodBeat.o(300545);
        return;
      }
      if ((s.p(paramString2, "getItemOffsets")) && (s.p(paramString3, "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V")) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4))
      {
        paramString1 = l.a(this.zIc);
        if (paramString1 != null) {
          break label109;
        }
      }
      label109:
      for (paramString1 = null;; paramString1 = (RecyclerView)paramString1.get())
      {
        if (paramString1 == null)
        {
          paramString1 = (RecyclerView)paramArrayOfObject[2];
          paramString1.a((RecyclerView.l)l.b(this.zIc));
          l.a(this.zIc, new WeakReference(paramString1));
        }
        AppMethodBeat.o(300545);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.l
 * JD-Core Version:    0.7.0.1
 */