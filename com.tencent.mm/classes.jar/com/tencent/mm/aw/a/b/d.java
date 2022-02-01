package com.tencent.mm.aw.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  implements com.tencent.mm.aw.a.c.g
{
  public final String FJ(String paramString)
  {
    AppMethodBeat.i(130413);
    String str = null;
    if (!bt.isNullOrNil(paramString))
    {
      str = com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
      ad.d("MicroMsg.imageloader.DefaultImageFileNameCreator", "[cpan] create image file name :%s", new Object[] { str });
    }
    AppMethodBeat.o(130413);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aw.a.b.d
 * JD-Core Version:    0.7.0.1
 */