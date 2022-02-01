package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  public static final Long cUd;
  public static final Long cUf;
  public static final Long cUg;
  public static final Long cUh;
  private static List<String> cUk;
  public static long cUl;
  public static final Long kQF;
  public static final Long kQG;
  
  static
  {
    AppMethodBeat.i(146323);
    cUd = Long.valueOf(259200000L);
    cUf = Long.valueOf(86400000L);
    cUg = Long.valueOf(43200000L);
    cUh = Long.valueOf(240000L);
    kQF = Long.valueOf(60000L);
    kQG = cUf;
    cUl = 0L;
    cUk = new ArrayList(10);
    AppMethodBeat.o(146323);
  }
  
  public static void bhN()
  {
    AppMethodBeat.i(146320);
    long l = System.currentTimeMillis();
    if (l - cUl <= kQG.longValue())
    {
      ad.e("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
      AppMethodBeat.o(146320);
      return;
    }
    ad.i("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
    cUl = l;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.d
 * JD-Core Version:    0.7.0.1
 */