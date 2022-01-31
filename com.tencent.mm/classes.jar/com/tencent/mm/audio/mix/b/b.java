package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import java.util.ArrayList;

public final class b
{
  private static b ceB;
  private ArrayList<d> ceC;
  private long ceD;
  private int count;
  private Object sLock;
  private int size;
  
  private b()
  {
    AppMethodBeat.i(136983);
    this.ceC = new ArrayList();
    this.sLock = new Object();
    this.ceD = 3000000L;
    this.size = 0;
    this.count = 0;
    AppMethodBeat.o(136983);
  }
  
  public static b Da()
  {
    AppMethodBeat.i(136984);
    if (ceB == null) {}
    try
    {
      if (ceB == null) {
        ceB = new b();
      }
      b localb = ceB;
      AppMethodBeat.o(136984);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(136984);
    }
  }
  
  public final d Db()
  {
    AppMethodBeat.i(136985);
    synchronized (this.sLock)
    {
      if (this.ceC.size() > 0)
      {
        d locald = (d)this.ceC.remove(this.ceC.size() - 1);
        AppMethodBeat.o(136985);
        return locald;
      }
      if (this.size >= this.ceD)
      {
        com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "size >= FIX_SIZE, size:%d", new Object[] { Integer.valueOf(this.size) });
        AppMethodBeat.o(136985);
        return null;
      }
      this.count += 1;
      this.size = (this.count * 3536);
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "pool tract count:%d", new Object[] { Integer.valueOf(this.count) });
      ??? = new d();
      ((d)???).cey = true;
      AppMethodBeat.o(136985);
      return ???;
    }
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(136986);
    if ((paramd == null) || (paramd.cem == null))
    {
      AppMethodBeat.o(136986);
      return;
    }
    if (!paramd.cey)
    {
      AppMethodBeat.o(136986);
      return;
    }
    paramd.reset();
    synchronized (this.sLock)
    {
      this.ceC.add(0, paramd);
      AppMethodBeat.o(136986);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.b
 * JD-Core Version:    0.7.0.1
 */