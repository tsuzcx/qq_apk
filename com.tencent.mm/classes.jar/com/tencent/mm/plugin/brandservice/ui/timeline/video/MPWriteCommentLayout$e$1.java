package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class MPWriteCommentLayout$e$1
  implements Runnable
{
  MPWriteCommentLayout$e$1(MPWriteCommentLayout.e parame, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(152913);
    this.khN.khv.aZM();
    if (this.khN.khv.getWeakThis$plugin_brandservice_release().get() != null)
    {
      Object localObject = this.khN.khv.getWeakThis$plugin_brandservice_release().get();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout");
        AppMethodBeat.o(152913);
        throw ((Throwable)localObject);
      }
      localObject = (MPWriteCommentLayout)localObject;
      b localb = this.kfG;
      j.p(localb, "rr");
      MPWriteCommentLayout.a((MPWriteCommentLayout)localObject, localb);
    }
    AppMethodBeat.o(152913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout.e.1
 * JD-Core Version:    0.7.0.1
 */