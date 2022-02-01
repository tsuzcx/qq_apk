package com.eclipsesource.a;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;

public abstract class h
  implements Serializable
{
  @Deprecated
  public static final h aZC = a.aZC;
  @Deprecated
  public static final h aZD = a.aZD;
  @Deprecated
  public static final h aZE = a.aZE;
  
  public final String a(l paraml)
  {
    StringWriter localStringWriter = new StringWriter();
    if (paraml == null) {
      try
      {
        throw new NullPointerException("config is null");
      }
      catch (IOException paraml)
      {
        throw new RuntimeException(paraml);
      }
    }
    m localm = new m(localStringWriter);
    a(paraml.a(localm));
    localm.flush();
    return localStringWriter.toString();
  }
  
  abstract void a(i parami);
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public boolean isArray()
  {
    return false;
  }
  
  public boolean isBoolean()
  {
    return false;
  }
  
  public boolean isNumber()
  {
    return false;
  }
  
  public boolean isObject()
  {
    return false;
  }
  
  public boolean isString()
  {
    return false;
  }
  
  public String sG()
  {
    throw new UnsupportedOperationException("Not a string: " + toString());
  }
  
  public b sd()
  {
    throw new UnsupportedOperationException("Not an array: " + toString());
  }
  
  public boolean se()
  {
    throw new UnsupportedOperationException("Not a boolean: " + toString());
  }
  
  public int sf()
  {
    throw new UnsupportedOperationException("Not a number: " + toString());
  }
  
  public long sg()
  {
    throw new UnsupportedOperationException("Not a number: " + toString());
  }
  
  public double sh()
  {
    throw new UnsupportedOperationException("Not a number: " + toString());
  }
  
  public e si()
  {
    throw new UnsupportedOperationException("Not an object: " + toString());
  }
  
  public String toString()
  {
    return a(l.baj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.a.h
 * JD-Core Version:    0.7.0.1
 */