package com.tencent.mm.media.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.al;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/remuxer/RemuxConfig;", "", "()V", "Companion", "plugin-mediaeditor_release"})
public final class j
{
  public static final a hne;
  
  static
  {
    AppMethodBeat.i(93836);
    hne = new a((byte)0);
    AppMethodBeat.o(93836);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/remuxer/RemuxConfig$Companion;", "", "()V", "getAudioCpFile", "", "filePath", "getCpVideoFile", "file", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static String yf(String paramString)
    {
      AppMethodBeat.i(93834);
      p.h(paramString, "filePath");
      paramString = paramString + "_audio.aac";
      AppMethodBeat.o(93834);
      return paramString;
    }
    
    public static String yg(String paramString)
    {
      AppMethodBeat.i(93835);
      p.h(paramString, "file");
      if (aj.cmR())
      {
        localObject = new StringBuilder();
        e locale = g.ajC();
        p.g(locale, "MMKernel.storage()");
        localObject = locale.ajh() + "videoMix/";
        i.aYg((String)localObject);
        paramString = (String)localObject + i.aPK(paramString) + "_cp_video.temp";
        AppMethodBeat.o(93835);
        return paramString;
      }
      Object localObject = al.IpN + "tmp";
      if (!i.fv((String)localObject)) {
        i.aYg((String)localObject);
      }
      paramString = (String)localObject + "/" + i.aPK(paramString) + "_cp_video.temp";
      AppMethodBeat.o(93835);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.i.j
 * JD-Core Version:    0.7.0.1
 */