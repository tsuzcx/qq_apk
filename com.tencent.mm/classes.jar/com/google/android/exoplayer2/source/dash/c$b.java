package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.h.v.a;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

final class c$b
  implements v.a<Long>
{
  private static Long i(InputStream paramInputStream)
  {
    AppMethodBeat.i(10471);
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream)).readLine();
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
      long l = localSimpleDateFormat.parse(paramInputStream).getTime();
      AppMethodBeat.o(10471);
      return Long.valueOf(l);
    }
    catch (ParseException paramInputStream)
    {
      paramInputStream = new o(paramInputStream);
      AppMethodBeat.o(10471);
      throw paramInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.c.b
 * JD-Core Version:    0.7.0.1
 */