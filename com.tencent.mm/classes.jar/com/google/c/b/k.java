package com.google.c.b;

import com.google.c.b.a.n;
import com.google.c.d.a;
import com.google.c.d.c;
import com.google.c.d.d;
import com.google.c.i;
import com.google.c.j;
import com.google.c.p;
import com.google.c.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;

public final class k
{
  public static void a(i parami, c paramc)
  {
    AppMethodBeat.i(107940);
    n.dHH.a(paramc, parami);
    AppMethodBeat.o(107940);
  }
  
  public static i c(a parama)
  {
    AppMethodBeat.i(208808);
    int i = 1;
    try
    {
      parama.Zh();
      i = 0;
      parama = (i)n.dHH.a(parama);
      AppMethodBeat.o(208808);
      return parama;
    }
    catch (EOFException parama)
    {
      if (i != 0)
      {
        parama = com.google.c.k.dEU;
        AppMethodBeat.o(208808);
        return parama;
      }
      parama = new p(parama);
      AppMethodBeat.o(208808);
      throw parama;
    }
    catch (d parama)
    {
      parama = new p(parama);
      AppMethodBeat.o(208808);
      throw parama;
    }
    catch (IOException parama)
    {
      parama = new j(parama);
      AppMethodBeat.o(208808);
      throw parama;
    }
    catch (NumberFormatException parama)
    {
      parama = new p(parama);
      AppMethodBeat.o(208808);
      throw parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.b.k
 * JD-Core Version:    0.7.0.1
 */