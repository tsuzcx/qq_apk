package com.google.a;

public final class t
  extends s<l.f>
{
  private static final long bUl = ;
  
  private static <T> long Ge()
  {
    try
    {
      long l = ch.a(ac.d.class.getDeclaredField("bWd"));
      return l;
    }
    catch (Throwable localThrowable)
    {
      throw new IllegalStateException("Unable to lookup extension field offset");
    }
  }
  
  public final x<l.f> an(Object paramObject)
  {
    return (x)ch.k(paramObject, bUl);
  }
  
  final x<l.f> ao(Object paramObject)
  {
    x localx2 = an(paramObject);
    x localx1 = localx2;
    if (localx2.bUC)
    {
      localx1 = localx2.Gk();
      ch.a(paramObject, bUl, localx1);
    }
    return localx1;
  }
  
  final void ap(Object paramObject)
  {
    an(paramObject).yK();
  }
  
  final boolean f(aw paramaw)
  {
    return paramaw instanceof ac.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.t
 * JD-Core Version:    0.7.0.1
 */