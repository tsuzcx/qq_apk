package com.tencent.mm.plugin.card.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.jw.a;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.model.a.e.a;
import com.tencent.mm.plugin.card.ui.CardHomePageUI;
import com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI;
import com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.n.d;
import java.io.IOException;

final class am$4
  extends c<jw>
{
  am$4(am paramam)
  {
    AppMethodBeat.i(161196);
    this.__eventId = jw.class.getName().hashCode();
    AppMethodBeat.o(161196);
  }
  
  private static boolean a(jw paramjw)
  {
    AppMethodBeat.i(112874);
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IZw, Integer.valueOf(1))).intValue();
    int j = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IZz, Integer.valueOf(1))).intValue();
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IZB, Boolean.FALSE)).booleanValue();
    ae.i("MicroMsg.SubCoreCard", "goto card version: %s, trade area: %s, newVersion2: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
    Object localObject;
    Context localContext;
    if (bool) {
      if (paramjw.dxT.context != null)
      {
        localObject = new Intent(paramjw.dxT.context, CardHomePageV3UI.class);
        localContext = paramjw.dxT.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        k.bVR();
        if (paramjw.dxT.enterScene == 1) {
          com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(3) });
        }
      }
    }
    for (;;)
    {
      paramjw = com.tencent.mm.plugin.card.model.a.e.oHI;
      e.a.bWy();
      AppMethodBeat.o(112874);
      return true;
      if (j == 2)
      {
        paramjw = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IZA, "");
        if (!bu.isNullOrNil(paramjw)) {
          try
          {
            paramjw = (ti)new ti().parseFrom(paramjw.getBytes(d.ISO_8859_1));
            b.I(paramjw.CRv, paramjw.CRw, paramjw.DyO);
          }
          catch (IOException paramjw)
          {
            ae.printErrStackTrace("MicroMsg.SubCoreCard", paramjw, "", new Object[0]);
          }
        }
      }
      else if (i == 1)
      {
        if (paramjw.dxT.context != null)
        {
          localObject = new Intent(paramjw.dxT.context, CardHomePageNewUI.class);
          localContext = paramjw.dxT.context;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          k.bVR();
          if (paramjw.dxT.enterScene == 1) {
            com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(3) });
          }
        }
      }
      else
      {
        if (paramjw.dxT.context != null)
        {
          localObject = new Intent(paramjw.dxT.context, CardHomePageUI.class);
          ((Intent)localObject).putExtra("key_from_scene", 22);
          ((Intent)localObject).putExtra("key_home_page_from_scene", paramjw.dxT.scene);
          localContext = paramjw.dxT.context;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          k.bVR();
          if (paramjw.dxT.enterScene == 1) {
            com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(2) });
          }
        }
        paramjw.dxU.targetActivity = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.4
 * JD-Core Version:    0.7.0.1
 */