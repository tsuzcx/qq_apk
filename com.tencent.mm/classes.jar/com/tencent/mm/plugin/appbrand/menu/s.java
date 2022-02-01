package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.IWWAPI.WWAppType;
import com.tencent.wework.api.WWAPIFactory;

public final class s
  extends a<ah>
{
  public s()
  {
    super(w.qgg.ordinal());
    AppMethodBeat.i(283020);
    AppMethodBeat.o(283020);
  }
  
  public static boolean ee(Context paramContext)
  {
    AppMethodBeat.i(283021);
    paramContext = WWAPIFactory.mw(paramContext);
    if ((paramContext.a(IWWAPI.WWAppType.ZYb)) && (paramContext.ivm()))
    {
      AppMethodBeat.o(283021);
      return true;
    }
    AppMethodBeat.o(283021);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.s
 * JD-Core Version:    0.7.0.1
 */