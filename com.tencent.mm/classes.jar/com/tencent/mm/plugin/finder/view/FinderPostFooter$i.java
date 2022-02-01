package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText.a;
import d.g.a.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onBack"})
final class FinderPostFooter$i
  implements MMEditText.a
{
  FinderPostFooter$i(FinderPostFooter paramFinderPostFooter) {}
  
  public final void onBack()
  {
    AppMethodBeat.i(200119);
    a locala = this.qXG.getBackClickListener();
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(200119);
      return;
    }
    AppMethodBeat.o(200119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostFooter.i
 * JD-Core Version:    0.7.0.1
 */