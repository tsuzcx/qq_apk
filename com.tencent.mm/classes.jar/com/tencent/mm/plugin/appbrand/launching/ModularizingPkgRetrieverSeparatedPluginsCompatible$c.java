package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallArgs;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
final class ModularizingPkgRetrieverSeparatedPluginsCompatible$c
  implements d<ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallArgs, ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult>
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "resultPkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "invoke"})
  static final class a
    extends q
    implements b<List<? extends IPkgInfo>, x>
  {
    a(f paramf, ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallArgs paramIPCCallArgs)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "wholeProgressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"})
  static final class b
    extends q
    implements b<WxaPkgLoadProgress, x>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "err", "", "errMsg", "", "invoke"})
  static final class c
    extends q
    implements m<Integer, String, x>
  {
    c(f paramf, ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallArgs paramIPCCallArgs)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible.c
 * JD-Core Version:    0.7.0.1
 */