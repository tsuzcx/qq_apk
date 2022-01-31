package com.tencent.mm.plugin.forcenotify.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.forcenotify.b.c;
import java.util.ArrayList;
import java.util.Collection;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class ForceNotifyListUI$d
  implements Runnable
{
  ForceNotifyListUI$d(ForceNotifyListUI paramForceNotifyListUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(51076);
    ForceNotifyListUI.a(this.mHI).clear();
    ArrayList localArrayList = ForceNotifyListUI.a(this.mHI);
    c localc = c.mHu;
    localArrayList.addAll((Collection)c.bzJ());
    this.mHI.runOnUiThread((Runnable)new ForceNotifyListUI.d.1(this));
    AppMethodBeat.o(51076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.d
 * JD-Core Version:    0.7.0.1
 */