package com.google.d.a;

import java.io.IOException;

public final class b$a
  extends IOException
{
  b$a(int paramInt1, int paramInt2)
  {
    super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + paramInt1 + " limit " + paramInt2 + ").");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.d.a.b.a
 * JD-Core Version:    0.7.0.1
 */