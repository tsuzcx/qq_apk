package com.google.b;

import java.lang.reflect.Method;

final class bm
  implements cq
{
  private static final bv bZI = new bv()
  {
    public final boolean A(Class<?> paramAnonymousClass)
    {
      return false;
    }
    
    public final bu B(Class<?> paramAnonymousClass)
    {
      throw new IllegalStateException("This should never be called.");
    }
  };
  private final bv bZH;
  
  public bm()
  {
    this(new a(new bv[] { ay.HR(), IA() }));
  }
  
  private bm(bv parambv)
  {
    this.bZH = ((bv)be.c(parambv, "messageInfoFactory"));
  }
  
  private static bv IA()
  {
    try
    {
      bv localbv = (bv)Class.forName("com.google.b.j").getDeclaredMethod("Bd", new Class[0]).invoke(null, new Object[0]);
      return localbv;
    }
    catch (Exception localException) {}
    return bZI;
  }
  
  private static boolean a(bu parambu)
  {
    return parambu.IF() == cj.can;
  }
  
  public final <T> cp<T> E(Class<T> paramClass)
  {
    cr.G(paramClass);
    bu localbu = this.bZH.B(paramClass);
    if (localbu.IG())
    {
      if (az.class.isAssignableFrom(paramClass)) {
        return cc.a(cr.IR(), at.HM(), localbu.IH());
      }
      return cc.a(cr.IP(), at.HN(), localbu.IH());
    }
    if (az.class.isAssignableFrom(paramClass))
    {
      if (a(localbu)) {
        return cb.a(localbu, cg.IK(), bl.Iz(), cr.IR(), at.HM(), bs.ID());
      }
      return cb.a(localbu, cg.IK(), bl.Iz(), cr.IR(), null, bs.ID());
    }
    if (a(localbu)) {
      return cb.a(localbu, cg.IJ(), bl.Iy(), cr.IP(), at.HN(), bs.IC());
    }
    return cb.a(localbu, cg.IJ(), bl.Iy(), cr.IQ(), null, bs.IC());
  }
  
  static final class a
    implements bv
  {
    private bv[] bZJ;
    
    a(bv... paramVarArgs)
    {
      this.bZJ = paramVarArgs;
    }
    
    public final boolean A(Class<?> paramClass)
    {
      boolean bool2 = false;
      bv[] arrayOfbv = this.bZJ;
      int j = arrayOfbv.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          if (arrayOfbv[i].A(paramClass)) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    public final bu B(Class<?> paramClass)
    {
      bv[] arrayOfbv = this.bZJ;
      int j = arrayOfbv.length;
      int i = 0;
      while (i < j)
      {
        bv localbv = arrayOfbv[i];
        if (localbv.A(paramClass)) {
          return localbv.B(paramClass);
        }
        i += 1;
      }
      throw new UnsupportedOperationException("No factory is available for message type: " + paramClass.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.bm
 * JD-Core Version:    0.7.0.1
 */