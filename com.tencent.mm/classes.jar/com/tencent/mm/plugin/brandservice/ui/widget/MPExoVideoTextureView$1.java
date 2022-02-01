package com.tencent.mm.plugin.brandservice.ui.widget;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class MPExoVideoTextureView$1
  implements Runnable
{
  MPExoVideoTextureView$1(MPExoVideoTextureView paramMPExoVideoTextureView, Surface paramSurface) {}
  
  public final void run()
  {
    AppMethodBeat.i(6260);
    try
    {
      if ((this.lxx != null) && (this.lxx.isValid()))
      {
        ae.i("MicroMsg.MPExoVideoTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.lxx.hashCode()) });
        this.lxx.release();
      }
      AppMethodBeat.o(6260);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.MPExoVideoTextureView", localException, "release Surface error", new Object[0]);
      AppMethodBeat.o(6260);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoTextureView.1
 * JD-Core Version:    0.7.0.1
 */