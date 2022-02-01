package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class av
  extends ag
{
  public final View cU(Context paramContext)
  {
    AppMethodBeat.i(194977);
    if (this.puO != null)
    {
      paramContext = this.puO;
      AppMethodBeat.o(194977);
      return paramContext;
    }
    this.puO = View.inflate(paramContext, 2131493302, null);
    cne();
    paramContext = this.puO;
    AppMethodBeat.o(194977);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.av
 * JD-Core Version:    0.7.0.1
 */