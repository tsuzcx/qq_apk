package com.tencent.mm.as.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.as.a.c.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  implements f
{
  public final String mt(String paramString)
  {
    String str = null;
    if (!bk.bl(paramString))
    {
      str = g.o(paramString.getBytes());
      y.d("MicroMsg.imageloader.DefaultImageFileNameCreator", "[cpan] create image file name :%s", new Object[] { str });
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.as.a.b.d
 * JD-Core Version:    0.7.0.1
 */