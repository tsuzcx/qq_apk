package com.tencent.mm.plugin.card.model;

import a.l.d;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.a.il.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.model.a.f;
import com.tencent.mm.plugin.card.model.a.f.a;
import com.tencent.mm.plugin.card.ui.CardHomePageUI;
import com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;

final class am$4
  extends c<il>
{
  am$4(am paramam)
  {
    AppMethodBeat.i(87933);
    this.__eventId = il.class.getName().hashCode();
    AppMethodBeat.o(87933);
  }
  
  private static boolean a(il paramil)
  {
    AppMethodBeat.i(87934);
    int i = ((Integer)g.RL().Ru().get(ac.a.yLe, Integer.valueOf(0))).intValue();
    int j = ((Integer)g.RL().Ru().get(ac.a.yLh, Integer.valueOf(1))).intValue();
    ab.i("MicroMsg.SubCoreCard", "goto card version: %s, trade area: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (j == 2)
    {
      paramil = (String)g.RL().Ru().get(ac.a.yLi, "");
      if (bo.isNullOrNil(paramil)) {}
    }
    for (;;)
    {
      try
      {
        paramil = (ou)new ou().parseFrom(paramil.getBytes(d.ISO_8859_1));
        b.x(paramil.ugl, paramil.uaL, paramil.urD);
        paramil = f.kpw;
        f.a.fW(false);
        AppMethodBeat.o(87934);
        return true;
      }
      catch (IOException paramil)
      {
        ab.printErrStackTrace("MicroMsg.SubCoreCard", paramil, "", new Object[0]);
        continue;
      }
      Intent localIntent;
      if (i == 1)
      {
        if (paramil.cxQ.context != null)
        {
          localIntent = new Intent(paramil.cxQ.context, CardHomePageNewUI.class);
          paramil.cxQ.context.startActivity(localIntent);
          k.bbS();
          if (paramil.cxQ.cxS == 1) {
            h.qsU.e(16322, new Object[] { Integer.valueOf(3) });
          }
        }
      }
      else
      {
        if (paramil.cxQ.context != null)
        {
          localIntent = new Intent(paramil.cxQ.context, CardHomePageUI.class);
          localIntent.putExtra("key_from_scene", 22);
          localIntent.putExtra("key_home_page_from_scene", paramil.cxQ.scene);
          paramil.cxQ.context.startActivity(localIntent);
          k.bbS();
          if (paramil.cxQ.cxS == 1) {
            h.qsU.e(16322, new Object[] { Integer.valueOf(2) });
          }
        }
        paramil.cxR.targetActivity = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.4
 * JD-Core Version:    0.7.0.1
 */