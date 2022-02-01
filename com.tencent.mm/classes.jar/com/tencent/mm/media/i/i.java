package com.tencent.mm.media.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.at;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/remuxer/RemuxConfig;", "", "()V", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final a nDi;
  
  static
  {
    AppMethodBeat.i(93836);
    nDi = new a((byte)0);
    AppMethodBeat.o(93836);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/remuxer/RemuxConfig$Companion;", "", "()V", "getAudioCpFile", "", "filePath", "getCpVideoFile", "file", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String GP(String paramString)
    {
      AppMethodBeat.i(93834);
      s.u(paramString, "filePath");
      paramString = s.X(paramString, "_audio.aac");
      AppMethodBeat.o(93834);
      return paramString;
    }
    
    public static String GQ(String paramString)
    {
      AppMethodBeat.i(93835);
      s.u(paramString, "file");
      if (MMApplicationContext.isMainProcess())
      {
        str = s.X(h.baE().cachePath, "videoMix/");
        y.bDX(str);
        paramString = str + y.bub(paramString) + "_cp_video.temp";
        AppMethodBeat.o(93835);
        return paramString;
      }
      String str = s.X(at.acHq, "tmp");
      if (!y.ZC(str)) {
        y.bDX(str);
      }
      paramString = str + '/' + y.bub(paramString) + "_cp_video.temp";
      AppMethodBeat.o(93835);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.i.i
 * JD-Core Version:    0.7.0.1
 */