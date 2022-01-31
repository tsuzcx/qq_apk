package com.tencent.mm.kernel.a.b;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import junit.framework.Assert;

public final class a
{
  private static ThreadLocal<Stack<b>> dMj = new ThreadLocal();
  
  static b Eh()
  {
    return (b)((Stack)dMj.get()).pop();
  }
  
  public static a a(Object paramObject, Class paramClass)
  {
    b localb = (b)((Stack)dMj.get()).peek();
    Assert.assertNotNull(localb);
    if (localb.cJ == null) {
      localb.cJ = new HashMap();
    }
    a locala2 = (a)localb.cJ.get(paramClass);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramObject, paramClass);
      localb.cJ.put(locala1.dMk, locala1);
    }
    return locala1;
  }
  
  static void start()
  {
    b localb = new b();
    Stack localStack2 = (Stack)dMj.get();
    Stack localStack1 = localStack2;
    if (localStack2 == null)
    {
      localStack1 = new Stack();
      dMj.set(localStack1);
    }
    localStack1.push(localb);
  }
  
  public static final class a
  {
    Object dMg;
    Class dMk;
    Set dMl = new HashSet();
    
    a(Object paramObject, Class paramClass)
    {
      this.dMg = paramObject;
      if (paramClass != null) {
        this.dMk = paramClass;
      }
      an(this.dMg);
    }
    
    private void an(Object paramObject)
    {
      Assert.assertNotNull(paramObject);
      Assert.assertNotNull(this.dMk);
      if (!this.dMk.isInstance(paramObject)) {
        throw new IllegalArgumentException("Your depend object " + paramObject + " must implement your type " + this.dMk);
      }
    }
    
    public final a ao(Object paramObject)
    {
      this.dMl.add(paramObject);
      an(paramObject);
      return this;
    }
  }
  
  static final class b
  {
    public HashMap<Class, a.a> cJ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.a
 * JD-Core Version:    0.7.0.1
 */