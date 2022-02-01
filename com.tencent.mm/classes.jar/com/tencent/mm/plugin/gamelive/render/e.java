package com.tencent.mm.plugin.gamelive.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/render/GameLiveTextureRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "()V", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "Companion", "plugin-gamelive_release"})
public final class e
  extends com.tencent.mm.media.j.d
{
  public static final a DmN;
  
  static
  {
    AppMethodBeat.i(208349);
    DmN = new a((byte)0);
    AppMethodBeat.o(208349);
  }
  
  public e()
  {
    super(1);
  }
  
  public final com.tencent.mm.media.j.b.a aMT()
  {
    AppMethodBeat.i(208347);
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new a(this.krg, this.krh, this.ksu, this.ksv, aVh(), getScaleType());
    AppMethodBeat.o(208347);
    return locala;
  }
  
  public final com.tencent.mm.media.g.d aMV()
  {
    com.tencent.mm.media.j.b.a locala = this.kYb;
    if (locala != null) {
      return locala.kYx;
    }
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/render/GameLiveTextureRenderer$Companion;", "", "()V", "TAG", "", "plugin-gamelive_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.render.e
 * JD-Core Version:    0.7.0.1
 */