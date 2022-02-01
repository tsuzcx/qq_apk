package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Stack;
import junit.framework.Assert;

public final class a
{
  private static ThreadLocal<Stack<b>> mEJ;
  
  static
  {
    AppMethodBeat.i(158358);
    mEJ = new ThreadLocal();
    AppMethodBeat.o(158358);
  }
  
  public static a.a a(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(158355);
    b localb = (b)((Stack)mEJ.get()).peek();
    Assert.assertNotNull(localb);
    if (localb.bIx == null) {
      localb.bIx = new HashMap();
    }
    a.a locala2 = (a.a)localb.bIx.get(paramClass);
    a.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a.a(paramObject, paramClass);
      localb.bIx.put(locala1.btN, locala1);
    }
    AppMethodBeat.o(158355);
    return locala1;
  }
  
  static b bbg()
  {
    AppMethodBeat.i(158357);
    b localb = (b)((Stack)mEJ.get()).pop();
    AppMethodBeat.o(158357);
    return localb;
  }
  
  static void start()
  {
    AppMethodBeat.i(158356);
    b localb = new b();
    Stack localStack2 = (Stack)mEJ.get();
    Stack localStack1 = localStack2;
    if (localStack2 == null)
    {
      localStack1 = new Stack();
      mEJ.set(localStack1);
    }
    localStack1.push(localb);
    AppMethodBeat.o(158356);
  }
  
  static final class b
  {
    public HashMap<Class, a.a> bIx = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.a
 * JD-Core Version:    0.7.0.1
 */