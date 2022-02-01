package com.tencent.mm.media.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/globject/GLLeakIDKeyReport;", "", "()V", "FBO_STEP", "", "ID", "", "KEY_ABSSURFACERENDERER", "KEY_FADEDRAWER", "KEY_GLTEXTURERENDERPROC", "KEY_GLTEXTURERENDERPROCBLEND", "KEY_GLTEXTURERENDERPROCYUVTORGB", "KEY_IMAGEDRAWER", "KEY_LIVE", "KEY_MULTITALK", "KEY_MULTI_VIDEO", "KEY_OTHER", "KEY_SCRIPTRENDER", "KEY_STICKERPREVIEWRENDER", "KEY_VLOGREMUXSURFACE", "KEY_VLogScriptTexCache", "KEY_VOIP", "KEY_XEFFECT_RENDERER", "KEY_XLABEFFECT", "NOT_DEFINED", "TAG", "", "markGLFBOCreated", "", "markGLFBOLeaked", "markGLFBOLeakedInErrorTid", "markGLFBOLeakedScene", "key", "markGLTextureCreated", "markGLTextureLeaked", "markGLTextureLeakedInErrorTid", "markGLTextureLeakedScene", "plugin-mediaeditor_release"})
public final class b
{
  public static final b hmY;
  
  static
  {
    AppMethodBeat.i(93693);
    hmY = new b();
    AppMethodBeat.o(93693);
  }
  
  public static void atS()
  {
    AppMethodBeat.i(93685);
    ae.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureCreated");
    g.yxI.n(1184L, 0L, 1L);
    AppMethodBeat.o(93685);
  }
  
  public static void atT()
  {
    AppMethodBeat.i(93686);
    ae.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeaked");
    g.yxI.n(1184L, 1L, 1L);
    AppMethodBeat.o(93686);
  }
  
  public static void atU()
  {
    AppMethodBeat.i(93688);
    ae.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOCreated");
    g.yxI.n(1184L, 100L, 1L);
    AppMethodBeat.o(93688);
  }
  
  public static void atV()
  {
    AppMethodBeat.i(93689);
    ae.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeaked");
    g.yxI.n(1184L, 101L, 1L);
    AppMethodBeat.o(93689);
  }
  
  public static void atW()
  {
    AppMethodBeat.i(93691);
    ae.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeakedInErrorTid");
    g.yxI.n(1184L, 200L, 1L);
    AppMethodBeat.o(93691);
  }
  
  public static void atX()
  {
    AppMethodBeat.i(93692);
    ae.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeakedInErrorTid");
    g.yxI.n(1184L, 201L, 1L);
    AppMethodBeat.o(93692);
  }
  
  public static void rB(long paramLong)
  {
    AppMethodBeat.i(93687);
    ae.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeakedScene key:".concat(String.valueOf(paramLong)));
    g.yxI.n(1184L, paramLong, 1L);
    AppMethodBeat.o(93687);
  }
  
  public static void rC(long paramLong)
  {
    AppMethodBeat.i(93690);
    ae.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeakedScene key:".concat(String.valueOf(paramLong)));
    g.yxI.n(1184L, 100L + paramLong, 1L);
    AppMethodBeat.o(93690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.g.b
 * JD-Core Version:    0.7.0.1
 */