package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIMoveTaskToBackGuardIPCHelper;", "", "()V", "TAG", "", "register", "", "activity", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "unregister", "makeKey", "plugin-appbrand-integration_release"})
public final class t
{
  public static final t nXI;
  
  static
  {
    AppMethodBeat.i(229521);
    nXI = new t();
    AppMethodBeat.o(229521);
  }
  
  private static String j(AppBrandUI paramAppBrandUI)
  {
    AppMethodBeat.i(229518);
    StringBuilder localStringBuilder = new StringBuilder();
    ComponentName localComponentName = paramAppBrandUI.getComponentName();
    p.g(localComponentName, "this.componentName");
    paramAppBrandUI = localComponentName.getShortClassName() + '@' + paramAppBrandUI.hashCode();
    AppMethodBeat.o(229518);
    return paramAppBrandUI;
  }
  
  public static final void k(AppBrandUI paramAppBrandUI)
  {
    AppMethodBeat.i(229519);
    p.h(paramAppBrandUI, "activity");
    if ((paramAppBrandUI instanceof AppBrandPluginUI))
    {
      AppMethodBeat.o(229519);
      return;
    }
    final WeakReference localWeakReference = new WeakReference(paramAppBrandUI);
    paramAppBrandUI = j(paramAppBrandUI);
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(paramAppBrandUI), (b)a.nXJ, (d)new b(paramAppBrandUI, localWeakReference));
    AppMethodBeat.o(229519);
  }
  
  public static final void l(AppBrandUI paramAppBrandUI)
  {
    AppMethodBeat.i(229520);
    p.h(paramAppBrandUI, "activity");
    if ((paramAppBrandUI instanceof AppBrandPluginUI))
    {
      AppMethodBeat.o(229520);
      return;
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(j(paramAppBrandUI)), (b)c.nXK, null);
    AppMethodBeat.o(229520);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<IPCString, IPCVoid>
  {
    public static final a nXJ;
    
    static
    {
      AppMethodBeat.i(229514);
      nXJ = new a();
      AppMethodBeat.o(229514);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements d<IPCVoid>
  {
    b(String paramString, WeakReference paramWeakReference) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class c<InputType, ResultType>
    implements b<IPCString, IPCVoid>
  {
    public static final c nXK;
    
    static
    {
      AppMethodBeat.i(229517);
      nXK = new c();
      AppMethodBeat.o(229517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.t
 * JD-Core Version:    0.7.0.1
 */