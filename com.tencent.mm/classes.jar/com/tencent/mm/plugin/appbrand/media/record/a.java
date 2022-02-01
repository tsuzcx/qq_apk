package com.tencent.mm.plugin.appbrand.media.record;

import android.media.MediaRecorder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.b.b;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
{
  private static b lrQ = null;
  private static String lrR = null;
  private static a.a lrS = null;
  private static au lrT = null;
  
  public static boolean a(String paramString, a.a parama, int paramInt)
  {
    AppMethodBeat.i(146138);
    ac.i("MicroMsg.Record.AudioRecorder", "startRecord");
    tU(1);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.Record.AudioRecorder", "startRecord, path is null or nil");
      AppMethodBeat.o(146138);
      return false;
    }
    b localb = new b(c.a.fCo);
    lrQ = localb;
    if (localb.cVf == c.a.fCn) {
      if (localb.cVd != null) {
        localb.cVd.reset();
      }
    }
    for (;;)
    {
      lrQ.Oa();
      lrQ.Ob();
      lrQ.NZ();
      lrQ.setOutputFile(paramString);
      lrQ.a(new a.2());
      try
      {
        lrQ.prepare();
        lrQ.start();
        lrS = parama;
        lrR = paramString;
        long l = paramInt;
        stopTimer();
        paramString = new au(new a.1(), false);
        lrT = paramString;
        paramString.au(l, l);
        AppMethodBeat.o(146138);
        return true;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.Record.AudioRecorder", "record prepare, exp = %s", new Object[] { bs.m(paramString) });
        AppMethodBeat.o(146138);
      }
      if (localb.cVg != b.b.cVs)
      {
        localb.release();
        localb.Oc();
      }
    }
    return false;
  }
  
  private static void stopTimer()
  {
    AppMethodBeat.i(146137);
    if (lrT != null) {
      lrT.stopTimer();
    }
    lrT = null;
    AppMethodBeat.o(146137);
  }
  
  public static void tU(int paramInt)
  {
    AppMethodBeat.i(146139);
    ac.i("MicroMsg.Record.AudioRecorder", "stopRecord what:%d", new Object[] { Integer.valueOf(paramInt) });
    if (bs.isNullOrNil(lrR))
    {
      AppMethodBeat.o(146139);
      return;
    }
    if (lrQ == null)
    {
      ac.i("MicroMsg.Record.AudioRecorder", "sRecorder is null,err");
      AppMethodBeat.o(146139);
      return;
    }
    lrQ.Fb();
    lrQ.release();
    lrQ = null;
    stopTimer();
    lrR = null;
    if (lrS != null) {
      lrS.sl(paramInt);
    }
    lrS = null;
    AppMethodBeat.o(146139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a
 * JD-Core Version:    0.7.0.1
 */