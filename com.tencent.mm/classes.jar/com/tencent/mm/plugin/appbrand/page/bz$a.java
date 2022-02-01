package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.a.a;

public class bz$a
  implements bz
{
  public <WIDGET extends View> WIDGET d(Context paramContext, Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(135280);
    paramContext = (View)paramClass.cast(a.ce(paramClass).ao(new Object[] { paramContext }).object);
    AppMethodBeat.o(135280);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bz.a
 * JD-Core Version:    0.7.0.1
 */