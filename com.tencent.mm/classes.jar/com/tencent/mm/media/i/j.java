package com.tencent.mm.media.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.am;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/remuxer/RemuxConfig;", "", "()V", "Companion", "plugin-mediaeditor_release"})
public final class j
{
  public static final a hpS;
  
  static
  {
    AppMethodBeat.i(93836);
    hpS = new a((byte)0);
    AppMethodBeat.o(93836);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/remuxer/RemuxConfig$Companion;", "", "()V", "getAudioCpFile", "", "filePath", "getCpVideoFile", "file", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static String yP(String paramString)
    {
      AppMethodBeat.i(93834);
      p.h(paramString, "filePath");
      paramString = paramString + "_audio.aac";
      AppMethodBeat.o(93834);
      return paramString;
    }
    
    public static String yQ(String paramString)
    {
      AppMethodBeat.i(93835);
      p.h(paramString, "file");
      if (ak.coh())
      {
        localObject = new StringBuilder();
        e locale = g.ajR();
        p.g(locale, "MMKernel.storage()");
        localObject = locale.ajw() + "videoMix/";
        o.aZI((String)localObject);
        paramString = (String)localObject + o.aRh(paramString) + "_cp_video.temp";
        AppMethodBeat.o(93835);
        return paramString;
      }
      Object localObject = am.IKh + "tmp";
      if (!o.fB((String)localObject)) {
        o.aZI((String)localObject);
      }
      paramString = (String)localObject + "/" + o.aRh(paramString) + "_cp_video.temp";
      AppMethodBeat.o(93835);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.i.j
 * JD-Core Version:    0.7.0.1
 */