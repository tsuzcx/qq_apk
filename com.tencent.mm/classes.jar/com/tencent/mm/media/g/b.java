package com.tencent.mm.media.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/globject/GLLeakIDKeyReport;", "", "()V", "FBO_STEP", "", "ID", "", "KEY_ABSSURFACERENDERER", "KEY_CAMERA_KIT", "KEY_FADEDRAWER", "KEY_GLTEXTURERENDERPROC", "KEY_GLTEXTURERENDERPROCBLEND", "KEY_GLTEXTURERENDERPROCYUVTORGB", "KEY_IMAGEDRAWER", "KEY_LIVE", "KEY_MULTITALK", "KEY_MULTI_VIDEO", "KEY_OTHER", "KEY_SCREEN_CAST", "KEY_SCRIPTRENDER", "KEY_STICKERPREVIEWRENDER", "KEY_VLOGREMUXSURFACE", "KEY_VLogScriptTexCache", "KEY_VOIP", "KEY_XEFFECT_RENDERER", "KEY_XLABEFFECT", "KEY_X_EFFECT", "NOT_DEFINED", "TAG", "", "markGLFBOCreated", "", "markGLFBOLeaked", "markGLFBOLeakedInErrorTid", "markGLFBOLeakedScene", "key", "markGLTextureCreated", "markGLTextureLeaked", "markGLTextureLeakedInErrorTid", "markGLTextureLeakedScene", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b nAA;
  
  static
  {
    AppMethodBeat.i(93693);
    nAA = new b();
    AppMethodBeat.o(93693);
  }
  
  public static void bpr()
  {
    AppMethodBeat.i(93685);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureCreated");
    h.OAn.p(1184L, 0L, 1L);
    AppMethodBeat.o(93685);
  }
  
  public static void bps()
  {
    AppMethodBeat.i(93686);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeaked");
    h.OAn.p(1184L, 1L, 1L);
    AppMethodBeat.o(93686);
  }
  
  public static void bpt()
  {
    AppMethodBeat.i(93688);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOCreated");
    h.OAn.p(1184L, 100L, 1L);
    AppMethodBeat.o(93688);
  }
  
  public static void bpu()
  {
    AppMethodBeat.i(93689);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeaked");
    h.OAn.p(1184L, 101L, 1L);
    AppMethodBeat.o(93689);
  }
  
  public static void bpv()
  {
    AppMethodBeat.i(93691);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLTextureLeakedInErrorTid");
    h.OAn.p(1184L, 200L, 1L);
    AppMethodBeat.o(93691);
  }
  
  public static void bpw()
  {
    AppMethodBeat.i(93692);
    Log.i("MicroMsg.GLLeakIDKeyReport", "markGLFBOLeakedInErrorTid");
    h.OAn.p(1184L, 201L, 1L);
    AppMethodBeat.o(93692);
  }
  
  public static void hV(long paramLong)
  {
    AppMethodBeat.i(93687);
    Log.i("MicroMsg.GLLeakIDKeyReport", s.X("markGLTextureLeakedScene key:", Long.valueOf(paramLong)));
    h.OAn.p(1184L, paramLong, 1L);
    AppMethodBeat.o(93687);
  }
  
  public static void hW(long paramLong)
  {
    AppMethodBeat.i(93690);
    Log.i("MicroMsg.GLLeakIDKeyReport", s.X("markGLFBOLeakedScene key:", Long.valueOf(paramLong)));
    h.OAn.p(1184L, 100L + paramLong, 1L);
    AppMethodBeat.o(93690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.g.b
 * JD-Core Version:    0.7.0.1
 */