package com.tencent.mm.plugin.forcenotify.ui;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class ForceNotifyListUI$e$1
  implements Runnable
{
  ForceNotifyListUI$e$1(ForceNotifyListUI.e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(51077);
    if (ForceNotifyListUI.a(this.mHR.mHI).isEmpty())
    {
      localObject = ForceNotifyListUI.c(this.mHR.mHI);
      if (localObject == null) {
        j.ebi();
      }
      ((RecyclerView)localObject).setVisibility(8);
      localObject = ForceNotifyListUI.d(this.mHR.mHI);
      if (localObject == null) {
        j.ebi();
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(51077);
      return;
    }
    Object localObject = ForceNotifyListUI.c(this.mHR.mHI);
    if (localObject == null) {
      j.ebi();
    }
    ((RecyclerView)localObject).setVisibility(0);
    localObject = ForceNotifyListUI.b(this.mHR.mHI);
    if (localObject == null) {
      j.ebi();
    }
    ((ForceNotifyListUI.a)localObject).notifyDataSetChanged();
    AppMethodBeat.o(51077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.e.1
 * JD-Core Version:    0.7.0.1
 */