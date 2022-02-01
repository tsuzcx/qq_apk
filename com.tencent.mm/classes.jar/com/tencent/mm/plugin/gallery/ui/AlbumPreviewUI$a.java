package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class AlbumPreviewUI$a
  implements Runnable
{
  WeakReference<AlbumPreviewUI> kOy;
  
  AlbumPreviewUI$a(AlbumPreviewUI paramAlbumPreviewUI)
  {
    AppMethodBeat.i(111448);
    this.kOy = new WeakReference(paramAlbumPreviewUI);
    AppMethodBeat.o(111448);
  }
  
  public final void run()
  {
    AppMethodBeat.i(111449);
    long l = System.currentTimeMillis();
    boolean bool = s.czT().czV();
    l = System.currentTimeMillis() - l;
    ad.i("MicroMsg.AlbumPreviewUI", "smart gallery isValid: %s, dur: %s.", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) });
    h.vKh.f(19165, new Object[] { Long.valueOf(l) });
    if (l <= 3000L) {
      h.vKh.dB(1297, 0);
    }
    for (;;)
    {
      if (bool)
      {
        a.a.rzX.rzJ = 1;
        e.czi().f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(111447);
            if (AlbumPreviewUI.a.this.kOy != null)
            {
              AlbumPreviewUI localAlbumPreviewUI = (AlbumPreviewUI)AlbumPreviewUI.a.this.kOy.get();
              if (localAlbumPreviewUI != null)
              {
                localAlbumPreviewUI.setSmartGalleryEntryVisibility(true);
                localAlbumPreviewUI.rIj = true;
              }
            }
            AppMethodBeat.o(111447);
          }
        });
      }
      AppMethodBeat.o(111449);
      return;
      if (l <= 5000L) {
        h.vKh.dB(1297, 1);
      } else if (l <= 10000L) {
        h.vKh.dB(1297, 2);
      } else if (l <= 15000L) {
        h.vKh.dB(1297, 3);
      } else {
        h.vKh.dB(1297, 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.a
 * JD-Core Version:    0.7.0.1
 */