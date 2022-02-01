package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.g;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "onClickRefresh", "Lkotlin/Function0;", "", "onClickPermission", "forceEnableNightMode", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Z)V", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends f<g>
{
  public static final a AHW;
  private final kotlin.g.a.a<ah> AHX;
  private final kotlin.g.a.a<ah> AHY;
  private final boolean AHZ;
  
  static
  {
    AppMethodBeat.i(165390);
    AHW = new a((byte)0);
    AppMethodBeat.o(165390);
  }
  
  public n(kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2, boolean paramBoolean)
  {
    this.AHX = parama1;
    this.AHY = parama2;
    this.AHZ = paramBoolean;
  }
  
  private static final void a(n paramn, View paramView)
  {
    AppMethodBeat.i(350440);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramn);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramn, "this$0");
    paramn = paramn.AHY;
    if (paramn != null) {
      paramn.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350440);
  }
  
  private static final void a(j paramj, n paramn, View paramView)
  {
    AppMethodBeat.i(350427);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(paramn);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramn, "this$0");
    paramView = (g)paramj.CSA;
    if ((paramView != null) && (paramView.type == -1)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramView = paramj.UH(e.e.tips_layout);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramj = paramj.UH(e.e.progress_convert);
        if (paramj != null) {
          paramj.setVisibility(0);
        }
        paramj = paramn.AHX;
        if (paramj != null) {
          paramj.invoke();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350427);
      return;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350490);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramj.caK.setOnClickListener(new n..ExternalSyntheticLambda1(paramj, this));
    AppMethodBeat.o(350490);
  }
  
  public final int getLayoutId()
  {
    if (this.AHZ) {
      return e.f.finder_timeline_empty_view_night_mode;
    }
    return e.f.finder_timeline_empty_view;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.n
 * JD-Core Version:    0.7.0.1
 */