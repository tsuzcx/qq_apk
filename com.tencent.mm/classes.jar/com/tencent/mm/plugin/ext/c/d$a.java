package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

public final class d$a
  implements d.c
{
  public final d.b az(String paramString, boolean paramBoolean)
  {
    if (!e.bK(paramString))
    {
      y.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: handle not exist");
      return null;
    }
    return d.c(e.c(paramString, 0, -1), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.d.a
 * JD-Core Version:    0.7.0.1
 */