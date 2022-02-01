package com.tencent.mm.plugin.gamelive.render;

import android.os.Parcelable;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.gamelive.PluginGameLive.IPCLiveControlData;
import com.tencent.mm.plugin.gamelive.PluginGameLive.IPCLiveControlData.b;
import com.tencent.mm.plugin.gamelive.PluginGameLive.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/render/GameLiveAppbrandRenderMgrService;", "Lcom/tencent/mm/plugin/gamelive/render/IGameLiveAppbrandRenderMgrService;", "()V", "getInputSurface", "", "callback", "Lcom/tencent/mm/plugin/gamelive/render/IGameLiveMainRenderMgrService$IGameLiveInputSurfaceCallback;", "setOnScreenSurface", "surface", "Landroid/view/Surface;", "setSize", "width", "", "height", "start", "stop", "Payload", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandRenderMgrService
  implements e
{
  private static final void a(f.a parama, PluginGameLive.IPCLiveControlData paramIPCLiveControlData)
  {
    AppMethodBeat.i(277285);
    s.u(parama, "$callback");
    if (paramIPCLiveControlData == null) {}
    for (paramIPCLiveControlData = null;; paramIPCLiveControlData = paramIPCLiveControlData.JdB)
    {
      parama.gotSurface((Surface)paramIPCLiveControlData);
      AppMethodBeat.o(277285);
      return;
    }
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(277300);
    s.u(parama, "callback");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdJ, null, null, 12), PluginGameLive.c.class, new GameLiveAppbrandRenderMgrService..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(277300);
  }
  
  public final void q(Surface paramSurface)
  {
    AppMethodBeat.i(277296);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdI, null, (Parcelable)paramSurface, 6), PluginGameLive.c.class, null);
    AppMethodBeat.o(277296);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277304);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdK, null, (Parcelable)new GameLiveAppbrandRenderMgrService.Payload(paramInt1, paramInt2), 6), PluginGameLive.c.class, null);
    AppMethodBeat.o(277304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.render.GameLiveAppbrandRenderMgrService
 * JD-Core Version:    0.7.0.1
 */