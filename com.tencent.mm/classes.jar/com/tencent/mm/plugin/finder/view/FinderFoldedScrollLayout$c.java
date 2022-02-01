package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.am;
import com.tencent.mm.plugin.finder.convert.co;
import com.tencent.mm.plugin.finder.convert.cx;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFoldedScrollLayout$c
  implements com.tencent.mm.view.recyclerview.g
{
  FinderFoldedScrollLayout$c(FinderFoldedScrollLayout paramFinderFoldedScrollLayout) {}
  
  public final f<?> yF(int paramInt)
  {
    AppMethodBeat.i(344416);
    switch (paramInt)
    {
    default: 
      localf = (f)new com.tencent.mm.plugin.finder.convert.g();
      AppMethodBeat.o(344416);
      return localf;
    case 4: 
      localf = (f)new cx((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.Gzv));
      AppMethodBeat.o(344416);
      return localf;
    case 2: 
      localf = (f)new am((FinderFoldedScrollLayout.b)FinderFoldedScrollLayout.a(this.Gzv));
      AppMethodBeat.o(344416);
      return localf;
    }
    f localf = (f)new co((a)new FinderFoldedScrollLayout.c.a(this.Gzv));
    AppMethodBeat.o(344416);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.c
 * JD-Core Version:    0.7.0.1
 */