package com.tencent.mm.plugin.appbrand.media.record;

import android.media.MediaRecorder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.b.a;
import com.tencent.mm.audio.b.b.b;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  private static b lRa = null;
  private static String lRb = null;
  private static a lRc = null;
  private static av lRd = null;
  
  public static boolean a(String paramString, a parama, int paramInt)
  {
    AppMethodBeat.i(146138);
    ad.i("MicroMsg.Record.AudioRecorder", "startRecord");
    uy(1);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.Record.AudioRecorder", "startRecord, path is null or nil");
      AppMethodBeat.o(146138);
      return false;
    }
    b localb = new b(c.a.fVC);
    lRa = localb;
    if (localb.dgv == c.a.fVB) {
      if (localb.dgt != null) {
        localb.dgt.reset();
      }
    }
    for (;;)
    {
      lRa.PJ();
      lRa.PK();
      lRa.PI();
      lRa.setOutputFile(paramString);
      lRa.a(new b.a()
      {
        public final void onError()
        {
          AppMethodBeat.i(146136);
          ad.e("MicroMsg.Record.AudioRecorder", "onError");
          a.uy(-1);
          AppMethodBeat.o(146136);
        }
      });
      try
      {
        lRa.prepare();
        lRa.start();
        lRc = parama;
        lRb = paramString;
        long l = paramInt;
        stopTimer();
        paramString = new av(new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(146135);
            a.uy(1);
            AppMethodBeat.o(146135);
            return false;
          }
        }, false);
        lRd = paramString;
        paramString.az(l, l);
        AppMethodBeat.o(146138);
        return true;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.Record.AudioRecorder", "record prepare, exp = %s", new Object[] { bt.n(paramString) });
        AppMethodBeat.o(146138);
      }
      if (localb.dgw != b.b.dgI)
      {
        localb.release();
        localb.PL();
      }
    }
    return false;
  }
  
  private static void stopTimer()
  {
    AppMethodBeat.i(146137);
    if (lRd != null) {
      lRd.stopTimer();
    }
    lRd = null;
    AppMethodBeat.o(146137);
  }
  
  public static void uy(int paramInt)
  {
    AppMethodBeat.i(146139);
    ad.i("MicroMsg.Record.AudioRecorder", "stopRecord what:%d", new Object[] { Integer.valueOf(paramInt) });
    if (bt.isNullOrNil(lRb))
    {
      AppMethodBeat.o(146139);
      return;
    }
    if (lRa == null)
    {
      ad.i("MicroMsg.Record.AudioRecorder", "sRecorder is null,err");
      AppMethodBeat.o(146139);
      return;
    }
    lRa.Gv();
    lRa.release();
    lRa = null;
    stopTimer();
    lRb = null;
    if (lRc != null) {
      lRc.sN(paramInt);
    }
    lRc = null;
    AppMethodBeat.o(146139);
  }
  
  public static abstract interface a
  {
    public abstract void sN(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a
 * JD-Core Version:    0.7.0.1
 */