package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Set;

final class b
  implements f
{
  e lmA;
  Runnable lmB;
  Runnable lmC;
  Runnable lmD;
  
  b(e parame)
  {
    AppMethodBeat.i(121219);
    this.lmB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121213);
        i.Fq(SupportProcessIPCService.dkO);
        AppMethodBeat.o(121213);
      }
    };
    this.lmC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121215);
        String str = SupportProcessIPCService.dkO;
        if (!c.axW().Fo(str))
        {
          AppMethodBeat.o(121215);
          return;
        }
        h.a(SupportProcessIPCService.dkO, null, b.a.class, new d() {});
        AppMethodBeat.o(121215);
      }
    };
    this.lmD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121217);
        Object localObject = SupportProcessIPCService.dkO;
        if (!c.axW().Fo((String)localObject))
        {
          AppMethodBeat.o(121217);
          return;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("forceKillProcess", true);
        h.a(SupportProcessIPCService.dkO, (Parcelable)localObject, b.a.class, new d() {});
        AppMethodBeat.o(121217);
      }
    };
    this.lmA = parame;
    AppMethodBeat.o(121219);
  }
  
  public final void Ln(String paramString)
  {
    AppMethodBeat.i(121222);
    paramString = this.lmA.ch(paramString);
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
  
  public final void Lo(String paramString)
  {
    AppMethodBeat.i(121223);
    paramString = this.lmA.ch(paramString);
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
  
  public final void exit()
  {
    AppMethodBeat.i(121220);
    com.tencent.mm.plugin.appbrand.dynamic.b.postToWorker(this.lmC);
    AppMethodBeat.o(121220);
  }
  
  public final void restart()
  {
    AppMethodBeat.i(121221);
    com.tencent.mm.plugin.appbrand.dynamic.b.postToWorker(this.lmD);
    com.tencent.mm.plugin.appbrand.dynamic.b.j(this.lmB, 2000L);
    AppMethodBeat.o(121221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.b
 * JD-Core Version:    0.7.0.1
 */