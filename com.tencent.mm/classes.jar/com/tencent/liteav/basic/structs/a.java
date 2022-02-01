package com.tencent.liteav.basic.structs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  implements Cloneable
{
  public int a;
  public int b;
  public int c;
  public int d;
  public long e;
  public byte[] f;
  public int g;
  public int h;
  
  public Object clone()
  {
    AppMethodBeat.i(14448);
    try
    {
      a locala = (a)super.clone();
      AppMethodBeat.o(14448);
      return locala;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.structs.a
 * JD-Core Version:    0.7.0.1
 */