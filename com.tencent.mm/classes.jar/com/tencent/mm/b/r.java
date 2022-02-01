package com.tencent.mm.b;

import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;

public final class r
{
  public static String a(k paramk, boolean paramBoolean, String paramString)
  {
    o.mI(w.B(paramk.mUri), paramString);
    if (paramBoolean) {
      o.dd(w.B(paramk.mUri), true);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.b.r
 * JD-Core Version:    0.7.0.1
 */