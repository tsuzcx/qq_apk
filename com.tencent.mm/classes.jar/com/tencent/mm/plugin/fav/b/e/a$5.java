package com.tencent.mm.plugin.fav.b.e;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$5
  implements am.a
{
  a$5(a parama) {}
  
  public final boolean tC()
  {
    try
    {
      this.kaG.Om();
      return false;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Fav.FavCdnService", localException, "", new Object[0]);
    }
    return false;
  }
  
  public final String toString()
  {
    return super.toString() + "|scenePusher";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.a.5
 * JD-Core Version:    0.7.0.1
 */