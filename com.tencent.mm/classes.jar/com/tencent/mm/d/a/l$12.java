package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class l$12
  implements Runnable
{
  public l$12(l paraml, Object paramObject, String paramString, Class paramClass) {}
  
  public final void run()
  {
    AppMethodBeat.i(113845);
    l locall = this.cbI;
    Object localObject2 = this.bFJ;
    String str = this.val$name;
    Object localObject4 = this.cbS;
    Object localObject1 = localObject2.getClass();
    Object localObject3 = new ArrayList();
    while (localObject1 != Object.class)
    {
      Iterator localIterator = new ArrayList(Arrays.asList(((Class)localObject1).getDeclaredMethods())).iterator();
      while (localIterator.hasNext())
      {
        Method localMethod = (Method)localIterator.next();
        if ((localObject4 == null) || (localMethod.isAnnotationPresent((Class)localObject4))) {
          ((List)localObject3).add(localMethod);
        }
      }
      localObject1 = ((Class)localObject1).getSuperclass();
    }
    localObject1 = locall.Cu().newV8Object();
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Method)((Iterator)localObject3).next();
      ((V8Object)localObject1).registerJavaMethod(localObject2, ((Method)localObject4).getName(), ((Method)localObject4).getName(), ((Method)localObject4).getParameterTypes());
    }
    locall.Cu().add(str, (V8Value)localObject1);
    ((V8Object)localObject1).release();
    AppMethodBeat.o(113845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.d.a.l.12
 * JD-Core Version:    0.7.0.1
 */