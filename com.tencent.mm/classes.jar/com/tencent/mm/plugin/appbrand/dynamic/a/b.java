package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Set;

final class b
  implements g
{
  com.tencent.mm.modelappbrand.f rkQ;
  Runnable rkR;
  Runnable rkS;
  Runnable rkT;
  
  b(com.tencent.mm.modelappbrand.f paramf)
  {
    AppMethodBeat.i(121219);
    this.rkR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121213);
        k.EY(SupportProcessIPCService.PROCESS_NAME);
        AppMethodBeat.o(121213);
      }
    };
    this.rkS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121215);
        String str = SupportProcessIPCService.PROCESS_NAME;
        if (!e.aYp().ET(str))
        {
          AppMethodBeat.o(121215);
          return;
        }
        j.a(SupportProcessIPCService.PROCESS_NAME, null, b.a.class, new com.tencent.mm.ipcinvoker.f() {});
        AppMethodBeat.o(121215);
      }
    };
    this.rkT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121217);
        Object localObject = SupportProcessIPCService.PROCESS_NAME;
        if (!e.aYp().ET((String)localObject))
        {
          AppMethodBeat.o(121217);
          return;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("forceKillProcess", true);
        j.a(SupportProcessIPCService.PROCESS_NAME, (Parcelable)localObject, b.a.class, new com.tencent.mm.ipcinvoker.f() {});
        AppMethodBeat.o(121217);
      }
    };
    this.rkQ = paramf;
    AppMethodBeat.o(121219);
  }
  
  public final void KI(String paramString)
  {
    AppMethodBeat.i(121222);
    paramString = this.rkQ.dz(paramString);
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
        Log.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do pause view(%s)", new Object[] { Integer.valueOf(localView.hashCode()) });
        ((IPCDynamicPageView)localView).onPause();
      }
    }
    AppMethodBeat.o(121222);
  }
  
  public final void KJ(String paramString)
  {
    AppMethodBeat.i(121223);
    paramString = this.rkQ.dz(paramString);
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
        Log.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do resume view(%s)", new Object[] { Integer.valueOf(localView.hashCode()) });
        ((IPCDynamicPageView)localView).onResume();
      }
    }
    AppMethodBeat.o(121223);
  }
  
  public final void bEH()
  {
    AppMethodBeat.i(121221);
    com.tencent.mm.plugin.appbrand.dynamic.b.postToWorker(this.rkT);
    com.tencent.mm.plugin.appbrand.dynamic.b.j(this.rkR, 2000L);
    AppMethodBeat.o(121221);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(121220);
    com.tencent.mm.plugin.appbrand.dynamic.b.postToWorker(this.rkS);
    AppMethodBeat.o(121220);
  }
  
  static class a
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.b
 * JD-Core Version:    0.7.0.1
 */