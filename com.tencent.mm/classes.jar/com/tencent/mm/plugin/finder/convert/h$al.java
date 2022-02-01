package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class h$al
  implements View.OnClickListener
{
  h$al(h paramh, List paramList, BaseFinderFeed paramBaseFinderFeed, ank paramank, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(201777);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFoldedLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    h.a(this.rVO, this.rVf, this.rVQ, this.oTF);
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFoldedLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(201777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.al
 * JD-Core Version:    0.7.0.1
 */