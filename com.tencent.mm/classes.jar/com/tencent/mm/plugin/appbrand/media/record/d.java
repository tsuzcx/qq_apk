package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  public static final Long hrH;
  public static final Long hrJ;
  public static final Long hrK;
  public static final Long hrL;
  private static List<String> hrO;
  public static long hrP;
  public static final Long tiv;
  public static final Long tiw;
  
  static
  {
    AppMethodBeat.i(146323);
    hrH = Long.valueOf(259200000L);
    hrJ = Long.valueOf(86400000L);
    hrK = Long.valueOf(43200000L);
    hrL = Long.valueOf(240000L);
    tiv = Long.valueOf(60000L);
    tiw = hrJ;
    hrP = 0L;
    hrO = new ArrayList(10);
    AppMethodBeat.o(146323);
  }
  
  public static void cBE()
  {
    AppMethodBeat.i(146320);
    long l = System.currentTimeMillis();
    if (l - hrP <= tiw.longValue())
    {
      Log.e("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
      AppMethodBeat.o(146320);
      return;
    }
    Log.i("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
    hrP = l;
    ThreadPool.post(new Runnable()
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