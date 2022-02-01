package com.tencent.mm.plugin.appbrand.media.record;

import android.media.MediaRecorder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.b.b;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static b qdr = null;
  private static String qds = null;
  private static a.a qdt = null;
  private static MTimerHandler qdu = null;
  
  public static void BV(int paramInt)
  {
    AppMethodBeat.i(146139);
    Log.i("MicroMsg.Record.AudioRecorder", "stopRecord what:%d", new Object[] { Integer.valueOf(paramInt) });
    if (Util.isNullOrNil(qds))
    {
      AppMethodBeat.o(146139);
      return;
    }
    if (qdr == null)
    {
      Log.i("MicroMsg.Record.AudioRecorder", "sRecorder is null,err");
      AppMethodBeat.o(146139);
      return;
    }
    qdr.TV();
    qdr.release();
    qdr = null;
    stopTimer();
    qds = null;
    if (qdt != null) {
      qdt.Ab(paramInt);
    }
    qdt = null;
    AppMethodBeat.o(146139);
  }
  
  public static boolean a(String paramString, a.a parama, int paramInt)
  {
    AppMethodBeat.i(146138);
    Log.i("MicroMsg.Record.AudioRecorder", "startRecord");
    BV(1);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.Record.AudioRecorder", "startRecord, path is null or nil");
      AppMethodBeat.o(146138);
      return false;
    }
    b localb = new b(c.a.jmU);
    qdr = localb;
    if (localb.fry == c.a.jmT) {
      if (localb.frw != null) {
        localb.frw.reset();
      }
    }
    for (;;)
    {
      qdr.aeN();
      qdr.aeO();
      qdr.aeM();
      qdr.setOutputFile(paramString);
      qdr.a(new a.2());
      try
      {
        qdr.prepare();
        qdr.start();
        qdt = parama;
        qds = paramString;
        long l = paramInt;
        stopTimer();
        paramString = new MTimerHandler(new a.1(), false);
        qdu = paramString;
        paramString.startTimer(l);
        AppMethodBeat.o(146138);
        return true;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.Record.AudioRecorder", "record prepare, exp = %s", new Object[] { Util.stackTraceToString(paramString) });
        AppMethodBeat.o(146138);
      }
      if (localb.frz != b.b.frL)
      {
        localb.release();
        localb.aeP();
      }
    }
    return false;
  }
  
  private static void stopTimer()
  {
    AppMethodBeat.i(146137);
    if (qdu != null) {
      qdu.stopTimer();
    }
    qdu = null;
    AppMethodBeat.o(146137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a
 * JD-Core Version:    0.7.0.1
 */