package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.app.aj;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView;
import com.tencent.mm.plugin.welab.c.b;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMWebView;

public class PluginBigBallOfMudAsync
  extends f
  implements com.tencent.mm.plugin.bbom.a.a
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(22430);
    if ((paramg.akL()) && (((com.tencent.mm.kernel.b.h)paramg).mProfileCompat != null)) {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).setNotification(((WorkerProfile)((com.tencent.mm.kernel.b.h)paramg).mProfileCompat).getNotification());
    }
    com.tencent.mm.pluginsdk.ui.applet.ab.a.Fpw = new ab()
    {
      public final com.tencent.mm.ui.widget.a.d a(com.tencent.mm.ui.s paramAnonymouss, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, boolean paramAnonymousBoolean, String paramAnonymousString4, y.a paramAnonymousa)
      {
        AppMethodBeat.i(22418);
        paramAnonymouss = o.a(paramAnonymouss, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousBoolean, paramAnonymousString4, paramAnonymousa);
        AppMethodBeat.o(22418);
        return paramAnonymouss;
      }
    };
    w.a.a(new w()
    {
      public final Pair<Integer, Long> a(k.b paramAnonymousb, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22419);
        paramAnonymousb = m.a(paramAnonymousb, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4, paramAnonymousArrayOfByte);
        AppMethodBeat.o(22419);
        return paramAnonymousb;
      }
    });
    com.tencent.mm.pluginsdk.ui.span.d.a.FzC = new PluginBigBallOfMudAsync.3(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.f.a.EIC = new PluginBigBallOfMudAsync.4(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.g.a.EID = new com.tencent.mm.plugin.webview.ui.tools.widget.g()
    {
      public final MMWebView es(Context paramAnonymousContext)
      {
        AppMethodBeat.i(22423);
        MailMMWebView.hd(paramAnonymousContext);
        paramAnonymousContext = new MailMMWebView(paramAnonymousContext);
        MailMMWebView.a(paramAnonymousContext);
        AppMethodBeat.o(22423);
        return paramAnonymousContext;
      }
    };
    com.tencent.mm.plugin.webview.ui.tools.widget.c.a.EIB = new PluginBigBallOfMudAsync.6(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.a.a.EIA = new PluginBigBallOfMudAsync.7(this);
    com.tencent.mm.kernel.g.b(ad.class, new com.tencent.mm.pluginsdk.model.h());
    com.tencent.mm.kernel.g.b(v.class, new com.tencent.mm.pluginsdk.model.e());
    if ((((com.tencent.mm.kernel.b.h)paramg).mProfileCompat != null) && (paramg.akL()))
    {
      WorkerProfile localWorkerProfile = (WorkerProfile)((com.tencent.mm.kernel.b.h)paramg).mProfileCompat;
      com.tencent.mm.app.ak localak = localWorkerProfile.cWV;
      aj localaj = localWorkerProfile.cWW;
      com.tencent.mm.br.c.FEO = localak;
      com.tencent.mm.br.c.FEP = localaj;
      new com.tencent.mm.plugin.e.e(localWorkerProfile).before(this).after(com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class));
    }
    if (paramg.akL()) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setIDataTransferFactoryDelegate(new PluginBigBallOfMudAsync.8(this));
    }
    AppMethodBeat.o(22430);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(22429);
    dependsOn(PluginBigBallOfMud.class);
    if (com.tencent.mm.sdk.platformtools.ak.coh()) {
      dependsOn(com.tencent.mm.plugin.notification.b.a.class);
    }
    AppMethodBeat.o(22429);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(22431);
    if ((((com.tencent.mm.kernel.b.h)paramg).mProfileCompat != null) && (paramg.akL()))
    {
      ae.i("MicroMsg.PluginBigBallOfMudAsync", "before WorkerProfile oncreate.");
      ((com.tencent.mm.kernel.b.h)paramg).mProfileCompat.onCreate();
    }
    if (paramg.akL())
    {
      ((com.tencent.mm.plugin.welab.a.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs1de6f3", new b());
      ((com.tencent.mm.plugin.welab.a.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.d.class)).a(new com.tencent.mm.plugin.welab.e.a());
      ((com.tencent.mm.plugin.welab.a.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs_browse", new com.tencent.mm.plugin.welab.c.a());
    }
    AppMethodBeat.o(22431);
  }
  
  public void installed()
  {
    AppMethodBeat.i(22428);
    alias(com.tencent.mm.plugin.bbom.a.a.class);
    AppMethodBeat.o(22428);
  }
  
  public String toString()
  {
    return "plugin-big-ball-of-mud-async";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync
 * JD-Core Version:    0.7.0.1
 */