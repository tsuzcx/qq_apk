package com.tencent.mm.media.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/globject/GLLeakIDKeyReport;", "", "()V", "FBO_STEP", "", "ID", "", "KEY_ABSSURFACERENDERER", "KEY_FADEDRAWER", "KEY_GLTEXTURERENDERPROC", "KEY_GLTEXTURERENDERPROCBLEND", "KEY_GLTEXTURERENDERPROCYUVTORGB", "KEY_IMAGEDRAWER", "KEY_LIVE", "KEY_MULTI_VIDEO", "KEY_OTHER", "KEY_SCRIPTRENDER", "KEY_STICKERPREVIEWRENDER", "KEY_VLOGREMUXSURFACE", "KEY_VLogScriptTexCache", "KEY_VOIP", "KEY_XEFFECT_RENDERER", "KEY_XLABEFFECT", "NOT_DEFINED", "TAG", "", "markGLFBOCreated", "", "markGLFBOLeaked", "markGLFBOLeakedInErrorTid", "markGLFBOLeakedScene", "key", "markGLTextureCreated", "markGLTextureLeaked", "markGLTextureLeakedInErrorTid", "markGLTextureLeakedScene", "plugin-mediaeditor_release"})
public final class b
{
  public static final b grk;
  
  static
  {
    AppMethodBeat.i(93693);
    grk = new b();
    AppMethodBeat.o(93693);
  }
  
  public static void ajQ()
  {
    AppMethodBeat.i(93685);
    ad.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureCreated");
    h.vKh.m(1184L, 0L, 1L);
    AppMethodBeat.o(93685);
  }
  
  public static void ajR()
  {
    AppMethodBeat.i(93686);
    ad.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeaked");
    h.vKh.m(1184L, 1L, 1L);
    AppMethodBeat.o(93686);
  }
  
  public static void ajS()
  {
    AppMethodBeat.i(93688);
    ad.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOCreated");
    h.vKh.m(1184L, 100L, 1L);
    AppMethodBeat.o(93688);
  }
  
  public static void ajT()
  {
    AppMethodBeat.i(93689);
    ad.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeaked");
    h.vKh.m(1184L, 101L, 1L);
    AppMethodBeat.o(93689);
  }
  
  public static void ajU()
  {
    AppMethodBeat.i(93691);
    ad.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeakedInErrorTid");
    h.vKh.m(1184L, 200L, 1L);
    AppMethodBeat.o(93691);
  }
  
  public static void ajV()
  {
    AppMethodBeat.i(93692);
    ad.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeakedInErrorTid");
    h.vKh.m(1184L, 201L, 1L);
    AppMethodBeat.o(93692);
  }
  
  public static void lA(long paramLong)
  {
    AppMethodBeat.i(93687);
    ad.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeakedScene key:".concat(String.valueOf(paramLong)));
    h.vKh.m(1184L, paramLong, 1L);
    AppMethodBeat.o(93687);
  }
  
  public static void lB(long paramLong)
  {
    AppMethodBeat.i(93690);
    ad.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeakedScene key:".concat(String.valueOf(paramLong)));
    h.vKh.m(1184L, 100L + paramLong, 1L);
    AppMethodBeat.o(93690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.f.b
 * JD-Core Version:    0.7.0.1
 */