package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import java.util.HashMap;

final class a$3
  implements j.a
{
  a$3(a parama) {}
  
  public final void a(String paramString, l paraml)
  {
    if ((paramString.equals("*")) || (paramString.equals("chatroomname"))) {}
    while (a.b(this.kyt).containsKey(paramString)) {
      return;
    }
    a.e(this.kyt).a(65556, new a.h(this.kyt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.3
 * JD-Core Version:    0.7.0.1
 */