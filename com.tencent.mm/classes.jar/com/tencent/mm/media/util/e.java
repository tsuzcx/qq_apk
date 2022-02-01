package com.tencent.mm.media.util;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"getIntegerOrDefault", "", "Landroid/media/MediaFormat;", "key", "", "defaultValue", "plugin-mediaeditor_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final int a(MediaFormat paramMediaFormat, String paramString)
  {
    AppMethodBeat.i(236932);
    s.u(paramMediaFormat, "<this>");
    s.u(paramString, "key");
    try
    {
      i = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(236932);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.util.e
 * JD-Core Version:    0.7.0.1
 */