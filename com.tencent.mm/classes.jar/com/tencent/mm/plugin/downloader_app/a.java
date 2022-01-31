package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.ui.widget.b.c.a;

public final class a
  implements com.tencent.mm.plugin.downloader_app.a.c
{
  public final void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(136011);
    PBool localPBool = new PBool();
    paramContext = new c.a(paramContext);
    paramContext.Rb(2131301363);
    paramContext.Rf(2131301361);
    paramContext.Ri(2131301364);
    paramContext.a(new a.1(this, paramOnClickListener1, localPBool, paramString));
    paramContext.Rj(2131301360);
    paramContext.b(new a.2(this, paramOnClickListener2, localPBool, paramString));
    paramContext.rG(true);
    paramContext.e(new a.3(this, paramOnCancelListener, localPBool, paramString));
    paramContext.aLZ().show();
    com.tencent.mm.plugin.downloader_app.c.a.a(15, 1501, 1, 1, paramString, "", "");
    AppMethodBeat.o(136011);
  }
  
  public final void b(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(136012);
    PBool localPBool = new PBool();
    paramContext = new c.a(paramContext);
    paramContext.Rb(2131301365);
    paramContext.Rf(2131301366);
    paramContext.Ri(2131301364);
    paramContext.a(new a.4(this, localPBool, paramOnClickListener1, paramString));
    paramContext.Rj(2131301362);
    paramContext.b(new a.5(this, paramOnClickListener2, localPBool, paramString));
    paramContext.rG(true);
    paramContext.e(new a.6(this, paramOnCancelListener, localPBool, paramString));
    paramContext.aLZ().show();
    com.tencent.mm.plugin.downloader_app.c.a.a(15, 1502, 1, 1, paramString, "", "");
    AppMethodBeat.o(136012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a
 * JD-Core Version:    0.7.0.1
 */