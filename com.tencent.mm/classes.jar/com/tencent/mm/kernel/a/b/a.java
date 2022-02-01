package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import junit.framework.Assert;

public final class a
{
  private static ThreadLocal<Stack<b>> hsE;
  
  static
  {
    AppMethodBeat.i(158358);
    hsE = new ThreadLocal();
    AppMethodBeat.o(158358);
  }
  
  public static a a(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(158355);
    b localb = (b)((Stack)hsE.get()).peek();
    Assert.assertNotNull(localb);
    if (localb.mMap == null) {
      localb.mMap = new HashMap();
    }
    a locala2 = (a)localb.mMap.get(paramClass);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramObject, paramClass);
      localb.mMap.put(locala1.hsF, locala1);
    }
    AppMethodBeat.o(158355);
    return locala1;
  }
  
  static b aAI()
  {
    AppMethodBeat.i(158357);
    b localb = (b)((Stack)hsE.get()).pop();
    AppMethodBeat.o(158357);
    return localb;
  }
  
  static void start()
  {
    AppMethodBeat.i(158356);
    b localb = new b();
    Stack localStack2 = (Stack)hsE.get();
    Stack localStack1 = localStack2;
    if (localStack2 == null)
    {
      localStack1 = new Stack();
      hsE.set(localStack1);
    }
    localStack1.push(localb);
    AppMethodBeat.o(158356);
  }
  
  public static final class a
  {
    Object hsB;
    Class hsF;
    Set hsG;
    
    a(Object paramObject, Class paramClass)
    {
      AppMethodBeat.i(158352);
      this.hsG = new HashSet();
      this.hsB = paramObject;
      if (paramClass != null) {
        this.hsF = paramClass;
      }
      bH(this.hsB);
      AppMethodBeat.o(158352);
    }
    
    private void bH(Object paramObject)
    {
      AppMethodBeat.i(158353);
      Assert.assertNotNull(paramObject);
      Assert.assertNotNull(this.hsF);
      if (!this.hsF.isInstance(paramObject))
      {
        paramObject = new IllegalArgumentException("Your depend object " + paramObject + " must implement your type " + this.hsF);
        AppMethodBeat.o(158353);
        throw paramObject;
      }
      AppMethodBeat.o(158353);
    }
    
    public final a bI(Object paramObject)
    {
      AppMethodBeat.i(158354);
      this.hsG.add(paramObject);
      bH(paramObject);
      AppMethodBeat.o(158354);
      return this;
    }
  }
  
  static final class b
  {
    public HashMap<Class, a.a> mMap = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.a
 * JD-Core Version:    0.7.0.1
 */