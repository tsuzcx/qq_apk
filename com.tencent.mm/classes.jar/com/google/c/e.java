package com.google.c;

import com.google.c.d.d;
import com.google.c.d.f;
import com.google.c.d.h;
import com.google.c.d.j;
import com.google.c.d.k;
import com.google.c.d.m;
import com.google.c.d.p;
import com.google.c.d.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class e
  implements g
{
  public final com.google.c.b.b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(12285);
    Object localObject;
    switch (1.bRB[parama.ordinal()])
    {
    default: 
      paramString = new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(parama)));
      AppMethodBeat.o(12285);
      throw paramString;
    case 1: 
      localObject = new k();
    }
    for (;;)
    {
      paramString = ((g)localObject).a(paramString, parama, paramInt1, paramInt2, paramMap);
      AppMethodBeat.o(12285);
      return paramString;
      localObject = new t();
      continue;
      localObject = new j();
      continue;
      localObject = new p();
      continue;
      localObject = new com.google.c.f.a();
      continue;
      localObject = new f();
      continue;
      localObject = new h();
      continue;
      localObject = new d();
      continue;
      localObject = new m();
      continue;
      localObject = new com.google.c.e.a();
      continue;
      localObject = new com.google.c.d.b();
      continue;
      localObject = new com.google.c.c.a();
      continue;
      localObject = new com.google.c.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.e
 * JD-Core Version:    0.7.0.1
 */