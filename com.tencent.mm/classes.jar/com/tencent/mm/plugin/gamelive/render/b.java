package com.tencent.mm.plugin.gamelive.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.h;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/render/GameLiveMainRenderMgrService;", "Lcom/tencent/mm/plugin/gamelive/render/IGameLiveMainRenderMgrService;", "()V", "height", "", "renderMgr", "Lcom/tencent/mm/plugin/gamelive/render/GameLiveRenderManager;", "width", "getInputSurface", "", "callback", "Lcom/tencent/mm/plugin/gamelive/render/IGameLiveMainRenderMgrService$IGameLiveInputSurfaceCallback;", "pause", "resume", "setDisableGLFinish", "disable", "", "setOnScreenSurface", "surface", "Landroid/view/Surface;", "setSize", "start", "stop", "ceilTo16", "Companion", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements f
{
  public static final b.a Jgk;
  public c Jgl;
  public int height;
  public int width;
  
  static
  {
    AppMethodBeat.i(277336);
    Jgk = new b.a((byte)0);
    AppMethodBeat.o(277336);
  }
  
  public static int Yb(int paramInt)
  {
    int i = paramInt / 16;
    if (paramInt % 16 == 0) {}
    for (paramInt = 0;; paramInt = 16) {
      return paramInt + i * 16;
    }
  }
  
  public static void wE(boolean paramBoolean)
  {
    AppMethodBeat.i(277332);
    i locali1 = new i();
    locali1.m("api", "setCustomCaptureGLSyncMode");
    i locali2 = new i();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      locali2.au("mode", i);
      ah localah = ah.aiuX;
      locali1.m("params", locali2);
      ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).callLiveExperimentalAPI(locali1.toString());
      AppMethodBeat.o(277332);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.render.b
 * JD-Core Version:    0.7.0.1
 */