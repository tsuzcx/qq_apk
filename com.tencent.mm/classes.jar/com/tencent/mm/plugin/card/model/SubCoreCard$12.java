package com.tencent.mm.plugin.card.model;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.mg;
import com.tencent.mm.autogen.a.mg.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.card.c.b;
import com.tencent.mm.plugin.card.mgr.j;
import com.tencent.mm.plugin.card.model.a.e;
import com.tencent.mm.plugin.card.model.a.e.a;
import com.tencent.mm.plugin.card.ui.CardHomePageUI;
import com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI;
import com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.IOException;
import kotlin.n.d;

class SubCoreCard$12
  extends IListener<mg>
{
  SubCoreCard$12(am paramam, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(294483);
    this.__eventId = mg.class.getName().hashCode();
    AppMethodBeat.o(294483);
  }
  
  private static boolean a(mg parammg)
  {
    AppMethodBeat.i(112874);
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acYc, Integer.valueOf(1))).intValue();
    int j = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acYf, Integer.valueOf(1))).intValue();
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acYh, Boolean.TRUE)).booleanValue();
    Log.i("MicroMsg.SubCoreCard", "goto card version: %s, trade area: %s, newVersion2: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
    Object localObject;
    Context localContext;
    if (bool) {
      if (parammg.hOp.context != null)
      {
        localObject = new Intent(parammg.hOp.context, CardHomePageV3UI.class);
        localContext = parammg.hOp.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        j.dky();
        if (parammg.hOp.enterScene == 1) {
          com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(3) });
        }
      }
    }
    for (;;)
    {
      parammg = e.wvR;
      e.a.dli();
      AppMethodBeat.o(112874);
      return true;
      if (j == 2)
      {
        parammg = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acYg, "");
        if (!Util.isNullOrNil(parammg)) {
          try
          {
            parammg = (wg)new wg().parseFrom(parammg.getBytes(d.ISO_8859_1));
            b.S(parammg.VcU, parammg.VcV, parammg.VQU);
          }
          catch (IOException parammg)
          {
            Log.printErrStackTrace("MicroMsg.SubCoreCard", parammg, "", new Object[0]);
          }
        }
      }
      else if (i == 1)
      {
        if (parammg.hOp.context != null)
        {
          localObject = new Intent(parammg.hOp.context, CardHomePageNewUI.class);
          localContext = parammg.hOp.context;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          j.dky();
          if (parammg.hOp.enterScene == 1) {
            com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(3) });
          }
        }
      }
      else
      {
        if (parammg.hOp.context != null)
        {
          localObject = new Intent(parammg.hOp.context, CardHomePageUI.class);
          ((Intent)localObject).putExtra("key_from_scene", 22);
          ((Intent)localObject).putExtra("key_home_page_from_scene", parammg.hOp.scene);
          localContext = parammg.hOp.context;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          j.dky();
          if (parammg.hOp.enterScene == 1) {
            com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(2) });
          }
        }
        parammg.hOq.hOr = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.SubCoreCard.12
 * JD-Core Version:    0.7.0.1
 */