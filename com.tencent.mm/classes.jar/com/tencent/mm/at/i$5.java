package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class i$5
  implements ap.a
{
  i$5(i parami) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(78289);
    try
    {
      i.e(this.fFd);
      AppMethodBeat.o(78289);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ImgService", "exception:%s", new Object[] { bo.l(localException) });
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(78290);
    String str = super.toString() + "|scenePusher";
    AppMethodBeat.o(78290);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.i.5
 * JD-Core Version:    0.7.0.1
 */