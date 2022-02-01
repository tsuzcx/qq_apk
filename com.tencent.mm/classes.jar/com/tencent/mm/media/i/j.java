package com.tencent.mm.media.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/remuxer/RemuxConfig;", "", "()V", "Companion", "plugin-mediaeditor_release"})
public final class j
{
  public static final a ijn;
  
  static
  {
    AppMethodBeat.i(93836);
    ijn = new a((byte)0);
    AppMethodBeat.o(93836);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/remuxer/RemuxConfig$Companion;", "", "()V", "getAudioCpFile", "", "filePath", "getCpVideoFile", "file", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static String Ho(String paramString)
    {
      AppMethodBeat.i(93834);
      p.h(paramString, "filePath");
      paramString = paramString + "_audio.aac";
      AppMethodBeat.o(93834);
      return paramString;
    }
    
    public static String Hp(String paramString)
    {
      AppMethodBeat.i(93835);
      p.h(paramString, "file");
      if (MMApplicationContext.isMainProcess())
      {
        localObject = new StringBuilder();
        e locale = g.aAh();
        p.g(locale, "MMKernel.storage()");
        localObject = locale.azM() + "videoMix/";
        s.boN((String)localObject);
        paramString = (String)localObject + s.bhK(paramString) + "_cp_video.temp";
        AppMethodBeat.o(93835);
        return paramString;
      }
      Object localObject = ar.NSe + "tmp";
      if (!s.YS((String)localObject)) {
        s.boN((String)localObject);
      }
      paramString = (String)localObject + "/" + s.bhK(paramString) + "_cp_video.temp";
      AppMethodBeat.o(93835);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.i.j
 * JD-Core Version:    0.7.0.1
 */