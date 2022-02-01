package com.tencent.mm.b;

import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class r
{
  public static String a(o paramo, boolean paramBoolean, String paramString)
  {
    s.nz(aa.z(paramo.mUri), paramString);
    if (paramBoolean) {
      s.dy(aa.z(paramo.mUri), true);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.b.r
 * JD-Core Version:    0.7.0.1
 */