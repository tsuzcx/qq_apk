package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.a.a;

public class bx$a
  implements bx
{
  public <WIDGET extends View> WIDGET c(Context paramContext, Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(135280);
    paramContext = (View)paramClass.cast(a.bA(paramClass).ag(new Object[] { paramContext }).object);
    AppMethodBeat.o(135280);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bx.a
 * JD-Core Version:    0.7.0.1
 */