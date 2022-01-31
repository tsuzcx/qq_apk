package com.tencent.mm.plugin.brandservice.ui.widget;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class MPVideoView$o$1
  implements Runnable
{
  MPVideoView$o$1(MPVideoView.o paramo, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(153041);
    if (this.evU != null)
    {
      Object localObject = this.evU;
      if (localObject == null) {
        j.ebi();
      }
      if (!((Bitmap)localObject).isRecycled())
      {
        localObject = MPVideoView.a(this.kjT.kjR);
        if (localObject == null) {
          j.ebi();
        }
        ((ImageView)localObject).setImageBitmap(this.evU);
      }
    }
    AppMethodBeat.o(153041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.o.1
 * JD-Core Version:    0.7.0.1
 */