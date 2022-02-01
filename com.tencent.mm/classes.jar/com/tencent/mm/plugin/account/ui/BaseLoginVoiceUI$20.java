package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.g;
import java.util.Iterator;
import java.util.List;

final class BaseLoginVoiceUI$20
  implements u.g
{
  BaseLoginVoiceUI$20(BaseLoginVoiceUI paramBaseLoginVoiceUI, List paramList) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(304978);
    if (params.size() == 0)
    {
      Iterator localIterator = this.pZG.iterator();
      while (localIterator.hasNext()) {
        params.j((t)localIterator.next());
      }
    }
    AppMethodBeat.o(304978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BaseLoginVoiceUI.20
 * JD-Core Version:    0.7.0.1
 */