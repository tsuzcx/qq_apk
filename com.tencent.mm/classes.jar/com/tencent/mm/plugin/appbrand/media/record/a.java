package com.tencent.mm.plugin.appbrand.media.record;

import android.media.MediaRecorder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.b.c;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static b tig = null;
  private static String tih = null;
  private static a.a tii = null;
  private static MTimerHandler tij = null;
  
  public static void Ck(int paramInt)
  {
    AppMethodBeat.i(146139);
    Log.i("MicroMsg.Record.AudioRecorder", "stopRecord what:%d", new Object[] { Integer.valueOf(paramInt) });
    if (Util.isNullOrNil(tih))
    {
      AppMethodBeat.o(146139);
      return;
    }
    if (tig == null)
    {
      Log.i("MicroMsg.Record.AudioRecorder", "sRecorder is null,err");
      AppMethodBeat.o(146139);
      return;
    }
    tig.stop();
    tig.release();
    tig = null;
    stopTimer();
    tih = null;
    if (tii != null) {
      tii.As(paramInt);
    }
    tii = null;
    AppMethodBeat.o(146139);
  }
  
  public static boolean a(String paramString, a.a parama, int paramInt)
  {
    AppMethodBeat.i(146138);
    Log.i("MicroMsg.Record.AudioRecorder", "startRecord");
    Ck(1);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.Record.AudioRecorder", "startRecord, path is null or nil");
      AppMethodBeat.o(146138);
      return false;
    }
    b localb = new b(c.a.lQf);
    tig = localb;
    if (localb.hvJ == c.a.lQe) {
      if (localb.hvH != null) {
        localb.hvH.reset();
      }
    }
    for (;;)
    {
      tig.aGL();
      tig.aGM();
      tig.aGK();
      tig.setOutputFile(paramString);
      tig.a(new a.2());
      try
      {
        tig.prepare();
        tig.start();
        tii = parama;
        tih = paramString;
        long l = paramInt;
        stopTimer();
        paramString = new MTimerHandler(new a.1(), false);
        tij = paramString;
        paramString.startTimer(l);
        AppMethodBeat.o(146138);
        return true;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.Record.AudioRecorder", "record prepare, exp = %s", new Object[] { Util.stackTraceToString(paramString) });
        AppMethodBeat.o(146138);
      }
      if (localb.hvK != b.c.hvZ)
      {
        localb.release();
        localb.aGN();
      }
    }
    return false;
  }
  
  private static void stopTimer()
  {
    AppMethodBeat.i(146137);
    if (tij != null) {
      tij.stopTimer();
    }
    tij = null;
    AppMethodBeat.o(146137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a
 * JD-Core Version:    0.7.0.1
 */