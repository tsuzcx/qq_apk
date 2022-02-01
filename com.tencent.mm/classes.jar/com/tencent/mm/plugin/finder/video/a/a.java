package com.tencent.mm.plugin.finder.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/parser/FinderMp4Parser;", "Lcom/tencent/mm/plugin/Atom/Mp4Parser2;", "()V", "TAG", "", "setLazyParse", "", "plugin-finder_release"})
public final class a
  extends j
{
  private final String TAG = "Finder.FinderMp4Parser";
  
  public final void fQP()
  {
    AppMethodBeat.i(199888);
    ad.i(this.TAG, "setLazyParse false");
    this.hXI = false;
    AppMethodBeat.o(199888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.a.a
 * JD-Core Version:    0.7.0.1
 */