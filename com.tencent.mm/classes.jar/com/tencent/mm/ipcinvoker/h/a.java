package com.tencent.mm.ipcinvoker.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;

public final class a
{
  public static boolean e(Class<?> paramClass, Class<? extends Annotation> paramClass1)
  {
    AppMethodBeat.i(235654);
    for (;;)
    {
      if (paramClass == null)
      {
        AppMethodBeat.o(235654);
        return false;
      }
      if (paramClass.isAnnotationPresent(paramClass1))
      {
        AppMethodBeat.o(235654);
        return true;
      }
      Class[] arrayOfClass = paramClass.getInterfaces();
      int j = arrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfClass[i].isAnnotationPresent(paramClass1))
        {
          AppMethodBeat.o(235654);
          return true;
        }
        i += 1;
      }
      if (paramClass.getSuperclass() == null) {
        break;
      }
      paramClass = paramClass.getSuperclass();
    }
    AppMethodBeat.o(235654);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.h.a
 * JD-Core Version:    0.7.0.1
 */