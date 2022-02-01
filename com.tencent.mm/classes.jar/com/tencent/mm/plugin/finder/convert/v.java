package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "showEdu", "", "isSelfLike", "Lkotlin/Function0;", "selfLikeClick", "Lkotlin/Function1;", "", "onRefresh", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "()Lkotlin/jvm/functions/Function0;", "getOnRefresh", "getSelfLikeClick", "()Lkotlin/jvm/functions/Function1;", "getShowEdu", "()Z", "canShowLikeEdu", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends f<w>
{
  private final boolean AJQ;
  private final kotlin.g.a.a<Boolean> AJR;
  private final kotlin.g.a.b<Boolean, ah> AJS;
  private final kotlin.g.a.a<ah> AJT;
  
  public v(boolean paramBoolean, kotlin.g.a.a<Boolean> parama, kotlin.g.a.b<? super Boolean, ah> paramb, kotlin.g.a.a<ah> parama1)
  {
    AppMethodBeat.i(350520);
    this.AJQ = paramBoolean;
    this.AJR = parama;
    this.AJS = paramb;
    this.AJT = parama1;
    AppMethodBeat.o(350520);
  }
  
  private static final void a(v paramv, w paramw, j paramj, View paramView)
  {
    AppMethodBeat.i(350535);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramv);
    localb.cH(paramw);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramv, "this$0");
    s.u(paramw, "$item");
    s.u(paramj, "$holder");
    paramv.AJS.invoke(Boolean.FALSE);
    paramv.a(paramw, paramj);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350535);
  }
  
  private final void a(w paramw, j paramj)
  {
    AppMethodBeat.i(350528);
    if ((this.AJQ) && (s.p(paramw.ECH.hLv, z.bAM())))
    {
      View localView;
      if (((Boolean)this.AJR.invoke()).booleanValue())
      {
        localView = paramj.UH(e.e.other_divider);
        if (localView != null) {
          localView.setVisibility(8);
        }
        localView = paramj.UH(e.e.self_divider);
        if (localView != null) {
          localView.setVisibility(0);
        }
        localView = paramj.UH(e.e.like_layout);
        if (localView != null) {
          localView.setVisibility(0);
        }
        localView = paramj.UH(e.e.wx_like_edu_layout);
        if (localView != null) {
          localView.setVisibility(8);
        }
        localView = paramj.UH(e.e.finder_disable_like_layout);
        if (localView != null)
        {
          localView.setOnClickListener(new v..ExternalSyntheticLambda1(this, paramw, paramj));
          AppMethodBeat.o(350528);
        }
      }
      else
      {
        localView = paramj.UH(e.e.like_layout);
        if (localView != null) {
          localView.setVisibility(8);
        }
        localView = paramj.UH(e.e.wx_like_edu_layout);
        if (localView != null) {
          localView.setVisibility(0);
        }
        localView = paramj.UH(e.e.wx_like_edu_layout);
        if (localView != null) {
          localView.setOnClickListener(new v..ExternalSyntheticLambda0(this, paramw, paramj));
        }
        this.AJT.invoke();
        AppMethodBeat.o(350528);
      }
    }
    else
    {
      paramw = paramj.UH(e.e.other_divider);
      if (paramw != null) {
        paramw.setVisibility(0);
      }
      paramw = paramj.UH(e.e.self_divider);
      if (paramw != null) {
        paramw.setVisibility(8);
      }
      paramw = paramj.UH(e.e.like_layout);
      if (paramw != null) {
        paramw.setVisibility(0);
      }
      paramw = paramj.UH(e.e.wx_like_edu_layout);
      if (paramw != null) {
        paramw.setVisibility(8);
      }
      paramw = paramj.UH(e.e.finder_disable_like_layout);
      if (paramw != null) {
        paramw.setVisibility(8);
      }
    }
    AppMethodBeat.o(350528);
  }
  
  private static final void b(v paramv, w paramw, j paramj, View paramView)
  {
    AppMethodBeat.i(350543);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramv);
    localb.cH(paramw);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramv, "this$0");
    s.u(paramw, "$item");
    s.u(paramj, "$holder");
    paramv.AJS.invoke(Boolean.TRUE);
    paramv.a(paramw, paramj);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350543);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350568);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(350568);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_self_liked_list_item_layout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.v
 * JD-Core Version:    0.7.0.1
 */