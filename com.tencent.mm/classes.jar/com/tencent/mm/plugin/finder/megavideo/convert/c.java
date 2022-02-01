package com.tencent.mm.plugin.finder.megavideo.convert;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.model.bt;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoLoadingConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoLoadingData;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class c
  extends e<bt>
{
  private final f zvV;
  
  public c(f paramf)
  {
    AppMethodBeat.i(270752);
    this.zvV = paramf;
    AppMethodBeat.o(270752);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(270750);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(270750);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_mega_video_loading_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(286410);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoLoadingConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.tDl.getContext();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(286410);
        throw paramView;
      }
      ((Activity)paramView).finish();
      a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoLoadingConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286410);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.convert.c
 * JD-Core Version:    0.7.0.1
 */