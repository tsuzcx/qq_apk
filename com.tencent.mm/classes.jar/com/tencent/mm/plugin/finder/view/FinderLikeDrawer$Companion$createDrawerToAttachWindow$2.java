package com.tencent.mm.plugin.finder.view;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderLikeDrawer$Companion$createDrawerToAttachWindow$2", "Landroid/arch/lifecycle/LifecycleObserver;", "onDestroy", "", "plugin-finder_release"})
public final class FinderLikeDrawer$Companion$createDrawerToAttachWindow$2
  implements LifecycleObserver
{
  FinderLikeDrawer$Companion$createDrawerToAttachWindow$2(FinderLikeDrawer paramFinderLikeDrawer, Context paramContext) {}
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(205790);
    this.tgf.cQu();
    ((MMActivity)this.crf).getLifecycle().removeObserver((LifecycleObserver)this);
    AppMethodBeat.o(205790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderLikeDrawer.Companion.createDrawerToAttachWindow.2
 * JD-Core Version:    0.7.0.1
 */