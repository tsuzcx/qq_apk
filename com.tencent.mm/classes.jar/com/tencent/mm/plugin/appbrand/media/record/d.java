package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static final Long gNA = Long.valueOf(86400000L);
  public static final Long gNB = Long.valueOf(43200000L);
  public static final Long gNC = Long.valueOf(240000L);
  public static final Long gND = Long.valueOf(60000L);
  public static final Long gNE = gNA;
  public static long gNF = 0L;
  private static List<String> gNG = new ArrayList(10);
  public static final Long gNz = Long.valueOf(259200000L);
  
  public static void amg()
  {
    long l = System.currentTimeMillis();
    if (l - gNF <= gNE.longValue())
    {
      y.e("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
      return;
    }
    y.i("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
    gNF = l;
    e.post(new d.1(), "AudioRecordCacheClean");
  }
  
  private static boolean vf(String paramString)
  {
    Iterator localIterator = gNG.iterator();
    while (localIterator.hasNext()) {
      if (paramString.contains((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.d
 * JD-Core Version:    0.7.0.1
 */