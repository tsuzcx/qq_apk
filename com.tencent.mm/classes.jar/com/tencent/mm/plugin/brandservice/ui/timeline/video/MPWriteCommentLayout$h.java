package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import a.v;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class MPWriteCommentLayout$h
  implements Runnable
{
  MPWriteCommentLayout$h(MPWriteCommentLayout paramMPWriteCommentLayout) {}
  
  public final void run()
  {
    AppMethodBeat.i(152919);
    MPWriteCommentLayout.d(this.khv);
    Object localObject = this.khv.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(152919);
      throw ((Throwable)localObject);
    }
    localObject = (InputMethodManager)localObject;
    if (localObject != null)
    {
      ((InputMethodManager)localObject).showSoftInput((View)MPWriteCommentLayout.e(this.khv), 0);
      AppMethodBeat.o(152919);
      return;
    }
    AppMethodBeat.o(152919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout.h
 * JD-Core Version:    0.7.0.1
 */