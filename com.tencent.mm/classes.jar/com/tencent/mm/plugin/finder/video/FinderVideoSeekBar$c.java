package com.tencent.mm.plugin.finder.video;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$showProgressBar$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVideoSeekBar$c
  implements View.OnLayoutChangeListener
{
  FinderVideoSeekBar$c(a<ah> parama, FinderVideoSeekBar paramFinderVideoSeekBar) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(334686);
    this.Gri.invoke();
    this.Grh.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
    AppMethodBeat.o(334686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoSeekBar.c
 * JD-Core Version:    0.7.0.1
 */