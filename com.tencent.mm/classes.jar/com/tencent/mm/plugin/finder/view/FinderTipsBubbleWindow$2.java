package com.tencent.mm.plugin.finder.view;

import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow$2", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTipsBubbleWindow$2
  implements p
{
  FinderTipsBubbleWindow$2(u<T> paramu) {}
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(344163);
    this.GDB.dismiss();
    ((MMActivity)u.a(this.GDB)).getLifecycle().removeObserver((p)this);
    AppMethodBeat.o(344163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTipsBubbleWindow.2
 * JD-Core Version:    0.7.0.1
 */