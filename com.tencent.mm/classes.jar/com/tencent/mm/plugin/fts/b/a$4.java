package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;

final class a$4
  implements j.a
{
  a$4(a parama) {}
  
  public final void a(String paramString, l paraml)
  {
    paramString = paramString.split(" ");
    if ((paramString == null) || (paramString.length == 0)) {}
    while (!paramString[0].equals("update")) {
      return;
    }
    int i = 1;
    while (i < paramString.length)
    {
      long l = bk.getLong(paramString[i], 0L);
      a.e(this.kyt).a(65554, new a.v(this.kyt, l));
      i += 1;
    }
    a.e(this.kyt).a(65556, new a.u(this.kyt, (byte)0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.4
 * JD-Core Version:    0.7.0.1
 */