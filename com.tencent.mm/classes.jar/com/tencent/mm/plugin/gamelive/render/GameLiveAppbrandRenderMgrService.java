package com.tencent.mm.plugin.gamelive.render;

import android.os.Parcelable;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.gamelive.PluginGameLive.IPCLiveControlData;
import com.tencent.mm.plugin.gamelive.PluginGameLive.IPCLiveControlData.b;
import com.tencent.mm.plugin.gamelive.PluginGameLive.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/render/GameLiveAppbrandRenderMgrService;", "Lcom/tencent/mm/plugin/gamelive/render/IGameLiveAppbrandRenderMgrService;", "()V", "getInputSurface", "", "callback", "Lcom/tencent/mm/plugin/gamelive/render/IGameLiveMainRenderMgrService$IGameLiveInputSurfaceCallback;", "setOnScreenSurface", "surface", "Landroid/view/Surface;", "setSize", "width", "", "height", "start", "stop", "Payload", "plugin-gamelive_release"})
public final class GameLiveAppbrandRenderMgrService
  implements f
{
  public final void a(g.a parama)
  {
    AppMethodBeat.i(208602);
    p.k(parama, "callback");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.DkC, null, null, 12), PluginGameLive.c.class, (com.tencent.mm.ipcinvoker.f)new a(parama));
    AppMethodBeat.o(208602);
  }
  
  public final void l(Surface paramSurface)
  {
    AppMethodBeat.i(208601);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.DkB, null, (Parcelable)paramSurface, 6), PluginGameLive.c.class, null);
    AppMethodBeat.o(208601);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208603);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.DkD, null, (Parcelable)new GameLiveAppbrandRenderMgrService.Payload(paramInt1, paramInt2), 6), PluginGameLive.c.class, null);
    AppMethodBeat.o(208603);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    a(g.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.render.GameLiveAppbrandRenderMgrService
 * JD-Core Version:    0.7.0.1
 */