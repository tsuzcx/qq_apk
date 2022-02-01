package com.tencent.mm.media.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/remuxer/RemuxConfig;", "", "()V", "Companion", "plugin-mediaeditor_release"})
public final class j
{
  public static final a guw;
  
  static
  {
    AppMethodBeat.i(93836);
    guw = new a((byte)0);
    AppMethodBeat.o(93836);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/remuxer/RemuxConfig$Companion;", "", "()V", "getAudioCpFile", "", "filePath", "getCpVideoFile", "file", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static String rm(String paramString)
    {
      AppMethodBeat.i(93834);
      k.h(paramString, "filePath");
      paramString = paramString + "_audio.aac";
      AppMethodBeat.o(93834);
      return paramString;
    }
    
    public static String rn(String paramString)
    {
      AppMethodBeat.i(93835);
      k.h(paramString, "file");
      if (aj.cbe())
      {
        paramString = new StringBuilder();
        localObject = g.afB();
        k.g(localObject, "MMKernel.storage()");
        paramString = ((e)localObject).aff() + "videoMix/";
        i.aMF(paramString);
        paramString = paramString + i.aEN(paramString) + "_cp_video.temp";
        AppMethodBeat.o(93835);
        return paramString;
      }
      Object localObject = ae.FfH + "tmp";
      if (!i.eK((String)localObject)) {
        i.aMF((String)localObject);
      }
      paramString = (String)localObject + "/" + i.aEN(paramString) + "_cp_video.temp";
      AppMethodBeat.o(93835);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.h.j
 * JD-Core Version:    0.7.0.1
 */