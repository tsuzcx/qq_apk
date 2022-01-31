package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.sdk.platformtools.al;

public final class f
  extends a<c>
{
  public f()
  {
    super(r.iqU.ordinal());
    AppMethodBeat.i(102136);
    AppMethodBeat.o(102136);
  }
  
  public static void a(d paramd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(140851);
    i.ab(paramString, paramBoolean);
    if (paramBoolean) {}
    for (paramString = paramd.getContext().getResources().getString(2131296606);; paramString = paramd.getContext().getResources().getString(2131296605))
    {
      al.d(new f.1(paramd, paramString));
      AppMethodBeat.o(140851);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.f
 * JD-Core Version:    0.7.0.1
 */