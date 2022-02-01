package com.tencent.mm.media.k;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getIntegerOrDefault", "", "Landroid/media/MediaFormat;", "key", "", "defaultValue", "plugin-mediaeditor_release"})
public final class e
{
  public static final int a(MediaFormat paramMediaFormat, String paramString)
  {
    AppMethodBeat.i(260148);
    p.k(paramMediaFormat, "$this$getIntegerOrDefault");
    p.k(paramString, "key");
    try
    {
      i = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(260148);
      return i;
    }
    catch (Exception paramMediaFormat)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.k.e
 * JD-Core Version:    0.7.0.1
 */