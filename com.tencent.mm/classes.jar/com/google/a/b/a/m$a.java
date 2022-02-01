package com.google.a.b.a;

import com.google.a.a.c;
import com.google.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class m$a<T extends Enum<T>>
  extends s<T>
{
  private final Map<String, T> bIw;
  private final Map<T, String> bIx;
  
  public m$a(Class<T> paramClass)
  {
    AppMethodBeat.i(108010);
    this.bIw = new HashMap();
    this.bIx = new HashMap();
    try
    {
      Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
      int k = arrayOfEnum.length;
      int i = 0;
      while (i < k)
      {
        Enum localEnum = arrayOfEnum[i];
        Object localObject1 = localEnum.name();
        Object localObject2 = (c)paramClass.getField((String)localObject1).getAnnotation(c.class);
        if (localObject2 != null)
        {
          String str = ((c)localObject2).value();
          localObject2 = ((c)localObject2).xv();
          int m = localObject2.length;
          int j = 0;
          for (;;)
          {
            localObject1 = str;
            if (j >= m) {
              break;
            }
            localObject1 = localObject2[j];
            this.bIw.put(localObject1, localEnum);
            j += 1;
          }
        }
        this.bIw.put(localObject1, localEnum);
        this.bIx.put(localEnum, localObject1);
        i += 1;
      }
      AppMethodBeat.o(108010);
      return;
    }
    catch (NoSuchFieldException paramClass)
    {
      paramClass = new AssertionError(paramClass);
      AppMethodBeat.o(108010);
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.a.b.a.m.a
 * JD-Core Version:    0.7.0.1
 */