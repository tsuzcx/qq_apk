package com.tencent.mm.plugin.finder.megavideo.convert;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.cb;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoLoadingConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoLoadingData;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.view.recyclerview.f<cb>
{
  private final com.tencent.mm.plugin.finder.megavideo.ui.f Ezo;
  
  public c(com.tencent.mm.plugin.finder.megavideo.ui.f paramf)
  {
    AppMethodBeat.i(342274);
    this.Ezo = paramf;
    AppMethodBeat.o(342274);
  }
  
  private static final void j(j paramj, View paramView)
  {
    AppMethodBeat.i(342279);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoLoadingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    paramj = paramj.context;
    if (paramj == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(342279);
      throw paramj;
    }
    ((Activity)paramj).finish();
    a.a(new Object(), "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoLoadingConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342279);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(342294);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(342294);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_mega_video_loading_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.convert.c
 * JD-Core Version:    0.7.0.1
 */