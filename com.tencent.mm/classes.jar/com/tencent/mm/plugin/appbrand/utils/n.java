package com.tencent.mm.plugin.appbrand.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.j;

public final class n
{
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(147716);
    paramContext = new d.a(paramContext).bBc(paramString2).bBd(paramString1).bBj(paramString3).c(paramOnClickListener1).bBk(paramString4).d(paramOnClickListener2).icu();
    paramContext.show();
    AppMethodBeat.o(147716);
    return paramContext;
  }
  
  public static ProgressDialog b(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(147713);
    paramContext = j.b(paramContext, paramCharSequence, true);
    AppMethodBeat.o(147713);
    return paramContext;
  }
  
  public static d b(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(147715);
    paramContext = new d.a(paramContext).bBc(paramString1).bBj(paramString2).c(paramOnClickListener).icu();
    paramContext.show();
    AppMethodBeat.o(147715);
    return paramContext;
  }
  
  public static d c(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(147717);
    paramContext = new d.a(paramContext).bBc(paramString2).bBd(paramString1).ayj(a.g.luggage_wxa_app_ok).c(paramOnClickListener).HG(false).icu();
    paramContext.show();
    AppMethodBeat.o(147717);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.n
 * JD-Core Version:    0.7.0.1
 */