package com.tencent.mm.plugin.cdndownloader.g;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;

public final class a
{
  private static volatile al ftB;
  private static final Object iXt;
  
  static
  {
    AppMethodBeat.i(965);
    iXt = new Object();
    AppMethodBeat.o(965);
  }
  
  public static al aNS()
  {
    AppMethodBeat.i(964);
    if (ftB == null) {}
    synchronized (iXt)
    {
      if (ftB == null)
      {
        ftB = new al("CDNDownloader#WorkThread");
        g.a("CDNDownloader#WorkThread", new h(ftB.oNc.getLooper(), "CDNDownloader#WorkThread"));
      }
      ??? = ftB;
      AppMethodBeat.o(964);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.g.a
 * JD-Core Version:    0.7.0.1
 */