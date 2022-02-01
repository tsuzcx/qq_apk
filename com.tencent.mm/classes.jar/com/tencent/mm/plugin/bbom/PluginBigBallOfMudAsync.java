package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.w.a;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.app.am;
import com.tencent.mm.app.an;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView;
import com.tencent.mm.plugin.webview.ui.tools.widget.j;
import com.tencent.mm.plugin.webview.ui.tools.widget.l;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.pluginsdk.ui.span.n.3;
import com.tencent.mm.pluginsdk.ui.span.n.4;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.xweb.ad;
import com.tencent.xweb.x;
import java.util.List;

public class PluginBigBallOfMudAsync
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.bbom.a.a
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(22430);
    if ((paramg.aIE()) && (((com.tencent.mm.kernel.b.h)paramg).mProfileCompat != null)) {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).setNotification(((WorkerProfile)((com.tencent.mm.kernel.b.h)paramg).mProfileCompat).getNotification());
    }
    com.tencent.mm.pluginsdk.ui.applet.ab.a.RgY = new ab()
    {
      public final com.tencent.mm.ui.widget.a.d a(com.tencent.mm.ui.w paramAnonymousw, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, boolean paramAnonymousBoolean, String paramAnonymousString4, y.a paramAnonymousa)
      {
        AppMethodBeat.i(22418);
        paramAnonymousw = o.a(paramAnonymousw, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousBoolean, paramAnonymousString4, paramAnonymousa);
        AppMethodBeat.o(22418);
        return paramAnonymousw;
      }
    };
    w.a.a(new com.tencent.mm.aj.w()
    {
      public final Pair<Integer, Long> a(k.b paramAnonymousb, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22419);
        paramAnonymousb = com.tencent.mm.pluginsdk.model.app.m.a(paramAnonymousb, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4, paramAnonymousArrayOfByte);
        AppMethodBeat.o(22419);
        return paramAnonymousb;
      }
    });
    com.tencent.mm.pluginsdk.ui.span.e.a.RrL = new com.tencent.mm.pluginsdk.ui.span.e()
    {
      public final void a(Context paramAnonymousContext, String paramAnonymousString, DialogInterface.OnDismissListener paramAnonymousOnDismissListener, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(22421);
        n.a(paramAnonymousContext, paramAnonymousString, paramAnonymousOnDismissListener, paramAnonymousBundle);
        AppMethodBeat.o(22421);
      }
      
      public final void a(Context paramAnonymousContext, List<String> paramAnonymousList, e.b paramAnonymousb)
      {
        AppMethodBeat.i(22420);
        if ((paramAnonymousList.isEmpty()) || (paramAnonymousContext == null))
        {
          AppMethodBeat.o(22420);
          return;
        }
        new com.tencent.mm.ui.tools.m(paramAnonymousContext).a(null, new n.3(paramAnonymousList), new n.4(paramAnonymousContext), paramAnonymousb);
        AppMethodBeat.o(22420);
      }
    };
    com.tencent.mm.plugin.webview.ui.tools.widget.f.a.QwC = new com.tencent.mm.plugin.webview.ui.tools.widget.f()
    {
      public final MMWebView eN(Context paramAnonymousContext)
      {
        AppMethodBeat.i(22422);
        paramAnonymousContext = MMWebViewWithJsApi.a.jd(paramAnonymousContext);
        AppMethodBeat.o(22422);
        return paramAnonymousContext;
      }
    };
    com.tencent.mm.plugin.webview.ui.tools.widget.g.a.QwD = new com.tencent.mm.plugin.webview.ui.tools.widget.g()
    {
      public final MMWebView eN(Context paramAnonymousContext)
      {
        AppMethodBeat.i(22423);
        MailMMWebView.bQ(paramAnonymousContext);
        paramAnonymousContext = new MailMMWebView(paramAnonymousContext);
        MailMMWebView.a(paramAnonymousContext);
        AppMethodBeat.o(22423);
        return paramAnonymousContext;
      }
    };
    com.tencent.mm.plugin.webview.ui.tools.widget.c.a.QwB = new com.tencent.mm.plugin.webview.ui.tools.widget.c()
    {
      public final ad a(MMWebView paramAnonymousMMWebView, com.tencent.mm.plugin.webview.ui.tools.widget.d paramAnonymousd, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(22425);
        paramAnonymousMMWebView = new l(paramAnonymousMMWebView, false, paramAnonymousd, paramAnonymousBundle);
        AppMethodBeat.o(22425);
        return paramAnonymousMMWebView;
      }
      
      public final ad a(MMWebView paramAnonymousMMWebView, boolean paramAnonymousBoolean, com.tencent.mm.plugin.webview.ui.tools.widget.d paramAnonymousd)
      {
        AppMethodBeat.i(22424);
        paramAnonymousMMWebView = new l(paramAnonymousMMWebView, paramAnonymousBoolean, paramAnonymousd);
        AppMethodBeat.o(22424);
        return paramAnonymousMMWebView;
      }
    };
    com.tencent.mm.plugin.webview.ui.tools.widget.a.a.QwA = new com.tencent.mm.plugin.webview.ui.tools.widget.a()
    {
      public final x a(MMWebView paramAnonymousMMWebView, com.tencent.mm.plugin.webview.ui.tools.widget.b paramAnonymousb)
      {
        AppMethodBeat.i(22426);
        paramAnonymousMMWebView = new j(paramAnonymousMMWebView, paramAnonymousb);
        AppMethodBeat.o(22426);
        return paramAnonymousMMWebView;
      }
    };
    com.tencent.mm.kernel.h.b(ae.class, new k());
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.fav.a.w.class, new com.tencent.mm.pluginsdk.model.h());
    if ((((com.tencent.mm.kernel.b.h)paramg).mProfileCompat != null) && (paramg.aIE()))
    {
      WorkerProfile localWorkerProfile = (WorkerProfile)((com.tencent.mm.kernel.b.h)paramg).mProfileCompat;
      an localan = localWorkerProfile.ffK;
      am localam = localWorkerProfile.ffL;
      com.tencent.mm.by.b.RzH = localan;
      com.tencent.mm.by.b.RzI = localam;
      new com.tencent.mm.plugin.g.e(localWorkerProfile).before(this).after(com.tencent.mm.kernel.h.ag(v.class));
    }
    if (paramg.aIE()) {
      ((v)com.tencent.mm.kernel.h.ag(v.class)).setIDataTransferFactoryDelegate(new PluginBigBallOfMudAsync.8(this));
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
    if ((((com.tencent.mm.kernel.b.h)paramg).mProfileCompat != null) && (paramg.aIE()))
    {
      Log.i("MicroMsg.PluginBigBallOfMudAsync", "before WorkerProfile oncreate.");
      ((com.tencent.mm.kernel.b.h)paramg).mProfileCompat.onCreate();
    }
    if (paramg.aIE())
    {
      ((com.tencent.mm.plugin.welab.a.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs1de6f3", new com.tencent.mm.plugin.welab.c.b());
      ((com.tencent.mm.plugin.welab.a.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.d.class)).a(new com.tencent.mm.plugin.welab.e.a());
      ((com.tencent.mm.plugin.welab.a.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs_browse", new com.tencent.mm.plugin.welab.c.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync
 * JD-Core Version:    0.7.0.1
 */