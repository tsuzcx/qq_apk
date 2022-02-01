package com.tencent.mm.plugin.finder.ui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class FinderMediaCropUI$t
  implements Runnable
{
  FinderMediaCropUI$t(FinderMediaCropUI paramFinderMediaCropUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(167369);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    Object localObject = this.sOs.getContext();
    p.g(localObject, "context");
    localLayoutParams.topMargin = ((int)((AppCompatActivity)localObject).getResources().getDimension(2131165303) + ar.B(this.sOs.getBaseContext(), (int)this.sOs.getResources().getDimension(2131165298)));
    localObject = this.sOs.cMt();
    p.g(localObject, "actionBarLayout");
    ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    this.sOs.cMt().requestLayout();
    AppMethodBeat.o(167369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.t
 * JD-Core Version:    0.7.0.1
 */