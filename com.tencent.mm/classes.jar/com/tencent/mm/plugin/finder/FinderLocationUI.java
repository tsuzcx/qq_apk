package com.tencent.mm.plugin.finder;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.l;
import d.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/FinderLocationUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "plugin-finder_release"})
public final class FinderLocationUI
  extends MMActivity
{
  public final int getLayoutId()
  {
    AppMethodBeat.i(178065);
    Throwable localThrowable = (Throwable)new n("An operation is not implemented: ".concat(String.valueOf("not implemented")));
    AppMethodBeat.o(178065);
    throw localThrowable;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.FinderLocationUI
 * JD-Core Version:    0.7.0.1
 */