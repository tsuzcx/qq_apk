package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRotationHelper;", "", "context", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "(Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "setContext", "changeScreenOrientation", "", "changeScreenToLandscape", "changeScreenToPortrait", "enableAutoRotation", "", "lockScreenRotation", "plugin-finder_release"})
public final class ae
{
  public final String TAG;
  public MMFinderUI ygW;
  
  public ae(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(292151);
    this.ygW = paramMMFinderUI;
    this.TAG = "Finder.LiveRotationHelper";
    AppMethodBeat.o(292151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ae
 * JD-Core Version:    0.7.0.1
 */