package com.google.d;

import java.lang.reflect.Method;

final class bs
  implements dd
{
  private static final cd dTt = new cd()
  {
    public final boolean J(Class<?> paramAnonymousClass)
    {
      return false;
    }
    
    public final cc K(Class<?> paramAnonymousClass)
    {
      throw new IllegalStateException("This should never be called.");
    }
  };
  private final cd dTs;
  
  public bs()
  {
    this(new a(new cd[] { bd.ahV(), aiz() }));
  }
  
  private bs(cd paramcd)
  {
    this.dTs = ((cd)bj.c(paramcd, "messageInfoFactory"));
  }
  
  private static boolean a(cc paramcc)
  {
    return paramcc.aiS() == cu.dUw;
  }
  
  private static cd aiz()
  {
    try
    {
      cd localcd = (cd)Class.forName("com.google.d.m").getDeclaredMethod("aaQ", new Class[0]).invoke(null, new Object[0]);
      return localcd;
    }
    catch (Exception localException) {}
    return dTt;
  }
  
  public final <T> dc<T> N(Class<T> paramClass)
  {
    de.P(paramClass);
    cc localcc = this.dTs.K(paramClass);
    if (localcc.aiT())
    {
      if (be.class.isAssignableFrom(paramClass)) {
        return ck.a(de.ajj(), ax.ahO(), localcc.aiU());
      }
      return ck.a(de.ajh(), ax.ahP(), localcc.aiU());
    }
    if (be.class.isAssignableFrom(paramClass))
    {
      if (a(localcc)) {
        return cj.a(localcc, cp.aiY(), bq.aix(), de.ajj(), ax.ahO(), ca.aiQ());
      }
      return cj.a(localcc, cp.aiY(), bq.aix(), de.ajj(), null, ca.aiQ());
    }
    if (a(localcc)) {
      return cj.a(localcc, cp.aiX(), bq.aiw(), de.ajh(), ax.ahP(), ca.aiP());
    }
    return cj.a(localcc, cp.aiX(), bq.aiw(), de.aji(), null, ca.aiP());
  }
  
  static final class a
    implements cd
  {
    private cd[] dTu;
    
    a(cd... paramVarArgs)
    {
      this.dTu = paramVarArgs;
    }
    
    public final boolean J(Class<?> paramClass)
    {
      boolean bool2 = false;
      cd[] arrayOfcd = this.dTu;
      int j = arrayOfcd.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          if (arrayOfcd[i].J(paramClass)) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    public final cc K(Class<?> paramClass)
    {
      cd[] arrayOfcd = this.dTu;
      int j = arrayOfcd.length;
      int i = 0;
      while (i < j)
      {
        cd localcd = arrayOfcd[i];
        if (localcd.J(paramClass)) {
          return localcd.K(paramClass);
        }
        i += 1;
      }
      throw new UnsupportedOperationException("No factory is available for message type: " + paramClass.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bs
 * JD-Core Version:    0.7.0.1
 */