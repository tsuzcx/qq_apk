package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.l;
import d.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationSearchUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "plugin-finder_release"})
public final class FinderConversationSearchUI
  extends MMActivity
{
  public final int getLayoutId()
  {
    AppMethodBeat.i(203933);
    Throwable localThrowable = (Throwable)new n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(203933);
    throw localThrowable;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationSearchUI
 * JD-Core Version:    0.7.0.1
 */