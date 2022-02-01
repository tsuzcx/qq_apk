package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.kernel.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  implements l
{
  public final AppBrandRecentView a(Context paramContext, l.b paramb, l.a parama)
  {
    AppMethodBeat.i(227792);
    if (paramb == l.b.oDI)
    {
      paramb = new ConversationAppBrandRecentView(paramContext);
      paramb.setSceneFactory(parama);
      parama = new FrameLayout.LayoutParams(-1, (int)paramContext.getResources().getDimension(2131165858));
      paramb.setPadding(0, (int)paramContext.getResources().getDimension(2131165860), 0, 0);
      paramb.setLayoutParams(parama);
      AppMethodBeat.o(227792);
      return paramb;
    }
    if (paramb == l.b.oDH)
    {
      paramb = new MenuAppBrandRecentView(paramContext);
      paramb.setSceneFactory(parama);
      parama = new FrameLayout.LayoutParams(-1, (int)paramContext.getResources().getDimension(2131165858));
      paramb.setPadding(0, (int)paramContext.getResources().getDimension(2131165860), 0, 0);
      paramb.setLayoutParams(parama);
      AppMethodBeat.o(227792);
      return paramb;
    }
    AppMethodBeat.o(227792);
    return null;
  }
  
  public final void ccV()
  {
    AppMethodBeat.i(227793);
    Log.i("MicroMsg.AppBrandRecentViewService", "[hideAppBrandRecentView] delay:%s type:%s", new Object[] { Integer.valueOf(300), Integer.valueOf(8) });
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb())
    {
      ks localks = new ks();
      localks.dPN.delay = 300;
      localks.dPN.type = 8;
      EventCenter.instance.publish(localks);
    }
    AppMethodBeat.o(227793);
  }
  
  public final g ccW()
  {
    AppMethodBeat.i(227794);
    g localg = new g();
    AppMethodBeat.o(227794);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.h
 * JD-Core Version:    0.7.0.1
 */