package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  private static ClassLoader a = null;
  private static boolean b = true;
  
  public static Object a(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(223830);
    Object localObject1 = new ArrayList();
    int j = paramString.indexOf("<");
    int m = 0;
    int i;
    while (m < j)
    {
      a((ArrayList)localObject1, paramString.substring(m, j));
      int n = j + 1;
      j = paramString.indexOf("<", n);
      int k = paramString.indexOf(",", n);
      i = j;
      if (j == -1) {
        i = k;
      }
      j = i;
      m = n;
      if (k != -1)
      {
        j = i;
        m = n;
        if (k < i)
        {
          j = k;
          m = n;
        }
      }
    }
    a((ArrayList)localObject1, paramString.substring(m, paramString.length()));
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    paramString = null;
    Object localObject2 = null;
    localObject1 = null;
    while (localIterator.hasNext())
    {
      paramString = b((String)localIterator.next(), paramBoolean, paramClassLoader);
      String str;
      if ((paramString instanceof String))
      {
        if ("Array".equals((String)paramString))
        {
          if (localObject1 != null) {
            break label430;
          }
          paramString = Array.newInstance(Byte.class, 0);
        }
        else
        {
          if ("?".equals((String)paramString)) {
            break label430;
          }
          if (localObject1 == null)
          {
            localObject1 = paramString;
            str = paramString;
            paramString = (String)localObject1;
            localObject1 = str;
          }
          else
          {
            localObject2 = paramString;
            str = paramString;
            paramString = (String)localObject2;
            localObject2 = localObject1;
            localObject1 = str;
          }
        }
      }
      else if ((paramString instanceof List))
      {
        if ((localObject1 != null) && ((localObject1 instanceof Byte)))
        {
          paramString = Array.newInstance(Byte.class, 1);
          Array.set(paramString, 0, localObject1);
        }
        else
        {
          if (localObject1 != null) {
            ((List)paramString).add(localObject1);
          }
          localObject1 = null;
        }
      }
      else
      {
        if ((paramString instanceof Map))
        {
          if (localObject1 != null)
          {
            i = 1;
            label343:
            if (localObject2 == null) {
              break label386;
            }
          }
          label386:
          for (j = 1;; j = 0)
          {
            if ((j & i) != 0) {
              ((Map)paramString).put(localObject1, localObject2);
            }
            localObject2 = null;
            localObject1 = null;
            break;
            i = 0;
            break label343;
          }
        }
        if (localObject1 == null)
        {
          localObject1 = paramString;
          str = paramString;
          paramString = (String)localObject1;
          localObject1 = str;
        }
        else
        {
          localObject2 = localObject1;
          localObject1 = paramString;
        }
      }
    }
    label430:
    for (;;)
    {
      break;
      AppMethodBeat.o(223830);
      return paramString;
    }
  }
  
  private static String a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223922);
    if (paramString2.equals("int"))
    {
      paramString1 = paramString2 + " " + paramString1 + "=0 ;\n";
      AppMethodBeat.o(223922);
      return paramString1;
    }
    if (paramString2.equals("boolean"))
    {
      paramString1 = paramString2 + " " + paramString1 + "=false ;\n";
      AppMethodBeat.o(223922);
      return paramString1;
    }
    if (paramString2.equals("byte"))
    {
      paramString1 = paramString2 + " " + paramString1 + " ;\n";
      AppMethodBeat.o(223922);
      return paramString1;
    }
    if (paramString2.equals("double"))
    {
      paramString1 = paramString2 + " " + paramString1 + "=0 ;\n";
      AppMethodBeat.o(223922);
      return paramString1;
    }
    if (paramString2.equals("float"))
    {
      paramString1 = paramString2 + " " + paramString1 + "=0 ;\n";
      AppMethodBeat.o(223922);
      return paramString1;
    }
    if (paramString2.equals("long"))
    {
      paramString1 = paramString2 + " " + paramString1 + "=0 ;\n";
      AppMethodBeat.o(223922);
      return paramString1;
    }
    if (paramString2.equals("short"))
    {
      paramString1 = paramString2 + " " + paramString1 + "=0 ;\n";
      AppMethodBeat.o(223922);
      return paramString1;
    }
    if (paramString2.equals("char"))
    {
      paramString1 = paramString2 + " " + paramString1 + " ;\n";
      AppMethodBeat.o(223922);
      return paramString1;
    }
    paramString1 = paramString2 + " " + paramString1 + " = null ;\n";
    AppMethodBeat.o(223922);
    return paramString1;
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(223788);
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    String str1;
    if (i < paramArrayList.size())
    {
      String str2 = (String)paramArrayList.get(i);
      if ((str2.equals("java.lang.Integer")) || (str2.equals("int"))) {
        str1 = "int32";
      }
      for (;;)
      {
        paramArrayList.set(i, str1);
        i += 1;
        break;
        if ((str2.equals("java.lang.Boolean")) || (str2.equals("boolean")))
        {
          str1 = "bool";
        }
        else if ((str2.equals("java.lang.Byte")) || (str2.equals("byte")))
        {
          str1 = "char";
        }
        else if ((str2.equals("java.lang.Double")) || (str2.equals("double")))
        {
          str1 = "double";
        }
        else if ((str2.equals("java.lang.Float")) || (str2.equals("float")))
        {
          str1 = "float";
        }
        else if ((str2.equals("java.lang.Long")) || (str2.equals("long")))
        {
          str1 = "int64";
        }
        else if ((str2.equals("java.lang.Short")) || (str2.equals("short")))
        {
          str1 = "short";
        }
        else
        {
          if (str2.equals("java.lang.Character"))
          {
            paramArrayList = new IllegalArgumentException("can not support java.lang.Character");
            AppMethodBeat.o(223788);
            throw paramArrayList;
          }
          if (str2.equals("java.lang.String"))
          {
            str1 = "string";
          }
          else if (str2.equals("java.util.List"))
          {
            str1 = "list";
          }
          else
          {
            str1 = str2;
            if (str2.equals("java.util.Map")) {
              str1 = "map";
            }
          }
        }
      }
    }
    Collections.reverse(paramArrayList);
    i = 0;
    if (i < paramArrayList.size())
    {
      str1 = (String)paramArrayList.get(i);
      if (str1.equals("list"))
      {
        paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
        paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
      }
      for (;;)
      {
        i += 1;
        break;
        if (str1.equals("map"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1) + ",");
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
        else if (str1.equals("Array"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
      }
    }
    Collections.reverse(paramArrayList);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next());
    }
    paramArrayList = localStringBuffer.toString();
    AppMethodBeat.o(223788);
    return paramArrayList;
  }
  
  private static ArrayList<String> a(String paramString)
  {
    AppMethodBeat.i(223771);
    ArrayList localArrayList = new ArrayList();
    int j = paramString.indexOf("<");
    int m = 0;
    while (m < j)
    {
      a(localArrayList, paramString.substring(m, j));
      int n = j + 1;
      j = paramString.indexOf("<", n);
      int k = paramString.indexOf(",", n);
      int i = j;
      if (j == -1) {
        i = k;
      }
      j = i;
      m = n;
      if (k != -1)
      {
        j = i;
        m = n;
        if (k < i)
        {
          j = k;
          m = n;
        }
      }
    }
    a(localArrayList, paramString.substring(m, paramString.length()));
    AppMethodBeat.o(223771);
    return localArrayList;
  }
  
  private static void a(ArrayList<String> paramArrayList, String paramString)
  {
    AppMethodBeat.i(223759);
    int i = paramString.length();
    int j;
    do
    {
      j = i;
      if (paramString.charAt(i - 1) != '>') {
        break;
      }
      j = i - 1;
      i = j;
    } while (j != 0);
    String str = paramString.substring(0, j);
    if (str.equals("int32")) {
      paramString = "java.lang.Integer";
    }
    for (;;)
    {
      paramArrayList.add(0, paramString);
      AppMethodBeat.o(223759);
      return;
      if (str.equals("bool"))
      {
        paramString = "java.lang.Boolean";
      }
      else if (str.equals("char"))
      {
        paramString = "java.lang.Byte";
      }
      else if (str.equals("double"))
      {
        paramString = "java.lang.Double";
      }
      else if (str.equals("float"))
      {
        paramString = "java.lang.Float";
      }
      else if (str.equals("int64"))
      {
        paramString = "java.lang.Long";
      }
      else if (str.equals("short"))
      {
        paramString = "java.lang.Short";
      }
      else if (str.equals("string"))
      {
        paramString = "java.lang.String";
      }
      else if (str.equals("list"))
      {
        paramString = "java.util.List";
      }
      else
      {
        paramString = str;
        if (str.equals("map")) {
          paramString = "java.util.Map";
        }
      }
    }
  }
  
  private static void a(boolean paramBoolean, ClassLoader paramClassLoader)
  {
    b = paramBoolean;
    a = paramClassLoader;
  }
  
  private static Object b(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(223856);
    if (paramString.equals("java.lang.Integer"))
    {
      AppMethodBeat.o(223856);
      return Integer.valueOf(0);
    }
    if (paramString.equals("java.lang.Boolean"))
    {
      paramString = Boolean.FALSE;
      AppMethodBeat.o(223856);
      return paramString;
    }
    if (paramString.equals("java.lang.Byte"))
    {
      AppMethodBeat.o(223856);
      return Byte.valueOf((byte)0);
    }
    if (paramString.equals("java.lang.Double"))
    {
      AppMethodBeat.o(223856);
      return Double.valueOf(0.0D);
    }
    if (paramString.equals("java.lang.Float"))
    {
      AppMethodBeat.o(223856);
      return Float.valueOf(0.0F);
    }
    if (paramString.equals("java.lang.Long"))
    {
      AppMethodBeat.o(223856);
      return Long.valueOf(0L);
    }
    if (paramString.equals("java.lang.Short"))
    {
      AppMethodBeat.o(223856);
      return Short.valueOf((short)0);
    }
    if (paramString.equals("java.lang.Character"))
    {
      paramString = new IllegalArgumentException("can not support java.lang.Character");
      AppMethodBeat.o(223856);
      throw paramString;
    }
    if (paramString.equals("java.lang.String"))
    {
      AppMethodBeat.o(223856);
      return "";
    }
    if (paramString.equals("java.util.List"))
    {
      paramString = new ArrayList();
      AppMethodBeat.o(223856);
      return paramString;
    }
    if (paramString.equals("java.util.Map"))
    {
      paramString = new HashMap();
      AppMethodBeat.o(223856);
      return paramString;
    }
    if (paramString.equals("Array"))
    {
      AppMethodBeat.o(223856);
      return "Array";
    }
    if (paramString.equals("?"))
    {
      AppMethodBeat.o(223856);
      return paramString;
    }
    if (paramClassLoader != null) {}
    for (;;)
    {
      try
      {
        paramString = Class.forName(paramString, paramBoolean, paramClassLoader);
        paramString = paramString.getConstructor(new Class[0]).newInstance(new Object[0]);
        AppMethodBeat.o(223856);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = new b(paramString);
        AppMethodBeat.o(223856);
        throw paramString;
      }
      if (a != null) {
        paramString = Class.forName(paramString, b, a);
      } else {
        paramString = Class.forName(paramString);
      }
    }
  }
  
  private static String b(String paramString)
  {
    AppMethodBeat.i(223867);
    if ((paramString.equals("java.lang.Integer")) || (paramString.equals("int")))
    {
      AppMethodBeat.o(223867);
      return "int32";
    }
    if ((paramString.equals("java.lang.Boolean")) || (paramString.equals("boolean")))
    {
      AppMethodBeat.o(223867);
      return "bool";
    }
    if ((paramString.equals("java.lang.Byte")) || (paramString.equals("byte")))
    {
      AppMethodBeat.o(223867);
      return "char";
    }
    if ((paramString.equals("java.lang.Double")) || (paramString.equals("double")))
    {
      AppMethodBeat.o(223867);
      return "double";
    }
    if ((paramString.equals("java.lang.Float")) || (paramString.equals("float")))
    {
      AppMethodBeat.o(223867);
      return "float";
    }
    if ((paramString.equals("java.lang.Long")) || (paramString.equals("long")))
    {
      AppMethodBeat.o(223867);
      return "int64";
    }
    if ((paramString.equals("java.lang.Short")) || (paramString.equals("short")))
    {
      AppMethodBeat.o(223867);
      return "short";
    }
    if (paramString.equals("java.lang.Character"))
    {
      paramString = new IllegalArgumentException("can not support java.lang.Character");
      AppMethodBeat.o(223867);
      throw paramString;
    }
    if (paramString.equals("java.lang.String"))
    {
      AppMethodBeat.o(223867);
      return "string";
    }
    if (paramString.equals("java.util.List"))
    {
      AppMethodBeat.o(223867);
      return "list";
    }
    if (paramString.equals("java.util.Map"))
    {
      AppMethodBeat.o(223867);
      return "map";
    }
    AppMethodBeat.o(223867);
    return paramString;
  }
  
  private static String c(String paramString)
  {
    AppMethodBeat.i(223879);
    if (paramString.equals("int32"))
    {
      AppMethodBeat.o(223879);
      return "java.lang.Integer";
    }
    if (paramString.equals("bool"))
    {
      AppMethodBeat.o(223879);
      return "java.lang.Boolean";
    }
    if (paramString.equals("char"))
    {
      AppMethodBeat.o(223879);
      return "java.lang.Byte";
    }
    if (paramString.equals("double"))
    {
      AppMethodBeat.o(223879);
      return "java.lang.Double";
    }
    if (paramString.equals("float"))
    {
      AppMethodBeat.o(223879);
      return "java.lang.Float";
    }
    if (paramString.equals("int64"))
    {
      AppMethodBeat.o(223879);
      return "java.lang.Long";
    }
    if (paramString.equals("short"))
    {
      AppMethodBeat.o(223879);
      return "java.lang.Short";
    }
    if (paramString.equals("string"))
    {
      AppMethodBeat.o(223879);
      return "java.lang.String";
    }
    if (paramString.equals("list"))
    {
      AppMethodBeat.o(223879);
      return "java.util.List";
    }
    if (paramString.equals("map"))
    {
      AppMethodBeat.o(223879);
      return "java.util.Map";
    }
    AppMethodBeat.o(223879);
    return paramString;
  }
  
  private static boolean d(String paramString)
  {
    AppMethodBeat.i(223894);
    if (paramString.equals("int"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("boolean"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("byte"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("double"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("float"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("long"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("short"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("char"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("Integer"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("Boolean"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("Byte"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("Double"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("Float"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("Long"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("Short"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    if (paramString.equals("Char"))
    {
      AppMethodBeat.o(223894);
      return true;
    }
    AppMethodBeat.o(223894);
    return false;
  }
  
  private static String e(String paramString)
  {
    AppMethodBeat.i(223909);
    String str;
    if (paramString.equals("int")) {
      str = "Integer";
    }
    for (;;)
    {
      AppMethodBeat.o(223909);
      return str;
      if (paramString.equals("boolean"))
      {
        str = "Boolean";
      }
      else if (paramString.equals("byte"))
      {
        str = "Byte";
      }
      else if (paramString.equals("double"))
      {
        str = "Double";
      }
      else if (paramString.equals("float"))
      {
        str = "Float";
      }
      else if (paramString.equals("long"))
      {
        str = "Long";
      }
      else if (paramString.equals("short"))
      {
        str = "Short";
      }
      else
      {
        str = paramString;
        if (paramString.equals("char")) {
          str = "Character";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.a
 * JD-Core Version:    0.7.0.1
 */