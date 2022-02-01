package com.tencent.mm.plugin.finder.megavideo.convert;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoLoadingConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoLoadingData;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class c
  extends e<bn>
{
  private final f uKk;
  
  public c(f paramf)
  {
    AppMethodBeat.i(248348);
    this.uKk = paramf;
    AppMethodBeat.o(248348);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(248346);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(248346);
  }
  
  public final int getLayoutId()
  {
    return 2131494508;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248345);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoLoadingConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.qhp.getContext();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(248345);
        throw paramView;
      }
      ((Activity)paramView).finish();
      a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoLoadingConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248345);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.convert.c
 * JD-Core Version:    0.7.0.1
 */