package com.tencent.mm.plugin.cast.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/ui/CastUIE;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CastUIE
  extends MMActivity
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return 0;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.ui.CastUIE
 * JD-Core Version:    0.7.0.1
 */