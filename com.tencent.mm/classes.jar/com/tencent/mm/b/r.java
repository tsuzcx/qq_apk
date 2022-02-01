package com.tencent.mm.b;

import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;

public final class r
{
  public static String a(e parame, boolean paramBoolean, String paramString)
  {
    i.mc(q.B(parame.mUri), paramString);
    if (paramBoolean) {
      i.cU(q.B(parame.mUri), true);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.b.r
 * JD-Core Version:    0.7.0.1
 */