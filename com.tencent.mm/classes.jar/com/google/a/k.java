package com.google.a;

import com.google.a.d.a;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class k
{
  public boolean getAsBoolean()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new StringWriter();
      a locala = new a((Writer)localObject);
      locala.bNi = true;
      com.google.a.b.k.a(this, locala);
      localObject = ((StringWriter)localObject).toString();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
  
  public Number yx()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String yy()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public final p yz()
  {
    if ((this instanceof p)) {
      return (p)this;
    }
    throw new IllegalStateException("Not a JSON Primitive: ".concat(String.valueOf(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.k
 * JD-Core Version:    0.7.0.1
 */