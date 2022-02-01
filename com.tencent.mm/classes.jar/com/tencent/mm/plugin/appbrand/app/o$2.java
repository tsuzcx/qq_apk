package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.e;
import com.tencent.mm.ui.base.h;

final class o$2
  implements h
{
  o$2(o paramo) {}
  
  public final LayoutInflater ex(Context paramContext)
  {
    AppMethodBeat.i(317691);
    paramContext = af.b(e.adOj.ex(paramContext));
    AppMethodBeat.o(317691);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.o.2
 * JD-Core Version:    0.7.0.1
 */