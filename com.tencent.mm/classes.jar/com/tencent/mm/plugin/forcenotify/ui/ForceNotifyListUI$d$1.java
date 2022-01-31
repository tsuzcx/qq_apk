package com.tencent.mm.plugin.forcenotify.ui;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class ForceNotifyListUI$d$1
  implements Runnable
{
  ForceNotifyListUI$d$1(ForceNotifyListUI.d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(51075);
    Object localObject = ForceNotifyListUI.b(this.mHQ.mHI);
    if (localObject == null) {
      j.ebi();
    }
    ((ForceNotifyListUI.a)localObject).notifyDataSetChanged();
    localObject = ForceNotifyListUI.g(this.mHQ.mHI);
    if (localObject == null) {
      j.ebi();
    }
    ((View)localObject).setVisibility(8);
    if (ForceNotifyListUI.a(this.mHQ.mHI).isEmpty())
    {
      localObject = ForceNotifyListUI.c(this.mHQ.mHI);
      if (localObject == null) {
        j.ebi();
      }
      ((RecyclerView)localObject).setVisibility(8);
      localObject = ForceNotifyListUI.d(this.mHQ.mHI);
      if (localObject == null) {
        j.ebi();
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(51075);
      return;
    }
    localObject = ForceNotifyListUI.c(this.mHQ.mHI);
    if (localObject == null) {
      j.ebi();
    }
    ((RecyclerView)localObject).setVisibility(0);
    AppMethodBeat.o(51075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.d.1
 * JD-Core Version:    0.7.0.1
 */