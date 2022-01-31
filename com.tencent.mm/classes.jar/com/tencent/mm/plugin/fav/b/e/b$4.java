package com.tencent.mm.plugin.fav.b.e;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$4
  implements am.a
{
  b$4(b paramb) {}
  
  public final boolean tC()
  {
    try
    {
      b.b(this.kaK);
      return false;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", localException, "", new Object[0]);
    }
    return false;
  }
  
  public final String toString()
  {
    return super.toString() + "|scenePusher";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.b.4
 * JD-Core Version:    0.7.0.1
 */