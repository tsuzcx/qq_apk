package com.tencent.mm.plugin.gallery.ui;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.t.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class SmartGalleryUI$h
  implements Runnable
{
  String HQI;
  WeakReference<RecyclerView> HQL;
  WeakReference<SmartGalleryUI.f> HQM;
  List<t.i> xGG;
  
  SmartGalleryUI$h(RecyclerView paramRecyclerView, SmartGalleryUI.f paramf)
  {
    AppMethodBeat.i(289449);
    this.xGG = new ArrayList();
    this.HQL = new WeakReference(paramRecyclerView);
    this.HQM = new WeakReference(paramf);
    AppMethodBeat.o(289449);
  }
  
  public final void run()
  {
    AppMethodBeat.i(111702);
    if ((this.HQL == null) || (this.HQM == null))
    {
      Log.e("MicroMsg.SmartGalleryUI", "update search ui, ref is null, return.");
      AppMethodBeat.o(111702);
      return;
    }
    if (this.xGG != null)
    {
      Object localObject = (RecyclerView)this.HQL.get();
      if (localObject != null)
      {
        SmartGalleryUI.f localf = (SmartGalleryUI.f)this.HQM.get();
        if (localf != null)
        {
          ((RecyclerView)localObject).setAdapter(localf);
          localf.HQI = this.HQI;
          localObject = this.xGG;
          localf.xGG.clear();
          localf.xGG.addAll((Collection)localObject);
          localf.bZE.notifyChanged();
        }
      }
      AppMethodBeat.o(111702);
      return;
    }
    Log.e("MicroMsg.SmartGalleryUI", "update search ui, data is null.");
    AppMethodBeat.o(111702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.h
 * JD-Core Version:    0.7.0.1
 */