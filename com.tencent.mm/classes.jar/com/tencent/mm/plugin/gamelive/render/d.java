package com.tencent.mm.plugin.gamelive.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/render/GameLiveTextureRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "()V", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "Companion", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends c
{
  public static final d.a Jgx;
  
  static
  {
    AppMethodBeat.i(277317);
    Jgx = new d.a((byte)0);
    AppMethodBeat.o(277317);
  }
  
  public d()
  {
    super(1);
  }
  
  public final com.tencent.mm.media.j.b.a bgD()
  {
    AppMethodBeat.i(277320);
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new a(this.mVd, this.mVe, this.mWn, this.mWo, bpJ(), getScaleType());
    AppMethodBeat.o(277320);
    return locala;
  }
  
  public final com.tencent.mm.media.g.d bgF()
  {
    com.tencent.mm.media.j.b.a locala = this.nDm;
    if (locala == null) {
      return null;
    }
    return locala.nDF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.render.d
 * JD-Core Version:    0.7.0.1
 */