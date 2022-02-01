package com.tencent.mm.plugin.hld;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.ny;
import com.tencent.mm.autogen.a.ro;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.WxImeInterService;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.af;
import com.tencent.threadpool.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/PluginHld;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/plugin/IPlugin;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "()V", "appForegroundListener", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "isLogin", "", "logoutListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LogoutEvent;", "otherLogoutListener", "Lcom/tencent/mm/autogen/events/OtherLogoutEvent;", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "handleLogout", "name", "", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginHld
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.b.d
{
  public static final String CLASS = "com.tencent.mm.plugin.hld.PluginHld";
  public static final PluginHld.a Companion;
  public static final String STORAGE_WX_IME = "wxime";
  public static final String TAG = "WxIme.PluginHld";
  private q.a appForegroundListener;
  private boolean isLogin;
  private final IListener<ny> logoutListener;
  private final IListener<ro> otherLogoutListener;
  
  static
  {
    AppMethodBeat.i(311432);
    Companion = new PluginHld.a((byte)0);
    AppMethodBeat.o(311432);
  }
  
  public PluginHld()
  {
    AppMethodBeat.i(311416);
    this.logoutListener = ((IListener)new IListener(com.tencent.mm.app.f.hfK) {});
    this.otherLogoutListener = ((IListener)new IListener(com.tencent.mm.app.f.hfK) {});
    this.appForegroundListener = ((q.a)new b());
    AppMethodBeat.o(311416);
  }
  
  private final void handleLogout()
  {
    AppMethodBeat.i(311423);
    if (this.isLogin)
    {
      Intent localIntent = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
      localIntent.putExtra("ime_logout", true);
      com.tencent.mm.br.c.n(localIntent, "hld");
    }
    this.isLogin = false;
    AppMethodBeat.o(311423);
  }
  
  private static final void onAccountInitialized$lambda-1()
  {
    AppMethodBeat.i(311429);
    Object localObject = l.JyV;
    if (l.fOJ())
    {
      localObject = l.JyV;
      localObject = MMApplicationContext.getContext();
      kotlin.g.b.s.s(localObject, "getContext()");
      if (!l.ic((Context)localObject))
      {
        localObject = l.JyV;
        if (l.fKJ())
        {
          Log.e("WxIme.PluginHld", "filter enable ime");
          AppMethodBeat.o(311429);
          return;
        }
        localObject = l.JyV;
        localObject = MMApplicationContext.getContext();
        kotlin.g.b.s.s(localObject, "getContext()");
        l.ia((Context)localObject);
        if (!((com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class)).fKF()) {
          ((com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class)).fKE();
        }
        localObject = l.JyV;
        Log.i("WxIme.PluginHld", kotlin.g.b.s.X("inInputMethod:", Boolean.valueOf(l.fKK())));
        AppMethodBeat.o(311429);
        return;
      }
      localObject = l.JyV;
      localObject = MMApplicationContext.getContext();
      kotlin.g.b.s.s(localObject, "getContext()");
      boolean bool = l.id((Context)localObject);
      if (bool)
      {
        localObject = l.JyV;
        l.fON();
      }
      Log.i("WxIme.PluginHld", kotlin.g.b.s.X("isInImeList:", Boolean.valueOf(bool)));
    }
    AppMethodBeat.o(311429);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(311445);
    Log.d("WxIme.PluginHld", "configure");
    if ((paramg != null) && (paramg.bbA())) {
      af.aR("wxime", "wxime", 1);
    }
    AppMethodBeat.o(311445);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(311440);
    Log.d("WxIme.PluginHld", "execute");
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.hld.a.d.class, (com.tencent.mm.kernel.c.c)new e((a)new p()));
    if ((paramg != null) && (paramg.bbA()))
    {
      paramg = l.JyV;
      if (l.fOJ())
      {
        paramg = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
        if (paramg != null) {
          paramg.fKE();
        }
        paramg = k.JvH;
        k.fMy();
      }
    }
    AppMethodBeat.o(311440);
  }
  
  public final String name()
  {
    return "plugin-hld";
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(311452);
    Log.d("WxIme.PluginHld", "onAccountInitialized");
    this.isLogin = true;
    this.appForegroundListener.alive();
    com.tencent.threadpool.h.ahAA.bm(PluginHld..ExternalSyntheticLambda0.INSTANCE);
    this.logoutListener.alive();
    this.otherLogoutListener.alive();
    paramc = l.JyV;
    paramc = MMApplicationContext.getContext();
    kotlin.g.b.s.s(paramc, "getContext()");
    if (l.iD(paramc))
    {
      paramc = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
      paramc.putExtra("ime_login", true);
      com.tencent.mm.br.c.n(paramc, "hld");
    }
    paramc = (n)com.tencent.mm.kernel.h.ax(n.class);
    if (paramc != null)
    {
      paramc = paramc.gaT();
      if (paramc != null) {
        paramc.a((h.a)com.tencent.mm.plugin.hld.b.d.JoH);
      }
    }
    AppMethodBeat.o(311452);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(311456);
    Log.d("WxIme.PluginHld", "onAccountRelease");
    this.logoutListener.dead();
    this.otherLogoutListener.dead();
    this.appForegroundListener.dead();
    this.isLogin = false;
    Object localObject = (n)com.tencent.mm.kernel.h.ax(n.class);
    if (localObject != null)
    {
      localObject = ((n)localObject).gaT();
      if (localObject != null) {
        ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject).b((h.a)com.tencent.mm.plugin.hld.b.d.JoH);
      }
    }
    AppMethodBeat.o(311456);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/PluginHld$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "handleLogic", "", "onAppBackground", "activity", "", "onAppForeground", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends q.a
  {
    private static void fKo()
    {
      AppMethodBeat.i(311726);
      Object localObject;
      boolean bool2;
      if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ) && (!b.aZG()) && (com.tencent.mm.kernel.h.baD().mCm.oun != null))
      {
        localObject = l.JyV;
        boolean bool1 = l.fPb();
        localObject = l.JyV;
        localObject = MMApplicationContext.getContext();
        kotlin.g.b.s.s(localObject, "getContext()");
        bool2 = l.iz((Context)localObject);
        if (bool1 != bool2)
        {
          localObject = k.JvH;
          if (!bool2) {
            break label99;
          }
        }
      }
      label99:
      for (int i = 3;; i = 4)
      {
        k.jq(i, 1);
        localObject = l.JyV;
        l.xr(bool2);
        AppMethodBeat.o(311726);
        return;
      }
    }
    
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(311759);
      kotlin.g.b.s.u(paramString, "activity");
      fKo();
      AppMethodBeat.o(311759);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(311745);
      kotlin.g.b.s.u(paramString, "activity");
      Log.i("WxIme.PluginHld", kotlin.g.b.s.X("onAppForeground ", paramString));
      fKo();
      AppMethodBeat.o(311745);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.PluginHld
 * JD-Core Version:    0.7.0.1
 */