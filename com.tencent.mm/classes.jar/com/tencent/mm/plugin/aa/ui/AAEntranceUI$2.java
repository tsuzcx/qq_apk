package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AAEntranceUI$2
  implements a.a
{
  AAEntranceUI$2(AAEntranceUI paramAAEntranceUI) {}
  
  public final void aoW()
  {
    AppMethodBeat.i(40709);
    Intent localIntent = new Intent(this.gpn.getContext(), AAQueryListUI.class);
    this.gpn.startActivity(localIntent);
    AppMethodBeat.o(40709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAEntranceUI.2
 * JD-Core Version:    0.7.0.1
 */