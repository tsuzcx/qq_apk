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
    super(x.tkK.ordinal());
    AppMethodBeat.i(323863);
    AppMethodBeat.o(323863);
  }
  
  public static boolean eY(Context paramContext)
  {
    AppMethodBeat.i(323873);
    paramContext = WWAPIFactory.oM(paramContext);
    if ((paramContext.a(IWWAPI.WWAppType.aicA)) && (paramContext.keI()))
    {
      AppMethodBeat.o(323873);
      return true;
    }
    AppMethodBeat.o(323873);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.s
 * JD-Core Version:    0.7.0.1
 */