package com.tencent.mm.plugin.appbrand.media.record;

import android.media.MediaRecorder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.audio.b.b.b;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  private static b kQr = null;
  private static String kQs = null;
  private static a.a kQt = null;
  private static av kQu = null;
  
  public static boolean a(String paramString, a.a parama, int paramInt)
  {
    AppMethodBeat.i(146138);
    ad.i("MicroMsg.Record.AudioRecorder", "startRecord");
    td(1);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.Record.AudioRecorder", "startRecord, path is null or nil");
      AppMethodBeat.o(146138);
      return false;
    }
    b localb = new b(c.a.fyH);
    kQr = localb;
    if (localb.cXJ == c.a.fyG) {
      if (localb.cXH != null) {
        localb.cXH.reset();
      }
    }
    for (;;)
    {
      kQr.Oe();
      kQr.Of();
      kQr.Od();
      kQr.setOutputFile(paramString);
      kQr.a(new a.2());
      try
      {
        kQr.prepare();
        kQr.start();
        kQt = parama;
        kQs = paramString;
        long l = paramInt;
        stopTimer();
        paramString = new av(new a.1(), false);
        kQu = paramString;
        paramString.av(l, l);
        AppMethodBeat.o(146138);
        return true;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.Record.AudioRecorder", "record prepare, exp = %s", new Object[] { bt.m(paramString) });
        AppMethodBeat.o(146138);
      }
      if (localb.cXK != b.b.cXW)
      {
        localb.release();
        localb.Og();
      }
    }
    return false;
  }
  
  private static void stopTimer()
  {
    AppMethodBeat.i(146137);
    if (kQu != null) {
      kQu.stopTimer();
    }
    kQu = null;
    AppMethodBeat.o(146137);
  }
  
  public static void td(int paramInt)
  {
    AppMethodBeat.i(146139);
    ad.i("MicroMsg.Record.AudioRecorder", "stopRecord what:%d", new Object[] { Integer.valueOf(paramInt) });
    if (bt.isNullOrNil(kQs))
    {
      AppMethodBeat.o(146139);
      return;
    }
    if (kQr == null)
    {
      ad.i("MicroMsg.Record.AudioRecorder", "sRecorder is null,err");
      AppMethodBeat.o(146139);
      return;
    }
    kQr.Ft();
    kQr.release();
    kQr = null;
    stopTimer();
    kQs = null;
    if (kQt != null) {
      kQt.rw(paramInt);
    }
    kQt = null;
    AppMethodBeat.o(146139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a
 * JD-Core Version:    0.7.0.1
 */