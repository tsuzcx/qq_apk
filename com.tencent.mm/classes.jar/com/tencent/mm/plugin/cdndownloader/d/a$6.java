package com.tencent.mm.plugin.cdndownloader.d;

import com.tencent.mm.sdk.platformtools.y;

final class a$6
  implements Runnable
{
  a$6(a parama) {}
  
  public final void run()
  {
    synchronized ()
    {
      y.i("MicroMsg.CDNDownloadClient", "queryDownloadTaskSync, notify after 10000ms");
      a.Tb().notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.d.a.6
 * JD-Core Version:    0.7.0.1
 */