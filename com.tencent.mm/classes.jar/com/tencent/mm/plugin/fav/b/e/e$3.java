package com.tencent.mm.plugin.fav.b.e;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$3
  implements am.a
{
  e$3(e parame) {}
  
  public final boolean tC()
  {
    try
    {
      e.d(this.kaR);
      return false;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Fav.FavSendService", localException, "", new Object[0]);
    }
    return false;
  }
  
  public final String toString()
  {
    return super.toString() + "|scenePusher";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.e.3
 * JD-Core Version:    0.7.0.1
 */