package com.tencent.mm.app;

import android.app.Application;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.kernel.b.h.6;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.splash.m.a;
import com.tencent.mm.splash.o.a;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vfs.k;
import java.io.File;

public class WeChatSplashStartup
  implements m.a
{
  private Application app;
  com.tencent.mm.kernel.b.h profile;
  private String thisProcess;
  
  private void b(final o.a parama)
  {
    AppMethodBeat.i(160091);
    com.tencent.mm.f.a.by(this.app);
    com.tencent.mm.blink.a.kL(2);
    final boolean bool;
    Object localObject;
    if (parama == null)
    {
      bool = true;
      this.profile.onCreate();
      if ((!this.profile.xO(":tools")) && (!this.profile.xO(":toolsmp"))) {
        break label216;
      }
      localObject = new ah();
    }
    for (;;)
    {
      this.profile.gDL.a((com.tencent.mm.kernel.a.b)localObject);
      if (!bool)
      {
        com.tencent.mm.splash.h.fri();
        new com.tencent.mm.sdk.b.c() {}.alive();
        new com.tencent.mm.sdk.b.c() {}.alive();
      }
      com.tencent.mm.kernel.g.ajS().a(cg(bool));
      com.tencent.mm.splash.h.a(new WeChatSplashStartup.4(this));
      com.tencent.mm.splash.h.a(y.cVK);
      com.tencent.mm.kernel.g.ajS().a(new com.tencent.mm.kernel.api.g()
      {
        public final void ML()
        {
          AppMethodBeat.i(160049);
          com.tencent.mm.kernel.g.ajS().b(this);
          if (!bool)
          {
            parama.done();
            AppMethodBeat.o(160049);
            return;
          }
          com.tencent.mm.splash.h.b("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
          Object localObject = com.tencent.mm.splash.a.fra();
          if (!new k((String)localObject).exists())
          {
            com.tencent.mm.splash.h.b("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
            AppMethodBeat.o(160049);
            return;
          }
          localObject = new k((String)localObject + "/main-process-blocking");
          if (((k)localObject).exists()) {
            com.tencent.mm.splash.h.b("MicroMsg.FigLeaf", "deleteRequest result %s.", new Object[] { Boolean.valueOf(((k)localObject).delete()) });
          }
          AppMethodBeat.o(160049);
        }
        
        public final void ch(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.ajS().a(new WeChatSplashStartup.6(this));
      com.tencent.mm.kernel.g.ajS().a(new WeChatSplashStartup.7(this));
      com.tencent.mm.kernel.g.ajS().a(new com.tencent.mm.kernel.api.g()
      {
        public final void ML()
        {
          AppMethodBeat.i(160117);
          b.c(WeChatSplashStartup.b(WeChatSplashStartup.this));
          AppMethodBeat.o(160117);
        }
        
        public final void ch(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.ajS().a(new WeChatSplashStartup.9(this));
      AppMethodBeat.o(160091);
      return;
      bool = false;
      break;
      label216:
      if ((this.profile.xP(":appbrand")) && (fB(com.tencent.mm.plugin.appbrand.api.a.jFJ))) {
        localObject = new c();
      } else {
        localObject = new i();
      }
    }
  }
  
  private d cg(boolean paramBoolean)
  {
    AppMethodBeat.i(160092);
    if (!paramBoolean)
    {
      Object localObject = q.Mg();
      ((q)localObject).Mh();
      com.tencent.mm.kernel.g.ajS().a(new com.tencent.mm.kernel.api.g()
      {
        public final void ML()
        {
          AppMethodBeat.i(224053);
          this.cWE.cUO.quit();
          com.tencent.mm.kernel.g.ajS().b(this);
          AppMethodBeat.o(224053);
        }
        
        public final void ch(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.a.c.ake().f(((q)localObject).cUO.getLooper());
      localObject = ((q)localObject).cUP;
      AppMethodBeat.o(160092);
      return localObject;
    }
    AppMethodBeat.o(160092);
    return null;
  }
  
  private static boolean fB(String paramString)
  {
    AppMethodBeat.i(177509);
    if (paramString == null)
    {
      AppMethodBeat.o(177509);
      return false;
    }
    if (new File(paramString).exists())
    {
      AppMethodBeat.o(177509);
      return true;
    }
    AppMethodBeat.o(177509);
    return false;
  }
  
  public final void MJ()
  {
    AppMethodBeat.i(160090);
    b(null);
    AppMethodBeat.o(160090);
  }
  
  public final void a(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(160088);
    this.app = paramApplication;
    this.thisProcess = paramString;
    this.profile = ai.cWl;
    com.tencent.mm.kernel.g.a(this.profile);
    paramApplication = this.profile;
    paramString = this.app;
    paramApplication.gGM.a(new h.6(paramApplication, paramString));
    AppMethodBeat.o(160088);
  }
  
  public final void a(o.a parama)
  {
    AppMethodBeat.i(160089);
    b(parama);
    AppMethodBeat.o(160089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup
 * JD-Core Version:    0.7.0.1
 */