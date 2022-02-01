package com.tencent.mm.plugin.finder.video.parser;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/parser/FinderMp4Parser;", "Lcom/tencent/mm/plugin/Atom/Mp4Parser2;", "()V", "TAG", "", "setLazyParse", "", "plugin-finder_release"})
public final class a
  extends k
{
  private final String TAG = "Finder.FinderMp4Parser";
  
  public final void blT()
  {
    AppMethodBeat.i(254441);
    Log.i(this.TAG, "setLazyParse false");
    this.jQI = false;
    AppMethodBeat.o(254441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.parser.a
 * JD-Core Version:    0.7.0.1
 */