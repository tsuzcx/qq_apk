package com.google.a;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class ay
{
  static void a(aw paramaw, StringBuilder paramStringBuilder, int paramInt)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = new HashMap();
    Object localObject3 = new TreeSet();
    Object localObject4 = paramaw.getClass().getDeclaredMethods();
    int j = localObject4.length;
    int i = 0;
    Object localObject5;
    while (i < j)
    {
      localObject5 = localObject4[i];
      ((Map)localObject2).put(((Method)localObject5).getName(), localObject5);
      if (((Method)localObject5).getParameterTypes().length == 0)
      {
        ((Map)localObject1).put(((Method)localObject5).getName(), localObject5);
        if (((Method)localObject5).getName().startsWith("get")) {
          ((Set)localObject3).add(((Method)localObject5).getName());
        }
      }
      i += 1;
    }
    localObject3 = ((Set)localObject3).iterator();
    label625:
    label894:
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (String)((Iterator)localObject3).next();
      localObject4 = ((String)localObject5).replaceFirst("get", "");
      Object localObject6;
      if ((((String)localObject4).endsWith("List")) && (!((String)localObject4).endsWith("OrBuilderList")) && (!((String)localObject4).equals("List")))
      {
        localObject6 = ((String)localObject4).substring(0, 1).toLowerCase() + ((String)localObject4).substring(1, ((String)localObject4).length() - 4);
        Method localMethod = (Method)((Map)localObject1).get(localObject5);
        if ((localMethod != null) && (localMethod.getReturnType().equals(List.class)))
        {
          a(paramStringBuilder, paramInt, ck((String)localObject6), ab.a(localMethod, paramaw, new Object[0]));
          continue;
        }
      }
      if ((((String)localObject4).endsWith("Map")) && (!((String)localObject4).equals("Map")))
      {
        localObject6 = ((String)localObject4).substring(0, 1).toLowerCase() + ((String)localObject4).substring(1, ((String)localObject4).length() - 3);
        localObject5 = (Method)((Map)localObject1).get(localObject5);
        if ((localObject5 != null) && (((Method)localObject5).getReturnType().equals(Map.class)) && (!((Method)localObject5).isAnnotationPresent(Deprecated.class)) && (Modifier.isPublic(((Method)localObject5).getModifiers())))
        {
          a(paramStringBuilder, paramInt, ck((String)localObject6), ab.a((Method)localObject5, paramaw, new Object[0]));
          continue;
        }
      }
      if (((Method)((Map)localObject2).get("set".concat(String.valueOf(localObject4))) != null) && ((!((String)localObject4).endsWith("Bytes")) || (!((Map)localObject1).containsKey("get" + ((String)localObject4).substring(0, ((String)localObject4).length() - 5)))))
      {
        localObject5 = ((String)localObject4).substring(0, 1).toLowerCase() + ((String)localObject4).substring(1);
        localObject6 = (Method)((Map)localObject1).get("get".concat(String.valueOf(localObject4)));
        localObject4 = (Method)((Map)localObject1).get("has".concat(String.valueOf(localObject4)));
        if (localObject6 != null)
        {
          localObject6 = ab.a((Method)localObject6, paramaw, new Object[0]);
          boolean bool;
          if (localObject4 == null) {
            if ((localObject6 instanceof Boolean)) {
              if (!((Boolean)localObject6).booleanValue())
              {
                bool = true;
                if (bool) {
                  break label869;
                }
                bool = true;
              }
            }
          }
          for (;;)
          {
            if (!bool) {
              break label894;
            }
            a(paramStringBuilder, paramInt, ck((String)localObject5), localObject6);
            break;
            bool = false;
            break label625;
            if ((localObject6 instanceof Integer))
            {
              if (((Integer)localObject6).intValue() == 0)
              {
                bool = true;
                break label625;
              }
              bool = false;
              break label625;
            }
            if ((localObject6 instanceof Float))
            {
              if (((Float)localObject6).floatValue() == 0.0F)
              {
                bool = true;
                break label625;
              }
              bool = false;
              break label625;
            }
            if ((localObject6 instanceof Double))
            {
              if (((Double)localObject6).doubleValue() == 0.0D)
              {
                bool = true;
                break label625;
              }
              bool = false;
              break label625;
            }
            if ((localObject6 instanceof String))
            {
              bool = localObject6.equals("");
              break label625;
            }
            if ((localObject6 instanceof g))
            {
              bool = localObject6.equals(g.bNg);
              break label625;
            }
            if ((localObject6 instanceof aw))
            {
              if (localObject6 == ((aw)localObject6).AP())
              {
                bool = true;
                break label625;
              }
              bool = false;
              break label625;
            }
            if ((localObject6 instanceof Enum))
            {
              if (((Enum)localObject6).ordinal() == 0)
              {
                bool = true;
                break label625;
              }
              bool = false;
              break label625;
            }
            bool = false;
            break label625;
            bool = false;
            continue;
            bool = ((Boolean)ab.a((Method)localObject4, paramaw, new Object[0])).booleanValue();
          }
        }
      }
    }
    label869:
    if ((paramaw instanceof ab.b))
    {
      localObject1 = ((ab.b)paramaw).bWd.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        a(paramStringBuilder, paramInt, "[" + ((ab.d)((Map.Entry)localObject2).getKey()).number + "]", ((Map.Entry)localObject2).getValue());
      }
    }
    if (((ab)paramaw).bVX != null) {
      ((ab)paramaw).bVX.a(paramStringBuilder, paramInt);
    }
  }
  
  static final void a(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    int k = 0;
    int j = 0;
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        a(paramStringBuilder, paramInt, paramString, paramObject.next());
      }
    }
    if ((paramObject instanceof Map))
    {
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (paramObject.hasNext()) {
        a(paramStringBuilder, paramInt, paramString, (Map.Entry)paramObject.next());
      }
    }
    paramStringBuilder.append('\n');
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append(' ');
      i += 1;
    }
    paramStringBuilder.append(paramString);
    if ((paramObject instanceof String))
    {
      paramStringBuilder.append(": \"").append(by.e(g.bZ((String)paramObject))).append('"');
      return;
    }
    if ((paramObject instanceof g))
    {
      paramStringBuilder.append(": \"").append(by.e((g)paramObject)).append('"');
      return;
    }
    if ((paramObject instanceof ab))
    {
      paramStringBuilder.append(" {");
      a((ab)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      i = j;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      return;
    }
    if ((paramObject instanceof Map.Entry))
    {
      paramStringBuilder.append(" {");
      paramString = (Map.Entry)paramObject;
      a(paramStringBuilder, paramInt + 2, "key", paramString.getKey());
      a(paramStringBuilder, paramInt + 2, "value", paramString.getValue());
      paramStringBuilder.append("\n");
      i = k;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      return;
    }
    paramStringBuilder.append(": ").append(paramObject.toString());
  }
  
  private static final String ck(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (Character.isUpperCase(c)) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append(Character.toLowerCase(c));
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.ay
 * JD-Core Version:    0.7.0.1
 */