package com.tencent.mm.plugin.cdndownloader.g;

import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;

public final class a
{
  private static volatile ai edy;
  private static final Object hkZ = new Object();
  
  public static ai DS()
  {
    if (edy == null) {}
    synchronized (hkZ)
    {
      if (edy == null)
      {
        edy = new ai("CDNDownloader#WorkThread");
        g.a("CDNDownloader#WorkThread", new h(edy.mnU.getLooper(), "CDNDownloader#WorkThread"));
      }
      return edy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.g.a
 * JD-Core Version:    0.7.0.1
 */