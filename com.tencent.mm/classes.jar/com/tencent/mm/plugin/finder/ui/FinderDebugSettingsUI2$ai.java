package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.whatnews.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.t;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderDebugSettingsUI2$initOnCreate$36", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-finder_release"})
public final class FinderDebugSettingsUI2$ai
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203146);
    paramView = a.sbA;
    a.cFE();
    t.makeText(ai.getContext(), (CharSequence)"清理成功，重启生效", 1).show();
    AppMethodBeat.o(203146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderDebugSettingsUI2.ai
 * JD-Core Version:    0.7.0.1
 */