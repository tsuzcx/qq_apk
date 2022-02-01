package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import junit.framework.Assert;

public final class a
{
  private static ThreadLocal<Stack<b>> gjz;
  
  static
  {
    AppMethodBeat.i(158358);
    gjz = new ThreadLocal();
    AppMethodBeat.o(158358);
  }
  
  public static a a(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(158355);
    b localb = (b)((Stack)gjz.get()).peek();
    Assert.assertNotNull(localb);
    if (localb.dz == null) {
      localb.dz = new HashMap();
    }
    a locala2 = (a)localb.dz.get(paramClass);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramObject, paramClass);
      localb.dz.put(locala1.gjA, locala1);
    }
    AppMethodBeat.o(158355);
    return locala1;
  }
  
  static b ahs()
  {
    AppMethodBeat.i(158357);
    b localb = (b)((Stack)gjz.get()).pop();
    AppMethodBeat.o(158357);
    return localb;
  }
  
  static void start()
  {
    AppMethodBeat.i(158356);
    b localb = new b();
    Stack localStack2 = (Stack)gjz.get();
    Stack localStack1 = localStack2;
    if (localStack2 == null)
    {
      localStack1 = new Stack();
      gjz.set(localStack1);
    }
    localStack1.push(localb);
    AppMethodBeat.o(158356);
  }
  
  public static final class a
  {
    Class gjA;
    Set gjB;
    Object gjw;
    
    a(Object paramObject, Class paramClass)
    {
      AppMethodBeat.i(158352);
      this.gjB = new HashSet();
      this.gjw = paramObject;
      if (paramClass != null) {
        this.gjA = paramClass;
      }
      bx(this.gjw);
      AppMethodBeat.o(158352);
    }
    
    private void bx(Object paramObject)
    {
      AppMethodBeat.i(158353);
      Assert.assertNotNull(paramObject);
      Assert.assertNotNull(this.gjA);
      if (!this.gjA.isInstance(paramObject))
      {
        paramObject = new IllegalArgumentException("Your depend object " + paramObject + " must implement your type " + this.gjA);
        AppMethodBeat.o(158353);
        throw paramObject;
      }
      AppMethodBeat.o(158353);
    }
    
    public final a by(Object paramObject)
    {
      AppMethodBeat.i(158354);
      this.gjB.add(paramObject);
      bx(paramObject);
      AppMethodBeat.o(158354);
      return this;
    }
  }
  
  static final class b
  {
    public HashMap<Class, a.a> dz = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.a
 * JD-Core Version:    0.7.0.1
 */