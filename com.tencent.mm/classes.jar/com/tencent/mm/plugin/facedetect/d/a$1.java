package com.tencent.mm.plugin.facedetect.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import java.util.ArrayList;
import java.util.Iterator;

final class a$1
  implements c.a
{
  a$1(a parama) {}
  
  public final void cf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103803);
    if (a.i(this.qyF) != null)
    {
      Iterator localIterator = a.i(this.qyF).iterator();
      while (localIterator.hasNext())
      {
        c.a locala = (c.a)localIterator.next();
        if (locala != null) {
          locala.cf(paramInt1, paramInt2);
        }
      }
    }
    AppMethodBeat.o(103803);
  }
  
  public final void u(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(103802);
    if (a.i(this.qyF) != null)
    {
      Iterator localIterator = a.i(this.qyF).iterator();
      while (localIterator.hasNext())
      {
        c.a locala = (c.a)localIterator.next();
        if (locala != null) {
          locala.u(paramArrayOfByte, paramInt);
        }
      }
    }
    AppMethodBeat.o(103802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.a.1
 * JD-Core Version:    0.7.0.1
 */