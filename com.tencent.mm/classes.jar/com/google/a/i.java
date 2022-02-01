package com.google.a;

import com.google.a.b.k;
import com.google.a.d.c;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class i
{
  public String toString()
  {
    try
    {
      Object localObject = new StringWriter();
      c localc = new c((Writer)localObject);
      localc.bLb = true;
      k.a(this, localc);
      localObject = ((StringWriter)localObject).toString();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
  
  public Number yZ()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String za()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean zb()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public final n zd()
  {
    if ((this instanceof n)) {
      return (n)this;
    }
    throw new IllegalStateException("Not a JSON Primitive: ".concat(String.valueOf(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.i
 * JD-Core Version:    0.7.0.1
 */