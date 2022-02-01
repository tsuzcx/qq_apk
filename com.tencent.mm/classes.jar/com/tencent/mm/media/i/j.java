package com.tencent.mm.media.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/remuxer/RemuxConfig;", "", "()V", "Companion", "plugin-mediaeditor_release"})
public final class j
{
  public static final a kYa;
  
  static
  {
    AppMethodBeat.i(93836);
    kYa = new a((byte)0);
    AppMethodBeat.o(93836);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/remuxer/RemuxConfig$Companion;", "", "()V", "getAudioCpFile", "", "filePath", "getCpVideoFile", "file", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static String OA(String paramString)
    {
      AppMethodBeat.i(93835);
      p.k(paramString, "file");
      if (MMApplicationContext.isMainProcess())
      {
        localObject = new StringBuilder();
        f localf = h.aHG();
        p.j(localf, "MMKernel.storage()");
        localObject = localf.aHl() + "videoMix/";
        u.bBD((String)localObject);
        paramString = (String)localObject + u.buc(paramString) + "_cp_video.temp";
        AppMethodBeat.o(93835);
        return paramString;
      }
      Object localObject = ar.Vgb + "tmp";
      if (!u.agG((String)localObject)) {
        u.bBD((String)localObject);
      }
      paramString = (String)localObject + "/" + u.buc(paramString) + "_cp_video.temp";
      AppMethodBeat.o(93835);
      return paramString;
    }
    
    public static String Oz(String paramString)
    {
      AppMethodBeat.i(93834);
      p.k(paramString, "filePath");
      paramString = paramString + "_audio.aac";
      AppMethodBeat.o(93834);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.i.j
 * JD-Core Version:    0.7.0.1
 */