package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class i$1
  implements Runnable
{
  i$1(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(14390);
    Toast.makeText(ah.getContext(), this.fOX, 0).show();
    AppMethodBeat.o(14390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.i.1
 * JD-Core Version:    0.7.0.1
 */