package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import junit.framework.Assert;

public final class a
{
  private static ThreadLocal<Stack<b>> keA;
  
  static
  {
    AppMethodBeat.i(158358);
    keA = new ThreadLocal();
    AppMethodBeat.o(158358);
  }
  
  public static a a(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(158355);
    b localb = (b)((Stack)keA.get()).peek();
    Assert.assertNotNull(localb);
    if (localb.aaP == null) {
      localb.aaP = new HashMap();
    }
    a locala2 = (a)localb.aaP.get(paramClass);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramObject, paramClass);
      localb.aaP.put(locala1.NJ, locala1);
    }
    AppMethodBeat.o(158355);
    return locala1;
  }
  
  static b aIl()
  {
    AppMethodBeat.i(158357);
    b localb = (b)((Stack)keA.get()).pop();
    AppMethodBeat.o(158357);
    return localb;
  }
  
  static void start()
  {
    AppMethodBeat.i(158356);
    b localb = new b();
    Stack localStack2 = (Stack)keA.get();
    Stack localStack1 = localStack2;
    if (localStack2 == null)
    {
      localStack1 = new Stack();
      keA.set(localStack1);
    }
    localStack1.push(localb);
    AppMethodBeat.o(158356);
  }
  
  public static final class a
  {
    Class NJ;
    Set keB;
    Object kew;
    
    a(Object paramObject, Class paramClass)
    {
      AppMethodBeat.i(158352);
      this.keB = new HashSet();
      this.kew = paramObject;
      if (paramClass != null) {
        this.NJ = paramClass;
      }
      bH(this.kew);
      AppMethodBeat.o(158352);
    }
    
    private void bH(Object paramObject)
    {
      AppMethodBeat.i(158353);
      Assert.assertNotNull(paramObject);
      Assert.assertNotNull(this.NJ);
      if (!this.NJ.isInstance(paramObject))
      {
        paramObject = new IllegalArgumentException("Your depend object " + paramObject + " must implement your type " + this.NJ);
        AppMethodBeat.o(158353);
        throw paramObject;
      }
      AppMethodBeat.o(158353);
    }
    
    public final a bI(Object paramObject)
    {
      AppMethodBeat.i(158354);
      this.keB.add(paramObject);
      bH(paramObject);
      AppMethodBeat.o(158354);
      return this;
    }
  }
  
  static final class b
  {
    public HashMap<Class, a.a> aaP = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.a
 * JD-Core Version:    0.7.0.1
 */