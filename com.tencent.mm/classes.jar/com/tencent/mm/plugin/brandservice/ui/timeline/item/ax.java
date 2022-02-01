package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.f;

public final class ax
  extends ai
{
  public final View cR(Context paramContext)
  {
    AppMethodBeat.i(264111);
    if (this.sEi != null)
    {
      paramContext = this.sEi;
      AppMethodBeat.o(264111);
      return paramContext;
    }
    this.sEi = View.inflate(paramContext, d.f.sua, null);
    cAQ();
    paramContext = this.sEi;
    AppMethodBeat.o(264111);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ax
 * JD-Core Version:    0.7.0.1
 */