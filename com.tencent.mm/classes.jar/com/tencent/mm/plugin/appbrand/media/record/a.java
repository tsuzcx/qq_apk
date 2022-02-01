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
  private static b ndc = null;
  private static String ndd = null;
  private static a.a nde = null;
  private static MTimerHandler ndf = null;
  
  public static boolean a(String paramString, a.a parama, int paramInt)
  {
    AppMethodBeat.i(146138);
    Log.i("MicroMsg.Record.AudioRecorder", "startRecord");
    yv(1);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.Record.AudioRecorder", "startRecord, path is null or nil");
      AppMethodBeat.o(146138);
      return false;
    }
    b localb = new b(c.a.gCO);
    ndc = localb;
    if (localb.dyJ == c.a.gCN) {
      if (localb.dyH != null) {
        localb.dyH.reset();
      }
    }
    for (;;)
    {
      ndc.aac();
      ndc.aad();
      ndc.aab();
      ndc.setOutputFile(paramString);
      ndc.a(new a.2());
      try
      {
        ndc.prepare();
        ndc.start();
        nde = parama;
        ndd = paramString;
        long l = paramInt;
        stopTimer();
        paramString = new MTimerHandler(new a.1(), false);
        ndf = paramString;
        paramString.startTimer(l);
        AppMethodBeat.o(146138);
        return true;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.Record.AudioRecorder", "record prepare, exp = %s", new Object[] { Util.stackTraceToString(paramString) });
        AppMethodBeat.o(146138);
      }
      if (localb.dyK != b.b.dyW)
      {
        localb.release();
        localb.aae();
      }
    }
    return false;
  }
  
  private static void stopTimer()
  {
    AppMethodBeat.i(146137);
    if (ndf != null) {
      ndf.stopTimer();
    }
    ndf = null;
    AppMethodBeat.o(146137);
  }
  
  public static void yv(int paramInt)
  {
    AppMethodBeat.i(146139);
    Log.i("MicroMsg.Record.AudioRecorder", "stopRecord what:%d", new Object[] { Integer.valueOf(paramInt) });
    if (Util.isNullOrNil(ndd))
    {
      AppMethodBeat.o(146139);
      return;
    }
    if (ndc == null)
    {
      Log.i("MicroMsg.Record.AudioRecorder", "sRecorder is null,err");
      AppMethodBeat.o(146139);
      return;
    }
    ndc.Qt();
    ndc.release();
    ndc = null;
    stopTimer();
    ndd = null;
    if (nde != null) {
      nde.wM(paramInt);
    }
    nde = null;
    AppMethodBeat.o(146139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a
 * JD-Core Version:    0.7.0.1
 */