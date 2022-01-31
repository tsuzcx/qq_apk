package com.tencent.mm.plugin.appbrand.media.record;

import android.media.MediaRecorder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.b.b;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  private static b ipe = null;
  private static String ipf = null;
  private static a ipg = null;
  private static ap iph = null;
  
  public static boolean a(String paramString, a parama, int paramInt)
  {
    AppMethodBeat.i(105585);
    ab.i("MicroMsg.Record.AudioRecorder", "startRecord");
    oO(1);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.Record.AudioRecorder", "startRecord, path is null or nil");
      AppMethodBeat.o(105585);
      return false;
    }
    b localb = new b(c.a.elQ);
    ipe = localb;
    if (localb.ciS == c.a.elP) {
      if (localb.ciQ != null) {
        localb.ciQ.reset();
      }
    }
    for (;;)
    {
      ipe.Ew();
      ipe.Ex();
      ipe.Ev();
      ipe.setOutputFile(paramString);
      ipe.a(new a.2());
      try
      {
        ipe.prepare();
        ipe.start();
        ipg = parama;
        ipf = paramString;
        long l = paramInt;
        stopTimer();
        paramString = new ap(new a.1(), false);
        iph = paramString;
        paramString.ag(l, l);
        AppMethodBeat.o(105585);
        return true;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.Record.AudioRecorder", "record prepare, exp = %s", new Object[] { bo.l(paramString) });
        AppMethodBeat.o(105585);
      }
      if (localb.ciT != b.b.cje)
      {
        localb.release();
        localb.Ey();
      }
    }
    return false;
  }
  
  public static void oO(int paramInt)
  {
    AppMethodBeat.i(105586);
    ab.i("MicroMsg.Record.AudioRecorder", "stopRecord what:%d", new Object[] { Integer.valueOf(paramInt) });
    if (bo.isNullOrNil(ipf))
    {
      AppMethodBeat.o(105586);
      return;
    }
    if (ipe == null)
    {
      ab.i("MicroMsg.Record.AudioRecorder", "sRecorder is null,err");
      AppMethodBeat.o(105586);
      return;
    }
    ipe.Ez();
    ipe.release();
    ipe = null;
    stopTimer();
    ipf = null;
    if (ipg != null) {
      ipg.nR(paramInt);
    }
    ipg = null;
    AppMethodBeat.o(105586);
  }
  
  private static void stopTimer()
  {
    AppMethodBeat.i(105584);
    if (iph != null) {
      iph.stopTimer();
    }
    iph = null;
    AppMethodBeat.o(105584);
  }
  
  public static abstract interface a
  {
    public abstract void nR(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a
 * JD-Core Version:    0.7.0.1
 */