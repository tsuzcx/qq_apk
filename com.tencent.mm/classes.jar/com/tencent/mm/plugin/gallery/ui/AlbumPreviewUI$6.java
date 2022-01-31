package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.stub.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout.a;

final class AlbumPreviewUI$6
  implements DrawedCallBackFrameLayout.a
{
  AlbumPreviewUI$6(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void aXH()
  {
    try
    {
      AlbumPreviewUI.b(this.kIF).aXH();
      if (!this.kIF.kIv) {}
    }
    catch (Exception localException)
    {
      try
      {
        this.kIF.unbindService(AlbumPreviewUI.A(this.kIF));
        this.kIF.kIv = false;
        return;
        localException = localException;
        y.printErrStackTrace("MicroMsg.AlbumPreviewUI", localException, "", new Object[0]);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.AlbumPreviewUI", localThrowable, "Failed to unbindService when onViewDrawed is invoked.", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.6
 * JD-Core Version:    0.7.0.1
 */