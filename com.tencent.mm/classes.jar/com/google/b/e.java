package com.google.b;

import com.google.b.d.d;
import com.google.b.d.f;
import com.google.b.d.h;
import com.google.b.d.j;
import com.google.b.d.k;
import com.google.b.d.m;
import com.google.b.d.p;
import com.google.b.d.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class e
  implements g
{
  public final com.google.b.b.b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(57220);
    Object localObject;
    switch (e.1.bhL[parama.ordinal()])
    {
    default: 
      paramString = new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(parama)));
      AppMethodBeat.o(57220);
      throw paramString;
    case 1: 
      localObject = new k();
    }
    for (;;)
    {
      paramString = ((g)localObject).a(paramString, parama, paramInt1, paramInt2, paramMap);
      AppMethodBeat.o(57220);
      return paramString;
      localObject = new t();
      continue;
      localObject = new j();
      continue;
      localObject = new p();
      continue;
      localObject = new com.google.b.f.a();
      continue;
      localObject = new f();
      continue;
      localObject = new h();
      continue;
      localObject = new d();
      continue;
      localObject = new m();
      continue;
      localObject = new com.google.b.e.a();
      continue;
      localObject = new com.google.b.d.b();
      continue;
      localObject = new com.google.b.c.a();
      continue;
      localObject = new com.google.b.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.b.e
 * JD-Core Version:    0.7.0.1
 */