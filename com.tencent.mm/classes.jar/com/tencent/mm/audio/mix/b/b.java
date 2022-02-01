package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.c;
import java.util.ArrayList;

public class b
{
  private static b ddn;
  private volatile int count;
  public volatile ArrayList<c> ddo;
  private long ddp;
  
  private b()
  {
    AppMethodBeat.i(182541);
    this.ddo = new ArrayList();
    this.ddp = 50L;
    this.count = 0;
    AppMethodBeat.o(182541);
  }
  
  public static b Om()
  {
    AppMethodBeat.i(182542);
    if (ddn == null) {}
    try
    {
      if (ddn == null) {
        ddn = new b();
      }
      b localb = ddn;
      AppMethodBeat.o(182542);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(182542);
    }
  }
  
  public final c On()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182543);
        c localc1;
        if (this.ddo.size() > 0)
        {
          localc1 = (c)this.ddo.remove(this.ddo.size() - 1);
          AppMethodBeat.o(182543);
          return localc1;
        }
        if (this.count >= this.ddp)
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioOutputMixBufferPool", "size >= FIX_SIZE, size:%d", new Object[] { Integer.valueOf(this.count) });
          localc1 = null;
          AppMethodBeat.o(182543);
          continue;
        }
        this.count += 1;
      }
      finally {}
      c localc2 = new c();
      AppMethodBeat.o(182543);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.b
 * JD-Core Version:    0.7.0.1
 */