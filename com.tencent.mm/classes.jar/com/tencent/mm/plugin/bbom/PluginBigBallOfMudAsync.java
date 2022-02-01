package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.w;
import com.tencent.mm.ag.w.a;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.app.ak;
import com.tencent.mm.app.al;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.e.e;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView;
import com.tencent.mm.plugin.welab.c.b;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.MMWebView;

public class PluginBigBallOfMudAsync
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.bbom.a.a
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(22430);
    if ((paramg.aBb()) && (((h)paramg).mProfileCompat != null)) {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).setNotification(((WorkerProfile)((h)paramg).mProfileCompat).getNotification());
    }
    com.tencent.mm.pluginsdk.ui.applet.ab.a.Kgn = new ab()
    {
      public final com.tencent.mm.ui.widget.a.d a(t paramAnonymoust, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, boolean paramAnonymousBoolean, String paramAnonymousString4, y.a paramAnonymousa)
      {
        AppMethodBeat.i(22418);
        paramAnonymoust = o.a(paramAnonymoust, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousBoolean, paramAnonymousString4, paramAnonymousa);
        AppMethodBeat.o(22418);
        return paramAnonymoust;
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
    com.tencent.mm.pluginsdk.ui.span.e.a.KqE = new PluginBigBallOfMudAsync.3(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.f.a.Jys = new PluginBigBallOfMudAsync.4(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.g.a.Jyt = new com.tencent.mm.plugin.webview.ui.tools.widget.g()
    {
      public final MMWebView eK(Context paramAnonymousContext)
      {
        AppMethodBeat.i(22423);
        MailMMWebView.bQ(paramAnonymousContext);
        paramAnonymousContext = new MailMMWebView(paramAnonymousContext);
        MailMMWebView.a(paramAnonymousContext);
        AppMethodBeat.o(22423);
        return paramAnonymousContext;
      }
    };
    com.tencent.mm.plugin.webview.ui.tools.widget.c.a.Jyr = new PluginBigBallOfMudAsync.6(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.a.a.Jyq = new PluginBigBallOfMudAsync.7(this);
    com.tencent.mm.kernel.g.b(ad.class, new i());
    com.tencent.mm.kernel.g.b(v.class, new com.tencent.mm.pluginsdk.model.f());
    if ((((h)paramg).mProfileCompat != null) && (paramg.aBb()))
    {
      WorkerProfile localWorkerProfile = (WorkerProfile)((h)paramg).mProfileCompat;
      al localal = localWorkerProfile.dnw;
      ak localak = localWorkerProfile.dnx;
      com.tencent.mm.br.b.KxT = localal;
      com.tencent.mm.br.b.KxU = localak;
      new e(localWorkerProfile).before(this).after(com.tencent.mm.kernel.g.ah(s.class));
    }
    if (paramg.aBb()) {
      ((s)com.tencent.mm.kernel.g.ah(s.class)).setIDataTransferFactoryDelegate(new PluginBigBallOfMudAsync.8(this));
    }
    AppMethodBeat.o(22430);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(22429);
    dependsOn(PluginBigBallOfMud.class);
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.notification.b.a.class);
    }
    AppMethodBeat.o(22429);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(22431);
    if ((((h)paramg).mProfileCompat != null) && (paramg.aBb()))
    {
      Log.i("MicroMsg.PluginBigBallOfMudAsync", "before WorkerProfile oncreate.");
      ((h)paramg).mProfileCompat.onCreate();
    }
    if (paramg.aBb())
    {
      ((com.tencent.mm.plugin.welab.a.a.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs1de6f3", new b());
      ((com.tencent.mm.plugin.welab.a.a.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.d.class)).a(new com.tencent.mm.plugin.welab.e.a());
      ((com.tencent.mm.plugin.welab.a.a.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs_browse", new com.tencent.mm.plugin.welab.c.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync
 * JD-Core Version:    0.7.0.1
 */