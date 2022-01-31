package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.f.b.c.a;
import java.util.ArrayList;
import java.util.Iterator;

final class a$1
  implements c.a
{
  a$1(a parama) {}
  
  public final void aU(int paramInt1, int paramInt2)
  {
    if (a.i(this.jOW) != null)
    {
      Iterator localIterator = a.i(this.jOW).iterator();
      while (localIterator.hasNext())
      {
        c.a locala = (c.a)localIterator.next();
        if (locala != null) {
          locala.aU(paramInt1, paramInt2);
        }
      }
    }
  }
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    if (a.i(this.jOW) != null)
    {
      Iterator localIterator = a.i(this.jOW).iterator();
      while (localIterator.hasNext())
      {
        c.a locala = (c.a)localIterator.next();
        if (locala != null) {
          locala.r(paramArrayOfByte, paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.a.1
 * JD-Core Version:    0.7.0.1
 */