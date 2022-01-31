package com.tencent.mm.modelstat;

import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

final class e$c
{
  WifiManager bci;
  int eCN = 0;
  int eDo = 0;
  boolean eDp = false;
  List<String> eDq = new ArrayList();
  long startTime = 0L;
  Thread thread = com.tencent.mm.sdk.f.e.b(new e.c.1(this), "MicroMsg.IndoorReporter_WIFI_Scan");
  
  e$c(e parame) {}
  
  public final String Rr()
  {
    this.eDp = false;
    try
    {
      if ((this.thread != null) && (this.thread.isAlive())) {
        this.thread.join(500L);
      }
      String str = this.eDq.size() + ";#";
      int i = 0;
      while (i < this.eDq.size())
      {
        str = str + (String)this.eDq.get(i) + "#";
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", new Object[] { localException.getMessage() });
      }
      return localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.c
 * JD-Core Version:    0.7.0.1
 */