package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class b$6
  implements Runnable
{
  public b$6(b paramb, Object paramObject, String paramString, Class paramClass) {}
  
  public final void run()
  {
    b localb = this.bzd;
    Object localObject2 = this.bjR;
    String str = this.bjS;
    Object localObject4 = this.bzh;
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
    localObject1 = localb.byX.newV8Object();
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Method)((Iterator)localObject3).next();
      ((V8Object)localObject1).registerJavaMethod(localObject2, ((Method)localObject4).getName(), ((Method)localObject4).getName(), ((Method)localObject4).getParameterTypes());
    }
    localb.byX.add(str, (V8Value)localObject1);
    ((V8Object)localObject1).release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.a.b.6
 * JD-Core Version:    0.7.0.1
 */