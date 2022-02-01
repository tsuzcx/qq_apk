package com.eclipsesource.a;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;

public abstract class h
  implements Serializable
{
  @Deprecated
  public static final h cBJ = a.cBJ;
  @Deprecated
  public static final h cBK = a.cBK;
  @Deprecated
  public static final h cBL = a.cBL;
  
  public String PF()
  {
    throw new UnsupportedOperationException("Not a string: " + toString());
  }
  
  public b Pc()
  {
    throw new UnsupportedOperationException("Not an array: " + toString());
  }
  
  public boolean Pd()
  {
    throw new UnsupportedOperationException("Not a boolean: " + toString());
  }
  
  public int Pe()
  {
    throw new UnsupportedOperationException("Not a number: " + toString());
  }
  
  public long Pf()
  {
    throw new UnsupportedOperationException("Not a number: " + toString());
  }
  
  public double Pg()
  {
    throw new UnsupportedOperationException("Not a number: " + toString());
  }
  
  public e Ph()
  {
    throw new UnsupportedOperationException("Not an object: " + toString());
  }
  
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
  
  public String toString()
  {
    return a(l.cCp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.eclipsesource.a.h
 * JD-Core Version:    0.7.0.1
 */