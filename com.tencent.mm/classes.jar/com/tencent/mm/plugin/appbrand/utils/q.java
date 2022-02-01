package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;

public final class q
{
  public static e b(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(147715);
    paramContext = new e.a(paramContext).bDv(paramString1).bDC(paramString2).c(paramOnClickListener).jHH();
    paramContext.show();
    AppMethodBeat.o(147715);
    return paramContext;
  }
  
  public static e c(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(147717);
    paramContext = new e.a(paramContext).bDv(paramString2).bDw(paramString1).aER(a.g.luggage_wxa_app_ok).c(paramOnClickListener).NC(false).jHH();
    paramContext.show();
    AppMethodBeat.o(147717);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.q
 * JD-Core Version:    0.7.0.1
 */