package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import junit.framework.Assert;

public final class a
{
  private static ThreadLocal<Stack<b>> eJK;
  
  static
  {
    AppMethodBeat.i(123305);
    eJK = new ThreadLocal();
    AppMethodBeat.o(123305);
  }
  
  static b Sl()
  {
    AppMethodBeat.i(123304);
    b localb = (b)((Stack)eJK.get()).pop();
    AppMethodBeat.o(123304);
    return localb;
  }
  
  public static a a(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(123302);
    b localb = (b)((Stack)eJK.get()).peek();
    Assert.assertNotNull(localb);
    if (localb.dw == null) {
      localb.dw = new HashMap();
    }
    a locala2 = (a)localb.dw.get(paramClass);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramObject, paramClass);
      localb.dw.put(locala1.eJL, locala1);
    }
    AppMethodBeat.o(123302);
    return locala1;
  }
  
  static void start()
  {
    AppMethodBeat.i(123303);
    b localb = new b();
    Stack localStack2 = (Stack)eJK.get();
    Stack localStack1 = localStack2;
    if (localStack2 == null)
    {
      localStack1 = new Stack();
      eJK.set(localStack1);
    }
    localStack1.push(localb);
    AppMethodBeat.o(123303);
  }
  
  public static final class a
  {
    Object eJH;
    Class eJL;
    Set eJM;
    
    a(Object paramObject, Class paramClass)
    {
      AppMethodBeat.i(123299);
      this.eJM = new HashSet();
      this.eJH = paramObject;
      if (paramClass != null) {
        this.eJL = paramClass;
      }
      ay(this.eJH);
      AppMethodBeat.o(123299);
    }
    
    private void ay(Object paramObject)
    {
      AppMethodBeat.i(123300);
      Assert.assertNotNull(paramObject);
      Assert.assertNotNull(this.eJL);
      if (!this.eJL.isInstance(paramObject))
      {
        paramObject = new IllegalArgumentException("Your depend object " + paramObject + " must implement your type " + this.eJL);
        AppMethodBeat.o(123300);
        throw paramObject;
      }
      AppMethodBeat.o(123300);
    }
    
    public final a az(Object paramObject)
    {
      AppMethodBeat.i(123301);
      this.eJM.add(paramObject);
      ay(paramObject);
      AppMethodBeat.o(123301);
      return this;
    }
  }
  
  static final class b
  {
    public HashMap<Class, a.a> dw = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.a
 * JD-Core Version:    0.7.0.1
 */