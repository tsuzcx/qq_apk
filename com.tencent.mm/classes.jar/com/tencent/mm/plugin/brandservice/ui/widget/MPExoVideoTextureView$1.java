package com.tencent.mm.plugin.brandservice.ui.widget;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class MPExoVideoTextureView$1
  implements Runnable
{
  MPExoVideoTextureView$1(MPExoVideoTextureView paramMPExoVideoTextureView, Surface paramSurface) {}
  
  public final void run()
  {
    AppMethodBeat.i(6260);
    try
    {
      if ((this.pDF != null) && (this.pDF.isValid()))
      {
        Log.i("MicroMsg.MPExoVideoTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.pDF.hashCode()) });
        this.pDF.release();
      }
      AppMethodBeat.o(6260);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MPExoVideoTextureView", localException, "release Surface error", new Object[0]);
      AppMethodBeat.o(6260);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoTextureView.1
 * JD-Core Version:    0.7.0.1
 */