package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "showEdu", "", "isSelfLike", "Lkotlin/Function0;", "selfLikeClick", "Lkotlin/Function1;", "", "onRefresh", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "()Lkotlin/jvm/functions/Function0;", "getOnRefresh", "getSelfLikeClick", "()Lkotlin/jvm/functions/Function1;", "getShowEdu", "()Z", "canShowLikeEdu", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refresh", "plugin-finder_release"})
public final class w
  extends e<v>
{
  private final boolean tDa;
  private final kotlin.g.a.a<Boolean> tDb;
  final kotlin.g.a.b<Boolean, x> tDc;
  private final kotlin.g.a.a<x> tDd;
  
  public w(boolean paramBoolean, kotlin.g.a.a<Boolean> parama, kotlin.g.a.b<? super Boolean, x> paramb, kotlin.g.a.a<x> parama1)
  {
    AppMethodBeat.i(243030);
    this.tDa = paramBoolean;
    this.tDb = parama;
    this.tDc = paramb;
    this.tDd = parama1;
    AppMethodBeat.o(243030);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243027);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(243027);
  }
  
  final void a(final v paramv, final h paramh)
  {
    AppMethodBeat.i(243029);
    if ((this.tDa) && (p.j(paramv.uOk.dMW, z.aTY())))
    {
      if (((Boolean)this.tDb.invoke()).booleanValue())
      {
        localView = paramh.Mn(2131305735);
        if (localView != null) {
          localView.setVisibility(8);
        }
        localView = paramh.Mn(2131307579);
        if (localView != null) {
          localView.setVisibility(0);
        }
        localView = paramh.Mn(2131303186);
        if (localView != null) {
          localView.setVisibility(0);
        }
        localView = paramh.Mn(2131310635);
        if (localView != null) {
          localView.setVisibility(8);
        }
        localView = paramh.Mn(2131300802);
        if (localView != null)
        {
          localView.setOnClickListener((View.OnClickListener)new a(this, paramv, paramh));
          AppMethodBeat.o(243029);
          return;
        }
        AppMethodBeat.o(243029);
        return;
      }
      View localView = paramh.Mn(2131303186);
      if (localView != null) {
        localView.setVisibility(8);
      }
      localView = paramh.Mn(2131310635);
      if (localView != null) {
        localView.setVisibility(0);
      }
      localView = paramh.Mn(2131310635);
      if (localView != null) {
        localView.setOnClickListener((View.OnClickListener)new b(this, paramv, paramh));
      }
      this.tDd.invoke();
      AppMethodBeat.o(243029);
      return;
    }
    paramv = paramh.Mn(2131305735);
    if (paramv != null) {
      paramv.setVisibility(0);
    }
    paramv = paramh.Mn(2131307579);
    if (paramv != null) {
      paramv.setVisibility(8);
    }
    paramv = paramh.Mn(2131303186);
    if (paramv != null) {
      paramv.setVisibility(0);
    }
    paramv = paramh.Mn(2131310635);
    if (paramv != null) {
      paramv.setVisibility(8);
    }
    paramv = paramh.Mn(2131300802);
    if (paramv != null)
    {
      paramv.setVisibility(8);
      AppMethodBeat.o(243029);
      return;
    }
    AppMethodBeat.o(243029);
  }
  
  public final int getLayoutId()
  {
    return 2131494622;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(w paramw, v paramv, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243025);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tDe.tDc.invoke(Boolean.FALSE);
      this.tDe.a(paramv, paramh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243025);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(w paramw, v paramv, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243026);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tDe.tDc.invoke(Boolean.TRUE);
      this.tDe.a(paramv, paramh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLikeConvert$refresh$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243026);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.w
 * JD-Core Version:    0.7.0.1
 */