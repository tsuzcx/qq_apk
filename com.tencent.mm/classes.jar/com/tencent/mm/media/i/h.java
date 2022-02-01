package com.tencent.mm.media.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerFactory;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer$Factory;", "()V", "get", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "filePath", "", "outputFilePath", "outputWidth", "", "outputHeight", "outputBitrate", "outputFps", "minQP", "maxQP", "callback", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer$FinishCallback;", "startTimeMs", "", "endTimeMs", "plugin-mediaeditor_release"})
public final class h
  implements d.a
{
  public static final h ijh;
  
  static
  {
    AppMethodBeat.i(93825);
    ijh = new h();
    AppMethodBeat.o(93825);
  }
  
  public final d a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, d.b paramb)
  {
    AppMethodBeat.i(93823);
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
        paramString1 = (d)new f(null, paramString1, 1, paramString2, 0, 0, paramInt1, paramInt2, paramInt3, 48000, 44100, 1, paramInt4, 0L, 0L, false, false, paramInt5, paramInt6, false, 0, (b)new a(paramb), 7340032);
        AppMethodBeat.o(93823);
        return paramString1;
      }
    }
  }
  
  public final d a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, int paramInt5, int paramInt6, d.b paramb)
  {
    AppMethodBeat.i(93824);
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
        paramString1 = (d)new f(null, paramString1, 1, paramString2, 0, 0, paramInt1, paramInt2, paramInt3, 48000, 44100, 1, paramInt4, paramLong1, paramLong2, false, false, paramInt5, paramInt6, false, 0, (b)new b(paramb), 7340032);
        AppMethodBeat.o(93824);
        return paramString1;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "path", "", "invoke"})
  static final class a
    extends q
    implements b<String, x>
  {
    a(d.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "path", "", "invoke"})
  static final class b
    extends q
    implements b<String, x>
  {
    b(d.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.i.h
 * JD-Core Version:    0.7.0.1
 */