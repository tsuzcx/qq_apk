package com.tencent.magicbrush.handler.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 enum b
{
  private static int bLf;
  ExecutorService bLg;
  
  static
  {
    AppMethodBeat.i(115983);
    bLe = new b("INSTANCE");
    bLh = new b[] { bLe };
    bLf = Runtime.getRuntime().availableProcessors() + 1;
    AppMethodBeat.o(115983);
  }
  
  private b()
  {
    AppMethodBeat.i(115982);
    this.bLg = null;
    this.bLg = Executors.newFixedThreadPool(Math.max(bLf, 5));
    AppMethodBeat.o(115982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.image.b
 * JD-Core Version:    0.7.0.1
 */