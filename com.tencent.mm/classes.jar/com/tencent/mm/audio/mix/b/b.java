package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.c;
import java.util.ArrayList;

public class b
{
  private static b dcl;
  private volatile int count;
  public volatile ArrayList<c> dcm;
  private long dcn;
  
  private b()
  {
    AppMethodBeat.i(182541);
    this.dcm = new ArrayList();
    this.dcn = 50L;
    this.count = 0;
    AppMethodBeat.o(182541);
  }
  
  public static b Oo()
  {
    AppMethodBeat.i(182542);
    if (dcl == null) {}
    try
    {
      if (dcl == null) {
        dcl = new b();
      }
      b localb = dcl;
      AppMethodBeat.o(182542);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(182542);
    }
  }
  
  public final c Op()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182543);
        c localc1;
        if (this.dcm.size() > 0)
        {
          localc1 = (c)this.dcm.remove(this.dcm.size() - 1);
          AppMethodBeat.o(182543);
          return localc1;
        }
        if (this.count >= this.dcn)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.b
 * JD-Core Version:    0.7.0.1
 */