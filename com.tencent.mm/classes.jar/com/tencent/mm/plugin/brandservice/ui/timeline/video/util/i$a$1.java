package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class i$a$1
  implements Runnable
{
  i$a$1(i.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(152972);
    Context localContext = (Context)this.kiK.kiJ.aZT();
    Object localObject = this.kiK.kiJ.aZT();
    if (localObject != null) {}
    for (localObject = ((TmplShareWebViewToolUI)localObject).getString(2131297740);; localObject = null)
    {
      h.bL(localContext, (String)localObject);
      AppMethodBeat.o(152972);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i.a.1
 * JD-Core Version:    0.7.0.1
 */