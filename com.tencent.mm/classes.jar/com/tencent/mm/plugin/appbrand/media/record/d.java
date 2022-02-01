package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  public static final Long fnA;
  private static List<String> fnD;
  public static long fnE;
  public static final Long fnw;
  public static final Long fny;
  public static final Long fnz;
  public static final Long qdF;
  public static final Long qdG;
  
  static
  {
    AppMethodBeat.i(146323);
    fnw = Long.valueOf(259200000L);
    fny = Long.valueOf(86400000L);
    fnz = Long.valueOf(43200000L);
    fnA = Long.valueOf(240000L);
    qdF = Long.valueOf(60000L);
    qdG = fny;
    fnE = 0L;
    fnD = new ArrayList(10);
    AppMethodBeat.o(146323);
  }
  
  public static void cbk()
  {
    AppMethodBeat.i(146320);
    long l = System.currentTimeMillis();
    if (l - fnE <= qdG.longValue())
    {
      Log.e("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
      AppMethodBeat.o(146320);
      return;
    }
    Log.i("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
    fnE = l;
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