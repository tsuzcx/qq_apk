package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.app.aq;
import com.tencent.mm.app.ar;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.w.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.av;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.applet.ac;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;

public class PluginBigBallOfMudAsync
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.bbom.a.a
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(22430);
    if ((paramg.bbA()) && (((com.tencent.mm.kernel.b.h)paramg).mFS != null)) {
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).setNotification(((WorkerProfile)((com.tencent.mm.kernel.b.h)paramg).mFS).getNotification());
    }
    com.tencent.mm.pluginsdk.ui.applet.ac.a.Yde = new ac()
    {
      public final com.tencent.mm.ui.widget.a.e a(y paramAnonymousy, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, boolean paramAnonymousBoolean, String paramAnonymousString4, y.a paramAnonymousa)
      {
        AppMethodBeat.i(22418);
        paramAnonymousy = o.a(paramAnonymousy, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousBoolean, paramAnonymousString4, paramAnonymousa);
        AppMethodBeat.o(22418);
        return paramAnonymousy;
      }
    };
    w.a.a(new com.tencent.mm.message.w()
    {
      public final Pair<Integer, Long> a(k.b paramAnonymousb, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22419);
        paramAnonymousb = n.a(paramAnonymousb, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4, paramAnonymousArrayOfByte);
        AppMethodBeat.o(22419);
        return paramAnonymousb;
      }
    });
    com.tencent.mm.pluginsdk.ui.span.e.a.YnZ = new PluginBigBallOfMudAsync.3(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.i.a.Xpw = new PluginBigBallOfMudAsync.4(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.j.a.Xpx = new com.tencent.mm.plugin.webview.ui.tools.widget.j()
    {
      public final MMWebView fJ(Context paramAnonymousContext)
      {
        AppMethodBeat.i(22423);
        MailMMWebView.cD(paramAnonymousContext);
        paramAnonymousContext = new MailMMWebView(paramAnonymousContext);
        MailMMWebView.a(paramAnonymousContext);
        AppMethodBeat.o(22423);
        return paramAnonymousContext;
      }
    };
    com.tencent.mm.plugin.webview.ui.tools.widget.f.a.Xpv = new PluginBigBallOfMudAsync.6(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.d.a.Xpu = new PluginBigBallOfMudAsync.7(this);
    com.tencent.mm.kernel.h.b(af.class, new m());
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.fav.a.w.class, new com.tencent.mm.pluginsdk.model.j());
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.notification.b.a.class, new com.tencent.mm.booter.notification.d());
    if ((((com.tencent.mm.kernel.b.h)paramg).mFS != null) && (paramg.bbA()))
    {
      WorkerProfile localWorkerProfile = (WorkerProfile)((com.tencent.mm.kernel.b.h)paramg).mFS;
      ar localar = localWorkerProfile.hjU;
      aq localaq = localWorkerProfile.hjV;
      com.tencent.mm.br.b.Ywg = localar;
      com.tencent.mm.br.b.Ywh = localaq;
      new com.tencent.mm.plugin.h.e(localWorkerProfile).before(this).after(com.tencent.mm.kernel.h.az(v.class));
    }
    if (paramg.bbA()) {
      ((v)com.tencent.mm.kernel.h.az(v.class)).setIDataTransferFactoryDelegate(new av()
      {
        public final List<au> getDataTransferList()
        {
          AppMethodBeat.i(22427);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(new com.tencent.mm.ap.d());
          localArrayList.add(new com.tencent.mm.ap.f());
          localArrayList.add(new com.tencent.mm.ap.e());
          localArrayList.add(new com.tencent.mm.ap.a());
          localArrayList.add(new com.tencent.mm.ap.c());
          localArrayList.add(new com.tencent.mm.ap.g());
          localArrayList.add(new com.tencent.mm.ap.b());
          AppMethodBeat.o(22427);
          return localArrayList;
        }
      });
    }
    AppMethodBeat.o(22430);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(22429);
    dependsOn(PluginBigBallOfMud.class);
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.notification.b.b.class);
    }
    AppMethodBeat.o(22429);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(22431);
    if ((((com.tencent.mm.kernel.b.h)paramg).mFS != null) && (paramg.bbA()))
    {
      Log.i("MicroMsg.PluginBigBallOfMudAsync", "before WorkerProfile oncreate.");
      ((com.tencent.mm.kernel.b.h)paramg).mFS.onCreate();
    }
    if (paramg.bbA())
    {
      ((com.tencent.mm.plugin.welab.a.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs1de6f3", new com.tencent.mm.plugin.welab.c.b());
      ((com.tencent.mm.plugin.welab.a.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.d.class)).a(new com.tencent.mm.plugin.welab.e.a());
      ((com.tencent.mm.plugin.welab.a.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs_browse", new com.tencent.mm.plugin.welab.c.a());
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