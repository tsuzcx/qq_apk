package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class AlbumPreviewUI$a
  implements Runnable
{
  WeakReference<AlbumPreviewUI> pZE;
  
  AlbumPreviewUI$a(AlbumPreviewUI paramAlbumPreviewUI)
  {
    AppMethodBeat.i(111448);
    this.pZE = new WeakReference(paramAlbumPreviewUI);
    AppMethodBeat.o(111448);
  }
  
  public final void run()
  {
    AppMethodBeat.i(111449);
    long l = System.currentTimeMillis();
    boolean bool = s.etX().etZ();
    l = System.currentTimeMillis() - l;
    Log.i("MicroMsg.AlbumPreviewUI", "smart gallery isValid: %s, dur: %s.", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) });
    h.IzE.a(19165, new Object[] { Long.valueOf(l) });
    if (l <= 3000L) {
      h.IzE.el(1297, 0);
    }
    for (;;)
    {
      if (bool)
      {
        a.a.BTR.BTD = 1;
        e.etm().postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(111447);
            if (AlbumPreviewUI.a.this.pZE != null)
            {
              AlbumPreviewUI localAlbumPreviewUI = (AlbumPreviewUI)AlbumPreviewUI.a.this.pZE.get();
              if (localAlbumPreviewUI != null)
              {
                localAlbumPreviewUI.setSmartGalleryEntryVisibility(true);
                localAlbumPreviewUI.CaV = true;
              }
            }
            AppMethodBeat.o(111447);
          }
        });
      }
      AppMethodBeat.o(111449);
      return;
      if (l <= 5000L) {
        h.IzE.el(1297, 1);
      } else if (l <= 10000L) {
        h.IzE.el(1297, 2);
      } else if (l <= 15000L) {
        h.IzE.el(1297, 3);
      } else {
        h.IzE.el(1297, 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.a
 * JD-Core Version:    0.7.0.1
 */