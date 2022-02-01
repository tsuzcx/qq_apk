package com.tencent.mm.plugin.card.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.kl.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.model.a.e.a;
import com.tencent.mm.plugin.card.ui.CardHomePageUI;
import com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI;
import com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;
import kotlin.n.d;

final class am$4
  extends IListener<kl>
{
  am$4(am paramam)
  {
    AppMethodBeat.i(161196);
    this.__eventId = kl.class.getName().hashCode();
    AppMethodBeat.o(161196);
  }
  
  private static boolean a(kl paramkl)
  {
    AppMethodBeat.i(112874);
    int i = ((Integer)g.aAh().azQ().get(ar.a.Oib, Integer.valueOf(1))).intValue();
    int j = ((Integer)g.aAh().azQ().get(ar.a.Oie, Integer.valueOf(1))).intValue();
    boolean bool = ((Boolean)g.aAh().azQ().get(ar.a.Oig, Boolean.FALSE)).booleanValue();
    Log.i("MicroMsg.SubCoreCard", "goto card version: %s, trade area: %s, newVersion2: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
    Object localObject;
    Context localContext;
    if (bool) {
      if (paramkl.dPA.context != null)
      {
        localObject = new Intent(paramkl.dPA.context, CardHomePageV3UI.class);
        localContext = paramkl.dPA.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        k.ctF();
        if (paramkl.dPA.enterScene == 1) {
          h.CyF.a(16322, new Object[] { Integer.valueOf(3) });
        }
      }
    }
    for (;;)
    {
      paramkl = com.tencent.mm.plugin.card.model.a.e.pVr;
      e.a.cup();
      AppMethodBeat.o(112874);
      return true;
      if (j == 2)
      {
        paramkl = (String)g.aAh().azQ().get(ar.a.Oif, "");
        if (!Util.isNullOrNil(paramkl)) {
          try
          {
            paramkl = (un)new un().parseFrom(paramkl.getBytes(d.ISO_8859_1));
            b.H(paramkl.Hwr, paramkl.Hws, paramkl.IhZ);
          }
          catch (IOException paramkl)
          {
            Log.printErrStackTrace("MicroMsg.SubCoreCard", paramkl, "", new Object[0]);
          }
        }
      }
      else if (i == 1)
      {
        if (paramkl.dPA.context != null)
        {
          localObject = new Intent(paramkl.dPA.context, CardHomePageNewUI.class);
          localContext = paramkl.dPA.context;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          k.ctF();
          if (paramkl.dPA.enterScene == 1) {
            h.CyF.a(16322, new Object[] { Integer.valueOf(3) });
          }
        }
      }
      else
      {
        if (paramkl.dPA.context != null)
        {
          localObject = new Intent(paramkl.dPA.context, CardHomePageUI.class);
          ((Intent)localObject).putExtra("key_from_scene", 22);
          ((Intent)localObject).putExtra("key_home_page_from_scene", paramkl.dPA.scene);
          localContext = paramkl.dPA.context;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          k.ctF();
          if (paramkl.dPA.enterScene == 1) {
            h.CyF.a(16322, new Object[] { Integer.valueOf(2) });
          }
        }
        paramkl.dPB.targetActivity = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.4
 * JD-Core Version:    0.7.0.1
 */