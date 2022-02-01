package com.google.a;

import java.lang.reflect.Method;

final class am
  implements bs
{
  private static final av bXR = new av()
  {
    public final boolean C(Class<?> paramAnonymousClass)
    {
      return false;
    }
    
    public final au D(Class<?> paramAnonymousClass)
    {
      throw new IllegalStateException("This should never be called.");
    }
  };
  private final av bXQ;
  
  public am()
  {
    this(new a(new av[] { aa.Gl(), GU() }));
  }
  
  private am(av paramav)
  {
    this.bXQ = ((av)ae.checkNotNull(paramav, "messageInfoFactory"));
  }
  
  private static av GU()
  {
    try
    {
      av localav = (av)Class.forName("com.google.a.j").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return localav;
    }
    catch (Exception localException) {}
    return bXR;
  }
  
  private static boolean a(au paramau)
  {
    return paramau.He() == bl.bYJ;
  }
  
  public final <T> br<T> G(Class<T> paramClass)
  {
    bt.I(paramClass);
    au localau = this.bXQ.D(paramClass);
    if (localau.Hf())
    {
      if (ab.class.isAssignableFrom(paramClass)) {
        return bc.a(bt.Hr(), v.Gg(), localau.Hg());
      }
      return bc.a(bt.Hp(), v.Gh(), localau.Hg());
    }
    if (ab.class.isAssignableFrom(paramClass))
    {
      if (a(localau)) {
        return bb.a(localau, bh.Hj(), al.GT(), bt.Hr(), v.Gg(), as.Hc());
      }
      return bb.a(localau, bh.Hj(), al.GT(), bt.Hr(), null, as.Hc());
    }
    if (a(localau)) {
      return bb.a(localau, bh.Hi(), al.GS(), bt.Hp(), v.Gh(), as.Hb());
    }
    return bb.a(localau, bh.Hi(), al.GS(), bt.Hq(), null, as.Hb());
  }
  
  static final class a
    implements av
  {
    private av[] bXS;
    
    a(av... paramVarArgs)
    {
      this.bXS = paramVarArgs;
    }
    
    public final boolean C(Class<?> paramClass)
    {
      boolean bool2 = false;
      av[] arrayOfav = this.bXS;
      int j = arrayOfav.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          if (arrayOfav[i].C(paramClass)) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    public final au D(Class<?> paramClass)
    {
      av[] arrayOfav = this.bXS;
      int j = arrayOfav.length;
      int i = 0;
      while (i < j)
      {
        av localav = arrayOfav[i];
        if (localav.C(paramClass)) {
          return localav.D(paramClass);
        }
        i += 1;
      }
      throw new UnsupportedOperationException("No factory is available for message type: " + paramClass.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.am
 * JD-Core Version:    0.7.0.1
 */