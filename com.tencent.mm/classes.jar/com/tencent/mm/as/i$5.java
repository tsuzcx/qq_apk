package com.tencent.mm.as;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class i$5
  implements am.a
{
  i$5(i parami) {}
  
  public final boolean tC()
  {
    try
    {
      i.e(this.eoG);
      return false;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ImgService", "exception:%s", new Object[] { bk.j(localException) });
    }
    return false;
  }
  
  public final String toString()
  {
    return super.toString() + "|scenePusher";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.as.i.5
 * JD-Core Version:    0.7.0.1
 */