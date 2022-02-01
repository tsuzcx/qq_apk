package com.tencent.midas.comm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class APBeanUtil
{
  public static void copyProperties(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(253573);
    try
    {
      copyPropertiesExclude(paramObject1, paramObject2, null, true);
      AppMethodBeat.o(253573);
      return;
    }
    catch (Exception paramObject1)
    {
      AppMethodBeat.o(253573);
    }
  }
  
  public static void copyPropertiesExclude(Object paramObject1, Object paramObject2, String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(253574);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {}
    for (paramArrayOfString = Arrays.asList(paramArrayOfString);; paramArrayOfString = null)
    {
      Method[] arrayOfMethod2;
      if (paramBoolean) {
        arrayOfMethod2 = paramObject1.getClass().getMethods();
      }
      for (Method[] arrayOfMethod1 = paramObject2.getClass().getMethods();; arrayOfMethod1 = paramObject2.getClass().getDeclaredMethods())
      {
        int i = 0;
        while (i < arrayOfMethod2.length)
        {
          Object localObject1 = arrayOfMethod2[i];
          Object localObject2 = ((Method)localObject1).getName();
          if ((((String)localObject2).contains("get")) && ((paramArrayOfString == null) || (!paramArrayOfString.contains(((String)localObject2).substring(3).toLowerCase()))))
          {
            localObject2 = findMethodByName(arrayOfMethod1, "set" + ((String)localObject2).substring(3));
            if (localObject2 != null)
            {
              localObject1 = ((Method)localObject1).invoke(paramObject1, new Object[0]);
              if ((localObject1 != null) && ((!(localObject1 instanceof Collection)) || (((Collection)localObject1).size() > 0))) {
                ((Method)localObject2).invoke(paramObject2, new Object[] { localObject1 });
              }
            }
          }
          i += 1;
        }
        arrayOfMethod2 = paramObject1.getClass().getDeclaredMethods();
      }
      AppMethodBeat.o(253574);
      return;
    }
  }
  
  public static void copyPropertiesInclude(Object paramObject1, Object paramObject2, String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(253575);
    List localList;
    Method[] arrayOfMethod;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      localList = Arrays.asList(paramArrayOfString);
      if (!paramBoolean) {
        break label227;
      }
      arrayOfMethod = paramObject1.getClass().getMethods();
    }
    for (paramArrayOfString = paramObject2.getClass().getMethods();; paramArrayOfString = paramObject2.getClass().getDeclaredMethods())
    {
      int i = 0;
      while (i < arrayOfMethod.length)
      {
        Object localObject1 = arrayOfMethod[i];
        Object localObject2 = ((Method)localObject1).getName();
        if (((String)localObject2).contains("get"))
        {
          String str = ((String)localObject2).substring(3);
          if (localList.contains(str.substring(0, 1).toLowerCase() + str.substring(1)))
          {
            localObject2 = findMethodByName(paramArrayOfString, "set" + ((String)localObject2).substring(3));
            if (localObject2 != null)
            {
              localObject1 = ((Method)localObject1).invoke(paramObject1, new Object[0]);
              if ((localObject1 != null) && ((!(localObject1 instanceof Collection)) || (((Collection)localObject1).size() > 0))) {
                ((Method)localObject2).invoke(paramObject2, new Object[] { localObject1 });
              }
            }
          }
        }
        i += 1;
      }
      AppMethodBeat.o(253575);
      return;
      label227:
      arrayOfMethod = paramObject1.getClass().getDeclaredMethods();
    }
    AppMethodBeat.o(253575);
  }
  
  public static Method findMethodByName(Method[] paramArrayOfMethod, String paramString)
  {
    AppMethodBeat.i(253576);
    int i = 0;
    while (i < paramArrayOfMethod.length)
    {
      if (paramArrayOfMethod[i].getName().equals(paramString))
      {
        paramArrayOfMethod = paramArrayOfMethod[i];
        AppMethodBeat.o(253576);
        return paramArrayOfMethod;
      }
      i += 1;
    }
    AppMethodBeat.o(253576);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.midas.comm.APBeanUtil
 * JD-Core Version:    0.7.0.1
 */