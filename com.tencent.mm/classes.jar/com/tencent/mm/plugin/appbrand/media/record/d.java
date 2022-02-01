package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  public static final Long dcQ;
  public static final Long dcS;
  public static final Long dcT;
  public static final Long dcU;
  private static List<String> dcX;
  public static long dcY;
  public static final Long lRo;
  public static final Long lRp;
  
  static
  {
    AppMethodBeat.i(146323);
    dcQ = Long.valueOf(259200000L);
    dcS = Long.valueOf(86400000L);
    dcT = Long.valueOf(43200000L);
    dcU = Long.valueOf(240000L);
    lRo = Long.valueOf(60000L);
    lRp = dcS;
    dcY = 0L;
    dcX = new ArrayList(10);
    AppMethodBeat.o(146323);
  }
  
  public static void bsG()
  {
    AppMethodBeat.i(146320);
    long l = System.currentTimeMillis();
    if (l - dcY <= lRp.longValue())
    {
      ad.e("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
      AppMethodBeat.o(146320);
      return;
    }
    ad.i("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
    dcY = l;
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