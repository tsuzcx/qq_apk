package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  public static final Long ddS;
  public static final Long ddU;
  public static final Long ddV;
  public static final Long ddW;
  private static List<String> ddZ;
  public static long dea;
  public static final Long lVP;
  public static final Long lVQ;
  
  static
  {
    AppMethodBeat.i(146323);
    ddS = Long.valueOf(259200000L);
    ddU = Long.valueOf(86400000L);
    ddV = Long.valueOf(43200000L);
    ddW = Long.valueOf(240000L);
    lVP = Long.valueOf(60000L);
    lVQ = ddU;
    dea = 0L;
    ddZ = new ArrayList(10);
    AppMethodBeat.o(146323);
  }
  
  public static void btr()
  {
    AppMethodBeat.i(146320);
    long l = System.currentTimeMillis();
    if (l - dea <= lVQ.longValue())
    {
      ae.e("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
      AppMethodBeat.o(146320);
      return;
    }
    ae.i("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
    dea = l;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.d
 * JD-Core Version:    0.7.0.1
 */