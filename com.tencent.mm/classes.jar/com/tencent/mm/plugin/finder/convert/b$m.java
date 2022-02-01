package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.view.recyclerview.e;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$m
  implements View.OnClickListener
{
  b$m(b paramb, h paramh, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(165318);
    paramView = a.qpY;
    paramView = this.qqk.qDA.getUsername();
    h localh = this.qqk;
    Context localContext = this.nGG.getContext();
    d.g.b.k.g(localContext, "holder.context");
    a.a(paramView, localh, localContext, b.a(this.qql).getCommentScene());
    AppMethodBeat.o(165318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.b.m
 * JD-Core Version:    0.7.0.1
 */