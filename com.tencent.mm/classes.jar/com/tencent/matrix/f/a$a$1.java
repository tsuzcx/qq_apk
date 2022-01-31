package com.tencent.matrix.f;

import java.util.Map;

final class a$a$1
  implements a.c
{
  a$a$1(a.a parama, Map paramMap) {}
  
  public final void a(a.e parame)
  {
    a.e locale = (a.e)this.bQF.get(Long.valueOf(parame.tid));
    parame.name = parame.name.replaceAll("-?[0-9]\\d*", "?");
    if (locale != null) {
      if (parame.tid != a.a.a(this.bQG)) {
        break label69;
      }
    }
    label69:
    String str;
    for (parame.name = "main";; locale.name = str)
    {
      parame.stack = locale.stack;
      return;
      str = locale.name.replaceAll("-?[0-9]\\d*", "?");
      parame.name = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.matrix.f.a.a.1
 * JD-Core Version:    0.7.0.1
 */