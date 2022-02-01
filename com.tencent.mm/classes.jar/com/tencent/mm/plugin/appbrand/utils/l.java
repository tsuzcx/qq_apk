package com.tencent.mm.plugin.appbrand.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.j;

public final class l
{
  public static d a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(147715);
    paramContext = new d.a(paramContext).aZh(paramString1).aZo(paramString2).c(paramOnClickListener).fQv();
    paramContext.show();
    AppMethodBeat.o(147715);
    return paramContext;
  }
  
  public static d a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(147716);
    paramContext = new d.a(paramContext).aZh(paramString2).aZi(paramString1).aZo(paramString3).c(paramOnClickListener1).aZp(paramString4).d(paramOnClickListener2).fQv();
    paramContext.show();
    AppMethodBeat.o(147716);
    return paramContext;
  }
  
  public static ProgressDialog b(Context paramContext, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(147713);
    paramContext = j.c(paramContext, paramCharSequence, true);
    AppMethodBeat.o(147713);
    return paramContext;
  }
  
  public static d b(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(147717);
    paramContext = new d.a(paramContext).aZh(paramString2).aZi(paramString1).afU(2131761022).c(paramOnClickListener).zf(false).fQv();
    paramContext.show();
    AppMethodBeat.o(147717);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.l
 * JD-Core Version:    0.7.0.1
 */