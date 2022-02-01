package com.tencent.mm.media.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerFactory;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer$Factory;", "()V", "get", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "filePath", "", "outputFilePath", "outputWidth", "", "outputHeight", "outputBitrate", "outputFps", "minQP", "maxQP", "callback", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer$FinishCallback;", "startTimeMs", "", "endTimeMs", "getWithSoftEncode", "outputHevc", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements c.a
{
  public static final g nDb;
  
  static
  {
    AppMethodBeat.i(93825);
    nDb = new g();
    AppMethodBeat.o(93825);
  }
  
  public final c a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, c.b paramb)
  {
    AppMethodBeat.i(93823);
    if (paramString1 == null)
    {
      paramString1 = "";
      if (paramString2 != null) {
        break label82;
      }
      paramString2 = "";
    }
    label82:
    for (;;)
    {
      paramString1 = (c)new e(null, paramString1, 1, paramString2, 0, 0, paramInt1, paramInt2, paramInt3, 48000, 44100, 1, paramInt4, 0L, 0L, false, false, paramInt5, paramInt6, false, 0, (b)new a(paramb), 7340032);
      AppMethodBeat.o(93823);
      return paramString1;
      break;
    }
  }
  
  public final c a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, c.b paramb)
  {
    AppMethodBeat.i(237807);
    if (paramString1 == null)
    {
      paramString1 = "";
      if (paramString2 != null) {
        break label83;
      }
      paramString2 = "";
    }
    label83:
    for (;;)
    {
      paramString1 = (c)new e(null, paramString1, 1, paramString2, 0, 0, paramInt1, paramInt2, paramInt3, 48000, 44100, 1, paramInt4, 0L, 0L, true, paramBoolean, paramInt5, paramInt6, false, 0, (b)new c(paramb), 7340032);
      AppMethodBeat.o(237807);
      return paramString1;
      break;
    }
  }
  
  public final c a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, int paramInt5, int paramInt6, c.b paramb)
  {
    AppMethodBeat.i(93824);
    if (paramString1 == null)
    {
      paramString1 = "";
      if (paramString2 != null) {
        break label84;
      }
      paramString2 = "";
    }
    label84:
    for (;;)
    {
      paramString1 = (c)new e(null, paramString1, 1, paramString2, 0, 0, paramInt1, paramInt2, paramInt3, 48000, 44100, 1, paramInt4, paramLong1, paramLong2, false, false, paramInt5, paramInt6, false, 0, (b)new b(paramb), 7340032);
      AppMethodBeat.o(93824);
      return paramString1;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "path", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<String, ah>
  {
    a(c.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "path", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<String, ah>
  {
    b(c.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "path", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<String, ah>
  {
    c(c.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.i.g
 * JD-Core Version:    0.7.0.1
 */