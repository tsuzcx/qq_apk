package com.tencent.mm.plugin.datareport.sample;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SampleUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SampleUI$1(SampleUI paramSampleUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(262922);
    this.xhZ.finish();
    AppMethodBeat.o(262922);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.sample.SampleUI.1
 * JD-Core Version:    0.7.0.1
 */