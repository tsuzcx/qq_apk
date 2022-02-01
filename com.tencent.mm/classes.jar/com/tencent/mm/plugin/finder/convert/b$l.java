package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$l
  implements View.OnClickListener
{
  b$l(b paramb, View paramView1, View paramView2, h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(197383);
    paramView = this.qqo;
    k.g(paramView, "arrowIv");
    paramView.setVisibility(8);
    paramView = this.qqp;
    k.g(paramView, "loadingView");
    paramView.setVisibility(0);
    b.a(this.qql).a(this.qqk, true);
    AppMethodBeat.o(197383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.b.l
 * JD-Core Version:    0.7.0.1
 */