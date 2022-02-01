package com.google.a.b;

import com.google.a.b.a.n;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import com.google.a.i;
import com.google.a.j;
import com.google.a.p;
import com.google.a.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;

public final class k
{
  public static void a(i parami, c paramc)
  {
    AppMethodBeat.i(107940);
    n.bOc.a(paramc, parami);
    AppMethodBeat.o(107940);
  }
  
  public static i c(a parama)
  {
    AppMethodBeat.i(222657);
    int i = 1;
    try
    {
      parama.zw();
      i = 0;
      parama = (i)n.bOc.a(parama);
      AppMethodBeat.o(222657);
      return parama;
    }
    catch (EOFException parama)
    {
      if (i != 0)
      {
        parama = com.google.a.k.bLm;
        AppMethodBeat.o(222657);
        return parama;
      }
      parama = new p(parama);
      AppMethodBeat.o(222657);
      throw parama;
    }
    catch (d parama)
    {
      parama = new p(parama);
      AppMethodBeat.o(222657);
      throw parama;
    }
    catch (IOException parama)
    {
      parama = new j(parama);
      AppMethodBeat.o(222657);
      throw parama;
    }
    catch (NumberFormatException parama)
    {
      parama = new p(parama);
      AppMethodBeat.o(222657);
      throw parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.k
 * JD-Core Version:    0.7.0.1
 */