package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.stub.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout.a;

final class AlbumPreviewUI$7
  implements DrawedCallBackFrameLayout.a
{
  AlbumPreviewUI$7(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void bEm()
  {
    AppMethodBeat.i(21399);
    try
    {
      AlbumPreviewUI.b(this.neV).bEm();
      if (!this.neV.neH) {}
    }
    catch (Exception localException)
    {
      try
      {
        this.neV.unbindService(AlbumPreviewUI.H(this.neV));
        this.neV.neH = false;
        AppMethodBeat.o(21399);
        return;
        localException = localException;
        ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", localException, "", new Object[0]);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", localThrowable, "Failed to unbindService when onViewDrawed is invoked.", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.7
 * JD-Core Version:    0.7.0.1
 */