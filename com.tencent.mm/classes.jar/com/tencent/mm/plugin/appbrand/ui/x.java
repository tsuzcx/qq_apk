package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import androidx.lifecycle.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIMoveTaskToBackGuardIPCHelper;", "", "()V", "TAG", "", "register", "", "activity", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "unregister", "makeKey", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
{
  public static final x uft;
  
  static
  {
    AppMethodBeat.i(322167);
    uft = new x();
    AppMethodBeat.o(322167);
  }
  
  private static final void a(String paramString, WeakReference paramWeakReference, IPCVoid paramIPCVoid)
  {
    AppMethodBeat.i(322161);
    s.u(paramString, "$key");
    s.u(paramWeakReference, "$ref");
    Log.i("MicroMsg.AppBrandUIMoveTaskToBackGuardIPCHelper", s.X("callback invoke, key:", paramString));
    paramString = (AppBrandUI)paramWeakReference.get();
    if (paramString != null)
    {
      switch (AppBrandUI.4.bDA[paramString.getLifecycle().getCurrentState().ordinal()])
      {
      default: 
        if (paramString.mRuntimeContainer != null)
        {
          paramWeakReference = paramString.mRuntimeContainer.getActiveRuntime();
          if ((paramWeakReference != null) && (!paramWeakReference.qsE.get()) && (!paramWeakReference.ccV)) {
            break;
          }
        }
        else
        {
          paramString.finish();
          AppMethodBeat.o(322161);
          return;
        }
        break;
      case 1: 
      case 2: 
        Log.w("MicroMsg.AppBrandUI", "forceMoveTaskToBack, hash:%d, name:%s, state:%s, skip.", new Object[] { Integer.valueOf(paramString.hashCode()), paramString.getLocalClassName(), paramString.getLifecycle().getCurrentState() });
        AppMethodBeat.o(322161);
        return;
      }
      if (paramString.moveTaskToBack(false)) {
        paramWeakReference.qsB.qKC.a(d.a.qLm);
      }
    }
    AppMethodBeat.o(322161);
  }
  
  private static final void j(IPCString paramIPCString, f paramf)
  {
    AppMethodBeat.i(322154);
    y localy = y.ufu;
    paramIPCString = paramIPCString.value;
    s.s(paramIPCString, "data.value");
    y.o(paramIPCString, (kotlin.g.a.a)new x.a(paramf));
    AppMethodBeat.o(322154);
  }
  
  private static String k(AppBrandUI paramAppBrandUI)
  {
    AppMethodBeat.i(322137);
    paramAppBrandUI = paramAppBrandUI.getComponentName().getShortClassName() + '@' + paramAppBrandUI.hashCode();
    AppMethodBeat.o(322137);
    return paramAppBrandUI;
  }
  
  private static final void k(IPCString paramIPCString, f paramf)
  {
    AppMethodBeat.i(322165);
    y localy = y.ufu;
    paramIPCString = paramIPCString.value;
    s.s(paramIPCString, "data.value");
    y.agh(paramIPCString);
    s.s(paramf, "callback");
    com.tencent.mm.ipcinvoker.wx_extension.b.a.b(paramf);
    AppMethodBeat.o(322165);
  }
  
  public static final void l(AppBrandUI paramAppBrandUI)
  {
    AppMethodBeat.i(322143);
    s.u(paramAppBrandUI, "activity");
    if ((paramAppBrandUI instanceof AppBrandPluginUI))
    {
      AppMethodBeat.o(322143);
      return;
    }
    WeakReference localWeakReference = new WeakReference(paramAppBrandUI);
    paramAppBrandUI = k(paramAppBrandUI);
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(paramAppBrandUI), x..ExternalSyntheticLambda1.INSTANCE, new x..ExternalSyntheticLambda2(paramAppBrandUI, localWeakReference));
    AppMethodBeat.o(322143);
  }
  
  public static final void m(AppBrandUI paramAppBrandUI)
  {
    AppMethodBeat.i(322146);
    s.u(paramAppBrandUI, "activity");
    if ((paramAppBrandUI instanceof AppBrandPluginUI))
    {
      AppMethodBeat.o(322146);
      return;
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(k(paramAppBrandUI)), (com.tencent.mm.ipcinvoker.d)x..ExternalSyntheticLambda0.INSTANCE, null);
    AppMethodBeat.o(322146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.x
 * JD-Core Version:    0.7.0.1
 */