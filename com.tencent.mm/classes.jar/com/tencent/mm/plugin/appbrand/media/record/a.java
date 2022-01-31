package com.tencent.mm.plugin.appbrand.media.record;

import android.media.MediaRecorder;
import com.tencent.mm.compatible.b.b.a;
import com.tencent.mm.f.b.b;
import com.tencent.mm.f.b.b.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  private static b gNk = null;
  private static String gNl = null;
  private static a gNm = null;
  private static am gNn = null;
  
  public static boolean a(String paramString, a parama, int paramInt)
  {
    y.i("MicroMsg.Record.AudioRecorder", "startRecord");
    lS(1);
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.Record.AudioRecorder", "startRecord, path is null or nil");
      return false;
    }
    b localb = new b(b.a.duc);
    gNk = localb;
    if (localb.bCd == b.a.dub) {
      if (localb.bCb != null) {
        localb.bCb.reset();
      }
    }
    for (;;)
    {
      gNk.uk();
      gNk.ul();
      gNk.uj();
      gNk.setOutputFile(paramString);
      gNk.a(new a.2());
      try
      {
        gNk.prepare();
        gNk.start();
        gNm = parama;
        gNl = paramString;
        long l = paramInt;
        stopTimer();
        paramString = new am(new a.1(), false);
        gNn = paramString;
        paramString.S(l, l);
        return true;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.Record.AudioRecorder", "record prepare, exp = %s", new Object[] { bk.j(paramString) });
      }
      if (localb.bCe != b.b.bCq)
      {
        localb.release();
        localb.um();
      }
    }
    return false;
  }
  
  public static void lS(int paramInt)
  {
    y.i("MicroMsg.Record.AudioRecorder", "stopRecord what:%d", new Object[] { Integer.valueOf(paramInt) });
    if (bk.bl(gNl)) {
      return;
    }
    if (gNk == null)
    {
      y.i("MicroMsg.Record.AudioRecorder", "sRecorder is null,err");
      return;
    }
    gNk.un();
    gNk.release();
    gNk = null;
    stopTimer();
    gNl = null;
    if (gNm != null) {
      gNm.li(paramInt);
    }
    gNm = null;
  }
  
  private static void stopTimer()
  {
    if (gNn != null) {
      gNn.stopTimer();
    }
    gNn = null;
  }
  
  public static abstract interface a
  {
    public abstract void li(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a
 * JD-Core Version:    0.7.0.1
 */