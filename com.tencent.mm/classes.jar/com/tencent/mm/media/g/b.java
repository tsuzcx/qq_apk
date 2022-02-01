package com.tencent.mm.media.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/globject/GLLeakIDKeyReport;", "", "()V", "FBO_STEP", "", "ID", "", "KEY_ABSSURFACERENDERER", "KEY_FADEDRAWER", "KEY_GLTEXTURERENDERPROC", "KEY_GLTEXTURERENDERPROCBLEND", "KEY_GLTEXTURERENDERPROCYUVTORGB", "KEY_IMAGEDRAWER", "KEY_LIVE", "KEY_MULTITALK", "KEY_MULTI_VIDEO", "KEY_OTHER", "KEY_SCREEN_CAST", "KEY_SCRIPTRENDER", "KEY_STICKERPREVIEWRENDER", "KEY_VLOGREMUXSURFACE", "KEY_VLogScriptTexCache", "KEY_VOIP", "KEY_XEFFECT_RENDERER", "KEY_XLABEFFECT", "NOT_DEFINED", "TAG", "", "markGLFBOCreated", "", "markGLFBOLeaked", "markGLFBOLeakedInErrorTid", "markGLFBOLeakedScene", "key", "markGLTextureCreated", "markGLTextureLeaked", "markGLTextureLeakedInErrorTid", "markGLTextureLeakedScene", "plugin-mediaeditor_release"})
public final class b
{
  public static final b kVf;
  
  static
  {
    AppMethodBeat.i(93693);
    kVf = new b();
    AppMethodBeat.o(93693);
  }
  
  public static void FN(long paramLong)
  {
    AppMethodBeat.i(93687);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeakedScene key:".concat(String.valueOf(paramLong)));
    h.IzE.p(1184L, paramLong, 1L);
    AppMethodBeat.o(93687);
  }
  
  public static void FO(long paramLong)
  {
    AppMethodBeat.i(93690);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeakedScene key:".concat(String.valueOf(paramLong)));
    h.IzE.p(1184L, 100L + paramLong, 1L);
    AppMethodBeat.o(93690);
  }
  
  public static void aUK()
  {
    AppMethodBeat.i(93685);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureCreated");
    h.IzE.p(1184L, 0L, 1L);
    AppMethodBeat.o(93685);
  }
  
  public static void aUL()
  {
    AppMethodBeat.i(93686);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeaked");
    h.IzE.p(1184L, 1L, 1L);
    AppMethodBeat.o(93686);
  }
  
  public static void aUM()
  {
    AppMethodBeat.i(93688);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOCreated");
    h.IzE.p(1184L, 100L, 1L);
    AppMethodBeat.o(93688);
  }
  
  public static void aUN()
  {
    AppMethodBeat.i(93689);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeaked");
    h.IzE.p(1184L, 101L, 1L);
    AppMethodBeat.o(93689);
  }
  
  public static void aUO()
  {
    AppMethodBeat.i(93691);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeakedInErrorTid");
    h.IzE.p(1184L, 200L, 1L);
    AppMethodBeat.o(93691);
  }
  
  public static void aUP()
  {
    AppMethodBeat.i(93692);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeakedInErrorTid");
    h.IzE.p(1184L, 201L, 1L);
    AppMethodBeat.o(93692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.g.b
 * JD-Core Version:    0.7.0.1
 */