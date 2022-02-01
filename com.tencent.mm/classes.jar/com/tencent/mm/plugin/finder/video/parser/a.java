package com.tencent.mm.plugin.finder.video.parser;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/parser/FinderMp4Parser;", "Lcom/tencent/mm/plugin/Atom/Mp4Parser2;", "()V", "TAG", "", "setLazyParse", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends k
{
  private final String TAG = "Finder.FinderMp4Parser";
  
  public final void bTV()
  {
    AppMethodBeat.i(335278);
    Log.i(this.TAG, "setLazyParse false");
    this.pEs = false;
    AppMethodBeat.o(335278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.parser.a
 * JD-Core Version:    0.7.0.1
 */