package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class MPWriteCommentLayout$d$1
  implements Runnable
{
  MPWriteCommentLayout$d$1(MPWriteCommentLayout.d paramd, int paramInt1, int paramInt2, String paramString, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(152911);
    this.khM.khv.aZM();
    Object localObject1;
    String str;
    Object localObject2;
    if (this.khM.khv.getWeakThis$plugin_brandservice_release().get() != null)
    {
      localObject1 = this.khM.khv.getWeakThis$plugin_brandservice_release().get();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout");
        AppMethodBeat.o(152911);
        throw ((Throwable)localObject1);
      }
      localObject1 = (MPWriteCommentLayout)localObject1;
      int i = this.kfE;
      int j = this.kfF;
      str = this.hxS;
      localObject2 = this.kfG;
      j.p(localObject2, "rr");
      MPWriteCommentLayout.a((MPWriteCommentLayout)localObject1, i, j, str, (b)localObject2);
    }
    if ((this.kfF != 0) && (!bo.isNullOrNil(this.hxS)))
    {
      localObject1 = this.khM.khv.getWeakThis$plugin_brandservice_release().get();
      if (localObject1 == null) {
        j.ebi();
      }
      j.p(localObject1, "weakThis.get()!!");
      localObject1 = ((MPWriteCommentLayout)localObject1).getContext();
      str = this.hxS;
      localObject2 = this.khM.khv.getWeakThis$plugin_brandservice_release().get();
      if (localObject2 == null) {
        j.ebi();
      }
      j.p(localObject2, "weakThis.get()!!");
      h.a((Context)localObject1, str, "", ((MPWriteCommentLayout)localObject2).getContext().getString(2131297018), null);
      AppMethodBeat.o(152911);
      return;
    }
    AppMethodBeat.o(152911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout.d.1
 * JD-Core Version:    0.7.0.1
 */