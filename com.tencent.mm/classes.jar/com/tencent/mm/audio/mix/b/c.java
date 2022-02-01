package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import java.util.ArrayList;

public class c
{
  private static c duj;
  private volatile int count;
  public volatile ArrayList<com.tencent.mm.audio.mix.a.c> duk;
  private long dul;
  
  private c()
  {
    AppMethodBeat.i(182541);
    this.duk = new ArrayList();
    this.dul = 50L;
    this.count = 0;
    AppMethodBeat.o(182541);
  }
  
  public static c YF()
  {
    AppMethodBeat.i(182542);
    if (duj == null) {}
    try
    {
      if (duj == null) {
        duj = new c();
      }
      c localc = duj;
      AppMethodBeat.o(182542);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(182542);
    }
  }
  
  public final com.tencent.mm.audio.mix.a.c YG()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182543);
        com.tencent.mm.audio.mix.a.c localc1;
        if (this.duk.size() > 0)
        {
          localc1 = (com.tencent.mm.audio.mix.a.c)this.duk.remove(this.duk.size() - 1);
          AppMethodBeat.o(182543);
          return localc1;
        }
        if (this.count >= this.dul)
        {
          b.e("MicroMsg.Mix.AudioOutputMixBufferPool", "size >= FIX_SIZE, size:%d", new Object[] { Integer.valueOf(this.count) });
          localc1 = null;
          AppMethodBeat.o(182543);
          continue;
        }
        this.count += 1;
      }
      finally {}
      com.tencent.mm.audio.mix.a.c localc2 = new com.tencent.mm.audio.mix.a.c();
      AppMethodBeat.o(182543);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.c
 * JD-Core Version:    0.7.0.1
 */