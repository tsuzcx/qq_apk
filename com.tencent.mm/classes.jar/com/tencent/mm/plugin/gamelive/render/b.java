package com.tencent.mm.plugin.gamelive.render;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.h;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/render/GameLiveMainRenderMgrService;", "Lcom/tencent/mm/plugin/gamelive/render/IGameLiveMainRenderMgrService;", "()V", "height", "", "renderMgr", "Lcom/tencent/mm/plugin/gamelive/render/GameLiveRenderManager;", "width", "getInputSurface", "", "callback", "Lcom/tencent/mm/plugin/gamelive/render/IGameLiveMainRenderMgrService$IGameLiveInputSurfaceCallback;", "pause", "resume", "setDisableGLFinish", "disable", "", "setOnScreenSurface", "surface", "Landroid/view/Surface;", "setSize", "start", "stop", "ceilTo16", "Companion", "plugin-gamelive_release"})
public final class b
  implements g
{
  public static final b.a DmB;
  public c DmA;
  public int height;
  public int width;
  
  static
  {
    AppMethodBeat.i(208053);
    DmB = new b.a((byte)0);
    AppMethodBeat.o(208053);
  }
  
  public static int Ue(int paramInt)
  {
    int i = paramInt / 16;
    if (paramInt % 16 == 0) {}
    for (paramInt = 0;; paramInt = 16) {
      return paramInt + i * 16;
    }
  }
  
  public static void sy(boolean paramBoolean)
  {
    AppMethodBeat.i(208052);
    i locali1 = new i();
    locali1.g("api", "setCustomCaptureGLSyncMode");
    i locali2 = new i();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      locali2.al("mode", i);
      locali1.g("params", locali2);
      ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).callLiveExperimentalAPI(locali1.toString());
      AppMethodBeat.o(208052);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.b<SurfaceTexture, x>
  {
    public b(g.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.render.b
 * JD-Core Version:    0.7.0.1
 */