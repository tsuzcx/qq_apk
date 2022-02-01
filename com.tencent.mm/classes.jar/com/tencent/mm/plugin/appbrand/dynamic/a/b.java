package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Set;

final class b
  implements com.tencent.mm.modelappbrand.f
{
  com.tencent.mm.modelappbrand.e ohm;
  Runnable ohn;
  Runnable oho;
  Runnable ohp;
  
  b(com.tencent.mm.modelappbrand.e parame)
  {
    AppMethodBeat.i(121219);
    this.ohn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121213);
        k.Mq(SupportProcessIPCService.PROCESS_NAME);
        AppMethodBeat.o(121213);
      }
    };
    this.oho = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121215);
        String str = SupportProcessIPCService.PROCESS_NAME;
        if (!com.tencent.mm.ipcinvoker.e.aFo().Ml(str))
        {
          AppMethodBeat.o(121215);
          return;
        }
        j.a(SupportProcessIPCService.PROCESS_NAME, null, b.a.class, new com.tencent.mm.ipcinvoker.f() {});
        AppMethodBeat.o(121215);
      }
    };
    this.ohp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121217);
        Object localObject = SupportProcessIPCService.PROCESS_NAME;
        if (!com.tencent.mm.ipcinvoker.e.aFo().Ml((String)localObject))
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
    this.ohm = parame;
    AppMethodBeat.o(121219);
  }
  
  public final void SG(String paramString)
  {
    AppMethodBeat.i(121222);
    paramString = this.ohm.ch(paramString);
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
  
  public final void SH(String paramString)
  {
    AppMethodBeat.i(121223);
    paramString = this.ohm.ch(paramString);
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
  
  public final void bgP()
  {
    AppMethodBeat.i(121221);
    com.tencent.mm.plugin.appbrand.dynamic.b.postToWorker(this.ohp);
    com.tencent.mm.plugin.appbrand.dynamic.b.i(this.ohn, 2000L);
    AppMethodBeat.o(121221);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(121220);
    com.tencent.mm.plugin.appbrand.dynamic.b.postToWorker(this.oho);
    AppMethodBeat.o(121220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.b
 * JD-Core Version:    0.7.0.1
 */