package com.google.a;

import java.io.IOException;

public final class i$b
  extends IOException
{
  i$b()
  {
    super("CodedOutputStream was writing to a flat byte array and ran out of space.");
  }
  
  i$b(String paramString, Throwable paramThrowable)
  {
    super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(paramString)), paramThrowable);
  }
  
  i$b(Throwable paramThrowable)
  {
    super("CodedOutputStream was writing to a flat byte array and ran out of space.", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.i.b
 * JD-Core Version:    0.7.0.1
 */