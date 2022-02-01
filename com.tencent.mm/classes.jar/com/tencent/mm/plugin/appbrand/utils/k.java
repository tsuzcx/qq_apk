package com.tencent.mm.plugin.appbrand.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.i;

public final class k
{
  public static d a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(147715);
    paramContext = new d.a(paramContext).aMf(paramString1).aMm(paramString2).b(paramOnClickListener).fft();
    paramContext.show();
    AppMethodBeat.o(147715);
    return paramContext;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(147716);
    paramContext = new d.a(paramContext).aMf(paramString2).aMg(paramString1).aMm(paramString3).b(paramOnClickListener1).aMn(paramString4).c(paramOnClickListener2).fft();
    paramContext.show();
    AppMethodBeat.o(147716);
    return paramContext;
  }
  
  public static ProgressDialog b(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(147713);
    paramContext = i.c(paramContext, paramCharSequence, true);
    AppMethodBeat.o(147713);
    return paramContext;
  }
  
  public static d b(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(147717);
    paramContext = new d.a(paramContext).aMf(paramString2).aMg(paramString1).aaB(2131761022).b(paramOnClickListener).wX(false).fft();
    paramContext.show();
    AppMethodBeat.o(147717);
    return paramContext;
  }
  
  public static d t(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147714);
    paramContext = new d.a(paramContext).aMf(paramString2).aMg(paramString1).fft();
    paramContext.show();
    AppMethodBeat.o(147714);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.k
 * JD-Core Version:    0.7.0.1
 */