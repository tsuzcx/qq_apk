package com.tencent.mm.modelstat;

import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

final class e$c
{
  WifiManager bsO;
  int fSE;
  int fTf;
  boolean fTg;
  List<String> fTh;
  long startTime;
  Thread thread;
  
  e$c(e parame)
  {
    AppMethodBeat.i(78724);
    this.fTf = 0;
    this.fSE = 0;
    this.fTg = false;
    this.startTime = 0L;
    this.fTh = new ArrayList();
    this.thread = d.h(new e.c.1(this), "MicroMsg.IndoorReporter_WIFI_Scan");
    AppMethodBeat.o(78724);
  }
  
  public final String akA()
  {
    AppMethodBeat.i(78725);
    this.fTg = false;
    try
    {
      if ((this.thread != null) && (this.thread.isAlive())) {
        this.thread.join(500L);
      }
      String str = this.fTh.size() + ";#";
      int i = 0;
      while (i < this.fTh.size())
      {
        str = str + (String)this.fTh.get(i) + "#";
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", new Object[] { localException.getMessage() });
      }
      AppMethodBeat.o(78725);
      return localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.c
 * JD-Core Version:    0.7.0.1
 */