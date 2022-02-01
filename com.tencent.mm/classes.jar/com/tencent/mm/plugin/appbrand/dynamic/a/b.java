package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.Set;

final class b
  implements f
{
  e jLr;
  Runnable jLs;
  Runnable jLt;
  Runnable jLu;
  
  b(e parame)
  {
    AppMethodBeat.i(121219);
    this.jLs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121213);
        i.tF("com.tencent.mm:support");
        AppMethodBeat.o(121213);
      }
    };
    this.jLt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121215);
        if (!c.aeI().tC("com.tencent.mm:support"))
        {
          AppMethodBeat.o(121215);
          return;
        }
        h.a("com.tencent.mm:support", null, b.a.class, new d() {});
        AppMethodBeat.o(121215);
      }
    };
    this.jLu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121217);
        if (!c.aeI().tC("com.tencent.mm:support"))
        {
          AppMethodBeat.o(121217);
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("forceKillProcess", true);
        h.a("com.tencent.mm:support", localBundle, b.a.class, new d() {});
        AppMethodBeat.o(121217);
      }
    };
    this.jLr = parame;
    AppMethodBeat.o(121219);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(121220);
    com.tencent.mm.plugin.appbrand.dynamic.b.postToWorker(this.jLt);
    AppMethodBeat.o(121220);
  }
  
  public final void restart()
  {
    AppMethodBeat.i(121221);
    com.tencent.mm.plugin.appbrand.dynamic.b.postToWorker(this.jLu);
    com.tencent.mm.plugin.appbrand.dynamic.b.j(this.jLs, 2000L);
    AppMethodBeat.o(121221);
  }
  
  public final void zb(String paramString)
  {
    AppMethodBeat.i(121222);
    paramString = this.jLr.bV(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(121222);
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      View localView = (View)paramString.next();
      if ((localView != null) && ((localView instanceof IPCDynamicPageView)))
      {
        ac.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do pause view(%s)", new Object[] { Integer.valueOf(localView.hashCode()) });
        ((IPCDynamicPageView)localView).onPause();
      }
    }
    AppMethodBeat.o(121222);
  }
  
  public final void zc(String paramString)
  {
    AppMethodBeat.i(121223);
    paramString = this.jLr.bV(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(121223);
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      View localView = (View)paramString.next();
      if ((localView != null) && ((localView instanceof IPCDynamicPageView)))
      {
        ac.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do resume view(%s)", new Object[] { Integer.valueOf(localView.hashCode()) });
        ((IPCDynamicPageView)localView).onResume();
      }
    }
    AppMethodBeat.o(121223);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.b
 * JD-Core Version:    0.7.0.1
 */