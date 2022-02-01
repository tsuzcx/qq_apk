package com.tencent.mm.live.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.f;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/LiveUIE;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveUIE
  extends MMActivity
{
  public final int getLayoutId()
  {
    return b.f.background_transparent;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIE
 * JD-Core Version:    0.7.0.1
 */