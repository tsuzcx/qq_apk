package com.google.c;

public abstract class f
  extends Exception
{
  protected static final boolean bRC;
  protected static final StackTraceElement[] bRD;
  
  static
  {
    if (System.getProperty("surefire.test.class.path") != null) {}
    for (boolean bool = true;; bool = false)
    {
      bRC = bool;
      bRD = new StackTraceElement[0];
      return;
    }
  }
  
  public final Throwable fillInStackTrace()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.c.f
 * JD-Core Version:    0.7.0.1
 */