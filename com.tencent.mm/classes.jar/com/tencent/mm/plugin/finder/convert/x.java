package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "showEdu", "", "isSelfLike", "Lkotlin/Function0;", "selfLikeClick", "Lkotlin/Function1;", "", "onRefresh", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "()Lkotlin/jvm/functions/Function0;", "getOnRefresh", "getSelfLikeClick", "()Lkotlin/jvm/functions/Function1;", "getShowEdu", "()Z", "canShowLikeEdu", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refresh", "plugin-finder_release"})
public final class x
  extends e<v>
{
  private final boolean xlw;
  private final kotlin.g.a.a<Boolean> xlx;
  final kotlin.g.a.b<Boolean, kotlin.x> xly;
  private final kotlin.g.a.a<kotlin.x> xlz;
  
  public x(boolean paramBoolean, kotlin.g.a.a<Boolean> parama, kotlin.g.a.b<? super Boolean, kotlin.x> paramb, kotlin.g.a.a<kotlin.x> parama1)
  {
    AppMethodBeat.i(288201);
    this.xlw = paramBoolean;
    this.xlx = parama;
    this.xly = paramb;
    this.xlz = parama1;
    AppMethodBeat.o(288201);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(288198);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(288198);
  }
  
  final void a(final v paramv, final i parami)
  {
    AppMethodBeat.i(288200);
    if ((this.xlw) && (p.h(paramv.zAz.fGe, z.bcZ())))
    {
      if (((Boolean)this.xlx.invoke()).booleanValue())
      {
        localView = parami.RD(b.f.other_divider);
        if (localView != null) {
          localView.setVisibility(8);
        }
        localView = parami.RD(b.f.self_divider);
        if (localView != null) {
          localView.setVisibility(0);
        }
        localView = parami.RD(b.f.like_layout);
        if (localView != null) {
          localView.setVisibility(0);
        }
        localView = parami.RD(b.f.wx_like_edu_layout);
        if (localView != null) {
          localView.setVisibility(8);
        }
        localView = parami.RD(b.f.finder_disable_like_layout);
        if (localView != null)
        {
          localView.setOnClickListener((View.OnClickListener)new a(this, paramv, parami));
          AppMethodBeat.o(288200);
          return;
        }
        AppMethodBeat.o(288200);
        return;
      }
      View localView = parami.RD(b.f.like_layout);
      if (localView != null) {
        localView.setVisibility(8);
      }
      localView = parami.RD(b.f.wx_like_edu_layout);
      if (localView != null) {
        localView.setVisibility(0);
      }
      localView = parami.RD(b.f.wx_like_edu_layout);
      if (localView != null) {
        localView.setOnClickListener((View.OnClickListener)new b(this, paramv, parami));
      }
      this.xlz.invoke();
      AppMethodBeat.o(288200);
      return;
    }
    paramv = parami.RD(b.f.other_divider);
    if (paramv != null) {
      paramv.setVisibility(0);
    }
    paramv = parami.RD(b.f.self_divider);
    if (paramv != null) {
      paramv.setVisibility(8);
    }
    paramv = parami.RD(b.f.like_layout);
    if (paramv != null) {
      paramv.setVisibility(0);
    }
    paramv = parami.RD(b.f.wx_like_edu_layout);
    if (paramv != null) {
      paramv.setVisibility(8);
    }
    paramv = parami.RD(b.f.finder_disable_like_layout);
    if (paramv != null)
    {
      paramv.setVisibility(8);
      AppMethodBeat.o(288200);
      return;
    }
    AppMethodBeat.o(288200);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_self_liked_list_item_layout;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(x paramx, v paramv, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(281111);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xlA.xly.invoke(Boolean.FALSE);
      this.xlA.a(paramv, parami);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(281111);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(x paramx, v paramv, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(281858);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xlA.xly.invoke(Boolean.TRUE);
      this.xlA.a(paramv, parami);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(281858);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.x
 * JD-Core Version:    0.7.0.1
 */