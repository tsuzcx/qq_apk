package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.pz.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public final class u
  extends com.tencent.mm.sdk.b.c<pz>
{
  Dialog gpx;
  
  public u()
  {
    AppMethodBeat.i(41000);
    this.__eventId = pz.class.getName().hashCode();
    AppMethodBeat.o(41000);
  }
  
  private boolean a(final pz parampz)
  {
    AppMethodBeat.i(41001);
    ab.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", new Object[] { Integer.valueOf(parampz.cGy.type) });
    if ((parampz.cGy.aqU == null) || (parampz.cGy.aqU.get() == null))
    {
      ab.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
      parampz.cGy.callback.run();
      AppMethodBeat.o(41001);
      return false;
    }
    final Context localContext = (Context)parampz.cGy.aqU.get();
    Object localObject;
    if (parampz.cGy.type == 0)
    {
      this.gpx = com.tencent.mm.wallet_core.ui.g.a(localContext, false, null);
      localObject = new k(parampz.cGy.cGA, parampz.cGy.scene);
      com.tencent.mm.kernel.g.Rc().a(1800, new u.1(this, parampz, localContext));
      com.tencent.mm.kernel.g.Rc().a((m)localObject, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(41001);
      return false;
      if (parampz.cGy.type == 1)
      {
        this.gpx = com.tencent.mm.wallet_core.ui.g.a(localContext, false, null);
        localObject = new com.tencent.mm.plugin.collect.reward.a.c(parampz.cGy.cGA, parampz.cGy.scene);
        com.tencent.mm.kernel.g.Rc().a(2811, new f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
          {
            AppMethodBeat.i(40999);
            if ((u.this.gpx != null) && (u.this.gpx.isShowing()))
            {
              u.this.gpx.dismiss();
              u.this.gpx = null;
            }
            com.tencent.mm.kernel.g.Rc().b(2811, this);
            paramAnonymousString = (com.tencent.mm.plugin.collect.reward.a.c)paramAnonymousm;
            paramAnonymousString.a(new u.2.3(this)).b(new u.2.2(this, paramAnonymousString)).c(new u.2.1(this));
            parampz.cGy.callback.run();
            AppMethodBeat.o(40999);
          }
        });
        com.tencent.mm.kernel.g.Rc().a((m)localObject, 0);
      }
      else
      {
        ab.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", new Object[] { Integer.valueOf(parampz.cGy.type) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.u
 * JD-Core Version:    0.7.0.1
 */