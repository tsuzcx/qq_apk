package com.tencent.luggage.game.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public static void a(a.a parama, Runnable paramRunnable)
  {
    AppMethodBeat.i(140553);
    if (parama == null)
    {
      parama = new IllegalStateException();
      AppMethodBeat.o(140553);
      throw parama;
    }
    if (parama.done)
    {
      AppMethodBeat.o(140553);
      return;
    }
    int i = 0;
    try
    {
      if (!parama.done)
      {
        i = 1;
        parama.done = true;
      }
      if (i != 0) {
        paramRunnable.run();
      }
      AppMethodBeat.o(140553);
      return;
    }
    finally
    {
      AppMethodBeat.o(140553);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.g.a
 * JD-Core Version:    0.7.0.1
 */