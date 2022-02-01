package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;

public final class o
  extends a<ae>
{
  public o()
  {
    super(r.lTk.ordinal());
    AppMethodBeat.i(188658);
    AppMethodBeat.o(188658);
  }
  
  public static boolean dG(Context paramContext)
  {
    AppMethodBeat.i(188659);
    boolean bool = WWAPIFactory.lt(paramContext).gab();
    AppMethodBeat.o(188659);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.o
 * JD-Core Version:    0.7.0.1
 */