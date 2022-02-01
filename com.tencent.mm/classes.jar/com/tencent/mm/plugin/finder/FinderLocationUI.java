package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/FinderLocationUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLocationUI
  extends MMActivity
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(178065);
    Throwable localThrowable = (Throwable)new q("An operation is not implemented: ".concat(String.valueOf("not implemented")));
    AppMethodBeat.o(178065);
    throw localThrowable;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.FinderLocationUI
 * JD-Core Version:    0.7.0.1
 */