package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIMoveTaskToBackGuardIPCHelper;", "", "()V", "TAG", "", "register", "", "activity", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "unregister", "makeKey", "plugin-appbrand-integration_release"})
public final class s
{
  public static final s qZq;
  
  static
  {
    AppMethodBeat.i(281981);
    qZq = new s();
    AppMethodBeat.o(281981);
  }
  
  private static String j(AppBrandUI paramAppBrandUI)
  {
    AppMethodBeat.i(281974);
    StringBuilder localStringBuilder = new StringBuilder();
    ComponentName localComponentName = paramAppBrandUI.getComponentName();
    p.j(localComponentName, "this.componentName");
    paramAppBrandUI = localComponentName.getShortClassName() + '@' + paramAppBrandUI.hashCode();
    AppMethodBeat.o(281974);
    return paramAppBrandUI;
  }
  
  public static final void k(AppBrandUI paramAppBrandUI)
  {
    AppMethodBeat.i(281976);
    p.k(paramAppBrandUI, "activity");
    if ((paramAppBrandUI instanceof AppBrandPluginUI))
    {
      AppMethodBeat.o(281976);
      return;
    }
    final WeakReference localWeakReference = new WeakReference(paramAppBrandUI);
    paramAppBrandUI = j(paramAppBrandUI);
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(paramAppBrandUI), (d)a.qZr, (f)new b(paramAppBrandUI, localWeakReference));
    AppMethodBeat.o(281976);
  }
  
  public static final void l(AppBrandUI paramAppBrandUI)
  {
    AppMethodBeat.i(281977);
    p.k(paramAppBrandUI, "activity");
    if ((paramAppBrandUI instanceof AppBrandPluginUI))
    {
      AppMethodBeat.o(281977);
      return;
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(j(paramAppBrandUI)), (d)c.qZs, null);
    AppMethodBeat.o(281977);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements d<IPCString, IPCVoid>
  {
    public static final a qZr;
    
    static
    {
      AppMethodBeat.i(275330);
      qZr = new a();
      AppMethodBeat.o(275330);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements f<IPCVoid>
  {
    b(String paramString, WeakReference paramWeakReference) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class c<InputType, ResultType>
    implements c<IPCString, IPCVoid>
  {
    public static final c qZs;
    
    static
    {
      AppMethodBeat.i(244189);
      qZs = new c();
      AppMethodBeat.o(244189);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.s
 * JD-Core Version:    0.7.0.1
 */