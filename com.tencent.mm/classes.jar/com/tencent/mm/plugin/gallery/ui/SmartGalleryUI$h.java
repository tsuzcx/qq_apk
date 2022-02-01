package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.s.i;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class SmartGalleryUI$h
  implements Runnable
{
  List<s.i> oXp;
  String sTA;
  WeakReference<RecyclerView> sTD;
  WeakReference<SmartGalleryUI.f> sTE;
  
  SmartGalleryUI$h(RecyclerView paramRecyclerView, SmartGalleryUI.f paramf)
  {
    AppMethodBeat.i(111701);
    this.oXp = new ArrayList();
    this.sTD = new WeakReference(paramRecyclerView);
    this.sTE = new WeakReference(paramf);
    AppMethodBeat.o(111701);
  }
  
  public final void run()
  {
    AppMethodBeat.i(111702);
    if ((this.sTD == null) || (this.sTE == null))
    {
      ac.e("MicroMsg.SmartGalleryUI", "update search ui, ref is null, return.");
      AppMethodBeat.o(111702);
      return;
    }
    if (this.oXp != null)
    {
      Object localObject = (RecyclerView)this.sTD.get();
      if (localObject != null)
      {
        SmartGalleryUI.f localf = (SmartGalleryUI.f)this.sTE.get();
        if (localf != null)
        {
          ((RecyclerView)localObject).setAdapter(localf);
          localf.sTA = this.sTA;
          localObject = this.oXp;
          localf.oXp.clear();
          localf.oXp.addAll((Collection)localObject);
          localf.arg.notifyChanged();
        }
      }
      AppMethodBeat.o(111702);
      return;
    }
    ac.e("MicroMsg.SmartGalleryUI", "update search ui, data is null.");
    AppMethodBeat.o(111702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.h
 * JD-Core Version:    0.7.0.1
 */