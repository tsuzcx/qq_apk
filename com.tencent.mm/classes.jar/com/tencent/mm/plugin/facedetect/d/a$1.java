package com.tencent.mm.plugin.facedetect.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import java.util.ArrayList;
import java.util.Iterator;

final class a$1
  implements c.a
{
  a$1(a parama) {}
  
  public final void bS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284);
    if (a.i(this.mjm) != null)
    {
      Iterator localIterator = a.i(this.mjm).iterator();
      while (localIterator.hasNext())
      {
        c.a locala = (c.a)localIterator.next();
        if (locala != null) {
          locala.bS(paramInt1, paramInt2);
        }
      }
    }
    AppMethodBeat.o(284);
  }
  
  public final void s(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(283);
    if (a.i(this.mjm) != null)
    {
      Iterator localIterator = a.i(this.mjm).iterator();
      while (localIterator.hasNext())
      {
        c.a locala = (c.a)localIterator.next();
        if (locala != null) {
          locala.s(paramArrayOfByte, paramInt);
        }
      }
    }
    AppMethodBeat.o(283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.a.1
 * JD-Core Version:    0.7.0.1
 */