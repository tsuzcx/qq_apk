package com.tencent.mm.media.g;

import a.f.a.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerFactory;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer$Factory;", "()V", "get", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "filePath", "", "outputFilePath", "outputWidth", "", "outputHeight", "outputBitrate", "outputFps", "callback", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer$FinishCallback;", "startTimeMs", "", "endTimeMs", "plugin-mediaeditor_release"})
public final class i
  implements d.a
{
  public final d a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, d.b paramb)
  {
    AppMethodBeat.i(13077);
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (paramString2 == null) {
        paramString2 = "";
      }
      for (;;)
      {
        paramString1 = (d)new g(paramString1, paramString2, paramInt1, paramInt2, paramInt3, 1, paramInt4, paramLong1, paramLong2, (b)new i.b(paramb), 8192);
        AppMethodBeat.o(13077);
        return paramString1;
      }
    }
  }
  
  public final d a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, d.b paramb)
  {
    AppMethodBeat.i(13076);
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (paramString2 == null) {
        paramString2 = "";
      }
      for (;;)
      {
        paramString1 = (d)new g(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, 0, 0L, 0L, (b)new i.a(paramb), 12288);
        AppMethodBeat.o(13076);
        return paramString1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.g.i
 * JD-Core Version:    0.7.0.1
 */