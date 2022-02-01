package com.tencent.mm.plugin.appbrand.media.record;

import android.media.MediaRecorder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.b.a;
import com.tencent.mm.audio.b.b.b;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  private static b lVB = null;
  private static String lVC = null;
  private static a lVD = null;
  private static aw lVE = null;
  
  public static boolean a(String paramString, a parama, int paramInt)
  {
    AppMethodBeat.i(146138);
    ae.i("MicroMsg.Record.AudioRecorder", "startRecord");
    uE(1);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.Record.AudioRecorder", "startRecord, path is null or nil");
      AppMethodBeat.o(146138);
      return false;
    }
    b localb = new b(c.a.fXI);
    lVB = localb;
    if (localb.dhx == c.a.fXH) {
      if (localb.dhv != null) {
        localb.dhv.reset();
      }
    }
    for (;;)
    {
      lVB.PI();
      lVB.PJ();
      lVB.PH();
      lVB.setOutputFile(paramString);
      lVB.a(new b.a()
      {
        public final void onError()
        {
          AppMethodBeat.i(146136);
          ae.e("MicroMsg.Record.AudioRecorder", "onError");
          a.uE(-1);
          AppMethodBeat.o(146136);
        }
      });
      try
      {
        lVB.prepare();
        lVB.start();
        lVD = parama;
        lVC = paramString;
        long l = paramInt;
        stopTimer();
        paramString = new aw(new a.1(), false);
        lVE = paramString;
        paramString.ay(l, l);
        AppMethodBeat.o(146138);
        return true;
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.Record.AudioRecorder", "record prepare, exp = %s", new Object[] { bu.o(paramString) });
        AppMethodBeat.o(146138);
      }
      if (localb.dhy != b.b.dhK)
      {
        localb.release();
        localb.PK();
      }
    }
    return false;
  }
  
  private static void stopTimer()
  {
    AppMethodBeat.i(146137);
    if (lVE != null) {
      lVE.stopTimer();
    }
    lVE = null;
    AppMethodBeat.o(146137);
  }
  
  public static void uE(int paramInt)
  {
    AppMethodBeat.i(146139);
    ae.i("MicroMsg.Record.AudioRecorder", "stopRecord what:%d", new Object[] { Integer.valueOf(paramInt) });
    if (bu.isNullOrNil(lVC))
    {
      AppMethodBeat.o(146139);
      return;
    }
    if (lVB == null)
    {
      ae.i("MicroMsg.Record.AudioRecorder", "sRecorder is null,err");
      AppMethodBeat.o(146139);
      return;
    }
    lVB.GB();
    lVB.release();
    lVB = null;
    stopTimer();
    lVC = null;
    if (lVD != null) {
      lVD.sQ(paramInt);
    }
    lVD = null;
    AppMethodBeat.o(146139);
  }
  
  public static abstract interface a
  {
    public abstract void sQ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a
 * JD-Core Version:    0.7.0.1
 */