package com.tencent.mm.plugin.finder.video.parser;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/parser/FinderMp4Parser;", "Lcom/tencent/mm/plugin/Atom/Mp4Parser2;", "()V", "TAG", "", "setLazyParse", "", "plugin-finder_release"})
public final class a
  extends k
{
  private final String TAG = "Finder.FinderMp4Parser";
  
  public final void aNE()
  {
    AppMethodBeat.i(203956);
    ac.i(this.TAG, "setLazyParse false");
    this.ixM = false;
    AppMethodBeat.o(203956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.parser.a
 * JD-Core Version:    0.7.0.1
 */