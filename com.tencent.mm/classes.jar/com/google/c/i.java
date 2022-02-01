package com.google.c;

import com.google.c.b.k;
import com.google.c.d.c;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class i
{
  public Number YK()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String YL()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean YM()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public final n YO()
  {
    if ((this instanceof n)) {
      return (n)this;
    }
    throw new IllegalStateException("Not a JSON Primitive: ".concat(String.valueOf(this)));
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new StringWriter();
      c localc = new c((Writer)localObject);
      localc.dEJ = true;
      k.a(this, localc);
      localObject = ((StringWriter)localObject).toString();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.i
 * JD-Core Version:    0.7.0.1
 */