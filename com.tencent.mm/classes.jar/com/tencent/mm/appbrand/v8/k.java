package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

final class k
{
  public final BlockingDeque<String> cMT;
  public volatile boolean enable;
  
  k()
  {
    AppMethodBeat.i(185102);
    this.enable = false;
    this.cMT = new LinkedBlockingDeque();
    AppMethodBeat.o(185102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.k
 * JD-Core Version:    0.7.0.1
 */