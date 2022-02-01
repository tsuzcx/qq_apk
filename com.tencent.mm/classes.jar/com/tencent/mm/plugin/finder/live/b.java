package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveRecyclerView;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewHolder;", "fragment", "Landroidx/fragment/app/Fragment;", "datas", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "isFromFloat", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "clickLiveId", "", "launchWithAnim", "(Landroidx/fragment/app/Fragment;Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;ZLcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;JZ)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "itemViewList", "", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "adjustCorner", "", "holder", "enableCorner", "adjustTopAreaMargin", "pluginLayout", "sideBarStyle", "checkProduceVisitorView", "context", "Landroid/content/Context;", "needPost", "consumeView", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "pos", "", "getItemCount", "onBindViewHolder", "vh", "position", "payloads", "", "onCreateViewHolder", "vg", "type", "onViewDetachedFromWindow", "preloadLiveOnce", "data", "produceView", "protectViewItemRecycleHealthy", "view", "Landroid/view/View;", "updateCorner", "showCorner", "from", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<h>
{
  public static final b.a BvG;
  private final g BvH;
  private final boolean BvI;
  private final FinderLiveViewCallback BvJ;
  private long BvK;
  private boolean BvL;
  private final List<FinderLiveVisitorPluginLayout> BvM;
  final String TAG;
  private final Fragment fragment;
  private final bui reportObj;
  
  static
  {
    AppMethodBeat.i(350773);
    BvG = new b.a((byte)0);
    AppMethodBeat.o(350773);
  }
  
  public b(Fragment paramFragment, g paramg, boolean paramBoolean1, FinderLiveViewCallback paramFinderLiveViewCallback, bui parambui, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(350724);
    this.fragment = paramFragment;
    this.BvH = paramg;
    this.BvI = paramBoolean1;
    this.BvJ = paramFinderLiveViewCallback;
    this.reportObj = parambui;
    this.BvK = paramLong;
    this.BvL = paramBoolean2;
    this.TAG = "Finder.FinderLiveViewCallback.Adapter";
    this.BvM = ((List)new ArrayList());
    AppMethodBeat.o(350724);
  }
  
  private static final void a(b paramb, int paramInt, View paramView)
  {
    AppMethodBeat.i(350747);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/FinderLiveAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramView = paramb.BvJ;
    if (paramView != null)
    {
      paramView = paramView.BwI;
      if (paramView != null)
      {
        localObject = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/live/FinderLiveAdapter", "onBindViewHolder$lambda-4", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveAdapter;ILandroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/finder/live/FinderLiveAdapter", "onBindViewHolder$lambda-4", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveAdapter;ILandroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
    }
    paramView = paramb.BvJ;
    if (paramView != null) {
      paramView.ehc();
    }
    paramb = paramb.BvJ;
    if (paramb != null) {
      paramb.X(true, false);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/FinderLiveAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350747);
  }
  
  private static void a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(350728);
    paramh = paramh.caK;
    if ((paramh instanceof RoundedCornerFrameLayout)) {
      paramh = (RoundedCornerFrameLayout)paramh;
    }
    while (paramh != null) {
      if (paramBoolean)
      {
        paramh.setRadius(paramh.getContext().getResources().getDimensionPixelOffset(p.c.Edge_A));
        AppMethodBeat.o(350728);
        return;
        paramh = null;
      }
      else
      {
        paramh.setRadius(0.0F);
      }
    }
    AppMethodBeat.o(350728);
  }
  
  public static void a(FinderLiveVisitorPluginLayout paramFinderLiveVisitorPluginLayout, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = null;
    AppMethodBeat.i(350735);
    float f1;
    float f2;
    if (paramFinderLiveVisitorPluginLayout != null)
    {
      f1 = paramFinderLiveVisitorPluginLayout.getContext().getResources().getDimension(p.c.Edge_5A);
      f2 = paramFinderLiveVisitorPluginLayout.getContext().getResources().getDimension(p.c.Edge_0_5_A);
      paramFinderLiveVisitorPluginLayout = paramFinderLiveVisitorPluginLayout.findViewById(p.e.BTU);
      if (paramFinderLiveVisitorPluginLayout != null) {
        break label95;
      }
      paramFinderLiveVisitorPluginLayout = null;
      if ((paramFinderLiveVisitorPluginLayout instanceof RelativeLayout.LayoutParams)) {
        localLayoutParams = (RelativeLayout.LayoutParams)paramFinderLiveVisitorPluginLayout;
      }
      if (localLayoutParams != null) {
        if (!paramBoolean) {
          break label103;
        }
      }
    }
    label95:
    label103:
    for (int i = (int)f2;; i = (int)f1)
    {
      localLayoutParams.topMargin = i;
      AppMethodBeat.o(350735);
      return;
      paramFinderLiveVisitorPluginLayout = paramFinderLiveVisitorPluginLayout.getLayoutParams();
      break;
    }
  }
  
  private static final void b(b paramb, int paramInt, View paramView)
  {
    AppMethodBeat.i(350752);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/FinderLiveAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramView = paramb.BvJ;
    if (paramView != null)
    {
      paramView = paramView.BwI;
      if (paramView != null)
      {
        localObject = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/live/FinderLiveAdapter", "onBindViewHolder$lambda-5", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveAdapter;ILandroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/finder/live/FinderLiveAdapter", "onBindViewHolder$lambda-5", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveAdapter;ILandroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
    }
    paramView = paramb.BvJ;
    if (paramView != null) {
      paramView.ehc();
    }
    paramb = paramb.BvJ;
    if (paramb != null) {
      paramb.X(false, false);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/FinderLiveAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350752);
  }
  
  private final void fM(View paramView)
  {
    AppMethodBeat.i(350740);
    int i;
    int k;
    if ((paramView instanceof ViewGroup))
    {
      i = 0;
      k = ((ViewGroup)paramView).getChildCount();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      View localView = ((ViewGroup)paramView).getChildAt(i);
      if (localView != null)
      {
        localView.animate().cancel();
        if (localView.hasTransientState()) {
          Log.i("RecyclerViewAdapterEx", s.X("[protectViewItemRecycleHealthy] child=", localView));
        }
        fM(localView);
      }
      if (j >= k)
      {
        paramView.animate().cancel();
        AppMethodBeat.o(350740);
        return;
      }
      i = j;
    }
  }
  
  public final void H(final Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(350784);
    s.u(paramContext, "context");
    d.uiThread((kotlin.g.a.a)new b(this, paramBoolean, paramContext));
    AppMethodBeat.o(350784);
  }
  
  public final f Ox(int paramInt)
  {
    AppMethodBeat.i(350800);
    if ((paramInt < 0) || (paramInt >= getItemCount()))
    {
      Log.i(this.TAG, "getData invalid pos:" + paramInt + '!');
      AppMethodBeat.o(350800);
      return null;
    }
    f localf = (f)this.BvH.Ebx.get(paramInt);
    AppMethodBeat.o(350800);
    return localf;
  }
  
  public final void P(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(350795);
    s.u(paramString, "from");
    Object localObject = this.BvJ.BwI.getLayoutManager();
    int i;
    int j;
    if ((localObject instanceof LinearLayoutManager))
    {
      localObject = (LinearLayoutManager)localObject;
      if (localObject != null)
      {
        i = ((LinearLayoutManager)localObject).Ju();
        j = ((LinearLayoutManager)localObject).Jw();
        Log.i(this.TAG, "sidebar updateCorner " + paramBoolean + ", from:" + paramString + ", first:" + i + ", last:" + j);
        if ((i >= 0) && (j >= 0)) {
          if (!paramBoolean) {
            break label155;
          }
        }
      }
    }
    label155:
    for (paramString = "PayLoadCorner";; paramString = "PayLoadHideCorner")
    {
      e(i, j - i + 1, paramString);
      AppMethodBeat.o(350795);
      return;
      localObject = null;
      break;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(350790);
    int i = this.BvH.Ebx.size();
    AppMethodBeat.o(350790);
    return i;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(b paramb, boolean paramBoolean, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.b
 * JD-Core Version:    0.7.0.1
 */