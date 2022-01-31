package com.tencent.mm.media.g;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ag;
import java.io.File;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/remuxer/RemuxConfig$Companion;", "", "()V", "getAudioCpFile", "", "filePath", "getCpVideoFile", "plugin-mediaeditor_release"})
public final class k$a
{
  public static String mQ(String paramString)
  {
    AppMethodBeat.i(13083);
    j.q(paramString, "filePath");
    paramString = paramString + "_audio.aac";
    AppMethodBeat.o(13083);
    return paramString;
  }
  
  public static String mR(String paramString)
  {
    AppMethodBeat.i(13084);
    j.q(paramString, "filePath");
    paramString = new StringBuilder();
    com.tencent.mm.kernel.e locale = g.RL();
    j.p(locale, "MMKernel.storage()");
    paramString = locale.Rp() + "videoMix" + File.separator;
    com.tencent.mm.vfs.e.um(paramString);
    paramString = paramString + ag.cE(paramString) + "_cp_video.temp";
    AppMethodBeat.o(13084);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.g.k.a
 * JD-Core Version:    0.7.0.1
 */