package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;

public final class p
  extends a<ad>
{
  public p()
  {
    super(s.lXL.ordinal());
    AppMethodBeat.i(222824);
    AppMethodBeat.o(222824);
  }
  
  public static boolean dK(Context paramContext)
  {
    AppMethodBeat.i(222825);
    boolean bool = WWAPIFactory.lz(paramContext).geD();
    AppMethodBeat.o(222825);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.p
 * JD-Core Version:    0.7.0.1
 */