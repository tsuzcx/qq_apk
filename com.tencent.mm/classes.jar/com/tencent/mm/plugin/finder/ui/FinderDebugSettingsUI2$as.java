package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.t;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$8", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
public final class FinderDebugSettingsUI2$as
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203157);
    paramView = b.rCU;
    b.lH(true);
    paramView = b.rCU;
    b.cyy();
    t.makeText(ai.getContext(), (CharSequence)"好了", 1).show();
    AppMethodBeat.o(203157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderDebugSettingsUI2.as
 * JD-Core Version:    0.7.0.1
 */