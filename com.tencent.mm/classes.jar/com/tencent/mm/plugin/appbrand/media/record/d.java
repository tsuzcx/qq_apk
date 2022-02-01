package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  public static final Long cRA;
  public static final Long cRC;
  public static final Long cRD;
  public static final Long cRE;
  private static List<String> cRH;
  public static long cRI;
  public static final Long lse;
  public static final Long lsg;
  
  static
  {
    AppMethodBeat.i(146323);
    cRA = Long.valueOf(259200000L);
    cRC = Long.valueOf(86400000L);
    cRD = Long.valueOf(43200000L);
    cRE = Long.valueOf(240000L);
    lse = Long.valueOf(60000L);
    lsg = cRC;
    cRI = 0L;
    cRH = new ArrayList(10);
    AppMethodBeat.o(146323);
  }
  
  public static void boH()
  {
    AppMethodBeat.i(146320);
    long l = System.currentTimeMillis();
    if (l - cRI <= lsg.longValue())
    {
      ac.e("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
      AppMethodBeat.o(146320);
      return;
    }
    ac.i("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
    cRI = l;
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146319);
        d.access$000();
        AppMethodBeat.o(146319);
      }
    }, "AudioRecordCacheClean");
    AppMethodBeat.o(146320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.d
 * JD-Core Version:    0.7.0.1
 */