package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static final Long cff;
  public static final Long cfi;
  public static final Long cfj;
  public static final Long cfk;
  private static List<String> cfn;
  public static long cfo;
  public static final Long ips;
  public static final Long ipt;
  
  static
  {
    AppMethodBeat.i(105600);
    cff = Long.valueOf(259200000L);
    cfi = Long.valueOf(86400000L);
    cfj = Long.valueOf(43200000L);
    cfk = Long.valueOf(240000L);
    ips = Long.valueOf(60000L);
    ipt = cfi;
    cfo = 0L;
    cfn = new ArrayList(10);
    AppMethodBeat.o(105600);
  }
  
  public static void aHN()
  {
    AppMethodBeat.i(105597);
    long l = System.currentTimeMillis();
    if (l - cfo <= ipt.longValue())
    {
      ab.e("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
      AppMethodBeat.o(105597);
      return;
    }
    ab.i("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
    cfo = l;
    com.tencent.mm.sdk.g.d.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(105596);
        d.access$000();
        AppMethodBeat.o(105596);
      }
    }, "AudioRecordCacheClean");
    AppMethodBeat.o(105597);
  }
  
  private static boolean dW(String paramString)
  {
    AppMethodBeat.i(105598);
    Iterator localIterator = cfn.iterator();
    while (localIterator.hasNext()) {
      if (paramString.contains((String)localIterator.next()))
      {
        AppMethodBeat.o(105598);
        return true;
      }
    }
    AppMethodBeat.o(105598);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.d
 * JD-Core Version:    0.7.0.1
 */