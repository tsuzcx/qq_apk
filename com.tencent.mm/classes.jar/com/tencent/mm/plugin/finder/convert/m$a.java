package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class m$a
  implements View.OnClickListener
{
  m$a(m paramm, e parame, BaseFinderFeed paramBaseFinderFeed) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(197426);
    paramView = this.nGG.getContext();
    k.g(paramView, "holder.context");
    m.a(paramView, this.qqO.bMs(), this.qqO.feedObject.getUserName());
    AppMethodBeat.o(197426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.m.a
 * JD-Core Version:    0.7.0.1
 */