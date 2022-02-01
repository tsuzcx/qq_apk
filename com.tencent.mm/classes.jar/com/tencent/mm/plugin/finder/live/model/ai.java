package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRotationHelper;", "", "rContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "(Ljava/lang/ref/WeakReference;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getRContext", "()Ljava/lang/ref/WeakReference;", "setRContext", "changeScreenOrientation", "", "changeScreenToLandscape", "changeScreenToPortrait", "enableAutoRotation", "", "lockScreenRotation", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
{
  public WeakReference<MMFinderUI> CGS;
  public final String TAG;
  
  public ai(WeakReference<MMFinderUI> paramWeakReference)
  {
    AppMethodBeat.i(359169);
    this.CGS = paramWeakReference;
    this.TAG = "Finder.LiveRotationHelper";
    AppMethodBeat.o(359169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ai
 * JD-Core Version:    0.7.0.1
 */