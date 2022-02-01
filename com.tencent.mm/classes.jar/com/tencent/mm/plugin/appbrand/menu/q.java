package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.IWWAPI.WWAppType;
import com.tencent.wework.api.WWAPIFactory;

public final class q
  extends a<ag>
{
  public q()
  {
    super(u.nfy.ordinal());
    AppMethodBeat.i(227172);
    AppMethodBeat.o(227172);
  }
  
  public static boolean ef(Context paramContext)
  {
    AppMethodBeat.i(227173);
    paramContext = WWAPIFactory.ly(paramContext);
    if ((paramContext.a(IWWAPI.WWAppType.Sxb)) && (paramContext.hrE()))
    {
      AppMethodBeat.o(227173);
      return true;
    }
    AppMethodBeat.o(227173);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.q
 * JD-Core Version:    0.7.0.1
 */