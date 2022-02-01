package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class e$ab
  implements View.OnClickListener
{
  e$ab(e parame, com.tencent.mm.view.recyclerview.e parame1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(197394);
    ad.i("Finder.FeedConvert", "onClickShare:" + this.nGG.ln());
    e.c(this.qqM, this.nGG);
    AppMethodBeat.o(197394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e.ab
 * JD-Core Version:    0.7.0.1
 */