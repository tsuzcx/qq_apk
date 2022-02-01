package com.tencent.mm.plugin.finder.feed.jumper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WeAppHalfScreenStatusChangeListener;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/jumper/AdStoreJumperViewHandler$enterAdStore$halfScreenStateChangeListener$1", "Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;", "onEnterFullScreen", "", "onEnterHalfScreen", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AdStoreJumperViewHandler$enterAdStore$halfScreenStateChangeListener$1
  extends WeAppHalfScreenStatusChangeListener
{
  public final void ckU()
  {
    AppMethodBeat.i(364117);
    super.ckU();
    Log.i("Finder.AdStoreJumperClickHandler", "onEnterFullScreen...");
    AppMethodBeat.o(364117);
  }
  
  public final void ckV()
  {
    AppMethodBeat.i(364124);
    super.ckV();
    Log.i("Finder.AdStoreJumperClickHandler", "onEnterHalfScreen...");
    AppMethodBeat.o(364124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.AdStoreJumperViewHandler.enterAdStore.halfScreenStateChangeListener.1
 * JD-Core Version:    0.7.0.1
 */