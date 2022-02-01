package com.tencent.mm.plugin.finder.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderPostFooter$h
  implements View.OnClickListener
{
  FinderPostFooter$h(FinderPostFooter paramFinderPostFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(200118);
    paramView = new Intent();
    paramView.putExtra("key_scene", 1);
    a locala = a.qSb;
    a.c(this.qXG.getActivity(), paramView, this.qXG.getReqCode());
    AppMethodBeat.o(200118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostFooter.h
 * JD-Core Version:    0.7.0.1
 */