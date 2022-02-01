package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  public static final Long duO;
  public static final Long duQ;
  public static final Long duR;
  public static final Long duS;
  private static List<String> duV;
  public static long duW;
  public static final Long ndq;
  public static final Long ndr;
  
  static
  {
    AppMethodBeat.i(146323);
    duO = Long.valueOf(259200000L);
    duQ = Long.valueOf(86400000L);
    duR = Long.valueOf(43200000L);
    duS = Long.valueOf(240000L);
    ndq = Long.valueOf(60000L);
    ndr = duQ;
    duW = 0L;
    duV = new ArrayList(10);
    AppMethodBeat.o(146323);
  }
  
  public static void bOU()
  {
    AppMethodBeat.i(146320);
    long l = System.currentTimeMillis();
    if (l - duW <= ndr.longValue())
    {
      Log.e("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
      AppMethodBeat.o(146320);
      return;
    }
    Log.i("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
    duW = l;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.d
 * JD-Core Version:    0.7.0.1
 */