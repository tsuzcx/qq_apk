package com.tencent.mm.modelimage.loader.impr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  implements com.tencent.mm.modelimage.loader.b.g
{
  public final String Ou(String paramString)
  {
    AppMethodBeat.i(130413);
    String str = null;
    if (!Util.isNullOrNil(paramString))
    {
      str = com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
      Log.d("MicroMsg.imageloader.DefaultImageFileNameCreator", "[cpan] create image file name :%s", new Object[] { str });
    }
    AppMethodBeat.o(130413);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.impr.d
 * JD-Core Version:    0.7.0.1
 */